import com.tencent.biz.qqstory.base.ErrorMessage;

class unh<Request extends unk, Respond extends unf>
  implements unl<Respond>
{
  protected final long a;
  protected uni<Request, Respond> a;
  public Request a;
  
  public unh(Request paramRequest)
  {
    this.jdField_a_of_type_Unk = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    uni localuni = this.jdField_a_of_type_Uni;
    if (localuni != null)
    {
      localuni.a(this.jdField_a_of_type_Unk, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    wsv.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unh
 * JD-Core Version:    0.7.0.1
 */