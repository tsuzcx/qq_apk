import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class vvk
  implements vqp<wdx, wfv>
{
  vvk(vvj paramvvj, vwe paramvwe, boolean paramBoolean, long paramLong) {}
  
  public void a(wdx arg1, wfv paramwfv, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramwfv.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Vvj.a(???);
        this.jdField_a_of_type_Vwe.a = ???.qq;
        this.jdField_a_of_type_Vwe.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (vuq)vux.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Vwe.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Vwe.b);
        }
      }
      xvv.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Vwe, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Vwe)
    {
      this.jdField_a_of_type_Vwe.notifyAll();
      return;
      xvv.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */