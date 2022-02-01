package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import aynp;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import mqq.os.MqqHandler;

public class EditTextPanel$2$1
  implements Runnable
{
  public EditTextPanel$2$1(aynp paramaynp, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.a.this$0.b == null) || (this.a.this$0.b.mLayoutManager == null)) {}
    for (;;)
    {
      return;
      int j = this.a.this$0.b.mLayoutManager.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.a.this$0.b.mLayoutManager.getChildAt(i);
        localObject = (EditTextEffectView.b)this.a.this$0.b.getChildViewHolder((View)localObject);
        if ((((EditTextEffectView.b)localObject).c.isContainsResUrl(this.val$url)) && (((EditTextEffectView.b)localObject).c.text_id == this.doZ)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.1.1(this, (EditTextEffectView.b)localObject));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.1
 * JD-Core Version:    0.7.0.1
 */