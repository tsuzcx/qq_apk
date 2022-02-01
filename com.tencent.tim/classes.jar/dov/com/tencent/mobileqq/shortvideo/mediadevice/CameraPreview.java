package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.content.res.Resources;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import azbc;
import com.tencent.qphone.base.util.QLog;

public class CameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  SurfaceHolder a;
  public azbc a;
  
  public CameraPreview(Context paramContext)
  {
    super(paramContext);
    super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Azbc.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreview", 2, "[@] surfaceChanged end");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Azbc.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Azbc.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview
 * JD-Core Version:    0.7.0.1
 */