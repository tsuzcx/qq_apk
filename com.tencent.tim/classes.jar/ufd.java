import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufd
  implements View.OnClickListener
{
  public ufd(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.this$0.getIntent();
    localIntent.putExtra("param_wzry_data", AddRequestActivity.a(this.this$0));
    ytb.a(this.this$0.app, this.this$0, this.this$0.aKN, AddRequestActivity.a(this.this$0), this.this$0.bDQ, AddRequestActivity.a(this.this$0), localIntent);
    if (AddRequestActivity.a(this.this$0) != null) {
      anot.a(this.this$0.app, "CliOper", "", "", "0X800843E", "0X800843E", 0, 0, "", "", "", "");
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X800AA42", "0X800AA42", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */