package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class VectorDrawableCompat$VClipPath
  extends VectorDrawableCompat.VPath
{
  public VectorDrawableCompat$VClipPath() {}
  
  public VectorDrawableCompat$VClipPath(VClipPath paramVClipPath)
  {
    super(paramVClipPath);
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray)
  {
    String str = paramTypedArray.getString(0);
    if (str != null) {
      this.mPathName = str;
    }
    paramTypedArray = paramTypedArray.getString(1);
    if (paramTypedArray != null) {
      this.mNodes = PathParser.createNodesFromPathData(paramTypedArray);
    }
  }
  
  public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
  {
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
      return;
    }
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
    updateStateFromTypedArray(paramResources);
    paramResources.recycle();
  }
  
  public boolean isClipPath()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VClipPath
 * JD-Core Version:    0.7.0.1
 */