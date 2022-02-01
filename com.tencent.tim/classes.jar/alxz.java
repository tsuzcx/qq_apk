import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alxz
  implements View.OnClickListener
{
  public alxz(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.b).iQ(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      alwx.dKs();
      if (!ankq.by(this.b.getContext())) {
        QQToast.a(this.b.getContext(), acfp.m(2131709987), 0).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (alwy.dyF == 0)
      {
        QQToast.a(this.b.getContext(), acfp.m(2131709993), 0).show();
      }
      else if (alwy.dyF == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
        }
      }
      else
      {
        boolean bool;
        if (alwy.dyF == 2)
        {
          bool = alwy.bi(true);
          if (QLog.isColorLevel()) {
            QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck soLoaded=" + bool);
          }
          if (ProviderContainerView.a(this.b) != null) {
            ProviderContainerView.a(this.b).dLh();
          }
        }
        if (i == 103)
        {
          alwx.dKv();
          alwx.dKs();
          if (!ankq.by(this.b.getContext()))
          {
            QQToast.a(this.b.getContext(), acfp.m(2131709992), 0).show();
            continue;
          }
          if (alwy.dyF == 0)
          {
            QQToast.a(this.b.getContext(), acfp.m(2131709991), 0).show();
            continue;
          }
          if (alwy.dyF == -1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
            continue;
          }
          if (alwy.dyF == 2)
          {
            bool = alwy.bi(true);
            if (QLog.isColorLevel()) {
              QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
            }
            if (ProviderContainerView.a(this.b) != null) {
              ProviderContainerView.a(this.b).dLh();
            }
          }
        }
        if (i == 101) {
          alwx.dKu();
        }
        if (i == 104)
        {
          anot.a(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
          alwx.dKt();
        }
        if (ProviderContainerView.a(this.b) != null) {
          ProviderContainerView.a(this.b).dKJ();
        }
        ProviderContainerView.a(this.b, paramView, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxz
 * JD-Core Version:    0.7.0.1
 */