package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitDao fruitDao;
    
    public ReturnOperationHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer quantity = (transaction.getQuantity() == null) ? 0 : transaction.getQuantity();
        Integer currentQuantity = fruitDao.getQuantity(transaction.getName());
        Integer newQuantity = ((currentQuantity == null) ? 0 : currentQuantity) 
                + quantity;
        fruitDao.replaceValue(transaction.getName(), newQuantity);
    }
}
