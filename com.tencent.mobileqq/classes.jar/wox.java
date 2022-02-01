import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class wox
  implements wok
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  wod jdField_a_of_type_Wod;
  
  public wox(wow paramwow, wod paramwod)
  {
    this.jdField_a_of_type_Wod = paramwod;
  }
  
  protected void a(String paramString, wol paramwol)
  {
    wea localwea = new wea();
    localwea.jdField_c_of_type_JavaLangString = wow.a(this.jdField_a_of_type_Wow).uid;
    if (wow.a(this.jdField_a_of_type_Wow).collectionKey != null) {
      localwea.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(wow.a(this.jdField_a_of_type_Wow).collectionKey);
    }
    localwea.jdField_d_of_type_JavaLangString = paramString;
    localwea.jdField_c_of_type_Int = 20;
    localwea.jdField_e_of_type_Int = wow.a(this.jdField_a_of_type_Wow).shareTimeZone;
    localwea.jdField_e_of_type_JavaLangString = wow.a(this.jdField_a_of_type_Wow).feedId;
    localwea.f = wow.a(this.jdField_a_of_type_Wow).identify;
    localwea.g = wow.a(this.jdField_a_of_type_Wow).videoListOrder;
    vqn.a().a(localwea, new woy(this, paramwol));
  }
  
  public void a(wol paramwol)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(wow.a(this.jdField_a_of_type_Wow), paramwol);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wox
 * JD-Core Version:    0.7.0.1
 */