import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public class apqs
  extends apsy
{
  apqs(apqk paramapqk, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, List paramList1, boolean paramBoolean, List paramList2, String paramString) {}
  
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
        this.Ih.remove(this.a);
        if (this.aTe)
        {
          this.this$0.a(this.a, false);
          if ((this.Ih.isEmpty()) && (this.Ii != null)) {
            Collections.sort(this.Ii, this.this$0.ah);
          }
        }
        this.this$0.playState = 1;
        this.this$0.Sa(this.aTe);
      }
      for (;;)
      {
        this.this$0.mApp.getEntityManagerFactory().createEntityManager().update(this.a);
        return;
        this.this$0.ebr();
        this.this$0.playState = 2;
        if ((this.aTe) && (this.Ii != null)) {
          this.Ii.clear();
        }
        if (this.this$0.mBaseChatPie != null)
        {
          this.Ih.remove(this.a);
          this.this$0.a.a(this.a, this.cqu, true, new apqt(this));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOAnimationControlManager", 2, "checkInteract errorCode: " + paramInt);
    }
    this.Ih.remove(this.a);
    if (!this.aTe)
    {
      this.this$0.a(this.a, false);
      if (this.Ih.isEmpty()) {
        Collections.sort(this.Ii, this.this$0.ah);
      }
    }
    this.this$0.playState = 1;
    this.this$0.Sa(this.aTe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqs
 * JD-Core Version:    0.7.0.1
 */