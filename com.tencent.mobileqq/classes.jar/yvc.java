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

public class yvc
{
  private static volatile yvc jdField_a_of_type_Yvc;
  private HashMap<String, yvf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private yuk jdField_a_of_type_Yuk;
  private yum jdField_a_of_type_Yum;
  private HashMap<String, yvg> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private yuk jdField_b_of_type_Yuk;
  private yum jdField_b_of_type_Yum;
  
  /* Error */
  public static yvc a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	yvc:jdField_a_of_type_Yvc	Lyvc;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	yvc:jdField_a_of_type_Yvc	Lyvc;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	yvc
    //   21: dup
    //   22: invokespecial 28	yvc:<init>	()V
    //   25: putstatic 27	yvc:jdField_a_of_type_Yvc	Lyvc;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	yvc:jdField_a_of_type_Yvc	Lyvc;
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
    //   34	5	0	localyvc	yvc
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
  
  private void a(yuk paramyuk)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramyuk != null)
    {
      str = paramyuk.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (yuz.a().a(str))
    {
      a(paramyuk, yuz.a().b(str));
      return;
    }
    yuz.a().a(paramyuk.a(), new yvd(this, paramyuk, str));
  }
  
  private void a(yuk paramyuk, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramyuk.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      yvf localyvf = new yvf(this, str, paramyuk.a().optJSONObject(str));
      localyvf.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localyvf);
    }
  }
  
  private void a(yum paramyum)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramyum != null)
    {
      str = paramyum.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (yuz.a().a(str))
    {
      a(paramyum, yuz.a().b(str));
      return;
    }
    yuz.a().a(paramyum.a(), new yve(this, paramyum, str));
  }
  
  private void a(yum paramyum, String paramString)
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
        yvg localyvg = new yvg(this, str, paramyum.c());
        localyvg.a(paramString + "/" + str);
        localyvg.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localyvg);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Yuk);
    a(this.jdField_b_of_type_Yum);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public yvf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (yvf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public yvg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (yvg)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)yuh.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Yuk = yuk.a(str);
        if (this.jdField_a_of_type_Yuk != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Yuk.toString());
        }
      }
      str = (String)yuh.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Yum = yum.a(str);
        if (this.jdField_a_of_type_Yum != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Yum.toString());
        }
      }
      this.jdField_b_of_type_Yuk = ((yuk)aogj.a().a(473));
      if (this.jdField_b_of_type_Yuk != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Yuk.toString());
      }
      this.jdField_b_of_type_Yum = ((yum)aogj.a().a(474));
      if (this.jdField_b_of_type_Yum != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Yum.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Yuk != null) {
          this.jdField_b_of_type_Yuk = this.jdField_a_of_type_Yuk;
        }
        if (this.jdField_a_of_type_Yum != null) {
          this.jdField_b_of_type_Yum = this.jdField_a_of_type_Yum;
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
    return yuh.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvc
 * JD-Core Version:    0.7.0.1
 */