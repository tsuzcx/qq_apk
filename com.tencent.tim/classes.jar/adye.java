import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class adye
{
  static int cLl = -1;
  public int bubbleId;
  public String bvU;
  public int[] kK;
  public String type = "diy_chartlet";
  
  private static float a(Paint paramPaint, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null)) {
      return 0.0F;
    }
    return paramPaint.measureText(paramString);
  }
  
  public static HashMap<String, adye> a(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Iterator localIterator = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (paramJSONObject.has("chartlet_animation"))
    {
      localObject2 = paramJSONObject.optJSONObject("chartlet_animation");
      if (((JSONObject)localObject2).has("animation_set"))
      {
        localObject2 = ((JSONObject)localObject2).optJSONArray("animation_set");
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localArrayList.add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
      }
    }
    if (paramJSONObject.has("diy_animation")) {
      localArrayList.add(paramJSONObject.optJSONObject("diy_animation").optString("diy"));
    }
    if (paramJSONObject.has("animation_sets"))
    {
      localObject2 = paramJSONObject.optJSONObject("animation_sets");
      paramJSONObject = localIterator;
      if (0 == 0) {
        paramJSONObject = new HashMap(4);
      }
      localIterator = localArrayList.iterator();
      label226:
      for (;;)
      {
        localObject1 = paramJSONObject;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((JSONObject)localObject2).optJSONObject((String)localIterator.next());
        if (localObject1 != null)
        {
          if (((JSONObject)localObject1).has("text_size")) {}
          for (localObject1 = adye.b.b((JSONObject)localObject1);; localObject1 = adye.a.a((JSONObject)localObject1))
          {
            if (localObject1 == null) {
              break label226;
            }
            ((adye)localObject1).bubbleId = paramInt;
            paramJSONObject.put(((adye)localObject1).bvU, localObject1);
            break;
          }
        }
      }
    }
    if ((localObject1 != null) && (((HashMap)localObject1).size() > 0)) {
      adxn.a().eO.put(Integer.valueOf(paramInt), localObject1);
    }
    return localObject1;
  }
  
  public void a(adyk paramadyk, Canvas paramCanvas) {}
  
  public static final class a
    extends adye
  {
    public boolean RQ = true;
    public int cKH;
    public String zipName = "";
    
    public static adye a(JSONObject paramJSONObject)
    {
      Object localObject = paramJSONObject.optString("type");
      if (("diy_chartlet".equalsIgnoreCase((String)localObject)) || ("static".equalsIgnoreCase((String)localObject)))
      {
        a locala = new a();
        locala.type = ((String)localObject);
        localObject = BaseApplicationImpl.getApplication().getApplicationContext();
        locala.bvU = paramJSONObject.optString("align").toUpperCase();
        if (paramJSONObject.has("rect"))
        {
          JSONArray localJSONArray = paramJSONObject.optJSONArray("rect");
          locala.kK = new int[4];
          int i = 0;
          while (i < localJSONArray.length())
          {
            locala.kK[i] = aqcx.dip2px((Context)localObject, localJSONArray.optInt(i) / 2);
            i += 1;
          }
        }
        locala.RQ = paramJSONObject.optBoolean("mirror", true);
        if (QLog.isColorLevel()) {
          QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubblePasterConfig json->" + paramJSONObject);
        }
        return locala;
      }
      QLog.e("DiyBubbleConfig", 1, "error! paster type: " + (String)localObject);
      return null;
    }
    
    @TargetApi(11)
    public Rect a(adyk paramadyk, Canvas paramCanvas)
    {
      int i1 = 0;
      paramCanvas = paramadyk.getBounds();
      Resources localResources = BaseApplicationImpl.getContext().getResources();
      if (cLl == -1) {
        cLl = wja.dp2px(48.0F, localResources);
      }
      int j = this.kK[3];
      int i = this.kK[2];
      int m;
      int n;
      int k;
      if (paramCanvas.height() >= cLl)
      {
        wja.dp2px(10.0F, localResources);
        wja.dp2px(9.0F, localResources);
        m = 0;
        n = 0;
        k = j;
        j = n;
      }
      for (;;)
      {
        if (this.bvU.startsWith("T")) {
          n = m + this.kK[1];
        }
        for (;;)
        {
          label111:
          if (this.bvU.endsWith("L")) {
            m = this.kK[0] + j;
          }
          for (;;)
          {
            j = m;
            if (paramadyk.bSb)
            {
              j = m;
              if (!this.RQ) {
                j = paramCanvas.width() - m - i;
              }
            }
            return new Rect(j, n, i + j, k + n);
            n = wja.dp2px(10.0F, localResources);
            m = wja.dp2px(7.0F, localResources);
            if ("static".equalsIgnoreCase(this.type))
            {
              m = -wja.dp2px(2.0F, localResources);
              k = j;
              j = 0;
              break;
            }
            k = j;
            if (j <= m * 2) {
              break label407;
            }
            m *= 2;
            j = this.kK[2] * m / this.kK[3];
            i = j;
            k = m;
            if (j >= n * 2) {
              break label407;
            }
            int i2 = j / 2;
            k = m;
            i = j;
            j = n - i2;
            m = 0;
            break;
            if (!this.bvU.startsWith("B")) {
              break label401;
            }
            n = this.kK[1] + this.kK[3] + paramCanvas.height() - k - m;
            break label111;
            m = i1;
            if (this.bvU.endsWith("R")) {
              m = this.kK[0] + this.kK[2] + paramCanvas.width() - i - j;
            }
          }
          label401:
          n = 0;
        }
        label407:
        m = 0;
        j = 0;
      }
    }
    
    public void a(adyk paramadyk, Canvas paramCanvas)
    {
      if ((paramCanvas == null) || (paramadyk == null)) {}
      for (;;)
      {
        return;
        Bitmap localBitmap;
        if ("diy_chartlet".equalsIgnoreCase(this.type)) {
          localBitmap = adxn.a().b(paramadyk, this);
        }
        while (localBitmap != null)
        {
          int i = paramCanvas.save();
          if ((paramadyk.bSb) && (this.RQ)) {
            paramCanvas.scale(-1.0F, 1.0F, paramadyk.getBounds().centerX(), paramadyk.getBounds().centerY());
          }
          Paint localPaint = new Paint();
          paramadyk = a(paramadyk, paramCanvas);
          if (paramCanvas.getHeight() < cLl) {
            paramCanvas.drawBitmap(localBitmap, null, paramadyk, localPaint);
          }
          for (;;)
          {
            paramCanvas.restoreToCount(i);
            return;
            if (!"static".equalsIgnoreCase(this.type)) {
              break label166;
            }
            localBitmap = adxn.a().a(paramadyk, this);
            break;
            paramCanvas.drawBitmap(localBitmap, paramadyk.left, paramadyk.top, localPaint);
          }
          label166:
          localBitmap = null;
        }
      }
    }
  }
  
  public static final class b
    extends adye
  {
    public int cLm;
    public String textAlign;
    public int textColor = -1;
    public int textSize;
    
    public static adye b(JSONObject paramJSONObject)
    {
      b localb = new b();
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      localb.bvU = paramJSONObject.optString("align");
      localb.textSize = (aqcx.sp2px(localContext, paramJSONObject.optInt("text_size") / 2) + 1);
      localb.textAlign = paramJSONObject.optString("text_align");
      String str = paramJSONObject.optString("text_color");
      Object localObject = str;
      if (str.startsWith("0x")) {
        localObject = str.substring(2);
      }
      try
      {
        localb.textColor = Color.parseColor("#" + (String)localObject);
        if (paramJSONObject.has("rect"))
        {
          localObject = paramJSONObject.optJSONArray("rect");
          localb.kK = new int[4];
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            localb.kK[i] = aqcx.dip2px(localContext, ((JSONArray)localObject).optInt(i) / 2);
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiyBubbleConfig", 2, "diy text_color invalid");
          }
        }
        localb.cLm = paramJSONObject.optInt("text_max_count");
        if (QLog.isColorLevel()) {
          QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubbleTextConfig json->" + paramJSONObject);
        }
      }
      return localb;
    }
    
    @TargetApi(11)
    public Rect a(adyk paramadyk, Canvas paramCanvas, Paint paramPaint)
    {
      float f1 = 0.0F;
      paramCanvas = paramadyk.getBounds();
      Object localObject = BaseApplicationImpl.getContext().getResources();
      if (cLl == -1) {
        cLl = wja.dp2px(48.0F, (Resources)localObject);
      }
      float f4 = 1.0F;
      float f3 = this.kK[3];
      int i;
      if (paramCanvas.height() < cLl)
      {
        i = wja.dp2px(2.0F, (Resources)localObject);
        int j = wja.dp2px(9.0F, (Resources)localObject);
        int k = wja.dp2px(7.0F, (Resources)localObject);
        f4 = (paramCanvas.height() - k * 2) * 1.0F / (cLl - j * 2);
        f3 = this.kK[3] * f4;
      }
      for (;;)
      {
        float f2;
        if (this.bvU.startsWith("T")) {
          f2 = this.kK[1] - i;
        }
        for (;;)
        {
          label162:
          float f5;
          if (this.bvU.endsWith("L"))
          {
            f1 = this.kK[0];
            i = this.kK[2];
            if (this.textSize != 0) {
              paramPaint.setTextSize(f4 * this.textSize);
            }
            paramPaint.setAntiAlias(true);
            paramPaint.setFakeBoldText(true);
            localObject = adxn.a().a(paramadyk, paramadyk.bwm);
            Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
            f4 = adye.b(paramPaint, (String)localObject);
            f5 = f2 + f3 / 2.0F - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top;
            if (!this.textAlign.equals("center")) {
              break label403;
            }
            f2 = f1 + (i - f4) / 2.0F;
          }
          for (;;)
          {
            if (!paramadyk.bSb) {
              break label433;
            }
            f1 = paramCanvas.width() - f2 - f4;
            return new Rect((int)f1, (int)f5, (int)(i + f1), (int)(f3 + f5));
            if (!this.bvU.startsWith("B")) {
              break label460;
            }
            f2 = this.kK[1] + this.kK[3] + paramCanvas.height();
            f2 = i + (f2 - f3);
            break;
            if (!this.bvU.endsWith("R")) {
              break label162;
            }
            f1 = this.kK[0] + paramCanvas.width();
            break label162;
            label403:
            f2 = f1;
            if (this.textAlign.equals("right")) {
              f2 = f1 + i - f4;
            }
          }
          label433:
          return new Rect((int)f2, (int)f5, (int)(i + f2), (int)(f3 + f5));
          label460:
          f2 = 0.0F;
        }
        i = 0;
      }
    }
    
    public void a(adyk paramadyk, Canvas paramCanvas)
    {
      if ((paramCanvas == null) || (paramadyk == null)) {}
      String str;
      do
      {
        return;
        str = adxn.a().a(paramadyk, paramadyk.bwm);
      } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.bvU)));
      Paint localPaint = new Paint();
      if (this.textColor != -1) {
        localPaint.setColor(this.textColor);
      }
      paramadyk = a(paramadyk, paramCanvas, localPaint);
      paramCanvas.drawText(str, paramadyk.left, paramadyk.top, localPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adye
 * JD-Core Version:    0.7.0.1
 */