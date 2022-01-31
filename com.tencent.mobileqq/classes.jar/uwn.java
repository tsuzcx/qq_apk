import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class uwn
  implements urr<vfa, vgy>
{
  uwn(uwm paramuwm, uxh paramuxh, boolean paramBoolean, long paramLong) {}
  
  public void a(vfa arg1, vgy paramvgy, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramvgy.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Uwm.a(???);
        this.jdField_a_of_type_Uxh.a = ???.qq;
        this.jdField_a_of_type_Uxh.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (uvt)uwa.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Uxh.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Uxh.b);
        }
      }
      wxe.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Uxh, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Uxh)
    {
      this.jdField_a_of_type_Uxh.notifyAll();
      return;
      wxe.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwn
 * JD-Core Version:    0.7.0.1
 */