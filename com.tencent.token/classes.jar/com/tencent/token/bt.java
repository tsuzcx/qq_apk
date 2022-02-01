package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class bt
  extends bs
{
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  f c;
  boolean d = true;
  private PorterDuffColorFilter e;
  private ColorFilter f;
  private boolean g;
  private Drawable.ConstantState h;
  private final float[] i = new float[9];
  private final Matrix j = new Matrix();
  private final Rect k = new Rect();
  
  bt()
  {
    this.c = new f();
  }
  
  bt(f paramf)
  {
    this.c = paramf;
    this.e = a(paramf.c, paramf.d);
  }
  
  static int a(int paramInt, float paramFloat)
  {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  public static bt a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new bt();
      if (Build.VERSION.SDK_INT >= 21) {
        paramResources = paramResources.getDrawable(paramInt, paramTheme);
      } else {
        paramResources = paramResources.getDrawable(paramInt);
      }
      ((bt)localObject).b = paramResources;
      ((bt)localObject).h = new g(((bt)localObject).b.getConstantState());
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return a(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      }
      throw new XmlPullParserException("No start tag found");
    }
    catch (XmlPullParserException|IOException paramResources)
    {
      label118:
      break label118;
    }
    return null;
  }
  
  public static bt a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    bt localbt = new bt();
    localbt.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localbt;
  }
  
  private void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    f localf = this.c;
    e locale = localf.b;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(locale.a);
    int i1 = paramXmlPullParser.getEventType();
    int i2 = paramXmlPullParser.getDepth();
    int n;
    for (int m = 1; (i1 != 1) && ((paramXmlPullParser.getDepth() >= i2 + 1) || (i1 != 3)); m = n)
    {
      if (i1 == 2)
      {
        Object localObject = paramXmlPullParser.getName();
        c localc = (c)localArrayDeque.peek();
        TypedArray localTypedArray;
        if ("path".equals(localObject))
        {
          localObject = new b();
          localTypedArray = cy.a(paramResources, paramTheme, paramAttributeSet, bl.c);
          ((b)localObject).a(localTypedArray, paramXmlPullParser);
          localTypedArray.recycle();
          localc.b.add(localObject);
          if (((b)localObject).getPathName() != null) {
            locale.h.put(((b)localObject).getPathName(), localObject);
          }
          m = localf.a;
          localf.a = (((b)localObject).o | m);
          n = 0;
        }
        else if ("clip-path".equals(localObject))
        {
          localObject = new a();
          if (cy.a(paramXmlPullParser, "pathData"))
          {
            localTypedArray = cy.a(paramResources, paramTheme, paramAttributeSet, bl.d);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.b.add(localObject);
          if (((a)localObject).getPathName() != null) {
            locale.h.put(((a)localObject).getPathName(), localObject);
          }
          n = localf.a;
          localf.a = (((a)localObject).o | n);
          n = m;
        }
        else
        {
          n = m;
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = cy.a(paramResources, paramTheme, paramAttributeSet, bl.b);
            ((c)localObject).l = null;
            ((c)localObject).c = cy.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).c);
            ((c)localObject).d = localTypedArray.getFloat(1, ((c)localObject).d);
            ((c)localObject).e = localTypedArray.getFloat(2, ((c)localObject).e);
            ((c)localObject).f = cy.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).f);
            ((c)localObject).g = cy.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).g);
            ((c)localObject).h = cy.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).h);
            ((c)localObject).i = cy.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).i);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).m = str;
            }
            ((c)localObject).a();
            localTypedArray.recycle();
            localc.b.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              locale.h.put(((c)localObject).getGroupName(), localObject);
            }
            n = localf.a;
            localf.a = (((c)localObject).k | n);
            n = m;
          }
        }
      }
      else
      {
        n = m;
        if (i1 == 3)
        {
          n = m;
          if ("group".equals(paramXmlPullParser.getName()))
          {
            localArrayDeque.pop();
            n = m;
          }
        }
      }
      i1 = paramXmlPullParser.next();
    }
    if (m == 0) {
      return;
    }
    throw new XmlPullParserException("no path defined");
  }
  
  public final boolean canApplyTheme()
  {
    if (this.b != null) {
      dh.c(this.b);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      this.b.draw(paramCanvas);
      return;
    }
    copyBounds(this.k);
    if (this.k.width() > 0)
    {
      if (this.k.height() <= 0) {
        return;
      }
      Object localObject2 = this.f;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.e;
      }
      paramCanvas.getMatrix(this.j);
      this.j.getValues(this.i);
      localObject2 = this.i;
      int n = 0;
      float f1 = Math.abs(localObject2[0]);
      float f2 = Math.abs(this.i[4]);
      float f4 = Math.abs(this.i[1]);
      float f3 = Math.abs(this.i[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      int i1 = (int)(this.k.width() * f1);
      int m = (int)(this.k.height() * f2);
      int i2 = Math.min(2048, i1);
      int i3 = Math.min(2048, m);
      if (i2 > 0)
      {
        if (i3 <= 0) {
          return;
        }
        i1 = paramCanvas.save();
        paramCanvas.translate(this.k.left, this.k.top);
        if (Build.VERSION.SDK_INT >= 17)
        {
          if ((isAutoMirrored()) && (dh.e(this) == 1)) {
            m = 1;
          } else {
            m = 0;
          }
        }
        else {
          m = 0;
        }
        if (m != 0)
        {
          paramCanvas.translate(this.k.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.k.offsetTo(0, 0);
        localObject2 = this.c;
        if (((f)localObject2).f != null)
        {
          if ((i2 == ((f)localObject2).f.getWidth()) && (i3 == ((f)localObject2).f.getHeight())) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0) {}
        }
        else
        {
          ((f)localObject2).f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
          ((f)localObject2).k = true;
        }
        if (!this.d)
        {
          this.c.a(i2, i3);
        }
        else
        {
          localObject2 = this.c;
          if ((!((f)localObject2).k) && (((f)localObject2).g == ((f)localObject2).c) && (((f)localObject2).h == ((f)localObject2).d) && (((f)localObject2).j == ((f)localObject2).e) && (((f)localObject2).i == ((f)localObject2).b.getRootAlpha())) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            this.c.a(i2, i3);
            localObject2 = this.c;
            ((f)localObject2).g = ((f)localObject2).c;
            ((f)localObject2).h = ((f)localObject2).d;
            ((f)localObject2).i = ((f)localObject2).b.getRootAlpha();
            ((f)localObject2).j = ((f)localObject2).e;
            ((f)localObject2).k = false;
          }
        }
        localObject2 = this.c;
        Rect localRect = this.k;
        m = n;
        if (((f)localObject2).b.getRootAlpha() < 255) {
          m = 1;
        }
        if ((m == 0) && (localObject1 == null))
        {
          localObject1 = null;
        }
        else
        {
          if (((f)localObject2).l == null)
          {
            ((f)localObject2).l = new Paint();
            ((f)localObject2).l.setFilterBitmap(true);
          }
          ((f)localObject2).l.setAlpha(((f)localObject2).b.getRootAlpha());
          ((f)localObject2).l.setColorFilter((ColorFilter)localObject1);
          localObject1 = ((f)localObject2).l;
        }
        paramCanvas.drawBitmap(((f)localObject2).f, null, localRect, (Paint)localObject1);
        paramCanvas.restoreToCount(i1);
        return;
      }
      return;
    }
  }
  
  public final int getAlpha()
  {
    if (this.b != null) {
      return dh.b(this.b);
    }
    return this.c.b.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.b != null) {
      return this.b.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.c.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.b != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new g(this.b.getConstantState());
    }
    this.c.a = getChangingConfigurations();
    return this.c;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.b != null) {
      return this.b.getIntrinsicHeight();
    }
    return (int)this.c.b.c;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.b != null) {
      return this.b.getIntrinsicWidth();
    }
    return (int)this.c.b.b;
  }
  
  public final int getOpacity()
  {
    if (this.b != null) {
      return this.b.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.b != null)
    {
      this.b.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.b != null)
    {
      dh.a(this.b, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    f localf1 = this.c;
    localf1.b = new e();
    TypedArray localTypedArray = cy.a(paramResources, paramTheme, paramAttributeSet, bl.a);
    f localf2 = this.c;
    e locale = localf2.b;
    int m = cy.a(localTypedArray, paramXmlPullParser, "tintMode", 6, -1);
    Object localObject = PorterDuff.Mode.SRC_IN;
    if (m != 3)
    {
      if (m != 5)
      {
        if (m != 9) {
          switch (m)
          {
          default: 
            break;
          case 16: 
            localObject = PorterDuff.Mode.ADD;
            break;
          case 15: 
            localObject = PorterDuff.Mode.SCREEN;
            break;
          case 14: 
            localObject = PorterDuff.Mode.MULTIPLY;
            break;
          }
        } else {
          localObject = PorterDuff.Mode.SRC_ATOP;
        }
      }
      else {
        localObject = PorterDuff.Mode.SRC_IN;
      }
    }
    else {
      localObject = PorterDuff.Mode.SRC_OVER;
    }
    localf2.d = ((PorterDuff.Mode)localObject);
    localObject = localTypedArray.getColorStateList(1);
    if (localObject != null) {
      localf2.c = ((ColorStateList)localObject);
    }
    boolean bool = localf2.e;
    if (cy.a(paramXmlPullParser, "autoMirrored")) {
      bool = localTypedArray.getBoolean(5, bool);
    }
    localf2.e = bool;
    locale.d = cy.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, locale.d);
    locale.e = cy.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, locale.e);
    if (locale.d > 0.0F)
    {
      if (locale.e > 0.0F)
      {
        locale.b = localTypedArray.getDimension(3, locale.b);
        locale.c = localTypedArray.getDimension(2, locale.c);
        if (locale.b > 0.0F)
        {
          if (locale.c > 0.0F)
          {
            locale.setAlpha(cy.a(localTypedArray, paramXmlPullParser, "alpha", 4, locale.getAlpha()));
            localObject = localTypedArray.getString(0);
            if (localObject != null)
            {
              locale.g = ((String)localObject);
              locale.h.put(localObject, locale);
            }
            localTypedArray.recycle();
            localf1.a = getChangingConfigurations();
            localf1.k = true;
            b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            this.e = a(localf1.c, localf1.d);
            return;
          }
          paramResources = new StringBuilder();
          paramResources.append(localTypedArray.getPositionDescription());
          paramResources.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(paramResources.toString());
        }
        paramResources = new StringBuilder();
        paramResources.append(localTypedArray.getPositionDescription());
        paramResources.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(paramResources.toString());
      }
      paramResources = new StringBuilder();
      paramResources.append(localTypedArray.getPositionDescription());
      paramResources.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(paramResources.toString());
    }
    paramResources = new StringBuilder();
    paramResources.append(localTypedArray.getPositionDescription());
    paramResources.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(paramResources.toString());
  }
  
  public final void invalidateSelf()
  {
    if (this.b != null)
    {
      this.b.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.b != null) {
      return dh.a(this.b);
    }
    return this.c.e;
  }
  
  public final boolean isStateful()
  {
    if (this.b != null) {
      return this.b.isStateful();
    }
    if (!super.isStateful())
    {
      f localf = this.c;
      if ((localf == null) || (localf.c == null) || (!this.c.c.isStateful())) {
        return false;
      }
    }
    return true;
  }
  
  public final Drawable mutate()
  {
    if (this.b != null)
    {
      this.b.mutate();
      return this;
    }
    if ((!this.g) && (super.mutate() == this))
    {
      this.c = new f(this.c);
      this.g = true;
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.b != null) {
      this.b.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.b != null) {
      return this.b.setState(paramArrayOfInt);
    }
    paramArrayOfInt = this.c;
    if ((paramArrayOfInt.c != null) && (paramArrayOfInt.d != null))
    {
      this.e = a(paramArrayOfInt.c, paramArrayOfInt.d);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.b != null)
    {
      this.b.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.b != null)
    {
      this.b.setAlpha(paramInt);
      return;
    }
    if (this.c.b.getRootAlpha() != paramInt)
    {
      this.c.b.setRootAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.b != null)
    {
      dh.a(this.b, paramBoolean);
      return;
    }
    this.c.e = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.b != null)
    {
      this.b.setColorFilter(paramColorFilter);
      return;
    }
    this.f = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.b != null)
    {
      dh.a(this.b, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.b != null)
    {
      dh.a(this.b, paramColorStateList);
      return;
    }
    f localf = this.c;
    if (localf.c != paramColorStateList)
    {
      localf.c = paramColorStateList;
      this.e = a(paramColorStateList, localf.d);
      invalidateSelf();
    }
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.b != null)
    {
      dh.a(this.b, paramMode);
      return;
    }
    f localf = this.c;
    if (localf.d != paramMode)
    {
      localf.d = paramMode;
      this.e = a(localf.c, paramMode);
      invalidateSelf();
    }
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b != null) {
      return this.b.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.b != null)
    {
      this.b.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  static final class a
    extends bt.d
  {
    public a() {}
    
    public a(a parama)
    {
      super();
    }
    
    final void a(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.n = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.m = da.b(paramTypedArray);
      }
    }
    
    public final boolean a()
    {
      return true;
    }
  }
  
  static final class b
    extends bt.d
  {
    int a = 0;
    float b = 0.0F;
    int c = 0;
    float d = 1.0F;
    int e = 0;
    float f = 1.0F;
    float g = 0.0F;
    float h = 1.0F;
    float i = 0.0F;
    Paint.Cap j = Paint.Cap.BUTT;
    Paint.Join k = Paint.Join.MITER;
    float l = 4.0F;
    private int[] p;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.p = paramb.p;
      this.a = paramb.a;
      this.b = paramb.b;
      this.d = paramb.d;
      this.c = paramb.c;
      this.e = paramb.e;
      this.f = paramb.f;
      this.g = paramb.g;
      this.h = paramb.h;
      this.i = paramb.i;
      this.j = paramb.j;
      this.k = paramb.k;
      this.l = paramb.l;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.p = null;
      if (!cy.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.n = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.m = da.b((String)localObject);
      }
      this.c = cy.b(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.c);
      this.f = cy.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.f);
      int m = cy.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.j;
      switch (m)
      {
      default: 
        break;
      case 2: 
        localObject = Paint.Cap.SQUARE;
        break;
      case 1: 
        localObject = Paint.Cap.ROUND;
        break;
      case 0: 
        localObject = Paint.Cap.BUTT;
      }
      this.j = ((Paint.Cap)localObject);
      m = cy.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
      localObject = this.k;
      switch (m)
      {
      default: 
        break;
      case 2: 
        localObject = Paint.Join.BEVEL;
        break;
      case 1: 
        localObject = Paint.Join.ROUND;
        break;
      case 0: 
        localObject = Paint.Join.MITER;
      }
      this.k = ((Paint.Join)localObject);
      this.l = cy.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.l);
      this.a = cy.b(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.a);
      this.d = cy.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.d);
      this.b = cy.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.b);
      this.h = cy.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.h);
      this.i = cy.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.i);
      this.g = cy.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.g);
      this.e = cy.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.e);
    }
    
    final float getFillAlpha()
    {
      return this.f;
    }
    
    final int getFillColor()
    {
      return this.c;
    }
    
    final float getStrokeAlpha()
    {
      return this.d;
    }
    
    final int getStrokeColor()
    {
      return this.a;
    }
    
    final float getStrokeWidth()
    {
      return this.b;
    }
    
    final float getTrimPathEnd()
    {
      return this.h;
    }
    
    final float getTrimPathOffset()
    {
      return this.i;
    }
    
    final float getTrimPathStart()
    {
      return this.g;
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.f = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.c = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.d = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.a = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.b = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.h = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.i = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.g = paramFloat;
    }
  }
  
  static final class c
  {
    final Matrix a = new Matrix();
    final ArrayList<Object> b = new ArrayList();
    float c = 0.0F;
    float d = 0.0F;
    float e = 0.0F;
    float f = 1.0F;
    float g = 1.0F;
    float h = 0.0F;
    float i = 0.0F;
    final Matrix j = new Matrix();
    int k;
    int[] l;
    String m = null;
    
    public c() {}
    
    public c(c paramc, dv<String, Object> paramdv)
    {
      this.c = paramc.c;
      this.d = paramc.d;
      this.e = paramc.e;
      this.f = paramc.f;
      this.g = paramc.g;
      this.h = paramc.h;
      this.i = paramc.i;
      this.l = paramc.l;
      this.m = paramc.m;
      this.k = paramc.k;
      Object localObject = this.m;
      if (localObject != null) {
        paramdv.put(localObject, this);
      }
      this.j.set(paramc.j);
      localObject = paramc.b;
      int n = 0;
      while (n < ((ArrayList)localObject).size())
      {
        paramc = ((ArrayList)localObject).get(n);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.b.add(new c(paramc, paramdv));
        }
        else
        {
          if ((paramc instanceof bt.b))
          {
            paramc = new bt.b((bt.b)paramc);
          }
          else
          {
            if (!(paramc instanceof bt.a)) {
              break label317;
            }
            paramc = new bt.a((bt.a)paramc);
          }
          this.b.add(paramc);
          if (paramc.n != null) {
            paramdv.put(paramc.n, paramc);
          }
        }
        n += 1;
        continue;
        label317:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
    
    final void a()
    {
      this.j.reset();
      this.j.postTranslate(-this.d, -this.e);
      this.j.postScale(this.f, this.g);
      this.j.postRotate(this.c, 0.0F, 0.0F);
      this.j.postTranslate(this.h + this.d, this.i + this.e);
    }
    
    public final String getGroupName()
    {
      return this.m;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.j;
    }
    
    public final float getPivotX()
    {
      return this.d;
    }
    
    public final float getPivotY()
    {
      return this.e;
    }
    
    public final float getRotation()
    {
      return this.c;
    }
    
    public final float getScaleX()
    {
      return this.f;
    }
    
    public final float getScaleY()
    {
      return this.g;
    }
    
    public final float getTranslateX()
    {
      return this.h;
    }
    
    public final float getTranslateY()
    {
      return this.i;
    }
    
    public final void setPivotX(float paramFloat)
    {
      if (paramFloat != this.d)
      {
        this.d = paramFloat;
        a();
      }
    }
    
    public final void setPivotY(float paramFloat)
    {
      if (paramFloat != this.e)
      {
        this.e = paramFloat;
        a();
      }
    }
    
    public final void setRotation(float paramFloat)
    {
      if (paramFloat != this.c)
      {
        this.c = paramFloat;
        a();
      }
    }
    
    public final void setScaleX(float paramFloat)
    {
      if (paramFloat != this.f)
      {
        this.f = paramFloat;
        a();
      }
    }
    
    public final void setScaleY(float paramFloat)
    {
      if (paramFloat != this.g)
      {
        this.g = paramFloat;
        a();
      }
    }
    
    public final void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.h)
      {
        this.h = paramFloat;
        a();
      }
    }
    
    public final void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.i)
      {
        this.i = paramFloat;
        a();
      }
    }
  }
  
  static class d
  {
    protected da.b[] m = null;
    String n;
    int o;
    
    public d() {}
    
    public d(d paramd)
    {
      this.n = paramd.n;
      this.o = paramd.o;
      this.m = da.a(paramd.m);
    }
    
    public final void a(Path paramPath)
    {
      paramPath.reset();
      da.b[] arrayOfb = this.m;
      if (arrayOfb != null) {
        da.b.a(arrayOfb, paramPath);
      }
    }
    
    public boolean a()
    {
      return false;
    }
    
    public da.b[] getPathData()
    {
      return this.m;
    }
    
    public String getPathName()
    {
      return this.n;
    }
    
    public void setPathData(da.b[] paramArrayOfb)
    {
      if (!da.a(this.m, paramArrayOfb))
      {
        this.m = da.a(paramArrayOfb);
        return;
      }
      da.b[] arrayOfb = this.m;
      int i = 0;
      while (i < paramArrayOfb.length)
      {
        arrayOfb[i].a = paramArrayOfb[i].a;
        int j = 0;
        while (j < paramArrayOfb[i].b.length)
        {
          arrayOfb[i].b[j] = paramArrayOfb[i].b[j];
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  static final class e
  {
    private static final Matrix k = new Matrix();
    final bt.c a;
    float b = 0.0F;
    float c = 0.0F;
    float d = 0.0F;
    float e = 0.0F;
    int f = 255;
    String g = null;
    final dv<String, Object> h = new dv();
    private final Path i;
    private final Path j;
    private final Matrix l = new Matrix();
    private Paint m;
    private Paint n;
    private PathMeasure o;
    private int p;
    
    public e()
    {
      this.a = new bt.c();
      this.i = new Path();
      this.j = new Path();
    }
    
    public e(e parame)
    {
      this.a = new bt.c(parame.a, this.h);
      this.i = new Path(parame.i);
      this.j = new Path(parame.j);
      this.b = parame.b;
      this.c = parame.c;
      this.d = parame.d;
      this.e = parame.e;
      this.p = parame.p;
      this.f = parame.f;
      this.g = parame.g;
      parame = parame.g;
      if (parame != null) {
        this.h.put(parame, this);
      }
    }
    
    private void a(bt.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      Object localObject1 = this;
      paramc.a.set(paramMatrix);
      paramc.a.preConcat(paramc.j);
      paramCanvas.save();
      int i1 = 0;
      paramMatrix = (Matrix)localObject1;
      while (i1 < paramc.b.size())
      {
        localObject1 = paramc.b.get(i1);
        if ((localObject1 instanceof bt.c))
        {
          a((bt.c)localObject1, paramc.a, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        else if ((localObject1 instanceof bt.d))
        {
          Object localObject2 = (bt.d)localObject1;
          float f1 = paramInt1 / paramMatrix.d;
          float f3 = paramInt2 / paramMatrix.e;
          float f2 = Math.min(f1, f3);
          localObject1 = paramc.a;
          paramMatrix.l.set((Matrix)localObject1);
          paramMatrix.l.postScale(f1, f3);
          paramMatrix = new float[4];
          Matrix tmp164_163 = paramMatrix;
          tmp164_163[0] = 0.0F;
          Matrix tmp168_164 = tmp164_163;
          tmp168_164[1] = 1.0F;
          Matrix tmp172_168 = tmp168_164;
          tmp172_168[2] = 1.0F;
          Matrix tmp176_172 = tmp172_168;
          tmp176_172[3] = 0.0F;
          tmp176_172;
          ((Matrix)localObject1).mapVectors(paramMatrix);
          float f6 = (float)Math.hypot(paramMatrix[0], paramMatrix[1]);
          float f7 = (float)Math.hypot(paramMatrix[2], paramMatrix[3]);
          f1 = paramMatrix[0];
          f3 = paramMatrix[1];
          float f4 = paramMatrix[2];
          float f5 = paramMatrix[3];
          f6 = Math.max(f6, f7);
          if (f6 > 0.0F) {
            f1 = Math.abs(f1 * f5 - f3 * f4) / f6;
          } else {
            f1 = 0.0F;
          }
          if (f1 != 0.0F)
          {
            localObject1 = this;
            ((bt.d)localObject2).a(((e)localObject1).i);
            paramMatrix = ((e)localObject1).i;
            ((e)localObject1).j.reset();
            if (((bt.d)localObject2).a())
            {
              ((e)localObject1).j.addPath(paramMatrix, ((e)localObject1).l);
              paramCanvas.clipPath(((e)localObject1).j);
              paramMatrix = (Matrix)localObject1;
            }
            else
            {
              localObject2 = (bt.b)localObject2;
              if ((((bt.b)localObject2).g != 0.0F) || (((bt.b)localObject2).h != 1.0F))
              {
                f6 = ((bt.b)localObject2).g;
                f7 = ((bt.b)localObject2).i;
                f4 = ((bt.b)localObject2).h;
                f5 = ((bt.b)localObject2).i;
                if (((e)localObject1).o == null) {
                  ((e)localObject1).o = new PathMeasure();
                }
                ((e)localObject1).o.setPath(((e)localObject1).i, false);
                f3 = ((e)localObject1).o.getLength();
                f6 = (f6 + f7) % 1.0F * f3;
                f4 = (f4 + f5) % 1.0F * f3;
                paramMatrix.reset();
                if (f6 > f4)
                {
                  ((e)localObject1).o.getSegment(f6, f3, paramMatrix, true);
                  ((e)localObject1).o.getSegment(0.0F, f4, paramMatrix, true);
                }
                else
                {
                  ((e)localObject1).o.getSegment(f6, f4, paramMatrix, true);
                }
                paramMatrix.rLineTo(0.0F, 0.0F);
              }
              ((e)localObject1).j.addPath(paramMatrix, ((e)localObject1).l);
              if (((bt.b)localObject2).c != 0)
              {
                if (((e)localObject1).n == null)
                {
                  ((e)localObject1).n = new Paint();
                  ((e)localObject1).n.setStyle(Paint.Style.FILL);
                  ((e)localObject1).n.setAntiAlias(true);
                }
                Paint localPaint = ((e)localObject1).n;
                localPaint.setColor(bt.a(((bt.b)localObject2).c, ((bt.b)localObject2).f));
                localPaint.setColorFilter(paramColorFilter);
                Path localPath = ((e)localObject1).j;
                if (((bt.b)localObject2).e == 0) {
                  paramMatrix = Path.FillType.WINDING;
                } else {
                  paramMatrix = Path.FillType.EVEN_ODD;
                }
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(((e)localObject1).j, localPaint);
              }
              paramMatrix = (Matrix)localObject1;
              if (((bt.b)localObject2).a != 0)
              {
                if (((e)localObject1).m == null)
                {
                  ((e)localObject1).m = new Paint();
                  ((e)localObject1).m.setStyle(Paint.Style.STROKE);
                  ((e)localObject1).m.setAntiAlias(true);
                }
                paramMatrix = ((e)localObject1).m;
                if (((bt.b)localObject2).k != null) {
                  paramMatrix.setStrokeJoin(((bt.b)localObject2).k);
                }
                if (((bt.b)localObject2).j != null) {
                  paramMatrix.setStrokeCap(((bt.b)localObject2).j);
                }
                paramMatrix.setStrokeMiter(((bt.b)localObject2).l);
                paramMatrix.setColor(bt.a(((bt.b)localObject2).a, ((bt.b)localObject2).d));
                paramMatrix.setColorFilter(paramColorFilter);
                paramMatrix.setStrokeWidth(((bt.b)localObject2).b * (f1 * f2));
                paramCanvas.drawPath(((e)localObject1).j, paramMatrix);
                paramMatrix = (Matrix)localObject1;
              }
            }
          }
          else
          {
            paramMatrix = this;
          }
        }
        i1 += 1;
      }
      paramCanvas.restore();
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.a, k, paramCanvas, paramInt1, paramInt2, null);
    }
    
    public final float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public final int getRootAlpha()
    {
      return this.f;
    }
    
    public final void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(paramFloat * 255.0F));
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.f = paramInt;
    }
  }
  
  static final class f
    extends Drawable.ConstantState
  {
    int a;
    bt.e b;
    ColorStateList c = null;
    PorterDuff.Mode d = bt.a;
    boolean e;
    Bitmap f;
    ColorStateList g;
    PorterDuff.Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;
    
    public f()
    {
      this.b = new bt.e();
    }
    
    public f(f paramf)
    {
      if (paramf != null)
      {
        this.a = paramf.a;
        this.b = new bt.e(paramf.b);
        if (bt.e.a(paramf.b) != null) {
          bt.e.a(this.b, new Paint(bt.e.a(paramf.b)));
        }
        if (bt.e.b(paramf.b) != null) {
          bt.e.b(this.b, new Paint(bt.e.b(paramf.b)));
        }
        this.c = paramf.c;
        this.d = paramf.d;
        this.e = paramf.e;
      }
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      this.f.eraseColor(0);
      Canvas localCanvas = new Canvas(this.f);
      this.b.a(localCanvas, paramInt1, paramInt2);
    }
    
    public final int getChangingConfigurations()
    {
      return this.a;
    }
    
    public final Drawable newDrawable()
    {
      return new bt(this);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new bt(this);
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public g(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      bt localbt = new bt();
      localbt.b = ((VectorDrawable)this.a.newDrawable());
      return localbt;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      bt localbt = new bt();
      localbt.b = ((VectorDrawable)this.a.newDrawable(paramResources));
      return localbt;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      bt localbt = new bt();
      localbt.b = ((VectorDrawable)this.a.newDrawable(paramResources, paramTheme));
      return localbt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bt
 * JD-Core Version:    0.7.0.1
 */