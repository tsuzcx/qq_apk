import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

class axmy
  implements View.OnClickListener
{
  axmy(axmx paramaxmx, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEEditorFilterBean localAEEditorFilterBean = this.e;
    boolean bool = true;
    if (axmx.a(this.b) != null) {
      bool = axmx.a(this.b).a(this.val$position, localAEEditorFilterBean);
    }
    if (bool)
    {
      axmx.a(this.b, this.val$position);
      int i = axmx.a(this.b);
      axmx.a(this.b, this.val$position);
      this.b.notifyItemChanged(i);
      this.b.notifyItemChanged(axmx.a(this.b));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmy
 * JD-Core Version:    0.7.0.1
 */