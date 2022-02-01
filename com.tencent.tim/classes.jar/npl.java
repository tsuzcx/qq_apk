import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class npl
{
  private final Map<String, npl.a> configMap = new HashMap();
  
  public npl()
  {
    init();
  }
  
  private void aZW() {}
  
  private static npl.a b(String paramString)
  {
    npl.a locala = new npl.a(paramString);
    locala.ov("default_feeds");
    locala.localPath = ("proteus/" + paramString + "");
    paramString = eX(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        locala.localPath = paramString;
      }
    }
    else {
      return locala;
    }
    locala.bid = paramString;
    return locala;
  }
  
  public static void bM(String paramString1, String paramString2)
  {
    awit.H(getSpKey(paramString1), paramString2);
  }
  
  public static String eX(String paramString)
  {
    return (String)awit.f(getSpKey(paramString), "");
  }
  
  private static String getSpKey(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private void init()
  {
    npl.a locala = new npl.a("default_feeds");
    locala.bid = awit.sn("default_feeds_proteus_offline_bid");
    locala.localPath = ("proteus/" + locala.ani + "");
    a(locala);
    locala = new npl.a("comment_feeds");
    locala.bid = awit.sn("comment_proteus_offline_bid");
    locala.localPath = ("proteus/" + locala.ani);
    a(locala);
    locala = new npl.a("native_article");
    locala.ov("default_feeds");
    locala.localPath = ("proteus/" + locala.ani + "");
    locala.bid = awit.sn("native_proteus_offline_bid");
    a(locala);
    aZW();
    locala = new npl.a("daily_dynamic_header");
    locala.bid = awit.sn("daily_header_proteus_bid");
    locala.localPath = ("proteus/" + locala.ani + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + locala.bid);
    a(locala);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  public static void ou(String paramString)
  {
    npl.a locala = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", locala.bid, ", config.localPath = ", locala.localPath });
    new npm(locala.bid, locala.localPath).checkUpdate();
  }
  
  public Map<String, npl.a> I()
  {
    return this.configMap;
  }
  
  public npl.a a(String paramString)
  {
    if (this.configMap.containsKey(paramString)) {
      return (npl.a)this.configMap.get(paramString);
    }
    npl.a locala = b(paramString);
    this.configMap.put(paramString, locala);
    return locala;
  }
  
  public npl.b a(Context paramContext, String paramString)
  {
    npl.a locala = a(paramString);
    npm localnpm = new npm(locala.bid, locala.localPath);
    npm.ow(paramString);
    paramString = localnpm.a(paramContext);
    if (paramString == null)
    {
      paramContext = localnpm.b(paramContext);
      return new npl.b(locala.localPath, paramContext, true);
    }
    return new npl.b(locala.bid, paramString, false);
  }
  
  public void a(npl.a parama)
  {
    if (parama.ani == null) {
      throw new IllegalArgumentException();
    }
    this.configMap.put(parama.ani, parama);
  }
  
  public void aZV()
  {
    Iterator localIterator = this.configMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      npl.a locala = (npl.a)((Map.Entry)localIterator.next()).getValue();
      new npm(locala.bid, locala.localPath).checkUpdate();
    }
  }
  
  public void ot(String paramString)
  {
    paramString = (npl.a)this.configMap.get(paramString);
    if (paramString != null) {
      new npm(paramString.bid, paramString.localPath).checkUpdate();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.configMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((npl.a)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public String ani;
    public String anj;
    public String bid;
    public String localPath;
    
    public a(String paramString)
    {
      this.ani = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if ((paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if ((this.bid == null) || (!this.bid.equals(paramObject.bid))) {
          break;
        }
      } while ((this.localPath != null) && (this.localPath.equals(paramObject.localPath)));
      return false;
      return false;
    }
    
    public void ov(String paramString)
    {
      this.anj = paramString;
    }
    
    public String toString()
    {
      return " bid :" + this.bid + " localPath:" + this.localPath + "  ";
    }
  }
  
  public static class b
  {
    public npi b;
    public String bid;
    public String localPath;
    
    public b(String paramString, npi paramnpi, boolean paramBoolean)
    {
      if (paramString == null) {
        throw new IllegalArgumentException();
      }
      this.b = paramnpi;
      if (paramBoolean)
      {
        this.localPath = paramString;
        return;
      }
      this.bid = paramString;
    }
    
    public String getKey()
    {
      if (this.localPath == null) {
        return this.bid;
      }
      return this.localPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npl
 * JD-Core Version:    0.7.0.1
 */