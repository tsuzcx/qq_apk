package com.tencent.mobileqq.activity;

import aceg;
import acfp;
import afmf;
import afmi;
import afml;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aofr;
import aofy;
import aqcx;
import aqha;
import aqho;
import arhz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import java.io.UnsupportedEncodingException;
import uvi;
import uvj;
import uvk;
import uvl;
import uvm;
import uvn;
import uvo;

public class EditActivity
  extends IphoneTitleBarActivity
  implements afmf
{
  private TextView As;
  TextView CY;
  TextView CZ;
  private arhz F;
  private Dialog M;
  private aceg a = new uvi(this);
  private String aMO;
  private String aMP;
  private boolean aVD;
  private boolean aVE;
  private boolean aVF = true;
  public int action;
  private int bGF;
  private EmoticonMainPanel c;
  public ClearableEditText e;
  private int emoId;
  private LinearLayout fW;
  private int limit;
  float mDensity = 1.5F;
  private boolean mHasChanged;
  private ImageView pR;
  private TextWatcher s = new uvm(this);
  private int title;
  
  private void bNr()
  {
    if ((this.F != null) && (this.F.isShowing())) {
      this.F.dismiss();
    }
  }
  
  private void bNs()
  {
    if (this.F == null)
    {
      this.F = new arhz(this, getTitleBarHeight());
      this.F.setMessage(2131693114);
    }
    this.F.show();
  }
  
  private void bNt()
  {
    String str = this.e.getText().toString();
    Intent localIntent = getIntent();
    localIntent.putExtra("result", str);
    if (this.action == 103) {
      localIntent.putExtra("hasChange", this.mHasChanged);
    }
    setResult(-1, localIntent);
    finish();
  }
  
  private void bNu()
  {
    if ((this.action == 102) || (this.action == 105))
    {
      this.CZ.setVisibility(0);
      this.As.setVisibility(8);
      return;
    }
    this.CZ.setVisibility(8);
    this.As.setVisibility(0);
    this.e.setPadding(this.e.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), aqcx.dip2px(this, 30.0F));
    this.e.setMinHeight(aqcx.dip2px(this, 74.0F));
  }
  
  private void bNw()
  {
    if (this.M == null) {
      this.M = aqha.a(this, acfp.m(2131705392), 2131694366, 2131694830, new uvn(this), new uvo(this));
    }
    this.M.show();
  }
  
  private boolean hh(String paramString)
  {
    return paramString.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*,*，*。*、*？*\\?*!*！*_*\\s*", "").length() != 0;
  }
  
  private void initEmoji()
  {
    this.pR = ((ImageView)findViewById(2131379058));
    this.pR.setVisibility(0);
    this.pR.setOnClickListener(new uvj(this));
    this.c = afml.a(this.app, this, this.e, this);
    this.c.setVisibility(0);
    this.fW = ((LinearLayout)findViewById(2131366381));
    this.fW.addView(this.c);
    this.e.setOnClickListener(new uvk(this));
  }
  
  private void initUI()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.As = ((TextView)findViewById(2131368167));
    this.CY = ((TextView)findViewById(2131368166));
    this.CZ = ((TextView)findViewById(2131368168));
    this.e.addTextChangedListener(this.s);
    this.e.setEditableFactory(aofr.a);
    if (getIntent().getBooleanExtra("key_null_bg", false))
    {
      this.e.setBackgroundResource(2130839682);
      this.e.setPadding((int)aqho.convertDpToPixel(this, 10.0F), (int)aqho.convertDpToPixel(this, 10.0F), (int)aqho.convertDpToPixel(this, 10.0F), (int)aqho.convertDpToPixel(this, 30.0F));
    }
    this.e.requestFocus();
    if (getIntent().getBooleanExtra("key_hide_clear_btn", false)) {
      this.e.setClearButtonStyle(1);
    }
    setTitle(this.title);
    if (!TextUtils.isEmpty(this.aMP))
    {
      this.CY.setText(this.aMP);
      this.CY.setVisibility(0);
    }
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (getIntent().getIntExtra("key_title_style", 0) == 0)
    {
      setRightHighlightButton(2131721066, new uvl(this));
      enableRightHighlight(true);
      localLayoutParams = this.e.getLayoutParams();
      if (this.aVE) {
        break label409;
      }
      this.e.setSingleLine(true);
      this.e.setText(this.aMO);
      i = this.e.getText().length();
      this.e.setSelection(i, i);
      if (localLayoutParams != null)
      {
        if ((this.action == 102) || (this.action == 105)) {
          break label393;
        }
        localLayoutParams.height = ((int)(74.0F * this.mDensity));
      }
    }
    for (;;)
    {
      if (localLayoutParams != null) {
        this.e.setLayoutParams(localLayoutParams);
      }
      new Handler().postDelayed(new EditActivity.5(this), 500L);
      return;
      if (getIntent().getIntExtra("key_title_style", 0) != 1) {
        break;
      }
      this.leftView.setText(2131690700);
      break;
      label393:
      localLayoutParams.height = ((int)(48.0F * this.mDensity));
      continue;
      label409:
      this.e.setSingleLine(false);
      this.e.setText(this.aMO);
      i = this.e.getText().length();
      this.e.setSelection(i, i);
      this.e.setGravity(48);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(150.0F * this.mDensity));
      }
    }
  }
  
  public void IM()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.e, 2);
  }
  
  public void a(afmi paramafmi)
  {
    paramafmi.a(this.app, this, this.e, null);
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return false;
  }
  
  public void b(afmi paramafmi) {}
  
  public void bNv()
  {
    String str = this.e.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject1 = new byte[0];
      try
      {
        localObject2 = str.getBytes("utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          ColorStateList localColorStateList = getResources().getColorStateList(2131167385);
          continue;
          localObject1 = String.valueOf((this.limit - i) / 3);
          continue;
          if (i > this.limit) {
            localObject1 = getString(2131692107) + "！ " + i + "/" + this.limit;
          } else {
            localObject1 = i + "/" + this.limit;
          }
        }
        if ((i > 0) && (i <= this.limit))
        {
          enableRightHighlight(true);
          return;
        }
        if ((i == 0) && (this.aVF))
        {
          enableRightHighlight(true);
          return;
        }
        enableRightHighlight(false);
        return;
      }
    }
    for (int i = localObject1.length;; i = 0) {
      if (i > this.limit)
      {
        localObject2 = getResources().getColorStateList(2131167439);
        if (!getIntent().getBooleanExtra("key_simple_count_style", false)) {
          continue;
        }
        if (i <= this.limit) {
          continue;
        }
        localObject1 = String.valueOf((this.limit - i - 2) / 3);
        if (localObject2 != null)
        {
          this.As.setTextColor((ColorStateList)localObject2);
          this.CZ.setTextColor((ColorStateList)localObject2);
        }
        this.As.setText((CharSequence)localObject1);
        this.CZ.setText((CharSequence)localObject1);
        if ((this.action != 101) || (!TextUtils.isEmpty(str.trim()))) {
          continue;
        }
        enableRightHighlight(false);
      }
    }
  }
  
  public void delete()
  {
    aofy.g(this.e);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.bGF = paramBundle.getIntExtra("support_emotion", 0);
    this.action = paramBundle.getIntExtra("action", 0);
    super.setContentView(2131559413);
    setContentBackgroundResource(2130838900);
    this.e = ((ClearableEditText)findViewById(2131368165));
    if (this.bGF == 1) {
      initEmoji();
    }
    this.title = paramBundle.getIntExtra("title", 0);
    this.limit = paramBundle.getIntExtra("limit", 0);
    this.emoId = paramBundle.getIntExtra("key_emo_id", -1);
    this.aVE = paramBundle.getBooleanExtra("multiLine", false);
    this.aVF = paramBundle.getBooleanExtra("canPostNull", true);
    this.aMO = paramBundle.getStringExtra("current");
    this.aMP = paramBundle.getStringExtra("key_input_tip");
    if (this.aMO == null) {
      this.aMO = "";
    }
    initUI();
    bNu();
    if (this.action == 103) {
      paramBundle = acfp.m(2131705389);
    }
    for (;;)
    {
      this.e.setHint(paramBundle);
      if (AppSetting.enableTalkBack) {
        this.e.setContentDescription(paramBundle);
      }
      if (this.action == 105) {
        addObserver(this.a);
      }
      return true;
      if (this.action == 102) {
        paramBundle = "";
      } else if (this.action == 105) {
        paramBundle = getString(2131693106);
      } else {
        paramBundle = acfp.m(2131705391) + getString(this.title);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.c != null) {
      this.c.onDestory();
    }
    ViewGroup localViewGroup = (ViewGroup)this.e.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.e);
    }
    if (this.action == 105) {
      removeObserver(this.a);
    }
    super.doOnDestroy();
  }
  
  public void enableRightHighlight(boolean paramBoolean)
  {
    super.enableRightHighlight(paramBoolean);
    int i = this.rightViewText.getCurrentTextColor();
    if ((!paramBoolean) && (i == -1))
    {
      this.rightViewText.setAlpha(0.6F);
      return;
    }
    this.rightViewText.setAlpha(1.0F);
  }
  
  public void gR()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void gq() {}
  
  public boolean onBackEvent()
  {
    Object localObject;
    if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      String str = this.e.getText().toString();
      if (TextUtils.isEmpty(str)) {
        break label163;
      }
      localObject = new byte[0];
      try
      {
        byte[] arrayOfByte = str.getBytes("utf-8");
        localObject = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        gR();
        localObject = getIntent();
        ((Intent)localObject).putExtra("result", str);
        setResult(-1, (Intent)localObject);
        finish();
        return false;
      }
    }
    label163:
    for (int i = localObject.length;; i = 0)
    {
      if (i > this.limit)
      {
        QQToast.a(this, 2131719509, 0).show(getTitleBarHeight());
        return true;
      }
      localObject = this.e.getText().toString();
      if ((this.action == 104) && (!TextUtils.equals((CharSequence)localObject, this.aMO)))
      {
        bNw();
        return true;
      }
      gR();
      return super.onBackEvent();
    }
  }
  
  public void onPause()
  {
    gR();
    super.onPause();
  }
  
  public void onResume()
  {
    if (!this.aVD) {
      IM();
    }
    super.onResume();
  }
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity
 * JD-Core Version:    0.7.0.1
 */