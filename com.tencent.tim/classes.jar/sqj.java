import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class sqj
{
  private static volatile sqj jdField_a_of_type_Sqj;
  private sps jdField_a_of_type_Sps;
  private spu jdField_a_of_type_Spu;
  private sps jdField_b_of_type_Sps;
  private spu jdField_b_of_type_Spu;
  private HashMap<String, sqj.a> fR = new HashMap();
  private HashMap<String, sqj.b> fS = new HashMap();
  
  /* Error */
  public static sqj a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 33	sqj:jdField_a_of_type_Sqj	Lsqj;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 33	sqj:jdField_a_of_type_Sqj	Lsqj;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	sqj
    //   21: dup
    //   22: invokespecial 34	sqj:<init>	()V
    //   25: putstatic 33	sqj:jdField_a_of_type_Sqj	Lsqj;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 33	sqj:jdField_a_of_type_Sqj	Lsqj;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localsqj	sqj
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void a(sps paramsps, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramsps.R().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      sqj.a locala = new sqj.a(str, paramsps.R().optJSONObject(str));
      locala.tx(paramString);
      this.fR.put(str, locala);
    }
  }
  
  private void a(spu paramspu, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initWidgetConfigCache() path:" + paramString);
    Object localObject1 = new File(paramString);
    Object localObject2;
    if (((File)localObject1).exists())
    {
      localObject2 = Arrays.asList(((File)localObject1).list());
      if (!((List)localObject2).contains("widget@2x.png")) {
        break label195;
      }
    }
    label195:
    for (localObject1 = paramString + "/" + "widget@2x.png";; localObject1 = "")
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        String str;
        if (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (!"widget@2x.png".equals(str)) {}
        }
        else
        {
          return;
        }
        sqj.b localb = new sqj.b(str, paramspu.getID());
        localb.tx(paramString + "/" + str);
        localb.aFV = ((String)localObject1);
        this.fS.put(str, localb);
      }
    }
  }
  
  private void bzR()
  {
    c(this.jdField_b_of_type_Sps);
    c(this.jdField_b_of_type_Spu);
  }
  
  private void c(sps paramsps)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramsps != null)
    {
      str = paramsps.getDownloadUrl();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (sqh.a().ga(str))
    {
      a(paramsps, sqh.a().gK(str));
      return;
    }
    sqh.a().b(paramsps.getDownloadUrl(), new sqk(this, paramsps, str));
  }
  
  private void c(spu paramspu)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramspu != null)
    {
      str = paramspu.getDownloadUrl();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (sqh.a().ga(str))
    {
      a(paramspu, sqh.a().gK(str));
      return;
    }
    sqh.a().b(paramspu.getDownloadUrl(), new sql(this, paramspu, str));
  }
  
  private boolean isQzoneProcess()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public boolean Ni()
  {
    return spp.a().Nh();
  }
  
  public sqj.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (sqj.a)this.fR.get(paramString);
  }
  
  public sqj.b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (sqj.b)this.fS.get(paramString);
  }
  
  public void loadConfig()
  {
    try
    {
      String str = (String)spp.a().getValue("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Sps = sps.a(str);
        if (this.jdField_a_of_type_Sps != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Sps.toString());
        }
      }
      str = (String)spp.a().getValue("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Spu = spu.a(str);
        if (this.jdField_a_of_type_Spu != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Spu.toString());
        }
      }
      this.jdField_b_of_type_Sps = ((sps)aeif.a().o(473));
      if (this.jdField_b_of_type_Sps != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Sps.toString());
      }
      this.jdField_b_of_type_Spu = ((spu)aeif.a().o(474));
      if (this.jdField_b_of_type_Spu != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Spu.toString());
      }
      if (isQzoneProcess())
      {
        if (this.jdField_a_of_type_Sps != null) {
          this.jdField_b_of_type_Sps = this.jdField_a_of_type_Sps;
        }
        if (this.jdField_a_of_type_Spu != null) {
          this.jdField_b_of_type_Spu = this.jdField_a_of_type_Spu;
        }
      }
      bzR();
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, new Object[] { "loadConfig error!" + localException.toString() });
    }
  }
  
  public class a
  {
    public String aFL = "";
    public String aFM = "";
    public String aFN = "";
    public String aFO = "";
    public String aFP = "";
    public String afu = "";
    public String bP = "";
    
    public a(String paramString, JSONObject paramJSONObject)
    {
      this.aFL = paramString;
      try
      {
        this.bP = paramJSONObject.getString("title");
        this.aFM = paramJSONObject.getString("title_color");
        this.afu = paramJSONObject.getString("bg_color");
        this.aFN = paramJSONObject.getString("bg_border_color");
        return;
      }
      catch (JSONException this$1)
      {
        sqj.this.printStackTrace();
      }
    }
    
    public void tx(String paramString)
    {
      paramString = paramString + "/" + this.aFL;
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        localObject = Arrays.asList(((File)localObject).list());
        if (((List)localObject).contains("take_video@2x.png"))
        {
          String str = paramString + "/" + "take_video@2x.png";
          if (new File(str).exists()) {
            this.aFO = str;
          }
        }
        if (((List)localObject).contains("take_video_no_bg@2x.png"))
        {
          paramString = paramString + "/" + "take_video_no_bg@2x.png";
          if (new File(paramString).exists()) {
            this.aFP = paramString;
          }
        }
      }
    }
  }
  
  public class b
  {
    public String aFQ = "";
    public String aFR = "";
    public String aFS = "";
    public String aFT = "";
    public String aFU = "";
    public String aFV = "";
    private boolean aMz;
    
    public b(String paramString1, String paramString2)
    {
      this.aFQ = paramString1;
      this.aFR = paramString2;
    }
    
    public boolean isResourceReady()
    {
      QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isResourceReady:" + this.aMz);
      return this.aMz;
    }
    
    public void tx(String paramString)
    {
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        this.aMz = true;
        localObject = Arrays.asList(((File)localObject).list());
        String str;
        if (((List)localObject).contains("bg@2x.png"))
        {
          str = paramString + "/" + "bg@2x.png";
          if (!new File(str).exists()) {
            break label195;
          }
          this.aFS = str;
        }
        if (((List)localObject).contains("camera@2x.png"))
        {
          str = paramString + "/" + "camera@2x.png";
          if (!new File(str).exists()) {
            break label203;
          }
          this.aFT = str;
        }
      }
      for (;;)
      {
        if (((List)localObject).contains("point@2x.png"))
        {
          paramString = paramString + "/" + "point@2x.png";
          if (!new File(paramString).exists()) {
            break label211;
          }
          this.aFU = paramString;
        }
        return;
        label195:
        this.aMz = false;
        break;
        label203:
        this.aMz = false;
      }
      label211:
      this.aMz = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqj
 * JD-Core Version:    0.7.0.1
 */