import com.tribe.async.reactive.StreamFunction;

class wmi
  extends StreamFunction<wly, wly>
{
  int jdField_a_of_type_Int = 0;
  
  wmi(wmd paramwmd) {}
  
  protected void a(wly paramwly)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramwly.a);
    notifyResult(paramwly);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */