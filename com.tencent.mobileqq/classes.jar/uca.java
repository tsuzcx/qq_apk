import android.os.SystemClock;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

class uca
  implements udd
{
  uca(ubz paramubz) {}
  
  public boolean a(ucz paramucz, int paramInt, Object paramObject)
  {
    if (this.a.isCanceled()) {
      return false;
    }
    ved.a(this.a.a.jdField_a_of_type_JavaLangString, "onInfo, [videoView=%d, what=%d, extra=%s]", Integer.valueOf(System.identityHashCode(paramucz)), Integer.valueOf(paramInt), paramObject);
    switch (paramInt)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.a.a).a(this.a.a, paramucz, paramInt, paramObject);
      return false;
      ved.d(this.a.a.jdField_a_of_type_JavaLangString, "PLAYER_INFO_HW_DECODE_FAILED. extra=%s", new Object[] { paramObject });
      continue;
      VideoViewVideoHolder.d(this.a.a, ((Integer)paramObject).intValue());
      continue;
      VideoViewVideoHolder.a(this.a.a, 0L, "rendering-Start");
      continue;
      ved.d(this.a.a.jdField_a_of_type_JavaLangString, "start buffering, show loading view");
      VideoViewVideoHolder.e(this.a.a, VideoViewVideoHolder.c(this.a.a) + 1);
      VideoViewVideoHolder.a(this.a.a, SystemClock.uptimeMillis());
      VideoViewVideoHolder.a(this.a.a, 8);
      this.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
      continue;
      VideoViewVideoHolder.f(this.a.a, (int)(VideoViewVideoHolder.d(this.a.a) + (SystemClock.uptimeMillis() - VideoViewVideoHolder.a(this.a.a))));
      ved.d(this.a.a.jdField_a_of_type_JavaLangString, "end buffering, hide loading view");
      this.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uca
 * JD-Core Version:    0.7.0.1
 */