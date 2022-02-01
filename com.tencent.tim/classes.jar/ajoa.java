import java.util.HashMap;

class ajoa
  implements aolm.a
{
  ajoa(ajny paramajny) {}
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg != null) && (paramaomh != null) && ((paramaomg instanceof aoll)))
    {
      paramaomg = (aoll)paramaomg;
      paramaomg.apS += paramaomh.apW;
      paramaomh.apW = 0L;
      paramaomh = "bytes=" + paramaomg.apS + "-";
      paramaomg.u.put("Range", paramaomh);
      paramaomh = paramaomg.bZ;
      if (paramaomh.contains("range="))
      {
        paramaomh = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
        paramaomg.bZ = (paramaomh + "range=" + paramaomg.apS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoa
 * JD-Core Version:    0.7.0.1
 */