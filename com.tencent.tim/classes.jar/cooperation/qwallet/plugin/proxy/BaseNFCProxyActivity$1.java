package cooperation.qwallet.plugin.proxy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BaseNFCProxyActivity$1
  implements DialogInterface.OnClickListener
{
  BaseNFCProxyActivity$1(BaseNFCProxyActivity paramBaseNFCProxyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.startActivity(new Intent("android.settings.NFC_SETTINGS"));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.proxy.BaseNFCProxyActivity.1
 * JD-Core Version:    0.7.0.1
 */