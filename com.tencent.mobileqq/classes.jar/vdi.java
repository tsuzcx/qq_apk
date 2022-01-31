import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vdi
  extends unf
{
  public final String a;
  public final List<xjv> a;
  public final int b;
  
  public vdi(qqstory_service.RspGetTagList paramRspGetTagList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject = paramRspGetTagList.tag_list.get();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        qqstory_struct.TagItem localTagItem = (qqstory_struct.TagItem)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilList.add(new xjv(localTagItem));
      }
    }
    this.b = paramRspGetTagList.is_end.get();
    this.jdField_a_of_type_JavaLangString = paramRspGetTagList.next_cookie.get();
  }
  
  public String toString()
  {
    return "GetTagListResponse{mTagItems=" + this.jdField_a_of_type_JavaUtilList + ", mIsEnd=" + this.b + ", mNextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */