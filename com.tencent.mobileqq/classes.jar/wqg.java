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

public class wqg
  extends wrd
  implements IEventReceiver, yuc
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
  public wpw a;
  private wql jdField_a_of_type_Wql;
  protected wst a;
  private xfj jdField_a_of_type_Xfj;
  public yln a;
  public ylo a;
  private yty jdField_a_of_type_Yty;
  protected boolean a;
  public ImageView b;
  public TextView b;
  private boolean b;
  public ImageView c;
  public ImageView d;
  
  public wqg(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, ylo paramylo, int paramInt)
  {
    super(paramContext, 2131561726);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Ylo = paramylo;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramylo.a();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wst = ((wst)wth.a(15));
    paramContext = new wqa(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ylo.a());
    paramActivity = wqs.a(this.jdField_a_of_type_AndroidContentContext, paramActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.jdField_a_of_type_Ylo.b());
    paramActivity.b(this.jdField_a_of_type_Ylo.c());
    j();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static wqg a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, ylo paramylo, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new wqg(paramContext, paramActivity, paramViewGroup, paramylo, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public void Q_()
  {
    xjq.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    String str;
    if (this.jdField_a_of_type_Int == 10) {
      str = "1";
    }
    for (;;)
    {
      yup.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
      }
      else
      {
        yuk.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
        str = "-1";
      }
    }
  }
  
  public wre a()
  {
    return null;
  }
  
  public wrf a()
  {
    return new wqh(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Xfj != null) {
      this.jdField_a_of_type_Xfj.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371346));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371344));
    this.d = ((ImageView)paramView.findViewById(2131371347));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364808));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364835));
    this.c = ((ImageView)paramView.findViewById(2131374608));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374605));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365587);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131378421));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.d.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.c.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Wrf);
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131166480), PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166480));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846478);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846471);
      this.d.setImageResource(2130846474);
      this.c.setImageResource(2130846524);
    }
    this.jdField_a_of_type_Yty = new yty(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Yty);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    wqa localwqa = (wqa)a("commentLego");
    localwqa.a(new wqv(localwqa, paramShareGroupItem));
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_Yln == null))) {
        break label580;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131703304) + zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label178:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label592;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838779));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label237:
      if (!(this.jdField_a_of_type_Ylo instanceof ymm)) {
        break label610;
      }
      paramList = "";
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1) {
        break label645;
      }
      paramList = zpz.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
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
      this.jdField_a_of_type_Yty.a(((ymm)this.jdField_a_of_type_Ylo).d, str, ((ymm)this.jdField_a_of_type_Ylo).c, bool1, paramList);
      this.jdField_a_of_type_Yty.a(this);
      if (bool2)
      {
        if (this.jdField_a_of_type_Int == 10)
        {
          paramList = "1";
          label374:
          yup.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_Ylo.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ylo.a().feedId });
        }
      }
      else
      {
        label430:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_Ylo.b().size())) {
          break label622;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131703330) + zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + anzj.a(2131703308));
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
          ((wtp)wth.a(23)).c();
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
  
  public void a(wpw paramwpw)
  {
    ((wqa)a("commentLego")).a(paramwpw);
    this.jdField_a_of_type_Wpw = paramwpw;
  }
  
  public void a(wql paramwql)
  {
    this.jdField_a_of_type_Wql = paramwql;
    ((wqa)a("commentLego")).a(paramwql);
  }
  
  public void a(yln paramyln)
  {
    this.jdField_a_of_type_Yln = paramyln;
  }
  
  public void a(ylo paramylo, ShareGroupItem paramShareGroupItem, yln paramyln)
  {
    this.jdField_a_of_type_Ylo = paramylo;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramylo.a();
    wqa localwqa = (wqa)a("commentLego");
    wqs localwqs = (wqs)a("likeLego");
    j();
    i();
    if (paramyln != null) {
      a(paramyln);
    }
    for (;;)
    {
      localwqa.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramylo.a());
      localwqs.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localwqa.c(this.jdField_a_of_type_Ylo.b());
      localwqs.c(this.jdField_a_of_type_Ylo.c());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(zll paramzll)
  {
    xjq.a(this.jdField_a_of_type_AndroidAppActivity, paramzll);
    String str1;
    if (this.jdField_a_of_type_Int == 10)
    {
      str1 = "1";
      if (paramzll.jdField_a_of_type_Int != 0) {
        break label108;
      }
    }
    label108:
    for (String str2 = "1";; str2 = "2")
    {
      yup.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramzll.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str1 = "3";
        break;
      }
      yuk.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846472);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846478);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846477);
  }
  
  public void c()
  {
    wqa localwqa = (wqa)a("commentLego");
    wqs localwqs = (wqs)a("likeLego");
    localwqa.c(this.jdField_a_of_type_Ylo.b());
    localwqs.c(this.jdField_a_of_type_Ylo.c());
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_Ylo.b().size();
    int j;
    int i;
    if ((this.jdField_a_of_type_Ylo.c().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = wnu.a(2131427360);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, zps.a(this.jdField_a_of_type_AndroidContentContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = wnu.a(2131427357);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = wnu.a(2131427359);
      } else if ((k > 0) && (j == 0)) {
        i = wnu.a(2131427358);
      } else {
        i = wnu.a(2131427355);
      }
    }
    label172:
    float f = wnu.a(2131427356);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, zps.a(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131703328), 0).a();
      return;
    }
    boolean bool;
    label42:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      wqn.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((wqs)a("likeLego")).a(bool);
      b(bool);
      wqa.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = yup.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label211;
      }
    }
    label211:
    for (Object localObject = ((wul)localObject).getUnionId();; localObject = "")
    {
      yup.a("home_page", "clk_like", yup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), yup.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
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
    ymm localymm;
    if ((this.jdField_a_of_type_Ylo instanceof ymm))
    {
      localymm = (ymm)this.jdField_a_of_type_Ylo;
      if (((ymm)this.jdField_a_of_type_Ylo).c) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localymm.c = bool;
      yup.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
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
      zsg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (!zqd.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label315;
      }
    }
    label149:
    label315:
    for (int i = 2;; i = 1)
    {
      yup.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        break;
      }
      yuk.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
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
        yuk.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      localObject = "";
      break;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
        break label56;
      }
      yuk.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      str = "-1";
      break label56;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    wqa localwqa = (wqa)a("commentLego");
    localwqa.a(new wpu(localwqa));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_Yln = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqg
 * JD-Core Version:    0.7.0.1
 */