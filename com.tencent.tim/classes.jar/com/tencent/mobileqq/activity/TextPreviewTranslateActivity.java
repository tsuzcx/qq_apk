package com.tencent.mobileqq.activity;

import aawl;
import aklr;
import aklt;
import akoz;
import akoz.b;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aofk;
import aqcl;
import aqcx;
import aqmr;
import arhz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import vxj;
import vxk;
import vxl;
import vxm;
import vxn;
import vxo;
import wja;

public class TextPreviewTranslateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int bLk = Color.parseColor("#03081A");
  public static final int bLl = Color.parseColor("#00CAFC");
  public static final int bLm = Color.parseColor("#FFFFFF");
  public static final int bLn = Color.parseColor("#A8A8A8");
  public static final int bLo = Color.parseColor("#004080");
  public static final int bLp = Color.parseColor("#1F1F1F");
  public static final int bLq = Color.parseColor("#000000");
  private TextView FT;
  private TextView FU;
  private aawl jdField_a_of_type_Aawl;
  private aklt jdField_a_of_type_Aklt = new vxk(this);
  public akoz a;
  protected arhz a;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private String aQn;
  private String aQo;
  private String aQp;
  private String aQq;
  private EditText ah;
  public akoz b;
  private OcrConfig jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig;
  private ContainerView jdField_b_of_type_ComTencentMobileqqWidgetContainerView;
  private boolean baR;
  private ScrollView c;
  public RelativeLayout et;
  private String originText;
  private List<String> rh;
  private List<String> ri;
  private ImageView ro;
  private ImageView rp;
  
  private static boolean X(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if ((19968 <= j) && (j < 40869)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult == null) {}
    while ((this.jdField_b_of_type_ComTencentMobileqqWidgetContainerView == null) || (this.jdField_a_of_type_Aawl == null)) {
      return;
    }
    ContainerView localContainerView = this.jdField_b_of_type_ComTencentMobileqqWidgetContainerView;
    aawl localaawl = this.jdField_a_of_type_Aawl;
    String str = paramTranslateResult.xG();
    localaawl.content = str;
    localContainerView.setText(str);
    wH(paramTranslateResult.btb);
    wG(paramTranslateResult.bta);
  }
  
  private void aDZ()
  {
    Intent localIntent = getIntent();
    this.originText = localIntent.getStringExtra("TranslateText");
    this.aQo = this.originText;
    this.aQn = localIntent.getStringExtra("WhereAreYouFrom");
  }
  
  private List<String> aa(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  private void ae(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      am(2131701478);
      if (this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController != null) {
        this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.aL(paramString1, paramString2, paramString3);
      }
    }
  }
  
  private void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null)
    {
      this.jdField_a_of_type_Arhz = new arhz(this, getResources().getDimensionPixelSize(2131299627));
      this.jdField_a_of_type_Arhz.setMessage(paramInt);
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  private void bWh()
  {
    if (X(this.aQo)) {
      this.aQp = "zh";
    }
    for (this.aQq = "en";; this.aQq = "zh")
    {
      this.FT.setText(hj(this.aQp));
      this.FU.setText(hj(this.aQq));
      this.rh = aa(this.aQp);
      this.ri = aa(this.aQq);
      return;
      this.aQp = "en";
    }
  }
  
  private void bWi()
  {
    this.ah.setBackgroundColor(bLm);
    this.jdField_b_of_type_ComTencentMobileqqWidgetContainerView.setTextColor(bLl);
    this.FT.setTextColor(bLk);
    this.FU.setTextColor(bLk);
    Drawable localDrawable = getResources().getDrawable(2130847056);
    this.ro.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130847052);
    this.rp.setImageDrawable(localDrawable);
  }
  
  private void bWj()
  {
    this.et = ((RelativeLayout)findViewById(2131379574));
    this.ah = ((EditText)findViewById(2131380159));
    this.ah.setText(new aofk(this.aQo, 5, 25));
    this.jdField_b_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)findViewById(2131380160));
    this.FT = ((TextView)findViewById(2131380134));
    this.FU = ((TextView)findViewById(2131380130));
    this.ro = ((ImageView)findViewById(2131380135));
    this.rp = ((ImageView)findViewById(2131380129));
    this.c = ((ScrollView)findViewById(2131377758));
    this.FT.setOnClickListener(this);
    this.FU.setOnClickListener(this);
    this.ro.setOnClickListener(this);
    this.rp.setOnClickListener(this);
    this.jdField_a_of_type_Aawl = new aawl();
    this.jdField_a_of_type_Aawl.a(this, this.jdField_b_of_type_ComTencentMobileqqWidgetContainerView);
    bWi();
    this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig = ((aklr)this.app.getManager(228)).a(false);
    if ((this.et instanceof DispatchTouchEventRelativeLayout)) {
      ((DispatchTouchEventRelativeLayout)this.et).setOnDispatchListener(new a(this.jdField_a_of_type_Aawl));
    }
    this.ah.setHorizontallyScrolling(false);
    int i = aqcx.dip2px(this, 360.0F);
    if (this.ah.getLineHeight() != 0) {
      i /= this.ah.getLineHeight();
    }
    for (;;)
    {
      this.ah.setMaxLines(i);
      this.ah.setOnEditorActionListener(new vxj(this));
      return;
      i = 17;
    }
  }
  
  private void bWk()
  {
    if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing())) {
      this.jdField_a_of_type_Akoz.dismiss();
    }
    if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
      this.jdField_b_of_type_Akoz.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.rh == null) || (this.rh.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.rh.size())
      {
        String str = (String)this.rh.get(i);
        if (str.equals(this.ri)) {}
        for (;;)
        {
          i += 1;
          break;
          akoz.b localb = new akoz.b();
          localb.languageCode = str;
          localb.bUe = hj(str);
          if (str.equalsIgnoreCase(this.aQp)) {
            j = i;
          }
          localArrayList.add(localb);
        }
      }
      this.jdField_b_of_type_Akoz = akoz.a(this, localArrayList, j, new vxl(this));
    } while (this.jdField_b_of_type_Akoz == null);
    this.jdField_b_of_type_Akoz.setOnDismissListener(new vxm(this));
    int i = this.FT.getMeasuredWidth() / 2;
    int j = wja.dp2px(75.0F, getResources());
    this.FT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Akoz.showAsDropDown(this.FT, i - j, 0);
  }
  
  private void bWl()
  {
    if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
      this.jdField_b_of_type_Akoz.dismiss();
    }
    if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing())) {
      this.jdField_a_of_type_Akoz.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.ri == null) || (this.ri.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.ri.size())
      {
        String str = (String)this.ri.get(i);
        if (str.equals(this.aQp)) {}
        for (;;)
        {
          i += 1;
          break;
          akoz.b localb = new akoz.b();
          localb.languageCode = str;
          localb.bUe = hj(str);
          if (str.equalsIgnoreCase(this.aQq)) {
            j = i;
          }
          localArrayList.add(localb);
        }
      }
      this.jdField_a_of_type_Akoz = akoz.a(this, localArrayList, j, new vxn(this));
    } while (this.jdField_a_of_type_Akoz == null);
    this.jdField_a_of_type_Akoz.setOnDismissListener(new vxo(this));
    int i = this.FU.getMeasuredWidth() / 2;
    int j = wja.dp2px(75.0F, getResources());
    this.FU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Akoz.showAsDropDown(this.FU, i - j, 0);
  }
  
  private void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  private String hj(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  private String hk(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return "";
    }
    return new aofk(paramString, 5, 25).v(false);
  }
  
  private void setResult()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_FROM", 1);
    setResult(1, localIntent);
  }
  
  private void wG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.aQp = paramString.toLowerCase();
    this.FT.setText(hj(this.aQp));
    this.ri = aa(this.aQp);
    if ((this.ri == null) || (this.ri.size() <= 1))
    {
      this.FU.setClickable(false);
      this.FU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      label82:
      if (AppSetting.enableTalkBack) {
        aqcl.changeAccessibilityForView(this.FT, this.aQp, getString(2131701477));
      }
    }
    else
    {
      this.FU.setClickable(true);
      paramString = getResources();
      if (!this.baR) {
        break label151;
      }
    }
    label151:
    for (int i = 2130846541;; i = 2130847054)
    {
      paramString = paramString.getDrawable(i);
      this.FU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      break label82;
      break;
    }
  }
  
  private void wH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.aQq = paramString.toLowerCase();
    this.FU.setText(hj(this.aQq));
    this.rh = aa(paramString);
    if ((this.rh == null) || (this.rh.size() <= 1))
    {
      this.FT.setClickable(false);
      this.FT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      label79:
      if (AppSetting.enableTalkBack) {
        aqcl.changeAccessibilityForView(this.FU, this.aQq, getString(2131701477));
      }
    }
    else
    {
      this.FT.setClickable(true);
      paramString = getResources();
      if (!this.baR) {
        break label148;
      }
    }
    label148:
    for (int i = 2130846541;; i = 2130847054)
    {
      paramString = paramString.getDrawable(i);
      this.FT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      break label79;
      break;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.a(this.app, paramIntent, this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561734);
    aDZ();
    bWj();
    setResult();
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.app);
    addObserver(this.jdField_a_of_type_Aklt);
    bWh();
    wG(this.aQp);
    wH(this.aQq);
    ae(hk(this.aQo), this.aQp, this.aQq);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Aklt);
    this.jdField_a_of_type_Aawl.b(this.jdField_b_of_type_ComTencentMobileqqWidgetContainerView);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Aawl.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Aawl.onResume();
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW())) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      bWk();
      continue;
      bWl();
      continue;
      String str = this.aQp;
      wG(this.aQq);
      wH(str);
      ae(hk(this.aQo), this.aQp, this.aQq);
      if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
        this.jdField_b_of_type_Akoz.dismiss();
      }
      if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing())) {
        this.jdField_a_of_type_Akoz.dismiss();
      }
    }
  }
  
  static final class a
    implements DispatchTouchEventRelativeLayout.a
  {
    private WeakReference<aawl> dP;
    
    a(aawl paramaawl)
    {
      this.dP = new WeakReference(paramaawl);
    }
    
    public void S(MotionEvent paramMotionEvent)
    {
      aawl localaawl = (aawl)this.dP.get();
      if (localaawl != null) {
        localaawl.W(paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity
 * JD-Core Version:    0.7.0.1
 */