import java.util.HashMap;

final class awqf
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
    } while (!paramaomh.contains("range="));
    paramaomh = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
    paramaomg.bZ = (paramaomh + "range=" + paramaomg.apS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqf
 * JD-Core Version:    0.7.0.1
 */