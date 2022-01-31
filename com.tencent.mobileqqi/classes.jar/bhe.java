import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.Display;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.VcCamera;

public class bhe
  implements Camera.PreviewCallback
{
  public bhe(VcCamera paramVcCamera) {}
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool = true;
    int i;
    if (VcCamera.jdField_a_of_type_Int > 0)
    {
      if (!VcCamera.a(this.a)) {
        break label482;
      }
      if (this.a.d != 1) {
        break label295;
      }
      i = (360 - (this.a.jdField_a_of_type_AndroidViewDisplay.getRotation() * 90 + this.a.d()) % 360) % 360;
    }
    for (;;)
    {
      int j = i + this.a.e();
      label161:
      label196:
      long l;
      if ((this.a.d() == 270) || (this.a.d() == 90))
      {
        i = j;
        if (this.a.e() % 180 == 0)
        {
          i = j;
          if (this.a.d == 1)
          {
            i = j;
            if (!VcCamera.a(this.a.jdField_a_of_type_AndroidContentContext, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
              i = j + 180;
            }
          }
        }
        if (this.a.d != 1) {
          break label439;
        }
        if (this.a.j <= 0) {
          break label419;
        }
        i += 360 - this.a.j;
        j = i;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().i)
        {
          j = i;
          if (this.a.d == 1)
          {
            i -= 180;
            j = i;
            if (i < 0) {
              j = i + 360;
            }
          }
        }
        i = j % 360 / 90;
        paramCamera = this.a.jdField_a_of_type_ComTencentAvVideoController;
        l = VcCamera.jdField_a_of_type_Int;
        if (this.a.d != 1) {
          break label761;
        }
      }
      for (;;)
      {
        paramCamera.a(paramArrayOfByte, i, l, bool);
        return;
        label295:
        if (this.a.d != 2) {
          break label767;
        }
        i = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation();
        i = (this.a.d() - i * 90 + 360) % 360;
        break;
        if (this.a.d() != 0)
        {
          i = j;
          if (this.a.d() != 180) {
            break label161;
          }
        }
        if (this.a.e() != 90)
        {
          i = j;
          if (this.a.e() != 270) {
            break label161;
          }
        }
        i = j;
        if (this.a.d != 1) {
          break label161;
        }
        i = j + 180;
        break label161;
        label419:
        i += this.a.a(this.a.e());
        break label196;
        label439:
        if (this.a.k > 0)
        {
          i += this.a.k;
          break label196;
        }
        i += this.a.b(this.a.e());
        break label196;
        label482:
        j = (this.a.e() + this.a.h + 90) % 360;
        if (this.a.d() != 270)
        {
          i = j;
          if (this.a.d() != 90) {}
        }
        else
        {
          if (this.a.e() % 180 != 0) {
            break label655;
          }
          if (this.a.d != 1) {
            break label645;
          }
          i = j + 90;
        }
        label565:
        if (this.a.d == 1)
        {
          j = i;
          if (!VcCamera.a(this.a.jdField_a_of_type_AndroidContentContext, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
            j = i + 180;
          }
        }
        for (;;)
        {
          if (this.a.d == 1)
          {
            if (this.a.j > 0)
            {
              i = j + (360 - this.a.j);
              break;
              label645:
              i = j + 180;
              break label565;
              label655:
              if (this.a.d == 1)
              {
                i = j + 90;
                break label565;
              }
              i = j + 180;
              break label565;
              j = i + 180;
              continue;
            }
            i = j + this.a.a(this.a.e());
            break;
          }
        }
        if (this.a.k > 0)
        {
          i = j + this.a.k;
          break label196;
        }
        i = j + this.a.b(this.a.e());
        break label196;
        label761:
        bool = false;
      }
      label767:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhe
 * JD-Core Version:    0.7.0.1
 */