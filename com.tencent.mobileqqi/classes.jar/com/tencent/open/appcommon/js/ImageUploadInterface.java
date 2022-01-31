package com.tencent.open.appcommon.js;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.ImageUploadAsyncTask;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageUploadInterface
  extends BaseInterface
{
  protected static int DEFAULT_CONTROL_HEIGHT_VALUE = 0;
  protected static int DEFAULT_CONTROL_QUALITY_VALUE = 0;
  protected static int DEFAULT_CONTROL_SIZE_VALUE = 0;
  protected static int DEFAULT_CONTROL_WIDTH_VALUE = 0;
  protected static String DEFAULT_FILE_FILTER_TYPE_VALUE;
  protected static int DEFAULT_NEED_CONTROL_RATIO_VALUE = 0;
  protected static final String LOG_TAG = ImageUploadInterface.class.getName();
  protected static int MAX_IMAGE_HEIGHT_LIMIT = 1280;
  protected static int MAX_IMAGE_SIZE_LIMIT = 4096;
  protected static int MAX_IMAGE_WIDTH_LIMIT = 0;
  protected static final int REQUEST_PIC_PICK = 10001;
  protected static boolean mUploading = false;
  protected final Activity mActivity;
  protected int mControlHeight;
  protected int mControlQuality;
  protected int mControlSize;
  protected int mControlWidth;
  protected String mFileFilterType;
  protected String mGuid = null;
  protected String mMethod = null;
  protected String mMineType;
  protected int mNeedControlratio;
  protected Bundle mParams = null;
  protected String mPicture = null;
  protected String mUrl = null;
  protected final WebView mWebView;
  
  static
  {
    DEFAULT_NEED_CONTROL_RATIO_VALUE = 1;
    DEFAULT_CONTROL_WIDTH_VALUE = 800;
    DEFAULT_CONTROL_HEIGHT_VALUE = 480;
    DEFAULT_CONTROL_QUALITY_VALUE = 100;
    DEFAULT_FILE_FILTER_TYPE_VALUE = "all";
    DEFAULT_CONTROL_SIZE_VALUE = 100;
    MAX_IMAGE_WIDTH_LIMIT = 1280;
  }
  
  public ImageUploadInterface(Activity paramActivity, WebView paramWebView)
  {
    this.mActivity = paramActivity;
    this.mWebView = paramWebView;
  }
  
  protected static String bytes2HexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected static Bitmap compressByQuality(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, paramInt, localByteArrayOutputStream);
    paramBitmap.recycle();
    paramCompressFormat = new BitmapFactory.Options();
    paramCompressFormat.inJustDecodeBounds = false;
    paramCompressFormat.inPurgeable = true;
    paramCompressFormat.inInputShareable = true;
    if (paramBitmap.hasAlpha()) {}
    for (paramBitmap = Bitmap.Config.ARGB_8888;; paramBitmap = Bitmap.Config.RGB_565)
    {
      paramCompressFormat.inPreferredConfig = paramBitmap;
      paramBitmap = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
      paramCompressFormat = BitmapFactory.decodeStream(paramBitmap, new Rect(0, 0, 0, 0), paramCompressFormat);
      try
      {
        localByteArrayOutputStream.close();
        paramBitmap.close();
        return paramCompressFormat;
      }
      catch (IOException paramBitmap)
      {
        LogUtility.e(LOG_TAG, "compressByQuality close stream error : " + paramBitmap.toString());
      }
    }
    return paramCompressFormat;
  }
  
  public static void loadJs(WebView paramWebView, String paramString)
  {
    if (paramWebView != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramWebView.loadUrl(paramString);
      }
      return;
    }
    catch (Exception paramWebView)
    {
      LogUtility.a(LOG_TAG, "webview loadUrl>>> ", paramWebView);
    }
  }
  
  protected Bitmap compressBySize(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    LogUtility.c(LOG_TAG, "before compress by size , width : " + i + ", height: " + j);
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if (f1 <= f2) {}
    for (;;)
    {
      paramCompressFormat = new Matrix();
      paramCompressFormat.postScale(f1, f1);
      paramCompressFormat = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, paramCompressFormat, false);
      LogUtility.c(LOG_TAG, "after compress by size , width : " + paramCompressFormat.getWidth() + ", height: " + paramCompressFormat.getHeight());
      paramBitmap.recycle();
      return paramCompressFormat;
      f1 = f2;
    }
  }
  
  protected byte[] compressToBytes(String paramString)
  {
    Object localObject2 = null;
    label307:
    label331:
    for (;;)
    {
      Object localObject1;
      Bitmap.CompressFormat localCompressFormat;
      try
      {
        Log.d(LOG_TAG, "compress picture to bytes");
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        this.mMineType = ((BitmapFactory.Options)localObject1).outMimeType;
        localCompressFormat = Bitmap.CompressFormat.JPEG;
        if (((BitmapFactory.Options)localObject1).outMimeType.equals("image/png"))
        {
          localCompressFormat = Bitmap.CompressFormat.PNG;
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
          localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
          paramString = (String)localObject1;
          if (this.mNeedControlratio == 1)
          {
            localObject1 = compressBySize((Bitmap)localObject1, localCompressFormat, this.mControlWidth, this.mControlHeight);
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              LogUtility.e(LOG_TAG, "image compress by size error");
              handleUploadPicCallbackException(new Exception("按长宽压缩图片错误"));
              paramString = localObject2;
              return paramString;
            }
          }
        }
        else
        {
          if (!((BitmapFactory.Options)localObject1).outMimeType.equals("image/jpeg")) {
            break label331;
          }
          localCompressFormat = Bitmap.CompressFormat.JPEG;
          continue;
        }
        localObject1 = paramString;
        if (this.mControlSize > 0)
        {
          paramString = compressByQuality(paramString, localCompressFormat, this.mControlQuality);
          localObject1 = paramString;
          if (paramString == null)
          {
            LogUtility.e(LOG_TAG, "image compress by quality error");
            handleUploadPicCallbackException(new Exception("按质量压缩图片错误"));
            paramString = localObject2;
            continue;
          }
        }
        paramString = new ByteArrayOutputStream();
      }
      finally {}
      if (((Bitmap)localObject1).compress(localCompressFormat, 100, paramString))
      {
        ((Bitmap)localObject1).recycle();
        System.gc();
        if ((this.mControlSize > 0) && (paramString.toByteArray().length / 1024 > this.mControlSize))
        {
          handleUploadPicCallbackException(new Exception("图片大小超过限制"));
          paramString = localObject2;
        }
        else
        {
          paramString = paramString.toByteArray();
        }
      }
      else
      {
        LogUtility.e(LOG_TAG, "covert bitmap to bytes error");
        ((Bitmap)localObject1).recycle();
        try
        {
          paramString.close();
          handleUploadPicCallbackException(new Exception("图片转字节码失败"));
          paramString = localObject2;
        }
        catch (IOException paramString)
        {
          break label307;
        }
      }
    }
  }
  
  protected String getAbsoluteImagePath(Context paramContext, Uri paramUri)
  {
    paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    if (paramContext != null)
    {
      int i = paramContext.getColumnIndexOrThrow("_data");
      paramContext.moveToFirst();
      paramUri = paramContext.getString(i);
      paramContext.close();
      return paramUri;
    }
    return paramUri.getPath();
  }
  
  /* Error */
  @SuppressLint({"DefaultLocale"})
  protected String getImageType(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_4
    //   3: newarray byte
    //   5: astore 4
    //   7: new 364	java/io/FileInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 365	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_2
    //   19: aload 4
    //   21: iconst_0
    //   22: aload 4
    //   24: arraylength
    //   25: invokevirtual 369	java/io/FileInputStream:read	([BII)I
    //   28: pop
    //   29: aload_2
    //   30: ifnull +7 -> 37
    //   33: aload_2
    //   34: invokevirtual 370	java/io/FileInputStream:close	()V
    //   37: aload 4
    //   39: invokestatic 372	com/tencent/open/appcommon/js/ImageUploadInterface:bytes2HexString	([B)Ljava/lang/String;
    //   42: invokevirtual 375	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ldc_w 377
    //   50: invokevirtual 380	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +142 -> 195
    //   56: ldc_w 381
    //   59: astore_2
    //   60: aload_2
    //   61: areturn
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 384	java/io/IOException:printStackTrace	()V
    //   67: goto -30 -> 37
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: getstatic 48	com/tencent/open/appcommon/js/ImageUploadInterface:LOG_TAG	Ljava/lang/String;
    //   78: new 93	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 386
    //   88: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_3
    //   92: invokevirtual 387	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   95: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 198	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_2
    //   105: ifnull -68 -> 37
    //   108: aload_2
    //   109: invokevirtual 370	java/io/FileInputStream:close	()V
    //   112: goto -75 -> 37
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 384	java/io/IOException:printStackTrace	()V
    //   120: goto -83 -> 37
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: getstatic 48	com/tencent/open/appcommon/js/ImageUploadInterface:LOG_TAG	Ljava/lang/String;
    //   129: new 93	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 389
    //   139: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 192	java/io/IOException:toString	()Ljava/lang/String;
    //   146: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 198	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_3
    //   156: astore_2
    //   157: aload_1
    //   158: ifnull -98 -> 60
    //   161: aload_1
    //   162: invokevirtual 370	java/io/FileInputStream:close	()V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 384	java/io/IOException:printStackTrace	()V
    //   172: aconst_null
    //   173: areturn
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 370	java/io/FileInputStream:close	()V
    //   185: aload_2
    //   186: athrow
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 384	java/io/IOException:printStackTrace	()V
    //   192: goto -7 -> 185
    //   195: aload_1
    //   196: ldc_w 391
    //   199: invokevirtual 380	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   202: ifeq +7 -> 209
    //   205: ldc_w 392
    //   208: areturn
    //   209: aload_1
    //   210: ldc_w 394
    //   213: invokevirtual 380	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   216: ifeq +7 -> 223
    //   219: ldc_w 396
    //   222: areturn
    //   223: aload_1
    //   224: ldc_w 398
    //   227: invokevirtual 380	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +7 -> 237
    //   233: ldc_w 400
    //   236: areturn
    //   237: ldc_w 402
    //   240: areturn
    //   241: astore_2
    //   242: goto -65 -> 177
    //   245: astore_2
    //   246: goto -69 -> 177
    //   249: astore 4
    //   251: aload_2
    //   252: astore_1
    //   253: aload 4
    //   255: astore_2
    //   256: goto -130 -> 126
    //   259: astore_3
    //   260: goto -187 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ImageUploadInterface
    //   0	263	1	paramString	String
    //   15	94	2	localObject1	Object
    //   123	20	2	localIOException1	IOException
    //   156	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   174	12	2	localObject2	Object
    //   241	1	2	localObject3	Object
    //   245	7	2	localObject4	Object
    //   255	1	2	localIOException2	IOException
    //   1	1	3	localObject5	Object
    //   70	86	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   259	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   5	33	4	arrayOfByte	byte[]
    //   249	5	4	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   33	37	62	java/io/IOException
    //   7	16	70	java/io/FileNotFoundException
    //   108	112	115	java/io/IOException
    //   7	16	123	java/io/IOException
    //   161	165	167	java/io/IOException
    //   7	16	174	finally
    //   181	185	187	java/io/IOException
    //   18	29	241	finally
    //   75	104	241	finally
    //   126	155	245	finally
    //   18	29	249	java/io/IOException
    //   18	29	259	java/io/FileNotFoundException
  }
  
  public String getInterfaceName()
  {
    return "q_picUpload";
  }
  
  public void handlePicUploadOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 10001)
    {
      if (paramInt2 != -1) {
        break label393;
      }
      paramIntent = paramIntent.getData();
      if (paramIntent == null) {
        break label369;
      }
      localObject = paramIntent.toString();
      if (!((String)localObject).startsWith("content://")) {
        break label77;
      }
      paramIntent = getAbsoluteImagePath(this.mActivity, paramIntent);
      if (paramIntent != null) {
        break label114;
      }
      Log.e(LOG_TAG, "picture path is null");
      handleUploadPicCallbackException(new Exception("获取图片路径错误"));
    }
    label77:
    label114:
    do
    {
      do
      {
        return;
        if (((String)localObject).startsWith("file://"))
        {
          paramIntent = ((String)localObject).substring(7);
          break;
        }
        handleUploadPicCallbackException(new Exception("文件管理器没有返回图片信息"));
        return;
        Log.d(LOG_TAG, "picture path = " + paramIntent);
        long l = new File(paramIntent).length();
        if (l == 0L)
        {
          Log.e(LOG_TAG, "picture file is not found");
          handleUploadPicCallbackException(new Exception("未找到图片文件"));
          return;
        }
        if (l / 1024L >= MAX_IMAGE_SIZE_LIMIT)
        {
          Log.e(LOG_TAG, "picture file is too large , size : " + l / 1024L + "KB");
          handleUploadPicCallbackException(new Exception("图片大小超过限制"));
          return;
        }
      } while (!imageTypeValidate(paramIntent));
      localObject = compressToBytes(paramIntent);
    } while (localObject == null);
    this.mParams.putString("filename", paramIntent.substring(paramIntent.lastIndexOf("/") + 1).trim());
    this.mParams.putString("mineType", this.mMineType);
    this.mParams.putByteArray(this.mPicture, (byte[])localObject);
    new ImageUploadAsyncTask(this.mActivity, this.mUrl, this.mMethod, new ImageUploadInterface.UploadPicCallback(this)).execute(new Bundle[] { this.mParams });
    return;
    label369:
    LogUtility.e(LOG_TAG, "the intent uri is null");
    handleUploadPicCallbackException(new Exception("选择图片返回结果为空"));
    return;
    label393:
    if (paramInt2 == 0)
    {
      LogUtility.c(LOG_TAG, "user give up to select any pic");
      mUploading = false;
      paramIntent = "javascript:JsBridge.callback('picUpload',{\"guid\":\"" + this.mGuid + "\",\"resultCode\":1,});void(0);";
      loadJs(this.mWebView, paramIntent);
      return;
    }
    LogUtility.e(LOG_TAG, "illegal operation");
    mUploading = false;
    handleUploadPicCallbackException(new Exception("错误操作"));
  }
  
  protected void handleUploadPicCallbackException(Exception paramException)
  {
    LogUtility.c(LOG_TAG, "onException >>> " + paramException.toString());
    mUploading = false;
    paramException = "javascript:JsBridge.callback('picUpload',{\"guid\":\"" + this.mGuid + "\",\"resultCode\":-1," + "\"content\":\"" + paramException.getMessage() + "\"});void(0);";
    loadJs(this.mWebView, paramException);
  }
  
  @SuppressLint({"DefaultLocale"})
  protected boolean imageTypeValidate(String paramString)
  {
    String str2 = paramString.substring(paramString.lastIndexOf(".") + 1).toUpperCase();
    String str1 = str2;
    if (str2.equals("JPG")) {
      str1 = "JPEG";
    }
    paramString = getImageType(paramString);
    LogUtility.a(LOG_TAG, "validate faceImageType : " + str1 + ", realImageType : " + paramString);
    if (paramString != null)
    {
      if ((paramString.equals("PNG")) || (paramString.equals("JPEG")))
      {
        if (!str1.equals(paramString))
        {
          handleUploadPicCallbackException(new Exception("图片的后缀名与实际格式不符"));
          LogUtility.c(LOG_TAG, "faceImageType is not equals realImageType");
          return false;
        }
        if ((this.mFileFilterType.equals("image/*")) || (this.mFileFilterType.toUpperCase().contains(paramString))) {
          return true;
        }
        handleUploadPicCallbackException(new Exception("选择的图片跟指定格式不符"));
        LogUtility.c(LOG_TAG, "selected image is not assign types");
        return false;
      }
      if ((paramString.equals("GIF")) || (paramString.equals("BMP")))
      {
        handleUploadPicCallbackException(new Exception("目前不支持GIF和BMP格式的图片上传"));
        LogUtility.c(LOG_TAG, "not support image format");
        return false;
      }
      handleUploadPicCallbackException(new Exception("选择的文件不是图片格式"));
      LogUtility.c(LOG_TAG, "selected file is not image");
      return false;
    }
    handleUploadPicCallbackException(new Exception("图片格式解析错误"));
    LogUtility.c(LOG_TAG, "getImageType error");
    return false;
  }
  
  @SuppressLint({"DefaultLocale"})
  protected boolean parseParam(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.mUrl = paramString.optString("url");
      this.mMethod = paramString.optString("method");
      localObject1 = new JSONObject(paramString.optString("control"));
      this.mNeedControlratio = ((JSONObject)localObject1).optInt("needControlratio", DEFAULT_NEED_CONTROL_RATIO_VALUE);
      this.mControlWidth = ((JSONObject)localObject1).optInt("controlWidth", DEFAULT_CONTROL_WIDTH_VALUE);
      this.mControlHeight = ((JSONObject)localObject1).optInt("controlHeight", DEFAULT_CONTROL_HEIGHT_VALUE);
      this.mControlSize = ((JSONObject)localObject1).optInt("controlSize", DEFAULT_CONTROL_SIZE_VALUE);
      this.mControlQuality = ((JSONObject)localObject1).optInt("controlQuality", DEFAULT_CONTROL_QUALITY_VALUE);
      if (this.mNeedControlratio == 1)
      {
        if ((this.mControlWidth > MAX_IMAGE_WIDTH_LIMIT) || (this.mControlWidth <= 0))
        {
          handleUploadPicCallbackException(new Exception("图片宽度控制参数（controlWidth）超过限制"));
          return false;
        }
        if ((this.mControlHeight > MAX_IMAGE_HEIGHT_LIMIT) || (this.mControlHeight <= 0))
        {
          handleUploadPicCallbackException(new Exception("图片长度控制参数（controlHeight）超过限制"));
          return false;
        }
      }
    }
    catch (JSONException paramString)
    {
      Log.e(LOG_TAG, "httpRequest JSONException" + paramString.toString());
      handleUploadPicCallbackException(new Exception("传入JSON串解析错误"));
      return false;
    }
    if (this.mControlSize > MAX_IMAGE_SIZE_LIMIT)
    {
      handleUploadPicCallbackException(new Exception("图片大小控制参数（controlSize）超过限制"));
      return false;
    }
    if ((this.mControlQuality <= 0) || (this.mControlQuality > 100))
    {
      handleUploadPicCallbackException(new Exception("图片大小控制参数（controlQuality）超过限制"));
      return false;
    }
    Object localObject1 = ((JSONObject)localObject1).optString("filetype", DEFAULT_FILE_FILTER_TYPE_VALUE).trim().toLowerCase();
    int j;
    int i;
    label379:
    Object localObject2;
    if ((((String)localObject1).equals("all")) || (((String)localObject1).equals("")))
    {
      this.mFileFilterType = "image/*";
      this.mParams = new Bundle();
      localObject1 = paramString.optString("params").split("&");
      j = localObject1.length;
      i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i].split("=");
        if ((localObject2[0] == null) || (localObject2[0].trim().equals("")) || (localObject2[1] == null)) {
          break label619;
        }
        this.mParams.putString(localObject2[0].trim(), localObject2[1].trim());
        break label619;
      }
    }
    else
    {
      localObject1 = ((String)localObject1).toLowerCase().split(",");
      localObject2 = new StringBuilder();
      j = localObject1.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject3 = localObject1[i];
        if (localObject3.trim().equals("png"))
        {
          ((StringBuilder)localObject2).append("image/png,");
        }
        else if ((localObject3.trim().equals("jpg")) || (localObject3.trim().equals("jpeg")))
        {
          ((StringBuilder)localObject2).append("image/jpeg,");
        }
        else
        {
          handleUploadPicCallbackException(new Exception("图片格式错误"));
          return false;
        }
      }
      else
      {
        this.mFileFilterType = ((StringBuilder)localObject2).toString();
        this.mFileFilterType = this.mFileFilterType.substring(0, this.mFileFilterType.length() - 1);
        break;
        this.mPicture = paramString.optString("picture", "picture");
        return true;
        label619:
        i += 1;
        break label379;
      }
      i += 1;
    }
  }
  
  public void picUpload(String paramString1, String paramString2)
  {
    LogUtility.a(LOG_TAG, "httpRequest >>> " + paramString1.toString());
    try
    {
      if (mUploading)
      {
        paramString1 = "javascript:JsBridge.callback('picUpload',{\"guid\":\"" + this.mGuid + "\",\"resultCode\":-1," + "\"content\":\"" + "图片正在上传中，请稍后操作" + "\"});void(0);";
        loadJs(this.mWebView, paramString1);
        return;
      }
      mUploading = true;
      this.mGuid = paramString2;
      paramString2 = this.mActivity.getPackageManager();
      Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.setData(Uri.parse("content://media/external/images/media"));
      localIntent.setType("image/*");
      paramString2 = paramString2.queryIntentActivities(localIntent, 0);
      if ((paramString2 == null) || (paramString2.size() == 0))
      {
        handleUploadPicCallbackException(new Exception("系统未安装图库或文件管理器"));
        return;
      }
    }
    finally {}
    if (parseParam(paramString1))
    {
      paramString1 = new Intent("android.intent.action.GET_CONTENT");
      paramString1.setData(Uri.parse("content://media/external/images/media"));
      paramString1.setType(this.mFileFilterType);
      this.mActivity.startActivityForResult(Intent.createChooser(paramString1, "请选择上传图片"), 10001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.ImageUploadInterface
 * JD-Core Version:    0.7.0.1
 */