import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton;

public class asar
  implements DialogInterface.OnClickListener
{
  public asar(ApkFileDownloadButton paramApkFileDownloadButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.cE(false, true);
    paramDialogInterface.dismiss();
    arwk.b(arwm.a().a("203").k(this.this$0.c.pageId).j("5").l(this.this$0.c.cDH).m(this.this$0.c.via).a(this.this$0.c.name).b(this.this$0.c.packageName).g(this.this$0.c.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asar
 * JD-Core Version:    0.7.0.1
 */