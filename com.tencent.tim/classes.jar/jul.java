import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class jul
  implements View.OnClickListener
{
  jul(juk paramjuk, jzs.a parama, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.b.mActivity.get(), QQMapActivity.class);
    localIntent.putExtra("lat", this.a.lat);
    localIntent.putExtra("lon", this.a.lng);
    if (!TextUtils.isEmpty(this.val$address)) {
      localIntent.putExtra("loc", this.val$address);
    }
    ((BaseActivity)this.b.mActivity.get()).startActivity(localIntent);
    anot.a(this.b.app, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.b.mUin, "", "", "");
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jul
 * JD-Core Version:    0.7.0.1
 */