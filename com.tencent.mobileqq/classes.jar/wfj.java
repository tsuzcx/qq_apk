import com.tencent.biz.qqstory.base.ErrorMessage;

class wfj<Request extends wfm, Respond extends wfh>
  implements wfn<Respond>
{
  protected final long a;
  protected wfk<Request, Respond> a;
  public Request a;
  
  public wfj(Request paramRequest)
  {
    this.jdField_a_of_type_Wfm = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    wfk localwfk = this.jdField_a_of_type_Wfk;
    if (localwfk != null)
    {
      localwfk.a(this.jdField_a_of_type_Wfm, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    ykq.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfj
 * JD-Core Version:    0.7.0.1
 */