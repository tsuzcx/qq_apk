package android.support.v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class AppCompatColorStateListInflater
{
  private static final int DEFAULT_COLOR = -65536;
  
  @NonNull
  public static ColorStateList createFromXml(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme)
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    return createFromXmlInner(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
  }
  
  @NonNull
  private static ColorStateList createFromXmlInner(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector")) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
    }
    return inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  private static ColorStateList inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    int n = paramXmlPullParser.getDepth() + 1;
    Object localObject1 = new int[20][];
    int[] arrayOfInt = new int[localObject1.length];
    int j = 0;
    int i;
    int k;
    do
    {
      i = paramXmlPullParser.next();
      if (i == 1) {
        break;
      }
      k = paramXmlPullParser.getDepth();
      if ((k < n) && (i == 3)) {
        break;
      }
    } while ((i != 2) || (k > n) || (!paramXmlPullParser.getName().equals("item")));
    Object localObject2 = obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
    int i1 = ((TypedArray)localObject2).getColor(R.styleable.ColorStateListItem_android_color, -65281);
    float f = 1.0F;
    label137:
    label162:
    int m;
    if (((TypedArray)localObject2).hasValue(R.styleable.ColorStateListItem_android_alpha))
    {
      f = ((TypedArray)localObject2).getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
      ((TypedArray)localObject2).recycle();
      i = 0;
      int i2 = paramAttributeSet.getAttributeCount();
      localObject2 = new int[i2];
      k = 0;
      if (k >= i2) {
        break label268;
      }
      m = paramAttributeSet.getAttributeNameResource(k);
      if ((m == 16843173) || (m == 16843551) || (m == R.attr.alpha)) {
        break label372;
      }
      if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
        break label260;
      }
      label213:
      localObject2[i] = m;
      i += 1;
    }
    label260:
    label268:
    label372:
    for (;;)
    {
      k += 1;
      break label162;
      if (!((TypedArray)localObject2).hasValue(R.styleable.ColorStateListItem_alpha)) {
        break label137;
      }
      f = ((TypedArray)localObject2).getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
      break label137;
      m = -m;
      break label213;
      localObject2 = StateSet.trimStateSet((int[])localObject2, i);
      i = modulateColorAlpha(i1, f);
      if ((j != 0) && (localObject2.length == 0)) {}
      arrayOfInt = GrowingArrayUtils.append(arrayOfInt, j, i);
      localObject1 = (int[][])GrowingArrayUtils.append((Object[])localObject1, j, localObject2);
      j += 1;
      break;
      paramResources = new int[j];
      paramXmlPullParser = new int[j][];
      System.arraycopy(arrayOfInt, 0, paramResources, 0, j);
      System.arraycopy(localObject1, 0, paramXmlPullParser, 0, j);
      return new ColorStateList(paramXmlPullParser, paramResources);
    }
  }
  
  private static int modulateColorAlpha(int paramInt, float paramFloat)
  {
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.content.res.AppCompatColorStateListInflater
 * JD-Core Version:    0.7.0.1
 */