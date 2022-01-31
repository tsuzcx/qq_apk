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

public class yzr
{
  private static volatile yzr jdField_a_of_type_Yzr;
  private HashMap<String, yzu> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private yyz jdField_a_of_type_Yyz;
  private yzb jdField_a_of_type_Yzb;
  private HashMap<String, yzv> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private yyz jdField_b_of_type_Yyz;
  private yzb jdField_b_of_type_Yzb;
  
  /* Error */
  public static yzr a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	yzr:jdField_a_of_type_Yzr	Lyzr;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	yzr:jdField_a_of_type_Yzr	Lyzr;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	yzr
    //   21: dup
    //   22: invokespecial 28	yzr:<init>	()V
    //   25: putstatic 27	yzr:jdField_a_of_type_Yzr	Lyzr;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	yzr:jdField_a_of_type_Yzr	Lyzr;
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
    //   34	5	0	localyzr	yzr
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
  
  private void a(yyz paramyyz)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramyyz != null)
    {
      str = paramyyz.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (yzo.a().a(str))
    {
      a(paramyyz, yzo.a().b(str));
      return;
    }
    yzo.a().a(paramyyz.a(), new yzs(this, paramyyz, str));
  }
  
  private void a(yyz paramyyz, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramyyz.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      yzu localyzu = new yzu(this, str, paramyyz.a().optJSONObject(str));
      localyzu.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localyzu);
    }
  }
  
  private void a(yzb paramyzb)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramyzb != null)
    {
      str = paramyzb.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (yzo.a().a(str))
    {
      a(paramyzb, yzo.a().b(str));
      return;
    }
    yzo.a().a(paramyzb.a(), new yzt(this, paramyzb, str));
  }
  
  private void a(yzb paramyzb, String paramString)
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
        yzv localyzv = new yzv(this, str, paramyzb.c());
        localyzv.a(paramString + "/" + str);
        localyzv.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localyzv);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Yyz);
    a(this.jdField_b_of_type_Yzb);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public yzu a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (yzu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public yzv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (yzv)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)yyw.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Yyz = yyz.a(str);
        if (this.jdField_a_of_type_Yyz != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Yyz.toString());
        }
      }
      str = (String)yyw.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Yzb = yzb.a(str);
        if (this.jdField_a_of_type_Yzb != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Yzb.toString());
        }
      }
      this.jdField_b_of_type_Yyz = ((yyz)aoks.a().a(473));
      if (this.jdField_b_of_type_Yyz != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Yyz.toString());
      }
      this.jdField_b_of_type_Yzb = ((yzb)aoks.a().a(474));
      if (this.jdField_b_of_type_Yzb != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Yzb.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Yyz != null) {
          this.jdField_b_of_type_Yyz = this.jdField_a_of_type_Yyz;
        }
        if (this.jdField_a_of_type_Yzb != null) {
          this.jdField_b_of_type_Yzb = this.jdField_a_of_type_Yzb;
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
    return yyw.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzr
 * JD-Core Version:    0.7.0.1
 */