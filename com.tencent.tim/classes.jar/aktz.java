import android.util.SparseArray;
import android.view.View;

public class aktz
{
  private SparseArray<View> dd = new SparseArray();
  
  public View getScrapView(int paramInt)
  {
    if (this.dd.size() > 0)
    {
      View localView = (View)this.dd.valueAt(paramInt);
      if (localView != null) {
        this.dd.remove(paramInt);
      }
      return localView;
    }
    return null;
  }
  
  public void x(int paramInt, View paramView)
  {
    if (this.dd.size() >= 3) {
      return;
    }
    this.dd.put(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktz
 * JD-Core Version:    0.7.0.1
 */