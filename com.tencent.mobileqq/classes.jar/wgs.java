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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;

public class wgs
  extends whp
  implements IEventReceiver, yki
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
  public wgi a;
  private wgx jdField_a_of_type_Wgx;
  protected wje a;
  private wvu jdField_a_of_type_Wvu;
  public ybt a;
  public ybu a;
  private yke jdField_a_of_type_Yke;
  protected boolean a;
  public ImageView b;
  public TextView b;
  private boolean b;
  public ImageView c;
  public ImageView d;
  
  public wgs(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, ybu paramybu, int paramInt)
  {
    super(paramContext, 2131561672);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Ybu = paramybu;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramybu.a();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wje = ((wje)wjs.a(15));
    paramContext = new wgm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ybu.a());
    paramActivity = whe.a(this.jdField_a_of_type_AndroidContentContext, paramActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.jdField_a_of_type_Ybu.b());
    paramActivity.b(this.jdField_a_of_type_Ybu.c());
    j();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static wgs a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, ybu paramybu, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new wgs(paramContext, paramActivity, paramViewGroup, paramybu, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public void M_()
  {
    xab.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    String str;
    if (this.jdField_a_of_type_Int == 10) {
      str = "1";
    }
    for (;;)
    {
      ykv.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
      }
      else
      {
        ykq.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
        str = "-1";
      }
    }
  }
  
  public whq a()
  {
    return null;
  }
  
  public whr a()
  {
    return new wgt(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Wvu != null) {
      this.jdField_a_of_type_Wvu.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371500));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371498));
    this.d = ((ImageView)paramView.findViewById(2131371501));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364925));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364953));
    this.c = ((ImageView)paramView.findViewById(2131374614));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374611));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365713);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131378476));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Whr);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Whr);
    this.d.setOnClickListener(this.jdField_a_of_type_Whr);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Whr);
    this.c.setOnClickListener(this.jdField_a_of_type_Whr);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Whr);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Whr);
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131166513), PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166513));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846482);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846475);
      this.d.setImageResource(2130846478);
      this.c.setImageResource(2130846528);
    }
    this.jdField_a_of_type_Yke = new yke(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Yke);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    wgm localwgm = (wgm)a("commentLego");
    localwgm.a(new whh(localwgm, paramShareGroupItem));
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_Ybt == null))) {
        break label580;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131703885) + UIUtils.formatCount(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label178:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label592;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838912));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label237:
      if (!(this.jdField_a_of_type_Ybu instanceof ycs)) {
        break label610;
      }
      paramList = "";
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1) {
        break label645;
      }
      paramList = zfj.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
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
      this.jdField_a_of_type_Yke.a(((ycs)this.jdField_a_of_type_Ybu).d, str, ((ycs)this.jdField_a_of_type_Ybu).c, bool1, paramList);
      this.jdField_a_of_type_Yke.a(this);
      if (bool2)
      {
        if (this.jdField_a_of_type_Int == 10)
        {
          paramList = "1";
          label374:
          ykv.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_Ybu.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Ybu.a().feedId });
        }
      }
      else
      {
        label430:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_Ybu.b().size())) {
          break label622;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131703911) + UIUtils.formatCount(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + anvx.a(2131703889));
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
          ((wka)wjs.a(23)).c();
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
  
  public void a(wgi paramwgi)
  {
    ((wgm)a("commentLego")).a(paramwgi);
    this.jdField_a_of_type_Wgi = paramwgi;
  }
  
  public void a(wgx paramwgx)
  {
    this.jdField_a_of_type_Wgx = paramwgx;
    ((wgm)a("commentLego")).a(paramwgx);
  }
  
  public void a(ybt paramybt)
  {
    this.jdField_a_of_type_Ybt = paramybt;
  }
  
  public void a(ybu paramybu, ShareGroupItem paramShareGroupItem, ybt paramybt)
  {
    this.jdField_a_of_type_Ybu = paramybu;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramybu.a();
    wgm localwgm = (wgm)a("commentLego");
    whe localwhe = (whe)a("likeLego");
    j();
    i();
    if (paramybt != null) {
      a(paramybt);
    }
    for (;;)
    {
      localwgm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramybu.a());
      localwhe.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localwgm.c(this.jdField_a_of_type_Ybu.b());
      localwhe.c(this.jdField_a_of_type_Ybu.c());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(zbe paramzbe)
  {
    xab.a(this.jdField_a_of_type_AndroidAppActivity, paramzbe);
    String str1;
    if (this.jdField_a_of_type_Int == 10)
    {
      str1 = "1";
      if (paramzbe.jdField_a_of_type_Int != 0) {
        break label108;
      }
    }
    label108:
    for (String str2 = "1";; str2 = "2")
    {
      ykv.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramzbe.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str1 = "3";
        break;
      }
      ykq.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846476);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846482);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846481);
  }
  
  public void c()
  {
    wgm localwgm = (wgm)a("commentLego");
    whe localwhe = (whe)a("likeLego");
    localwgm.c(this.jdField_a_of_type_Ybu.b());
    localwhe.c(this.jdField_a_of_type_Ybu.c());
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_Ybu.b().size();
    int j;
    int i;
    if ((this.jdField_a_of_type_Ybu.c().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = weg.a(2131427360);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = weg.a(2131427357);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = weg.a(2131427359);
      } else if ((k > 0) && (j == 0)) {
        i = weg.a(2131427358);
      } else {
        i = weg.a(2131427355);
      }
    }
    label172:
    float f = weg.a(2131427356);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703909), 0).a();
      return;
    }
    boolean bool;
    label42:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      wgz.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((whe)a("likeLego")).a(bool);
      b(bool);
      wgm.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = ykv.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label211;
      }
    }
    label211:
    for (Object localObject = ((wkw)localObject).getUnionId();; localObject = "")
    {
      ykv.a("home_page", "clk_like", ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), ykv.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
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
    ycs localycs;
    if ((this.jdField_a_of_type_Ybu instanceof ycs))
    {
      localycs = (ycs)this.jdField_a_of_type_Ybu;
      if (((ycs)this.jdField_a_of_type_Ybu).c) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localycs.c = bool;
      ykv.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
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
      zgk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (!zfn.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label315;
      }
    }
    label149:
    label315:
    for (int i = 2;; i = 1)
    {
      ykv.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        break;
      }
      ykq.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
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
        ykq.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      localObject = "";
      break;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
        break label56;
      }
      ykq.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      str = "-1";
      break label56;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    wgm localwgm = (wgm)a("commentLego");
    localwgm.a(new wgg(localwgm));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_Ybt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */