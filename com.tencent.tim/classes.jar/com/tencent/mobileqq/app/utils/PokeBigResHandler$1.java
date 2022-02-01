package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aoll;
import aomj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;

class PokeBigResHandler$1
  implements Runnable
{
  PokeBigResHandler$1(PokeBigResHandler paramPokeBigResHandler) {}
  
  public void run()
  {
    PokeBigResHandler.access$002(true);
    aoll localaoll = new aoll();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0.app.getApp());
    String str = this.this$0.app.getAccount();
    PokeBigResHandler.access$102(localSharedPreferences.getString(str + "_" + "aio_poke_res_url", ""));
    PokeBigResHandler.access$202(localSharedPreferences.getString(str + "_" + "aio_poke_res_md5", ""));
    if (TextUtils.isEmpty(PokeBigResHandler.access$100()))
    {
      PokeBigResHandler.access$002(false);
      return;
    }
    localaoll.f = PokeBigResHandler.a(this.this$0);
    localaoll.bZ = PokeBigResHandler.access$100();
    localaoll.mHttpMethod = 0;
    localaoll.atY = (PokeBigResHandler.access$400() + "poke.zip");
    ((aomj)this.this$0.mApp.getNetEngine(0)).a(localaoll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.1
 * JD-Core Version:    0.7.0.1
 */