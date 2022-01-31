package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinnableBitmapDrawable
  extends Drawable
{
  private static final int a = 6;
  private static final int[] k = { 16843033, 16843034, 16843035, 16843036, 16842927, 16843265 };
  private a b;
  private Bitmap c;
  private int d;
  private final Rect e = new Rect();
  private boolean f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  
  SkinnableBitmapDrawable()
  {
    this.b = new a((Bitmap)null);
  }
  
  public SkinnableBitmapDrawable(Resources paramResources)
  {
    this.b = new a((Bitmap)null);
    this.b.o = this.d;
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(new a(paramBitmap), paramResources);
    this.b.o = this.d;
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, InputStream paramInputStream)
  {
    this(new a(BitmapFactory.decodeStream(paramInputStream)), null);
    this.b.o = this.d;
    if (this.c == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramInputStream);
    }
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, String paramString)
  {
    this(new a(BitmapFactory.decodeFile(paramString)), null);
    this.b.o = this.d;
    if (this.c == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramString);
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(Bitmap paramBitmap)
  {
    this(new a(paramBitmap), null);
  }
  
  SkinnableBitmapDrawable(a parama, Resources paramResources)
  {
    this.b = parama;
    if (paramResources != null) {
      this.d = paramResources.getDisplayMetrics().densityDpi;
    }
    for (;;)
    {
      a(parama.i);
      if (parama.p)
      {
        this.g = true;
        this.f = true;
      }
      return;
      if (parama != null) {
        this.d = parama.o;
      } else {
        this.d = 160;
      }
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(InputStream paramInputStream)
  {
    this(new a(BitmapFactory.decodeStream(paramInputStream)), null);
    if (this.c == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramInputStream);
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(String paramString)
  {
    this(new a(BitmapFactory.decodeFile(paramString)), null);
    if (this.c == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramString);
    }
  }
  
  static a a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet1, AttributeSet paramAttributeSet2, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    int n = paramAttributeSet1.getAttributeCount();
    paramResources = new a((Bitmap)null);
    paramResources.p = true;
    Paint localPaint = new Paint();
    int m = 0;
    int i1;
    Object localObject1;
    if (m < n)
    {
      switch (paramAttributeSet1.getAttributeNameResource(m))
      {
      }
      for (;;)
      {
        m += 1;
        break;
        i1 = paramAttributeSet1.getAttributeResourceValue(m, 0);
        if (i1 == 0) {
          throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <bitmap> requires a valid src attribute");
        }
        localObject1 = (a)SkinEngine.getInstances().a(i1);
        paramResources.i = ((a)localObject1).i;
        paramResources.h = ((a)localObject1).h;
        continue;
        localPaint.setAntiAlias(paramAttributeSet1.getAttributeBooleanValue(m, localPaint.isAntiAlias()));
        continue;
        localPaint.setFilterBitmap(paramAttributeSet1.getAttributeBooleanValue(m, localPaint.isFilterBitmap()));
        continue;
        localPaint.setDither(paramAttributeSet1.getAttributeBooleanValue(m, localPaint.isDither()));
        continue;
        paramResources.k = paramAttributeSet1.getAttributeIntValue(m, 119);
        continue;
        i1 = paramAttributeSet1.getAttributeIntValue(m, -1);
        if (i1 != -1) {
          switch (i1)
          {
          default: 
            break;
          case 0: 
            paramResources.m = Shader.TileMode.CLAMP;
            paramResources.n = Shader.TileMode.CLAMP;
            break;
          case 1: 
            paramResources.m = Shader.TileMode.REPEAT;
            paramResources.n = Shader.TileMode.REPEAT;
            break;
          case 2: 
            paramResources.m = Shader.TileMode.MIRROR;
            paramResources.n = Shader.TileMode.MIRROR;
          }
        }
      }
    }
    if (paramAttributeSet2 != null) {
      if (paramBoolean)
      {
        n = paramAttributeSet2.getAttributeCount();
        m = 0;
        if (m < n)
        {
          switch (paramAttributeSet2.getAttributeNameResource(m))
          {
          }
          for (;;)
          {
            m += 1;
            break;
            localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(m, localPaint.isAntiAlias()));
            continue;
            localPaint.setFilterBitmap(paramAttributeSet2.getAttributeBooleanValue(m, localPaint.isFilterBitmap()));
            continue;
            localPaint.setDither(paramAttributeSet2.getAttributeBooleanValue(m, localPaint.isDither()));
            continue;
            paramResources.k = paramAttributeSet2.getAttributeIntValue(m, 119);
            continue;
            i1 = paramAttributeSet2.getAttributeIntValue(m, -2);
            if (i1 != -2) {
              switch (i1)
              {
              default: 
                break;
              case -1: 
                paramResources.m = null;
                paramResources.n = null;
                break;
              case 0: 
                paramResources.m = Shader.TileMode.CLAMP;
                paramResources.n = Shader.TileMode.CLAMP;
                break;
              case 1: 
                paramResources.m = Shader.TileMode.REPEAT;
                paramResources.n = Shader.TileMode.REPEAT;
                break;
              case 2: 
                paramResources.m = Shader.TileMode.MIRROR;
                paramResources.n = Shader.TileMode.MIRROR;
              }
            }
          }
        }
      }
      else
      {
        int i2 = paramAttributeSet2.getAttributeCount();
        n = 0;
        if (n < i2)
        {
          paramAttributeSet1 = paramAttributeSet2.getAttributeName(n);
          if ("antialias".equals(paramAttributeSet1)) {
            localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(n, localPaint.isAntiAlias()));
          }
          for (;;)
          {
            n += 1;
            break;
            if ("filter".equals(paramAttributeSet1))
            {
              localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(n, localPaint.isAntiAlias()));
            }
            else if ("dither".equals(paramAttributeSet1))
            {
              localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(n, localPaint.isAntiAlias()));
            }
            else if ("gravity".equals(paramAttributeSet1))
            {
              paramAttributeSet1 = paramAttributeSet2.getAttributeValue(n);
              localObject1 = paramAttributeSet1.split("\\|");
              int i3 = localObject1.length;
              m = 0;
              i1 = 0;
              if (i1 < i3)
              {
                Object localObject2 = localObject1[i1];
                if ("top".equals(localObject2)) {
                  m |= 0x30;
                }
                for (;;)
                {
                  i1 += 1;
                  break;
                  if ("bottom".equals(localObject2))
                  {
                    m |= 0x50;
                  }
                  else if ("left".equals(localObject2))
                  {
                    m |= 0x3;
                  }
                  else if ("right".equals(localObject2))
                  {
                    m |= 0x5;
                  }
                  else if ("center_vertical".equals(localObject2))
                  {
                    m |= 0x10;
                  }
                  else if ("fill_vertical".equals(localObject2))
                  {
                    m |= 0x70;
                  }
                  else if ("center_horizontal".equals(localObject2))
                  {
                    m |= 0x1;
                  }
                  else if ("fill_horizontal".equals(localObject2))
                  {
                    m |= 0x7;
                  }
                  else if ("center".equals(localObject2))
                  {
                    m |= 0x11;
                  }
                  else if ("fill".equals(localObject2))
                  {
                    m |= 0x77;
                  }
                  else if ("clip_vertical".equals(localObject2))
                  {
                    m |= 0x80;
                  }
                  else if ("clip_horizontal".equals(localObject2))
                  {
                    m |= 0x8;
                  }
                  else if ("start".equals(localObject2))
                  {
                    m |= 0x800003;
                  }
                  else
                  {
                    if (!"end".equals(localObject2)) {
                      break label1150;
                    }
                    m |= 0x800005;
                  }
                }
                label1150:
                throw new XmlPullParserException("error attribute value: " + paramAttributeSet1);
              }
              paramResources.k = m;
            }
            else if ("tileMode".equals(paramAttributeSet1))
            {
              paramAttributeSet1 = paramAttributeSet2.getAttributeValue(n);
              if ("clamp".equals(paramAttributeSet1))
              {
                paramResources.m = Shader.TileMode.CLAMP;
                paramResources.n = Shader.TileMode.CLAMP;
              }
              else if ("repeat".equals(paramAttributeSet1))
              {
                paramResources.m = Shader.TileMode.REPEAT;
                paramResources.n = Shader.TileMode.REPEAT;
              }
              else if ("mirror".equals(paramAttributeSet1))
              {
                paramResources.m = Shader.TileMode.MIRROR;
                paramResources.n = Shader.TileMode.MIRROR;
              }
              else
              {
                if (!"disabled".equals(paramAttributeSet1)) {
                  break label1310;
                }
                paramResources.m = null;
                paramResources.n = null;
              }
            }
          }
          label1310:
          throw new XmlPullParserException("error attribute value: " + paramAttributeSet1);
        }
      }
    }
    if ((paramResources.i == null) && (paramResources.h == null)) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <bitmap> requires a valid src attribute");
    }
    return paramResources;
  }
  
  private void a()
  {
    b();
    if (this.b.h != null)
    {
      int[] arrayOfInt = this.b.h;
      this.i = b.a(arrayOfInt[0], arrayOfInt[2], this.d);
      this.i = b.a(arrayOfInt[1], arrayOfInt[2], this.d);
      return;
    }
    this.i = this.c.getScaledWidth(this.d);
    this.j = this.c.getScaledHeight(this.d);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.c = paramBitmap;
    if (paramBitmap != null)
    {
      a();
      return;
    }
    this.j = -1;
    this.i = -1;
  }
  
  private void b()
  {
    if (this.c != this.b.i)
    {
      this.c = this.b.i;
      if (this.b.p)
      {
        this.g = true;
        this.f = true;
      }
      if (this.b.h != null)
      {
        int[] arrayOfInt = this.b.h;
        this.i = b.a(arrayOfInt[0], arrayOfInt[2], this.d);
        this.i = b.a(arrayOfInt[1], arrayOfInt[2], this.d);
      }
    }
    else
    {
      return;
    }
    this.i = this.c.getScaledWidth(this.d);
    this.j = this.c.getScaledHeight(this.d);
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    if (this.b.h != null) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = this.c;
    } while (localBitmap == null);
    a locala = this.b;
    Object localObject2;
    Shader.TileMode localTileMode;
    if (this.g)
    {
      localObject2 = locala.m;
      localTileMode = locala.n;
      if ((localObject2 != null) || (localTileMode != null)) {
        break label148;
      }
      locala.l.setShader(null);
    }
    for (;;)
    {
      this.g = false;
      copyBounds(this.e);
      if (locala.l.getShader() != null) {
        break;
      }
      if (this.f)
      {
        Gravity.apply(locala.k, this.i, this.j, getBounds(), this.e);
        this.f = false;
      }
      paramCanvas.drawBitmap(localBitmap, null, this.e, locala.l);
      return;
      label148:
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Shader.TileMode.CLAMP;
      }
      localObject2 = localTileMode;
      if (localTileMode == null) {
        localObject2 = Shader.TileMode.CLAMP;
      }
      localObject1 = new BitmapShader(localBitmap, (Shader.TileMode)localObject1, (Shader.TileMode)localObject2);
      locala.l.setShader((Shader)localObject1);
    }
    if (this.f)
    {
      this.e.set(getBounds());
      this.f = false;
    }
    paramCanvas.drawRect(this.e, locala.l);
  }
  
  public final Bitmap getBitmap()
  {
    b();
    return this.c;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.b.j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.b;
  }
  
  public int getGravity()
  {
    return this.b.k;
  }
  
  public int getIntrinsicHeight()
  {
    b();
    return this.j;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.i;
  }
  
  public int getOpacity()
  {
    if (this.b.k != 119) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      b();
      localBitmap = this.c;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.b.l.getAlpha() < 255));
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.b.l;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.b.m;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.b.n;
  }
  
  public Drawable mutate()
  {
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.f = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.l.setAlpha(paramInt);
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.b.l.setAntiAlias(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.l.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.b.l.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.b.l.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.b.k = paramInt;
    this.f = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 0) {
      m = 160;
    }
    this.d = m;
    b();
    if (this.c != null) {
      a();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    this.d = paramDisplayMetrics.densityDpi;
    b();
    if (this.c != null) {
      a();
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    setTileModeXY(paramTileMode, this.b.n);
  }
  
  public void setTileModeXY(Shader.TileMode paramTileMode1, Shader.TileMode paramTileMode2)
  {
    a locala = this.b;
    if ((locala.l.getShader() == null) || (locala.m != paramTileMode1) || (locala.n != paramTileMode2))
    {
      locala.m = paramTileMode1;
      locala.n = paramTileMode2;
      this.g = true;
    }
  }
  
  public final void setTileModeY(Shader.TileMode paramTileMode)
  {
    setTileModeXY(this.b.m, paramTileMode);
  }
  
  static final class a
    extends b
  {
    Bitmap i;
    int j;
    int k = 119;
    Paint l = new Paint(6);
    Shader.TileMode m;
    Shader.TileMode n;
    int o = 160;
    boolean p = false;
    
    a(Bitmap paramBitmap)
    {
      this.i = paramBitmap;
    }
    
    a(a parama)
    {
      this(parama.i);
      this.j = parama.j;
      this.k = parama.k;
      this.m = parama.m;
      this.n = parama.n;
      this.o = parama.o;
      this.l = new Paint(parama.l);
    }
    
    public int getChangingConfigurations()
    {
      return this.j;
    }
    
    public Drawable newDrawable()
    {
      return new SkinnableBitmapDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new SkinnableBitmapDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */