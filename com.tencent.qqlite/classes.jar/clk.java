import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

public class clk
  implements Runnable
{
  public clk(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void run()
  {
    NearFieldDiscussHandler localNearFieldDiscussHandler = (NearFieldDiscussHandler)this.a.app.a(32);
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a);
    localNearFieldDiscussHandler.b(this.a.a.toString(), this.a.b, localLBSInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clk
 * JD-Core Version:    0.7.0.1
 */