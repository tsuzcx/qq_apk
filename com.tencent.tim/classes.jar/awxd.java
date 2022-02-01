import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class awxd
  implements awxc
{
  private static final Double d = Double.valueOf(0.005D);
  private static final Double e = Double.valueOf(0.01D);
  private static final Double f = Double.valueOf(0.35D);
  private JSONObject cp;
  
  private JSONObject H(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("raw_base64", paramString);
      localJSONObject2.put("only_gender", 0);
      localJSONObject2.put("token", sy(paramString));
      paramString = awxb.h("https://tu.qq.com/cgi-bin/qq/get_face_detail.fcg", localJSONObject2.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private JSONObject I(String paramString)
  {
    long l = System.currentTimeMillis() / 1000L;
    String str = String.valueOf(l).hashCode() + "";
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("request_id", str);
      localJSONObject2.put("appid", "10301");
      localJSONObject2.put("raw_base64", paramString);
      localJSONObject2.put("user", "PTU");
      localJSONObject2.put("token", sy(paramString));
      paramString = awxb.h("https://tu.qq.com/cgi-bin/qq/do_image_classify.fcg", localJSONObject2.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private awxd.a a(Bitmap paramBitmap, ArrayList<awxc.a> paramArrayList)
  {
    awxd.a locala = new awxd.a();
    if ((paramBitmap == null) || (paramArrayList == null)) {
      return locala;
    }
    double d1 = paramBitmap.getWidth() * paramBitmap.getHeight();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramBitmap = (awxc.a)paramArrayList.get(i);
      int j = paramBitmap.eDB;
      double d2 = paramBitmap.eDA * j;
      double d3 = locala.jdField_do;
      locala.jdField_do = (d2 / d1 + d3);
      if (locala.jdField_do > d.doubleValue()) {
        locala.dtr = true;
      }
      i += 1;
    }
    if ((paramArrayList.size() > 1) && (locala.jdField_do > e.doubleValue())) {
      locala.dts = true;
    }
    return locala;
  }
  
  private awxf a(String paramString)
  {
    awxf localawxf = new awxf();
    if (paramString == null) {}
    do
    {
      return null;
      if (this.cp != null) {
        break;
      }
      this.cp = al();
    } while (this.cp == null);
    JSONArray localJSONArray1 = this.cp.optJSONArray("sceneList");
    int i = 0;
    while (i < localJSONArray1.length())
    {
      JSONObject localJSONObject1 = localJSONArray1.optJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject1.optJSONArray("sceneLvTwoList");
      int j = 0;
      JSONObject localJSONObject2;
      if (j < localJSONArray2.length())
      {
        localJSONObject2 = localJSONArray2.optJSONObject(j);
        if (localJSONObject2.optString("sceneName").equals(paramString))
        {
          localawxf.eDC = localJSONObject1.optInt("sceneLvOne");
          localawxf.eDD = localJSONObject2.optInt("sceneLvTwo");
          localawxf.sceneName = localJSONObject2.optString("sceneName");
          localawxf.cTq = localJSONObject2.optString("sceneFilterID");
          localawxf.dp = localJSONObject2.optDouble("sceneFilterPercent");
        }
      }
      else
      {
        i += 1;
        continue;
      }
      JSONArray localJSONArray3 = localJSONObject2.optJSONArray("sceneLabels");
      String[] arrayOfString = new String[localJSONArray3.length()];
      int k = 0;
      while (k < localJSONArray3.length())
      {
        arrayOfString[k] = localJSONArray3.optString(k);
        k += 1;
      }
      int m = arrayOfString.length;
      k = 0;
      for (;;)
      {
        if (k < m)
        {
          if (arrayOfString[k].equals(paramString))
          {
            localawxf.eDC = localJSONObject1.optInt("sceneLvOne");
            localawxf.eDD = localJSONObject2.optInt("sceneLvTwo");
            localawxf.sceneName = localJSONObject2.optString("sceneName");
            localawxf.cTq = localJSONObject2.optString("sceneFilterID");
            localawxf.dp = localJSONObject2.optDouble("sceneFilterPercent");
          }
        }
        else
        {
          j += 1;
          break;
        }
        k += 1;
      }
    }
    return localawxf;
  }
  
  private awxf a(JSONArray paramJSONArray)
  {
    double d2 = -1.0D;
    Object localObject1 = new awxf();
    Object localObject2 = localObject1;
    if (paramJSONArray.length() > 0)
    {
      int i = 0;
      double d3 = -1.0D;
      localObject2 = localObject1;
      if (i < paramJSONArray.length())
      {
        localObject2 = paramJSONArray.optJSONObject(i);
        Object localObject3 = ((JSONObject)localObject2).optString("label");
        double d4 = ((JSONObject)localObject2).optDouble("confidence");
        awxf localawxf = a((String)localObject3);
        double d6;
        double d5;
        if (localawxf == null)
        {
          d6 = d3;
          d5 = d2;
          localObject2 = localObject1;
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          d2 = d5;
          d3 = d6;
          break;
          localObject2 = localObject1;
          d5 = d2;
          d6 = d3;
          if (localawxf.eDD != -1)
          {
            localObject3 = localObject1;
            double d1 = d2;
            if (localawxf.eDC == 3)
            {
              localObject3 = localObject1;
              d1 = d2;
              if (d4 > f.doubleValue())
              {
                localObject3 = localObject1;
                d1 = d2;
                if (d4 > d2)
                {
                  d1 = d4;
                  localObject3 = localawxf;
                }
              }
            }
            localObject2 = localObject3;
            d5 = d1;
            d6 = d3;
            if (d4 > d3)
            {
              localObject2 = localObject3;
              d5 = d1;
              d6 = d3;
              if (d1 <= 0.0D)
              {
                localObject2 = localawxf;
                d5 = d1;
                d6 = d4;
              }
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  private JSONObject al()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(aqhq.py("video_story_aiSceneParams.json"));
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private String b(Bitmap paramBitmap, int paramInt)
  {
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    if (i > paramInt)
    {
      paramBitmap = akrf.b(paramBitmap, i / paramInt);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      return awxa.encode(localByteArrayOutputStream.toByteArray());
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return awxa.encode(localByteArrayOutputStream.toByteArray());
  }
  
  private String sy(String paramString)
  {
    int i = paramString.length();
    int j = i / 2;
    paramString = paramString.substring(j, (int)(i * 0.1D) + j);
    return getMD5(paramString + "9996ef4aa4fb4378826bc1f1a8409dd7");
  }
  
  public void a(Bitmap paramBitmap, ArrayList<awxc.a> paramArrayList, awxc.b paramb)
  {
    if (paramBitmap == null)
    {
      paramb.onFail("image is null");
      return;
    }
    long l = System.currentTimeMillis();
    awxf localawxf = new awxf();
    paramArrayList = a(paramBitmap, paramArrayList);
    paramBitmap = b(paramBitmap, 256);
    if (paramArrayList.dtr) {
      if (paramArrayList.dts) {
        paramBitmap = a(acfp.m(2131716185));
      }
    }
    while (paramBitmap == null)
    {
      paramb.onFail("unknown error");
      awxb.q(System.currentTimeMillis() - l, 1);
      return;
      paramBitmap = H(paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.isNull("retcode")))
      {
        paramb.onFail("network error");
        awxb.q(System.currentTimeMillis() - l, 1);
        return;
      }
      if ((paramBitmap != null) && (paramBitmap.has("retcode")) && (paramBitmap.optInt("retcode") == 0))
      {
        paramBitmap = paramBitmap.optJSONObject("retdata");
        int i = paramBitmap.optInt("age");
        int j = paramBitmap.optInt("gender");
        if (i <= 5) {
          paramBitmap = a(acfp.m(2131716188));
        } else if (j < 50) {
          paramBitmap = a(acfp.m(2131716186));
        } else {
          paramBitmap = a(acfp.m(2131716183));
        }
      }
      else
      {
        paramBitmap = a(acfp.m(2131716187));
        continue;
        paramArrayList = I(paramBitmap);
        if ((paramArrayList == null) || (paramArrayList.isNull("retcode")))
        {
          paramb.onFail("network error");
          l = System.currentTimeMillis() - l;
          awxb.q(l, 1);
          sqn.n("record_smart_filter", sqn.i(1L, l));
          return;
        }
        paramBitmap = localawxf;
        if (paramArrayList != null)
        {
          paramBitmap = localawxf;
          if (paramArrayList.has("retcode"))
          {
            paramBitmap = localawxf;
            if (paramArrayList.optInt("retcode") == 0)
            {
              paramArrayList = paramArrayList.optJSONObject("retdata");
              paramBitmap = localawxf;
              if (paramArrayList.has("message"))
              {
                paramBitmap = localawxf;
                if (paramArrayList.optString("message").equals("ok")) {
                  paramBitmap = a(paramArrayList.optJSONObject("data").optJSONArray("tags"));
                }
              }
            }
          }
        }
      }
    }
    paramb.b(paramBitmap);
    l = System.currentTimeMillis() - l;
    awxb.q(l, 0);
    sqn.n("record_smart_filter", sqn.i(0L, l));
  }
  
  public String getMD5(String paramString)
  {
    try
    {
      paramString = String.format("%032x", new Object[] { new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes())) });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  class a
  {
    public double jdField_do;
    public boolean dtr;
    public boolean dts;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxd
 * JD-Core Version:    0.7.0.1
 */