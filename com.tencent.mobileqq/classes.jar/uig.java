import android.os.Bundle;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoDelete;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

class uig
  extends mxh
{
  uig(uif paramuif) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_Uhw.l();
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_Uhw.jdField_b_of_type_JavaLangString, 2, "troop story delete result, code=" + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = this.a.jdField_a_of_type_Uhw.a.jdField_b_of_type_JavaLangString;
        Object localObject = new qqstory_group.RspGroupVideoDelete();
        ((qqstory_group.RspGroupVideoDelete)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)((qqstory_group.RspGroupVideoDelete)localObject).result.get();
        this.a.jdField_a_of_type_Uwd.a(paramBundle, 0, this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        this.a.jdField_a_of_type_Uwd.a(paramBundle, 1, this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        localObject = new tce(new ErrorMessage(), this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, false);
        ((tce)localObject).jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
        ((tce)localObject).d = paramBundle;
        ((tce)localObject).jdField_b_of_type_Boolean = false;
        ((tce)localObject).c = this.a.jdField_a_of_type_Uhw.b();
        ((tce)localObject).a = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
        if (((tce)localObject).a == 0L) {
          ((tce)localObject).a = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
        }
        Bosses.get().scheduleJobDelayed(new uih(this, this.a.jdField_a_of_type_Uhw.jdField_b_of_type_JavaLangString, (tce)localObject), 400);
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_Uhw.jdField_b_of_type_JavaLangString, 2, "parse RspGroupVideoDelete error", paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uig
 * JD-Core Version:    0.7.0.1
 */