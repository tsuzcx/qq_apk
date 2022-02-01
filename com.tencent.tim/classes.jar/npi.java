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

public class npi
  extends TemplateWithHotReloadFactory
{
  private static TemplateFactoryCache jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache = new TemplateFactoryCache();
  private lan jdField_a_of_type_Lan;
  private npl jdField_a_of_type_Npl = new npl();
  private String anh;
  private String bid = "-1";
  
  public static npi a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      npt.a(paramString, true);
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.getAutoCreate(BaseApplicationImpl.getContext(), paramString);
    }
    paramString = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.get(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return null;
  }
  
  private void aZU()
  {
    Iterator localIterator = this.nameTemplateMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TemplateBean localTemplateBean = (TemplateBean)((Map.Entry)localIterator.next()).getValue();
      localTemplateBean.setId(this.templateId.get());
      localTemplateBean.setStyleSource(this.bid);
    }
  }
  
  public static void reset()
  {
    QLog.d("TemplateFactory", 2, "reset: ");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactoryCache.reset();
  }
  
  public lan a()
  {
    return this.jdField_a_of_type_Lan;
  }
  
  public npi a()
  {
    npi localnpi = new npi();
    localnpi.templateId = new AtomicInteger(getTemplateId());
    localnpi.or(this.bid);
    localnpi.os(this.anh);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.nameTemplateMap);
    localnpi.nameTemplateMap = localHashMap;
    return localnpi;
  }
  
  public void a(npv.a parama)
  {
    if (parama == null)
    {
      QLog.d("TemplateFactory", 2, "updateProteusConfig, configData is null.");
      return;
    }
    this.jdField_a_of_type_Lan = parama.jdField_a_of_type_Lan;
  }
  
  public boolean a(TemplateBean paramTemplateBean)
  {
    boolean bool = false;
    if (paramTemplateBean == null) {
      return true;
    }
    npt localnpt = npt.a(this.anh, false);
    if ((localnpt != null) && (localnpt.getTemplate(paramTemplateBean.getStyleName()) != null)) {
      return localnpt.a(paramTemplateBean);
    }
    if ((paramTemplateBean.getId() != getTemplateId()) || (!aZ().equals(paramTemplateBean.getStyleSource()))) {
      bool = true;
    }
    return bool;
  }
  
  public String aZ()
  {
    return this.bid;
  }
  
  public int getColumnCount()
  {
    String str;
    if (this.jdField_a_of_type_Lan != null)
    {
      str = this.jdField_a_of_type_Lan.eF("column_count");
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
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    Map localMap = super.getNameTemplateMap();
    npt localnpt = npt.a(this.anh, false);
    if (localnpt != null) {
      localMap.putAll(localnpt.getNameTemplateMap());
    }
    return localMap;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    Object localObject1 = npt.a(this.anh, false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((npt)localObject1).getTemplate(paramString);
      if (localObject2 == null) {}
    }
    do
    {
      return localObject2;
      localObject2 = super.getTemplate(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject3 = this.jdField_a_of_type_Npl.a(this.anh);
        localObject1 = localObject2;
        if (((npl.a)localObject3).anj != null)
        {
          localObject3 = a(((npl.a)localObject3).anj, true);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((npi)localObject3).getTemplate(paramString);
          }
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    obr.M(this.bid, this.anh, paramString);
    return localObject1;
  }
  
  public boolean isUsable()
  {
    return getTemplateId() > 0;
  }
  
  public void onAddTemplate(String paramString, TemplateBean paramTemplateBean)
  {
    paramTemplateBean.setStyleSource(this.bid);
  }
  
  public void or(String paramString)
  {
    this.bid = paramString;
    aZU();
  }
  
  public void os(String paramString)
  {
    this.anh = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.templateId.set(paramInt);
    aZU();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serviceId: " + this.anh + " bid: " + this.bid + "\n");
    Iterator localIterator = getNameTemplateMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("" + (String)localEntry.getKey() + " : " + localEntry.getValue() + "\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npi
 * JD-Core Version:    0.7.0.1
 */