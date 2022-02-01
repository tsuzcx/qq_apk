import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

class epk
  implements Runnable
{
  epk(epj paramepj) {}
  
  public void run()
  {
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a.a);
    ((NearFieldDiscussHandler)this.a.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(40)).b(this.a.a.a.toString(), this.a.a.jdField_b_of_type_Int, localLBSInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epk
 * JD-Core Version:    0.7.0.1
 */