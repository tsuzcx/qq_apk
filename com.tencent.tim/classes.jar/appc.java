import android.text.Spannable;
import java.util.Comparator;

final class appc
  implements Comparator<appb>
{
  appc(Spannable paramSpannable) {}
  
  public int a(appb paramappb1, appb paramappb2)
  {
    int i = 0;
    int j = this.a.getSpanStart(paramappb1);
    int k = this.a.getSpanStart(paramappb2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appc
 * JD-Core Version:    0.7.0.1
 */