package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import java.io.File;

final class e
  implements PreloadManager.d
{
  e(d paramd, String paramString) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (c.a(new File(paramPathResult.filePath).getAbsolutePath(), this.a))) {
      if (this.b.b != null) {
        this.b.b.onUpdateSucc(true);
      }
    }
    while (this.b.b == null) {
      return;
    }
    this.b.b.onUpdateSucc(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.e
 * JD-Core Version:    0.7.0.1
 */