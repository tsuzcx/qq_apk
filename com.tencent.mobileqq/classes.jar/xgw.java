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

public class xgw
  implements xjd
{
  int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b = -1;
  
  private xgw(xgv paramxgv) {}
  
  public void a(int paramInt)
  {
    xgv.a(this.jdField_a_of_type_Xgv);
    Object localObject1 = xgv.a(this.jdField_a_of_type_Xgv).a();
    if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
      xgv.a(this.jdField_a_of_type_Xgv, ((xcz)((List)localObject1).get(paramInt)).a);
    }
    localObject1 = this.jdField_a_of_type_Xgv.a(paramInt);
    boolean bool1;
    boolean bool2;
    if (localObject1 != null)
    {
      Object localObject2 = ((StoryPlayerGroupHolder)localObject1).a();
      ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
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
        this.jdField_a_of_type_Xgv.a.setEnableScrollDirection(bool3, bool2, true, true);
        if (xgv.a(this.jdField_a_of_type_Xgv) != null) {
          xgv.a(this.jdField_a_of_type_Xgv).a(paramInt, ((xhm)localObject2).b, ((xhm)localObject2).b);
        }
      }
      label197:
      if (!(xgv.a(this.jdField_a_of_type_Xgv) instanceof xdm)) {
        break label357;
      }
      localObject1 = ((xdm)xgv.a(this.jdField_a_of_type_Xgv)).a;
      if (localObject1 != null)
      {
        if (TextUtils.equals(((wly)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          break label343;
        }
        this.jdField_a_of_type_JavaLangString = ((wly)localObject1).jdField_a_of_type_JavaLangString;
        localObject2 = new wna();
        ((wna)localObject2).c = ((wly)localObject1).jdField_a_of_type_Int;
        ((wna)localObject2).jdField_b_of_type_JavaLangString = ((wly)localObject1).jdField_a_of_type_JavaLangString;
        ((wna)localObject2).jdField_b_of_type_Long = ((wly)localObject1).e;
        ((wly)localObject1).c = false;
        wfi.a().a((wfm)localObject2, null);
        ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
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
      ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
      break label197;
      label343:
      ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.jdField_a_of_type_JavaLangString);
      continue;
      label357:
      ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (xgv.a(this.jdField_a_of_type_Xgv) != null) {
      xgv.a(this.jdField_a_of_type_Xgv).a(this.jdField_a_of_type_Xgv.a.c(), paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Xgv.a.c();
    Object localObject = this.jdField_a_of_type_Xgv.a(i);
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).a();
      if ((localObject instanceof xhn))
      {
        localObject = (VideoViewVideoHolder)((xhn)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null)
        {
          if (paramInt != 1) {
            break label94;
          }
          ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
          ((VideoViewVideoHolder)localObject).e();
        }
      }
    }
    for (;;)
    {
      if (xgv.a(this.jdField_a_of_type_Xgv) != null) {
        xgv.a(this.jdField_a_of_type_Xgv).a(i, paramInt);
      }
      return;
      label94:
      if (paramInt == 0)
      {
        ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(this.jdField_a_of_type_Xgv.a.b()));
        if (!((VideoViewVideoHolder)localObject).a.a()) {
          ((VideoViewVideoHolder)localObject).d();
        }
        ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
      }
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = xgv.a(this.jdField_a_of_type_Xgv).a.values().iterator();
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
        this.jdField_a_of_type_Xgv.a(null);
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
 * Qualified Name:     xgw
 * JD-Core Version:    0.7.0.1
 */