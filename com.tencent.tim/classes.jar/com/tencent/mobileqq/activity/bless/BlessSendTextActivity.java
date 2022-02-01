package com.tencent.mobileqq.activity.bless;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import anot;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import ylm;

public class BlessSendTextActivity
  extends BaseActivity
  implements TextWatcher, View.OnClickListener
{
  private ylm a;
  int bZP = 0;
  private boolean bnv;
  EditText editText;
  protected RelativeLayout ih;
  View mTitleBar;
  ArrayList<String> ra;
  
  private void b(IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 2);
    }
  }
  
  private void cjD()
  {
    if (this.bZP < this.ra.size())
    {
      String str = this.editText.getText().toString();
      this.ra.set(this.bZP, str);
      this.a.r(this.bZP, str, this.ra.size());
    }
  }
  
  private void initViews()
  {
    ((ImmersiveTitleBar2)findViewById(2131379866)).setVisibility(4);
    this.mTitleBar = findViewById(2131379769);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165418));
    findViewById(2131369612).setOnClickListener(this);
    findViewById(2131364431).setOnClickListener(this);
    findViewById(2131363986).setOnClickListener(this);
    this.editText = ((EditText)findViewById(2131366257));
    this.editText.addTextChangedListener(this);
    if ((this.ra != null) && (this.ra.size() > 0))
    {
      this.editText.setText((CharSequence)this.ra.get(this.bZP));
      this.editText.setSelection(this.editText.getText().length());
    }
    this.ih = ((RelativeLayout)findViewById(2131363219));
    this.ih.setOnClickListener(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    cjD();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void close()
  {
    anot.a(this.app, "CliOper", "", "", "0X8006195", "0X8006195", 0, 0, String.valueOf(1), "", "", "");
    finish();
    overridePendingTransition(2130772009, 2130772013);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131558769);
    this.a = ((ylm)this.app.getManager(138));
    this.ra = this.a.bM();
    initViews();
    this.bnv = getIntent().getBooleanExtra("fromoutweb", false);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.ra != null) && (this.ra.size() > 0))
      {
        cjD();
        if (this.bZP >= this.ra.size() - 1) {}
        for (this.bZP = 0;; this.bZP += 1)
        {
          this.editText.setText((CharSequence)this.ra.get(this.bZP));
          break;
        }
        Object localObject = this.editText.getText().toString();
        if (((String)localObject).equals(""))
        {
          QQToast.a(this, 2131690897, 1).show();
        }
        else
        {
          cjD();
          Intent localIntent = new Intent(this, BlessSelectMemberActivity.class);
          localIntent.putExtra("param_type", 9003);
          localIntent.putExtra("param_entrance", 15);
          localIntent.putExtra("param_only_friends", true);
          localIntent.putExtra("param_donot_need_contacts", true);
          localIntent.putExtra("param_title", getString(2131690914));
          localIntent.putExtra("param_done_button_wording", getString(2131691970));
          localIntent.putExtra("param_exit_animation", 1);
          localIntent.putExtra("param_blesstype", 1);
          localIntent.putExtra("param_blessword_content", (String)localObject);
          startActivity(localIntent);
          overridePendingTransition(2130772004, 2130772005);
          localObject = this.app;
          if (this.bnv) {}
          for (;;)
          {
            anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X800618C", "0X800618C", i, 0, "", "", "", "");
            break;
            i = 0;
          }
          b(this.editText.getWindowToken());
          continue;
          close();
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      close();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSendTextActivity
 * JD-Core Version:    0.7.0.1
 */