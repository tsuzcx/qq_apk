package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import aofk.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ColorClearableEditText
  extends ClearableEditText
{
  private ArrayList<a> Dk = new ArrayList();
  private b a = new b();
  private Rect cN = new Rect();
  private Rect cO = new Rect();
  private Rect cP = new Rect();
  private int cdT;
  private Bitmap gI;
  private Bitmap gJ;
  private int[] mColors;
  private int mOrientation;
  private float[] mPositions;
  
  public ColorClearableEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ColorClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Canvas a(int paramInt1, int paramInt2)
  {
    if ((this.gI == null) || (this.gI.getWidth() != paramInt1) || (this.gI.getHeight() != paramInt2))
    {
      if (this.gI != null) {
        this.gI.recycle();
      }
      this.gI = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas(this.gI);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    return localCanvas;
  }
  
  public static void a(List<a> paramList, b paramb, Spannable paramSpannable)
  {
    paramList.clear();
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])paramSpannable.getSpans(0, paramSpannable.length(), CharacterStyle.class);
    if (arrayOfCharacterStyle.length == 0)
    {
      paramList.add(new a(1, 0, paramSpannable.length(), paramSpannable.toString(), null));
      return;
    }
    paramb.a(paramSpannable);
    Arrays.sort(arrayOfCharacterStyle, paramb);
    int j = 0;
    int i = 0;
    label76:
    int m;
    int k;
    if (i < arrayOfCharacterStyle.length)
    {
      m = paramSpannable.getSpanStart(arrayOfCharacterStyle[i]);
      k = paramSpannable.getSpanEnd(arrayOfCharacterStyle[i]);
      if (m > j) {
        paramList.add(new a(1, j, m, paramSpannable.subSequence(j, m).toString(), null));
      }
      paramb = paramSpannable.subSequence(m, k).toString();
      if (!(arrayOfCharacterStyle[i] instanceof aofk.a)) {
        break label279;
      }
    }
    label279:
    for (j = 2;; j = 3)
    {
      paramList.add(new a(j, m, k, paramb, arrayOfCharacterStyle[i]));
      if ((i == arrayOfCharacterStyle.length - 1) && (k < paramSpannable.length()))
      {
        paramb = paramSpannable.subSequence(k, paramSpannable.length()).toString();
        paramList.add(new a(1, k, paramSpannable.length(), paramb, null));
      }
      i += 1;
      j = k;
      break label76;
      break;
    }
  }
  
  private PointF e()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i = 0;
    float f = 0.0F;
    if (i < this.Dk.size())
    {
      Object localObject = (a)this.Dk.get(i);
      switch (((a)localObject).type)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localPointF.x += getPaint().measureText(((a)localObject).text);
        getPaint().getTextBounds(((a)localObject).text, 0, ((a)localObject).text.length(), localRect);
        f = Math.max(f, localRect.height());
        continue;
        localObject = (aofk.a)((a)localObject).a;
        localPointF.x += ((aofk.a)localObject).getDrawable().getBounds().width();
        f = Math.max(f, ((aofk.a)localObject).getDrawable().getBounds().height());
      }
    }
    localPointF.y = f;
    return localPointF;
  }
  
  public ArrayList<a> ee()
  {
    return this.Dk;
  }
  
  public void ehP()
  {
    a(this.Dk, this.a, getText());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    float f3;
    float f6;
    float f1;
    Paint localPaint;
    int i;
    int j;
    a locala;
    if (this.cdT != 0)
    {
      a(this.Dk, this.a, getText());
      localObject = e();
      f3 = ((PointF)localObject).x;
      f6 = ((PointF)localObject).y;
      if ((f3 > 0.0F) && (f6 > 0.0F)) {}
      switch (this.cdT)
      {
      default: 
        super.onDraw(paramCanvas);
        return;
      case 2: 
        getPaint().setShader(null);
        localObject = a((int)f3, (int)f6);
        f1 = 0.0F;
        localPaint = new Paint(getPaint());
        i = 0;
        j = 0;
        while (j < this.Dk.size())
        {
          locala = (a)this.Dk.get(j);
          switch (locala.type)
          {
          default: 
            j += 1;
            break;
          case 1: 
            label196:
            if (i != 0) {
              break label1104;
            }
            getPaint().getTextBounds(locala.text, 0, locala.text.length(), this.cN);
            i = this.cN.height();
          }
        }
      }
    }
    label290:
    label314:
    label328:
    label461:
    label1104:
    for (;;)
    {
      int k = 0;
      float f2;
      if (k < locala.text.length())
      {
        float f7 = getPaint().measureText(locala.text, k, k + 1);
        if (this.mOrientation == 1)
        {
          f2 = f1;
          if (this.mOrientation != 1) {
            break label437;
          }
          f3 = i * 0.5F + f6 - i;
          if (this.mOrientation != 1) {
            break label448;
          }
          f4 = f1 + f7;
          if (this.mOrientation != 1) {
            break label461;
          }
        }
        for (float f5 = i * 0.5F + f6 - i;; f5 = i)
        {
          localPaint.setShader(new LinearGradient(f2, f3, f4, f5, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          ((Canvas)localObject).drawRect(f1, f6 - i, f1 + f7, f6, localPaint);
          k += 1;
          f1 += f7;
          break;
          f2 = f1 + 0.5F * f7;
          break label290;
          f3 = f6 - i;
          break label314;
          f4 = f1 + 0.5F * f7;
          break label328;
        }
      }
      break label196;
      f1 += ((aofk.a)locala.a).getDrawable().getBounds().width();
      break label196;
      localObject = new BitmapShader(this.gI, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      getPaint().setShader((Shader)localObject);
      break;
      localObject = new RadialGradient(f3 / 2.0F, f6 / 2.0F, f3 / 2.0F, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      if (this.mOrientation == 1)
      {
        f1 = 0.0F;
        label592:
        if (this.mOrientation != 1) {
          break label680;
        }
        f2 = f6 * 0.5F;
        label607:
        if (this.mOrientation != 1) {
          break label685;
        }
        label615:
        if (this.mOrientation != 1) {
          break label696;
        }
      }
      for (float f4 = f6 * 0.5F;; f4 = f6)
      {
        localObject = new LinearGradient(f1, f2, f3, f4, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
        getPaint().setShader((Shader)localObject);
        break;
        f1 = f3 * 0.5F;
        break label592;
        f2 = 0.0F;
        break label607;
        f3 *= 0.5F;
        break label615;
      }
      getPaint().setShader(null);
      localObject = a((int)f3, (int)f6);
      f1 = 0.0F;
      localPaint = new Paint(getPaint());
      i = 0;
      j = 0;
      if (j < this.Dk.size())
      {
        locala = (a)this.Dk.get(j);
        switch (locala.type)
        {
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          while (k < locala.text.length())
          {
            f2 = getPaint().measureText(locala.text, k, k + 1);
            localPaint.setColor(this.mColors[(i % this.mColors.length)]);
            localPaint.setStyle(Paint.Style.FILL);
            ((Canvas)localObject).drawRect(f1, 0.0F, f1 + f2, f6, localPaint);
            k += 1;
            i += 1;
            f1 += f2;
          }
          continue;
          f1 += ((aofk.a)locala.a).getDrawable().getBounds().width();
        }
      }
      localObject = new BitmapShader(this.gI, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      if (this.gJ == null) {
        break;
      }
      localObject = a((int)f3, (int)f6);
      j = this.gJ.getWidth();
      i = 0;
      while (i < f3)
      {
        this.cP.set(i, 0, i + j, (int)f6);
        ((Canvas)localObject).drawBitmap(this.gJ, this.cO, this.cP, getPaint());
        i += j;
      }
      localObject = new BitmapShader(this.gI, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      break;
    }
  }
  
  public void setSpecialColor(int paramInt1, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2, Bitmap paramBitmap)
  {
    this.cdT = paramInt1;
    this.mOrientation = paramInt2;
    if (paramArrayOfInt != null) {
      this.mColors = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    }
    if (paramArrayOfFloat != null) {
      this.mPositions = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    }
    this.gJ = paramBitmap;
    if (this.gJ != null) {
      this.cO.set(0, 0, this.gJ.getWidth(), this.gJ.getHeight());
    }
    invalidate();
  }
  
  public static class a
  {
    public CharacterStyle a;
    public int end;
    public int start;
    public String text;
    public int type;
    
    public a(int paramInt1, int paramInt2, int paramInt3, String paramString, CharacterStyle paramCharacterStyle)
    {
      this.type = paramInt1;
      this.start = paramInt2;
      this.end = paramInt3;
      this.text = paramString;
      this.a = paramCharacterStyle;
    }
  }
  
  public static class b
    implements Comparator<CharacterStyle>
  {
    Spanned a;
    
    public int a(CharacterStyle paramCharacterStyle1, CharacterStyle paramCharacterStyle2)
    {
      int i = 1;
      if (this.a == null) {
        i = 0;
      }
      int j;
      int k;
      do
      {
        do
        {
          return i;
          j = this.a.getSpanStart(paramCharacterStyle1);
          k = this.a.getSpanStart(paramCharacterStyle2);
          if (j != k) {
            break;
          }
          j = this.a.getSpanEnd(paramCharacterStyle1);
          k = this.a.getSpanEnd(paramCharacterStyle2);
          if (j == k) {
            return 0;
          }
        } while (j > k);
        return -1;
      } while (j > k);
      return -1;
    }
    
    public void a(Spanned paramSpanned)
    {
      this.a = paramSpanned;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorClearableEditText
 * JD-Core Version:    0.7.0.1
 */