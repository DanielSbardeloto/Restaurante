/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uricer.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Mesa {
    
    boolean ocupada;
    List<Item> itens = new ArrayList();
    private BigDecimal valorTotal;
    int numero;

    public boolean isOcupada() {
        return ocupada;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public void ocupar(){
        ocupada = true;
    }
    
    public void desocupar(){
        ocupada = false;
    }
    
    public void totalizar(){
        valorTotal = new BigDecimal("0.0");
        
        for(Item item:itens){
            item.totalizar();
            valorTotal = valorTotal.add(item.getValorTotal());
        }    
    }
    
    public void adicionaItem(Produto produto,  BigDecimal quantidade, BigDecimal valorUnitario){
           Item novoItem = new Item();
           novoItem.setProduto(produto);
           novoItem.setQuantidade(quantidade);
           novoItem.setValorUnitario(valorUnitario);
           itens.add(novoItem);
    }
}
