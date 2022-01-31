import android.text.Editable;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import java.util.Comparator;

public final class eqa
  implements Comparator
{
  public eqa(Editable paramEditable) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqa
 * JD-Core Version:    0.7.0.1
 */