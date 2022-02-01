import java.util.Comparator;

class acgm
  implements Comparator<acgl.c>
{
  acgm(acgl paramacgl) {}
  
  public int a(acgl.c paramc1, acgl.c paramc2)
  {
    if ((paramc1 == null) || (paramc2 == null)) {}
    do
    {
      return 0;
      if (paramc1.stime > paramc2.stime) {
        return 1;
      }
    } while (paramc1.stime >= paramc2.stime);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgm
 * JD-Core Version:    0.7.0.1
 */