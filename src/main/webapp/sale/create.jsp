<%@ page import="br.com.talles.ecommercebooks.domain.Entity" %>
<%@ page import="br.com.talles.ecommercebooks.domain.customer.Address" %>
<%@ page import="br.com.talles.ecommercebooks.controll.Result" %>
<%@ page import="br.com.talles.ecommercebooks.domain.sale.Sale" %>
<%@ page import="java.util.Date" %>
<%@ page import="br.com.talles.ecommercebooks.domain.sale.PromotionalCoupon" %>
<%@ page import="br.com.talles.ecommercebooks.domain.customer.CreditCard" %>
<%@ page import="br.com.talles.ecommercebooks.domain.customer.Customer" %>
<%@ page import="br.com.talles.ecommercebooks.domain.sale.SaleItem" %>
<%@ page import="br.com.talles.ecommercebooks.domain.sale.Status" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.talles.ecommercebooks.domain.customer.DeliveryAddress" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Result result = new Result();
        result = (Result) request.getAttribute("result");

        Sale sale = new Sale("", new Date(), 0.0, 0, new Status(), new Date(), new PromotionalCoupon(),
                new DeliveryAddress(), new Address(), new CreditCard(), new Customer(), new ArrayList<SaleItem>());

        if (result != null) {
            if (result.getKeys().contains(Sale.class.getSimpleName())) {
                sale = (Sale) result.getEntities(Sale.class.getSimpleName()).get(0);
            }

            if (result.hasMsg()) {
                String[] msgs = result.getMsg().split("\n");
                out.print("<p>");
                for(String msg : msgs)
                    out.print("<i class='fa fa-times' aria-hidden='true' style='color: #FF0000;'></i> " + msg + "<br/>");
                out.print("</p>");
            }
        }
    %>
    <div id="app">
        <h1 id="create-sale">Finalizar Compras!</h1>

        <form action="<% out.print("save"); %>" method="POST" >
            <fieldset>

                <div>
                    <label for="idDeliveryAddress">Endereço de Entrega*: </label>
                    <select name="idDeliveryAddress" id="idDeliveryAddress">
                        <%
                            for(Entity entity : result.getEntities(DeliveryAddress.class.getSimpleName())){
                                DeliveryAddress deliveryAddress = (DeliveryAddress) entity;
                                out.print("<option value='" + deliveryAddress.getId() + "'>" + deliveryAddress.getAlias() + "</option>");
                            }
                        %>
                    </select>
                </div>

                <div>
                    <label for="idCreditCard">Cartão de Crédito*: </label>
                    <select name="idCreditCard" id="idCreditCard">
                        <%
                            for(Entity entity : result.getEntities(CreditCard.class.getSimpleName())){
                                CreditCard creditCard = (CreditCard) entity;
                                out.print("<option value='" + creditCard.getId() + "'>" + creditCard.getNumber() + "</option>");
                            }
                        %>
                    </select>
                </div>
            </fieldset>

            <input type="hidden" name="operation" id="operation-sale" value="SAVE" />
            <button type="submit">Concluir</button>
        </form>
    </div>
</body>
</html>
