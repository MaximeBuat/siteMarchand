/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.stock;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maxim
 */
public class ModeleStock extends AbstractTableModel {
    
    private String[] colonnes = {"Genre","Vetement","Taille","Couleur","Prix","Quantité"};
    private Vector<String[]> rows;
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return colonnes[column];
    }
    
    public void loadDatas(ArrayList<stock> lesStocks)
    {
        rows = new Vector<>();
        for(stock sto : lesStocks)
        {
            rows.add(new String[]{sto.getGenre(),sto.getTypVet(),sto.getTaille(),sto.getCouleur(),String.valueOf(sto.getPrix()),String.valueOf(sto.getQuantite())});
        }
        fireTableChanged(null);
    }
}
