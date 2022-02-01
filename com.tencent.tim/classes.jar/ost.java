import UserGrowth.stSimpleGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.List;

class ost
  implements oko
{
  ost(oss paramoss, long paramLong, ons paramons, oqm paramoqm) {}
  
  public void a(okz paramokz)
  {
    long l = System.currentTimeMillis() - this.ze;
    ooz.i("weishi-beacon", "小程序播放页请求耗时：" + l + "毫秒");
    onk.a().a(true, l, this.jdField_a_of_type_Ons.ly(), 1, "fullscreen_videoPlay", true);
    if (!paramokz.succeeded())
    {
      ooz.e("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramokz.bfj + ", msg:" + paramokz.msg);
      if (this.jdField_a_of_type_Oqm != null) {
        this.jdField_a_of_type_Oqm.onFailed(paramokz.bfj, paramokz.msg);
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (!(paramokz.bb instanceof stSimpleGetFeedDetailRsp)) {
            break;
          }
          paramokz = ((stSimpleGetFeedDetailRsp)paramokz.bb).feed;
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramokz);
          paramokz = oqp.a().e((ArrayList)localObject);
        } while ((this.jdField_a_of_type_Oss.a == null) || (this.jdField_a_of_type_Oss.a.a() == null) || (this.jdField_a_of_type_Oss.a.a().a() == null));
        localObject = this.jdField_a_of_type_Oss.a.a().a().a;
      } while (!(localObject instanceof orb));
      ((orb)localObject).d((oqr)paramokz.get(0));
      return;
    } while (this.jdField_a_of_type_Oqm == null);
    this.jdField_a_of_type_Oqm.onFailed(paramokz.mResultCode, paramokz.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ost
 * JD-Core Version:    0.7.0.1
 */