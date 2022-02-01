import android.view.View;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;

public class nlj
{
  private int bal = -1;
  private int bam = -1;
  
  public nlj(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    this.bal = paramInt1;
    this.bam = paramInt2;
    a(paramAbsListView, paramInt1, new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, Pair<Integer, Integer> paramPair)
  {
    paramInt = ((Integer)paramPair.first).intValue() - paramInt;
    int i = paramInt + (((Integer)paramPair.second).intValue() - ((Integer)paramPair.first).intValue());
    if (i > paramAbsListView.getChildCount()) {}
    for (;;)
    {
      return;
      while (paramInt <= i)
      {
        paramPair = paramAbsListView.getChildAt(paramInt);
        if ((paramPair != null) && ((paramPair.getTag() instanceof nlm))) {
          ((nlm)paramPair.getTag()).onShow();
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    paramInt2 = paramInt1 + paramInt2 - 1;
    if ((paramInt1 >= this.bal) && (paramInt2 <= this.bam)) {
      return;
    }
    Object localObject1;
    if (paramInt1 < this.bal) {
      if (paramInt2 >= this.bam)
      {
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(this.bal - 1));
        label64:
        this.bam = paramInt2;
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = localObject3;
      if (paramInt2 > this.bam)
      {
        if (paramInt1 > this.bal) {
          break label176;
        }
        localObject1 = new Pair(Integer.valueOf(this.bam + 1), Integer.valueOf(paramInt2));
      }
      for (;;)
      {
        this.bam = paramInt2;
        if (paramAbsListView == null) {
          break;
        }
        if (localObject2 != null) {
          a(paramAbsListView, paramInt1, localObject2);
        }
        if (localObject1 == null) {
          break;
        }
        a(paramAbsListView, paramInt1, (Pair)localObject1);
        return;
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        this.bal = paramInt1;
        break label64;
        label176:
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        this.bal = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlj
 * JD-Core Version:    0.7.0.1
 */