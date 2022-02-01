import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;
import java.util.HashSet;

public class axxk
  implements View.OnClickListener
{
  public axxk(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374659)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.this$0).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.aPT()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131711228), 0).show();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("ProviderContainerView", 2, "onclick, indext: " + i);
      }
      this.this$0.f(i, 0, null, false);
      if (QIMProviderContainerView.a(this.this$0) == null) {
        break;
      }
      QIMProviderContainerView.a(this.this$0).bta();
      break;
      rar.a("clk_effect", rar.ea(alwx.dyy), 0, false, new String[0]);
      awsy.bV.add(Integer.valueOf(7));
      continue;
      rar.a("clk_filter", rar.ea(alwx.dyy), 0, false, new String[0]);
      awsy.bV.add(Integer.valueOf(8));
      continue;
      rar.a("clk_music", rar.ea(alwx.dyy), 0, false, new String[0]);
      awsy.bV.add(Integer.valueOf(9));
      continue;
      rar.a("clk_face", rar.ea(alwx.dyy), 0, false, new String[0]);
      awsy.bV.add(Integer.valueOf(10));
      continue;
      rar.a("clk_beauty", rar.ea(alwx.dyy), 0, false, new String[0]);
      awsy.bV.add(Integer.valueOf(11));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxk
 * JD-Core Version:    0.7.0.1
 */