import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aitj
  extends acnd
{
  aitj(aitg paramaitg) {}
  
  protected void cG(String paramString, int paramInt)
  {
    super.cG(paramString, paramInt);
    if ((aitg.a(this.b).getSessionType() == 1) && (aitg.a(this.b).xc().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (aitg.a(this.b) != null)
      {
        aitg.a(this.b).finish();
        QQToast.a(aitg.a(this.b), 2131694569, 1).show();
      }
      aitg.e(aitg.a(this.b), 1, paramString);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    super.q(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      aitg.e(aitg.a(this.b), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitj
 * JD-Core Version:    0.7.0.1
 */