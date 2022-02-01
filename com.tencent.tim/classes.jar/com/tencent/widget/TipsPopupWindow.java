package com.tencent.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

public class TipsPopupWindow
  extends PopupWindow
  implements TipsLinearLayout.a
{
  private ImageView Hq;
  private TipsLinearLayout jdField_a_of_type_ComTencentWidgetTipsLinearLayout;
  private DismissRunnable jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable;
  private FrameLayout cu;
  private boolean dld;
  private boolean dle;
  private boolean dlf;
  private boolean isTipsShowing;
  
  private void dec()
  {
    if (!this.isTipsShowing) {
      return;
    }
    if (this.dld) {
      ((Animatable)this.Hq.getDrawable()).stop();
    }
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.exw();
  }
  
  private void exz()
  {
    if (this.dle) {
      this.cu.postDelayed(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable, 1000L);
    }
    while ((!this.isTipsShowing) || (this.dlf)) {
      return;
    }
    this.dlf = true;
    dec();
  }
  
  private void oo()
  {
    if (!this.isTipsShowing)
    {
      this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.atK();
      this.dle = true;
      this.dlf = false;
    }
    this.isTipsShowing = true;
    this.cu.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable);
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsPopupWindow", 2, "dismiss");
    }
    this.cu.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable);
    this.cu.postDelayed(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable, 300L);
  }
  
  public void exx()
  {
    if (this.dld) {
      ((Animatable)this.Hq.getDrawable()).start();
    }
    this.dle = false;
  }
  
  public void exy()
  {
    this.cu.post(new TipsPopupWindow.2(this));
  }
  
  public void showAsDropDown(View paramView)
  {
    super.showAsDropDown(paramView);
    oo();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    oo();
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    oo();
  }
  
  class DismissRunnable
    implements Runnable
  {
    public void run()
    {
      TipsPopupWindow.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TipsPopupWindow
 * JD-Core Version:    0.7.0.1
 */