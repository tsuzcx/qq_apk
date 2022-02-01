import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class xfu
  extends xgu
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<xhf> a;
  public xcy a;
  protected xfv a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public xfu(@NonNull View paramView)
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
  
  public xfu(@NonNull ViewGroup paramViewGroup)
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
  
  public xfu a(Class<? extends xfu> paramClass)
  {
    if (this.jdField_a_of_type_Xfv != null) {
      return this.jdField_a_of_type_Xfv.b(paramClass);
    }
    return null;
  }
  
  public xfv a()
  {
    return this.jdField_a_of_type_Xfv;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, xcz paramxcz, @NonNull ArrayList<xhf> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xcy = paramxcz.jdField_a_of_type_Xcy;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      xhf localxhf = (xhf)localIterator.next();
      if ((paramxcz.jdField_a_of_type_Xcy instanceof xdm)) {
        localxhf.a = ((xdm)paramxcz.jdField_a_of_type_Xcy).a;
      } else {
        localxhf.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(xfv paramxfv)
  {
    this.jdField_a_of_type_Xfv = paramxfv;
  }
  
  protected void b() {}
  
  public void c()
  {
    ykq.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfu
 * JD-Core Version:    0.7.0.1
 */