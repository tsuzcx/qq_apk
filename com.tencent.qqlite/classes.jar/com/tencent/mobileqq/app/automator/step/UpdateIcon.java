package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class UpdateIcon
  extends AsyncStep
{
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.a.a().getSharedPreferences("special_care_file", 0);
    if (localSharedPreferences.getBoolean("updateShortcutIcon3.4.0.607", true))
    {
      QQUtils.a(this.a.a, "sid");
      localSharedPreferences.edit().putBoolean("updateShortcutIcon3.4.0.607", false).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateIcon
 * JD-Core Version:    0.7.0.1
 */