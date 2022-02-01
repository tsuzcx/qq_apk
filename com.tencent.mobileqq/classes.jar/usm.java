import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class usm
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static usm a()
  {
    return uso.a();
  }
  
  private void a(uko paramuko, usf paramusf)
  {
    boolean bool = true;
    if (!paramuko.a())
    {
      uqf.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] failed code:" + paramuko.jdField_a_of_type_Int + ", msg:" + paramuko.jdField_a_of_type_JavaLangString);
      if (paramusf != null) {
        paramusf.a(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString);
      }
    }
    label208:
    do
    {
      do
      {
        return;
        if (!(paramuko.jdField_a_of_type_JavaLangObject instanceof stFriendFeedRsp)) {
          break;
        }
        Object localObject = (stFriendFeedRsp)paramuko.jdField_a_of_type_JavaLangObject;
        if (((stFriendFeedRsp)localObject).isFinished == 1) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          localObject = ((stFriendFeedRsp)localObject).friendFeed;
          if (localObject == null) {
            break label208;
          }
          this.jdField_a_of_type_JavaLangString = ((stFriendFeed)localObject).attachInfo;
          paramuko = ((stFriendFeed)localObject).friendFeeds;
          paramuko = WSVerticalDataManager.a().a(paramuko);
          uqf.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:" + paramuko.size() + ", mAttachInfo:" + this.jdField_a_of_type_JavaLangString + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
          if (paramusf == null) {
            break;
          }
          paramusf.a(paramuko, false, false, null);
          return;
          bool = false;
        }
        uqf.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
      } while (paramusf == null);
      paramusf.a(paramuko.b, "stFriendFeed is null!");
      return;
      uqf.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
    } while (paramusf == null);
    paramusf.a(paramuko.b, paramuko.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    uqf.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:" + paramString);
  }
  
  public void a(usf paramusf)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      uqf.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramusf = new usn(this, paramusf);
    uqf.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][fetchData] attachInfo:" + this.jdField_a_of_type_JavaLangString);
    paramusf = new uko(new uon(this.jdField_a_of_type_JavaLangString), null, paramusf, 4012);
    ukh.a().a(paramusf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usm
 * JD-Core Version:    0.7.0.1
 */