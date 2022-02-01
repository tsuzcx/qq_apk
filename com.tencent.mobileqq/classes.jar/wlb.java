import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class wlb
{
  public static volatile wlb a;
  
  public static wlb a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        wlb localwlb2 = a;
        localObject = localwlb2;
        if (localwlb2 == null)
        {
          localObject = new wlb();
          a = (wlb)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localwlb1;
  }
  
  public <Request extends wlf, Respond extends wla> void a(Request paramRequest, wld<Request, Respond> paramwld)
  {
    paramRequest = new wlc(paramRequest);
    paramRequest.jdField_a_of_type_Wld = paramwld;
    paramRequest.jdField_a_of_type_Wlf.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Wlf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlb
 * JD-Core Version:    0.7.0.1
 */