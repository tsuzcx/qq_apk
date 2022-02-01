package com.tencent.mobileqq.filemanager.util;

import agst;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import aqhq;
import com.tencent.mobileqq.app.ThreadManagerV2;
import rvx;

public final class QFileUtils$5
  implements Runnable
{
  public QFileUtils$5(Context paramContext, String paramString, agst paramagst) {}
  
  public void run()
  {
    if (this.val$context == null) {}
    while (!aqhq.fileExistsAndNotEmpty(this.val$filePath)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray(2);
    int i = rvx.a(Uri.parse("file://" + this.val$filePath), this.val$context, 3, localSparseArray);
    ThreadManagerV2.getUIHandlerV2().post(new QFileUtils.5.1(this, i, localSparseArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.5
 * JD-Core Version:    0.7.0.1
 */