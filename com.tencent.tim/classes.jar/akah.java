import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class akah
  implements ausj.a
{
  akah(ajzv paramajzv, BaseActivity paramBaseActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if (this.val$actionSheet != null) {
          this.val$actionSheet.dismiss();
        }
        return;
        if (!ajzv.e(this.this$0)) {
          break;
        }
        ajzv.a(this.this$0, aqha.a(this.this$0.Fb.getContext(), 230, acfp.m(2131709718), null, acfp.m(2131709726), acfp.m(2131709721), new akai(this), new akak(this)));
        ajzv.a(this.this$0).show();
        anot.a(this.this$0.app, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    } while ((this.this$0.b == null) || (this.this$0.Fc == null) || (this.this$0.app == null));
    String str = String.valueOf(this.this$0.b.ads);
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, acfp.m(2131709717), 0).show();
      return;
    }
    paramView = "";
    if (this.this$0.b.feedType == 4) {
      if (this.this$0.b.yf.get(0) == null) {}
    }
    for (paramView = ((ajwh)this.this$0.b.yf.get(0)).imageUrl;; paramView = this.this$0.b.coverUrl)
    {
      paramView = new aqep.a().b(this.this$0.b.coverUrl).d(paramView).a(this.this$0.b.bSJ).s();
      aqep.b(this.val$activity, 0L, str, null, 20006, "", paramView);
      anot.a(this.this$0.app, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akah
 * JD-Core Version:    0.7.0.1
 */