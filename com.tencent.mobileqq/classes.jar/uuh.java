import com.tribe.async.reactive.StreamFunction;

class uuh
  extends StreamFunction<utx, utx>
{
  int jdField_a_of_type_Int = 0;
  
  uuh(uuc paramuuc) {}
  
  protected void a(utx paramutx)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramutx.a);
    notifyResult(paramutx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuh
 * JD-Core Version:    0.7.0.1
 */