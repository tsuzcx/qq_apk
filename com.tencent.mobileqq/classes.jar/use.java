import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class use
  implements uni<var, vcp>
{
  use(usd paramusd, usy paramusy, boolean paramBoolean, long paramLong) {}
  
  public void a(var arg1, vcp paramvcp, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramvcp.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Usd.a(???);
        this.jdField_a_of_type_Usy.a = ???.qq;
        this.jdField_a_of_type_Usy.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (urk)urr.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Usy.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Usy.b);
        }
      }
      wsv.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Usy, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Usy)
    {
      this.jdField_a_of_type_Usy.notifyAll();
      return;
      wsv.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     use
 * JD-Core Version:    0.7.0.1
 */