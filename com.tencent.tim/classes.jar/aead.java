import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFMoveCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.2;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.3;
import com.tencent.mobileqq.camera.CameraManagerImpl.FaceDetectionCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

@TargetApi(9)
public class aead
  implements aeac
{
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  private IOException jdField_a_of_type_JavaIoIOException;
  private Camera.Parameters b;
  private boolean bSB;
  private Camera mCamera;
  
  public static class a
    implements Camera.AutoFocusCallback
  {
    private final aeac.a jdField_a_of_type_Aeac$a;
    private final aeac.g jdField_a_of_type_Aeac$g;
    private final Handler mHandler;
    
    public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      this.mHandler.post(new CameraManagerImpl.AFCallbackForward.1(this, paramBoolean));
    }
  }
  
  @TargetApi(16)
  public static class b
    implements Camera.AutoFocusMoveCallback
  {
    private final aeac.b jdField_a_of_type_Aeac$b;
    private final aeac.g jdField_a_of_type_Aeac$g;
    private final Handler mHandler;
    
    public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
    {
      this.mHandler.post(new CameraManagerImpl.AFMoveCallbackForward.1(this, paramBoolean));
    }
  }
  
  public class c
    extends Handler
  {
    private String TAG;
    
    @TargetApi(16)
    private void a(Camera paramCamera, Object paramObject)
    {
      paramCamera.setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback)paramObject);
    }
    
    @TargetApi(14)
    private void bh(Object paramObject)
    {
      try
      {
        aead.a(this.a).setPreviewTexture((SurfaceTexture)paramObject);
        return;
      }
      catch (IOException paramObject)
      {
        QLog.e(this.TAG, 2, "Could not set preview texture", paramObject);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      for (;;)
      {
        try
        {
          switch (paramMessage.what)
          {
          case 1: 
            throw new RuntimeException("Invalid CameraProxy message=" + paramMessage.what);
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          localRuntimeException.printStackTrace();
          QLog.e(this.TAG, 2, localRuntimeException, new Object[0]);
          if ((paramMessage.what != 2) && (aead.a(this.a) != null))
          {
            QLog.e(this.TAG, 1, "mCamera != null, but RuntimeException");
            try
            {
              aead.a(this.a).release();
              aead.a(this.a, null);
              if (paramMessage.obj != null)
              {
                QLog.w(this.TAG, 1, "相机已经打开，运行时异常 " + paramMessage.what);
                if ((paramMessage.obj instanceof aeac.d))
                {
                  ((aeac.d)paramMessage.obj).LN(paramMessage.arg1);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                  }
                  aead.a(this.a, Camera.open(paramMessage.arg1));
                  if (aead.a(this.a) != null)
                  {
                    aead.a(this.a, true);
                    if (aead.a(this.a) == null)
                    {
                      aead.a(this.a, aead.a(this.a).getParameters());
                      if (QLog.isColorLevel()) {
                        QLog.d(this.TAG, 2, "[handleMessage] OPEN_CAMERA, parameter = " + aead.a(this.a));
                      }
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d(this.TAG, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + aead.a(this.a));
                    }
                  }
                  else
                  {
                    if (paramMessage.obj == null) {
                      continue;
                    }
                    ((aeac.d)paramMessage.obj).LN(paramMessage.arg1);
                    continue;
                  }
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] RELEASE");
                  }
                  if (aead.a(this.a) != null) {
                    aead.a(this.a).release();
                  }
                  aead.a(this.a, null);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] RECONNECT");
                  }
                  aead.a(this.a, null);
                  try
                  {
                    if (aead.a(this.a) == null) {
                      continue;
                    }
                    aead.a(this.a).reconnect();
                    return;
                  }
                  catch (IOException localIOException1)
                  {
                    aead.a(this.a, localIOException1);
                    return;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] UNLOCK");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).unlock();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] LOCK");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).lock();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_PREVIEW_TEXTURE_ASYNC");
                  }
                  bh(paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_PREVIEW_DISPLAY");
                  }
                  try
                  {
                    if (aead.a(this.a) == null) {
                      continue;
                    }
                    aead.a(this.a).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                    return;
                  }
                  catch (IOException localIOException2)
                  {
                    throw new RuntimeException(localIOException2);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] START_PREVIEW_ASYNC");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).startPreview();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] STOP_PREVIEW");
                  }
                  try
                  {
                    if (aead.a(this.a) == null) {
                      continue;
                    }
                    aead.a(this.a).stopPreview();
                    return;
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                    return;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_ONE_SHOT_PREVIEW_CALlBACK");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).addCallbackBuffer((byte[])paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] AUTO_FOCUS");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).cancelAutoFocus();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  a(aead.a(this.a), paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).setDisplayOrientation(paramMessage.arg1);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
                  return;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d(this.TAG, 2, "[handleMessage] SET_FACE_DETECTION_LISTENER");
                  return;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d(this.TAG, 2, "[handleMessage] START_FACE_DETECTION");
                  return;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d(this.TAG, 2, "[handleMessage] STOP_FACE_DETECTION");
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_ERROR_CALLBACK");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] SET_PARAMETERS");
                  }
                  if (aead.a(this.a) == null) {
                    continue;
                  }
                  aead.a(this.a, true);
                  aead.a(this.a).unflatten((String)paramMessage.obj);
                  aead.a(this.a).setParameters(aead.a(this.a));
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] GET_PARAMETERS");
                  }
                  if ((aead.a(this.a) == null) || (!aead.a(this.a))) {
                    continue;
                  }
                  aead.b(this.a, aead.a(this.a).getParameters());
                  aead.a(this.a, false);
                  return;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d(this.TAG, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "[handleMessage] REFRESH_PARAMETERS");
                  }
                  aead.a(this.a, true);
                  return;
                }
              }
            }
            catch (Exception localException2)
            {
              QLog.e(this.TAG, 2, "Fail to release the camera.");
              continue;
              if (!(paramMessage.obj instanceof aead.a)) {
                continue;
              }
              ((aead.a)paramMessage.obj).onAutoFocus(false, aead.a(this.a));
              return;
            }
            QLog.w(this.TAG, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
            throw localException1;
          }
          if (aead.a(this.a) == null) {
            if (paramMessage.what == 1)
            {
              QLog.e(this.TAG, 1, "mCamera == null Since Camera is disabled");
              if ((paramMessage.obj != null) && ((paramMessage.obj instanceof aeac.d))) {
                ((aeac.d)paramMessage.obj).LM(paramMessage.arg1);
              }
            }
            else
            {
              QLog.e(this.TAG, 1, "mCamera == null, Cannot handle message, 相机运行异常，请尝试重启机器");
              throw localException1;
            }
          }
        }
      }
    }
  }
  
  public static class d
    implements aeac.d
  {
    private final aeac.d a;
    private final Handler mHandler;
    
    public void LM(int paramInt)
    {
      this.mHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.1(this, paramInt));
    }
    
    public void LN(int paramInt)
    {
      this.mHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.2(this, paramInt));
    }
    
    public void a(aeac paramaeac)
    {
      this.mHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.3(this, paramaeac));
    }
  }
  
  @TargetApi(14)
  public static class e
    implements Camera.FaceDetectionListener
  {
    private final aeac.c jdField_a_of_type_Aeac$c;
    private final aeac.g jdField_a_of_type_Aeac$g;
    private final Handler mHandler;
    
    public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
    {
      QLog.d("Q.camera.CameraManagerImpl", 2, "[onFaceDetection] faces = " + paramArrayOfFace + ", length = " + paramArrayOfFace.length);
      this.mHandler.post(new CameraManagerImpl.FaceDetectionCallbackForward.1(this, paramArrayOfFace));
    }
  }
  
  public static class f
    implements Camera.PictureCallback
  {
    private final aeac.e jdField_a_of_type_Aeac$e;
    private final aeac.g jdField_a_of_type_Aeac$g;
    private final Handler mHandler;
    
    public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
    {
      this.mHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
    }
  }
  
  public static class g
    implements Camera.PreviewCallback
  {
    private final aeac.f jdField_a_of_type_Aeac$f;
    private final aeac.g jdField_a_of_type_Aeac$g;
    private final Handler mHandler;
    
    @TargetApi(8)
    public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      this.mHandler.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
    }
  }
  
  public static class h
    implements Camera.ShutterCallback
  {
    private final aeac.g jdField_a_of_type_Aeac$g;
    private final aeac.h jdField_a_of_type_Aeac$h;
    private final Handler mHandler;
    
    public void onShutter()
    {
      this.mHandler.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aead
 * JD-Core Version:    0.7.0.1
 */