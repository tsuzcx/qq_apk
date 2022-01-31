import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class vxi
  implements TVK_IMediaPlayer.OnInfoListener
{
  vxi(vxe paramvxe) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      wxe.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), vwo.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= vwo.b.length))
      {
        wxe.d(this.a.a, "onInfo. playerType %s", new Object[] { vwo.b[i] });
      }
      else
      {
        wxe.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        wxe.d(this.a.a, "onInfo. start buffering");
        continue;
        wxe.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < vwo.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          wxe.d(this.a.a, "onInfo. set decoder. %s", new Object[] { vwo.jdField_a_of_type_ArrayOfJavaLangString[i] });
          vxe.a(this.a).d = vwo.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          wxe.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          vxe.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxi
 * JD-Core Version:    0.7.0.1
 */