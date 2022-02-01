import com.tencent.qphone.base.util.QLog;

public class iwc
{
  public static String QL;
  public static String QM = "sharp/small_window/" + "close_flag";
  public static String QN;
  public static String QO;
  public static String QP;
  @Deprecated
  imf a = null;
  public int auJ;
  public int auK;
  public int auL = -1;
  public int auM;
  public int auN;
  
  static
  {
    QL = "sharp/small_window/" + "version";
    QN = "sharp/small_window/" + "use_textureview";
    QO = "sharp/small_window/" + "close_video";
    QP = "sharp/small_window/" + "close_audio";
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenConfigParser", 2, " SmallScreenConfigParser --> key_open_flag = " + QM + " , key_version = " + QL + " , key_textureview = " + QN + " , key_close_video_flag = " + QO + " , key_close_audio_flag = " + QP);
    }
  }
  
  public boolean b(imf paramimf)
  {
    try
    {
      this.auJ = paramimf.getIntValue(QL, 0);
      this.auK = paramimf.getIntValue(QM, 0);
      this.auL = paramimf.getIntValue(QN, -1);
      this.auM = paramimf.getIntValue(QO, 0);
      this.auN = paramimf.getIntValue(QP, 0);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenConfigParser", 2, "value_version = " + this.auJ + " , value_close_flag = " + this.auK + " , value_use_textureview = " + this.auL + " ,value_close_video = " + this.auM + " , value_close_audio = " + this.auN);
      }
      return true;
    }
    catch (Exception paramimf)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenConfigParser", 2, "parseConfig --> Error");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwc
 * JD-Core Version:    0.7.0.1
 */