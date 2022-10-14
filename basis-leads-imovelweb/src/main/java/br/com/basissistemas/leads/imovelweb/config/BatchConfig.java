package br.com.basissistemas.leads.imovelweb.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.basissistemas.leads.imovelweb.tasks.TaskMensagem;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private StepBuilderFactory steps;
	
	@Autowired
	private JobBuilderFactory jobs;
	
	@Autowired
	TaskMensagem taskMensagem;
	
	@Bean
	public Step stepMensagem(){
		return steps.get("stepMensagem")
				.tasklet(taskMensagem)
				.build();
	}
	
	@Bean
	public Job mensagemJob(){
		return jobs.get("mensagemJob")
				.incrementer(new RunIdIncrementer())
				.start(stepMensagem())
				.build();
	}

}
