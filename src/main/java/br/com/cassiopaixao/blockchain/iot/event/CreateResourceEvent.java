package br.com.cassiopaixao.blockchain.iot.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class CreateResourceEvent extends ApplicationEvent {

	/**
	 * @author CassioPaixao
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private Long code;

	public CreateResourceEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.code = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
