import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class vbz
  implements bfso, vdp, vdq, wdd
{
  private int jdField_a_of_type_Int = -1;
  private vap jdField_a_of_type_Vap;
  
  protected vbz(vba paramvba) {}
  
  public void P_()
  {
    if (this.jdField_a_of_type_Int == -1) {
      vxp.a(ajya.a(2131704466), new Object[0]);
    }
    while (this.jdField_a_of_type_Vba.jdField_a_of_type_Int == 12) {
      return;
    }
    uxm localuxm = (uxm)this.jdField_a_of_type_Vba.jdField_a_of_type_Uwq.a().get(this.jdField_a_of_type_Int);
    vba.a(this.jdField_a_of_type_Vba, localuxm);
  }
  
  public void Q_() {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      vxp.a(ajya.a(2131704488), new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      vxp.a(ajya.a(2131704468), new Object[0]);
      return;
    }
    uxm localuxm = (uxm)this.jdField_a_of_type_Vba.jdField_a_of_type_Uwq.a().get(this.jdField_a_of_type_Int);
    if ((localuxm.a() != null) && (!TextUtils.isEmpty(localuxm.a().feedId)))
    {
      this.jdField_a_of_type_Vba.jdField_a_of_type_JavaUtilMap.put(localuxm.a().feedId, Integer.valueOf(paramInt2));
      ved.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localuxm.a().feedId, Integer.valueOf(paramInt2));
      return;
    }
    vxp.a(ajya.a(2131704489), new Object[0]);
    ved.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
  }
  
  public void a(int paramInt, vap paramvap)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vap = paramvap;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      vxp.a(ajya.a(2131704477), new Object[0]);
      return false;
    }
    for (;;)
    {
      try
      {
        uxo localuxo = (uxo)this.jdField_a_of_type_Vba.jdField_a_of_type_Uwq.a().get(this.jdField_a_of_type_Int);
        int i = vei.a(localuxo.a());
        if (localuxo.a().getOwner().isMe())
        {
          String str1 = "1";
          if (this.jdField_a_of_type_Vba.jdField_a_of_type_Int == 10)
          {
            str3 = "1";
            vei.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localuxo.a().feedId });
            return this.jdField_a_of_type_Vba.jdField_a_of_type_Uwq.a(localuxo);
          }
          String str3 = "3";
          continue;
        }
        String str2 = "2";
      }
      catch (Exception localException)
      {
        ved.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
        vxp.a(localException.getMessage(), new Object[0]);
        return false;
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == -1)
    {
      vxp.a(ajya.a(2131704483), new Object[0]);
      break label22;
    }
    label22:
    label93:
    label361:
    label362:
    for (;;)
    {
      return;
      if (vba.c(this.jdField_a_of_type_Vba))
      {
        StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.jdField_a_of_type_Vap.a(2131373264);
        uxm localuxm;
        Object localObject;
        if (this.jdField_a_of_type_Vba.jdField_a_of_type_Uwq.a().size() > this.jdField_a_of_type_Int)
        {
          localuxm = (uxm)this.jdField_a_of_type_Vba.jdField_a_of_type_Uwq.a().get(this.jdField_a_of_type_Int);
          if ((localuxm != null) && ((paramInt == 4097) || (paramInt == 4098)))
          {
            int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            int i = k;
            if (k < 0) {
              i = 0;
            }
            ved.a("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
            localObject = new ArrayList();
            ((List)localObject).add(localuxm);
            vba.a(this.jdField_a_of_type_Vba, (List)localObject, i);
            vba.b(this.jdField_a_of_type_Vba, (List)localObject, i);
          }
          localObject = (usb)this.jdField_a_of_type_Vap.a("general_adapter");
          if (paramInt != 4097) {
            break label326;
          }
          paramInt = vba.a(this.jdField_a_of_type_Vba);
          this.jdField_a_of_type_Vba.b(paramInt);
          if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localuxm == null)) {
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
          if (((usb)localObject).a.isEmpty()) {
            break label362;
          }
          vba.a(this.jdField_a_of_type_Vba).jdField_a_of_type_JavaUtilMap.put("1_" + localuxm.a().feedId, ((StoryVideoItem)((usb)localObject).a.get(paramInt)).mVid);
          return;
          localuxm = null;
          break label93;
          if ((vba.a(this.jdField_a_of_type_Vba) == null) || (vba.a(this.jdField_a_of_type_Vba).b() != 1)) {
            break;
          }
          vba.a(this.jdField_a_of_type_Vba).b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbz
 * JD-Core Version:    0.7.0.1
 */