import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class zxj
{
  private static volatile zxj jdField_a_of_type_Zxj;
  private HashMap<String, zxm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private zwr jdField_a_of_type_Zwr;
  private zwt jdField_a_of_type_Zwt;
  private HashMap<String, zxn> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private zwr jdField_b_of_type_Zwr;
  private zwt jdField_b_of_type_Zwt;
  
  /* Error */
  public static zxj a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	zxj:jdField_a_of_type_Zxj	Lzxj;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	zxj:jdField_a_of_type_Zxj	Lzxj;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	zxj
    //   21: dup
    //   22: invokespecial 28	zxj:<init>	()V
    //   25: putstatic 27	zxj:jdField_a_of_type_Zxj	Lzxj;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	zxj:jdField_a_of_type_Zxj	Lzxj;
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
    //   34	5	0	localzxj	zxj
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
  
  private void a(zwr paramzwr)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramzwr != null)
    {
      str = paramzwr.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (zxg.a().a(str))
    {
      a(paramzwr, zxg.a().b(str));
      return;
    }
    zxg.a().a(paramzwr.a(), new zxk(this, paramzwr, str));
  }
  
  private void a(zwr paramzwr, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramzwr.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zxm localzxm = new zxm(this, str, paramzwr.a().optJSONObject(str));
      localzxm.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localzxm);
    }
  }
  
  private void a(zwt paramzwt)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramzwt != null)
    {
      str = paramzwt.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (zxg.a().a(str))
    {
      a(paramzwt, zxg.a().b(str));
      return;
    }
    zxg.a().a(paramzwt.a(), new zxl(this, paramzwt, str));
  }
  
  private void a(zwt paramzwt, String paramString)
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
        zxn localzxn = new zxn(this, str, paramzwt.c());
        localzxn.a(paramString + "/" + str);
        localzxn.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localzxn);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Zwr);
    a(this.jdField_b_of_type_Zwt);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public zxm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (zxm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public zxn a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (zxn)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Zwr = zwr.a(str);
        if (this.jdField_a_of_type_Zwr != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Zwr.toString());
        }
      }
      str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Zwt = zwt.a(str);
        if (this.jdField_a_of_type_Zwt != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Zwt.toString());
        }
      }
      this.jdField_b_of_type_Zwr = ((zwr)apub.a().a(473));
      if (this.jdField_b_of_type_Zwr != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Zwr.toString());
      }
      this.jdField_b_of_type_Zwt = ((zwt)apub.a().a(474));
      if (this.jdField_b_of_type_Zwt != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Zwt.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Zwr != null) {
          this.jdField_b_of_type_Zwr = this.jdField_a_of_type_Zwr;
        }
        if (this.jdField_a_of_type_Zwt != null) {
          this.jdField_b_of_type_Zwt = this.jdField_a_of_type_Zwt;
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
    return VSConfigManager.getInstance().isApplyWidgetConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxj
 * JD-Core Version:    0.7.0.1
 */