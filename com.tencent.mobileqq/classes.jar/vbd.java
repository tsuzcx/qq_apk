import UserGrowth.stFollowFeedsRsp;
import java.util.ArrayList;

class vbd
  implements vfg
{
  vbd(vbc paramvbc, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, vbf paramvbf) {}
  
  public void a(vfr paramvfr)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramvfr.a();
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      vbc.a(this.jdField_a_of_type_Vbc, paramvfr, l, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Vbf != null) {
        this.jdField_a_of_type_Vbf.a(this.jdField_a_of_type_Boolean, this.b, bool2, paramvfr.jdField_a_of_type_JavaLangObject);
      }
      if (bool2) {
        break;
      }
      vmp.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramvfr.jdField_a_of_type_Int + ", msg: " + paramvfr.jdField_a_of_type_JavaLangString);
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      vmp.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramvfr.jdField_a_of_type_JavaLangObject);
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, -1, "数据无法解析或为空");
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramvfr.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Vbc.jdField_a_of_type_JavaLangString = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_Vbc.jdField_a_of_type_Int = localstFollowFeedsRsp.cache_size;
    if (paramvfr.jdField_a_of_type_Vfh != null) {
      vkc.a().a(localstFollowFeedsRsp.trace_id, paramvfr.jdField_a_of_type_Vfh.a);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Vbc.b = localstFollowFeedsRsp.feeds_source;
      vka.a(this.jdField_a_of_type_Vbc.b);
    }
    if (vmg.a(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramvfr = "null";; paramvfr = "size = 0")
      {
        vmp.e("FollowRequest", paramvfr);
        return;
      }
    }
    vmp.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    vbc.a(this.jdField_a_of_type_Vbc, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_Vbf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbd
 * JD-Core Version:    0.7.0.1
 */