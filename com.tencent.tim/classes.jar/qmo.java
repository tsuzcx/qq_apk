import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3;
import com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.7;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class qmo
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private final psm jdField_a_of_type_Psm = (psm)psx.a(15);
  protected qbc a;
  private qmo.g jdField_a_of_type_Qmo$g;
  private qmo.h jdField_a_of_type_Qmo$h;
  private final qvf jdField_a_of_type_Qvf = (qvf)psx.a(11);
  private boolean aEu;
  private String axL = "";
  private PressDarkImageView jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private pno jdField_b_of_type_Pno = new pno();
  private qhr jdField_c_of_type_Qhr;
  private qhy jdField_c_of_type_Qhy;
  private TextView mCommentCountView;
  private View oj;
  private View ok;
  private View ol;
  private View om;
  private View on;
  private TextView xl;
  
  public qmo(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LocalMediaInfo paramLocalMediaInfo)
  {
    Intent localIntent = paramActivity.getIntent();
    localIntent.putExtra("is_video_forward", true);
    localIntent.putExtra("vip_forward_feedid", paramString1);
    localIntent.putExtra("vip_forward_vid", paramString2);
    localIntent.putExtra("vip_forward_uid", paramString3);
    localIntent.putExtra("vip_forward_name", paramString4);
    localIntent.putExtra("vip_forward_avatrname", paramString5);
    aytv.a(paramActivity, paramString6, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, 118, 10002, 0, null, null, false, 3);
  }
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.bvX();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847437);
    }
    while (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.xl.setText(rpq.aL(paramVideoListFeedItem.mLikeCount));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847751);
    }
    this.xl.setText(acfp.m(2131703258));
  }
  
  private void b(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.bvX();
    if (paramVideoListFeedItem.mCommentCount > 0)
    {
      this.mCommentCountView.setText(rpq.aL(paramVideoListFeedItem.mCommentCount));
      return;
    }
    this.mCommentCountView.setText(acfp.m(2131703261));
  }
  
  private void bpn()
  {
    if (this.jdField_a_of_type_Qjq == null) {
      return;
    }
    psr localpsr = (psr)psx.a(10);
    if (((Boolean)localpsr.c("first_clk_forward", Boolean.valueOf(true))).booleanValue())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      aqju localaqju = aqha.a(getActivity(), 230);
      localaqju.setTitle(acfp.m(2131703259)).setMessage(acfp.m(2131703252)).setPositiveButton(acfp.m(2131703260), new qms(this)).setOnDismissListener(new qmr(this, localVideoViewVideoHolder));
      localaqju.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(true);
      }
      localpsr.n("first_clk_forward", Boolean.valueOf(false));
      rar.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    for (;;)
    {
      rar.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Qjq.vid });
      return;
      bpo();
    }
  }
  
  private void bpo()
  {
    if (this.jdField_a_of_type_Qjq == null) {
      return;
    }
    Object localObject2 = (ptf)psx.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
    if (localStoryVideoItem == null)
    {
      ram.e(this.TAG, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Qjq.vid });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Qjq.a();
    localObject2 = ((ptf)localObject2).b(localStoryVideoItem.mOwnerUid);
    VideoViewVideoHolder localVideoViewVideoHolder;
    if (localObject1 == null)
    {
      localObject1 = null;
      localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      if ((TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) || (!new File(localStoryVideoItem.mLocalVideoPath).exists())) {
        break label171;
      }
      e(localStoryVideoItem.mLocalVideoPath, ((QQUserUIItem)localObject2).uid, (String)localObject1, localStoryVideoItem.mVid, ((QQUserUIItem)localObject2).nickName, ((QQUserUIItem)localObject2).headUrl);
    }
    for (;;)
    {
      rar.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
      return;
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
      break;
      label171:
      a(getActivity().getString(2131721701), true);
      this.jdField_b_of_type_Pno.a(localStoryVideoItem.mVid, 0, true, new qmt(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(true);
      }
      ThreadManager.getUIHandlerV2().postDelayed(new BottomVideoInfoWidget.7(this, localVideoViewVideoHolder, localStoryVideoItem), 15000L);
    }
  }
  
  private void e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner localMediaScanner = MediaScanner.getInstance(getActivity().getApplicationContext());
    System.currentTimeMillis();
    localMediaScanner.queryMediaInfoAsync(new qmu(this, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1, localLocalMediaInfo), localLocalMediaInfo);
  }
  
  private int sE()
  {
    return (int)Math.min(ankt.cIE - ankt.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  public boolean Ka()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Qjq == null) {}
    label72:
    label345:
    label348:
    label352:
    for (;;)
    {
      return false;
      Object localObject = (ptf)psx.a(2);
      qjq localqjq = this.jdField_a_of_type_Qjq;
      StoryVideoItem localStoryVideoItem = localqjq.b();
      VideoListFeedItem localVideoListFeedItem = localqjq.a();
      int i;
      boolean bool;
      if (localStoryVideoItem != null)
      {
        localObject = ((ptf)localObject).b(localStoryVideoItem.mOwnerUid);
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label309;
        }
        i = 1;
        if (((localObject != null) && (((QQUserUIItem)localObject).isMe())) && ((this.d == null) || (!(this.d instanceof qhc.a)))) {
          break label348;
        }
        localObject = ((qhc.a)this.d).g;
        bool = puy.a(QQStoryContext.a()).fh(((qhc.a)this.d).getUnionId());
        if ((!bool) || (localObject == null)) {
          break label345;
        }
        if (localStoryVideoItem == null) {
          break label314;
        }
        l = ((puh)localObject).N(localStoryVideoItem.mVid);
      }
      for (;;)
      {
        if ((!isShow()) || (this.ol.getVisibility() != 0)) {
          break label352;
        }
        if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mHadLike != 1))
        {
          this.ol.setTag(Boolean.valueOf(true));
          onClick(this.ol);
        }
        localObject = a();
        if ((((OpenPlayerBuilder.Data)localObject).mInfo instanceof MsgTabPlayInfo)) {}
        for (localObject = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject).mInfo).nodeUnionId;; localObject = null)
        {
          label247:
          int j;
          if (i != 0)
          {
            i = 1;
            j = getVideoSource();
            if (!bool) {
              break label324;
            }
          }
          for (localObject = String.valueOf(l);; localObject = String.valueOf(rar.a((String)localObject, localVideoListFeedItem)))
          {
            rar.a("play_video", "dbl_like", i, j, new String[] { "", localObject, "", localqjq.vid });
            return true;
            localObject = null;
            break;
            i = 0;
            break label72;
            l = 0L;
            break label161;
            i = 2;
            break label247;
          }
        }
        continue;
        bool = false;
      }
    }
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new qmo.d(this), "");
    paramMap.put(new qmo.b(this), "");
    paramMap.put(new qmo.c(this), "");
    paramMap.put(new qmo.e(this), "");
    paramMap.put(new qmo.a(this), "");
    paramMap.put(new qmo.f(this), "");
    this.jdField_a_of_type_Qmo$g = new qmo.g();
    a(this.jdField_a_of_type_Qmo$g);
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ram.b(this.TAG, "bindData=%s", paramqjq);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_Qvf.a(paramqjq.feedId, true);
    Object localObject;
    boolean bool1;
    boolean bool2;
    if ((!paramStoryVideoItem.isUploadSuc()) || (localVideoListFeedItem == null))
    {
      localObject = this.TAG;
      if (!paramStoryVideoItem.isUploadSuc())
      {
        bool1 = true;
        if (localVideoListFeedItem != null) {
          break label110;
        }
      }
      label110:
      for (bool2 = true;; bool2 = false)
      {
        ram.w((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramqjq.feedId });
        hide();
        return;
        bool1 = false;
        break;
      }
    }
    label135:
    int i;
    label237:
    label253:
    boolean bool3;
    label269:
    boolean bool4;
    label282:
    boolean bool5;
    label293:
    label435:
    label470:
    label497:
    int j;
    label513:
    int k;
    if (TextUtils.equals(this.axL, paramqjq.vid))
    {
      this.aEu = false;
      localObject = ((ptf)psx.a(2)).c(paramStoryVideoItem.mOwnerUid);
      i = a().mUIStyle.bottomWidgetShowFlag;
      switch (i)
      {
      default: 
        if (((paramStoryVideoItem.mStoryType != 1) || (localObject == null) || (((QQUserUIItem)localObject).isVip()) || (((QQUserUIItem)localObject).isFriend()) || (((QQUserUIItem)localObject).isMe())) || ((localObject != null) && (((QQUserUIItem)localObject).isFriend())))
        {
          bool1 = true;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isMe())) {
            break label664;
          }
          bool2 = true;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
            break label670;
          }
          bool3 = true;
          if (paramStoryVideoItem.mBanType != 1000) {
            break label676;
          }
          bool4 = true;
          if (paramStoryVideoItem.mStoryType != 2) {
            break label682;
          }
          bool5 = true;
          ram.w(this.TAG, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(a().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5)) {
            break label688;
          }
          i = 1;
          ram.w(this.TAG, "show BottomWidget");
          if (i == 0) {
            break label781;
          }
          show();
          if (acej.aV() <= 16.0F) {
            break label728;
          }
          this.oj.setVisibility(8);
          this.ok.setVisibility(0);
          a(localVideoListFeedItem);
          b(localVideoListFeedItem);
          if ((localObject == null) || (!((QQUserUIItem)localObject).isFriend())) {
            break label748;
          }
          i = 1;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isMe())) {
            break label753;
          }
          j = 1;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
            break label759;
          }
          k = 1;
          label529:
          if (paramStoryVideoItem.mStoryType != 2) {
            break label765;
          }
        }
        break;
      }
    }
    label664:
    label670:
    label676:
    label682:
    label688:
    label728:
    label748:
    label753:
    label759:
    label765:
    for (int m = 1;; m = 0)
    {
      if ((m != 0) || (j != 0) || (i != 0) || (k == 0)) {
        break label771;
      }
      this.on.setVisibility(0);
      if (!this.aEu) {
        break;
      }
      rar.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramqjq.vid });
      return;
      this.aEu = true;
      this.axL = paramqjq.vid;
      break label135;
      i = 1;
      ram.w(this.TAG, "show BottomWidget because flag 1");
      break label435;
      i = 0;
      ram.w(this.TAG, "hide BottomWidget because flag 2");
      break label435;
      bool1 = false;
      break label237;
      bool2 = false;
      break label253;
      bool3 = false;
      break label269;
      bool4 = false;
      break label282;
      bool5 = false;
      break label293;
      if ((bool1) && (i == 3))
      {
        i = 1;
        ram.w(this.TAG, "show BottomWidget because friend and showBottomWidgetFlag=3");
        break label435;
      }
      i = 0;
      ram.w(this.TAG, "hide BottomWidget");
      break label435;
      this.oj.setVisibility(0);
      this.ok.setVisibility(8);
      break label470;
      i = 0;
      break label497;
      j = 0;
      break label513;
      k = 0;
      break label529;
    }
    label771:
    this.on.setVisibility(8);
    return;
    label781:
    hide();
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramqjq.h == null) || (paramqjq.h.nodeType != 13);
  }
  
  public void dJ(View paramView)
  {
    new qmp(this);
    this.oj = paramView.findViewById(2131382326);
    this.oj.setOnClickListener(this);
    this.ok = paramView.findViewById(2131382327);
    this.ok.setOnClickListener(this);
    this.ol = paramView.findViewById(2131370437);
    this.ol.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131370443));
    this.xl = ((TextView)paramView.findViewById(2131370441));
    this.om = paramView.findViewById(2131364968);
    this.mCommentCountView = ((TextView)paramView.findViewById(2131365001));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131365014));
    this.om.setOnClickListener(this);
    this.on = paramView.findViewById(2131378168);
    this.on.setOnClickListener(this);
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy()
  {
    if (this.jdField_b_of_type_Pno != null) {
      this.jdField_b_of_type_Pno.stop();
    }
    if (this.jdField_c_of_type_Qhy != null) {
      this.jdField_c_of_type_Qhy.destroy();
    }
    if (this.jdField_a_of_type_Qmo$g != null) {
      b(this.jdField_a_of_type_Qmo$g);
    }
  }
  
  public int getLayoutId()
  {
    return 2131561911;
  }
  
  public String getTag()
  {
    return "BottomVideoInfoWidget";
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qjq == null) {}
    Object localObject1;
    StoryVideoItem localStoryVideoItem;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = (ptf)psx.a(2);
      localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
      if (localStoryVideoItem != null) {
        break;
      }
      ram.e(this.TAG, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Qjq.vid });
    }
    Object localObject3 = this.jdField_a_of_type_Qjq.a();
    QQUserUIItem localQQUserUIItem = ((ptf)localObject1).b(localStoryVideoItem.mOwnerUid);
    int i;
    label101:
    boolean bool5;
    boolean bool2;
    long l;
    boolean bool1;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      i = 1;
      bool5 = qem.c(localStoryVideoItem);
      bool2 = false;
      l = 0L;
      if (!(this.d instanceof qhc.a)) {
        break label1279;
      }
      localObject1 = ((qhc.a)this.d).g;
      bool1 = puy.a(QQStoryContext.a()).fh(((qhc.a)this.d).getUnionId());
      if (!bool1) {
        break label1276;
      }
      l = ((puh)localObject1).N(localStoryVideoItem.mVid);
    }
    for (;;)
    {
      label277:
      Object localObject2;
      label352:
      int j;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364968: 
      case 2131382326: 
      case 2131382327: 
        for (;;)
        {
          if ((localObject3 == null) || (((VideoListFeedItem)localObject3).mDenyComment != 1)) {
            break label277;
          }
          QQToast.a(qem.getApplicationContext(), 1, acfp.m(2131703256), 0).show();
          break;
          i = 0;
          break label101;
          bool2 = true;
        }
        localObject2 = ((StoryPlayerGroupHolder)a()).a();
        if (localObject2 != null) {
          ((VideoViewVideoHolder)localObject2).sH(true);
        }
        if (this.jdField_c_of_type_Qhy == null) {
          this.jdField_c_of_type_Qhy = new qhy();
        }
        localObject1 = acfp.m(2131703257);
        if ((localObject3 != null) && (((VideoListFeedItem)localObject3).type == 2)) {
          localObject1 = ((VideoListFeedItem)localObject3).getOwner().getName();
        }
        while (localQQUserUIItem == null)
        {
          bool1 = false;
          localObject3 = a();
          if ((((OpenPlayerBuilder.Data)localObject3).mInfo instanceof MsgTabPlayInfo)) {
            bool1 = puy.a(QQStoryContext.a()).fh(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject3).mInfo).nodeUnionId);
          }
          localObject1 = (String)localObject1 + acfp.m(2131703254);
          this.jdField_c_of_type_Qhr = new qhr(getActivity(), this.jdField_a_of_type_Qjq.feedId, this.jdField_c_of_type_Qhy, (String)localObject1, 4444, bool2, bool1);
          this.jdField_c_of_type_Qhr.show();
          this.jdField_c_of_type_Qhr.setOnDismissListener(new qmq(this, (VideoViewVideoHolder)localObject2));
          if (!(this.d instanceof qhc.a)) {
            break label1261;
          }
          localObject1 = ((qhc.a)this.d).g;
          if (!bool1) {
            break label1261;
          }
          l = ((puh)localObject1).N(localStoryVideoItem.mVid);
          if (!bool2) {
            break label727;
          }
          j = (int)l;
          if (!bool5) {
            break label711;
          }
          localObject1 = "2";
          if (i == 0) {
            break label719;
          }
          localObject2 = "2";
          rar.a("play_video", "input_reply", j, 0, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
          break;
        }
        if (localStoryVideoItem.mStoryType == 2)
        {
          localObject1 = localStoryVideoItem.mGroupId;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject3 != null) && (((VideoListFeedItem)localObject3).getOwner() != null) && ((((VideoListFeedItem)localObject3).getOwner() instanceof QQUserUIItem))) {
            localObject1 = ((QQUserUIItem)((VideoListFeedItem)localObject3).getOwner()).qq;
          }
        }
      case 2131370437: 
      case 2131378168: 
        for (;;)
        {
          label518:
          label537:
          label546:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((ptc)psx.a(23)).a(localQQUserUIItem, (String)localObject1, false, true);
            break label352;
          }
          if (localQQUserUIItem.isVipButNoFriend())
          {
            localObject1 = localQQUserUIItem.nickName;
            break label352;
          }
          localObject1 = localQQUserUIItem.getDisplayName();
          break label352;
          label711:
          localObject1 = "1";
          break label537;
          label719:
          localObject2 = "1";
          break label546;
          label727:
          j = (int)l;
          if (bool5)
          {
            localObject1 = "2";
            label741:
            if (i == 0) {
              break label799;
            }
          }
          label799:
          for (localObject2 = "2";; localObject2 = "1")
          {
            rar.a("play_video", "clk_reply", j, 1, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
            break;
            localObject1 = "1";
            break label741;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
          {
            bool2 = ((Boolean)localObject1).booleanValue();
            paramView.setTag(null);
          }
          for (;;)
          {
            if (localObject3 != null)
            {
              localObject1 = new LikeEntry();
              ((LikeEntry)localObject1).likeTime = System.currentTimeMillis();
              ((LikeEntry)localObject1).uin = QQStoryContext.a().mi();
              ((LikeEntry)localObject1).unionId = QQStoryContext.a().getCurrentUid();
              ((LikeEntry)localObject1).feedId = ((VideoListFeedItem)localObject3).feedId;
              boolean bool3;
              label907:
              label930:
              boolean bool4;
              label938:
              int k;
              if (((VideoListFeedItem)localObject3).mHadLike == 1)
              {
                bool3 = true;
                if (!bool3) {
                  break label1128;
                }
                ((VideoListFeedItem)localObject3).mHadLike = 0;
                ((VideoListFeedItem)localObject3).mLikeCount -= 1;
                if (bool3) {
                  break label1149;
                }
                bool4 = true;
                k = ((VideoListFeedItem)localObject3).getCommentLikeType();
                if (getVideoSource() != 106) {
                  break label1155;
                }
                j = 106;
                label957:
                pqt.a((CommentLikeFeedItem)localObject3, bool4, k, j);
                updateUI();
                ThreadManager.post(new BottomVideoInfoWidget.3(this, bool3, (LikeEntry)localObject1, (VideoListFeedItem)localObject3), 5, null, false);
                if (bool2) {
                  break;
                }
                localObject2 = null;
                localObject1 = a();
                if ((((OpenPlayerBuilder.Data)localObject1).mInfo instanceof MsgTabPlayInfo)) {
                  localObject2 = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject1).mInfo).nodeUnionId;
                }
                if (!bool3) {
                  break label1160;
                }
                localObject1 = "unlike";
                label1039:
                if (!bool1) {
                  break label1168;
                }
                j = (int)l;
                label1048:
                k = getVideoSource();
                if (i == 0) {
                  break label1179;
                }
                localObject2 = "2";
                label1063:
                if (!bool5) {
                  break label1187;
                }
              }
              label1155:
              label1160:
              label1168:
              label1179:
              label1187:
              for (localObject3 = "2";; localObject3 = "1")
              {
                rar.a("play_video", (String)localObject1, j, k, new String[] { localObject2, localObject3, String.valueOf(localStoryVideoItem.mOwnerUid), this.jdField_a_of_type_Qjq.vid });
                break;
                bool3 = false;
                break label907;
                label1128:
                ((VideoListFeedItem)localObject3).mHadLike = 1;
                ((VideoListFeedItem)localObject3).mLikeCount += 1;
                break label930;
                label1149:
                bool4 = false;
                break label938;
                j = 0;
                break label957;
                localObject1 = "like";
                break label1039;
                j = rar.a((String)localObject2, (VideoListFeedItem)localObject3);
                break label1048;
                localObject2 = "1";
                break label1063;
              }
            }
            if ((localStoryVideoItem.mHasLike == -1) || (localStoryVideoItem.mHasLike == 0))
            {
              this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847437);
              localStoryVideoItem.mHasLike = 1;
              break;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847751);
            localStoryVideoItem.mHasLike = 0;
            break;
            bpn();
            break;
            bool2 = false;
          }
          label1261:
          l = 0L;
          break label518;
          continue;
          localObject1 = null;
        }
        label1276:
        continue;
        label1279:
        bool1 = false;
      }
    }
  }
  
  public static class a
    extends QQUIEventReceiver<qmo, qem.a>
  {
    public a(@NonNull qmo paramqmo)
    {
      super();
    }
    
    public void a(@NonNull qmo paramqmo, @NonNull qem.a parama)
    {
      if (TextUtils.equals(String.valueOf(paramqmo.hashCode()), parama.key)) {
        b(paramqmo, parama);
      }
    }
    
    public Class acceptEventClass()
    {
      return qem.a.class;
    }
    
    public void b(qmo paramqmo, qem.a parama)
    {
      paramqmo = ((StoryPlayerGroupHolder)paramqmo.a()).a();
      if (paramqmo != null) {
        paramqmo.sH(false);
      }
      if (parama.g == null) {
        return;
      }
      boolean bool = qem.c(parama.g);
      switch (parama.status)
      {
      case 0: 
      default: 
        return;
      case 1: 
        QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131703250), 0).show();
        return;
      case 2: 
        if (bool) {}
        for (paramqmo = "2";; paramqmo = "1")
        {
          rar.a("play_video", "down_suc", 0, 0, new String[] { paramqmo, "", "", parama.g.mVid });
          QQToast.a(BaseApplicationImpl.getContext(), 2, ppf.getString(2131701960), 0).show();
          return;
        }
      }
      if (bool) {}
      for (paramqmo = "2";; paramqmo = "1")
      {
        rar.a("play_video", "down_fail", 0, 0, new String[] { paramqmo, "", "", parama.g.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131703251), 0).show();
        return;
      }
    }
  }
  
  public static class b
    extends pml<qmo, pqs>
  {
    public b(qmo paramqmo)
    {
      super();
    }
    
    public void a(@NonNull qmo paramqmo, @NonNull pqs parampqs)
    {
      if ((paramqmo.a != null) && (TextUtils.equals(paramqmo.a.feedId, parampqs.feedId)))
      {
        ram.b(this.TAG, "receive feed info change event. %s.", parampqs.toString());
        paramqmo.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull qmo paramqmo, @NonNull pqs parampqs) {}
  }
  
  public static class c
    extends QQUIEventReceiver<qmo, qeu.b>
  {
    public c(@NonNull qmo paramqmo)
    {
      super();
    }
    
    public void a(@NonNull qmo paramqmo, @NonNull qeu.b paramb)
    {
      if (!TextUtils.equals(paramb.axg, String.valueOf(paramqmo.hashCode()))) {
        return;
      }
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramqmo.a()).a();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(false);
      }
      paramqmo.bpm();
      if (paramb.b.isSuccess())
      {
        ram.b(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramb.axf);
        if (paramb.f.mIsPicture == 1)
        {
          qeu.a().v(paramqmo.getActivity(), paramb.axf);
          return;
        }
        qeu.a().a(paramqmo.getActivity(), paramb.axf, paramb.f, paramqmo.hashCode());
        return;
      }
      ram.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
      QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131703249), 0).show();
    }
    
    public Class acceptEventClass()
    {
      return qeu.b.class;
    }
  }
  
  public static final class d
    extends QQUIEventReceiver<qmo, pxk.a>
  {
    public d(@NonNull qmo paramqmo)
    {
      super();
    }
    
    public void a(@NonNull qmo paramqmo, @NonNull pxk.a parama)
    {
      if ((parama.b.isSuccess()) && (parama.mO != null) && (paramqmo.a != null))
      {
        parama = parama.mO.iterator();
        while (parama.hasNext())
        {
          ptp localptp = (ptp)parama.next();
          if (TextUtils.equals(paramqmo.a.feedId, localptp.feedId)) {
            paramqmo.updateUI();
          }
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pxk.a.class;
    }
  }
  
  public static final class e
    extends QQUIEventReceiver<qmo, qvf.c>
  {
    public e(@NonNull qmo paramqmo)
    {
      super();
    }
    
    public void a(@NonNull qmo paramqmo, @NonNull qvf.c paramc)
    {
      if ((paramc.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramc.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramqmo.a != null) && (TextUtils.equals(paramc.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramqmo.a.feedId)))
      {
        ram.b(paramqmo.TAG, "refresh feed item , feed id :%s", paramqmo.a.feedId);
        paramqmo.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return qvf.c.class;
    }
  }
  
  public static class f
    extends QQUIEventReceiver<qmo, pxs.b>
  {
    public f(@NonNull qmo paramqmo)
    {
      super();
    }
    
    public void a(@NonNull qmo paramqmo, @NonNull pxs.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.b(paramqmo.TAG, "receive user info event. %s.", paramb.toString());
        paramqmo.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  public class g
    extends qjh
  {
    public g() {}
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      Object localObject = qmo.this.a();
      if ((localObject == null) || (!qmo.this.d.equals(localObject))) {}
      do
      {
        return;
        if (paramInt1 == qmo.this.hashCode())
        {
          ram.d(qmo.this.TAG, "onActivityResult, onChooseFriendResult");
          localObject = ((StoryPlayerGroupHolder)qmo.this.a()).a();
          if (localObject != null) {
            ((VideoViewVideoHolder)localObject).sH(false);
          }
          if (paramInt2 == -1) {
            qeu.a().aU(paramIntent.getExtras());
          }
        }
        if ((paramInt1 == 10002) && (paramInt2 == -1))
        {
          pnx.qU(qmo.this.TAG + " onActivityResult");
          QQToast.a(qmo.this.getActivity(), qmo.this.getActivity().getString(2131720184), 1).show();
        }
        if ((paramInt1 == 467) && (paramInt2 == -1) && (qmo.a(qmo.this) != null)) {
          qmo.a(qmo.this).onSuccess();
        }
        if (QLog.isColorLevel()) {
          QLog.d(qmo.this.TAG, 2, new Object[] { "BottomVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
        }
      } while (qmo.this.a == null);
      qmo.this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      if (qmo.a(qmo.this) != null) {
        qmo.a(qmo.this).stop();
      }
    }
    
    public void onResume()
    {
      super.onResume();
      if ((ayxa.sHasNotch) && (!ankt.bA(qmo.this.mItemView.getContext())) && (qmo.a(qmo.this) - rpq.dip2px(qmo.this.mItemView.getContext(), 9.0F) > 0))
      {
        Object localObject = qmo.a(qmo.this).getBackground();
        if ((localObject instanceof StateListDrawable))
        {
          localObject = (DrawableContainer.DrawableContainerState)((StateListDrawable)localObject).getConstantState();
          if (localObject != null) {
            ((GradientDrawable)localObject.getChildren()[0]).setColor(qmo.this.mItemView.getResources().getColor(2131167663));
          }
        }
      }
    }
  }
  
  public static abstract interface h
  {
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmo
 * JD-Core Version:    0.7.0.1
 */