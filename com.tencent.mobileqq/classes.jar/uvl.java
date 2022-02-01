import UserGrowth.stSimpleMetaFeed;
import java.util.List;

class uvl
  implements ugo<stSimpleMetaFeed>
{
  uvl(uvk paramuvk, long paramLong, usf paramusf, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = uvk.a(this.jdField_a_of_type_Uvk, paramList);
    if (this.jdField_a_of_type_Usf != null) {
      this.jdField_a_of_type_Usf.a(paramList, this.jdField_a_of_type_Boolean, this.b, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uqf.a("weishi-beacon", "请求播放页（关注)耗时：" + l + "毫秒");
    uoc.a().a(true, l, "focus", 10, "fullscreen_videoplay", paramBoolean1);
    if (!paramBoolean3)
    {
      if (this.jdField_a_of_type_Usf != null) {
        this.jdField_a_of_type_Usf.a(-1, "task failed.");
      }
      this.jdField_a_of_type_Uvk.a(-1, "task failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvl
 * JD-Core Version:    0.7.0.1
 */