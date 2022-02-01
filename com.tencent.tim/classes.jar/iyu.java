import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class iyu
  implements View.OnClickListener
{
  public iyu(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.hG();
    int k = paramView.getId();
    Object localObject = paramView.getTag(2131379197);
    if ((localObject != null) && ((localObject instanceof Boolean))) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      int m = this.a.avL;
      bool = this.a.a(l, k, bool);
      int i;
      int j;
      if (k == 4)
      {
        i = 1;
        j = i;
        if (i != 0)
        {
          localObject = ((AVActivity)this.a.getContext()).a;
          if ((localObject != null) && ((localObject == null) || (((EffectFilterPanel)localObject).getVisibility() != 8))) {
            break label344;
          }
          j = 1;
        }
        label117:
        if ((bool) && ((m != k) || (j != 0))) {
          this.a.mApp.l(new Object[] { Integer.valueOf(6105), Integer.valueOf(k), Long.valueOf(l) });
        }
        if (bool)
        {
          localObject = VideoController.a().a((Context)this.a.mContext.get());
          if (localObject != null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d(this.a.TAG, 1, "onShow clear state");
            }
            ((iov)localObject).ln(k);
          }
        }
        this.a.mApp.l(new Object[] { Integer.valueOf(165), Integer.valueOf(1) });
        if (m != k)
        {
          if (k != 1) {
            break label349;
          }
          ixo.b((Context)this.a.mContext.get(), this.a.mApp.b().b().relationType, this.a.mApp.b().b().amI, this.a.bL(), bool);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 0;
        break;
        label344:
        j = 0;
        break label117;
        label349:
        if (k == 2)
        {
          ixo.a(this.a.mApp, this.a.bL(), bool);
          if (this.a.a != null) {
            this.a.a.asC();
          }
        }
        else if (k == 4)
        {
          ixo.a((Context)this.a.mContext.get(), this.a.mApp.b().b().relationType, this.a.mApp.b().b().amI, this.a.bL(), bool);
        }
        else if (k == 3)
        {
          ixo.B(this.a.bL(), bool);
        }
        else if (k == 5)
        {
          jjk.axa();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyu
 * JD-Core Version:    0.7.0.1
 */