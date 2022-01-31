import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;

public class usz
  extends utw
  implements IEventReceiver, www
{
  public int a;
  public Activity a;
  protected Rect a;
  public View a;
  public ImageView a;
  public TextView a;
  public ShareGroupItem a;
  public CommentLikeFeedItem a;
  private TagFlowLayout jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout;
  public InnerListView a;
  public usp a;
  private ute jdField_a_of_type_Ute;
  protected uvm a;
  private vic jdField_a_of_type_Vic;
  public woh a;
  public woi a;
  private wws jdField_a_of_type_Wws;
  protected boolean a;
  public ImageView b;
  public TextView b;
  private boolean b;
  public ImageView c;
  public ImageView d;
  
  public usz(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, woi paramwoi, int paramInt)
  {
    super(paramContext, 2131561449);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Woi = paramwoi;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramwoi.a();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Uvm = ((uvm)uwa.a(15));
    paramContext = new ust(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_Woi.a());
    paramActivity = utl.a(this.jdField_a_of_type_AndroidContentContext, paramActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.jdField_a_of_type_Woi.b());
    paramActivity.b(this.jdField_a_of_type_Woi.c());
    j();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static usz a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, woi paramwoi, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new usz(paramContext, paramActivity, paramViewGroup, paramwoi, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public void T_()
  {
    vmj.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    String str;
    if (this.jdField_a_of_type_Int == 10) {
      str = "1";
    }
    for (;;)
    {
      wxj.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
      }
      else
      {
        wxe.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
        str = "-1";
      }
    }
  }
  
  public utx a()
  {
    return null;
  }
  
  public uty a()
  {
    return new uta(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Vic != null) {
      this.jdField_a_of_type_Vic.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370683));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370681));
    this.d = ((ImageView)paramView.findViewById(2131370684));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364545));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364573));
    this.c = ((ImageView)paramView.findViewById(2131373768));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373765));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365305);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131377435));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Uty);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Uty);
    this.d.setOnClickListener(this.jdField_a_of_type_Uty);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Uty);
    this.c.setOnClickListener(this.jdField_a_of_type_Uty);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Uty);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Uty);
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131166402), PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166402));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846022);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846015);
      this.d.setImageResource(2130846018);
      this.c.setImageResource(2130846068);
    }
    this.jdField_a_of_type_Wws = new wws(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Wws);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    ust localust = (ust)a("commentLego");
    localust.a(new uto(localust, paramShareGroupItem));
  }
  
  public void a(List paramList)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
    {
      bool1 = true;
      b(bool1);
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      bool2 = paramList.isVipButNoFriend();
      bool1 = paramList.isSubscribeButNoFriend();
      if ((!bool2) && (!paramList.isMe()) && (!bool1)) {
        break label563;
      }
      i = 1;
      label67:
      if ((i == 0) && ((this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic()))) {
        break label568;
      }
      this.d.setVisibility(0);
      label96:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_Woh == null))) {
        break label580;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131704800) + xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label178:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label592;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838593));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label237:
      if (!(this.jdField_a_of_type_Woi instanceof wpg)) {
        break label610;
      }
      paramList = "";
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1) {
        break label645;
      }
      paramList = xst.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
      if ((!TextUtils.isEmpty(paramList)) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1)) {
        break label639;
      }
      paramList = "来自微视APP";
      bool1 = true;
    }
    for (;;)
    {
      String str = ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mQimSyncWording;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(0);
      this.jdField_a_of_type_Wws.a(((wpg)this.jdField_a_of_type_Woi).d, str, ((wpg)this.jdField_a_of_type_Woi).c, bool1, paramList);
      this.jdField_a_of_type_Wws.a(this);
      if (bool2)
      {
        if (this.jdField_a_of_type_Int == 10)
        {
          paramList = "1";
          label374:
          wxj.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_Woi.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Woi.a().feedId });
        }
      }
      else
      {
        label430:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_Woi.b().size())) {
          break label622;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131704826) + xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + alud.a(2131704804));
        label519:
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
          break label634;
        }
      }
      label563:
      label568:
      label580:
      label592:
      label610:
      label622:
      label634:
      for (i = j;; i = 0)
      {
        if (i != 0) {
          ((uwi)uwa.a(23)).c();
        }
        d();
        return;
        bool1 = false;
        break;
        i = 0;
        break label67;
        this.d.setVisibility(8);
        break label96;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label178;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label237;
        paramList = "3";
        break label374;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(8);
        break label430;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label519;
      }
      label639:
      bool1 = true;
      continue;
      label645:
      bool1 = false;
    }
  }
  
  public void a(usp paramusp)
  {
    ((ust)a("commentLego")).a(paramusp);
    this.jdField_a_of_type_Usp = paramusp;
  }
  
  public void a(ute paramute)
  {
    this.jdField_a_of_type_Ute = paramute;
    ((ust)a("commentLego")).a(paramute);
  }
  
  public void a(woh paramwoh)
  {
    this.jdField_a_of_type_Woh = paramwoh;
  }
  
  public void a(woi paramwoi, ShareGroupItem paramShareGroupItem, woh paramwoh)
  {
    this.jdField_a_of_type_Woi = paramwoi;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramwoi.a();
    ust localust = (ust)a("commentLego");
    utl localutl = (utl)a("likeLego");
    j();
    i();
    if (paramwoh != null) {
      a(paramwoh);
    }
    for (;;)
    {
      localust.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramwoi.a());
      localutl.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localust.c(this.jdField_a_of_type_Woi.b());
      localutl.c(this.jdField_a_of_type_Woi.c());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(xof paramxof)
  {
    vmj.a(this.jdField_a_of_type_AndroidAppActivity, paramxof);
    String str1;
    if (this.jdField_a_of_type_Int == 10)
    {
      str1 = "1";
      if (paramxof.jdField_a_of_type_Int != 0) {
        break label108;
      }
    }
    label108:
    for (String str2 = "1";; str2 = "2")
    {
      wxj.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramxof.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str1 = "3";
        break;
      }
      wxe.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
      str1 = "-1";
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846016);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846022);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846021);
  }
  
  public void c()
  {
    ust localust = (ust)a("commentLego");
    utl localutl = (utl)a("likeLego");
    localust.c(this.jdField_a_of_type_Woi.b());
    localutl.c(this.jdField_a_of_type_Woi.c());
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_Woi.b().size();
    int j;
    int i;
    if ((this.jdField_a_of_type_Woi.c().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = uqn.a(2131427360);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = uqn.a(2131427357);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = uqn.a(2131427359);
      } else if ((k > 0) && (j == 0)) {
        i = uqn.a(2131427358);
      } else {
        i = uqn.a(2131427355);
      }
    }
    label172:
    float f = uqn.a(2131427356);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, xsm.a(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      QQToast.a(BaseApplication.getContext(), 1, alud.a(2131704824), 0).a();
      return;
    }
    boolean bool;
    label42:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      utg.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((utl)a("likeLego")).a(bool);
      b(bool);
      ust.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = wxj.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label211;
      }
    }
    label211:
    for (Object localObject = ((uxe)localObject).getUnionId();; localObject = "")
    {
      wxj.a("home_page", "clk_like", wxj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), wxj.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FeedCommentLikeLego", 2, "onLikeBtnClick: isLike:" + bool);
      return;
      bool = false;
      break label42;
    }
  }
  
  public void f()
  {
    wpg localwpg;
    if ((this.jdField_a_of_type_Woi instanceof wpg))
    {
      localwpg = (wpg)this.jdField_a_of_type_Woi;
      if (((wpg)this.jdField_a_of_type_Woi).c) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localwpg.c = bool;
      wxj.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void h()
  {
    Object localObject;
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type != 1) {
        break label193;
      }
      localObject = (GeneralFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      if (this.jdField_a_of_type_Int != 10) {
        break label149;
      }
      localObject = ((GeneralFeedItem)localObject).wsSchemaForMain;
      if (this.jdField_a_of_type_Int != 10) {
        break label273;
      }
      str = "1";
      label56:
      xva.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (!xsx.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label315;
      }
    }
    label149:
    label315:
    for (int i = 2;; i = 1)
    {
      wxj.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        break;
      }
      wxe.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      localObject = "";
      break;
      label193:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type == 3)
      {
        localObject = (GeneralRecommendFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        if (this.jdField_a_of_type_Int == 10)
        {
          localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMain;
          break;
        }
        if (this.jdField_a_of_type_Int == 12)
        {
          localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMemories;
          break;
        }
        wxe.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      localObject = "";
      break;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
        break label56;
      }
      wxe.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      str = "-1";
      break label56;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    ust localust = (ust)a("commentLego");
    localust.a(new usn(localust));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_Woh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usz
 * JD-Core Version:    0.7.0.1
 */