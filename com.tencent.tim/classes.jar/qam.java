import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qam
  extends ppu
{
  public List<ShareGroupItem> mQ = new ArrayList();
  
  public qam(qqstory_service.RspGetShareGroupInfo paramRspGetShareGroupInfo)
  {
    super(paramRspGetShareGroupInfo.result);
    if (paramRspGetShareGroupInfo.share_group_info_list.has())
    {
      paramRspGetShareGroupInfo = paramRspGetShareGroupInfo.share_group_info_list.get().iterator();
      while (paramRspGetShareGroupInfo.hasNext())
      {
        qqstory_struct.ShareGroupInfo localShareGroupInfo = (qqstory_struct.ShareGroupInfo)paramRspGetShareGroupInfo.next();
        ShareGroupItem localShareGroupItem = new ShareGroupItem();
        localShareGroupItem.convertFrom(localShareGroupInfo);
        this.mQ.add(localShareGroupItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetShareGroupInfoResponse{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + ", groupItems=" + this.mQ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qam
 * JD-Core Version:    0.7.0.1
 */