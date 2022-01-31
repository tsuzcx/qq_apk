import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class wqr
  implements bhtl, wsh, wsi, xrv
{
  private int jdField_a_of_type_Int = -1;
  private wph jdField_a_of_type_Wph;
  
  protected wqr(wps paramwps) {}
  
  public void X_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      xmh.a(alpo.a(2131704838), new Object[0]);
    }
    while (this.jdField_a_of_type_Wps.jdField_a_of_type_Int == 12) {
      return;
    }
    wme localwme = (wme)this.jdField_a_of_type_Wps.jdField_a_of_type_Wli.a().get(this.jdField_a_of_type_Int);
    wps.a(this.jdField_a_of_type_Wps, localwme);
  }
  
  public void Y_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      xmh.a(alpo.a(2131704860), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      xmh.a(alpo.a(2131704840), new Object[0]);
      return;
    }
    wme localwme = (wme)this.jdField_a_of_type_Wps.jdField_a_of_type_Wli.a().get(this.jdField_a_of_type_Int);
    if ((localwme.a() != null) && (!TextUtils.isEmpty(localwme.a().feedId)))
    {
      this.jdField_a_of_type_Wps.jdField_a_of_type_JavaUtilMap.put(localwme.a().feedId, Integer.valueOf(paramInt2));
      wsv.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localwme.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    xmh.a(alpo.a(2131704861), new Object[0]);
    wsv.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, wph paramwph)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wph = paramwph;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      xmh.a(alpo.a(2131704849), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        wmg localwmg = (wmg)this.jdField_a_of_type_Wps.jdField_a_of_type_Wli.a().get(this.jdField_a_of_type_Int);
        int i = wta.a(localwmg.a());
        if (localwmg.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Wps.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            wta.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localwmg.a().feedId });
            return this.jdField_a_of_type_Wps.jdField_a_of_type_Wli.a(localwmg);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        wsv.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        xmh.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      xmh.a(alpo.a(2131704855), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (wps.c(this.jdField_a_of_type_Wps))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Wph.a(2131373713);
        wme localwme;
        Object localObject;
        if (this.jdField_a_of_type_Wps.jdField_a_of_type_Wli.a().size() > this.jdField_a_of_type_Int)
        {
          localwme = (wme)this.jdField_a_of_type_Wps.jdField_a_of_type_Wli.a().get(this.jdField_a_of_type_Int);
          if ((localwme != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            wsv.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localwme);
            wps.a(this.jdField_a_of_type_Wps, (List)localObject, i);
            wps.b(this.jdField_a_of_type_Wps, (List)localObject, i);
          }
          localObject = (wgt)this.jdField_a_of_type_Wph.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = wps.a(this.jdField_a_of_type_Wps);
          this.jdField_a_of_type_Wps.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localwme == null)) {
            break;
          }
          paramInt = localStoryHomeHorizontalListView.getFirstVisiblePosition();
          if (paramInt >= 0) {
            break label361;
          }
          paramInt = j;
        }
        for (;;)
        {
          if (((wgt)localObject).a.isEmpty()) {
            break label362;
          }
          wps.a(this.jdField_a_of_type_Wps).jdField_a_of_type_JavaUtilMap.put("1_" + localwme.a().feedId, ((StoryVideoItem)((wgt)localObject).a.get(paramInt)).mVid);
          return;
          localwme = null;
          break label93;
          if ((wps.a(this.jdField_a_of_type_Wps) == null) || (wps.a(this.jdField_a_of_type_Wps).b() != 1)) {
            break;
          }
          wps.a(this.jdField_a_of_type_Wps).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqr
 * JD-Core Version:    0.7.0.1
 */