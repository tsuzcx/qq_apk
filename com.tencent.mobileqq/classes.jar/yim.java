import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yim
  implements HorizontalListView.OnScrollStateChangedListener, ykc, ykd, zho
{
  private int jdField_a_of_type_Int = -1;
  private yhc jdField_a_of_type_Yhc;
  
  protected yim(yhn paramyhn) {}
  
  public void N_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      zdl.a(anvx.a(2131703935), new Object[0]);
    }
    while (this.jdField_a_of_type_Yhn.jdField_a_of_type_Int == 12) {
      return;
    }
    ydz localydz = (ydz)this.jdField_a_of_type_Yhn.jdField_a_of_type_Ydd.a().get(this.jdField_a_of_type_Int);
    yhn.a(this.jdField_a_of_type_Yhn, localydz);
  }
  
  public void O_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      zdl.a(anvx.a(2131703957), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      zdl.a(anvx.a(2131703937), new Object[0]);
      return;
    }
    ydz localydz = (ydz)this.jdField_a_of_type_Yhn.jdField_a_of_type_Ydd.a().get(this.jdField_a_of_type_Int);
    if ((localydz.a() != null) && (!TextUtils.isEmpty(localydz.a().feedId)))
    {
      this.jdField_a_of_type_Yhn.jdField_a_of_type_JavaUtilMap.put(localydz.a().feedId, Integer.valueOf(paramInt2));
      ykq.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localydz.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    zdl.a(anvx.a(2131703958), new Object[0]);
    ykq.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, yhc paramyhc)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Yhc = paramyhc;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      zdl.a(anvx.a(2131703946), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        yeb localyeb = (yeb)this.jdField_a_of_type_Yhn.jdField_a_of_type_Ydd.a().get(this.jdField_a_of_type_Int);
        int i = ykv.a(localyeb.a());
        if (localyeb.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Yhn.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            ykv.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localyeb.a().feedId });
            return this.jdField_a_of_type_Yhn.jdField_a_of_type_Ydd.a(localyeb);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        ykq.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        zdl.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      zdl.a(anvx.a(2131703952), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (yhn.c(this.jdField_a_of_type_Yhn))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Yhc.a(2131374610);
        ydz localydz;
        Object localObject;
        if (this.jdField_a_of_type_Yhn.jdField_a_of_type_Ydd.a().size() > this.jdField_a_of_type_Int)
        {
          localydz = (ydz)this.jdField_a_of_type_Yhn.jdField_a_of_type_Ydd.a().get(this.jdField_a_of_type_Int);
          if ((localydz != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            ykq.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localydz);
            yhn.a(this.jdField_a_of_type_Yhn, (List)localObject, i);
            yhn.b(this.jdField_a_of_type_Yhn, (List)localObject, i);
          }
          localObject = (xyo)this.jdField_a_of_type_Yhc.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = yhn.a(this.jdField_a_of_type_Yhn);
          this.jdField_a_of_type_Yhn.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localydz == null)) {
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
          if (((xyo)localObject).a.isEmpty()) {
            break label362;
          }
          yhn.a(this.jdField_a_of_type_Yhn).jdField_a_of_type_JavaUtilMap.put("1_" + localydz.a().feedId, ((StoryVideoItem)((xyo)localObject).a.get(paramInt)).mVid);
          return;
          localydz = null;
          break label93;
          if ((yhn.a(this.jdField_a_of_type_Yhn) == null) || (yhn.a(this.jdField_a_of_type_Yhn).b() != 1)) {
            break;
          }
          yhn.a(this.jdField_a_of_type_Yhn).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yim
 * JD-Core Version:    0.7.0.1
 */