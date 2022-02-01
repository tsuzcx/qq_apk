package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import yam;

public class HotChatDemoChatPie
  extends yam
{
  protected String aWY;
  protected int bYb;
  protected int bYc;
  protected LinearLayout hn;
  protected int mMarginRight;
  protected ImageView uc;
  
  private void O(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return;
        if (this.hn != null) {
          break;
        }
        this.uc = new ImageView(this.mActivity);
        this.uc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.bYb, this.bYb);
        int i = this.bYc;
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.uc.setLayoutParams(localLayoutParams);
        this.uc.setImageDrawable(paramDrawable);
        paramDrawable = new SimpleTextView(this.mActivity);
        paramDrawable.setText(this.mActivity.getText(2131701266));
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = this.bYc;
        localLayoutParams.gravity = 1;
        paramDrawable.setLayoutParams(localLayoutParams);
        paramDrawable.setTextColor(Color.rgb(119, 119, 119));
        paramDrawable.setTextSize(1, 14.0F);
        paramDrawable.setGravity(1);
        this.hn = new LinearLayout(this.mActivity);
        this.hn.setOrientation(1);
        this.hn.addView(this.uc);
        this.hn.addView(paramDrawable);
        paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
        paramDrawable.addRule(11);
        paramDrawable.addRule(15);
        paramDrawable.rightMargin = this.mMarginRight;
        this.hn.setLayoutParams(paramDrawable);
        this.hn.setBackgroundResource(2130846367);
      } while (this.fs == null);
      this.fs.addView(this.hn);
      return;
    } while (this.uc == null);
    this.uc.setImageDrawable(paramDrawable);
  }
  
  private String ax(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.app.getManager(60)).a(paramString2);
      str = paramString1;
      if (paramString2 != null) {
        str = paramString2.name;
      }
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        paramString1 = URLEncoder.encode(str, "UTF-8");
        paramString1 = String.format("https://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s", new Object[] { paramString1 });
        if (QLog.isDevelopLevel()) {
          QLog.i("HotChatDemoChatPie", 4, "makeUrl: " + paramString1);
        }
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = str;
        continue;
      }
      paramString1 = null;
    }
  }
  
  public void Ib()
  {
    this.TAG = "HotChatDemoChatPie";
  }
  
  public void bGE()
  {
    super.bGE();
    if (this.a != null) {
      this.a.setVisibility(8);
    }
  }
  
  public void bGZ()
  {
    if (this.pp != null) {
      this.pp.setVisibility(8);
    }
  }
  
  public void bs(Intent paramIntent)
  {
    this.aSu = true;
    if ((this.sessionInfo.troopUin == null) || (this.sessionInfo.troopUin.length() == 0))
    {
      paramIntent = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
      if (paramIntent != null) {
        this.sessionInfo.troopUin = paramIntent.troopcode;
      }
    }
    this.aWY = ax(this.sessionInfo.aTn, this.sessionInfo.troopUin);
  }
  
  public void bt(Intent paramIntent)
  {
    if (this.Cr != null)
    {
      this.Cr.setText(2131701265);
      this.Cr.setContentDescription(this.mActivity.getString(2131701265));
      this.Cr.setBackgroundDrawable(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 34)
    {
      Drawable localDrawable = null;
      if ((paramMessage.obj instanceof Drawable)) {
        localDrawable = (Drawable)paramMessage.obj;
      }
      if (paramMessage.arg1 == 2) {
        O(localDrawable);
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onShow()
  {
    super.onShow();
    if (this.hn == null)
    {
      if (TextUtils.isEmpty(this.aWY)) {
        this.aWY = ax(this.sessionInfo.aTn, this.sessionInfo.troopUin);
      }
      ThreadManager.getFileThreadHandler().post(new LoadQRCodeImg(this.aWY, this.uiHandler, this.bYb));
    }
  }
  
  public void vW(boolean paramBoolean)
  {
    super.vW(paramBoolean);
    this.mActivity.finish();
  }
  
  static class LoadQRCodeImg
    implements Runnable
  {
    private final int bYd;
    private final int bYe;
    private final int bYf;
    private WeakReference<MqqHandler> j;
    private final String mUrl;
    
    public LoadQRCodeImg(String paramString, MqqHandler paramMqqHandler, int paramInt)
    {
      this(paramString, paramMqqHandler, paramInt, 2, 0);
    }
    
    public LoadQRCodeImg(String paramString, MqqHandler paramMqqHandler, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mUrl = paramString;
      this.bYd = paramInt1;
      this.j = new WeakReference(paramMqqHandler);
      this.bYe = paramInt2;
      this.bYf = paramInt3;
    }
    
    /* Error */
    private Bitmap a(String paramString, Resources paramResources)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aconst_null
      //   3: astore 7
      //   5: aconst_null
      //   6: astore 8
      //   8: aconst_null
      //   9: astore 6
      //   11: aload 6
      //   13: astore_3
      //   14: aload 7
      //   16: astore 4
      //   18: aload 8
      //   20: astore 5
      //   22: new 52	java/lang/StringBuilder
      //   25: dup
      //   26: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   29: getstatic 58	acbn:bmg	Ljava/lang/String;
      //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   35: aload_1
      //   36: invokevirtual 68	java/lang/String:getBytes	()[B
      //   39: invokestatic 74	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
      //   42: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   48: astore 10
      //   50: aload 6
      //   52: astore_3
      //   53: aload 7
      //   55: astore 4
      //   57: aload 8
      //   59: astore 5
      //   61: invokestatic 84	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   64: ifeq +40 -> 104
      //   67: aload 6
      //   69: astore_3
      //   70: aload 7
      //   72: astore 4
      //   74: aload 8
      //   76: astore 5
      //   78: ldc 86
      //   80: iconst_4
      //   81: new 52	java/lang/StringBuilder
      //   84: dup
      //   85: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   88: ldc 88
      //   90: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: aload 10
      //   95: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   101: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   104: aload 6
      //   106: astore_3
      //   107: aload 7
      //   109: astore 4
      //   111: aload 8
      //   113: astore 5
      //   115: new 94	java/io/File
      //   118: dup
      //   119: aload 10
      //   121: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
      //   124: astore 9
      //   126: aload 6
      //   128: astore_3
      //   129: aload 7
      //   131: astore 4
      //   133: aload 8
      //   135: astore 5
      //   137: aload 9
      //   139: invokevirtual 100	java/io/File:exists	()Z
      //   142: ifne +80 -> 222
      //   145: aload 6
      //   147: astore_3
      //   148: aload 7
      //   150: astore 4
      //   152: aload 8
      //   154: astore 5
      //   156: aload_1
      //   157: aload_2
      //   158: aload_0
      //   159: getfield 31	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:bYd	I
      //   162: iconst_0
      //   163: iconst_1
      //   164: invokestatic 105	apzg:a	(Ljava/lang/String;Landroid/content/res/Resources;IIZ)Landroid/graphics/Bitmap;
      //   167: astore_2
      //   168: aload_2
      //   169: astore_3
      //   170: aload_2
      //   171: astore 4
      //   173: aload_2
      //   174: astore 5
      //   176: aload_2
      //   177: aload 9
      //   179: invokestatic 110	aqhu:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
      //   182: pop
      //   183: aload_2
      //   184: astore_1
      //   185: aload_2
      //   186: astore_3
      //   187: aload_2
      //   188: astore 4
      //   190: aload_2
      //   191: astore 5
      //   193: aload_0
      //   194: getfield 40	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:bYe	I
      //   197: iconst_1
      //   198: if_icmpne +20 -> 218
      //   201: aload_2
      //   202: astore_3
      //   203: aload_2
      //   204: astore 4
      //   206: aload_2
      //   207: astore 5
      //   209: aload_2
      //   210: aload_0
      //   211: getfield 42	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:bYf	I
      //   214: invokestatic 114	aqhu:scaleBitmap	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
      //   217: astore_1
      //   218: aload_0
      //   219: monitorexit
      //   220: aload_1
      //   221: areturn
      //   222: aload 6
      //   224: astore_3
      //   225: aload 7
      //   227: astore 4
      //   229: aload 8
      //   231: astore 5
      //   233: aload 10
      //   235: invokestatic 120	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   238: astore_2
      //   239: aload_2
      //   240: astore_1
      //   241: aload_2
      //   242: astore_3
      //   243: aload_2
      //   244: astore 4
      //   246: aload_2
      //   247: astore 5
      //   249: aload_0
      //   250: getfield 40	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:bYe	I
      //   253: iconst_1
      //   254: if_icmpne -36 -> 218
      //   257: aload_2
      //   258: astore_3
      //   259: aload_2
      //   260: astore 4
      //   262: aload_2
      //   263: astore 5
      //   265: aload_2
      //   266: aload_0
      //   267: getfield 42	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:bYf	I
      //   270: invokestatic 114	aqhu:scaleBitmap	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
      //   273: astore_1
      //   274: goto -56 -> 218
      //   277: astore_2
      //   278: aload_3
      //   279: astore_1
      //   280: invokestatic 84	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   283: ifeq -65 -> 218
      //   286: aload_2
      //   287: invokevirtual 123	java/lang/Exception:printStackTrace	()V
      //   290: aload_3
      //   291: astore_1
      //   292: goto -74 -> 218
      //   295: astore_1
      //   296: aload_0
      //   297: monitorexit
      //   298: aload_1
      //   299: athrow
      //   300: astore_2
      //   301: aload 4
      //   303: astore_1
      //   304: invokestatic 84	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   307: ifeq -89 -> 218
      //   310: aload_2
      //   311: invokevirtual 124	java/lang/Error:printStackTrace	()V
      //   314: aload 4
      //   316: astore_1
      //   317: goto -99 -> 218
      //   320: astore_1
      //   321: aload 5
      //   323: astore_1
      //   324: goto -106 -> 218
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	327	0	this	LoadQRCodeImg
      //   0	327	1	paramString	String
      //   0	327	2	paramResources	Resources
      //   13	278	3	localObject1	Object
      //   16	299	4	localObject2	Object
      //   20	302	5	localObject3	Object
      //   9	214	6	localObject4	Object
      //   3	223	7	localObject5	Object
      //   6	224	8	localObject6	Object
      //   124	54	9	localFile	java.io.File
      //   48	186	10	str	String
      // Exception table:
      //   from	to	target	type
      //   22	50	277	java/lang/Exception
      //   61	67	277	java/lang/Exception
      //   78	104	277	java/lang/Exception
      //   115	126	277	java/lang/Exception
      //   137	145	277	java/lang/Exception
      //   156	168	277	java/lang/Exception
      //   176	183	277	java/lang/Exception
      //   193	201	277	java/lang/Exception
      //   209	218	277	java/lang/Exception
      //   233	239	277	java/lang/Exception
      //   249	257	277	java/lang/Exception
      //   265	274	277	java/lang/Exception
      //   22	50	295	finally
      //   61	67	295	finally
      //   78	104	295	finally
      //   115	126	295	finally
      //   137	145	295	finally
      //   156	168	295	finally
      //   176	183	295	finally
      //   193	201	295	finally
      //   209	218	295	finally
      //   233	239	295	finally
      //   249	257	295	finally
      //   265	274	295	finally
      //   280	290	295	finally
      //   304	314	295	finally
      //   22	50	300	java/lang/Error
      //   61	67	300	java/lang/Error
      //   78	104	300	java/lang/Error
      //   115	126	300	java/lang/Error
      //   137	145	300	java/lang/Error
      //   156	168	300	java/lang/Error
      //   176	183	300	java/lang/Error
      //   193	201	300	java/lang/Error
      //   209	218	300	java/lang/Error
      //   233	239	300	java/lang/Error
      //   249	257	300	java/lang/Error
      //   265	274	300	java/lang/Error
      //   22	50	320	java/lang/OutOfMemoryError
      //   61	67	320	java/lang/OutOfMemoryError
      //   78	104	320	java/lang/OutOfMemoryError
      //   115	126	320	java/lang/OutOfMemoryError
      //   137	145	320	java/lang/OutOfMemoryError
      //   156	168	320	java/lang/OutOfMemoryError
      //   176	183	320	java/lang/OutOfMemoryError
      //   193	201	320	java/lang/OutOfMemoryError
      //   209	218	320	java/lang/OutOfMemoryError
      //   233	239	320	java/lang/OutOfMemoryError
      //   249	257	320	java/lang/OutOfMemoryError
      //   265	274	320	java/lang/OutOfMemoryError
    }
    
    public void run()
    {
      Object localObject1 = BaseApplicationImpl.getContext().getResources();
      Object localObject2 = a(this.mUrl, (Resources)localObject1);
      if (localObject2 != null) {}
      for (localObject1 = new BitmapDrawable((Resources)localObject1, (Bitmap)localObject2);; localObject1 = null)
      {
        localObject2 = (MqqHandler)this.j.get();
        if (localObject2 != null) {
          ((MqqHandler)localObject2).obtainMessage(34, this.bYe, 0, localObject1).sendToTarget();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */