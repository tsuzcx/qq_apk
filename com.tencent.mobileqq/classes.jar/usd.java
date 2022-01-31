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

public class usd
  extends wcr<ups>
  implements vdy
{
  public static final String KEY = "DetailTagListSegment";
  private ups jdField_a_of_type_Ups;
  private vas jdField_a_of_type_Vas;
  private vdu jdField_a_of_type_Vdu;
  private boolean b = true;
  
  public usd(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Vdu = new vdu(paramContext);
  }
  
  public void O_()
  {
    ttl.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    vel.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Ups.a.feedId });
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramvas.a(2131376862);
    String str = null;
    if ((this.jdField_a_of_type_Ups.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Ups.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Ups.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Ups.a.feedSourceTagType == 1)
      {
        paramViewGroup = vzv.b(this.jdField_a_of_type_Ups.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Ups.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Vdu.a(this.jdField_a_of_type_Ups.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_Vdu.a(this);
        if (bool2) {
          vel.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Ups.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ups.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Vdu);
        return paramvas.a();
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
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561221, paramViewGroup, false));
    return this.jdField_a_of_type_Vas;
  }
  
  public void a(ups paramups)
  {
    this.jdField_a_of_type_Ups = paramups;
  }
  
  public void a(vvh paramvvh)
  {
    ttl.a(this.jdField_a_of_type_AndroidContentContext, paramvvh);
    if (paramvvh.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      vel.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramvvh.jdField_a_of_type_Long), this.jdField_a_of_type_Ups.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      vel.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Ups.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Ups.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Ups.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Ups.a).wsSchemaForMemories;
      wcc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ups.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_Ups.a.feedId, 1, str);
      if (!vzz.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      vel.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Ups.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ups.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Ups.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usd
 * JD-Core Version:    0.7.0.1
 */