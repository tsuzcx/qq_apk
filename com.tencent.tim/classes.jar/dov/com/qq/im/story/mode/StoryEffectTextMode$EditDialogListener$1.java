package dov.com.qq.im.story.mode;

import android.text.TextUtils;
import android.widget.TextView;
import aycm;
import aycm.a;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import rgb;
import rgm;

public class StoryEffectTextMode$EditDialogListener$1
  implements Runnable
{
  public StoryEffectTextMode$EditDialogListener$1(aycm.a parama) {}
  
  public void run()
  {
    ((rgb)aycm.a(this.b.this$0).a("TextLayer")).a(this.b.c);
    if (aycm.a(this.b.this$0))
    {
      aycm.a(this.b.this$0).setVisibility(8);
      aycm.a(this.b.this$0).setVisibility(8);
    }
    aycm.a(this.b.this$0, aycm.a(this.b.this$0), this.b.c.text, aycm.c(this.b.this$0), aycm.d(this.b.this$0), 8, null);
    if ((!TextUtils.isEmpty(this.b.c.text)) || (aycm.a(this.b.this$0)))
    {
      aycm.b(this.b.this$0).setVisibility(8);
      return;
    }
    aycm.b(this.b.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1
 * JD-Core Version:    0.7.0.1
 */