import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

public abstract class zox<E>
  extends RecyclerView.Adapter
{
  private Handler a;
  protected ArrayList<E> a;
  
  public zox()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public ArrayList<E> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(E paramE, int paramInt)
  {
    if ((paramE == null) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, paramE);
  }
  
  public void a(ArrayList<E> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void b(List<E> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyItemRangeInserted(this.jdField_a_of_type_JavaUtilArrayList.size(), paramList.size());
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    a().removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zox
 * JD-Core Version:    0.7.0.1
 */