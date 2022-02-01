import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.a;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class axrl
  implements rxc.a<CLIENT.StBatchGetMusicInfoRsp>
{
  public axrl(QIMMusicConfigManager paramQIMMusicConfigManager, GetSingleFullMusicInfoTask.a parama) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      this.b.m(false, new FlowMusic());
    }
    while (this.b == null) {
      return;
    }
    paramString = new FlowMusic((META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(0));
    QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo from story success flow info:" + paramString.toString());
    this.b.m(true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrl
 * JD-Core Version:    0.7.0.1
 */