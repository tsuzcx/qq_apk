import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class tzk
  extends uak
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<uav> a;
  public two a;
  protected tzl a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public tzk(@NonNull View paramView)
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
  
  public tzk(@NonNull ViewGroup paramViewGroup)
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
  
  public tzk a(Class<? extends tzk> paramClass)
  {
    if (this.jdField_a_of_type_Tzl != null) {
      return this.jdField_a_of_type_Tzl.b(paramClass);
    }
    return null;
  }
  
  public tzl a()
  {
    return this.jdField_a_of_type_Tzl;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, twp paramtwp, @NonNull ArrayList<uav> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Two = paramtwp.jdField_a_of_type_Two;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      uav localuav = (uav)localIterator.next();
      if ((paramtwp.jdField_a_of_type_Two instanceof txc)) {
        localuav.a = ((txc)paramtwp.jdField_a_of_type_Two).a;
      } else {
        localuav.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(tzl paramtzl)
  {
    this.jdField_a_of_type_Tzl = paramtzl;
  }
  
  protected void b() {}
  
  public void c()
  {
    veg.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzk
 * JD-Core Version:    0.7.0.1
 */