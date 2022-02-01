import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class jvl
  implements View.OnClickListener
{
  jvl(juk paramjuk, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    smu.b((Activity)this.b.mActivity.get(), new smu.a(this.b.mUin, this.b.a.name, this.b.a.summary), 1, juk.a(this.b));
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvl
 * JD-Core Version:    0.7.0.1
 */