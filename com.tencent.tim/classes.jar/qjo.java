import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.a;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.j;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class qjo
  implements VideoViewVideoHolder.j
{
  public qjo(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  private boolean a(StoryPlayerGroupHolder paramStoryPlayerGroupHolder, int paramInt, boolean paramBoolean, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < paramStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount()))
    {
      Object localObject = paramStoryPlayerGroupHolder.a(paramInt);
      if (localObject == null) {
        break label151;
      }
      localObject = (VideoViewVideoHolder)((qjw)localObject).a(VideoViewVideoHolder.class);
      if ((localObject != null) && (!((VideoViewVideoHolder)localObject).isSelected()))
      {
        if (((VideoViewVideoHolder)localObject).a != null) {
          paramStoryPlayerGroupHolder = ((VideoViewVideoHolder)localObject).a.vid;
        }
        while ((paramStoryPlayerGroupHolder != null) && (!paramStoryPlayerGroupHolder.startsWith("Loading"))) {
          if (paramBoolean)
          {
            ram.b(this.this$0.TAG, "pre-prepared video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            ((VideoViewVideoHolder)localObject).aK(8, "pre-prepared");
            return true;
            paramStoryPlayerGroupHolder = null;
          }
          else
          {
            ram.b(this.this$0.TAG, "pre-load video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            return true;
          }
        }
        ram.b(this.this$0.TAG, "pre-prepared-load video %s failed. vid = %s", paramString, paramStoryPlayerGroupHolder);
      }
    }
    for (;;)
    {
      return false;
      label151:
      ram.a(this.this$0.TAG, "pre-prepared-load video %s failed. group=%d, video=%d", paramString, Integer.valueOf(paramStoryPlayerGroupHolder.bmu), Integer.valueOf(paramInt));
    }
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean)
  {
    ram.a(this.this$0.TAG, "onDownloadSuccess, view pager current item = %d, holder position = %d. newDownload=%s", Integer.valueOf(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem()), Integer.valueOf(paramVideoViewVideoHolder.bmB), Boolean.valueOf(paramBoolean));
    if (this.this$0.Jv())
    {
      paramVideoViewVideoHolder = (StoryPlayerGroupAdapter)this.this$0.a().getAdapter();
      if (paramVideoViewVideoHolder != null)
      {
        a(this.this$0, this.this$0.bmz + 1, true, "[↓]");
        paramVideoViewVideoHolder = paramVideoViewVideoHolder.fU.values().iterator();
        while (paramVideoViewVideoHolder.hasNext())
        {
          paramString2 = (StoryPlayerGroupHolder)paramVideoViewVideoHolder.next();
          if ((paramString2 != this.this$0) && (paramString2.bmu > this.this$0.bmu)) {
            a(paramString2, paramString2.bmz, true, "[→]");
          }
        }
      }
    }
    if (paramBoolean) {
      pmi.a().dispatch(new StoryPlayerGroupHolder.a(paramString1, true, paramFile));
    }
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb)
  {
    ram.b(this.this$0.TAG, "onPrepared, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.bmn), Integer.valueOf(paramVideoViewVideoHolder.bmB));
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public void b(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb)
  {
    ram.b(this.this$0.TAG, "onStarting, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.bmn), Integer.valueOf(paramVideoViewVideoHolder.bmB));
  }
  
  public boolean b(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, boolean paramBoolean)
  {
    ram.w(this.this$0.TAG, "onCompletion, current item = %d, repeat = %s, repeatMode=%d", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem()), Boolean.valueOf(paramBoolean), Integer.valueOf(StoryPlayerGroupHolder.b(this.this$0)) });
    int i;
    if (((StoryPlayerGroupHolder.b(this.this$0) & 0x1) == 1) || (paramBoolean))
    {
      paramVideoViewVideoHolder.boL();
      paramVideoViewVideoHolder.c(10, true, "repeat video");
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        ram.w(this.this$0.TAG, "onCompletion, current item = %d, finish", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem()) });
        rar.a("play_video", "auto_quit", 0, 0, new String[0]);
        this.this$0.n().finish();
      }
      do
      {
        return true;
        if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() < this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1)
        {
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() + 1, true);
          i = 0;
          break;
        }
        if ((StoryPlayerGroupHolder.b(this.this$0) & 0x2) == 2)
        {
          if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() == 1)
          {
            paramVideoViewVideoHolder.boL();
            paramVideoViewVideoHolder.c(10, true, "repeat feed");
            i = 0;
            break;
          }
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(0, true);
          i = 0;
          break;
        }
        if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() != this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1) {
          break label442;
        }
      } while ((StoryPlayerGroupHolder.a(this.this$0) != null) && (StoryPlayerGroupHolder.a(this.this$0).b(paramVideoViewVideoHolder, paramqlb, false)));
      if (this.this$0.JI())
      {
        paramVideoViewVideoHolder = (qiv)this.this$0.b(qiv.class);
        if (paramVideoViewVideoHolder != null) {
          paramVideoViewVideoHolder.boz();
        }
        ram.d(this.this$0.TAG + "Q.qqstory.weishi", "onCompletion, showLoadingMoreWidget");
        i = 0;
      }
      else
      {
        paramVideoViewVideoHolder = this.this$0.a();
        if (paramVideoViewVideoHolder.getCurrentItem() < paramVideoViewVideoHolder.getAdapter().getCount() - 1)
        {
          paramVideoViewVideoHolder.setEnableScrollDirection(true, true, false, false);
          paramVideoViewVideoHolder.setCurrentItem(paramVideoViewVideoHolder.getCurrentItem() + 1, true);
          i = 0;
        }
        else
        {
          i = 1;
          continue;
          label442:
          i = 1;
        }
      }
    }
  }
  
  public void c(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb)
  {
    if (this.this$0.Jv())
    {
      paramqlb = (StoryPlayerGroupAdapter)this.this$0.a().getAdapter();
      if (paramqlb != null)
      {
        a(this.this$0, this.this$0.bmz + 1, true, "[↓]");
        paramqlb = paramqlb.fU.values().iterator();
        while (paramqlb.hasNext())
        {
          StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramqlb.next();
          if (localStoryPlayerGroupHolder != this.this$0) {
            if (localStoryPlayerGroupHolder.bmu < this.this$0.bmu) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.bmz, false, "[←]");
            } else if (localStoryPlayerGroupHolder.bmu > this.this$0.bmu) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.bmz, true, "[→]");
            }
          }
        }
        a(this.this$0, this.this$0.bmz - 1, false, "[↑]");
      }
      paramqlb = this.this$0.nR;
      int i = paramqlb.size();
      if (paramVideoViewVideoHolder.bmB + 2 < i)
      {
        paramVideoViewVideoHolder = ((qjq)paramqlb.get(paramVideoViewVideoHolder.bmB + 2)).vid;
        if (!paramVideoViewVideoHolder.startsWith("Loading")) {
          ram.b(this.this$0.TAG, "pre-load video [↓↓]. vid = %s", paramVideoViewVideoHolder);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjo
 * JD-Core Version:    0.7.0.1
 */