import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.a;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class agai
  extends achq
{
  public agai(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onSendSystemMsgActionFin 同意加对方好友回调 issuc" + paramBoolean + "logStr=" + paramString1 + ";actionType=" + paramInt1 + ";msgDetail=" + paramString2 + ";resultCode=" + paramInt2 + ";respType=" + paramInt3 + ";msgFail=" + paramString3 + ";msgInvalidDecided=" + paramString4 + ";remarkRet=" + paramInt4);
    }
    long l2 = anzd.a().hf();
    Object localObject;
    if ((!paramBoolean) && (paramInt2 == 32))
    {
      QQToast.a(this.this$0, 0, paramString3, 0).show(this.this$0.getTitleBarHeight());
      localObject = anzd.a().a(Long.valueOf(l2));
      if (localObject != null)
      {
        localObject = String.valueOf(((structmsg.StructMsg)localObject).req_uin.get());
        Message localMessage = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
        localMessage.what = 2;
        localMessage.arg1 = 3;
        localMessage.obj = localObject;
        Face2FaceAddFriendActivity.a(this.this$0).sendMessage(localMessage);
        Face2FaceAddFriendActivity.a(this.this$0, 3, (String)localObject);
      }
      super.a(paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
      return;
    }
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      localObject = anzd.a().a(Long.valueOf(l1));
      if (localObject != null)
      {
        localObject = String.valueOf(((structmsg.StructMsg)localObject).req_uin.get());
        if ((QLog.isColorLevel()) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onSendSystemMsgActionFin 同意加对方好友回调 =" + ((String)localObject).substring(0, 4));
        }
        this.this$0.AH.add(localObject);
        super.a(paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l1 = l2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onSendSystemMsgActionFin structMsg = null");
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onSendSystemMsgActionError.benginisSuccess=" + paramBoolean + "uin" + paramString);
    }
    super.a(paramBoolean, paramString, paramLong);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin.bengin");
    }
    if (paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin.success");
      }
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        new ArrayList();
        localObject = this.this$0.app.b().k(acbn.bkJ, 0);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin mDataList size=" + ((List)localObject).size());
        }
        i = ((List)localObject).size() - 1;
        if (i >= 0)
        {
          MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)((List)localObject).get(i);
          if (localMessageForSystemMsg == null) {
            return;
          }
          if (QLog.isColorLevel())
          {
            QLog.d(Face2FaceAddFriendActivity.TAG, 2, "msg_type=" + localMessageForSystemMsg.structMsg.msg_type.get() + "source id" + localMessageForSystemMsg.structMsg.msg.src_id.get() + "senderuin" + localMessageForSystemMsg.senderuin);
            QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin" + localMessageForSystemMsg.senderuin + "请求加好友");
          }
          if ((localMessageForSystemMsg.structMsg.msg.src_id.get() == 3021) || (localMessageForSystemMsg.structMsg.msg.src_id.get() == 2021)) {
            break label322;
          }
          if (!QLog.isColorLevel()) {
            break label670;
          }
          QLog.d(Face2FaceAddFriendActivity.TAG, 2, "此请求加好友来源不是面对面不予处理");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      super.a(paramBoolean1, paramBoolean2, paramList);
      return;
      label322:
      if (localException.structMsg.msg_type.get() == 1)
      {
        Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = Face2FaceAddFriendActivity.a(this.this$0, localException.senderuin, 1);
        int j;
        if (localFace2FaceFriendBubbleView == null)
        {
          this.this$0.kA.put(localException.senderuin, Integer.valueOf(3));
          if (QLog.isColorLevel()) {
            QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin getViewFromUin=null");
          }
        }
        else
        {
          Iterator localIterator = this.this$0.AH.iterator();
          String str2;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str2 = (String)localIterator.next();
          } while (!localException.senderuin.equals(str2));
          for (boolean bool = true;; bool = false)
          {
            if ((localFace2FaceFriendBubbleView != null) && (bool) && (Face2FaceAddFriendActivity.a(this.this$0, localException.senderuin)))
            {
              if (!QLog.isColorLevel()) {
                break label670;
              }
              QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin isAddFriend=true" + bool);
              return;
            }
            j = localException.structMsg.msg.sub_type.get();
            if (!QLog.isColorLevel()) {
              break label671;
            }
            QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetSystemMsgFin subType=" + j);
            break label671;
            localObject = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
            ((Message)localObject).what = 2;
            ((Message)localObject).arg1 = 3;
            ((Message)localObject).obj = localException.senderuin;
            Face2FaceAddFriendActivity.a(this.this$0).sendMessage((Message)localObject);
            Face2FaceAddFriendActivity.a(this.this$0, 3, localException.senderuin);
            return;
            if (!paramBoolean2) {
              break;
            }
            String str1 = this.this$0.getResources().getString(2131720697);
            QQToast.a(this.this$0, 1, str1, 0).show(this.this$0.getTitleBarHeight());
            break;
          }
        }
        return;
        switch (j)
        {
        }
      }
      label670:
      label671:
      i -= 1;
    }
  }
  
  protected void iv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onSendSystemMsgActionError.bengin 同意添加好友失败" + paramString);
    }
    long l2 = anzd.a().hf();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l1 = Long.parseLong(paramString);
      Object localObject = anzd.a().a(Long.valueOf(l1));
      if (localObject != null)
      {
        localObject = String.valueOf(((structmsg.StructMsg)localObject).req_uin.get());
        Message localMessage = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
        localMessage.what = 2;
        localMessage.arg1 = 3;
        localMessage.obj = localObject;
        Face2FaceAddFriendActivity.a(this.this$0).sendMessage(localMessage);
        Face2FaceAddFriendActivity.a(this.this$0, 3, (String)localObject);
        this.this$0.a.Iz((String)localObject);
        localObject = this.this$0.getResources().getString(2131693352);
        QQToast.a(this.this$0, 0, (CharSequence)localObject, 0).show(this.this$0.getTitleBarHeight());
        super.iv(paramString);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l1 = l2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i(Face2FaceAddFriendActivity.TAG, 2, "onSendSystemMsgActionError structMsg = null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agai
 * JD-Core Version:    0.7.0.1
 */