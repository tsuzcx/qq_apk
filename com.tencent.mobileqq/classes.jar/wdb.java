import com.tencent.biz.qqstory.base.ErrorMessage;

class wdb
  implements wnk<Integer>
{
  wdb(wcy paramwcy, urk paramurk) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    wsv.e("QQStoryTakeVideoHelper", "get vip error.");
  }
  
  public void a(Integer paramInteger)
  {
    wsv.b("QQStoryTakeVideoHelper", "get vip competed, vip:" + paramInteger);
    this.jdField_a_of_type_Urk.b("qqstory_i_am_vip", paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdb
 * JD-Core Version:    0.7.0.1
 */