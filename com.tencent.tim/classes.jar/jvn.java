import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class jvn
  implements View.OnClickListener
{
  jvn(juk paramjuk, int paramInt, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    smu.a((BaseActivity)this.b.mActivity.get(), new smu.a(this.b.mUin, this.b.a.name, this.b.a.summary), 1, juk.a(this.b), this.val$action);
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvn
 * JD-Core Version:    0.7.0.1
 */