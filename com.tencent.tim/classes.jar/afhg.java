import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afhg
  implements View.OnClickListener
{
  afhg(afhf paramafhf, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.an.dismiss();
    afhu localafhu = (afhu)this.this$0.mApp.getManager(149);
    CustomEmotionData localCustomEmotionData = this.this$0.c;
    afpg localafpg = new afpg();
    localafpg.type = 4;
    localafpg.path = localafhu.a(localCustomEmotionData);
    localafpg.src_type = 2;
    localafpg.eId = localCustomEmotionData.eId;
    localafpg.url = localCustomEmotionData.url;
    localafpg.bDZ = localCustomEmotionData.RomaingType;
    localafpg.emoId = localCustomEmotionData.emoId;
    localafpg.bnT = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.this$0.mContext, localafpg, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhg
 * JD-Core Version:    0.7.0.1
 */