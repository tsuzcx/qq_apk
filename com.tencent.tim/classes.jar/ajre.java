import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ajre
  extends aojm
{
  private NearbyAppInterface b;
  
  public ajre(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.b = paramNearbyAppInterface;
  }
  
  public aojn a(aool paramaool)
  {
    if (paramaool == null) {}
    do
    {
      return null;
      if ((paramaool.mFileType == 8) || (paramaool.mFileType == 64) || (paramaool.mFileType == 21)) {
        return new aomd(this, paramaool);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramaool.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajre
 * JD-Core Version:    0.7.0.1
 */