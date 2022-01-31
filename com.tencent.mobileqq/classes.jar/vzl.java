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
import com.tribe.async.dispatch.Subscriber;
import java.io.File;
import java.util.Map;

public class vzl
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private unz jdField_a_of_type_Unz = new unz();
  private final uvm jdField_a_of_type_Uvm = (uvm)uwa.a(15);
  protected vic a;
  private vqu jdField_a_of_type_Vqu;
  private vrd jdField_a_of_type_Vrd;
  private vzz jdField_a_of_type_Vzz;
  private waa jdField_a_of_type_Waa;
  private final woy jdField_a_of_type_Woy = (woy)uwa.a(11);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private View d;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View f;
  
  public vzl(ViewGroup paramViewGroup)
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
    bnfr.a(paramActivity, paramString6, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, 118, 10002, 0, null, null, false, 3);
  }
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846116);
    }
    while (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(xsm.a(paramVideoListFeedItem.mLikeCount));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846430);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131701564));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner localMediaScanner = MediaScanner.getInstance(b().getApplicationContext());
    System.currentTimeMillis();
    localMediaScanner.queryMediaInfoAsync(new vzr(this, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1, localLocalMediaInfo), localLocalMediaInfo);
  }
  
  private void b(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mCommentCount > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(xsm.a(paramVideoListFeedItem.mCommentCount));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131701567));
  }
  
  private int d()
  {
    return (int)Math.min(azkz.b - azkz.a / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Vtt == null) {
      return;
    }
    uvt localuvt = (uvt)uwa.a(10);
    if (((Boolean)localuvt.b("first_clk_forward", Boolean.valueOf(true))).booleanValue())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      bdjz localbdjz = bdgm.a(b(), 230);
      localbdjz.setTitle(alud.a(2131701565)).setMessage(alud.a(2131701558)).setPositiveButton(alud.a(2131701566), new vzp(this)).setOnDismissListener(new vzo(this, localVideoViewVideoHolder));
      localbdjz.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      localuvt.b("first_clk_forward", Boolean.valueOf(false));
      wxj.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    for (;;)
    {
      wxj.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString });
      return;
      e();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Vtt == null) {
      return;
    }
    Object localObject2 = (uwm)uwa.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Vtt.a();
    if (localStoryVideoItem == null)
    {
      wxe.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Vtt.a();
    localObject2 = ((uwm)localObject2).b(localStoryVideoItem.mOwnerUid);
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
      wxj.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
      return;
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
      break;
      label171:
      a(b().getString(2131721300), true);
      this.jdField_a_of_type_Unz.a(localStoryVideoItem.mVid, 0, true, new vzq(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
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
    new vzm(this);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380295);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380296);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131369430);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131369436));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369434));
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131364511);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364544));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131364557));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.f = paramView.findViewById(2131376558);
    this.f.setOnClickListener(this);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new vzw(this), "");
    paramMap.put(new vzu(this), "");
    paramMap.put(new vzv(this), "");
    paramMap.put(new vzx(this), "");
    paramMap.put(new vzt(this), "");
    paramMap.put(new vzy(this), "");
    this.jdField_a_of_type_Vzz = new vzz(this);
    a(this.jdField_a_of_type_Vzz);
  }
  
  public void a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    wxe.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramvtt);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_Woy.a(paramvtt.jdField_b_of_type_JavaLangString, true);
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
        wxe.d((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramvtt.jdField_b_of_type_JavaLangString });
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
    if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramvtt.jdField_a_of_type_JavaLangString))
    {
      this.jdField_e_of_type_Boolean = false;
      localObject = ((uwm)uwa.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
          wxe.d(this.jdField_b_of_type_JavaLangString, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(a().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5)) {
            break label687;
          }
          i = 1;
          wxe.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget");
          if (i == 0) {
            break label780;
          }
          j();
          if (alsf.a() <= 16.0F) {
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
      wxj.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramvtt.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = paramvtt.jdField_a_of_type_JavaLangString;
      break label135;
      i = 1;
      wxe.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      break label435;
      i = 0;
      wxe.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
        wxe.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because friend and showBottomWidgetFlag=3");
        break label435;
      }
      i = 0;
      wxe.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget");
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
  
  public boolean a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramvtt.jdField_a_of_type_Uyg == null) || (paramvtt.jdField_a_of_type_Uyg.a != 13);
  }
  
  public int b()
  {
    return 2131561518;
  }
  
  public boolean d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Vtt == null) {}
    label72:
    label345:
    label348:
    label352:
    for (;;)
    {
      return false;
      Object localObject = (uwm)uwa.a(2);
      vtt localvtt = this.jdField_a_of_type_Vtt;
      StoryVideoItem localStoryVideoItem = localvtt.a();
      VideoListFeedItem localVideoListFeedItem = localvtt.a();
      int i;
      boolean bool;
      if (localStoryVideoItem != null)
      {
        localObject = ((uwm)localObject).b(localStoryVideoItem.mOwnerUid);
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label309;
        }
        i = 1;
        if (((localObject != null) && (((QQUserUIItem)localObject).isMe())) && ((this.jdField_a_of_type_Vpm == null) || (!(this.jdField_a_of_type_Vpm instanceof vqa)))) {
          break label348;
        }
        localObject = ((vqa)this.jdField_a_of_type_Vpm).jdField_a_of_type_Uyg;
        bool = uyz.a(QQStoryContext.a()).a(((vqa)this.jdField_a_of_type_Vpm).a());
        if ((!bool) || (localObject == null)) {
          break label345;
        }
        if (localStoryVideoItem == null) {
          break label314;
        }
        l = ((uyg)localObject).a(localStoryVideoItem.mVid);
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
          for (localObject = String.valueOf(l);; localObject = String.valueOf(wxj.a((String)localObject, localVideoListFeedItem)))
          {
            wxj.a("play_video", "dbl_like", i, j, new String[] { "", localObject, "", localvtt.jdField_a_of_type_JavaLangString });
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
    if (this.jdField_a_of_type_Unz != null) {
      this.jdField_a_of_type_Unz.a();
    }
    if (this.jdField_a_of_type_Vrd != null) {
      this.jdField_a_of_type_Vrd.a();
    }
    if (this.jdField_a_of_type_Vzz != null) {
      b(this.jdField_a_of_type_Vzz);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Vtt == null) {
      return;
    }
    Object localObject1 = (uwm)uwa.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Vtt.a();
    if (localStoryVideoItem == null)
    {
      wxe.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Vtt.a();
    QQUserUIItem localQQUserUIItem = ((uwm)localObject1).b(localStoryVideoItem.mOwnerUid);
    int i;
    boolean bool5;
    boolean bool2;
    long l;
    boolean bool1;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      i = 1;
      bool5 = vls.a(localStoryVideoItem);
      bool2 = false;
      l = 0L;
      if (!(this.jdField_a_of_type_Vpm instanceof vqa)) {
        break label1221;
      }
      localObject1 = ((vqa)this.jdField_a_of_type_Vpm).jdField_a_of_type_Uyg;
      bool1 = uyz.a(QQStoryContext.a()).a(((vqa)this.jdField_a_of_type_Vpm).a());
      if (!bool1) {
        break label1218;
      }
      l = ((uyg)localObject1).a(localStoryVideoItem.mVid);
    }
    for (;;)
    {
      label265:
      label338:
      label499:
      int j;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364511: 
      case 2131380295: 
      case 2131380296: 
        for (;;)
        {
          if ((localObject2 == null) || (((VideoListFeedItem)localObject2).mDenyComment != 1)) {
            break label265;
          }
          QQToast.a(vls.a(), 1, alud.a(2131701562), 0).a();
          return;
          i = 0;
          break;
          bool2 = true;
        }
        localObject1 = ((StoryPlayerGroupHolder)a()).a();
        if (localObject1 != null) {
          ((VideoViewVideoHolder)localObject1).c(true);
        }
        if (this.jdField_a_of_type_Vrd == null) {
          this.jdField_a_of_type_Vrd = new vrd();
        }
        paramView = alud.a(2131701563);
        if ((localObject2 != null) && (((VideoListFeedItem)localObject2).type == 2)) {
          paramView = ((VideoListFeedItem)localObject2).getOwner().getName();
        }
        label517:
        label526:
        while (localQQUserUIItem == null)
        {
          bool1 = false;
          localObject2 = a();
          if ((((OpenPlayerBuilder.Data)localObject2).mInfo instanceof MsgTabPlayInfo)) {
            bool1 = uyz.a(QQStoryContext.a()).a(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject2).mInfo).nodeUnionId);
          }
          paramView = paramView + alud.a(2131701560);
          this.jdField_a_of_type_Vqu = new vqu(b(), this.jdField_a_of_type_Vtt.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Vrd, paramView, 4444, bool2, bool1);
          this.jdField_a_of_type_Vqu.show();
          this.jdField_a_of_type_Vqu.setOnDismissListener(new vzn(this, (VideoViewVideoHolder)localObject1));
          if (!(this.jdField_a_of_type_Vpm instanceof vqa)) {
            break label1204;
          }
          paramView = ((vqa)this.jdField_a_of_type_Vpm).jdField_a_of_type_Uyg;
          if (!bool1) {
            break label1204;
          }
          l = paramView.a(localStoryVideoItem.mVid);
          if (!bool2) {
            break label695;
          }
          j = (int)l;
          if (!bool5) {
            break;
          }
          paramView = "2";
          if (i == 0) {
            break label687;
          }
          localObject1 = "2";
          wxj.a("play_video", "input_reply", j, 0, new String[] { paramView, localObject1, "", localStoryVideoItem.mVid });
          return;
        }
        if (localStoryVideoItem.mStoryType == 2)
        {
          paramView = localStoryVideoItem.mGroupId;
          if ((TextUtils.isEmpty(paramView)) && (localObject2 != null) && (((VideoListFeedItem)localObject2).getOwner() != null) && ((((VideoListFeedItem)localObject2).getOwner() instanceof QQUserUIItem))) {
            paramView = ((QQUserUIItem)((VideoListFeedItem)localObject2).getOwner()).qq;
          }
        }
        break;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramView))
        {
          paramView = ((uwi)uwa.a(23)).a(localQQUserUIItem, paramView, false, true);
          break label338;
        }
        if (localQQUserUIItem.isVipButNoFriend())
        {
          paramView = localQQUserUIItem.nickName;
          break label338;
        }
        paramView = localQQUserUIItem.getDisplayName();
        break label338;
        paramView = "1";
        break label517;
        label687:
        localObject1 = "1";
        break label526;
        label695:
        j = (int)l;
        if (bool5)
        {
          paramView = "2";
          if (i == 0) {
            break label762;
          }
        }
        label762:
        for (localObject1 = "2";; localObject1 = "1")
        {
          wxj.a("play_video", "clk_reply", j, 1, new String[] { paramView, localObject1, "", localStoryVideoItem.mVid });
          return;
          paramView = "1";
          break;
        }
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
        {
          bool2 = ((Boolean)localObject1).booleanValue();
          paramView.setTag(null);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            paramView = new LikeEntry();
            paramView.likeTime = System.currentTimeMillis();
            paramView.uin = QQStoryContext.a().a();
            paramView.unionId = QQStoryContext.a().b();
            paramView.feedId = ((VideoListFeedItem)localObject2).feedId;
            boolean bool3;
            label888:
            boolean bool4;
            label896:
            int k;
            if (((VideoListFeedItem)localObject2).mHadLike == 1)
            {
              bool3 = true;
              if (!bool3) {
                break label1078;
              }
              ((VideoListFeedItem)localObject2).mHadLike = 0;
              ((VideoListFeedItem)localObject2).mLikeCount -= 1;
              if (bool3) {
                break label1099;
              }
              bool4 = true;
              k = ((VideoListFeedItem)localObject2).getCommentLikeType();
              if (c() != 106) {
                break label1105;
              }
              j = 106;
              label915:
              utg.a((CommentLikeFeedItem)localObject2, bool4, k, j);
              i();
              ThreadManager.post(new BottomVideoInfoWidget.3(this, bool3, paramView, (VideoListFeedItem)localObject2), 5, null, false);
              if (bool2) {
                break;
              }
              localObject1 = null;
              paramView = a();
              if ((paramView.mInfo instanceof MsgTabPlayInfo)) {
                localObject1 = ((MsgTabPlayInfo)paramView.mInfo).nodeUnionId;
              }
              if (!bool3) {
                break label1110;
              }
              paramView = "unlike";
              label992:
              if (!bool1) {
                break label1117;
              }
              j = (int)l;
              label1001:
              k = c();
              if (i == 0) {
                break label1128;
              }
              localObject1 = "2";
              label1016:
              if (!bool5) {
                break label1136;
              }
            }
            label1078:
            label1099:
            label1105:
            label1110:
            label1117:
            label1128:
            label1136:
            for (localObject2 = "2";; localObject2 = "1")
            {
              wxj.a("play_video", paramView, j, k, new String[] { localObject1, localObject2, String.valueOf(localStoryVideoItem.mOwnerUid), this.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString });
              return;
              bool3 = false;
              break;
              ((VideoListFeedItem)localObject2).mHadLike = 1;
              ((VideoListFeedItem)localObject2).mLikeCount += 1;
              break label888;
              bool4 = false;
              break label896;
              j = 0;
              break label915;
              paramView = "like";
              break label992;
              j = wxj.a((String)localObject1, (VideoListFeedItem)localObject2);
              break label1001;
              localObject1 = "1";
              break label1016;
            }
          }
          if ((localStoryVideoItem.mHasLike == -1) || (localStoryVideoItem.mHasLike == 0))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846116);
            localStoryVideoItem.mHasLike = 1;
            return;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846430);
          localStoryVideoItem.mHasLike = 0;
          return;
          d();
          return;
          bool2 = false;
        }
        label1204:
        l = 0L;
        break label499;
        continue;
        paramView = null;
      }
      label1218:
      continue;
      label1221:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzl
 * JD-Core Version:    0.7.0.1
 */