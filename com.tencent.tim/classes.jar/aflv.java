import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class aflv
  extends afmd
  implements afpn
{
  static long lastTime;
  public String bDY;
  private ColorDrawable i = new ColorDrawable();
  public String templateId;
  public String thumbPath;
  
  public int Dg()
  {
    return this.emoId;
  }
  
  public void HR(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return b(paramContext, paramFloat);
  }
  
  public Drawable a(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130844558);
      localURLDrawableOptions.mLoadingDrawable = this.i;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("CameraEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    do
    {
      return;
      lastTime = l;
      if (((paramContext instanceof BaseActivity)) && (ajpd.O(paramSessionInfo.cZ, paramSessionInfo.aTl)))
      {
        paramContext = (BaseActivity)paramContext;
        QQToast.a(paramQQAppInterface.getApp(), acfp.m(2131703361), 0).show(paramContext.getTitleBarHeight());
        return;
      }
      paramEditText = null;
      if (!TextUtils.isEmpty(this.templateId))
      {
        paramEditText = new Bundle();
        paramEditText.putString("widgetinfo", this.templateId);
      }
      ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, this.path, true, this.bDY, paramEditText);
    } while (TextUtils.isEmpty(this.eId));
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A371", "0X800A371", 0, 0, "", "", this.eId, "");
  }
  
  /* Error */
  public Drawable b(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	aflv:path	Ljava/lang/String;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 242	aflv:bDZ	Ljava/lang/String;
    //   9: ldc 244
    //   11: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +18 -> 32
    //   17: aload_1
    //   18: astore 4
    //   20: aload_0
    //   21: getfield 242	aflv:bDZ	Ljava/lang/String;
    //   24: ldc 252
    //   26: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +33 -> 62
    //   32: aload_1
    //   33: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +20 -> 56
    //   39: aload_1
    //   40: astore 4
    //   42: new 254	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 260	java/io/File:exists	()Z
    //   53: ifne +9 -> 62
    //   56: aload_0
    //   57: getfield 262	aflv:thumbPath	Ljava/lang/String;
    //   60: astore 4
    //   62: invokestatic 267	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   65: invokevirtual 268	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   68: astore_3
    //   69: aload_3
    //   70: ldc_w 269
    //   73: invokevirtual 82	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   76: astore_1
    //   77: aload_3
    //   78: ldc 76
    //   80: invokevirtual 82	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   83: astore 5
    //   85: aload_1
    //   86: astore_3
    //   87: aload 5
    //   89: astore_1
    //   90: new 47	java/net/URL
    //   93: dup
    //   94: ldc 49
    //   96: ldc_w 271
    //   99: aload 4
    //   101: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore 6
    //   106: new 273	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   109: dup
    //   110: invokespecial 274	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   113: astore 5
    //   115: aload 5
    //   117: aload 4
    //   119: putfield 275	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   122: aload 5
    //   124: bipush 100
    //   126: putfield 278	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   129: aload 5
    //   131: bipush 100
    //   133: putfield 281	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   136: invokestatic 63	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   139: astore 7
    //   141: aload 7
    //   143: aload_3
    //   144: putfield 89	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   147: aload 7
    //   149: aload_1
    //   150: putfield 86	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   153: aload 7
    //   155: aload_0
    //   156: putfield 285	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   159: aload 4
    //   161: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +71 -> 235
    //   167: aload 6
    //   169: aload 7
    //   171: invokestatic 97	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   174: astore_1
    //   175: aload_1
    //   176: aload 5
    //   178: invokevirtual 289	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   181: aload_1
    //   182: areturn
    //   183: astore 5
    //   185: aconst_null
    //   186: astore_3
    //   187: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: ldc 105
    //   195: iconst_2
    //   196: aload 5
    //   198: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aconst_null
    //   205: astore_1
    //   206: goto -116 -> 90
    //   209: astore 5
    //   211: aconst_null
    //   212: astore_3
    //   213: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +14 -> 230
    //   219: ldc 105
    //   221: iconst_2
    //   222: aload 5
    //   224: invokevirtual 293	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   227: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aconst_null
    //   231: astore_1
    //   232: goto -142 -> 90
    //   235: ldc 105
    //   237: iconst_1
    //   238: new 107	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 295
    //   248: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: invokevirtual 296	aflv:toString	()Ljava/lang/String;
    //   255: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 140	java/net/MalformedURLException:printStackTrace	()V
    //   271: ldc 105
    //   273: iconst_1
    //   274: ldc_w 298
    //   277: aload_1
    //   278: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: goto -17 -> 264
    //   284: astore 5
    //   286: aload_1
    //   287: astore_3
    //   288: goto -75 -> 213
    //   291: astore 5
    //   293: aload_1
    //   294: astore_3
    //   295: goto -108 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	aflv
    //   0	298	1	paramContext	Context
    //   0	298	2	paramFloat	float
    //   68	227	3	localObject1	Object
    //   18	142	4	localObject2	Object
    //   83	94	5	localObject3	Object
    //   183	14	5	localException1	java.lang.Exception
    //   209	14	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   284	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   291	1	5	localException2	java.lang.Exception
    //   104	64	6	localURL	URL
    //   139	31	7	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   62	77	183	java/lang/Exception
    //   62	77	209	java/lang/OutOfMemoryError
    //   90	181	266	java/net/MalformedURLException
    //   235	264	266	java/net/MalformedURLException
    //   77	85	284	java/lang/OutOfMemoryError
    //   77	85	291	java/lang/Exception
  }
  
  public Drawable c(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130844558);
      localURLDrawableOptions.mLoadingDrawable = this.i;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public String toString()
  {
    return String.format("CameraEmoticonInfo, path %s, url %s, contextKey %s", new Object[] { this.path, this.url, this.bDY });
  }
  
  public String uy()
  {
    return this.bDZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflv
 * JD-Core Version:    0.7.0.1
 */