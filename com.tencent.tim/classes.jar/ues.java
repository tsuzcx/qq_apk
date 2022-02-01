import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ues
  implements View.OnClickListener
{
  public ues(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.d != null)
    {
      this.this$0.getWindow().setSoftInputMode(2);
      this.this$0.d.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.this$0).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.this$0).clearFocus();
    }
    Object localObject = AddFriendVerifyActivity.a(this.this$0).getText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (!this.this$0.isFinishing())
      {
        localObject = new jog(this.this$0);
        ((jog)localObject).np.setText(acfp.m(2131702064));
        ((jog)localObject).hk.setImageResource(2130847058);
        ((jog)localObject).ayG();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((String)localObject).length() > 90)
      {
        localObject = new ReportDialog(this.this$0, 2131756467);
        ((Dialog)localObject).setContentView(2131562991);
        ((TextView)((Dialog)localObject).findViewById(2131365863)).setText(this.this$0.getString(2131692107));
        ((ProgressBar)((Dialog)localObject).findViewById(2131367453)).setVisibility(8);
        ((ImageView)((Dialog)localObject).findViewById(2131381312)).setImageResource(2130840117);
        ((Dialog)localObject).show();
      }
      else
      {
        this.this$0.aN(AddFriendVerifyActivity.a(this.this$0).getText().toString(), true);
        if (aqiw.isNetSupport(this.this$0)) {
          AddFriendVerifyActivity.a(this.this$0, AddFriendVerifyActivity.a(this.this$0), AddFriendVerifyActivity.a(this.this$0).getText().toString(), this.this$0.getIntent().getIntExtra("stat_option", 0), 2000);
        } else {
          QQToast.a(this.this$0, 1, 2131696272, 0).show(this.this$0.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ues
 * JD-Core Version:    0.7.0.1
 */