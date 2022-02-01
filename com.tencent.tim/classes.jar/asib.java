import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qidian.proto.mobileqq_qidian.GroupItem;

public class asib
{
  public int level;
  public long mN;
  public String name;
  
  public asib() {}
  
  public asib(mobileqq_qidian.GroupItem paramGroupItem)
  {
    a(paramGroupItem);
  }
  
  public mobileqq_qidian.GroupItem a()
  {
    mobileqq_qidian.GroupItem localGroupItem = new mobileqq_qidian.GroupItem();
    localGroupItem.uint64_groupid.set(this.mN);
    localGroupItem.uint32_group_level.set(this.level);
    localGroupItem.str_group_name.set(this.name);
    return localGroupItem;
  }
  
  public void a(mobileqq_qidian.GroupItem paramGroupItem)
  {
    if (paramGroupItem.uint64_groupid.has()) {
      this.mN = paramGroupItem.uint64_groupid.get();
    }
    if (paramGroupItem.uint32_group_level.has()) {
      this.level = paramGroupItem.uint32_group_level.get();
    }
    if (paramGroupItem.str_group_name.has()) {
      this.name = paramGroupItem.str_group_name.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asib
 * JD-Core Version:    0.7.0.1
 */