package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import d.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat
{
  @NonNull
  public static ColorStateList createFromXml(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
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
  public static ColorStateList createFromXmlInner(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector")) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
    }
    return inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  @Nullable
  public static ColorStateList inflate(@NonNull Resources paramResources, @XmlRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      paramResources = createFromXml(paramResources, paramResources.getXml(paramInt), paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("CSLCompat", "Failed to inflate ColorStateList.", paramResources);
    }
    return null;
  }
  
  private static ColorStateList inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
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
    Object localObject2 = obtainAttributes(paramResources, paramTheme, paramAttributeSet, d.a.ColorStateListItem);
    int i1 = ((TypedArray)localObject2).getColor(d.a.ColorStateListItem_android_color, -65281);
    float f = 1.0F;
    label137:
    label162:
    int m;
    if (((TypedArray)localObject2).hasValue(d.a.ColorStateListItem_android_alpha))
    {
      f = ((TypedArray)localObject2).getFloat(d.a.ColorStateListItem_android_alpha, 1.0F);
      ((TypedArray)localObject2).recycle();
      i = 0;
      int i2 = paramAttributeSet.getAttributeCount();
      localObject2 = new int[i2];
      k = 0;
      if (k >= i2) {
        break label267;
      }
      m = paramAttributeSet.getAttributeNameResource(k);
      if ((m == 16843173) || (m == 16843551) || (m == 2131034191)) {
        break label356;
      }
      if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
        break label259;
      }
      label212:
      localObject2[i] = m;
      i += 1;
    }
    label259:
    label267:
    label356:
    for (;;)
    {
      k += 1;
      break label162;
      if (!((TypedArray)localObject2).hasValue(d.a.ColorStateListItem_alpha)) {
        break label137;
      }
      f = ((TypedArray)localObject2).getFloat(d.a.ColorStateListItem_alpha, 1.0F);
      break label137;
      m = -m;
      break label212;
      localObject2 = StateSet.trimStateSet((int[])localObject2, i);
      arrayOfInt = GrowingArrayUtils.append(arrayOfInt, j, modulateColorAlpha(i1, f));
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
  
  @ColorInt
  private static int modulateColorAlpha(@ColorInt int paramInt, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return Math.round(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.res.ColorStateListInflaterCompat
 * JD-Core Version:    0.7.0.1
 */