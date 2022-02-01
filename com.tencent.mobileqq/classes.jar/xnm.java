import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class xnm
  implements xmz
{
  private int jdField_a_of_type_Int;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  xms jdField_a_of_type_Xms;
  
  public xnm(xnl paramxnl, xms paramxms)
  {
    this.jdField_a_of_type_Xms = paramxms;
  }
  
  protected void a(String paramString, xna paramxna)
  {
    xck localxck = new xck();
    localxck.jdField_c_of_type_JavaLangString = xnl.a(this.jdField_a_of_type_Xnl).uid;
    if (xnl.a(this.jdField_a_of_type_Xnl).collectionKey != null) {
      localxck.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(xnl.a(this.jdField_a_of_type_Xnl).collectionKey);
    }
    localxck.jdField_d_of_type_JavaLangString = paramString;
    localxck.jdField_c_of_type_Int = 20;
    localxck.jdField_e_of_type_Int = xnl.a(this.jdField_a_of_type_Xnl).shareTimeZone;
    localxck.jdField_e_of_type_JavaLangString = xnl.a(this.jdField_a_of_type_Xnl).feedId;
    localxck.f = xnl.a(this.jdField_a_of_type_Xnl).identify;
    localxck.g = xnl.a(this.jdField_a_of_type_Xnl).videoListOrder;
    wow.a().a(localxck, new xnn(this, paramxna));
  }
  
  public void a(xna paramxna)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(xnl.a(this.jdField_a_of_type_Xnl), paramxna);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnm
 * JD-Core Version:    0.7.0.1
 */