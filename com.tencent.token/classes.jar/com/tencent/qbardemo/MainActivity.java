package com.tencent.qbardemo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qbar.QbarNative;
import com.tencent.token.af;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.r;
import com.tencent.token.ui.GetBarcodeVerifyMsgActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.ScanLoginAccountListActivity;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import com.tencent.token.x;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity
  extends Activity
  implements Camera.AutoFocusCallback, Camera.PreviewCallback, SurfaceHolder.Callback
{
  public static final double ASPECT_RATIO = 1.0D;
  private static final String BARCODE_URL_PREFIX = "aq.qq.com/sao?";
  public static final int D_DELAY = 1000;
  public static final int D_PERIOD = 200;
  public static final int F_DELAY = 500;
  public static final int F_PERIOD = 2500;
  public static final double RECT_RATIO = 0.6D;
  public static final int THRESHOLD = 1;
  private Camera camera;
  private Camera.PreviewCallback cb;
  private int detectCounter = 1;
  private TimerTask detectTask;
  private Timer detectTimer;
  private boolean flag = false;
  private TimerTask focusTask;
  private Timer focusTimer;
  private SurfaceHolder holder;
  public byte[] inData;
  private String mBarcodeResult;
  private int mSource = 0;
  private TextView mTitleText;
  public byte[] outData;
  private Camera.Parameters parameters;
  public String path;
  private int preHeight;
  private int preWidth;
  public byte[] previewData;
  private int screenHeight;
  private int screenWidth;
  private SurfaceView surfaceView;
  public Handler uiHandler = new MainActivity.1(this);
  private RectView view;
  
  private static String findSettableValue(Collection paramCollection, String... paramVarArgs)
  {
    int i;
    String str;
    if (paramCollection != null)
    {
      int j = paramVarArgs.length;
      i = 0;
      if (i < j)
      {
        str = paramVarArgs[i];
        if (!paramCollection.contains(str)) {}
      }
    }
    for (paramCollection = str;; paramCollection = null)
    {
      e.b("resolution Settable value: " + paramCollection);
      return paramCollection;
      i += 1;
      break;
    }
  }
  
  private void finishActivity()
  {
    if (isFinishing()) {
      return;
    }
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.addFlags(4194304);
    IndexActivity.CAM_ERR = true;
    startActivity(localIntent);
    finish();
  }
  
  private String parseBarcode(String paramString)
  {
    if ((paramString != null) && (paramString.indexOf("aq.qq.com/sao?") != -1))
    {
      int i = paramString.indexOf('?');
      e.a("scan string: " + paramString.substring(i + 1));
      return paramString.substring(i + 1);
    }
    return null;
  }
  
  public void createUI()
  {
    this.path = (Environment.getExternalStorageDirectory() + File.separator + "test");
    new File(this.path).mkdir();
    Object localObject = getResources().getDisplayMetrics();
    this.screenWidth = ((DisplayMetrics)localObject).heightPixels;
    this.screenHeight = ((DisplayMetrics)localObject).widthPixels;
    this.surfaceView = ((SurfaceView)findViewById(2131296416));
    this.mTitleText = ((TextView)findViewById(2131296419));
    localObject = (RelativeLayout)findViewById(2131296415);
    this.view = new RectView(this, this.screenHeight, this.screenWidth);
    this.view.invalidate();
    ((RelativeLayout)localObject).addView(this.view);
    if (this.mSource == 0)
    {
      this.mTitleText.setText(getResources().getString(2131362111));
      return;
    }
    this.mTitleText.setText(getResources().getString(2131362756));
  }
  
  public void detectStart()
  {
    this.detectTimer = new Timer(false);
    this.detectTask = new MainActivity.5(this);
    try
    {
      this.detectTimer.schedule(this.detectTask, 1000L, 200L);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void doFocus()
  {
    if (this.camera == null) {
      return;
    }
    try
    {
      this.camera.autoFocus(this);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      e.d("camera auto focus " + localRuntimeException.toString());
      finishActivity();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      e.d("camera auto focus " + localException.toString());
      finishActivity();
    }
  }
  
  public void focusStart()
  {
    this.focusTimer = new Timer(false);
    this.focusTask = new MainActivity.4(this);
    this.focusTimer.schedule(this.focusTask, 500L, 2500L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      this.flag = false;
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    t.a(true);
    requestWindowFeature(1);
    if (getIntent() != null) {
      this.mSource = getIntent().getIntExtra("source_from", 0);
    }
    setContentView(2130903054);
    createUI();
    this.cb = this;
    this.holder = this.surfaceView.getHolder();
    this.holder.addCallback(this);
    this.holder.setType(3);
    findViewById(2131296422).setOnClickListener(new MainActivity.2(this));
    findViewById(2131296420).setOnClickListener(new MainActivity.3(this));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Log.i("TAG", "exit");
      QbarNative.Release();
      finish();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.previewData = paramArrayOfByte;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void setDisplayOrientation(Camera paramCamera, int paramInt)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (localMethod != null) {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      }
      return;
    }
    catch (Exception paramCamera)
    {
      Log.e("MainActivity", "setDisplayOrientation: " + paramCamera.getMessage());
    }
  }
  
  public void showResult(Bundle paramBundle)
  {
    this.mBarcodeResult = paramBundle.getString("dataInfo");
    paramBundle = paramBundle.getString("dataInfo");
    Object localObject1 = x.a(getApplicationContext());
    if (((x)localObject1).a(paramBundle))
    {
      ((x)localObject1).b(paramBundle);
      localObject2 = new Intent(this, ScanLoginAccountListActivity.class);
      int i = paramBundle.indexOf("?k=") + 3;
      paramBundle = paramBundle.substring(i, i + 32);
      ((Intent)localObject2).putExtra("scancode", s.a(paramBundle.getBytes(), paramBundle.length()));
      startActivityForResult((Intent)localObject2, 1);
      r.a(RqdApplication.i()).a(((x)localObject1).b());
      finish();
      return;
    }
    localObject1 = parseBarcode(paramBundle);
    if (localObject1 == null)
    {
      localObject1 = (ImageView)findViewById(2131296417);
      ((ImageView)localObject1).setImageResource(2130837713);
      ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
      af.a().c(paramBundle, this.uiHandler);
      return;
    }
    paramBundle = new Intent(this, GetBarcodeVerifyMsgActivity.class);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("barcode_result", (String)localObject1);
    paramBundle.putExtra("com.tencent.input_param", (Bundle)localObject2);
    startActivityForResult(paramBundle, 1);
    this.detectCounter = 0;
    this.view.setDrawLineImage(true);
    this.view.invalidate();
  }
  
  /* Error */
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 398
    //   3: ldc_w 579
    //   6: invokestatic 406	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   23: invokevirtual 583	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   26: putfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   29: aload_0
    //   30: getfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   33: invokevirtual 591	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   36: astore 5
    //   38: aload_0
    //   39: aload 5
    //   41: iconst_0
    //   42: invokeinterface 597 2 0
    //   47: checkcast 599	android/hardware/Camera$Size
    //   50: getfield 602	android/hardware/Camera$Size:width	I
    //   53: putfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   56: aload_0
    //   57: aload 5
    //   59: iconst_0
    //   60: invokeinterface 597 2 0
    //   65: checkcast 599	android/hardware/Camera$Size
    //   68: getfield 605	android/hardware/Camera$Size:height	I
    //   71: putfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   74: new 127	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 607
    //   84: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   91: invokevirtual 610	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 612
    //   97: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 610	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 614	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore_2
    //   113: iload_2
    //   114: aload 5
    //   116: invokeinterface 617 1 0
    //   121: if_icmpge +154 -> 275
    //   124: aload_0
    //   125: getfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   128: i2d
    //   129: aload_0
    //   130: getfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   133: i2d
    //   134: ddiv
    //   135: aload_0
    //   136: getfield 232	com/tencent/qbardemo/MainActivity:screenWidth	I
    //   139: i2d
    //   140: aload_0
    //   141: getfield 237	com/tencent/qbardemo/MainActivity:screenHeight	I
    //   144: i2d
    //   145: ddiv
    //   146: dsub
    //   147: invokestatic 623	java/lang/Math:abs	(D)D
    //   150: aload 5
    //   152: iload_2
    //   153: invokeinterface 597 2 0
    //   158: checkcast 599	android/hardware/Camera$Size
    //   161: getfield 602	android/hardware/Camera$Size:width	I
    //   164: i2d
    //   165: aload 5
    //   167: iload_2
    //   168: invokeinterface 597 2 0
    //   173: checkcast 599	android/hardware/Camera$Size
    //   176: getfield 605	android/hardware/Camera$Size:height	I
    //   179: i2d
    //   180: ddiv
    //   181: aload_0
    //   182: getfield 232	com/tencent/qbardemo/MainActivity:screenWidth	I
    //   185: i2d
    //   186: aload_0
    //   187: getfield 237	com/tencent/qbardemo/MainActivity:screenHeight	I
    //   190: i2d
    //   191: ddiv
    //   192: dsub
    //   193: invokestatic 623	java/lang/Math:abs	(D)D
    //   196: dcmpl
    //   197: iflt +39 -> 236
    //   200: aload_0
    //   201: aload 5
    //   203: iload_2
    //   204: invokeinterface 597 2 0
    //   209: checkcast 599	android/hardware/Camera$Size
    //   212: getfield 602	android/hardware/Camera$Size:width	I
    //   215: putfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   218: aload_0
    //   219: aload 5
    //   221: iload_2
    //   222: invokeinterface 597 2 0
    //   227: checkcast 599	android/hardware/Camera$Size
    //   230: getfield 605	android/hardware/Camera$Size:height	I
    //   233: putfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   236: iload_2
    //   237: iconst_1
    //   238: iadd
    //   239: istore_2
    //   240: goto -127 -> 113
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   248: new 127	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 625
    //   258: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   265: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 614	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   274: return
    //   275: aload_0
    //   276: getfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   279: aload_0
    //   280: getfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   283: aload_0
    //   284: getfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   287: invokevirtual 629	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   290: aload_0
    //   291: getfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   294: bipush 17
    //   296: invokevirtual 632	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   299: aload_0
    //   300: getfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   303: invokevirtual 635	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   306: iconst_1
    //   307: anewarray 175	java/lang/String
    //   310: dup
    //   311: iconst_0
    //   312: ldc_w 637
    //   315: aastore
    //   316: invokestatic 639	com/tencent/qbardemo/MainActivity:findSettableValue	(Ljava/util/Collection;[Ljava/lang/String;)Ljava/lang/String;
    //   319: astore 5
    //   321: aload 5
    //   323: ifnull +12 -> 335
    //   326: aload_0
    //   327: getfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   330: aload 5
    //   332: invokevirtual 642	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   335: iconst_2
    //   336: iconst_0
    //   337: iconst_0
    //   338: ldc_w 644
    //   341: ldc_w 646
    //   344: invokestatic 650	com/tencent/qbar/QbarNative:Init	(IIILjava/lang/String;Ljava/lang/String;)I
    //   347: istore_2
    //   348: iconst_1
    //   349: newarray int
    //   351: astore 5
    //   353: aload 5
    //   355: iconst_0
    //   356: iconst_2
    //   357: iastore
    //   358: aload 5
    //   360: aload 5
    //   362: arraylength
    //   363: invokestatic 654	com/tencent/qbar/QbarNative:SetReaders	([II)I
    //   366: istore_3
    //   367: invokestatic 657	com/tencent/qbar/QbarNative:GetVersion	()Ljava/lang/String;
    //   370: astore 5
    //   372: ldc_w 398
    //   375: new 127	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 659
    //   385: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload_2
    //   389: invokevirtual 610	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: ldc_w 661
    //   395: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload_3
    //   399: invokevirtual 610	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 664	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   408: pop
    //   409: ldc_w 398
    //   412: new 127	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 666
    //   422: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 5
    //   427: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 664	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   436: pop
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   442: bipush 90
    //   444: invokevirtual 668	com/tencent/qbardemo/MainActivity:setDisplayOrientation	(Landroid/hardware/Camera;I)V
    //   447: aload_0
    //   448: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   451: aload_0
    //   452: getfield 585	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   455: invokevirtual 672	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   458: aload_0
    //   459: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   462: aload_0
    //   463: invokevirtual 676	android/hardware/Camera:setOneShotPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   466: aload_0
    //   467: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   470: aload_1
    //   471: invokevirtual 680	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   474: aload_0
    //   475: getfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   478: i2d
    //   479: ldc2_w 29
    //   482: dmul
    //   483: d2i
    //   484: istore_2
    //   485: aload_0
    //   486: iload_2
    //   487: iload_2
    //   488: imul
    //   489: iconst_3
    //   490: imul
    //   491: iconst_2
    //   492: idiv
    //   493: newarray byte
    //   495: putfield 682	com/tencent/qbardemo/MainActivity:outData	[B
    //   498: aload_0
    //   499: iload_2
    //   500: iload_2
    //   501: imul
    //   502: newarray byte
    //   504: putfield 684	com/tencent/qbardemo/MainActivity:inData	[B
    //   507: aload_0
    //   508: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   511: invokevirtual 687	android/hardware/Camera:startPreview	()V
    //   514: aload_0
    //   515: invokevirtual 689	com/tencent/qbardemo/MainActivity:focusStart	()V
    //   518: aload_0
    //   519: invokevirtual 691	com/tencent/qbardemo/MainActivity:detectStart	()V
    //   522: return
    //   523: astore_1
    //   524: aload_1
    //   525: invokevirtual 692	java/lang/ExceptionInInitializerError:printStackTrace	()V
    //   528: new 127	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 694
    //   538: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_1
    //   542: invokevirtual 695	java/lang/ExceptionInInitializerError:toString	()Ljava/lang/String;
    //   545: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   554: aload_0
    //   555: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   558: goto -84 -> 474
    //   561: astore_1
    //   562: aload_1
    //   563: invokevirtual 696	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   566: new 127	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 694
    //   576: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_1
    //   580: invokevirtual 697	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   583: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   592: aload_0
    //   593: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   596: goto -122 -> 474
    //   599: astore_1
    //   600: aload_1
    //   601: invokevirtual 698	java/io/IOException:printStackTrace	()V
    //   604: new 127	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 700
    //   614: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_1
    //   618: invokevirtual 701	java/io/IOException:toString	()Ljava/lang/String;
    //   621: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   630: aload_0
    //   631: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   634: goto -160 -> 474
    //   637: astore_1
    //   638: aload_1
    //   639: invokevirtual 311	java/lang/RuntimeException:printStackTrace	()V
    //   642: new 127	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 700
    //   652: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_1
    //   656: invokevirtual 314	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   659: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   668: aload_0
    //   669: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   672: goto -198 -> 474
    //   675: astore_1
    //   676: aload_1
    //   677: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   680: new 127	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   687: ldc_w 700
    //   690: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_1
    //   694: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   697: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   706: aload_0
    //   707: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   710: goto -236 -> 474
    //   713: astore_1
    //   714: aload_1
    //   715: invokevirtual 311	java/lang/RuntimeException:printStackTrace	()V
    //   718: new 127	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 703
    //   728: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_1
    //   732: invokevirtual 314	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   735: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   744: aload_0
    //   745: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   748: goto -234 -> 514
    //   751: astore_1
    //   752: aload_1
    //   753: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   756: new 127	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   763: ldc_w 703
    //   766: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_1
    //   770: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   773: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 317	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   782: aload_0
    //   783: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   786: goto -272 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	this	MainActivity
    //   0	789	1	paramSurfaceHolder	SurfaceHolder
    //   0	789	2	paramInt1	int
    //   0	789	3	paramInt2	int
    //   0	789	4	paramInt3	int
    //   36	390	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	243	java/lang/Exception
    //   335	353	523	java/lang/ExceptionInInitializerError
    //   358	474	523	java/lang/ExceptionInInitializerError
    //   335	353	561	java/lang/UnsatisfiedLinkError
    //   358	474	561	java/lang/UnsatisfiedLinkError
    //   335	353	599	java/io/IOException
    //   358	474	599	java/io/IOException
    //   335	353	637	java/lang/RuntimeException
    //   358	474	637	java/lang/RuntimeException
    //   335	353	675	java/lang/Exception
    //   358	474	675	java/lang/Exception
    //   507	514	713	java/lang/RuntimeException
    //   507	514	751	java/lang/Exception
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      if (this.camera == null) {
        this.camera = Camera.open();
      }
      this.camera.setPreviewDisplay(paramSurfaceHolder);
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      e.c("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      e.d("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      finishActivity();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      e.c("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      e.d("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      finishActivity();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      e.c("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      e.d("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      finishActivity();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.i("TAG", "surfaceDestroyed");
    if (this.focusTimer != null)
    {
      this.focusTimer.cancel();
      this.focusTimer = null;
    }
    if (this.focusTask != null)
    {
      this.focusTask.cancel();
      this.focusTask = null;
    }
    if (this.detectTimer != null)
    {
      this.detectTimer.cancel();
      this.detectTimer = null;
    }
    if (this.detectTask != null)
    {
      this.detectTask.cancel();
      this.detectTask = null;
    }
    if (this.camera != null)
    {
      this.camera.setPreviewCallback(null);
      this.camera.stopPreview();
      this.camera.release();
    }
    this.camera = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbardemo.MainActivity
 * JD-Core Version:    0.7.0.1
 */