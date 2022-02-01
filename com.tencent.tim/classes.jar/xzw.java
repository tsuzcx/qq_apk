import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class xzw
  extends arec
{
  xzw(xzp paramxzp) {}
  
  public void DC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onDownLoadedPluginResult result = " + paramInt);
    }
    if (paramInt == 0) {
      this.this$0.initPlugin();
    }
    do
    {
      return;
      QQToast.a(this.this$0.a(), acfp.m(2131706801), 0).show();
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
  }
  
  public void h(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onNotifyGameRoomSpeakerStatus uin = " + paramLong2 + " isSeaking = " + paramBoolean);
    }
    if ((!this.this$0.sessionInfo.aTl.equals(String.valueOf(paramLong1))) || (this.this$0.jdField_a_of_type_Aree == null)) {}
    ared localared;
    do
    {
      return;
      localared = this.this$0.jdField_a_of_type_Aree.a();
    } while (localared == null);
    localared.dr(String.valueOf(paramLong2), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzw
 * JD-Core Version:    0.7.0.1
 */