import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

public class eud
  implements Runnable
{
  public eud(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void run()
  {
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a);
    ((NearFieldDiscussHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(40)).b(this.a.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.jdField_b_of_type_Int, localLBSInfo);
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eud
 * JD-Core Version:    0.7.0.1
 */