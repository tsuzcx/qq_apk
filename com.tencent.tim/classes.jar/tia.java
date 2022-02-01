import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
public final class tia
  implements DialogInterface.OnDismissListener
{
  public tia(GdtMotiveBrowsingFragment paramGdtMotiveBrowsingFragment) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    GdtMotiveBrowsingFragment.a(this.a).aTG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tia
 * JD-Core Version:    0.7.0.1
 */