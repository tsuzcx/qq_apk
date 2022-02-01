import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class afor
  implements AbsListView.e
{
  public afor(EmotionPanelViewPagerAdapter.2 param2) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      URLDrawable.resume();
      if (this.a.cSK == 1) {
        EmotionPanelViewPagerAdapter.a(this.a.this$0, this.a.val$data, this.a.c);
      }
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afor
 * JD-Core Version:    0.7.0.1
 */