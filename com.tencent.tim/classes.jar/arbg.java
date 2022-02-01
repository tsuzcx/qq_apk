import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import java.io.File;

class arbg
  implements ausj.b
{
  arbg(arbf paramarbf) {}
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (this.this$0.m == null)
      {
        this.this$0.m = new arhz(this.this$0.s, this.this$0.baA);
        this.this$0.m.setMessage(2131695695);
      }
      this.this$0.m.show();
      if (!paramString.equals(this.this$0.s.getString(2131691025))) {
        break label165;
      }
      if (!TextUtils.isEmpty(this.this$0.mTempPath)) {
        break label115;
      }
      this.this$0.eec = 0;
    }
    for (;;)
    {
      this.this$0.d.dismiss();
      return;
      label115:
      if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
        this.this$0.m.dismiss();
      }
      this.this$0.VW(this.this$0.mTempPath);
      continue;
      label165:
      if (paramString.equals(this.this$0.s.getString(2131691024)))
      {
        if (TextUtils.isEmpty(this.this$0.mTempPath)) {
          this.this$0.eec = 1;
        } else {
          this.this$0.VV(this.this$0.mTempPath);
        }
      }
      else if (paramString.equals(this.this$0.s.getString(2131694760)))
      {
        if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
          this.this$0.m.dismiss();
        }
        this.this$0.gw(this.this$0.mTempPath, 1);
      }
      else if (paramString.equals(this.this$0.s.getString(2131694759)))
      {
        if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
          this.this$0.m.dismiss();
        }
        this.this$0.gw(this.this$0.mTempPath, 2);
      }
      else if (paramString.equals(this.this$0.s.getString(2131691027)))
      {
        if (TextUtils.isEmpty(this.this$0.mTempPath))
        {
          this.this$0.eec = 2;
        }
        else
        {
          if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
            this.this$0.m.dismiss();
          }
          this.this$0.VX(this.this$0.mTempPath);
        }
      }
      else if (paramString.equals(this.this$0.s.getString(2131694750)))
      {
        if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
          this.this$0.m.dismiss();
        }
        if (!TextUtils.isEmpty(this.this$0.mTempPath))
        {
          paramView = new File(this.this$0.mTempPath);
          paramString = ((TeamWorkDocEditBrowserActivity)this.this$0.s).mApp.getCurrentAccountUin();
          aviz.b(paramView.getAbsolutePath()).b(this.this$0.s, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbg
 * JD-Core Version:    0.7.0.1
 */