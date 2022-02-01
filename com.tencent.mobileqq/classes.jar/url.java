import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class url
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static url a()
  {
    return urn.a();
  }
  
  private void a(uju paramuju, ure paramure)
  {
    boolean bool = true;
    if (!paramuju.a())
    {
      upe.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] failed code:" + paramuju.jdField_a_of_type_Int + ", msg:" + paramuju.jdField_a_of_type_JavaLangString);
      if (paramure != null) {
        paramure.a(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString);
      }
    }
    label208:
    do
    {
      do
      {
        return;
        if (!(paramuju.jdField_a_of_type_JavaLangObject instanceof stFriendFeedRsp)) {
          break;
        }
        Object localObject = (stFriendFeedRsp)paramuju.jdField_a_of_type_JavaLangObject;
        if (((stFriendFeedRsp)localObject).isFinished == 1) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          localObject = ((stFriendFeedRsp)localObject).friendFeed;
          if (localObject == null) {
            break label208;
          }
          this.jdField_a_of_type_JavaLangString = ((stFriendFeed)localObject).attachInfo;
          paramuju = ((stFriendFeed)localObject).friendFeeds;
          paramuju = WSVerticalDataManager.a().a(paramuju);
          upe.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:" + paramuju.size() + ", mAttachInfo:" + this.jdField_a_of_type_JavaLangString + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
          if (paramure == null) {
            break;
          }
          paramure.a(paramuju, false, false, null);
          return;
          bool = false;
        }
        upe.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
      } while (paramure == null);
      paramure.a(paramuju.b, "stFriendFeed is null!");
      return;
      upe.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
    } while (paramure == null);
    paramure.a(paramuju.b, paramuju.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    upe.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:" + paramString);
  }
  
  public void a(ure paramure)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      upe.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramure = new urm(this, paramure);
    upe.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][fetchData] attachInfo:" + this.jdField_a_of_type_JavaLangString);
    paramure = new uju(new unm(this.jdField_a_of_type_JavaLangString), null, paramure, 4012);
    ujn.a().a(paramure);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     url
 * JD-Core Version:    0.7.0.1
 */