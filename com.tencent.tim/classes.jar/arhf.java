import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhf
  implements View.OnClickListener
{
  public arhf(ProfileCardMoreInfoView paramProfileCardMoreInfoView, String paramString, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((amin.oE(this.bWm)) && (this.dtl >= 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_sign_topic_name", this.bWm);
      localBundle.putInt("key_sign_topic_id", this.dtl);
      localBundle.putInt("from_type", 2);
      if ((this.this$0.mActivity != null) && (this.this$0.app != null)) {
        SignTextEditFragment.a(this.this$0.mActivity, null, null, localBundle, -1);
      }
      this.jY.setVisibility(8);
      aldf.a().dF(this.this$0.app);
      anot.a(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhf
 * JD-Core Version:    0.7.0.1
 */