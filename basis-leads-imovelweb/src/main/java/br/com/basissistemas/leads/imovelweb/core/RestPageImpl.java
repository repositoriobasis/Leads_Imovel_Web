package br.com.basissistemas.leads.imovelweb.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class RestPageImpl<T> implements Page<T> {

	private PageImpl<T> pageDelegate = new PageImpl<>(new ArrayList<>(0));

    public List<T> getContent() {
        return pageDelegate.getContent();
    }

    public int getNumber() {
        return pageDelegate.getNumber();
    }

    public int getNumberOfElements() {
        return pageDelegate.getNumberOfElements();
    }

    public int getSize() {
        return pageDelegate.getSize();
    }

    public Sort getSort() {
        return pageDelegate.getSort();
    }

    public long getTotalElements() {
        return pageDelegate.getTotalElements();
    }

    public int getTotalPages() {
        return pageDelegate.getTotalPages();
    }

    public boolean hasContent() {
        return pageDelegate.hasContent();
    }

    public boolean hasNext() {
        return pageDelegate.hasNext();
    }

    public boolean hasPrevious() {
        return pageDelegate.hasPrevious();
    }

    public boolean isFirst() {
        return pageDelegate.isFirst();
    }

    public boolean isLast() {
        return pageDelegate.isLast();
    }

    public Iterator<T> iterator() {
        return pageDelegate.iterator();
    }

    public Pageable nextPageable() {
        return pageDelegate.nextPageable();
    }

    public Pageable previousPageable() {
        return pageDelegate.previousPageable();
    }

    public void setContent(List<T> content) {
//    	PageRequest pageRequest;
//    	pageRequest = PageRequest.of(1, 1, Sort.unsorted());
        pageDelegate = new PageImpl<>(content);
    }

    public void setTotalElements(int totalElements) {
    	if (totalElements > 0 ) {
    		PageRequest pageRequest;
    		if (getSort() != null) {
				pageRequest = PageRequest.of(getNumber(), getSize(), getSort());
			}
			else {
				pageRequest = PageRequest.of(getNumber(), getSize());
			}
    		pageDelegate = new PageImpl<>(getContent(), pageRequest, totalElements);
    	} else {
    		pageDelegate = new PageImpl<>(getContent());
    	}
    }

    public String toString() {
        return pageDelegate.toString();
    }

	@Override
	public <U> Page<U> map(Function<? super T, ? extends U> converter) {
		return pageDelegate.map(converter);
	}
	
}
