package com.tencent.biz.qrcode;

import acbn;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import aqfo;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rwt;

public class CodeMaskManager
{
  private static final String aCa = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath() + "/qbiz/qrcode/";
  private Bundle L;
  protected int bvo;
  protected Activity context;
  protected Thread g;
  protected boolean isReleased;
  protected int lastIndex = -1;
  protected Handler mHandler;
  protected List<Bundle> pl;
  protected List<Bundle> pm;
  
  static
  {
    if (aqfo.isExistSDCard())
    {
      aCa = acbn.SDCARD_PATH + "qbiz/qrcode/";
      return;
    }
  }
  
  public CodeMaskManager(Activity paramActivity, int paramInt)
  {
    this.context = paramActivity;
    this.pm = new Vector();
    xX(paramInt);
    this.pl = this.pm;
    xY(tX());
    this.mHandler = new Handler();
  }
  
  /* Error */
  private boolean b(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_2
    //   9: ifnull +90 -> 99
    //   12: new 73	java/io/File
    //   15: dup
    //   16: getstatic 59	com/tencent/biz/qrcode/CodeMaskManager:aCa	Ljava/lang/String;
    //   19: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 137	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 73	java/io/File
    //   29: dup
    //   30: new 39	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 59	com/tencent/biz/qrcode/CodeMaskManager:aCa	Ljava/lang/String;
    //   40: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 140	java/io/File:exists	()Z
    //   58: ifne +8 -> 66
    //   61: aload_1
    //   62: invokevirtual 143	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: new 145	java/io/FileOutputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_2
    //   77: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   80: iconst_1
    //   81: istore 4
    //   83: iload 4
    //   85: istore_3
    //   86: aload_1
    //   87: ifnull +10 -> 97
    //   90: aload_1
    //   91: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   94: iload 4
    //   96: istore_3
    //   97: iload_3
    //   98: ireturn
    //   99: iconst_0
    //   100: ifeq -3 -> 97
    //   103: new 157	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aload 6
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull -22 -> 97
    //   122: aload_1
    //   123: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_1
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: aload 5
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_2
    //   149: goto -6 -> 143
    //   152: astore 5
    //   154: aload_1
    //   155: astore_2
    //   156: aload 5
    //   158: astore_1
    //   159: goto -24 -> 135
    //   162: astore_2
    //   163: goto -45 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	CodeMaskManager
    //   0	166	1	paramString	String
    //   0	166	2	paramArrayOfByte	byte[]
    //   1	97	3	bool1	boolean
    //   81	14	4	bool2	boolean
    //   3	130	5	localObject1	Object
    //   152	5	5	localObject2	Object
    //   6	110	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   12	66	114	java/io/IOException
    //   66	75	114	java/io/IOException
    //   122	126	128	java/io/IOException
    //   12	66	131	finally
    //   66	75	131	finally
    //   90	94	145	java/io/IOException
    //   139	143	148	java/io/IOException
    //   75	80	152	finally
    //   75	80	162	java/io/IOException
  }
  
  private void bwt()
  {
    this.lastIndex = this.bvo;
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("qrcode", 0).edit();
    localEditor.putInt("lastIndex", this.lastIndex);
    localEditor.commit();
  }
  
  private int em(int paramInt)
  {
    int i = 0;
    if (paramInt < 1) {
      throw new IllegalArgumentException("qrcode mask build-in list should have at least 1 item");
    }
    if (paramInt == 1) {
      paramInt = i;
    }
    for (;;)
    {
      this.bvo = paramInt;
      return this.bvo;
      if (this.lastIndex == -1)
      {
        int j = this.context.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
        if (j >= 0)
        {
          i = j;
          if (j < paramInt) {}
        }
        else
        {
          i = 0;
        }
        paramInt = i;
      }
      else
      {
        i = (int)(Math.random() * (paramInt - 1));
        paramInt = i;
        if (i >= this.lastIndex) {
          paramInt = i + 1;
        }
      }
    }
  }
  
  private Bundle g()
  {
    int i = em(this.pm.size());
    return g((Bundle)this.pm.get(i));
  }
  
  private Bundle g(Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("bkgRes"))
    {
      i = paramBundle.getInt("bkgRes");
      paramBundle.remove("bkg");
      if (i == 0) {}
    }
    try
    {
      paramBundle.putParcelable("bkg", BitmapFactory.decodeResource(this.context.getResources(), i));
      label43:
      if (paramBundle.containsKey("qrbkgRes"))
      {
        i = paramBundle.getInt("qrbkgRes");
        paramBundle.remove("qrbkg");
        if (i == 0) {}
      }
      try
      {
        paramBundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.context.getResources(), i));
        label86:
        return (Bundle)paramBundle.clone();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        break label86;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label43;
    }
  }
  
  /* Error */
  private Bitmap getImage(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnull +13 -> 17
    //   7: aload_1
    //   8: ldc_w 259
    //   11: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +7 -> 21
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_2
    //   20: areturn
    //   21: aload_1
    //   22: astore 6
    //   24: aload_1
    //   25: ldc_w 267
    //   28: invokevirtual 270	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: ifne +38 -> 69
    //   34: aload_1
    //   35: astore 6
    //   37: aload_1
    //   38: ldc_w 272
    //   41: invokevirtual 270	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifne +25 -> 69
    //   47: new 39	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 274
    //   57: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 6
    //   69: aload 6
    //   71: invokestatic 280	aoiz:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 7
    //   76: new 282	java/io/FileInputStream
    //   79: dup
    //   80: new 39	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   87: getstatic 59	com/tencent/biz/qrcode/CodeMaskManager:aCa	Ljava/lang/String;
    //   90: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 7
    //   95: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 283	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   104: astore_2
    //   105: new 285	java/io/BufferedInputStream
    //   108: dup
    //   109: aload_2
    //   110: sipush 8192
    //   113: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   116: astore_1
    //   117: aload_1
    //   118: astore 4
    //   120: aload_2
    //   121: astore_3
    //   122: aload_1
    //   123: invokestatic 292	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   126: astore 5
    //   128: aload 5
    //   130: astore_3
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 293	java/io/BufferedInputStream:close	()V
    //   139: aload_3
    //   140: astore_1
    //   141: aload_2
    //   142: ifnull +9 -> 151
    //   145: aload_2
    //   146: invokevirtual 294	java/io/FileInputStream:close	()V
    //   149: aload_3
    //   150: astore_1
    //   151: aload_1
    //   152: astore_2
    //   153: aload_1
    //   154: ifnonnull -135 -> 19
    //   157: aload_0
    //   158: getfield 85	com/tencent/biz/qrcode/CodeMaskManager:context	Landroid/app/Activity;
    //   161: ldc_w 296
    //   164: aload 6
    //   166: invokestatic 302	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   169: ldc_w 304
    //   172: aconst_null
    //   173: aconst_null
    //   174: invokestatic 309	jqc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull +11 -> 190
    //   182: aload_2
    //   183: iconst_0
    //   184: aload_2
    //   185: arraylength
    //   186: invokestatic 313	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   189: astore_1
    //   190: aload_1
    //   191: ifnonnull +101 -> 292
    //   194: new 111	java/io/IOException
    //   197: dup
    //   198: ldc_w 314
    //   201: invokestatic 320	acfp:m	(I)Ljava/lang/String;
    //   204: invokespecial 321	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   207: athrow
    //   208: astore 5
    //   210: aconst_null
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: aload_1
    //   215: astore 4
    //   217: aload_2
    //   218: astore_3
    //   219: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +20 -> 242
    //   225: aload_1
    //   226: astore 4
    //   228: aload_2
    //   229: astore_3
    //   230: ldc_w 328
    //   233: iconst_2
    //   234: aload 5
    //   236: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_1
    //   243: ifnull +7 -> 250
    //   246: aload_1
    //   247: invokevirtual 293	java/io/BufferedInputStream:close	()V
    //   250: aload_2
    //   251: ifnull +95 -> 346
    //   254: aload_2
    //   255: invokevirtual 294	java/io/FileInputStream:close	()V
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -109 -> 151
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -115 -> 151
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_2
    //   272: aload 4
    //   274: ifnull +8 -> 282
    //   277: aload 4
    //   279: invokevirtual 293	java/io/BufferedInputStream:close	()V
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 294	java/io/FileInputStream:close	()V
    //   290: aload_1
    //   291: athrow
    //   292: aload_0
    //   293: aload 7
    //   295: aload_2
    //   296: invokespecial 337	com/tencent/biz/qrcode/CodeMaskManager:b	(Ljava/lang/String;[B)Z
    //   299: pop
    //   300: aload_1
    //   301: areturn
    //   302: astore_1
    //   303: goto -164 -> 139
    //   306: astore_1
    //   307: aload_3
    //   308: astore_1
    //   309: goto -158 -> 151
    //   312: astore_1
    //   313: goto -63 -> 250
    //   316: astore_3
    //   317: goto -35 -> 282
    //   320: astore_2
    //   321: goto -31 -> 290
    //   324: astore_1
    //   325: goto -53 -> 272
    //   328: astore_1
    //   329: aload_3
    //   330: astore_2
    //   331: goto -59 -> 272
    //   334: astore 5
    //   336: aconst_null
    //   337: astore_1
    //   338: goto -124 -> 214
    //   341: astore 5
    //   343: goto -129 -> 214
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -197 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	CodeMaskManager
    //   0	351	1	paramString	String
    //   18	278	2	localObject1	Object
    //   320	1	2	localIOException1	IOException
    //   330	1	2	localObject2	Object
    //   121	187	3	localObject3	Object
    //   316	14	3	localIOException2	IOException
    //   1	277	4	str1	String
    //   126	3	5	localBitmap	Bitmap
    //   208	27	5	localException1	Exception
    //   334	1	5	localException2	Exception
    //   341	1	5	localException3	Exception
    //   22	143	6	str2	String
    //   74	220	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   76	105	208	java/lang/Exception
    //   254	258	263	java/io/IOException
    //   76	105	269	finally
    //   135	139	302	java/io/IOException
    //   145	149	306	java/io/IOException
    //   246	250	312	java/io/IOException
    //   277	282	316	java/io/IOException
    //   286	290	320	java/io/IOException
    //   105	117	324	finally
    //   122	128	328	finally
    //   219	225	328	finally
    //   230	242	328	finally
    //   105	117	334	java/lang/Exception
    //   122	128	341	java/lang/Exception
  }
  
  private void j(JSONArray paramJSONArray)
  {
    if (this.isReleased) {}
    for (;;)
    {
      return;
      this.pl = new Vector(this.pm);
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          Bundle localBundle = new Bundle();
          if (localJSONObject.has("bkg")) {
            localBundle.putString("bkgUrl", localJSONObject.getString("bkg"));
          }
          localBundle.putInt("nameClr", (int)Long.parseLong(localJSONObject.getString("nameClr"), 16));
          localBundle.putInt("tipsClr", (int)Long.parseLong(localJSONObject.getString("tipsClr"), 16));
          if (localJSONObject.has("qrbkg")) {
            localBundle.putString("qrbkgUrl", localJSONObject.getString("qrbkg"));
          }
          Object localObject;
          int k;
          int m;
          int n;
          int i1;
          if (localJSONObject.has("qrloc"))
          {
            localObject = localJSONObject.getJSONArray("qrloc");
            j = ((JSONArray)localObject).getInt(0);
            k = ((JSONArray)localObject).getInt(1);
            m = ((JSONArray)localObject).getInt(0);
            n = ((JSONArray)localObject).getInt(2);
            i1 = ((JSONArray)localObject).getInt(1);
            localBundle.putParcelable("qrloc", new Rect(j, k, m + n, ((JSONArray)localObject).getInt(3) + i1));
          }
          if (localJSONObject.has("qrsz")) {
            localBundle.putInt("qrsz", localJSONObject.getInt("qrsz"));
          }
          if (localJSONObject.has("clip"))
          {
            localObject = new ArrayList();
            JSONArray localJSONArray1 = localJSONObject.getJSONArray("clip");
            j = 0;
            while (j < localJSONArray1.length())
            {
              JSONArray localJSONArray2 = localJSONArray1.getJSONArray(j);
              k = localJSONArray2.getInt(0);
              m = localJSONArray2.getInt(1);
              n = localJSONArray2.getInt(0);
              i1 = localJSONArray2.getInt(2);
              int i2 = localJSONArray2.getInt(1);
              ((ArrayList)localObject).add(new Rect(k, m, n + i1, localJSONArray2.getInt(3) + i2));
              j += 1;
            }
            localBundle.putParcelableArrayList("clip", (ArrayList)localObject);
          }
          localBundle.putInt("B", (int)Long.parseLong(localJSONObject.getString("B"), 16));
          if (localJSONObject.has("W")) {
            localBundle.putInt("W", (int)Long.parseLong(localJSONObject.getString("W"), 16));
          }
          for (;;)
          {
            try
            {
              localBundle.putInt("head", localJSONObject.getInt("head"));
              localBundle.putInt("v", localJSONObject.getInt("v"));
              localBundle.putInt("type", 2);
              this.pl.add(localBundle);
            }
            catch (Exception localException)
            {
              if (!localJSONObject.getBoolean("head")) {
                break;
              }
            }
            localBundle.putInt("W", 16777215);
          }
          for (int j = 1;; j = 0)
          {
            localBundle.putInt("head", j);
            break;
          }
        }
        catch (JSONException localJSONException)
        {
          label556:
          break label556;
        }
        i += 1;
      }
    }
  }
  
  private int tX()
  {
    try
    {
      Object localObject = this.context.getSharedPreferences("qrcode", 0).getString("tpl_json", null);
      if (localObject == null) {
        return 0;
      }
      localObject = new JSONObject((String)localObject);
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("tpls");
      if (localJSONArray.length() > 0)
      {
        j(localJSONArray);
        int i = ((JSONObject)localObject).getInt("t");
        return i;
      }
    }
    catch (JSONException localJSONException) {}
    return 0;
  }
  
  private void xX(int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramInt == 1)
    {
      localBundle.putInt("qrbkgRes", 2130844060);
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", 0);
      localBundle.putInt("W", -1);
      localBundle.putParcelable("qrloc", new Rect(126, 156, 413, 443));
      localBundle.putInt("head", 0);
      localBundle.putInt("type", 1);
    }
    for (;;)
    {
      this.pm.add(localBundle);
      return;
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", -16777216);
      localBundle.putInt("W", 16777215);
      localBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      localBundle.putInt("head", 1);
      localBundle.putInt("type", 1);
    }
  }
  
  private void xY(int paramInt)
  {
    if (this.g != null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      localSharedPreferences = this.context.getSharedPreferences("qrcode", 0);
      l = localSharedPreferences.getLong("updateTemplate2", 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
    Display localDisplay = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getHeight();
    this.g = new CodeMaskManager.1(this, "qr_code_mask_update_extenal_thread", localSharedPreferences, localDisplay.getWidth(), i, paramInt);
    this.g.start();
  }
  
  public void a(a parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    if (this.isReleased) {
      return;
    }
    if (paramBoolean3)
    {
      new Bundle();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("bkgRes", 0);
      ((Bundle)localObject).putInt("nameClr", -16777216);
      ((Bundle)localObject).putInt("tipsClr", -8947849);
      ((Bundle)localObject).putInt("W", 16777215);
      ((Bundle)localObject).putInt("B", -16777216);
      ((Bundle)localObject).putInt("head", 0);
      ((Bundle)localObject).putInt("type", 1);
      parama.aX(g((Bundle)localObject));
      return;
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.L == null)
      {
        this.L = new Bundle();
        this.L.putInt("bkgRes", 0);
        this.L.putInt("nameClr", -16777216);
        this.L.putInt("tipsClr", -8947849);
        this.L.putInt("W", 0);
        this.L.putInt("B", -9947128);
        if (paramInt != 2) {
          break label254;
        }
        this.L.putInt("head", 3);
      }
      for (;;)
      {
        this.L.putInt("type", 1);
        parama.aX(g(this.L));
        return;
        label254:
        if (paramInt == 1) {
          this.L.putInt("head", 4);
        }
      }
    }
    int i = em(this.pl.size());
    if (i >= 0)
    {
      paramInt = i;
      if (i < this.pl.size()) {}
    }
    else
    {
      paramInt = 0;
    }
    Object localObject = (Bundle)this.pl.get(paramInt);
    if (((Bundle)localObject).getInt("type") == 1)
    {
      parama.aX(g((Bundle)localObject));
      bwt();
      return;
    }
    localObject = new PrepareBundleTask(parama, (Bundle)localObject);
    this.mHandler.postDelayed(new CodeMaskManager.2(this, (PrepareBundleTask)localObject, parama), 10000L);
    ((PrepareBundleTask)localObject).start();
  }
  
  public void release()
  {
    this.isReleased = true;
    Iterator localIterator = this.pl.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Bundle)localIterator.next();
      Bitmap localBitmap = (Bitmap)((Bundle)localObject).getParcelable("bkg");
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      localObject = (Bitmap)((Bundle)localObject).getParcelable("qrbkg");
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.pm.clear();
    this.pl.clear();
  }
  
  class PrepareBundleTask
    extends Thread
  {
    Bundle M;
    CodeMaskManager.a b;
    AtomicBoolean bd = new AtomicBoolean(false);
    
    PrepareBundleTask(CodeMaskManager.a parama, Bundle paramBundle)
    {
      super();
      this.b = parama;
      this.M = paramBundle;
    }
    
    Bundle h()
    {
      try
      {
        if (this.M.containsKey("qrsz"))
        {
          Object localObject1 = ((QRDisplayActivity)CodeMaskManager.this.context).getData();
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool) {
            try
            {
              localObject1 = rwt.a((String)localObject1, this.M.getInt("qrsz"));
              if (localObject1 == null) {
                return null;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localObject2 = null;
              }
            }
          }
        }
        if (this.M.containsKey("bkgUrl"))
        {
          localObject2 = CodeMaskManager.a(CodeMaskManager.this, this.M.getString("bkgUrl"));
          this.M.putParcelable("bkg", (Parcelable)localObject2);
          this.M.remove("bkgUrl");
        }
        if (this.M.containsKey("qrbkgUrl"))
        {
          localObject2 = CodeMaskManager.a(CodeMaskManager.this, this.M.getString("qrbkgUrl"));
          this.M.putParcelable("qrbkg", (Parcelable)localObject2);
          this.M.remove("qrbkgUrl");
        }
        Object localObject2 = this.M;
        return localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CodeMaskManager", 2, localOutOfMemoryError.getMessage());
        }
        System.gc();
        return null;
      }
      catch (IOException localIOException)
      {
        label184:
        break label184;
      }
    }
    
    public void run()
    {
      Bundle localBundle = h();
      if (this.bd.compareAndSet(false, true)) {
        CodeMaskManager.this.mHandler.post(new CodeMaskManager.PrepareBundleTask.1(this, localBundle));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aX(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager
 * JD-Core Version:    0.7.0.1
 */