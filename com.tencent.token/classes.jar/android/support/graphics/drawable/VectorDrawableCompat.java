package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat
  extends VectorDrawableCommon
{
  private static final boolean DBG_VECTOR_DRAWABLE = false;
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private static final int LINECAP_BUTT = 0;
  private static final int LINECAP_ROUND = 1;
  private static final int LINECAP_SQUARE = 2;
  private static final int LINEJOIN_BEVEL = 2;
  private static final int LINEJOIN_MITER = 0;
  private static final int LINEJOIN_ROUND = 1;
  static final String LOGTAG = "VectorDrawableCompat";
  private static final int MAX_CACHED_BITMAP_SIZE = 2048;
  private static final String SHAPE_CLIP_PATH = "clip-path";
  private static final String SHAPE_GROUP = "group";
  private static final String SHAPE_PATH = "path";
  private static final String SHAPE_VECTOR = "vector";
  private boolean mAllowCaching = true;
  private Drawable.ConstantState mCachedConstantStateDelegate;
  private ColorFilter mColorFilter;
  private boolean mMutated;
  private PorterDuffColorFilter mTintFilter;
  private final Rect mTmpBounds = new Rect();
  private final float[] mTmpFloats = new float[9];
  private final Matrix mTmpMatrix = new Matrix();
  private VectorDrawableCompat.VectorDrawableCompatState mVectorState;
  
  VectorDrawableCompat()
  {
    this.mVectorState = new VectorDrawableCompat.VectorDrawableCompatState();
  }
  
  VectorDrawableCompat(@NonNull VectorDrawableCompat.VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    this.mVectorState = paramVectorDrawableCompatState;
    this.mTintFilter = updateTintFilter(this.mTintFilter, paramVectorDrawableCompatState.mTint, paramVectorDrawableCompatState.mTintMode);
  }
  
  static int applyAlpha(int paramInt, float paramFloat)
  {
    return (int)(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  @Nullable
  public static VectorDrawableCompat create(@NonNull Resources paramResources, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new VectorDrawableCompat();
      ((VectorDrawableCompat)localObject).mDelegateDrawable = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      ((VectorDrawableCompat)localObject).mCachedConstantStateDelegate = new VectorDrawableCompat.VectorDrawableDelegateState(((VectorDrawableCompat)localObject).mDelegateDrawable.getConstantState());
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
      paramResources = createFromXmlInner(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        Log.e("VectorDrawableCompat", "parser error", paramResources);
      }
    }
  }
  
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localVectorDrawableCompat;
  }
  
  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    VectorDrawableCompat.VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    VectorDrawableCompat.VPathRenderer localVPathRenderer = localVectorDrawableCompatState.mVPathRenderer;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localVPathRenderer.mRootGroup);
    int k = paramXmlPullParser.getEventType();
    int m = paramXmlPullParser.getDepth();
    int i = 1;
    if ((k != 1) && ((paramXmlPullParser.getDepth() >= m + 1) || (k != 3)))
    {
      Object localObject;
      VectorDrawableCompat.VGroup localVGroup;
      int j;
      if (k == 2)
      {
        localObject = paramXmlPullParser.getName();
        localVGroup = (VectorDrawableCompat.VGroup)localArrayDeque.peek();
        if ("path".equals(localObject))
        {
          localObject = new VectorDrawableCompat.VFullPath();
          ((VectorDrawableCompat.VFullPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          if (((VectorDrawableCompat.VFullPath)localObject).getPathName() != null) {
            localVPathRenderer.mVGTargetsMap.put(((VectorDrawableCompat.VFullPath)localObject).getPathName(), localObject);
          }
          i = 0;
          j = localVectorDrawableCompatState.mChangingConfigurations;
          localVectorDrawableCompatState.mChangingConfigurations = (((VectorDrawableCompat.VFullPath)localObject).mChangingConfigurations | j);
          label187:
          j = i;
        }
      }
      for (;;)
      {
        k = paramXmlPullParser.next();
        i = j;
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new VectorDrawableCompat.VClipPath();
          ((VectorDrawableCompat.VClipPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          if (((VectorDrawableCompat.VClipPath)localObject).getPathName() != null) {
            localVPathRenderer.mVGTargetsMap.put(((VectorDrawableCompat.VClipPath)localObject).getPathName(), localObject);
          }
          localVectorDrawableCompatState.mChangingConfigurations |= ((VectorDrawableCompat.VClipPath)localObject).mChangingConfigurations;
          break label187;
        }
        if ("group".equals(localObject))
        {
          localObject = new VectorDrawableCompat.VGroup();
          ((VectorDrawableCompat.VGroup)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          localArrayDeque.push(localObject);
          if (((VectorDrawableCompat.VGroup)localObject).getGroupName() != null) {
            localVPathRenderer.mVGTargetsMap.put(((VectorDrawableCompat.VGroup)localObject).getGroupName(), localObject);
          }
          localVectorDrawableCompatState.mChangingConfigurations |= ((VectorDrawableCompat.VGroup)localObject).mChangingConfigurations;
        }
        break label187;
        j = i;
        if (k == 3)
        {
          j = i;
          if ("group".equals(paramXmlPullParser.getName()))
          {
            localArrayDeque.pop();
            j = i;
          }
        }
      }
    }
    if (i != 0) {
      throw new XmlPullParserException("no path defined");
    }
  }
  
  private boolean needMirroring()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return (isAutoMirrored()) && (DrawableCompat.getLayoutDirection(this) == 1);
    }
    return false;
  }
  
  private static PorterDuff.Mode parseTintModeCompat(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramMode;
    case 3: 
      return PorterDuff.Mode.SRC_OVER;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    }
    return PorterDuff.Mode.ADD;
  }
  
  private void printGroupTree(VectorDrawableCompat.VGroup paramVGroup, int paramInt)
  {
    Object localObject = "";
    int i = 0;
    while (i < paramInt)
    {
      localObject = (String)localObject + "    ";
      i += 1;
    }
    Log.v("VectorDrawableCompat", (String)localObject + "current group is :" + paramVGroup.getGroupName() + " rotation is " + paramVGroup.mRotate);
    Log.v("VectorDrawableCompat", (String)localObject + "matrix is :" + paramVGroup.getLocalMatrix().toString());
    i = 0;
    if (i < paramVGroup.mChildren.size())
    {
      localObject = paramVGroup.mChildren.get(i);
      if ((localObject instanceof VectorDrawableCompat.VGroup)) {
        printGroupTree((VectorDrawableCompat.VGroup)localObject, paramInt + 1);
      }
      for (;;)
      {
        i += 1;
        break;
        ((VectorDrawableCompat.VPath)localObject).printVPath(paramInt + 1);
      }
    }
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    VectorDrawableCompat.VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    VectorDrawableCompat.VPathRenderer localVPathRenderer = localVectorDrawableCompatState.mVPathRenderer;
    localVectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList localColorStateList = paramTypedArray.getColorStateList(1);
    if (localColorStateList != null) {
      localVectorDrawableCompatState.mTint = localColorStateList;
    }
    localVectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localVectorDrawableCompatState.mAutoMirrored);
    localVPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, localVPathRenderer.mViewportWidth);
    localVPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, localVPathRenderer.mViewportHeight);
    if (localVPathRenderer.mViewportWidth <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }
    if (localVPathRenderer.mViewportHeight <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    localVPathRenderer.mBaseWidth = paramTypedArray.getDimension(3, localVPathRenderer.mBaseWidth);
    localVPathRenderer.mBaseHeight = paramTypedArray.getDimension(2, localVPathRenderer.mBaseHeight);
    if (localVPathRenderer.mBaseWidth <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (localVPathRenderer.mBaseHeight <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    localVPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, localVPathRenderer.getAlpha()));
    paramTypedArray = paramTypedArray.getString(0);
    if (paramTypedArray != null)
    {
      localVPathRenderer.mRootName = paramTypedArray;
      localVPathRenderer.mVGTargetsMap.put(paramTypedArray, localVPathRenderer);
    }
  }
  
  public boolean canApplyTheme()
  {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.draw(paramCanvas);
    }
    Object localObject;
    int i;
    int j;
    do
    {
      do
      {
        return;
        copyBounds(this.mTmpBounds);
      } while ((this.mTmpBounds.width() <= 0) || (this.mTmpBounds.height() <= 0));
      if (this.mColorFilter != null) {
        break;
      }
      localObject = this.mTintFilter;
      paramCanvas.getMatrix(this.mTmpMatrix);
      this.mTmpMatrix.getValues(this.mTmpFloats);
      float f2 = Math.abs(this.mTmpFloats[0]);
      float f1 = Math.abs(this.mTmpFloats[4]);
      float f4 = Math.abs(this.mTmpFloats[1]);
      float f3 = Math.abs(this.mTmpFloats[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      i = (int)(f2 * this.mTmpBounds.width());
      j = (int)(f1 * this.mTmpBounds.height());
      i = Math.min(2048, i);
      j = Math.min(2048, j);
    } while ((i <= 0) || (j <= 0));
    int k = paramCanvas.save();
    paramCanvas.translate(this.mTmpBounds.left, this.mTmpBounds.top);
    if (needMirroring())
    {
      paramCanvas.translate(this.mTmpBounds.width(), 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    }
    this.mTmpBounds.offsetTo(0, 0);
    this.mVectorState.createCachedBitmapIfNeeded(i, j);
    if (!this.mAllowCaching) {
      this.mVectorState.updateCachedBitmap(i, j);
    }
    for (;;)
    {
      this.mVectorState.drawCachedBitmapWithRootAlpha(paramCanvas, (ColorFilter)localObject, this.mTmpBounds);
      paramCanvas.restoreToCount(k);
      return;
      localObject = this.mColorFilter;
      break;
      if (!this.mVectorState.canReuseCache())
      {
        this.mVectorState.updateCachedBitmap(i, j);
        this.mVectorState.updateCacheStates();
      }
    }
  }
  
  public int getAlpha()
  {
    if (this.mDelegateDrawable != null) {
      return DrawableCompat.getAlpha(this.mDelegateDrawable);
    }
    return this.mVectorState.mVPathRenderer.getRootAlpha();
  }
  
  public int getChangingConfigurations()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.mDelegateDrawable != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new VectorDrawableCompat.VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }
    this.mVectorState.mChangingConfigurations = getChangingConfigurations();
    return this.mVectorState;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getIntrinsicHeight();
    }
    return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getIntrinsicWidth();
    }
    return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
  }
  
  public int getOpacity()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getOpacity();
    }
    return -3;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float getPixelSize()
  {
    if ((this.mVectorState == null) || (this.mVectorState.mVPathRenderer == null) || (this.mVectorState.mVPathRenderer.mBaseWidth == 0.0F) || (this.mVectorState.mVPathRenderer.mBaseHeight == 0.0F) || (this.mVectorState.mVPathRenderer.mViewportHeight == 0.0F) || (this.mVectorState.mVPathRenderer.mViewportWidth == 0.0F)) {
      return 1.0F;
    }
    float f1 = this.mVectorState.mVPathRenderer.mBaseWidth;
    float f2 = this.mVectorState.mVPathRenderer.mBaseHeight;
    float f3 = this.mVectorState.mVPathRenderer.mViewportWidth;
    float f4 = this.mVectorState.mVPathRenderer.mViewportHeight;
    return Math.min(f3 / f1, f4 / f2);
  }
  
  Object getTargetByName(String paramString)
  {
    return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(paramString);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.inflate(this.mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    VectorDrawableCompat.VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    localVectorDrawableCompatState.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
    updateStateFromTypedArray(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
    localVectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
    localVectorDrawableCompatState.mCacheDirty = true;
    inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.mTintFilter = updateTintFilter(this.mTintFilter, localVectorDrawableCompatState.mTint, localVectorDrawableCompatState.mTintMode);
  }
  
  public void invalidateSelf()
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    if (this.mDelegateDrawable != null) {
      return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
    }
    return this.mVectorState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.isStateful();
    }
    return (super.isStateful()) || ((this.mVectorState != null) && (this.mVectorState.mTint != null) && (this.mVectorState.mTint.isStateful()));
  }
  
  public Drawable mutate()
  {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.mutate();
    }
    while ((this.mMutated) || (super.mutate() != this)) {
      return this;
    }
    this.mVectorState = new VectorDrawableCompat.VectorDrawableCompatState(this.mVectorState);
    this.mMutated = true;
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.setState(paramArrayOfInt);
    }
    paramArrayOfInt = this.mVectorState;
    if ((paramArrayOfInt.mTint != null) && (paramArrayOfInt.mTintMode != null))
    {
      this.mTintFilter = updateTintFilter(this.mTintFilter, paramArrayOfInt.mTint, paramArrayOfInt.mTintMode);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  void setAllowCaching(boolean paramBoolean)
  {
    this.mAllowCaching = paramBoolean;
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setAlpha(paramInt);
    }
    while (this.mVectorState.mVPathRenderer.getRootAlpha() == paramInt) {
      return;
    }
    this.mVectorState.mVPathRenderer.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setAutoMirrored(this.mDelegateDrawable, paramBoolean);
      return;
    }
    this.mVectorState.mAutoMirrored = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.mColorFilter = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
    }
    VectorDrawableCompat.VectorDrawableCompatState localVectorDrawableCompatState;
    do
    {
      return;
      localVectorDrawableCompatState = this.mVectorState;
    } while (localVectorDrawableCompatState.mTint == paramColorStateList);
    localVectorDrawableCompatState.mTint = paramColorStateList;
    this.mTintFilter = updateTintFilter(this.mTintFilter, paramColorStateList, localVectorDrawableCompatState.mTintMode);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
    }
    VectorDrawableCompat.VectorDrawableCompatState localVectorDrawableCompatState;
    do
    {
      return;
      localVectorDrawableCompatState = this.mVectorState;
    } while (localVectorDrawableCompatState.mTintMode == paramMode);
    localVectorDrawableCompatState.mTintMode = paramMode;
    this.mTintFilter = updateTintFilter(this.mTintFilter, localVectorDrawableCompatState.mTint, paramMode);
    invalidateSelf();
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat
 * JD-Core Version:    0.7.0.1
 */