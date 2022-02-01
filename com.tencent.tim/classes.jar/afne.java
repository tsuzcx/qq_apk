import com.tencent.image.AbstractGifImage;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class afne
  implements AbsListView.e
{
  afne(afnd paramafnd) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2)) {
      AbstractGifImage.resumeAll();
    }
    for (;;)
    {
      this.this$0.mLastScrollState = paramInt;
      return;
      AbstractGifImage.pauseAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afne
 * JD-Core Version:    0.7.0.1
 */