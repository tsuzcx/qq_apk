import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.b;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.c;
import com.tencent.qphone.base.util.QLog;

public abstract class rmm
{
  protected aman a;
  protected String aBi;
  protected String aBj;
  protected int mResult;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, SlideShowProcessor.c paramc)
  {
    if (paramc != null)
    {
      rlt localrlt = new rlt();
      localrlt.mID = paramc.Cj;
      localrlt.mResult = paramInt;
      localrlt.mFile = paramString2;
      localrlt.aBm = paramString1;
      localrlt.mMediaFormat = paramMediaFormat;
      localrlt.aBn = this.aBj;
      localrlt.mHasAudioTrack = false;
      localrlt.bth = 1;
      if (paramSlideItemInfo != null)
      {
        localrlt.mHasAudioTrack = paramSlideItemInfo.hasAudioTrack;
        localrlt.bth = paramSlideItemInfo.mSampleRate;
      }
      if (paramc.a != null) {
        paramc.a.c(localrlt);
      }
    }
  }
  
  protected boolean a(SlideShowProcessor.c paramc)
  {
    if ((!paramc.isRun) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramc.Cj + " currContext.isRun:" + paramc.isRun);
    }
    return !paramc.isRun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmm
 * JD-Core Version:    0.7.0.1
 */