import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;

public class wlb
  extends xvp<wiq>
  implements www
{
  public static final String KEY = "DetailTagListSegment";
  private wiq jdField_a_of_type_Wiq;
  private wtq jdField_a_of_type_Wtq;
  private wws jdField_a_of_type_Wws;
  private boolean b = true;
  
  public wlb(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Wws = new wws(paramContext);
  }
  
  public void T_()
  {
    vmj.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    wxj.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Wiq.a.feedId });
  }
  
  public void W_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramwtq.a(2131377432);
    String str = null;
    if ((this.jdField_a_of_type_Wiq.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Wiq.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Wiq.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Wiq.a.feedSourceTagType == 1)
      {
        paramViewGroup = xst.b(this.jdField_a_of_type_Wiq.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Wiq.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Wws.a(this.jdField_a_of_type_Wiq.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Wws.a(this);
        if (bool2) {
          wxj.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Wiq.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Wiq.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Wws);
        return paramwtq.a();
        bool1 = true;
        continue;
        bool1 = false;
      }
    }
  }
  
  public String a()
  {
    return "DetailTagListSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561428, paramViewGroup, false));
    return this.jdField_a_of_type_Wtq;
  }
  
  public void a(wiq paramwiq)
  {
    this.jdField_a_of_type_Wiq = paramwiq;
  }
  
  public void a(xof paramxof)
  {
    vmj.a(this.jdField_a_of_type_AndroidContentContext, paramxof);
    if (paramxof.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      wxj.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramxof.jdField_a_of_type_Long), this.jdField_a_of_type_Wiq.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      wxj.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Wiq.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Wiq.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Wiq.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Wiq.a).wsSchemaForMemories;
      xva.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wiq.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Wiq.a.feedId, 1, str);
      if (!xsx.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      wxj.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Wiq.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Wiq.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Wiq.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlb
 * JD-Core Version:    0.7.0.1
 */