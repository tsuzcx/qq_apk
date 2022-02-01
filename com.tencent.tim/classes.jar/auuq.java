import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auuq
  extends BaseAdapter
{
  private int euc = 1;
  private int eud;
  private BaseAdapter i;
  
  public auuq(BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.i = paramBaseAdapter;
    if (paramInt > 0) {}
    for (;;)
    {
      this.euc = paramInt;
      if (this.i != null) {
        this.i.registerDataSetObserver(new auur(this));
      }
      return;
      paramInt = 1;
    }
  }
  
  public int OS()
  {
    return this.euc;
  }
  
  public int OT()
  {
    int j = this.i.getCount();
    int k = j / this.euc;
    if (j % this.euc != 0) {}
    for (j = 1;; j = 0) {
      return j + k;
    }
  }
  
  public BaseAdapter c()
  {
    return this.i;
  }
  
  public int getCount()
  {
    int j = this.i.getCount();
    if ((this.eud + 1) * this.euc > j) {
      return j % this.euc;
    }
    return this.euc;
  }
  
  public Object getItem(int paramInt)
  {
    return this.i.getItem(this.eud * this.euc + paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.i.getItemId(this.eud * this.euc + paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.i.getView(this.eud * this.euc + paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void setCurrentPage(int paramInt)
  {
    int j = OT();
    if (paramInt < 0)
    {
      this.eud = 0;
      return;
    }
    if (paramInt >= j)
    {
      this.eud = (j - 1);
      return;
    }
    this.eud = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auuq
 * JD-Core Version:    0.7.0.1
 */