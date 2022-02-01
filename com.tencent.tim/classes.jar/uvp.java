import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uvp
  implements View.OnClickListener
{
  public uvp(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.aA.setCursorVisible(true);
    this.this$0.fX.setVisibility(8);
    this.this$0.pR.setImageResource(2130848765);
    this.this$0.pR.setContentDescription(acfp.m(2131705403));
    this.this$0.aVD = false;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvp
 * JD-Core Version:    0.7.0.1
 */