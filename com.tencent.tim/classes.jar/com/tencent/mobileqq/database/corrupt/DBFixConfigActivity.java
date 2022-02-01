package com.tencent.mobileqq.database.corrupt;

import afan;
import afao;
import afap;
import afaq;
import afar;
import afas;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixConfigActivity
  extends AppActivity
{
  public static String TAG = "DBFix";
  public static int cPH = 2;
  CheckBox J;
  CheckBox K;
  Button fS;
  Button fT;
  public Runnable gn = new DBFixConfigActivity.7(this);
  RadioGroup i;
  RadioButton l;
  RadioButton m;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559533);
    paramBundle = getAppRuntime();
    String str = paramBundle.getAccount();
    this.i = ((RadioGroup)super.findViewById(2131364587));
    this.i.setOnCheckedChangeListener(new afan(this, paramBundle, str));
    this.l = ((RadioButton)super.findViewById(2131366155));
    this.m = ((RadioButton)super.findViewById(2131365635));
    cPH = paramBundle.getApplication().getSharedPreferences(DBFixManager.bCE, 0).getInt(str + DBFixManager.bCF, 2);
    if (cPH == 2)
    {
      this.l.setChecked(false);
      this.m.setChecked(true);
    }
    for (;;)
    {
      this.fS = ((Button)super.findViewById(2131382325));
      this.fS.setOnClickListener(new afao(this));
      ((Button)super.findViewById(2131365453)).setOnClickListener(new afap(this, str));
      this.J = ((CheckBox)super.findViewById(2131370934));
      this.J.setChecked(true);
      this.J.setOnCheckedChangeListener(new afaq(this, paramBundle));
      this.K = ((CheckBox)super.findViewById(2131364158));
      this.K.setChecked(true);
      this.K.setOnCheckedChangeListener(new afar(this, paramBundle));
      this.fT = ((Button)super.findViewById(2131373590));
      this.fT.setOnClickListener(new afas(this, paramBundle));
      return true;
      this.l.setChecked(true);
      this.m.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity
 * JD-Core Version:    0.7.0.1
 */