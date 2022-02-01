import java.util.HashMap;

class pnf
  implements aolm.a
{
  pnf(pnb.c paramc) {}
  
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
    String str1 = localaoll.bZ;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localaoll.bZ = (str2 + "range=" + localaoll.apS);
    }
    paramaomg = paramaomg.U();
    if ((paramaomg != null) && ((paramaomg instanceof png))) {
      ((png)paramaomg).aAL = true;
    }
    ram.d("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { paramaomh, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnf
 * JD-Core Version:    0.7.0.1
 */