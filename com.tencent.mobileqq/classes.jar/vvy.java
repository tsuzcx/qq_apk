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
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Subscriber;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class vvy
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ElasticImageView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  private StoryUserBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  private vwj jdField_a_of_type_Vwj;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private TextView d;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView f;
  
  public vvy(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(@Nullable QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = bdda.b();
    if (paramQQUserUIItem == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      return;
    }
    if ((paramQQUserUIItem.isVipButNoFriend()) || (paramQQUserUIItem.isNotDovUser())) {
      xod.b(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setUnionID(paramQQUserUIItem.getUnionId(), 2);
      if (!((usd)urr.a(2)).a(paramQQUserUIItem.qq)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setOnClickListener(null);
      return;
      if (!TextUtils.isEmpty(paramQQUserUIItem.qq))
      {
        localObject = bcxb.a(vhj.a(), 1, paramQQUserUIItem.qq, 3, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      else if (ndd.a(paramQQUserUIItem.headUrl))
      {
        xod.b(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    boolean bool2 = false;
    long l2 = paramStoryVideoItem.mCreateTime;
    long l1;
    if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
      l1 = paramStoryVideoItem.mTimeZoneOffsetMillis;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
        bool2 = true;
      }
      paramStoryVideoItem = wnc.a(l2, l1, bool1, true, bool2);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramStoryVideoItem);
      return;
      l1 = TimeZone.getDefault().getRawOffset();
    }
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()) && (!paramQQUserUIItem.isMe()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_e_of_type_Boolean) {
        wta.a("play_video", "exp_bigv", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull VideoListFeedItem paramVideoListFeedItem)
  {
    Object localObject = ((usd)urr.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
        ((StringBuilder)localObject).append("赞").append(xod.a(paramVideoListFeedItem.mLikeCount));
      }
      if (((paramStoryVideoItem.mStoryType != 1) || (i != 0) || (j == 0)) && (paramVideoListFeedItem.mViewTotalTime > 0L))
      {
        if (paramVideoListFeedItem.mLikeCount > 0) {
          ((StringBuilder)localObject).append(" • ");
        }
        ((StringBuilder)localObject).append("浏览").append(xod.a(paramVideoListFeedItem.mViewTotalTime));
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.d.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.d.setText(((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.d.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label263:
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "storyVideoItem ownerUid is null.");
      }
      return;
    }
    ume.a(b(), 9, paramStoryVideoItem.mOwnerUid);
    if (paramBoolean)
    {
      QQUserUIItem localQQUserUIItem = ((usd)urr.a(2)).b(paramStoryVideoItem.mOwnerUid);
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
        wta.a("play_video", "clk_head", 0, 0, new String[] { str2, str1, "", paramStoryVideoItem.mVid });
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
    wta.a("play_video", "clk_name", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void a(String paramString)
  {
    if (upg.a().a(paramString))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.setOnClickListener(null);
  }
  
  private void a(@Nullable String paramString, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramQQUserUIItem == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(vhj.jdField_b_of_type_JavaLangString);
        return;
      }
      urz localurz = (urz)urr.a(23);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localurz.a(paramQQUserUIItem, paramString, false, true));
      return;
    }
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(vhj.jdField_b_of_type_JavaLangString);
      return;
    }
    if (paramQQUserUIItem.isVipButNoFriend())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQUserUIItem.nickName);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQUserUIItem.getDisplayName());
  }
  
  private void b(QQUserUIItem paramQQUserUIItem)
  {
    Object localObject;
    String str;
    long l1;
    if ((paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()))
    {
      this.jdField_a_of_type_Vwj.jdField_a_of_type_JavaLangString = paramQQUserUIItem.getUnionId();
      ((uhk)vhj.a().a(98)).a(1, paramQQUserUIItem.uid, 0, 1);
      if (this.jdField_a_of_type_Vpk == null) {
        break label185;
      }
      localObject = this.jdField_a_of_type_Vpk.a();
      str = "";
      if (localObject != null) {
        str = ((StoryVideoItem)localObject).mVid;
      }
      long l2 = 0L;
      l1 = l2;
      if ((this.jdField_a_of_type_Vld instanceof vlr))
      {
        localObject = ((vlr)this.jdField_a_of_type_Vld).jdField_a_of_type_Utx;
        l1 = l2;
        if (uuq.a(QQStoryContext.a()).a(((vlr)this.jdField_a_of_type_Vld).a())) {
          l1 = ((utx)localObject).a(str);
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
      wta.a("play_video", "follow_bigv", i, (int)l1, new String[] { "1", "", "", str });
      return;
      localObject = null;
      break;
    }
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    if (localVideoViewVideoHolder == null) {
      return;
    }
    localVideoViewVideoHolder.c(true);
    vig localvig = new vig(b(), paramStoryVideoItem.mVid, paramStoryVideoItem.mBanType, paramStoryVideoItem.mVideoSpreadGroupList, false);
    localvig.setCanceledOnTouchOutside(true);
    localvig.setCancelable(true);
    localvig.setOnDismissListener(new vvz(this, localVideoViewVideoHolder));
    localvig.show();
    wta.a("pub_control", "clk_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void b(vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mOwnerUid;
    QQUserUIItem localQQUserUIItem = ((usd)urr.a(2)).c((String)localObject);
    localObject = null;
    if (paramStoryVideoItem.mStoryType == 2)
    {
      String str = paramStoryVideoItem.mGroupId;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramvpk = paramvpk.a();
        localObject = str;
        if (paramvpk != null)
        {
          localObject = str;
          if (paramvpk.getOwner() != null)
          {
            localObject = str;
            if ((paramvpk.getOwner() instanceof QQUserUIItem)) {
              localObject = ((QQUserUIItem)paramvpk.getOwner()).qq;
            }
          }
        }
      }
    }
    a(localQQUserUIItem);
    a((String)localObject, localQQUserUIItem);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramStoryVideoItem, bool);
      a(paramStoryVideoItem);
      a(paramStoryVideoItem, localQQUserUIItem);
      return;
    }
  }
  
  private void c(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = (StoryPlayerGroupHolder)a();
    Dialog localDialog = xqr.a(b(), paramStoryVideoItem.mOwnerUid, "4", paramStoryVideoItem.mVid, 3, paramStoryVideoItem.mWsSchema);
    localObject = ((StoryPlayerGroupHolder)localObject).a();
    if (localDialog != null)
    {
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).c(true);
      }
      localDialog.setOnDismissListener(new vwa(this, (VideoViewVideoHolder)localObject));
    }
    if (xoo.a(b())) {}
    for (int i = 2;; i = 1)
    {
      wta.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramStoryVideoItem.mOwnerUid, "weishi", paramStoryVideoItem.mVid });
      return;
    }
  }
  
  private void c(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramvpk = paramvpk.a();
    if (paramvpk == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(paramStoryVideoItem, paramvpk);
    a(paramvpk.feedId);
  }
  
  private void d(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ((usd)urr.a(2)).c(paramStoryVideoItem.mOwnerUid);
    if (!b(paramvpk, paramStoryVideoItem))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void e(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramvpk = paramStoryVideoItem.getVideoLinkInfo();
    if ((paramvpk != null) && (paramvpk.a()) && (paramvpk.a.a()) && (!TextUtils.isEmpty(paramvpk.a.d)))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramStoryVideoItem = paramvpk.a.d;
      paramvpk = paramStoryVideoItem;
      if (baiy.a(paramStoryVideoItem)) {
        paramvpk = ayvy.b(paramStoryVideoItem);
      }
      paramvpk = new baiq(paramvpk, 3, 16);
      this.f.setText(paramvpk);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public String a()
  {
    return "DetailVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368371));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377374));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366765));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373787));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView = ((StoryUserBadgeView)paramView.findViewById(2131373794));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373788));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377171));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373793));
    this.d = ((TextView)paramView.findViewById(2131368370));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362829));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramView.findViewById(2131373791));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377036));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379823));
    this.f = ((TextView)paramView.findViewById(2131366773));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Vwj = new vwj(this, null);
    a(this.jdField_a_of_type_Vwj);
    paramMap.put(new vwi(this), "");
    paramMap.put(new vwf(this), "");
    paramMap.put(new vwe(this), "");
    paramMap.put(new vwg(this), "");
    paramMap.put(new vwh(this), "");
  }
  
  public void a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramvpk.jdField_a_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = paramvpk.jdField_a_of_type_JavaLangString;
    }
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      b(paramvpk, paramStoryVideoItem);
      c(paramvpk, paramStoryVideoItem);
      d(paramvpk, paramStoryVideoItem);
      e(paramvpk, paramStoryVideoItem);
      return;
      this.jdField_c_of_type_JavaLangString = "";
    }
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if ((paramStoryVideoItem.isMine()) || (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid)))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramStoryVideoItem.mBanType == 0) {
        if (paramBoolean) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846380);
        }
      }
      for (;;)
      {
        if (this.jdField_e_of_type_Boolean) {
          wta.a("pub_control", "exp_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
        }
        return true;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846376);
        continue;
        if (paramStoryVideoItem.mBanType == 1) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846378);
        } else if ((paramStoryVideoItem.mBanType == 2) || (paramStoryVideoItem.mBanType == 3)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846382);
        } else {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846380);
        }
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return false;
  }
  
  public boolean a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideVideoDetailInfo) && ((paramvpk.jdField_a_of_type_Utx == null) || (paramvpk.jdField_a_of_type_Utx.jdField_a_of_type_Int != 13));
  }
  
  public int b()
  {
    return 2131561618;
  }
  
  public boolean b(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mTagInfoBase;
    if ((!TextUtils.isEmpty(paramStoryVideoItem.originalAuthorUnionId)) && (!TextUtils.isEmpty(paramStoryVideoItem.originalAuthorName)))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130846149, 0, 0, 0);
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(xod.a(b(), 2.0F));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramStoryVideoItem.originalAuthorName);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramStoryVideoItem.originalAuthorUnionId);
      if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label249;
      }
      if (this.jdField_e_of_type_Boolean) {
        if (localObject != null) {
          break label238;
        }
      }
    }
    label238:
    for (localObject = "";; localObject = String.valueOf(((xjw)localObject).jdField_a_of_type_Long))
    {
      wta.a("play_video", "exp_tag_play", 0, 0, new String[] { "", localObject, paramvpk.jdField_b_of_type_JavaLangString, paramStoryVideoItem.mVid });
      return true;
      if ((localObject != null) && (!TextUtils.isEmpty(((xjw)localObject).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130846358, 0, 0, 0);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(xod.a(b(), 2.0F));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((xjw)localObject).jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setTag(null);
        break;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setTag(null);
      break;
    }
    label249:
    return false;
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Vwj != null) {
      b(this.jdField_a_of_type_Vwj);
    }
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Vpk != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Vpk.a();
      if (localStoryVideoItem != null) {
        break label38;
      }
      wsv.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found");
    }
    label38:
    Object localObject2;
    Object localObject1;
    VideoListFeedItem localVideoListFeedItem;
    int i;
    label95:
    boolean bool;
    label235:
    label242:
    label251:
    do
    {
      return;
      localStoryVideoItem = null;
      break;
      localObject2 = ((StoryPlayerGroupHolder)a()).a();
      localObject1 = (usd)urr.a(2);
      localVideoListFeedItem = this.jdField_a_of_type_Vpk.a();
      localObject1 = ((usd)localObject1).b(localStoryVideoItem.mOwnerUid);
      if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
      {
        i = 1;
        bool = vhj.a(localStoryVideoItem);
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131368371: 
        i = upg.a().a(this.jdField_a_of_type_Vpk.jdField_b_of_type_JavaLangString);
        if (i != -1)
        {
          StoryDetailActivity.a(b(), this.jdField_a_of_type_Vpk.jdField_b_of_type_JavaLangString, vhj.a(c()), i, c(), 0);
          if (localObject1 != null) {
            break label549;
          }
          i = 4;
          if (!bool) {
            break label558;
          }
          paramView = "2";
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.getVisibility() != 0) {
            break label565;
          }
        }
      case 2131373787: 
      case 2131373788: 
      case 2131373793: 
      case 2131377171: 
      case 2131379823: 
      case 2131377036: 
      case 2131380142: 
        for (localObject1 = "2";; localObject1 = "1")
        {
          wta.a("play_video", "clk_list", i, 0, new String[] { paramView, localObject1, "", localStoryVideoItem.mVid });
          return;
          i = 0;
          break label95;
          a(localStoryVideoItem, true);
          return;
          a(localStoryVideoItem, false);
          return;
          if (localObject1 == null) {
            break;
          }
          b((QQUserUIItem)localObject1);
          return;
          b(localStoryVideoItem);
          return;
          if (paramView.getTag() != null)
          {
            paramView = (String)paramView.getTag();
            wsv.d(this.jdField_b_of_type_JavaLangString, "startStoryProfileActivity by original author name, video-item-unionId=%s, tag-unionId=%s", new Object[] { localStoryVideoItem.originalAuthorUnionId, paramView });
            ume.a(b(), 9, paramView);
            return;
          }
          via.a(b(), localStoryVideoItem.mTagInfoBase);
          localObject1 = "1";
          paramView = "";
          if (localStoryVideoItem.mTagInfoBase != null) {
            if (localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Int != 0) {
              break label499;
            }
          }
          for (paramView = "1";; paramView = "2")
          {
            long l = localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Long;
            localObject2 = String.valueOf(l);
            localObject1 = paramView;
            paramView = (View)localObject2;
            wta.a("play_video", "clk_tag", 0, 0, new String[] { "", localObject1, paramView, localStoryVideoItem.mVid });
            return;
          }
          c(localStoryVideoItem);
          return;
          StoryDetailActivity.a(b(), this.jdField_a_of_type_Vpk.jdField_b_of_type_JavaLangString, vhj.a(c()), false, this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString, c());
          break label235;
          i = wta.a((usv)localObject1);
          break label242;
          paramView = "1";
          break label251;
        }
      }
      paramView = (bhpy)bhql.b(b(), null);
      paramView.a(alpo.a(2131703539), 5);
      paramView.c(2131690648);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      paramView.a(new vwb(this, localStoryVideoItem, (VideoViewVideoHolder)localObject2, localAtomicBoolean, paramView));
      paramView.a(new vwd(this, localAtomicBoolean, (VideoViewVideoHolder)localObject2));
    } while (paramView.isShowing());
    label499:
    paramView.show();
    label549:
    label558:
    label565:
    if (localObject2 != null) {
      ((VideoViewVideoHolder)localObject2).c(true);
    }
    int j;
    if (i != 0)
    {
      i = 1;
      j = wta.a(localVideoListFeedItem);
      if (!bool) {
        break label734;
      }
    }
    label734:
    for (paramView = "2";; paramView = "1")
    {
      wta.a("play_video", "clk_more_play", i, j, new String[] { paramView, String.valueOf(wta.a((usv)localObject1)), localStoryVideoItem.mVid });
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvy
 * JD-Core Version:    0.7.0.1
 */