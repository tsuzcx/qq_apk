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

public class yem
  extends zpa<ycb>
  implements yqh
{
  public static final String KEY = "DetailTagListSegment";
  private ycb jdField_a_of_type_Ycb;
  private ynb jdField_a_of_type_Ynb;
  private yqd jdField_a_of_type_Yqd;
  private boolean b = true;
  
  public yem(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yqd = new yqd(paramContext);
  }
  
  public void Q_()
  {
    xfv.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    yqu.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Ycb.a.feedId });
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null) && (this.jdField_a_of_type_Ycb.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramynb.a(2131378261);
    String str = null;
    if ((this.jdField_a_of_type_Ycb.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Ycb.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Ycb.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Ycb.a.feedSourceTagType == 1)
      {
        paramViewGroup = zme.b(this.jdField_a_of_type_Ycb.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Ycb.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Yqd.a(this.jdField_a_of_type_Ycb.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Yqd.a(this);
        if (bool2) {
          yqu.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Ycb.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ycb.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Yqd);
        return paramynb.a();
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
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561664, paramViewGroup, false));
    return this.jdField_a_of_type_Ynb;
  }
  
  public void a(ycb paramycb)
  {
    this.jdField_a_of_type_Ycb = paramycb;
  }
  
  public void a(zhq paramzhq)
  {
    xfv.a(this.jdField_a_of_type_AndroidContentContext, paramzhq);
    if (paramzhq.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      yqu.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramzhq.jdField_a_of_type_Long), this.jdField_a_of_type_Ycb.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      yqu.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Ycb.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Ycb.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Ycb.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Ycb.a).wsSchemaForMemories;
      zol.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ycb.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Ycb.a.feedId, 1, str);
      if (!zmi.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      yqu.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Ycb.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ycb.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Ycb.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yem
 * JD-Core Version:    0.7.0.1
 */