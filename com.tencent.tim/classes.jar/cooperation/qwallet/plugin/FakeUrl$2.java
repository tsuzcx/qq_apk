package cooperation.qwallet.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class FakeUrl$2
  implements DialogInterface.OnClickListener
{
  FakeUrl$2(FakeUrl paramFakeUrl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.fl != null) && (this.this$0.fl.onBlHandleFakeurl(this.this$0.fakeInfo, 1)))
    {
      QLog.i("FakeUrl", 2, "bl has handled fake url...");
      return;
    }
    this.this$0.parseFakeUrl(this.this$0.fakeInfo.retUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.FakeUrl.2
 * JD-Core Version:    0.7.0.1
 */