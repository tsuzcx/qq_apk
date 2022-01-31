import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class vqg
  implements vpt
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  vpm jdField_a_of_type_Vpm;
  
  public vqg(vqf paramvqf, vpm paramvpm)
  {
    this.jdField_a_of_type_Vpm = paramvpm;
  }
  
  protected void a(String paramString, vpu paramvpu)
  {
    vfd localvfd = new vfd();
    localvfd.jdField_c_of_type_JavaLangString = vqf.a(this.jdField_a_of_type_Vqf).uid;
    if (vqf.a(this.jdField_a_of_type_Vqf).collectionKey != null) {
      localvfd.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(vqf.a(this.jdField_a_of_type_Vqf).collectionKey);
    }
    localvfd.jdField_d_of_type_JavaLangString = paramString;
    localvfd.jdField_c_of_type_Int = 20;
    localvfd.jdField_e_of_type_Int = vqf.a(this.jdField_a_of_type_Vqf).shareTimeZone;
    localvfd.jdField_e_of_type_JavaLangString = vqf.a(this.jdField_a_of_type_Vqf).feedId;
    localvfd.f = vqf.a(this.jdField_a_of_type_Vqf).identify;
    localvfd.g = vqf.a(this.jdField_a_of_type_Vqf).videoListOrder;
    urp.a().a(localvfd, new vqh(this, paramvpu));
  }
  
  public void a(vpu paramvpu)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(vqf.a(this.jdField_a_of_type_Vqf), paramvpu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqg
 * JD-Core Version:    0.7.0.1
 */