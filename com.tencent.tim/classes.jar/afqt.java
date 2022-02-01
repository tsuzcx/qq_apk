import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1.1;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class afqt
  implements AbsListView.e
{
  public afqt(SystemAndEmojiUniversalPanel.1.1 param1) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemAndEmojiUniversalPanel.a(this.a.a.this$0, paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      URLDrawable.resume();
      SystemAndEmojiUniversalPanel.a(this.a.a.this$0, this.a.Ar, SystemAndEmojiUniversalPanel.a(this.a.a.this$0));
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqt
 * JD-Core Version:    0.7.0.1
 */