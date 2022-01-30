package com.singraul.mockito.junit.business;

import java.util.List;

import com.singraul.mockito.junit.business.exception.DifferentCurrenciesException;
import com.singraul.mockito.junit.model.AmountImpl;
import com.singraul.mockito.junit.model.Product;

public interface ClientBO {

	AmountImpl getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}