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

public class pqn
  extends prf
  implements IEventReceiver, rae.a
{
  private boolean Wt;
  public ShareGroupItem a;
  public CommentLikeFeedItem a;
  private TagFlowLayout jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout;
  public pqh.b a;
  private pqn.a jdField_a_of_type_Pqn$a;
  protected psm a;
  private qbc jdField_a_of_type_Qbc;
  public quw a;
  public qux a;
  private rae jdField_a_of_type_Rae;
  public InnerListView b;
  public Activity mActivity;
  protected boolean mDestroyed;
  public int mFeedType;
  public ImageView mLikeBtn;
  protected Rect mRect = new Rect();
  public TextView mTailText;
  public ImageView mv;
  public ImageView mw;
  public ImageView mx;
  public View oa;
  public TextView wY;
  
  public pqn(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, qux paramqux, int paramInt)
  {
    super(paramContext, 2131561842);
    this.jdField_a_of_type_Qux = paramqux;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramqux.a();
    this.mActivity = paramActivity;
    this.mFeedType = paramInt;
    this.jdField_a_of_type_Psm = ((psm)psx.a(15));
    paramContext = new pqj(this.mContext, this.mActivity, this.mParentView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.mFeedType, this.jdField_a_of_type_Qux.bS());
    paramActivity = pqu.a(this.mContext, paramActivity, this.mParentView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.mFeedType);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.dY(this.jdField_a_of_type_Qux.getCommentList());
    paramActivity.dY(this.jdField_a_of_type_Qux.bU());
    bmv();
    bmu();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static pqn a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, qux paramqux, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new pqn(paramContext, paramActivity, paramViewGroup, paramqux, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public prg a()
  {
    return null;
  }
  
  public prh a()
  {
    return new pqo(this);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      bmu();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    pqj localpqj = (pqj)a("commentLego");
    localpqj.a(new pqx(localpqj, paramShareGroupItem));
  }
  
  public void a(pqh.b paramb)
  {
    ((pqj)a("commentLego")).a(paramb);
    this.jdField_a_of_type_Pqh$b = paramb;
  }
  
  public void a(quw paramquw)
  {
    this.jdField_a_of_type_Quw = paramquw;
  }
  
  public void a(qux paramqux, ShareGroupItem paramShareGroupItem, quw paramquw)
  {
    this.jdField_a_of_type_Qux = paramqux;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramqux.a();
    pqj localpqj = (pqj)a("commentLego");
    pqu localpqu = (pqu)a("likeLego");
    bmv();
    bmu();
    if (paramquw != null) {
      a(paramquw);
    }
    for (;;)
    {
      localpqj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramqux.bS());
      localpqu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localpqj.dZ(this.jdField_a_of_type_Qux.getCommentList());
      localpqu.dZ(this.jdField_a_of_type_Qux.bU());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(rmw.a parama)
  {
    qev.a(this.mActivity, parama);
    String str1;
    if (this.mFeedType == 10)
    {
      str1 = "1";
      if (parama.type != 0) {
        break label109;
      }
    }
    label109:
    for (String str2 = "1";; str2 = "2")
    {
      rar.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(parama.id), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.mFeedType == 12)
      {
        str1 = "3";
        break;
      }
      ram.b("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.mFeedType));
      str1 = "-1";
      break;
    }
  }
  
  public void b(pqn.a parama)
  {
    this.jdField_a_of_type_Pqn$a = parama;
    ((pqj)a("commentLego")).a(parama);
  }
  
  public void bmp()
  {
    pqj localpqj = (pqj)a("commentLego");
    pqu localpqu = (pqu)a("likeLego");
    localpqj.dZ(this.jdField_a_of_type_Qux.getCommentList());
    localpqu.dZ(this.jdField_a_of_type_Qux.bU());
  }
  
  public void bmq()
  {
    int k = this.jdField_a_of_type_Qux.getCommentList().size();
    int j;
    int i;
    if ((this.jdField_a_of_type_Qux.bU().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = ppf.getInteger(2131427367);
    }
    for (;;)
    {
      this.mParentView.setPadding(0, 0, 0, rpq.dip2px(this.mContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.b.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = ppf.getInteger(2131427364);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = ppf.getInteger(2131427366);
      } else if ((k > 0) && (j == 0)) {
        i = ppf.getInteger(2131427365);
      } else {
        i = ppf.getInteger(2131427362);
      }
    }
    label172:
    float f = ppf.getInteger(2131427363);
    this.b.setPadding(0, rpq.dip2px(this.mContext, f + 0.5F), 0, 0);
  }
  
  protected void bmr()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706159), 0).show();
      return;
    }
    boolean bool;
    label42:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      pqt.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((pqu)a("likeLego")).sc(bool);
      sb(bool);
      pqj.b(this.mFeedType, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = rar.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label211;
      }
    }
    label211:
    for (Object localObject = ((ptq)localObject).getUnionId();; localObject = "")
    {
      rar.a("home_page", "clk_like", rar.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), rar.bX(this.mFeedType), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FeedCommentLikeLego", 2, "onLikeBtnClick: isLike:" + bool);
      return;
      bool = false;
      break label42;
    }
  }
  
  public void bms()
  {
    qev.ba(this.mContext, "com.tencent.qim");
    String str;
    if (this.mFeedType == 10) {
      str = "1";
    }
    for (;;)
    {
      rar.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.mFeedType == 12)
      {
        str = "3";
      }
      else
      {
        ram.b("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.mFeedType));
        str = "-1";
      }
    }
  }
  
  public void bmt()
  {
    Object localObject;
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type != 1) {
        break label194;
      }
      localObject = (GeneralFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      if (this.mFeedType != 10) {
        break label149;
      }
      localObject = ((GeneralFeedItem)localObject).wsSchemaForMain;
      if (this.mFeedType != 10) {
        break label275;
      }
      str = "1";
      label56:
      rrt.a(this.mActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (!rpw.isWeishiInstalled(this.mContext)) {
        break label318;
      }
    }
    label149:
    label318:
    for (int i = 2;; i = 1)
    {
      rar.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.mFeedType == 12)
      {
        localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        break;
      }
      ram.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.mFeedType) });
      localObject = "";
      break;
      label194:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type == 3)
      {
        localObject = (GeneralRecommendFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        if (this.mFeedType == 10)
        {
          localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMain;
          break;
        }
        if (this.mFeedType == 12)
        {
          localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMemories;
          break;
        }
        ram.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.mFeedType) });
      }
      localObject = "";
      break;
      if (this.mFeedType == 12)
      {
        str = "3";
        break label56;
      }
      ram.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.mFeedType) });
      str = "-1";
      break label56;
    }
  }
  
  public void bmu()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    pqj localpqj = (pqj)a("commentLego");
    localpqj.a(new pqh(localpqj));
  }
  
  public void bmv()
  {
    this.jdField_a_of_type_Quw = null;
  }
  
  public void dX(List paramList)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
    {
      bool1 = true;
      sb(bool1);
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      bool2 = paramList.isVipButNoFriend();
      bool1 = paramList.isSubscribeButNoFriend();
      if ((!bool2) && (!paramList.isMe()) && (!bool1)) {
        break label564;
      }
      i = 1;
      label67:
      if ((i == 0) && ((this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic()))) {
        break label569;
      }
      this.mx.setVisibility(0);
      label96:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_Quw == null))) {
        break label581;
      }
      this.wY.setVisibility(0);
      this.wY.setText(acfp.m(2131706135) + rpq.aL(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label178:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label593;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.oa.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838901));
        this.oa.setAlpha(0.89F);
      }
      this.oa.setVisibility(0);
      label237:
      if (!(this.jdField_a_of_type_Qux instanceof qvj)) {
        break label611;
      }
      paramList = "";
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1) {
        break label646;
      }
      paramList = rpu.ci(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
      if ((!TextUtils.isEmpty(paramList)) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1)) {
        break label640;
      }
      paramList = "来自微视APP";
      bool1 = true;
    }
    for (;;)
    {
      String str = ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mQimSyncWording;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(0);
      this.jdField_a_of_type_Rae.a(((qvj)this.jdField_a_of_type_Qux).oi, str, ((qvj)this.jdField_a_of_type_Qux).aFP, bool1, paramList);
      this.jdField_a_of_type_Rae.a(this);
      if (bool2)
      {
        if (this.mFeedType == 10)
        {
          paramList = "1";
          label375:
          rar.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_Qux.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Qux.a().feedId });
        }
      }
      else
      {
        label431:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_Qux.getCommentList().size())) {
          break label623;
        }
        this.mTailText.setVisibility(0);
        this.mTailText.setText(acfp.m(2131706161) + rpq.aL(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + acfp.m(2131706139));
        label520:
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
          break label635;
        }
      }
      label564:
      label569:
      label581:
      label593:
      label611:
      label623:
      label635:
      for (i = j;; i = 0)
      {
        if (i != 0) {
          ((ptc)psx.a(23)).flush();
        }
        bmq();
        return;
        bool1 = false;
        break;
        i = 0;
        break label67;
        this.mx.setVisibility(8);
        break label96;
        this.wY.setVisibility(8);
        break label178;
        this.oa.setVisibility(8);
        break label237;
        paramList = "3";
        break label375;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(8);
        break label431;
        this.mTailText.setVisibility(8);
        break label520;
      }
      label640:
      bool1 = true;
      continue;
      label646:
      bool1 = false;
    }
  }
  
  public void g(Context paramContext, View paramView)
  {
    this.mLikeBtn = ((ImageView)paramView.findViewById(2131371886));
    this.mv = ((ImageView)paramView.findViewById(2131371884));
    this.mx = ((ImageView)paramView.findViewById(2131371887));
    this.mTailText = ((TextView)paramView.findViewById(2131365002));
    this.b = ((InnerListView)paramView.findViewById(2131365030));
    this.mw = ((ImageView)paramView.findViewById(2131375150));
    this.wY = ((TextView)paramView.findViewById(2131375147));
    this.oa = paramView.findViewById(2131365943);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131379219));
    this.mLikeBtn.setOnClickListener(this.jdField_a_of_type_Prh);
    this.mv.setOnClickListener(this.jdField_a_of_type_Prh);
    this.mx.setOnClickListener(this.jdField_a_of_type_Prh);
    this.mTailText.setOnClickListener(this.jdField_a_of_type_Prh);
    this.mw.setOnClickListener(this.jdField_a_of_type_Prh);
    this.oa.setOnClickListener(this.jdField_a_of_type_Prh);
    this.wY.setOnClickListener(this.jdField_a_of_type_Prh);
    this.Wt = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.Wt)
    {
      paramView = this.wY.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131166763), PorterDuff.Mode.SRC_ATOP);
      }
      this.wY.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.mTailText.setTextColor(paramContext.getResources().getColor(2131166763));
      this.mLikeBtn.setImageResource(2130847343);
      this.mv.setImageResource(2130847336);
      this.mx.setImageResource(2130847339);
      this.mw.setImageResource(2130847389);
    }
    this.jdField_a_of_type_Rae = new rae(this.mContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Rae);
  }
  
  public boolean isValidate()
  {
    return !this.mDestroyed;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Qbc != null) {
      this.jdField_a_of_type_Qbc.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestory()
  {
    this.mDestroyed = true;
    super.onDestory();
  }
  
  public void onMoreClick()
  {
    qvj localqvj;
    if ((this.jdField_a_of_type_Qux instanceof qvj))
    {
      localqvj = (qvj)this.jdField_a_of_type_Qux;
      if (((qvj)this.jdField_a_of_type_Qux).aFP) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      localqvj.aFP = bool;
      rar.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void sa(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mw.setVisibility(0);
      return;
    }
    this.mw.setVisibility(8);
  }
  
  public void sb(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLikeBtn.setImageResource(2130847337);
      return;
    }
    if (this.Wt)
    {
      this.mLikeBtn.setImageResource(2130847343);
      return;
    }
    this.mLikeBtn.setImageResource(2130847342);
  }
  
  public void showLoading() {}
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, String paramString, CommentLikeFeedItem paramCommentLikeFeedItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqn
 * JD-Core Version:    0.7.0.1
 */