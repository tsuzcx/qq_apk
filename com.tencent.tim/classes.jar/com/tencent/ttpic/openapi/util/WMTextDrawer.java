package com.tencent.ttpic.openapi.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.util.WMTokenizer;
import com.tencent.ttpic.util.WMTokenizer.Token;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

public class WMTextDrawer
{
  protected static final String INT_D = "%d";
  private static final String TAG = WMTextDrawer.class.getSimpleName();
  private static Map<String, Typeface> typefaceCache = new HashMap();
  private AsyncDrawRunnable asyncDrawRunnable;
  private boolean isAsyncDrawFinished = true;
  public String lastDrawText = "";
  
  @TargetApi(17)
  public static Bitmap blurBitmap(Context paramContext, Bitmap paramBitmap, float paramFloat)
  {
    if ((paramContext == null) || (!BitmapUtils.isLegal(paramBitmap))) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap);
    paramContext = RenderScript.create(paramContext);
    ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
    paramBitmap = Allocation.createFromBitmap(paramContext, paramBitmap);
    Allocation localAllocation = Allocation.createFromBitmap(paramContext, localBitmap);
    localScriptIntrinsicBlur.setRadius(paramFloat);
    localScriptIntrinsicBlur.setInput(paramBitmap);
    localScriptIntrinsicBlur.forEach(localAllocation);
    localAllocation.copyTo(localBitmap);
    paramBitmap.destroy();
    localAllocation.destroy();
    localScriptIntrinsicBlur.destroy();
    paramContext.destroy();
    return localBitmap;
  }
  
  private void drawHorizontalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    new TextHorizontalLayout(paramTextWMElement, paramInt1, paramInt2, paramString).draw(paramCanvas);
  }
  
  private void drawNormalVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    new TextVerticalLayout(paramTextWMElement, paramInt1, paramInt2, paramString).draw(paramCanvas);
  }
  
  private void drawRotatedVerticalText(TextWMElement paramTextWMElement, String paramString)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramTextWMElement.height, paramTextWMElement.width, Bitmap.Config.ARGB_8888);
    drawHorizontalText(paramTextWMElement, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight(), paramString);
    if (BitmapUtils.isLegal(paramTextWMElement.getIdleBitmap())) {
      paramTextWMElement.getIdleBitmap().recycle();
    }
    paramTextWMElement.setIdleBitmap(rotateBitmap(localBitmap, paramTextWMElement.rotate));
  }
  
  private void drawVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTextWMElement.rotate == 90) || (paramTextWMElement.rotate == -90))
    {
      drawRotatedVerticalText(paramTextWMElement, paramString);
      return;
    }
    drawNormalVerticalText(paramTextWMElement, paramCanvas, paramInt1, paramInt2, paramString);
  }
  
  public static Bitmap fastblur(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    Object localObject = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * paramFloat), Math.round(paramBitmap.getHeight() * paramFloat), false);
    Bitmap localBitmap = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
    if ((localObject != paramBitmap) && (localObject != localBitmap)) {
      ((Bitmap)localObject).recycle();
    }
    if (paramInt < 1) {
      localObject = null;
    }
    do
    {
      return localObject;
      int i = paramInt;
      if (paramFloat < 0.5F) {
        i = (int)(paramInt * paramFloat * 2.0F);
      }
      int i5 = localBitmap.getWidth();
      int i6 = localBitmap.getHeight();
      localObject = new int[i5 * i6];
      localBitmap.getPixels((int[])localObject, 0, i5, 0, 0, i5, i6);
      int i10 = i5 - 1;
      int i7 = i6 - 1;
      paramInt = i5 * i6;
      int i8 = i + i + 1;
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      arrayOfInt2 = new int[paramInt];
      arrayOfInt2 = new int[Math.max(i5, i6)];
      paramInt = i8 + 1 >> 1;
      int j = paramInt * paramInt;
      int[] arrayOfInt3 = new int[j * 256];
      paramInt = 0;
      while (paramInt < j * 256)
      {
        arrayOfInt3[paramInt] = (paramInt / j);
        paramInt += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i8, 1 });
      int i9 = i + 1;
      int i1 = 0;
      int n = 0;
      paramInt = 0;
      int i2;
      int m;
      int k;
      int i3;
      int[] arrayOfInt4;
      while (i1 < i6)
      {
        j = 0;
        i2 = -i;
        m = 0;
        k = 0;
        if (i2 <= i)
        {
          i3 = localObject[(Math.min(i10, Math.max(i2, 0)) + paramInt)];
          arrayOfInt4 = arrayOfInt[(i2 + i)];
          arrayOfInt4[0] = ((i3 & 0xFF000000) >>> 24);
          m += (i9 - Math.abs(i2)) * arrayOfInt4[0];
          if (i2 > 0) {
            j += arrayOfInt4[0];
          }
          for (;;)
          {
            i2 += 1;
            break;
            k += arrayOfInt4[0];
          }
        }
        i2 = m;
        m = i;
        int i4 = 0;
        i3 = j;
        j = k;
        k = i4;
        while (k < i5)
        {
          arrayOfInt1[paramInt] = arrayOfInt3[i2];
          arrayOfInt4 = arrayOfInt[((m - i + i8) % i8)];
          i4 = arrayOfInt4[0];
          if (i1 == 0) {
            arrayOfInt2[k] = Math.min(k + i + 1, i10);
          }
          arrayOfInt4[0] = ((localObject[(arrayOfInt2[k] + n)] & 0xFF000000) >>> 24);
          i3 += arrayOfInt4[0];
          i2 = i2 - j + i3;
          m = (m + 1) % i8;
          arrayOfInt4 = arrayOfInt[(m % i8)];
          j = j - i4 + arrayOfInt4[0];
          i3 -= arrayOfInt4[0];
          paramInt += 1;
          k += 1;
        }
        i1 += 1;
        n += i5;
      }
      paramInt = 0;
      while (paramInt < i5)
      {
        j = 0;
        i1 = -i * i5;
        n = -i;
        m = 0;
        k = 0;
        if (n <= i)
        {
          i2 = Math.max(0, i1) + paramInt;
          arrayOfInt4 = arrayOfInt[(n + i)];
          arrayOfInt4[0] = arrayOfInt1[i2];
          i3 = Math.abs(n);
          i2 = m + arrayOfInt1[i2] * (i9 - i3);
          if (n > 0) {
            j += arrayOfInt4[0];
          }
          for (;;)
          {
            m = i1;
            if (n < i7) {
              m = i1 + i5;
            }
            n += 1;
            i1 = m;
            m = i2;
            break;
            k += arrayOfInt4[0];
          }
        }
        n = 0;
        i1 = paramInt;
        i3 = i;
        i2 = j;
        j = i3;
        while (n < i6)
        {
          localObject[i1] = (0xFF000000 & arrayOfInt3[m] << 24 | 0xFFFFFF & localObject[i1]);
          arrayOfInt4 = arrayOfInt[((j - i + i8) % i8)];
          i3 = arrayOfInt4[0];
          if (paramInt == 0) {
            arrayOfInt2[n] = (Math.min(n + i9, i7) * i5);
          }
          arrayOfInt4[0] = arrayOfInt1[(arrayOfInt2[n] + paramInt)];
          i2 += arrayOfInt4[0];
          m = m - k + i2;
          j = (j + 1) % i8;
          arrayOfInt4 = arrayOfInt[j];
          k = k - i3 + arrayOfInt4[0];
          i2 -= arrayOfInt4[0];
          i1 += i5;
          n += 1;
        }
        paramInt += 1;
      }
      localBitmap.setPixels((int[])localObject, 0, i5, 0, 0, i5, i6);
      localObject = localBitmap;
    } while (paramFloat == 1.0F);
    localObject = Bitmap.createScaledBitmap(localBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
    if ((localObject != localBitmap) && (localBitmap != paramBitmap)) {
      localBitmap.recycle();
    }
    return localObject;
  }
  
  public static void putTypeface(@NonNull String paramString, @NonNull Typeface paramTypeface)
  {
    if (typefaceCache != null) {
      typefaceCache.put(paramString, paramTypeface);
    }
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramFloat);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      localObject = localBitmap;
    } while (localBitmap.equals(paramBitmap));
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public void cancelAsyncDrawTask()
  {
    if ((!this.isAsyncDrawFinished) && (this.asyncDrawRunnable != null))
    {
      this.asyncDrawRunnable.isTaskCanceled = true;
      this.isAsyncDrawFinished = true;
    }
  }
  
  public void drawTextToBitmap(TextWMElement paramTextWMElement, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {
      this.lastDrawText = paramString;
    }
    this.isAsyncDrawFinished = false;
    this.asyncDrawRunnable = new WMTextDrawer.1(this, paramTextWMElement, paramString, paramBoolean1);
    if (paramBoolean2)
    {
      this.asyncDrawRunnable.run();
      return;
    }
    AsyncTask.SERIAL_EXECUTOR.execute(this.asyncDrawRunnable);
  }
  
  public boolean isAsyncDrawFinished()
  {
    return this.isAsyncDrawFinished;
  }
  
  public abstract class AsyncDrawRunnable
    implements Runnable
  {
    public boolean isTaskCanceled = false;
    
    public AsyncDrawRunnable() {}
  }
  
  class TextHorizontalLayout
    extends WMTextDrawer.TextLayout
  {
    public TextHorizontalLayout(TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt1, paramInt2, paramString);
    }
    
    protected void drawText(Canvas paramCanvas, float paramFloat1, float paramFloat2)
    {
      this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
      float f4 = this.mWMTokenizer.getFontHeight() / 2.0F;
      float f5 = (Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0F;
      Iterator localIterator = this.mWMTokenizer.getTokens().iterator();
      if (localIterator.hasNext())
      {
        WMTokenizer.Token localToken = (WMTokenizer.Token)localIterator.next();
        float[] arrayOfFloat = new float[localToken.text.length()];
        this.mPaint.getTextWidths(localToken.text, arrayOfFloat);
        float f1 = localToken.x;
        float f6 = localToken.y;
        int i = 0;
        label128:
        float f7;
        float f8;
        float f2;
        if (i < localToken.text.length())
        {
          draw(paramCanvas, String.valueOf(localToken.text.charAt(i)), f1 + paramFloat1, f6 + (f4 + f5) + paramFloat2);
          f7 = arrayOfFloat[i];
          f8 = this.mWMElement.kern;
          if (this.mWMElement.outerStrokeSize <= 0.0F) {
            break label261;
          }
          f2 = this.mWMElement.outerStrokeSize * 2.0F;
          label213:
          if (this.mWMElement.strokeSize <= 0.0F) {
            break label267;
          }
        }
        label261:
        label267:
        for (float f3 = this.mWMElement.shadowSize * 2.0F;; f3 = 0.0F)
        {
          f1 += f3 + (f8 + f7 + f2);
          i += 1;
          break label128;
          break;
          f2 = 0.0F;
          break label213;
        }
      }
    }
  }
  
  public static abstract class TextLayout
  {
    protected TextPaint mOuterStrokePaint;
    protected TextPaint mPaint;
    protected TextPaint mStrokePaint;
    protected String mText;
    protected TextWMElement mWMElement;
    protected WMTokenizer mWMTokenizer;
    
    protected TextLayout(TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
    {
      this.mText = paramString;
      this.mWMElement = paramTextWMElement;
      this.mPaint = genPaint(this.mWMElement);
      paramTextWMElement = WMTokenizer.from(this.mText, this.mPaint).setWidth(paramInt1).setHeight(paramInt2).setAlign(this.mWMElement.alignment);
      if (!this.mWMElement.multiRow)
      {
        bool1 = true;
        paramTextWMElement = paramTextWMElement.setSingleLine(bool1).setSpacingPlus(this.mWMElement.kern);
        if (this.mWMElement.vertical != 1) {
          break label141;
        }
      }
      label141:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.mWMTokenizer = paramTextWMElement.setVertical(bool1);
        adjustPaintIfNeed();
        this.mWMTokenizer.tokenizer();
        this.mWMTokenizer.doLayout();
        return;
        bool1 = false;
        break;
      }
    }
    
    private void adjustPaintIfNeed()
    {
      if (this.mWMElement.fontFit == 1)
      {
        fontKernCompat();
        this.mWMTokenizer.tokenizer();
        if (!this.mWMTokenizer.isFitIn()) {
          break label377;
        }
        while (this.mWMTokenizer.isFitIn())
        {
          this.mPaint.setTextSize(this.mPaint.getTextSize() + 4.0F);
          fontKernCompat();
          this.mWMTokenizer.tokenizer();
        }
        this.mPaint.setTextSize(this.mPaint.getTextSize() - 4.0F);
        fontKernCompat();
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(this.mWMElement.fontName)) && (this.mWMElement.fontName.equals("axis")) && (this.mPaint.getTextSize() - 30.0F > 0.0F)) {
          this.mPaint.setTextSize(this.mPaint.getTextSize() - 30.0F);
        }
        if ((!TextUtils.isEmpty(this.mWMElement.fontName)) && (this.mWMElement.fontName.equals("happytime")) && (this.mPaint.getTextSize() - 20.0F > 0.0F)) {
          this.mPaint.setTextSize(this.mPaint.getTextSize() - 20.0F);
        }
        if (this.mWMElement.strokeSize > 0.0F)
        {
          this.mStrokePaint = new TextPaint(this.mPaint);
          this.mStrokePaint.setShader(null);
          this.mStrokePaint.setMaskFilter(null);
          this.mStrokePaint.setStyle(Paint.Style.STROKE);
          this.mStrokePaint.setColor(Color.parseColor(this.mWMElement.strokeColor));
          this.mStrokePaint.setStrokeWidth(this.mWMElement.strokeSize * (this.mPaint.getTextSize() / 20.0F) * 1.2F);
        }
        if (this.mWMElement.outerStrokeSize > 0.0F)
        {
          this.mOuterStrokePaint = new TextPaint(this.mPaint);
          this.mOuterStrokePaint.setShader(null);
          this.mOuterStrokePaint.setMaskFilter(null);
          this.mOuterStrokePaint.setColor(Color.parseColor(this.mWMElement.outerStrokeColor));
        }
        return;
        label377:
        while (!this.mWMTokenizer.isFitIn())
        {
          this.mPaint.setTextSize(this.mPaint.getTextSize() - 4.0F);
          fontKernCompat();
          this.mWMTokenizer.tokenizer();
        }
        fontKernCompat();
      }
    }
    
    private TextPaint genPaint(TextWMElement paramTextWMElement)
    {
      TextPaint localTextPaint = new TextPaint();
      localTextPaint.setAntiAlias(true);
      if (!TextUtils.isEmpty(paramTextWMElement.fontName)) {}
      do
      {
        for (;;)
        {
          try
          {
            localObject2 = (Typeface)WMTextDrawer.typefaceCache.get(paramTextWMElement.fontName);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              if (!paramTextWMElement.fontName.equals("sans_serif")) {
                continue;
              }
              if (!WMTextDrawer.typefaceCache.containsKey(paramTextWMElement.fontName)) {
                continue;
              }
              localObject1 = (Typeface)WMTextDrawer.typefaceCache.get(paramTextWMElement.fontName);
            }
            localObject2 = localObject1;
            if (!paramTextWMElement.isLocalFont)
            {
              File localFile = new File(paramTextWMElement.fontName);
              localObject2 = localObject1;
              if (localFile != null)
              {
                localObject2 = localObject1;
                if (localFile.exists()) {
                  localObject2 = Typeface.createFromFile(localFile);
                }
              }
            }
            if (localObject2 != null)
            {
              localTextPaint.setTypeface((Typeface)localObject2);
              if (!WMTextDrawer.typefaceCache.containsKey(paramTextWMElement.fontName)) {
                WMTextDrawer.typefaceCache.put(paramTextWMElement.fontName, localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            Object localObject2;
            Object localObject1;
            float f2;
            LogUtils.e(WMTextDrawer.TAG, localException.getMessage());
            continue;
            float f1 = 40.0F;
            continue;
            f1 = 0.0F;
            continue;
          }
          if (paramTextWMElement.fontSize <= 0.0F) {
            continue;
          }
          f1 = paramTextWMElement.fontSize;
          f2 = f1;
          if (f1 < 4.0F) {
            f2 = f1 + 20.0F;
          }
          localTextPaint.setTextSize(f2);
          if (!TextUtils.isEmpty(paramTextWMElement.shaderBmp))
          {
            localObject1 = paramTextWMElement.shaderBmp.replace("%d", String.valueOf(paramTextWMElement.getFrameIndex()));
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(paramTextWMElement.curShaderBmp)) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().loadImage(paramTextWMElement.itemId, (String)localObject1)))) {
              paramTextWMElement.curShaderBmp = ((String)localObject1);
            }
            localObject1 = VideoMemoryManager.getInstance().loadImage(paramTextWMElement.itemId, paramTextWMElement.curShaderBmp);
            if (BitmapUtils.isLegal((Bitmap)localObject1)) {
              localTextPaint.setShader(new BitmapShader((Bitmap)localObject1, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
            }
          }
          localTextPaint.setFakeBoldText(paramTextWMElement.fontBold);
          if (!paramTextWMElement.fontItalics) {
            continue;
          }
          f1 = -0.2F;
          localTextPaint.setTextSkewX(f1);
          localTextPaint.setColor(Color.parseColor(paramTextWMElement.color));
          return localTextPaint;
          localObject1 = Typeface.create(Typeface.SANS_SERIF, 0);
          continue;
          if (paramTextWMElement.fontName.equals("serif"))
          {
            localObject1 = Typeface.create(Typeface.SERIF, 0);
          }
          else
          {
            if (!paramTextWMElement.fontName.equals("monospace")) {
              continue;
            }
            localObject1 = Typeface.create(Typeface.MONOSPACE, 0);
          }
        }
        localObject1 = localObject2;
      } while (!paramTextWMElement.isLocalFont);
      if (paramTextWMElement.fontName.contains(".")) {}
      for (localObject1 = "fonts/" + paramTextWMElement.fontName;; localObject1 = "fonts/" + paramTextWMElement.fontName + ".ttf")
      {
        localObject1 = Typeface.createFromAsset(AEModule.getContext().getAssets(), (String)localObject1);
        break;
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      Bitmap localBitmap;
      Object localObject1;
      Object localObject3;
      if (!TextUtils.isEmpty(this.mWMElement.color))
      {
        localBitmap = this.mWMElement.getIdleBitmap();
        if (BitmapUtils.isLegal(localBitmap))
        {
          localObject1 = new Canvas(localBitmap);
          localObject3 = getPaint();
          if (localObject3 != null)
          {
            if (!TextUtils.isEmpty(this.mWMElement.shadowColor))
            {
              int i = ((Paint)localObject3).getColor();
              ((Paint)localObject3).setColor(Color.parseColor(this.mWMElement.shadowColor));
              draw((Canvas)localObject1, this.mWMElement.shadowDx, this.mWMElement.shadowDy);
              ((Paint)localObject3).setColor(i);
            }
            if (this.mWMElement.blurAmount > 0.0F)
            {
              localObject3 = null;
              localObject1 = localObject3;
              if (!BitmapUtils.isLegal(localBitmap)) {}
            }
          }
        }
      }
      try
      {
        localObject1 = WMTextDrawer.blurBitmap(AEModule.getContext(), localBitmap, this.mWMElement.blurAmount);
        if (BitmapUtils.isLegal((Bitmap)localObject1))
        {
          localObject3 = ByteBuffer.allocate(((Bitmap)localObject1).getRowBytes() * ((Bitmap)localObject1).getHeight());
          ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject3);
          ((Bitmap)localObject1).recycle();
          if (localObject3 != null) {
            ((ByteBuffer)localObject3).rewind();
          }
          if (BitmapUtils.isLegal(localBitmap)) {
            localBitmap.copyPixelsFromBuffer((Buffer)localObject3);
          }
        }
        drawText(paramCanvas, 0.0F, 0.0F);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          LogUtils.e(localRuntimeException);
          Object localObject2 = localObject3;
        }
      }
    }
    
    public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
    {
      drawText(paramCanvas, paramFloat1, paramFloat2);
    }
    
    protected void draw(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2)
    {
      if (this.mStrokePaint != null) {
        paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mStrokePaint);
      }
      if (this.mOuterStrokePaint != null)
      {
        float f = this.mWMElement.outerStrokeSize;
        paramCanvas.drawText(paramString, paramFloat1 - f, paramFloat2 - f, this.mOuterStrokePaint);
        paramCanvas.drawText(paramString, paramFloat1 + f, paramFloat2 - f, this.mOuterStrokePaint);
        paramCanvas.drawText(paramString, paramFloat1 + f, paramFloat2 + f, this.mOuterStrokePaint);
        paramCanvas.drawText(paramString, paramFloat1 - f, f + paramFloat2, this.mOuterStrokePaint);
      }
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mPaint);
    }
    
    protected void drawText(Canvas paramCanvas)
    {
      drawText(paramCanvas, 0.0F, 0.0F);
    }
    
    protected abstract void drawText(Canvas paramCanvas, float paramFloat1, float paramFloat2);
    
    public void fontKernCompat()
    {
      if ("HYHeiLiZhiTiJ".equals(this.mWMElement.fontName)) {
        this.mWMElement.kern = ((int)(this.mWMElement.kern * (this.mPaint.getTextSize() / 141.0F)));
      }
      this.mWMTokenizer.setSpacingPlus(this.mWMElement.kern);
    }
    
    public Paint getPaint()
    {
      return this.mPaint;
    }
  }
  
  class TextVerticalLayout
    extends WMTextDrawer.TextLayout
  {
    public TextVerticalLayout(TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt1, paramInt2, paramString);
    }
    
    protected void drawText(Canvas paramCanvas, float paramFloat1, float paramFloat2)
    {
      this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
      float f4 = this.mWMTokenizer.getFontHeight() / 2.0F;
      float f5 = (Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0F;
      paramCanvas.save();
      Iterator localIterator = this.mWMTokenizer.getTokens().iterator();
      if (localIterator.hasNext())
      {
        WMTokenizer.Token localToken = (WMTokenizer.Token)localIterator.next();
        float f6 = localToken.x;
        float f1 = localToken.y + (f4 + f5);
        int i = 0;
        label112:
        float f7;
        float f2;
        if (i < localToken.text.length())
        {
          draw(paramCanvas, String.valueOf(localToken.text.charAt(i)), f6 + paramFloat1, f1 + paramFloat2);
          f7 = this.mWMTokenizer.getFontHeight();
          if (this.mWMElement.outerStrokeSize <= 0.0F) {
            break label228;
          }
          f2 = this.mWMElement.outerStrokeSize * 2.0F;
          label183:
          if (this.mWMElement.strokeSize <= 0.0F) {
            break label234;
          }
        }
        label228:
        label234:
        for (float f3 = this.mWMElement.shadowSize * 2.0F;; f3 = 0.0F)
        {
          f1 += f3 + (f7 + f2);
          i += 1;
          break label112;
          break;
          f2 = 0.0F;
          break label183;
        }
      }
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.WMTextDrawer
 * JD-Core Version:    0.7.0.1
 */