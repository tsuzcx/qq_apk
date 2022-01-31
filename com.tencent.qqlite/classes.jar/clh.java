import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

class clh
  implements Runnable
{
  clh(clg paramclg) {}
  
  public void run()
  {
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a.a);
    ((NearFieldDiscussHandler)this.a.a.app.a(32)).a(this.a.a.a.toString(), this.a.a.b, localLBSInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clh
 * JD-Core Version:    0.7.0.1
 */