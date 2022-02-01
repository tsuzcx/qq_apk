import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class aksi
  implements DialogInterface.OnClickListener
{
  aksi(akrv paramakrv, long paramLong, AppRuntime.Status paramStatus) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(akrv.a(this.this$0)))
    {
      QQToast.a(akrv.a(this.this$0), 1, 2131720447, 1).show();
      return;
    }
    if (this.aen == -1L)
    {
      paramDialogInterface = (akun)akrv.a(this.this$0).getBusinessHandler(174);
      akue localakue = ((aktp)akrv.a(this.this$0).getManager(369)).a();
      paramDialogInterface.a(2, akti.a().a(localakue, false), null);
      return;
    }
    akrv.b(this.this$0, this.e, this.aen);
    anot.a(akrv.a(this.this$0), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksi
 * JD-Core Version:    0.7.0.1
 */