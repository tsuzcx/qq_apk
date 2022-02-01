import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class aeab
{
  private static aeab jdField_a_of_type_Aeab;
  private static Camera.CameraInfo[] b;
  private aeaf jdField_a_of_type_Aeaf = aeaf.b();
  private final Camera.CameraInfo[] jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private final int cLI;
  private int cLJ = -1;
  private int cLK = -1;
  private int mCameraId = -1;
  
  private aeab()
  {
    int i;
    if (b != null)
    {
      this.cLI = b.length;
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = b;
      i = k;
      if (i >= this.cLI) {
        return;
      }
      if ((this.cLJ != -1) || (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i].facing != 0)) {
        break label203;
      }
      this.cLJ = i;
    }
    for (;;)
    {
      i += 1;
      break;
      this.cLI = getNumberOfCameras();
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraHolder", 1, "[CameraHolder] mNumberOfCameras = " + this.cLI);
      }
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = new Camera.CameraInfo[this.cLI];
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= this.cLI) {
          break;
        }
        this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j] = new Camera.CameraInfo();
        try
        {
          Camera.getCameraInfo(j, this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j]);
          j += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("Q.camera.CameraHolder", 2, localException, new Object[0]);
          }
        }
      }
      label203:
      if ((this.cLK == -1) && (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i].facing == 1)) {
        this.cLK = i;
      }
    }
  }
  
  /* Error */
  public static aeab a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 94	aeab:jdField_a_of_type_Aeab	Laeab;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 94	aeab:jdField_a_of_type_Aeab	Laeab;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	aeab
    //   21: dup
    //   22: invokespecial 95	aeab:<init>	()V
    //   25: putstatic 94	aeab:jdField_a_of_type_Aeab	Laeab;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 94	aeab:jdField_a_of_type_Aeab	Laeab;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localaeab	aeab
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public aeaf a()
  {
    return aeaf.b();
  }
  
  public Camera.CameraInfo[] a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  }
  
  public int getNumberOfCameras()
  {
    return aeaf.b().getNumberOfCameras();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeab
 * JD-Core Version:    0.7.0.1
 */