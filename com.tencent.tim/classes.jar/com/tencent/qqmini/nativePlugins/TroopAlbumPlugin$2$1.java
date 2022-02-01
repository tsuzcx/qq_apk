package com.tencent.qqmini.nativePlugins;

import acfp;
import android.app.Activity;
import android.content.Context;
import aqha;
import aqju;
import assx;
import assz;
import asta;
import astb;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class TroopAlbumPlugin$2$1
  implements Runnable
{
  public TroopAlbumPlugin$2$1(assz paramassz) {}
  
  public void run()
  {
    assx.a(this.a.a, this.a.val$jsonString);
    Activity localActivity = assx.e(this.a.a).getAttachedActivity();
    if (assx.a(this.a.a) == null) {
      assx.a(this.a.a, aqha.a(localActivity, 230).setTitle(acfp.m(2131715534)).setMessage(acfp.m(2131715533)).setPositiveButton(acfp.m(2131715532), new astb(this)).setNegativeButton(localActivity.getString(2131721058), new asta(this)));
    }
    if (!assx.a(this.a.a).isShowing()) {
      assx.a(this.a.a).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */