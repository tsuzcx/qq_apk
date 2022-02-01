import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;

public class jbg
  extends BroadcastReceiver
{
  public jbg(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l1 = paramIntent.getLongExtra("groupId", 0L);
    long l2 = paramIntent.getLongExtra("roomId", 0L);
    long l3 = this.this$0.a.bw();
    int i;
    int j;
    label61:
    String str;
    StringBuilder localStringBuilder;
    if (this.this$0.md == l1)
    {
      i = 1;
      if (l3 != l2) {
        break label231;
      }
      j = 1;
      if (QLog.isColorLevel())
      {
        str = this.this$0.TAG;
        localStringBuilder = new StringBuilder().append("handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=");
        if ((i == 0) || (j == 0)) {
          break label237;
        }
      }
    }
    label231:
    label237:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + ";current roomId=" + l3 + ";groupId=" + this.this$0.md);
      if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(paramContext)) {
        jjc.aH(paramIntent);
      }
      if ((paramContext.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate")) && (i != 0) && (j != 0)) {
        paramContext = new submsgtype0x116.MsgBody();
      }
      try
      {
        paramContext.mergeFrom(paramIntent.getByteArrayExtra("pushData"));
        this.this$0.a.a(paramContext.rpt_msg_member_join, paramContext.rpt_msg_member_quit, paramContext.uint32_invite_list_total_count.get(), paramContext.enum_event_type.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramContext)
      {
        do
        {
          paramContext.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d(this.this$0.TAG, 2, "mMemberChangeEventReceiver throw exception");
      }
      i = 0;
      break;
      j = 0;
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbg
 * JD-Core Version:    0.7.0.1
 */