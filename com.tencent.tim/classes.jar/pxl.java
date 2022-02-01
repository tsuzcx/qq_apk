import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1;
import com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupHotRankVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pxl
{
  private String mCookie;
  private String mGroupId;
  public boolean mIsEnd;
  private long mSeq;
  
  public pxl(String paramString)
  {
    this.mGroupId = paramString;
  }
  
  public void bny()
  {
    pxl.a locala = new pxl.a(false);
    pxl.b localb = new pxl.b(false);
    pri.a().a(locala, localb);
  }
  
  public void bnz()
  {
    pxl.a locala = new pxl.a(true);
    pxl.b localb = new pxl.b(true);
    pri.a().a(locala, localb);
  }
  
  public class a
    extends prk
  {
    boolean aCA = false;
    
    public a(boolean paramBoolean)
    {
      this.aCA = paramBoolean;
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_group.RspGetGroupHotRankVideo localRspGetGroupHotRankVideo = new qqstory_group.RspGetGroupHotRankVideo();
      try
      {
        localRspGetGroupHotRankVideo.mergeFrom(paramArrayOfByte);
        return new pxl.b(pxl.this, localRspGetGroupHotRankVideo, this.aCA);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("GetHotSortVideoHandler", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_group.ReqGetGroupHotRankVideo localReqGetGroupHotRankVideo = new qqstory_group.ReqGetGroupHotRankVideo();
      localReqGetGroupHotRankVideo.union_id.set(ByteStringMicro.copyFromUtf8(pxl.a(pxl.this)));
      localReqGetGroupHotRankVideo.size.set(10);
      if (this.aCA)
      {
        localReqGetGroupHotRankVideo.seq.set(pxl.a(pxl.this));
        if (!TextUtils.isEmpty(pxl.b(pxl.this))) {
          localReqGetGroupHotRankVideo.start_cookie.set(ByteStringMicro.copyFromUtf8(pxl.b(pxl.this)));
        }
      }
      return localReqGetGroupHotRankVideo.toByteArray();
    }
    
    public String mg()
    {
      return ppf.fQ("StoryGroupSvc.get_hot_rank_video_list");
    }
  }
  
  public class b
    extends prl
  {
    qqstory_group.RspGetGroupHotRankVideo a;
    boolean aCA = false;
    
    public b(qqstory_group.RspGetGroupHotRankVideo paramRspGetGroupHotRankVideo, boolean paramBoolean)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo = paramRspGetGroupHotRankVideo;
      this.aCA = paramBoolean;
    }
    
    public b(boolean paramBoolean)
    {
      this.aCA = paramBoolean;
    }
    
    public void aJ(int paramInt, String paramString)
    {
      pxl.c localc = new pxl.c();
      localc.isError = true;
      pmi.a().dispatch(localc);
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706955), 0).show();
      if (QLog.isColorLevel()) {
        QLog.e("GetHotSortVideoHandler", 2, "GetUserIconListResponse errorCode:" + paramInt + " errorMsg:" + paramString);
      }
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      paramBundle = new pxl.c();
      paramBundle.isError = true;
      pmi.a().dispatch(paramBundle);
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706956), 0).show();
      if (QLog.isColorLevel()) {
        QLog.e("GetHotSortVideoHandler", 2, "GetUserIconListResponse onNetError errorCode " + paramInt);
      }
    }
    
    public void onSuccess()
    {
      Object localObject = this.jdField_a_of_type_Pxl;
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.is_end.get() == 1) {}
      pxl.c localc;
      for (boolean bool = true;; bool = false)
      {
        ((pxl)localObject).mIsEnd = bool;
        pxl.a(this.jdField_a_of_type_Pxl, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.next_cookie.get().toStringUtf8());
        pxl.a(this.jdField_a_of_type_Pxl, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.seq.get());
        localObject = new ArrayList();
        localc = new pxl.c();
        localc.isEnd = this.jdField_a_of_type_Pxl.mIsEnd;
        localc.aCA = this.aCA;
        if ((!this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.has()) || (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.size() <= 0)) {
          break label203;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.get().iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject).add(HotSortVideoEntry.convertFrom((qqstory_group.HotVideoCard)localIterator.next()));
        }
      }
      if (!this.aCA)
      {
        ThreadManager.post(new GetHotSortVideoHandler.GetHotSortVideoResponse.1(this, (ArrayList)localObject, localc), 5, null, true);
        return;
        label203:
        ram.e("GetHotSortVideoHandler", "GetHotSortVideoResponse Success but video_card_list is empty。");
      }
      localc.list = ((ArrayList)localObject);
      pmi.a().dispatch(localc);
    }
  }
  
  public static class c
    extends plt
  {
    public boolean aCA;
    public boolean isEnd;
    public boolean isError;
    public ArrayList<HotSortVideoEntry> list;
    
    public String toString()
    {
      return " GetVideoByHotSortEvent " + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxl
 * JD-Core Version:    0.7.0.1
 */