import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.widget.QQToast;

class voz
  implements ausj.a
{
  voz(voy paramvoy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.mActionSheet.dismiss();
      return;
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
      swb.report("share_success");
      this.a.a.bTs();
      continue;
      if (aviz.a((float)this.a.a.latitude, (float)this.a.a.longitude, this.a.a.aOW, this.a.a.aOV, null).c(this.a.a.getIntent().getStringExtra("uin")).b(this.a.a, this.a.a.getIntent().getStringExtra("uin"), 1, null))
      {
        paramInt = QQMapActivity.a(this.a.a).getDimensionPixelSize(2131299627);
        QQToast.a(this.a.a, 2, this.a.a.getString(2131693408), 1).show(paramInt);
        swb.report("favorite_success");
      }
      avjg.a(null, 65, 7);
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voz
 * JD-Core Version:    0.7.0.1
 */