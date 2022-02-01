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

public class xyn
  extends zgz<xwc>
  implements yki
{
  public static final String KEY = "DetailTagListSegment";
  private xwc jdField_a_of_type_Xwc;
  private yhc jdField_a_of_type_Yhc;
  private yke jdField_a_of_type_Yke;
  private boolean b = true;
  
  public xyn(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yke = new yke(paramContext);
  }
  
  public void M_()
  {
    xab.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    ykv.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Xwc.a.feedId });
  }
  
  public void P_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramyhc.a(2131378473);
    String str = null;
    if ((this.jdField_a_of_type_Xwc.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Xwc.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Xwc.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Xwc.a.feedSourceTagType == 1)
      {
        paramViewGroup = zfj.b(this.jdField_a_of_type_Xwc.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Xwc.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Yke.a(this.jdField_a_of_type_Xwc.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Yke.a(this);
        if (bool2) {
          ykv.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Xwc.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Xwc.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Yke);
        return paramyhc.a();
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
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561653, paramViewGroup, false));
    return this.jdField_a_of_type_Yhc;
  }
  
  public void a(xwc paramxwc)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
  }
  
  public void a(zbe paramzbe)
  {
    xab.a(this.jdField_a_of_type_AndroidContentContext, paramzbe);
    if (paramzbe.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      ykv.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramzbe.jdField_a_of_type_Long), this.jdField_a_of_type_Xwc.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      ykv.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Xwc.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Xwc.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Xwc.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Xwc.a).wsSchemaForMemories;
      zgk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xwc.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Xwc.a.feedId, 1, str);
      if (!zfn.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      ykv.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Xwc.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Xwc.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Xwc.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyn
 * JD-Core Version:    0.7.0.1
 */