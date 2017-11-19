package br.com.talles.ecommercebooks.controll.command;

import br.com.talles.ecommercebooks.controll.Transaction;
import br.com.talles.ecommercebooks.controll.Result;
import br.com.talles.ecommercebooks.domain.Entity;

public class UpdateCmd extends AbstractCommand{

    @Override
    public Result execute(Entity entity, Transaction transaction) {
        return facade.update(entity, transaction);
    }
    
}
