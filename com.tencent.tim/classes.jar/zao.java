import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zao
  implements View.OnClickListener
{
  zao(zam paramzam) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.bu(this.this$0.mContext);
    anot.a(zam.a(this.this$0), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zao
 * JD-Core Version:    0.7.0.1
 */