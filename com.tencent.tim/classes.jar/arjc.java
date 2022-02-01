import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class arjc
  implements AbsListView.e
{
  public arjc(SlideDetectListView paramSlideDetectListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SlideDetectListView.a(this.l) != null) {
      SlideDetectListView.a(this.l).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (SlideDetectListView.b(this.l) != null) {
      SlideDetectListView.b(this.l).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.l.mScrollState = paramInt;
    if (SlideDetectListView.a(this.l) != null) {
      SlideDetectListView.a(this.l).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (SlideDetectListView.b(this.l) != null) {
      SlideDetectListView.b(this.l).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjc
 * JD-Core Version:    0.7.0.1
 */