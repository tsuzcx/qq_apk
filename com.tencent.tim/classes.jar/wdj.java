import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class wdj
  implements ausj.a
{
  public wdj(TroopRequestActivity paramTroopRequestActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.val$sheet.dismiss();
      return;
    }
    if (aqiw.isNetSupport(BaseApplication.getContext())) {
      TroopRequestActivity.a(this.this$0);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, this.this$0.aKI, this.this$0.aRH, "", "");
      break;
      QQToast.a(this.this$0, 2131696272, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdj
 * JD-Core Version:    0.7.0.1
 */