import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class tro
  implements TVK_IMediaPlayer.OnInfoListener
{
  tro(trk paramtrk) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      urk.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), tqu.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= tqu.b.length))
      {
        urk.d(this.a.a, "onInfo. playerType %s", new Object[] { tqu.b[i] });
      }
      else
      {
        urk.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        urk.d(this.a.a, "onInfo. start buffering");
        continue;
        urk.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < tqu.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          urk.d(this.a.a, "onInfo. set decoder. %s", new Object[] { tqu.jdField_a_of_type_ArrayOfJavaLangString[i] });
          trk.a(this.a).d = tqu.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          urk.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          trk.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tro
 * JD-Core Version:    0.7.0.1
 */