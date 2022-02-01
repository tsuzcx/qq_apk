import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class vah
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static vah a()
  {
    return vaj.a();
  }
  
  private void a(urj paramurj, vaa paramvaa)
  {
    boolean bool = true;
    if (!paramurj.a())
    {
      uya.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] failed code:" + paramurj.jdField_a_of_type_Int + ", msg:" + paramurj.jdField_a_of_type_JavaLangString);
      if (paramvaa != null) {
        paramvaa.a(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      }
    }
    label214:
    do
    {
      do
      {
        return;
        if (!(paramurj.jdField_a_of_type_JavaLangObject instanceof stFriendFeedRsp)) {
          break;
        }
        Object localObject = (stFriendFeedRsp)paramurj.jdField_a_of_type_JavaLangObject;
        if (((stFriendFeedRsp)localObject).isFinished == 1) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          localObject = ((stFriendFeedRsp)localObject).friendFeed;
          if (localObject == null) {
            break label214;
          }
          this.jdField_a_of_type_JavaLangString = ((stFriendFeed)localObject).attachInfo;
          paramurj = ((stFriendFeed)localObject).friendFeeds;
          paramurj = WSVerticalDataManager.a().a(paramurj, "", this.jdField_a_of_type_Boolean);
          uya.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:" + paramurj.size() + ", mAttachInfo:" + this.jdField_a_of_type_JavaLangString + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
          if (paramvaa == null) {
            break;
          }
          paramvaa.a(paramurj, false, false, null);
          return;
          bool = false;
        }
        uya.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
      } while (paramvaa == null);
      paramvaa.a(paramurj.b, "stFriendFeed is null!");
      return;
      uya.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
    } while (paramvaa == null);
    paramvaa.a(paramurj.b, paramurj.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    uya.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:" + paramString);
  }
  
  public void a(vaa paramvaa)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      uya.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramvaa = new vai(this, paramvaa);
    uya.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][fetchData] attachInfo:" + this.jdField_a_of_type_JavaLangString);
    paramvaa = new urj(new uwh(this.jdField_a_of_type_JavaLangString), null, paramvaa, 4012);
    urc.a().a(paramvaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */