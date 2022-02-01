import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xyk
  implements View.OnClickListener
{
  xyk(xyi paramxyi, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((xyi.a(this.this$0) != null) && (xyi.a(this.this$0).isShowing())) {
      xyi.a(this.this$0).dismiss();
    }
    if ((this.this$0.Z != null) && (this.this$0.Z.isShowing()))
    {
      this.this$0.Z.dismiss();
      this.this$0.Z = null;
    }
    xyi.a(this.this$0, this.aWV);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyk
 * JD-Core Version:    0.7.0.1
 */