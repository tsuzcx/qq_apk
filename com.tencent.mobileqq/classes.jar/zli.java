import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class zli
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<zlk> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private zlk jdField_a_of_type_Zlk;
  
  public zli(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public zlk a()
  {
    return this.jdField_a_of_type_Zlk;
  }
  
  public void a(List<zlk> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable zlk paramzlk)
  {
    this.jdField_a_of_type_Zlk = paramzlk;
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561863, null);
      localObject = new zlj(paramView);
      paramView.setTag(localObject);
    }
    for (;;)
    {
      ((zlj)localObject).a((zlk)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Zlk);
      localObject = ((zlj)localObject).a;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (zlj)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zli
 * JD-Core Version:    0.7.0.1
 */