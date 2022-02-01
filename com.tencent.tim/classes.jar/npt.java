import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactoryCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class npt
  extends npi
{
  private static RealTimeTemplateFactoryCache a = new RealTimeTemplateFactoryCache();
  private Map<String, npt.a> eN = new ConcurrentHashMap();
  
  public npt()
  {
    this.nameTemplateMap = new ConcurrentHashMap();
  }
  
  public static npt a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.getAutoCreate(BaseApplicationImpl.getContext(), paramString);
    }
    return a.get(paramString);
  }
  
  public static void reset()
  {
    QLog.d("RealTimeTemplateFactory", 2, "reset: ");
    a.clear();
  }
  
  public void I(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    paramString2 = new npt.a(paramString1, paramString2, paramString3);
    this.eN.put(paramString1, paramString2);
  }
  
  public Map<String, String> J()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.eN.values().iterator();
    while (localIterator.hasNext())
    {
      npt.a locala = (npt.a)localIterator.next();
      localHashMap.put(locala.ano, locala.version);
    }
    return localHashMap;
  }
  
  public boolean a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {}
    while ((paramTemplateBean.getId() != getTemplateId()) || (!aZ().equals(paramTemplateBean.getStyleSource()))) {
      return true;
    }
    return false;
  }
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.nameTemplateMap);
    return localArrayMap;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (TemplateBean)this.nameTemplateMap.get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.clone()) {
      return paramString;
    }
  }
  
  public void ox(String paramString)
  {
    paramString = (npt.a)this.eN.remove(paramString);
    if (paramString != null)
    {
      paramString = (TemplateBean)this.nameTemplateMap.remove(paramString.styleName);
      QLog.d("RealTimeTemplateFactory", 1, "deleteStyle: " + paramString);
    }
  }
  
  static class a
  {
    String ano;
    String styleName;
    String version;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.ano = paramString1;
      this.version = paramString2;
      this.styleName = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npt
 * JD-Core Version:    0.7.0.1
 */