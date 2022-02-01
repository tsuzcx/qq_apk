import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

public class apok
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener, apop.a, AtPanelTouchController.a
{
  private View II;
  private apok.a jdField_a_of_type_Apok$a;
  private apop jdField_a_of_type_Apop;
  private LayerDrawable e;
  private Drawable fE;
  private Drawable fF;
  private BaseActivity mActivity;
  private Animation u;
  
  private apok(BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_Apop = new apop(this.mActivity);
    paramBaseActivity = (LayerDrawable)paramBaseActivity.getResources().getDrawable(2130838056);
    this.fE = new ColorDrawable();
    this.fF = paramBaseActivity.getDrawable(1);
    this.e = ((LayerDrawable)paramBaseActivity.mutate());
    this.e.setDrawableByLayerId(2131370140, this.fE);
    setBackgroundDrawable(this.e);
  }
  
  private static View a(apok paramapok, Activity paramActivity, int paramInt)
  {
    View localView = paramapok.getContentView();
    AtPanelTouchController localAtPanelTouchController = (AtPanelTouchController)localView.findViewById(2131365360);
    int i = wja.dp2px(60.0F, paramActivity.getResources());
    IndexBar localIndexBar = (IndexBar)localView.findViewById(2131369142);
    XListView localXListView = (XListView)localView.findViewById(2131380348);
    ViewGroup.LayoutParams localLayoutParams = localXListView.getLayoutParams();
    localXListView.setOverScrollMode(2);
    if (paramInt == 1) {
      localIndexBar.setVisibility(8);
    }
    for (localLayoutParams.height = -2;; localLayoutParams.height = -1)
    {
      localAtPanelTouchController.smoothScrollTo(0, 500);
      localAtPanelTouchController.setAtPanelTouchListener(paramapok);
      localAtPanelTouchController.setMode(paramInt);
      localAtPanelTouchController.setPadding(0, i, 0, 0);
      localXListView.setLayoutParams(localLayoutParams);
      return localView;
      localIndexBar.setVisibility(0);
      ListAdapter localListAdapter = localXListView.getAdapter();
      if (((localListAdapter instanceof apol)) && (((apol)localListAdapter).Ly() == 1)) {
        localIndexBar.setVisibility(8);
      }
      i = wja.dp2px(40.0F, paramActivity.getResources());
    }
  }
  
  public static apok a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131558681, null);
    apok localapok = new apok(paramBaseActivity, localView, paramInt1, paramInt2);
    a(localapok, paramBaseActivity, 1);
    localapok.setFocusable(false);
    localView.setOnClickListener(localapok);
    ((TextView)localView.findViewById(2131363028)).setOnClickListener(localapok);
    ((RelativeLayout)localView.findViewById(2131363029)).setOnClickListener(localapok);
    localapok.setInputMethodMode(32);
    localapok.setInputMethodMode(1);
    localapok.setClippingEnabled(false);
    localapok.setOutsideTouchable(true);
    if (AppSetting.enableTalkBack) {
      a(localapok);
    }
    return localapok;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.enableTalkBack) {}
    for (;;)
    {
      return;
      Method[] arrayOfMethod = PopupWindow.class.getMethods();
      int j = arrayOfMethod.length;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (localMethod.getName().equals("setTouchModal")) {
          try
          {
            localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
            return;
          }
          catch (Exception paramPopupWindow)
          {
            paramPopupWindow.printStackTrace();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public void QR(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e.setDrawableByLayerId(2131370140, this.fE);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PopupCardDialog", 2, "JSKJSSKSKSKSK+" + paramBoolean);
      }
      return;
      this.e.setDrawableByLayerId(2131370140, this.fF);
    }
  }
  
  public void VO(int paramInt)
  {
    dismiss();
  }
  
  public void a(apok.a parama)
  {
    this.jdField_a_of_type_Apok$a = parama;
  }
  
  public void bf(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getHeight();
    if (this.II == null)
    {
      paramInt3 = 0;
      if (!apop.cRQ) {
        break label67;
      }
    }
    label67:
    for (int i = 0;; i = ImmersiveUtils.getStatusBarHeight(this.mActivity))
    {
      paramInt2 = paramInt2 - paramInt3 + i;
      if (paramInt2 != j) {
        update(0, 0, -1, paramInt2);
      }
      a(this, this.mActivity, paramInt1);
      return;
      paramInt3 = this.II.getHeight();
      break;
    }
  }
  
  public void bg(int paramInt1, int paramInt2, int paramInt3)
  {
    bf(paramInt1, paramInt2, -1);
  }
  
  @TargetApi(16)
  public void dismiss()
  {
    this.jdField_a_of_type_Apop.removeListener();
    this.jdField_a_of_type_Apop.il(null);
    this.II = null;
    if (Build.VERSION.SDK_INT >= 11) {
      super.dismiss();
    }
    while ((!isShowing()) || ((this.u != null) && (!this.u.hasEnded()))) {
      return;
    }
    if (this.u == null)
    {
      this.u = AnimationUtils.loadAnimation(this.mActivity, 2130772395);
      this.u.setAnimationListener(this);
    }
    getContentView().startAnimation(this.u);
  }
  
  public void eaS()
  {
    if (!isShowing()) {
      getContentView().scrollTo(0, -1000);
    }
  }
  
  public void jT(int paramInt1, int paramInt2)
  {
    View localView = getContentView().findViewById(2131362464);
    if (localView == null) {
      return;
    }
    localView.setVisibility(paramInt1);
    ((TextView)localView.findViewById(2131370815)).setText(localView.getResources().getText(paramInt2));
    if (paramInt2 != 2131690102) {}
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      getContentView().findViewById(2131362376).setVisibility(paramInt1);
      return;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupCardDialog", 2, "onAnimationEnd");
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupCardDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363028) {
      if (this.jdField_a_of_type_Apok$a != null) {
        this.jdField_a_of_type_Apok$a.ii(paramView);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() != 2131363029) {
        dismiss();
      }
    }
  }
  
  public void scrollToTop()
  {
    if (this.mActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.mActivity.getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.mActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.II = paramView;
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Apop.a(this);
    this.jdField_a_of_type_Apop.il(this.II);
  }
  
  public static abstract interface a
  {
    public abstract void ii(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apok
 * JD-Core Version:    0.7.0.1
 */