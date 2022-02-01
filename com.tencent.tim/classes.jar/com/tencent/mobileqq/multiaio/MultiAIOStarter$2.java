package com.tencent.mobileqq.multiaio;

import ajhz;
import ajil;
import ajim;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public final class MultiAIOStarter$2
  implements Runnable
{
  public MultiAIOStarter$2(BaseActivity paramBaseActivity, ajil paramajil) {}
  
  public void run()
  {
    Bitmap localBitmap2;
    try
    {
      if (this.val$activity == null) {
        return;
      }
      if (this.val$activity.isFinishing()) {
        return;
      }
      Bitmap localBitmap1 = this.a.az();
      this.a.U(null);
      localBitmap2 = ajhz.a(localBitmap1, this.a.getContentHeight(), this.val$activity);
      if (localBitmap2 == null)
      {
        QLog.e("MultiAIOStarter", 1, "run: decorViewBitmap == null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MultiAIOStarter", 1, "run: ", localThrowable);
      ajim.dxL();
      return;
    }
    this.a.V(localBitmap2);
    QQAppInterface localQQAppInterface = this.val$activity.app;
    if (localQQAppInterface != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putParcelable("KEY_AIO_BITMAP", localBitmap2);
      localQQAppInterface.notifyObservers(MultiAIOFragment.class, 0, true, (Bundle)localObject);
      localBitmap2 = Bitmap.createScaledBitmap(localBitmap2, (int)(localBitmap2.getWidth() * 0.0625F), (int)(localBitmap2.getHeight() * 0.0625F), false);
      if (localBitmap2 == null)
      {
        QLog.e("MultiAIOStarter", 1, "run: scaledBitmap == null");
        ajim.dxL();
        return;
      }
      localObject = new StackBlurManager(localBitmap2).process(4);
      if (localObject == null)
      {
        QLog.e("MultiAIOStarter", 1, "run: blured bitmap is null");
        ajim.dxL();
        return;
      }
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawColor(0);
      localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
      }
      for (;;)
      {
        localCanvas.setBitmap(null);
        this.a.W(localBitmap2);
        localObject = new Bundle();
        ((Bundle)localObject).putParcelable("KEY_AIO_BITMAP_BLURED", localBitmap2);
        localQQAppInterface.notifyObservers(MultiAIOFragment.class, 1, true, (Bundle)localObject);
        return;
        localCanvas.drawColor(Color.parseColor("#7F03081A"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter.2
 * JD-Core Version:    0.7.0.1
 */