import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qg.sdk.QGJNIBridge;
import com.tencent.qg.sdk.QGRenderer.QGEventListener;
import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.controller.VipQGThreeController.1;
import cooperation.vip.ar.controller.VipQGThreeController.2;
import cooperation.vip.ar.controller.VipQGThreeController.3;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class awlb
  extends awla
  implements awkt, QGRenderer.QGEventListener
{
  private boolean YX = true;
  private asge.a jdField_a_of_type_Asge$a = new awlc(this);
  private awlb.a jdField_a_of_type_Awlb$a;
  private awle jdField_a_of_type_Awle;
  private VipQGGLSurfaceView jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView;
  private adcv b;
  private volatile boolean dqO;
  private volatile boolean dqP;
  private volatile int eBy = 1;
  private ViewGroup eY;
  private Runnable iE = new VipQGThreeController.3(this);
  
  public awlb(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    if (this.as != null) {
      this.eY = ((ViewGroup)this.as.findViewById(2131370261));
    }
    eEl();
  }
  
  private boolean aNe()
  {
    if ((this.mContext == null) || (this.eY == null) || (this.jdField_a_of_type_Awle == null) || (!asgf.isSoLoaded.get()))
    {
      QZLog.i("VipARQGThreeController", 1, "checkInValid mVipQGViewConfig = " + this.jdField_a_of_type_Awle + " so status = " + asgf.isSoLoaded.get());
      return true;
    }
    return false;
  }
  
  private String b(float[] paramArrayOfFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      localStringBuilder.append(paramArrayOfFloat[i]);
      if (i != paramArrayOfFloat.length - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void eEl()
  {
    ThreadManager.executeOnFileThread(new VipQGThreeController.1(this));
  }
  
  public void a(awle paramawle)
  {
    this.jdField_a_of_type_Awle = paramawle;
    if ((this.jdField_a_of_type_Awle != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awle.resUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipARQGThreeController", 2, " setVipQGViewConfig config = " + paramawle.toString());
      }
      localObject = new aeoq.a();
      ((aeoq.a)localObject).resUrl = paramawle.resUrl;
      ((aeoq.a)localObject).md5 = paramawle.resMD5;
      awll.a().a((aeoq.a)localObject, this);
      return;
    }
    Object localObject = new StringBuilder().append("setVipQGViewConfig config = null or resUrl = null , config == null : ");
    if (paramawle == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("VipARQGThreeController", 1, bool);
      return;
    }
  }
  
  public void a(String paramString, float[] paramArrayOfFloat)
  {
    if ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null) || (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge() == null) || (paramArrayOfFloat == null))
    {
      QZLog.e("VipARQGThreeController", 1, new Object[] { "dispatchQGJSEvent float[] error" });
      return;
    }
    this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge().dispatchJSEvent(paramString, paramArrayOfFloat);
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    if ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null) || (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge() == null))
    {
      QZLog.e("VipARQGThreeController", 1, new Object[] { "dispatchQGJSEvent error" });
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("modelMatrix", b(paramArrayOfFloat1));
      localJSONObject.put("viewMatrix", b(paramArrayOfFloat2));
      localJSONObject.put("projectionMatrix", b(paramArrayOfFloat3));
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge().dispatchJSEvent("onRenderFrame", localJSONObject);
      return;
    }
    catch (JSONException paramArrayOfFloat1)
    {
      for (;;)
      {
        paramArrayOfFloat1.printStackTrace();
      }
    }
  }
  
  public void abS(String paramString)
  {
    if (this.jdField_a_of_type_Awle != null) {
      this.jdField_a_of_type_Awle.cRd = paramString;
    }
    QZLog.i("VipARQGThreeController", 1, "qg resources load success path = " + paramString + " soStatus = " + asgf.isSoLoaded.get());
  }
  
  public void abT(String paramString)
  {
    QZLog.i("VipARQGThreeController", 1, "qg resources load fail error = " + paramString + " soStatus = " + asgf.isSoLoaded.get());
    if (this.jdField_a_of_type_Awle != null) {
      this.jdField_a_of_type_Awle.cRd = "";
    }
  }
  
  public void eEm()
  {
    if (aNe()) {
      return;
    }
    ThreadManager.getUIHandler().post(new VipQGThreeController.2(this));
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null) && (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getModuleEngine() != null))
    {
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getModuleEngine().unRegisterJsModule(this.jdField_a_of_type_Awlb$a);
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.onDestory();
    }
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null) {
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.onPause();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null) {
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.onResume();
    }
  }
  
  public void onCanvasCreated()
  {
    QZLog.i("VipARQGThreeController", 1, "qg view onCanvasCreated");
    this.dqP = true;
  }
  
  public void onDrawFrame()
  {
    this.dqO = true;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    switch (this.eBy)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (!asgf.isSoLoaded.get());
              QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status SO_LOAD success next status CREATE_QGVIEW" });
              this.eBy = 2;
              return;
            } while (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null);
            eEm();
            this.eBy = 5;
            return;
          } while ((this.jdField_a_of_type_Awle == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Awle.cRd)) || (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null));
          QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status JS_MODEL_LOAD success next status DRAW_FRAME mIsQGReady = " + this.dqP + " mIsQGStartDraw = " + this.dqO });
        } while (!this.dqP);
        this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.queueEvent(this.iE);
      } while (!this.jdField_a_of_type_Awle.dqQ);
      this.eBy = 4;
      return;
    } while ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null) || (!this.dqO) || (this.b == null) || (paramGL10 == null));
    int i = this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getCanvasTexture("offScreen");
    if (i != 0)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      this.b.drawTexture(i, null, null);
      if (this.YX)
      {
        awlg.jF("ar_qg_show", "1");
        this.YX = false;
      }
    }
    this.eBy = 4;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.b = new adcv();
    this.b.init();
  }
  
  public class a
    extends BaseJsModule
  {
    public a() {}
    
    public String getModuleName()
    {
      return "VipQGModel";
    }
    
    public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
    {
      if ("notifyJsInvokeFinish".equalsIgnoreCase(paramString))
      {
        QLog.i("VipQGModel", 1, "handleJsRequest: notifyJsInvokeFinish");
        awlb.this.a("getDeviceSize", new float[] { aqnm.getScreenWidth(), aqnm.getScreenHeight() });
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlb
 * JD-Core Version:    0.7.0.1
 */