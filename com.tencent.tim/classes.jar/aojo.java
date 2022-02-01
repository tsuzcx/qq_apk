import java.util.HashMap;

final class aojo
  implements aolm.a
{
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (!(paramaomg instanceof aoll));
          paramaomg = (aoll)paramaomg;
          paramaomg.apS += paramaomh.apW;
          if (0L != paramaomg.apT) {
            break;
          }
          paramaomh.apW = 0L;
          paramaomh = "bytes=" + paramaomg.apS + "-";
          paramaomg.u.put("Range", paramaomh);
          paramaomh = paramaomg.bZ;
        } while (!paramaomh.contains("range="));
        paramaomh = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
        paramaomg.bZ = (paramaomh + "range=" + paramaomg.apS);
        return;
      } while ((paramaomg.apS <= 0L) || (paramaomg.apT <= 0L) || (paramaomg.apS >= paramaomg.apT));
      paramaomh.apW = 0L;
      paramaomh = "bytes=" + paramaomg.apS + "-" + paramaomg.apT;
      paramaomg.u.put("Range", paramaomh);
      paramaomh = paramaomg.bZ;
    } while (!paramaomh.contains("range="));
    paramaomh = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
    paramaomg.bZ = (paramaomh + "range=" + paramaomg.apS + "-" + paramaomg.apT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojo
 * JD-Core Version:    0.7.0.1
 */