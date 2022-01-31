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

public class ufh
  extends vpv<ucw>
  implements urc
{
  public static final String KEY = "DetailTagListSegment";
  private ucw jdField_a_of_type_Ucw;
  private unw jdField_a_of_type_Unw;
  private uqy jdField_a_of_type_Uqy;
  private boolean b = true;
  
  public ufh(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Uqy = new uqy(paramContext);
  }
  
  public void Q_()
  {
    tgp.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    urp.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Ucw.a.feedId });
  }
  
  public void T_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramunw.a(2131311053);
    String str = null;
    if ((this.jdField_a_of_type_Ucw.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Ucw.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Ucw.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Ucw.a.feedSourceTagType == 1)
      {
        paramViewGroup = vmz.b(this.jdField_a_of_type_Ucw.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Ucw.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Uqy.a(this.jdField_a_of_type_Ucw.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Uqy.a(this);
        if (bool2) {
          urp.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Ucw.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ucw.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Uqy);
        return paramunw.a();
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
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495630, paramViewGroup, false));
    return this.jdField_a_of_type_Unw;
  }
  
  public void a(ucw paramucw)
  {
    this.jdField_a_of_type_Ucw = paramucw;
  }
  
  public void a(vil paramvil)
  {
    tgp.a(this.jdField_a_of_type_AndroidContentContext, paramvil);
    if (paramvil.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      urp.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramvil.jdField_a_of_type_Long), this.jdField_a_of_type_Ucw.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      urp.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Ucw.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Ucw.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Ucw.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Ucw.a).wsSchemaForMemories;
      vpg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ucw.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Ucw.a.feedId, 1, str);
      if (!vnd.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      urp.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Ucw.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ucw.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Ucw.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */