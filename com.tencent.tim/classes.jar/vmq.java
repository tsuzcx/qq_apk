import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vmq
  implements View.OnClickListener
{
  public vmq(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.this$0.getIntent().getStringExtra("uin");
    if ((str != null) && (str.equals(this.this$0.app.getCurrentAccountUin())))
    {
      ProfileLabelEditorActivity.a(this.this$0);
      anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "4", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmq
 * JD-Core Version:    0.7.0.1
 */