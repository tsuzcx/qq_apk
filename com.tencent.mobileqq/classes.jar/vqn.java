import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class vqn
{
  public static volatile vqn a;
  
  public static vqn a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        vqn localvqn2 = a;
        localObject = localvqn2;
        if (localvqn2 == null)
        {
          localObject = new vqn();
          a = (vqn)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localvqn1;
  }
  
  public <Request extends vqr, Respond extends vqm> void a(Request paramRequest, vqp<Request, Respond> paramvqp)
  {
    paramRequest = new vqo(paramRequest);
    paramRequest.jdField_a_of_type_Vqp = paramvqp;
    paramRequest.jdField_a_of_type_Vqr.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Vqr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */