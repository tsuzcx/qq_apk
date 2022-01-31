import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class wva
  implements bhxs, wwq, wwr, xwe
{
  private int jdField_a_of_type_Int = -1;
  private wtq jdField_a_of_type_Wtq;
  
  protected wva(wub paramwub) {}
  
  public void U_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      xqq.a(alud.a(2131704850), new Object[0]);
    }
    while (this.jdField_a_of_type_Wub.jdField_a_of_type_Int == 12) {
      return;
    }
    wqn localwqn = (wqn)this.jdField_a_of_type_Wub.jdField_a_of_type_Wpr.a().get(this.jdField_a_of_type_Int);
    wub.a(this.jdField_a_of_type_Wub, localwqn);
  }
  
  public void V_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      xqq.a(alud.a(2131704872), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      xqq.a(alud.a(2131704852), new Object[0]);
      return;
    }
    wqn localwqn = (wqn)this.jdField_a_of_type_Wub.jdField_a_of_type_Wpr.a().get(this.jdField_a_of_type_Int);
    if ((localwqn.a() != null) && (!TextUtils.isEmpty(localwqn.a().feedId)))
    {
      this.jdField_a_of_type_Wub.jdField_a_of_type_JavaUtilMap.put(localwqn.a().feedId, Integer.valueOf(paramInt2));
      wxe.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localwqn.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    xqq.a(alud.a(2131704873), new Object[0]);
    wxe.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, wtq paramwtq)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wtq = paramwtq;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      xqq.a(alud.a(2131704861), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        wqp localwqp = (wqp)this.jdField_a_of_type_Wub.jdField_a_of_type_Wpr.a().get(this.jdField_a_of_type_Int);
        int i = wxj.a(localwqp.a());
        if (localwqp.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Wub.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            wxj.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localwqp.a().feedId });
            return this.jdField_a_of_type_Wub.jdField_a_of_type_Wpr.a(localwqp);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        wxe.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        xqq.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      xqq.a(alud.a(2131704867), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (wub.c(this.jdField_a_of_type_Wub))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Wtq.a(2131373764);
        wqn localwqn;
        Object localObject;
        if (this.jdField_a_of_type_Wub.jdField_a_of_type_Wpr.a().size() > this.jdField_a_of_type_Int)
        {
          localwqn = (wqn)this.jdField_a_of_type_Wub.jdField_a_of_type_Wpr.a().get(this.jdField_a_of_type_Int);
          if ((localwqn != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            wxe.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localwqn);
            wub.a(this.jdField_a_of_type_Wub, (List)localObject, i);
            wub.b(this.jdField_a_of_type_Wub, (List)localObject, i);
          }
          localObject = (wlc)this.jdField_a_of_type_Wtq.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = wub.a(this.jdField_a_of_type_Wub);
          this.jdField_a_of_type_Wub.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localwqn == null)) {
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
          if (((wlc)localObject).a.isEmpty()) {
            break label362;
          }
          wub.a(this.jdField_a_of_type_Wub).jdField_a_of_type_JavaUtilMap.put("1_" + localwqn.a().feedId, ((StoryVideoItem)((wlc)localObject).a.get(paramInt)).mVid);
          return;
          localwqn = null;
          break label93;
          if ((wub.a(this.jdField_a_of_type_Wub) == null) || (wub.a(this.jdField_a_of_type_Wub).b() != 1)) {
            break;
          }
          wub.a(this.jdField_a_of_type_Wub).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wva
 * JD-Core Version:    0.7.0.1
 */