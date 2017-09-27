package br.com.talles.ecommercebooks.controll.command;

import br.com.talles.ecommercebooks.controll.Result;
import br.com.talles.ecommercebooks.domain.Entity;

public class DisableCmd extends AbstractCommand {

	@Override
	public Result execute(Entity entity) {
		return facade.disable(entity);
	}
	
}
