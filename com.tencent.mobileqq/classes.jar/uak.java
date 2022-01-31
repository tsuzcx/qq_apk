import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.List;
import java.util.Map;

class uak
  implements tzr
{
  private uak(uai paramuai) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a.a(paramInt1);
    if (localStoryPlayerGroupHolder == null) {
      ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, find vertical holder is null");
    }
    do
    {
      return;
      if (uai.a(this.a) == null)
      {
        ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, mCurrentSelectedGroupId is null");
        return;
      }
      ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, verticalPosition=%d, currentGroup=%s, onSelectedGroup=%s", Integer.valueOf(paramInt1), uai.a(this.a), localStoryPlayerGroupHolder.jdField_a_of_type_Twl);
    } while ((uai.a(this.a) != localStoryPlayerGroupHolder.jdField_a_of_type_Twl) && (!uai.a(this.a).equals(localStoryPlayerGroupHolder.jdField_a_of_type_Twl)));
    Object localObject = localStoryPlayerGroupHolder.a();
    if ((localObject instanceof uba))
    {
      localObject = (VideoViewVideoHolder)((uba)localObject).b(VideoViewVideoHolder.class);
      if (localObject != null)
      {
        if (paramInt2 != 1) {
          break label168;
        }
        ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, pause because of dragging");
        ((VideoViewVideoHolder)localObject).e();
      }
    }
    label143:
    while (uai.a(this.a) != null)
    {
      uai.a(this.a).a(paramInt1, paramInt2);
      return;
      label168:
      if (paramInt2 == 0)
      {
        if ((!localStoryPlayerGroupHolder.d()) || (!localStoryPlayerGroupHolder.c())) {
          break label229;
        }
        ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, no need start");
      }
    }
    for (;;)
    {
      vei.a("play_video", "slide_up_down", 0, 0, new String[] { "2", "", "", "" });
      break label143;
      break;
      label229:
      ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, start because of idle");
      ((VideoViewVideoHolder)localObject).d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a.a(paramInt1);
    if (localStoryPlayerGroupHolder == null) {
      ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, find vertical holder is null");
    }
    do
    {
      return;
      if (uai.a(this.a) == null)
      {
        ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, mCurrentSelectedGroupId is null");
        return;
      }
    } while (((uai.a(this.a) != localStoryPlayerGroupHolder.jdField_a_of_type_Twl) && (!uai.a(this.a).equals(localStoryPlayerGroupHolder.jdField_a_of_type_Twl))) || (uai.a(this.a) == null));
    uai.a(this.a).a(paramInt1, paramInt2, paramFloat, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)uai.a(this.a).a.get(Integer.valueOf(paramInt1));
    if (localStoryPlayerGroupHolder == null) {
      ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, find vertical holder is null");
    }
    do
    {
      return;
      if (uai.a(this.a) == null)
      {
        ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, mCurrentSelectedGroupId is null");
        return;
      }
      ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, verticalPosition=%d, oldHorizontalPosition=%d, horizontalPosition=%d, currentGroup=%s, onSelectedGroup=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), uai.a(this.a), localStoryPlayerGroupHolder.jdField_a_of_type_Twl });
    } while ((uai.a(this.a) != localStoryPlayerGroupHolder.jdField_a_of_type_Twl) && (!uai.a(this.a).equals(localStoryPlayerGroupHolder.jdField_a_of_type_Twl)));
    boolean bool1;
    if (localStoryPlayerGroupHolder.a(paramInt3) != null)
    {
      if (uai.a(this.a) != null) {
        uai.a(this.a).a(paramInt1, paramInt2, paramInt3);
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
      ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, getPageHolderOfPosition return null. onSelected true failed");
      break;
      bool1 = false;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uak
 * JD-Core Version:    0.7.0.1
 */