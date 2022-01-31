import android.text.Editable;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import java.util.Comparator;

public final class hbm
  implements Comparator
{
  public hbm(Editable paramEditable) {}
  
  public int a(AtTroopMemberSpan paramAtTroopMemberSpan1, AtTroopMemberSpan paramAtTroopMemberSpan2)
  {
    int i = 0;
    int j = this.a.getSpanStart(paramAtTroopMemberSpan1);
    int k = this.a.getSpanStart(paramAtTroopMemberSpan2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hbm
 * JD-Core Version:    0.7.0.1
 */