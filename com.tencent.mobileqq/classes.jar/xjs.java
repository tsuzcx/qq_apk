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

public class xjs
  extends ysg<xhh>
  implements xvn
{
  public static final String KEY = "DetailTagListSegment";
  private xhh jdField_a_of_type_Xhh;
  private xsh jdField_a_of_type_Xsh;
  private xvj jdField_a_of_type_Xvj;
  private boolean b = true;
  
  public xjs(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Xvj = new xvj(paramContext);
  }
  
  public void K_()
  {
    wlg.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    xwa.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Xhh.a.feedId });
  }
  
  public void N_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramxsh.a(2131378185);
    String str = null;
    if ((this.jdField_a_of_type_Xhh.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Xhh.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Xhh.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Xhh.a.feedSourceTagType == 1)
      {
        paramViewGroup = yqq.b(this.jdField_a_of_type_Xhh.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Xhh.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Xvj.a(this.jdField_a_of_type_Xhh.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Xvj.a(this);
        if (bool2) {
          xwa.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Xhh.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Xhh.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Xvj);
        return paramxsh.a();
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
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561585, paramViewGroup, false));
    return this.jdField_a_of_type_Xsh;
  }
  
  public void a(xhh paramxhh)
  {
    this.jdField_a_of_type_Xhh = paramxhh;
  }
  
  public void a(yml paramyml)
  {
    wlg.a(this.jdField_a_of_type_AndroidContentContext, paramyml);
    if (paramyml.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      xwa.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramyml.jdField_a_of_type_Long), this.jdField_a_of_type_Xhh.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      xwa.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Xhh.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Xhh.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Xhh.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Xhh.a).wsSchemaForMemories;
      yrr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xhh.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Xhh.a.feedId, 1, str);
      if (!yqu.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      xwa.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Xhh.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Xhh.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Xhh.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjs
 * JD-Core Version:    0.7.0.1
 */