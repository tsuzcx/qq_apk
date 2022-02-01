import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class adew
  implements aolm.a
{
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaomg instanceof aoll));
      paramaomg = (aoll)paramaomg;
      paramaomg.apS += paramaomh.apW;
      paramaomh.apW = 0L;
      paramaomh = "bytes=" + paramaomg.apS + "-";
      paramaomg.u.put("Range", paramaomh);
      paramaomh = paramaomg.bZ;
      if (paramaomh.contains("range="))
      {
        String str = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
        paramaomg.bZ = (str + "range=" + paramaomg.apS);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ArConfig_ArResourceDownload", 2, "IBreakDownFix, " + paramaomh + ", offset=" + paramaomg.apS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adew
 * JD-Core Version:    0.7.0.1
 */