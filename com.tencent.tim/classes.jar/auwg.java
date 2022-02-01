import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;

class auwg
  implements RecyclerView.ChildDrawingOrderCallback
{
  auwg(auwd paramauwd) {}
  
  public int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.this$0.mOverdrawChild == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = this.this$0.mOverdrawChildPosition;
      i = j;
      if (j == -1)
      {
        i = this.this$0.mRecyclerView.indexOfChild(this.this$0.mOverdrawChild);
        this.this$0.mOverdrawChildPosition = i;
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwg
 * JD-Core Version:    0.7.0.1
 */