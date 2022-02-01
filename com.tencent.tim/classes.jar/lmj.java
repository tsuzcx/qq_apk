import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class lmj
  implements lpi
{
  private void a(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    if (b(paramContext, paramBaseArticleInfo)) {}
    try
    {
      paramContext = muj.a((Activity)paramContext, paramBaseArticleInfo.mVideoJsonWidth, paramBaseArticleInfo.mVideoJsonHeight);
      paramBaseArticleInfo.setFirstFrameWidth(((Integer)paramContext.first).intValue());
      paramBaseArticleInfo.setFirstFrameHeight(((Integer)paramContext.second).intValue());
      paramContext = paramBaseArticleInfo.getFirstFrameUrl();
      noz localnoz = new noz();
      localnoz.url = paramContext;
      localnoz.reqHeight = paramBaseArticleInfo.getFirstFrameHeight();
      localnoz.reqWidth = paramBaseArticleInfo.getFirstFrameWidth();
      localnoz.isPreload = true;
      noy.a().a(localnoz, new lmk(this, paramBaseArticleInfo, paramContext));
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.e("BigImageVideoProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
  }
  
  private static boolean b(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool1 = true;
    if ((paramBaseArticleInfo == null) || (!(paramContext instanceof Activity))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = kzc.b(3, paramBaseArticleInfo.mVideoJsonWidth, paramBaseArticleInfo.mVideoJsonHeight, paramBaseArticleInfo.getVideoDuration());
      if (Aladdin.getConfig(312).getIntegerFromString("first_frame_preload_disable", 0) == 0) {}
      for (int i = 1; (paramBaseArticleInfo.getFirstFrameUrl() == null) || (paramBaseArticleInfo.mChannelID != 0L) || (bool2) || (i == 0); i = 0) {
        return false;
      }
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    return llk.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((NetworkState.isWifiConn()) || (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) == 1))
    {
      localObject = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject != null) {
        ((ViewBase)localObject).setVisibility(0);
      }
      localObject = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject != null) {
        ((ViewBase)localObject).setVisibility(8);
      }
      kwz.a(false, localViewBase, null);
      if (paramlie != null)
      {
        localObject = paramlie.a();
        if ((localObject != null) && (((BaseArticleInfo)localObject).isAccountShown)) {
          lrh.b(paramContainer, paramlie);
        }
      }
      localObject = paramlie.a();
      lri.a((BaseArticleInfo)localObject, paramContainer, paramlie);
      a((BaseArticleInfo)localObject, paramContainer.getContext());
      return;
    }
    Object localObject = localViewBase.findViewBaseByName("id_large_video_icon");
    if (localObject != null) {
      ((ViewBase)localObject).setVisibility(8);
    }
    localObject = localViewBase.findViewBaseByName("id_video_bg");
    if (localObject != null) {
      ((ViewBase)localObject).setVisibility(0);
    }
    localObject = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
    if (localObject != null)
    {
      if (aqux.Mv() == 1) {
        label197:
        ((NativeText)localObject).setText("");
      }
    }
    else {
      if (paramlie == null) {
        break label247;
      }
    }
    label247:
    for (localObject = paramlie.a();; localObject = null)
    {
      kwz.a(localViewBase, (BaseArticleInfo)localObject);
      break;
      if ((paramlie == null) || (paramlie.a().mXGFileSize <= 0L)) {
        break label197;
      }
      break label197;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    paramContainer = paramlie.a();
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new lml(this, paramContainer, paramlie, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmj
 * JD-Core Version:    0.7.0.1
 */