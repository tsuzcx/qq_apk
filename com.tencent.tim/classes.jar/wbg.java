import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wbg
  implements View.OnClickListener
{
  public wbg(TroopMemberListActivity paramTroopMemberListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.bbp) && (!TroopMemberListActivity.a(this.this$0))) {
      if (((this.this$0.mFrom == 11) && (this.this$0.bLG > 0)) || (this.this$0.mFrom == 3))
      {
        Intent localIntent = this.this$0.getIntent();
        localIntent.putExtra("member_uin", "0");
        localIntent.putExtra("member_display_name", this.val$name);
        this.this$0.setResult(-1, localIntent);
        this.this$0.finish();
        if (this.this$0.mFrom == 11) {
          anot.a(this.this$0.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.this$0, acfp.m(2131715986), 0).show(this.this$0.mTitleBar.getHeight());
      continue;
      if (!TextUtils.isEmpty(this.this$0.aQL)) {
        QQToast.a(this.this$0, this.this$0.aQL, 0).show(this.this$0.mTitleBar.getHeight());
      } else {
        QQToast.a(this.this$0, acfp.m(2131715946), 0).show(this.this$0.mTitleBar.getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbg
 * JD-Core Version:    0.7.0.1
 */