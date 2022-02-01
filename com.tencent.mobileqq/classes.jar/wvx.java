import com.tribe.async.reactive.StreamFunction;

class wvx
  extends StreamFunction<wvn, wvn>
{
  int jdField_a_of_type_Int = 0;
  
  wvx(wvs paramwvs) {}
  
  protected void a(wvn paramwvn)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramwvn.a);
    notifyResult(paramwvn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvx
 * JD-Core Version:    0.7.0.1
 */