import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class vox
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static vox a()
  {
    return voz.a();
  }
  
  private void a(vfr paramvfr, vos paramvos)
  {
    if (!paramvfr.a())
    {
      vmp.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
      if (paramvos != null) {
        paramvos.a(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stGetCollectionRsp)) {
          break;
        }
        paramvfr = (stGetCollectionRsp)paramvfr.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_JavaLangString = paramvfr.attachInfo;
        this.jdField_a_of_type_Boolean = paramvfr.isFinished;
        paramvfr = paramvfr.feedList;
        paramvfr = WSVerticalDataManager.a().a(paramvfr, "", this.jdField_a_of_type_Boolean);
        vmp.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] itemDataList size:" + paramvfr.size() + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
      } while (paramvos == null);
      paramvos.a(paramvfr, false, false, null);
      return;
      vmp.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (paramvos == null);
    paramvos.a(paramvfr.b, paramvfr.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, vos paramvos)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      vmp.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramvos = new voy(this, paramvos);
    paramString = new vfr(new vlm(paramString, this.jdField_a_of_type_JavaLangString, paramInt), null, paramvos, 4011);
    vfk.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vox
 * JD-Core Version:    0.7.0.1
 */