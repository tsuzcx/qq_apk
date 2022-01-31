import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.widget.DropdownView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class eyd
  extends AutoCompleteTextView
{
  private boolean jdField_a_of_type_Boolean;
  
  public eyd(DropdownView paramDropdownView, Context paramContext)
  {
    super(paramContext);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public eyd(DropdownView paramDropdownView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public eyd(DropdownView paramDropdownView, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean enoughToFilter()
  {
    return true;
  }
  
  public boolean isPopupShowing()
  {
    if (this.jdField_a_of_type_Boolean) {
      return super.isPopupShowing();
    }
    return false;
  }
  
  public void onEditorAction(int paramInt)
  {
    if (paramInt == 5)
    {
      View localView = focusSearch(130);
      if ((localView != null) && (!localView.requestFocus(130))) {
        throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
      }
    }
    else
    {
      super.onEditorAction(paramInt);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    try
    {
      if (isPopupShowing()) {
        dismissDropDown();
      }
      return;
    }
    catch (Exception paramCharSequence) {}
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt) {}
  
  public void showDropDown()
  {
    super.showDropDown();
    if (Build.VERSION.SDK_INT <= 8) {
      return;
    }
    try
    {
      Object localObject1 = getClass().getSuperclass().getDeclaredField("mDropDownList");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(this);
      localObject1.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(0) });
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject2 = getClass().getSuperclass().getDeclaredField("mPopup");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(this);
        Object localObject3 = localObject2.getClass().getDeclaredField("mDropDownList");
        ((Field)localObject3).setAccessible(true);
        localObject3 = ((Field)localObject3).get(localObject2);
        localObject3.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject3, new Object[] { Integer.valueOf(0) });
        ((PopupWindow)localObject2).setAnimationStyle(2130968638);
        return;
      }
      catch (Exception localException2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eyd
 * JD-Core Version:    0.7.0.1
 */