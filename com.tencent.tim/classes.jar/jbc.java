import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jbc
  implements View.OnClickListener
{
  jbc(jba paramjba) {}
  
  public void onClick(View paramView)
  {
    if (this.a.this$0.a != null) {
      this.a.this$0.a.su();
    }
    anot.a(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbc
 * JD-Core Version:    0.7.0.1
 */