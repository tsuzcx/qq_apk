package com.tencent.mobileqq.musicgene;

import ajmr;
import ajmu;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import java.io.File;

public class MusicGeneWebViewPlugin$5
  implements Runnable
{
  public MusicGeneWebViewPlugin$5(ajmu paramajmu, String paramString, int paramInt, File paramFile) {}
  
  public void run()
  {
    Object localObject1 = ajmu.I(this.val$imgUrl);
    if (localObject1 != null) {
      if (this.djR <= 0) {
        break label87;
      }
    }
    label87:
    for (int i = this.djR;; i = 5)
    {
      Object localObject2 = ajmr.c((Bitmap)localObject1, 3, i, i);
      ajmu.a(this.this$0, (Bitmap)localObject2);
      localObject1 = Message.obtain(ajmu.a(this.this$0));
      ((Message)localObject1).obj = localObject2;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("BUNDLE_KEY_FILE_PATH", this.val$imageFile.getPath());
      ((Message)localObject1).setData((Bundle)localObject2);
      ((Message)localObject1).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.5
 * JD-Core Version:    0.7.0.1
 */