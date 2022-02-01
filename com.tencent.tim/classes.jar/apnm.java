import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class apnm
  extends apmr
  implements Observer
{
  @Nullable
  private apbo jdField_a_of_type_Apbo;
  private apmz jdField_a_of_type_Apmz;
  private long arM;
  private apbo.b b;
  private Object fp;
  
  apnm(QQAppInterface paramQQAppInterface, Context paramContext, apmz paramapmz, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 102;
    this.jdField_a_of_type_Apmz = paramapmz;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    this.arM = paramLong1;
    this.fp = paramObject;
    paramList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new apmr.a(true, this.context.getString(2131699845), apab.a.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView1.setVisibility(0);
    paramTextView2.setVisibility(8);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.app.getManager(52);
    String str;
    long l;
    if (paramObject != null)
    {
      paramObject = paramObject.b(this.sessionInfo.aTl);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.context.getString(2131699857));
        paramString = this.app;
        str = this.sessionInfo.aTl;
        l = paramObject.dwGroupClassExt;
        if (!bool) {
          break label104;
        }
      }
    }
    label104:
    for (paramObject = "2";; paramObject = "1")
    {
      anot.b(paramString, "dc00898", "", "", "", "0X800AACB", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      return;
    }
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.app.getManager(52);
    String str;
    long l;
    if (paramObject != null)
    {
      paramObject = paramObject.b(this.sessionInfo.aTl);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.context.getString(2131699857));
        paramString = this.app;
        str = this.sessionInfo.aTl;
        l = paramObject.dwGroupClassExt;
        if (!bool) {
          break label104;
        }
      }
    }
    label104:
    for (paramObject = "2";; paramObject = "1")
    {
      anot.b(paramString, "dc00898", "", "", "", "0X800AACC", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      return;
    }
  }
  
  public void cbt()
  {
    super.cbt();
    this.b = null;
    if (this.jdField_a_of_type_Apbo != null) {
      this.jdField_a_of_type_Apbo.deleteObserver(this);
    }
  }
  
  void eaK()
  {
    boolean bool3 = this.jdField_a_of_type_Apmz.isShow();
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateNotification", 2, "showTroopNotifyBar troopNotifyData = " + this.b + ",  mFIsShow = " + bool3);
    }
    if (this.b == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Apmz.aBm())
      {
        this.b = null;
        return;
      }
      bool2 = false;
      localObject1 = "";
      Object localObject2 = localObject1;
      bool1 = bool2;
      Object localObject4;
      if (bool3)
      {
        localObject2 = localObject1;
        bool1 = bool2;
        if (!this.b.cPJ)
        {
          localObject2 = localObject1;
          bool1 = bool2;
          if ((this.fp instanceof MessageForArkApp))
          {
            localObject4 = (MessageForArkApp)this.fp;
            localObject2 = localObject1;
            bool1 = bool2;
            if (((MessageForArkApp)localObject4).ark_app_message != null)
            {
              localObject2 = localObject1;
              bool1 = bool2;
              if (!"com.tencent.mannounce".equals(((MessageForArkApp)localObject4).ark_app_message.appName)) {}
            }
          }
        }
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TroopAioMsgNavigateNotification", 2, "showTroopNotifyBar ark.ark_app_message.metaList:" + ((MessageForArkApp)localObject4).ark_app_message.metaList);
          QLog.d("TroopAioMsgNavigateNotification", 2, "showTroopNotifyBar mTroopNotifyData confirmRequired:" + this.b.cPK + " fid:" + this.b.fid + " isShowTipWindow:" + this.b.cPJ);
        }
        localObject2 = new JSONObject(((MessageForArkApp)localObject4).ark_app_message.metaList).optJSONObject("mannounce");
        localObject4 = this.jdField_a_of_type_Apmz.f();
        if ((localObject2 == null) || (localObject4 == null) || (!((JSONObject)localObject2).optString("fid").equals(this.b.fid))) {
          break label507;
        }
        long l = ((MessageRecord)localObject4).shmsgseq;
        localObject2 = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, this.arM);
        if ((localObject2 == null) || (!a((MessageRecord)localObject2, l, this.jdField_a_of_type_Apmz.hv()))) {
          break label507;
        }
        if (!this.b.cPK) {
          break;
        }
        localObject2 = this.context.getString(2131699857);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TroopAioMsgNavigateNotification", 1, "[showTroopNotifyBar] ", localException);
          Object localObject3 = localObject1;
          bool1 = bool2;
          continue;
          localObject1 = "";
          continue;
          bool1 = false;
        }
      }
      bool1 = true;
      localObject2 = localObject1;
      this.jdField_a_of_type_Apmz.a(new apmr.a(bool1, (String)localObject2, null, ""));
      this.b = null;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAioMsgNavigateNotification", 2, "showTroopNotifyBar mFIsShow:" + bool1);
  }
  
  public int getIconRes(int paramInt)
  {
    return 2130851832;
  }
  
  public void onInit()
  {
    super.onInit();
    this.b = null;
    ajdr localajdr = (ajdr)this.app.getManager(37);
    long l = aqix.string2Long(this.sessionInfo.aTl);
    if (l == -1L) {
      return;
    }
    this.jdField_a_of_type_Apbo = localajdr.a(Long.valueOf(l), true);
    this.jdField_a_of_type_Apbo.addObserver(this);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateNotification", 2, "troopNotify update");
    }
    if (!(paramObject instanceof Integer)) {}
    do
    {
      do
      {
        return;
        paramObservable = (Integer)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateNotification", 2, "update. notifyType = " + paramObservable);
        }
      } while ((paramObservable.intValue() != 1007) && (paramObservable.intValue() != 1011));
      if ((this.jdField_a_of_type_Apbo != null) && (this.jdField_a_of_type_Apbo.bS != null)) {
        try
        {
          this.b = apbo.b.a(this.app, this.sessionInfo.aTl, this.jdField_a_of_type_Apbo.bS);
          eaK();
          return;
        }
        finally {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAioMsgNavigateNotification", 2, "update. mNewNorNotice = null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnm
 * JD-Core Version:    0.7.0.1
 */