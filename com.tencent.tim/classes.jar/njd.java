import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class njd
  implements AbsListView.e
{
  public njd(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.this$0.asA = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njd
 * JD-Core Version:    0.7.0.1
 */