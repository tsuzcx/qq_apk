import com.tribe.async.reactive.StreamFunction;

class wsc
  extends StreamFunction<wrs, wrs>
{
  int jdField_a_of_type_Int = 0;
  
  wsc(wrx paramwrx) {}
  
  protected void a(wrs paramwrs)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    yqp.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramwrs.a);
    notifyResult(paramwrs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsc
 * JD-Core Version:    0.7.0.1
 */