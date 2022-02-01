import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.b;
import com.tencent.qphone.base.util.QLog;

public abstract class afnq
  extends afnw
{
  private static afnr a;
  public int cSA;
  protected Context context;
  protected SparseArray<View> cx;
  
  public afnq(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramInt1);
    if (paramContext == null) {
      throw new IllegalArgumentException("Context MUST NOT be null!!!");
    }
    this.context = paramContext;
    this.cSA = paramInt2;
    this.cx = new SparseArray();
  }
  
  public static void daU()
  {
    if (a != null)
    {
      a.destroy();
      a = null;
    }
  }
  
  private boolean jw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  protected View I(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, " createEmoticonPanelView, type=" + paramInt);
    }
    long l = System.currentTimeMillis();
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelViewBinder", 2, "[Performance] createEmoticonPanelView, type=" + paramInt + ",duration=" + (System.currentTimeMillis() - l));
      }
      return localObject;
      localObject = new EmoticonLinearLayout(this.context, null);
      ((EmoticonLinearLayout)localObject).setPanelViewType(paramInt);
    }
  }
  
  public View J(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, "getEmoticonPanelView, pageIndex=" + paramInt + ",viewBinder=" + this);
    }
    int i = hn(paramInt);
    View localView1 = null;
    if (a != null) {
      localView1 = a.K(i);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = I(i);
    }
    if (localView2 != null)
    {
      if (this.cx == null) {
        this.cx = new SparseArray();
      }
      this.cx.put(paramInt, localView2);
      ai(localView2, paramInt);
    }
    return localView2;
  }
  
  public void MO(int paramInt)
  {
    if (this.cx == null) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = (View)this.cx.get(paramInt);
        } while (localView == null);
        this.cx.remove(paramInt);
        paramInt = hn(paramInt);
      } while (!jw(paramInt));
      if (a == null) {
        a = new afnr();
      }
    } while (a.c(paramInt, localView));
  }
  
  protected abstract void ai(View paramView, int paramInt);
  
  public void destroy()
  {
    this.context = null;
    if (this.cx != null) {
      this.cx.clear();
    }
  }
  
  protected abstract int hn(int paramInt);
  
  class a
    extends EmoticonLinearLayout.b
  {
    private int cRV;
    private int cSB = (int)(afnq.this.context.getResources().getDisplayMetrics().density * 30.0F);
    
    public a(int paramInt)
    {
      this.cRV = paramInt;
    }
    
    public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
    {
      ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131366331);
      localImageView.setVisibility(0);
      localImageView.setTag(Boolean.valueOf(false));
      afmi localafmi = a(paramInt);
      paramRelativeLayout.setTag(localafmi);
      if ((localafmi != null) && ((localafmi instanceof afqr)))
      {
        paramViewGroup = (afqr)localafmi;
        paramInt = paramViewGroup.code;
        if (paramViewGroup.ahx != 1) {
          break label256;
        }
        if ((paramInt >= 0) && (paramInt < aoff.hj.length))
        {
          String str = aoff.hj[paramInt];
          paramViewGroup = str;
          if (str != null)
          {
            paramViewGroup = str;
            if (str.startsWith("/"))
            {
              paramViewGroup = str;
              if (str.length() > 1) {
                paramViewGroup = str.substring(1);
              }
            }
          }
          if (paramViewGroup != null) {
            paramRelativeLayout.setContentDescription(paramViewGroup);
          }
        }
      }
      label255:
      do
      {
        break label255;
        paramViewGroup = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
        float f = afnq.this.context.getResources().getDisplayMetrics().density;
        if (localafmi == null) {
          break;
        }
        if ((localafmi.type == 1) || (localafmi.type == 2) || (localafmi.type == 7))
        {
          paramViewGroup.width = this.cSB;
          paramViewGroup.height = this.cSB;
        }
        if (localafmi.type != -1)
        {
          paramRelativeLayout = localafmi.b(afnq.this.context, f);
          if (paramRelativeLayout != null) {
            localImageView.setImageDrawable(paramRelativeLayout);
          }
          for (;;)
          {
            localImageView.setBackgroundDrawable(null);
            return;
            if (paramViewGroup.ahx != 2) {
              break;
            }
            paramRelativeLayout.setContentDescription(aoff.fv(paramInt));
            break;
            localImageView.setVisibility(4);
          }
        }
      } while (!"delete".equals(localafmi.action));
      label256:
      localImageView.setImageResource(2130840073);
      paramRelativeLayout.setContentDescription(acfp.m(2131705826));
      return;
      localImageView.setImageDrawable(null);
      localImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnq
 * JD-Core Version:    0.7.0.1
 */