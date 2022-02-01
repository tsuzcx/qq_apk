import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aouz
  implements View.OnClickListener
{
  public aouz(TroopBarPublishActivity.16 param16) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("path", this.a.val$outPath);
    PublicFragmentActivity.start(this.a.this$0, localIntent, TribeVideoPreviewFragment.class);
    this.a.this$0.overridePendingTransition(2130772399, 2130772400);
    if ((this.a.this$0.ZZ != null) && (this.a.this$0.ZZ.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00899", "Grp_tribe", "", "post", "Clk_full_screen", i, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouz
 * JD-Core Version:    0.7.0.1
 */