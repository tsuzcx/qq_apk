import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class rsy
  extends auve
{
  public rsy(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parama == null) || (parama.b == null) || (parama.b.length == 0) || (parama.b.length > this.euG)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfAuvd$b);
    int j = 0;
    int n = 0;
    if (n < this.euG)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parama.b[n].dOe != this.jdField_a_of_type_ArrayOfAuvd$b[n].dOe)) {
        a(parama.b[n]);
      }
      parama.b[n].dOe = this.jdField_a_of_type_ArrayOfAuvd$b[n].dOe;
      parama.b[n].dOf = this.jdField_a_of_type_ArrayOfAuvd$b[n].dOf;
      parama.b[n].euH = 0;
      parama.b[n].euI = -1;
      int k = parama.b[n].dOe;
      Object localObject1 = parama.b[n].LA;
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
          parama.b[n].LA = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parama.b[n], paramOnClickListener);
          if (parama.b[n].euH >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parama.b[n].euH);
          i1 = 0;
        }
        i += parama.b[n].euH;
        j += 1;
        ((View)localObject1).setVisibility(0);
        m = j;
        k = i;
        if (i1 != 0)
        {
          a(localLinearLayout, (View)localObject1, parama.b[n], j);
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
  
  protected void a(ViewGroup paramViewGroup, View paramView, auvd.b paramb, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramb = new LinearLayout.LayoutParams(paramb.euH, paramb.euI);
      paramView.setLayoutParams(paramb);
    }
    for (;;)
    {
      paramb.gravity = 16;
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = paramb.euH;
      localLayoutParams.height = paramb.euI;
      paramb = localLayoutParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsy
 * JD-Core Version:    0.7.0.1
 */