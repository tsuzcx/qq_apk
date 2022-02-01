import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;

public class yiy
  implements Handler.Callback, yim
{
  private NearbyGrayTipsManager jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager;
  private yjh jdField_a_of_type_Yjh;
  private MqqHandler b = new aqgw(ThreadManager.getSubThreadLooper(), this);
  private int byr;
  private QQMessageFacade e;
  private Random g;
  private QQAppInterface mApp;
  private int mGender;
  private SessionInfo mSessionInfo;
  
  public yiy(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, yjh paramyjh)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Yjh = paramyjh;
    this.mGender = -1;
    this.g = new Random();
    if (this.mSessionInfo.cZ == 1001) {
      this.byr = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager = ((NearbyGrayTipsManager)this.mApp.getManager(93));
      this.e = ((QQMessageFacade)paramQQAppInterface.getManager(20));
      return;
      if (this.mSessionInfo.cZ == 1010) {
        this.byr = 2;
      } else if (this.mSessionInfo.cZ == 10002) {
        this.byr = 3;
      }
    }
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig1, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig2)
  {
    if (paramGrayTipsConfig1 != null)
    {
      if (paramGrayTipsConfig2 == null) {}
      do
      {
        do
        {
          return paramGrayTipsConfig1;
          if (paramGrayTipsConfig1.priority != paramGrayTipsConfig2.priority) {
            break;
          }
          if (paramGrayTipsConfig1.createTime < paramGrayTipsConfig2.createTime) {
            return paramGrayTipsConfig2;
          }
        } while (paramGrayTipsConfig1.createTime != paramGrayTipsConfig2.createTime);
        return paramGrayTipsConfig1;
      } while (paramGrayTipsConfig1.priority >= paramGrayTipsConfig2.priority);
      return paramGrayTipsConfig2;
    }
    if (paramGrayTipsConfig2 != null) {
      return paramGrayTipsConfig2;
    }
    return null;
  }
  
  private boolean c(int paramInt, Object... paramVarArgs)
  {
    anot.a(this.mApp, "CliOper", "", "", "0X800524B", "0X800524B", 0, 0, String.valueOf(paramInt), "", "", "");
    QQAppInterface localQQAppInterface = this.mApp;
    if (this.byr == 0) {}
    for (String str = "0";; str = "1")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "exp_oper", 0, 0, str, "", "", "");
      return this.jdField_a_of_type_Yjh.a(this, paramVarArgs);
    }
  }
  
  public int[] E()
  {
    return null;
  }
  
  public void Eb(int paramInt)
  {
    this.mGender = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyMarketGrayTips", 2, "setOtherGender, " + this.mGender);
    }
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {}
    for (paramVarArgs = paramVarArgs[0].toString();; paramVarArgs = null)
    {
      if (!TextUtils.isEmpty(paramVarArgs))
      {
        MessageRecord localMessageRecord = anbi.d(-2027);
        long l = anaz.gQ();
        String str = this.mApp.getCurrentAccountUin();
        localMessageRecord.init(str, this.mSessionInfo.aTl, str, paramVarArgs, l, -2027, this.mSessionInfo.cZ, l);
        localMessageRecord.isread = true;
        return localMessageRecord;
      }
      return null;
    }
  }
  
  public int getType()
  {
    return 1006;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("NearbyMarketGrayTips", 4, "onAIOEvent, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.b.hasMessages(paramInt));
    this.b.sendEmptyMessage(paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      switch (paramMessage.what)
      {
      }
      break;
    }
    long l1;
    label378:
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig;
    int i;
    label687:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.abc()) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.bI(anaz.gQ() * 1000L))) {
              break;
            }
            return false;
            l1 = anaz.gQ() * 1000L;
            long l2 = System.currentTimeMillis();
            paramMessage = this.mApp.b().f(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
            long l3 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("NearbyMarketGrayTips", 2, "getAIOList cost:" + (l3 - l2) + " ms");
            }
            if ((paramMessage == null) || (paramMessage.size() <= 0)) {
              break label378;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.ah(paramMessage));
          paramMessage = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
        } while (anbk.ls(paramMessage.msgtype));
        if (paramMessage.isSend()) {}
        for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.byr, this.mGender, paramMessage.msg, 1, l1); paramMessage != null; paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.byr, this.mGender, paramMessage.msg, 2, l1))
        {
          localObject = paramMessage.getGrayTipWording(this.g);
          if (localObject == null) {
            break;
          }
          localObject = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, paramMessage.url, this.byr);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (!c(paramMessage.id, new Object[] { localObject })) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.aa(paramMessage.id, l1);
          break;
        }
        localGrayTipsConfig = a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.byr, this.mGender, l1), this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.d(this.byr, this.mGender, l1));
      } while (localGrayTipsConfig == null);
      paramMessage = null;
      this.g.setSeed(l1);
      localObject = localGrayTipsConfig.getGrayTipWording(this.g);
      if (localGrayTipsConfig.sceneId == 2) {
        if (localObject != null) {
          paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 2, localGrayTipsConfig.url, this.byr);
        }
      }
      while (!TextUtils.isEmpty(paramMessage))
      {
        if (!c(localGrayTipsConfig.id, new Object[] { paramMessage })) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.aa(localGrayTipsConfig.id, l1);
        break;
        if (localGrayTipsConfig.sceneId == 4)
        {
          if (localObject != null)
          {
            paramMessage = (Message)localObject;
            if (!TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text)) {}
          }
          else
          {
            paramMessage = new NearbyGrayTipsManager.Wording();
            paramMessage.text = acfp.m(2131708758);
            paramMessage.highlightText = acfp.m(2131708757);
          }
          paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, paramMessage.text, paramMessage.highlightText, 8, localGrayTipsConfig.url, this.byr);
        }
      }
      paramMessage = this.e.f(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.ah(paramMessage)) {
        return false;
      }
      l1 = anaz.gQ() * 1000L;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.abc()) || (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.bI(l1))) {
        break label880;
      }
      i = 1;
      if ((i == 0) || (paramMessage == null) || (paramMessage.size() <= 0)) {
        break label883;
      }
      localObject = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
      if (QLog.isDevelopLevel()) {
        QLog.d("longchen", 4, "last msg=" + ((ChatMessage)localObject).toString());
      }
      if (!aqiu.mt(((ChatMessage)localObject).issend)) {
        break label1201;
      }
      localObject = this.e.a(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
    } while (aqiu.d(this.mApp, (QQMessageFacade.Message)localObject));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.byr, this.mGender, ((QQMessageFacade.Message)localObject).msg, 1, l1);
    label844:
    int j;
    if (paramMessage != null)
    {
      paramMessage = paramMessage.iterator();
      i = 0;
      j = i;
      if (!paramMessage.hasNext()) {
        break label887;
      }
      if (anbk.ls(((ChatMessage)paramMessage.next()).msgtype)) {
        break label1348;
      }
      i += 1;
    }
    label954:
    label1348:
    for (;;)
    {
      break label844;
      label880:
      i = 0;
      break label687;
      label883:
      break;
      j = 0;
      label887:
      if (j == 1) {}
      for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.c(this.byr, this.mGender, l1);; paramMessage = null)
      {
        localGrayTipsConfig = a((NearbyGrayTipsManager.GrayTipsConfig)localObject, paramMessage);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = localStringBuilder1.append("send msg done. config1 id=");
          if (localObject == null)
          {
            localObject = "null";
            localObject = localStringBuilder2.append(localObject).append("|config2 id=");
            if (paramMessage != null) {
              break label1137;
            }
            paramMessage = "null";
            label977:
            localObject = ((StringBuilder)localObject).append(paramMessage).append("|chosen config id=");
            if (localGrayTipsConfig != null) {
              break label1148;
            }
            paramMessage = "null";
            label1000:
            ((StringBuilder)localObject).append(paramMessage);
            QLog.d("nearby_aio_operation_gray_tips", 4, localStringBuilder1.toString());
          }
        }
        else
        {
          if (localGrayTipsConfig == null) {
            break;
          }
          localObject = localGrayTipsConfig.getGrayTipWording(this.g);
          if (localObject == null) {
            break;
          }
          paramMessage = null;
          if (localGrayTipsConfig.sceneId != 1) {
            break label1160;
          }
          paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 1, localGrayTipsConfig.url, this.byr);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramMessage)) {
            break label1199;
          }
          if (!c(localGrayTipsConfig.id, new Object[] { paramMessage })) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.aa(localGrayTipsConfig.id, l1);
          break;
          localObject = Integer.valueOf(((NearbyGrayTipsManager.GrayTipsConfig)localObject).id);
          break label954;
          label1137:
          paramMessage = Integer.valueOf(paramMessage.id);
          break label977;
          label1148:
          paramMessage = Integer.valueOf(localGrayTipsConfig.id);
          break label1000;
          if (localGrayTipsConfig.sceneId == 3) {
            paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, localGrayTipsConfig.url, this.byr);
          }
        }
        break;
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 4, "receive message");
        }
        if (anbk.ls(((ChatMessage)localObject).msgtype)) {
          break;
        }
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.byr, this.mGender, ((ChatMessage)localObject).msg, 2, l1);
        if (paramMessage == null) {
          break;
        }
        localObject = paramMessage.getGrayTipWording(this.g);
        if (localObject == null) {
          break;
        }
        localObject = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, paramMessage.url, this.byr);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!c(paramMessage.id, new Object[] { localObject })) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.aa(paramMessage.id, l1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yiy
 * JD-Core Version:    0.7.0.1
 */