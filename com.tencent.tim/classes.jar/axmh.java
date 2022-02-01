import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class axmh
  implements View.OnClickListener
{
  public axmh(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.applyCurrentSticker();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmh
 * JD-Core Version:    0.7.0.1
 */