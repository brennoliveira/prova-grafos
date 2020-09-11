/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prova;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class segunda {
    
    static private String diretorio = "C:\\Users\\brenn\\OneDrive\\Área de Trabalho\\k\\TRABALHOS\\3 periodo\\analise algoritimo\\2 unid\\prova\\file2.txt";
    
    public static void main (String[] args)throws FileNotFoundException{ 
        int nVertices = NumVertices();
        
        List<Integer>[] grafo = new ArrayList[nVertices];
        carregarGrafo(grafo);
        print(grafo);
        int arestas = numArestas(grafo);
        if (arestas == 0){
            System.out.println("Este grafo é nulo");
            
        } else {
            System.out.println("grafo não nulo");
        }
        
    }
 
        
    static int NumVertices() throws FileNotFoundException{
        int count = 0;
        Scanner in = new Scanner(new FileReader(diretorio));
        while (in.hasNext()){
            count++;
            in.nextLine();
        }
        return count;
        }
    
    static void print(List[] grafo){
        for (int i = 0; i < grafo.length; i++){
            System.out.print(grafo[i].get(0)+": ");
            for (int j = 1; j< grafo[i].size(); j++){
                System.out.print(grafo[i].get(j)+" ");
               
            }
            System.out.print("(vertices adjacentes: ");
            System.out.print(grafo[i].size()-1+")");
            System.out.println("");
        } 
        
    }
    
    static void carregarGrafo(List[] grafo) throws FileNotFoundException{
        int count2 = 0;
        Scanner in = new Scanner(new FileReader(diretorio));
        ligarGrafo(grafo);
        
        while (in.hasNext()){
            String line = in.nextLine();
            String[] vertices = line.split("\t");
            
            for (String vertice: vertices ){
                grafo[count2].add(Integer.parseInt(vertice));
            }
            count2++;
        }
        
    }
    
    static void ligarGrafo(List[] grafo){
        for (int i = 0; i < grafo.length; i++){
            grafo[i] = new ArrayList<Integer>();
        }
    }
    
    static int numArestas(List[] grafo){
        int nArestas = 0;
        for (int i = 0; i< grafo.length; i++){
            for (int j = 1; j< grafo[i].size(); j++){
                nArestas++;
            }
        }
        return nArestas;
    }
}