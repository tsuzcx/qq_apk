import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahui
  implements View.OnClickListener
{
  public ahui(ImgHeaderView paramImgHeaderView, Activity paramActivity, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.a, this.val$activity, this.y);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahui
 * JD-Core Version:    0.7.0.1
 */