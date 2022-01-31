import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class txi
  implements twv
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  two jdField_a_of_type_Two;
  
  public txi(txh paramtxh, two paramtwo)
  {
    this.jdField_a_of_type_Two = paramtwo;
  }
  
  protected void a(String paramString, tww paramtww)
  {
    tmf localtmf = new tmf();
    localtmf.jdField_c_of_type_JavaLangString = txh.a(this.jdField_a_of_type_Txh).uid;
    if (txh.a(this.jdField_a_of_type_Txh).collectionKey != null) {
      localtmf.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(txh.a(this.jdField_a_of_type_Txh).collectionKey);
    }
    localtmf.jdField_d_of_type_JavaLangString = paramString;
    localtmf.jdField_c_of_type_Int = 20;
    localtmf.jdField_e_of_type_Int = txh.a(this.jdField_a_of_type_Txh).shareTimeZone;
    localtmf.jdField_e_of_type_JavaLangString = txh.a(this.jdField_a_of_type_Txh).feedId;
    localtmf.f = txh.a(this.jdField_a_of_type_Txh).identify;
    localtmf.g = txh.a(this.jdField_a_of_type_Txh).videoListOrder;
    syr.a().a(localtmf, new txj(this, paramtww));
  }
  
  public void a(tww paramtww)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(txh.a(this.jdField_a_of_type_Txh), paramtww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txi
 * JD-Core Version:    0.7.0.1
 */