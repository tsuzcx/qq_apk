package com.tencent.biz.pubaccount.weishi_new.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.io.IOException;
import jqc;

public final class WeishiShareUtil$1
  implements Runnable
{
  public WeishiShareUtil$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject1 = jqc.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.val$imageUrl), "GET", null, null);
      Object localObject2;
      String str1;
      String str2;
      String str3;
      String str4;
      if (localObject1 != null)
      {
        localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        if (localObject2 != null)
        {
          int j = ((Bitmap)localObject2).getWidth();
          int k = ((Bitmap)localObject2).getHeight();
          if (j * k > 8000.0D)
          {
            double d = Math.sqrt(8000.0D / (j * k));
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, (int)(j * d), (int)(k * d), true);
            ((Bitmap)localObject2).recycle();
            localObject2 = WXShareHelper.a();
            str1 = this.QH;
            str2 = this.val$title;
            str3 = this.val$desc;
            str4 = this.aqZ;
            if (this.val$scene != 0) {
              break label168;
            }
          }
        }
      }
      for (;;)
      {
        ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
        ((Bitmap)localObject1).recycle();
        return;
        label168:
        i = 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil.1
 * JD-Core Version:    0.7.0.1
 */