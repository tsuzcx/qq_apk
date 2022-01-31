import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class txf
  implements tws
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  twl jdField_a_of_type_Twl;
  
  public txf(txe paramtxe, twl paramtwl)
  {
    this.jdField_a_of_type_Twl = paramtwl;
  }
  
  protected void a(String paramString, twt paramtwt)
  {
    tmc localtmc = new tmc();
    localtmc.jdField_c_of_type_JavaLangString = txe.a(this.jdField_a_of_type_Txe).uid;
    if (txe.a(this.jdField_a_of_type_Txe).collectionKey != null) {
      localtmc.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(txe.a(this.jdField_a_of_type_Txe).collectionKey);
    }
    localtmc.jdField_d_of_type_JavaLangString = paramString;
    localtmc.jdField_c_of_type_Int = 20;
    localtmc.jdField_e_of_type_Int = txe.a(this.jdField_a_of_type_Txe).shareTimeZone;
    localtmc.jdField_e_of_type_JavaLangString = txe.a(this.jdField_a_of_type_Txe).feedId;
    localtmc.f = txe.a(this.jdField_a_of_type_Txe).identify;
    localtmc.g = txe.a(this.jdField_a_of_type_Txe).videoListOrder;
    syo.a().a(localtmc, new txg(this, paramtwt));
  }
  
  public void a(twt paramtwt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(txe.a(this.jdField_a_of_type_Txe), paramtwt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txf
 * JD-Core Version:    0.7.0.1
 */