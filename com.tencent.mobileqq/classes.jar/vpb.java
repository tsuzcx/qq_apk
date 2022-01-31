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

public class vpb
  implements vri
{
  int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b = -1;
  
  private vpb(vpa paramvpa) {}
  
  public void a(int paramInt)
  {
    vpa.a(this.jdField_a_of_type_Vpa);
    Object localObject1 = vpa.a(this.jdField_a_of_type_Vpa).a();
    if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
      vpa.a(this.jdField_a_of_type_Vpa, ((vle)((List)localObject1).get(paramInt)).a);
    }
    localObject1 = this.jdField_a_of_type_Vpa.a(paramInt);
    boolean bool1;
    boolean bool2;
    if (localObject1 != null)
    {
      Object localObject2 = ((StoryPlayerGroupHolder)localObject1).a();
      wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
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
        this.jdField_a_of_type_Vpa.a.setEnableScrollDirection(bool3, bool2, true, true);
        if (vpa.a(this.jdField_a_of_type_Vpa) != null) {
          vpa.a(this.jdField_a_of_type_Vpa).a(paramInt, ((vpr)localObject2).b, ((vpr)localObject2).b);
        }
      }
      label197:
      if (!(vpa.a(this.jdField_a_of_type_Vpa) instanceof vlr)) {
        break label357;
      }
      localObject1 = ((vlr)vpa.a(this.jdField_a_of_type_Vpa)).a;
      if (localObject1 != null)
      {
        if (TextUtils.equals(((utx)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          break label343;
        }
        this.jdField_a_of_type_JavaLangString = ((utx)localObject1).jdField_a_of_type_JavaLangString;
        localObject2 = new uuz();
        ((uuz)localObject2).c = ((utx)localObject1).jdField_a_of_type_Int;
        ((uuz)localObject2).jdField_b_of_type_JavaLangString = ((utx)localObject1).jdField_a_of_type_JavaLangString;
        ((uuz)localObject2).jdField_b_of_type_Long = ((utx)localObject1).e;
        ((utx)localObject1).c = false;
        ung.a().a((unk)localObject2, null);
        wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
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
      wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
      break label197;
      label343:
      wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.jdField_a_of_type_JavaLangString);
      continue;
      label357:
      wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (vpa.a(this.jdField_a_of_type_Vpa) != null) {
      vpa.a(this.jdField_a_of_type_Vpa).a(this.jdField_a_of_type_Vpa.a.c(), paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Vpa.a.c();
    Object localObject = this.jdField_a_of_type_Vpa.a(i);
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).a();
      if ((localObject instanceof vps))
      {
        localObject = (VideoViewVideoHolder)((vps)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null)
        {
          if (paramInt != 1) {
            break label94;
          }
          wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
          ((VideoViewVideoHolder)localObject).e();
        }
      }
    }
    for (;;)
    {
      if (vpa.a(this.jdField_a_of_type_Vpa) != null) {
        vpa.a(this.jdField_a_of_type_Vpa).a(i, paramInt);
      }
      return;
      label94:
      if (paramInt == 0)
      {
        wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(this.jdField_a_of_type_Vpa.a.b()));
        if (!((VideoViewVideoHolder)localObject).a.a()) {
          ((VideoViewVideoHolder)localObject).d();
        }
        ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
      }
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = vpa.a(this.jdField_a_of_type_Vpa).a.values().iterator();
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
        this.jdField_a_of_type_Vpa.a(null);
      }
      return;
      paramInt = 0;
      break label55;
      label77:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpb
 * JD-Core Version:    0.7.0.1
 */