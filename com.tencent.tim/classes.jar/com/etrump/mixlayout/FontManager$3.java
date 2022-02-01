package com.etrump.mixlayout;

import ahxo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import aqnl;
import aqvd;
import com.tencent.qphone.base.util.BaseApplication;
import i;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import ku;
import lb;
import ld;

public class FontManager$3
  implements Runnable
{
  public FontManager$3(ku paramku, int paramInt) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    switch (this.iJ)
    {
    case 2: 
    case 3: 
    default: 
      localObject1 = null;
      localObject2 = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (!aqnl.B((String)localObject2, aqnl.getSoDir() + File.separator, (String)localObject1)) {
          break label390;
        }
        if (aqnl.af(aqnl.getSoDir(), (String)localObject1) != 0) {
          break label377;
        }
        ld.a().C(this.iJ, 0);
        switch (this.iJ)
        {
        }
      }
      break;
    }
    for (;;)
    {
      aqnl.H(this.this$0.mApp);
      ku.a(this.this$0);
      return;
      localObject2 = ku.dV + File.separator + "libColorFont.zip";
      localObject1 = "libFounderColorFont_818.so";
      break;
      localObject2 = ku.dV + File.separator + "libVipFont.zip";
      localObject1 = "libvipfont808.so";
      break;
      i.a().p.set(true);
      ahxo.a().dqG();
      continue;
      if ((!TextUtils.isEmpty(this.this$0.dY)) && (this.this$0.a != null))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("callbackId", this.this$0.dY);
        ((Bundle)localObject1).putInt("srcType", 9);
        this.this$0.a.a(0L, 0, (Bundle)localObject1);
        this.this$0.dY = null;
      }
      ETEngine.isSOLoaded.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 0).edit().putBoolean("vip_font_so_downloaded", true).commit();
      ahxo.a().dqG();
      lb.M.set(true);
      this.this$0.U(false);
    }
    label377:
    ld.a().C(this.iJ, -102);
    return;
    label390:
    ld.a().C(this.iJ, -102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.3
 * JD-Core Version:    0.7.0.1
 */