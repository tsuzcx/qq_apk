import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class wpz
  implements wld<wym, xak>
{
  wpz(wpy paramwpy, wqt paramwqt, boolean paramBoolean, long paramLong) {}
  
  public void a(wym arg1, xak paramxak, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramxak.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Wpy.a(???);
        this.jdField_a_of_type_Wqt.a = ???.qq;
        this.jdField_a_of_type_Wqt.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (wpf)wpm.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Wqt.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Wqt.b);
        }
      }
      yqp.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Wqt, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Wqt)
    {
      this.jdField_a_of_type_Wqt.notifyAll();
      return;
      yqp.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpz
 * JD-Core Version:    0.7.0.1
 */