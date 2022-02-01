import UserGrowth.stSimpleMetaFeed;
import java.util.List;

class osr
  implements oie.b<stSimpleMetaFeed>
{
  osr(osq paramosq, long paramLong, boolean paramBoolean, oqm paramoqm) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = osq.a(this.jdField_a_of_type_Osq, paramList);
    if (this.jdField_a_of_type_Oqm != null) {
      this.jdField_a_of_type_Oqm.onSuccess(paramList);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    long l = System.currentTimeMillis() - this.zi;
    ooz.i("weishi-beacon", "请求播放页（关注)耗时：" + l + "毫秒");
    onk.a().a(true, l, "focus", 10, "fullscreen_videoPlay", this.uk);
    if (!paramBoolean2)
    {
      if (this.jdField_a_of_type_Oqm != null) {
        this.jdField_a_of_type_Oqm.onFailed(-1, "task failed.");
      }
      this.jdField_a_of_type_Osq.onFailed(-1, "task failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osr
 * JD-Core Version:    0.7.0.1
 */