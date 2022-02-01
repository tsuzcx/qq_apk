import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class wyy
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ElasticImageView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  private StoryUserBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  private wzj jdField_a_of_type_Wzj;
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
  
  public wyy(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(@Nullable QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = bfvo.b();
    if (paramQQUserUIItem == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      return;
    }
    if ((paramQQUserUIItem.isVipButNoFriend()) || (paramQQUserUIItem.isNotDovUser())) {
      UIUtils.setCircleViewByURL(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setUnionID(paramQQUserUIItem.getUnionId(), 2);
      if (!((vvj)vux.a(2)).a(paramQQUserUIItem.qq)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setOnClickListener(null);
      return;
      if (!android.text.TextUtils.isEmpty(paramQQUserUIItem.qq))
      {
        localObject = FaceDrawable.getFaceDrawable(wkp.a(), 1, paramQQUserUIItem.qq, 3, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      else if (HttpUtil.isValidUrl(paramQQUserUIItem.headUrl))
      {
        UIUtils.setCircleViewByURL(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
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
      paramStoryVideoItem = xqc.a(l2, l1, bool1, true, bool2);
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
        xwa.a("play_video", "exp_bigv", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull VideoListFeedItem paramVideoListFeedItem)
  {
    Object localObject = ((vvj)vux.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
        ((StringBuilder)localObject).append("赞").append(UIUtils.formatCount(paramVideoListFeedItem.mLikeCount));
      }
      if (((paramStoryVideoItem.mStoryType != 1) || (i != 0) || (j == 0)) && (paramVideoListFeedItem.mViewTotalTime > 0L))
      {
        if (paramVideoListFeedItem.mLikeCount > 0) {
          ((StringBuilder)localObject).append(" • ");
        }
        ((StringBuilder)localObject).append("浏览").append(UIUtils.formatCount(paramVideoListFeedItem.mViewTotalTime));
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
    if (android.text.TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "storyVideoItem ownerUid is null.");
      }
      return;
    }
    vpl.a(b(), 9, paramStoryVideoItem.mOwnerUid);
    if (paramBoolean)
    {
      QQUserUIItem localQQUserUIItem = ((vvj)vux.a(2)).b(paramStoryVideoItem.mOwnerUid);
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
        xwa.a("play_video", "clk_head", 0, 0, new String[] { str2, str1, "", paramStoryVideoItem.mVid });
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
    xwa.a("play_video", "clk_name", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void a(String paramString)
  {
    if (vsn.a().a(paramString))
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
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramQQUserUIItem == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(wkp.jdField_b_of_type_JavaLangString);
        return;
      }
      vvf localvvf = (vvf)vux.a(23);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localvvf.a(paramQQUserUIItem, paramString, false, true));
      return;
    }
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(wkp.jdField_b_of_type_JavaLangString);
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
      this.jdField_a_of_type_Wzj.jdField_a_of_type_JavaLangString = paramQQUserUIItem.getUnionId();
      ((vkz)wkp.a().getBusinessHandler(98)).a(1, paramQQUserUIItem.uid, 0, 1);
      if (this.jdField_a_of_type_Wsk == null) {
        break label185;
      }
      localObject = this.jdField_a_of_type_Wsk.a();
      str = "";
      if (localObject != null) {
        str = ((StoryVideoItem)localObject).mVid;
      }
      long l2 = 0L;
      l1 = l2;
      if ((this.jdField_a_of_type_Wod instanceof wor))
      {
        localObject = ((wor)this.jdField_a_of_type_Wod).jdField_a_of_type_Vxd;
        l1 = l2;
        if (vxw.a(QQStoryContext.a()).a(((wor)this.jdField_a_of_type_Wod).a())) {
          l1 = ((vxd)localObject).a(str);
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
      xwa.a("play_video", "follow_bigv", i, (int)l1, new String[] { "1", "", "", str });
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
    wlh localwlh = new wlh(b(), paramStoryVideoItem.mVid, paramStoryVideoItem.mBanType, paramStoryVideoItem.mVideoSpreadGroupList, false);
    localwlh.setCanceledOnTouchOutside(true);
    localwlh.setCancelable(true);
    localwlh.setOnDismissListener(new wyz(this, localVideoViewVideoHolder));
    localwlh.show();
    xwa.a("pub_control", "clk_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void b(wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mOwnerUid;
    QQUserUIItem localQQUserUIItem = ((vvj)vux.a(2)).c((String)localObject);
    localObject = null;
    if (paramStoryVideoItem.mStoryType == 2)
    {
      String str = paramStoryVideoItem.mGroupId;
      localObject = str;
      if (android.text.TextUtils.isEmpty(str))
      {
        paramwsk = paramwsk.a();
        localObject = str;
        if (paramwsk != null)
        {
          localObject = str;
          if (paramwsk.getOwner() != null)
          {
            localObject = str;
            if ((paramwsk.getOwner() instanceof QQUserUIItem)) {
              localObject = ((QQUserUIItem)paramwsk.getOwner()).qq;
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
    Dialog localDialog = yrr.a(b(), paramStoryVideoItem.mOwnerUid, "4", paramStoryVideoItem.mVid, 3, paramStoryVideoItem.mWsSchema);
    localObject = ((StoryPlayerGroupHolder)localObject).a();
    if (localDialog != null)
    {
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).c(true);
      }
      localDialog.setOnDismissListener(new wza(this, (VideoViewVideoHolder)localObject));
    }
    if (yqu.a(b())) {}
    for (int i = 2;; i = 1)
    {
      xwa.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramStoryVideoItem.mOwnerUid, "weishi", paramStoryVideoItem.mVid });
      return;
    }
  }
  
  private void c(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramwsk = paramwsk.a();
    if (paramwsk == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(paramStoryVideoItem, paramwsk);
    a(paramwsk.feedId);
  }
  
  private void d(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ((vvj)vux.a(2)).c(paramStoryVideoItem.mOwnerUid);
    if (!b(paramwsk, paramStoryVideoItem))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void e(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramwsk = paramStoryVideoItem.getVideoLinkInfo();
    if ((paramwsk != null) && (paramwsk.a()) && (paramwsk.a.a()) && (!android.text.TextUtils.isEmpty(paramwsk.a.d)))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramStoryVideoItem = paramwsk.a.d;
      paramwsk = paramStoryVideoItem;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramStoryVideoItem)) {
        paramwsk = bblk.b(paramStoryVideoItem);
      }
      paramwsk = new QQTextBuilder(paramwsk, 3, 16);
      this.f.setText(paramwsk);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368788));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378181));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367110));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374445));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView = ((StoryUserBadgeView)paramView.findViewById(2131374452));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374446));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377961));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374451));
    this.d = ((TextView)paramView.findViewById(2131368787));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362974));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramView.findViewById(2131374449));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377816));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380743));
    this.f = ((TextView)paramView.findViewById(2131367118));
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
    this.jdField_a_of_type_Wzj = new wzj(this, null);
    a(this.jdField_a_of_type_Wzj);
    paramMap.put(new wzi(this), "");
    paramMap.put(new wzf(this), "");
    paramMap.put(new wze(this), "");
    paramMap.put(new wzg(this), "");
    paramMap.put(new wzh(this), "");
  }
  
  public void a(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!android.text.TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramwsk.jdField_a_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = paramwsk.jdField_a_of_type_JavaLangString;
    }
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      b(paramwsk, paramStoryVideoItem);
      c(paramwsk, paramStoryVideoItem);
      d(paramwsk, paramStoryVideoItem);
      e(paramwsk, paramStoryVideoItem);
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
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846816);
        }
      }
      for (;;)
      {
        if (this.jdField_e_of_type_Boolean) {
          xwa.a("pub_control", "exp_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
        }
        return true;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846812);
        continue;
        if (paramStoryVideoItem.mBanType == 1) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846814);
        } else if ((paramStoryVideoItem.mBanType == 2) || (paramStoryVideoItem.mBanType == 3)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846818);
        } else {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846816);
        }
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return false;
  }
  
  public boolean a(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideVideoDetailInfo) && ((paramwsk.jdField_a_of_type_Vxd == null) || (paramwsk.jdField_a_of_type_Vxd.jdField_a_of_type_Int != 13));
  }
  
  public int b()
  {
    return 2131561788;
  }
  
  public boolean b(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mTagInfoBase;
    if ((!android.text.TextUtils.isEmpty(paramStoryVideoItem.originalAuthorUnionId)) && (!android.text.TextUtils.isEmpty(paramStoryVideoItem.originalAuthorName)))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130846586, 0, 0, 0);
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.dip2px(b(), 2.0F));
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
    for (localObject = "";; localObject = String.valueOf(((yml)localObject).jdField_a_of_type_Long))
    {
      xwa.a("play_video", "exp_tag_play", 0, 0, new String[] { "", localObject, paramwsk.jdField_b_of_type_JavaLangString, paramStoryVideoItem.mVid });
      return true;
      if ((localObject != null) && (!android.text.TextUtils.isEmpty(((yml)localObject).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130846794, 0, 0, 0);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.dip2px(b(), 2.0F));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((yml)localObject).jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Wzj != null) {
      b(this.jdField_a_of_type_Wzj);
    }
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Wsk != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
      if (localStoryVideoItem != null) {
        break label45;
      }
      xvv.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found");
    }
    label45:
    Object localObject2;
    Object localObject3;
    int i;
    label102:
    boolean bool;
    label245:
    label252:
    bjnw localbjnw;
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
        localObject2 = (vvj)vux.a(2);
        localObject3 = this.jdField_a_of_type_Wsk.a();
        localObject2 = ((vvj)localObject2).b(localStoryVideoItem.mOwnerUid);
        if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isVip)) {
          break label317;
        }
        i = 1;
        bool = wkp.a(localStoryVideoItem);
        switch (paramView.getId())
        {
        }
      }
      i = vsn.a().a(this.jdField_a_of_type_Wsk.jdField_b_of_type_JavaLangString);
      if (i != -1)
      {
        StoryDetailActivity.a(b(), this.jdField_a_of_type_Wsk.jdField_b_of_type_JavaLangString, wkp.a(c()), i, c(), 0);
        if (localObject2 != null) {
          break label586;
        }
        i = 4;
        if (!bool) {
          break label595;
        }
        localObject1 = "2";
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.getVisibility() != 0) {
          break label603;
        }
      }
      for (localObject2 = "2";; localObject2 = "1")
      {
        xwa.a("play_video", "clk_list", i, 0, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
        break;
        i = 0;
        break label102;
        a(localStoryVideoItem, true);
        break;
        a(localStoryVideoItem, false);
        break;
        if (localObject2 == null) {
          break;
        }
        b((QQUserUIItem)localObject2);
        break;
        b(localStoryVideoItem);
        break;
        if (paramView.getTag() != null)
        {
          localObject1 = (String)paramView.getTag();
          xvv.d(this.jdField_b_of_type_JavaLangString, "startStoryProfileActivity by original author name, video-item-unionId=%s, tag-unionId=%s", new Object[] { localStoryVideoItem.originalAuthorUnionId, localObject1 });
          vpl.a(b(), 9, (String)localObject1);
          break;
        }
        wlg.a(b(), localStoryVideoItem.mTagInfoBase);
        localObject2 = "1";
        localObject1 = "";
        if (localStoryVideoItem.mTagInfoBase != null) {
          if (localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Int != 0) {
            break label533;
          }
        }
        for (localObject1 = "1";; localObject1 = "2")
        {
          long l = localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Long;
          localObject3 = String.valueOf(l);
          localObject2 = localObject1;
          localObject1 = localObject3;
          xwa.a("play_video", "clk_tag", 0, 0, new String[] { "", localObject2, localObject1, localStoryVideoItem.mVid });
          break;
        }
        c(localStoryVideoItem);
        break;
        StoryDetailActivity.a(b(), this.jdField_a_of_type_Wsk.jdField_b_of_type_JavaLangString, wkp.a(c()), false, this.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString, c());
        break label245;
        i = xwa.a((vwb)localObject2);
        break label252;
        localObject1 = "1";
        break label262;
      }
      localbjnw = (bjnw)bjon.b(b(), null);
      localbjnw.a(amtj.a(2131702290), 5);
      localbjnw.c(2131690620);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localbjnw.a(new wzb(this, localStoryVideoItem, (VideoViewVideoHolder)localObject1, localAtomicBoolean, localbjnw));
      localbjnw.a(new wzd(this, localAtomicBoolean, (VideoViewVideoHolder)localObject1));
    } while (localbjnw.isShowing());
    label533:
    localbjnw.show();
    if (localObject1 != null) {
      ((VideoViewVideoHolder)localObject1).c(true);
    }
    label722:
    int j;
    if (i != 0)
    {
      i = 1;
      j = xwa.a((FeedItem)localObject3);
      if (!bool) {
        break label784;
      }
    }
    label784:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      xwa.a("play_video", "clk_more_play", i, j, new String[] { localObject1, String.valueOf(xwa.a((vwb)localObject2)), localStoryVideoItem.mVid });
      break;
      i = 2;
      break label722;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyy
 * JD-Core Version:    0.7.0.1
 */