import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateWithHotReloadFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class tmh
  extends TemplateWithHotReloadFactory
{
  private static TemplateFactoryCache jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache = new TemplateFactoryCache();
  private String jdField_a_of_type_JavaLangString = "-1";
  private ptm jdField_a_of_type_Ptm;
  private tmk jdField_a_of_type_Tmk = new tmk();
  private String b;
  
  public static tmh a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      tmw.a(paramString, true);
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.getAutoCreate(BaseApplicationImpl.getContext(), paramString);
    }
    paramString = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.get(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return null;
  }
  
  public static void a()
  {
    QLog.d("TemplateFactory", 1, "reset: ");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.reset();
  }
  
  private void b()
  {
    Iterator localIterator = this.nameTemplateMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TemplateBean localTemplateBean = (TemplateBean)((Map.Entry)localIterator.next()).getValue();
      localTemplateBean.setId(this.templateId.get());
      localTemplateBean.setStyleSource(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public static void c(String paramString)
  {
    tmm localtmm = tmk.a().a(BaseApplicationImpl.getContext(), paramString);
    localtmm.a.b(paramString);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.put(paramString, localtmm);
  }
  
  public int a()
  {
    String str;
    if (this.jdField_a_of_type_Ptm != null)
    {
      str = this.jdField_a_of_type_Ptm.a("column_count");
      if (str == null) {}
    }
    for (;;)
    {
      try
      {
        i = Integer.valueOf(str).intValue();
        QLog.d("TemplateFactory", 2, new Object[] { "getColumnCount = ", Integer.valueOf(i) });
        if (i <= 0) {
          break;
        }
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("TemplateFactory", 2, new Object[] { "getColumnCount e = ", localNumberFormatException, ", s = ", str });
      }
      int i = 1;
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ptm a()
  {
    return this.jdField_a_of_type_Ptm;
  }
  
  public tmh a()
  {
    tmh localtmh = new tmh();
    localtmh.templateId = new AtomicInteger(getTemplateId());
    localtmh.a(this.jdField_a_of_type_JavaLangString);
    localtmh.b(this.b);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.nameTemplateMap);
    localtmh.nameTemplateMap = localHashMap;
    return localtmh;
  }
  
  public void a(int paramInt)
  {
    this.templateId.set(paramInt);
    b();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    b();
  }
  
  public void a(tna paramtna)
  {
    if (paramtna == null)
    {
      QLog.d("TemplateFactory", 2, "updateProteusConfig, configData is null.");
      return;
    }
    this.jdField_a_of_type_Ptm = paramtna.jdField_a_of_type_Ptm;
  }
  
  public boolean a(TemplateBean paramTemplateBean)
  {
    boolean bool = false;
    if (paramTemplateBean == null) {
      return true;
    }
    tmw localtmw = tmw.a(this.b, false);
    if ((localtmw != null) && (localtmw.getTemplate(paramTemplateBean.getStyleName()) != null)) {
      return localtmw.a(paramTemplateBean);
    }
    if ((paramTemplateBean.getId() != getTemplateId()) || (!a().equals(paramTemplateBean.getStyleSource()))) {
      bool = true;
    }
    return bool;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    Map localMap = super.getNameTemplateMap();
    tmw localtmw = tmw.a(this.b, false);
    if (localtmw != null) {
      localMap.putAll(localtmw.getNameTemplateMap());
    }
    return localMap;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    Object localObject1 = tmw.a(this.b, false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((tmw)localObject1).getTemplate(paramString);
      if (localObject2 == null) {}
    }
    do
    {
      return localObject2;
      localObject2 = super.getTemplate(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject3 = this.jdField_a_of_type_Tmk.a(this.b);
        localObject1 = localObject2;
        if (((tml)localObject3).d != null)
        {
          localObject3 = a(((tml)localObject3).d, true);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((tmh)localObject3).getTemplate(paramString);
          }
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    usp.a(this.jdField_a_of_type_JavaLangString, this.b, paramString);
    return localObject1;
  }
  
  public boolean isUsable()
  {
    return getTemplateId() > 0;
  }
  
  public void onAddTemplate(String paramString, TemplateBean paramTemplateBean)
  {
    paramTemplateBean.setStyleSource(this.jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serviceId: " + this.b + " bid: " + this.jdField_a_of_type_JavaLangString + "\n");
    Iterator localIterator = getNameTemplateMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("" + (String)localEntry.getKey() + " : " + localEntry.getValue() + "\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmh
 * JD-Core Version:    0.7.0.1
 */