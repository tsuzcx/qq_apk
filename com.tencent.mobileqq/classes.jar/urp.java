import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class urp
{
  public static volatile urp a;
  
  public static urp a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        urp localurp2 = a;
        localObject = localurp2;
        if (localurp2 == null)
        {
          localObject = new urp();
          a = (urp)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localurp1;
  }
  
  public <Request extends urt, Respond extends uro> void a(Request paramRequest, urr<Request, Respond> paramurr)
  {
    paramRequest = new urq(paramRequest);
    paramRequest.jdField_a_of_type_Urr = paramurr;
    paramRequest.jdField_a_of_type_Urt.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Urt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urp
 * JD-Core Version:    0.7.0.1
 */