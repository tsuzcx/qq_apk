import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class afso
  implements afxt
{
  afso(afsi paramafsi) {}
  
  public void a(boolean paramBoolean, aftc paramaftc)
  {
    if (afsi.a(this.this$0) == null)
    {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo NOT suc");
    }
    int i = afwh.K(afsi.a(this.this$0));
    ((afsg)afsi.a(this.this$0).getBusinessHandler(127)).a(i, paramaftc);
    QLog.i("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo  suc:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afso
 * JD-Core Version:    0.7.0.1
 */