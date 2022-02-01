import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.14.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class jur
  extends adai.a
{
  jur(juq paramjuq, int paramInt) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "success:" + paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public int dI()
  {
    return 7;
  }
  
  public void onSuccess(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      Object localObject1 = ((ArrayList)paramObject).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((localObject2 instanceof AppletItem)) && (((AppletItem)localObject2).sb().equals(this.a.b.mUin)))
        {
          this.a.a.state = this.aDA;
          paramObject = null;
          localObject1 = (acja)this.a.b.app.getManager(56);
          if (localObject1 != null) {
            paramObject = ((acja)localObject1).a(this.a.b.mUin);
          }
          if (paramObject != null)
          {
            if (this.a.a.aGI != 6) {
              break label226;
            }
            if (this.aDA == 1) {
              paramObject.mShowMsgFlag = this.aDA;
            }
          }
          label226:
          while (this.a.a.aGI != 3)
          {
            ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailGroupListContainer.14.1.1(this, paramObject), 10L);
            juk.a(this.a.b, this.a.a);
            ocp.a(this.a.b.app, this.a.b.app.getApplication(), this.a.b.mUin);
            return;
          }
          paramObject.isSyncLbs = true;
          if (this.a.a.state == 1) {}
          for (boolean bool = true;; bool = false)
          {
            paramObject.isAgreeSyncLbs = bool;
            break;
          }
        }
      }
    }
    p(paramObject);
  }
  
  public void p(Object paramObject)
  {
    juk.a(this.a.b, 2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jur
 * JD-Core Version:    0.7.0.1
 */