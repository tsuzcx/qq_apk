import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afco
  implements View.OnClickListener
{
  afco(afcn paramafcn) {}
  
  public void onClick(View paramView)
  {
    if ((HotChatFlashPicActivity.a(this.a.this$0) != null) && (!this.a.this$0.isFinishing()))
    {
      HotChatFlashPicActivity.a(this.a.this$0).dismiss();
      HotChatFlashPicActivity.a(this.a.this$0, null);
      this.a.this$0.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afco
 * JD-Core Version:    0.7.0.1
 */