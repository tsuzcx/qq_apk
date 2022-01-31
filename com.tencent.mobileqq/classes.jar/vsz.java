import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class vsz
  implements TVK_IMediaPlayer.OnInfoListener
{
  vsz(vsv paramvsv) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      wsv.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), vsf.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= vsf.b.length))
      {
        wsv.d(this.a.a, "onInfo. playerType %s", new Object[] { vsf.b[i] });
      }
      else
      {
        wsv.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        wsv.d(this.a.a, "onInfo. start buffering");
        continue;
        wsv.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < vsf.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          wsv.d(this.a.a, "onInfo. set decoder. %s", new Object[] { vsf.jdField_a_of_type_ArrayOfJavaLangString[i] });
          vsv.a(this.a).d = vsf.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          wsv.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          vsv.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsz
 * JD-Core Version:    0.7.0.1
 */