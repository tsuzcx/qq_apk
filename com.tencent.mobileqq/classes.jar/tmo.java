import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class tmo
  extends tno
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<tnz> a;
  public tjs a;
  protected tmp a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public tmo(@NonNull View paramView)
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
  
  public tmo(@NonNull ViewGroup paramViewGroup)
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
  
  public tmo a(Class<? extends tmo> paramClass)
  {
    if (this.jdField_a_of_type_Tmp != null) {
      return this.jdField_a_of_type_Tmp.b(paramClass);
    }
    return null;
  }
  
  public tmp a()
  {
    return this.jdField_a_of_type_Tmp;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, tjt paramtjt, @NonNull ArrayList<tnz> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Tjs = paramtjt.jdField_a_of_type_Tjs;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      tnz localtnz = (tnz)localIterator.next();
      if ((paramtjt.jdField_a_of_type_Tjs instanceof tkg)) {
        localtnz.a = ((tkg)paramtjt.jdField_a_of_type_Tjs).a;
      } else {
        localtnz.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(tmp paramtmp)
  {
    this.jdField_a_of_type_Tmp = paramtmp;
  }
  
  protected void b() {}
  
  public void c()
  {
    urk.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmo
 * JD-Core Version:    0.7.0.1
 */