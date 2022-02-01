import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.2.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public class apqp
  extends apsy
{
  apqp(apqk paramapqk, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      this.a.interactState = paramRspBody.uint32_play_state.get();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "checkInteract interactId: " + this.a.interactId + ", interactState: " + this.a.interactState);
      }
      this.a.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
      this.a.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
      if ((this.a.interactState == 2) && (paramRspBody.msg_finish_info.has()))
      {
        paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
        this.a.interactText = paramRspBody.bytes_text.get().toStringUtf8();
        this.a.participateNum = paramRspBody.uint32_participate_num.get();
        this.a.interactFirstUin = paramRspBody.uint64_first_uin.get();
        this.a.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
        this.a.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
        this.this$0.mApp.getEntityManagerFactory().createEntityManager().update(this.a);
      }
    }
    for (;;)
    {
      this.this$0.mHandler.post(new AIOAnimationControlManager.2.1(this));
      return;
      List localList = (List)this.this$0.oq.get(this.a.frienduin);
      paramRspBody = localList;
      if (localList == null)
      {
        paramRspBody = new ArrayList();
        this.this$0.oq.put(this.a.frienduin, paramRspBody);
      }
      try
      {
        if (!paramRspBody.contains(this.a))
        {
          paramRspBody.add(this.a);
          if (paramRspBody.size() > 5) {
            paramRspBody.remove(0);
          }
        }
        paramRspBody = (List)this.this$0.op.get(this.a.frienduin);
        if (paramRspBody == null) {}
      }
      finally
      {
        try
        {
          paramRspBody.remove(this.a);
          if (!this.bER) {
            break;
          }
          apqk.b(this.this$0);
          this.this$0.notifyObservers(this.a);
          break;
        }
        finally {}
        localObject1 = finally;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AIOAnimationControlManager", 2, "checkInteract errorCode: " + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqp
 * JD-Core Version:    0.7.0.1
 */