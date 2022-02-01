import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class wow
{
  public static volatile wow a;
  
  public static wow a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        wow localwow2 = a;
        localObject = localwow2;
        if (localwow2 == null)
        {
          localObject = new wow();
          a = (wow)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localwow1;
  }
  
  public <Request extends wpa, Respond extends wov> void a(Request paramRequest, woy<Request, Respond> paramwoy)
  {
    paramRequest = new wox(paramRequest);
    paramRequest.jdField_a_of_type_Woy = paramwoy;
    paramRequest.jdField_a_of_type_Wpa.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Wpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wow
 * JD-Core Version:    0.7.0.1
 */