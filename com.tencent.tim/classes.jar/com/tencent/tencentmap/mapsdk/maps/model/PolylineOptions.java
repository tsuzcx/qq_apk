package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import com.tencent.map.sdk.a.fz;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PolylineOptions
{
  private static String x = "color_texture_flat_style.png";
  @Deprecated
  private static String y;
  private ColorType A = ColorType.LINE_COLOR_NONE;
  private IndoorInfo B;
  private int C = OverlayLevel.OverlayLevelAboveRoads;
  private Text D;
  private int E = 100;
  final List<LatLng> a = new ArrayList();
  boolean b = false;
  boolean c = true;
  private float d = -1.0F;
  private float e;
  private int f = fz.m;
  private int g = 0;
  private boolean h = true;
  private boolean i = false;
  private boolean j;
  private boolean k = false;
  private float l = 1.0F;
  private boolean m = false;
  private Animation n;
  private List<Integer> o;
  private int[] p = null;
  private int[] q = { -16711936 };
  private int[] r = null;
  private int s = -7829368;
  private int t = 0;
  @Deprecated
  private String u = x;
  private BitmapDescriptor v = BitmapDescriptorFactory.fromAsset(x);
  private BitmapDescriptor w = null;
  private boolean z;
  
  @Deprecated
  public static String getDefaultColorTexture()
  {
    return x;
  }
  
  @Deprecated
  public static String getsDefaultArrowTexture()
  {
    return y;
  }
  
  @Deprecated
  public static void setDefaultArrowTexture(String paramString)
  {
    y = paramString;
  }
  
  @Deprecated
  public static void setDefaultColorTexture(String paramString)
  {
    x = paramString;
  }
  
  public PolylineOptions abovePillar(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (this.B != null) {
      this.k = true;
    }
    return this;
  }
  
  public PolylineOptions add(LatLng paramLatLng, LatLng... paramVarArgs)
  {
    this.a.add(paramLatLng);
    if (paramVarArgs != null) {
      add(paramVarArgs);
    }
    return this;
  }
  
  public PolylineOptions add(LatLng[] paramArrayOfLatLng)
  {
    if (paramArrayOfLatLng != null) {
      this.a.addAll(Arrays.asList(paramArrayOfLatLng));
    }
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        add((LatLng)paramIterable.next(), new LatLng[0]);
      }
    }
    return this;
  }
  
  public PolylineOptions alpha(float paramFloat)
  {
    this.l = paramFloat;
    return this;
  }
  
  public PolylineOptions animation(Animation paramAnimation)
  {
    this.n = paramAnimation;
    return this;
  }
  
  public PolylineOptions arrow(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public PolylineOptions arrowSpacing(int paramInt)
  {
    this.E = paramInt;
    return this;
  }
  
  public PolylineOptions arrowTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.w = paramBitmapDescriptor;
    return this;
  }
  
  public PolylineOptions borderColor(int paramInt)
  {
    this.q = new int[] { paramInt };
    return this;
  }
  
  public PolylineOptions borderColors(int[] paramArrayOfInt)
  {
    this.q = paramArrayOfInt;
    return this;
  }
  
  public PolylineOptions borderWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.e = 1.0F;
      return this;
    }
    this.e = paramFloat;
    return this;
  }
  
  public PolylineOptions clickable(boolean paramBoolean)
  {
    this.z = paramBoolean;
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public PolylineOptions colorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.v = paramBitmapDescriptor;
    this.A = ColorType.LINE_COLOR_TEXTURE;
    return this;
  }
  
  public PolylineOptions colorType(ColorType paramColorType)
  {
    this.A = paramColorType;
    return this;
  }
  
  public PolylineOptions colors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.p = paramArrayOfInt1;
    this.r = paramArrayOfInt2;
    return this;
  }
  
  public PolylineOptions eraseColor(int paramInt)
  {
    this.s = paramInt;
    return this;
  }
  
  public float getAlpha()
  {
    return this.l;
  }
  
  public Animation getAnimation()
  {
    return this.n;
  }
  
  public int getArrowSpacing()
  {
    return this.E;
  }
  
  public BitmapDescriptor getArrowTexture()
  {
    return this.w;
  }
  
  public int[] getBorderColors()
  {
    return this.q;
  }
  
  public float getBorderWidth()
  {
    return this.e;
  }
  
  public int getColor()
  {
    return this.f;
  }
  
  public BitmapDescriptor getColorTexture()
  {
    return this.v;
  }
  
  public ColorType getColorType()
  {
    return this.A;
  }
  
  public int[][] getColors()
  {
    if ((this.p == null) || (this.r == null)) {}
    while (this.p.length != this.r.length) {
      return null;
    }
    int i1 = this.p.length;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i1 });
    arrayOfInt[0] = this.p;
    arrayOfInt[1] = this.r;
    return arrayOfInt;
  }
  
  public int getEraseColor()
  {
    return this.s;
  }
  
  public IndoorInfo getIndoorInfo()
  {
    return this.B;
  }
  
  public int getLevel()
  {
    return this.C;
  }
  
  public boolean getLineCap()
  {
    return this.m;
  }
  
  public int getLineType()
  {
    return this.t;
  }
  
  public List<Integer> getPattern()
  {
    return this.o;
  }
  
  public List<LatLng> getPoints()
  {
    return this.a;
  }
  
  public Text getText()
  {
    return this.D;
  }
  
  @Deprecated
  public String getTextureName()
  {
    return this.u;
  }
  
  public float getWidth()
  {
    return this.d;
  }
  
  public int getZIndex()
  {
    return this.g;
  }
  
  public PolylineOptions indoorInfo(IndoorInfo paramIndoorInfo)
  {
    if (paramIndoorInfo != null)
    {
      this.B = paramIndoorInfo;
      this.k = true;
    }
    return this;
  }
  
  public boolean isAbovePillar()
  {
    return this.k;
  }
  
  public boolean isArrow()
  {
    return this.j;
  }
  
  public boolean isClickable()
  {
    return this.z;
  }
  
  public boolean isRoad()
  {
    return this.c;
  }
  
  public boolean isVisible()
  {
    return this.h;
  }
  
  public PolylineOptions latLngs(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
    }
    return this;
  }
  
  public PolylineOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.C = paramInt;
    return this;
  }
  
  public PolylineOptions lineCap(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public PolylineOptions lineType(int paramInt)
  {
    this.t = paramInt;
    return this;
  }
  
  public PolylineOptions pattern(List<Integer> paramList)
  {
    this.o = paramList;
    return this;
  }
  
  @Deprecated
  public PolylineOptions setColorTexture(String paramString)
  {
    this.u = paramString;
    return colorTexture(BitmapDescriptorFactory.fromAsset(paramString));
  }
  
  @Deprecated
  public void setColors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.p = paramArrayOfInt1;
    this.r = paramArrayOfInt2;
  }
  
  @Deprecated
  public void setLatLngs(List<LatLng> paramList)
  {
    latLngs(paramList);
  }
  
  @Deprecated
  public PolylineOptions setLineType(int paramInt)
  {
    return lineType(paramInt);
  }
  
  public PolylineOptions text(Text paramText)
  {
    this.D = paramText;
    return this;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.d = 9.0F;
      return this;
    }
    float f1 = paramFloat;
    if (paramFloat > 128.0F) {
      f1 = 128.0F;
    }
    this.d = f1;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeFloat(this.d);
  }
  
  public PolylineOptions zIndex(int paramInt)
  {
    this.g = Math.max(0, paramInt);
    return this;
  }
  
  public static enum ColorType
  {
    private ColorType() {}
  }
  
  public static final class Colors
  {
    public static final int DARK_BLUE = 6;
    public static final int DASHED = 33;
    public static final int GRAYBLUE = 8;
    public static final int GREEN = 4;
    public static final int GREY = 0;
    public static final int LAST_BLUE = 20;
    public static final int LIGHT_BLUE = 1;
    public static final int LIVER_RED = 9;
    public static final int MID_BLUE = 5;
    public static final int RED = 2;
    public static final int TRANSPARENT = 7;
    public static final int WHITE_BLUE = 19;
    public static final int YELLOW = 3;
  }
  
  public static final class LineType
  {
    public static final int LINE_TYPE_DOTTEDLINE = 2;
    public static final int LINE_TYPE_IMAGEINARYLINE = 1;
    public static final int LINE_TYPE_MULTICOLORLINE = 0;
  }
  
  public static final class SegmentText
  {
    private final int a;
    private final int b;
    private final String c;
    
    public SegmentText(int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString;
    }
    
    public final int getEndIndex()
    {
      return this.b;
    }
    
    public final int getStartIndex()
    {
      return this.a;
    }
    
    public final String getText()
    {
      return this.c;
    }
  }
  
  public static final class Text
  {
    private final List<PolylineOptions.SegmentText> a;
    private Builder b;
    
    private Text(Builder paramBuilder)
    {
      this.a = Collections.unmodifiableList(Builder.a(paramBuilder));
      this.b = paramBuilder;
    }
    
    public final PolylineOptions.TextPriority getPriority()
    {
      return Builder.e(this.b);
    }
    
    public final List<PolylineOptions.SegmentText> getSegmentTexts()
    {
      return this.a;
    }
    
    public final int getStrokeColor()
    {
      return Builder.c(this.b);
    }
    
    public final int getTextColor()
    {
      return Builder.b(this.b);
    }
    
    public final int getTextSize()
    {
      return Builder.d(this.b);
    }
    
    public final void setPriority(PolylineOptions.TextPriority paramTextPriority)
    {
      Builder.a(this.b, paramTextPriority);
    }
    
    public final void setStrokeColor(int paramInt)
    {
      Builder.b(this.b, paramInt);
    }
    
    public final void setTextColor(int paramInt)
    {
      Builder.a(this.b, paramInt);
    }
    
    public final void setTextSize(int paramInt)
    {
      Builder.c(this.b, paramInt);
    }
    
    public static final class Builder
    {
      private List<PolylineOptions.SegmentText> a = new ArrayList();
      private int b = -16777216;
      private int c = -1;
      private int d = 14;
      private PolylineOptions.TextPriority e = PolylineOptions.TextPriority.HIGH;
      
      public Builder(PolylineOptions.SegmentText paramSegmentText)
      {
        addSegmentText(paramSegmentText);
      }
      
      public Builder(List<PolylineOptions.SegmentText> paramList)
      {
        addAllSegmentText(paramList);
      }
      
      public final Builder addAllSegmentText(List<PolylineOptions.SegmentText> paramList)
      {
        this.a.addAll(paramList);
        return this;
      }
      
      public final Builder addSegmentText(PolylineOptions.SegmentText paramSegmentText)
      {
        this.a.add(paramSegmentText);
        return this;
      }
      
      public final PolylineOptions.Text build()
      {
        return new PolylineOptions.Text(this, (byte)0);
      }
      
      public final Builder color(int paramInt)
      {
        this.b = paramInt;
        return this;
      }
      
      public final Builder priority(PolylineOptions.TextPriority paramTextPriority)
      {
        this.e = paramTextPriority;
        return this;
      }
      
      public final Builder size(int paramInt)
      {
        this.d = paramInt;
        return this;
      }
      
      public final Builder strokeColor(int paramInt)
      {
        this.c = paramInt;
        return this;
      }
    }
  }
  
  public static enum TextPriority
  {
    private TextPriority() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */