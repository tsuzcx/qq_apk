import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class lpk
  implements lpi
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    lku locallku = new lku();
    String str2;
    String str1;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a != null) && (paramBaseArticleInfo.mSocialFeedInfo.a.a != null))
    {
      String str3 = "ReadInjoy_QA_NoImage_cell";
      String str4 = "";
      str2 = str4;
      str1 = str3;
      if (paramBaseArticleInfo.mSocialFeedInfo.a.iX != null)
      {
        str2 = str4;
        str1 = str3;
        if (paramBaseArticleInfo.mSocialFeedInfo.a.iX.size() > 0)
        {
          str2 = str4;
          str1 = str3;
          if (paramBaseArticleInfo.mSocialFeedInfo.a.a.cardStyle == 1)
          {
            str1 = "ReadInjoy_QA_Image_cell";
            str2 = ((String)paramBaseArticleInfo.mSocialFeedInfo.a.iX.get(0)).trim();
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        locallku.a(str1).c(paramBaseArticleInfo, str2).j(paramBaseArticleInfo).r(paramBaseArticleInfo);
        return locallku.E();
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        continue;
      }
      try
      {
        locallku.a("ReadInjoy_QA_NoImage_cell");
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    Object localObject = paramContainer.getVirtualView();
    if ((localObject == null) || (paramlie == null) || (paramlie.a() == null)) {}
    NativeTextImp localNativeTextImp;
    do
    {
      do
      {
        return;
        localObject = ((ViewBase)localObject).findViewBaseByName("id_summary");
      } while ((localObject == null) || (((ViewBase)localObject).getNativeView() == null) || (!(((ViewBase)localObject).getNativeView() instanceof NativeTextImp)));
      localNativeTextImp = (NativeTextImp)((ViewBase)localObject).getNativeView();
    } while (localNativeTextImp == null);
    boolean bool = lbz.a().aO(paramlie.a().mArticleID);
    localNativeTextImp.setTextSize(2, 15.0F);
    if (bool) {}
    for (localObject = "#999999";; localObject = "#4c4c4c")
    {
      localNativeTextImp.setTextColor(Color.parseColor((String)localObject));
      paramContainer = paramContainer.getContext().getResources().getDisplayMetrics();
      paramInt2 = 3;
      paramInt1 = paramInt2;
      if (paramContainer.widthPixels <= 720)
      {
        paramInt1 = paramInt2;
        if (!kxm.q(paramlie.a())) {
          paramInt1 = 2;
        }
      }
      localNativeTextImp.setMaxLines(paramInt1);
      localNativeTextImp.setLineSpacing(Utils.rp2px(2.0D), 1.0F);
      if (Build.VERSION.SDK_INT < 21) {
        break;
      }
      localNativeTextImp.setLetterSpacing(0.02F);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpk
 * JD-Core Version:    0.7.0.1
 */