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

public class wgs
  extends xrg<weh>
  implements wsn
{
  public static final String KEY = "DetailTagListSegment";
  private weh jdField_a_of_type_Weh;
  private wph jdField_a_of_type_Wph;
  private wsj jdField_a_of_type_Wsj;
  private boolean b = true;
  
  public wgs(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Wsj = new wsj(paramContext);
  }
  
  public void W_()
  {
    via.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    wta.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Weh.a.feedId });
  }
  
  public void Z_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramwph.a(2131377378);
    String str = null;
    if ((this.jdField_a_of_type_Weh.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Weh.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Weh.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Weh.a.feedSourceTagType == 1)
      {
        paramViewGroup = xok.b(this.jdField_a_of_type_Weh.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Weh.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Wsj.a(this.jdField_a_of_type_Weh.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Wsj.a(this);
        if (bool2) {
          wta.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Weh.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Weh.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Wsj);
        return paramwph.a();
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
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561410, paramViewGroup, false));
    return this.jdField_a_of_type_Wph;
  }
  
  public void a(weh paramweh)
  {
    this.jdField_a_of_type_Weh = paramweh;
  }
  
  public void a(xjw paramxjw)
  {
    via.a(this.jdField_a_of_type_AndroidContentContext, paramxjw);
    if (paramxjw.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      wta.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramxjw.jdField_a_of_type_Long), this.jdField_a_of_type_Weh.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      wta.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Weh.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Weh.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Weh.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Weh.a).wsSchemaForMemories;
      xqr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Weh.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Weh.a.feedId, 1, str);
      if (!xoo.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      wta.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Weh.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Weh.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Weh.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */