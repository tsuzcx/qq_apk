import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class tmk
{
  private static tmk jdField_a_of_type_Tmk = new tmk();
  private final Map<String, tml> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public tmk()
  {
    c();
  }
  
  public static String a(String paramString)
  {
    return (String)bmhv.a(b(paramString), "");
  }
  
  public static tmk a()
  {
    return jdField_a_of_type_Tmk;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bmhv.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static tml b(String paramString)
  {
    tml localtml = new tml(paramString);
    localtml.a("default_feeds");
    localtml.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localtml.c = paramString;
      }
    }
    else {
      return localtml;
    }
    localtml.b = paramString;
    return localtml;
  }
  
  public static void b(String paramString)
  {
    tml localtml = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localtml.b, ", config.localPath = ", localtml.c });
    new tmn(localtml.b, localtml.c).a();
  }
  
  private void c()
  {
    tml localtml = new tml("default_feeds");
    localtml.b = bmhv.a("default_feeds_proteus_offline_bid");
    localtml.c = ("proteus/" + localtml.a + "");
    a(localtml);
    localtml = new tml("comment_feeds");
    localtml.b = bmhv.a("comment_proteus_offline_bid");
    localtml.c = ("proteus/" + localtml.a);
    a(localtml);
    localtml = new tml("native_article");
    localtml.a("default_feeds");
    localtml.c = ("proteus/" + localtml.a + "");
    localtml.b = bmhv.a("native_proteus_offline_bid");
    a(localtml);
    d();
    localtml = new tml("daily_dynamic_header");
    localtml.b = bmhv.a("daily_header_proteus_bid");
    localtml.c = ("proteus/" + localtml.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localtml.b);
    a(localtml);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  private void d() {}
  
  public Map<String, tml> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public tml a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (tml)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    tml localtml = b(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localtml);
    return localtml;
  }
  
  public tmm a(Context paramContext, String paramString)
  {
    tml localtml = a(paramString);
    tmn localtmn = new tmn(localtml.b, localtml.c);
    tmn.a(paramString);
    paramString = localtmn.a(paramContext);
    if (paramString == null)
    {
      paramContext = localtmn.b(paramContext);
      return new tmm(localtml.c, paramContext, true);
    }
    return new tmm(localtml.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      tml localtml = (tml)((Map.Entry)localIterator.next()).getValue();
      new tmn(localtml.b, localtml.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (tml)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      new tmn(paramString.b, paramString.c).a();
    }
  }
  
  public void a(tml paramtml)
  {
    if (paramtml.a == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramtml.a, paramtml);
  }
  
  public void b()
  {
    if ((!prs.c()) && (Aladdin.getConfig(335).getIntegerFromString("pts_style_immediate_effect", 0) == 1) && (((Boolean)bmhv.a("kandian_pts_style_update", Boolean.valueOf(false))).booleanValue()))
    {
      QLog.d("StyleConfigHelper", 1, "invalidAllArticles");
      tmh.c("default_feeds");
      bmhv.a("kandian_pts_style_update", Boolean.valueOf(false));
      pis.a.a();
      List localList = pis.a.a();
      pis.a.a(localList);
      QLog.d("StyleConfigHelper", 1, "preload pts card, rules : " + localList);
      pvm.a().o();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((tml)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmk
 * JD-Core Version:    0.7.0.1
 */