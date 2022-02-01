import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class vae
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static vae a()
  {
    return vag.a();
  }
  
  private void a(urj paramurj, vaa paramvaa)
  {
    if (!paramurj.a())
    {
      uya.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] failed code:" + paramurj.jdField_a_of_type_Int + ", msg:" + paramurj.jdField_a_of_type_JavaLangString);
      if (paramvaa != null) {
        paramvaa.a(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramurj.jdField_a_of_type_JavaLangObject instanceof stGetCollectionRsp)) {
          break;
        }
        paramurj = (stGetCollectionRsp)paramurj.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_JavaLangString = paramurj.attachInfo;
        this.jdField_a_of_type_Boolean = paramurj.isFinished;
        paramurj = paramurj.feedList;
        paramurj = WSVerticalDataManager.a().a(paramurj, "", this.jdField_a_of_type_Boolean);
        uya.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] itemDataList size:" + paramurj.size() + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
      } while (paramvaa == null);
      paramvaa.a(paramurj, false, false, null);
      return;
      uya.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (paramvaa == null);
    paramvaa.a(paramurj.b, paramurj.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, vaa paramvaa)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      uya.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramvaa = new vaf(this, paramvaa);
    paramString = new urj(new uwx(paramString, this.jdField_a_of_type_JavaLangString, paramInt), null, paramvaa, 4011);
    urc.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vae
 * JD-Core Version:    0.7.0.1
 */