import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxy
  implements View.OnClickListener
{
  public aaxy(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.eK == 27)
    {
      this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.aQ);
      ((InputMethodManager)this.this$0.getSystemService("input_method")).hideSoftInputFromWindow(this.this$0.getWindow().peekDecorView().getWindowToken(), 0);
      this.this$0.setResult(-1, this.this$0.mIntent);
    }
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxy
 * JD-Core Version:    0.7.0.1
 */