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

public class xqq
  implements xsx
{
  int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b = -1;
  
  private xqq(xqp paramxqp) {}
  
  public void a(int paramInt)
  {
    xqp.a(this.jdField_a_of_type_Xqp);
    Object localObject1 = xqp.a(this.jdField_a_of_type_Xqp).a();
    if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
      xqp.a(this.jdField_a_of_type_Xqp, ((xmt)((List)localObject1).get(paramInt)).a);
    }
    localObject1 = this.jdField_a_of_type_Xqp.a(paramInt);
    boolean bool1;
    boolean bool2;
    if (localObject1 != null)
    {
      Object localObject2 = ((StoryPlayerGroupHolder)localObject1).a();
      yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
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
        this.jdField_a_of_type_Xqp.a.setEnableScrollDirection(bool3, bool2, true, true);
        if (xqp.a(this.jdField_a_of_type_Xqp) != null) {
          xqp.a(this.jdField_a_of_type_Xqp).a(paramInt, ((xrg)localObject2).b, ((xrg)localObject2).b);
        }
      }
      label197:
      if (!(xqp.a(this.jdField_a_of_type_Xqp) instanceof xng)) {
        break label357;
      }
      localObject1 = ((xng)xqp.a(this.jdField_a_of_type_Xqp)).a;
      if (localObject1 != null)
      {
        if (TextUtils.equals(((wvn)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          break label343;
        }
        this.jdField_a_of_type_JavaLangString = ((wvn)localObject1).jdField_a_of_type_JavaLangString;
        localObject2 = new wwp();
        ((wwp)localObject2).c = ((wvn)localObject1).jdField_a_of_type_Int;
        ((wwp)localObject2).jdField_b_of_type_JavaLangString = ((wvn)localObject1).jdField_a_of_type_JavaLangString;
        ((wwp)localObject2).jdField_b_of_type_Long = ((wvn)localObject1).e;
        ((wvn)localObject1).c = false;
        wow.a().a((wpa)localObject2, null);
        yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
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
      yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
      break label197;
      label343:
      yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.jdField_a_of_type_JavaLangString);
      continue;
      label357:
      yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (xqp.a(this.jdField_a_of_type_Xqp) != null) {
      xqp.a(this.jdField_a_of_type_Xqp).a(this.jdField_a_of_type_Xqp.a.c(), paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Xqp.a.c();
    Object localObject = this.jdField_a_of_type_Xqp.a(i);
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).a();
      if ((localObject instanceof xrh))
      {
        localObject = (VideoViewVideoHolder)((xrh)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null)
        {
          if (paramInt != 1) {
            break label94;
          }
          yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
          ((VideoViewVideoHolder)localObject).e();
        }
      }
    }
    for (;;)
    {
      if (xqp.a(this.jdField_a_of_type_Xqp) != null) {
        xqp.a(this.jdField_a_of_type_Xqp).a(i, paramInt);
      }
      return;
      label94:
      if (paramInt == 0)
      {
        yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(this.jdField_a_of_type_Xqp.a.b()));
        if (!((VideoViewVideoHolder)localObject).a.a()) {
          ((VideoViewVideoHolder)localObject).d();
        }
        ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
      }
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = xqp.a(this.jdField_a_of_type_Xqp).a.values().iterator();
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
        this.jdField_a_of_type_Xqp.a(null);
      }
      return;
      paramInt = 0;
      break label55;
      label77:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqq
 * JD-Core Version:    0.7.0.1
 */