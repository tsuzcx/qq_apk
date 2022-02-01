import UserGrowth.stSimpleMetaFeed;
import java.util.List;

class uuj
  implements ugm<stSimpleMetaFeed>
{
  uuj(uui paramuui, long paramLong, boolean paramBoolean1, ure paramure, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = uui.a(this.jdField_a_of_type_Uui, paramList);
    if (this.jdField_a_of_type_Ure != null) {
      this.jdField_a_of_type_Ure.a(paramList, this.b, this.jdField_a_of_type_Boolean, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    upe.a("weishi-beacon", "请求播放页（关注)耗时：" + l + "毫秒");
    unb.a().a(true, l, "focus", 10, "fullscreen_videoplay", this.jdField_a_of_type_Boolean);
    if (!paramBoolean2)
    {
      if (this.jdField_a_of_type_Ure != null) {
        this.jdField_a_of_type_Ure.a(-1, "task failed.");
      }
      this.jdField_a_of_type_Uui.a(-1, "task failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuj
 * JD-Core Version:    0.7.0.1
 */