import UserGrowth.stFollowFeedsRsp;
import java.util.ArrayList;

class ugm
  implements ukd
{
  ugm(ugl paramugl, boolean paramBoolean1, boolean paramBoolean2, ugo paramugo, int paramInt) {}
  
  public void a(uko paramuko)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramuko.a();
      if (this.jdField_a_of_type_Ugo != null) {
        this.jdField_a_of_type_Ugo.a(this.jdField_a_of_type_Boolean, this.b, bool2, paramuko.jdField_a_of_type_JavaLangObject);
      }
      if (bool2) {
        break;
      }
      uqf.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramuko.jdField_a_of_type_Int + ", msg: " + paramuko.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramuko.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      uqf.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramuko.jdField_a_of_type_JavaLangObject);
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramuko.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Ugl.jdField_a_of_type_JavaLangString = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_Ugl.jdField_a_of_type_Int = localstFollowFeedsRsp.cache_size;
    if (paramuko.jdField_a_of_type_Uke != null) {
      unu.a().a(localstFollowFeedsRsp.trace_id, paramuko.jdField_a_of_type_Uke.a);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ugl.b = localstFollowFeedsRsp.feeds_source;
      uns.a(this.jdField_a_of_type_Ugl.b);
    }
    if (upw.a(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramuko = "null";; paramuko = "size = 0")
      {
        uqf.e("FollowRequest", paramuko);
        return;
      }
    }
    uqf.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    ugl.a(this.jdField_a_of_type_Ugl, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_Ugo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugm
 * JD-Core Version:    0.7.0.1
 */