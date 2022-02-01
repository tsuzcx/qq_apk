import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.widget.BubblePopupWindow;
import mqq.util.WeakReference;

public class xad
  implements ArkViewImplement.InputCallback
{
  private WeakReference<ArkAppView> ae;
  private ViewGroup dn;
  private BubblePopupWindow j;
  private ImageView sO;
  private ImageView sP;
  private ImageView sQ;
  
  public xad(ArkAppView paramArkAppView)
  {
    this.ae = new WeakReference(paramArkAppView);
  }
  
  private void fi(View paramView)
  {
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.setVisibility(8);
    }
  }
  
  private void r(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.animate().x(paramInt1).y(paramInt2).setDuration(0L).start();
    }
  }
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    ArkAppView localArkAppView = (ArkAppView)this.ae.get();
    if (localArkAppView == null) {}
    do
    {
      return;
      paramView = (ViewGroup)localArkAppView.getParent();
      if (this.dn != null) {
        paramView = this.dn;
      }
    } while (paramView == null);
    if (paramBoolean)
    {
      Object localObject2 = localArkAppView.getResources().getDrawable(2130838745);
      Object localObject1 = localArkAppView.getResources().getDrawable(2130838744);
      localArkAppView.setInputSetSelectHolderSize(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localArkAppView.setInputSetCaretHolderSize(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (this.sO == null)
      {
        this.sO = new ImageView(localArkAppView.getContext());
        this.sO.setBackgroundDrawable((Drawable)localObject2);
        this.sO.setScaleX(-1.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.sO, localLayoutParams);
        this.sO.setVisibility(8);
        this.sO.setOnTouchListener(localArkAppView);
      }
      if (this.sP == null)
      {
        this.sP = new ImageView(localArkAppView.getContext());
        this.sP.setBackgroundDrawable((Drawable)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.sP, (ViewGroup.LayoutParams)localObject2);
        this.sP.setVisibility(8);
        this.sO.setOnTouchListener(localArkAppView);
      }
      if (this.sQ == null)
      {
        this.sQ = new ImageView(localArkAppView.getContext());
        this.sQ.setBackgroundDrawable((Drawable)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.sQ, (ViewGroup.LayoutParams)localObject1);
        this.sQ.setVisibility(8);
        this.sQ.setOnTouchListener(localArkAppView);
      }
    }
    fi(this.sO);
    fi(this.sP);
    fi(this.sQ);
  }
  
  public void onHideMenu(View paramView)
  {
    if (this.j != null)
    {
      this.j.dismiss();
      this.j = null;
    }
  }
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkAppView localArkAppView = (ArkAppView)this.ae.get();
    if (localArkAppView == null) {}
    do
    {
      return;
      paramView = (ViewGroup)localArkAppView.getParent();
      if (this.dn != null) {
        paramView = this.dn;
      }
    } while (paramView == null);
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4)))
    {
      int k = this.sO.getWidth();
      int i = k;
      if (k <= 0) {
        i = localArkAppView.getResources().getDrawable(2130838745).getIntrinsicWidth();
      }
      r(this.sO, localArkAppView.getLeft() + paramInt1 - i, localArkAppView.getTop() + paramInt2);
      if ((paramInt3 <= 0) || (paramInt4 <= 0) || ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4))) {
        break label255;
      }
      r(this.sP, localArkAppView.getLeft() + paramInt3, localArkAppView.getTop() + paramInt4);
    }
    for (;;)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label266;
      }
      paramInt2 = this.sQ.getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = localArkAppView.getResources().getDrawable(2130838744).getIntrinsicWidth();
      }
      r(this.sQ, localArkAppView.getLeft() + paramInt3 - paramInt1 / 2, localArkAppView.getTop() + paramInt4);
      return;
      fi(this.sO);
      break;
      label255:
      fi(this.sP);
    }
    label266:
    fi(this.sQ);
  }
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkAppView localArkAppView = (ArkAppView)this.ae.get();
    if (localArkAppView == null) {
      return;
    }
    if (this.j != null)
    {
      this.j.dismiss();
      this.j = null;
    }
    aqoa localaqoa = new aqoa();
    if (paramInt4 == 2)
    {
      localaqoa.dV(0, acfp.m(2131702781));
      localaqoa.dV(1, acfp.m(2131702777));
      localaqoa.dV(2, acfp.m(2131702778));
    }
    for (;;)
    {
      this.j = aqgq.a(paramView, paramInt1, paramInt2, paramInt3 + localArkAppView.getResources().getDrawable(2130838744).getIntrinsicHeight(), localaqoa, new xae(this, paramInt4, (ArkViewImplement.ArkViewInterface)paramView));
      return;
      if (paramInt4 == 1)
      {
        localaqoa.dV(0, acfp.m(2131702780));
        localaqoa.dV(1, acfp.m(2131702776));
        localaqoa.dV(2, acfp.m(2131702779));
      }
      else
      {
        localaqoa.dV(0, acfp.m(2131702782));
      }
    }
  }
  
  public void setInputHolderAnchor(ViewGroup paramViewGroup)
  {
    this.dn = paramViewGroup;
  }
  
  public int wo()
  {
    if (this.sQ != null) {
      return this.sQ.getHeight();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xad
 * JD-Core Version:    0.7.0.1
 */