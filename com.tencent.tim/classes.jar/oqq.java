import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import java.util.ArrayList;
import java.util.List;

class oqq
  implements oko
{
  oqq(oqp paramoqp, long paramLong, boolean paramBoolean, oqm paramoqm) {}
  
  public void a(okz paramokz)
  {
    long l = System.currentTimeMillis() - this.zi;
    ooz.i("weishi-beacon", "请求播放页（推荐)耗时：" + l + "毫秒");
    onk.a().a(true, l, "feeds", 2, "fullscreen_videoPlay", this.uk);
    if (!paramokz.succeeded())
    {
      ooz.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramokz.bfj + ", msg:" + paramokz.msg);
      if (this.jdField_a_of_type_Oqm != null) {
        this.jdField_a_of_type_Oqm.onFailed(paramokz.bfj, paramokz.msg);
      }
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (!(paramokz.bb instanceof stSimpleGetFeedListRsp)) {
          break;
        }
        stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramokz.bb;
        if (this.uk)
        {
          oqp.a(this.jdField_a_of_type_Oqp, localstSimpleGetFeedListRsp, this.jdField_a_of_type_Oqm);
          if (ogd.GI()) {
            oiv.a().b(new WSUserAuthEvent());
          }
        }
        oqp.a(this.jdField_a_of_type_Oqp, localstSimpleGetFeedListRsp.attach_info);
        oqp.b(this.jdField_a_of_type_Oqp, localstSimpleGetFeedListRsp.session);
        localObject = localstSimpleGetFeedListRsp.feeds;
        oqp.setGdtArgs(localstSimpleGetFeedListRsp.gdt_args);
        omc.setGdtArgs(localstSimpleGetFeedListRsp.gdt_args);
        if (!TextUtils.isEmpty(localstSimpleGetFeedListRsp.gdt_args)) {
          oqp.access$502(localstSimpleGetFeedListRsp.gdt_args);
        }
        localObject = this.jdField_a_of_type_Oqp.e((ArrayList)localObject);
        ooz.bY("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + ((List)localObject).size());
        if (paramokz.a != null) {
          ohy.a().f(localstSimpleGetFeedListRsp.trace_id, paramokz.a.mapExt);
        }
      } while (this.jdField_a_of_type_Oqm == null);
      this.jdField_a_of_type_Oqm.onSuccess((List)localObject);
      return;
      ooz.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (this.jdField_a_of_type_Oqm == null);
    this.jdField_a_of_type_Oqm.onFailed(paramokz.mResultCode, paramokz.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqq
 * JD-Core Version:    0.7.0.1
 */