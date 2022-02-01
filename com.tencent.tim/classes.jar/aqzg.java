import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.3;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class aqzg
{
  public View AM;
  public View AN;
  public View AO;
  public View AP;
  public View AQ;
  public View AR;
  public View AS;
  public arcd.a a;
  public arcd a;
  public Hole a;
  int cpO;
  int cpP;
  Runnable fy = new SwiftFloatViewUI.3(this);
  public View lY;
  Rect mRect = new Rect();
  public int mScreenHeight;
  public int mScreenWidth;
  public View mask;
  
  public aqzg(arcd paramarcd)
  {
    this.jdField_a_of_type_Arcd = paramarcd;
    this.jdField_a_of_type_Arcd$a = paramarcd.jdField_a_of_type_Arcd$a;
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics;
    int i;
    if (this.jdField_a_of_type_Arcd.s != null)
    {
      localDisplayMetrics = this.jdField_a_of_type_Arcd.s.getResources().getDisplayMetrics();
      if (!this.jdField_a_of_type_Arcd$a.cYn) {
        break label554;
      }
      if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
        break label536;
      }
      i = localDisplayMetrics.heightPixels;
      label54:
      this.mScreenWidth = i;
      if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
        break label545;
      }
      i = localDisplayMetrics.widthPixels;
      label78:
      this.mScreenHeight = i;
      this.AM = paramView.findViewById(2131367230);
      this.AO = paramView.findViewById(2131379710);
      this.AN = paramView.findViewById(2131363712);
      this.AP = paramView.findViewById(2131366571);
      this.lY = paramView.findViewById(2131378168);
      this.AR = paramView.findViewById(2131378017);
      this.AS = paramView.findViewById(2131371927);
      this.AQ = paramView.findViewById(2131367362);
      this.mask = paramView.findViewById(2131371159);
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)paramView.findViewById(2131368554));
      cEj();
      if (this.jdField_a_of_type_Arcd$a.cYm) {
        iw(paramView);
      }
      if ((this.jdField_a_of_type_Arcd$a.Dr & 1L) != 0L)
      {
        this.lY.setVisibility(0);
        this.AM.setVisibility(0);
      }
      if ((this.jdField_a_of_type_Arcd$a.Dr & 0x4) != 0L)
      {
        this.AP.setVisibility(0);
        this.AM.setVisibility(0);
      }
      if ((this.jdField_a_of_type_Arcd$a.Dr & 0x2) != 0L)
      {
        this.AS.setVisibility(0);
        this.AM.setVisibility(0);
      }
      if ((((this.jdField_a_of_type_Arcd$a.Ds & 0x800) != 0L) || ((this.jdField_a_of_type_Arcd$a.gK & 0x80000000) != 0L)) && (this.jdField_a_of_type_Arcd.c != null) && (jml.a().cZ(this.jdField_a_of_type_Arcd.c.mUrl)))
      {
        this.AQ.setVisibility(0);
        this.AM.setVisibility(0);
      }
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("secondHandSharePre", 0);
      if (!localSharedPreferences.getBoolean("first_float_tip", true)) {
        break label623;
      }
      this.AO.setVisibility(0);
      localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new aqzh(this, paramView, localDisplayMetrics));
    }
    for (;;)
    {
      paramView = new aqzi(this, localDisplayMetrics);
      this.AP.setOnClickListener(paramOnClickListener);
      this.lY.setOnClickListener(paramOnClickListener);
      this.AS.setOnClickListener(paramOnClickListener);
      this.AR.setOnClickListener(paramOnClickListener);
      this.AQ.setOnClickListener(paramOnClickListener);
      this.AM.setOnTouchListener(paramView);
      this.AO.setOnTouchListener(paramView);
      this.mask.setOnTouchListener(paramView);
      return;
      localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      break;
      label536:
      i = localDisplayMetrics.widthPixels;
      break label54;
      label545:
      i = localDisplayMetrics.heightPixels;
      break label78;
      label554:
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels)
      {
        i = localDisplayMetrics.heightPixels;
        label573:
        this.mScreenWidth = i;
        if (localDisplayMetrics.heightPixels >= localDisplayMetrics.widthPixels) {
          break label614;
        }
      }
      label614:
      for (i = localDisplayMetrics.widthPixels;; i = localDisplayMetrics.heightPixels)
      {
        this.mScreenHeight = i;
        break;
        i = localDisplayMetrics.widthPixels;
        break label573;
      }
      label623:
      this.AO.setVisibility(8);
    }
  }
  
  public void cEj()
  {
    if ((this.jdField_a_of_type_Arcd$a != null) && (this.jdField_a_of_type_Arcd$a.cYn) && (this.jdField_a_of_type_Arcd$a.cYP) && (this.AM != null) && (8 == this.AO.getVisibility())) {
      cEk();
    }
  }
  
  public void cEk()
  {
    int i;
    int j;
    if (this.mScreenHeight > this.mScreenWidth)
    {
      i = this.mScreenWidth;
      j = this.mScreenHeight;
      if (this.jdField_a_of_type_Arcd.s == null) {
        break label115;
      }
    }
    label115:
    for (DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Arcd.s.getResources().getDisplayMetrics();; localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics())
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AM.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(j - localDisplayMetrics.density * 70.0F));
      localLayoutParams.topMargin = (i / 2 - this.AM.getWidth() / 2);
      this.AM.setLayoutParams(localLayoutParams);
      return;
      i = this.mScreenHeight;
      j = this.mScreenWidth;
      break;
    }
  }
  
  @TargetApi(11)
  public void ct(Activity paramActivity)
  {
    if (auwa.hasNavBar(paramActivity))
    {
      paramActivity = paramActivity.findViewById(16908290);
      paramActivity.addOnLayoutChangeListener(new aqzk(this, paramActivity));
    }
  }
  
  public void egz()
  {
    if ((this.AM != null) && (8 == this.AO.getVisibility())) {
      if (this.jdField_a_of_type_Arcd.s == null) {
        break label91;
      }
    }
    label91:
    for (DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Arcd.s.getResources().getDisplayMetrics();; localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics())
    {
      this.mScreenWidth = localDisplayMetrics.widthPixels;
      this.mScreenHeight = localDisplayMetrics.heightPixels;
      if ((this.jdField_a_of_type_Arcd$a == null) || (!this.jdField_a_of_type_Arcd$a.cYn) || (!this.jdField_a_of_type_Arcd$a.cYP)) {
        break;
      }
      cEk();
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AM.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(this.mScreenWidth - 50.0F * localDisplayMetrics.density));
    localLayoutParams.topMargin = ((int)(this.mScreenHeight - localDisplayMetrics.density * 100.0F));
    this.AM.setLayoutParams(localLayoutParams);
  }
  
  public void iw(View paramView)
  {
    int i = paramView.getResources().getColor(2131167487);
    if (this.jdField_a_of_type_Arcd$a.cYm) {
      i = paramView.getResources().getColor(2131167488);
    }
    for (;;)
    {
      if ((this.lY != null) && ((this.lY instanceof TextView))) {
        if (!this.jdField_a_of_type_Arcd$a.cYm) {
          break label338;
        }
      }
      label300:
      label317:
      label324:
      label331:
      label338:
      for (int j = 2130843475;; j = 2130843474)
      {
        ((TextView)this.lY).setCompoundDrawablesWithIntrinsicBounds(0, j, 0, 0);
        ((TextView)this.lY).setTextColor(i);
        if ((this.AR != null) && ((this.AR instanceof TextView))) {
          if (!this.jdField_a_of_type_Arcd$a.cYm) {
            break label331;
          }
        }
        for (j = 2130843472;; j = 2130843471)
        {
          ((TextView)this.AR).setCompoundDrawablesWithIntrinsicBounds(0, j, 0, 0);
          ((TextView)this.AR).setTextColor(i);
          if ((this.AQ != null) && ((this.AQ instanceof TextView))) {
            if (!this.jdField_a_of_type_Arcd$a.cYm) {
              break label324;
            }
          }
          for (j = 2130843466;; j = 2130843465)
          {
            ((TextView)this.AQ).setCompoundDrawablesWithIntrinsicBounds(0, j, 0, 0);
            ((TextView)this.AQ).setTextColor(i);
            if ((this.AP != null) && ((this.AP instanceof TextView))) {
              if (!this.jdField_a_of_type_Arcd$a.cYm) {
                break label317;
              }
            }
            for (j = 2130843463;; j = 2130843462)
            {
              ((TextView)this.AP).setCompoundDrawablesWithIntrinsicBounds(0, j, 0, 0);
              ((TextView)this.AP).setTextColor(i);
              if ((this.AM != null) && ((this.AM instanceof Button)))
              {
                i = 2130843458;
                if (!this.jdField_a_of_type_Arcd$a.cYm) {
                  break label300;
                }
                i = 2130843468;
              }
              for (;;)
              {
                this.AM.setBackgroundResource(i);
                return;
                if (this.jdField_a_of_type_Arcd$a.cYP) {
                  i = 2130843470;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setFloatBtnBackground(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arcd$a.cYm)
    {
      paramView.setBackgroundResource(2130843468);
      return;
    }
    if (this.jdField_a_of_type_Arcd$a.cYP)
    {
      paramView.setBackgroundResource(2130843470);
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130843458);
      return;
    }
    paramView.setBackgroundResource(2130843459);
  }
  
  public void setFloatingShareVisible(boolean paramBoolean)
  {
    View localView;
    if (this.lY != null)
    {
      localView = this.lY;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if ((!paramBoolean) && (this.AM != null) && ((this.AM.getVisibility() == 8) || (this.AM.getVisibility() == 4))) {
        this.AM.setVisibility(0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzg
 * JD-Core Version:    0.7.0.1
 */