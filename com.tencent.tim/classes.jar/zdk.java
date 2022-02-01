import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;

class zdk
  implements DialogInterface.OnClickListener
{
  zdk(zdf paramzdf, ArrayList paramArrayList, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    zdf.a(this.this$0, true);
    zdf.a(this.this$0).Fc(1);
    zdf.a(this.this$0, this.val$list.size(), 0.0F);
    if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      paramInt = (int)(90.0F / this.cdb);
      zdf.a(this.this$0).Fd(paramInt);
    }
    zdf.a(this.this$0, this.val$list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdk
 * JD-Core Version:    0.7.0.1
 */