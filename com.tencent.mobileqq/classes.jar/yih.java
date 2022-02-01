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

public class yih
  extends zsv<yfw>
  implements yuc
{
  public static final String KEY = "DetailTagListSegment";
  private yfw jdField_a_of_type_Yfw;
  private yqw jdField_a_of_type_Yqw;
  private yty jdField_a_of_type_Yty;
  private boolean b = true;
  
  public yih(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yty = new yty(paramContext);
  }
  
  public void Q_()
  {
    xjq.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    yup.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Yfw.a.feedId });
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null) && (this.jdField_a_of_type_Yfw.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramyqw.a(2131378418);
    String str = null;
    if ((this.jdField_a_of_type_Yfw.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Yfw.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Yfw.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Yfw.a.feedSourceTagType == 1)
      {
        paramViewGroup = zpz.b(this.jdField_a_of_type_Yfw.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Yfw.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Yty.a(this.jdField_a_of_type_Yfw.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Yty.a(this);
        if (bool2) {
          yup.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Yfw.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Yfw.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Yty);
        return paramyqw.a();
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
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561705, paramViewGroup, false));
    return this.jdField_a_of_type_Yqw;
  }
  
  public void a(yfw paramyfw)
  {
    this.jdField_a_of_type_Yfw = paramyfw;
  }
  
  public void a(zll paramzll)
  {
    xjq.a(this.jdField_a_of_type_AndroidContentContext, paramzll);
    if (paramzll.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      yup.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramzll.jdField_a_of_type_Long), this.jdField_a_of_type_Yfw.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      yup.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Yfw.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Yfw.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Yfw.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Yfw.a).wsSchemaForMemories;
      zsg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Yfw.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Yfw.a.feedId, 1, str);
      if (!zqd.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      yup.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Yfw.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Yfw.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Yfw.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yih
 * JD-Core Version:    0.7.0.1
 */