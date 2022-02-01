package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.core.functions.animation.GlAlphaAnimation;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlAnimation.SetAnimatePropertyListener;
import com.tencent.map.core.functions.animation.GlEmergeAnimation;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.ColorType;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.map.lib.basemap.data.GeoPoint;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

public class mw
  extends mu
{
  private static final int[] I = { 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 3500, 2000, 1500, 1000, 720, 500, 320, 160, 80 };
  private BitmapDescriptor A = null;
  private int B = 12;
  private GlAnimation C;
  private float D;
  private a E = null;
  private float F = 1.0F;
  private int G = 0;
  private boolean H = true;
  private float J = 0.0F;
  private boolean K = false;
  private String O;
  private int P = -1;
  private List<Integer> Q;
  private int R = 0;
  private final String S = this.L + "_arrow_texture_";
  private final float T;
  private GlAnimation.SetAnimatePropertyListener U = new mw.1(this);
  public ip h = null;
  public Polyline i = null;
  protected byte[] j = new byte[0];
  public pn k = null;
  public boolean l = false;
  public int[] m = null;
  public int[] n = null;
  public PolylineOptions.Text o;
  public boolean p = false;
  public boolean q = false;
  public int r = -1;
  public GeoPoint s = null;
  private iq t = null;
  private ArrayList<a> u = null;
  private ArrayList<GeoPoint> v = null;
  private float w;
  private int[] x = null;
  private int y = -7829368;
  private PolylineOptions.ColorType z;
  
  public mw(pn parampn)
  {
    this.k = parampn;
    this.u = new ArrayList();
    this.T = this.k.ay.getResources().getDisplayMetrics().density;
  }
  
  private static float a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    float f = 0.0F;
    if (paramGeoPoint2 != null)
    {
      int i1 = paramGeoPoint1.getLatitudeE6();
      int i2 = paramGeoPoint2.getLatitudeE6();
      int i3 = paramGeoPoint1.getLongitudeE6();
      int i4 = paramGeoPoint2.getLongitudeE6();
      f = (float)(Math.hypot(i1 - i2, i3 - i4) + 0.0D);
    }
    return f;
  }
  
  private static float a(a parama1, a parama2, GeoPoint paramGeoPoint, a parama3)
  {
    int i1 = parama1.getLongitudeE6();
    int i2 = parama1.getLatitudeE6();
    int i3 = parama2.getLongitudeE6();
    int i4 = parama2.getLatitudeE6();
    int i5 = paramGeoPoint.getLongitudeE6();
    int i6 = paramGeoPoint.getLatitudeE6();
    float f1 = (i3 - i1) * (i5 - i1) + (i4 - i2) * (i6 - i2);
    if (f1 <= 0.0F)
    {
      parama3.setLatitudeE6(parama1.getLatitudeE6());
      parama3.setLongitudeE6(parama1.getLongitudeE6());
      parama3.a = parama1.a;
      return (float)Math.hypot(i5 - i1, i6 - i2);
    }
    double d = (i3 - i1) * (i3 - i1) + (i4 - i2) * (i4 - i2);
    if (f1 >= d)
    {
      parama3.setLatitudeE6(parama2.getLatitudeE6());
      parama3.setLongitudeE6(parama2.getLongitudeE6());
      parama3.a = parama2.a;
      return (float)Math.hypot(i5 - i3, i6 - i4);
    }
    f1 = (float)(f1 / d);
    float f2 = i1;
    f2 = (i3 - i1) * f1 + f2;
    float f3 = i2;
    f3 = (i4 - i2) * f1 + f3;
    parama3.setLongitudeE6(Math.round(f2));
    parama3.setLatitudeE6(Math.round(f3));
    parama1.a += (parama2.a - parama1.a) * f1;
    return (float)Math.hypot(i5 - f2, i6 - f3);
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= this.B) {
      paramInt = this.B - 1;
    }
    for (;;)
    {
      int i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
      return i1;
    }
  }
  
  private static int a(Context paramContext, BitmapDescriptor paramBitmapDescriptor)
  {
    if ((paramContext == null) || (paramBitmapDescriptor == null)) {}
    int i1;
    do
    {
      do
      {
        return 0;
        paramBitmapDescriptor = paramBitmapDescriptor.getBitmap(paramContext);
      } while (paramBitmapDescriptor == null);
      i1 = paramBitmapDescriptor.getHeight();
    } while (i1 <= 0);
    float f = pz.a(paramContext);
    return (int)(Math.pow(2.0D, 25.0D) / Math.pow(i1, 2.0D) / f);
  }
  
  private a a(GeoPoint paramGeoPoint)
  {
    float f1 = 3.4028235E+38F;
    Object localObject3 = null;
    Object localObject2 = new a();
    Object localObject1 = localObject3;
    int i1;
    Object localObject4;
    if (this.u != null)
    {
      localObject1 = localObject3;
      if (this.u.size() >= 2)
      {
        localObject1 = localObject3;
        if (paramGeoPoint != null)
        {
          localObject3 = (a)this.u.get(0);
          i1 = 1;
          localObject1 = null;
          if (i1 < this.u.size())
          {
            localObject4 = (a)this.u.get(i1);
            float f2 = a((a)localObject3, (a)localObject4, paramGeoPoint, (a)localObject2);
            if (f2 >= f1) {
              break label150;
            }
            localObject1 = new a();
            f1 = f2;
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      localObject3 = localObject4;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
      return localObject1;
      label150:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private static a a(a parama1, a parama2, float paramFloat)
  {
    a locala = new a();
    int i1 = parama2.getLongitudeE6();
    int i2 = parama1.getLongitudeE6();
    int i3 = parama2.getLatitudeE6();
    int i4 = parama1.getLatitudeE6();
    int i5 = parama1.getLatitudeE6();
    locala.setLatitudeE6(Math.round((i3 - i4) * paramFloat) + i5);
    i3 = parama1.getLongitudeE6();
    locala.setLongitudeE6(Math.round((i1 - i2) * paramFloat) + i3);
    parama1.a += (parama2.a - parama1.a) * paramFloat;
    return locala;
  }
  
  private PolylineOptions.ColorType a(PolylineOptions.ColorType paramColorType)
  {
    if (paramColorType != PolylineOptions.ColorType.LINE_COLOR_NONE) {
      return paramColorType;
    }
    if ((this.m != null) && (this.m.length > 0))
    {
      int i1 = 0;
      int i2 = this.m.length;
      while (i1 < i2)
      {
        if ((this.m[i1] < 0) || (this.m[i1] >= this.B)) {
          return PolylineOptions.ColorType.LINE_COLOR_ARGB;
        }
        i1 += 1;
      }
      return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }
    if ((this.c < 0) || (this.c >= this.B)) {
      return PolylineOptions.ColorType.LINE_COLOR_ARGB;
    }
    return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
  }
  
  private void a(GlAlphaAnimation paramGlAlphaAnimation)
  {
    this.C = paramGlAlphaAnimation;
    this.C.setAnimationProperty(this.U);
    this.C.startAnimation(null, null);
    if ((this.k != null) && (this.k.az != null)) {
      this.k.az.b.k();
    }
  }
  
  private void a(GlEmergeAnimation paramGlEmergeAnimation)
  {
    if ((this.k == null) || (this.k.az == null)) {
      return;
    }
    this.C = paramGlEmergeAnimation;
    this.E = a(fz.a(paramGlEmergeAnimation.getStartPoint()));
    if (this.E == null) {
      throw new RuntimeException("Error, start point not found.");
    }
    paramGlEmergeAnimation.setAnimationProperty(this.U);
    paramGlEmergeAnimation.startAnimation(null, null);
    this.k.az.b.k();
  }
  
  private int[][] b(List<GeoPoint> paramList)
  {
    int i1;
    if ((this.m == null) || (this.n == null) || (paramList == null) || (this.m.length == 0) || (this.n.length == 0) || (paramList.isEmpty()))
    {
      i1 = this.c;
      if (this.z != PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
        break label544;
      }
      i1 = a(i1);
    }
    label544:
    for (;;)
    {
      paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 1 });
      paramList[0][0] = i1;
      paramList[1][0] = 0;
      return paramList;
      if ((this.m != null) && (this.n != null)) {}
      for (i1 = Math.min(this.m.length, this.n.length);; i1 = 0)
      {
        int[] arrayOfInt = new int[i1];
        int i2 = 0;
        while (i2 < i1)
        {
          arrayOfInt[i2] = this.m[i2];
          if (this.z == PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
            arrayOfInt[i2] = a(arrayOfInt[i2]);
          }
          i2 += 1;
        }
        TreeMap localTreeMap = new TreeMap();
        Object localObject1 = (a)paramList.get(0);
        i2 = 1;
        if (i2 < i1) {
          if (((a)localObject1).b <= this.n[i2]) {
            localTreeMap.put(Integer.valueOf(0), Integer.valueOf(arrayOfInt[(i2 - 1)]));
          }
        }
        for (int i4 = i2;; i4 = 0)
        {
          int i3 = i4;
          if (i2 == i1)
          {
            i3 = i4;
            if (localTreeMap.size() == 0)
            {
              localTreeMap.put(Integer.valueOf(0), Integer.valueOf(arrayOfInt[(i1 - 1)]));
              i3 = i1;
            }
          }
          i4 = 1;
          i2 = i3;
          i3 = i4;
          for (;;)
          {
            if (i3 >= paramList.size()) {
              break label420;
            }
            localObject2 = (a)paramList.get(i3);
            i4 = i2;
            for (;;)
            {
              if ((i4 < i1) && (((a)localObject2).b > this.n[i4]) && (((a)localObject1).b <= this.n[i4]))
              {
                localTreeMap.put(Integer.valueOf(i3 - 1), Integer.valueOf(arrayOfInt[i4]));
                i4 += 1;
                i2 += 1;
                continue;
                i2 += 1;
                break;
              }
            }
            i3 += 1;
            localObject1 = localObject2;
          }
          label420:
          i1 = localTreeMap.size();
          localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i1 });
          Object localObject2 = localTreeMap.entrySet().iterator();
          i1 = 0;
          for (;;)
          {
            paramList = (List<GeoPoint>)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (Map.Entry)((Iterator)localObject2).next();
            localObject1[0][i1] = ((Integer)paramList.getValue()).intValue();
            localObject1[1][i1] = ((Integer)paramList.getKey()).intValue();
            i1 += 1;
          }
        }
      }
    }
  }
  
  private void f()
  {
    pf localpf;
    if ((this.k != null) && (this.k.aA != null))
    {
      localpf = this.k.aA.a;
      if (localpf != null) {
        break label33;
      }
    }
    label33:
    do
    {
      do
      {
        return;
        if ((this.o == null) && (this.t != null))
        {
          this.t.a();
          this.t = null;
          return;
        }
      } while (this.o == null);
      if (this.t != null) {
        break;
      }
    } while ((this.v == null) || (this.v.size() < 2));
    this.t = new iq(localpf, (GeoPoint[])this.v.toArray(new GeoPoint[this.v.size()]), this.o);
    return;
    this.t.a(this.o);
  }
  
  private hi g()
  {
    if ((this.k == null) || (this.k.az == null)) {
      return null;
    }
    hi localhi = new hi();
    if ((this.A != null) && (this.A.getFormater() != null)) {
      localhi.k = this.A.getFormater().g;
    }
    int[][] arrayOfInt = b(this.v);
    localhi.i = this.l;
    localhi.u = this.P;
    localhi.a(this.v);
    localhi.z = this.y;
    int i1;
    float f;
    label153:
    int[] arrayOfInt1;
    if (this.G == 0)
    {
      i1 = a(this.k.ay, this.A);
      if (i1 > 0) {
        if (this.a > i1)
        {
          f = i1;
          localhi.j = f;
          if (this.z == PolylineOptions.ColorType.LINE_COLOR_ARGB)
          {
            localhi.h = true;
            if (this.w * 2.0F > this.a) {
              this.w = (this.a / 3.0F);
            }
            localhi.g = this.w;
          }
          arrayOfInt1 = this.x;
          if (!this.H) {
            break label399;
          }
          localhi.a(arrayOfInt[1]);
          if ((this.w <= 0.0F) || (arrayOfInt1 == null) || (arrayOfInt1.length <= 0)) {
            break label386;
          }
          localhi.a(arrayOfInt[0], arrayOfInt1);
        }
      }
    }
    for (;;)
    {
      localhi.m = this.D;
      localhi.o = this.G;
      localhi.s = ((int)this.d);
      localhi.p = this.p;
      localhi.q = this.q;
      localhi.l = this.K;
      localhi.n = this.H;
      localhi.t = this.O;
      localhi.b(this.Q);
      localhi.y = this.g;
      return localhi;
      f = this.a;
      break;
      localhi.j = this.a;
      break label153;
      localhi.j = this.a;
      break label153;
      label386:
      localhi.b(arrayOfInt[0]);
      continue;
      label399:
      localhi.a(new int[] { 0 });
      if ((this.w > 0.0F) && (arrayOfInt1 != null) && (arrayOfInt1.length > 0))
      {
        i1 = this.c;
        int i2 = arrayOfInt1[0];
        localhi.a(new int[] { i1 }, new int[] { i2 });
      }
      else
      {
        localhi.b(new int[] { this.c });
      }
    }
  }
  
  public final void a(GlAnimation paramGlAnimation)
  {
    if (this.C != null)
    {
      this.C.stopAnimation();
      this.C.setAnimationProperty(null);
    }
    if ((paramGlAnimation instanceof GlEmergeAnimation))
    {
      a((GlEmergeAnimation)paramGlAnimation);
      return;
    }
    if ((paramGlAnimation instanceof GlAlphaAnimation))
    {
      a((GlAlphaAnimation)paramGlAnimation);
      return;
    }
    this.C = null;
  }
  
  public final void a(BitmapDescriptor paramBitmapDescriptor)
  {
    if ((this.k == null) || (this.k.az == null) || (paramBitmapDescriptor == null) || (paramBitmapDescriptor.getFormater() == null)) {
      return;
    }
    this.A = paramBitmapDescriptor;
    paramBitmapDescriptor = this.A.getBitmap(this.k.ay);
    oi.a(this.A.getFormater().g, paramBitmapDescriptor);
    this.z = PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
  }
  
  public final void a(PolylineOptions paramPolylineOptions)
  {
    if ((this.k == null) || (this.k.az == null) || (paramPolylineOptions == null)) {
      return;
    }
    if (paramPolylineOptions.getWidth() == -1.0F) {
      a(this.T * 9.0F);
    }
    for (;;)
    {
      super.b(paramPolylineOptions.getColor());
      b(paramPolylineOptions.getZIndex());
      c(paramPolylineOptions.isVisible());
      this.D = paramPolylineOptions.getAlpha();
      this.l = paramPolylineOptions.isArrow();
      a(paramPolylineOptions.getColorTexture());
      this.K = paramPolylineOptions.getLineCap();
      this.Q = paramPolylineOptions.getPattern();
      this.w = paramPolylineOptions.getBorderWidth();
      this.x = paramPolylineOptions.getBorderColors();
      this.N = paramPolylineOptions.getIndoorInfo();
      this.G = paramPolylineOptions.getLineType();
      this.g = paramPolylineOptions.getLevel();
      this.y = paramPolylineOptions.getEraseColor();
      if ((paramPolylineOptions.isAbovePillar()) && (this.g == OverlayLevel.OverlayLevelAboveRoads)) {
        this.g = OverlayLevel.OverlayLevelAboveLabels;
      }
      a(paramPolylineOptions.getPoints());
      if (paramPolylineOptions.getArrowTexture() != null)
      {
        localObject1 = paramPolylineOptions.getArrowTexture().getBitmap(this.k.ay);
        oi.b(this.S + this.R);
        localObject2 = new StringBuilder().append(this.S);
        int i1 = this.R + 1;
        this.R = i1;
        localObject2 = i1;
        oi.a((String)localObject2, (Bitmap)localObject1);
        this.O = ((String)localObject2);
      }
      this.P = paramPolylineOptions.getArrowSpacing();
      this.H = paramPolylineOptions.isRoad();
      Object localObject1 = paramPolylineOptions.getAnimation();
      if (localObject1 != null) {
        a(((Animation)localObject1).glAnimation);
      }
      Object localObject2 = paramPolylineOptions.getColors();
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        if ((localObject1 != null) && (localObject2 != null) && (localObject1.length == localObject2.length)) {
          a((int[])localObject1, (int[])localObject2);
        }
      }
      this.z = a(paramPolylineOptions.getColorType());
      this.o = paramPolylineOptions.getText();
      e();
      return;
      a(paramPolylineOptions.getWidth());
    }
  }
  
  public final void a(List<LatLng> paramList)
  {
    this.J = 0.0F;
    this.u.clear();
    if (paramList == null) {}
    int i2;
    do
    {
      return;
      i2 = paramList.size();
    } while (i2 <= 0);
    Object localObject1 = null;
    this.v = new ArrayList();
    int i1 = 0;
    label44:
    if (i1 < i2)
    {
      Object localObject2 = (LatLng)paramList.get(i1);
      if (localObject2 == null) {
        break label162;
      }
      localObject2 = fz.a((LatLng)localObject2);
      if (localObject2 == null) {
        break label162;
      }
      localObject2 = new a((GeoPoint)localObject2);
      this.v.add(localObject2);
      if (localObject1 != null)
      {
        this.J += a((GeoPoint)localObject2, (GeoPoint)localObject1);
        ((a)localObject2).a = this.J;
        ((a)localObject1).b += 1;
      }
      this.u.add(localObject2);
      localObject1 = localObject2;
    }
    label162:
    for (;;)
    {
      i1 += 1;
      break label44;
      break;
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (!a()) {
      break label7;
    }
    label7:
    while ((this.k == null) || (this.k.az == null) || (this.C == null) || (!this.C.isStarted())) {
      return;
    }
    this.C.drawAnimation();
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((this.C instanceof GlEmergeAnimation))
    {
      localArrayList2 = this.u;
      localArrayList1 = new ArrayList();
      if ((localArrayList2 == null) || (localArrayList2.size() < 2))
      {
        this.v = localArrayList1;
        if (this.v.size() >= 2) {
          e();
        }
      }
    }
    for (;;)
    {
      this.k.az.b.k();
      if (!this.C.isEnded()) {
        break;
      }
      this.C.setAnimationProperty(null);
      this.C = null;
      return;
      float f2 = this.E.a;
      float f3 = this.J;
      float f4 = this.E.a;
      float f1 = this.F;
      float f5 = this.F;
      f1 = f2 - f1 * f2;
      f2 += (f3 - f4) * f5;
      int i1 = 0;
      paramGL10 = null;
      label204:
      a locala1;
      if (i1 < localArrayList2.size())
      {
        locala1 = (a)localArrayList2.get(i1);
        if ((locala1.a > f1) && (locala1.a < f2))
        {
          if ((paramGL10 != null) && (paramGL10.a < f1))
          {
            f3 = locala1.a;
            f4 = paramGL10.a;
            a locala2 = a(paramGL10, locala1, (f1 - paramGL10.a) / (f3 - f4));
            locala2.b = paramGL10.b;
            localArrayList1.add(locala2);
          }
          localArrayList1.add(locala1);
        }
      }
      for (;;)
      {
        i1 += 1;
        paramGL10 = locala1;
        break label204;
        if (locala1.a > f2)
        {
          if ((paramGL10 != null) && (paramGL10.a < f2))
          {
            f1 = locala1.a;
            f3 = paramGL10.a;
            paramGL10 = a(paramGL10, locala1, (f2 - paramGL10.a) / (f1 - f3));
            paramGL10.b = locala1.b;
            localArrayList1.add(paramGL10);
          }
          break;
        }
        if ((Float.compare(locala1.a, f1) == 0) || (Float.compare(locala1.a, f2) == 0)) {
          localArrayList1.add(locala1);
        }
      }
      if ((this.C instanceof GlAlphaAnimation)) {
        e();
      }
    }
  }
  
  public final void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.m = paramArrayOfInt1;
    this.n = paramArrayOfInt2;
    this.z = a(PolylineOptions.ColorType.LINE_COLOR_NONE);
  }
  
  public final boolean a()
  {
    if (q() != null) {
      return (this.e) && (this.M);
    }
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.k == null) || (this.k.az == null) || (!a())) {}
    while (this.h == null) {
      return false;
    }
    return this.h.a(paramFloat1, paramFloat2);
  }
  
  public final void b()
  {
    if ((this.k != null) && (this.k.az != null) && (this.h != null))
    {
      this.k.az.b(this.h);
      this.h = null;
    }
    if (this.t != null)
    {
      this.t.a();
      this.t = null;
    }
    if (this.u != null)
    {
      this.u.clear();
      this.u = null;
    }
    if (this.v != null)
    {
      this.v.clear();
      this.v = null;
    }
    oi.b(this.O);
    if ((this.A != null) && (this.A.getFormater() != null)) {
      oi.b(this.A.getFormater().g);
    }
  }
  
  public final void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public final void c() {}
  
  public final void d()
  {
    e();
  }
  
  public final void e()
  {
    if ((this.k == null) || (this.k.az == null)) {}
    do
    {
      do
      {
        return;
        if (a()) {
          break;
        }
      } while (this.h == null);
      this.k.az.b(this.h);
      this.h.g = -1;
      this.h = null;
      return;
    } while ((this.v == null) || (this.v.size() < 2));
    if (this.h == null)
    {
      this.h = new ip(this.k.az.b.f, g());
      this.k.az.a(this.h);
    }
    for (;;)
    {
      this.h.a(this.r, this.s);
      f();
      this.k.az.b.k();
      return;
      this.h.a(g());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof mw)) {
      return false;
    }
    paramObject = (mw)paramObject;
    return TextUtils.equals(this.L, paramObject.L);
  }
  
  public final void h()
  {
    b();
  }
  
  public int hashCode()
  {
    return this.L.hashCode();
  }
  
  public final boolean m()
  {
    return true;
  }
  
  static final class a
    extends GeoPoint
  {
    float a = 0.0F;
    int b = 0;
    
    public a() {}
    
    public a(GeoPoint paramGeoPoint)
    {
      super();
    }
    
    public final String toString()
    {
      return super.toString() + "," + this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.mw
 * JD-Core Version:    0.7.0.1
 */