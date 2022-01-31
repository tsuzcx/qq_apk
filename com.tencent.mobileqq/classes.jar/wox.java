import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

public abstract class wox<E>
  extends RecyclerView.Adapter
{
  public final ArrayList<E> a = new ArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(ArrayList<E> paramArrayList)
  {
    this.a.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    this.a.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void a(List<E> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.a.addAll(paramList);
    notifyItemRangeInserted(this.a.size(), paramList.size());
  }
  
  public ArrayList<E> b()
  {
    return this.a;
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wox
 * JD-Core Version:    0.7.0.1
 */