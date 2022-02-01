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

public class xsw
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private whl jdField_a_of_type_Whl = new whl();
  private final woy jdField_a_of_type_Woy = (woy)wpm.a(15);
  protected xbo a;
  private xkf jdField_a_of_type_Xkf;
  private xko jdField_a_of_type_Xko;
  private xtk jdField_a_of_type_Xtk;
  private xtl jdField_a_of_type_Xtl;
  private final yij jdField_a_of_type_Yij = (yij)wpm.a(11);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private View d;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View f;
  
  public xsw(ViewGroup paramViewGroup)
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
    bpwu.a(paramActivity, paramString6, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, 118, 10002, 0, null, null, false, 3);
  }
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846555);
    }
    while (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(zlx.a(paramVideoListFeedItem.mLikeCount));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846868);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131699988));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner localMediaScanner = MediaScanner.getInstance(b().getApplicationContext());
    System.currentTimeMillis();
    localMediaScanner.queryMediaInfoAsync(new xtc(this, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1, localLocalMediaInfo), localLocalMediaInfo);
  }
  
  private void b(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mCommentCount > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(zlx.a(paramVideoListFeedItem.mCommentCount));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131699991));
  }
  
  private int d()
  {
    return (int)Math.min(bclx.b - bclx.a / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Xne == null) {
      return;
    }
    wpf localwpf = (wpf)wpm.a(10);
    if (((Boolean)localwpf.b("first_clk_forward", Boolean.valueOf(true))).booleanValue())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      bgpa localbgpa = bglp.a(b(), 230);
      localbgpa.setTitle(anni.a(2131699989)).setMessage(anni.a(2131699982)).setPositiveButton(anni.a(2131699990), new xta(this)).setOnDismissListener(new xsz(this, localVideoViewVideoHolder));
      localbgpa.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      localwpf.b("first_clk_forward", Boolean.valueOf(false));
      yqu.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    for (;;)
    {
      yqu.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString });
      return;
      e();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xne == null) {
      return;
    }
    Object localObject2 = (wpy)wpm.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xne.a();
    if (localStoryVideoItem == null)
    {
      yqp.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Xne.a();
    localObject2 = ((wpy)localObject2).b(localStoryVideoItem.mOwnerUid);
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
      yqu.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
      return;
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
      break;
      label171:
      a(b().getString(2131719017), true);
      this.jdField_a_of_type_Whl.a(localStoryVideoItem.mVid, 0, true, new xtb(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
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
    new xsx(this);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381283);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131381284);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131369824);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131369830));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369828));
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131364725);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364760));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131364773));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.f = paramView.findViewById(2131377349);
    this.f.setOnClickListener(this);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xth(this), "");
    paramMap.put(new xtf(this), "");
    paramMap.put(new xtg(this), "");
    paramMap.put(new xti(this), "");
    paramMap.put(new xte(this), "");
    paramMap.put(new xtj(this), "");
    this.jdField_a_of_type_Xtk = new xtk(this);
    a(this.jdField_a_of_type_Xtk);
  }
  
  public void a(@NonNull xne paramxne, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    yqp.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramxne);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_Yij.a(paramxne.jdField_b_of_type_JavaLangString, true);
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
        yqp.d((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramxne.jdField_b_of_type_JavaLangString });
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
    if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramxne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_e_of_type_Boolean = false;
      localObject = ((wpy)wpm.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
          yqp.d(this.jdField_b_of_type_JavaLangString, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(a().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5)) {
            break label687;
          }
          i = 1;
          yqp.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget");
          if (i == 0) {
            break label780;
          }
          j();
          if (anll.a() <= 16.0F) {
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
      yqu.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramxne.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = paramxne.jdField_a_of_type_JavaLangString;
      break label135;
      i = 1;
      yqp.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      break label435;
      i = 0;
      yqp.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
        yqp.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because friend and showBottomWidgetFlag=3");
        break label435;
      }
      i = 0;
      yqp.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget");
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
  
  public boolean a(@NonNull xne paramxne, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramxne.jdField_a_of_type_Wrs == null) || (paramxne.jdField_a_of_type_Wrs.a != 13);
  }
  
  public int b()
  {
    return 2131561753;
  }
  
  public boolean d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Xne == null) {}
    label72:
    label345:
    label348:
    label352:
    for (;;)
    {
      return false;
      Object localObject = (wpy)wpm.a(2);
      xne localxne = this.jdField_a_of_type_Xne;
      StoryVideoItem localStoryVideoItem = localxne.a();
      VideoListFeedItem localVideoListFeedItem = localxne.a();
      int i;
      boolean bool;
      if (localStoryVideoItem != null)
      {
        localObject = ((wpy)localObject).b(localStoryVideoItem.mOwnerUid);
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label309;
        }
        i = 1;
        if (((localObject != null) && (((QQUserUIItem)localObject).isMe())) && ((this.jdField_a_of_type_Xix == null) || (!(this.jdField_a_of_type_Xix instanceof xjl)))) {
          break label348;
        }
        localObject = ((xjl)this.jdField_a_of_type_Xix).jdField_a_of_type_Wrs;
        bool = wsl.a(QQStoryContext.a()).a(((xjl)this.jdField_a_of_type_Xix).a());
        if ((!bool) || (localObject == null)) {
          break label345;
        }
        if (localStoryVideoItem == null) {
          break label314;
        }
        l = ((wrs)localObject).a(localStoryVideoItem.mVid);
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
          for (localObject = String.valueOf(l);; localObject = String.valueOf(yqu.a((String)localObject, localVideoListFeedItem)))
          {
            yqu.a("play_video", "dbl_like", i, j, new String[] { "", localObject, "", localxne.jdField_a_of_type_JavaLangString });
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
    if (this.jdField_a_of_type_Whl != null) {
      this.jdField_a_of_type_Whl.a();
    }
    if (this.jdField_a_of_type_Xko != null) {
      this.jdField_a_of_type_Xko.a();
    }
    if (this.jdField_a_of_type_Xtk != null) {
      b(this.jdField_a_of_type_Xtk);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xne == null) {}
    Object localObject1;
    StoryVideoItem localStoryVideoItem;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = (wpy)wpm.a(2);
      localStoryVideoItem = this.jdField_a_of_type_Xne.a();
      if (localStoryVideoItem != null) {
        break;
      }
      yqp.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString });
    }
    Object localObject3 = this.jdField_a_of_type_Xne.a();
    QQUserUIItem localQQUserUIItem = ((wpy)localObject1).b(localStoryVideoItem.mOwnerUid);
    int i;
    label101:
    boolean bool5;
    boolean bool2;
    long l;
    boolean bool1;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      i = 1;
      bool5 = xfe.a(localStoryVideoItem);
      bool2 = false;
      l = 0L;
      if (!(this.jdField_a_of_type_Xix instanceof xjl)) {
        break label1279;
      }
      localObject1 = ((xjl)this.jdField_a_of_type_Xix).jdField_a_of_type_Wrs;
      bool1 = wsl.a(QQStoryContext.a()).a(((xjl)this.jdField_a_of_type_Xix).a());
      if (!bool1) {
        break label1276;
      }
      l = ((wrs)localObject1).a(localStoryVideoItem.mVid);
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
      case 2131364725: 
      case 2131381283: 
      case 2131381284: 
        for (;;)
        {
          if ((localObject3 == null) || (((VideoListFeedItem)localObject3).mDenyComment != 1)) {
            break label277;
          }
          QQToast.a(xfe.a(), 1, anni.a(2131699986), 0).a();
          break;
          i = 0;
          break label101;
          bool2 = true;
        }
        localObject2 = ((StoryPlayerGroupHolder)a()).a();
        if (localObject2 != null) {
          ((VideoViewVideoHolder)localObject2).c(true);
        }
        if (this.jdField_a_of_type_Xko == null) {
          this.jdField_a_of_type_Xko = new xko();
        }
        localObject1 = anni.a(2131699987);
        if ((localObject3 != null) && (((VideoListFeedItem)localObject3).type == 2)) {
          localObject1 = ((VideoListFeedItem)localObject3).getOwner().getName();
        }
        while (localQQUserUIItem == null)
        {
          bool1 = false;
          localObject3 = a();
          if ((((OpenPlayerBuilder.Data)localObject3).mInfo instanceof MsgTabPlayInfo)) {
            bool1 = wsl.a(QQStoryContext.a()).a(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject3).mInfo).nodeUnionId);
          }
          localObject1 = (String)localObject1 + anni.a(2131699984);
          this.jdField_a_of_type_Xkf = new xkf(b(), this.jdField_a_of_type_Xne.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Xko, (String)localObject1, 4444, bool2, bool1);
          this.jdField_a_of_type_Xkf.show();
          this.jdField_a_of_type_Xkf.setOnDismissListener(new xsy(this, (VideoViewVideoHolder)localObject2));
          if (!(this.jdField_a_of_type_Xix instanceof xjl)) {
            break label1261;
          }
          localObject1 = ((xjl)this.jdField_a_of_type_Xix).jdField_a_of_type_Wrs;
          if (!bool1) {
            break label1261;
          }
          l = ((wrs)localObject1).a(localStoryVideoItem.mVid);
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
          yqu.a("play_video", "input_reply", j, 0, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
          break;
        }
        if (localStoryVideoItem.mStoryType == 2)
        {
          localObject1 = localStoryVideoItem.mGroupId;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject3 != null) && (((VideoListFeedItem)localObject3).getOwner() != null) && ((((VideoListFeedItem)localObject3).getOwner() instanceof QQUserUIItem))) {
            localObject1 = ((QQUserUIItem)((VideoListFeedItem)localObject3).getOwner()).qq;
          }
        }
      case 2131369824: 
      case 2131377349: 
        for (;;)
        {
          label518:
          label537:
          label546:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((wpu)wpm.a(23)).a(localQQUserUIItem, (String)localObject1, false, true);
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
            yqu.a("play_video", "clk_reply", j, 1, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
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
                wms.a((CommentLikeFeedItem)localObject3, bool4, k, j);
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
                yqu.a("play_video", (String)localObject1, j, k, new String[] { localObject2, localObject3, String.valueOf(localStoryVideoItem.mOwnerUid), this.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString });
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
                j = yqu.a((String)localObject2, (VideoListFeedItem)localObject3);
                break label1048;
                localObject2 = "1";
                break label1063;
              }
            }
            if ((localStoryVideoItem.mHasLike == -1) || (localStoryVideoItem.mHasLike == 0))
            {
              this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846555);
              localStoryVideoItem.mHasLike = 1;
              break;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846868);
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
 * Qualified Name:     xsw
 * JD-Core Version:    0.7.0.1
 */