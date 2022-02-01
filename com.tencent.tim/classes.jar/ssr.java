import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ssr
  extends WebViewPlugin
{
  private static ssr a;
  private static String aGj = "";
  private static boolean aMZ;
  private static boolean aNa;
  protected ssr.a a;
  private float[] aJ = new float[4];
  protected final byte aK = 3;
  protected SensorManager mSensorManager;
  
  public ssr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 2, "init");
    }
    jdField_a_of_type_Ssr = this;
  }
  
  public static final void bAH()
  {
    aNa = true;
    QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime startRender. isStartRender = " + aNa);
    if (!TextUtils.isEmpty(aGj)) {
      jdField_a_of_type_Ssr.callJs(aGj, new String[] { String.valueOf(true) });
    }
  }
  
  public void bAG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "stop motion");
    }
    if ((this.mSensorManager != null) && (this.jdField_a_of_type_Ssr$a != null))
    {
      this.mSensorManager.unregisterListener(this.jdField_a_of_type_Ssr$a);
      this.jdField_a_of_type_Ssr$a = null;
    }
    aMZ = false;
    aNa = false;
  }
  
  public final boolean ge(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "start motion");
    }
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)BaseApplication.getContext().getSystemService("sensor"));
    }
    Object localObject = this.mSensorManager;
    int i;
    if (addz.adJ())
    {
      i = 15;
      localObject = ((SensorManager)localObject).getSensorList(i);
      Sensor localSensor = this.mSensorManager.getDefaultSensor(4);
      if ((((List)localObject).size() <= 0) || (localSensor == null)) {
        break label211;
      }
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_Ssr$a != null) {
        bAG();
      }
      this.jdField_a_of_type_Ssr$a = new ssr.a((byte)3, paramString);
      if (!Build.MODEL.equalsIgnoreCase("Nexus 5X")) {
        break label194;
      }
      this.mSensorManager.registerListener(this.jdField_a_of_type_Ssr$a, (Sensor)localObject, 3);
      label141:
      if (QLog.isColorLevel()) {
        QLog.d("ARTransparentWebviewPlugin", 2, "support gyroscope");
      }
    }
    for (;;)
    {
      aMZ = true;
      QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime startMotion. isRenderReady = " + aMZ);
      return true;
      i = 11;
      break;
      label194:
      this.mSensorManager.registerListener(this.jdField_a_of_type_Ssr$a, (Sensor)localObject, 1);
      break label141;
      label211:
      callJs(paramString, new String[] { "false" });
      if (QLog.isColorLevel()) {
        QLog.d("ARTransparentWebviewPlugin", 2, "not support gyroscope");
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("sensor".equals(paramString2))
    {
      if ("startMotion".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          QLog.d("ARTransparentWebviewPlugin", 2, "handleJsRequest jsonobject is " + paramJsBridgeListener.toString());
          return ge(paramJsBridgeListener.optString("callback"));
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return false;
        }
      }
      if ("stopMotion".equals(paramString3))
      {
        bAG();
        return true;
      }
      if ("notifyRenderReady".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          QLog.d("ARTransparentWebviewPlugin", 2, "handleJsRequest jsonobject is " + paramJsBridgeListener.toString());
          tD(paramJsBridgeListener.optString("callback"));
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return false;
        }
      }
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void tD(String paramString)
  {
    aGj = paramString;
    QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime notifyRenderReady. callbackStartRender = " + aGj);
    paramString = this.mRuntime.getActivity();
    if ((paramString != null) && ((paramString instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)paramString).cSv();
    }
  }
  
  public class a
    implements SensorEventListener
  {
    protected byte aH;
    protected String mCallBack;
    
    public a(byte paramByte, String paramString)
    {
      this.aH = paramByte;
      this.mCallBack = paramString;
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      switch (this.aH)
      {
      }
      do
      {
        return;
        float[] arrayOfFloat = new float[4];
        if (Build.VERSION.SDK_INT >= 9)
        {
          SensorManager localSensorManager = ssr.this.mSensorManager;
          SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
          ssr.a(ssr.this)[0] = arrayOfFloat[1];
          ssr.a(ssr.this)[1] = arrayOfFloat[2];
          ssr.a(ssr.this)[2] = arrayOfFloat[3];
          ssr.a(ssr.this)[3] = arrayOfFloat[0];
        }
      } while ((!ssr.aMZ) || (!ssr.aNa));
      ssr.this.callJs(this.mCallBack, new String[] { String.valueOf(true), String.valueOf(ssr.a(ssr.this)[0]), String.valueOf(ssr.a(ssr.this)[1]), String.valueOf(ssr.a(ssr.this)[2]), String.valueOf(ssr.a(ssr.this)[3]) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssr
 * JD-Core Version:    0.7.0.1
 */