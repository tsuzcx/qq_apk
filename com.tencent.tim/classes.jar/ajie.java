import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.j;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;

public class ajie
  extends MultiAIOBaseViewPager.j
{
  public ajie(MultiAIOItemFragment paramMultiAIOItemFragment, AbsListView.e parame, ListView paramListView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
    boolean bool;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
      bool = false;
    }
    for (;;)
    {
      this.r.onScrollStateChanged(this.c, paramInt);
      if ((this.c instanceof ChatXListView))
      {
        ChatXListView localChatXListView = (ChatXListView)this.c;
        int[] arrayOfInt = MultiAIOItemFragment.a(this.this$0);
        localChatXListView.setDisableLayout(bool, arrayOfInt[0], arrayOfInt[1]);
      }
      return;
      paramInt = 1;
      bool = false;
      continue;
      paramInt = 2;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajie
 * JD-Core Version:    0.7.0.1
 */