import com.tencent.biz.qqstory.base.ErrorMessage;

class wlc<Request extends wlf, Respond extends wla>
  implements wlg<Respond>
{
  protected final long a;
  protected wld<Request, Respond> a;
  public Request a;
  
  public wlc(Request paramRequest)
  {
    this.jdField_a_of_type_Wlf = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    wld localwld = this.jdField_a_of_type_Wld;
    if (localwld != null)
    {
      localwld.a(this.jdField_a_of_type_Wlf, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    yqp.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlc
 * JD-Core Version:    0.7.0.1
 */