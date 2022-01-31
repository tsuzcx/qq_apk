import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uxr
{
  public int a;
  public List<String> a;
  public int b;
  public List<String> b;
  
  public uxr(qqstory_struct.VideoSpreadGroupList paramVideoSpreadGroupList)
  {
    if (paramVideoSpreadGroupList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramVideoSpreadGroupList.visibility_type.get();
      int k;
      int i;
      if ((paramVideoSpreadGroupList.group_list != null) && (paramVideoSpreadGroupList.group_list.has()))
      {
        k = paramVideoSpreadGroupList.group_list.size();
        this.jdField_a_of_type_JavaUtilList = new ArrayList(k);
        i = 0;
        while (i < k)
        {
          this.jdField_a_of_type_JavaUtilList.add(String.valueOf(((Long)paramVideoSpreadGroupList.group_list.get(i)).longValue()));
          i += 1;
        }
      }
      this.jdField_b_of_type_Int = paramVideoSpreadGroupList.visibility_sharegroup_type.get();
      if ((paramVideoSpreadGroupList.share_group_list != null) && (paramVideoSpreadGroupList.share_group_list.has()))
      {
        k = paramVideoSpreadGroupList.share_group_list.size();
        this.jdField_b_of_type_JavaUtilList = new ArrayList(k);
        i = j;
        while (i < k)
        {
          this.jdField_b_of_type_JavaUtilList.add(((ByteStringMicro)paramVideoSpreadGroupList.share_group_list.get(i)).toStringUtf8());
          i += 1;
        }
      }
    }
  }
  
  public uxr(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = 2;
  }
  
  public static boolean a(uxr paramuxr)
  {
    return (paramuxr == null) || (paramuxr.jdField_a_of_type_JavaUtilList == null) || (paramuxr.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public qqstory_struct.VideoSpreadGroupList a()
  {
    qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
    localVideoSpreadGroupList.setHasFlag(false);
    Iterator localIterator;
    String str;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localVideoSpreadGroupList.visibility_type.set(this.jdField_a_of_type_Int);
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localVideoSpreadGroupList.group_list.add(Long.valueOf(str));
      }
      localVideoSpreadGroupList.setHasFlag(true);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      localVideoSpreadGroupList.visibility_sharegroup_type.set(this.jdField_b_of_type_Int);
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(str));
      }
      localVideoSpreadGroupList.setHasFlag(true);
    }
    return localVideoSpreadGroupList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxr
 * JD-Core Version:    0.7.0.1
 */