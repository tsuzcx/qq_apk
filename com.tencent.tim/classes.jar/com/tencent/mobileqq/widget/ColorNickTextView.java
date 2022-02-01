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
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.widget.TextView;
import aofk.a;
import arge;
import arge.a;
import java.util.ArrayList;
import java.util.Arrays;

public class ColorNickTextView
  extends TextView
  implements arge.a
{
  private ArrayList<ColorClearableEditText.a> Dk = new ArrayList();
  private arge jdField_a_of_type_Arge;
  private ColorClearableEditText.b jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$b = new ColorClearableEditText.b();
  private CharSequence aB;
  private Rect cN = new Rect();
  private Rect cO = new Rect();
  private Rect cP = new Rect();
  private int cdT;
  private Bitmap gI;
  private Bitmap gJ;
  private int[] mColors;
  private int mOrientation;
  private float[] mPositions;
  
  public ColorNickTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
  
  private void bp(Canvas paramCanvas)
  {
    Object localObject;
    float f3;
    float f6;
    float f1;
    Paint localPaint;
    int i;
    int j;
    ColorClearableEditText.a locala;
    if (this.cdT != 0)
    {
      ehP();
      if (this.Dk.size() == 0)
      {
        getPaint().setShader(null);
        super.onDraw(paramCanvas);
        return;
      }
      localObject = e();
      f3 = ((PointF)localObject).x;
      f6 = ((PointF)localObject).y;
      if ((f3 > 0.0F) && (f6 > 0.0F)) {
        getPaint().setColor(-16777216);
      }
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
          locala = (ColorClearableEditText.a)this.Dk.get(j);
          switch (locala.type)
          {
          default: 
            j += 1;
            break;
          case 1: 
            label216:
            if (i != 0) {
              break label1116;
            }
            getPaint().getTextBounds(locala.text, 0, locala.text.length(), this.cN);
            i = this.cN.height();
          }
        }
      }
    }
    label310:
    label333:
    label347:
    label1116:
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
            break label454;
          }
          f3 = i * 0.5F + f6 - i;
          if (this.mOrientation != 1) {
            break label465;
          }
          f4 = f1 + f7;
          if (this.mOrientation != 1) {
            break label477;
          }
        }
        label477:
        for (float f5 = i * 0.5F + f6 - i;; f5 = i)
        {
          localPaint.setShader(new LinearGradient(f2, f3, f4, f5, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          ((Canvas)localObject).drawRect(f1, f6 - i, f1 + f7, f6, localPaint);
          k += 1;
          f1 += f7;
          break;
          f2 = f1 + 0.5F * f7;
          break label310;
          f3 = f6 - i;
          break label333;
          f4 = f1 + 0.5F * f7;
          break label347;
        }
      }
      break label216;
      f1 += ((aofk.a)locala.a).getDrawable().getBounds().width();
      break label216;
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
        label608:
        if (this.mOrientation != 1) {
          break label693;
        }
        f2 = f6 * 0.5F;
        label622:
        if (this.mOrientation != 1) {
          break label698;
        }
        label630:
        if (this.mOrientation != 1) {
          break label708;
        }
      }
      for (float f4 = f6 * 0.5F;; f4 = f6)
      {
        localObject = new LinearGradient(f1, f2, f3, f4, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
        getPaint().setShader((Shader)localObject);
        break;
        f1 = f3 * 0.5F;
        break label608;
        f2 = 0.0F;
        break label622;
        f3 *= 0.5F;
        break label630;
      }
      getPaint().setShader(null);
      localObject = a((int)f3, (int)f6);
      f1 = 0.0F;
      localPaint = new Paint(getPaint());
      i = 0;
      j = 0;
      if (j < this.Dk.size())
      {
        locala = (ColorClearableEditText.a)this.Dk.get(j);
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
  
  private PointF e()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i = 0;
    float f = 0.0F;
    if (i < this.Dk.size())
    {
      Object localObject = (ColorClearableEditText.a)this.Dk.get(i);
      switch (((ColorClearableEditText.a)localObject).type)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localPointF.x += getPaint().measureText(((ColorClearableEditText.a)localObject).text);
        getPaint().getTextBounds(((ColorClearableEditText.a)localObject).text, 0, ((ColorClearableEditText.a)localObject).text.length(), localRect);
        f = Math.max(f, localRect.height());
        continue;
        localObject = (aofk.a)((ColorClearableEditText.a)localObject).a;
        localPointF.x += ((aofk.a)localObject).getDrawable().getBounds().width();
        f = Math.max(f, ((aofk.a)localObject).getDrawable().getBounds().height());
      }
    }
    localPointF.y = f;
    return localPointF;
  }
  
  public void aX(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void aY(Canvas paramCanvas)
  {
    bp(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void ehP()
  {
    int j = 0;
    Object localObject1 = getText();
    if ((localObject1 instanceof Spanned)) {}
    for (localObject1 = (Spanned)localObject1;; localObject1 = null)
    {
      CharacterStyle[] arrayOfCharacterStyle;
      if (localObject1 != null)
      {
        this.aB = getText();
        this.Dk.clear();
        arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject1).getSpans(0, getText().length(), CharacterStyle.class);
        if (arrayOfCharacterStyle.length == 0)
        {
          localObject1 = new ColorClearableEditText.a(1, 0, this.aB.length(), this.aB.toString(), null);
          this.Dk.add(localObject1);
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$b.a((Spanned)localObject1);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$b);
      int i = 0;
      label135:
      int m;
      int k;
      Object localObject2;
      if (i < arrayOfCharacterStyle.length)
      {
        m = ((Spanned)localObject1).getSpanStart(arrayOfCharacterStyle[i]);
        k = ((Spanned)localObject1).getSpanEnd(arrayOfCharacterStyle[i]);
        if (m > j)
        {
          localObject2 = new ColorClearableEditText.a(1, j, m, getText().subSequence(j, m).toString(), null);
          this.Dk.add(localObject2);
        }
        localObject2 = getText().subSequence(m, k).toString();
        if (!(arrayOfCharacterStyle[i] instanceof aofk.a)) {
          break label364;
        }
      }
      label364:
      for (j = 2;; j = 3)
      {
        localObject2 = new ColorClearableEditText.a(j, m, k, (String)localObject2, arrayOfCharacterStyle[i]);
        this.Dk.add(localObject2);
        if ((i == arrayOfCharacterStyle.length - 1) && (k < getText().length()))
        {
          localObject2 = getText().subSequence(k, getText().length()).toString();
          localObject2 = new ColorClearableEditText.a(1, k, getText().length(), (String)localObject2, null);
          this.Dk.add(localObject2);
        }
        i += 1;
        j = k;
        break label135;
        break;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.onDraw(paramCanvas);
      return;
    }
    bp(paramCanvas);
  }
  
  public void setMosaicEffect(arge paramarge)
  {
    if (this.jdField_a_of_type_Arge != null) {
      this.jdField_a_of_type_Arge.setView(null);
    }
    this.jdField_a_of_type_Arge = paramarge;
    if (this.jdField_a_of_type_Arge != null) {
      this.jdField_a_of_type_Arge.setView(this);
    }
    invalidate();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorNickTextView
 * JD-Core Version:    0.7.0.1
 */