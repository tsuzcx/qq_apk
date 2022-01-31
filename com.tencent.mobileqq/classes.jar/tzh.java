import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class tzh
  extends uah
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<uas> a;
  public twl a;
  protected tzi a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public tzh(@NonNull View paramView)
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
  
  public tzh(@NonNull ViewGroup paramViewGroup)
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
  
  public tzh a(Class<? extends tzh> paramClass)
  {
    if (this.jdField_a_of_type_Tzi != null) {
      return this.jdField_a_of_type_Tzi.b(paramClass);
    }
    return null;
  }
  
  public tzi a()
  {
    return this.jdField_a_of_type_Tzi;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, twm paramtwm, @NonNull ArrayList<uas> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Twl = paramtwm.jdField_a_of_type_Twl;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      uas localuas = (uas)localIterator.next();
      if ((paramtwm.jdField_a_of_type_Twl instanceof twz)) {
        localuas.a = ((twz)paramtwm.jdField_a_of_type_Twl).a;
      } else {
        localuas.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(tzi paramtzi)
  {
    this.jdField_a_of_type_Tzi = paramtzi;
  }
  
  protected void b() {}
  
  public void c()
  {
    ved.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzh
 * JD-Core Version:    0.7.0.1
 */