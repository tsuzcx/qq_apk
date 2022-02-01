import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aahn
  implements View.OnClickListener
{
  aahn(aahb paramaahb, altq paramaltq, altu paramaltu, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.c.OS("200001");
    Object localObject;
    if ((this.a.link == null) || (TextUtils.isEmpty(this.a.link)))
    {
      localObject = this.a.buffer;
      if (localObject == null)
      {
        localObject = "";
        switch (this.a.type)
        {
        }
      }
    }
    for (;;)
    {
      this.this$0.a(this.b, this.a.bYn, 3);
      aahb.a(this.this$0).removeMessages(9);
      aahb.a(this.this$0).sendEmptyMessage(9);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = ((String)localObject).replace(" ", "_");
      break;
      VipUtils.b(aahb.a(this.this$0), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.c(aahb.a(this.this$0), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(aahb.a(this.this$0), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.c(aahb.a(this.this$0), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { localObject }));
      continue;
      localObject = new Intent(aahb.a(this.this$0), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.a.link);
      aahb.a(this.this$0).startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahn
 * JD-Core Version:    0.7.0.1
 */