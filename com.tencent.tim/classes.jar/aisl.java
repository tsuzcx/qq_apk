import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class aisl
  implements AbsListView.e
{
  private int buL;
  
  aisl(aisj paramaisj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramInt = paramAbsListView.getFirstVisiblePosition();
    if (paramInt > this.buL)
    {
      if (!aisj.a(this.this$0).aQZ()) {
        aisj.a(this.this$0).displayPanel();
      }
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LocationShareController", 4, "onScrollStateChanged");
        }
        aisj.a(this.this$0).dui();
      }
    }
    for (;;)
    {
      this.buL = paramInt;
      return;
      if (paramInt >= this.buL) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisl
 * JD-Core Version:    0.7.0.1
 */