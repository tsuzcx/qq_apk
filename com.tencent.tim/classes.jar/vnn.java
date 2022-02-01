import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;

class vnn
  implements DialogInterface.OnClickListener
{
  vnn(vnm paramvnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.a.b.a.app.b().t(this.a.b.a.ay(), 0, this.a.rJ);
      this.a.b.a.refresh();
      return;
    } while (this.a.b.a.a.getCount() <= 0);
    this.a.b.a.app.b().N(this.a.b.a.ay(), 0);
    this.a.b.a.a.changeCursor(this.a.b.getCursor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnn
 * JD-Core Version:    0.7.0.1
 */