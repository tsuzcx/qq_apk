import UserGrowth.stFollowFeedsRsp;
import java.util.ArrayList;

class ugk
  implements ujj
{
  ugk(ugj paramugj, boolean paramBoolean1, boolean paramBoolean2, ugm paramugm, int paramInt) {}
  
  public void a(uju paramuju)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramuju.a();
      if (this.jdField_a_of_type_Ugm != null) {
        this.jdField_a_of_type_Ugm.a(this.b, bool2, paramuju.jdField_a_of_type_JavaLangObject);
      }
      if (bool2) {
        break;
      }
      upe.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramuju.jdField_a_of_type_Int + ", msg: " + paramuju.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramuju.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      upe.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramuju.jdField_a_of_type_JavaLangObject);
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramuju.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Ugj.jdField_a_of_type_JavaLangString = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_Ugj.jdField_a_of_type_Int = localstFollowFeedsRsp.cache_size;
    if (paramuju.jdField_a_of_type_Ujk != null) {
      ugb.a().a(localstFollowFeedsRsp.trace_id, paramuju.jdField_a_of_type_Ujk.a);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ugj.b = localstFollowFeedsRsp.feeds_source;
      umu.a(this.jdField_a_of_type_Ugj.b);
    }
    if (uov.a(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramuju = "null";; paramuju = "size = 0")
      {
        upe.e("FollowRequest", paramuju);
        return;
      }
    }
    upe.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    ugj.a(this.jdField_a_of_type_Ugj, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_Ugm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugk
 * JD-Core Version:    0.7.0.1
 */