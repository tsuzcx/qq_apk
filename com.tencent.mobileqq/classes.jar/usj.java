import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class usj
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static usj a()
  {
    return usl.a();
  }
  
  private void a(uko paramuko, usf paramusf)
  {
    if (!paramuko.a())
    {
      uqf.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] failed code:" + paramuko.jdField_a_of_type_Int + ", msg:" + paramuko.jdField_a_of_type_JavaLangString);
      if (paramusf != null) {
        paramusf.a(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramuko.jdField_a_of_type_JavaLangObject instanceof stGetCollectionRsp)) {
          break;
        }
        paramuko = (stGetCollectionRsp)paramuko.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_JavaLangString = paramuko.attachInfo;
        this.jdField_a_of_type_Boolean = paramuko.isFinished;
        paramuko = paramuko.feedList;
        paramuko = WSVerticalDataManager.a().a(paramuko);
        uqf.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] itemDataList size:" + paramuko.size() + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
      } while (paramusf == null);
      paramusf.a(paramuko, false, false, null);
      return;
      uqf.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (paramusf == null);
    paramusf.a(paramuko.b, paramuko.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, usf paramusf)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      uqf.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramusf = new usk(this, paramusf);
    paramString = new uko(new upc(paramString, this.jdField_a_of_type_JavaLangString, paramInt), null, paramusf, 4011);
    ukh.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usj
 * JD-Core Version:    0.7.0.1
 */