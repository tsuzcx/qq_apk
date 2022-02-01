import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class xpo
  extends xqo
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<xqz> a;
  public xms a;
  protected xpp a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public xpo(@NonNull View paramView)
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
  
  public xpo(@NonNull ViewGroup paramViewGroup)
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
  
  public xpo a(Class<? extends xpo> paramClass)
  {
    if (this.jdField_a_of_type_Xpp != null) {
      return this.jdField_a_of_type_Xpp.b(paramClass);
    }
    return null;
  }
  
  public xpp a()
  {
    return this.jdField_a_of_type_Xpp;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, xmt paramxmt, @NonNull ArrayList<xqz> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xms = paramxmt.jdField_a_of_type_Xms;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      xqz localxqz = (xqz)localIterator.next();
      if ((paramxmt.jdField_a_of_type_Xms instanceof xng)) {
        localxqz.a = ((xng)paramxmt.jdField_a_of_type_Xms).a;
      } else {
        localxqz.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(xpp paramxpp)
  {
    this.jdField_a_of_type_Xpp = paramxpp;
  }
  
  protected void b() {}
  
  public void c()
  {
    yuk.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpo
 * JD-Core Version:    0.7.0.1
 */