import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aesk
  implements DialogInterface.OnClickListener
{
  aesk(aesh paramaesh, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = this.val$context;
    if (this.bWf)
    {
      str = this.a.h.getString(this.bAQ);
      aqrf.cU((Context)localObject, str);
      paramDialogInterface.dismiss();
      if (!this.bWf) {
        break label92;
      }
      paramDialogInterface = "0X800AE6A";
      label50:
      localObject = this.bAQ;
      if (!this.bWg) {
        break label98;
      }
    }
    label92:
    label98:
    for (String str = "size";; str = "full")
    {
      aesh.aD(paramDialogInterface, (String)localObject, str);
      return;
      str = this.a.i.getString(this.bAQ);
      break;
      paramDialogInterface = "0X800AE64";
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesk
 * JD-Core Version:    0.7.0.1
 */