package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i
{
  public static final byte[] a = { 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 1, 0, 0, 0 };
  
  static Bitmap a(Resources paramResources, TypedValue paramTypedValue, InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    int i;
    if ((localOptions.inDensity == 0) && (paramTypedValue != null))
    {
      i = paramTypedValue.density;
      if (i != 0) {
        break label81;
      }
      localOptions.inDensity = 160;
    }
    for (;;)
    {
      if ((localOptions.inTargetDensity == 0) && (paramResources != null)) {
        localOptions.inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      }
      return BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
      label81:
      if (i != 65535) {
        localOptions.inDensity = i;
      }
    }
  }
  
  static SkinnableBitmapDrawable.a a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet1, AttributeSet paramAttributeSet2, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (str.equals("bitmap")) {
      return SkinnableBitmapDrawable.a(paramResources, paramXmlPullParser, paramAttributeSet1, paramAttributeSet2, paramBoolean);
    }
    throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid drawable tag " + str);
  }
  
  static SkinnableColorStateList a(SkinEngine paramSkinEngine, Resources paramResources, File paramFile, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    long l1 = SystemClock.uptimeMillis();
    if (paramBoolean) {}
    for (Object localObject = new a();; localObject = Xml.newPullParser())
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ((XmlPullParser)localObject).setInput(localFileInputStream, "UTF-8");
      paramSkinEngine = SkinnableColorStateList.createFromXml(paramSkinEngine, paramResources, (XmlPullParser)localObject, paramBoolean);
      localFileInputStream.close();
      if (SkinEngine.DEBUG)
      {
        long l2 = SystemClock.uptimeMillis();
        Log.d("SkinEngine", "load colorList:" + paramFile.toString() + " , cost:" + (l2 - l1));
      }
      return paramSkinEngine;
    }
  }
  
  static b a(Resources paramResources, TypedValue paramTypedValue, InputStream paramInputStream, String paramString, BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean)
    throws IOException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool = false;
    if (paramInputStream == null) {
      paramInputStream = localObject2;
    }
    do
    {
      return paramInputStream;
      BitmapFactory.Options localOptions = paramOptions;
      if (paramOptions == null) {
        localOptions = new BitmapFactory.Options();
      }
      localOptions.inScreenDensity = paramResources.getDisplayMetrics().densityDpi;
      if ((paramInputStream instanceof FileInputStream))
      {
        localOptions.inScaled = paramBoolean;
        paramTypedValue = a(paramResources, paramTypedValue, paramInputStream, paramRect, localOptions);
      }
      while (localOptions.inJustDecodeBounds)
      {
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        int k = localOptions.inDensity;
        paramTypedValue = new int[3];
        paramTypedValue[0] = i;
        paramTypedValue[1] = j;
        paramTypedValue[2] = k;
        if (paramString.endsWith(".9.png"))
        {
          paramInputStream = new SkinnableNinePatchDrawable.a(null, null, new Rect(0, 0, 0, 0));
          paramInputStream.h = paramTypedValue;
          if (paramResources != null) {
            paramInputStream.n = paramResources.getDisplayMetrics().densityDpi;
          }
          return paramInputStream;
          try
          {
            paramTypedValue = BitmapFactory.decodeResourceStream(paramResources, paramTypedValue, paramInputStream, paramRect, localOptions);
          }
          catch (NullPointerException paramTypedValue)
          {
            paramTypedValue = null;
          }
        }
        else
        {
          paramInputStream = new SkinnableBitmapDrawable.a((Bitmap)null);
          paramInputStream.h = paramTypedValue;
          if (paramResources != null) {
            paramInputStream.o = paramResources.getDisplayMetrics().densityDpi;
          }
          return paramInputStream;
        }
      }
      paramInputStream = localObject2;
    } while (paramTypedValue == null);
    if (paramString.endsWith(".9.png")) {
      if (paramBoolean)
      {
        paramInputStream = paramTypedValue.getNinePatchChunk();
        if ((paramInputStream != null) && (NinePatch.isNinePatchChunk(paramInputStream))) {
          break label493;
        }
        paramInputStream = a(paramTypedValue);
        paramRect = new Rect();
      }
    }
    label493:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramTypedValue = new SkinnableNinePatchDrawable.a(new NinePatch(paramTypedValue, paramInputStream, paramString), paramTypedValue, paramRect);
      if (paramResources != null) {
        paramTypedValue.n = paramResources.getDisplayMetrics().densityDpi;
      }
      paramTypedValue.g = paramBoolean;
      return paramTypedValue;
      try
      {
        paramInputStream = a(paramTypedValue, paramRect);
        if ((paramInputStream == null) || (!NinePatch.isNinePatchChunk(paramInputStream)))
        {
          paramInputStream = a(paramTypedValue);
          paramRect = new Rect();
          paramBoolean = true;
          paramTypedValue = new SkinnableNinePatchDrawable.a(new NinePatch(paramTypedValue, paramInputStream, paramString), paramTypedValue, paramRect);
          paramTypedValue.g = paramBoolean;
          if (paramResources != null) {
            paramTypedValue.n = paramResources.getDisplayMetrics().densityDpi;
          }
          return paramTypedValue;
        }
      }
      catch (IllegalArgumentException paramOptions)
      {
        for (;;)
        {
          paramInputStream = localObject1;
          if (SkinEngine.DEBUG)
          {
            Log.e("SkinEngine", "", paramOptions);
            paramInputStream = localObject1;
            continue;
            paramOptions = Bitmap.createBitmap(paramTypedValue, 1, 1, paramTypedValue.getWidth() - 2, paramTypedValue.getHeight() - 2);
            paramTypedValue.recycle();
            paramTypedValue = paramOptions;
            paramBoolean = bool;
          }
        }
      }
      paramTypedValue = new SkinnableBitmapDrawable.a(paramTypedValue);
      paramInputStream = paramTypedValue;
      if (paramResources == null) {
        break;
      }
      paramTypedValue.o = paramResources.getDisplayMetrics().densityDpi;
      return paramTypedValue;
    }
  }
  
  static b a(Resources paramResources, XmlPullParser paramXmlPullParser1, XmlPullParser paramXmlPullParser2, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet1 = Xml.asAttributeSet(paramXmlPullParser1);
    int i;
    do
    {
      i = paramXmlPullParser1.next();
    } while ((i != 2) && (i != 1));
    if (paramXmlPullParser2 == null) {
      if (i != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    AttributeSet localAttributeSet2;
    for (paramResources = a(paramResources, paramXmlPullParser1, localAttributeSet1, null, paramBoolean); paramResources == null; paramResources = a(paramResources, paramXmlPullParser1, localAttributeSet1, localAttributeSet2, paramBoolean))
    {
      throw new RuntimeException("Unknown initial tag: " + paramXmlPullParser1.getName());
      localAttributeSet2 = Xml.asAttributeSet(paramXmlPullParser2);
      do
      {
        i = paramXmlPullParser2.next();
      } while ((i != 2) && (i != 1));
      if (i != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    return paramResources;
  }
  
  static byte[] a(Bitmap paramBitmap)
  {
    byte[] arrayOfByte = new byte[a.length];
    System.arraycopy(a, 0, arrayOfByte, 0, a.length);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(36);
    localByteBuffer.putInt(paramBitmap.getWidth());
    localByteBuffer.position(44);
    localByteBuffer.putInt(paramBitmap.getHeight());
    return arrayOfByte;
  }
  
  static byte[] a(Bitmap paramBitmap, Rect paramRect)
    throws IllegalArgumentException, IOException
  {
    int j = paramBitmap.getWidth();
    int i3 = paramBitmap.getHeight();
    if ((j <= 2) || (i3 <= 2)) {
      throw new IllegalArgumentException("not a nine-path bitmap");
    }
    Object localObject1 = new ByteArrayOutputStream(83);
    Object localObject2 = new DataOutputStream((OutputStream)localObject1);
    int i = 0;
    while (i < 32)
    {
      ((DataOutputStream)localObject2).write(0);
      i += 1;
    }
    int[] arrayOfInt = new int[j - 2];
    paramBitmap.getPixels(arrayOfInt, 0, j, 1, 0, j - 2, 1);
    int n;
    int m;
    label127:
    int i4;
    int i1;
    label139:
    int i2;
    int k;
    if (arrayOfInt[0] == -16777216)
    {
      n = 1;
      if (arrayOfInt[(arrayOfInt.length - 1)] != -16777216) {
        break label219;
      }
      m = 1;
      j = 0;
      i4 = arrayOfInt.length;
      i1 = 0;
      i = 0;
      if (i1 >= i4) {
        break label262;
      }
      i2 = arrayOfInt[i1];
      k = i2;
      if (i2 == -65536) {
        k = 0;
      }
      if ((k != -16777216) && (k != 0)) {
        break label225;
      }
      if (j == k) {
        break label1226;
      }
      i += 1;
      ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(i1));
    }
    for (;;)
    {
      i1 += 1;
      j = k;
      break label139;
      n = 0;
      break;
      label219:
      m = 0;
      break label127;
      label225:
      throw new IllegalArgumentException("Ticks in transparent frame must be black or red. Fount at pixel #" + (i1 + 1) + " along top edge");
      label262:
      j = i;
      if (m != 0)
      {
        j = i + 1;
        ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(arrayOfInt.length));
      }
      i = j + 1;
      if (n != 0) {
        i -= 1;
      }
      for (;;)
      {
        if (m != 0) {}
        for (k = i - 1;; k = i)
        {
          arrayOfInt = new int[i3 - 2];
          paramBitmap.getPixels(arrayOfInt, 0, 1, 0, 1, 1, i3 - 2);
          if (arrayOfInt[0] == -16777216)
          {
            n = 1;
            if (arrayOfInt[(arrayOfInt.length - 1)] != -16777216) {
              break label476;
            }
          }
          int i5;
          label476:
          for (m = 1;; m = 0)
          {
            i5 = arrayOfInt.length;
            i1 = 0;
            i2 = 0;
            for (i = 0;; i = i3)
            {
              if (i1 >= i5) {
                break label519;
              }
              i4 = arrayOfInt[i1];
              i3 = i4;
              if (i4 == -65536) {
                i3 = 0;
              }
              if ((i3 != -16777216) && (i3 != 0)) {
                break;
              }
              i4 = i2;
              i3 = i;
              if (i2 != arrayOfInt[i1])
              {
                i3 = i + 1;
                ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(i1));
                i4 = arrayOfInt[i1];
              }
              i1 += 1;
              i2 = i4;
            }
            n = 0;
            break;
          }
          throw new IllegalArgumentException("Ticks in transparent frame must be black or red. Fount at pixel #" + (i1 + 1) + " along left edge");
          label519:
          i1 = i;
          if (m != 0)
          {
            i1 = i + 1;
            ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(arrayOfInt.length));
          }
          i = i1 + 1;
          if (n != 0) {
            i -= 1;
          }
          for (;;)
          {
            n = i;
            if (m != 0) {
              n = i - 1;
            }
            i = 0;
            while (i < k * n)
            {
              ((DataOutputStream)localObject2).writeInt(16777216);
              i += 1;
            }
            localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
            localObject1[0] = 1;
            localObject1[1] = ((byte)j);
            localObject1[2] = ((byte)i1);
            localObject1[3] = ((byte)(n * k));
            i = -1;
            j = -1;
            localObject2 = new int[paramBitmap.getWidth() - 2];
            paramBitmap.getPixels((int[])localObject2, 0, localObject2.length, 1, paramBitmap.getHeight() - 1, localObject2.length, 1);
            i2 = 0;
            k = 0;
            if (k < localObject2.length)
            {
              n = localObject2[k];
              m = n;
              if (n == -65536) {
                m = 0;
              }
              if ((m != -16777216) && (m != 0)) {
                break label1211;
              }
              if ((-16777216 == m) && (m != i2)) {
                if (i == -1)
                {
                  i1 = k;
                  n = j;
                  label742:
                  i = i1;
                  j = n;
                  i2 = m;
                }
              }
            }
            label1028:
            label1065:
            label1211:
            for (;;)
            {
              k += 1;
              break;
              throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (k + 1) + " along bottom edge.");
              n = j;
              i1 = i;
              if (m != 0) {
                break label742;
              }
              n = j;
              i1 = i;
              if (m == i2) {
                break label742;
              }
              if (j == -1)
              {
                n = localObject2.length - k;
                i1 = i;
                break label742;
              }
              throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (k + 1) + " along bottom edge.");
              localObject2 = new int[paramBitmap.getHeight() - 2];
              paramBitmap.getPixels((int[])localObject2, 0, 1, paramBitmap.getWidth() - 1, 0, 1, localObject2.length);
              m = 0;
              i4 = 0;
              n = -1;
              k = -1;
              if (m < localObject2.length)
              {
                i2 = localObject2[m];
                i1 = i2;
                if (i2 == -65536) {
                  i1 = 0;
                }
                if (i1 != -16777216)
                {
                  i5 = i4;
                  i2 = n;
                  i3 = k;
                  if (i1 != 0) {}
                }
                else
                {
                  if ((-16777216 != i1) || (i1 == i4)) {
                    break label1065;
                  }
                  if (k != -1) {
                    break label1028;
                  }
                  i3 = m;
                  i2 = n;
                }
                for (;;)
                {
                  i5 = i1;
                  m += 1;
                  i4 = i5;
                  n = i2;
                  k = i3;
                  break;
                  throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (m + 1) + " along right edge.");
                  i2 = n;
                  i3 = k;
                  if (i1 == 0)
                  {
                    i2 = n;
                    i3 = k;
                    if (i1 != i4)
                    {
                      if (n != -1) {
                        break label1114;
                      }
                      i2 = localObject2.length - m;
                      i3 = k;
                    }
                  }
                }
                label1114:
                throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (m + 1) + " along bottom edge.");
              }
              paramBitmap = ByteBuffer.wrap((byte[])localObject1);
              paramBitmap.order(ByteOrder.LITTLE_ENDIAN);
              paramBitmap.position(12);
              paramBitmap.putInt(i);
              paramBitmap.putInt(j);
              paramBitmap.putInt(k);
              paramBitmap.putInt(n);
              paramRect.set(i, k, j, n);
              return localObject1;
            }
          }
        }
      }
      label1226:
      k = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.theme.i
 * JD-Core Version:    0.7.0.1
 */