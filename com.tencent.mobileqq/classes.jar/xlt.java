import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class xlt
  extends xmt
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<xne> a;
  public xix a;
  protected xlu a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public xlt(@NonNull View paramView)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this));
    if ((paramView instanceof ViewGroup))
    {
      this.jdField_a_of_type_AndroidViewView = a((ViewGroup)paramView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public xlt(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this));
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public xlt a(Class<? extends xlt> paramClass)
  {
    if (this.jdField_a_of_type_Xlu != null) {
      return this.jdField_a_of_type_Xlu.b(paramClass);
    }
    return null;
  }
  
  public xlu a()
  {
    return this.jdField_a_of_type_Xlu;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, xiy paramxiy, @NonNull ArrayList<xne> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xix = paramxiy.jdField_a_of_type_Xix;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      xne localxne = (xne)localIterator.next();
      if ((paramxiy.jdField_a_of_type_Xix instanceof xjl)) {
        localxne.a = ((xjl)paramxiy.jdField_a_of_type_Xix).a;
      } else {
        localxne.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(xlu paramxlu)
  {
    this.jdField_a_of_type_Xlu = paramxlu;
  }
  
  protected void b() {}
  
  public void c()
  {
    yqp.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlt
 * JD-Core Version:    0.7.0.1
 */