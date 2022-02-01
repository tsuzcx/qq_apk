import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class tji
{
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    paramArticleInfo = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), "click_T");
    if (TextUtils.isEmpty(paramArticleInfo))
    {
      QLog.d("FastWebProteusReportUtils", 2, "customClickReport bigT is null");
      return;
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getName());
    paramFastWebArticleInfo = new pqg();
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.entrySet().iterator();
      while (paramTemplateBean.hasNext())
      {
        Object localObject = (Map.Entry)paramTemplateBean.next();
        paramViewBase = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (!TextUtils.equals(paramViewBase, "click_T")) {
          paramFastWebArticleInfo.b(paramViewBase, localObject.toString());
        }
      }
    }
    olh.a(null, "", paramArticleInfo, paramArticleInfo, 0, 0, "", "", "", paramFastWebArticleInfo.a(), false);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {
      QLog.d("FastWebProteusReportUtils", 2, "data is null!");
    }
    do
    {
      return;
      paramFastWebArticleInfo = paramTemplateBean.getDataAttribute(null);
      if ((paramFastWebArticleInfo == null) || (paramFastWebArticleInfo.isEmpty()))
      {
        QLog.d("FastWebProteusReportUtils", 2, "cellDataAttr null or empty!");
        return;
      }
      paramBaseArticleInfo = new pqg();
      paramTemplateBean = paramFastWebArticleInfo.entrySet().iterator();
      while (paramTemplateBean.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramTemplateBean.next();
        paramBaseArticleInfo.b((String)localEntry.getKey(), localEntry.getValue().toString());
      }
      olh.a(null, "", "0X800B303", "0X800B303", 0, 0, "", "", "", paramBaseArticleInfo.a(), false);
    } while (paramFastWebArticleInfo.get("expose_T") == null);
    paramFastWebArticleInfo = paramFastWebArticleInfo.get("expose_T").toString();
    olh.a(null, "", paramFastWebArticleInfo, paramFastWebArticleInfo, 0, 0, "", "", "", paramBaseArticleInfo.a(), false);
  }
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    paramArticleInfo = new HashMap();
    paramFastWebArticleInfo = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (paramFastWebArticleInfo != null) {
      paramArticleInfo.putAll(paramFastWebArticleInfo);
    }
    if (paramTemplateBean != null) {
      paramArticleInfo.putAll(paramTemplateBean);
    }
    paramFastWebArticleInfo = new pqg();
    paramArticleInfo = paramArticleInfo.entrySet().iterator();
    while (paramArticleInfo.hasNext())
    {
      paramTemplateBean = (Map.Entry)paramArticleInfo.next();
      paramFastWebArticleInfo.b((String)paramTemplateBean.getKey(), paramTemplateBean.getValue().toString());
    }
    olh.a(null, "", "0X800B304", "0X800B304", 0, 0, "", "", "", paramFastWebArticleInfo.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tji
 * JD-Core Version:    0.7.0.1
 */