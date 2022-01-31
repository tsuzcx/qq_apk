import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public class wsr
  extends RecyclerView.Adapter<wss>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<wst> jdField_a_of_type_JavaUtilList;
  
  public wsr(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public wss a(ViewGroup paramViewGroup, int paramInt)
  {
    return new wss(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492937, paramViewGroup, false));
  }
  
  public void a(@NonNull List<wst> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(wss paramwss, int paramInt)
  {
    paramwss.a((wst)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsr
 * JD-Core Version:    0.7.0.1
 */