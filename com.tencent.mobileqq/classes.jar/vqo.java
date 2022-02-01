import com.tencent.biz.qqstory.base.ErrorMessage;

class vqo<Request extends vqr, Respond extends vqm>
  implements vqs<Respond>
{
  protected final long a;
  protected vqp<Request, Respond> a;
  public Request a;
  
  public vqo(Request paramRequest)
  {
    this.jdField_a_of_type_Vqr = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    vqp localvqp = this.jdField_a_of_type_Vqp;
    if (localvqp != null)
    {
      localvqp.a(this.jdField_a_of_type_Vqr, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    xvv.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqo
 * JD-Core Version:    0.7.0.1
 */