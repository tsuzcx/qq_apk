import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class ymi
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<ymk> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private ymk jdField_a_of_type_Ymk;
  
  public ymi(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public ymk a()
  {
    return this.jdField_a_of_type_Ymk;
  }
  
  public void a(List<ymk> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable ymk paramymk)
  {
    this.jdField_a_of_type_Ymk = paramymk;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561740, null);
      localObject = new ymj(paramView);
      paramView.setTag(localObject);
    }
    for (;;)
    {
      ((ymj)localObject).a((ymk)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Ymk);
      localObject = ((ymj)localObject).a;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (ymj)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymi
 * JD-Core Version:    0.7.0.1
 */