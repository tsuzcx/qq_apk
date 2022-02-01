import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class xds
  implements xdf
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  xcy jdField_a_of_type_Xcy;
  
  public xds(xdr paramxdr, xcy paramxcy)
  {
    this.jdField_a_of_type_Xcy = paramxcy;
  }
  
  protected void a(String paramString, xdg paramxdg)
  {
    wsv localwsv = new wsv();
    localwsv.jdField_c_of_type_JavaLangString = xdr.a(this.jdField_a_of_type_Xdr).uid;
    if (xdr.a(this.jdField_a_of_type_Xdr).collectionKey != null) {
      localwsv.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(xdr.a(this.jdField_a_of_type_Xdr).collectionKey);
    }
    localwsv.jdField_d_of_type_JavaLangString = paramString;
    localwsv.jdField_c_of_type_Int = 20;
    localwsv.jdField_e_of_type_Int = xdr.a(this.jdField_a_of_type_Xdr).shareTimeZone;
    localwsv.jdField_e_of_type_JavaLangString = xdr.a(this.jdField_a_of_type_Xdr).feedId;
    localwsv.f = xdr.a(this.jdField_a_of_type_Xdr).identify;
    localwsv.g = xdr.a(this.jdField_a_of_type_Xdr).videoListOrder;
    wfi.a().a(localwsv, new xdt(this, paramxdg));
  }
  
  public void a(xdg paramxdg)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(xdr.a(this.jdField_a_of_type_Xdr), paramxdg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xds
 * JD-Core Version:    0.7.0.1
 */