import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeha
{
  public static final String[] eD = { "#B45EFF", "#3C8DFE", "#00B0C7", "#FF6565" };
  
  public static Bitmap a(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, aduk paramaduk)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1) || (paramContext == null))
    {
      paramAppInterface = null;
      return paramAppInterface;
    }
    label33:
    label44:
    label58:
    int k;
    label65:
    int i;
    int j;
    String str;
    if ((paramInt1 < 0) || (paramInt1 >= 4))
    {
      paramInt1 = 0;
      if ((paramInt2 < 0) || (paramInt2 >= 4))
      {
        paramInt2 = 0;
        if ((paramInt3 < 0) || (paramInt3 >= 2))
        {
          paramInt3 = 0;
          if (paramInt2 != 0)
          {
            k = 1;
            i = 515;
            j = 290;
            if (k == 1)
            {
              i = 750;
              j = 1334;
            }
            str = a(d(paramAppInterface), 8.0F);
          }
        }
      }
    }
    for (;;)
    {
      Bitmap localBitmap;
      for (;;)
      {
        try
        {
          localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        }
        catch (Exception paramString1)
        {
          Canvas localCanvas;
          Paint localPaint;
          int m;
          paramContext = null;
          continue;
        }
        catch (OutOfMemoryError paramString1)
        {
          paramContext = null;
          continue;
        }
        try
        {
          localCanvas = new Canvas(localBitmap);
          localPaint = new Paint(1);
          a(paramContext, localCanvas, paramInt1, k, 1.0F);
          localPaint.setColor(-1);
          if (k == 0)
          {
            if (paramInt3 == 0)
            {
              paramAppInterface = paramJSONArray.getJSONObject(0).optString("confess");
              localPaint.setTextSize(48.0F);
              localPaint.setFakeBoldText(true);
              localPaint.setShadowLayer(2.0F, 0.0F, 1.0F, -7829368);
              localPaint.setTextAlign(Paint.Align.CENTER);
              if (paramAppInterface.contains("\n")) {
                break label771;
              }
              paramInt1 = 1;
              paramContext = new Rect(48, 144, 467, 246);
              paramInt2 = paramInt1;
              if (paramInt1 != 0)
              {
                paramString1 = new Rect();
                localPaint.getTextBounds(paramAppInterface, 0, paramAppInterface.length(), paramString1);
                paramInt2 = paramInt1;
                if (paramContext.width() <= paramString1.width()) {
                  paramInt2 = 0;
                }
              }
              if (paramInt2 != 0)
              {
                a(localCanvas, localPaint, paramContext, paramAppInterface, Paint.Align.CENTER, 48);
                localPaint.setFakeBoldText(false);
                break label768;
              }
            }
            else
            {
              paramAppInterface = str + "\n最近收到的坦白说";
              continue;
            }
            paramAppInterface = d(paramAppInterface, 18);
            a(localCanvas, localPaint, new Rect(48, 144, 467, 186), (String)paramAppInterface.first, Paint.Align.CENTER, 42);
            a(localCanvas, localPaint, new Rect(48, 202, 467, 246), (String)paramAppInterface.second, Paint.Align.CENTER, 42);
            continue;
          }
        }
        catch (OutOfMemoryError paramString1)
        {
          paramContext = localBitmap;
          paramAppInterface = paramContext;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ConfessShareHelper", 2, paramString1.getMessage());
          return paramContext;
          k = 80;
          m = 290;
          if (paramInt3 == 1)
          {
            m = 240;
            k = 100;
          }
          localPaint.setColor(-1);
          a(paramAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramJSONArray, paramaduk, i, j, k, m, str, localCanvas, localPaint);
          localPaint.setAlpha(255);
          localPaint.setColor(-1);
          localPaint.setFakeBoldText(false);
          localCanvas.drawRoundRect(new RectF(i / 2 - 125, j - 164 - 250, i / 2 + 125, j - 164), 8.0F, 8.0F, localPaint);
          a(paramString3, localCanvas, new Rect(i / 2 - 116, j - 173 - 232, i / 2 + 116, j - 173));
          paramAppInterface = paramContext.getResources().getDrawable(2130845899);
          paramAppInterface.setBounds(i / 2 - 45, j - 102 - 42, i / 2 + 45, j - 102);
          paramAppInterface.draw(localCanvas);
          paramAppInterface = acfp.m(2131704318);
          localPaint.clearShadowLayer();
          a(localCanvas, localPaint, new Rect(0, j - 82, i, j - 54), paramAppInterface, Paint.Align.CENTER, 28);
        }
        catch (Exception paramString1)
        {
          paramContext = localBitmap;
          paramAppInterface = paramContext;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ConfessShareHelper", 2, paramString1.getMessage());
      return paramContext;
      k = 0;
      break label65;
      break label58;
      break label44;
      break label33;
      label768:
      return localBitmap;
      label771:
      paramInt1 = 0;
    }
  }
  
  public static String a(AppInterface paramAppInterface, Context paramContext, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramAppInterface == null) || (paramContext == null)) {
      paramAppInterface = null;
    }
    for (;;)
    {
      return paramAppInterface;
      try
      {
        String str = "temp_qrcode_share_" + System.currentTimeMillis() + paramAppInterface.getCurrentAccountUin() + ".png";
        paramContext = rwt.a(paramContext, str, paramBitmap);
        paramAppInterface = paramContext;
        if (QLog.isColorLevel())
        {
          QLog.d("ConfessShareHelper", 2, "filename = " + str + "  path = " + paramContext);
          return paramContext;
        }
      }
      catch (OutOfMemoryError paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfessShareHelper", 2, paramAppInterface.getMessage());
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString, float paramFloat)
  {
    String str = paramString;
    int i;
    int j;
    if (aehc.d(paramString) > paramFloat)
    {
      i = Math.max(0, (int)(paramFloat - 3.0F));
      j = i;
    }
    for (;;)
    {
      if ((i >= paramString.length()) || (aehc.d(paramString.substring(0, i) + "…") > paramFloat))
      {
        str = paramString.substring(0, j) + "…";
        return str;
      }
      j = i;
      i += 1;
    }
  }
  
  public static String a(String paramString, AppInterface paramAppInterface)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      localObject1 = localObject3;
    }
    label25:
    do
    {
      for (;;)
      {
        return localObject1;
        localObject1 = new HashMap();
        ((Map)localObject1).put("Connection", "keep-alive");
        ((Map)localObject1).put("Referer", "http://www.qq.com");
        ((Map)localObject1).put("Host", "cgi.connect.qq.com");
        Object localObject2 = (TicketManager)paramAppInterface.getManager(2);
        String str1 = paramAppInterface.getCurrentAccountUin();
        String str2 = ((TicketManager)localObject2).getSkey(str1);
        paramAppInterface = ((TicketManager)localObject2).getPskey(str1, "cgi.connect.qq.com");
        if (!TextUtils.isEmpty(paramAppInterface)) {
          ((Map)localObject1).put("Cookie", "p_uin=" + str1 + ";p_skey=" + paramAppInterface);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("share_image", paramString);
        paramAppInterface = jqc.a(jqi.x("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str1, str2, null, localHashMap, (Map)localObject1, false);
        localObject2 = paramAppInterface;
        if (paramAppInterface == null) {
          localObject2 = jqc.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str1, str2, null, localHashMap, (Map)localObject1, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ConfessShareHelper", 2, "urlResult = " + (String)localObject2 + "  filePath = " + paramString);
        }
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          paramAppInterface = localObject4;
          try
          {
            localObject2 = new JSONObject((String)localObject2);
            localObject1 = localObject3;
            paramAppInterface = localObject4;
            if (((JSONObject)localObject2).getInt("retcode") == 0)
            {
              localObject1 = localObject3;
              paramAppInterface = localObject4;
              if (((JSONObject)localObject2).has("result"))
              {
                paramAppInterface = localObject4;
                localObject2 = ((JSONObject)localObject2).getJSONObject("result").getString("url");
                localObject1 = localObject2;
                paramAppInterface = (AppInterface)localObject2;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject1 = localObject2;
                  paramAppInterface = (AppInterface)localObject2;
                  if (QLog.isColorLevel())
                  {
                    paramAppInterface = (AppInterface)localObject2;
                    QLog.d("ConfessShareHelper", 2, "filePath = " + paramString + " imageUrl=" + (String)localObject2);
                    return localObject2;
                  }
                }
              }
            }
          }
          catch (JSONException paramString)
          {
            localObject1 = paramAppInterface;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConfessShareHelper", 2, paramString.getMessage());
    return paramAppInterface;
  }
  
  public static void a(Canvas paramCanvas, Paint paramPaint, Rect paramRect, String paramString, Paint.Align paramAlign, int paramInt)
  {
    a(paramCanvas, paramPaint, paramRect, paramString, paramAlign, 0, paramInt);
  }
  
  public static void a(Canvas paramCanvas, Paint paramPaint, Rect paramRect, String paramString, Paint.Align paramAlign, int paramInt1, int paramInt2)
  {
    paramPaint.setTextSize(paramInt2);
    paramPaint.setTextAlign(paramAlign);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    int i = (paramRect.bottom + paramRect.top - localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
    if (paramInt1 == -1)
    {
      i = (paramRect.top + (paramRect.top + paramInt2 + paramRect.bottom) / 2 - localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
      paramInt1 = paramRect.centerX();
      if (paramAlign != Paint.Align.LEFT) {
        break label162;
      }
      paramInt1 = paramRect.left;
    }
    for (;;)
    {
      paramCanvas.drawText(paramString, paramInt1, i, paramPaint);
      return;
      if (paramInt1 != 1) {
        break;
      }
      i = (paramRect.bottom + (paramRect.bottom - paramInt2 + paramRect.top) / 2 - localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
      break;
      label162:
      if (paramAlign == Paint.Align.RIGHT) {
        paramInt1 = paramRect.right;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, aduk paramaduk, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString4, Canvas paramCanvas, Paint paramPaint)
  {
    if (paramInt3 == 0)
    {
      paramString1 = paramJSONArray.optJSONObject(0);
      paramInt1 = paramString1.optInt("anonymous_icon_type");
      paramAppInterface = paramString1.optString("confess");
      paramString1 = paramString1.optString("anonymous_name");
      paramContext = paramContext.getResources();
      if (paramInt1 == 0)
      {
        paramInt1 = 2130845874;
        paramContext = paramContext.getDrawable(paramInt1);
        paramContext.setBounds(paramInt6, paramInt7, paramInt6 + 48, paramInt7 + 48);
        paramContext.draw(paramCanvas);
        paramPaint.setShadowLayer(4.0F, 0.0F, 2.0F, -7829368);
        paramPaint.setAntiAlias(true);
        paramPaint.setFakeBoldText(false);
        paramContext = a(paramString1, 15.0F);
        a(paramCanvas, paramPaint, new Rect(paramInt6 + 60, paramInt7 + 6, paramInt4 - paramInt6, paramInt7 + 42), paramContext, Paint.Align.LEFT, 36);
        paramPaint.setFakeBoldText(true);
        a(paramCanvas, paramPaint, new Rect(paramInt6, paramInt7 + 174, paramInt4 - paramInt6, paramInt7 + 246), paramString4, Paint.Align.CENTER, 72);
        paramPaint.setTextSize(72.0F);
        if (paramAppInterface.contains("\n")) {
          break label324;
        }
        paramInt1 = 1;
        label221:
        paramContext = new Rect(paramInt6, paramInt7 + 288, paramInt4 - paramInt6, paramInt7 + 360);
        paramInt2 = paramInt1;
        if (paramInt1 != 0)
        {
          paramString1 = new Rect();
          paramPaint.getTextBounds(paramAppInterface, 0, paramAppInterface.length(), paramString1);
          paramInt2 = paramInt1;
          if (paramContext.width() <= paramString1.width()) {
            paramInt2 = 0;
          }
        }
        if (paramInt2 == 0) {
          break label329;
        }
        a(paramCanvas, paramPaint, paramContext, paramAppInterface, Paint.Align.CENTER, 72);
      }
      for (;;)
      {
        paramPaint.setFakeBoldText(false);
        return;
        paramInt1 = 2130845875;
        break;
        label324:
        paramInt1 = 0;
        break label221;
        label329:
        paramAppInterface = d(paramAppInterface, 18);
        a(paramCanvas, paramPaint, new Rect(paramInt6, paramInt7 + 288, paramInt4 - paramInt6, paramInt7 + 360), (String)paramAppInterface.first, Paint.Align.CENTER, 72);
        a(paramCanvas, paramPaint, new Rect(paramInt6, paramInt7 + 388, paramInt4 - paramInt6, paramInt7 + 460), (String)paramAppInterface.second, Paint.Align.CENTER, 72);
      }
    }
    paramString1 = d(paramJSONArray);
    paramString2 = new Rect(0, 0, 550, 550);
    Object localObject2 = new Rect(paramString2.centerX() - 66, paramString2.centerY() - 66, paramString2.centerX() + 66, paramString2.centerY() + 66);
    paramString3 = new aehc.b();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    paramString1 = paramString3.a(paramString1, paramString2, (ArrayList)localObject1);
    Object localObject3;
    if (paramString3.vl.size() > 1)
    {
      localObject2 = paramString3.vl.iterator();
      paramInt1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Rect)((Iterator)localObject2).next();
        paramInt2 = ((Rect)localObject3).width();
        paramInt2 = ((Rect)localObject3).height() * paramInt2;
        if (paramInt2 > paramInt1) {
          paramInt1 = paramInt2;
        }
        for (;;)
        {
          break;
        }
      }
      if (paramInt1 > 1152) {
        paramString1 = paramString3.a(d(paramJSONArray), paramString2, (ArrayList)localObject1);
      }
    }
    for (;;)
    {
      paramString2 = new Rect(paramInt4 / 2 - 275, paramInt7, paramInt4 / 2 + 275, 550 + paramInt7);
      paramString3 = new Rect();
      paramPaint.clearShadowLayer();
      paramPaint.setAntiAlias(true);
      paramJSONArray = paramString1.iterator();
      if (paramJSONArray.hasNext())
      {
        localObject1 = (aehc.a)paramJSONArray.next();
        localObject2 = ((aehc.a)localObject1).vk.iterator();
        label721:
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aehc.a.a)((Iterator)localObject2).next();
          paramString3.left = (((aehc.a.a)localObject3).rect.left + paramString2.left + 1);
          paramString3.top = (((aehc.a.a)localObject3).rect.top + paramString2.top + 1);
          paramString3.right = (((aehc.a.a)localObject3).rect.right + paramString2.left - 2);
          paramString3.bottom = (((aehc.a.a)localObject3).rect.bottom + paramString2.top - 2);
          paramPaint.setColor(((aehc.a)localObject1).color);
          if (!((aehc.a)localObject1).bTQ) {
            break label913;
          }
          paramInt1 = 178;
          paramPaint.setAlpha(paramInt1);
          paramPaint.setFakeBoldText(((aehc.a)localObject1).bold);
          paramString1 = Paint.Align.CENTER;
          if (((aehc.a)localObject1).cMW != -1) {
            break label920;
          }
          paramString1 = Paint.Align.LEFT;
        }
        for (;;)
        {
          label849:
          a(paramCanvas, paramPaint, paramString3, ((aehc.a.a)localObject3).text, paramString1, ((aehc.a)localObject1).cMX, ((aehc.a)localObject1).size);
          break label721;
          break;
          label913:
          paramInt1 = 255;
          break label849;
          label920:
          if (((aehc.a)localObject1).cMW == 1) {
            paramString1 = Paint.Align.RIGHT;
          }
        }
      }
      paramPaint.setFakeBoldText(false);
      paramPaint.setColor(-1);
      paramPaint.setAlpha(178);
      paramCanvas.drawCircle(paramString2.centerX(), paramString2.centerY(), 54.0F, paramPaint);
      paramPaint.setAlpha(255);
      if (paramaduk != null)
      {
        paramAppInterface = paramaduk.getFaceBitmap(paramAppInterface.getCurrentAccountUin(), true);
        QLog.i("ConfessShareHelper", 4, "preLoadQQSelfHeaderBitmap " + paramAppInterface);
      }
      for (paramAppInterface = new BitmapDrawable(paramAppInterface);; paramAppInterface = paramContext.getResources().getDrawable(2130845892))
      {
        paramAppInterface.setBounds(paramString2.centerX() - 50, paramString2.centerY() - 50, paramString2.centerX() + 50, paramString2.centerY() + 50);
        paramAppInterface.draw(paramCanvas);
        paramPaint.setTextSize(24.0F);
        paramAppInterface = new Rect();
        paramContext = a(paramString4, 8.0F) + acfp.m(2131704319);
        paramPaint.getTextBounds(paramContext, 0, paramContext.length(), paramAppInterface);
        paramPaint.setStrokeWidth(1.0F);
        paramPaint.setAlpha(128);
        paramCanvas.drawLine(paramString2.left + 6, paramString2.bottom + 38, paramInt4 / 2 - paramAppInterface.width() / 2 - 12, paramString2.bottom + 38, paramPaint);
        paramCanvas.drawLine(paramInt4 / 2 + paramAppInterface.width() / 2 + 12, paramString2.bottom + 38, paramString2.right - 6, paramString2.bottom + 38, paramPaint);
        paramPaint.setAlpha(255);
        paramPaint.setStrokeWidth(0.0F);
        a(paramCanvas, paramPaint, new Rect(paramString2.left, paramString2.bottom + 26, paramString2.right, paramString2.bottom + 50), paramContext, Paint.Align.CENTER, 24);
        return;
      }
    }
  }
  
  public static final void a(String paramString, Canvas paramCanvas, Rect paramRect)
  {
    int m;
    int i;
    int j;
    int k;
    try
    {
      localObject = rwt.a(paramString, -1);
      m = ((lk)localObject).getWidth();
      paramString = new int[m * m];
      i = 0;
    }
    catch (OutOfMemoryError paramString)
    {
      Object localObject;
      while (!QLog.isColorLevel()) {}
      QLog.i("ConfessShareHelper", 2, "drawQRBitmap e:" + paramString.getMessage());
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ConfessShareHelper", 2, "drawQRBitmap e:" + paramString.getMessage());
      return;
    }
    if (j < m) {
      if (((lk)localObject).get(j, i)) {
        k = -16777216;
      }
    }
    label212:
    for (;;)
    {
      localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
      paramCanvas.drawBitmap((Bitmap)localObject, null, paramRect, null);
      ((Bitmap)localObject).recycle();
      return;
      for (;;)
      {
        if (i >= m) {
          break label212;
        }
        j = 0;
        break;
        for (;;)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
          k = -1;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    int i = Color.parseColor(eD[paramInt1]);
    paramCanvas.drawColor(i);
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    float f1 = 1.0F;
    if (f2 > 0.05F) {
      f1 = 2.0F / f2;
    }
    aeha.a[] arrayOfa = a(paramInt2, paramInt1);
    paramInt2 = arrayOfa.length;
    paramInt1 = 0;
    aeha.a locala;
    if (paramInt1 < paramInt2) {
      locala = arrayOfa[paramInt1];
    }
    for (;;)
    {
      try
      {
        localDrawable = paramContext.getResources().getDrawable(locala.resId);
        if (locala.resId == 2130845901) {
          break label316;
        }
        if (locala.resId != 2130845894) {
          break label309;
        }
      }
      catch (Exception localException)
      {
        Drawable localDrawable;
        int j;
        int k;
        int m;
        int n;
        float f3;
        QLog.e("ConfessShareHelper", 1, " drawConfessShareBitmapBG e: " + localException.getMessage());
        continue;
      }
      j = localDrawable.getIntrinsicWidth();
      k = localDrawable.getIntrinsicHeight();
      m = (int)(locala.cx - j * locala.scale * f1 / 2.0F);
      n = (int)(locala.cy * f2 - k * locala.scale * f1 / 2.0F);
      f3 = locala.cx;
      localDrawable.setBounds(m, n, (int)(j * locala.scale * f1 / 2.0F + f3), (int)(f2 * locala.cy + k * locala.scale * f1 / 2.0F));
      if (locala.bTP)
      {
        localDrawable.setAlpha(77);
        localDrawable.setColorFilter(i, PorterDuff.Mode.MULTIPLY);
      }
      localDrawable.draw(paramCanvas);
      paramInt1 += 1;
      break;
      return true;
      label309:
      f2 = paramFloat;
      continue;
      label316:
      f2 = 1.0F;
    }
  }
  
  public static aeha.a[] a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      for (;;)
      {
        return new aeha.a[0];
        return new aeha.a[] { new aeha.a(2130845866, 60, 60, true, 0.75F), new aeha.a(2130845871, 458, 84, true, 0.75F), new aeha.a(2130845872, 142, 250, true, 0.75F), new aeha.a(2130845866, 368, 188, true, 0.75F), new aeha.a(2130845864, 168, 120, true, 0.75F), new aeha.a(2130845897, 120, 40, true, 0.75F), new aeha.a(2130845898, 120, 110, true, 0.75F), new aeha.a(2130845895, 30, 150, true, 0.75F), new aeha.a(2130845895, 180, 200, true, 0.75F), new aeha.a(2130845897, 420, 160, true, 0.75F), new aeha.a(2130845898, 495, 150, true, 0.75F), new aeha.a(2130845894, 257, 82, false, 1.0F) };
        return new aeha.a[] { new aeha.a(2130845873, 60, 88, true, 0.75F), new aeha.a(2130845865, 226, 56, true, 0.75F), new aeha.a(2130845872, 480, 140, true, 0.75F), new aeha.a(2130845870, 330, 198, true, 0.75F), new aeha.a(2130845871, 168, 244, true, 0.75F), new aeha.a(2130845897, 300, 50, true, 0.75F), new aeha.a(2130845898, 460, 50, true, 0.75F), new aeha.a(2130845895, 60, 230, true, 0.75F), new aeha.a(2130845897, 120, 120, true, 0.75F), new aeha.a(2130845897, 440, 270, true, 0.75F), new aeha.a(2130845894, 257, 82, false, 1.0F) };
        return new aeha.a[] { new aeha.a(2130845866, 174, 58, true, 0.75F), new aeha.a(2130845868, 70, 146, true, 0.75F), new aeha.a(2130845870, 390, 106, true, 0.75F), new aeha.a(2130845865, 206, 240, true, 0.75F), new aeha.a(2130845867, 470, 225, true, 0.75F), new aeha.a(2130845898, 120, 88, true, 0.75F), new aeha.a(2130845898, 480, 70, true, 0.75F), new aeha.a(2130845895, 110, 230, true, 0.75F), new aeha.a(2130845897, 340, 210, true, 0.75F), new aeha.a(2130845894, 257, 82, false, 1.0F) };
        return new aeha.a[] { new aeha.a(2130845872, 138, 88, true, 0.75F), new aeha.a(2130845866, 68, 232, true, 0.75F), new aeha.a(2130845870, 298, 206, true, 0.75F), new aeha.a(2130845873, 480, 140, true, 0.75F), new aeha.a(2130845902, 382, 140, true, 0.75F), new aeha.a(2130845897, 60, 90, true, 0.75F), new aeha.a(2130845895, 182, 64, true, 0.75F), new aeha.a(2130845895, 440, 210, true, 0.75F), new aeha.a(2130845897, 440, 30, true, 0.75F), new aeha.a(2130845897, 190, 200, true, 0.75F), new aeha.a(2130845894, 257, 82, false, 1.0F) };
        if (paramInt1 != 1) {
          break;
        }
        switch (paramInt2)
        {
        }
      }
      return new aeha.a[] { new aeha.a(2130845867, 110, 230, true, 1.0F), new aeha.a(2130845870, 656, 170, true, 1.0F), new aeha.a(2130845865, 516, 350, true, 1.0F), new aeha.a(2130845866, 84, 550, true, 1.0F), new aeha.a(2130845871, 656, 586, true, 1.0F), new aeha.a(2130845866, 526, 735, true, 1.0F), new aeha.a(2130845872, 198, 830, true, 1.0F), new aeha.a(2130845868, 70, 1016, true, 1.0F), new aeha.a(2130845870, 397, 952, true, 1.0F), new aeha.a(2130845873, 670, 880, true, 1.0F), new aeha.a(2130845865, 220, 1257, true, 1.0F), new aeha.a(2130845869, 606, 1220, true, 1.0F), new aeha.a(2130845902, 452, 475, true, 1.0F), new aeha.a(2130845864, 240, 645, true, 1.0F), new aeha.a(2130845895, 160, 300, true, 1.0F), new aeha.a(2130845898, 660, 330, true, 1.0F), new aeha.a(2130845896, 620, 450, true, 1.0F), new aeha.a(2130845897, 175, 500, true, 1.0F), new aeha.a(2130845897, 460, 570, true, 1.0F), new aeha.a(2130845898, 180, 630, true, 1.0F), new aeha.a(2130845895, 40, 690, true, 1.0F), new aeha.a(2130845895, 260, 750, true, 1.0F), new aeha.a(2130845898, 710, 600, true, 1.0F), new aeha.a(2130845897, 600, 710, true, 1.0F), new aeha.a(2130845897, 140, 970, true, 1.0F), new aeha.a(2130845895, 85, 1200, true, 1.0F), new aeha.a(2130845895, 600, 1050, true, 1.0F), new aeha.a(2130845898, 420, 1100, true, 1.0F), new aeha.a(2130845897, 540, 1250, true, 1.0F), new aeha.a(2130845901, 375, 134, false, 1.0F) };
      return new aeha.a[] { new aeha.a(2130845870, 110, 368, true, 1.0F), new aeha.a(2130845871, 570, 256, true, 1.0F), new aeha.a(2130845866, 655, 475, true, 1.0F), new aeha.a(2130845873, 75, 740, true, 1.0F), new aeha.a(2130845865, 320, 686, true, 1.0F), new aeha.a(2130845872, 670, 832, true, 1.0F), new aeha.a(2130845870, 505, 955, true, 1.0F), new aeha.a(2130845871, 260, 1020, true, 1.0F), new aeha.a(2130845869, 75, 1216, true, 1.0F), new aeha.a(2130845865, 565, 1235, true, 1.0F), new aeha.a(2130845902, 430, 355, true, 1.0F), new aeha.a(2130845864, 110, 174, true, 1.0F), new aeha.a(2130845895, 140, 250, true, 1.0F), new aeha.a(2130845898, 640, 195, true, 1.0F), new aeha.a(2130845895, 170, 450, true, 1.0F), new aeha.a(2130845897, 490, 1220, true, 1.0F), new aeha.a(2130845896, 350, 520, true, 1.0F), new aeha.a(2130845896, 630, 410, true, 1.0F), new aeha.a(2130845898, 60, 500, true, 1.0F), new aeha.a(2130845898, 680, 655, true, 1.0F), new aeha.a(2130845898, 310, 1110, true, 1.0F), new aeha.a(2130845897, 470, 660, true, 1.0F), new aeha.a(2130845897, 190, 780, true, 1.0F), new aeha.a(2130845897, 680, 1060, true, 1.0F), new aeha.a(2130845895, 180, 1230, true, 1.0F), new aeha.a(2130845901, 375, 134, false, 1.0F) };
      return new aeha.a[] { new aeha.a(2130845866, 110, 220, true, 1.0F), new aeha.a(2130845872, 654, 240, true, 1.0F), new aeha.a(2130845870, 562, 482, true, 1.0F), new aeha.a(2130845868, 95, 537, true, 1.0F), new aeha.a(2130845865, 295, 672, true, 1.0F), new aeha.a(2130845867, 683, 660, true, 1.0F), new aeha.a(2130845869, 60, 850, true, 1.0F), new aeha.a(2130845871, 442, 872, true, 1.0F), new aeha.a(2130845865, 114, 1046, true, 1.0F), new aeha.a(2130845866, 680, 950, true, 1.0F), new aeha.a(2130845871, 230, 1197, true, 1.0F), new aeha.a(2130845873, 480, 1260, true, 1.0F), new aeha.a(2130845902, 670, 1200, true, 1.0F), new aeha.a(2130845895, 140, 630, true, 1.0F), new aeha.a(2130845895, 500, 960, true, 1.0F), new aeha.a(2130845895, 330, 1050, true, 1.0F), new aeha.a(2130845895, 50, 1150, true, 1.0F), new aeha.a(2130845896, 290, 430, true, 1.0F), new aeha.a(2130845896, 330, 760, true, 1.0F), new aeha.a(2130845897, 60, 310, true, 1.0F), new aeha.a(2130845897, 480, 580, true, 1.0F), new aeha.a(2130845897, 220, 820, true, 1.0F), new aeha.a(2130845898, 600, 150, true, 1.0F), new aeha.a(2130845898, 700, 410, true, 1.0F), new aeha.a(2130845898, 25, 900, true, 1.0F), new aeha.a(2130845898, 150, 430, true, 1.0F), new aeha.a(2130845901, 375, 134, false, 1.0F) };
      return new aeha.a[] { new aeha.a(2130845866, 104, 278, true, 1.0F), new aeha.a(2130845869, 588, 200, true, 1.0F), new aeha.a(2130845865, 690, 390, true, 1.0F), new aeha.a(2130845868, 420, 534, true, 1.0F), new aeha.a(2130845867, 92, 592, true, 1.0F), new aeha.a(2130845871, 660, 624, true, 1.0F), new aeha.a(2130845866, 475, 735, true, 1.0F), new aeha.a(2130845872, 192, 818, true, 1.0F), new aeha.a(2130845873, 696, 880, true, 1.0F), new aeha.a(2130845870, 430, 990, true, 1.0F), new aeha.a(2130845865, 64, 1034, true, 1.0F), new aeha.a(2130845865, 272, 1250, true, 1.0F), new aeha.a(2130845869, 584, 1205, true, 1.0F), new aeha.a(2130845864, 254, 638, true, 1.0F), new aeha.a(2130845895, 200, 320, true, 1.0F), new aeha.a(2130845895, 260, 780, true, 1.0F), new aeha.a(2130845895, 620, 1000, true, 1.0F), new aeha.a(2130845895, 150, 1250, true, 1.0F), new aeha.a(2130845896, 70, 420, true, 1.0F), new aeha.a(2130845896, 460, 590, true, 1.0F), new aeha.a(2130845896, 630, 450, true, 1.0F), new aeha.a(2130845897, 70, 800, true, 1.0F), new aeha.a(2130845897, 280, 980, true, 1.0F), new aeha.a(2130845897, 610, 720, true, 1.0F), new aeha.a(2130845897, 480, 1220, true, 1.0F), new aeha.a(2130845898, 170, 590, true, 1.0F), new aeha.a(2130845898, 330, 1160, true, 1.0F), new aeha.a(2130845898, 700, 680, true, 1.0F), new aeha.a(2130845898, 660, 290, true, 1.0F), new aeha.a(2130845901, 375, 134, false, 1.0F) };
    } while (paramInt1 != 2);
    return new aeha.a[] { new aeha.a(2130845867, 110, 310, true, 1.0F), new aeha.a(2130845870, 650, 216, true, 1.0F), new aeha.a(2130845865, 516, 350, true, 1.0F), new aeha.a(2130845867, 92, 592, true, 1.0F), new aeha.a(2130845871, 656, 586, true, 1.0F), new aeha.a(2130845866, 470, 716, true, 1.0F), new aeha.a(2130845872, 198, 830, true, 1.0F), new aeha.a(2130845873, 670, 980, true, 1.0F), new aeha.a(2130845870, 397, 1060, true, 1.0F), new aeha.a(2130845868, 70, 1016, true, 1.0F), new aeha.a(2130845895, 200, 320, true, 1.0F), new aeha.a(2130845864, 240, 438, true, 1.0F), new aeha.a(2130845902, 452, 475, true, 0.75F), new aeha.a(2130845895, 200, 600, true, 1.0F), new aeha.a(2130845895, 1000, 620, true, 1.0F), new aeha.a(2130845896, 70, 420, true, 1.0F) };
  }
  
  public static Bitmap b(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, aduk paramaduk)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1) || (paramContext == null))
    {
      paramAppInterface = null;
      return paramAppInterface;
    }
    if ((paramInt3 < 0) || (paramInt3 >= 2)) {
      paramInt3 = 0;
    }
    for (;;)
    {
      for (;;)
      {
        int i = 600;
        int j = 470;
        if (paramInt3 == 1)
        {
          i = 560;
          j = 612;
        }
        String str = a(d(paramAppInterface), 8.0F);
        try
        {
          paramString1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString1)
        {
          try
          {
            Canvas localCanvas = new Canvas(paramString1);
            Paint localPaint = new Paint(1);
            localPaint.setColor(-1);
            a(paramAppInterface, paramContext, paramInt1, paramInt2, paramInt3, null, paramString2, paramString3, paramJSONArray, paramaduk, i, j, 5, 5, str, localCanvas, localPaint);
            localPaint.setAlpha(255);
            localPaint.setColor(-1);
            return paramString1;
          }
          catch (Exception paramAppInterface)
          {
            for (;;)
            {
              paramContext = paramString1;
              paramString1 = paramAppInterface;
            }
          }
          catch (OutOfMemoryError paramAppInterface)
          {
            for (;;)
            {
              paramContext = paramString1;
              paramString1 = paramAppInterface;
            }
          }
          paramString1 = paramString1;
          paramContext = null;
          paramAppInterface = paramContext;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ConfessShareHelper", 2, paramString1.getMessage());
          return paramContext;
        }
        catch (Exception paramString1)
        {
          paramContext = null;
          paramAppInterface = paramContext;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ConfessShareHelper", 2, paramString1.getMessage());
      return paramContext;
    }
  }
  
  public static Pair<String, String> d(String paramString, int paramInt)
  {
    String str2 = a(paramString, paramInt);
    paramString = "";
    Object localObject1 = "";
    Object localObject2 = localObject1;
    String str1 = paramString;
    if (str2.contains("\n"))
    {
      String[] arrayOfString = str2.split("\n");
      localObject2 = localObject1;
      str1 = paramString;
      if (arrayOfString.length >= 2)
      {
        str1 = arrayOfString[0];
        localObject2 = arrayOfString[1];
      }
    }
    paramString = localObject2;
    localObject1 = str1;
    if (TextUtils.isEmpty(str1))
    {
      paramString = localObject2;
      localObject1 = str1;
      if (TextUtils.isEmpty(localObject2))
      {
        paramInt = str2.length();
        if (paramInt < 16) {
          break label134;
        }
        localObject1 = str2.substring(0, (paramInt + 1) / 2);
        paramString = str2.substring((paramInt + 1) / 2, paramInt);
      }
    }
    for (;;)
    {
      return new Pair(localObject1, paramString);
      label134:
      if (paramInt >= 12)
      {
        localObject1 = str2.substring(0, 8);
        paramString = str2.substring(8, paramInt);
      }
      else
      {
        localObject1 = str2.substring(0, paramInt * 6 / 10);
        paramString = str2.substring(paramInt * 6 / 10, paramInt);
      }
    }
  }
  
  /* Error */
  public static final String d(AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 243	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 650	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10: new 134	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 656	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   20: invokevirtual 657	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   23: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload 5
    //   28: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokevirtual 662	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_0
    //   38: aload_0
    //   39: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +324 -> 366
    //   45: invokestatic 668	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   48: invokevirtual 674	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   51: astore_1
    //   52: aload_1
    //   53: new 134	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 676
    //   63: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 5
    //   68: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 682	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   77: aconst_null
    //   78: ldc_w 684
    //   81: iconst_1
    //   82: anewarray 13	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: aload 5
    //   89: aastore
    //   90: aconst_null
    //   91: invokestatic 690	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   94: astore_2
    //   95: aload_0
    //   96: astore 4
    //   98: aload_2
    //   99: ifnull +111 -> 210
    //   102: aload_0
    //   103: astore 4
    //   105: aload_0
    //   106: astore_3
    //   107: aload_2
    //   108: invokeinterface 695 1 0
    //   113: ifeq +97 -> 210
    //   116: aload_0
    //   117: astore_3
    //   118: aload_2
    //   119: aload_2
    //   120: ldc_w 697
    //   123: invokeinterface 700 2 0
    //   128: invokeinterface 702 2 0
    //   133: astore 4
    //   135: aload_0
    //   136: astore_1
    //   137: aload_0
    //   138: astore_3
    //   139: aload 4
    //   141: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +24 -> 168
    //   147: aload_0
    //   148: astore_3
    //   149: new 13	java/lang/String
    //   152: dup
    //   153: aload 4
    //   155: invokevirtual 706	java/lang/String:getBytes	()[B
    //   158: ldc_w 708
    //   161: invokespecial 711	java/lang/String:<init>	([BLjava/lang/String;)V
    //   164: invokestatic 716	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore_1
    //   168: aload_1
    //   169: astore 4
    //   171: aload_1
    //   172: astore_3
    //   173: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +34 -> 210
    //   179: aload_1
    //   180: astore_3
    //   181: ldc 165
    //   183: iconst_2
    //   184: new 134	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 718
    //   194: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_1
    //   208: astore 4
    //   210: aload 4
    //   212: astore_0
    //   213: aload_2
    //   214: ifnull +12 -> 226
    //   217: aload_2
    //   218: invokeinterface 721 1 0
    //   223: aload 4
    //   225: astore_0
    //   226: aload_0
    //   227: astore_1
    //   228: aload_0
    //   229: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   232: ifeq +6 -> 238
    //   235: aload 5
    //   237: astore_1
    //   238: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +29 -> 270
    //   244: ldc 165
    //   246: iconst_2
    //   247: new 134	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 723
    //   257: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_1
    //   271: areturn
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_2
    //   276: astore_3
    //   277: aload_0
    //   278: astore_2
    //   279: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +32 -> 314
    //   285: ldc 165
    //   287: iconst_2
    //   288: new 134	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 725
    //   298: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_3
    //   302: invokestatic 729	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   305: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_2
    //   315: astore_0
    //   316: aload_1
    //   317: ifnull -91 -> 226
    //   320: aload_1
    //   321: invokeinterface 721 1 0
    //   326: aload_2
    //   327: astore_0
    //   328: goto -102 -> 226
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull +9 -> 344
    //   338: aload_2
    //   339: invokeinterface 721 1 0
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: goto -13 -> 334
    //   350: astore_0
    //   351: aload_1
    //   352: astore_2
    //   353: goto -19 -> 334
    //   356: astore_0
    //   357: aload_2
    //   358: astore_1
    //   359: aload_3
    //   360: astore_2
    //   361: aload_0
    //   362: astore_3
    //   363: goto -84 -> 279
    //   366: goto -140 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	paramAppInterface	AppInterface
    //   51	308	1	localObject1	Object
    //   94	124	2	localCursor	android.database.Cursor
    //   272	4	2	localException	Exception
    //   278	83	2	localObject2	Object
    //   106	257	3	localObject3	Object
    //   96	128	4	localObject4	Object
    //   4	232	5	str	String
    // Exception table:
    //   from	to	target	type
    //   52	95	272	java/lang/Exception
    //   52	95	331	finally
    //   107	116	346	finally
    //   118	135	346	finally
    //   139	147	346	finally
    //   149	168	346	finally
    //   173	179	346	finally
    //   181	207	346	finally
    //   279	314	350	finally
    //   107	116	356	java/lang/Exception
    //   118	135	356	java/lang/Exception
    //   139	147	356	java/lang/Exception
    //   149	168	356	java/lang/Exception
    //   173	179	356	java/lang/Exception
    //   181	207	356	java/lang/Exception
  }
  
  public static ArrayList<aehc.c> d(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < j)
    {
      String str = paramJSONArray.optJSONObject(i).optString("confess");
      if (localHashSet.contains(str)) {}
      do
      {
        i += 1;
        break;
        localHashSet.add(str);
        localArrayList.add(new aehc.c(str));
      } while (localArrayList.size() < 10);
    }
    localHashSet.clear();
    return localArrayList;
  }
  
  public static class a
  {
    public boolean bTP = true;
    public int cx;
    public int cy;
    public int resId;
    public float scale = 1.0F;
    
    public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float paramFloat)
    {
      this.resId = paramInt1;
      this.cx = paramInt2;
      this.cy = paramInt3;
      this.bTP = paramBoolean;
      this.scale = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeha
 * JD-Core Version:    0.7.0.1
 */