import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class aoes
  implements AbsListView.e
{
  int bqx = 0;
  int cdI = 0;
  
  aoes(aoeq paramaoeq) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cdI = paramInt3;
    this.bqx = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    for (;;)
    {
      try
      {
        int i = this.this$0.mRequestCount;
        if (i > 0) {
          return;
        }
        if ((paramInt != 0) || (this.this$0.GY == null) || (this.bqx != this.cdI - 2)) {
          continue;
        }
        if (this.this$0.mIsEnd)
        {
          this.this$0.tG(true);
          continue;
        }
        this.this$0.tG(false);
      }
      finally {}
      this.this$0.b(this.this$0.acU, this.this$0.cku, this.this$0.dOd, 50, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoes
 * JD-Core Version:    0.7.0.1
 */