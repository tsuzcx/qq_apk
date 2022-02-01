import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;

class zzl
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>
{
  zzl(zzf paramzzf) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    long l = System.currentTimeMillis() - zzf.a(this.a);
    zxp.a("edit_smart_music", zxp.a(paramLong, l, "", 0L));
    this.a.a(amtj.a(2131703030) + l + "ms");
    zzf.a(this.a, paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzl
 * JD-Core Version:    0.7.0.1
 */