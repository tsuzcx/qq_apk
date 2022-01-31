import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class gny
  implements UpCallBack
{
  gny(gnx paramgnx) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    boolean bool2 = true;
    boolean bool1;
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" onSend result is null ? ");
      if (paramSendResult == null)
      {
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append(" result is: ");
        if (paramSendResult != null) {
          break label74;
        }
        i = -99;
        label49:
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      }
    }
    else
    {
      if (paramSendResult != null) {
        break label82;
      }
    }
    label137:
    label142:
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label74:
      i = paramSendResult.a;
      break label49;
      label82:
      if (paramSendResult.a == 0)
      {
        bool1 = bool2;
        paramSendResult = (CardHandler)this.a.a.a(2);
        if (paramSendResult == null) {
          break label137;
        }
        paramSendResult.a(bool1, this.a.a.a(), 0);
      }
      for (;;)
      {
        if (bool1) {
          break label142;
        }
        return;
        bool1 = false;
        break;
        ProfileCardUtil.a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gny
 * JD-Core Version:    0.7.0.1
 */