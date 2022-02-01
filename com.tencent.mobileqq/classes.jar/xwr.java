import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
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
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.io.File;
import java.util.Map;

public class xwr
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private wlg jdField_a_of_type_Wlg = new wlg();
  private final wst jdField_a_of_type_Wst = (wst)wth.a(15);
  protected xfj a;
  private xoa jdField_a_of_type_Xoa;
  private xoj jdField_a_of_type_Xoj;
  private xxf jdField_a_of_type_Xxf;
  private xxg jdField_a_of_type_Xxg;
  private final yme jdField_a_of_type_Yme = (yme)wth.a(11);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private View d;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View f;
  
  public xwr(ViewGroup paramViewGroup)
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
    bqyp.a(paramActivity, paramString6, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, 118, 10002, 0, null, null, false, 3);
  }
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846572);
    }
    while (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(zps.a(paramVideoListFeedItem.mLikeCount));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846885);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700095));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner localMediaScanner = MediaScanner.getInstance(b().getApplicationContext());
    System.currentTimeMillis();
    localMediaScanner.queryMediaInfoAsync(new xwx(this, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1, localLocalMediaInfo), localLocalMediaInfo);
  }
  
  private void b(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mCommentCount > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(zps.a(paramVideoListFeedItem.mCommentCount));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131700098));
  }
  
  private int d()
  {
    return (int)Math.min(bdep.b - bdep.a / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Xqz == null) {
      return;
    }
    wta localwta = (wta)wth.a(10);
    if (((Boolean)localwta.b("first_clk_forward", Boolean.valueOf(true))).booleanValue())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      bhpc localbhpc = bhlq.a(b(), 230);
      localbhpc.setTitle(anzj.a(2131700096)).setMessage(anzj.a(2131700089)).setPositiveButton(anzj.a(2131700097), new xwv(this)).setOnDismissListener(new xwu(this, localVideoViewVideoHolder));
      localbhpc.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      localwta.b("first_clk_forward", Boolean.valueOf(false));
      yup.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    for (;;)
    {
      yup.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString });
      return;
      e();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xqz == null) {
      return;
    }
    Object localObject2 = (wtt)wth.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
    if (localStoryVideoItem == null)
    {
      yuk.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Xqz.a();
    localObject2 = ((wtt)localObject2).b(localStoryVideoItem.mOwnerUid);
    VideoViewVideoHolder localVideoViewVideoHolder;
    if (localObject1 == null)
    {
      localObject1 = null;
      localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      if ((TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) || (!new File(localStoryVideoItem.mLocalVideoPath).exists())) {
        break label171;
      }
      a(localStoryVideoItem.mLocalVideoPath, ((QQUserUIItem)localObject2).uid, (String)localObject1, localStoryVideoItem.mVid, ((QQUserUIItem)localObject2).nickName, ((QQUserUIItem)localObject2).headUrl);
    }
    for (;;)
    {
      yup.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
      return;
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
      break;
      label171:
      a(b().getString(2131719186), true);
      this.jdField_a_of_type_Wlg.a(localStoryVideoItem.mVid, 0, true, new xww(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      ThreadManager.getUIHandlerV2().postDelayed(new BottomVideoInfoWidget.7(this, localVideoViewVideoHolder, localStoryVideoItem), 15000L);
    }
  }
  
  public String a()
  {
    return "BottomVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    new xws(this);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381457);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131381458);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131369922);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131369928));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369926));
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131364772);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364807));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131364820));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.f = paramView.findViewById(2131377489);
    this.f.setOnClickListener(this);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xxc(this), "");
    paramMap.put(new xxa(this), "");
    paramMap.put(new xxb(this), "");
    paramMap.put(new xxd(this), "");
    paramMap.put(new xwz(this), "");
    paramMap.put(new xxe(this), "");
    this.jdField_a_of_type_Xxf = new xxf(this);
    a(this.jdField_a_of_type_Xxf);
  }
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    yuk.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramxqz);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_Yme.a(paramxqz.jdField_b_of_type_JavaLangString, true);
    Object localObject;
    boolean bool1;
    boolean bool2;
    if ((!paramStoryVideoItem.isUploadSuc()) || (localVideoListFeedItem == null))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
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
        yuk.d((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramxqz.jdField_b_of_type_JavaLangString });
        k();
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
    label469:
    label496:
    int j;
    label512:
    int k;
    if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramxqz.jdField_a_of_type_JavaLangString))
    {
      this.jdField_e_of_type_Boolean = false;
      localObject = ((wtt)wth.a(2)).c(paramStoryVideoItem.mOwnerUid);
      i = a().mUIStyle.bottomWidgetShowFlag;
      switch (i)
      {
      default: 
        if (((paramStoryVideoItem.mStoryType != 1) || (localObject == null) || (((QQUserUIItem)localObject).isVip()) || (((QQUserUIItem)localObject).isFriend()) || (((QQUserUIItem)localObject).isMe())) || ((localObject != null) && (((QQUserUIItem)localObject).isFriend())))
        {
          bool1 = true;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isMe())) {
            break label663;
          }
          bool2 = true;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
            break label669;
          }
          bool3 = true;
          if (paramStoryVideoItem.mBanType != 1000) {
            break label675;
          }
          bool4 = true;
          if (paramStoryVideoItem.mStoryType != 2) {
            break label681;
          }
          bool5 = true;
          yuk.d(this.jdField_b_of_type_JavaLangString, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(a().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5)) {
            break label687;
          }
          i = 1;
          yuk.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget");
          if (i == 0) {
            break label780;
          }
          j();
          if (anxh.a() <= 16.0F) {
            break label727;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          a(localVideoListFeedItem);
          b(localVideoListFeedItem);
          if ((localObject == null) || (!((QQUserUIItem)localObject).isFriend())) {
            break label747;
          }
          i = 1;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isMe())) {
            break label752;
          }
          j = 1;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
            break label758;
          }
          k = 1;
          label528:
          if (paramStoryVideoItem.mStoryType != 2) {
            break label764;
          }
        }
        break;
      }
    }
    label663:
    label669:
    label675:
    label681:
    label687:
    label727:
    label747:
    label752:
    label758:
    label764:
    for (int m = 1;; m = 0)
    {
      if ((m != 0) || (j != 0) || (i != 0) || (k == 0)) {
        break label770;
      }
      this.f.setVisibility(0);
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      yup.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramxqz.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = paramxqz.jdField_a_of_type_JavaLangString;
      break label135;
      i = 1;
      yuk.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      break label435;
      i = 0;
      yuk.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
        yuk.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because friend and showBottomWidgetFlag=3");
        break label435;
      }
      i = 0;
      yuk.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget");
      break label435;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label469;
      i = 0;
      break label496;
      j = 0;
      break label512;
      k = 0;
      break label528;
    }
    label770:
    this.f.setVisibility(8);
    return;
    label780:
    k();
  }
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramxqz.jdField_a_of_type_Wvn == null) || (paramxqz.jdField_a_of_type_Wvn.a != 13);
  }
  
  public int b()
  {
    return 2131561794;
  }
  
  public boolean d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Xqz == null) {}
    label72:
    label345:
    label348:
    label352:
    for (;;)
    {
      return false;
      Object localObject = (wtt)wth.a(2);
      xqz localxqz = this.jdField_a_of_type_Xqz;
      StoryVideoItem localStoryVideoItem = localxqz.a();
      VideoListFeedItem localVideoListFeedItem = localxqz.a();
      int i;
      boolean bool;
      if (localStoryVideoItem != null)
      {
        localObject = ((wtt)localObject).b(localStoryVideoItem.mOwnerUid);
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label309;
        }
        i = 1;
        if (((localObject != null) && (((QQUserUIItem)localObject).isMe())) && ((this.jdField_a_of_type_Xms == null) || (!(this.jdField_a_of_type_Xms instanceof xng)))) {
          break label348;
        }
        localObject = ((xng)this.jdField_a_of_type_Xms).jdField_a_of_type_Wvn;
        bool = wwg.a(QQStoryContext.a()).a(((xng)this.jdField_a_of_type_Xms).a());
        if ((!bool) || (localObject == null)) {
          break label345;
        }
        if (localStoryVideoItem == null) {
          break label314;
        }
        l = ((wvn)localObject).a(localStoryVideoItem.mVid);
      }
      for (;;)
      {
        if ((!c()) || (this.d.getVisibility() != 0)) {
          break label352;
        }
        if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mHadLike != 1))
        {
          this.d.setTag(Boolean.valueOf(true));
          onClick(this.d);
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
            j = c();
            if (!bool) {
              break label324;
            }
          }
          for (localObject = String.valueOf(l);; localObject = String.valueOf(yup.a((String)localObject, localVideoListFeedItem)))
          {
            yup.a("play_video", "dbl_like", i, j, new String[] { "", localObject, "", localxqz.jdField_a_of_type_JavaLangString });
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
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Wlg != null) {
      this.jdField_a_of_type_Wlg.a();
    }
    if (this.jdField_a_of_type_Xoj != null) {
      this.jdField_a_of_type_Xoj.a();
    }
    if (this.jdField_a_of_type_Xxf != null) {
      b(this.jdField_a_of_type_Xxf);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xqz == null) {}
    Object localObject1;
    StoryVideoItem localStoryVideoItem;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = (wtt)wth.a(2);
      localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
      if (localStoryVideoItem != null) {
        break;
      }
      yuk.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString });
    }
    Object localObject3 = this.jdField_a_of_type_Xqz.a();
    QQUserUIItem localQQUserUIItem = ((wtt)localObject1).b(localStoryVideoItem.mOwnerUid);
    int i;
    label101:
    boolean bool5;
    boolean bool2;
    long l;
    boolean bool1;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      i = 1;
      bool5 = xiz.a(localStoryVideoItem);
      bool2 = false;
      l = 0L;
      if (!(this.jdField_a_of_type_Xms instanceof xng)) {
        break label1279;
      }
      localObject1 = ((xng)this.jdField_a_of_type_Xms).jdField_a_of_type_Wvn;
      bool1 = wwg.a(QQStoryContext.a()).a(((xng)this.jdField_a_of_type_Xms).a());
      if (!bool1) {
        break label1276;
      }
      l = ((wvn)localObject1).a(localStoryVideoItem.mVid);
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
      case 2131364772: 
      case 2131381457: 
      case 2131381458: 
        for (;;)
        {
          if ((localObject3 == null) || (((VideoListFeedItem)localObject3).mDenyComment != 1)) {
            break label277;
          }
          QQToast.a(xiz.a(), 1, anzj.a(2131700093), 0).a();
          break;
          i = 0;
          break label101;
          bool2 = true;
        }
        localObject2 = ((StoryPlayerGroupHolder)a()).a();
        if (localObject2 != null) {
          ((VideoViewVideoHolder)localObject2).c(true);
        }
        if (this.jdField_a_of_type_Xoj == null) {
          this.jdField_a_of_type_Xoj = new xoj();
        }
        localObject1 = anzj.a(2131700094);
        if ((localObject3 != null) && (((VideoListFeedItem)localObject3).type == 2)) {
          localObject1 = ((VideoListFeedItem)localObject3).getOwner().getName();
        }
        while (localQQUserUIItem == null)
        {
          bool1 = false;
          localObject3 = a();
          if ((((OpenPlayerBuilder.Data)localObject3).mInfo instanceof MsgTabPlayInfo)) {
            bool1 = wwg.a(QQStoryContext.a()).a(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject3).mInfo).nodeUnionId);
          }
          localObject1 = (String)localObject1 + anzj.a(2131700091);
          this.jdField_a_of_type_Xoa = new xoa(b(), this.jdField_a_of_type_Xqz.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Xoj, (String)localObject1, 4444, bool2, bool1);
          this.jdField_a_of_type_Xoa.show();
          this.jdField_a_of_type_Xoa.setOnDismissListener(new xwt(this, (VideoViewVideoHolder)localObject2));
          if (!(this.jdField_a_of_type_Xms instanceof xng)) {
            break label1261;
          }
          localObject1 = ((xng)this.jdField_a_of_type_Xms).jdField_a_of_type_Wvn;
          if (!bool1) {
            break label1261;
          }
          l = ((wvn)localObject1).a(localStoryVideoItem.mVid);
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
          yup.a("play_video", "input_reply", j, 0, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
          break;
        }
        if (localStoryVideoItem.mStoryType == 2)
        {
          localObject1 = localStoryVideoItem.mGroupId;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject3 != null) && (((VideoListFeedItem)localObject3).getOwner() != null) && ((((VideoListFeedItem)localObject3).getOwner() instanceof QQUserUIItem))) {
            localObject1 = ((QQUserUIItem)((VideoListFeedItem)localObject3).getOwner()).qq;
          }
        }
      case 2131369922: 
      case 2131377489: 
        for (;;)
        {
          label518:
          label537:
          label546:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((wtp)wth.a(23)).a(localQQUserUIItem, (String)localObject1, false, true);
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
            yup.a("play_video", "clk_reply", j, 1, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
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
              ((LikeEntry)localObject1).uin = QQStoryContext.a().a();
              ((LikeEntry)localObject1).unionId = QQStoryContext.a().b();
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
                if (c() != 106) {
                  break label1155;
                }
                j = 106;
                label957:
                wqn.a((CommentLikeFeedItem)localObject3, bool4, k, j);
                i();
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
                k = c();
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
                yup.a("play_video", (String)localObject1, j, k, new String[] { localObject2, localObject3, String.valueOf(localStoryVideoItem.mOwnerUid), this.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString });
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
                j = yup.a((String)localObject2, (VideoListFeedItem)localObject3);
                break label1048;
                localObject2 = "1";
                break label1063;
              }
            }
            if ((localStoryVideoItem.mHasLike == -1) || (localStoryVideoItem.mHasLike == 0))
            {
              this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846572);
              localStoryVideoItem.mHasLike = 1;
              break;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846885);
            localStoryVideoItem.mHasLike = 0;
            break;
            d();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwr
 * JD-Core Version:    0.7.0.1
 */