import com.tencent.qphone.base.util.QLog;

public class adhl
  extends adim
{
  public String bsP;
  public String bsQ;
  public int cFR;
  public int cFY;
  public int cFZ;
  public float confidence;
  public String sessionId;
  
  public adhl()
  {
    this.Sl = 64L;
  }
  
  public static boolean a(adhl paramadhl)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramadhl != null)
    {
      bool1 = bool2;
      if (paramadhl.aeu())
      {
        bool1 = bool2;
        if (paramadhl.aev()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARCloudPreOcrResult", 2, "isRecogSuccess result = " + bool1);
    }
    return bool1;
  }
  
  public boolean aeu()
  {
    return (this.cFR == 0) && (this.cFY == 0);
  }
  
  public boolean aev()
  {
    return this.cFZ == 1;
  }
  
  public String toString()
  {
    return "ARCloudPreOcrResult{recogType = " + this.Sl + ", recogSvrRetCode = " + this.cFR + ", recogSvrRetMsg = " + this.bsP + ", sessionId = " + this.sessionId + ", arWordDetectRetCode = " + this.cFY + ", arWordDetectRetMsg = " + this.bsQ + ", wordType = " + this.cFZ + ", confidence = " + this.confidence + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhl
 * JD-Core Version:    0.7.0.1
 */