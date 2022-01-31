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

public class usa
  extends wco<upp>
  implements vdv
{
  public static final String KEY = "DetailTagListSegment";
  private upp jdField_a_of_type_Upp;
  private vap jdField_a_of_type_Vap;
  private vdr jdField_a_of_type_Vdr;
  private boolean b = true;
  
  public usa(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Vdr = new vdr(paramContext);
  }
  
  public void O_()
  {
    tti.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    vei.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Upp.a.feedId });
  }
  
  public void R_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramvap.a(2131376864);
    String str = null;
    if ((this.jdField_a_of_type_Upp.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Upp.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Upp.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Upp.a.feedSourceTagType == 1)
      {
        paramViewGroup = vzs.b(this.jdField_a_of_type_Upp.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Upp.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Vdr.a(this.jdField_a_of_type_Upp.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Vdr.a(this);
        if (bool2) {
          vei.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Upp.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Upp.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Vdr);
        return paramvap.a();
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
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561220, paramViewGroup, false));
    return this.jdField_a_of_type_Vap;
  }
  
  public void a(upp paramupp)
  {
    this.jdField_a_of_type_Upp = paramupp;
  }
  
  public void a(vve paramvve)
  {
    tti.a(this.jdField_a_of_type_AndroidContentContext, paramvve);
    if (paramvve.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      vei.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramvve.jdField_a_of_type_Long), this.jdField_a_of_type_Upp.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      vei.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Upp.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Upp.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Upp.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Upp.a).wsSchemaForMemories;
      wbz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Upp.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Upp.a.feedId, 1, str);
      if (!vzw.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      vei.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Upp.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Upp.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Upp.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usa
 * JD-Core Version:    0.7.0.1
 */