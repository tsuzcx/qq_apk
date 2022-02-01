import com.tencent.mobileqq.apollo.script.SpriteActionMessage.1;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloSlaveInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abqs
{
  private abrc a;
  
  public abqs(abrc paramabrc)
  {
    this.a = paramabrc;
  }
  
  private void CM(String paramString)
  {
    abqt localabqt;
    if ((this.a != null) && (this.a.getApp() != null))
    {
      localabqt = abrj.a(this.a.getApp());
      if (localabqt != null) {}
    }
    else
    {
      return;
    }
    localabqt.ey("", paramString);
  }
  
  private void bk(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new SpriteActionMessage.1(this, paramInt, paramBoolean));
  }
  
  private void c(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      QLog.e("cmshow_scripted_SpriteActionMessage", 1, "[tiggerAction] actionData is null,return.");
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return;
      localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.mActionId = paramApolloActionData.actionId;
      localSpriteTaskParam.mActionType = 0;
      localSpriteTaskParam.crd = 3;
      localSpriteTaskParam.crb = paramApolloActionData.personNum;
      localSpriteTaskParam.mMsgId = -10000L;
      localSpriteTaskParam.mIsSend = true;
      localSpriteTaskParam.bEW = false;
      localSpriteTaskParam.bhv = paramApolloActionData.bubbleText;
    } while ((this.a == null) || (this.a.getApp() == null));
    localSpriteTaskParam.mSenderUin = String.valueOf(this.a.getApp().getCurrentAccountUin());
    ((abrg)this.a.getApp().getManager(249)).a().a(localSpriteTaskParam);
  }
  
  public void HN(int paramInt)
  {
    if ((this.a == null) || (this.a.getApp() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.getApp();
    ApolloActionData localApolloActionData = ((abxk)localQQAppInterface.getManager(155)).a(paramInt);
    String str = acfp.m(2131714730);
    if (localApolloActionData == null)
    {
      CM(str);
      return;
    }
    localApolloActionData.bubbleText = str;
    if (!ApolloUtil.aF(paramInt, localApolloActionData.personNum))
    {
      ((abhh)localQQAppInterface.getManager(153)).a(localApolloActionData, 4);
      CM(str);
      return;
    }
    c(localApolloActionData);
  }
  
  public boolean d(MessageForApollo paramMessageForApollo)
  {
    int k = 2;
    int j = 0;
    if ((paramMessageForApollo.actionType != 5) || (this.a == null) || (this.a.getApp() == null)) {
      return true;
    }
    QQAppInterface localQQAppInterface = this.a.getApp();
    String str1 = paramMessageForApollo.extendJson;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionMessage", 2, new Object[] { "rep data:", str1 });
    }
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool2;
      try
      {
        paramMessageForApollo = new JSONObject(paramMessageForApollo.extendJson);
        if (!paramMessageForApollo.has("data")) {
          break label335;
        }
        String str2 = localQQAppInterface.getCurrentAccountUin();
        JSONObject localJSONObject = paramMessageForApollo.getJSONObject("data");
        JSONArray localJSONArray = localJSONObject.getJSONArray("slaveInfoList");
        Object localObject = null;
        str1 = null;
        paramMessageForApollo = localObject;
        if (localJSONArray != null)
        {
          paramMessageForApollo = localObject;
          if (localJSONArray.length() > 0)
          {
            i = 0;
            paramMessageForApollo = str1;
            if (i < localJSONArray.length())
            {
              paramMessageForApollo = (ApolloSlaveInfo)aqec.convertFrom(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
              if (!str2.equals(String.valueOf(paramMessageForApollo.uin))) {
                continue;
              }
            }
          }
        }
        if (paramMessageForApollo == null) {
          break label327;
        }
        i = paramMessageForApollo.slaveTotal;
        if (paramMessageForApollo.isCaptured == 1)
        {
          bool1 = true;
          int m = localJSONObject.optInt("defaultActId");
          bk(i, bool1);
          if ((bool1) || (i != 0)) {
            break label321;
          }
          HN(m);
          bool2 = false;
          break label346;
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clickslaveaction", j, i, new String[0]);
          return bool2;
          i += 1;
          continue;
        }
        bool1 = false;
        continue;
        if (i > 0) {
          i = k;
        } else {
          i = 3;
        }
      }
      catch (Exception paramMessageForApollo)
      {
        QLog.i("cmshow_scripted_SpriteActionMessage", 1, "[handleSendMsg] Exception", paramMessageForApollo);
        return true;
      }
      if (i == 0)
      {
        i = 0;
      }
      else
      {
        i = 1;
        break label358;
        label321:
        bool2 = true;
        break label346;
        label327:
        bool1 = false;
        i = 0;
        continue;
        label335:
        bool1 = false;
        i = 0;
        bool2 = true;
        break label358;
        label346:
        if (!bool1) {
          continue;
        }
        if (i < 5) {
          continue;
        }
        i = 1;
      }
      label358:
      if (bool1) {
        j = 1;
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqs
 * JD-Core Version:    0.7.0.1
 */