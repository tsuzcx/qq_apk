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

public class qtb
  extends rsd<qru>
  implements rae.a
{
  public static final String KEY = "DetailTagListSegment";
  private qru jdField_a_of_type_Qru;
  private rae jdField_a_of_type_Rae;
  private boolean aFo = true;
  private qyd b;
  
  public qtb(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Rae = new rae(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramqyd.get(2131379216);
    String str = null;
    if ((this.jdField_a_of_type_Qru.d instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_Qru.d).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_Qru.b();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_Qru.d.feedSourceTagType == 1)
      {
        paramViewGroup = rpu.ci(this.jdField_a_of_type_Qru.d.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_Qru.d.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Rae.a(this.jdField_a_of_type_Qru.bT(), str, this.aFo, bool1, paramViewGroup);
        this.jdField_a_of_type_Rae.a(this);
        if (bool2) {
          rar.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_Qru.d.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Qru.d.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_Rae);
        return paramqyd.getItemView();
        bool1 = true;
        continue;
        bool1 = false;
      }
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new qyd(LayoutInflater.from(this.context).inflate(2131561821, paramViewGroup, false));
    return this.b;
  }
  
  public void a(rmw.a parama)
  {
    qev.a(this.context, parama);
    if (parama.type == 0) {}
    for (String str = "1";; str = "2")
    {
      rar.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(parama.id), this.jdField_a_of_type_Qru.d.feedId });
      return;
    }
  }
  
  public void bms()
  {
    qev.ba(this.context, "com.tencent.qim");
    rar.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_Qru.d.feedId });
  }
  
  public void bmt()
  {
    String str;
    if (this.jdField_a_of_type_Qru.d.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_Qru.d.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_Qru.d).wsSchemaForMemories;
      rrt.a(this.context, this.jdField_a_of_type_Qru.d.getOwner().getUnionId(), "2", this.jdField_a_of_type_Qru.d.feedId, 1, str);
      if (!rpw.isWeishiInstalled(this.context)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      rar.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_Qru.d.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Qru.d.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_Qru.d).wsSchemaForMemories;
      break;
    }
  }
  
  public void bqo()
  {
    if (((StoryDetailListView)a()).Kx())
    {
      this.isDisplay = true;
      return;
    }
    this.isDisplay = false;
  }
  
  public void c(qru paramqru)
  {
    this.jdField_a_of_type_Qru = paramqru;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.Ko())) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "DetailTagListSegment";
  }
  
  public void onMoreClick()
  {
    if (!this.aFo) {}
    for (boolean bool = true;; bool = false)
    {
      this.aFo = bool;
      rar.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Qru.d.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtb
 * JD-Core Version:    0.7.0.1
 */