import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.Comparator;

public class cif
  implements Comparator
{
  private cif(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public int a(cid paramcid1, cid paramcid2)
  {
    return paramcid1.c.compareToIgnoreCase(paramcid2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cif
 * JD-Core Version:    0.7.0.1
 */