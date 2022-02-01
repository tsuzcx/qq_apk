import UserGrowth.stFollowFeedsRsp;
import java.util.ArrayList;

class und
  implements uqy
{
  und(unc paramunc, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, unf paramunf) {}
  
  public void a(urj paramurj)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramurj.a();
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      unc.a(this.jdField_a_of_type_Unc, paramurj, l, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Unf != null) {
        this.jdField_a_of_type_Unf.a(this.jdField_a_of_type_Boolean, this.b, bool2, paramurj.jdField_a_of_type_JavaLangObject);
      }
      if (bool2) {
        break;
      }
      uya.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramurj.jdField_a_of_type_Int + ", msg: " + paramurj.jdField_a_of_type_JavaLangString);
      uvw.a().a(l, paramurj.jdField_a_of_type_Urg, paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramurj.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      uya.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramurj.jdField_a_of_type_JavaLangObject);
      uvw.a().a(l, paramurj.jdField_a_of_type_Urg, -1, "数据无法解析或为空");
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramurj.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Unc.jdField_a_of_type_JavaLangString = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_Unc.jdField_a_of_type_Int = localstFollowFeedsRsp.cache_size;
    if (paramurj.jdField_a_of_type_Uqz != null) {
      uvo.a().a(localstFollowFeedsRsp.trace_id, paramurj.jdField_a_of_type_Uqz.a);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Unc.b = localstFollowFeedsRsp.feeds_source;
      uvm.a(this.jdField_a_of_type_Unc.b);
    }
    if (uxr.a(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramurj = "null";; paramurj = "size = 0")
      {
        uya.e("FollowRequest", paramurj);
        return;
      }
    }
    uya.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    unc.a(this.jdField_a_of_type_Unc, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_Unf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     und
 * JD-Core Version:    0.7.0.1
 */