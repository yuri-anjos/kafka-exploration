package com.yuri.paymentservice.model;

import java.io.Serial;
import java.io.Serializable;

public class Payment implements Serializable {

	@Serial
	private static final long serialVersionUID = -4656577276738563438L;

	private Long id;
	private Long userId;
	private Long productId;
	private String cardNumber;

	public Payment() {
		// no nothing
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getProductId() {
		return productId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", userId=" + userId +
				", productId=" + productId +
				", cardNumber='" + cardNumber + '\'' +
				'}';
	}
}
