import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicInteger;

public class wqf
  implements View.OnClickListener
{
  public wqf(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    if ((VoiceTextEditPanel.a(this.this$0).get() == 1) || (VoiceTextEditPanel.a(this.this$0).get() == 3)) {
      QQToast.a(this.this$0.getContext(), acfp.m(2131716877), 0).show(this.this$0.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqf
 * JD-Core Version:    0.7.0.1
 */