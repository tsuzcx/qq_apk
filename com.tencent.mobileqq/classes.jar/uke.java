import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Iterator;
import java.util.List;

final class uke
  implements DialogInterface.OnClickListener
{
  uke(List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ukd.a((String)localIterator.next());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */