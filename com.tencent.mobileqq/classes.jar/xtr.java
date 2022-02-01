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

public class xtr
  implements HorizontalListView.OnScrollStateChangedListener, xvh, xvi, ysv
{
  private int jdField_a_of_type_Int = -1;
  private xsh jdField_a_of_type_Xsh;
  
  protected xtr(xss paramxss) {}
  
  public void L_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      yos.a(amtj.a(2131703584), new Object[0]);
    }
    while (this.jdField_a_of_type_Xss.jdField_a_of_type_Int == 12) {
      return;
    }
    xpe localxpe = (xpe)this.jdField_a_of_type_Xss.jdField_a_of_type_Xoi.a().get(this.jdField_a_of_type_Int);
    xss.a(this.jdField_a_of_type_Xss, localxpe);
  }
  
  public void M_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      yos.a(amtj.a(2131703606), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      yos.a(amtj.a(2131703586), new Object[0]);
      return;
    }
    xpe localxpe = (xpe)this.jdField_a_of_type_Xss.jdField_a_of_type_Xoi.a().get(this.jdField_a_of_type_Int);
    if ((localxpe.a() != null) && (!TextUtils.isEmpty(localxpe.a().feedId)))
    {
      this.jdField_a_of_type_Xss.jdField_a_of_type_JavaUtilMap.put(localxpe.a().feedId, Integer.valueOf(paramInt2));
      xvv.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localxpe.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    yos.a(amtj.a(2131703607), new Object[0]);
    xvv.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, xsh paramxsh)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xsh = paramxsh;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      yos.a(amtj.a(2131703595), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        xpg localxpg = (xpg)this.jdField_a_of_type_Xss.jdField_a_of_type_Xoi.a().get(this.jdField_a_of_type_Int);
        int i = xwa.a(localxpg.a());
        if (localxpg.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Xss.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            xwa.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localxpg.a().feedId });
            return this.jdField_a_of_type_Xss.jdField_a_of_type_Xoi.a(localxpg);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        xvv.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        yos.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      yos.a(amtj.a(2131703601), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (xss.c(this.jdField_a_of_type_Xss))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Xsh.a(2131374372);
        xpe localxpe;
        Object localObject;
        if (this.jdField_a_of_type_Xss.jdField_a_of_type_Xoi.a().size() > this.jdField_a_of_type_Int)
        {
          localxpe = (xpe)this.jdField_a_of_type_Xss.jdField_a_of_type_Xoi.a().get(this.jdField_a_of_type_Int);
          if ((localxpe != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            xvv.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localxpe);
            xss.a(this.jdField_a_of_type_Xss, (List)localObject, i);
            xss.b(this.jdField_a_of_type_Xss, (List)localObject, i);
          }
          localObject = (xjt)this.jdField_a_of_type_Xsh.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = xss.a(this.jdField_a_of_type_Xss);
          this.jdField_a_of_type_Xss.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localxpe == null)) {
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
          if (((xjt)localObject).a.isEmpty()) {
            break label362;
          }
          xss.a(this.jdField_a_of_type_Xss).jdField_a_of_type_JavaUtilMap.put("1_" + localxpe.a().feedId, ((StoryVideoItem)((xjt)localObject).a.get(paramInt)).mVid);
          return;
          localxpe = null;
          break label93;
          if ((xss.a(this.jdField_a_of_type_Xss) == null) || (xss.a(this.jdField_a_of_type_Xss).b() != 1)) {
            break;
          }
          xss.a(this.jdField_a_of_type_Xss).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtr
 * JD-Core Version:    0.7.0.1
 */