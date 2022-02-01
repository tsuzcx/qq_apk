import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteFloatBarUICtr.3.1;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class jex
  extends iid
{
  jex(jeu paramjeu) {}
  
  protected void b(long paramLong, ArrayList<VideoController.b> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.b)paramArrayList.next()).uin).equalsIgnoreCase(this.this$0.mApp.getAccount())) {
        this.this$0.onDestroy();
      }
    }
  }
  
  protected void bJ(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->notifyByGroupId=" + paramLong);
    }
    if (this.this$0.mGroupId != paramLong) {}
    this.this$0.onDestroy();
  }
  
  protected void bK(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->groupId=" + paramLong);
    }
    if (this.this$0.mGroupId == paramLong) {
      this.this$0.onDestroy();
    }
  }
  
  protected void d(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr.troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.this$0.mf + ", mGroupId:" + this.this$0.mGroupId);
    }
    if ((paramLong2 == this.this$0.mf) && (paramLong1 == this.this$0.mGroupId)) {
      this.this$0.onDestroy();
    }
  }
  
  protected void l(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->groupId=" + paramLong);
    }
    if ((this.this$0.mGroupId == paramLong) && (this.this$0.OG.equals(paramString))) {
      this.this$0.onDestroy();
    }
  }
  
  protected void n(long paramLong, int paramInt)
  {
    super.bG(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onDestroyInviteUI-->reason=" + paramInt);
    }
    if ((this.this$0.mGroupId == paramLong) || (0L == paramLong)) {
      this.this$0.onDestroy();
    }
  }
  
  protected void onServiceConnected()
  {
    super.onServiceConnected();
    this.this$0.jw(false);
  }
  
  protected void y(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.this$0.e.QX = true;
    if (this.this$0.mUinType == 1) {
      this.this$0.mApp.ak(paramLong2);
    }
  }
  
  protected void z(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoInviteFloatBarUICtr", 1, "onEnterRoomSuc, groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    this.this$0.mApp.getHandler().postDelayed(new VideoInviteFloatBarUICtr.3.1(this, paramLong2), 500L);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.alx();
    ivm.a(this.this$0.mApp).x(paramLong1, false);
    if (this.this$0.jdField_a_of_type_Jet != null) {
      this.this$0.jdField_a_of_type_Jet.avn();
    }
    TraeHelper.a().startService(this.this$0.QK);
    this.this$0.mApp.getHandler().postDelayed(this.this$0.bf, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jex
 * JD-Core Version:    0.7.0.1
 */