import android.text.TextUtils;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class izw
  extends iid
{
  public izw(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void bJ(long paramLong)
  {
    this.this$0.kd("notifyCloseAllGroupVideoInviteMsgBox");
    this.this$0.finish();
  }
  
  protected void bK(long paramLong)
  {
    if (this.this$0.mGroupId == paramLong)
    {
      this.this$0.kd("notifyCloseGroupVideoInviteMsgBox");
      this.this$0.finish();
    }
  }
  
  protected void d(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.this$0.mf + ", mGroupId:" + this.this$0.mGroupId);
    }
    if ((paramLong2 == this.this$0.mf) && (paramLong1 == this.this$0.mGroupId)) {
      this.this$0.finish();
    }
  }
  
  protected void l(long paramLong, String paramString)
  {
    if ((this.this$0.mGroupId == paramLong) && (this.this$0.OG.equals(paramString))) {
      this.this$0.finish();
    }
  }
  
  protected void n(long paramLong, int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(this.this$0.TAG, 1, "onDestroyInviteUI, groupId[" + paramLong + "], reason[" + paramInt + "], mIsDoubleVideoMeeting[" + this.this$0.Td + "], mPeerUin[" + this.this$0.mPeerUin + "], mGroupId[" + this.this$0.mGroupId + "], seq[" + l + "]");
    if (this.this$0.Td) {
      if (TextUtils.equals(this.this$0.mPeerUin, String.valueOf(paramLong)))
      {
        this.this$0.kd("onDestroyInviteUI_DoubleVideoMeeting");
        this.this$0.H(l, paramInt);
      }
    }
    while ((this.this$0.mGroupId != paramLong) && (0L != paramLong)) {
      return;
    }
    this.this$0.kd("onDestroyInviteUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izw
 * JD-Core Version:    0.7.0.1
 */