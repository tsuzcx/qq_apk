import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;

public class adl
  implements AbsListView.OnScrollListener
{
  public adl(ChatHistory paramChatHistory) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.v = paramInt;
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    if ((this.a.a != null) && (this.a.a.c == 1) && (!this.a.a.a)) {
      this.a.a.b();
    }
    AbstractGifImage.pauseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adl
 * JD-Core Version:    0.7.0.1
 */