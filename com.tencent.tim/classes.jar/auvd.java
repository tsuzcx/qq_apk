import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class auvd
{
  protected String TAG = auvd.class.getSimpleName();
  protected final auvd.b[] a;
  protected final Stack<View>[] a;
  protected final int euG;
  
  public auvd(int paramInt1, int paramInt2)
  {
    this.euG = paramInt1;
    if ((this.euG < 0) || ((this.euG > 0) && (paramInt2 < 1))) {
      throw new IllegalArgumentException("SwipRightMenuBuilder, menuTypeCount = " + paramInt2);
    }
    this.jdField_a_of_type_ArrayOfJavaUtilStack = new Stack[paramInt2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.jdField_a_of_type_ArrayOfJavaUtilStack[paramInt1] = new Stack();
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ArrayOfAuvd$b = new auvd.b[this.euG];
    paramInt1 = i;
    while (paramInt1 < this.euG)
    {
      this.jdField_a_of_type_ArrayOfAuvd$b[paramInt1] = new auvd.b();
      paramInt1 += 1;
    }
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
    while (n < this.euG)
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
        if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(8);
          k = j + 1;
          j = i;
          i = k;
          n += 1;
          k = j;
          j = i;
          i = k;
        }
      }
      else
      {
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
          ??? = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          if (??? != null) {
            break label594;
          }
          ??? = new LinearLayout.LayoutParams(parama.b[n].euH, parama.b[n].euI);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)???);
        }
      }
      for (;;)
      {
        ((LinearLayout.LayoutParams)???).gravity = 16;
        localLinearLayout.addView((View)localObject1, j);
        k = i;
        m = j;
        i = m;
        j = k;
        break;
        label594:
        ((LinearLayout.LayoutParams)???).width = parama.b[n].euH;
        ((LinearLayout.LayoutParams)???).height = parama.b[n].euI;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, auvd.b paramb, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, auvd.a parama, int paramInt)
  {
    if ((parama == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.euG > 0)
    {
      parama.b = new auvd.b[this.euG];
      int i = 0;
      while (i < this.euG)
      {
        parama.b[i] = new auvd.b();
        parama.b[i].dOe = -1;
        parama.b[i].euH = 0;
        parama.b[i].LA = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      parama.Lz = paramView;
      return paramContext;
      parama.b = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb);
  
  protected void a(auvd.b paramb)
  {
    if (paramb == null) {
      return;
    }
    if (paramb.LA != null)
    {
      ??? = paramb.LA.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((paramb.dOe >= 0) && (paramb.dOe < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[paramb.dOe].push(paramb.LA);
        }
        paramb.reset();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(paramb.LA);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
  
  public static class a
  {
    public View Lz;
    public auvd.b[] b;
  }
  
  public static class b
  {
    public View LA;
    public int dOe;
    public int dOf;
    public int euH;
    public int euI;
    
    public void reset()
    {
      this.dOe = -1;
      this.dOf = -1;
      this.euH = 0;
      this.euI = 0;
      this.LA = null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append("menuType = ").append(this.dOe).append(",").append("menuId = ").append(this.dOf).append(",").append("menuWidth = ").append(this.euH).append(",").append("menuHeight = ").append(this.euI).append(",").append("menuView = ").append(this.LA).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvd
 * JD-Core Version:    0.7.0.1
 */