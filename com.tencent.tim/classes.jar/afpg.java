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
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class afpg
  extends afmd
  implements afpn
{
  static long lastTime;
  public String actionData;
  private ColorDrawable i = new ColorDrawable();
  
  public afpg()
  {
    this.bEa = "show_fav_menu";
  }
  
  public static String c(Map<String, VipComicFavorEmoStructMsgInfo> paramMap, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    paramMap = (VipComicFavorEmoStructMsgInfo)paramMap.get(paramString.toUpperCase());
    if (paramMap != null) {
      return paramMap.actionData;
    }
    return null;
  }
  
  private void n(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.path);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", acfp.m(2131706109));
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", this.actionData);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)anre.a(localBundle), paramSessionInfo.aTl, paramSessionInfo.cZ, paramSessionInfo.troopUin, 0);
    paramSessionInfo = xtj.i(this.actionData);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      avdb.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], xtj.hA(this.actionData) });
    }
  }
  
  public int Dg()
  {
    return this.emoId;
  }
  
  public void HR(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  /* Error */
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 18	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 19	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: astore_1
    //   12: aload 6
    //   14: astore 5
    //   16: invokestatic 166	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: invokevirtual 170	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   22: astore 7
    //   24: aload 6
    //   26: astore_1
    //   27: aload 6
    //   29: astore 5
    //   31: aload 7
    //   33: ldc 171
    //   35: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore 6
    //   40: aload 6
    //   42: astore_1
    //   43: aload 6
    //   45: astore 5
    //   47: aload 7
    //   49: ldc 178
    //   51: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   54: astore 7
    //   56: aload 7
    //   58: astore 5
    //   60: aload 6
    //   62: astore_1
    //   63: aload 5
    //   65: astore 6
    //   67: new 180	java/net/URL
    //   70: dup
    //   71: ldc 182
    //   73: ldc 184
    //   75: aload_0
    //   76: getfield 67	afpg:path	Ljava/lang/String;
    //   79: invokespecial 187	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore 7
    //   84: new 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   87: dup
    //   88: invokespecial 190	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   91: astore 5
    //   93: aload 5
    //   95: aload_0
    //   96: getfield 67	afpg:path	Ljava/lang/String;
    //   99: putfield 191	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   102: aload 5
    //   104: iload_3
    //   105: putfield 194	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   108: aload 5
    //   110: iload 4
    //   112: putfield 197	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   115: invokestatic 203	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   118: astore 8
    //   120: aload 8
    //   122: aload_1
    //   123: putfield 207	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   126: aload 8
    //   128: aload 6
    //   130: putfield 210	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   133: aload 8
    //   135: aload_0
    //   136: putfield 214	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   139: aload_0
    //   140: getfield 67	afpg:path	Ljava/lang/String;
    //   143: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifne +70 -> 216
    //   149: aload 7
    //   151: aload 8
    //   153: invokestatic 219	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   156: astore_1
    //   157: aload_1
    //   158: aload 5
    //   160: invokevirtual 223	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   163: aload_1
    //   164: areturn
    //   165: astore 5
    //   167: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +14 -> 184
    //   173: ldc 231
    //   175: iconst_2
    //   176: aload 5
    //   178: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aconst_null
    //   185: astore 6
    //   187: goto -120 -> 67
    //   190: astore_1
    //   191: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +13 -> 207
    //   197: ldc 231
    //   199: iconst_2
    //   200: aload_1
    //   201: invokevirtual 239	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   204: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aconst_null
    //   208: astore 6
    //   210: aload 5
    //   212: astore_1
    //   213: goto -146 -> 67
    //   216: ldc 231
    //   218: iconst_1
    //   219: new 241	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   226: ldc 244
    //   228: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: invokevirtual 251	afpg:toString	()Ljava/lang/String;
    //   235: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 255	java/net/MalformedURLException:printStackTrace	()V
    //   251: ldc 231
    //   253: iconst_1
    //   254: ldc_w 257
    //   257: aload_1
    //   258: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: goto -17 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	afpg
    //   0	264	1	paramContext	Context
    //   0	264	2	paramFloat	float
    //   0	264	3	paramInt1	int
    //   0	264	4	paramInt2	int
    //   14	145	5	localObject1	Object
    //   165	46	5	localException	java.lang.Exception
    //   7	202	6	localObject2	Object
    //   22	128	7	localObject3	Object
    //   118	34	8	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   16	24	165	java/lang/Exception
    //   31	40	165	java/lang/Exception
    //   47	56	165	java/lang/Exception
    //   16	24	190	java/lang/OutOfMemoryError
    //   31	40	190	java/lang/OutOfMemoryError
    //   47	56	190	java/lang/OutOfMemoryError
    //   67	163	246	java/net/MalformedURLException
    //   216	244	246	java/net/MalformedURLException
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    lastTime = l;
    if (xtj.hQ(this.actionData))
    {
      n(paramQQAppInterface, paramSessionInfo);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (ajpd.O(paramSessionInfo.cZ, paramSessionInfo.aTl)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), acfp.m(2131706111), 0).show(paramContext.getTitleBarHeight());
      return;
    }
    paramEditText = this.path;
    if (!TextUtils.isEmpty(this.eId)) {}
    for (boolean bool = true;; bool = false)
    {
      ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEditText, true, bool, this.eId, null);
      if ((TextUtils.isEmpty(this.path)) || (!this.path.contains("qto_"))) {
        break;
      }
      anot.a(((BaseActivity)paramContext).app, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(acfi.cq(this.eId)), "", acfi.jj(this.path), "");
      return;
    }
    anot.a(((BaseActivity)paramContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
  }
  
  /* Error */
  public Drawable b(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: new 18	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 19	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: astore_1
    //   12: aload 4
    //   14: astore_3
    //   15: invokestatic 166	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: invokevirtual 170	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   21: astore 5
    //   23: aload 4
    //   25: astore_1
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: ldc 171
    //   33: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   36: astore 4
    //   38: aload 4
    //   40: astore_1
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: ldc 178
    //   48: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   51: astore 5
    //   53: aload 5
    //   55: astore_3
    //   56: aload 4
    //   58: astore_1
    //   59: aload_3
    //   60: astore 4
    //   62: new 180	java/net/URL
    //   65: dup
    //   66: ldc 182
    //   68: ldc_w 355
    //   71: aload_0
    //   72: getfield 67	afpg:path	Ljava/lang/String;
    //   75: invokespecial 187	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore 5
    //   80: new 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   83: dup
    //   84: invokespecial 190	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   87: astore_3
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 67	afpg:path	Ljava/lang/String;
    //   93: putfield 191	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   96: aload_3
    //   97: bipush 100
    //   99: putfield 194	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   102: aload_3
    //   103: bipush 100
    //   105: putfield 197	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   108: invokestatic 203	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   111: astore 6
    //   113: aload 6
    //   115: aload_1
    //   116: putfield 207	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   119: aload 6
    //   121: aload 4
    //   123: putfield 210	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   126: aload 6
    //   128: aload_0
    //   129: putfield 214	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   132: aload_0
    //   133: getfield 67	afpg:path	Ljava/lang/String;
    //   136: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +66 -> 205
    //   142: aload 5
    //   144: aload 6
    //   146: invokestatic 219	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   149: astore_1
    //   150: aload_1
    //   151: aload_3
    //   152: invokevirtual 223	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   155: aload_1
    //   156: areturn
    //   157: astore_3
    //   158: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +13 -> 174
    //   164: ldc 231
    //   166: iconst_2
    //   167: aload_3
    //   168: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   171: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aconst_null
    //   175: astore 4
    //   177: goto -115 -> 62
    //   180: astore_1
    //   181: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +13 -> 197
    //   187: ldc 231
    //   189: iconst_2
    //   190: aload_1
    //   191: invokevirtual 239	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   194: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aconst_null
    //   198: astore 4
    //   200: aload_3
    //   201: astore_1
    //   202: goto -140 -> 62
    //   205: ldc 231
    //   207: iconst_1
    //   208: new 241	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 357
    //   218: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: invokevirtual 251	afpg:toString	()Ljava/lang/String;
    //   225: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 255	java/net/MalformedURLException:printStackTrace	()V
    //   241: ldc 231
    //   243: iconst_1
    //   244: ldc_w 359
    //   247: aload_1
    //   248: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: goto -17 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	afpg
    //   0	254	1	paramContext	Context
    //   0	254	2	paramFloat	float
    //   14	138	3	localObject1	Object
    //   157	44	3	localException	java.lang.Exception
    //   7	192	4	localObject2	Object
    //   21	122	5	localObject3	Object
    //   111	34	6	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   15	23	157	java/lang/Exception
    //   29	38	157	java/lang/Exception
    //   44	53	157	java/lang/Exception
    //   15	23	180	java/lang/OutOfMemoryError
    //   29	38	180	java/lang/OutOfMemoryError
    //   44	53	180	java/lang/OutOfMemoryError
    //   62	155	236	java/net/MalformedURLException
    //   205	234	236	java/net/MalformedURLException
  }
  
  public Drawable b(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130844558);
      localURLDrawableOptions.mLoadingDrawable = this.i;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable c(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130844558);
      localURLDrawableOptions.mLoadingDrawable = this.i;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
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
    return String.format("FavoriteEmoticonInfo, path %s, url %s", new Object[] { this.path, this.url });
  }
  
  public String uy()
  {
    return this.bDZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpg
 * JD-Core Version:    0.7.0.1
 */