import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment.a;

public class axld
  implements View.OnClickListener
{
  public axld(AEEditorImageClipFragment.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEEditorImageClipFragment.a(this.b.a, this.val$position);
    this.b.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axld
 * JD-Core Version:    0.7.0.1
 */