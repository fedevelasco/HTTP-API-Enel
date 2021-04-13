package com.isae.devEnelHttp;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.NotRunningException;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.BWorker;
import javax.baja.util.CoalesceQueue;
import javax.baja.util.Worker;

@NiagaraType

public class BPostWorker extends BWorker {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.isae.devEnelHttp.BPostWorker(2979906276)1.0$ @*/
/* Generated Thu Aug 13 18:11:57 ART 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPostWorker.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    //////////////////////////////////////////////////////////
    //  Atributos
    //////////////////////////////////////////////////////////

    private CoalesceQueue queue; //Cola de trabajo
    private Worker worker; //Manejador de la cola

    //////////////////////////////////////////////////////////
    //  Metodo para encolar acciones y volverlas asincronicas
    //////////////////////////////////////////////////////////
    public void postAsync(Runnable r) {
        if (!isRunning() || queue == null)
            throw new NotRunningException();
        queue.enqueue(r);
    }

    //////////////////////////////////////////////////////////
    //  Metodo que crea la cola y el worker
    //////////////////////////////////////////////////////////

    @Override
    public Worker getWorker() {
        if (worker == null) {
            queue = new CoalesceQueue(1000); //Cola para 1000 tareas en multi-thread
            worker = new Worker(queue);
        }
        return worker;
    }
}
