import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class vpa
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static vpa a()
  {
    return vpc.a();
  }
  
  private void a(vfr paramvfr, vos paramvos)
  {
    boolean bool = true;
    if (!paramvfr.a())
    {
      vmp.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
      if (paramvos != null) {
        paramvos.a(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      }
    }
    label214:
    do
    {
      do
      {
        return;
        if (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stFriendFeedRsp)) {
          break;
        }
        Object localObject = (stFriendFeedRsp)paramvfr.jdField_a_of_type_JavaLangObject;
        if (((stFriendFeedRsp)localObject).isFinished == 1) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          localObject = ((stFriendFeedRsp)localObject).friendFeed;
          if (localObject == null) {
            break label214;
          }
          this.jdField_a_of_type_JavaLangString = ((stFriendFeed)localObject).attachInfo;
          paramvfr = ((stFriendFeed)localObject).friendFeeds;
          paramvfr = WSVerticalDataManager.a().a(paramvfr, "", this.jdField_a_of_type_Boolean);
          vmp.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:" + paramvfr.size() + ", mAttachInfo:" + this.jdField_a_of_type_JavaLangString + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
          if (paramvos == null) {
            break;
          }
          paramvos.a(paramvfr, false, false, null);
          return;
          bool = false;
        }
        vmp.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
      } while (paramvos == null);
      paramvos.a(paramvfr.b, "stFriendFeed is null!");
      return;
      vmp.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
    } while (paramvos == null);
    paramvos.a(paramvfr.b, paramvfr.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    vmp.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:" + paramString);
  }
  
  public void a(vos paramvos)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      vmp.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramvos = new vpb(this, paramvos);
    vmp.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][fetchData] attachInfo:" + this.jdField_a_of_type_JavaLangString);
    paramvos = new vfr(new vkv(this.jdField_a_of_type_JavaLangString), null, paramvos, 4012);
    vfk.a().a(paramvos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpa
 * JD-Core Version:    0.7.0.1
 */