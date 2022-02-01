import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class iyx
  implements View.OnClickListener
{
  public iyx(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    EffectSettingUi.a(this.a.mApp, -1007L);
    this.a.G(-1007L, true);
    ixo.asa();
    if (this.a.mContext != null)
    {
      AVActivity localAVActivity = (AVActivity)this.a.mContext.get();
      localAVActivity.a.a(-1007L, localAVActivity, 99, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyx
 * JD-Core Version:    0.7.0.1
 */