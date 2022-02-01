import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aleq
  implements acci
{
  aleq(alep paramalep) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetQzoneMusicInfoRsp)))
    {
      paramObject = (GetQzoneMusicInfoRsp)paramObject;
      if ((alep.a(this.this$0)) || (!paramObject.mMusicList.containsKey(alep.a(this.this$0).album))) {
        break label101;
      }
      alep.a(this.this$0).url = ((MusicInfo)paramObject.mMusicList.get(alep.a(this.this$0).album)).sSongUrl;
      this.this$0.b(BaseApplicationImpl.getContext(), alep.a(this.this$0));
    }
    for (;;)
    {
      return;
      label101:
      SongInfo[] arrayOfSongInfo = QQPlayerService.a();
      if (arrayOfSongInfo != null)
      {
        paramInt = 0;
        while (paramInt < arrayOfSongInfo.length)
        {
          if (paramObject.mMusicList.containsKey(arrayOfSongInfo[paramInt].album))
          {
            arrayOfSongInfo[paramInt].url = ((MusicInfo)paramObject.mMusicList.get(arrayOfSongInfo[paramInt].album)).sSongUrl;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileMusicBoxController", 2, "requestMusicSongUrl mid:" + arrayOfSongInfo[paramInt].album + " url:" + arrayOfSongInfo[paramInt].url);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aleq
 * JD-Core Version:    0.7.0.1
 */