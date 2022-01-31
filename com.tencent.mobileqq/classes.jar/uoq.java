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

public class uoq
  extends upn
  implements IEventReceiver, wsn
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
  public uog a;
  private uov jdField_a_of_type_Uov;
  protected urd a;
  private vdt jdField_a_of_type_Vdt;
  public wjy a;
  public wjz a;
  private wsj jdField_a_of_type_Wsj;
  protected boolean a;
  public ImageView b;
  public TextView b;
  private boolean b;
  public ImageView c;
  public ImageView d;
  
  public uoq(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, wjz paramwjz, int paramInt)
  {
    super(paramContext, 2131561431);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Wjz = paramwjz;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramwjz.a();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Urd = ((urd)urr.a(15));
    paramContext = new uok(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_Wjz.a());
    paramActivity = upc.a(this.jdField_a_of_type_AndroidContentContext, paramActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.jdField_a_of_type_Wjz.b());
    paramActivity.b(this.jdField_a_of_type_Wjz.c());
    j();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static uoq a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, wjz paramwjz, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new uoq(paramContext, paramActivity, paramViewGroup, paramwjz, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public void W_()
  {
    via.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    String str;
    if (this.jdField_a_of_type_Int == 10) {
      str = "1";
    }
    for (;;)
    {
      wta.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
      }
      else
      {
        wsv.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
        str = "-1";
      }
    }
  }
  
  public upo a()
  {
    return null;
  }
  
  public upp a()
  {
    return new uor(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Vdt != null) {
      this.jdField_a_of_type_Vdt.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370664));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370662));
    this.d = ((ImageView)paramView.findViewById(2131370665));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364543));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364571));
    this.c = ((ImageView)paramView.findViewById(2131373717));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373714));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365303);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131377381));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Upp);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Upp);
    this.d.setOnClickListener(this.jdField_a_of_type_Upp);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Upp);
    this.c.setOnClickListener(this.jdField_a_of_type_Upp);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Upp);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Upp);
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131166400), PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166400));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845949);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845942);
      this.d.setImageResource(2130845945);
      this.c.setImageResource(2130845995);
    }
    this.jdField_a_of_type_Wsj = new wsj(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Wsj);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    uok localuok = (uok)a("commentLego");
    localuok.a(new upf(localuok, paramShareGroupItem));
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_Wjy == null))) {
        break label580;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704788) + xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label178:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label592;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838592));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label237:
      if (!(this.jdField_a_of_type_Wjz instanceof wkx)) {
        break label610;
      }
      paramList = "";
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1) {
        break label645;
      }
      paramList = xok.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
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
      this.jdField_a_of_type_Wsj.a(((wkx)this.jdField_a_of_type_Wjz).d, str, ((wkx)this.jdField_a_of_type_Wjz).c, bool1, paramList);
      this.jdField_a_of_type_Wsj.a(this);
      if (bool2)
      {
        if (this.jdField_a_of_type_Int == 10)
        {
          paramList = "1";
          label374:
          wta.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_Wjz.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Wjz.a().feedId });
        }
      }
      else
      {
        label430:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_Wjz.b().size())) {
          break label622;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131704814) + xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + alpo.a(2131704792));
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
          ((urz)urr.a(23)).c();
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
  
  public void a(uog paramuog)
  {
    ((uok)a("commentLego")).a(paramuog);
    this.jdField_a_of_type_Uog = paramuog;
  }
  
  public void a(uov paramuov)
  {
    this.jdField_a_of_type_Uov = paramuov;
    ((uok)a("commentLego")).a(paramuov);
  }
  
  public void a(wjy paramwjy)
  {
    this.jdField_a_of_type_Wjy = paramwjy;
  }
  
  public void a(wjz paramwjz, ShareGroupItem paramShareGroupItem, wjy paramwjy)
  {
    this.jdField_a_of_type_Wjz = paramwjz;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramwjz.a();
    uok localuok = (uok)a("commentLego");
    upc localupc = (upc)a("likeLego");
    j();
    i();
    if (paramwjy != null) {
      a(paramwjy);
    }
    for (;;)
    {
      localuok.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramwjz.a());
      localupc.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localuok.c(this.jdField_a_of_type_Wjz.b());
      localupc.c(this.jdField_a_of_type_Wjz.c());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(xjw paramxjw)
  {
    via.a(this.jdField_a_of_type_AndroidAppActivity, paramxjw);
    String str1;
    if (this.jdField_a_of_type_Int == 10)
    {
      str1 = "1";
      if (paramxjw.jdField_a_of_type_Int != 0) {
        break label108;
      }
    }
    label108:
    for (String str2 = "1";; str2 = "2")
    {
      wta.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramxjw.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str1 = "3";
        break;
      }
      wsv.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845943);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845949);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845948);
  }
  
  public void c()
  {
    uok localuok = (uok)a("commentLego");
    upc localupc = (upc)a("likeLego");
    localuok.c(this.jdField_a_of_type_Wjz.b());
    localupc.c(this.jdField_a_of_type_Wjz.c());
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_Wjz.b().size();
    int j;
    int i;
    if ((this.jdField_a_of_type_Wjz.c().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = ume.a(2131427360);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, xod.a(this.jdField_a_of_type_AndroidContentContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = ume.a(2131427357);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = ume.a(2131427359);
      } else if ((k > 0) && (j == 0)) {
        i = ume.a(2131427358);
      } else {
        i = ume.a(2131427355);
      }
    }
    label172:
    float f = ume.a(2131427356);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, xod.a(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704812), 0).a();
      return;
    }
    boolean bool;
    label42:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      uox.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((upc)a("likeLego")).a(bool);
      b(bool);
      uok.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = wta.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label211;
      }
    }
    label211:
    for (Object localObject = ((usv)localObject).getUnionId();; localObject = "")
    {
      wta.a("home_page", "clk_like", wta.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), wta.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
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
    wkx localwkx;
    if ((this.jdField_a_of_type_Wjz instanceof wkx))
    {
      localwkx = (wkx)this.jdField_a_of_type_Wjz;
      if (((wkx)this.jdField_a_of_type_Wjz).c) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localwkx.c = bool;
      wta.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
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
      xqr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (!xoo.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label315;
      }
    }
    label149:
    label315:
    for (int i = 2;; i = 1)
    {
      wta.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        break;
      }
      wsv.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
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
        wsv.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      localObject = "";
      break;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
        break label56;
      }
      wsv.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      str = "-1";
      break label56;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    uok localuok = (uok)a("commentLego");
    localuok.a(new uoe(localuok));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_Wjy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoq
 * JD-Core Version:    0.7.0.1
 */