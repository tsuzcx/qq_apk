import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.b;
import com.tencent.qphone.base.util.QLog;

class mwk
  implements RIJRedPacketManager.b
{
  mwk(mwj parammwj, VideoInfo paramVideoInfo) {}
  
  public void p(boolean paramBoolean, String paramString)
  {
    if ((this.a == mwj.a(this.this$0)) && (paramBoolean) && (!mwj.a(this.this$0).adI)) {}
    for (boolean bool = true;; bool = false)
    {
      this.a.adI = paramBoolean;
      this.a.WF = paramString;
      this.a.adK = this.this$0.k(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRedPacketShareController", 2, "hasSharePacketCallback: title=" + this.a.title + ", changed=" + bool + ", permission=" + paramBoolean + ", redPacketId=" + paramString);
      }
      if (bool)
      {
        this.this$0.H(this.a);
        if (mwj.a(this.this$0) != null) {
          mwj.a(this.this$0).D(this.a);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwk
 * JD-Core Version:    0.7.0.1
 */