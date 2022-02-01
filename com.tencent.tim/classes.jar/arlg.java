import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class arlg
  implements View.OnClickListener
{
  public ImageView FV;
  public arle a;
  public FloatingScreenStatusReceiver a;
  public FloatingScreenContainer b;
  public FrameLayout cn;
  public RelativeLayout et;
  public Context mContext;
  
  arlg(Context paramContext)
  {
    this.mContext = paramContext;
    initViews(paramContext);
  }
  
  public void YY(int paramInt)
  {
    this.b.YY(paramInt);
  }
  
  public void Ze(int paramInt)
  {
    if ((paramInt != 1) || (this.jdField_a_of_type_Arle == null) || (!this.jdField_a_of_type_Arle.MM()))
    {
      this.jdField_a_of_type_Arle = null;
      if ((this.b != null) && (this.b.aGP()))
      {
        iK(this.cn);
        this.cn.removeAllViews();
        a(false, new View[] { this.FV });
        this.jdField_a_of_type_Arle = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.destroy();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = null;
      }
    }
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().build();
      }
    }
    else
    {
      iJ(paramView);
      kF(localFloatingScreenParams.getInnerRoundCorner(), localFloatingScreenParams.getOuterRoundCorner());
      iK(this.cn);
      this.b.a(this.cn, localFloatingScreenParams);
      ekd();
      eke();
      return 0;
    }
    return 2;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return null;
  }
  
  public void a(arle paramarle)
  {
    this.jdField_a_of_type_Arle = paramarle;
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener) {}
  
  public void a(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    label11:
    View localView;
    if (i < j)
    {
      localView = paramVarArgs[i];
      if (localView != null)
      {
        if (!paramBoolean) {
          break label44;
        }
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      i += 1;
      break label11;
      break;
      label44:
      localView.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        View localView = paramVarArgs[i];
        if (localView != null) {
          localView.setEnabled(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  public void bh(float paramFloat)
  {
    this.b.bh(paramFloat);
  }
  
  public void ekd()
  {
    a(true, new View[] { this.b, this.FV });
  }
  
  public void eke() {}
  
  public void g(View... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        View localView = paramVarArgs[i];
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        i += 1;
      }
    }
  }
  
  public void iJ(View paramView)
  {
    this.cn.removeAllViews();
    iK(paramView);
    paramView.setId(2131375046);
    this.cn.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    iK(this.et);
    this.cn.addView(this.et, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void iK(View paramView)
  {
    if (paramView != null) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
      return;
    }
    catch (ClassCastException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void initViews(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.b = new FloatingScreenContainer(paramContext);
    this.b.setBackgroundColor(paramContext.getResources().getColor(2131167595));
    this.cn = new FrameLayout(paramContext);
    this.cn.setId(2131375044);
    this.cn.setBackgroundColor(paramContext.getResources().getColor(2131167595));
    this.et = ((RelativeLayout)View.inflate(paramContext, 2131561789, null));
    this.FV = ((ImageView)this.et.findViewById(2131375031));
    this.FV.setContentDescription(acfp.m(2131706343));
    g(new View[] { this.et, this.FV });
  }
  
  public void kF(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.b != null)
      {
        this.b.setOutlineProvider(new arkq(paramInt2));
        this.b.setClipToOutline(true);
        this.b.setElevation(15.0F);
        afxl.setBackground(this.b, this.mContext.getResources().getDrawable(2130847109));
      }
      if (this.cn != null)
      {
        this.cn.setOutlineProvider(new arkq(paramInt1));
        this.cn.setClipToOutline(true);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131375031) {
      Ze(1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131375037) && (this.jdField_a_of_type_Arle != null)) {
        this.jdField_a_of_type_Arle.ap(this.b.getFloatingCenterX(), this.b.getFloatingCenterY());
      }
    }
  }
  
  public void setFullScreenViewClickListener(arld paramarld) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlg
 * JD-Core Version:    0.7.0.1
 */