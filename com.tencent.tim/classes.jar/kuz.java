import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kuz
  implements View.OnClickListener
{
  kuz(kuy paramkuy, ktm paramktm, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d(kuy.a(this.b), 1, "getBottomGuideView : " + kuy.b(this.b));
    kuy.a(this.b, "0X8009FEA", this.a.articleInfo);
    kxm.aJ(this.val$context, kuy.b(this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kuz
 * JD-Core Version:    0.7.0.1
 */