package com.tencent.mobileqq.filemanager.core;

import aglz;
import aglz.a;
import ahch;
import ahch.a;
import ahcj;
import ahcj.b;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(aglz paramaglz, Bundle paramBundle, String paramString, ahcj.b paramb) {}
  
  public void run()
  {
    Object localObject = this.aT.getString("_filename_from_dlg");
    long l = this.aT.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = ahch.a(this.ajI);
      this.aT.putLong("_filesize_from_dlg", ((ahch.a)localObject).aal);
      if (TextUtils.isEmpty(((ahch.a)localObject).fName)) {
        ((ahch.a)localObject).fName = "nofilename.x";
      }
      this.aT.putString("_filename_from_dlg", ((ahch.a)localObject).fName);
    }
    localObject = aglz.a(this.this$0, this.ajI);
    if ((localObject != null) && (((aglz.a)localObject).a != null))
    {
      int i = ((aglz.a)localObject).a.getStatus();
      if ((i == 1) || (i == 2))
      {
        if (this.b != null) {
          ((aglz.a)localObject).a.a(this.b);
        }
        ahcj.b localb = aglz.a(this.this$0, this.ajI);
        if (localb != null) {
          ((aglz.a)localObject).a.a(localb, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.ajI + " update OuterListenner");
      }
    }
    aglz.a(this.this$0, this.ajI, this.aT);
    aglz.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */