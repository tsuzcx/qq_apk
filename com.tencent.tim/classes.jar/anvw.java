import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class anvw
  implements DialogInterface.OnDismissListener
{
  anvw(anvv paramanvv, int paramInt1, int paramInt2) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = ((Iterable)anvv.a(this.a)).iterator();
    while (paramDialogInterface.hasNext()) {
      ((anvv.a)paramDialogInterface.next()).ff(this.dNc, this.dNd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvw
 * JD-Core Version:    0.7.0.1
 */