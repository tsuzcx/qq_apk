import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class ioe
{
  private static String ON = "hwcodec_new2";
  private static String OO = "sharp/hwcodec_new/";
  private static String OP = "sharp/hwcodec_new2/";
  private static String OQ = "avc_decoder/";
  private static String OR = "avc_encoder/";
  private static String OT = "hevc_decoder/";
  private static String OU = "hevc_encoder/";
  private static String OV = "test/";
  private static String OW;
  private static String OX;
  private static String OY = "async/";
  private static String OZ = "min_sdk";
  private static String Pa = "codec";
  private static String str_black_list;
  private static String str_codec;
  private static String str_disable_sdk;
  private static String str_fingerprint;
  private static String str_min_sdk;
  private static String str_min_version;
  private static String str_model;
  private static String str_product;
  private static String str_sdk;
  private static String str_test_async_min_sdk = "async_min_sdk";
  private static String str_version;
  private static String str_white_list = "white_list/";
  private String PA;
  private String PB = OO;
  private String Pb;
  private String Pc;
  private String Pd;
  private String Pe;
  private String Pf;
  private String Pg;
  private String Ph;
  private String Pi;
  private String Pj;
  private String Pk;
  private String Pl;
  private String Pm;
  private String Pn;
  private String Po;
  private String Pp;
  private String Pq;
  private String Pr;
  private String Ps;
  private String Pt;
  private String Pu;
  private String Pv;
  private String Pw;
  private String Px;
  private String Py;
  private String Pz;
  private int aqR = 1;
  private imf b;
  private String key_async_codec;
  private String key_async_min_sdk;
  private String key_avcdec_bl_fingerprint;
  private String key_avcdec_bl_model;
  private String key_avcdec_bl_product;
  private String key_avcdec_bl_sdk;
  private String key_avcdec_bl_version;
  private String key_avcdec_wl_min_version;
  private String key_avcenc_bl_fingerprint;
  private String key_avcenc_bl_model;
  private String key_avcenc_bl_product;
  private String key_avcenc_bl_sdk;
  private String key_avcenc_bl_version;
  private String key_avcenc_wl_min_version;
  private String key_test_async_min_sdk;
  private String key_test_codec;
  private String key_test_disable_sdk;
  
  static
  {
    str_black_list = "black_list/";
    str_min_sdk = "min_sdk";
    str_min_version = "min_version";
    OW = "max_w";
    OX = "max_h";
    str_model = "model";
    str_product = "product";
    str_fingerprint = "fingerprint";
    str_sdk = "sdk";
    str_version = "version";
    str_codec = "codec";
    str_disable_sdk = "disable_sdk";
  }
  
  public ioe(imf paramimf)
  {
    if ((paramimf != null) && (!paramimf.isEmpty()) && (paramimf.getData().contains(ON))) {
      this.aqR = 2;
    }
    this.b = paramimf;
    if (this.aqR == 2) {}
    for (paramimf = OP;; paramimf = OO)
    {
      this.PB = paramimf;
      QLog.i("CodecConfigParser", 1, "ver = " + this.aqR + ", root = " + this.PB);
      this.Pb = (this.PB + OV + str_min_sdk);
      this.key_test_disable_sdk = (this.PB + OV + str_disable_sdk);
      this.key_test_codec = (this.PB + OV + str_codec);
      this.key_test_async_min_sdk = (this.PB + OV + str_test_async_min_sdk);
      this.Pc = (this.PB + OV + str_min_version);
      this.Pd = (this.PB + OQ + str_white_list + str_min_sdk);
      this.key_avcdec_wl_min_version = (this.PB + OQ + str_white_list + str_min_version);
      this.key_avcdec_bl_model = (this.PB + OQ + str_black_list + str_model);
      this.key_avcdec_bl_product = (this.PB + OQ + str_black_list + str_product);
      this.key_avcdec_bl_fingerprint = (this.PB + OQ + str_black_list + str_fingerprint);
      this.key_avcdec_bl_sdk = (this.PB + OQ + str_black_list + str_sdk);
      this.key_avcdec_bl_version = (this.PB + OQ + str_black_list + str_version);
      this.Pe = (this.PB + OQ + str_white_list + OW);
      this.Pf = (this.PB + OQ + str_white_list + OX);
      this.Pg = (this.PB + OR + str_white_list + str_min_sdk);
      this.key_avcenc_wl_min_version = (this.PB + OR + str_white_list + str_min_version);
      this.key_avcenc_bl_model = (this.PB + OR + str_black_list + str_model);
      this.key_avcenc_bl_product = (this.PB + OR + str_black_list + str_product);
      this.key_avcenc_bl_fingerprint = (this.PB + OR + str_black_list + str_fingerprint);
      this.key_avcenc_bl_sdk = (this.PB + OR + str_black_list + str_sdk);
      this.key_avcenc_bl_version = (this.PB + OR + str_black_list + str_version);
      this.Ph = (this.PB + OR + str_white_list + OW);
      this.Pi = (this.PB + OR + str_white_list + OX);
      this.Pj = (this.PB + OT + str_white_list + str_min_sdk);
      this.Pk = (this.PB + OT + str_white_list + str_min_version);
      this.Pl = (this.PB + OT + str_black_list + str_model);
      this.Pm = (this.PB + OT + str_black_list + str_product);
      this.Pn = (this.PB + OT + str_black_list + str_fingerprint);
      this.Po = (this.PB + OT + str_black_list + str_sdk);
      this.Pp = (this.PB + OT + str_black_list + str_version);
      this.Pq = (this.PB + OT + str_white_list + OW);
      this.Pr = (this.PB + OT + str_white_list + OX);
      this.Ps = (this.PB + OU + str_white_list + str_min_sdk);
      this.Pt = (this.PB + OU + str_white_list + str_min_version);
      this.Pu = (this.PB + OU + str_black_list + str_model);
      this.Pv = (this.PB + OU + str_black_list + str_product);
      this.Pw = (this.PB + OU + str_black_list + str_fingerprint);
      this.Px = (this.PB + OU + str_black_list + str_sdk);
      this.Py = (this.PB + OU + str_black_list + str_version);
      this.Pz = (this.PB + OU + str_white_list + OW);
      this.PA = (this.PB + OU + str_white_list + OX);
      this.key_async_min_sdk = (this.PB + OY + OZ);
      this.key_async_codec = (this.PB + OY + Pa);
      return;
    }
  }
  
  public static int a(igi.c paramc)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    while ((paramc == null) || (Build.VERSION.SDK_INT < paramc.akV) || (!b(paramc.LP, null)) || (jjd.a(paramc.hX, Integer.valueOf(Build.VERSION.SDK_INT)))) {
      return 0;
    }
    if ((paramc.akW != 0) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= paramc.akW)) {
      return 2;
    }
    return 1;
  }
  
  static boolean b(String paramString, String[] paramArrayOfString)
  {
    int j = jll.mM();
    if (jll.az(paramString) > j) {
      return false;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString != null))
    {
      int k = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label51;
        }
        if (jll.az(paramArrayOfString[i]) == j) {
          break;
        }
        i += 1;
      }
    }
    label51:
    return true;
  }
  
  public ioc.b a()
  {
    int j = 0;
    if (this.b == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        ioc.b localb = new ioc.b(4, true);
        try
        {
          Object localObject = a(this.b, this.Pj);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.b, this.Pk, this.Pp)))
          {
            localObject = a(this.b, this.Po);
            int i;
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i]) {
                  break;
                }
                i += 1;
              }
            }
            label122:
            localObject = a(this.b, this.Pl);
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label170:
            localObject = a(this.b, this.Pm);
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label218:
            localObject = a(this.b, this.Pn);
            if (localObject != null)
            {
              i = j;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label266:
            localObject = a(this.b, this.Pq);
            if ((localObject != null) && (localObject[0] > 0)) {
              localb.aqP = localObject[0];
            }
            localObject = a(this.b, this.Pr);
            if ((localObject != null) && (localObject[0] > 0)) {
              localb.aqQ = localObject[0];
            }
            return localb;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  boolean a(imf paramimf, String paramString1, String paramString2)
  {
    if (this.aqR != 2) {}
    for (;;)
    {
      return true;
      int j = jll.mM();
      if (jll.az(paramimf.getStringValue(paramString1, "")) > j) {
        return false;
      }
      if (paramString2 != null)
      {
        paramimf = paramimf.getStringValues(paramString2);
        if (paramimf != null)
        {
          int k = paramimf.length;
          int i = 0;
          while (i < k)
          {
            if (jll.az(paramimf[i]) == j) {
              return false;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  int[] a(imf paramimf, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramimf.getIntValues(paramString);
  }
  
  String[] a(imf paramimf, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramimf.getStringValues(paramString);
  }
  
  public ioc.b b()
  {
    int j = 0;
    if (this.b == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < 19.");
      return null;
    }
    ioc.b localb = new ioc.b(8, true);
    try
    {
      localObject = a(this.b, this.Ps);
      if (localObject == null)
      {
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. minsdk == null.");
        return null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. err msg = " + localException.getMessage());
      return null;
    }
    if (Build.VERSION.SDK_INT < localObject[0])
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < minsdk[0]. minsdk[0] = " + localObject[0]);
      return null;
    }
    if (!a(this.b, this.Pt, this.Py))
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. checkQQVer failed.");
      return null;
    }
    Object localObject = a(this.b, this.Px);
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i < localObject.length)
      {
        if (Build.VERSION.SDK_INT != localObject[i]) {
          break label453;
        }
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT == disablesdk[i].");
        return null;
      }
    }
    localObject = a(this.b, this.Pu);
    if (localObject != null)
    {
      i = 0;
      label248:
      if (i < localObject.length)
      {
        if (!Build.MODEL.equalsIgnoreCase(localObject[i])) {
          break label460;
        }
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.MODEL.equalsIgnoreCase(models[i]).");
        return null;
      }
    }
    localObject = a(this.b, this.Pv);
    if (localObject != null)
    {
      i = 0;
      label300:
      if (i < localObject.length)
      {
        if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
          break label467;
        }
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(products[i]).");
        return null;
      }
    }
    localObject = a(this.b, this.Pw);
    if (localObject != null) {
      i = j;
    }
    for (;;)
    {
      if (i < localObject.length)
      {
        if (Build.PRODUCT.equalsIgnoreCase(localObject[i]))
        {
          QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(fingerprints[i].");
          return null;
        }
      }
      else
      {
        localObject = a(this.b, this.Pz);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.aqP = localObject[0];
        }
        localObject = a(this.b, this.PA);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.aqQ = localObject[0];
        }
        return localException;
        label453:
        i += 1;
        break;
        label460:
        i += 1;
        break label248;
        label467:
        i += 1;
        break label300;
      }
      i += 1;
    }
  }
  
  public ioc.b c()
  {
    int j = 0;
    if (this.b == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        ioc.b localb = new ioc.b(1, true);
        try
        {
          Object localObject = a(this.b, this.Pd);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.b, this.key_avcdec_wl_min_version, this.key_avcdec_bl_version)))
          {
            localObject = a(this.b, this.key_avcdec_bl_sdk);
            int i;
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i]) {
                  break;
                }
                i += 1;
              }
            }
            label122:
            localObject = a(this.b, this.key_avcdec_bl_model);
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label170:
            localObject = a(this.b, this.key_avcdec_bl_product);
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label218:
            localObject = a(this.b, this.key_avcdec_bl_fingerprint);
            if (localObject != null)
            {
              i = j;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label266:
            localObject = a(this.b, this.Pe);
            if ((localObject != null) && (localObject[0] > 0)) {
              localb.aqP = localObject[0];
            }
            localObject = a(this.b, this.Pf);
            if ((localObject != null) && (localObject[0] > 0)) {
              localb.aqQ = localObject[0];
            }
            return localb;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  public ioc.b d()
  {
    int j = 0;
    if (this.b == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 19)
      {
        ioc.b localb = new ioc.b(2, true);
        try
        {
          Object localObject = a(this.b, this.Pg);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.b, this.key_avcenc_wl_min_version, this.key_avcenc_bl_version)))
          {
            localObject = a(this.b, this.key_avcenc_bl_sdk);
            int i;
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i]) {
                  break;
                }
                i += 1;
              }
            }
            label122:
            localObject = a(this.b, this.key_avcenc_bl_model);
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label170:
            localObject = a(this.b, this.key_avcenc_bl_product);
            if (localObject != null)
            {
              i = 0;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label218:
            localObject = a(this.b, this.key_avcenc_bl_fingerprint);
            if (localObject != null)
            {
              i = j;
              for (;;)
              {
                if (i >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
                  break;
                }
                i += 1;
              }
            }
            label266:
            localObject = a(this.b, this.Ph);
            if ((localObject != null) && (localObject[0] > 0)) {
              localb.aqP = localObject[0];
            }
            localObject = a(this.b, this.Pi);
            if ((localObject != null) && (localObject[0] > 0)) {
              localb.aqQ = localObject[0];
            }
            return localb;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  public boolean isEnableAsyncApi(int paramInt)
  {
    if (this.b == null) {}
    for (;;)
    {
      return false;
      try
      {
        int[] arrayOfInt = a(this.b, this.key_async_min_sdk);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          arrayOfInt = a(this.b, this.key_async_codec);
          if (arrayOfInt != null)
          {
            boolean bool = jjd.contains(arrayOfInt, paramInt);
            if (bool) {
              return true;
            }
          }
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioe
 * JD-Core Version:    0.7.0.1
 */