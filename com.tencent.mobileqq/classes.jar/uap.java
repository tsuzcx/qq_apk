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

public class uap
  implements ucg
{
  public uap(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  private boolean a(StoryPlayerGroupHolder paramStoryPlayerGroupHolder, int paramInt, boolean paramBoolean, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < paramStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount()))
    {
      Object localObject = paramStoryPlayerGroupHolder.a(paramInt);
      if (localObject == null) {
        break label156;
      }
      localObject = (VideoViewVideoHolder)((uaz)localObject).a(VideoViewVideoHolder.class);
      if ((localObject != null) && (!((VideoViewVideoHolder)localObject).c()))
      {
        if (((VideoViewVideoHolder)localObject).jdField_a_of_type_Uas != null) {
          paramStoryPlayerGroupHolder = ((VideoViewVideoHolder)localObject).jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;
        }
        while ((paramStoryPlayerGroupHolder != null) && (!paramStoryPlayerGroupHolder.startsWith("Loading"))) {
          if (paramBoolean)
          {
            ved.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            ((VideoViewVideoHolder)localObject).a(8, "pre-prepared");
            return true;
            paramStoryPlayerGroupHolder = null;
          }
          else
          {
            ved.a(this.a.jdField_a_of_type_JavaLangString, "pre-load video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            tvh.a(paramStoryPlayerGroupHolder, true);
            return true;
          }
        }
        ved.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared-load video %s failed. vid = %s", paramString, paramStoryPlayerGroupHolder);
      }
    }
    for (;;)
    {
      return false;
      label156:
      ved.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared-load video %s failed. group=%d, video=%d", paramString, Integer.valueOf(paramStoryPlayerGroupHolder.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    }
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean)
  {
    ved.a(this.a.jdField_a_of_type_JavaLangString, "onDownloadSuccess, view pager current item = %d, holder position = %d. newDownload=%s", Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramVideoViewVideoHolder.b), Boolean.valueOf(paramBoolean));
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
      stb.a().dispatch(new uaq(paramString1, true, paramFile));
    }
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, ucz paramucz)
  {
    ved.a(this.a.jdField_a_of_type_JavaLangString, "onPrepared, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.jdField_a_of_type_Int), Integer.valueOf(paramVideoViewVideoHolder.b));
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, ucz paramucz, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, ucz paramucz, boolean paramBoolean)
  {
    ved.d(this.a.jdField_a_of_type_JavaLangString, "onCompletion, current item = %d, repeat = %s, repeatMode=%d", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Boolean.valueOf(paramBoolean), Integer.valueOf(StoryPlayerGroupHolder.b(this.a)) });
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
        ved.d(this.a.jdField_a_of_type_JavaLangString, "onCompletion, current item = %d, finish", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()) });
        vei.a("play_video", "auto_quit", 0, 0, new String[0]);
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
      } while ((StoryPlayerGroupHolder.a(this.a) != null) && (StoryPlayerGroupHolder.a(this.a).a(paramVideoViewVideoHolder, paramucz, false)));
      if (this.a.d())
      {
        paramVideoViewVideoHolder = (tzo)this.a.b(tzo.class);
        if (paramVideoViewVideoHolder != null) {
          paramVideoViewVideoHolder.d();
        }
        ved.b(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onCompletion, showLoadingMoreWidget");
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
  
  public void b(VideoViewVideoHolder paramVideoViewVideoHolder, ucz paramucz)
  {
    ved.a(this.a.jdField_a_of_type_JavaLangString, "onStarting, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.jdField_a_of_type_Int), Integer.valueOf(paramVideoViewVideoHolder.b));
  }
  
  public void c(VideoViewVideoHolder paramVideoViewVideoHolder, ucz paramucz)
  {
    if (this.a.b())
    {
      tvh.a();
      paramucz = (StoryPlayerGroupAdapter)this.a.a().a();
      if (paramucz != null)
      {
        a(this.a, this.a.b + 1, true, "[↓]");
        paramucz = paramucz.a.values().iterator();
        while (paramucz.hasNext())
        {
          StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramucz.next();
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
      paramucz = this.a.jdField_a_of_type_JavaUtilList;
      int i = paramucz.size();
      if (paramVideoViewVideoHolder.b + 2 < i)
      {
        paramVideoViewVideoHolder = ((uas)paramucz.get(paramVideoViewVideoHolder.b + 2)).jdField_a_of_type_JavaLangString;
        if (!paramVideoViewVideoHolder.startsWith("Loading"))
        {
          ved.a(this.a.jdField_a_of_type_JavaLangString, "pre-load video [↓↓]. vid = %s", paramVideoViewVideoHolder);
          tvh.a(paramVideoViewVideoHolder, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uap
 * JD-Core Version:    0.7.0.1
 */