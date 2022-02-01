package com.tencent.mobileqq.activity.aio.anim;

import acle;
import adxk;
import adxp;
import adxp.a;
import adyd;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anlm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import wja;
import xkx.a;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, xkx.a parama)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        localObject = parama.b.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break label39;
        }
        i = j;
      }
    }
    label39:
    do
    {
      return i;
      localObject = (adxp.a)((Pair)localObject).first;
      if ((parama.E == null) || (parama.E.getHeight() <= 0)) {
        break;
      }
      j = parama.E.getHeight() - ((adxp.a)localObject).g.cKF - ((adxp.a)localObject).g.cKG;
      i = j;
    } while (j <= parama.hG.getHeight());
    return parama.hG.getHeight();
    return wja.dp2px(57.0F, paramQQAppInterface.getApp().getResources()) - ((adxp.a)localObject).g.cKF - ((adxp.a)localObject).g.cKG;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.e parame, MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (anlm.ayn()) {}
    label133:
    label140:
    for (;;)
    {
      return false;
      if (paramMessageForPtt.needVipBubble())
      {
        int i = BubbleManager.cKU;
        if (i == 0) {
          i = ((acle)paramQQAppInterface.getBusinessHandler(13)).j(paramMessageForPtt);
        }
        for (;;)
        {
          if (i == 0) {
            break label140;
          }
          paramMessageForPtt = paramContext.getResources();
          if (!(paramContext instanceof MultiForwardActivity))
          {
            bool1 = true;
            parame.b = adyd.a(i, paramQQAppInterface, paramMessageForPtt, paramBaseAdapter, bool1);
            if ((parame.b == null) || (parame.b.bubbleId <= 0)) {
              break;
            }
            paramQQAppInterface = parame.b.a(paramQQAppInterface, 7);
            if ((paramQQAppInterface == null) || (paramQQAppInterface.first == null)) {
              break label133;
            }
          }
          for (boolean bool1 = bool2;; bool1 = false)
          {
            return bool1;
            bool1 = false;
            break;
          }
        }
      }
    }
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, xkx.a parama)
  {
    int i;
    Object localObject;
    int j;
    int m;
    if ((paramBoolean1) && (paramQQAppInterface != null))
    {
      if (paramBoolean2) {}
      for (float f = 6.0F;; f = 24.0F)
      {
        i = paramInt + wja.dp2px(f, paramQQAppInterface.getApp().getResources());
        localObject = parama.b.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break;
        }
        return new int[] { i, 0, 0 };
      }
      localObject = (adxp.a)((Pair)localObject).first;
      if (parama.hG.getLeft() > 0)
      {
        paramInt = ((adxp.a)localObject).g.cKD - parama.hG.getLeft();
        j = paramInt;
        if (paramInt < 0) {
          j = 0;
        }
        m = wja.dp2px(6.0F, paramQQAppInterface.getApp().getResources());
        i = i - j - m;
        paramQQAppInterface = ((adxp.a)localObject).g.kI;
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length <= 0)) {
          break label338;
        }
        if (i > paramQQAppInterface[0]) {
          break label232;
        }
        i = paramQQAppInterface[0];
        paramInt = 0;
      }
    }
    label338:
    for (;;)
    {
      return new int[] { i, paramInt / 2 + j, paramInt / 2 + m };
      paramInt = ((adxp.a)localObject).g.cKD - wja.dp2px(12.0F, paramQQAppInterface.getApp().getResources());
      break;
      label232:
      if (i >= paramQQAppInterface[(paramQQAppInterface.length - 1)])
      {
        paramInt = i - paramQQAppInterface[(paramQQAppInterface.length - 1)];
        i = paramQQAppInterface[(paramQQAppInterface.length - 1)];
      }
      else
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < paramQQAppInterface.length - 1)
          {
            if ((i >= paramQQAppInterface[paramInt]) && (i < paramQQAppInterface[(paramInt + 1)]))
            {
              int n = paramQQAppInterface[paramInt];
              int k = paramQQAppInterface[paramInt];
              paramInt = i - n;
              i = k;
              break;
            }
            paramInt += 1;
            continue;
            return new int[] { paramInt, 0, 0 };
          }
        }
        paramInt = 0;
      }
    }
  }
  
  public static class VoicePrintView
    extends ImageView
  {
    private adxp.a jdField_a_of_type_Adxp$a;
    private VoicePrintUtils.a jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$a;
    private String aTx;
    private VipPngPlayAnimationDrawable b;
    public int bPL;
    public int bPM;
    public int height;
    BitmapFactory.Options options = new BitmapFactory.Options();
    private boolean reverse;
    public int width;
    
    public VoicePrintView(Context paramContext)
    {
      super();
      this.options.inDensity = 320;
      this.options.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
    }
    
    private boolean RC()
    {
      Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(this.aTx);
      if (localBitmap != null)
      {
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        if (localLayoutParams.height > localBitmap.getHeight())
        {
          localLayoutParams.height = localBitmap.getHeight();
          this.height = localBitmap.getHeight();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$a.e(localBitmap, this.width);
        this.b.mWidth = this.width;
        this.b.mHeight = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$a.bmp.getHeight();
        this.b.mLayoutWidth = this.width;
        this.b.mLayoutHeight = this.height;
        this.b.c(this.jdField_a_of_type_Adxp$a.ez, this.jdField_a_of_type_Adxp$a.duration);
        this.b.mRepeatCount = -1;
        this.b.mReverse = this.reverse;
        return true;
      }
      return false;
    }
    
    public void setBitmap(adxp.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      this.reverse = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$a = new VoicePrintUtils.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$a.canvasWidth = (paramInt1 + paramInt3 + paramInt4);
      this.width = paramInt1;
      this.height = paramInt2;
      this.bPL = paramInt3;
      this.bPM = paramInt4;
      this.aTx = parama.ez[0];
      this.jdField_a_of_type_Adxp$a = parama;
      setPadding(paramInt3, 0, paramInt4, 0);
      this.b = new VipPngPlayAnimationDrawable(getResources());
      if (!RC()) {
        new a().execute(new String[] { this.aTx });
      }
    }
    
    public void yF(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$a);
        return;
      }
      setImageDrawable(this.b);
    }
    
    class a
      extends AsyncTask<String, Void, Bitmap>
    {
      a() {}
      
      protected Bitmap c(String... paramVarArgs)
      {
        paramVarArgs = paramVarArgs[0];
        if (BaseApplicationImpl.sImageCache.get(paramVarArgs) == null)
        {
          Bitmap localBitmap = BubbleManager.decodeFile(paramVarArgs, VoicePrintUtils.VoicePrintView.this.options);
          if (QLog.isColorLevel()) {
            QLog.d("VoicePrintUtils.DecodePngTask", 2, "decode " + paramVarArgs + "in background.");
          }
          BaseApplicationImpl.sImageCache.put(paramVarArgs, localBitmap);
        }
        return null;
      }
      
      protected void o(Bitmap paramBitmap)
      {
        VoicePrintUtils.VoicePrintView.a(VoicePrintUtils.VoicePrintView.this);
        VoicePrintUtils.VoicePrintView.this.setImageDrawable(VoicePrintUtils.VoicePrintView.a(VoicePrintUtils.VoicePrintView.this));
        VoicePrintUtils.VoicePrintView.this.invalidate();
      }
    }
  }
  
  static class a
    extends Drawable
  {
    Bitmap bmp;
    int canvasWidth;
    Paint paint = new Paint(6);
    boolean reverse;
    Rect src;
    
    public void draw(Canvas paramCanvas)
    {
      if (this.bmp == null) {
        QLog.e("VoicePrintView", 1, "onDraw(), bmp==null");
      }
      int i;
      do
      {
        return;
        i = 0;
        if (this.reverse)
        {
          i = paramCanvas.save();
          paramCanvas.scale(-1.0F, 1.0F, this.canvasWidth / 2.0F, getBounds().exactCenterY());
        }
        paramCanvas.drawBitmap(this.bmp, this.src, getBounds(), this.paint);
      } while (!this.reverse);
      paramCanvas.restoreToCount(i);
    }
    
    public void e(Bitmap paramBitmap, int paramInt)
    {
      this.bmp = paramBitmap;
      this.src = new Rect(0, 0, paramInt, paramBitmap.getHeight());
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public void setAlpha(int paramInt)
    {
      if (paramInt != this.paint.getAlpha())
      {
        this.paint.setAlpha(paramInt);
        super.invalidateSelf();
      }
    }
    
    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.paint.setColorFilter(paramColorFilter);
      super.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils
 * JD-Core Version:    0.7.0.1
 */