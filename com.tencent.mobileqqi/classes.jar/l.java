import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.activities.DLFileViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

public class l
  implements DialogInterface.OnClickListener
{
  public l(DLFileViewerActivity paramDLFileViewerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.b.a().a(DLFileViewerActivity.a(this.a).sessionid);
    if (paramDialogInterface != null) {
      paramDialogInterface.setPaused(false);
    }
    if (this.a.a.a != DLBaseFileViewActivity.DLFileState.SENDFAILED)
    {
      DLFileViewerActivity.a(this.a);
      return;
    }
    DLFileViewerActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     l
 * JD-Core Version:    0.7.0.1
 */