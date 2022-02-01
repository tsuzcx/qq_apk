import android.os.Bundle;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class yro
  implements AbsListView.e
{
  yro(yri paramyri) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    yri.a(this.this$0, paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    if (yri.b(this.this$0) >= this.this$0.getCount() - 2)
    {
      paramAbsListView = new Bundle();
      paramAbsListView.putString("from", "4");
      yri.a(this.this$0).b(4, yri.a(this.this$0), paramAbsListView);
    }
    this.this$0.ckZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yro
 * JD-Core Version:    0.7.0.1
 */