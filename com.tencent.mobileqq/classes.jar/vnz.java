import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class vnz
  extends voz
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<vpk> a;
  public vld a;
  protected voa a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public vnz(@NonNull View paramView)
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
  
  public vnz(@NonNull ViewGroup paramViewGroup)
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
  
  public vnz a(Class<? extends vnz> paramClass)
  {
    if (this.jdField_a_of_type_Voa != null) {
      return this.jdField_a_of_type_Voa.b(paramClass);
    }
    return null;
  }
  
  public voa a()
  {
    return this.jdField_a_of_type_Voa;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, vle paramvle, @NonNull ArrayList<vpk> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vld = paramvle.jdField_a_of_type_Vld;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      vpk localvpk = (vpk)localIterator.next();
      if ((paramvle.jdField_a_of_type_Vld instanceof vlr)) {
        localvpk.a = ((vlr)paramvle.jdField_a_of_type_Vld).a;
      } else {
        localvpk.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(voa paramvoa)
  {
    this.jdField_a_of_type_Voa = paramvoa;
  }
  
  protected void b() {}
  
  public void c()
  {
    wsv.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnz
 * JD-Core Version:    0.7.0.1
 */