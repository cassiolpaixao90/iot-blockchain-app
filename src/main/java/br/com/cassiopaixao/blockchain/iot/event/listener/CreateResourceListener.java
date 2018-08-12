package br.com.cassiopaixao.blockchain.iot.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cassiopaixao.blockchain.iot.event.CreateResourceEvent;

@Component
public class CreateResourceListener implements ApplicationListener<CreateResourceEvent> {

	@Override
	public void onApplicationEvent(CreateResourceEvent createResourceEvent) {
		HttpServletResponse httpServletResponse = createResourceEvent.getResponse();
		Long code = createResourceEvent.getCode();

		addHeaderLocation(httpServletResponse, code);
	}

	public void addHeaderLocation(HttpServletResponse response, Long code) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}").buildAndExpand(code).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
