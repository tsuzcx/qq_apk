import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;

public class aueu
  implements View.OnClickListener
{
  public aueu(CloudSendBottomBar paramCloudSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this.this$0.context)) {
      audx.JI(this.this$0.context.getString(2131694663));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((atwb.fO() > atvz.fJ()) && (audx.amK())) {
        ahal.a(CloudSendBottomBar.a(this.this$0), 2131693826, 2131693832, new auev(this));
      } else {
        this.this$0.dmE();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aueu
 * JD-Core Version:    0.7.0.1
 */