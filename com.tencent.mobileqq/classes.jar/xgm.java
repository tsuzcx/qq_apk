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

public class xgm
{
  private static volatile xgm jdField_a_of_type_Xgm;
  private HashMap<String, xgp> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private xfu jdField_a_of_type_Xfu;
  private xfw jdField_a_of_type_Xfw;
  private HashMap<String, xgq> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private xfu jdField_b_of_type_Xfu;
  private xfw jdField_b_of_type_Xfw;
  
  /* Error */
  public static xgm a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	xgm:jdField_a_of_type_Xgm	Lxgm;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	xgm:jdField_a_of_type_Xgm	Lxgm;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	xgm
    //   21: dup
    //   22: invokespecial 28	xgm:<init>	()V
    //   25: putstatic 27	xgm:jdField_a_of_type_Xgm	Lxgm;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	xgm:jdField_a_of_type_Xgm	Lxgm;
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
    //   34	5	0	localxgm	xgm
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
  
  private void a(xfu paramxfu)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramxfu != null)
    {
      str = paramxfu.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (xgj.a().a(str))
    {
      a(paramxfu, xgj.a().b(str));
      return;
    }
    xgj.a().a(paramxfu.a(), new xgn(this, paramxfu, str));
  }
  
  private void a(xfu paramxfu, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramxfu.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      xgp localxgp = new xgp(this, str, paramxfu.a().optJSONObject(str));
      localxgp.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localxgp);
    }
  }
  
  private void a(xfw paramxfw)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramxfw != null)
    {
      str = paramxfw.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (xgj.a().a(str))
    {
      a(paramxfw, xgj.a().b(str));
      return;
    }
    xgj.a().a(paramxfw.a(), new xgo(this, paramxfw, str));
  }
  
  private void a(xfw paramxfw, String paramString)
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
        xgq localxgq = new xgq(this, str, paramxfw.c());
        localxgq.a(paramString + "/" + str);
        localxgq.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localxgq);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Xfu);
    a(this.jdField_b_of_type_Xfw);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public xgp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (xgp)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public xgq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (xgq)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)xfr.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Xfu = xfu.a(str);
        if (this.jdField_a_of_type_Xfu != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Xfu.toString());
        }
      }
      str = (String)xfr.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Xfw = xfw.a(str);
        if (this.jdField_a_of_type_Xfw != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Xfw.toString());
        }
      }
      this.jdField_b_of_type_Xfu = ((xfu)ampm.a().a(473));
      if (this.jdField_b_of_type_Xfu != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Xfu.toString());
      }
      this.jdField_b_of_type_Xfw = ((xfw)ampm.a().a(474));
      if (this.jdField_b_of_type_Xfw != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Xfw.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Xfu != null) {
          this.jdField_b_of_type_Xfu = this.jdField_a_of_type_Xfu;
        }
        if (this.jdField_a_of_type_Xfw != null) {
          this.jdField_b_of_type_Xfw = this.jdField_a_of_type_Xfw;
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
    return xfr.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgm
 * JD-Core Version:    0.7.0.1
 */