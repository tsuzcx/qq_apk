import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;

public class jaa
  extends BroadcastReceiver
{
  public jaa(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l1 = paramIntent.getLongExtra("groupId", 0L);
    long l2 = paramIntent.getLongExtra("roomId", 0L);
    boolean bool;
    if ((this.this$0.mGroupId == l1) && (MultiIncomingCallsActivity.a(this.this$0) == l2)) {
      bool = true;
    }
    Object localObject;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=" + bool + ";current roomId=" + MultiIncomingCallsActivity.a(this.this$0) + ";groupId=" + this.this$0.mGroupId);
      }
      if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(paramContext)) {
        jjc.aH(paramIntent);
      }
      if ((paramContext.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate")) && (bool))
      {
        paramContext = new submsgtype0x116.MsgBody();
        try
        {
          paramContext.mergeFrom(paramIntent.getByteArrayExtra("pushData"));
          paramIntent = new HashSet();
          localObject = MultiIncomingCallsActivity.a(this.this$0).iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramIntent.add(Long.valueOf(((inx)((Iterator)localObject).next()).mUserUin));
            continue;
            bool = false;
          }
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          paramContext.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.TAG, 2, "mMemberChangeEventReceiver throw exception");
          }
        }
      }
    }
    int j;
    do
    {
      return;
      int n = paramContext.enum_event_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "mMemberChangeEventReceiver before totalCount:" + paramContext.uint32_invite_list_total_count.get() + ";currentInviteMembers=" + MultiIncomingCallsActivity.a(this.this$0).size() + ";eventType=" + paramContext.enum_event_type.get());
      }
      int i = 0;
      j = 0;
      if (j < paramContext.rpt_msg_member_join.size())
      {
        localObject = (submsgtype0x116.MemberInfo)paramContext.rpt_msg_member_join.get(j);
        l1 = ((submsgtype0x116.MemberInfo)localObject).uint64_member_uin.get();
        if ((l1 != this.this$0.mApp.getLongAccountUin()) && (l1 != this.this$0.mf)) {}
        for (int m = 1;; m = 0)
        {
          k = i;
          if (!paramIntent.contains(Long.valueOf(l1)))
          {
            k = i;
            if (m != 0)
            {
              MultiIncomingCallsActivity.a(this.this$0).add(new inx(((submsgtype0x116.MemberInfo)localObject).uint64_member_uin.get(), ((submsgtype0x116.MemberInfo)localObject).uint32_invite_timestamp.get()));
              i = 1;
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d(this.this$0.TAG, 2, "mMemberChangeEventReceiver add member UIN:" + l1);
                k = i;
              }
            }
          }
          j += 1;
          i = k;
          break;
        }
      }
      int k = 0;
      j = i;
      i = k;
      while (i < paramContext.rpt_msg_member_quit.size())
      {
        l1 = ((submsgtype0x116.MemberInfo)paramContext.rpt_msg_member_quit.get(i)).uint64_member_uin.get();
        paramIntent = MultiIncomingCallsActivity.a(this.this$0).iterator();
        do
        {
          k = j;
          if (!paramIntent.hasNext()) {
            break;
          }
          localObject = (inx)paramIntent.next();
        } while (((inx)localObject).mUserUin != l1);
        MultiIncomingCallsActivity.a(this.this$0).remove(localObject);
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "mMemberChangeEventReceiver remove member UIN:" + ((inx)localObject).mUserUin);
        }
        k = j;
        if (n != 2) {
          k = 1;
        }
        i += 1;
        j = k;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "mMemberChangeEventReceiver after totalCount:" + paramContext.uint32_invite_list_total_count.get() + ";currentInviteMembers=" + MultiIncomingCallsActivity.a(this.this$0).size() + ";eventType=" + paramContext.enum_event_type.get());
      }
    } while (j == 0);
    MultiIncomingCallsActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jaa
 * JD-Core Version:    0.7.0.1
 */