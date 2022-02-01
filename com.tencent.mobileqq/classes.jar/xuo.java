import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class xuo
  implements TVK_IMediaPlayer.OnInfoListener
{
  xuo(xuk paramxuk) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      yuk.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), xtu.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= xtu.b.length))
      {
        yuk.d(this.a.a, "onInfo. playerType %s", new Object[] { xtu.b[i] });
      }
      else
      {
        yuk.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        yuk.d(this.a.a, "onInfo. start buffering");
        continue;
        yuk.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < xtu.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          yuk.d(this.a.a, "onInfo. set decoder. %s", new Object[] { xtu.jdField_a_of_type_ArrayOfJavaLangString[i] });
          xuk.a(this.a).d = xtu.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          yuk.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          xuk.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuo
 * JD-Core Version:    0.7.0.1
 */