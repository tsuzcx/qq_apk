import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.1;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.2;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.3;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class izl
  extends iid
{
  public izl(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioMemberMicChanged-->uin=" + paramLong + ",isMicOff=" + paramBoolean);
    }
    GAudioMembersCtrlActivity.c(this.this$0, new GAudioMembersCtrlActivity.7.3(this, paramLong, paramInt1, paramInt2, paramBoolean));
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.this$0.mGroupId != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.this$0.mGroupId + " ,isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.this$0.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioRoomMicModeChanged-->uin=" + paramLong + ",isRoomMicOff=" + paramBoolean1);
    }
    GAudioMembersCtrlActivity.b(this.this$0, new GAudioMembersCtrlActivity.7.2(this));
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {}
    for (paramInt = 42;; paramInt = 43)
    {
      this.this$0.a(paramLong, 2, paramBoolean2, paramInt);
      return;
    }
  }
  
  protected void amB()
  {
    super.amB();
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onUpdatePstnInfo --> Start");
    }
    GAudioMembersCtrlActivity.a(this.this$0, new GAudioMembersCtrlActivity.7.1(this));
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.this$0.mGroupId != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.this$0.mGroupId + " ,isQQUser = " + paramBoolean);
      }
      return;
    }
    super.b(paramLong1, paramLong2, paramBoolean);
    this.this$0.a(paramLong2, 1, true, 71);
  }
  
  protected void bG(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onDestroyUI");
    }
    this.this$0.finish();
  }
  
  protected void by(ArrayList<ini> paramArrayList)
  {
    GAudioMembersCtrlActivity.d(this.this$0, new GAudioMembersCtrlActivity.7.4(this, paramArrayList));
  }
  
  protected void d(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.this$0.finish();
  }
  
  protected void m(long paramLong, boolean paramBoolean)
  {
    this.this$0.b.m(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izl
 * JD-Core Version:    0.7.0.1
 */