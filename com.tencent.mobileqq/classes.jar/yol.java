import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yol
  implements bkle, yqb, yqc, zpp
{
  private int jdField_a_of_type_Int = -1;
  private ynb jdField_a_of_type_Ynb;
  
  protected yol(ynm paramynm) {}
  
  public void R_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      zkb.a(anni.a(2131703247), new Object[0]);
    }
    while (this.jdField_a_of_type_Ynm.jdField_a_of_type_Int == 12) {
      return;
    }
    yjy localyjy = (yjy)this.jdField_a_of_type_Ynm.jdField_a_of_type_Yjc.a().get(this.jdField_a_of_type_Int);
    ynm.a(this.jdField_a_of_type_Ynm, localyjy);
  }
  
  public void S_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      zkb.a(anni.a(2131703269), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      zkb.a(anni.a(2131703249), new Object[0]);
      return;
    }
    yjy localyjy = (yjy)this.jdField_a_of_type_Ynm.jdField_a_of_type_Yjc.a().get(this.jdField_a_of_type_Int);
    if ((localyjy.a() != null) && (!TextUtils.isEmpty(localyjy.a().feedId)))
    {
      this.jdField_a_of_type_Ynm.jdField_a_of_type_JavaUtilMap.put(localyjy.a().feedId, Integer.valueOf(paramInt2));
      yqp.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localyjy.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    zkb.a(anni.a(2131703270), new Object[0]);
    yqp.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, ynb paramynb)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ynb = paramynb;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      zkb.a(anni.a(2131703258), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        yka localyka = (yka)this.jdField_a_of_type_Ynm.jdField_a_of_type_Yjc.a().get(this.jdField_a_of_type_Int);
        int i = yqu.a(localyka.a());
        if (localyka.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Ynm.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            yqu.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localyka.a().feedId });
            return this.jdField_a_of_type_Ynm.jdField_a_of_type_Yjc.a(localyka);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        yqp.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        zkb.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      zkb.a(anni.a(2131703264), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (ynm.c(this.jdField_a_of_type_Ynm))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Ynb.a(2131374467);
        yjy localyjy;
        Object localObject;
        if (this.jdField_a_of_type_Ynm.jdField_a_of_type_Yjc.a().size() > this.jdField_a_of_type_Int)
        {
          localyjy = (yjy)this.jdField_a_of_type_Ynm.jdField_a_of_type_Yjc.a().get(this.jdField_a_of_type_Int);
          if ((localyjy != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            yqp.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localyjy);
            ynm.a(this.jdField_a_of_type_Ynm, (List)localObject, i);
            ynm.b(this.jdField_a_of_type_Ynm, (List)localObject, i);
          }
          localObject = (yen)this.jdField_a_of_type_Ynb.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = ynm.a(this.jdField_a_of_type_Ynm);
          this.jdField_a_of_type_Ynm.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localyjy == null)) {
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
          if (((yen)localObject).a.isEmpty()) {
            break label362;
          }
          ynm.a(this.jdField_a_of_type_Ynm).jdField_a_of_type_JavaUtilMap.put("1_" + localyjy.a().feedId, ((StoryVideoItem)((yen)localObject).a.get(paramInt)).mVid);
          return;
          localyjy = null;
          break label93;
          if ((ynm.a(this.jdField_a_of_type_Ynm) == null) || (ynm.a(this.jdField_a_of_type_Ynm).b() != 1)) {
            break;
          }
          ynm.a(this.jdField_a_of_type_Ynm).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yol
 * JD-Core Version:    0.7.0.1
 */