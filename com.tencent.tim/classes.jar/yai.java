import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class yai
  implements ardq.a<oidb_0x8ed.RspBody>
{
  yai(xzp paramxzp) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.this$0.bkT))
    {
      QQToast.a(this.this$0.mContext, 2, acfp.m(2131706817), 0).show();
      aqmj.o(this.this$0.a(), this.this$0.app.getCurrentAccountUin(), false);
      this.this$0.mGameRoomAVController.reset(this.this$0.mContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yai
 * JD-Core Version:    0.7.0.1
 */