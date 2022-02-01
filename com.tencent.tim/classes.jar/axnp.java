import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;

public class axnp
  implements View.OnClickListener
{
  public axnp(AEEditorColorSelectorView paramAEEditorColorSelectorView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEEditorColorSelectorView.a(this.a, this.TJ);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnp
 * JD-Core Version:    0.7.0.1
 */