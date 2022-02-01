import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jbi
  implements jka
{
  public jbi(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  private void atr()
  {
    AVActivity localAVActivity = (AVActivity)this.this$0.mContext.get();
    if (localAVActivity != null) {
      if ((this.this$0.a.b().QO) || (this.this$0.a.b().QP))
      {
        bool = true;
        VideoMsgTools.a(localAVActivity, String.valueOf(this.this$0.a.b().ll), bool, true);
        anot.a(null, "CliOper", "", "", "0X8009E27", "0X8009E27", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    QLog.e(this.this$0.TAG, 2, "startMembersListViewPage-->can not get activity");
  }
  
  public void atq()
  {
    long l = AudioHelper.hG();
    this.this$0.dE(l);
  }
  
  public void d(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 7) && (paramBoolean)) {
      atr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbi
 * JD-Core Version:    0.7.0.1
 */