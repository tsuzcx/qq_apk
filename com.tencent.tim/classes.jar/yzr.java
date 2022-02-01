import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;

public abstract class yzr
{
  @SuppressLint({"UseSparseArrays"})
  public static Map<Integer, ColorStateList> jdField_if = new HashMap(5);
  protected auvd a;
  protected yzr.a a;
  protected zam a;
  protected boolean bqa;
  public Entity c;
  protected Drawable ee;
  public QQAppInterface mApp;
  public Context mContext;
  protected int mMenuFlag;
  
  protected yzr(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.c = paramEntity;
  }
  
  protected static ColorStateList getColorStateList(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList2 = (ColorStateList)jdField_if.get(Integer.valueOf(paramInt));
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = paramContext.getResources().getColorStateList(paramInt);
      jdField_if.put(Integer.valueOf(paramInt), localColorStateList1);
    }
    return localColorStateList1;
  }
  
  protected int[] F()
  {
    return null;
  }
  
  protected int[] G()
  {
    return null;
  }
  
  protected int[] H()
  {
    return null;
  }
  
  public abstract View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener);
  
  protected auvd a(Context paramContext)
  {
    int i = aqnm.dip2px(152.0F);
    int j = xV();
    int k = xW();
    paramContext = F();
    int[] arrayOfInt1 = G();
    int[] arrayOfInt2 = H();
    return new yzs(this, j, k, new int[] { i }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a(int paramInt, auvd.b[] paramArrayOfb) {}
  
  public void a(View paramView, int paramInt, yzr.b paramb, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Auvd != null) {}
    for (int i = this.jdField_a_of_type_Auvd.a(this.mContext, paramView, paramInt, this.c, paramb, paramOnClickListener);; i = 0)
    {
      if ((this.jdField_a_of_type_Zam != null) && (this.jdField_a_of_type_Zam.bKH != -1))
      {
        if (paramInt != this.jdField_a_of_type_Zam.bKH) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  public void a(yzr.a parama)
  {
    this.jdField_a_of_type_Yzr$a = parama;
  }
  
  protected Drawable aH()
  {
    boolean bool = anlm.ayn();
    if ((this.ee != null) && (this.bqa != bool)) {
      this.ee = null;
    }
    if (this.ee == null) {}
    try
    {
      this.ee = this.mContext.getResources().getDrawable(2130845852);
      this.bqa = bool;
      label52:
      return this.ee;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label52;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  protected int xV()
  {
    return 1;
  }
  
  protected int xW()
  {
    return 1;
  }
  
  public int xX()
  {
    return this.mMenuFlag;
  }
  
  public static abstract interface a {}
  
  public static class b
    extends abgc.a
  {
    public Object item;
    public SingleLineTextView l;
    public SingleLineTextView m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzr
 * JD-Core Version:    0.7.0.1
 */