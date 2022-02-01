package com.tencent.qbardemo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qbar.QbarNative;
import com.tencent.token.aac;
import com.tencent.token.aad;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.qy;
import com.tencent.token.rt;
import com.tencent.token.rv;
import com.tencent.token.ry;
import com.tencent.token.sa;
import com.tencent.token.sa.28;
import com.tencent.token.ui.GetBarcodeVerifyMsgActivity;
import com.tencent.token.ui.GetOtherBarcodeActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.ScanLoginAccountListActivity;
import com.tencent.token.xa;
import gameloginsdk.GameLogin;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import oicq.wlogin_sdk.request.WtloginHelper;

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
  public Handler uiHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int j = paramAnonymousMessage.what;
      if (j != 4)
      {
        int i = 0;
        if (j != 3053)
        {
          switch (j)
          {
          default: 
            return;
          case 2: 
            MainActivity.this.doFocus();
            return;
          }
          switch (paramAnonymousMessage.arg1)
          {
          default: 
            return;
          case 2: 
            MainActivity.this.showResult(paramAnonymousMessage.getData());
            return;
          case 1: 
            MainActivity.access$102(MainActivity.this, 0);
            MainActivity.this.view.setDrawLineImage(false);
            MainActivity.this.view.invalidate();
            MainActivity.this.showResult(paramAnonymousMessage.getData());
            return;
          }
          MainActivity.access$002(MainActivity.this, false);
          if (MainActivity.this.detectCounter > 0)
          {
            MainActivity.this.view.getPen().setColor(-65536);
            MainActivity.this.view.invalidate();
          }
          else
          {
            MainActivity.access$108(MainActivity.this);
            MainActivity.this.view.getPen().setColor(-256);
            MainActivity.this.view.invalidate();
          }
          if (MainActivity.this.camera == null) {
            return;
          }
          MainActivity.this.camera.setOneShotPreviewCallback(MainActivity.this.cb);
          return;
        }
        String str = "";
        if (paramAnonymousMessage.arg1 == 0)
        {
          i = paramAnonymousMessage.arg2;
          str = (String)paramAnonymousMessage.obj;
        }
        paramAnonymousMessage = new Intent(MainActivity.this, GetOtherBarcodeActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("barcode_result", MainActivity.this.mBarcodeResult);
        localBundle.putInt("url_id", i);
        localBundle.putString("url_txt", str);
        paramAnonymousMessage.putExtra("com.tencent.input_param", localBundle);
        MainActivity.this.startActivityForResult(paramAnonymousMessage, 1);
        rt.a().a(System.currentTimeMillis(), 10);
        MainActivity.this.finish();
        return;
      }
    }
  };
  private RectView view;
  
  private static String findSettableValue(Collection<String> paramCollection, String... paramVarArgs)
  {
    if (paramCollection != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (paramCollection.contains(str))
        {
          paramCollection = str;
          break label45;
        }
        i += 1;
      }
    }
    paramCollection = null;
    label45:
    xa.b("resolution Settable value: ".concat(String.valueOf(paramCollection)));
    return paramCollection;
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
      StringBuilder localStringBuilder = new StringBuilder("scan string: ");
      i += 1;
      localStringBuilder.append(paramString.substring(i));
      xa.a(localStringBuilder.toString());
      return paramString.substring(i);
    }
    return null;
  }
  
  public void createUI()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("test");
    this.path = ((StringBuilder)localObject).toString();
    new File(this.path).mkdir();
    localObject = getResources().getDisplayMetrics();
    this.screenWidth = ((DisplayMetrics)localObject).heightPixels;
    this.screenHeight = ((DisplayMetrics)localObject).widthPixels;
    this.surfaceView = ((SurfaceView)findViewById(2131165816));
    this.mTitleText = ((TextView)findViewById(2131165298));
    localObject = (RelativeLayout)findViewById(2131165935);
    this.view = new RectView(this, this.screenHeight, this.screenWidth);
    this.view.invalidate();
    ((RelativeLayout)localObject).addView(this.view);
    if (this.mSource == 0)
    {
      this.mTitleText.setText(getResources().getString(2131492993));
      return;
    }
    this.mTitleText.setText(getResources().getString(2131493540));
  }
  
  public void detectStart()
  {
    this.detectTimer = new Timer(false);
    this.detectTask = new TimerTask()
    {
      public void run()
      {
        if (!MainActivity.this.flag)
        {
          MainActivity.access$002(MainActivity.this, true);
          ProcessThread localProcessThread = new ProcessThread(MainActivity.this.uiHandler, MainActivity.this.previewData, MainActivity.this.outData, MainActivity.this.inData, MainActivity.this.preWidth, MainActivity.this.preHeight, MainActivity.this.path);
          localProcessThread.setPriority(10);
          localProcessThread.start();
        }
      }
    };
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
    Camera localCamera = this.camera;
    if (localCamera == null) {
      return;
    }
    try
    {
      localCamera.autoFocus(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localStringBuilder = new StringBuilder("camera auto focus ");
      localStringBuilder.append(localException.toString());
      xa.c(localStringBuilder.toString());
      finishActivity();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("camera auto focus ");
      localStringBuilder.append(localRuntimeException.toString());
      xa.c(localStringBuilder.toString());
      finishActivity();
    }
  }
  
  public void focusStart()
  {
    this.focusTimer = new Timer(false);
    this.focusTask = new TimerTask()
    {
      public void run()
      {
        Message localMessage = new Message();
        localMessage.what = 2;
        MainActivity.this.uiHandler.sendMessage(localMessage);
      }
    };
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
    aad.a(true);
    requestWindowFeature(1);
    if (getIntent() != null) {
      this.mSource = getIntent().getIntExtra("source_from", 0);
    }
    setContentView(2131296297);
    createUI();
    this.cb = this;
    this.holder = this.surfaceView.getHolder();
    this.holder.addCallback(this);
    this.holder.setType(3);
    findViewById(2131165296).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = MainActivity.this;
        aac.b(paramAnonymousView, paramAnonymousView.getString(2131493429));
      }
    });
    findViewById(2131165291).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.finish();
      }
    });
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
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
      new StringBuilder("setDisplayOrientation: ").append(paramCamera.getMessage());
    }
  }
  
  public void showResult(Bundle paramBundle)
  {
    this.mBarcodeResult = paramBundle.getString("dataInfo");
    paramBundle = paramBundle.getString("dataInfo");
    Object localObject1 = ry.a(getApplicationContext());
    Object localObject2;
    if (((ry)localObject1).a.IsWtLoginUrl(paramBundle))
    {
      ((ry)localObject1).d = paramBundle;
      localObject2 = new Intent(this, ScanLoginAccountListActivity.class);
      int i = paramBundle.indexOf("?k=") + 3;
      paramBundle = paramBundle.substring(i, i + 32);
      ((Intent)localObject2).putExtra("scancode", aac.a(paramBundle.getBytes(), paramBundle.length()));
      startActivityForResult((Intent)localObject2, 1);
    }
    try
    {
      paramBundle = rv.a(RqdApplication.n());
      long l = ((ry)localObject1).a();
      if (rv.h)
      {
        paramBundle.b = false;
        paramBundle.c = false;
        xa.a("game login get flow type appid=".concat(String.valueOf(l)));
        paramBundle.a.sendGetFlowType(l);
      }
      label157:
      finish();
      return;
      localObject1 = parseBarcode(paramBundle);
      if (localObject1 == null)
      {
        localObject1 = (ImageView)findViewById(2131165827);
        ((ImageView)localObject1).setImageResource(2131099938);
        ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
        localObject1 = sa.a();
        localObject2 = this.uiHandler;
        qy.a().b(paramBundle, new sa.28((sa)localObject1, (Handler)localObject2));
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
    catch (Exception|Error paramBundle)
    {
      break label157;
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.camera;
    if (localObject == null) {
      return;
    }
    try
    {
      this.parameters = ((Camera)localObject).getParameters();
      localObject = this.parameters.getSupportedPreviewSizes();
      this.preWidth = ((Camera.Size)((List)localObject).get(0)).width;
      this.preHeight = ((Camera.Size)((List)localObject).get(0)).height;
      StringBuilder localStringBuilder = new StringBuilder("camera width=");
      localStringBuilder.append(this.preWidth);
      localStringBuilder.append(", height=");
      localStringBuilder.append(paramInt3);
      xa.c(localStringBuilder.toString());
      paramInt1 = 1;
      while (paramInt1 < ((List)localObject).size())
      {
        d1 = this.preWidth;
        double d2 = this.preHeight;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = this.screenWidth;
        double d3 = this.screenHeight;
        Double.isNaN(d2);
        Double.isNaN(d3);
        d1 = Math.abs(d1 - d2 / d3);
        d2 = ((Camera.Size)((List)localObject).get(paramInt1)).width;
        d3 = ((Camera.Size)((List)localObject).get(paramInt1)).height;
        Double.isNaN(d2);
        Double.isNaN(d3);
        d2 /= d3;
        d3 = this.screenWidth;
        double d4 = this.screenHeight;
        Double.isNaN(d3);
        Double.isNaN(d4);
        d2 = Math.abs(d2 - d3 / d4);
        if (d1 >= d2)
        {
          this.preWidth = ((Camera.Size)((List)localObject).get(paramInt1)).width;
          this.preHeight = ((Camera.Size)((List)localObject).get(paramInt1)).height;
          if ((d1 == d2) && (this.preWidth < ((Camera.Size)((List)localObject).get(paramInt1)).width))
          {
            this.preWidth = ((Camera.Size)((List)localObject).get(paramInt1)).width;
            this.preHeight = ((Camera.Size)((List)localObject).get(paramInt1)).height;
          }
        }
        paramInt1 += 1;
      }
      this.parameters.setPreviewSize(this.preWidth, this.preHeight);
      this.parameters.setPreviewFormat(17);
      localObject = findSettableValue(this.parameters.getSupportedFocusModes(), new String[] { "auto" });
      if (localObject != null) {
        this.parameters.setFocusMode((String)localObject);
      }
      try
      {
        paramInt1 = QbarNative.Init(2, 0, 0, "ANY", "UTF-8");
        paramInt2 = QbarNative.SetReaders(new int[] { 2 }, 1);
        QbarNative.GetVersion();
        localObject = new StringBuilder("init_result1:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",init_result2:");
        ((StringBuilder)localObject).append(paramInt2);
        setDisplayOrientation(this.camera, 90);
        this.camera.setParameters(this.parameters);
        this.camera.setOneShotPreviewCallback(this);
        this.camera.setPreviewDisplay(paramSurfaceHolder);
      }
      catch (Exception paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("camera set parameter ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      catch (RuntimeException paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("camera set parameter ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      catch (IOException paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("camera set parameter ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      catch (UnsatisfiedLinkError paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("qbar init ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      catch (ExceptionInInitializerError paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("qbar init ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      double d1 = this.preHeight;
      Double.isNaN(d1);
      paramInt1 = (int)(d1 * 0.6D);
      paramInt1 *= paramInt1;
      this.outData = new byte[paramInt1 * 3 / 2];
      this.inData = new byte[paramInt1];
      try
      {
        this.camera.startPreview();
      }
      catch (Exception paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("camera start preview ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      catch (RuntimeException paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        localObject = new StringBuilder("camera start preview ");
        ((StringBuilder)localObject).append(paramSurfaceHolder.toString());
        xa.c(((StringBuilder)localObject).toString());
        finishActivity();
      }
      focusStart();
      detectStart();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      paramSurfaceHolder = new StringBuilder("Camera getParameters failed");
      paramSurfaceHolder.append(this.camera);
      xa.c(paramSurfaceHolder.toString());
    }
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
    catch (Exception paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      localStringBuilder = new StringBuilder("Unexpected error initializing camera");
      localStringBuilder.append(paramSurfaceHolder.toString());
      xa.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("Unexpected error initializing camera");
      localStringBuilder.append(paramSurfaceHolder.toString());
      xa.c(localStringBuilder.toString());
      finishActivity();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      localStringBuilder = new StringBuilder("Unexpected error initializing camera");
      localStringBuilder.append(paramSurfaceHolder.toString());
      xa.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("Unexpected error initializing camera");
      localStringBuilder.append(paramSurfaceHolder.toString());
      xa.c(localStringBuilder.toString());
      finishActivity();
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      this.camera = null;
      paramSurfaceHolder.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("Unexpected error initializing camera");
      localStringBuilder.append(paramSurfaceHolder.toString());
      xa.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("Unexpected error initializing camera");
      localStringBuilder.append(paramSurfaceHolder.toString());
      xa.c(localStringBuilder.toString());
      finishActivity();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.focusTimer;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.cancel();
      this.focusTimer = null;
    }
    paramSurfaceHolder = this.focusTask;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.cancel();
      this.focusTask = null;
    }
    paramSurfaceHolder = this.detectTimer;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.cancel();
      this.detectTimer = null;
    }
    paramSurfaceHolder = this.detectTask;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.cancel();
      this.detectTask = null;
    }
    paramSurfaceHolder = this.camera;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.setPreviewCallback(null);
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