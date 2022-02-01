import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class wvz
  implements TVK_IMediaPlayer.OnInfoListener
{
  wvz(wvv paramwvv) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      xvv.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), wvf.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= wvf.b.length))
      {
        xvv.d(this.a.a, "onInfo. playerType %s", new Object[] { wvf.b[i] });
      }
      else
      {
        xvv.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        xvv.d(this.a.a, "onInfo. start buffering");
        continue;
        xvv.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < wvf.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          xvv.d(this.a.a, "onInfo. set decoder. %s", new Object[] { wvf.jdField_a_of_type_ArrayOfJavaLangString[i] });
          wvv.a(this.a).d = wvf.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          xvv.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          wvv.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvz
 * JD-Core Version:    0.7.0.1
 */