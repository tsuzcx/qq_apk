import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class lrj
{
  private static String TAG = "DynamicItemViewHelper";
  private static int aLr = 2147483647;
  private lno a;
  private final int aLp = 143;
  private int aLq = 143;
  private final Map<String, Integer> dJ = new ConcurrentHashMap();
  private BaseTemplateFactory templateFactory;
  
  public static boolean C(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 29) {
      return false;
    }
    return true;
  }
  
  private static ProteusItemView a(ProteusItemView paramProteusItemView, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    Container localContainer = paramVafContext.getViewFactory().inflate(paramVafContext, paramTemplateBean);
    paramTemplateBean = paramProteusItemView;
    if (localContainer != null)
    {
      paramTemplateBean = paramProteusItemView;
      if (paramProteusItemView == null) {
        paramTemplateBean = new ProteusItemView(paramVafContext.getContext());
      }
      paramTemplateBean.e(localContainer);
    }
    return paramTemplateBean;
  }
  
  private TemplateBean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getTemplateBean : " + paramBaseArticleInfo);
    }
    if (this.templateFactory == null) {
      paramBaseArticleInfo = null;
    }
    for (;;)
    {
      return paramBaseArticleInfo;
      try
      {
        if ((paramBaseArticleInfo.mProteusTemplateBean != null) && (!((npi)this.templateFactory).a(paramBaseArticleInfo.mProteusTemplateBean))) {
          return paramBaseArticleInfo.mProteusTemplateBean;
        }
        if (this.a == null) {
          return null;
        }
        JSONObject localJSONObject = this.a.a(142, paramBaseArticleInfo);
        localTemplateBean = this.a.a(142, localJSONObject);
        try
        {
          paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
          paramBaseArticleInfo = localTemplateBean;
          if (localTemplateBean != null)
          {
            paramBaseArticleInfo = localTemplateBean;
            if (localTemplateBean.getViewBean() != null)
            {
              paramBaseArticleInfo = localTemplateBean;
              if (localJSONObject != null)
              {
                paramBaseArticleInfo = localTemplateBean;
                if (localJSONObject.has("report_feeds_type"))
                {
                  localTemplateBean.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
                  return localTemplateBean;
                }
              }
            }
          }
        }
        catch (JSONException paramBaseArticleInfo) {}
      }
      catch (JSONException paramBaseArticleInfo)
      {
        for (;;)
        {
          TemplateBean localTemplateBean = null;
        }
      }
    }
    QLog.d(TAG, 1, paramBaseArticleInfo, new Object[] { "getView" });
    return localTemplateBean;
  }
  
  private static void a(ProteusItemView paramProteusItemView)
  {
    QLog.d(TAG, 1, "setGone");
    if (paramProteusItemView == null)
    {
      QLog.d(TAG, 1, "setGone proteusItemView == null");
      return;
    }
    setViewGone(paramProteusItemView.a());
    setViewGone(paramProteusItemView);
  }
  
  private void a(lie paramlie, VafContext paramVafContext)
  {
    paramVafContext = paramlie.b();
    if (paramVafContext != null)
    {
      paramlie = paramVafContext.c(paramlie.getPosition() + 1);
      if ((paramlie != null) && (paramlie.mProteusTemplateBean == null)) {
        paramlie.mProteusTemplateBean = a(paramlie);
      }
    }
  }
  
  private static void b(ProteusItemView paramProteusItemView)
  {
    if (paramProteusItemView == null) {
      QLog.d(TAG, 1, "setVisible proteusItemView == null");
    }
    do
    {
      return;
      Container localContainer = paramProteusItemView.a();
      if ((localContainer != null) && (localContainer.getVisibility() == 8))
      {
        QLog.d(TAG, 1, "container.getVisibility() == View.GONE");
        localContainer.setVisibility(0);
        wja.a(TAG, "", new IllegalArgumentException("container.getVisibility() == View.GONE"));
      }
    } while (paramProteusItemView.getVisibility() != 8);
    QLog.d(TAG, 1, "proteusItemView.getVisibility() == View.GONE");
    paramProteusItemView.setVisibility(0);
    wja.a(TAG, "", new IllegalArgumentException("proteusItemView.getVisibility() == View.GONE"));
  }
  
  public static int d(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = paramTemplateBean.getDataAttribute(null, "feeds_type");
        if (localObject != null)
        {
          localObject = localObject.toString();
          if (localObject == null)
          {
            QLog.d(TAG, 1, "getReportType: " + paramTemplateBean);
            return -1024;
          }
        }
        else
        {
          localObject = (String)paramTemplateBean.getViewBean().getDynamicValue("report_feeds_type");
          continue;
        }
        i = Integer.valueOf((String)localObject).intValue();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        QLog.d(TAG, 1, paramTemplateBean, new Object[] { "getReportType" });
      }
      int i = -1024;
    }
  }
  
  private void mu(String paramString)
  {
    if ((!this.dJ.containsKey(paramString)) && (this.aLq < aLr - 1))
    {
      this.dJ.put(paramString, Integer.valueOf(this.aLq));
      this.aLq += 1;
      QLog.d(TAG, 2, "addViewType : " + paramString + " TYPE_DYNAMIC_END: " + this.aLq + "  TYPE_DYNAMIC_MAX_END : " + aLr);
    }
  }
  
  private static void setViewGone(View paramView)
  {
    if (paramView != null)
    {
      paramView.setVisibility(8);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = 0;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public boolean D(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (C(paramArticleInfo))
    {
      bool1 = bool2;
      if (f(paramArticleInfo) == 142) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject2 = null;
    auvk.traceBegin("DynamicPTS.getView");
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseArticleInfo != null)
        {
          localObject1 = localObject2;
          QLog.d(TAG, 1, " " + paramBaseArticleInfo.mArticleID + ":" + paramBaseArticleInfo.proteusItemsData);
        }
        localObject1 = localObject2;
        localObject3 = a(paramBaseArticleInfo);
        localObject1 = localObject2;
        localObject2 = a(null, paramVafContext, (TemplateBean)localObject3);
        localObject1 = localObject2;
        long l2 = System.currentTimeMillis();
        localObject1 = localObject2;
        String str = TAG;
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject2;
        localObject3 = ((TemplateBean)localObject3).getStyleName();
        localObject1 = localObject2;
        nxr.a(str, (String)localObject3, "DynamicPTS.getView", l2 - l1);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject3;
        QLog.e(TAG, 1, localException, new Object[] { "getView" });
        wja.a(TAG, "getView:", new IllegalArgumentException(paramBaseArticleInfo.proteusItemsData, localException));
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new ProteusItemView(paramVafContext.getContext());
        a((ProteusItemView)localObject2);
      }
      if (paramInt == 142)
      {
        QLog.e(TAG, 1, "getView gone : " + paramBaseArticleInfo);
        a((ProteusItemView)localObject2);
      }
      auvk.traceEnd();
      return localObject2;
      localObject3 = "";
    }
  }
  
  /* Error */
  public ProteusItemView a(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 345
    //   3: iconst_1
    //   4: invokestatic 348	npi:a	(Ljava/lang/String;Z)Lnpi;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +64 -> 73
    //   12: aload_3
    //   13: aload_2
    //   14: invokevirtual 352	npi:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   17: astore_2
    //   18: aload_1
    //   19: invokevirtual 53	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getViewFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/ViewFactory;
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 59	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/ViewFactory:inflate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +70 -> 101
    //   34: new 61	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getContext	()Landroid/content/Context;
    //   42: invokespecial 68	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView:<init>	(Landroid/content/Context;)V
    //   45: astore_3
    //   46: aload_3
    //   47: aload 4
    //   49: invokevirtual 72	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView:e	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;)V
    //   52: aload 4
    //   54: aconst_null
    //   55: aload_2
    //   56: invokestatic 358	kvx:bindDynamicValueWithoutRecursion	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)V
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 362	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView:setTemplateBean	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)V
    //   64: aload 4
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic 365	kvx:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)V
    //   71: aload_3
    //   72: areturn
    //   73: aconst_null
    //   74: astore_2
    //   75: goto -57 -> 18
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: getstatic 23	lrj:TAG	Ljava/lang/String;
    //   84: iconst_1
    //   85: aload_2
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: areturn
    //   95: astore_2
    //   96: aload_3
    //   97: astore_1
    //   98: goto -17 -> 81
    //   101: aconst_null
    //   102: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	lrj
    //   0	103	1	paramVafContext	VafContext
    //   0	103	2	paramJSONObject	JSONObject
    //   7	90	3	localObject	Object
    //   27	38	4	localContainer	Container
    // Exception table:
    //   from	to	target	type
    //   0	8	78	java/lang/Exception
    //   12	18	78	java/lang/Exception
    //   18	29	78	java/lang/Exception
    //   34	46	78	java/lang/Exception
    //   46	71	95	java/lang/Exception
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, aqdf paramaqdf, ndi paramndi, lie paramlie, int paramInt2)
  {
    auvk.traceBegin("DynamicPTS.bindData");
    long l1 = System.currentTimeMillis();
    Object localObject2 = paramProteusItemView.getTemplateBean();
    TemplateBean localTemplateBean = a(paramBaseArticleInfo);
    if (paramProteusItemView.a() == null)
    {
      auvk.traceEnd();
      QLog.d(TAG, 1, "proteusItemView.getContainer == null bindData : " + paramBaseArticleInfo + " adapterViewType : " + paramInt1);
      a(paramProteusItemView, paramVafContext, localTemplateBean);
      auvk.traceEnd();
      return;
    }
    if (paramInt1 == 142)
    {
      a(paramProteusItemView);
      auvk.traceEnd();
      return;
    }
    b(paramProteusItemView);
    if (lrl.shouldLog()) {
      lrl.d(TAG, "[bindData] " + paramBaseArticleInfo + " adapterViewType: " + paramInt1);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localTemplateBean != null)
      {
        localObject1 = localObject2;
        if (!localTemplateBean.equals(localObject2))
        {
          auvk.traceBegin("DynamicPTS.bindData.reuseView");
          localObject1 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
          if (localObject1 != null)
          {
            ((Container)localObject1).setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842544));
            paramProteusItemView.aMU();
            paramProteusItemView.e((Container)localObject1);
            kvx.bindDynamicValueWithoutRecursion((Container)localObject1, null, localTemplateBean);
          }
          paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
          localObject1 = null;
          auvk.traceEnd();
        }
      }
    }
    localObject2 = paramProteusItemView.a();
    paramProteusItemView.setModel(paramlie, paramndi.a());
    paramProteusItemView.setTemplateBean(localTemplateBean);
    if (localTemplateBean != null)
    {
      auvk.traceBegin("DynamicPTS.bindData.compareWithOldTemplateBean");
      kvx.bindDynamicValueWithoutRecursion((Container)localObject2, (TemplateBean)localObject1, localTemplateBean);
      auvk.traceEnd();
    }
    auvk.traceBegin("DynamicPTS.bindData.bindView");
    this.a.a(paramInt1, (Container)localObject2, paramlie, paramInt2);
    auvk.traceEnd();
    kvx.a(paramInt1, paramProteusItemView, paramVafContext, paramaqdf, paramndi, paramlie, paramBaseArticleInfo);
    a(paramlie, paramVafContext);
    kvx.a((Container)localObject2, paramlie, localTemplateBean);
    long l2 = System.currentTimeMillis();
    paramBaseArticleInfo = TAG;
    if (localTemplateBean != null) {}
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      nxr.a(paramBaseArticleInfo, paramProteusItemView, "DynamicPTS.bindData", l2 - l1);
      auvk.traceEnd();
      return;
    }
  }
  
  public void b(VafContext paramVafContext)
  {
    this.templateFactory = paramVafContext.getTemplateFactory();
    this.a = new lno(paramVafContext);
    int j = paramVafContext.getTemplateFactory().size();
    if ((this.aLq < j + 143) && (j > 0) && (this.aLq < aLr))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      int i = this.aLq;
      paramVafContext = paramVafContext.iterator();
      if (paramVafContext.hasNext())
      {
        String str = (String)paramVafContext.next();
        if (this.dJ.containsKey(str)) {
          break label247;
        }
        this.dJ.put(str, Integer.valueOf(i));
        i += 1;
      }
    }
    label247:
    for (;;)
    {
      break;
      this.aLq = (j + 143);
      if (aLr == 2147483647) {
        aLr = this.aLq + 30;
      }
      if (this.aLq > aLr) {
        this.aLq = aLr;
      }
      QLog.d(TAG, 1, "init: templateCount : " + j + " TYPE_DYNAMIC_END : " + this.aLq + " max : " + aLr);
      if (aLr == 2147483647) {
        aLr = 243;
      }
      return;
    }
  }
  
  public boolean dx(int paramInt)
  {
    return (paramInt >= 142) && (paramInt < this.aLq);
  }
  
  public int f(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 142;
    }
    TemplateBean localTemplateBean = a(paramArticleInfo);
    Integer localInteger = null;
    if (localTemplateBean != null)
    {
      mu(localTemplateBean.getStyleName());
      localInteger = (Integer)this.dJ.get(localTemplateBean.getStyleName());
    }
    if (localInteger == null)
    {
      QLog.d(TAG, 2, "getType: templateBean : " + localTemplateBean + " data: " + paramArticleInfo.proteusItemsData);
      return 142;
    }
    if ((localInteger.intValue() < 142) || (localInteger.intValue() >= this.aLq)) {
      return 142;
    }
    return localInteger.intValue();
  }
  
  public String l(BaseArticleInfo paramBaseArticleInfo)
  {
    paramBaseArticleInfo = a(paramBaseArticleInfo);
    if (paramBaseArticleInfo != null) {
      return paramBaseArticleInfo.getStyleName();
    }
    return "";
  }
  
  public int oL()
  {
    if (aLr == 2147483647) {
      return this.aLq - 142 + 1;
    }
    return aLr - 142 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrj
 * JD-Core Version:    0.7.0.1
 */