import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class wtu
  implements woy<xch, xef>
{
  wtu(wtt paramwtt, wuo paramwuo, boolean paramBoolean, long paramLong) {}
  
  public void a(xch arg1, xef paramxef, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramxef.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Wtt.a(???);
        this.jdField_a_of_type_Wuo.a = ???.qq;
        this.jdField_a_of_type_Wuo.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (wta)wth.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Wuo.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Wuo.b);
        }
      }
      yuk.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Wuo, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Wuo)
    {
      this.jdField_a_of_type_Wuo.notifyAll();
      return;
      yuk.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtu
 * JD-Core Version:    0.7.0.1
 */