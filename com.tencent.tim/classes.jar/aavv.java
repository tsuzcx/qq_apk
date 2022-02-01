import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class aavv
  implements aawg
{
  private static final int clC = aqnm.dpToPx(72.0F);
  private static final int clD = aqnm.dpToPx(63.0F);
  private aawe a;
  private aqoa jdField_b_of_type_Aqoa;
  private BubblePopupWindow.b jdField_b_of_type_ComTencentWidgetBubblePopupWindow$b;
  private aqoa c;
  private int clT;
  private int clU;
  public int clV;
  public int clW;
  aqoa d;
  private BubblePopupWindow g;
  private View.OnClickListener x;
  
  private void checkDelegateBound()
  {
    if (this.a == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public void GI(int paramInt)
  {
    this.clT = paramInt;
  }
  
  public void GJ(int paramInt)
  {
    this.clU = paramInt;
  }
  
  public aavv.a a(View paramView, BaseChatPie paramBaseChatPie)
  {
    int m = 0;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int n = arrayOfInt[1];
    int i = arrayOfInt[1];
    i = paramView.getHeight() + i;
    paramView = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      paramView = paramBaseChatPie;
      if ((this instanceof aavo)) {
        paramView = ((aavo)this).f;
      }
    }
    int j;
    int k;
    if ((paramView != null) && (paramView.a != null) && (paramView.a.getVisibility() == 0))
    {
      paramView.a.getLocationInWindow(arrayOfInt);
      j = arrayOfInt[1];
      if (n + 0 >= clC + ImmersiveUtils.statusHeight) {
        break label344;
      }
      if (i + 0 >= clC + ImmersiveUtils.statusHeight) {
        break label221;
      }
      if ((this.clV == 0) || (this.clV + 0 <= clC + ImmersiveUtils.statusHeight)) {
        break label171;
      }
      i = this.clV + 0;
      k = m;
    }
    for (;;)
    {
      return new aavv.a(i, k);
      j = aqnm.getScreenHeight();
      break;
      label171:
      if ((this.clV != 0) && (this.clV + clD + 0 < j))
      {
        i = this.clV + 0;
        k = 1;
      }
      else
      {
        i = clC + ImmersiveUtils.statusHeight;
        k = m;
        continue;
        label221:
        i += 0;
        if (clD + i > j) {
          if ((this.clV != 0) && (this.clV + 0 > clC + ImmersiveUtils.statusHeight))
          {
            j = this.clV + 0;
            i = 0;
          }
        }
        for (;;)
        {
          k = i;
          i = j;
          break;
          if ((this.clV != 0) && (this.clV + clD + 0 < j))
          {
            j = this.clV + 0;
            i = 1;
          }
          else
          {
            j = clC + ImmersiveUtils.statusHeight + clD + 0;
            i = 0;
            continue;
            k = 1;
            j = i;
            i = k;
          }
        }
        label344:
        i = j;
        k = m;
        if (n <= j)
        {
          i = n + 0;
          k = m;
        }
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, paramaqoa, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.g != null) && (this.g.isShowing()))
    {
      this.g.dismiss();
      this.g = null;
    }
    this.g = new BubblePopupWindow(-2, -2);
    this.g.setContentView(aqgq.a(this.g, paramView.getContext(), paramaqoa, this.x, true));
    this.g.setBackgroundDrawable(new ColorDrawable(0));
    this.g.setOutsideTouchable(paramBoolean);
    if (paramBoolean) {
      this.g.setFocusable(true);
    }
    this.g.setSoftInputMode(1);
    this.g.setInputMethodMode(2);
    paramaqoa = this.g;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramaqoa.We(paramBoolean);
      this.g.a(this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$b);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.clT = paramInt1;
      this.clU = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, paramaqoa, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.jdField_b_of_type_Aqoa = paramaqoa;
    this.c = null;
    a(paramView, paramInt1, paramInt2, paramaqoa, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(aqoa paramaqoa, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, paramaqoa, paramInt3, false);
  }
  
  public void a(aqoa paramaqoa, boolean paramBoolean)
  {
    this.jdField_b_of_type_Aqoa = paramaqoa;
    this.c = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (paramaqoa != null))
    {
      localObject = paramaqoa.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        paramaqoa = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].getItemId() != 2131365509) {}
      }
    }
    for (;;)
    {
      localObject = new aqob();
      ((aqob)localObject).setItemId(2131377931);
      ((aqob)localObject).setTitle(acfp.m(2131704236));
      ((aqob)localObject).setDrawable(2130839095);
      paramaqoa.add(i + 1, localObject);
      this.c = new aqoa();
      paramaqoa = paramaqoa.iterator();
      for (;;)
      {
        if (paramaqoa.hasNext())
        {
          localObject = (aqob)paramaqoa.next();
          this.c.a((aqob)localObject);
          continue;
          i += 1;
          break;
        }
      }
      return;
      label171:
      i = 0;
    }
  }
  
  public void a(BubblePopupWindow.b paramb)
  {
    this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$b = paramb;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    checkDelegateBound();
    aqoa localaqoa;
    if (this.a.isSelected())
    {
      int i = this.a.endIndex();
      int j = this.a.startIndex();
      if (this.a.length() == i - j) {
        localaqoa = this.jdField_b_of_type_Aqoa;
      }
    }
    for (;;)
    {
      a(localaqoa, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.c != null)
      {
        localaqoa = this.c;
      }
      else
      {
        if (this.d == null)
        {
          this.d = new aqoa();
          this.d.Z(2131365509, acfp.m(2131704235), 2130839077);
          this.d.Z(2131377931, acfp.m(2131704233), 2130839095);
          this.d.Z(2131367523, acfp.m(2131704237), 2130839086);
          this.d.Z(2131366733, acfp.m(2131704234), 2130839085);
        }
        localaqoa = this.d;
        continue;
        localaqoa = this.jdField_b_of_type_Aqoa;
      }
    }
  }
  
  public void bind(@Nullable aawe paramaawe)
  {
    this.a = paramaawe;
  }
  
  public void czM()
  {
    this.g = null;
  }
  
  @Nullable
  public aawe delegate()
  {
    return this.a;
  }
  
  public void dismiss()
  {
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  public boolean isShow()
  {
    return (this.g != null) && (this.g.isShowing());
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
  }
  
  public int zp()
  {
    return this.clT;
  }
  
  public int zq()
  {
    return this.clU;
  }
  
  public static final class a
  {
    public final int clX;
    public final int clY;
    
    a(int paramInt1, int paramInt2)
    {
      this.clX = paramInt1;
      this.clY = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavv
 * JD-Core Version:    0.7.0.1
 */