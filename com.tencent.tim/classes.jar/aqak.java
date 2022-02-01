import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class aqak
  implements View.OnClickListener
{
  aqak(aqai paramaqai) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    arwt.i("NewUpgradeDialog", arud.b(10010, aqai.access$000(), 2, 200));
    arub.a().postReport(17, arud.b(10010, aqai.access$000(), 4, 200));
    this.this$0.dismiss();
    ((Activity)this.this$0.mActivity.get()).finish();
    if (aqai.access$000() == 2) {
      i = 1;
    }
    anot.a(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqak
 * JD-Core Version:    0.7.0.1
 */