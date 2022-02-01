package com.tencent.mobileqq.vas.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anlm;
import aqsd;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import ku;

public final class ThemeFontAdapter$2
  implements Runnable
{
  public ThemeFontAdapter$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = ku.e(this.iI, this.iJ);
    if (!new File((String)localObject1).exists())
    {
      QLog.d("ThemeFontAdapter", 1, "switchFont  fontPath not exists:" + this.iI);
      aqsd.kq(this.iI, this.iJ);
      return;
    }
    Object localObject2;
    if (this.iJ == 1)
    {
      if (!ETEngine.isSOLoaded.get())
      {
        aqsd.kq(this.iI, this.iJ);
        return;
      }
      localObject2 = ku.f(this.iI, this.iJ);
      if (aqsd.bY((String)localObject1, (String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeFontAdapter", 2, "switchFont  fontPath:" + (String)localObject1);
      }
      localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
      if (localObject2 == null)
      {
        QLog.e("ThemeFontAdapter", 1, "switchFont  context is null");
        return;
      }
      if (anlm.ayn())
      {
        aqsd.cV((Context)localObject2, (String)localObject1);
        return;
      }
      if (!TextHook.getInstance().switchFont((Context)localObject2, (String)localObject1)) {
        break;
      }
      aqsd.access$102(this.iI);
      if (aqsd.a() != null)
      {
        aqsd.a().destroy();
        aqsd.a(null);
      }
      QLog.e("ThemeFontAdapter", 2, "switchFont  success:" + this.iI + " type:" + this.iJ);
      TextHook.saveLastPath((Context)localObject2, (String)localObject1);
      ((Context)localObject2).getSharedPreferences("theme", 0).edit().remove("theme_font_root_pre").commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.2
 * JD-Core Version:    0.7.0.1
 */