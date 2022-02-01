import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class auoc
  implements AbsListView.e
{
  private int erN = (int)(aunz.a(this.this$0).getResources().getDisplayMetrics().density * 22.0F);
  
  auoc(aunz paramaunz) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (aunz.a(this.this$0) != null) {
      aunz.a(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt1 >= 1) || ((paramInt1 == 0) && (paramAbsListView.getChildAt(0) != null) && (paramAbsListView.getChildAt(0).getBottom() < this.erN))) {
      aunz.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (((aunz.a(this.this$0) + aunz.a(this.this$0).getHeaderViewsCount() < paramInt1) || (aunz.a(this.this$0) + aunz.a(this.this$0).getHeaderViewsCount() > paramInt1 + paramInt2)) && (aunz.a(this.this$0) != null) && (aunz.a(this.this$0)))
      {
        aunz.a(this.this$0).cancel();
        aunz.a(this.this$0, false);
        if (aunz.a(this.this$0) != null) {
          aunz.a(this.this$0).setVisibility(8);
        }
      }
      return;
      aunz.a(this.this$0).setVisibility(8);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (aunz.a(this.this$0) != null) {
      aunz.a(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoc
 * JD-Core Version:    0.7.0.1
 */