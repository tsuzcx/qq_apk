import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class qmy
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private StoryUserBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  private qmy.f jdField_a_of_type_Qmy$f;
  private boolean aEu;
  private String axL = "";
  private ElasticImageView b;
  private LinearLayout eQ;
  private LinearLayout eR;
  private LinearLayout eS;
  private ImageView mK;
  private ImageView mL;
  private ImageView mM;
  private TextView mTimeText;
  private TextView us;
  private TextView xm;
  private TextView xn;
  private TextView xo;
  private TextView xp;
  
  public qmy(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()) && (!paramQQUserUIItem.isMe()))
    {
      this.xm.setVisibility(0);
      if (this.aEu) {
        rar.a("play_video", "exp_bigv", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      }
      return;
    }
    this.xm.setVisibility(8);
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull VideoListFeedItem paramVideoListFeedItem)
  {
    Object localObject = ((ptf)psx.a(2)).c(paramStoryVideoItem.mOwnerUid);
    int i;
    int j;
    if ((localObject != null) && (((QQUserUIItem)localObject).isMe()))
    {
      i = 1;
      if ((localObject == null) || (!((QQUserUIItem)localObject).isFriend())) {
        break label225;
      }
      j = 1;
      label47:
      localObject = new StringBuilder();
      if (paramVideoListFeedItem.mLikeCount > 0) {
        ((StringBuilder)localObject).append("赞").append(rpq.aL(paramVideoListFeedItem.mLikeCount));
      }
      if (((paramStoryVideoItem.mStoryType != 1) || (i != 0) || (j == 0)) && (paramVideoListFeedItem.mViewTotalTime > 0L))
      {
        if (paramVideoListFeedItem.mLikeCount > 0) {
          ((StringBuilder)localObject).append(" • ");
        }
        ((StringBuilder)localObject).append("浏览").append(rpq.aL(paramVideoListFeedItem.mViewTotalTime));
      }
      if (((StringBuilder)localObject).length() <= 0) {
        break label263;
      }
      if ((paramStoryVideoItem.mStoryType != 1) || (i != 0) || (paramVideoListFeedItem.mLikeCount != 0)) {
        break label231;
      }
      i = 1;
      label170:
      if (i == 0) {
        break label236;
      }
      this.eQ.setClickable(false);
      this.xn.setVisibility(0);
      this.mM.setVisibility(8);
    }
    for (;;)
    {
      this.xn.setText(((StringBuilder)localObject).toString());
      this.eQ.setVisibility(0);
      return;
      i = 0;
      break;
      label225:
      j = 0;
      break label47;
      label231:
      i = 0;
      break label170;
      label236:
      this.eQ.setClickable(true);
      this.xn.setVisibility(0);
      this.mM.setVisibility(0);
    }
    label263:
    this.xn.setVisibility(8);
    this.mM.setVisibility(8);
    this.eQ.setVisibility(8);
  }
  
  private void a(@Nullable String paramString, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramQQUserUIItem == null)
      {
        this.us.setText(qem.auW);
        return;
      }
      ptc localptc = (ptc)psx.a(23);
      this.us.setText(localptc.a(paramQQUserUIItem, paramString, false, true));
      return;
    }
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable()))
    {
      this.us.setText(qem.auW);
      return;
    }
    if (paramQQUserUIItem.isVipButNoFriend())
    {
      this.us.setText(paramQQUserUIItem.nickName);
      return;
    }
    this.us.setText(paramQQUserUIItem.getDisplayName());
  }
  
  private void b(@Nullable QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = aqhu.at();
    if (paramQQUserUIItem == null)
    {
      this.mK.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      return;
    }
    if ((paramQQUserUIItem.isVipButNoFriend()) || (paramQQUserUIItem.isNotDovUser())) {
      rpq.b(this.mK, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setUnionID(paramQQUserUIItem.getUnionId(), 2);
      if (!((ptf)psx.a(2)).fg(paramQQUserUIItem.qq)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setOnClickListener(null);
      return;
      if (!TextUtils.isEmpty(paramQQUserUIItem.qq))
      {
        localObject = aqdj.a(qem.getQQAppInterface(), 1, paramQQUserUIItem.qq, 3, (Drawable)localObject, (Drawable)localObject);
        this.mK.setImageDrawable((Drawable)localObject);
      }
      else if (jqc.isValidUrl(paramQQUserUIItem.headUrl))
      {
        rpq.b(this.mK, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
      }
      else
      {
        this.mK.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  private void b(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "storyVideoItem ownerUid is null.");
      }
      return;
    }
    ppf.f(getActivity(), 9, paramStoryVideoItem.mOwnerUid);
    if (paramBoolean)
    {
      QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(paramStoryVideoItem.mOwnerUid);
      String str3 = "";
      String str1 = "";
      String str2 = str3;
      if (localQQUserUIItem != null)
      {
        if (!localQQUserUIItem.isMe()) {
          break label130;
        }
        str2 = "1";
        str1 = "2";
      }
      for (;;)
      {
        rar.a("play_video", "clk_head", 0, 0, new String[] { str2, str1, "", paramStoryVideoItem.mVid });
        return;
        label130:
        if (localQQUserUIItem.isFriend())
        {
          str2 = "2";
          str1 = "1";
        }
        else if (localQQUserUIItem.isVip())
        {
          str2 = "3";
          str1 = "1";
        }
        else
        {
          str1 = "1";
          str2 = str3;
        }
      }
    }
    rar.a("play_video", "clk_name", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void b(qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mOwnerUid;
    QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).c((String)localObject);
    localObject = null;
    if (paramStoryVideoItem.mStoryType == 2)
    {
      String str = paramStoryVideoItem.mGroupId;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramqjq = paramqjq.a();
        localObject = str;
        if (paramqjq != null)
        {
          localObject = str;
          if (paramqjq.getOwner() != null)
          {
            localObject = str;
            if ((paramqjq.getOwner() instanceof QQUserUIItem)) {
              localObject = ((QQUserUIItem)paramqjq.getOwner()).qq;
            }
          }
        }
      }
    }
    b(localQQUserUIItem);
    a((String)localObject, localQQUserUIItem);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramStoryVideoItem, bool);
      h(paramStoryVideoItem);
      a(paramStoryVideoItem, localQQUserUIItem);
      return;
    }
  }
  
  private void c(QQUserUIItem paramQQUserUIItem)
  {
    Object localObject;
    String str;
    long l1;
    if ((paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()))
    {
      this.jdField_a_of_type_Qmy$f.axQ = paramQQUserUIItem.getUnionId();
      ((pma)qem.getQQAppInterface().getBusinessHandler(98)).b(1, paramQQUserUIItem.uid, 0, 1);
      if (this.jdField_a_of_type_Qjq == null) {
        break label185;
      }
      localObject = this.jdField_a_of_type_Qjq.b();
      str = "";
      if (localObject != null) {
        str = ((StoryVideoItem)localObject).mVid;
      }
      long l2 = 0L;
      l1 = l2;
      if ((this.d instanceof qhc.a))
      {
        localObject = ((qhc.a)this.d).g;
        l1 = l2;
        if (puy.a(QQStoryContext.a()).fh(((qhc.a)this.d).getUnionId())) {
          l1 = ((puh)localObject).N(str);
        }
      }
      if (!paramQQUserUIItem.isVip) {
        break label191;
      }
    }
    label185:
    label191:
    for (int i = 1;; i = 2)
    {
      rar.a("play_video", "follow_bigv", i, (int)l1, new String[] { "1", "", "", str });
      return;
      localObject = null;
      break;
    }
  }
  
  private void c(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramqjq = paramqjq.a();
    if (paramqjq == null)
    {
      this.eQ.setVisibility(8);
      return;
    }
    this.eQ.setVisibility(0);
    a(paramStoryVideoItem, paramqjq);
    rL(paramqjq.feedId);
  }
  
  private void d(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ((ptf)psx.a(2)).c(paramStoryVideoItem.mOwnerUid);
    if (!b(paramqjq, paramStoryVideoItem))
    {
      this.eR.setVisibility(8);
      return;
    }
    this.eR.setVisibility(0);
  }
  
  private void e(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramqjq = paramStoryVideoItem.getVideoLinkInfo();
    if ((paramqjq != null) && (paramqjq.IX()) && (paramqjq.a.IY()) && (!TextUtils.isEmpty(paramqjq.a.avp)))
    {
      this.eS.setVisibility(0);
      paramStoryVideoItem = paramqjq.a.avp;
      paramqjq = paramStoryVideoItem;
      if (aofy.Z(paramStoryVideoItem)) {
        paramqjq = anbk.nn(paramStoryVideoItem);
      }
      paramqjq = new aofr(paramqjq, 3, 16);
      this.xp.setText(paramqjq);
      return;
    }
    this.eS.setVisibility(8);
  }
  
  private void h(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    boolean bool2 = false;
    long l2 = paramStoryVideoItem.mCreateTime;
    long l1;
    if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
      l1 = paramStoryVideoItem.mTimeZoneOffsetMillis;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.nR.size() == 1) {
        bool2 = true;
      }
      paramStoryVideoItem = qwq.a(l2, l1, bool1, true, bool2);
      this.mTimeText.setText(paramStoryVideoItem);
      return;
      l1 = TimeZone.getDefault().getRawOffset();
    }
  }
  
  private void i(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    if (localVideoViewVideoHolder == null) {
      return;
    }
    localVideoViewVideoHolder.sH(true);
    qfa localqfa = new qfa(getActivity(), paramStoryVideoItem.mVid, paramStoryVideoItem.mBanType, paramStoryVideoItem.mVideoSpreadGroupList, false);
    localqfa.setCanceledOnTouchOutside(true);
    localqfa.setCancelable(true);
    localqfa.setOnDismissListener(new qmz(this, localVideoViewVideoHolder));
    localqfa.show();
    rar.a("pub_control", "clk_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void j(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = (StoryPlayerGroupHolder)a();
    Dialog localDialog = rrt.a(getActivity(), paramStoryVideoItem.mOwnerUid, "4", paramStoryVideoItem.mVid, 3, paramStoryVideoItem.mWsSchema);
    localObject = ((StoryPlayerGroupHolder)localObject).a();
    if (localDialog != null)
    {
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).sH(true);
      }
      localDialog.setOnDismissListener(new qna(this, (VideoViewVideoHolder)localObject));
    }
    if (rpw.isWeishiInstalled(getActivity())) {}
    for (int i = 2;; i = 1)
    {
      rar.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramStoryVideoItem.mOwnerUid, "weishi", paramStoryVideoItem.mVid });
      return;
    }
  }
  
  private void rL(String paramString)
  {
    if (pqy.a().fe(paramString))
    {
      this.b.setVisibility(0);
      this.b.setOnClickListener(this);
      return;
    }
    this.b.setVisibility(8);
    this.b.setOnClickListener(null);
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Qmy$f = new qmy.f(null);
    a(this.jdField_a_of_type_Qmy$f);
    paramMap.put(new qmy.e(this), "");
    paramMap.put(new qmy.b(this), "");
    paramMap.put(new qmy.a(this), "");
    paramMap.put(new qmy.c(this), "");
    paramMap.put(new qmy.d(this), "");
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.equals(this.axL, paramqjq.vid)) {
      this.axL = paramqjq.vid;
    }
    for (this.aEu = true;; this.aEu = false)
    {
      b(paramqjq, paramStoryVideoItem);
      c(paramqjq, paramStoryVideoItem);
      d(paramqjq, paramStoryVideoItem);
      e(paramqjq, paramStoryVideoItem);
      return;
      this.axL = "";
    }
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if ((paramStoryVideoItem.isMine()) || (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid)))
    {
      this.mL.setVisibility(0);
      if (paramStoryVideoItem.mBanType == 0) {
        if (paramBoolean) {
          this.mL.setImageResource(2130847774);
        }
      }
      for (;;)
      {
        if (this.aEu) {
          rar.a("pub_control", "exp_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
        }
        return true;
        this.mL.setImageResource(2130847770);
        continue;
        if (paramStoryVideoItem.mBanType == 1) {
          this.mL.setImageResource(2130847772);
        } else if ((paramStoryVideoItem.mBanType == 2) || (paramStoryVideoItem.mBanType == 3)) {
          this.mL.setImageResource(2130847776);
        } else {
          this.mL.setImageResource(2130847774);
        }
      }
    }
    this.mL.setVisibility(8);
    return false;
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideVideoDetailInfo) && ((paramqjq.h == null) || (paramqjq.h.nodeType != 13));
  }
  
  public boolean b(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mTagInfoBase;
    if ((!TextUtils.isEmpty(paramStoryVideoItem.originalAuthorUnionId)) && (!TextUtils.isEmpty(paramStoryVideoItem.originalAuthorName)))
    {
      this.xo.setCompoundDrawablesWithIntrinsicBounds(2130847543, 0, 0, 0);
      this.xo.setCompoundDrawablePadding(rpq.dip2px(getActivity(), 2.0F));
      this.xo.setText(paramStoryVideoItem.originalAuthorName);
      this.xo.setVisibility(0);
      this.xo.setTag(paramStoryVideoItem.originalAuthorUnionId);
      if (this.xo.getVisibility() != 0) {
        break label249;
      }
      if (this.aEu) {
        if (localObject != null) {
          break label238;
        }
      }
    }
    label238:
    for (localObject = "";; localObject = String.valueOf(((rmw.a)localObject).id))
    {
      rar.a("play_video", "exp_tag_play", 0, 0, new String[] { "", localObject, paramqjq.feedId, paramStoryVideoItem.mVid });
      return true;
      if ((localObject != null) && (!TextUtils.isEmpty(((rmw.a)localObject).name)))
      {
        this.xo.setCompoundDrawablesWithIntrinsicBounds(2130847752, 0, 0, 0);
        this.xo.setCompoundDrawablePadding(rpq.dip2px(getActivity(), 2.0F));
        this.xo.setText(((rmw.a)localObject).name);
        this.xo.setVisibility(0);
        this.xo.setTag(null);
        break;
      }
      this.xo.setVisibility(8);
      this.xo.setTag(null);
      break;
    }
    label249:
    return false;
  }
  
  public void dJ(View paramView)
  {
    this.eQ = ((LinearLayout)paramView.findViewById(2131369319));
    this.eR = ((LinearLayout)paramView.findViewById(2131379212));
    this.eS = ((LinearLayout)paramView.findViewById(2131367538));
    this.mK = ((ImageView)paramView.findViewById(2131375220));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView = ((StoryUserBadgeView)paramView.findViewById(2131375227));
    this.us = ((TextView)paramView.findViewById(2131375221));
    this.xm = ((TextView)paramView.findViewById(2131378958));
    this.mTimeText = ((TextView)paramView.findViewById(2131375226));
    this.xn = ((TextView)paramView.findViewById(2131369318));
    this.mM = ((ImageView)paramView.findViewById(2131362986));
    this.b = ((ElasticImageView)paramView.findViewById(2131375224));
    this.xo = ((TextView)paramView.findViewById(2131378803));
    this.mL = ((ImageView)paramView.findViewById(2131381870));
    this.xp = ((TextView)paramView.findViewById(2131367546));
    this.mK.setOnClickListener(this);
    this.xm.setOnClickListener(this);
    this.us.setOnClickListener(this);
    this.mTimeText.setOnClickListener(this);
    this.mL.setOnClickListener(this);
    this.xo.setOnClickListener(this);
    this.eQ.setOnClickListener(this);
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Qmy$f != null) {
      b(this.jdField_a_of_type_Qmy$f);
    }
  }
  
  public int getLayoutId()
  {
    return 2131562029;
  }
  
  public String getTag()
  {
    return "DetailVideoInfoWidget";
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Qjq != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
      if (localStoryVideoItem != null) {
        break label45;
      }
      ram.e(this.TAG, "click error , video info not found");
    }
    label45:
    Object localObject2;
    Object localObject3;
    int i;
    label102:
    boolean bool;
    label245:
    label252:
    ausj localausj;
    label262:
    label317:
    label586:
    label595:
    label603:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localStoryVideoItem = null;
        break;
        localObject1 = ((StoryPlayerGroupHolder)a()).a();
        localObject2 = (ptf)psx.a(2);
        localObject3 = this.jdField_a_of_type_Qjq.a();
        localObject2 = ((ptf)localObject2).b(localStoryVideoItem.mOwnerUid);
        if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isVip)) {
          break label317;
        }
        i = 1;
        bool = qem.c(localStoryVideoItem);
        switch (paramView.getId())
        {
        }
      }
      i = pqy.a().bd(this.jdField_a_of_type_Qjq.feedId);
      if (i != -1)
      {
        StoryDetailActivity.a(getActivity(), this.jdField_a_of_type_Qjq.feedId, qem.dU(getVideoSource()), i, getVideoSource(), 0);
        if (localObject2 != null) {
          break label586;
        }
        i = 4;
        if (!bool) {
          break label595;
        }
        localObject1 = "2";
        if (this.b.getVisibility() != 0) {
          break label603;
        }
      }
      for (localObject2 = "2";; localObject2 = "1")
      {
        rar.a("play_video", "clk_list", i, 0, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
        break;
        i = 0;
        break label102;
        b(localStoryVideoItem, true);
        break;
        b(localStoryVideoItem, false);
        break;
        if (localObject2 == null) {
          break;
        }
        c((QQUserUIItem)localObject2);
        break;
        i(localStoryVideoItem);
        break;
        if (paramView.getTag() != null)
        {
          localObject1 = (String)paramView.getTag();
          ram.w(this.TAG, "startStoryProfileActivity by original author name, video-item-unionId=%s, tag-unionId=%s", new Object[] { localStoryVideoItem.originalAuthorUnionId, localObject1 });
          ppf.f(getActivity(), 9, (String)localObject1);
          break;
        }
        qev.a(getActivity(), localStoryVideoItem.mTagInfoBase);
        localObject2 = "1";
        localObject1 = "";
        if (localStoryVideoItem.mTagInfoBase != null) {
          if (localStoryVideoItem.mTagInfoBase.type != 0) {
            break label533;
          }
        }
        for (localObject1 = "1";; localObject1 = "2")
        {
          long l = localStoryVideoItem.mTagInfoBase.id;
          localObject3 = String.valueOf(l);
          localObject2 = localObject1;
          localObject1 = localObject3;
          rar.a("play_video", "clk_tag", 0, 0, new String[] { "", localObject2, localObject1, localStoryVideoItem.mVid });
          break;
        }
        j(localStoryVideoItem);
        break;
        StoryDetailActivity.a(getActivity(), this.jdField_a_of_type_Qjq.feedId, qem.dU(getVideoSource()), false, this.jdField_a_of_type_Qjq.vid, getVideoSource());
        break label245;
        i = rar.a((ptq)localObject2);
        break label252;
        localObject1 = "1";
        break label262;
      }
      localausj = (ausj)auss.b(getActivity(), null);
      localausj.addButton(acfp.m(2131704954), 5);
      localausj.addCancelButton(2131721058);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localausj.a(new qnb(this, localStoryVideoItem, (VideoViewVideoHolder)localObject1, localAtomicBoolean, localausj));
      localausj.a(new qnd(this, localAtomicBoolean, (VideoViewVideoHolder)localObject1));
    } while (localausj.isShowing());
    label533:
    localausj.show();
    if (localObject1 != null) {
      ((VideoViewVideoHolder)localObject1).sH(true);
    }
    label722:
    int j;
    if (i != 0)
    {
      i = 1;
      j = rar.a((FeedItem)localObject3);
      if (!bool) {
        break label784;
      }
    }
    label784:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      rar.a("play_video", "clk_more_play", i, j, new String[] { localObject1, String.valueOf(rar.a((ptq)localObject2)), localStoryVideoItem.mVid });
      break;
      i = 2;
      break label722;
    }
  }
  
  public static class a
    extends pml<qmy, pqs>
  {
    public a(qmy paramqmy)
    {
      super();
    }
    
    public void a(@NonNull qmy paramqmy, @NonNull pqs parampqs)
    {
      if ((paramqmy.a != null) && (TextUtils.equals(paramqmy.a.feedId, parampqs.feedId)))
      {
        ram.b(this.TAG, "receive feed info change event. %s.", parampqs.toString());
        paramqmy.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull qmy paramqmy, @NonNull pqs parampqs) {}
  }
  
  public static final class b
    extends QQUIEventReceiver<qmy, pxk.a>
  {
    public b(@NonNull qmy paramqmy)
    {
      super();
    }
    
    public void a(@NonNull qmy paramqmy, @NonNull pxk.a parama)
    {
      if ((parama.b.isSuccess()) && (parama.mO != null) && (paramqmy.a != null))
      {
        parama = parama.mO.iterator();
        while (parama.hasNext())
        {
          ptp localptp = (ptp)parama.next();
          if (TextUtils.equals(paramqmy.a.feedId, localptp.feedId)) {
            paramqmy.updateUI();
          }
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pxk.a.class;
    }
  }
  
  public static final class c
    extends QQUIEventReceiver<qmy, qvf.c>
  {
    public c(@NonNull qmy paramqmy)
    {
      super();
    }
    
    public void a(@NonNull qmy paramqmy, @NonNull qvf.c paramc)
    {
      if ((paramc.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramc.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramqmy.a != null) && (TextUtils.equals(paramc.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramqmy.a.feedId))) {
        paramqmy.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return qvf.c.class;
    }
  }
  
  public static class d
    extends pml<qmy, pxn.a>
  {
    public d(qmy paramqmy)
    {
      super();
    }
    
    public void a(@NonNull qmy paramqmy, @NonNull pxn.a parama)
    {
      if ((paramqmy.a != null) && (parama.b.isSuccess()) && (parama.mS.contains(paramqmy.a.vid)))
      {
        ram.b(this.TAG, "receive tag info change event. %s", parama.toString());
        paramqmy.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxn.a.class;
    }
    
    public void b(@NonNull qmy paramqmy, @NonNull pxn.a parama) {}
  }
  
  public static class e
    extends QQUIEventReceiver<qmy, pxs.b>
  {
    public e(@NonNull qmy paramqmy)
    {
      super();
    }
    
    public void a(@NonNull qmy paramqmy, @NonNull pxs.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.b(paramqmy.TAG, "receive user info event. %s.", paramb.toString());
        paramqmy.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  public class f
    extends pmd
  {
    public String axQ;
    
    private f() {}
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
    {
      super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
      boolean bool = TextUtils.equals(this.axQ, paramString);
      if (bool) {
        this.axQ = null;
      }
      StoryVideoItem localStoryVideoItem;
      if (qmy.this.a != null)
      {
        localStoryVideoItem = qmy.this.a.b();
        if (localStoryVideoItem != null) {
          break label64;
        }
      }
      label64:
      label326:
      do
      {
        do
        {
          ptf localptf;
          QQUserUIItem localQQUserUIItem;
          do
          {
            return;
            localStoryVideoItem = null;
            break;
            localptf = (ptf)psx.a(2);
            localQQUserUIItem = localptf.b(localStoryVideoItem.mOwnerUid);
          } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
          if (paramBoolean1)
          {
            if (paramBoolean2) {}
            for (paramInt = 1;; paramInt = 0)
            {
              localQQUserUIItem.isSubscribe = paramInt;
              ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localptf, localQQUserUIItem), 5, null, false);
              if (paramBoolean2)
              {
                paramString = (pmb)qem.getQQAppInterface().getManager(181);
                if (!paramString.Ip())
                {
                  paramString.blQ();
                  QQToast.a(qem.getApplicationContext(), 2, acfp.m(2131704956), 0).show();
                }
                paramString = new qwu(2);
                pmi.a().dispatch(paramString);
              }
              qmy.a(qmy.this, localStoryVideoItem, localQQUserUIItem);
              if (!bool) {
                break;
              }
              rar.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
              return;
            }
          }
          if (!paramBoolean2) {
            break label326;
          }
          QQToast.a(qem.getApplicationContext(), 1, acfp.m(2131704955), 0).show();
        } while (!bool);
        rar.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
        return;
        QQToast.a(qem.getApplicationContext(), 1, acfp.m(2131704953), 0).show();
      } while (!bool);
      rar.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmy
 * JD-Core Version:    0.7.0.1
 */