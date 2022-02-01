import com.tribe.async.reactive.StreamFunction;

class vxn
  extends StreamFunction<vxd, vxd>
{
  int jdField_a_of_type_Int = 0;
  
  vxn(vxi paramvxi) {}
  
  protected void a(vxd paramvxd)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    xvv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramvxd.a);
    notifyResult(paramvxd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxn
 * JD-Core Version:    0.7.0.1
 */