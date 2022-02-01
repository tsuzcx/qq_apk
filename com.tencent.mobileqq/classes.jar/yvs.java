import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class yvs<T extends yvr>
{
  protected int a;
  public final View a;
  public T a;
  
  protected yvs(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramContext, paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new NullPointerException("onCreateView can not return null");
    }
  }
  
  protected abstract View a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public void a()
  {
    this.jdField_a_of_type_Yvr = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(T paramT, int paramInt)
  {
    this.jdField_a_of_type_Yvr = paramT;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Yvr != null) && (this.jdField_a_of_type_Yvr.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvs
 * JD-Core Version:    0.7.0.1
 */