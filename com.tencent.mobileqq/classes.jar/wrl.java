import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class wrl<M, VH extends wro<M>>
  extends wrp<M, VH>
{
  private List<M> a;
  
  public wrl(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public abstract int a(int paramInt);
  
  public int a(M paramM)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramM);
    if (i < 0) {
      return i;
    }
    this.jdField_a_of_type_JavaUtilList.set(i, paramM);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemChanged(i);
      return i;
    }
    notifyItemChanged(i + 1);
    return i;
  }
  
  public M a(int paramInt)
  {
    if (((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size() + b())) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
  }
  
  public List<M> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(M paramM)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramM);
    if (i < 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(i);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemRemoved(i);
      return;
    }
    notifyItemRemoved(i + 1);
  }
  
  public void a(M paramM, int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramM);
    if (i != -1) {
      this.jdField_a_of_type_JavaUtilList.remove(i);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramM);
    if (i != -1)
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        notifyItemMoved(i, paramInt);
        notifyItemChanged(paramInt);
        return;
      }
      notifyItemMoved(i + 1, paramInt + 1);
      notifyItemChanged(paramInt + 1);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemInserted(paramInt);
      return;
    }
    notifyItemInserted(paramInt + 1);
  }
  
  public boolean a(List<M> paramList)
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      boolean bool = i | this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (bool) {
        notifyDataSetChanged();
      }
      return bool;
    }
  }
  
  public boolean b(List<M> paramList)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (bool) {
      notifyDataSetChanged();
    }
    return bool;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + a();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) {
      return 1024;
    }
    if ((this.b != null) && (paramInt == this.jdField_a_of_type_JavaUtilList.size() + b())) {
      return 1025;
    }
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrl
 * JD-Core Version:    0.7.0.1
 */