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

public class wxm
{
  private static volatile wxm jdField_a_of_type_Wxm;
  private HashMap<String, wxp> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private www jdField_a_of_type_Www;
  private wwy jdField_a_of_type_Wwy;
  private HashMap<String, wxq> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private www jdField_b_of_type_Www;
  private wwy jdField_b_of_type_Wwy;
  
  /* Error */
  public static wxm a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	wxm:jdField_a_of_type_Wxm	Lwxm;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	wxm:jdField_a_of_type_Wxm	Lwxm;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	wxm
    //   21: dup
    //   22: invokespecial 28	wxm:<init>	()V
    //   25: putstatic 27	wxm:jdField_a_of_type_Wxm	Lwxm;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	wxm:jdField_a_of_type_Wxm	Lwxm;
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
    //   34	5	0	localwxm	wxm
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
  
  private void a(www paramwww)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramwww != null)
    {
      str = paramwww.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (wxj.a().a(str))
    {
      a(paramwww, wxj.a().b(str));
      return;
    }
    wxj.a().a(paramwww.a(), new wxn(this, paramwww, str));
  }
  
  private void a(www paramwww, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramwww.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      wxp localwxp = new wxp(this, str, paramwww.a().optJSONObject(str));
      localwxp.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localwxp);
    }
  }
  
  private void a(wwy paramwwy)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramwwy != null)
    {
      str = paramwwy.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (wxj.a().a(str))
    {
      a(paramwwy, wxj.a().b(str));
      return;
    }
    wxj.a().a(paramwwy.a(), new wxo(this, paramwwy, str));
  }
  
  private void a(wwy paramwwy, String paramString)
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
        wxq localwxq = new wxq(this, str, paramwwy.c());
        localwxq.a(paramString + "/" + str);
        localwxq.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localwxq);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Www);
    a(this.jdField_b_of_type_Wwy);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public wxp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (wxp)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public wxq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (wxq)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)wwt.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Www = www.a(str);
        if (this.jdField_a_of_type_Www != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Www.toString());
        }
      }
      str = (String)wwt.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Wwy = wwy.a(str);
        if (this.jdField_a_of_type_Wwy != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Wwy.toString());
        }
      }
      this.jdField_b_of_type_Www = ((www)alzw.a().a(473));
      if (this.jdField_b_of_type_Www != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Www.toString());
      }
      this.jdField_b_of_type_Wwy = ((wwy)alzw.a().a(474));
      if (this.jdField_b_of_type_Wwy != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Wwy.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Www != null) {
          this.jdField_b_of_type_Www = this.jdField_a_of_type_Www;
        }
        if (this.jdField_a_of_type_Wwy != null) {
          this.jdField_b_of_type_Wwy = this.jdField_a_of_type_Wwy;
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
    return wwt.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxm
 * JD-Core Version:    0.7.0.1
 */