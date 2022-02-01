import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class tuk
  implements qdy
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pzh.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    boolean bool = true;
    paramContainer = paramContainer.getVirtualView();
    ViewBase localViewBase = paramContainer.findViewBaseByName("id_large_video_icon");
    if (localViewBase != null) {
      localViewBase.setVisibility(0);
    }
    if (twr.f(parampvc.a()))
    {
      parampvc = paramContainer.findViewBaseByName("id_video_bg");
      if (parampvc != null) {
        parampvc.setVisibility(8);
      }
      paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
      if (paramContainer != null) {
        paramContainer.setVisibility(8);
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(8);
      }
    }
    label241:
    do
    {
      do
      {
        return;
      } while (!twr.d(parampvc.a()));
      if (Aladdin.getConfig(318).getIntegerFromString("small_game_large_card_new_style", 0) == 1) {}
      for (;;)
      {
        QLog.d("AdQQMiniGameVideoProteusItem", 2, "small game card is new style:" + bool);
        if ((!bool) || (parampvc.a() == null) || (parampvc.a().mSmallMiniGameInfo == null) || (TextUtils.isEmpty(parampvc.a().mSmallMiniGameInfo.d))) {
          break label241;
        }
        if (localViewBase != null) {
          localViewBase.setVisibility(8);
        }
        parampvc = paramContainer.findViewBaseByName("id_video_bg");
        if (parampvc != null) {
          parampvc.setVisibility(0);
        }
        paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
        if (paramContainer == null) {
          break;
        }
        paramContainer.setVisibility(0);
        return;
        bool = false;
      }
      parampvc = paramContainer.findViewBaseByName("id_video_bg");
      if (parampvc != null) {
        parampvc.setVisibility(8);
      }
      paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
    } while (paramContainer == null);
    paramContainer.setVisibility(8);
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuk
 * JD-Core Version:    0.7.0.1
 */