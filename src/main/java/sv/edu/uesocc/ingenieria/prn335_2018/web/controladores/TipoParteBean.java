/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso.TipoParteFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso.TipoParteFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoParte;

/**
 *
 * @author Stany
 */
@ManagedBean
@RequestScoped
public class TipoParteBean implements Serializable{

//Inicializa las varibales y estados de la parte BEAN
    @EJB
    private TipoParteFacadeLocal tipoParteFacadelocal;//instancia una variable de la clase
    private TipoParte tp;//declara una variable 
    private List<TipoParte> listatipo;//declara la lista de tipo
    private TipoParteFacade tipoFacade;//delcara instancia  del facade
    
//     public TipoParteBean() {
//    }
    
    //Es el primer metodo que construye e inicia el ciclo del BEAN
    @PostConstruct//anotacion que construye  :v 
    public void inciar(){
    tp= new TipoParte();//declara la varibale de tipo parte
    tp.setIdTipoParte(null);//declara nulos los parametros id
    tp.setNombre("");//declara vacio los parametros de nombre
    tp.setActivo(false);//declara falso el boolean
    tp.setObservaciones("");//declara vacio el campo
    listatipo=tipoParteFacadelocal.findAll();//instancia el metodo creado en las otras clases
    }
    
   
//LOS GETTERS AND SETTERS
    public TipoParteFacadeLocal getTipoParteFacade() {
        return tipoParteFacadelocal;
    }

    public void setTipoParteFacade(TipoParteFacadeLocal tipoParteFacade) {
        this.tipoParteFacadelocal = tipoParteFacade;
    }

    public TipoParte getTp() {
        return tp;
    }

    public void setTp(TipoParte tp) {
        this.tp = tp;
    }

    public List<TipoParte> getListatipo() {
        return listatipo;
    }

    public void setListatipo(List<TipoParte> listatipo) {
        this.listatipo = listatipo;
    }

    public TipoParteFacade getTipoFacade() {
        return tipoFacade;
    }

    public void setTipoFacade(TipoParteFacade tipoFacade) {
        this.tipoFacade = tipoFacade;
    }
    
    //metodo que servira para guardar los datos que se mandaran del index
    public void ward(){
       //comprueba  las variables y valida al entrar
       try{
           tipoParteFacadelocal.create(tp);//crea instancia del tipopartefacade a crearlo con varibale tp
           inciar();//inicia los parametros para que se demustren nulos
           showMessage("Guardado con exito!! :D");
           tp=new TipoParte();
           
       }catch(Exception e){
           System.out.println("Error: " + e);
           showMessage("No se pudieron ingresar.");
       }
   }
       
    //componente que hace mostrar un msj
       public void showMessage(String Mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(Mensaje));
}
    
   
}
