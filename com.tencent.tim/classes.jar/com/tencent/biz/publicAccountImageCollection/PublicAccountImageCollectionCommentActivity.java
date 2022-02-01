package com.tencent.biz.publicAccountImageCollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import otk;
import otl;
import otm;
import otn;
import oto;
import otp;

public class PublicAccountImageCollectionCommentActivity
  extends BaseActivity
{
  private EditText W;
  private boolean ahe;
  private boolean ayo;
  private Button cd;
  private View dE;
  private CheckBox p;
  
  private boolean eJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.trim().length() == 0) || (paramString.length() > 100)) {
      return false;
    }
    return true;
  }
  
  private void hideSoftInput()
  {
    this.W.clearFocus();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.W.getWindowToken(), 2);
  }
  
  private void pX(String paramString)
  {
    boolean bool = eJ(paramString);
    this.cd.setEnabled(bool);
    if (bool)
    {
      this.cd.setTextColor(Color.parseColor("#FFFFFF"));
      return;
    }
    this.cd.setTextColor(Color.parseColor("#9D9D9D"));
  }
  
  private void va(int paramInt)
  {
    this.dE.setVisibility(8);
    String str = this.W.getText().toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("comment", str);
    localIntent.putExtra("anonymous", this.ahe);
    setResult(paramInt, localIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559817);
    this.dE = findViewById(2131364979);
    this.W = ((EditText)this.dE.findViewById(2131364976));
    this.W.requestFocus();
    this.W.addTextChangedListener(new otk(this));
    this.W.setOnEditorActionListener(new otl(this));
    this.dE.findViewById(2131364970).setOnClickListener(new otm(this));
    this.dE.getViewTreeObserver().addOnGlobalLayoutListener(new otn(this));
    this.cd = ((Button)findViewById(2131377984));
    this.cd.setOnClickListener(new oto(this));
    this.ahe = getIntent().getBooleanExtra("anonymous", false);
    this.p = ((CheckBox)findViewById(2131362730));
    this.p.setChecked(this.ahe);
    this.p.setOnCheckedChangeListener(new otp(this));
    paramBundle = getIntent().getStringExtra("comment");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.W.setText(paramBundle);
      this.W.setSelection(paramBundle.length());
      pX(paramBundle);
    }
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity
 * JD-Core Version:    0.7.0.1
 */