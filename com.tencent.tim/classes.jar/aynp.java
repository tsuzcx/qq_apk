import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.b;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView.b;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.2;
import mqq.os.MqqHandler;

public class aynp
  implements DynamicTextConfigManager.b
{
  public aynp(EditTextPanel paramEditTextPanel) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.this$0.post(new EditTextPanel.2.1(this, paramString, paramInt));
  }
  
  public void bd(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.b == null) || (this.this$0.b.mLayoutManager == null)) {}
    for (;;)
    {
      return;
      int j = this.this$0.b.mLayoutManager.getChildCount();
      DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)axov.a(7);
      int i = 0;
      while (i < j)
      {
        Object localObject = this.this$0.b.mLayoutManager.getChildAt(i);
        localObject = (EditTextEffectView.b)this.this$0.b.getChildViewHolder((View)localObject);
        if (((EditTextEffectView.b)localObject).c.isContainsResUrl(paramString)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.2(this, paramBoolean, (EditTextEffectView.b)localObject, localDynamicTextConfigManager));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynp
 * JD-Core Version:    0.7.0.1
 */