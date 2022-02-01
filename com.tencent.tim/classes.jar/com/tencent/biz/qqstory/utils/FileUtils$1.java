package com.tencent.biz.qqstory.utils;

import acfp;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import aqha;
import aqju;
import roy;
import roz;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(this.val$context, 230);
    localaqju.setMessage(acfp.m(2131706296));
    localaqju.setNegativeButton(acfp.m(2131706298), new roy(this));
    localaqju.setPositiveButton(acfp.m(2131706297), new roz(this));
    localaqju.setCancelable(false);
    localaqju.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localaqju.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */