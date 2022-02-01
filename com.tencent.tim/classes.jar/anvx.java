import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class anvx
  implements DialogInterface.OnClickListener
{
  anvx(anvv paramanvv, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof aqju)) {
      ((aqju)paramDialogInterface).setOnDismissListener(null);
    }
    anvv.a(this.a, this.dNe, this.dNc, this.dNd, this.cKi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvx
 * JD-Core Version:    0.7.0.1
 */