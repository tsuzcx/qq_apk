import java.util.Comparator;

class wdg
  implements Comparator<wcl>
{
  wdg(wde paramwde) {}
  
  public int a(wcl paramwcl1, wcl paramwcl2)
  {
    if (paramwcl1.f() == paramwcl2.f()) {
      return 0;
    }
    if (paramwcl1.f() > paramwcl2.f()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdg
 * JD-Core Version:    0.7.0.1
 */