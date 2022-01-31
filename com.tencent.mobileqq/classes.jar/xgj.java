import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class xgj
{
  private static volatile xgj jdField_a_of_type_Xgj;
  private HashMap<String, xgm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private xfr jdField_a_of_type_Xfr;
  private xft jdField_a_of_type_Xft;
  private HashMap<String, xgn> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private xfr jdField_b_of_type_Xfr;
  private xft jdField_b_of_type_Xft;
  
  /* Error */
  public static xgj a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	xgj:jdField_a_of_type_Xgj	Lxgj;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	xgj:jdField_a_of_type_Xgj	Lxgj;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	xgj
    //   21: dup
    //   22: invokespecial 28	xgj:<init>	()V
    //   25: putstatic 27	xgj:jdField_a_of_type_Xgj	Lxgj;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	xgj:jdField_a_of_type_Xgj	Lxgj;
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
    //   34	5	0	localxgj	xgj
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
  
  private void a(xfr paramxfr)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramxfr != null)
    {
      str = paramxfr.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (xgg.a().a(str))
    {
      a(paramxfr, xgg.a().b(str));
      return;
    }
    xgg.a().a(paramxfr.a(), new xgk(this, paramxfr, str));
  }
  
  private void a(xfr paramxfr, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramxfr.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      xgm localxgm = new xgm(this, str, paramxfr.a().optJSONObject(str));
      localxgm.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localxgm);
    }
  }
  
  private void a(xft paramxft)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramxft != null)
    {
      str = paramxft.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (xgg.a().a(str))
    {
      a(paramxft, xgg.a().b(str));
      return;
    }
    xgg.a().a(paramxft.a(), new xgl(this, paramxft, str));
  }
  
  private void a(xft paramxft, String paramString)
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
        xgn localxgn = new xgn(this, str, paramxft.c());
        localxgn.a(paramString + "/" + str);
        localxgn.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localxgn);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Xfr);
    a(this.jdField_b_of_type_Xft);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public xgm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (xgm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public xgn a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (xgn)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)xfo.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Xfr = xfr.a(str);
        if (this.jdField_a_of_type_Xfr != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Xfr.toString());
        }
      }
      str = (String)xfo.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Xft = xft.a(str);
        if (this.jdField_a_of_type_Xft != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Xft.toString());
        }
      }
      this.jdField_b_of_type_Xfr = ((xfr)ampl.a().a(473));
      if (this.jdField_b_of_type_Xfr != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Xfr.toString());
      }
      this.jdField_b_of_type_Xft = ((xft)ampl.a().a(474));
      if (this.jdField_b_of_type_Xft != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Xft.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Xfr != null) {
          this.jdField_b_of_type_Xfr = this.jdField_a_of_type_Xfr;
        }
        if (this.jdField_a_of_type_Xft != null) {
          this.jdField_b_of_type_Xft = this.jdField_a_of_type_Xft;
        }
      }
      b();
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, new Object[] { "loadConfig error!" + localException.toString() });
    }
  }
  
  public boolean a()
  {
    return xfo.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgj
 * JD-Core Version:    0.7.0.1
 */