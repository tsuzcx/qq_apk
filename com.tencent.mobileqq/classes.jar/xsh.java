import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class xsh
  implements View.OnClickListener, View.OnLongClickListener
{
  public int a;
  public SparseArray<View> a;
  public View a;
  public Object a;
  public String a;
  public HashMap<String, Object> a;
  public xqa a;
  public int b;
  public SparseArray<String> b;
  public int c = -1;
  
  public xsh(View paramView)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramView.setTag(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public <T extends View> T a(int paramInt)
  {
    View localView2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public Object a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramObject);
  }
  
  public void a(xqa paramxqa)
  {
    this.jdField_a_of_type_Xqa = paramxqa;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xqa != null) {
      this.jdField_a_of_type_Xqa.a(this.jdField_b_of_type_Int, paramView, this.jdField_a_of_type_JavaLangObject, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Xqa != null) {
      this.jdField_a_of_type_Xqa.b(this.jdField_b_of_type_Int, paramView, this.jdField_a_of_type_JavaLangObject, this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsh
 * JD-Core Version:    0.7.0.1
 */