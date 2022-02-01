import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class adbi
  implements addz.a
{
  public static int cBx = 8;
  private long RP;
  private adbi.a jdField_a_of_type_Adbi$a;
  private addz jdField_a_of_type_Addz;
  private boolean bKU;
  private boolean bKV = true;
  private int cBy = 0;
  private Context mContext;
  
  public adbi(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Addz = new addz();
  }
  
  private void f(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    long l;
    if (this.RP != 0L)
    {
      l = System.currentTimeMillis();
      if (l - this.RP >= 1000L) {}
    }
    label35:
    label241:
    do
    {
      return;
      this.RP = l;
      if (paramFloat2 > cBx) {}
      for (int i = 1;; i = 2)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("ARPhonePoseDetectManager", 1, "ARPhonePoseDetectManager current value:=" + this.cBy + ";nextPhonepose:=" + i);
        }
        if (this.cBy == i) {
          break;
        }
        QLog.i("ARPhonePoseDetectManager", 1, "detectPhonePose. data = " + paramFloat1 + "," + paramFloat2 + "," + paramFloat3 + "," + paramLong + ", mPhonePose = " + this.cBy + ", phonePose = " + i);
        if ((i == 2) && (this.bKV)) {
          this.bKV = false;
        }
        this.cBy = i;
        if (this.jdField_a_of_type_Adbi$a == null) {
          break;
        }
        if (this.cBy != 1) {
          break label241;
        }
        this.jdField_a_of_type_Adbi$a.FR(true);
        return;
        this.RP = System.currentTimeMillis();
        break label35;
      }
    } while (this.cBy != 2);
    this.jdField_a_of_type_Adbi$a.FR(false);
  }
  
  public void a(adbi.a parama)
  {
    this.jdField_a_of_type_Adbi$a = parama;
  }
  
  public void b(float[] paramArrayOfFloat) {}
  
  public void cPF()
  {
    if (!this.bKU)
    {
      this.jdField_a_of_type_Addz.a(this.mContext, this);
      this.bKU = true;
      return;
    }
    this.jdField_a_of_type_Addz.cQM();
    this.cBy = 0;
  }
  
  public void cPG()
  {
    this.jdField_a_of_type_Addz.stopSensor();
    this.cBy = 0;
  }
  
  public void g(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    f(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public static abstract interface a
  {
    public abstract void FR(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbi
 * JD-Core Version:    0.7.0.1
 */