import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class jvj
  implements View.OnClickListener
{
  jvj(juk paramjuk, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.b.mActivity.get(), ScannerActivity.class);
    localIntent.putExtra("from", this.b.mActivity.getClass().getName());
    localIntent.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.b.mActivity.get()).startActivity(localIntent);
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvj
 * JD-Core Version:    0.7.0.1
 */