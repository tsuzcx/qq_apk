import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class auww
  extends RecyclerView.AdapterDataObserver
{
  auww(auwv paramauwv) {}
  
  private void onPagerDataChanged(int paramInt1, int paramInt2)
  {
    View localView = this.b.findCenterView(auwv.a(this.b));
    if (localView != null) {}
    for (int i = auwv.a(this.b).getPosition(localView);; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + auwv.b(this.b) + ", currentPosition=" + i);
      }
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        auwv.a.a(auwv.a(this.b), true);
        auwv.a(this.b).addOnLayoutChangeListener(auwv.a(this.b));
        auwv.a(this.b).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    onPagerDataChanged(0, auwv.a(this.b).getItemCount());
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= auwv.b(this.b)) {
      auwv.b(this.b, auwv.b(this.b) + paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == auwv.b(this.b)) {
      auwv.b(this.b, paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= auwv.b(this.b)) {
      auwv.b(this.b, auwv.b(this.b) - paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auww
 * JD-Core Version:    0.7.0.1
 */