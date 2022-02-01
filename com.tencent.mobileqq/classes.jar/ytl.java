import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class ytl
  extends bjub
{
  public ytl(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, bjtz parambjtz, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parambjtz == null) || (parambjtz.jdField_a_of_type_ArrayOfBjua == null) || (parambjtz.jdField_a_of_type_ArrayOfBjua.length == 0) || (parambjtz.jdField_a_of_type_ArrayOfBjua.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBjua);
    int j = 0;
    int n = 0;
    if (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int)) {
        a(parambjtz.jdField_a_of_type_ArrayOfBjua[n]);
      }
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int;
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].b = this.jdField_a_of_type_ArrayOfBjua[n].b;
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].c = 0;
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].d = -1;
      int k = parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int;
      Object localObject1 = parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_AndroidViewView;
      int m;
      if ((k < 0) || (k >= this.jdField_a_of_type_ArrayOfJavaUtilStack.length))
      {
        m = j;
        k = i;
        if (localObject1 == null) {
          break label532;
        }
        ((View)localObject1).setVisibility(8);
        k = j + 1;
        j = i;
        i = k;
      }
      for (;;)
      {
        n += 1;
        k = j;
        j = i;
        i = k;
        break;
        int i1;
        if (localObject1 == null)
        {
          synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
          {
            if (!this.jdField_a_of_type_ArrayOfJavaUtilStack[k].isEmpty()) {
              localObject1 = (View)this.jdField_a_of_type_ArrayOfJavaUtilStack[k].pop();
            }
            ??? = localObject1;
            if (localObject1 == null) {
              ??? = a(paramContext, k);
            }
            if (??? == null) {
              throw new NullPointerException("updateRightMenuView menuView is null");
            }
          }
          parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parambjtz.jdField_a_of_type_ArrayOfBjua[n], paramOnClickListener);
          if (parambjtz.jdField_a_of_type_ArrayOfBjua[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parambjtz.jdField_a_of_type_ArrayOfBjua[n].c);
          i1 = 0;
        }
        i += parambjtz.jdField_a_of_type_ArrayOfBjua[n].c;
        j += 1;
        ((View)localObject1).setVisibility(0);
        m = j;
        k = i;
        if (i1 != 0)
        {
          a(localLinearLayout, (View)localObject1, parambjtz.jdField_a_of_type_ArrayOfBjua[n], j);
          k = i;
          m = j;
        }
        label532:
        i = m;
        j = k;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bjua parambjua, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      parambjua = new LinearLayout.LayoutParams(parambjua.c, parambjua.d);
      paramView.setLayoutParams(parambjua);
    }
    for (;;)
    {
      parambjua.gravity = 16;
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambjua.c;
      localLayoutParams.height = parambjua.d;
      parambjua = localLayoutParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */