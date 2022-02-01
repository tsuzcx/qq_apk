import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class zte
  implements ausj.a
{
  zte(ztd paramztd, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.this$0.fp == null) || (paramInt >= this.this$0.fp.length)) {
      return;
    }
    switch (this.this$0.fp[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.this$0.mActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.this$0.mActivity).requestPermissions(new ztf(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          ztd.a(this.this$0);
        }
      }
      else
      {
        ztd.a(this.this$0);
        continue;
        zti.p(this.this$0.mActivity, zti.fG(this.this$0.mType));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zte
 * JD-Core Version:    0.7.0.1
 */