package br.com.basissistemas.leads.imovelweb.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.basissistemas.leads.imovelweb.api.dto.Imobiliaria;
import br.com.basissistemas.leads.imovelweb.api.dto.Mensagem;
import br.com.basissistemas.leads.imovelweb.core.RestPageImpl;
import br.com.basissistemas.leads.imovelweb.domain.model.Lead;
import br.com.basissistemas.leads.imovelweb.domain.model.LeadPortal;
import br.com.basissistemas.leads.imovelweb.domain.service.ImobiliariaService;
import br.com.basissistemas.leads.imovelweb.domain.service.LeadPortalService;
import br.com.basissistemas.leads.imovelweb.domain.service.LeadService;
import br.com.basissistemas.leads.imovelweb.domain.service.MensagemService;

@Service
public class TaskMensagem implements Tasklet {
	
	@Autowired
	ImobiliariaService imobiliariaService;
	
	@Autowired
	MensagemService mensagemService;
	
	@Autowired
	LeadPortalService leadPortalService;
	
	@Autowired
	LeadService leadService;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		RestPageImpl<Imobiliaria> pageImobiliaria = imobiliariaService.listar();
		
		for (Imobiliaria i : pageImobiliaria) {
			
			RestPageImpl<Mensagem> pageMensagens = mensagemService.listarMensagensImobiliaria(i.getCodigoInmobiliaria());
			
			LeadPortal leadPortal = leadPortalService.buscar(i.getCodigoInmobiliaria());

			if (leadPortal.getBancoNome() == null) {
				continue;
			}
			
			for (Mensagem leadImovelweb : pageMensagens) {
				
				Lead lead = Lead.builder()
						.idBancoDeDados(leadPortal.getIdBancoDeDados())
						.imovelContato(leadImovelweb.getCodigoAviso())
						.nomeContato(leadImovelweb.getNombre())
						.emailContato(leadImovelweb.getEmail())
						.telefoneContato(leadImovelweb.getTelefono())
						.mensagemContato(leadImovelweb.getTextoMensaje())
						.idLeadPortal(String.valueOf(leadImovelweb.getIdAvisoNavplat()))
						.dataLeadPortal(leadImovelweb.getFecha().toLocalDateTime())
						.identificador("Imovelweb")
						.build();
				leadService.salvar(leadPortal.getBancoNome(), lead);
			}
			
		}
		return RepeatStatus.FINISHED;
	}
	
}
