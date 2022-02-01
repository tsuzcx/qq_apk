import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jei
  extends iid
{
  public jei(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void n(long paramLong, int paramInt)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onDestroyInviteUI, relationId[" + paramLong + "], seq[" + l + "]");
    }
    boolean bool = this.this$0.Td;
    if ((bool) && (this.this$0.mPeerUin != null) && (this.this$0.mPeerUin.equals(String.valueOf(paramLong))))
    {
      super.bG(paramLong);
      TraeHelper.t(this.this$0.mApp);
      this.this$0.dN(l);
      if ((bool) && (this.this$0.mPeerUin.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.this$0.mPeerUin).longValue();
        if (!this.this$0.Yn)
        {
          this.this$0.Yn = true;
          if (paramInt != 1) {
            break label255;
          }
          this.this$0.b().f(l, paramLong, 7);
        }
      }
    }
    for (;;)
    {
      this.this$0.Ox = true;
      if ((!this.this$0.mIsResume) || (this.this$0.a == null) || (this.this$0.wP())) {
        break;
      }
      this.this$0.a.a(new jej(this));
      return;
      label255:
      if (paramInt == 2) {
        this.this$0.b().f(l, paramLong, 2);
      }
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jei
 * JD-Core Version:    0.7.0.1
 */