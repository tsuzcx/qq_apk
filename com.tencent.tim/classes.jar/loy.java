import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class loy
  implements ViewBase.OnClickListener
{
  loy(lot paramlot, ViewBase paramViewBase, lie paramlie) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    paramViewBase = (lso)this.e.getParent().findViewBaseByName("id_pgc_short_content_video_view");
    Object localObject = this.b.a();
    if (((ArticleInfo)localObject).mProteusTemplateBean == null) {
      QLog.e("PgcShortContentProteusItem", 1, "articleInfo.mProteusTemplateBean is null");
    }
    ViewBase localViewBase;
    do
    {
      return;
      localObject = ((ArticleInfo)localObject).mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
      localViewBase = this.e.getParent().findViewBaseByName("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localObject == null));
    if (!"video_audio_mute".equals(((ViewBean)localObject).valueBean.dynamicValue.get("loadImageWithPath:")))
    {
      paramViewBase.a().setMute(bool);
      if (!bool) {
        break label140;
      }
    }
    label140:
    for (paramViewBase = "video_audio_mute";; paramViewBase = "video_audio_speak")
    {
      ((ViewBean)localObject).putMapValue("pgc_video_content_audio_icon", paramViewBase);
      localViewBase.bindDynamicValue((ViewBean)localObject);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     loy
 * JD-Core Version:    0.7.0.1
 */