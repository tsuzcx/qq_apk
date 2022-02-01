package com.tencent.hotpatch;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import tnh;
import tnp;
import tnq;

public final class DexPatchInstaller$1
  implements Runnable
{
  public DexPatchInstaller$1(tnp paramtnp, Context paramContext) {}
  
  public void run()
  {
    String str = this.a.ot();
    int i = PatchSharedPreUtil.getCountFailStartupPatch(this.val$context, BaseApplicationImpl.processName, str);
    if (i <= 5) {
      PatchSharedPreUtil.updateCountFailStartupPatch(this.val$context, BaseApplicationImpl.processName, str, i + 1);
    }
    tnq.c(this.val$context, this.a);
    if ((501 == tnh.bCv) || (502 == tnh.bCv))
    {
      i = PatchSharedPreUtil.getCountFailInstallPatch(this.val$context, BaseApplicationImpl.processName, str);
      PatchSharedPreUtil.updateCountFailInstallPatch(this.val$context, BaseApplicationImpl.processName, str, i + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.hotpatch.DexPatchInstaller.1
 * JD-Core Version:    0.7.0.1
 */