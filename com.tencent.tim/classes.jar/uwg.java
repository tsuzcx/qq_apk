import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uwg
  implements View.OnClickListener
{
  public uwg(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    EditInfoActivity localEditInfoActivity = this.this$0;
    boolean bool;
    if (!this.this$0.aVD)
    {
      bool = true;
      localEditInfoActivity.aVD = bool;
      if (!this.this$0.aVD) {
        break label137;
      }
      this.this$0.gR();
      if (this.this$0.getIntent().getBooleanExtra("key_need_hide_couser_when_emoj", false)) {
        this.this$0.aA.setCursorVisible(false);
      }
      this.this$0.pR.setImageResource(2130838169);
      this.this$0.pR.setContentDescription(acfp.m(2131705408));
      if ((!this.this$0.aVI) && (this.this$0.fX != null)) {
        this.this$0.fX.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label137:
      this.this$0.aA.setCursorVisible(true);
      if (this.this$0.fX != null) {
        this.this$0.fX.setVisibility(8);
      }
      this.this$0.pR.setImageResource(2130848765);
      this.this$0.pR.setContentDescription(acfp.m(2131705398));
      this.this$0.IM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwg
 * JD-Core Version:    0.7.0.1
 */