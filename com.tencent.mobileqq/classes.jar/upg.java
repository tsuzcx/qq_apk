import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class upg
  implements bekd, uqw, uqx, vqk
{
  private int jdField_a_of_type_Int = -1;
  private unw jdField_a_of_type_Unw;
  
  protected upg(uoh paramuoh) {}
  
  public void R_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      vkw.a(ajjy.a(2131638670), new Object[0]);
    }
    while (this.jdField_a_of_type_Uoh.jdField_a_of_type_Int == 12) {
      return;
    }
    ukt localukt = (ukt)this.jdField_a_of_type_Uoh.jdField_a_of_type_Ujx.a().get(this.jdField_a_of_type_Int);
    uoh.a(this.jdField_a_of_type_Uoh, localukt);
  }
  
  public void S_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      vkw.a(ajjy.a(2131638692), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      vkw.a(ajjy.a(2131638672), new Object[0]);
      return;
    }
    ukt localukt = (ukt)this.jdField_a_of_type_Uoh.jdField_a_of_type_Ujx.a().get(this.jdField_a_of_type_Int);
    if ((localukt.a() != null) && (!TextUtils.isEmpty(localukt.a().feedId)))
    {
      this.jdField_a_of_type_Uoh.jdField_a_of_type_JavaUtilMap.put(localukt.a().feedId, Integer.valueOf(paramInt2));
      urk.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localukt.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    vkw.a(ajjy.a(2131638693), new Object[0]);
    urk.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, unw paramunw)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Unw = paramunw;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      vkw.a(ajjy.a(2131638681), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        ukv localukv = (ukv)this.jdField_a_of_type_Uoh.jdField_a_of_type_Ujx.a().get(this.jdField_a_of_type_Int);
        int i = urp.a(localukv.a());
        if (localukv.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Uoh.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            urp.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localukv.a().feedId });
            return this.jdField_a_of_type_Uoh.jdField_a_of_type_Ujx.a(localukv);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        urk.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        vkw.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      vkw.a(ajjy.a(2131638687), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (uoh.c(this.jdField_a_of_type_Uoh))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Unw.a(2131307549);
        ukt localukt;
        Object localObject;
        if (this.jdField_a_of_type_Uoh.jdField_a_of_type_Ujx.a().size() > this.jdField_a_of_type_Int)
        {
          localukt = (ukt)this.jdField_a_of_type_Uoh.jdField_a_of_type_Ujx.a().get(this.jdField_a_of_type_Int);
          if ((localukt != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            urk.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localukt);
            uoh.a(this.jdField_a_of_type_Uoh, (List)localObject, i);
            uoh.b(this.jdField_a_of_type_Uoh, (List)localObject, i);
          }
          localObject = (ufi)this.jdField_a_of_type_Unw.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = uoh.a(this.jdField_a_of_type_Uoh);
          this.jdField_a_of_type_Uoh.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localukt == null)) {
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
          if (((ufi)localObject).a.isEmpty()) {
            break label362;
          }
          uoh.a(this.jdField_a_of_type_Uoh).jdField_a_of_type_JavaUtilMap.put("1_" + localukt.a().feedId, ((StoryVideoItem)((ufi)localObject).a.get(paramInt)).mVid);
          return;
          localukt = null;
          break label93;
          if ((uoh.a(this.jdField_a_of_type_Uoh) == null) || (uoh.a(this.jdField_a_of_type_Uoh).b() != 1)) {
            break;
          }
          uoh.a(this.jdField_a_of_type_Uoh).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upg
 * JD-Core Version:    0.7.0.1
 */