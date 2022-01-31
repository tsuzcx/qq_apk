import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class uek
  implements TVK_IMediaPlayer.OnInfoListener
{
  uek(ueg paramueg) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      veg.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), udq.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= udq.b.length))
      {
        veg.d(this.a.a, "onInfo. playerType %s", new Object[] { udq.b[i] });
      }
      else
      {
        veg.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        veg.d(this.a.a, "onInfo. start buffering");
        continue;
        veg.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < udq.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          veg.d(this.a.a, "onInfo. set decoder. %s", new Object[] { udq.jdField_a_of_type_ArrayOfJavaLangString[i] });
          ueg.a(this.a).d = udq.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          veg.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          ueg.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uek
 * JD-Core Version:    0.7.0.1
 */