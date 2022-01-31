import com.tencent.biz.qqstory.base.ErrorMessage;

class urq<Request extends urt, Respond extends uro>
  implements uru<Respond>
{
  protected final long a;
  protected urr<Request, Respond> a;
  public Request a;
  
  public urq(Request paramRequest)
  {
    this.jdField_a_of_type_Urt = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    urr localurr = this.jdField_a_of_type_Urr;
    if (localurr != null)
    {
      localurr.a(this.jdField_a_of_type_Urt, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    wxe.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urq
 * JD-Core Version:    0.7.0.1
 */