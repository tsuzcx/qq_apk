import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class ilk
  implements Camera.PreviewCallback
{
  private int aoE = -1;
  
  ilk(ilj paramilj) {}
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "onPreviewFrame, data为空, Camera[" + paramCamera + "], camera[" + this.a.camera + "]");
      }
      this.a.jdField_a_of_type_Ilj$c.anT();
    }
    int i1;
    int k;
    int i2;
    int i;
    int j;
    label214:
    label249:
    int i4;
    label308:
    boolean bool;
    label492:
    do
    {
      return;
      i1 = this.a.la();
      k = ilj.a(this.a) * 90;
      if (this.a.Sk) {
        k = 0;
      }
      i2 = this.a.lb();
      i = 0;
      if (this.a.CUR_CAMERA != 1) {
        break;
      }
      i = (360 - (k + i1) % 360) % 360;
      j = i + i2;
      if ((i1 != 270) && (i1 != 90)) {
        break label619;
      }
      i = j;
      if (i2 % 180 == 0)
      {
        i = j;
        if (this.a.CUR_CAMERA == 1) {
          if (tU())
          {
            i = j;
            if (!this.a.Sj) {}
          }
          else
          {
            i = j + 180;
          }
        }
      }
      if (this.a.CUR_CAMERA != 1) {
        break label746;
      }
      if (this.a.mFrontCameraAngle <= 0) {
        break label724;
      }
      i += 360 - this.a.mFrontCameraAngle;
      int i3 = i % 360 / 90;
      j = ilj.aoB;
      i = ilj.aoC;
      i4 = paramArrayOfByte.length;
      int m = i;
      int n = j;
      if (i4 != j * i * 3 / 2)
      {
        if (i4 != 460800) {
          break label791;
        }
        j = 640;
        i = 480;
        m = i;
        n = j;
        if (AudioHelper.aCz())
        {
          QLog.w("AndroidCamera", 1, "OnPreviewData false, expectSize[" + ilj.aoB + ", " + ilj.aoC + "], datalen[" + i4 + "], fixSize[" + j + ", " + i + "]");
          n = j;
          m = i;
        }
      }
      this.a.jdField_a_of_type_Ilj$c.a(i3, this.a.CUR_CAMERA, ilj.nInFPS, this.a.Sk, i1, k, i2, paramArrayOfByte.length, n, m);
      if (this.a.jdField_a_of_type_Ilj$b != null)
      {
        paramCamera = this.a.jdField_a_of_type_Ilj$b;
        long l1 = this.a.jdField_a_of_type_Ilj$c.frameIndex;
        long l2 = ilj.nInFPS;
        if (this.a.CUR_CAMERA != 1) {
          break label829;
        }
        bool = true;
        paramCamera.a(l1, paramArrayOfByte, n, m, i3, i2, l2, bool);
      }
    } while ((!this.a.Si) || (this.a.camera == null) || (paramArrayOfByte == null));
    paramCamera = ilo.a().c(0);
    if (paramCamera == null)
    {
      paramCamera = paramArrayOfByte;
      if (QLog.isDevelopLevel())
      {
        QLog.w("AndroidCamera", 1, "OnPreviewData, 没有空闲的缓存");
        paramCamera = paramArrayOfByte;
      }
    }
    for (;;)
    {
      if (paramCamera != null) {
        ilo.a().d(paramCamera, 1);
      }
      this.a.camera.addCallbackBuffer(paramCamera);
      return;
      if (this.a.CUR_CAMERA != 2) {
        break;
      }
      i = (i1 - k + 360) % 360;
      break;
      label619:
      if (i1 != 0)
      {
        i = j;
        if (i1 != 180) {
          break label214;
        }
      }
      if ((i2 == 90) || (i2 == 270))
      {
        i = j;
        if (this.a.CUR_CAMERA != 1) {
          break label214;
        }
        i = j;
        if (this.a.mbIsTablet) {
          break label214;
        }
        i = j + 180;
        break label214;
      }
      i = j;
      if (this.a.CUR_CAMERA != 1) {
        break label214;
      }
      i = j;
      if (!this.a.mbIsTablet) {
        break label214;
      }
      i = j + 180;
      break label214;
      label724:
      i += this.a.g(i2, this.a.Sk);
      break label249;
      label746:
      if (this.a.mBackCameraAngle > 0)
      {
        i += this.a.mBackCameraAngle;
        break label249;
      }
      i += this.a.h(i2, this.a.Sk);
      break label249;
      label791:
      if (i4 == 1382400)
      {
        j = 1280;
        i = 720;
        break label308;
      }
      if (i4 != 115200) {
        break label308;
      }
      j = 320;
      i = 240;
      break label308;
      label829:
      bool = false;
      break label492;
    }
  }
  
  boolean tU()
  {
    if (this.aoE == -1) {
      if (!jkg.get(this.a.mContext, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
        break label43;
      }
    }
    label43:
    for (this.aoE = 1; this.aoE == 1; this.aoE = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilk
 * JD-Core Version:    0.7.0.1
 */