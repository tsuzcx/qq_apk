import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ysg
  implements blmh, ytw, ytx, ztk
{
  private int jdField_a_of_type_Int = -1;
  private yqw jdField_a_of_type_Yqw;
  
  protected ysg(yrh paramyrh) {}
  
  public void R_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      znw.a(anzj.a(2131703354), new Object[0]);
    }
    while (this.jdField_a_of_type_Yrh.jdField_a_of_type_Int == 12) {
      return;
    }
    ynt localynt = (ynt)this.jdField_a_of_type_Yrh.jdField_a_of_type_Ymx.a().get(this.jdField_a_of_type_Int);
    yrh.a(this.jdField_a_of_type_Yrh, localynt);
  }
  
  public void S_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      znw.a(anzj.a(2131703376), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      znw.a(anzj.a(2131703356), new Object[0]);
      return;
    }
    ynt localynt = (ynt)this.jdField_a_of_type_Yrh.jdField_a_of_type_Ymx.a().get(this.jdField_a_of_type_Int);
    if ((localynt.a() != null) && (!TextUtils.isEmpty(localynt.a().feedId)))
    {
      this.jdField_a_of_type_Yrh.jdField_a_of_type_JavaUtilMap.put(localynt.a().feedId, Integer.valueOf(paramInt2));
      yuk.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localynt.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    znw.a(anzj.a(2131703377), new Object[0]);
    yuk.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, yqw paramyqw)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Yqw = paramyqw;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      znw.a(anzj.a(2131703365), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        ynv localynv = (ynv)this.jdField_a_of_type_Yrh.jdField_a_of_type_Ymx.a().get(this.jdField_a_of_type_Int);
        int i = yup.a(localynv.a());
        if (localynv.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Yrh.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            yup.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localynv.a().feedId });
            return this.jdField_a_of_type_Yrh.jdField_a_of_type_Ymx.a(localynv);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        yuk.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        znw.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      znw.a(anzj.a(2131703371), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (yrh.c(this.jdField_a_of_type_Yrh))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Yqw.a(2131374604);
        ynt localynt;
        Object localObject;
        if (this.jdField_a_of_type_Yrh.jdField_a_of_type_Ymx.a().size() > this.jdField_a_of_type_Int)
        {
          localynt = (ynt)this.jdField_a_of_type_Yrh.jdField_a_of_type_Ymx.a().get(this.jdField_a_of_type_Int);
          if ((localynt != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            yuk.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localynt);
            yrh.a(this.jdField_a_of_type_Yrh, (List)localObject, i);
            yrh.b(this.jdField_a_of_type_Yrh, (List)localObject, i);
          }
          localObject = (yii)this.jdField_a_of_type_Yqw.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = yrh.a(this.jdField_a_of_type_Yrh);
          this.jdField_a_of_type_Yrh.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localynt == null)) {
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
          if (((yii)localObject).a.isEmpty()) {
            break label362;
          }
          yrh.a(this.jdField_a_of_type_Yrh).jdField_a_of_type_JavaUtilMap.put("1_" + localynt.a().feedId, ((StoryVideoItem)((yii)localObject).a.get(paramInt)).mVid);
          return;
          localynt = null;
          break label93;
          if ((yrh.a(this.jdField_a_of_type_Yrh) == null) || (yrh.a(this.jdField_a_of_type_Yrh).b() != 1)) {
            break;
          }
          yrh.a(this.jdField_a_of_type_Yrh).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysg
 * JD-Core Version:    0.7.0.1
 */