import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class vlx
  implements vlk
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  vld jdField_a_of_type_Vld;
  
  public vlx(vlw paramvlw, vld paramvld)
  {
    this.jdField_a_of_type_Vld = paramvld;
  }
  
  protected void a(String paramString, vll paramvll)
  {
    vau localvau = new vau();
    localvau.jdField_c_of_type_JavaLangString = vlw.a(this.jdField_a_of_type_Vlw).uid;
    if (vlw.a(this.jdField_a_of_type_Vlw).collectionKey != null) {
      localvau.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(vlw.a(this.jdField_a_of_type_Vlw).collectionKey);
    }
    localvau.jdField_d_of_type_JavaLangString = paramString;
    localvau.jdField_c_of_type_Int = 20;
    localvau.jdField_e_of_type_Int = vlw.a(this.jdField_a_of_type_Vlw).shareTimeZone;
    localvau.jdField_e_of_type_JavaLangString = vlw.a(this.jdField_a_of_type_Vlw).feedId;
    localvau.f = vlw.a(this.jdField_a_of_type_Vlw).identify;
    localvau.g = vlw.a(this.jdField_a_of_type_Vlw).videoListOrder;
    ung.a().a(localvau, new vly(this, paramvll));
  }
  
  public void a(vll paramvll)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(vlw.a(this.jdField_a_of_type_Vlw), paramvll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */