import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqreader.ui.ReaderHomeTabFragment;

public class avoj
  extends aqzl
{
  private View LJ;
  private String cMm;
  private String cMn;
  private int cdl = -1;
  private Activity mActivity;
  private Intent mIntent;
  private int mItemType;
  private String mNetWorkTypeName;
  private String mResolution;
  private LinearLayout mj;
  private RadioGroup n;
  
  public avoj(arcd paramarcd)
  {
    super(paramarcd);
    this.mActivity = paramarcd.s;
    this.mIntent = this.mActivity.getIntent();
    int i = this.mIntent.getIntExtra("key_subtab", 0);
    this.mIntent.removeExtra("key_subtab");
    this.cMm = this.mIntent.getStringExtra("key_title_bar_left_tab_url");
    this.cMn = this.mIntent.getStringExtra("key_title_bar_right_tab_url");
    if (this.jdField_a_of_type_Arcd$a.eet != i) {
      Yk(i);
    }
    this.mNetWorkTypeName = aqgz.a(this.mActivity).networkType;
    this.mResolution = avoh.j(this.mActivity);
  }
  
  private ImageView a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.rightViewImg != null) && (this.rightViewImg.getVisibility() == 0))
    {
      ViewGroup localViewGroup = (ViewGroup)this.rightViewImg.getParent();
      Object localObject = (RelativeLayout.LayoutParams)this.rightViewImg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (((RelativeLayout.LayoutParams)localObject).width + aqcx.dip2px(this.mActivity, 13.0F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((RelativeLayout.LayoutParams)localObject).width, ((RelativeLayout.LayoutParams)localObject).height);
      localLayoutParams.topMargin = ((RelativeLayout.LayoutParams)localObject).topMargin;
      localObject = new ImageView(this.mActivity);
      ((ImageView)localObject).setContentDescription(paramString);
      ((ImageView)localObject).setOnClickListener(paramOnClickListener);
      ((ImageView)localObject).setImageResource(paramInt);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      localViewGroup.addView((View)localObject, localViewGroup.indexOfChild(this.rightViewImg), localLayoutParams);
      return localObject;
    }
    return null;
  }
  
  private void a(RadioButton paramRadioButton, boolean paramBoolean)
  {
    paramRadioButton.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130847853));
    paramRadioButton.setButtonDrawable(null);
    paramRadioButton.setGravity(17);
    paramRadioButton.setTextColor(-16777216);
    paramRadioButton.setTextSize(2, 18.0F);
    paramRadioButton.setTypeface(Typeface.DEFAULT_BOLD);
    paramRadioButton.setChecked(paramBoolean);
  }
  
  private boolean aKU()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isBookStore=");
    if (100 == this.cdl) {}
    for (boolean bool = true;; bool = false)
    {
      avoc.d("ReaderTitleBarView", bool);
      if (100 != this.cdl) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void abS(int paramInt)
  {
    if (this.leftView == null) {
      avoc.e("ReaderTitleBarView", "leftView is null");
    }
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        localDrawable = this.leftView.getBackground();
      } while (localDrawable == null);
      localDrawable = aqhu.d(localDrawable, paramInt);
    } while (localDrawable == null);
    this.leftView.setBackgroundDrawable(localDrawable);
  }
  
  private void abT(int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(this.cMm)) && (!TextUtils.isEmpty(this.cMn))) {
      switch (paramInt)
      {
      default: 
        str = "";
        paramInt = 0;
        i = paramInt;
        if (this.jdField_a_of_type_Arcd.c != null) {
          this.jdField_a_of_type_Arcd.c.j.loadUrl(str);
        }
        break;
      }
    }
    for (int i = paramInt;; i = 0)
    {
      abU(i);
      return;
      avof.c(this.mNetWorkTypeName, this.mResolution, "5", "502", "", "3", "", "", "");
      str = this.cMm;
      paramInt = 0;
      break;
      avof.c(this.mNetWorkTypeName, this.mResolution, "5", "2206", "", "3", "", "", "");
      paramInt = 1;
      str = this.cMn;
      break;
    }
  }
  
  private void abU(int paramInt)
  {
    int j = this.n.getChildCount();
    if ((paramInt < 0) || (paramInt >= j)) {
      return;
    }
    int i = 0;
    label20:
    RadioButton localRadioButton;
    if (i < j)
    {
      localRadioButton = (RadioButton)this.n.getChildAt(i);
      if (i != paramInt) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      localRadioButton.setSelected(bool);
      i += 1;
      break label20;
      break;
    }
  }
  
  private void eBv()
  {
    if (this.mj == null)
    {
      this.mj = new LinearLayout(this.mActivity);
      this.mj.setGravity(17);
      this.n = new RadioGroup(this.mActivity);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
      this.n.setGravity(17);
      this.n.setOrientation(0);
      this.n.setDividerDrawable(null);
      this.n.setDividerPadding(0);
      this.mj.addView(this.n, localLayoutParams);
      RadioButton localRadioButton = new RadioButton(this.mActivity);
      localRadioButton.setId(2131375315);
      localLayoutParams = new ViewGroup.LayoutParams(aqcx.dip2px(this.mActivity, 68.0F), aqcx.dip2px(this.mActivity, 34.0F));
      a(localRadioButton, true);
      localRadioButton.setText(this.mActivity.getResources().getString(2131717133));
      this.n.addView(localRadioButton, localLayoutParams);
      localRadioButton = new RadioButton(this.mActivity);
      localRadioButton.setId(2131375316);
      a(localRadioButton, false);
      localRadioButton.setText(this.mActivity.getResources().getString(2131717135));
      this.n.addView(localRadioButton, localLayoutParams);
    }
    this.n.setOnCheckedChangeListener(new avol(this));
    this.mx.removeAllViews();
    this.mx.addView(this.mj, new ViewGroup.LayoutParams(aqcx.dip2px(this.mActivity, 186.0F), aqcx.dip2px(this.mActivity, 44.0F)));
  }
  
  public void abR(int paramInt)
  {
    if (paramInt > 0)
    {
      this.cdl = paramInt;
      Window localWindow = this.jdField_a_of_type_Arcd.c.getHostActivity().getWindow();
      b(aKU(), localWindow);
    }
  }
  
  public void b(boolean paramBoolean, Window paramWindow)
  {
    if (paramBoolean)
    {
      ImmersiveUtils.setStatusTextColor(false, paramWindow);
      abS(-1);
      return;
    }
    ImmersiveUtils.setStatusTextColor(true, paramWindow);
    abS(-16777216);
  }
  
  public void bla()
  {
    super.bla();
    if ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_Arcd.eQ).uW(false);
    }
    if (this.jdField_a_of_type_Arcd.eG != null) {
      this.jdField_a_of_type_Arcd.eG.setVisibility(8);
    }
    this.jdField_a_of_type_Arcd$a.cYp = true;
    this.centerView.setTypeface(Typeface.DEFAULT_BOLD);
    this.leftView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.centerView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.rightViewText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.leftView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130851760));
    int i;
    int j;
    int k;
    int m;
    Object localObject;
    label289:
    label311:
    label361:
    boolean bool;
    label426:
    label451:
    Drawable localDrawable;
    if (aKU())
    {
      Yj(-1);
      Yh(-1);
      i = this.aK.getPaddingTop();
      j = this.aK.getPaddingBottom();
      k = this.aK.getPaddingLeft();
      m = this.aK.getPaddingRight();
      if ((this.mIntent == null) || (this.mIntent.getBundleExtra("theme") == null)) {
        break label639;
      }
      localObject = this.mIntent.getBundleExtra("theme");
      this.aK.setBackgroundColor(((Bundle)localObject).getInt("readerBgColor", -1));
      this.leftView.getBackground().setColorFilter(new LightingColorFilter(Color.rgb(0, 0, 0), ((Bundle)localObject).getInt("readerTextColor", -16777216)));
      this.centerView.setTextColor(((Bundle)localObject).getInt("readerTextColor", -16777216));
      this.rightViewText.setTextColor(((Bundle)localObject).getInt("readerTextColor", -16777216));
      if (!aKU()) {
        break label650;
      }
      avoh.l(this.aK, ImmersiveUtils.getStatusBarHeight(this.mActivity));
      if (this.jdField_a_of_type_Arcd.c != null)
      {
        j = this.jdField_a_of_type_Arcd.c.getResources().getDimensionPixelSize(2131299627);
        if (!aKU()) {
          break label665;
        }
        avoh.l(this.jdField_a_of_type_Arcd.c.a, -i);
        this.jdField_a_of_type_Arcd.c.mNeedStatusTrans = true;
        this.jdField_a_of_type_Arcd.c.mActNeedImmersive = true;
        if (this.jdField_a_of_type_Arcd.c.Js != null)
        {
          if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            break label705;
          }
          this.jdField_a_of_type_Arcd.c.Js.setBackgroundColor(-6710887);
          localObject = this.jdField_a_of_type_Arcd.c.getHostActivity().getWindow();
          if (aKU()) {
            break label783;
          }
          bool = true;
          ImmersiveUtils.setStatusTextColor(bool, (Window)localObject);
          this.jdField_a_of_type_Arcd$a.cYs = true;
        }
      }
      if ((this.mItemType != 1) || (104 == this.cdl)) {
        break label823;
      }
      this.rightViewImg.setVisibility(0);
      localDrawable = this.rightViewImg.getResources().getDrawable(2130847831);
      if (!aKU()) {
        break label789;
      }
      localObject = aqhu.d(localDrawable, -1);
      label522:
      this.rightViewImg.setImageDrawable((Drawable)localObject);
      this.rightViewImg.setContentDescription(this.mActivity.getResources().getString(2131695835));
      label551:
      if (102 == this.cdl)
      {
        if ((TextUtils.isEmpty(this.cMm)) || (TextUtils.isEmpty(this.cMn))) {
          break label835;
        }
        eBv();
      }
    }
    for (;;)
    {
      if (this.LJ == null) {
        this.LJ = a(2130847832, this.mActivity.getResources().getString(2131717134), new avok(this));
      }
      return;
      Yj(-16777216);
      Yh(-16777216);
      break;
      label639:
      this.aK.setBackgroundColor(-1);
      break label289;
      label650:
      this.aK.setPadding(k, i, m, j);
      break label311;
      label665:
      if (!(this.jdField_a_of_type_Arcd.c instanceof ReaderHomeTabFragment)) {
        break label361;
      }
      avoh.l(this.jdField_a_of_type_Arcd.c.j, -j - ImmersiveUtils.getStatusBarHeight(this.mActivity));
      break label361;
      label705:
      this.jdField_a_of_type_Arcd.c.Js.setBackgroundColor(-1);
      if (Build.VERSION.SDK_INT <= 23) {
        break label426;
      }
      localObject = this.jdField_a_of_type_Arcd.c.getHostActivity().getWindow();
      if (localObject == null) {
        break label426;
      }
      ((Window)localObject).clearFlags(67108864);
      ((Window)localObject).getDecorView().setSystemUiVisibility(1280);
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(0);
      break label426;
      label783:
      bool = false;
      break label451;
      label789:
      localObject = localDrawable;
      if (this.jdField_a_of_type_Arcd$a.a == null) {
        break label522;
      }
      localObject = aqhu.d(localDrawable, this.jdField_a_of_type_Arcd$a.a.edP);
      break label522;
      label823:
      this.rightViewImg.setVisibility(8);
      break label551;
      label835:
      avoc.e("ReaderTitleBarView", "mTitleBarLeftTabUrl=" + this.cMm + ",mTitleBarRightTabUrl=" + this.cMn);
    }
  }
  
  public void d(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      this.cdl = paramIntent.getIntExtra("key_tab_id", -1);
      this.mItemType = paramIntent.getIntExtra("item_type", -1);
    }
    this.jdField_a_of_type_Arcd$a.czz = null;
    super.d(paramIntent, paramString);
    if (aKU())
    {
      d(this.jdField_a_of_type_Arcd$a.ce, false);
      if ((this.jdField_a_of_type_Arcd.a() != null) && (!this.jdField_a_of_type_Arcd$a.isFullScreen))
      {
        this.jdField_a_of_type_Arcd$a.cYC = true;
        f(this.jdField_a_of_type_Arcd.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avoj
 * JD-Core Version:    0.7.0.1
 */