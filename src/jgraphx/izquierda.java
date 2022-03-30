/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jgraphx;

/**
 *
 * @author  godoy
 */
public class izquierda {
     public Nodo raiz2;
    int max(int a, int b)
    {
    return (a>b)?a:b;
    }
    int altura(Nodo r){
    if(r!=null) return r.altura;
   
    return 0;
        
    }
    int balance(Nodo r){
    if(r==null)
        return 0;
    return altura(r.der)-altura(r.izq);
       
    }
    public Nodo insert(Nodo r, int x){
        if(r==null){
        return new Nodo(x);
        }
        else 
            if(r.valor>x){    //11>5
            r.izq=insert(r.izq,x);
            }
        else
            {
          r.der=  insert(r.der,x);
            }
        // r.altura=max(altura(r.der),altura(r.izq))+1;
        r.altura=max(altura(r.izq),altura(r.der))+1; //verificar
        
        r.balance=balance(r);
       //izquierda
     
       if(r.balance<-1&& x>r.izq.valor)
            System.out.println("debalanceado 1");
        if(r.balance>1 && x>r.der.valor)
        { 
            System.out.println("debalanceado 2");
         r=balanceado2(r);
        }
       
      if(r.balance>1 && x<r.der.valor)
        {System.out.println("debalanceado 3");
        balancear3(r);
        }
        if(r.balance<-1 && x<r.izq.valor)
        {System.out.println("debalanceado 4");
        r=balancear4(r);
        }
       
        
    return r;
    }
    
    public Nodo balanceado2(Nodo n){
          Nodo n1=n;//   11  
          Nodo n2=n.der;//  15  
          Nodo n3=n.der.der;//  20  
      
          n2.izq=n1;
          n=n2;
          n2.izq.der=null;
          n2.izq.altura=1; n2.izq.balance=0;
         
          
          n2.der=n3;
          n2.der.izq=null;
          n2.der.altura=1; n2.der.balance=0;
   

      
        n2.altura=max(altura(n2.izq),altura(n2.der))+1;
        
        n2.balance=balance(n2);
      return n2; 
      
    }
   public Nodo balancear4(Nodo n){
        System.out.println("n:"+n.valor);//11
          System.out.println("n2:"+n.izq.valor);//5
          if(n.izq.izq!=null)
          {System.out.println("3 en fila a la izquierda n3:"+n.izq.izq.valor);//2
         
          Nodo n1=n;//11
         
          Nodo n2=n.izq;//5  
          Nodo n3= n.izq.izq; //este no lo vamos a usar 2   
          n2.der=n1;
          n=n2;
          n2.der.izq=null;
          n2.der.altura=1; 
          n2.der.balance=0;
          
          
          n2.izq=n3;
          n2.izq.altura=1; 
          n2.izq.balance=0; 
   
   
        n2.altura=max(altura(n2.izq),altura(n2.der))+1;
        
        n2.balance=balance(n2);
          
        return n2;
    }
          else
          {    
            
        System.out.println("3 cruzados n3:"+n.der.der.valor);
          
          Nodo n1=n;//   11
          Nodo n2=n.der;//  15
          Nodo n3=n.der.der;//  20  
         
          n2.izq=n1;
         // n=n2;
          n2.der=n3;
          
          }
          return n; 
       
   }
public void balancear3(Nodo n3){
          System.out.println("n:"+n3.valor);
          System.out.println("n2:"+n3.izq.valor);
          System.out.println("n3:"+n3.izq.izq.valor);
    }
}
   


