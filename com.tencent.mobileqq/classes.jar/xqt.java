import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class xqt
  implements TVK_IMediaPlayer.OnInfoListener
{
  xqt(xqp paramxqp) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      yqp.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), xpz.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= xpz.b.length))
      {
        yqp.d(this.a.a, "onInfo. playerType %s", new Object[] { xpz.b[i] });
      }
      else
      {
        yqp.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        yqp.d(this.a.a, "onInfo. start buffering");
        continue;
        yqp.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < xpz.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          yqp.d(this.a.a, "onInfo. set decoder. %s", new Object[] { xpz.jdField_a_of_type_ArrayOfJavaLangString[i] });
          xqp.a(this.a).d = xpz.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          yqp.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          xqp.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqt
 * JD-Core Version:    0.7.0.1
 */