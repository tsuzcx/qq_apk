import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;

public abstract class adva
  extends aduz
{
  protected advh a;
  public Matrix4 a;
  public int cKk = 2;
  public float[] cq = new float[3];
  public float[] cr = new float[3];
  protected Context mContext;
  
  public adva(Context paramContext, int paramInt, SensorManager paramSensorManager, adus.a parama)
  {
    super(paramSensorManager, parama);
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
    this.cKk = paramInt;
    this.mContext = paramContext;
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
    this.jdField_a_of_type_Advh = new advh();
  }
  
  protected void e(float[] paramArrayOfFloat)
  {
    if ((this.jdField_a_of_type_Adus$a == null) || (paramArrayOfFloat == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.set(paramArrayOfFloat);
        this.jdField_a_of_type_Advh.a(this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4, 0, this.cr);
        if (this.cKk == 1)
        {
          this.jdField_a_of_type_Adus$a.updateAzimuth(this.cr[0]);
          return;
        }
        this.cq[0] = this.cr[1];
        this.cq[1] = (-this.cr[0]);
        this.cq[2] = (-this.cr[2]);
        if (this.cKk == 0)
        {
          this.jdField_a_of_type_Adus$a.updateRotation(this.cq[0], this.cq[1], this.cq[2]);
          return;
        }
      } while ((this.cKk != 2) && (this.cKk != 3));
      this.jdField_a_of_type_Adus$a.updateRotation(this.cq[0], this.cq[1], this.cq[2]);
    } while ((this.cKk != 3) || (paramArrayOfFloat.length != 16));
    this.jdField_a_of_type_Adus$a.onRotationUpdateOriginal(paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adva
 * JD-Core Version:    0.7.0.1
 */