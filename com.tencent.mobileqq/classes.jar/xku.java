import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class xku
  implements TVK_IMediaPlayer.OnInfoListener
{
  xku(xkq paramxkq) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      ykq.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), xka.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= xka.b.length))
      {
        ykq.d(this.a.a, "onInfo. playerType %s", new Object[] { xka.b[i] });
      }
      else
      {
        ykq.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        ykq.d(this.a.a, "onInfo. start buffering");
        continue;
        ykq.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < xka.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          ykq.d(this.a.a, "onInfo. set decoder. %s", new Object[] { xka.jdField_a_of_type_ArrayOfJavaLangString[i] });
          xkq.a(this.a).d = xka.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          ykq.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          xkq.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xku
 * JD-Core Version:    0.7.0.1
 */