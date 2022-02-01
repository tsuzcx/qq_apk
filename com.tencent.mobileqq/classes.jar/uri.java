import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class uri
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static uri a()
  {
    return urk.a();
  }
  
  private void a(uju paramuju, ure paramure)
  {
    if (!paramuju.a())
    {
      upe.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] failed code:" + paramuju.jdField_a_of_type_Int + ", msg:" + paramuju.jdField_a_of_type_JavaLangString);
      if (paramure != null) {
        paramure.a(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramuju.jdField_a_of_type_JavaLangObject instanceof stGetCollectionRsp)) {
          break;
        }
        paramuju = (stGetCollectionRsp)paramuju.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_JavaLangString = paramuju.attachInfo;
        this.jdField_a_of_type_Boolean = paramuju.isFinished;
        paramuju = paramuju.feedList;
        paramuju = WSVerticalDataManager.a().a(paramuju);
        upe.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] itemDataList size:" + paramuju.size() + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
      } while (paramure == null);
      paramure.a(paramuju, false, false, null);
      return;
      upe.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (paramure == null);
    paramure.a(paramuju.b, paramuju.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, ure paramure)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      upe.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramure = new urj(this, paramure);
    paramString = new uju(new uob(paramString, this.jdField_a_of_type_JavaLangString, paramInt), null, paramure, 4011);
    ujn.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uri
 * JD-Core Version:    0.7.0.1
 */