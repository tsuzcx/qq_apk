import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anyk
{
  private int JO;
  private anyk.a jdField_a_of_type_Anyk$a;
  private anyk.b jdField_a_of_type_Anyk$b;
  private anyk.c jdField_a_of_type_Anyk$c;
  private anyk.d jdField_a_of_type_Anyk$d;
  private anyk.e jdField_a_of_type_Anyk$e;
  private String alm = "";
  private boolean cKE;
  private anyo.a d;
  private float mScale;
  
  public static boolean E(File paramFile)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (paramFile.exists())
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append("check.ini");
      localObject = new File(localStringBuffer.toString());
      if (((File)localObject).exists()) {}
    }
    else
    {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = aqhq.readFileToString((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("&");
        if (localObject == null) {
          break;
        }
        i = 0;
        if (i >= localObject.length) {
          break label219;
        }
        if (localObject[i].startsWith("﻿")) {
          localObject[i] = localObject[i].replace("﻿", "");
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append(localObject[i]);
        File localFile = new File(localStringBuffer.toString());
        if (localFile.exists()) {
          break label212;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SceneBuilder", 2, "isAnimationPackageValid File not exist:" + localFile.getName());
        return false;
      }
      catch (IOException paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SceneBuilder", 2, "isAnimationPackageValid IOException");
      return false;
      label212:
      i += 1;
    }
    label219:
    return true;
  }
  
  private anxu a(anxz paramanxz, JSONObject paramJSONObject)
  {
    int n;
    Object localObject1;
    Object localObject3;
    label38:
    Object localObject2;
    int i1;
    int i;
    Paint localPaint;
    Object localObject5;
    int k;
    Object localObject4;
    int i4;
    if ((paramanxz instanceof SpriteGLView))
    {
      n = 4;
      localObject1 = paramJSONObject.optString("text");
      if (!(paramanxz instanceof SpriteGLView)) {
        break label772;
      }
      localObject3 = new anyu((SpriteGLView)paramanxz);
      ((anxu)localObject3).setScale(1.0F / n);
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Anyk$d != null) {
        localObject2 = this.jdField_a_of_type_Anyk$d.a((anxy)localObject3, (String)localObject1);
      }
      i1 = paramJSONObject.optInt("textSize", 20) * n;
      i = Color.parseColor(paramJSONObject.optString("textColor"));
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(i);
      localPaint.setTextSize(i1);
      localObject5 = paramJSONObject.optJSONObject("size");
      k = (int)localPaint.measureText((String)localObject2);
      localObject4 = paramJSONObject.optString("imageRight");
      i4 = paramJSONObject.optInt("imagePadding") * n;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label973;
      }
      if (this.jdField_a_of_type_Anyk$c == null) {
        break label967;
      }
      localObject1 = this.jdField_a_of_type_Anyk$c.a((anxy)localObject3, this.alm, (String)localObject4);
      label205:
      if (localObject1 != null) {
        break label826;
      }
    }
    label772:
    label826:
    label958:
    label967:
    label973:
    for (;;)
    {
      int j;
      int m;
      int i2;
      float f2;
      float f1;
      float f6;
      float f3;
      float f5;
      try
      {
        localObject4 = aqhu.d(this.alm + "/" + (String)localObject4, null);
        localObject1 = localObject4;
        if (localObject1 == null) {
          break label958;
        }
        i = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
        j *= n;
        i *= n;
        if (localObject5 == null) {
          break label947;
        }
        if (((JSONObject)localObject5).optInt("width") == 0) {
          break label944;
        }
        k = ((JSONObject)localObject5).optInt("width") * n;
        if (((JSONObject)localObject5).optInt("height") == 0) {
          break label937;
        }
        m = ((JSONObject)localObject5).optInt("height") * n;
        if (this.jdField_a_of_type_Anyk$d != null) {
          this.jdField_a_of_type_Anyk$d.a(k - i - i4, (String)localObject2, localPaint);
        }
        localObject2 = a(k - i - i4, (String)localObject2, localPaint);
        i2 = m;
        m = k;
        if (this.jdField_a_of_type_Anyk$d == null) {
          break label931;
        }
        k = this.jdField_a_of_type_Anyk$d.a(m, i, i4, (String)localObject2, localPaint);
        i3 = k;
        if (k == 0) {
          i3 = (int)localPaint.measureText((String)localObject2);
        }
        i = i + i3 + i4;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int i3;
        float f7;
        float f4;
        if (QLog.isColorLevel()) {
          QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(localOutOfMemoryError));
        }
      }
      try
      {
        localObject4 = Bitmap.createBitmap(m, i2, Bitmap.Config.ARGB_8888);
        localObject5 = new Canvas((Bitmap)localObject4);
        ((Canvas)localObject5).drawColor(-16777216, PorterDuff.Mode.CLEAR);
        f7 = i1 * 0.8F;
        f2 = 0.0F;
        f1 = 0.0F;
        f4 = 0.0F;
        f6 = 0.0F;
        f3 = 0.0F;
        f5 = 0.0F;
        paramJSONObject = paramJSONObject.optString("gravity");
        if (paramJSONObject == null) {
          break label925;
        }
        if (!paramJSONObject.contains("left")) {
          break label868;
        }
        f1 = 0.0F;
        if (!paramJSONObject.contains("top")) {
          break label888;
        }
        f2 = 0.0F;
        f3 = f5;
        f4 = f2;
        if (paramJSONObject.equals("center"))
        {
          f1 = (m - i) / 2;
          f4 = (i2 - i1) / 2;
          f3 = (i2 - j) / 2;
        }
        if (paramJSONObject.contains("center_horizontal")) {
          f1 = (m - i) / 2;
        }
        f2 = f1;
        if (!paramJSONObject.contains("center_vertical")) {
          break label925;
        }
        f2 = (i2 - i1) / 2;
        f3 = (i2 - j) / 2;
        f4 = f2;
        f2 = f1;
        f1 = f3;
        if ((this.jdField_a_of_type_Anyk$d == null) || (!this.jdField_a_of_type_Anyk$d.a((Canvas)localObject5, (String)localObject2, f2, f4, f7, m, i2, localPaint))) {
          ((Canvas)localObject5).drawText((String)localObject2, f2, f4 + f7, localPaint);
        }
        if (localObject1 != null)
        {
          paramJSONObject = new Matrix();
          paramJSONObject.postScale(n, n);
          f3 = i4;
          paramJSONObject.postTranslate(i3 + (f3 + f2), f1);
          ((Canvas)localObject5).drawBitmap((Bitmap)localObject1, paramJSONObject, localPaint);
        }
        ((anxy)localObject3).a(paramanxz, (Bitmap)localObject4);
      }
      catch (OutOfMemoryError paramanxz)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(paramanxz));
        return localObject3;
      }
      return localObject3;
      n = 1;
      break;
      localObject3 = new anza((SpriteNativeView)paramanxz);
      break label38;
      continue;
      label868:
      if (paramJSONObject.contains("right"))
      {
        f1 = m - i;
        continue;
        label888:
        f3 = f5;
        f2 = f6;
        if (paramJSONObject.contains("bottom"))
        {
          f2 = i2 - i1;
          f3 = i2 - j;
          continue;
          f1 = f3;
          continue;
          k = 0;
          continue;
          m = i1;
          continue;
          continue;
          i2 = i1;
          m = k;
          continue;
          j = 0;
          i = 0;
          continue;
          localObject1 = null;
          break label205;
          localObject1 = null;
          j = 0;
          i = 0;
        }
      }
    }
  }
  
  private anxu a(anxz paramanxz, JSONObject paramJSONObject, anxx paramanxx)
    throws JSONException
  {
    Object localObject1 = null;
    Object localObject3 = paramJSONObject.optString("type");
    if ("layer".equals(localObject3)) {
      if ((paramanxz instanceof SpriteGLView)) {
        localObject1 = new anys((SpriteGLView)paramanxz);
      }
    }
    Object localObject6;
    label134:
    int i;
    int j;
    label412:
    label457:
    Object localObject2;
    while (localObject1 == null)
    {
      localObject3 = null;
      return localObject3;
      localObject1 = new anyy((SpriteNativeView)paramanxz);
      continue;
      if ("image".equals(localObject3))
      {
        localObject1 = null;
        Object localObject4 = paramJSONObject.optString("path");
        localObject6 = paramJSONObject.optString("event");
        if ((paramanxz instanceof SpriteGLView))
        {
          localObject3 = (SpriteGLView)paramanxz;
          if (TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject3 = new anyu((SpriteGLView)localObject3);
            if (this.jdField_a_of_type_Anyk$c != null) {
              localObject1 = this.jdField_a_of_type_Anyk$c.a((anxy)localObject3, this.alm, (String)localObject4);
            }
            if (localObject1 != null) {
              break label412;
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject4 = aqhu.d(this.alm + "/" + (String)localObject4, null);
              localObject1 = localObject3;
              if (localObject4 == null) {
                break;
              }
              localObject1 = paramJSONObject.optJSONObject("size");
              if (localObject1 == null) {
                break label457;
              }
              i = ((JSONObject)localObject1).optInt("width");
              j = ((JSONObject)localObject1).optInt("height");
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              if (QLog.isColorLevel()) {
                QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(localOutOfMemoryError2));
              }
            }
            try
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, j, true);
              ((anxy)localObject3).a(paramanxz, (Bitmap)localObject1);
              localObject1 = localObject3;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              if (!QLog.isColorLevel()) {
                break label457;
              }
              QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(localOutOfMemoryError1));
            }
          }
          localObject3 = new anyq((SpriteGLView)localObject3, true, (String)localObject6);
          ((anyq)localObject3).a(new anyl(this, paramanxx, (String)localObject6));
          break label134;
          localObject3 = (SpriteNativeView)paramanxz;
          if (TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject3 = new anza((SpriteNativeView)localObject3);
            break label134;
          }
          localObject3 = new anyx((SpriteNativeView)localObject3, (String)localObject6);
          ((anyx)localObject3).setOnClickListener(new anym(this, paramanxx, (anxu)localObject3, (String)localObject6));
          break label134;
          localObject5 = localObject1;
          continue;
          localObject2 = localObject5;
        }
      }
      if ("video".equals(localObject3))
      {
        if ((paramanxz instanceof SpriteGLView))
        {
          localObject3 = (SpriteGLView)paramanxz;
          localObject2 = new VideoSprite((SpriteGLView)localObject3, ((SpriteGLView)localObject3).getContext(), true);
          ((VideoSprite)localObject2).Go(this.alm + "/" + paramJSONObject.optString("path"));
          if (paramJSONObject.optBoolean("isKey", false)) {
            ((SpriteGLView)localObject3).setVideoTimeGetter((VideoSprite)localObject2);
          }
          if (paramJSONObject.optBoolean("autoClose", false)) {
            ((VideoSprite)localObject2).a(this.d);
          }
          ((VideoSprite)localObject2).setLooping(paramJSONObject.optBoolean("isLooping", false));
        }
        else
        {
          localObject2 = (SpriteNativeView)paramanxz;
          localObject3 = this.alm + "/" + paramJSONObject.optString("path");
          localObject2 = new anzb((SpriteNativeView)localObject2, (String)localObject3);
          ((anzb)localObject2).cW((String)localObject3, paramJSONObject.optBoolean("isLooping", false));
        }
      }
      else if ("label".equals(localObject3)) {
        localObject2 = a(paramanxz, paramJSONObject);
      }
    }
    ((anxu)localObject2).setName(paramJSONObject.optString("name"));
    ((anxu)localObject2).cw(paramJSONObject.optInt("tag"));
    ((anxu)localObject2).setX((float)paramJSONObject.optDouble("x", 0.0D));
    ((anxu)localObject2).setY((float)paramJSONObject.optDouble("y", 0.0D));
    ((anxu)localObject2).setOpacity((int)(paramJSONObject.optDouble("alpha", 1.0D) * 255.0D));
    ((anxu)localObject2).setScale(((anxu)localObject2).getScale() * (float)paramJSONObject.optDouble("scale", 1.0D));
    ((anxu)localObject2).setRotate((float)paramJSONObject.optDouble("rotate", 0.0D));
    ((anxu)localObject2).be(((anxu)paramanxx).getScale());
    localObject3 = paramJSONObject.optJSONArray("actions");
    if (localObject3 != null) {
      ((anxu)localObject2).a(a((JSONArray)localObject3));
    }
    Object localObject5 = paramJSONObject.optJSONObject("frames");
    if (localObject5 != null)
    {
      localObject3 = new anxv();
      ((anxv)localObject3).fps = ((JSONObject)localObject5).optInt("fps");
      localObject5 = ((JSONObject)localObject5).optJSONArray("datas");
      j = ((JSONArray)localObject5).length();
      ((anxv)localObject3).a = new anxv.a[j];
      i = 0;
      while (i < j)
      {
        ((anxv)localObject3).a[i] = new anxv.a();
        localObject6 = ((JSONArray)localObject5).optJSONObject(i);
        localObject3.a[i].x = ((JSONObject)localObject6).optInt("x");
        localObject3.a[i].y = ((JSONObject)localObject6).optInt("y");
        i += 1;
      }
      ((anxu)localObject2).a((anxv)localObject3);
    }
    localObject3 = paramJSONObject.optString("horizontal_align");
    if (localObject3 != null)
    {
      if (((String)localObject3).equals("left")) {
        ((anxu)localObject2).VA(0);
      }
    }
    else
    {
      label1029:
      localObject3 = paramJSONObject.optString("vertical_align");
      if (localObject3 != null)
      {
        if (!((String)localObject3).equals("top")) {
          break label1184;
        }
        ((anxu)localObject2).VB(0);
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (!(localObject2 instanceof anxx)) {
        break;
      }
      localObject5 = (anxx)localObject2;
      paramJSONObject = paramJSONObject.optJSONArray("children");
      j = paramJSONObject.length();
      i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= j) {
          break;
        }
        localObject3 = a(paramanxz, paramJSONObject.getJSONObject(i), paramanxx);
        if (localObject3 != null) {
          ((anxx)localObject5).a((anxu)localObject3);
        }
        i += 1;
      }
      if (((String)localObject3).equals("right"))
      {
        ((anxu)localObject2).VA(1);
        break label1029;
      }
      if (!((String)localObject3).equals("center")) {
        break label1029;
      }
      ((anxu)localObject2).VA(2);
      break label1029;
      label1184:
      if (((String)localObject3).equals("bottom")) {
        ((anxu)localObject2).VB(1);
      } else if (((String)localObject3).equals("center")) {
        ((anxu)localObject2).VB(2);
      }
    }
  }
  
  private anxx a(anxz paramanxz, String paramString)
  {
    Object localObject1;
    if ((paramanxz instanceof SpriteGLView))
    {
      localObject1 = new anys((SpriteGLView)paramanxz);
      if (paramString != null) {
        break label43;
      }
    }
    for (;;)
    {
      return localObject1;
      localObject1 = new anyy((SpriteNativeView)paramanxz);
      break;
      try
      {
        label43:
        paramString = new JSONObject(paramString);
        Object localObject2 = paramString.optJSONObject("size");
        int i = ((JSONObject)localObject2).optInt("width");
        int j = ((JSONObject)localObject2).optInt("height");
        this.mScale = (this.JO / i);
        if (this.cKE)
        {
          localObject2 = ((ViewGroup)paramanxz).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = this.JO;
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(j * this.mScale));
          ((ViewGroup)paramanxz).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((anxu)localObject1).setScale(this.mScale);
          if (this.jdField_a_of_type_Anyk$e != null) {
            this.jdField_a_of_type_Anyk$e.dj(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height);
          }
        }
        paramString = paramString.optJSONArray("scene");
        if (paramString != null)
        {
          j = paramString.length();
          i = 0;
          while (i < j)
          {
            localObject2 = a(paramanxz, paramString.getJSONObject(i), (anxx)localObject1);
            if (localObject2 != null) {
              ((anxx)localObject1).a((anxu)localObject2);
            }
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception paramanxz) {}
    }
    QLog.e("SceneBuilder", 2, "buildFromJson" + QLog.getStackTraceString(paramanxz));
    return localObject1;
  }
  
  private anyb a(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    JSONObject localJSONObject = null;
    Object localObject2 = paramJSONObject.optString("type");
    String str = paramJSONObject.optString("timeType");
    int j = paramJSONObject.optInt("duration");
    if (((String)localObject2).equals("sequence")) {
      localObject1 = new anyj(a(paramJSONObject.optJSONArray("actions")));
    }
    label513:
    label516:
    for (;;)
    {
      if (localObject1 != null)
      {
        ((anyb)localObject1).isRepeat = paramJSONObject.optBoolean("isRepeat");
        if (str != null)
        {
          if (!str.equals("linear")) {
            break label473;
          }
          ((anyb)localObject1).speedType = 0;
        }
        label102:
        if ((paramJSONObject.optBoolean("autoClose", false)) && (this.d != null)) {
          ((anyb)localObject1).a(new anyn(this));
        }
      }
      return localObject1;
      if (((String)localObject2).equals("delay"))
      {
        localObject1 = new anyc(j);
      }
      else
      {
        if (((String)localObject2).equals("position"))
        {
          localJSONObject = paramJSONObject.optJSONObject("from");
          localObject2 = paramJSONObject.optJSONObject("to");
          if ((this.jdField_a_of_type_Anyk$a == null) || (!"$POSITIONX$".equals(((JSONObject)localObject2).optString("x")))) {
            break label513;
          }
          anya[] arrayOfanya = this.jdField_a_of_type_Anyk$a.a(localJSONObject, (JSONObject)localObject2, this.mScale);
          if ((arrayOfanya == null) || (arrayOfanya.length != 2)) {
            break label513;
          }
          localObject1 = new anye(j, arrayOfanya[0].x, arrayOfanya[0].y, arrayOfanya[1].x, arrayOfanya[1].y);
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label516;
          }
          localObject1 = new anye(j, (float)localJSONObject.optDouble("x"), (float)localJSONObject.optDouble("y"), (float)((JSONObject)localObject2).optDouble("x"), (float)((JSONObject)localObject2).optDouble("y"));
          break;
          if (((String)localObject2).equals("scale"))
          {
            localObject1 = new anyi(j, (float)paramJSONObject.optDouble("from", 1.0D), (float)paramJSONObject.optDouble("to", 1.0D));
            break;
          }
          if (((String)localObject2).equals("alpha"))
          {
            localObject1 = new anyg(j, (int)(paramJSONObject.optDouble("from", 1.0D) * 255.0D), (int)(paramJSONObject.optDouble("to", 1.0D) * 255.0D));
            break;
          }
          localObject1 = localJSONObject;
          if (!((String)localObject2).equals("rotate")) {
            break;
          }
          localObject1 = new anyh(j, paramJSONObject.optInt("from", 0), paramJSONObject.optInt("to", 0));
          break;
          label473:
          if (str.equals("easeIn"))
          {
            ((anyb)localObject1).speedType = 1;
            break label102;
          }
          if (!str.equals("easeOut")) {
            break label102;
          }
          ((anyb)localObject1).speedType = 2;
          break label102;
        }
      }
    }
  }
  
  public static String a(int paramInt, String paramString, Paint paramPaint)
  {
    String str2 = "";
    if (paramInt <= 0) {}
    float f;
    do
    {
      return paramString;
      f = paramPaint.measureText("...");
    } while ((int)Math.ceil(paramPaint.measureText(paramString)) <= paramInt);
    int i = paramString.length() - 1;
    for (;;)
    {
      String str1 = str2;
      if (i > 0)
      {
        if ((int)Math.ceil(paramPaint.measureText(paramString, 0, i) + f) <= paramInt) {
          str1 = paramString.substring(0, i) + "...";
        }
      }
      else {
        return str1;
      }
      i -= 1;
    }
  }
  
  private anyb[] a(JSONArray paramJSONArray)
  {
    int j = paramJSONArray.length();
    anyb[] arrayOfanyb = new anyb[j];
    int i = 0;
    while (i < j)
    {
      arrayOfanyb[i] = a(paramJSONArray.optJSONObject(i));
      i += 1;
    }
    return arrayOfanyb;
  }
  
  private static String nN(String paramString)
  {
    try
    {
      localInputStreamReader = new InputStreamReader(new FileInputStream(new File(paramString)));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label66:
        localBufferedReader = null;
        InputStreamReader localInputStreamReader = null;
      }
    }
    try
    {
      localBufferedReader = new BufferedReader(localInputStreamReader);
      try
      {
        paramString = new StringBuilder();
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          paramString.append(str);
          paramString.append('\n');
        }
        paramString.printStackTrace();
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      localBufferedReader = null;
      break label66;
    }
    if (localBufferedReader != null) {}
    try
    {
      localBufferedReader.close();
      if (localInputStreamReader != null) {}
      try
      {
        localInputStreamReader.close();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      localBufferedReader.close();
      localInputStreamReader.close();
      paramString = paramString.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public anyk a(int paramInt)
  {
    this.cKE = true;
    this.JO = paramInt;
    return this;
  }
  
  public anyk a(anyk.b paramb)
  {
    this.jdField_a_of_type_Anyk$b = paramb;
    return this;
  }
  
  public anyk a(anyk.c paramc)
  {
    this.jdField_a_of_type_Anyk$c = paramc;
    return this;
  }
  
  public anyk a(anyk.d paramd)
  {
    this.jdField_a_of_type_Anyk$d = paramd;
    return this;
  }
  
  public anyk a(anyk.e parame)
  {
    this.jdField_a_of_type_Anyk$e = parame;
    return this;
  }
  
  public anyk a(anyo.a parama)
  {
    this.d = parama;
    return this;
  }
  
  public anyk a(String paramString)
  {
    this.alm = paramString;
    return this;
  }
  
  public void a(anxz paramanxz, anyk.f paramf)
  {
    ThreadManager.post(new SceneBuilder.1(this, paramanxz, paramf), 8, null, true);
  }
  
  public static abstract interface a
  {
    public abstract anya[] a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, float paramFloat);
  }
  
  public static abstract interface b
  {
    public abstract void a(anxx paramanxx, anxy paramanxy, String paramString);
  }
  
  public static abstract interface c
  {
    public abstract Bitmap a(anxy paramanxy, String paramString1, String paramString2);
  }
  
  public static abstract interface d
  {
    public abstract int a(int paramInt1, int paramInt2, int paramInt3, String paramString, Paint paramPaint);
    
    public abstract String a(anxy paramanxy, String paramString);
    
    public abstract void a(int paramInt, String paramString, Paint paramPaint);
    
    public abstract boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint);
  }
  
  public static abstract interface e
  {
    public abstract void dj(int paramInt1, int paramInt2);
  }
  
  public static abstract interface f
  {
    public abstract void a(anxx paramanxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyk
 * JD-Core Version:    0.7.0.1
 */