package com.tencent.mobileqq.search.util;

import akyr;
import amxk.a;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import arwv;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import ykk;
import ykm;
import ykv;
import yla;
import yla.a;

public final class SearchUtils$3
  implements Runnable
{
  public SearchUtils$3(String paramString1, String paramString2, List paramList, String paramString3, Rect paramRect, AppInterface paramAppInterface, amxk.a parama) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = arwv.toMD5(this.cct);
      if (akyr.lP(this.cct))
      {
        localObject3 = new ykk(new File(this.cct), false, 0.0F);
        localObject2 = yla.a().a(((ykk)localObject3).getWidth(), ((ykk)localObject3).getHeight(), this.val$text, this.Gn, this.ccu, this.cA, 1, arwv.toMD5(this.cct), 0, Typeface.DEFAULT);
        ((ykk)localObject3).a((yla.a)localObject2);
        localObject3 = new ykv();
        ((ykv)localObject3).b = ((yla.a)localObject2);
        ((ykv)localObject3).isGif = true;
        ((ykv)localObject3).gJ = this.cct;
        ((ykv)localObject3).bnc = true;
        ((ykv)localObject3).aYv = ((String)localObject1);
        ((ykv)localObject3).bZJ = 0;
        ((ykv)localObject3).pic_md5 = ((String)localObject1);
        localObject1 = ykm.a(this.b).a((ykv)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + (String)localObject1);
        }
        this.a.LJ((String)localObject1);
        return;
      }
      localObject1 = BitmapFactory.decodeFile(this.cct).copy(Bitmap.Config.ARGB_8888, true);
      Object localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Object localObject3 = yla.a().a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), this.val$text, this.Gn, this.ccu, this.cA, 1, arwv.toMD5(this.cct), 0, Typeface.DEFAULT);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      int i = 0;
      while (i < ((yla.a)localObject3).aP.length)
      {
        float f = ((Rect)localObject2).top + localObject3.aP[i];
        if (((yla.a)localObject3).strokePaint != null) {
          localCanvas.drawText(localObject3.cN[i], ((Rect)localObject2).exactCenterX(), f, ((yla.a)localObject3).strokePaint);
        }
        localCanvas.drawText(localObject3.cN[i], ((Rect)localObject2).exactCenterX(), f, ((yla.a)localObject3).bs);
        i += 1;
      }
      localObject2 = this.cct + "_" + System.currentTimeMillis();
      BitmapUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2);
      this.a.LJ((String)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localException);
      this.a.LJ(null);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localOutOfMemoryError);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.3
 * JD-Core Version:    0.7.0.1
 */