import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class wkf
  implements wfk<wss, wuq>
{
  wkf(wke paramwke, wkz paramwkz, boolean paramBoolean, long paramLong) {}
  
  public void a(wss arg1, wuq paramwuq, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramwuq.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Wke.a(???);
        this.jdField_a_of_type_Wkz.a = ???.qq;
        this.jdField_a_of_type_Wkz.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (wjl)wjs.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Wkz.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Wkz.b);
        }
      }
      ykq.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Wkz, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Wkz)
    {
      this.jdField_a_of_type_Wkz.notifyAll();
      return;
      ykq.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkf
 * JD-Core Version:    0.7.0.1
 */