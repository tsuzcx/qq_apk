import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kep
  implements View.OnClickListener
{
  public kep(CustomTabView paramCustomTabView, kem.a parama, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        kee.a(null, "gouwu.tab.click", this.a.aCj + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        if (this.hP.getTag() != null) {
          continue;
        }
        i = 0;
        Integer localInteger = Integer.valueOf(i);
        if (localInteger.intValue() != 0)
        {
          this.hP.setVisibility(8);
          kee.cl(this.a.aCj, localInteger.intValue());
        }
        i = this.a.aCj;
        int j = this.this$0.aIo;
        if (i != j) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localThrowable));
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)this.hP.getTag()).intValue();
      continue;
      CustomTabView.a(this.this$0, this.a, this.val$textView, this.hQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kep
 * JD-Core Version:    0.7.0.1
 */