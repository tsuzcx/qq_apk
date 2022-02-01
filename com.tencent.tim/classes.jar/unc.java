import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.d;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class unc
  implements AbsListView.e
{
  public unc(ChatHistory paramChatHistory) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.this$0.mScrollState = paramInt;
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    if ((this.this$0.a != null) && (this.this$0.a.nType == 1) && (!this.this$0.a.isFinish)) {
      this.this$0.a.bJV();
    }
    AbstractGifImage.pauseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unc
 * JD-Core Version:    0.7.0.1
 */