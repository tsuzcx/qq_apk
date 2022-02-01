import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class zlr
  implements DialogInterface.OnClickListener
{
  zlr(zlq paramzlq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((aocn)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a(true);
    bdla.b(null, "dc00898", "", "", "0X800A476", "0X800A476", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlr
 * JD-Core Version:    0.7.0.1
 */