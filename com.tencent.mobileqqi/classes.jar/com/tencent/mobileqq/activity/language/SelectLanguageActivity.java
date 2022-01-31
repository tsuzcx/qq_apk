package com.tencent.mobileqq.activity.language;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.international.LocaleUtil;
import ehe;
import ehf;
import ehg;
import ehh;
import ehi;
import ehj;
import ehk;
import ehl;
import ehm;

public class SelectLanguageActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "SelectLanguageActivity";
  private int jdField_a_of_type_Int = 0;
  private Integer[] jdField_a_of_type_ArrayOfJavaLangInteger = { Integer.valueOf(0), Integer.valueOf(2131231841), Integer.valueOf(2131231843), Integer.valueOf(2131231845), Integer.valueOf(2131231847), Integer.valueOf(2131231849), Integer.valueOf(2131231851), Integer.valueOf(2131231853), Integer.valueOf(2131231855) };
  
  private void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (i >= 1) {
      ((ImageView)findViewById(this.jdField_a_of_type_ArrayOfJavaLangInteger[i].intValue())).setImageResource(2130840218);
    }
    ((ImageView)findViewById(this.jdField_a_of_type_ArrayOfJavaLangInteger[this.jdField_a_of_type_Int].intValue())).setImageResource(2130840217);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903256);
    setTitle(2131559346);
    b(2131559347, new ehe(this));
    d(true);
    this.jdField_a_of_type_Int = LocaleUtil.a(getApplicationContext());
    Log.d("SelectLanguageActivity", "last saved item " + this.jdField_a_of_type_Int);
    ((ImageView)findViewById(this.jdField_a_of_type_ArrayOfJavaLangInteger[this.jdField_a_of_type_Int].intValue())).setImageResource(2130840217);
    findViewById(2131231842).setOnClickListener(new ehf(this));
    findViewById(2131231844).setOnClickListener(new ehg(this));
    findViewById(2131231840).setOnClickListener(new ehh(this));
    findViewById(2131231846).setOnClickListener(new ehi(this));
    findViewById(2131231848).setOnClickListener(new ehj(this));
    findViewById(2131231850).setOnClickListener(new ehk(this));
    findViewById(2131231852).setOnClickListener(new ehl(this));
    findViewById(2131231854).setOnClickListener(new ehm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.language.SelectLanguageActivity
 * JD-Core Version:    0.7.0.1
 */