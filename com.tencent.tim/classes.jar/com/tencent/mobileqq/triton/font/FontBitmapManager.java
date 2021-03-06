package com.tencent.mobileqq.triton.font;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FontBitmapManager
{
  private final Map<String, Typeface> a = new HashMap();
  private TTEngine b;
  
  public FontBitmapManager(TTEngine paramTTEngine)
  {
    this.b = paramTTEngine;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    if (paramInt1 == 1) {}
    for (;;)
    {
      i = 2;
      do
      {
        if (paramInt2 != 1) {
          break;
        }
        paramInt1 = j;
        if (i == 2) {
          paramInt1 = 3;
        }
        return paramInt1;
      } while (paramInt1 != 2);
    }
    return i;
  }
  
  private Typeface a(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.a.containsKey(paramString)) && (this.a.get(paramString) != null)) {
      return (Typeface)this.a.get(paramString);
    }
    return Typeface.create(paramString, a(paramInt1, paramInt2));
  }
  
  public String a(String paramString)
  {
    int j = 0;
    if (paramString != null) {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        Object localObject2 = ((JSONObject)localObject1).optString("fontStyle");
        String str = ((JSONObject)localObject1).optString("fontWeight");
        int k = ((JSONObject)localObject1).optInt("fontSize");
        paramString = ((JSONObject)localObject1).optString("fontFamily");
        localObject1 = ((JSONObject)localObject1).optString("text");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString)))
        {
          TTLog.b("FontBitmapManager", "getTextLineHeight: invalid parameters");
          return null;
        }
        int i;
        if ("normal".equals(localObject2))
        {
          i = 0;
          if (!"normal".equals(str)) {
            break label252;
          }
        }
        for (;;)
        {
          localObject2 = new Paint(1);
          ((Paint)localObject2).setTypeface(a(i, j, paramString));
          ((Paint)localObject2).setTextSize(k);
          paramString = new Rect();
          ((Paint)localObject2).getTextBounds((String)localObject1, 0, ((String)localObject1).length(), paramString);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("lineHeight", paramString.height());
          return ((JSONObject)localObject1).toString();
          if ("italic".equals(localObject2))
          {
            i = 1;
            break;
          }
          boolean bool = "oblique".equals(localObject2);
          if (bool)
          {
            i = 2;
            break;
          }
          TTLog.d("FontBitmapManager", "getTextLineHeight: invalid font style " + (String)localObject2);
          i = 0;
          break;
          label252:
          bool = "bold".equals(str);
          if (bool) {
            j = 1;
          } else {
            TTLog.d("FontBitmapManager", "getTextLineHeight: invalid font weight " + str);
          }
        }
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public String b(String paramString)
  {
    JSONObject localJSONObject = null;
    String str = this.b.l().getResPath(paramString, null, null);
    Object localObject = localJSONObject;
    if (!TextUtils.isEmpty(str))
    {
      localObject = localJSONObject;
      if (!new File(str).exists()) {}
    }
    try
    {
      paramString = Typeface.createFromFile(str);
      localObject = localJSONObject;
      if (paramString != null)
      {
        localObject = localJSONObject;
        if (paramString != Typeface.DEFAULT)
        {
          localJSONObject = new JSONObject();
          localObject = a.a(str);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label167;
          }
          localObject = new File(str).getName().replaceFirst("\\..*$", "").replaceAll("\\s", "_");
        }
      }
    }
    catch (Exception paramString)
    {
      label167:
      for (;;)
      {
        try
        {
          localJSONObject.put("familyName", localObject);
          this.a.put(localObject, paramString);
          localObject = localJSONObject.toString();
          return localObject;
          paramString = paramString;
          TTLog.b("FontBitmapManager", "loadFont: ", paramString);
          paramString = null;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  @TTNativeCall
  public FontBitmap createBitmap(int paramInt1, int paramInt2, String paramString1, String paramString2, float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    Paint localPaint = new Paint(1);
    localPaint.setTypeface(a(paramInt1, paramInt2, paramString1));
    localPaint.setTextSize(paramFloat1);
    if (paramBoolean) {
      localPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      paramFloat1 = -localPaint.ascent();
      paramInt1 = (int)(localPaint.measureText(paramString2) + 0.5F);
      paramInt2 = (int)(localPaint.descent() + paramFloat1 + 0.5F);
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break;
      }
      paramString1 = new FontBitmap();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawText(paramString2, 0.0F, paramFloat1, localPaint);
      paramString1.bitmap = localBitmap;
      paramString1.ascent = localPaint.ascent();
      paramString1.descent = localPaint.descent();
      return paramString1;
      localPaint.setStyle(Paint.Style.STROKE);
      if (paramFloat2 > 0.0F) {
        localPaint.setStrokeWidth(paramFloat2);
      }
    }
  }
  
  @TTNativeCall
  public float measureText(int paramInt1, int paramInt2, String paramString1, String paramString2, float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return 0.0F;
    }
    Paint localPaint = new Paint(1);
    localPaint.setTypeface(a(paramInt1, paramInt2, paramString1));
    localPaint.setTextSize(paramFloat1);
    if (paramBoolean) {
      localPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      return localPaint.measureText(paramString2);
      localPaint.setStyle(Paint.Style.STROKE);
      if (paramFloat2 > 0.0F) {
        localPaint.setStrokeWidth(paramFloat2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.FontBitmapManager
 * JD-Core Version:    0.7.0.1
 */