import android.os.Bundle;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoDelete;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

class xyn
  extends nko
{
  xyn(xym paramxym) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_Xyd.l();
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_Xyd.jdField_b_of_type_JavaLangString, 2, "troop story delete result, code=" + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = this.a.jdField_a_of_type_Xyd.a.jdField_b_of_type_JavaLangString;
        Object localObject = new qqstory_group.RspGroupVideoDelete();
        ((qqstory_group.RspGroupVideoDelete)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)((qqstory_group.RspGroupVideoDelete)localObject).result.get();
        this.a.jdField_a_of_type_Ymk.a(paramBundle, 0, this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        this.a.jdField_a_of_type_Ymk.a(paramBundle, 1, this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        localObject = new wsm(new ErrorMessage(), this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, false);
        ((wsm)localObject).jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
        ((wsm)localObject).d = paramBundle;
        ((wsm)localObject).jdField_b_of_type_Boolean = false;
        ((wsm)localObject).c = this.a.jdField_a_of_type_Xyd.b();
        ((wsm)localObject).a = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
        if (((wsm)localObject).a == 0L) {
          ((wsm)localObject).a = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
        }
        Bosses.get().scheduleJobDelayed(new xyo(this, this.a.jdField_a_of_type_Xyd.jdField_b_of_type_JavaLangString, (wsm)localObject), 400);
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_Xyd.jdField_b_of_type_JavaLangString, 2, "parse RspGroupVideoDelete error", paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyn
 * JD-Core Version:    0.7.0.1
 */