import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.mobileqq.widget.DraggableGridView.c;

public abstract class arep
{
  public DraggableGridView b;
  
  public abstract void C(View paramView, int paramInt1, int paramInt2);
  
  public int ME()
  {
    return 1;
  }
  
  public abstract void U(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract View a(LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, ViewGroup paramViewGroup);
  
  public abstract void at(View paramView, int paramInt);
  
  public abstract View c(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup);
  
  public abstract Object c(int paramInt1, int paramInt2);
  
  public abstract int getGroupCount();
  
  public abstract int jF(int paramInt);
  
  public abstract void jO(int paramInt1, int paramInt2);
  
  public int ku(int paramInt)
  {
    return 0;
  }
  
  public void kv(int paramInt1, int paramInt2)
  {
    this.b.kw(paramInt1, paramInt2);
  }
  
  public void notifyDataSetChanged()
  {
    ((DraggableGridView.c)this.b.a()).notifyDataSetChanged();
  }
  
  public abstract Object p(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arep
 * JD-Core Version:    0.7.0.1
 */