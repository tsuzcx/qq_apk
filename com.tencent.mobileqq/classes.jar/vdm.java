import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class vdm
  implements uqy
{
  vdm(vdl paramvdl, long paramLong, vaa paramvaa) {}
  
  public void a(urj paramurj)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uya.a("weishi-beacon", "小程序播放页请求耗时：" + l + "毫秒");
    uvw.a().a(l, paramurj.jdField_a_of_type_Urg, "fullscreen_videoplay", true);
    if (!paramurj.a())
    {
      uya.d("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramurj.jdField_a_of_type_Int + ", msg:" + paramurj.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Vaa != null) {
        this.jdField_a_of_type_Vaa.a(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      }
      uvw.a().a(l, paramurj.jdField_a_of_type_Urg, paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (!(paramurj.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedDetailRsp)) {
          break;
        }
        paramurj = ((stSimpleGetFeedDetailRsp)paramurj.jdField_a_of_type_JavaLangObject).feed;
        paramurj.isLoop = true;
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramurj);
        paramurj = WSVerticalDataManager.a().a((List)localObject);
        localObject = this.jdField_a_of_type_Vdl.a();
      } while ((localObject == null) || (((uzq)localObject).a() == null) || (((uzq)localObject).a().a() == null));
      localObject = ((uzq)localObject).a().a().a;
    } while (!(localObject instanceof vbl));
    ((vbl)localObject).b((vaq)paramurj.get(0));
    return;
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(paramurj.b, paramurj.jdField_a_of_type_JavaLangString);
    }
    uvw.a().a(l, paramurj.jdField_a_of_type_Urg, -1, "数据无法解析或为空");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdm
 * JD-Core Version:    0.7.0.1
 */