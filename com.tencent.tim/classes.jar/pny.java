import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Iterator;
import java.util.List;

final class pny
  implements DialogInterface.OnClickListener
{
  pny(List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Iterator localIterator = this.mp.iterator();
    while (localIterator.hasNext()) {
      pnx.qT((String)localIterator.next());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pny
 * JD-Core Version:    0.7.0.1
 */