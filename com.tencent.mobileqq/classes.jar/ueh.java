import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class ueh
  implements TVK_IMediaPlayer.OnInfoListener
{
  ueh(ued paramued) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      ved.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), udn.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= udn.b.length))
      {
        ved.d(this.a.a, "onInfo. playerType %s", new Object[] { udn.b[i] });
      }
      else
      {
        ved.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        ved.d(this.a.a, "onInfo. start buffering");
        continue;
        ved.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < udn.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          ved.d(this.a.a, "onInfo. set decoder. %s", new Object[] { udn.jdField_a_of_type_ArrayOfJavaLangString[i] });
          ued.a(this.a).d = udn.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          ved.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          ued.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueh
 * JD-Core Version:    0.7.0.1
 */