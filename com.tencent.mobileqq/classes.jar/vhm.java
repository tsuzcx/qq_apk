import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vhm
  extends uro
{
  public List<ShareGroupItem> a;
  
  public vhm(qqstory_service.RspGetShareGroupInfo paramRspGetShareGroupInfo)
  {
    super(paramRspGetShareGroupInfo.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramRspGetShareGroupInfo.share_group_info_list.has())
    {
      paramRspGetShareGroupInfo = paramRspGetShareGroupInfo.share_group_info_list.get().iterator();
      while (paramRspGetShareGroupInfo.hasNext())
      {
        qqstory_struct.ShareGroupInfo localShareGroupInfo = (qqstory_struct.ShareGroupInfo)paramRspGetShareGroupInfo.next();
        ShareGroupItem localShareGroupItem = new ShareGroupItem();
        localShareGroupItem.convertFrom(localShareGroupInfo);
        this.jdField_a_of_type_JavaUtilList.add(localShareGroupItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetShareGroupInfoResponse{errorCode=" + this.jdField_a_of_type_Int + ", errorMsg='" + this.b + '\'' + ", groupItems=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vhm
 * JD-Core Version:    0.7.0.1
 */