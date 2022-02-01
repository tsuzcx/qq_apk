import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.a;

class rjt
  implements GetSingleFullMusicInfoTask.a
{
  rjt(rjr paramrjr) {}
  
  public void m(boolean paramBoolean, Object paramObject)
  {
    String str = rjr.a(this.a).getResources().getString(2131700434);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new rkc();
        ((rkc)localObject).title = paramObject.songName;
        ((rkc)localObject).aAQ = paramObject.url;
        ((rkc)localObject).musicType = 2;
        ((rkc)localObject).id = String.valueOf(paramObject.songId);
        this.a.sendMessage(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = rjr.a(this.a).getResources().getString(2131700435);
      }
    }
    this.a.sendMessage(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjt
 * JD-Core Version:    0.7.0.1
 */