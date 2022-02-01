import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.a;

public class axkb
  implements View.OnClickListener
{
  public axkb(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onClick(View paramView)
  {
    AEEditorAILoadingView.a(this.this$0).setVisibility(8);
    if (AEEditorAILoadingView.a(this.this$0) != null) {
      AEEditorAILoadingView.a(this.this$0).onCancel();
    }
    ((ViewGroup)this.this$0.getParent()).removeAllViews();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axkb
 * JD-Core Version:    0.7.0.1
 */