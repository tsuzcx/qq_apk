import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class uaj
  implements ucq
{
  int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b = -1;
  
  private uaj(uai paramuai) {}
  
  public void a(int paramInt)
  {
    uai.a(this.jdField_a_of_type_Uai);
    Object localObject1 = uai.a(this.jdField_a_of_type_Uai).a();
    if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
      uai.a(this.jdField_a_of_type_Uai, ((twm)((List)localObject1).get(paramInt)).a);
    }
    localObject1 = this.jdField_a_of_type_Uai.a(paramInt);
    boolean bool1;
    boolean bool2;
    if (localObject1 != null)
    {
      Object localObject2 = ((StoryPlayerGroupHolder)localObject1).a();
      ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
      if (localObject2 != null)
      {
        if (((StoryPlayerGroupHolder)localObject1).b != ((StoryPlayerGroupHolder)localObject1).a.size() - 1) {
          break label323;
        }
        bool1 = true;
        if (((StoryPlayerGroupHolder)localObject1).b != 0) {
          break label328;
        }
        bool2 = true;
        label128:
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (((StoryPlayerGroupHolder)localObject1).d()) {
            bool3 = false;
          }
        }
        this.jdField_a_of_type_Uai.a.setEnableScrollDirection(bool3, bool2, true, true);
        if (uai.a(this.jdField_a_of_type_Uai) != null) {
          uai.a(this.jdField_a_of_type_Uai).a(paramInt, ((uaz)localObject2).b, ((uaz)localObject2).b);
        }
      }
      label197:
      if (!(uai.a(this.jdField_a_of_type_Uai) instanceof twz)) {
        break label357;
      }
      localObject1 = ((twz)uai.a(this.jdField_a_of_type_Uai)).a;
      if (localObject1 != null)
      {
        if (TextUtils.equals(((tff)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          break label343;
        }
        this.jdField_a_of_type_JavaLangString = ((tff)localObject1).jdField_a_of_type_JavaLangString;
        localObject2 = new tgh();
        ((tgh)localObject2).c = ((tff)localObject1).jdField_a_of_type_Int;
        ((tgh)localObject2).jdField_b_of_type_JavaLangString = ((tff)localObject1).jdField_a_of_type_JavaLangString;
        ((tgh)localObject2).jdField_b_of_type_Long = ((tff)localObject1).e;
        ((tff)localObject1).c = false;
        syo.a().a((sys)localObject2, null);
        ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
      }
    }
    for (;;)
    {
      c(paramInt);
      return;
      label323:
      bool1 = false;
      break;
      label328:
      bool2 = false;
      break label128;
      ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
      break label197;
      label343:
      ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.jdField_a_of_type_JavaLangString);
      continue;
      label357:
      ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (uai.a(this.jdField_a_of_type_Uai) != null) {
      uai.a(this.jdField_a_of_type_Uai).a(this.jdField_a_of_type_Uai.a.c(), paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Uai.a.c();
    Object localObject = this.jdField_a_of_type_Uai.a(i);
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).a();
      if ((localObject instanceof uba))
      {
        localObject = (VideoViewVideoHolder)((uba)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null)
        {
          if (paramInt != 1) {
            break label94;
          }
          ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
          ((VideoViewVideoHolder)localObject).e();
        }
      }
    }
    for (;;)
    {
      if (uai.a(this.jdField_a_of_type_Uai) != null) {
        uai.a(this.jdField_a_of_type_Uai).a(i, paramInt);
      }
      return;
      label94:
      if (paramInt == 0)
      {
        ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(this.jdField_a_of_type_Uai.a.b()));
        if (!((VideoViewVideoHolder)localObject).a.a()) {
          ((VideoViewVideoHolder)localObject).d();
        }
        ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
      }
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = uai.a(this.jdField_a_of_type_Uai).a.values().iterator();
    paramInt = 0;
    if (localIterator.hasNext())
    {
      StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)localIterator.next();
      if ((paramInt != 0) || (localStoryPlayerGroupHolder.e()))
      {
        paramInt = 1;
        label55:
        if (paramInt == 0) {
          break label77;
        }
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_Uai.a(null);
      }
      return;
      paramInt = 0;
      break label55;
      label77:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uaj
 * JD-Core Version:    0.7.0.1
 */