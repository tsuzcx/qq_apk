import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class tkm
  implements tjz
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  tjs jdField_a_of_type_Tjs;
  
  public tkm(tkl paramtkl, tjs paramtjs)
  {
    this.jdField_a_of_type_Tjs = paramtjs;
  }
  
  protected void a(String paramString, tka paramtka)
  {
    szj localszj = new szj();
    localszj.jdField_c_of_type_JavaLangString = tkl.a(this.jdField_a_of_type_Tkl).uid;
    if (tkl.a(this.jdField_a_of_type_Tkl).collectionKey != null) {
      localszj.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(tkl.a(this.jdField_a_of_type_Tkl).collectionKey);
    }
    localszj.jdField_d_of_type_JavaLangString = paramString;
    localszj.jdField_c_of_type_Int = 20;
    localszj.jdField_e_of_type_Int = tkl.a(this.jdField_a_of_type_Tkl).shareTimeZone;
    localszj.jdField_e_of_type_JavaLangString = tkl.a(this.jdField_a_of_type_Tkl).feedId;
    localszj.f = tkl.a(this.jdField_a_of_type_Tkl).identify;
    localszj.g = tkl.a(this.jdField_a_of_type_Tkl).videoListOrder;
    slv.a().a(localszj, new tkn(this, paramtka));
  }
  
  public void a(tka paramtka)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(tkl.a(this.jdField_a_of_type_Tkl), paramtka);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkm
 * JD-Core Version:    0.7.0.1
 */