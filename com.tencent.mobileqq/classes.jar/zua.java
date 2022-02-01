import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class zua
  extends blpy
{
  public zua(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, blpw paramblpw, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (paramblpw == null) || (paramblpw.jdField_a_of_type_ArrayOfBlpx == null) || (paramblpw.jdField_a_of_type_ArrayOfBlpx.length == 0) || (paramblpw.jdField_a_of_type_ArrayOfBlpx.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBlpx);
    int j = 0;
    int n = 0;
    if (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int)) {
        a(paramblpw.jdField_a_of_type_ArrayOfBlpx[n]);
      }
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int;
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].b = this.jdField_a_of_type_ArrayOfBlpx[n].b;
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c = 0;
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].d = -1;
      int k = paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int;
      Object localObject1 = paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_AndroidViewView;
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
          paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, paramblpw.jdField_a_of_type_ArrayOfBlpx[n], paramOnClickListener);
          if (paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c);
          i1 = 0;
        }
        i += paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c;
        j += 1;
        ((View)localObject1).setVisibility(0);
        m = j;
        k = i;
        if (i1 != 0)
        {
          a(localLinearLayout, (View)localObject1, paramblpw.jdField_a_of_type_ArrayOfBlpx[n], j);
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
  
  protected void a(ViewGroup paramViewGroup, View paramView, blpx paramblpx, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramblpx = new LinearLayout.LayoutParams(paramblpx.c, paramblpx.d);
      paramView.setLayoutParams(paramblpx);
    }
    for (;;)
    {
      paramblpx.gravity = 16;
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = paramblpx.c;
      localLayoutParams.height = paramblpx.d;
      paramblpx = localLayoutParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zua
 * JD-Core Version:    0.7.0.1
 */