import android.os.Bundle;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1;
import com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tju
  extends tbe
{
  qqstory_group.RspGetGroupHotRankVideo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo;
  boolean jdField_a_of_type_Boolean = false;
  
  public tju(tjs paramtjs, qqstory_group.RspGetGroupHotRankVideo paramRspGetGroupHotRankVideo, boolean paramBoolean)
  {
    super(paramRspGetGroupHotRankVideo.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo = paramRspGetGroupHotRankVideo;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public tju(tjs paramtjs, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Tjs;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.is_end.get() == 1) {}
    tjv localtjv;
    for (boolean bool = true;; bool = false)
    {
      ((tjs)localObject).jdField_a_of_type_Boolean = bool;
      tjs.a(this.jdField_a_of_type_Tjs, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.next_cookie.get().toStringUtf8());
      tjs.a(this.jdField_a_of_type_Tjs, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.seq.get());
      localObject = new ArrayList();
      localtjv = new tjv();
      localtjv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Tjs.jdField_a_of_type_Boolean;
      localtjv.b = this.jdField_a_of_type_Boolean;
      if ((!this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.has()) || (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.size() <= 0)) {
        break label203;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.get().iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(HotSortVideoEntry.convertFrom((qqstory_group.HotVideoCard)localIterator.next()));
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.post(new GetHotSortVideoHandler.GetHotSortVideoResponse.1(this, (ArrayList)localObject, localtjv), 5, null, true);
      return;
      label203:
      veg.e("GetHotSortVideoHandler", "GetHotSortVideoResponse Success but video_card_list is empty。");
    }
    localtjv.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    ste.a().dispatch(localtjv);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = new tjv();
    paramBundle.c = true;
    ste.a().dispatch(paramBundle);
    bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131705259), 0).a();
    if (QLog.isColorLevel()) {
      QLog.e("GetHotSortVideoHandler", 2, "GetUserIconListResponse onNetError errorCode " + paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    tjv localtjv = new tjv();
    localtjv.c = true;
    ste.a().dispatch(localtjv);
    bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131705258), 0).a();
    if (QLog.isColorLevel()) {
      QLog.e("GetHotSortVideoHandler", 2, "GetUserIconListResponse errorCode:" + paramInt + " errorMsg:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tju
 * JD-Core Version:    0.7.0.1
 */