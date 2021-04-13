package com.isae.devEnelHttp;

import com.tridium.json.JSONArray;
import com.tridium.json.JSONException;
import com.tridium.json.JSONObject;

import javax.baja.file.BFileSystem;
import javax.baja.file.BIFile;
import javax.baja.file.FilePath;
import javax.baja.naming.BOrd;
import javax.baja.naming.OrdQuery;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.search.*;
import javax.baja.sys.*;
import javax.baja.tag.Tag;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


@NiagaraType

@NiagaraAction(
        name = "post",
        flags = Flags.ASYNC | Flags.SUMMARY
)

@NiagaraProperty(
        name = "worker",
        type = "BPostWorker",
        defaultValue = "new BPostWorker()"
)

@NiagaraProperty(
        name = "Gateway",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "TGW4API"
)

@NiagaraProperty(
        name = "Token",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "327c326441ec1e5b995b"
)

@NiagaraProperty(
        name = "lastTimeSend",
        type = "BAbsTime",
        flags = Flags.READONLY | Flags.SUMMARY,
        defaultValue = "BAbsTime.now()"
)

@NiagaraProperty(
        name = "lastTimeFailure",
        type = "BAbsTime",
        flags = Flags.READONLY | Flags.SUMMARY,
        defaultValue = "BAbsTime.now()"
)

@NiagaraProperty(
        name = "lasFailureCause",
        type = "String",
        flags = Flags.READONLY | Flags.SUMMARY,
        defaultValue = ""
)

public class BHttpEnelService extends BAbstractService {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.isae.devEnelHttp.BHttpEnelService(613047319)1.0$ @*/
/* Generated Fri Aug 14 15:51:11 ART 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "worker"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code worker} property.
   * @see #getWorker
   * @see #setWorker
   */
  public static final Property worker = newProperty(0, new BPostWorker(), null);
  
  /**
   * Get the {@code worker} property.
   * @see #worker
   */
  public BPostWorker getWorker() { return (BPostWorker)get(worker); }
  
  /**
   * Set the {@code worker} property.
   * @see #worker
   */
  public void setWorker(BPostWorker v) { set(worker, v, null); }

////////////////////////////////////////////////////////////////
// Property "Gateway"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Gateway} property.
   * @see #getGateway
   * @see #setGateway
   */
  public static final Property Gateway = newProperty(Flags.SUMMARY, "TGW4API", null);
  
  /**
   * Get the {@code Gateway} property.
   * @see #Gateway
   */
  public String getGateway() { return getString(Gateway); }
  
  /**
   * Set the {@code Gateway} property.
   * @see #Gateway
   */
  public void setGateway(String v) { setString(Gateway, v, null); }

////////////////////////////////////////////////////////////////
// Property "Token"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Token} property.
   * @see #getToken
   * @see #setToken
   */
  public static final Property Token = newProperty(Flags.SUMMARY, "327c326441ec1e5b995b", null);
  
  /**
   * Get the {@code Token} property.
   * @see #Token
   */
  public String getToken() { return getString(Token); }
  
  /**
   * Set the {@code Token} property.
   * @see #Token
   */
  public void setToken(String v) { setString(Token, v, null); }

////////////////////////////////////////////////////////////////
// Property "lastTimeSend"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lastTimeSend} property.
   * @see #getLastTimeSend
   * @see #setLastTimeSend
   */
  public static final Property lastTimeSend = newProperty(Flags.READONLY | Flags.SUMMARY, BAbsTime.now(), null);
  
  /**
   * Get the {@code lastTimeSend} property.
   * @see #lastTimeSend
   */
  public BAbsTime getLastTimeSend() { return (BAbsTime)get(lastTimeSend); }
  
  /**
   * Set the {@code lastTimeSend} property.
   * @see #lastTimeSend
   */
  public void setLastTimeSend(BAbsTime v) { set(lastTimeSend, v, null); }

////////////////////////////////////////////////////////////////
// Property "lastTimeFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lastTimeFailure} property.
   * @see #getLastTimeFailure
   * @see #setLastTimeFailure
   */
  public static final Property lastTimeFailure = newProperty(Flags.READONLY | Flags.SUMMARY, BAbsTime.now(), null);
  
  /**
   * Get the {@code lastTimeFailure} property.
   * @see #lastTimeFailure
   */
  public BAbsTime getLastTimeFailure() { return (BAbsTime)get(lastTimeFailure); }
  
  /**
   * Set the {@code lastTimeFailure} property.
   * @see #lastTimeFailure
   */
  public void setLastTimeFailure(BAbsTime v) { set(lastTimeFailure, v, null); }

////////////////////////////////////////////////////////////////
// Property "lasFailureCause"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lasFailureCause} property.
   * @see #getLasFailureCause
   * @see #setLasFailureCause
   */
  public static final Property lasFailureCause = newProperty(Flags.READONLY | Flags.SUMMARY, "", null);
  
  /**
   * Get the {@code lasFailureCause} property.
   * @see #lasFailureCause
   */
  public String getLasFailureCause() { return getString(lasFailureCause); }
  
  /**
   * Set the {@code lasFailureCause} property.
   * @see #lasFailureCause
   */
  public void setLasFailureCause(String v) { setString(lasFailureCause, v, null); }

////////////////////////////////////////////////////////////////
// Action "post"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code post} action.
   * @see #post()
   */
  public static final Action post = newAction(Flags.ASYNC | Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code post} action.
   * @see #post
   */
  public void post() { invoke(post, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHttpEnelService.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  ////////////////////////////////////////////////////////////////
  // Implementacion Asincronica del Metodo Post
  ////////////////////////////////////////////////////////////////

  public void doPost(Context cx){

    //Abro el archivo
    BOrd fileOrd = BOrd.make("file:^DataPending.txt");
    BIFile file = null;

    try {
      file = (BIFile) fileOrd.get(this);
    } catch (UnresolvedException e) {
      e.printStackTrace();
    }

    //Lo creo si no existe
    if (file == null) {
      try {
        OrdQuery[] queries = fileOrd.parse();
        FilePath filePath = (FilePath) queries[queries.length - 1];
        file = BFileSystem.INSTANCE.makeFile(filePath);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    //Creacion del JSON vacio
    JSONArray jsonBuffer = new JSONArray();

    //Leo el archivo y cargo en el JSON los valores pendientes de transmitir
    try {
      byte[] jsonObjReadBytes = file.read();
      if (jsonObjReadBytes.length > 0) {
        String jsonObjReadString = new String(jsonObjReadBytes, "UTF-8");
        String[] jsonObjReadParts = jsonObjReadString.split(System.lineSeparator());
        for (int i = 0; i < jsonObjReadParts.length; i++) {
          JSONObject jsonObjReadPart = new JSONObject(jsonObjReadParts[i]);
          jsonBuffer.put(jsonObjReadPart);
        }
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
       e.printStackTrace();
    }

    //Creo la lista de dispositivos actuales
    ArrayList<Device> devices = new ArrayList<Device>();


    try {
      //Verificamos que este instalado el Search Service
      BSearchService searchService = BSearchService.getService();

      //Query neql
      BOrd searchRequest = BOrd.make("neql:e:enel");

      //Ejecuto la query en el Search Serivce
      BSearchParams searchParams = new BSearchParams(searchRequest, Sys.getStation());
      BOrd searchTaskOrd = searchService.search(searchParams);

      //Obtengo las entities que cumplen la query neql
      BSearchResultSet results = null;

      while (results == null || !results.getResultsComplete())
      {
        BResultsRequest resultsRequest = BResultsRequest.make(searchTaskOrd, 0, -1);
        results = searchService.retrieveResults(resultsRequest);
      }

      //Forma de acceder a las entities
      results.streamResults().forEach(result -> {

        //Obtengo el ORD de una entity
        BOrd resultOrd = ((BSearchResult)result).getOrd();
        //Obtengo el BComponente
        BComponent comp = resultOrd.resolve().getComponent();

        //Obtengo el out.value
        String vraw = comp.get("out").toString();
        int end = vraw.indexOf('{');
        String v = vraw.substring(0,end-1);

        //Obtengo una Collection con los Tags del BComponente
        Collection<Tag> compTags = comp.tags().getAll();

        //Hago un barrido de los tags y me guardo los valores de los tags did y p
        Iterator iterator = compTags.iterator();
        String did = "";
        String p = "0";
        int both = 0;

        while (iterator.hasNext()){

          //Obtengo el nombre del Tag
          Tag tag = (Tag) iterator.next();
          String tagName = tag.getId().toString();

          //Guardo el valor si es el e:did
          if (tagName.equals("e:did")) {
            did = tag.getValue().toString();
            both++;
          }
          //Guardo el valor si es el e:p
          if (tagName.equals("e:p")) {
            p = tag.getValue().toString();
            both++;
          }
          //Salgo del loop si ya encontre los e:did y e:p
          if(both == 2){
            break;
          }
        }

        int matchd = 0;
        int matchp = 0;

        if (both == 2){
          //Busco el device dentro del ArrayList en funcion de su e:did
          for (int i = 0; i < devices.size(); i++){
            if (devices.get(i).getDid().equals(did)){
              matchd = 1;
              break;
            }
          }
          //Si no existe el device lo creo
          if(matchd == 0){
            devices.add(new Device(did));
          }
          //Busco el device en el ArrayList
          for (int i = 0; i < devices.size(); i++){
            if (devices.get(i).getDid().equals(did)){

              //Busco el parametro dentro del dispositivo
              for(int j = 0; j < devices.get(i).getParameterSize(); j++){
                if (devices.get(i).getParameter(j).equals(p)) {
                  matchp = 1;
                  break;
                }
              }
              //Si no existe el parametro lo creo
              if(matchp == 0){
                devices.get(i).parameters.add(new Parameter(p=p,v=v));
              }
              else {
                //Si existe informo un error
                System.out.println("Parametro repetido : " + p );
              }
              break;
            }
          }
        }
      });

    } catch (Exception e) {
      e.printStackTrace();
    }

    //Agregado al JSON con valores actuales
    try {
      for (int i = 0; i < devices.size(); i++) {
        JSONObject jsonDev = new JSONObject();
        jsonDev.put("did", devices.get(i).getDid());
        jsonDev.put("sqn", 1);
        jsonDev.put("ts", encodeTimeStamp(BAbsTime.now()));
        JSONArray jsonValues = new JSONArray();
        for (int j = 0; j < devices.get(i).getParameterSize(); j++) {
          JSONObject jsonParameter = new JSONObject();
          jsonParameter.put("p", Integer.parseInt(devices.get(i).parameters.get(j).getP()));
          jsonParameter.put("v", Double.parseDouble(devices.get(i).parameters.get(j).getV()));
          jsonValues.put(jsonParameter);
        }
        jsonDev.put("values", jsonValues);
        jsonBuffer.put(jsonDev);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    //Verificado del Armado del JSON
    System.out.println(jsonBuffer.toString(4));

    try {

      //Creo el objeto URL y el Conector con la URL

      String url = "https://is3.dexcell.com/readings?source_key=" + getGateway() + "&dexcell_source_token=" + getToken();
      URL myUrl = null;

      myUrl = new URL(url);
      URLConnection con = (HttpURLConnection) myUrl.openConnection();

      //Configuro el POST como metodo a usar y preparo las propiedades para enviar y recibir formato JSON
      con.setDoOutput(true);
      con.setRequestProperty("Content-Type", "application/json");

      //Hago el POST
      try (OutputStream os = con.getOutputStream()) {
        byte[] jsonBytes = jsonBuffer.toString().getBytes("utf-8");
        os.write(jsonBytes, 0, jsonBytes.length);
      }

      //Leo la respuesta del POST
      try (BufferedReader br = new BufferedReader(
              new InputStreamReader(con.getInputStream(), "utf-8"))) {

        StringBuilder response = new StringBuilder();
        String responseLine = null;

        while ((responseLine = br.readLine()) != null) {
          response.append(responseLine.trim());
        }

        //Verifico el OK, guardo el timestamp y limpio el archivo
        if (response.toString().equals("OK")) {

          setLastTimeSend(BAbsTime.now());

          try {
            String jsonObjBuffer = "";
            byte[] jsonObjBytes = jsonObjBuffer.getBytes("utf-8");
            file.write(jsonObjBytes);

            //Excepciones al guardar el archivo
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        else{

          //Sino guardo la causa de la falla, el timestamp y guardo el JSON en el archivo
          setLastTimeFailure(BAbsTime.now());
          setLasFailureCause(response.toString());

          try {
            String jsonObjBuffer = "";
            for(int i = 0 ; i < jsonBuffer.length() ; i++){
              jsonObjBuffer = jsonObjBuffer.concat(jsonBuffer.getJSONObject(i).toString());
              jsonObjBuffer = jsonObjBuffer.concat(System.lineSeparator());
            }
            byte[] jsonObjBytes = jsonObjBuffer.getBytes("utf-8");
            file.write(jsonObjBytes);

            //Excepciones al guardar el archivo
          } catch (JSONException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
      //Excepciones durante el POST, guardo la causa de la falla, el timestamp y guardo el JSON en el archivo
    } catch (MalformedURLException e) {

      setLastTimeFailure(BAbsTime.now());
      setLasFailureCause(e.getMessage());

      try {
        String jsonObjBuffer = "";
        for(int i = 0 ; i < jsonBuffer.length() ; i++){
          jsonObjBuffer = jsonObjBuffer.concat(jsonBuffer.getJSONObject(i).toString());
          jsonObjBuffer = jsonObjBuffer.concat(System.lineSeparator());
        }
        byte[] jsonObjBytes = jsonObjBuffer.getBytes("utf-8");
        file.write(jsonObjBytes);

        //Excepciones al guardar el archivo
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }

      e.printStackTrace();

    } catch (UnsupportedEncodingException e) {
      setLastTimeFailure(BAbsTime.now());
      setLasFailureCause(e.getMessage());

      try {
        String jsonObjBuffer = "";
        for(int i = 0 ; i < jsonBuffer.length() ; i++){
          jsonObjBuffer = jsonObjBuffer.concat(jsonBuffer.getJSONObject(i).toString());
          jsonObjBuffer = jsonObjBuffer.concat(System.lineSeparator());
        }
        byte[] jsonObjBytes = jsonObjBuffer.getBytes("utf-8");
        file.write(jsonObjBytes);
        //Excepciones al guardar el archivo

      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }

      e.printStackTrace();

    } catch (IOException e) {

      setLastTimeFailure(BAbsTime.now());
      setLasFailureCause(e.getMessage());

      try {
        String jsonObjBuffer = "";
        for(int i = 0 ; i < jsonBuffer.length() ; i++){
          jsonObjBuffer = jsonObjBuffer.concat(jsonBuffer.getJSONObject(i).toString());
          jsonObjBuffer = jsonObjBuffer.concat(System.lineSeparator());
        }
        byte[] jsonObjBytes = jsonObjBuffer.getBytes("utf-8");
        file.write(jsonObjBytes);
        //Excepciones al guardar el archivo

      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }

      e.printStackTrace();

    }
  }

  @Override
  public IFuture post(Action action, BValue argument, Context cx) {
    getWorker().postAsync(new Invocation(this, action, argument, cx));
    return null;
  }

  ////////////////////////////////////////////////////////////////
  // Service Callbacks
  ////////////////////////////////////////////////////////////////

  public void serviceStarted() {
    //No hace nada...
  }

  @Override
  public void serviceStopped() {
    //No hace nada...
  }

  @Override
  public Type[] getServiceTypes() {
    return serviceTypes;
  }

  private static Type[] serviceTypes = new Type[] { TYPE };

  ////////////////////////////////////////////////////////////////
  // Metodo para convertir el timestamp del web en el formato que necesita el soft de enel
  ////////////////////////////////////////////////////////////////

  public String encodeTimeStamp(BAbsTime t){
    int year = t.getYear();
    int month = t.getMonth().getMonthOfYear();
    int day = t.getDay();
    int hour = t.getHour();
    int minute = t.getMinute();
    int second = t.getSecond();
    int timeZoneMili = t.getTimeZoneOffset();
    char timeZoneSign = String.valueOf(timeZoneMili).charAt(0);
    int timeZoneMiliAbs = Math.abs(timeZoneMili);
    int timeZoneHour = timeZoneMiliAbs / (60 * 60 * 1000);
    return (String.format("%04d",year) + "-" + String.format("%02d",month) + "-" + String.format("%02d",day) + "T" +
            String.format("%02d",hour) + ":" + String.format("%02d",minute) + ":" + String.format("%02d",second) +
            timeZoneSign + String.format("%02d",timeZoneHour) + ":00");
  }

}
