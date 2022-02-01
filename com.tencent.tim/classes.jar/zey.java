import android.os.Bundle;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class zey
  extends aobo
{
  public zey(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (this.this$0.mApp.getApp().getString(2131720940).equals(str))
      {
        paramArrayOfObject = this.this$0.mApp.b().a(((DocsGrayTipsInfo)localObject).uin, 0, l);
        if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)paramArrayOfObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.xg != null)) {
            ((MessageForUniteGrayTip)localObject).tipParam.xg.clear();
          }
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsg(this.this$0.mApp, str);
          localObject = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramArrayOfObject.uniseq);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).what = 78;
          ((Message)localObject).arg1 = 0;
          this.this$0.mUIHandler.sendMessage((Message)localObject);
        }
      }
      QQToast.a(this.this$0.getActivity(), str, 0).show();
      QLog.i(aoaf.cjv, 2, " onGetUserAuth  isSuccess = " + paramBoolean + " tips =" + str);
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      QLog.e(aoaf.cjv, 2, " onGetUserAuth  exception = " + paramArrayOfObject.toString());
    }
  }
  
  public void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      QLog.i(aoaf.cjv, 2, " onSetUserAuth  isSuccess = " + paramBoolean);
      Object localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramArrayOfObject = this.this$0.mApp.b().a(((DocsGrayTipsInfo)localObject).uin, 0, l);
        if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)paramArrayOfObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.xg != null)) {
            ((MessageForUniteGrayTip)localObject).tipParam.xg.clear();
          }
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsg(this.this$0.mApp, str);
          localObject = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramArrayOfObject.uniseq);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).what = 78;
          ((Message)localObject).arg1 = 0;
          this.this$0.mUIHandler.sendMessage((Message)localObject);
        }
      }
      QQToast.a(this.this$0.getActivity(), str, 0).show();
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      QLog.e(aoaf.cjv, 1, " onSetUserAuth  exception  = " + paramArrayOfObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zey
 * JD-Core Version:    0.7.0.1
 */