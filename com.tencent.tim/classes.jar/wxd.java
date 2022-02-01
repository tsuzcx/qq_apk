import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class wxd
  extends aoif
{
  wxd(wxc paramwxc) {}
  
  protected void a(boolean paramBoolean, aoii paramaoii, int paramInt, String paramString)
  {
    int i = 1;
    if (!wxc.a(this.a).sessionInfo.aTl.equals(paramaoii.uin)) {
      super.a(paramBoolean, paramaoii, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        wxc.a(this.a).setTogetherSession(paramaoii);
        if (paramaoii.status == 3)
        {
          this.a.Sj();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramaoii.serviceType), " session.userState=", Integer.valueOf(paramaoii.deR), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!aoij.a(wxc.a(this.a).app, paramaoii)) || (aihl.f(paramaoii.serviceType, paramaoii.uin, paramaoii.type)) || (this.a.Sn())) {
              break label242;
            }
            paramInt = i;
            if (paramInt != 0) {
              break label247;
            }
            this.a.Sj();
          }
        }
        for (;;)
        {
          wxc.a(this.a);
          return;
          switch (paramaoii.deR)
          {
          default: 
            paramBoolean = false;
            break;
          case 1: 
          case 2: 
          case 3: 
            paramBoolean = true;
            break;
            paramInt = 0;
            break label180;
            wxc.a(this.a);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState false, ", Integer.valueOf(paramInt), " ", paramString });
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2)
    {
      if (((paramObject instanceof apyk)) && (wxc.a(this.a).sessionInfo.aTl.equals(((apyk)paramObject).troopuin)) && ((wxc.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)wxc.a(this.a)).a().h(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxd
 * JD-Core Version:    0.7.0.1
 */