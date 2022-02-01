package com.tencent.mobileqq.doutu;

import afdw;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import aqhu;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuiButtonImageView
  extends ImageView
{
  private static volatile boolean bXF;
  public static volatile boolean bXG;
  static WeakReference<DuiButtonImageView> gG;
  private static List<File> zw = new ArrayList();
  CustomFrameAnimationDrawable c;
  QQAppInterface mApp;
  Context mContext;
  public ChatMessage q;
  
  public DuiButtonImageView(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.q = paramChatMessage;
  }
  
  public static boolean a(DuiButtonImageView paramDuiButtonImageView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "startAnim");
    }
    gG = new WeakReference(paramDuiButtonImageView);
    if (!bXF) {}
    do
    {
      return false;
      paramDuiButtonImageView.pm();
    } while (paramDuiButtonImageView.c == null);
    paramDuiButtonImageView.c.cdJ();
    paramDuiButtonImageView.c.cdG();
    paramDuiButtonImageView.setImageDrawable(paramDuiButtonImageView.c);
    paramDuiButtonImageView.c.start();
    return true;
  }
  
  public static boolean aiQ()
  {
    Object localObject1 = new File(afdw.bDf + "dui_icon");
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if (localObject2 == null) {
              break label112;
            }
            zw.add(localObject2);
            break label112;
          }
          if (zw.size() > 1) {
            Collections.sort(zw);
          }
          bXG = true;
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
      label112:
      i += 1;
    }
  }
  
  public static void cYG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScroll");
    }
    bXF = false;
    if ((gG != null) && (gG.get() != null) && (((DuiButtonImageView)gG.get()).c != null)) {
      ((DuiButtonImageView)gG.get()).c.pause();
    }
  }
  
  public static void cYH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScrollStop");
    }
    bXF = true;
    if ((gG != null) && (gG.get() != null) && (((DuiButtonImageView)gG.get()).c != null) && (((DuiButtonImageView)gG.get()).q.isDui) && (((DuiButtonImageView)gG.get()).q.hasPlayedDui)) {
      ((DuiButtonImageView)gG.get()).c.resume();
    }
  }
  
  public static void ciK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnShowFirst");
    }
    bXF = true;
    if ((gG != null) && (gG.get() != null) && (((DuiButtonImageView)gG.get()).c != null) && (((DuiButtonImageView)gG.get()).q.isDui) && (!((DuiButtonImageView)gG.get()).q.hasPlayedDui)) {
      ((DuiButtonImageView)gG.get()).c.start();
    }
  }
  
  public static void cqt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnFinish");
    }
    bXF = false;
    if ((gG != null) && (gG.get() != null) && (((DuiButtonImageView)gG.get()).c != null)) {
      ((DuiButtonImageView)gG.get()).c.stop();
    }
    gG = null;
  }
  
  private void pm()
  {
    int i = 0;
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inMutable = true;
      if ((zw != null) && (zw.size() > 0))
      {
        localObject = aqhu.d(((File)zw.get(0)).getAbsolutePath(), (BitmapFactory.Options)localObject);
        if (localObject == null)
        {
          bXG = false;
          afdw.ej(this.mContext);
        }
        afdw localafdw = (afdw)this.mApp.getManager(214);
        if (localafdw == null) {
          return;
        }
        this.c = new CustomFrameAnimationDrawable(this.mContext.getResources(), (Bitmap)localObject, localafdw.F);
        while (i < zw.size())
        {
          localObject = (File)zw.get(i);
          if (localObject != null) {
            this.c.u(i, 77, ((File)localObject).getAbsolutePath());
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void ms()
  {
    gG = null;
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "resumeAnim");
    }
    if ((this.c != null) && (this.c.a != null) && (this.c.a.qA != null) && (this.c.a.qA.size() > 0)) {
      this.c.resume();
    }
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("DuiButtonImageView", 2, "showLastFrame");
        }
        try
        {
          Object localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          ((BitmapFactory.Options)localObject).inMutable = true;
          if (zw.size() > 0)
          {
            localObject = aqhu.d(((File)zw.get(zw.size() - 1)).getAbsolutePath(), (BitmapFactory.Options)localObject);
            if (localObject == null)
            {
              bXG = false;
              afdw.ej(this.mContext);
            }
            setImageBitmap((Bitmap)localObject);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("DuiButtonImageView", 1, "oom occur!");
          System.gc();
          return;
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("DuiButtonImageView", 2, "resumeAnim error!", localException);
  }
  
  public void stopAnim()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "stopAnim");
    }
    if (this.c != null) {
      this.c.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DuiButtonImageView
 * JD-Core Version:    0.7.0.1
 */