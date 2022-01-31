package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ot;
import ov;
import ow;

public class CodeMaskManager
{
  private static final String jdField_a_of_type_JavaLangString = "http://qm.qq.com/cgi-bin/tpl";
  private static final String b;
  private static final int jdField_c_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = "http://pub.idqqimg.com/qqmobile/qrcode/images/";
  private static final int jdField_d_of_type_Int = 2;
  private static final String jdField_d_of_type_JavaLangString = "qrcode";
  private static final int jdField_e_of_type_Int = 10000;
  private static final String jdField_e_of_type_JavaLangString = "updateTemplate2";
  private static final String f = "lastIndex";
  private static final String g = "tpl_json";
  protected int a;
  public Activity a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  public Thread a;
  protected List a;
  public boolean a;
  protected int b;
  protected List b;
  
  static
  {
    if (SystemUtil.a())
    {
      jdField_b_of_type_JavaLangString = AppConstants.as + "qbiz/qrcode/";
      return;
    }
    jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath() + "/qbiz/qrcode/";
  }
  
  public CodeMaskManager(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaUtilList = new Vector();
    b();
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
    a(a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getString("tpl_json", null);
      if (localObject == null) {
        return 0;
      }
      localObject = new JSONObject((String)localObject);
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("tpls");
      if (localJSONArray.length() > 0)
      {
        a(localJSONArray);
        int i = ((JSONObject)localObject).getInt("t");
        return i;
      }
    }
    catch (JSONException localJSONException) {}
    return 0;
  }
  
  private int a(int paramInt)
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
      this.jdField_b_of_type_Int = paramInt;
      return this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int == -1)
      {
        int j = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
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
        if (i >= this.jdField_a_of_type_Int) {
          paramInt = i + 1;
        }
      }
    }
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject2;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject2 = null;
    }
    String str;
    do
    {
      return localObject2;
      localObject1 = paramString;
      if (!paramString.startsWith("http://")) {
        localObject1 = "http://pub.idqqimg.com/qqmobile/qrcode/images/" + paramString;
      }
      str = AbsDownloader.c((String)localObject1);
      paramString = BitmapFactory.decodeFile(jdField_b_of_type_JavaLangString + str);
      localObject2 = paramString;
    } while (paramString != null);
    Object localObject1 = HttpUtil.a(this.jdField_a_of_type_AndroidAppActivity, MsfSdkUtils.insertMtype("codemask", (String)localObject1), "GET", null, null);
    if (localObject1 != null) {
      paramString = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
    }
    if (paramString == null) {
      throw new IOException("拉取图片失败");
    }
    a(str, (byte[])localObject1);
    return paramString;
  }
  
  private Bundle a()
  {
    int i = a(this.jdField_b_of_type_JavaUtilList.size());
    return a((Bundle)this.jdField_b_of_type_JavaUtilList.get(i));
  }
  
  private Bundle a(Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("bkgRes"))
    {
      i = paramBundle.getInt("bkgRes");
      paramBundle.remove("bkg");
      if (i != 0) {
        paramBundle.putParcelable("bkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
      }
    }
    if (paramBundle.containsKey("qrbkgRes"))
    {
      i = paramBundle.getInt("qrbkgRes");
      paramBundle.remove("qrbkg");
      if (i != 0) {
        paramBundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
      }
    }
    return (Bundle)paramBundle.clone();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0);
      l = localSharedPreferences.getLong("updateTemplate2", 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getHeight();
    this.jdField_a_of_type_JavaLangThread = new ot(this, localSharedPreferences, localDisplay.getWidth(), i, paramInt);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = new Vector(this.jdField_b_of_type_JavaUtilList);
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
              this.jdField_a_of_type_JavaUtilList.add(localBundle);
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
          label558:
          break label558;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_2
    //   6: ifnull +81 -> 87
    //   9: new 77	java/io/File
    //   12: dup
    //   13: getstatic 63	com/tencent/biz/qrcode/CodeMaskManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 399	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 402	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: new 77	java/io/File
    //   26: dup
    //   27: new 43	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   34: getstatic 63	com/tencent/biz/qrcode/CodeMaskManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 399	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 405	java/io/File:exists	()Z
    //   55: ifne +8 -> 63
    //   58: aload_1
    //   59: invokevirtual 408	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: new 410	java/io/FileOutputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 417	java/io/FileOutputStream:write	([B)V
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: iconst_0
    //   88: ifeq -3 -> 85
    //   91: new 422	java/lang/NullPointerException
    //   94: dup
    //   95: invokespecial 423	java/lang/NullPointerException:<init>	()V
    //   98: athrow
    //   99: astore_1
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload 4
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull -22 -> 85
    //   110: aload_1
    //   111: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_1
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_1
    //   120: aload_3
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull -38 -> 85
    //   126: aload_1
    //   127: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_1
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_1
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_2
    //   139: goto -17 -> 122
    //   142: astore_2
    //   143: goto -37 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	CodeMaskManager
    //   0	146	1	paramString	String
    //   0	146	2	paramArrayOfByte	byte[]
    //   1	120	3	localObject1	Object
    //   3	101	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   91	99	99	java/io/IOException
    //   9	63	102	java/io/IOException
    //   63	72	102	java/io/IOException
    //   110	114	116	java/io/IOException
    //   9	63	119	finally
    //   63	72	119	finally
    //   126	130	132	java/io/IOException
    //   81	85	135	java/io/IOException
    //   72	77	138	finally
    //   72	77	142	java/io/IOException
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("bkgRes", 0);
    localBundle.putInt("nameClr", -16777216);
    localBundle.putInt("tipsClr", -8947849);
    localBundle.putInt("B", -16777216);
    localBundle.putInt("W", 16777215);
    localBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
    localBundle.putInt("head", 1);
    localBundle.putInt("type", 1);
    this.jdField_b_of_type_JavaUtilList.add(localBundle);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).edit();
    localEditor.putInt("lastIndex", this.jdField_a_of_type_Int);
    localEditor.commit();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(CodeMaskManager.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.jdField_a_of_type_AndroidOsBundle.putInt("B", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("W", -9947128);
        if (paramInt != 2) {
          break label149;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("head", 3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("type", 1);
        paramCallback.a(a(this.jdField_a_of_type_AndroidOsBundle));
        return;
        label149:
        if (paramInt == 1) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("head", 4);
        }
      }
    }
    int i = a(this.jdField_a_of_type_JavaUtilList.size());
    if (i >= 0)
    {
      paramInt = i;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      paramInt = 0;
    }
    Object localObject = (Bundle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((Bundle)localObject).getInt("type") == 1)
    {
      paramCallback.a(a((Bundle)localObject));
      c();
      return;
    }
    localObject = new ow(this, paramCallback, (Bundle)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ov(this, (ow)localObject, paramCallback), 10000L);
    ((ow)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager
 * JD-Core Version:    0.7.0.1
 */