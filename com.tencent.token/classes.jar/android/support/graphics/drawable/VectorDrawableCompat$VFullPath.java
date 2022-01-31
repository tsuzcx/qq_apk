package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class VectorDrawableCompat$VFullPath
  extends VectorDrawableCompat.VPath
{
  private static final int FILL_TYPE_WINDING = 0;
  float mFillAlpha = 1.0F;
  int mFillColor = 0;
  int mFillRule = 0;
  float mStrokeAlpha = 1.0F;
  int mStrokeColor = 0;
  Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
  Paint.Join mStrokeLineJoin = Paint.Join.MITER;
  float mStrokeMiterlimit = 4.0F;
  float mStrokeWidth = 0.0F;
  private int[] mThemeAttrs;
  float mTrimPathEnd = 1.0F;
  float mTrimPathOffset = 0.0F;
  float mTrimPathStart = 0.0F;
  
  public VectorDrawableCompat$VFullPath() {}
  
  public VectorDrawableCompat$VFullPath(VFullPath paramVFullPath)
  {
    super(paramVFullPath);
    this.mThemeAttrs = paramVFullPath.mThemeAttrs;
    this.mStrokeColor = paramVFullPath.mStrokeColor;
    this.mStrokeWidth = paramVFullPath.mStrokeWidth;
    this.mStrokeAlpha = paramVFullPath.mStrokeAlpha;
    this.mFillColor = paramVFullPath.mFillColor;
    this.mFillRule = paramVFullPath.mFillRule;
    this.mFillAlpha = paramVFullPath.mFillAlpha;
    this.mTrimPathStart = paramVFullPath.mTrimPathStart;
    this.mTrimPathEnd = paramVFullPath.mTrimPathEnd;
    this.mTrimPathOffset = paramVFullPath.mTrimPathOffset;
    this.mStrokeLineCap = paramVFullPath.mStrokeLineCap;
    this.mStrokeLineJoin = paramVFullPath.mStrokeLineJoin;
    this.mStrokeMiterlimit = paramVFullPath.mStrokeMiterlimit;
  }
  
  private Paint.Cap getStrokeLineCap(int paramInt, Paint.Cap paramCap)
  {
    switch (paramInt)
    {
    default: 
      return paramCap;
    case 0: 
      return Paint.Cap.BUTT;
    case 1: 
      return Paint.Cap.ROUND;
    }
    return Paint.Cap.SQUARE;
  }
  
  private Paint.Join getStrokeLineJoin(int paramInt, Paint.Join paramJoin)
  {
    switch (paramInt)
    {
    default: 
      return paramJoin;
    case 0: 
      return Paint.Join.MITER;
    case 1: 
      return Paint.Join.ROUND;
    }
    return Paint.Join.BEVEL;
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    this.mThemeAttrs = null;
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
      return;
    }
    String str = paramTypedArray.getString(0);
    if (str != null) {
      this.mPathName = str;
    }
    str = paramTypedArray.getString(2);
    if (str != null) {
      this.mNodes = PathParser.createNodesFromPathData(str);
    }
    this.mFillColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.mFillColor);
    this.mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.mFillAlpha);
    this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
    this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
    this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
    this.mStrokeColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.mStrokeColor);
    this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
    this.mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
    this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
    this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
    this.mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
    this.mFillRule = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "fillType", 13, this.mFillRule);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mThemeAttrs == null) {}
  }
  
  public boolean canApplyTheme()
  {
    return this.mThemeAttrs != null;
  }
  
  float getFillAlpha()
  {
    return this.mFillAlpha;
  }
  
  int getFillColor()
  {
    return this.mFillColor;
  }
  
  float getStrokeAlpha()
  {
    return this.mStrokeAlpha;
  }
  
  int getStrokeColor()
  {
    return this.mStrokeColor;
  }
  
  float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }
  
  float getTrimPathEnd()
  {
    return this.mTrimPathEnd;
  }
  
  float getTrimPathOffset()
  {
    return this.mTrimPathOffset;
  }
  
  float getTrimPathStart()
  {
    return this.mTrimPathStart;
  }
  
  public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
  {
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
    updateStateFromTypedArray(paramResources, paramXmlPullParser);
    paramResources.recycle();
  }
  
  void setFillAlpha(float paramFloat)
  {
    this.mFillAlpha = paramFloat;
  }
  
  void setFillColor(int paramInt)
  {
    this.mFillColor = paramInt;
  }
  
  void setStrokeAlpha(float paramFloat)
  {
    this.mStrokeAlpha = paramFloat;
  }
  
  void setStrokeColor(int paramInt)
  {
    this.mStrokeColor = paramInt;
  }
  
  void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
  }
  
  void setTrimPathEnd(float paramFloat)
  {
    this.mTrimPathEnd = paramFloat;
  }
  
  void setTrimPathOffset(float paramFloat)
  {
    this.mTrimPathOffset = paramFloat;
  }
  
  void setTrimPathStart(float paramFloat)
  {
    this.mTrimPathStart = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VFullPath
 * JD-Core Version:    0.7.0.1
 */