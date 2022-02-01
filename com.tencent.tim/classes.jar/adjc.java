import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class adjc
  implements aolm.a
{
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    while (!(paramaomg instanceof aoll)) {
      return;
    }
    aoll localaoll = (aoll)paramaomg;
    localaoll.apS += paramaomh.apW;
    paramaomh.apW = 0L;
    paramaomh = "bytes=" + localaoll.apS + "-";
    localaoll.u.put("Range", paramaomh);
    paramaomh = localaoll.bZ;
    if (paramaomh.contains("range="))
    {
      paramaomh = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
      localaoll.bZ = (paramaomh + "range=" + localaoll.apS);
    }
    QLog.i("AREngine_ARResourceDownload", 1, "IBreakDownFix. url = " + ((aoll)paramaomg).bZ + ", offset=" + localaoll.apS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjc
 * JD-Core Version:    0.7.0.1
 */