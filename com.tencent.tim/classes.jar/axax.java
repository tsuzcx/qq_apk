import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class axax
  implements View.OnClickListener
{
  axax(axaw paramaxaw, int paramInt, axaw.a parama) {}
  
  public void onClick(View paramView)
  {
    WMElement localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.val$position);
    if (localWMElement != null)
    {
      if (!localWMElement.ischeckin) {
        break label50;
      }
      axaw.a(this.this$0, localWMElement, this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      this.a.editText.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axax
 * JD-Core Version:    0.7.0.1
 */