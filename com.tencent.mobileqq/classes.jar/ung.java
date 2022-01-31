import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class ung
{
  public static volatile ung a;
  
  public static ung a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        ung localung2 = a;
        localObject = localung2;
        if (localung2 == null)
        {
          localObject = new ung();
          a = (ung)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localung1;
  }
  
  public <Request extends unk, Respond extends unf> void a(Request paramRequest, uni<Request, Respond> paramuni)
  {
    paramRequest = new unh(paramRequest);
    paramRequest.jdField_a_of_type_Uni = paramuni;
    paramRequest.jdField_a_of_type_Unk.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Unk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ung
 * JD-Core Version:    0.7.0.1
 */