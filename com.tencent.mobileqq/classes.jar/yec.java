import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class yec<E>
  extends ydn<E>
{
  protected static final String b;
  protected String a;
  protected boolean a;
  protected boolean b;
  
  static
  {
    jdField_b_of_type_JavaLangString = alpo.a(2131709241);
  }
  
  public yec()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    notifyItemChanged(getItemCount() - 1);
  }
  
  protected abstract RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void b(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return 0;
    }
    return 99999;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == null) || (paramInt >= getItemCount())) {
      return;
    }
    if (99999 == getItemViewType(paramInt))
    {
      a(paramViewHolder, paramInt);
      return;
    }
    b(paramViewHolder, paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 99999) {
      return a(paramViewGroup, paramInt);
    }
    return b(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yec
 * JD-Core Version:    0.7.0.1
 */