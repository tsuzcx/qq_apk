import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class vcc
  implements bfrx, vds, vdt, wdg
{
  private int jdField_a_of_type_Int = -1;
  private vas jdField_a_of_type_Vas;
  
  protected vcc(vbd paramvbd) {}
  
  public void P_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      vxs.a(ajyc.a(2131704455), new Object[0]);
    }
    while (this.jdField_a_of_type_Vbd.jdField_a_of_type_Int == 12) {
      return;
    }
    uxp localuxp = (uxp)this.jdField_a_of_type_Vbd.jdField_a_of_type_Uwt.a().get(this.jdField_a_of_type_Int);
    vbd.a(this.jdField_a_of_type_Vbd, localuxp);
  }
  
  public void Q_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      vxs.a(ajyc.a(2131704477), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      vxs.a(ajyc.a(2131704457), new Object[0]);
      return;
    }
    uxp localuxp = (uxp)this.jdField_a_of_type_Vbd.jdField_a_of_type_Uwt.a().get(this.jdField_a_of_type_Int);
    if ((localuxp.a() != null) && (!TextUtils.isEmpty(localuxp.a().feedId)))
    {
      this.jdField_a_of_type_Vbd.jdField_a_of_type_JavaUtilMap.put(localuxp.a().feedId, Integer.valueOf(paramInt2));
      veg.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localuxp.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    vxs.a(ajyc.a(2131704478), new Object[0]);
    veg.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, vas paramvas)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vas = paramvas;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      vxs.a(ajyc.a(2131704466), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        uxr localuxr = (uxr)this.jdField_a_of_type_Vbd.jdField_a_of_type_Uwt.a().get(this.jdField_a_of_type_Int);
        int i = vel.a(localuxr.a());
        if (localuxr.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Vbd.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            vel.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localuxr.a().feedId });
            return this.jdField_a_of_type_Vbd.jdField_a_of_type_Uwt.a(localuxr);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        veg.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        vxs.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      vxs.a(ajyc.a(2131704472), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (vbd.c(this.jdField_a_of_type_Vbd))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Vas.a(2131373262);
        uxp localuxp;
        Object localObject;
        if (this.jdField_a_of_type_Vbd.jdField_a_of_type_Uwt.a().size() > this.jdField_a_of_type_Int)
        {
          localuxp = (uxp)this.jdField_a_of_type_Vbd.jdField_a_of_type_Uwt.a().get(this.jdField_a_of_type_Int);
          if ((localuxp != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            veg.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localuxp);
            vbd.a(this.jdField_a_of_type_Vbd, (List)localObject, i);
            vbd.b(this.jdField_a_of_type_Vbd, (List)localObject, i);
          }
          localObject = (use)this.jdField_a_of_type_Vas.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = vbd.a(this.jdField_a_of_type_Vbd);
          this.jdField_a_of_type_Vbd.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localuxp == null)) {
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
          if (((use)localObject).a.isEmpty()) {
            break label362;
          }
          vbd.a(this.jdField_a_of_type_Vbd).jdField_a_of_type_JavaUtilMap.put("1_" + localuxp.a().feedId, ((StoryVideoItem)((use)localObject).a.get(paramInt)).mVid);
          return;
          localuxp = null;
          break label93;
          if ((vbd.a(this.jdField_a_of_type_Vbd) == null) || (vbd.a(this.jdField_a_of_type_Vbd).b() != 1)) {
            break;
          }
          vbd.a(this.jdField_a_of_type_Vbd).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcc
 * JD-Core Version:    0.7.0.1
 */