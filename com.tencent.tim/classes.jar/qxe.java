import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTodayStoryVidList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class qxe
  implements ppv.b<pyl, pzy>
{
  qxe(qxd paramqxd, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull pyl parampyl, @Nullable pzy parampzy, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$a != null) {
        this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$a.e(paramErrorMessage);
      }
      return;
    }
    if (parampzy == null)
    {
      this.jdField_a_of_type_Qxd.b.errorCode = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$b != null)
      {
        this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$b.si(this.jdField_a_of_type_Qxd.getKey());
        return;
      }
      ram.w("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    parampyl = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        parampyl.mergeFrom(parampzy.bytes);
        parampzy = parampyl.vid_list.get().listIterator();
        paramErrorMessage = parampyl.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Qxd.b.feedId = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Qxd.b;
        if (parampyl.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.aFS = bool;
          ((psr)psx.a(10)).n("qqstory_my_story_have_contributed", Integer.valueOf(parampyl.share_to_discover.get()));
          if (!parampzy.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Qxd.b.nq.add(((ByteStringMicro)parampzy.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException parampyl)
      {
        ram.e("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", parampyl);
        if (this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$b != null)
        {
          this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$b.si(this.jdField_a_of_type_Qxd.getKey());
          return;
        }
        ram.w("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!parampyl.is_end.has()) || (parampyl.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$b != null)
      {
        this.jdField_a_of_type_Qxd.jdField_a_of_type_Qxo$b.si(this.jdField_a_of_type_Qxd.getKey());
        return;
      }
      ram.w("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    parampzy = new qqstory_service.ReqTodayStoryVidList();
    parampzy.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    parampzy.cookie.set(parampyl.cookie.get());
    ppv.a().a(new pyl(this.aza, parampzy, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxe
 * JD-Core Version:    0.7.0.1
 */