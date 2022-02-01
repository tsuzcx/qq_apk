import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xhc
  implements xit
{
  public xhc(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  private boolean a(StoryPlayerGroupHolder paramStoryPlayerGroupHolder, int paramInt, boolean paramBoolean, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < paramStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount()))
    {
      Object localObject = paramStoryPlayerGroupHolder.a(paramInt);
      if (localObject == null) {
        break label156;
      }
      localObject = (VideoViewVideoHolder)((xhm)localObject).a(VideoViewVideoHolder.class);
      if ((localObject != null) && (!((VideoViewVideoHolder)localObject).c()))
      {
        if (((VideoViewVideoHolder)localObject).jdField_a_of_type_Xhf != null) {
          paramStoryPlayerGroupHolder = ((VideoViewVideoHolder)localObject).jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString;
        }
        while ((paramStoryPlayerGroupHolder != null) && (!paramStoryPlayerGroupHolder.startsWith("Loading"))) {
          if (paramBoolean)
          {
            ykq.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            ((VideoViewVideoHolder)localObject).a(8, "pre-prepared");
            return true;
            paramStoryPlayerGroupHolder = null;
          }
          else
          {
            ykq.a(this.a.jdField_a_of_type_JavaLangString, "pre-load video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            xbu.a(paramStoryPlayerGroupHolder, true);
            return true;
          }
        }
        ykq.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared-load video %s failed. vid = %s", paramString, paramStoryPlayerGroupHolder);
      }
    }
    for (;;)
    {
      return false;
      label156:
      ykq.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared-load video %s failed. group=%d, video=%d", paramString, Integer.valueOf(paramStoryPlayerGroupHolder.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    }
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean)
  {
    ykq.a(this.a.jdField_a_of_type_JavaLangString, "onDownloadSuccess, view pager current item = %d, holder position = %d. newDownload=%s", Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramVideoViewVideoHolder.b), Boolean.valueOf(paramBoolean));
    if (this.a.b())
    {
      paramVideoViewVideoHolder = (StoryPlayerGroupAdapter)this.a.a().a();
      if (paramVideoViewVideoHolder != null)
      {
        a(this.a, this.a.b + 1, true, "[↓]");
        paramVideoViewVideoHolder = paramVideoViewVideoHolder.a.values().iterator();
        while (paramVideoViewVideoHolder.hasNext())
        {
          paramString2 = (StoryPlayerGroupHolder)paramVideoViewVideoHolder.next();
          if ((paramString2 != this.a) && (paramString2.jdField_a_of_type_Int > this.a.jdField_a_of_type_Int)) {
            a(paramString2, paramString2.b, true, "[→]");
          }
        }
      }
    }
    if (paramBoolean) {
      wad.a().dispatch(new xhd(paramString1, true, paramFile));
    }
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, xjm paramxjm)
  {
    ykq.a(this.a.jdField_a_of_type_JavaLangString, "onPrepared, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.jdField_a_of_type_Int), Integer.valueOf(paramVideoViewVideoHolder.b));
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, xjm paramxjm, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, xjm paramxjm, boolean paramBoolean)
  {
    ykq.d(this.a.jdField_a_of_type_JavaLangString, "onCompletion, current item = %d, repeat = %s, repeatMode=%d", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Boolean.valueOf(paramBoolean), Integer.valueOf(StoryPlayerGroupHolder.b(this.a)) });
    int i;
    if (((StoryPlayerGroupHolder.b(this.a) & 0x1) == 1) || (paramBoolean))
    {
      paramVideoViewVideoHolder.f();
      paramVideoViewVideoHolder.a(10, true, "repeat video");
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        ykq.d(this.a.jdField_a_of_type_JavaLangString, "onCompletion, current item = %d, finish", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()) });
        ykv.a("play_video", "auto_quit", 0, 0, new String[0]);
        this.a.a().finish();
      }
      do
      {
        return true;
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() < this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1)
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() + 1, true);
          i = 0;
          break;
        }
        if ((StoryPlayerGroupHolder.b(this.a) & 0x2) == 2)
        {
          if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() == 1)
          {
            paramVideoViewVideoHolder.f();
            paramVideoViewVideoHolder.a(10, true, "repeat feed");
            i = 0;
            break;
          }
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(0, true);
          i = 0;
          break;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1) {
          break label440;
        }
      } while ((StoryPlayerGroupHolder.a(this.a) != null) && (StoryPlayerGroupHolder.a(this.a).a(paramVideoViewVideoHolder, paramxjm, false)));
      if (this.a.d())
      {
        paramVideoViewVideoHolder = (xgb)this.a.b(xgb.class);
        if (paramVideoViewVideoHolder != null) {
          paramVideoViewVideoHolder.d();
        }
        ykq.b(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onCompletion, showLoadingMoreWidget");
        i = 0;
      }
      else
      {
        paramVideoViewVideoHolder = this.a.a();
        if (paramVideoViewVideoHolder.c() < paramVideoViewVideoHolder.a().getCount() - 1)
        {
          paramVideoViewVideoHolder.setEnableScrollDirection(true, true, false, false);
          paramVideoViewVideoHolder.setCurrentItem(paramVideoViewVideoHolder.c() + 1, true);
          i = 0;
        }
        else
        {
          i = 1;
          continue;
          label440:
          i = 1;
        }
      }
    }
  }
  
  public void b(VideoViewVideoHolder paramVideoViewVideoHolder, xjm paramxjm)
  {
    ykq.a(this.a.jdField_a_of_type_JavaLangString, "onStarting, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.jdField_a_of_type_Int), Integer.valueOf(paramVideoViewVideoHolder.b));
  }
  
  public void c(VideoViewVideoHolder paramVideoViewVideoHolder, xjm paramxjm)
  {
    if (this.a.b())
    {
      xbu.a();
      paramxjm = (StoryPlayerGroupAdapter)this.a.a().a();
      if (paramxjm != null)
      {
        a(this.a, this.a.b + 1, true, "[↓]");
        paramxjm = paramxjm.a.values().iterator();
        while (paramxjm.hasNext())
        {
          StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramxjm.next();
          if (localStoryPlayerGroupHolder != this.a) {
            if (localStoryPlayerGroupHolder.jdField_a_of_type_Int < this.a.jdField_a_of_type_Int) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.b, false, "[←]");
            } else if (localStoryPlayerGroupHolder.jdField_a_of_type_Int > this.a.jdField_a_of_type_Int) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.b, true, "[→]");
            }
          }
        }
        a(this.a, this.a.b - 1, false, "[↑]");
      }
      paramxjm = this.a.jdField_a_of_type_JavaUtilList;
      int i = paramxjm.size();
      if (paramVideoViewVideoHolder.b + 2 < i)
      {
        paramVideoViewVideoHolder = ((xhf)paramxjm.get(paramVideoViewVideoHolder.b + 2)).jdField_a_of_type_JavaLangString;
        if (!paramVideoViewVideoHolder.startsWith("Loading"))
        {
          ykq.a(this.a.jdField_a_of_type_JavaLangString, "pre-load video [↓↓]. vid = %s", paramVideoViewVideoHolder);
          xbu.a(paramVideoViewVideoHolder, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhc
 * JD-Core Version:    0.7.0.1
 */