package br.com.talles.ecommercebooks.controll.command;

import br.com.talles.ecommercebooks.controll.Result;
import br.com.talles.ecommercebooks.domain.Entity;

public class ListCmd extends AbstractCommand{

    @Override
    public Result execute(Entity entity, String operation) {
        return facade.list(entity, operation);
    }
    
}
