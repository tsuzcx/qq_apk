import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.10;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;

public class aawp
  extends SosoInterface.a
{
  public aawp(CreateFaceToFaceDiscussionActivity.10 param10, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt != 0) || (paramSosoLbsInfo == null))
    {
      paramSosoLbsInfo = this.a.this$0.mHandler.obtainMessage(2);
      paramSosoLbsInfo.arg1 = 1;
      paramSosoLbsInfo.arg2 = 2131701274;
      paramSosoLbsInfo.sendToTarget();
      return;
    }
    paramSosoLbsInfo = CreateFaceToFaceDiscussionActivity.a(this.a.this$0, paramSosoLbsInfo);
    achy localachy = (achy)this.a.this$0.app.getBusinessHandler(33);
    switch (this.a.PJ)
    {
    default: 
      return;
    case 0: 
      localachy.a(this.a.this$0.j.toString(), this.a.this$0.aea, paramSosoLbsInfo, this.a.this$0.TYPE_DISCUSS, this.a.this$0.cmn);
      return;
    case 1: 
      localachy.a(this.a.this$0.j.toString(), this.a.this$0.aea, paramSosoLbsInfo, 2, this.a.this$0.cmn);
      return;
    case 2: 
      localachy.a(this.a.this$0.j.toString(), this.a.this$0.aea, paramSosoLbsInfo, true);
      return;
    case 3: 
      localachy.a(this.a.this$0.j.toString(), this.a.this$0.aea, paramSosoLbsInfo, false);
      return;
    }
    localachy.a(this.a.this$0.j.toString(), this.a.this$0.aea, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawp
 * JD-Core Version:    0.7.0.1
 */