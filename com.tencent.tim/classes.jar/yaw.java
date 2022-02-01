import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;

class yaw
  implements AbsListView.e
{
  yaw(yam paramyam) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.this$0.z != null) && (this.this$0.z.getLastVisiblePosition() == this.this$0.z.getCount() - 1) && (this.this$0.a != null) && (this.this$0.a.zw() != 0) && (this.this$0.a.XU()))
    {
      this.this$0.a.cBk();
      yam.a(this.this$0, this.this$0.a.zw(), 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yaw
 * JD-Core Version:    0.7.0.1
 */