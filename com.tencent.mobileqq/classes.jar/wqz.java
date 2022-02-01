import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class wqz
  extends wrz
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<wsk> a;
  public wod a;
  protected wra a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public wqz(@NonNull View paramView)
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
  
  public wqz(@NonNull ViewGroup paramViewGroup)
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
  
  public wqz a(Class<? extends wqz> paramClass)
  {
    if (this.jdField_a_of_type_Wra != null) {
      return this.jdField_a_of_type_Wra.b(paramClass);
    }
    return null;
  }
  
  public wra a()
  {
    return this.jdField_a_of_type_Wra;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, woe paramwoe, @NonNull ArrayList<wsk> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wod = paramwoe.jdField_a_of_type_Wod;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      wsk localwsk = (wsk)localIterator.next();
      if ((paramwoe.jdField_a_of_type_Wod instanceof wor)) {
        localwsk.a = ((wor)paramwoe.jdField_a_of_type_Wod).a;
      } else {
        localwsk.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(wra paramwra)
  {
    this.jdField_a_of_type_Wra = paramwra;
  }
  
  protected void b() {}
  
  public void c()
  {
    xvv.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqz
 * JD-Core Version:    0.7.0.1
 */