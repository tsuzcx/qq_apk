import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

public class euc
  implements Runnable
{
  public euc(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void run()
  {
    NearFieldDiscussHandler localNearFieldDiscussHandler = (NearFieldDiscussHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a);
    localNearFieldDiscussHandler.c(this.a.a.toString(), this.a.jdField_b_of_type_Int, localLBSInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     euc
 * JD-Core Version:    0.7.0.1
 */