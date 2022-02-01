import com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class zld
{
  public final int a;
  public final String a;
  public final boolean a;
  public final String b;
  public final String c;
  public final String d;
  
  public zld(qqstory_struct.CompInfoBase paramCompInfoBase)
  {
    this.jdField_a_of_type_JavaLangString = paramCompInfoBase.title.get();
    this.b = paramCompInfoBase.backgroud_url.get();
    this.c = paramCompInfoBase.compared_vid.get();
    if (paramCompInfoBase.is_compared_able.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.d = paramCompInfoBase.icon_url.get();
      this.jdField_a_of_type_Int = paramCompInfoBase.oa_task_id.get();
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "CompInfoBase{title='" + this.jdField_a_of_type_JavaLangString + '\'' + ", linkUrl='" + this.b + '\'' + ", comparedVid='" + this.c + '\'' + ", isComparedAble=" + this.jdField_a_of_type_Boolean + ", iconUrl='" + this.d + '\'' + ", taskId=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zld
 * JD-Core Version:    0.7.0.1
 */