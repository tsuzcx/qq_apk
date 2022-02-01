package com.tencent.tim.filemanager.core;

import ahch;
import ahch.a;
import android.os.Bundle;
import android.text.TextUtils;
import atur;

public class UniformDownloadMgr$7
  implements Runnable
{
  public void run()
  {
    Object localObject = this.aT.getString("_filename_from_dlg");
    long l = this.aT.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l) || (-1L == l))
    {
      localObject = ahch.a(this.ajI);
      this.aT.putLong("_filesize_from_dlg", ((ahch.a)localObject).aal);
      if (TextUtils.isEmpty(((ahch.a)localObject).fName)) {
        ((ahch.a)localObject).fName = "nofilename.x";
      }
      this.aT.putString("_filename_from_dlg", ((ahch.a)localObject).fName);
    }
    atur.a(this.this$0, this.ajI, this.aT);
    atur.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadMgr.7
 * JD-Core Version:    0.7.0.1
 */