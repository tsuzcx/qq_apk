import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class wmp
  implements wfk<wne, wnf>
{
  wmp(wmo paramwmo, wly paramwly) {}
  
  public void a(@NonNull wne paramwne, @Nullable wnf paramwnf, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwnf == null) || (paramErrorMessage.isFail()))
    {
      ykq.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Wly);
      wmo.a(this.jdField_a_of_type_Wmo, paramErrorMessage);
      return;
    }
    if (paramwnf.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Wly.jdField_a_of_type_Int != 5)
      {
        ykq.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Wly + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        wmo.b(this.jdField_a_of_type_Wmo, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      wmo.a(this.jdField_a_of_type_Wmo, wmo.a(paramwnf.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Wly);
    }
    wmr.a(this.jdField_a_of_type_Wly, paramwnf.jdField_a_of_type_ArrayOfByte);
    paramwne = wmo.a(paramwnf.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Wly.jdField_a_of_type_Int == 12) {}
    wmo.b(this.jdField_a_of_type_Wmo, paramwne);
    if (this.jdField_a_of_type_Wly.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Wmo.a != null)
      {
        this.jdField_a_of_type_Wmo.a.c = paramwnf.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramwne = this.jdField_a_of_type_Wmo.a;
        if (paramwnf.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramwne.a = bool;
      this.jdField_a_of_type_Wly.i = paramwnf.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      ykq.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Wly.jdField_a_of_type_JavaLangString, paramwnf.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */