import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class xjr
  implements xje
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  xix jdField_a_of_type_Xix;
  
  public xjr(xjq paramxjq, xix paramxix)
  {
    this.jdField_a_of_type_Xix = paramxix;
  }
  
  protected void a(String paramString, xjf paramxjf)
  {
    wyp localwyp = new wyp();
    localwyp.jdField_c_of_type_JavaLangString = xjq.a(this.jdField_a_of_type_Xjq).uid;
    if (xjq.a(this.jdField_a_of_type_Xjq).collectionKey != null) {
      localwyp.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(xjq.a(this.jdField_a_of_type_Xjq).collectionKey);
    }
    localwyp.jdField_d_of_type_JavaLangString = paramString;
    localwyp.jdField_c_of_type_Int = 20;
    localwyp.jdField_e_of_type_Int = xjq.a(this.jdField_a_of_type_Xjq).shareTimeZone;
    localwyp.jdField_e_of_type_JavaLangString = xjq.a(this.jdField_a_of_type_Xjq).feedId;
    localwyp.f = xjq.a(this.jdField_a_of_type_Xjq).identify;
    localwyp.g = xjq.a(this.jdField_a_of_type_Xjq).videoListOrder;
    wlb.a().a(localwyp, new xjs(this, paramxjf));
  }
  
  public void a(xjf paramxjf)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(xjq.a(this.jdField_a_of_type_Xjq), paramxjf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjr
 * JD-Core Version:    0.7.0.1
 */