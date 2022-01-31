package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class VectorDrawableCompat$VGroup
{
  int mChangingConfigurations;
  final ArrayList mChildren = new ArrayList();
  private String mGroupName = null;
  private final Matrix mLocalMatrix = new Matrix();
  private float mPivotX = 0.0F;
  private float mPivotY = 0.0F;
  float mRotate = 0.0F;
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private final Matrix mStackedMatrix = new Matrix();
  private int[] mThemeAttrs;
  private float mTranslateX = 0.0F;
  private float mTranslateY = 0.0F;
  
  public VectorDrawableCompat$VGroup() {}
  
  public VectorDrawableCompat$VGroup(VGroup paramVGroup, ArrayMap paramArrayMap)
  {
    this.mRotate = paramVGroup.mRotate;
    this.mPivotX = paramVGroup.mPivotX;
    this.mPivotY = paramVGroup.mPivotY;
    this.mScaleX = paramVGroup.mScaleX;
    this.mScaleY = paramVGroup.mScaleY;
    this.mTranslateX = paramVGroup.mTranslateX;
    this.mTranslateY = paramVGroup.mTranslateY;
    this.mThemeAttrs = paramVGroup.mThemeAttrs;
    this.mGroupName = paramVGroup.mGroupName;
    this.mChangingConfigurations = paramVGroup.mChangingConfigurations;
    if (this.mGroupName != null) {
      paramArrayMap.put(this.mGroupName, this);
    }
    this.mLocalMatrix.set(paramVGroup.mLocalMatrix);
    ArrayList localArrayList = paramVGroup.mChildren;
    int i = 0;
    while (i < localArrayList.size())
    {
      paramVGroup = localArrayList.get(i);
      if ((paramVGroup instanceof VGroup))
      {
        paramVGroup = (VGroup)paramVGroup;
        this.mChildren.add(new VGroup(paramVGroup, paramArrayMap));
        i += 1;
      }
      else
      {
        if ((paramVGroup instanceof VectorDrawableCompat.VFullPath)) {}
        for (paramVGroup = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)paramVGroup);; paramVGroup = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)paramVGroup))
        {
          this.mChildren.add(paramVGroup);
          if (paramVGroup.mPathName == null) {
            break;
          }
          paramArrayMap.put(paramVGroup.mPathName, paramVGroup);
          break;
          if (!(paramVGroup instanceof VectorDrawableCompat.VClipPath)) {
            break label315;
          }
        }
        label315:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
  }
  
  private void updateLocalMatrix()
  {
    this.mLocalMatrix.reset();
    this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
    this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
    this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
    this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    this.mThemeAttrs = null;
    this.mRotate = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "rotation", 5, this.mRotate);
    this.mPivotX = paramTypedArray.getFloat(1, this.mPivotX);
    this.mPivotY = paramTypedArray.getFloat(2, this.mPivotY);
    this.mScaleX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.mScaleX);
    this.mScaleY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.mScaleY);
    this.mTranslateX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateX", 6, this.mTranslateX);
    this.mTranslateY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateY", 7, this.mTranslateY);
    paramTypedArray = paramTypedArray.getString(0);
    if (paramTypedArray != null) {
      this.mGroupName = paramTypedArray;
    }
    updateLocalMatrix();
  }
  
  public String getGroupName()
  {
    return this.mGroupName;
  }
  
  public Matrix getLocalMatrix()
  {
    return this.mLocalMatrix;
  }
  
  public float getPivotX()
  {
    return this.mPivotX;
  }
  
  public float getPivotY()
  {
    return this.mPivotY;
  }
  
  public float getRotation()
  {
    return this.mRotate;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public float getTranslateX()
  {
    return this.mTranslateX;
  }
  
  public float getTranslateY()
  {
    return this.mTranslateY;
  }
  
  public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
  {
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
    updateStateFromTypedArray(paramResources, paramXmlPullParser);
    paramResources.recycle();
  }
  
  public void setPivotX(float paramFloat)
  {
    if (paramFloat != this.mPivotX)
    {
      this.mPivotX = paramFloat;
      updateLocalMatrix();
    }
  }
  
  public void setPivotY(float paramFloat)
  {
    if (paramFloat != this.mPivotY)
    {
      this.mPivotY = paramFloat;
      updateLocalMatrix();
    }
  }
  
  public void setRotation(float paramFloat)
  {
    if (paramFloat != this.mRotate)
    {
      this.mRotate = paramFloat;
      updateLocalMatrix();
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    if (paramFloat != this.mScaleX)
    {
      this.mScaleX = paramFloat;
      updateLocalMatrix();
    }
  }
  
  public void setScaleY(float paramFloat)
  {
    if (paramFloat != this.mScaleY)
    {
      this.mScaleY = paramFloat;
      updateLocalMatrix();
    }
  }
  
  public void setTranslateX(float paramFloat)
  {
    if (paramFloat != this.mTranslateX)
    {
      this.mTranslateX = paramFloat;
      updateLocalMatrix();
    }
  }
  
  public void setTranslateY(float paramFloat)
  {
    if (paramFloat != this.mTranslateY)
    {
      this.mTranslateY = paramFloat;
      updateLocalMatrix();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VGroup
 * JD-Core Version:    0.7.0.1
 */