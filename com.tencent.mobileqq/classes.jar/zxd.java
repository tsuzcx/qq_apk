import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class zxd
  implements Runnable
{
  zxd(zxa paramzxa, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if (zxa.c(this.jdField_a_of_type_Zxa) != -1) {
      GLES20.glDeleteTextures(1, new int[] { zxa.c(this.jdField_a_of_type_Zxa) }, 0);
    }
    if (zxa.d(this.jdField_a_of_type_Zxa) != -1) {
      GLES20.glDeleteTextures(1, new int[] { zxa.d(this.jdField_a_of_type_Zxa) }, 0);
    }
    if (zxa.e(this.jdField_a_of_type_Zxa) != -1) {
      GLES20.glDeleteTextures(1, new int[] { zxa.e(this.jdField_a_of_type_Zxa) }, 0);
    }
    try
    {
      zxa.b(this.jdField_a_of_type_Zxa, zxa.a(this.jdField_a_of_type_Zxa, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      zxa.c(this.jdField_a_of_type_Zxa, zxa.a(this.jdField_a_of_type_Zxa, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      zxa.d(this.jdField_a_of_type_Zxa, zxa.a(this.jdField_a_of_type_Zxa, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      zxa.a(this.jdField_a_of_type_Zxa, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "drawFrame_soft exception=" + localException.getMessage());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxd
 * JD-Core Version:    0.7.0.1
 */