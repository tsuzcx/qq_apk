package com.tencent.theme;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinnableColorStateList
  extends ColorStateList
{
  public static final Parcelable.Creator<ColorStateList> CREATOR = new Parcelable.Creator()
  {
    public ColorStateList a(Parcel paramAnonymousParcel)
    {
      int j = paramAnonymousParcel.readInt();
      int[][] arrayOfInt = new int[j][];
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = paramAnonymousParcel.createIntArray();
        i += 1;
      }
      return new ColorStateList(arrayOfInt, paramAnonymousParcel.createIntArray());
    }
    
    public ColorStateList[] a(int paramAnonymousInt)
    {
      return new ColorStateList[paramAnonymousInt];
    }
  };
  private static final int[][] d = { new int[0] };
  private static final int[][] e = new int[0][];
  private int[][] a;
  private int[] b;
  private int c = -65536;
  public i skinData;
  
  public SkinnableColorStateList(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
  {
    super(e, null);
    this.a = paramArrayOfInt;
    this.b = paramArrayOfInt1;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.c = paramArrayOfInt1[0];
      while (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i].length == 0) {
          this.c = paramArrayOfInt1[i];
        }
        i += 1;
      }
    }
  }
  
  private int a(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private static SkinnableColorStateList a(SkinEngine paramSkinEngine, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("selector"))
    {
      localObject = new SkinnableColorStateList((int[][])null, null);
      ((SkinnableColorStateList)localObject).b(paramSkinEngine, paramResources, paramXmlPullParser, paramAttributeSet, paramBoolean);
      return localObject;
    }
    throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid drawable tag " + (String)localObject);
  }
  
  private void b(SkinEngine paramSkinEngine, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    int i4 = paramXmlPullParser.getDepth() + 1;
    int i1 = 20;
    int n = 0;
    Object localObject1 = new int[20];
    paramResources = new int[20][];
    int i;
    int j;
    int m;
    int k;
    Object localObject2;
    int i2;
    int i3;
    label150:
    label172:
    Object localObject3;
    for (;;)
    {
      i = paramXmlPullParser.next();
      if (i == 1) {
        break label1031;
      }
      j = paramXmlPullParser.getDepth();
      if ((j < i4) && (i == 3)) {
        break label1031;
      }
      if ((i == 2) && (j <= i4) && (paramXmlPullParser.getName().equals("item")))
      {
        m = 0;
        j = -65536;
        k = 0;
        i = 0;
        int i5 = paramAttributeSet.getAttributeCount();
        localObject2 = new int[i5];
        i2 = 0;
        if (i2 < i5)
        {
          if (!paramBoolean) {
            break label403;
          }
          i3 = paramAttributeSet.getAttributeNameResource(i2);
          if (i3 != 0) {
            break;
          }
        }
        int[] arrayOfInt = StateSet.trimStateSet((int[])localObject2, i);
        if (m == 0) {
          break label994;
        }
        j = paramSkinEngine.getColor(m);
        if ((n == 0) || (arrayOfInt.length == 0)) {
          this.c = j;
        }
        localObject3 = paramResources;
        localObject2 = localObject1;
        i = i1;
        if (n + 1 >= i1)
        {
          i = a(n + 1);
          localObject2 = new int[i];
          System.arraycopy(localObject1, 0, localObject2, 0, n);
          localObject1 = new int[i][];
          System.arraycopy(paramResources, 0, localObject1, 0, n);
          paramResources = (Resources)localObject1;
          localObject3 = paramResources;
        }
        localObject2[n] = j;
        localObject3[n] = arrayOfInt;
        n += 1;
        paramResources = (Resources)localObject3;
        localObject1 = localObject2;
        i1 = i;
      }
    }
    if (i3 == 16843173)
    {
      m = paramAttributeSet.getAttributeResourceValue(i2, 0);
      if (m != 0) {
        break label1074;
      }
      k = paramAttributeSet.getAttributeIntValue(i2, j);
      j = 1;
    }
    for (;;)
    {
      i3 = j;
      j = k;
      for (k = i3;; k = 1)
      {
        i2 += 1;
        break;
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (;;)
        {
          localObject2[i] = i3;
          i += 1;
          i3 = j;
          j = k;
          k = i3;
          break;
          i3 = -i3;
        }
        label403:
        localObject3 = paramAttributeSet.getAttributeName(i2);
        if (!"color".equals(localObject3)) {
          break label444;
        }
        j = Color.parseColor(paramAttributeSet.getAttributeValue(i2));
      }
      label444:
      if ("state_window_focused".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16842909;; i3 = -16842909)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_selected".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16842913;; i3 = -16842913)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_focused".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16842908;; i3 = -16842908)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_enabled".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16842910;; i3 = -16842910)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_pressed".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16842919;; i3 = -16842919)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_checked".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16842912;; i3 = -16842912)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_activated".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16843518;; i3 = -16843518)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_accelerated".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16843547;; i3 = -16843547)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_hovered".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16843623;; i3 = -16843623)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if ("state_drag_can_accept".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
        for (i3 = 16843624;; i3 = -16843624)
        {
          localObject2[i] = i3;
          i += 1;
          break;
        }
      }
      if (!"state_drag_hovered".equals(localObject3)) {
        break label150;
      }
      if (paramAttributeSet.getAttributeBooleanValue(i2, false)) {}
      for (i3 = 16843625;; i3 = -16843625)
      {
        localObject2[i] = i3;
        i += 1;
        break;
      }
      label994:
      if (k != 0) {
        break label172;
      }
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'android:color' attribute.");
      label1031:
      this.b = new int[n];
      this.a = new int[n][];
      System.arraycopy(localObject1, 0, this.b, 0, n);
      System.arraycopy(paramResources, 0, this.a, 0, n);
      return;
      label1074:
      i3 = j;
      j = k;
      k = i3;
    }
  }
  
  public static SkinnableColorStateList createFromXml(SkinEngine paramSkinEngine, Resources paramResources, XmlPullParser paramXmlPullParser, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet;
    try
    {
      localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      int i;
      do
      {
        i = paramXmlPullParser.next();
      } while ((i != 2) && (i != 1));
      if (i != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (Exception paramSkinEngine)
    {
      if (SkinEngine.DEBUG) {
        Log.e("SkinEngine", "", paramSkinEngine);
      }
      return new SkinnableColorStateList(d, new int[] { -65281 });
    }
    paramSkinEngine = a(paramSkinEngine, paramResources, paramXmlPullParser, localAttributeSet, paramBoolean);
    return paramSkinEngine;
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  void a(SkinnableColorStateList paramSkinnableColorStateList)
  {
    this.a = paramSkinnableColorStateList.a;
    this.b = paramSkinnableColorStateList.b;
    this.c = paramSkinnableColorStateList.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getColorForState(int[] paramArrayOfInt, int paramInt)
  {
    int k = this.a.length;
    int i = 0;
    for (;;)
    {
      int j = paramInt;
      if (i < k)
      {
        if (StateSet.stateSetMatches(this.a[i], paramArrayOfInt)) {
          j = this.b[i];
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int getDefaultColor()
  {
    return this.c;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public String toString()
  {
    return "ColorStateList{mStateSpecs=" + Arrays.deepToString(this.a) + "mColors=" + Arrays.toString(this.b) + "mDefaultColor=" + this.c + '}';
  }
  
  public ColorStateList withAlpha(int paramInt)
  {
    int[] arrayOfInt = new int[this.b.length];
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = (this.b[i] & 0xFFFFFF | paramInt << 24);
      i += 1;
    }
    return new ColorStateList(this.a, arrayOfInt);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.a.length;
    paramParcel.writeInt(i);
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeIntArray(this.a[paramInt]);
      paramInt += 1;
    }
    paramParcel.writeIntArray(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableColorStateList
 * JD-Core Version:    0.7.0.1
 */