import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class laq
{
  public static ProteusItemView a(VafContext paramVafContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = a(paramVafContext, paramString2, paramString1);
    paramString2 = paramVafContext.getViewFactory().inflate(paramVafContext, paramString1);
    paramString1 = localObject;
    if (paramString2 != null)
    {
      paramString2.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842544));
      paramString1 = new ProteusItemView(paramVafContext.getContext());
      paramString1.e(paramString2);
    }
    return paramString1;
  }
  
  public static ProteusItemView a(VafContext paramVafContext, String paramString, JSONObject paramJSONObject)
  {
    Object localObject = null;
    paramString = a(paramVafContext, paramJSONObject, paramString);
    paramJSONObject = paramVafContext.getViewFactory().inflate(paramVafContext, paramString);
    paramString = localObject;
    if (paramJSONObject != null)
    {
      paramJSONObject.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842544));
      paramString = new ProteusItemView(paramVafContext.getContext());
      paramString.e(paramJSONObject);
    }
    return paramString;
  }
  
  public static TemplateBean a(VafContext paramVafContext, String paramString1, String paramString2)
  {
    QLog.d("ProteusSupportUtilBase", 2, new Object[] { "getTemplateBean, styleID = ", paramString1, ", serviceID = ", paramString2 });
    npi localnpi = (npi)paramVafContext.getTemplateFactory();
    paramVafContext = localnpi;
    if (localnpi == null) {
      paramVafContext = npi.a(paramString2, true);
    }
    if (paramVafContext != null) {}
    try
    {
      paramVafContext = paramVafContext.getTemplateBean(new lku().a(paramString1).E());
      return paramVafContext;
    }
    catch (JSONException paramVafContext)
    {
      QLog.e("ProteusSupportUtilBase", 1, new Object[] { "getTemplateBean failed, styleID = ", paramString1, ", serviceID = ", paramString2, ", e = ", paramVafContext });
    }
    return null;
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, JSONObject paramJSONObject, String paramString)
  {
    QLog.d("ProteusSupportUtilBase", 2, new Object[] { "getTemplateBean, data = ", paramJSONObject, ", serviceID = ", paramString });
    npi localnpi = (npi)paramVafContext.getTemplateFactory();
    paramVafContext = localnpi;
    if (localnpi == null) {
      paramVafContext = npi.a(paramString, true);
    }
    if (paramVafContext != null) {}
    try
    {
      paramVafContext = paramVafContext.getTemplateBean(paramJSONObject);
      return paramVafContext;
    }
    catch (JSONException paramVafContext)
    {
      QLog.e("ProteusSupportUtilBase", 1, new Object[] { "getTemplateBean failed, data = ", paramJSONObject, ", serviceID = ", paramString, ", e = ", paramVafContext });
    }
    return null;
    return null;
  }
  
  public static void a(ProteusItemView paramProteusItemView, VafContext paramVafContext, String paramString1, String paramString2)
  {
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      QLog.d("ProteusSupportUtilBase", 1, new Object[] { "bindData proteusItemVIew is null, data = ", paramString2 });
      return;
    }
    TemplateBean localTemplateBean = paramProteusItemView.getTemplateBean();
    paramString1 = a(paramVafContext, d(paramString2), paramString1);
    if ((localTemplateBean != null) && (paramString1 != null) && (!paramString1.equals(localTemplateBean)))
    {
      paramString2 = paramVafContext.getViewFactory().inflate(paramVafContext, paramString1);
      if (paramString2 != null)
      {
        paramString2.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842544));
        paramProteusItemView.aMU();
        paramProteusItemView.e(paramString2);
      }
    }
    paramProteusItemView = paramProteusItemView.a();
    paramProteusItemView.setTag(2131376767, paramString1);
    if (paramString1 != null) {
      kvx.bindDynamicValueWithoutRecursion(paramProteusItemView, localTemplateBean, paramString1);
    }
    kvx.a(paramProteusItemView, paramVafContext, paramString1);
  }
  
  public static JSONObject d(String paramString)
  {
    localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString)) {
      return localJSONObject;
    }
    QLog.d("ProteusSupportUtilBase", 2, new Object[] { "getProteusDynamicData data = ", paramString });
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramString.opt(str);
        if (localObject != null) {
          localJSONObject.put(str, localObject);
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      QLog.d("ProteusSupportUtilBase", 2, "getProteusDynamicData e = ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     laq
 * JD-Core Version:    0.7.0.1
 */