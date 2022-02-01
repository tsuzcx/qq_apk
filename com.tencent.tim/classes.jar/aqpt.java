import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vas.ColorRingPlayer.3;
import com.tencent.mobileqq.vas.ColorRingPlayer.8;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONObject;

public class aqpt
  implements View.OnClickListener
{
  ImageView Fh;
  ImageView Fi;
  TextView XA;
  aqpt.a jdField_a_of_type_Aqpt$a = new aqpt.a();
  argt jdField_a_of_type_Argt = null;
  TextView abC;
  TextView abD;
  TextView abE;
  ProgressBar ap;
  public Client.b b = new aqpz(this);
  boolean cVA = true;
  boolean cVB = false;
  AudioManager.OnAudioFocusChangeListener jdField_d_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new aqpv(this);
  QQBrowserActivity jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  Button dy;
  ViewGroup eJ;
  int ebv;
  ImageView fV;
  public Handler handler;
  public Object lock = new Object();
  public ProgressBar mPlayProgress;
  public MediaPlayer mediaPlayer = null;
  
  public aqpt(QQBrowserActivity paramQQBrowserActivity, ViewGroup paramViewGroup)
  {
    this.eJ = paramViewGroup;
    this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    afjy.a().a(this.b);
    this.fV = ((ImageView)paramViewGroup.findViewById(2131365477));
    this.dy = ((Button)paramViewGroup.findViewById(2131361975));
    this.Fi = ((ImageView)paramViewGroup.findViewById(2131365484));
    this.mPlayProgress = ((ProgressBar)paramViewGroup.findViewById(2131373659));
    this.abD = ((TextView)paramViewGroup.findViewById(2131364924));
    this.XA = ((TextView)paramViewGroup.findViewById(2131364923));
    this.abE = ((TextView)paramViewGroup.findViewById(2131364920));
    this.Fh = ((ImageView)paramViewGroup.findViewById(2131373674));
    this.ap = ((ProgressBar)paramViewGroup.findViewById(2131378155));
    this.abC = ((TextView)paramViewGroup.findViewById(2131378285));
    this.dy.setOnClickListener(this);
    this.Fi.setOnClickListener(this);
    this.handler = new Handler();
  }
  
  public void Vr(String arg1)
  {
    if ((this.mediaPlayer != null) && (this.mediaPlayer.isPlaying()))
    {
      this.ebv = this.mediaPlayer.getCurrentPosition();
      this.mediaPlayer.stop();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
      this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847956));
    }
    synchronized (this.jdField_a_of_type_Aqpt$a)
    {
      this.jdField_a_of_type_Aqpt$a.aNy = 6;
      this.cVB = false;
      if ((this.eJ != null) && (this.eJ.getVisibility() == 0)) {
        this.eJ.setVisibility(8);
      }
      return;
    }
  }
  
  void aL(long paramLong, String paramString)
  {
    if ("colorring".equals(paramString)) {
      this.abC.setText(2131691754);
    }
    for (;;)
    {
      this.Fi.setTag(paramString);
      this.dy.setTag(paramString);
      if (paramLong != 0L) {
        break label249;
      }
      aY(paramLong, 0);
      if (!j(paramLong, paramString)) {
        break;
      }
      this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691750));
      this.dy.setEnabled(false);
      this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847955));
      this.fV.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847953));
      this.Fh.setVisibility(8);
      this.XA.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131692451));
      this.abD.setText("");
      return;
      if ("comering".equals(paramString)) {
        this.abC.setText(2131691867);
      }
    }
    if (paramString.equals("colorring")) {
      this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719567));
    }
    for (;;)
    {
      this.dy.setEnabled(true);
      break;
      if (paramString.equals("comering")) {
        this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719569));
      }
    }
    label249:
    if (j(paramLong, paramString)) {
      this.dy.setEnabled(false);
    }
    if (!new File(aqpr.p(paramLong, 3)).exists())
    {
      this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847954));
      this.Fi.setVisibility(0);
      if (paramString.equals("colorring"))
      {
        this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719567));
        this.dy.setEnabled(true);
        o(paramLong, 3, paramString);
        label354:
        if (new File(aqpr.p(paramLong, 1)).exists()) {
          break label589;
        }
        this.fV.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847952));
        o(paramLong, 1, paramString);
      }
    }
    for (;;)
    {
      if (new File(aqpr.p(paramLong, 2)).exists()) {
        break label610;
      }
      this.XA.setText("");
      this.abD.setText("");
      o(paramLong, 2, paramString);
      return;
      if (!paramString.equals("comering")) {
        break;
      }
      this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719569));
      break;
      aY(paramLong, 0);
      if (j(paramLong, paramString))
      {
        this.dy.setEnabled(false);
        this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691750));
        break label354;
      }
      if (paramString.equals("colorring")) {
        this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719567));
      }
      for (;;)
      {
        this.dy.setEnabled(true);
        break;
        if (paramString.equals("comering")) {
          this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719569));
        }
      }
      label589:
      if (aqpr.e(paramLong) != null) {
        this.fV.setImageBitmap(aqpr.e(paramLong));
      }
    }
    label610:
    bQ(aqpr.a(paramLong));
  }
  
  /* Error */
  void aY(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +30 -> 36
    //   9: ldc_w 283
    //   12: iconst_2
    //   13: new 285	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 288
    //   23: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_1
    //   27: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 55	aqpt:lock	Ljava/lang/Object;
    //   40: astore 4
    //   42: aload 4
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   56: invokevirtual 160	android/media/MediaPlayer:release	()V
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   64: aload 4
    //   66: monitorexit
    //   67: aload_0
    //   68: new 144	android/media/MediaPlayer
    //   71: dup
    //   72: invokespecial 303	android/media/MediaPlayer:<init>	()V
    //   75: putfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   78: aload_0
    //   79: getfield 53	aqpt:jdField_a_of_type_Aqpt$a	Laqpt$a;
    //   82: astore 6
    //   84: aload 6
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 53	aqpt:jdField_a_of_type_Aqpt$a	Laqpt$a;
    //   91: iconst_4
    //   92: putfield 180	aqpt$a:aNy	I
    //   95: aload 6
    //   97: monitorexit
    //   98: lload_1
    //   99: lconst_0
    //   100: lcmp
    //   101: ifne +321 -> 422
    //   104: aload_0
    //   105: getfield 77	aqpt:jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   108: invokevirtual 166	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   111: ldc_w 304
    //   114: invokevirtual 308	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   117: astore 4
    //   119: aload 4
    //   121: ifnonnull +120 -> 241
    //   124: aload_0
    //   125: getfield 55	aqpt:lock	Ljava/lang/Object;
    //   128: astore 6
    //   130: aload 6
    //   132: monitorenter
    //   133: aload_0
    //   134: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   137: invokevirtual 160	android/media/MediaPlayer:release	()V
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   145: aload 6
    //   147: monitorexit
    //   148: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +13 -> 164
    //   154: ldc_w 283
    //   157: iconst_2
    //   158: ldc_w 310
    //   161: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 315	android/content/res/AssetFileDescriptor:close	()V
    //   174: return
    //   175: astore 5
    //   177: aload 4
    //   179: monitorexit
    //   180: aload 5
    //   182: athrow
    //   183: astore 4
    //   185: aload 6
    //   187: monitorexit
    //   188: aload 4
    //   190: athrow
    //   191: astore 5
    //   193: aconst_null
    //   194: astore 4
    //   196: aload 5
    //   198: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   201: aload 4
    //   203: ifnull -29 -> 174
    //   206: aload 4
    //   208: invokevirtual 315	android/content/res/AssetFileDescriptor:close	()V
    //   211: return
    //   212: astore 4
    //   214: aload 4
    //   216: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   219: return
    //   220: astore 5
    //   222: aload 6
    //   224: monitorexit
    //   225: aload 5
    //   227: athrow
    //   228: astore 5
    //   230: goto -34 -> 196
    //   233: astore 4
    //   235: aload 4
    //   237: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   240: return
    //   241: aload_0
    //   242: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   245: aload 4
    //   247: invokevirtual 323	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   250: aload 4
    //   252: invokevirtual 327	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   255: aload 4
    //   257: invokevirtual 330	android/content/res/AssetFileDescriptor:getLength	()J
    //   260: invokevirtual 334	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   263: aload 4
    //   265: invokevirtual 315	android/content/res/AssetFileDescriptor:close	()V
    //   268: aload_0
    //   269: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   272: invokevirtual 337	android/media/MediaPlayer:prepare	()V
    //   275: aload_0
    //   276: getfield 77	aqpt:jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   279: ldc_w 339
    //   282: invokevirtual 343	com/tencent/mobileqq/activity/QQBrowserActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   285: checkcast 345	android/media/AudioManager
    //   288: astore 4
    //   290: aload 4
    //   292: aload_0
    //   293: getfield 68	aqpt:jdField_d_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
    //   296: iconst_3
    //   297: iconst_1
    //   298: invokevirtual 349	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   301: iconst_1
    //   302: if_icmpne +135 -> 437
    //   305: aload_0
    //   306: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   309: iload_3
    //   310: invokevirtual 352	android/media/MediaPlayer:seekTo	(I)V
    //   313: aload_0
    //   314: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   317: invokevirtual 355	android/media/MediaPlayer:start	()V
    //   320: aload_0
    //   321: invokevirtual 358	aqpt:eeS	()V
    //   324: aload_0
    //   325: getfield 120	aqpt:abE	Landroid/widget/TextView;
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   333: invokevirtual 361	android/media/MediaPlayer:getDuration	()I
    //   336: sipush 1000
    //   339: idiv
    //   340: invokevirtual 364	aqpt:gh	(I)Ljava/lang/String;
    //   343: invokevirtual 231	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   346: aload_0
    //   347: getfield 104	aqpt:Fi	Landroid/widget/ImageView;
    //   350: aload_0
    //   351: getfield 77	aqpt:jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   354: invokevirtual 166	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   357: ldc 227
    //   359: invokevirtual 173	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   362: invokevirtual 177	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   365: aload_0
    //   366: getfield 104	aqpt:Fi	Landroid/widget/ImageView;
    //   369: iconst_0
    //   370: invokevirtual 229	android/widget/ImageView:setVisibility	(I)V
    //   373: aload_0
    //   374: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   377: new 366	aqpu
    //   380: dup
    //   381: aload_0
    //   382: aload 4
    //   384: invokespecial 369	aqpu:<init>	(Laqpt;Landroid/media/AudioManager;)V
    //   387: invokevirtual 373	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   390: aload_0
    //   391: ldc_w 375
    //   394: ldc_w 375
    //   397: lload_1
    //   398: iconst_0
    //   399: invokevirtual 379	aqpt:k	(Ljava/lang/String;Ljava/lang/String;JI)V
    //   402: iconst_0
    //   403: ifeq -229 -> 174
    //   406: new 381	java/lang/NullPointerException
    //   409: dup
    //   410: invokespecial 382	java/lang/NullPointerException:<init>	()V
    //   413: athrow
    //   414: astore 4
    //   416: aload 4
    //   418: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   421: return
    //   422: aload_0
    //   423: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   426: lload_1
    //   427: iconst_3
    //   428: invokestatic 246	aqpr:p	(JI)Ljava/lang/String;
    //   431: invokevirtual 384	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   434: goto -166 -> 268
    //   437: aload_0
    //   438: getfield 55	aqpt:lock	Ljava/lang/Object;
    //   441: astore 6
    //   443: aload 6
    //   445: monitorenter
    //   446: aload_0
    //   447: getfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   450: invokevirtual 160	android/media/MediaPlayer:release	()V
    //   453: aload_0
    //   454: aconst_null
    //   455: putfield 57	aqpt:mediaPlayer	Landroid/media/MediaPlayer;
    //   458: aload 6
    //   460: monitorexit
    //   461: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq -62 -> 402
    //   467: ldc_w 283
    //   470: iconst_2
    //   471: ldc_w 386
    //   474: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -75 -> 402
    //   480: astore 4
    //   482: aload 5
    //   484: ifnull +8 -> 492
    //   487: aload 5
    //   489: invokevirtual 315	android/content/res/AssetFileDescriptor:close	()V
    //   492: aload 4
    //   494: athrow
    //   495: astore 4
    //   497: aload 6
    //   499: monitorexit
    //   500: aload 4
    //   502: athrow
    //   503: astore 5
    //   505: aload 5
    //   507: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   510: goto -18 -> 492
    //   513: astore 6
    //   515: aload 4
    //   517: astore 5
    //   519: aload 6
    //   521: astore 4
    //   523: goto -41 -> 482
    //   526: astore 6
    //   528: aload 4
    //   530: astore 5
    //   532: aload 6
    //   534: astore 4
    //   536: goto -54 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	aqpt
    //   0	539	1	paramLong	long
    //   0	539	3	paramInt	int
    //   40	138	4	localObject1	Object
    //   183	6	4	localObject2	Object
    //   194	13	4	localObject3	Object
    //   212	3	4	localException1	Exception
    //   233	31	4	localException2	Exception
    //   288	95	4	localAudioManager	AudioManager
    //   414	3	4	localException3	Exception
    //   480	13	4	localObject4	Object
    //   495	21	4	localObject5	Object
    //   521	14	4	localObject6	Object
    //   1	1	5	localObject7	Object
    //   175	6	5	localObject8	Object
    //   191	6	5	localIOException1	java.io.IOException
    //   220	6	5	localObject9	Object
    //   228	260	5	localIOException2	java.io.IOException
    //   503	3	5	localException4	Exception
    //   517	14	5	localObject10	Object
    //   513	7	6	localObject12	Object
    //   526	7	6	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   45	64	175	finally
    //   64	67	175	finally
    //   177	180	175	finally
    //   87	98	183	finally
    //   185	188	183	finally
    //   78	87	191	java/io/IOException
    //   104	119	191	java/io/IOException
    //   188	191	191	java/io/IOException
    //   268	402	191	java/io/IOException
    //   422	434	191	java/io/IOException
    //   437	446	191	java/io/IOException
    //   461	477	191	java/io/IOException
    //   500	503	191	java/io/IOException
    //   206	211	212	java/lang/Exception
    //   133	148	220	finally
    //   222	225	220	finally
    //   124	133	228	java/io/IOException
    //   148	164	228	java/io/IOException
    //   225	228	228	java/io/IOException
    //   241	268	228	java/io/IOException
    //   169	174	233	java/lang/Exception
    //   406	414	414	java/lang/Exception
    //   78	87	480	finally
    //   104	119	480	finally
    //   188	191	480	finally
    //   268	402	480	finally
    //   422	434	480	finally
    //   437	446	480	finally
    //   461	477	480	finally
    //   500	503	480	finally
    //   446	461	495	finally
    //   497	500	495	finally
    //   487	492	503	java/lang/Exception
    //   124	133	513	finally
    //   148	164	513	finally
    //   225	228	513	finally
    //   241	268	513	finally
    //   196	201	526	finally
  }
  
  void bQ(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "initColorRingDetail, detail is null");
      }
      return;
    }
    try
    {
      this.abD.setText(paramJSONObject.getString("singer"));
      this.XA.setText(paramJSONObject.getString("name"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void c(long paramLong, String paramString1, int paramInt, String arg5)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Aqpt$a)
      {
        if (this.jdField_a_of_type_Aqpt$a.atA == paramLong)
        {
          if (paramInt != 0) {
            break label203;
          }
          this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691750));
          this.dy.setEnabled(false);
          if (!paramString1.equals("colorring")) {
            continue;
          }
          if (paramInt == 0)
          {
            paramInt = i;
            k("0X8004A24", "0X8004A24", paramLong, paramInt);
            Bundle localBundle = new Bundle();
            localBundle.putLong("id", paramLong);
            localBundle.putString("colorType", paramString1);
            dw(affz.a("colorRingSetup", "", this.b.key, localBundle));
          }
        }
        else
        {
          this.ap.setVisibility(8);
          return;
        }
        paramInt = 1;
        continue;
        if (!paramString1.equals("comering")) {
          continue;
        }
        if (paramInt == 0)
        {
          paramInt = j;
          k("0X8005003", "0X8005003", paramLong, paramInt);
        }
      }
      paramInt = 1;
      continue;
      label203:
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "setup failure.");
      }
    }
  }
  
  public void dw(Bundle paramBundle)
  {
    if (!afjy.a().ajq())
    {
      Toast.makeText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), acfp.m(2131704175), 0).show();
      return;
    }
    afjy.a().cr(paramBundle);
  }
  
  void eeP()
  {
    synchronized (this.lock)
    {
      if ((this.mediaPlayer != null) && (this.mediaPlayer.isPlaying()))
      {
        this.mediaPlayer.pause();
        this.ebv = this.mediaPlayer.getCurrentPosition();
        this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847956));
      }
      this.jdField_a_of_type_Aqpt$a.aNy = 5;
      return;
    }
  }
  
  void eeQ()
  {
    synchronized (this.lock)
    {
      if (this.mediaPlayer != null)
      {
        this.mediaPlayer.stop();
        this.mediaPlayer.release();
        this.mediaPlayer = null;
      }
      this.mPlayProgress.setProgress(0);
      return;
    }
  }
  
  void eeR()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.mediaPlayer == null) {
          synchronized (this.jdField_a_of_type_Aqpt$a)
          {
            long l = this.jdField_a_of_type_Aqpt$a.atA;
            aY(l, this.ebv);
            eeS();
            this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847955));
          }
        }
      }
      synchronized (this.jdField_a_of_type_Aqpt$a)
      {
        this.jdField_a_of_type_Aqpt$a.aNy = 4;
        return;
        localObject4 = finally;
        throw localObject4;
        localObject2 = finally;
        throw localObject2;
        this.mediaPlayer.seekTo(this.ebv);
        this.mediaPlayer.start();
      }
    }
  }
  
  void eeS()
  {
    ThreadManager.post(new ColorRingPlayer.3(this), 8, null, true);
  }
  
  public void eeT()
  {
    if ((this.eJ != null) && (this.eJ.getVisibility() != 0)) {
      this.eJ.setVisibility(0);
    }
  }
  
  String gh(int paramInt)
  {
    if (paramInt > 3599) {
      return "";
    }
    int i = paramInt % 60;
    paramInt /= 60;
    if (paramInt >= 10) {}
    for (String str = "" + paramInt;; str = "" + "0" + paramInt)
    {
      str = str + ":";
      if (i < 10) {
        break;
      }
      return str + i;
    }
    return str + "0" + i;
  }
  
  boolean j(long paramLong, String paramString)
  {
    Object localObject = (BrowserAppInterface)this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getAppRuntime();
    EntityManager localEntityManager = ((BrowserAppInterface)localObject).getEntityManagerFactory(null).createEntityManager();
    localObject = (ExtensionInfo)localEntityManager.find(ExtensionInfo.class, ((BrowserAppInterface)localObject).getAccount());
    localEntityManager.close();
    if (localObject == null) {
      return false;
    }
    if (("colorring".equals(paramString)) && (((ExtensionInfo)localObject).colorRingId == paramLong)) {
      return true;
    }
    return ("comering".equals(paramString)) && (((ExtensionInfo)localObject).commingRingId == paramLong);
  }
  
  void k(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new ColorRingPlayer.8(this, paramString1, paramString2, paramLong, paramInt));
  }
  
  void ma(long paramLong)
  {
    ??? = new Bundle();
    ((Bundle)???).putLong("id", paramLong);
    ((Bundle)???).putInt("resourceType", 3);
    dw(affz.a("stopDownloadColorRing", "", this.b.key, (Bundle)???));
    synchronized (this.jdField_a_of_type_Aqpt$a)
    {
      this.jdField_a_of_type_Aqpt$a.aNy = 2;
      this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847954));
      this.Fi.setVisibility(0);
      this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691752));
      this.Fh.setVisibility(4);
      return;
    }
  }
  
  void o(long paramLong, int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt != 3)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("id", paramLong);
      ((Bundle)localObject).putInt("resourceType", paramInt);
      ((Bundle)localObject).putString("colorType", paramString);
      dw(affz.a("startDownloadColorRing", "", this.b.key, (Bundle)localObject));
      return;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      localObject = new aqpw(this, this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getActivity(), 2131756467);
      ((aqju)localObject).setContentView(2131559151);
      ((aqju)localObject).setTitle(acfp.m(2131704176));
      ((aqju)localObject).setMessage(2131721031);
      ((aqju)localObject).setCanceledOnTouchOutside(false);
      ((aqju)localObject).setNegativeButton(2131721058, new aqpx(this));
      ((aqju)localObject).setPositiveButton(2131721079, new aqpy(this, paramLong, paramInt, paramString));
      ((aqju)localObject).show();
      return;
    }
    p(paramLong, paramInt, paramString);
  }
  
  public void onClick(View paramView)
  {
    ??? = (String)paramView.getTag();
    Object localObject1 = ???;
    if (??? == null) {
      localObject1 = "colorring";
    }
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131365484: 
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Aqpt$a)
        {
          if (this.jdField_a_of_type_Aqpt$a.aNy == 4) {
            eeP();
          }
        }
        if (this.jdField_a_of_type_Aqpt$a.aNy == 5)
        {
          eeR();
        }
        else if (this.jdField_a_of_type_Aqpt$a.aNy == 6)
        {
          aY(this.jdField_a_of_type_Aqpt$a.atA, 0);
        }
        else if (this.jdField_a_of_type_Aqpt$a.aNy == 1)
        {
          ma(this.jdField_a_of_type_Aqpt$a.atA);
          this.jdField_a_of_type_Aqpt$a.aNy = 2;
        }
        else if (this.jdField_a_of_type_Aqpt$a.aNy == 2)
        {
          o(this.jdField_a_of_type_Aqpt$a.atA, 3, (String)localObject1);
        }
        else if (this.jdField_a_of_type_Aqpt$a.aNy == 0)
        {
          o(this.jdField_a_of_type_Aqpt$a.atA, 3, (String)localObject1);
        }
        else if (this.jdField_a_of_type_Aqpt$a.aNy == 3)
        {
          aY(this.jdField_a_of_type_Aqpt$a.atA, 0);
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Aqpt$a)
      {
        if (this.jdField_a_of_type_Aqpt$a.aNy == 1) {
          ma(this.jdField_a_of_type_Aqpt$a.atA);
        }
      }
      if (this.jdField_a_of_type_Aqpt$a.aNy == 2)
      {
        o(this.jdField_a_of_type_Aqpt$a.atA, 3, (String)localObject1);
      }
      else if (this.jdField_a_of_type_Aqpt$a.aNy == 0)
      {
        o(this.jdField_a_of_type_Aqpt$a.atA, 3, (String)localObject1);
      }
      else if (this.jdField_a_of_type_Aqpt$a.aNy >= 3)
      {
        localObject1 = this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.c();
        if (localObject1 != null) {
          ((WebViewFragment)localObject1).getWebView().callJs(this.jdField_a_of_type_Aqpt$a.cuU, new String[] { "{'result':0,'message':'OK'}" });
        }
        this.ap.setVisibility(0);
      }
    }
  }
  
  public void onDestroy()
  {
    afjy.a().b(this.b);
    ??? = (AudioManager)this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("audio");
    if (??? == null) {
      return;
    }
    ((AudioManager)???).abandonAudioFocus(this.jdField_d_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    synchronized (this.lock)
    {
      if (this.mediaPlayer != null)
      {
        this.mediaPlayer.release();
        this.mediaPlayer = null;
      }
      return;
    }
  }
  
  public void onPause()
  {
    synchronized (this.lock)
    {
      if ((this.mediaPlayer != null) && (this.mediaPlayer.isPlaying()))
      {
        this.ebv = this.mediaPlayer.getCurrentPosition();
        this.mediaPlayer.stop();
        this.mediaPlayer.release();
        this.mediaPlayer = null;
        this.Fi.setImageDrawable(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847956));
      }
      synchronized (this.jdField_a_of_type_Aqpt$a)
      {
        this.jdField_a_of_type_Aqpt$a.aNy = 6;
        this.cVB = true;
        this.cVA = false;
        return;
      }
    }
  }
  
  public void onResume()
  {
    this.cVA = true;
  }
  
  void p(long paramLong, int paramInt, String arg4)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("id", paramLong);
    ((Bundle)localObject1).putInt("resourceType", paramInt);
    ((Bundle)localObject1).putString("colorType", ???);
    dw(affz.a("startDownloadColorRing", "", this.b.key, (Bundle)localObject1));
    synchronized (this.jdField_a_of_type_Aqpt$a)
    {
      this.jdField_a_of_type_Aqpt$a.aNy = 1;
      this.Fh.setVisibility(0);
      ??? = null;
      if (this.jdField_a_of_type_Argt == null) {}
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources(), 2130849452);
        ??? = (String)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label115:
        break label115;
      }
      localObject1 = ???;
      if (??? == null) {
        localObject1 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_Argt = new argt((Bitmap)localObject1, (int)(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().density * 12.0F));
      ??? = new Rect();
      ???.set(0, 0, this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131296850), this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131296849));
      this.jdField_a_of_type_Argt.setBounds(???);
      this.Fh.setImageDrawable(this.jdField_a_of_type_Argt);
      this.jdField_a_of_type_Argt.setLevel(0);
      this.jdField_a_of_type_Argt.invalidateSelf();
      this.mPlayProgress.setProgress(0);
      this.dy.setText(this.jdField_d_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691751));
      this.Fi.setVisibility(8);
      return;
    }
  }
  
  public void u(long paramLong, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Aqpt$a.atA == paramLong) && (this.jdField_a_of_type_Aqpt$a.curType.equals(paramString1)))
    {
      if (this.jdField_a_of_type_Aqpt$a.aNy == 6) {
        aY(paramLong, 0);
      }
      return;
    }
    if (this.jdField_a_of_type_Aqpt$a.aNy == 1) {
      ma(this.jdField_a_of_type_Aqpt$a.atA);
    }
    eeQ();
    this.jdField_a_of_type_Aqpt$a.atA = paramLong;
    this.jdField_a_of_type_Aqpt$a.curType = paramString1;
    this.jdField_a_of_type_Aqpt$a.cuU = paramString2;
    this.jdField_a_of_type_Aqpt$a.aNy = 0;
    this.ap.setVisibility(8);
    aL(paramLong, paramString1);
  }
  
  class a
  {
    public int aNy;
    public long atA = -1L;
    public String cuU = "";
    public String curType = "";
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpt
 * JD-Core Version:    0.7.0.1
 */