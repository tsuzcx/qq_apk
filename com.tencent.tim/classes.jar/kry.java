import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class kry
{
  private static int aLr = 2147483647;
  private static String abT = "0";
  private final int aLp = 9;
  private int aLq = 9;
  private final Map<String, Integer> dJ = new ConcurrentHashMap();
  private BaseTemplateFactory templateFactory;
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, kte paramkte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramkte == null)) {
      return;
    }
    try
    {
      kvx.bindDynamicValueWithoutRecursion(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = kqy.a(paramkte, paramVafContext, (ktm)paramkte.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.bindData(paramVafContext);
          kqy.a(paramContainer, paramkte, (ktm)paramkte.getItem(paramInt1));
        }
      }
      auvk.traceEnd();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("DynamicCommentProteusHelper", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  public static boolean b(ktm paramktm)
  {
    return (paramktm != null) && (paramktm.a != null) && (paramktm.a.isDynamicComment());
  }
  
  private void mu(String paramString)
  {
    if ((!this.dJ.containsKey(paramString)) && (this.aLq < aLr - 1))
    {
      this.dJ.put(paramString, Integer.valueOf(this.aLq));
      this.aLq += 1;
      QLog.d("DynamicCommentProteusHelper", 2, "addViewType : " + paramString + " TYPE_DYNAMIC_END: " + this.aLq + "  TYPE_DYNAMIC_MAX_END : " + aLr);
    }
  }
  
  public int a(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null)) {}
    do
    {
      return 8;
      paramktm = paramktm.a.styleData;
    } while (TextUtils.isEmpty(paramktm));
    try
    {
      paramktm = new JSONObject(paramktm).optString("style_ID");
      mu(paramktm);
      int i = ((Integer)this.dJ.get(paramktm)).intValue();
      return i;
    }
    catch (JSONException paramktm)
    {
      paramktm.printStackTrace();
    }
    return -1;
  }
  
  public TemplateBean a(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if (this.templateFactory != null)
        {
          paramktm = this.templateFactory.getTemplateBean(new JSONObject(paramktm.a.styleData));
          return paramktm;
        }
      }
      catch (JSONException paramktm)
      {
        paramktm.printStackTrace();
      }
    }
    return null;
  }
  
  public void b(VafContext paramVafContext)
  {
    if (paramVafContext == null) {
      return;
    }
    Object localObject = Aladdin.getConfig(228);
    if (localObject != null)
    {
      abT = ((AladdinConfig)localObject).getString("comment_feeds", "0");
      localObject = ((AladdinConfig)localObject).getString("comment_feeds_cdn_url", "");
      awit.jD("comment_proteus_offline_bid", abT);
      QLog.i("DynamicCommentProteusHelper", 1, "[init], offline comment pts bid = " + abT + ", cdnUrl = " + (String)localObject);
      npx.bO(abT, (String)localObject);
    }
    this.templateFactory = paramVafContext.getTemplateFactory();
    int j = paramVafContext.getTemplateFactory().size();
    if ((this.aLq < j + 9) && (j > 0) && (this.aLq < aLr))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      int i = this.aLq;
      paramVafContext = paramVafContext.iterator();
      label160:
      if (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (this.dJ.containsKey(localObject)) {
          break label325;
        }
        this.dJ.put(localObject, Integer.valueOf(i));
        i += 1;
      }
    }
    label325:
    for (;;)
    {
      break label160;
      this.aLq = (j + 9);
      if (aLr == 2147483647) {
        aLr = this.aLq + 30;
      }
      if (this.aLq > aLr) {
        this.aLq = aLr;
      }
      QLog.d("DynamicCommentProteusHelper", 1, "init: commentTemplateCount : " + j + " TYPE_DYNAMIC_END : " + this.aLq + " max : " + aLr);
      if (aLr != 2147483647) {
        break;
      }
      aLr = 109;
      return;
    }
  }
  
  public int nD()
  {
    if (aLr == 2147483647) {
      return this.aLq - 8;
    }
    return aLr - 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kry
 * JD-Core Version:    0.7.0.1
 */