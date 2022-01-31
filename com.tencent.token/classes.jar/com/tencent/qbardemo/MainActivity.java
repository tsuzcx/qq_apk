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
import com.tencent.token.cj;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.GetBarcodeVerifyMsgActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.ScanLoginAccountListActivity;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
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
      h.b("resolution Settable value: " + paramCollection);
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
      h.a("scan string: " + paramString.substring(i + 1));
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
    this.surfaceView = ((SurfaceView)findViewById(2131558689));
    this.mTitleText = ((TextView)findViewById(2131558692));
    localObject = (RelativeLayout)findViewById(2131558675);
    this.view = new RectView(this, this.screenHeight, this.screenWidth);
    this.view.invalidate();
    ((RelativeLayout)localObject).addView(this.view);
    if (this.mSource == 0)
    {
      this.mTitleText.setText(getResources().getString(2131230850));
      return;
    }
    this.mTitleText.setText(getResources().getString(2131231396));
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
      h.d("camera auto focus " + localRuntimeException.toString());
      finishActivity();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      h.d("camera auto focus " + localException.toString());
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
    x.a(true);
    requestWindowFeature(1);
    if (getIntent() != null) {
      this.mSource = getIntent().getIntExtra("source_from", 0);
    }
    setContentView(2130968617);
    createUI();
    this.cb = this;
    this.holder = this.surfaceView.getHolder();
    this.holder.addCallback(this);
    this.holder.setType(3);
    findViewById(2131558695).setOnClickListener(new MainActivity.2(this));
    findViewById(2131558693).setOnClickListener(new MainActivity.3(this));
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
    Object localObject1 = cp.a(getApplicationContext());
    Object localObject2;
    if (((cp)localObject1).a(paramBundle))
    {
      ((cp)localObject1).b(paramBundle);
      localObject2 = new Intent(this, ScanLoginAccountListActivity.class);
      int i = paramBundle.indexOf("?k=") + 3;
      paramBundle = paramBundle.substring(i, i + 32);
      ((Intent)localObject2).putExtra("scancode", w.a(paramBundle.getBytes(), paramBundle.length()));
      startActivityForResult((Intent)localObject2, 1);
    }
    try
    {
      cj.a(RqdApplication.l()).a(((cp)localObject1).a());
      label113:
      finish();
      return;
      localObject1 = parseBarcode(paramBundle);
      if (localObject1 == null)
      {
        localObject1 = (ImageView)findViewById(2131558690);
        ((ImageView)localObject1).setImageResource(2130837791);
        ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
        cw.a().a(paramBundle, this.uiHandler);
        return;
      }
      paramBundle = new Intent(this, GetBarcodeVerifyMsgActivity.class);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("barcode_result", (String)localObject1);
      paramBundle.putExtra("com.tencent.input_param", (Bundle)localObject2);
      startActivityForResult(paramBundle, 1);
      this.detectCounter = 0;
      this.view.setDrawLineImage(true);
      this.view.invalidate();
      return;
    }
    catch (Error paramBundle)
    {
      break label113;
    }
    catch (Exception paramBundle)
    {
      break label113;
    }
  }
  
  /* Error */
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 398
    //   3: ldc_w 581
    //   6: invokestatic 406	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   23: invokevirtual 585	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   26: putfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   29: aload_0
    //   30: getfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   33: invokevirtual 593	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   36: astore 9
    //   38: aload_0
    //   39: aload 9
    //   41: iconst_0
    //   42: invokeinterface 599 2 0
    //   47: checkcast 601	android/hardware/Camera$Size
    //   50: getfield 604	android/hardware/Camera$Size:width	I
    //   53: putfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   56: aload_0
    //   57: aload 9
    //   59: iconst_0
    //   60: invokeinterface 599 2 0
    //   65: checkcast 601	android/hardware/Camera$Size
    //   68: getfield 607	android/hardware/Camera$Size:height	I
    //   71: putfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   74: new 127	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 609
    //   84: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   91: invokevirtual 612	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 614
    //   97: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 612	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 617	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore_2
    //   113: iload_2
    //   114: aload 9
    //   116: invokeinterface 620 1 0
    //   121: if_icmpge +227 -> 348
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
    //   147: invokestatic 626	java/lang/Math:abs	(D)D
    //   150: dstore 5
    //   152: aload 9
    //   154: iload_2
    //   155: invokeinterface 599 2 0
    //   160: checkcast 601	android/hardware/Camera$Size
    //   163: getfield 604	android/hardware/Camera$Size:width	I
    //   166: i2d
    //   167: aload 9
    //   169: iload_2
    //   170: invokeinterface 599 2 0
    //   175: checkcast 601	android/hardware/Camera$Size
    //   178: getfield 607	android/hardware/Camera$Size:height	I
    //   181: i2d
    //   182: ddiv
    //   183: aload_0
    //   184: getfield 232	com/tencent/qbardemo/MainActivity:screenWidth	I
    //   187: i2d
    //   188: aload_0
    //   189: getfield 237	com/tencent/qbardemo/MainActivity:screenHeight	I
    //   192: i2d
    //   193: ddiv
    //   194: dsub
    //   195: invokestatic 626	java/lang/Math:abs	(D)D
    //   198: dstore 7
    //   200: dload 5
    //   202: dload 7
    //   204: dcmpl
    //   205: iflt +104 -> 309
    //   208: aload_0
    //   209: aload 9
    //   211: iload_2
    //   212: invokeinterface 599 2 0
    //   217: checkcast 601	android/hardware/Camera$Size
    //   220: getfield 604	android/hardware/Camera$Size:width	I
    //   223: putfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   226: aload_0
    //   227: aload 9
    //   229: iload_2
    //   230: invokeinterface 599 2 0
    //   235: checkcast 601	android/hardware/Camera$Size
    //   238: getfield 607	android/hardware/Camera$Size:height	I
    //   241: putfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   244: dload 5
    //   246: dload 7
    //   248: dcmpl
    //   249: ifne +60 -> 309
    //   252: aload_0
    //   253: getfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   256: aload 9
    //   258: iload_2
    //   259: invokeinterface 599 2 0
    //   264: checkcast 601	android/hardware/Camera$Size
    //   267: getfield 604	android/hardware/Camera$Size:width	I
    //   270: if_icmpge +39 -> 309
    //   273: aload_0
    //   274: aload 9
    //   276: iload_2
    //   277: invokeinterface 599 2 0
    //   282: checkcast 601	android/hardware/Camera$Size
    //   285: getfield 604	android/hardware/Camera$Size:width	I
    //   288: putfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   291: aload_0
    //   292: aload 9
    //   294: iload_2
    //   295: invokeinterface 599 2 0
    //   300: checkcast 601	android/hardware/Camera$Size
    //   303: getfield 607	android/hardware/Camera$Size:height	I
    //   306: putfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   309: iload_2
    //   310: iconst_1
    //   311: iadd
    //   312: istore_2
    //   313: goto -200 -> 113
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   321: new 127	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 628
    //   331: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   338: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 617	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   347: return
    //   348: aload_0
    //   349: getfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   352: aload_0
    //   353: getfield 114	com/tencent/qbardemo/MainActivity:preWidth	I
    //   356: aload_0
    //   357: getfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   360: invokevirtual 632	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   363: aload_0
    //   364: getfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   367: bipush 17
    //   369: invokevirtual 635	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   372: aload_0
    //   373: getfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   376: invokevirtual 638	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   379: iconst_1
    //   380: anewarray 175	java/lang/String
    //   383: dup
    //   384: iconst_0
    //   385: ldc_w 640
    //   388: aastore
    //   389: invokestatic 642	com/tencent/qbardemo/MainActivity:findSettableValue	(Ljava/util/Collection;[Ljava/lang/String;)Ljava/lang/String;
    //   392: astore 9
    //   394: aload 9
    //   396: ifnull +12 -> 408
    //   399: aload_0
    //   400: getfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   403: aload 9
    //   405: invokevirtual 645	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   408: iconst_2
    //   409: iconst_0
    //   410: iconst_0
    //   411: ldc_w 647
    //   414: ldc_w 649
    //   417: invokestatic 653	com/tencent/qbar/QbarNative:Init	(IIILjava/lang/String;Ljava/lang/String;)I
    //   420: istore_2
    //   421: iconst_1
    //   422: newarray int
    //   424: astore 9
    //   426: aload 9
    //   428: iconst_0
    //   429: iconst_2
    //   430: iastore
    //   431: aload 9
    //   433: aload 9
    //   435: arraylength
    //   436: invokestatic 657	com/tencent/qbar/QbarNative:SetReaders	([II)I
    //   439: istore_3
    //   440: invokestatic 660	com/tencent/qbar/QbarNative:GetVersion	()Ljava/lang/String;
    //   443: astore 9
    //   445: ldc_w 398
    //   448: new 127	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 662
    //   458: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: iload_2
    //   462: invokevirtual 612	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: ldc_w 664
    //   468: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: iload_3
    //   472: invokevirtual 612	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   475: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 667	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   481: pop
    //   482: ldc_w 398
    //   485: new 127	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 669
    //   495: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload 9
    //   500: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 667	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   509: pop
    //   510: aload_0
    //   511: aload_0
    //   512: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   515: bipush 90
    //   517: invokevirtual 671	com/tencent/qbardemo/MainActivity:setDisplayOrientation	(Landroid/hardware/Camera;I)V
    //   520: aload_0
    //   521: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   524: aload_0
    //   525: getfield 587	com/tencent/qbardemo/MainActivity:parameters	Landroid/hardware/Camera$Parameters;
    //   528: invokevirtual 675	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   531: aload_0
    //   532: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   535: aload_0
    //   536: invokevirtual 679	android/hardware/Camera:setOneShotPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   539: aload_0
    //   540: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   543: aload_1
    //   544: invokevirtual 683	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   547: aload_0
    //   548: getfield 117	com/tencent/qbardemo/MainActivity:preHeight	I
    //   551: i2d
    //   552: ldc2_w 29
    //   555: dmul
    //   556: d2i
    //   557: istore_2
    //   558: aload_0
    //   559: iload_2
    //   560: iload_2
    //   561: imul
    //   562: iconst_3
    //   563: imul
    //   564: iconst_2
    //   565: idiv
    //   566: newarray byte
    //   568: putfield 685	com/tencent/qbardemo/MainActivity:outData	[B
    //   571: aload_0
    //   572: iload_2
    //   573: iload_2
    //   574: imul
    //   575: newarray byte
    //   577: putfield 687	com/tencent/qbardemo/MainActivity:inData	[B
    //   580: aload_0
    //   581: getfield 103	com/tencent/qbardemo/MainActivity:camera	Landroid/hardware/Camera;
    //   584: invokevirtual 690	android/hardware/Camera:startPreview	()V
    //   587: aload_0
    //   588: invokevirtual 692	com/tencent/qbardemo/MainActivity:focusStart	()V
    //   591: aload_0
    //   592: invokevirtual 694	com/tencent/qbardemo/MainActivity:detectStart	()V
    //   595: return
    //   596: astore_1
    //   597: aload_1
    //   598: invokevirtual 695	java/lang/ExceptionInInitializerError:printStackTrace	()V
    //   601: new 127	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   608: ldc_w 697
    //   611: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_1
    //   615: invokevirtual 698	java/lang/ExceptionInInitializerError:toString	()Ljava/lang/String;
    //   618: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   627: aload_0
    //   628: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   631: goto -84 -> 547
    //   634: astore_1
    //   635: aload_1
    //   636: invokevirtual 699	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   639: new 127	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 697
    //   649: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_1
    //   653: invokevirtual 700	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   656: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   665: aload_0
    //   666: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   669: goto -122 -> 547
    //   672: astore_1
    //   673: aload_1
    //   674: invokevirtual 701	java/io/IOException:printStackTrace	()V
    //   677: new 127	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   684: ldc_w 703
    //   687: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload_1
    //   691: invokevirtual 704	java/io/IOException:toString	()Ljava/lang/String;
    //   694: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   703: aload_0
    //   704: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   707: goto -160 -> 547
    //   710: astore_1
    //   711: aload_1
    //   712: invokevirtual 311	java/lang/RuntimeException:printStackTrace	()V
    //   715: new 127	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   722: ldc_w 703
    //   725: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload_1
    //   729: invokevirtual 314	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   732: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   741: aload_0
    //   742: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   745: goto -198 -> 547
    //   748: astore_1
    //   749: aload_1
    //   750: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   753: new 127	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   760: ldc_w 703
    //   763: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload_1
    //   767: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   770: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   779: aload_0
    //   780: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   783: goto -236 -> 547
    //   786: astore_1
    //   787: aload_1
    //   788: invokevirtual 311	java/lang/RuntimeException:printStackTrace	()V
    //   791: new 127	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   798: ldc_w 706
    //   801: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_1
    //   805: invokevirtual 314	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   808: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   817: aload_0
    //   818: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   821: goto -234 -> 587
    //   824: astore_1
    //   825: aload_1
    //   826: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   829: new 127	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   836: ldc_w 706
    //   839: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload_1
    //   843: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   846: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 317	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   855: aload_0
    //   856: invokespecial 319	com/tencent/qbardemo/MainActivity:finishActivity	()V
    //   859: goto -272 -> 587
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	this	MainActivity
    //   0	862	1	paramSurfaceHolder	SurfaceHolder
    //   0	862	2	paramInt1	int
    //   0	862	3	paramInt2	int
    //   0	862	4	paramInt3	int
    //   150	95	5	d1	double
    //   198	49	7	d2	double
    //   36	463	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	316	java/lang/Exception
    //   408	426	596	java/lang/ExceptionInInitializerError
    //   431	547	596	java/lang/ExceptionInInitializerError
    //   408	426	634	java/lang/UnsatisfiedLinkError
    //   431	547	634	java/lang/UnsatisfiedLinkError
    //   408	426	672	java/io/IOException
    //   431	547	672	java/io/IOException
    //   408	426	710	java/lang/RuntimeException
    //   431	547	710	java/lang/RuntimeException
    //   408	426	748	java/lang/Exception
    //   431	547	748	java/lang/Exception
    //   580	587	786	java/lang/RuntimeException
    //   580	587	824	java/lang/Exception
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
      h.c("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      h.d("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      finishActivity();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      h.c("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      h.d("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      finishActivity();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      h.c("Unexpected error initializing camera" + paramSurfaceHolder.toString());
      h.d("Unexpected error initializing camera" + paramSurfaceHolder.toString());
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