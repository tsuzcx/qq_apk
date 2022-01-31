import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.List;
import java.util.Map;

class tnr
  implements tmy
{
  private tnr(tnp paramtnp) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a.a(paramInt1);
    if (localStoryPlayerGroupHolder == null) {
      urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, find vertical holder is null");
    }
    do
    {
      return;
      if (tnp.a(this.a) == null)
      {
        urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, mCurrentSelectedGroupId is null");
        return;
      }
      urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, verticalPosition=%d, currentGroup=%s, onSelectedGroup=%s", Integer.valueOf(paramInt1), tnp.a(this.a), localStoryPlayerGroupHolder.jdField_a_of_type_Tjs);
    } while ((tnp.a(this.a) != localStoryPlayerGroupHolder.jdField_a_of_type_Tjs) && (!tnp.a(this.a).equals(localStoryPlayerGroupHolder.jdField_a_of_type_Tjs)));
    Object localObject = localStoryPlayerGroupHolder.a();
    if ((localObject instanceof toh))
    {
      localObject = (VideoViewVideoHolder)((toh)localObject).b(VideoViewVideoHolder.class);
      if (localObject != null)
      {
        if (paramInt2 != 1) {
          break label168;
        }
        urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, pause because of dragging");
        ((VideoViewVideoHolder)localObject).e();
      }
    }
    label143:
    while (tnp.a(this.a) != null)
    {
      tnp.a(this.a).a(paramInt1, paramInt2);
      return;
      label168:
      if (paramInt2 == 0)
      {
        if ((!localStoryPlayerGroupHolder.d()) || (!localStoryPlayerGroupHolder.c())) {
          break label229;
        }
        urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, no need start");
      }
    }
    for (;;)
    {
      urp.a("play_video", "slide_up_down", 0, 0, new String[] { "2", "", "", "" });
      break label143;
      break;
      label229:
      urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, start because of idle");
      ((VideoViewVideoHolder)localObject).d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a.a(paramInt1);
    if (localStoryPlayerGroupHolder == null) {
      urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, find vertical holder is null");
    }
    do
    {
      return;
      if (tnp.a(this.a) == null)
      {
        urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, mCurrentSelectedGroupId is null");
        return;
      }
    } while (((tnp.a(this.a) != localStoryPlayerGroupHolder.jdField_a_of_type_Tjs) && (!tnp.a(this.a).equals(localStoryPlayerGroupHolder.jdField_a_of_type_Tjs))) || (tnp.a(this.a) == null));
    tnp.a(this.a).a(paramInt1, paramInt2, paramFloat, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)tnp.a(this.a).a.get(Integer.valueOf(paramInt1));
    if (localStoryPlayerGroupHolder == null) {
      urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, find vertical holder is null");
    }
    do
    {
      return;
      if (tnp.a(this.a) == null)
      {
        urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, mCurrentSelectedGroupId is null");
        return;
      }
      urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, verticalPosition=%d, oldHorizontalPosition=%d, horizontalPosition=%d, currentGroup=%s, onSelectedGroup=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), tnp.a(this.a), localStoryPlayerGroupHolder.jdField_a_of_type_Tjs });
    } while ((tnp.a(this.a) != localStoryPlayerGroupHolder.jdField_a_of_type_Tjs) && (!tnp.a(this.a).equals(localStoryPlayerGroupHolder.jdField_a_of_type_Tjs)));
    boolean bool1;
    if (localStoryPlayerGroupHolder.a(paramInt3) != null)
    {
      if (tnp.a(this.a) != null) {
        tnp.a(this.a).a(paramInt1, paramInt2, paramInt3);
      }
      if (localStoryPlayerGroupHolder.b != localStoryPlayerGroupHolder.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label257;
      }
      bool1 = true;
      label195:
      if (localStoryPlayerGroupHolder.b != 0) {
        break label263;
      }
    }
    label257:
    label263:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool3 = bool1;
      if (bool1)
      {
        bool3 = bool1;
        if (localStoryPlayerGroupHolder.d()) {
          bool3 = false;
        }
      }
      this.a.a.setEnableScrollDirection(bool3, bool2, true, true);
      return;
      urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, getPageHolderOfPosition return null. onSelected true failed");
      break;
      bool1 = false;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnr
 * JD-Core Version:    0.7.0.1
 */