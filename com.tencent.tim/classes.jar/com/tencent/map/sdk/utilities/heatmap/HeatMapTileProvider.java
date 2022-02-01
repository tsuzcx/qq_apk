package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.util.LongSparseArray;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.sdk.a.hl;
import com.tencent.map.sdk.a.hl.a;
import com.tencent.map.sdk.a.ho;
import com.tencent.map.sdk.a.ol;
import com.tencent.map.sdk.a.ol.b;
import com.tencent.map.sdk.a.ol.b.a;
import com.tencent.map.sdk.a.ol.d;
import com.tencent.map.sdk.a.or;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatMapTileProvider
  implements TileProvider
{
  public static final Gradient DEFAULT_GRADIENT = new Gradient(a, b);
  public static final double DEFAULT_OPACITY = 0.6D;
  public static final int DEFAULT_RADIUS = 40;
  private static final int[] a = { Color.argb(0, 25, 0, 255), Color.argb(170, 30, 0, 255), Color.rgb(0, 191, 255), Color.rgb(0, 255, 0), Color.rgb(255, 255, 0), Color.rgb(255, 0, 0) };
  private static final float[] b = { 0.0F, 0.4F, 0.6F, 0.75F, 0.8F, 1.0F };
  private final OnHeatMapReadyListener c;
  private HeatTileGenerator d;
  private hl<WeightedLatLng> e;
  private Collection<WeightedLatLng> f;
  private ho g;
  private int h;
  private Gradient i;
  private int[] j;
  private double[] k;
  private double l;
  private double[] m;
  private boolean n;
  
  private HeatMapTileProvider(Builder paramBuilder)
  {
    this.f = Builder.a(paramBuilder);
    this.h = Builder.b(paramBuilder);
    this.i = Builder.c(paramBuilder);
    this.l = Builder.d(paramBuilder);
    this.c = Builder.e(paramBuilder);
    this.d = Builder.f(paramBuilder);
    if (this.f != null) {
      ol.a(new HeatMapTileProvider.1(this)).a(new ol.d(Boolean.FALSE)).a();
    }
  }
  
  private static double a(Collection<WeightedLatLng> paramCollection, ho paramho, int paramInt1, int paramInt2)
  {
    double d2 = paramho.a;
    double d1 = paramho.c;
    double d3 = paramho.b;
    double d4 = paramho.d;
    label82:
    WeightedLatLng localWeightedLatLng;
    double d5;
    if (d1 - d2 > d4 - d3)
    {
      d1 -= d2;
      d4 = (int)(paramInt2 / (paramInt1 * 2) + 0.5D) / d1;
      LongSparseArray localLongSparseArray = new LongSparseArray();
      Iterator localIterator = paramCollection.iterator();
      d1 = 0.0D;
      if (!localIterator.hasNext()) {
        break label253;
      }
      localWeightedLatLng = (WeightedLatLng)localIterator.next();
      d5 = localWeightedLatLng.getItemPoint().x;
      double d6 = localWeightedLatLng.getItemPoint().y;
      paramInt1 = (int)((d5 - d2) * d4);
      paramInt2 = (int)((d6 - d3) * d4);
      paramCollection = (LongSparseArray)localLongSparseArray.get(paramInt1);
      if (paramCollection != null) {
        break label259;
      }
      paramCollection = new LongSparseArray();
      localLongSparseArray.put(paramInt1, paramCollection);
    }
    label259:
    for (;;)
    {
      Double localDouble = (Double)paramCollection.get(paramInt2);
      paramho = localDouble;
      if (localDouble == null) {
        paramho = Double.valueOf(0.0D);
      }
      d5 = paramho.doubleValue();
      paramho = Double.valueOf(localWeightedLatLng.getIntensity() + d5);
      paramCollection.put(paramInt2, paramho);
      if (paramho.doubleValue() > d1) {
        d1 = paramho.doubleValue();
      }
      for (;;)
      {
        break label82;
        d1 = d4 - d3;
        break;
        label253:
        return d1;
      }
    }
  }
  
  private static Bitmap a(double[][] paramArrayOfDouble, int[] paramArrayOfInt, double paramDouble)
  {
    int i3 = paramArrayOfInt[(paramArrayOfInt.length - 1)];
    paramDouble = (paramArrayOfInt.length - 1) / paramDouble;
    int i4 = paramArrayOfDouble.length;
    int[] arrayOfInt = new int[i4 * i4];
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      if (i2 < i4)
      {
        double d1 = paramArrayOfDouble[i2][i1];
        int i5 = i1 * i4 + i2;
        int i6 = (int)(d1 * paramDouble);
        if (d1 != 0.0D) {
          if (i6 < paramArrayOfInt.length) {
            arrayOfInt[i5] = paramArrayOfInt[i6];
          }
        }
        for (;;)
        {
          i2 += 1;
          break;
          arrayOfInt[i5] = i3;
          continue;
          arrayOfInt[i5] = 0;
        }
      }
      i1 += 1;
    }
    paramArrayOfDouble = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
    paramArrayOfDouble.setPixels(arrayOfInt, 0, i4, 0, 0, i4, i4);
    return paramArrayOfDouble;
  }
  
  private double[] a(int paramInt)
  {
    int i3 = 11;
    double[] arrayOfDouble = new double[22];
    int i1 = 5;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 11) {
        break;
      }
      arrayOfDouble[i1] = a(this.f, this.g, paramInt, (int)(1280.0D * Math.pow(2.0D, i1 - 3)));
      if (i1 == 5)
      {
        i2 = 0;
        while (i2 < i1)
        {
          arrayOfDouble[i2] = arrayOfDouble[i1];
          i2 += 1;
        }
      }
      i1 += 1;
    }
    while (i2 < 22)
    {
      arrayOfDouble[i2] = arrayOfDouble[10];
      i2 += 1;
    }
    return arrayOfDouble;
  }
  
  static double[] a(int paramInt, double paramDouble)
  {
    double[] arrayOfDouble = new double[paramInt * 2 + 1];
    int i1 = -paramInt;
    while (i1 <= paramInt)
    {
      arrayOfDouble[(i1 + paramInt)] = Math.exp(-i1 * i1 / (2.0D * paramDouble * paramDouble));
      i1 += 1;
    }
    return arrayOfDouble;
  }
  
  private static double[][] a(double[][] paramArrayOfDouble, double[] paramArrayOfDouble1)
  {
    int i1 = (int)Math.floor(paramArrayOfDouble1.length / 2.0D);
    int i7 = paramArrayOfDouble.length;
    int i8 = i7 - i1 * 2;
    int i3 = i1 + i8 - 1;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i7, i7 });
    int i4 = 0;
    int i5;
    double d1;
    int i6;
    int i2;
    double[] arrayOfDouble1;
    while (i4 < i7)
    {
      i5 = 0;
      while (i5 < i7)
      {
        d1 = paramArrayOfDouble[i4][i5];
        if (d1 != 0.0D)
        {
          if (i3 < i4 + i1)
          {
            i6 = i3;
            if (i1 <= i4 - i1) {
              break label179;
            }
            i2 = i1;
          }
          for (;;)
          {
            if (i2 >= i6 + 1) {
              break label189;
            }
            arrayOfDouble1 = arrayOfDouble[i2];
            arrayOfDouble1[i5] += paramArrayOfDouble1[(i2 - (i4 - i1))] * d1;
            i2 += 1;
            continue;
            i6 = i4 + i1;
            break;
            label179:
            i2 = i4 - i1;
          }
        }
        label189:
        i5 += 1;
      }
      i4 += 1;
    }
    paramArrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i8, i8 });
    i4 = i1;
    while (i4 < i3 + 1)
    {
      i5 = 0;
      while (i5 < i7)
      {
        d1 = arrayOfDouble[i4][i5];
        if (d1 != 0.0D)
        {
          if (i3 < i5 + i1)
          {
            i6 = i3;
            if (i1 <= i5 - i1) {
              break label363;
            }
            i2 = i1;
          }
          for (;;)
          {
            if (i2 >= i6 + 1) {
              break label373;
            }
            arrayOfDouble1 = paramArrayOfDouble[(i4 - i1)];
            i8 = i2 - i1;
            arrayOfDouble1[i8] += paramArrayOfDouble1[(i2 - (i5 - i1))] * d1;
            i2 += 1;
            continue;
            i6 = i5 + i1;
            break;
            label363:
            i2 = i5 - i1;
          }
        }
        label373:
        i5 += 1;
      }
      i4 += 1;
    }
    return paramArrayOfDouble;
  }
  
  private static ho b(Collection<WeightedLatLng> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
    double d7 = localWeightedLatLng.getItemPoint().x;
    double d3 = localWeightedLatLng.getItemPoint().x;
    double d2 = localWeightedLatLng.getItemPoint().y;
    double d1 = localWeightedLatLng.getItemPoint().y;
    while (paramCollection.hasNext())
    {
      localWeightedLatLng = (WeightedLatLng)paramCollection.next();
      double d8 = localWeightedLatLng.getItemPoint().x;
      double d4 = localWeightedLatLng.getItemPoint().y;
      double d5 = d7;
      if (d8 < d7) {
        d5 = d8;
      }
      double d6 = d3;
      if (d8 > d3) {
        d6 = d8;
      }
      d8 = d2;
      if (d4 < d2) {
        d8 = d4;
      }
      d7 = d5;
      d3 = d6;
      d2 = d8;
      if (d4 > d1)
      {
        d1 = d4;
        d7 = d5;
        d3 = d6;
        d2 = d8;
      }
    }
    return new ho(d7, d3, d2, d1);
  }
  
  private static Collection<WeightedLatLng> c(Collection<LatLng> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new WeightedLatLng((LatLng)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.n)
    {
      or.b("TileOverlay", "热力图未初始化完成，返回空瓦块");
      return TileProvider.NO_TILE;
    }
    double d1 = 1.0D / Math.pow(2.0D, paramInt3);
    double d2 = this.h * d1 / 256.0D;
    double d3 = (2.0D * d2 + d1) / (this.h * 2 + 256);
    double d4 = paramInt1 * d1 - d2;
    double d5 = (paramInt1 + 1) * d1 + d2;
    double d6 = paramInt2 * d1 - d2;
    double d7 = d1 * (paramInt2 + 1) + d2;
    Object localObject1 = new ArrayList();
    if (d4 < 0.0D)
    {
      localObject1 = new ho(1.0D + d4, 1.0D, d6, d7);
      localObject1 = this.e.a((ho)localObject1);
      d1 = -1.0D;
    }
    for (;;)
    {
      Object localObject2 = new ho(d4, d5, d6, d7);
      if (!((ho)localObject2).a(new ho(this.g.a - d2, this.g.c + d2, this.g.b - d2, d2 + this.g.d)))
      {
        or.b("TileOverlay", "热力图超出有效边界，返回空瓦块-" + paramInt1 + ":" + paramInt2 + ":" + paramInt3);
        return TileProvider.NO_TILE;
        if (d5 > 1.0D)
        {
          localObject1 = new ho(0.0D, d5 - 1.0D, d6, d7);
          localObject1 = this.e.a((ho)localObject1);
          d1 = 1.0D;
        }
      }
      else
      {
        Object localObject3 = this.e.a((ho)localObject2);
        if (((Collection)localObject3).isEmpty())
        {
          or.b("TileOverlay", "热力图没有热力数据，返回空瓦块-" + paramInt1 + ":" + paramInt2 + ":" + paramInt3);
          return TileProvider.NO_TILE;
        }
        paramInt1 = this.h;
        paramInt2 = this.h;
        localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1 * 2 + 256, paramInt2 * 2 + 256 });
        localObject3 = ((Collection)localObject3).iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (WeightedLatLng)((Iterator)localObject3).next();
          DoublePoint localDoublePoint = ((WeightedLatLng)localObject4).getItemPoint();
          paramInt1 = (int)((localDoublePoint.x - d4) / d3);
          paramInt2 = (int)((localDoublePoint.y - d6) / d3);
          localDoublePoint = localObject2[paramInt1];
          localDoublePoint[paramInt2] += ((WeightedLatLng)localObject4).getIntensity();
        }
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (WeightedLatLng)((Iterator)localObject1).next();
          localObject4 = ((WeightedLatLng)localObject3).getItemPoint();
          paramInt1 = (int)((((DoublePoint)localObject4).x + d1 - d4) / d3);
          paramInt2 = (int)((((DoublePoint)localObject4).y - d6) / d3);
          localObject4 = localObject2[paramInt1];
          localObject4[paramInt2] += ((WeightedLatLng)localObject3).getIntensity();
        }
        localObject1 = a(a((double[][])localObject2, this.k), this.j, this.m[paramInt3]);
        localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
        return new Tile(256, 256, ((ByteArrayOutputStream)localObject2).toByteArray());
      }
      d1 = 0.0D;
    }
  }
  
  public void setData(Collection<LatLng> paramCollection)
  {
    setWeightedData(c(paramCollection));
  }
  
  public void setGradient(Gradient paramGradient)
  {
    this.i = paramGradient;
    if (this.d != null)
    {
      this.j = this.d.generateColorMap(this.l);
      return;
    }
    this.j = this.i.generateColorMap(this.l);
  }
  
  public void setHeatTileGenerator(HeatTileGenerator paramHeatTileGenerator)
  {
    this.d = paramHeatTileGenerator;
    if (this.d != null)
    {
      this.k = this.d.generateKernel(this.h);
      this.j = this.d.generateColorMap(this.l);
    }
  }
  
  public void setOpacity(double paramDouble)
  {
    this.l = paramDouble;
    setGradient(this.i);
  }
  
  public void setRadius(int paramInt)
  {
    this.h = paramInt;
    if (this.d != null) {}
    for (this.k = this.d.generateKernel(this.h);; this.k = a(this.h, this.h / 3.0D))
    {
      this.m = a(this.h);
      return;
    }
  }
  
  public void setWeightedData(Collection<WeightedLatLng> paramCollection)
  {
    this.f = paramCollection;
    if (this.f.isEmpty()) {
      throw new IllegalArgumentException("No input points.");
    }
    this.g = b(this.f);
    this.e = new hl(this.g);
    paramCollection = this.f.iterator();
    while (paramCollection.hasNext())
    {
      WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
      hl localhl = this.e;
      DoublePoint localDoublePoint = localWeightedLatLng.getItemPoint();
      if (localhl.a.a(localDoublePoint.x, localDoublePoint.y)) {
        localhl.a(localDoublePoint.x, localDoublePoint.y, localWeightedLatLng);
      }
    }
    this.m = a(this.h);
  }
  
  public static class Builder
  {
    private Collection<WeightedLatLng> a;
    private int b = 40;
    private Gradient c = HeatMapTileProvider.DEFAULT_GRADIENT;
    private double d = 0.6D;
    private HeatMapTileProvider.HeatTileGenerator e;
    private HeatMapTileProvider.OnHeatMapReadyListener f;
    
    public HeatMapTileProvider build()
    {
      if (this.a == null) {
        throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
      }
      return new HeatMapTileProvider(this, (byte)0);
    }
    
    public Builder data(Collection<LatLng> paramCollection)
    {
      return weightedData(HeatMapTileProvider.a(paramCollection));
    }
    
    public Builder gradient(Gradient paramGradient)
    {
      this.c = paramGradient;
      return this;
    }
    
    public Builder opacity(double paramDouble)
    {
      if ((paramDouble < 0.0D) || (paramDouble > 1.0D)) {
        throw new IllegalArgumentException("Opacity must be in range [0, 1]");
      }
      this.d = paramDouble;
      return this;
    }
    
    public Builder radius(int paramInt)
    {
      if ((paramInt < 10) || (paramInt > 50)) {
        throw new IllegalArgumentException("Radius not within bounds.");
      }
      this.b = paramInt;
      return this;
    }
    
    public Builder readyListener(HeatMapTileProvider.OnHeatMapReadyListener paramOnHeatMapReadyListener)
    {
      this.f = paramOnHeatMapReadyListener;
      return this;
    }
    
    public Builder tileGenerator(HeatMapTileProvider.HeatTileGenerator paramHeatTileGenerator)
    {
      this.e = paramHeatTileGenerator;
      return this;
    }
    
    public Builder weightedData(Collection<WeightedLatLng> paramCollection)
    {
      if (paramCollection.isEmpty()) {
        throw new IllegalArgumentException("No input points.");
      }
      this.a = paramCollection;
      return this;
    }
  }
  
  public static abstract interface HeatTileGenerator
  {
    public abstract int[] generateColorMap(double paramDouble);
    
    public abstract double[] generateKernel(int paramInt);
  }
  
  public static abstract interface OnHeatMapReadyListener
  {
    public abstract void onHeatMapReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
 * JD-Core Version:    0.7.0.1
 */