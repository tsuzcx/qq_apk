import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class wfi
{
  public static volatile wfi a;
  
  public static wfi a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        wfi localwfi2 = a;
        localObject = localwfi2;
        if (localwfi2 == null)
        {
          localObject = new wfi();
          a = (wfi)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localwfi1;
  }
  
  public <Request extends wfm, Respond extends wfh> void a(Request paramRequest, wfk<Request, Respond> paramwfk)
  {
    paramRequest = new wfj(paramRequest);
    paramRequest.jdField_a_of_type_Wfk = paramwfk;
    paramRequest.jdField_a_of_type_Wfm.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Wfm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfi
 * JD-Core Version:    0.7.0.1
 */