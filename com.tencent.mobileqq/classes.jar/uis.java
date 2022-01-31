import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class uis
  extends tpk
{
  private long jdField_a_of_type_Long;
  private final QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private final StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private final VideoViewVideoHolder jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
  private final VideoListFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  private final boolean c;
  private boolean d;
  private boolean e;
  
  public uis(uhz paramuhz, boolean paramBoolean1, VideoListFeedItem paramVideoListFeedItem, String paramString, StoryVideoItem paramStoryVideoItem, boolean paramBoolean2, VideoViewVideoHolder paramVideoViewVideoHolder, boolean paramBoolean3, QQUserUIItem paramQQUserUIItem, boolean paramBoolean4, long paramLong)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = paramVideoListFeedItem;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.b = paramBoolean2;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder = paramVideoViewVideoHolder;
    this.c = paramBoolean3;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramQQUserUIItem;
    this.e = paramBoolean4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a()
  {
    super.a();
    veg.b(this.jdField_a_of_type_Uhz.b, "OnSimpleShareListenerImpl onFinish");
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    veg.b(this.jdField_a_of_type_Uhz.b, "OnSimpleShareListenerImpl onSuccess");
    if (this.jdField_a_of_type_Boolean)
    {
      vel.a("host_share", "suc_share", 3, paramInt, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      switch (paramInt)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        label128:
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo() != null)
        {
          if (!this.b) {
            break label812;
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo().jdField_a_of_type_Int != 1) {
            break label807;
          }
          paramInt = 1;
        }
        break;
      }
    }
    for (;;)
    {
      vel.a("video_game", "share_game", 0, 0, new String[] { String.valueOf(paramInt), "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      vel.a("host_share", "suc_share", 1, paramInt, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      break;
      label275:
      String str1;
      if (this.c)
      {
        paramInt = 1;
        if (!this.b) {
          break label346;
        }
        str1 = "2";
        label285:
        if (!this.e) {
          break label352;
        }
      }
      label346:
      label352:
      for (String str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        vel.a("play_video", "guest_share_suc", paramInt, 1, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        break;
        paramInt = 2;
        break label275;
        str1 = "1";
        break label285;
      }
      if (this.c)
      {
        paramInt = 1;
        label375:
        if (!this.b) {
          break label446;
        }
        str1 = "2";
        label385:
        if (!this.e) {
          break label452;
        }
      }
      label446:
      label452:
      for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        vel.a("play_video", "guest_share_suc", paramInt, 2, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        break;
        paramInt = 2;
        break label375;
        str1 = "1";
        break label385;
      }
      if (this.c)
      {
        paramInt = 1;
        label475:
        if (!this.b) {
          break label546;
        }
        str1 = "2";
        label485:
        if (!this.e) {
          break label552;
        }
      }
      label546:
      label552:
      for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        vel.a("play_video", "guest_share_suc", paramInt, 3, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        break;
        paramInt = 2;
        break label475;
        str1 = "1";
        break label485;
      }
      if (this.c)
      {
        paramInt = 1;
        label575:
        if (!this.b) {
          break label646;
        }
        str1 = "2";
        label585:
        if (!this.e) {
          break label652;
        }
      }
      label646:
      label652:
      for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        vel.a("play_video", "guest_share_suc", paramInt, 4, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        break;
        paramInt = 2;
        break label575;
        str1 = "1";
        break label585;
      }
      if (this.c)
      {
        paramInt = 1;
        label675:
        if (!this.b) {
          break label746;
        }
        str1 = "2";
        label685:
        if (!this.e) {
          break label752;
        }
      }
      label746:
      label752:
      for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        vel.a("play_video", "guest_share_suc", paramInt, 5, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        break;
        paramInt = 2;
        break label675;
        str1 = "1";
        break label685;
      }
      vel.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      break label128;
      label807:
      paramInt = 3;
      continue;
      label812:
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo().jdField_a_of_type_Int == 1) {
        paramInt = 2;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    this.d = true;
    veg.b(this.jdField_a_of_type_Uhz.b, "OnSimpleShareListenerImpl onChooseShareChannel");
    if (this.jdField_a_of_type_Boolean) {
      vel.a("host_share", "share_chanel", 3, paramInt, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        return;
        vel.a("host_share", "share_chanel", 1, paramInt, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      }
    }
    if (this.c)
    {
      paramInt = 1;
      if (!this.b) {
        break label268;
      }
      str1 = "2";
      label207:
      if (!this.e) {
        break label274;
      }
    }
    label268:
    label274:
    for (String str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
    {
      vel.a("play_video", "guest_share", paramInt, 1, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      paramInt = 2;
      break;
      str1 = "1";
      break label207;
    }
    if (this.c)
    {
      paramInt = 1;
      if (!this.b) {
        break label369;
      }
      str1 = "2";
      label308:
      if (!this.e) {
        break label375;
      }
    }
    label369:
    label375:
    for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
    {
      vel.a("play_video", "guest_share", paramInt, 2, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      paramInt = 2;
      break;
      str1 = "1";
      break label308;
    }
    if (this.c)
    {
      paramInt = 1;
      if (!this.b) {
        break label470;
      }
      str1 = "2";
      label409:
      if (!this.e) {
        break label476;
      }
    }
    label470:
    label476:
    for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
    {
      vel.a("play_video", "guest_share", paramInt, 3, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      paramInt = 2;
      break;
      str1 = "1";
      break label409;
    }
    if (this.c)
    {
      paramInt = 1;
      if (!this.b) {
        break label571;
      }
      str1 = "2";
      label510:
      if (!this.e) {
        break label577;
      }
    }
    label571:
    label577:
    for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
    {
      vel.a("play_video", "guest_share", paramInt, 4, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      paramInt = 2;
      break;
      str1 = "1";
      break label510;
    }
    if (this.c)
    {
      paramInt = 1;
      if (!this.b) {
        break label672;
      }
      str1 = "2";
      label611:
      if (!this.e) {
        break label678;
      }
    }
    label672:
    label678:
    for (str2 = String.valueOf(this.jdField_a_of_type_Long);; str2 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
    {
      vel.a("play_video", "guest_share", paramInt, 5, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      paramInt = 2;
      break;
      str1 = "1";
      break label611;
    }
    if (tti.a().a()) {
      bcpw.a(this.jdField_a_of_type_Uhz.b(), 0, ajyc.a(2131706891), 0).a();
    }
    for (;;)
    {
      vel.a("play_video", "share_friend", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath))
      {
        bcpw.a(this.jdField_a_of_type_Uhz.b(), 1, ajyc.a(2131706886), 0).a();
        veg.e(this.jdField_a_of_type_Uhz.b, "send video to friend failed because videoLocalPath is empty.");
      }
      else
      {
        this.jdField_a_of_type_Uhz.a("", true, 300L);
        tti.a().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, String.valueOf(this.jdField_a_of_type_Uhz.hashCode()));
      }
    }
    if (tti.a().a())
    {
      bcpw.a(this.jdField_a_of_type_Uhz.b(), 0, ajyc.a(2131706890), 0).a();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath))
    {
      veg.d(this.jdField_a_of_type_Uhz.b, "save video -info local file not exist , start download , vid:%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      uhz.a(this.jdField_a_of_type_Uhz).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, false, new uit(this));
      paramInt = this.jdField_a_of_type_Uhz.c();
      str2 = this.jdField_a_of_type_Uhz.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) {
        break label1088;
      }
      str1 = "";
      label975:
      vel.a("story_grp", "clk_one", paramInt, 0, new String[] { "3", str2, "", str1 });
      if (!this.b) {
        break label1099;
      }
    }
    label1088:
    label1099:
    for (String str1 = "2";; str1 = "1")
    {
      vel.a("play_video", "clk_download", 0, 0, new String[] { str1 });
      return;
      veg.d(this.jdField_a_of_type_Uhz.b, "save video -info local file exist , start watermark , vid:%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      tsu.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mStoryType, String.valueOf(this.jdField_a_of_type_Uhz.hashCode()));
      break;
      str1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId;
      break label975;
    }
    tsu.a(this.jdField_a_of_type_Uhz.b(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, new uiu(this));
    int i;
    if (this.c)
    {
      paramInt = 1;
      if (!this.e) {
        break label1250;
      }
      i = (int)this.jdField_a_of_type_Long;
      label1149:
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {
        break label1255;
      }
      str1 = "4";
      label1159:
      vel.a("play_video", "more_report", paramInt, i, new String[] { "", str1 });
      paramInt = this.jdField_a_of_type_Uhz.c();
      str2 = this.jdField_a_of_type_Uhz.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) {
        break label1269;
      }
    }
    label1250:
    label1255:
    label1269:
    for (str1 = "";; str1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId)
    {
      vel.a("story_grp", "clk_one", paramInt, 0, new String[] { "7", str2, "", str1 });
      return;
      paramInt = 2;
      break;
      i = 0;
      break label1149;
      str1 = String.valueOf(vel.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
      break label1159;
    }
    this.jdField_a_of_type_Uhz.b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    return;
    this.jdField_a_of_type_Uhz.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    vel.a("play_video", "not_like", this.jdField_a_of_type_Uhz.c(), 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
  
  public void c()
  {
    super.c();
    veg.b(this.jdField_a_of_type_Uhz.b, "OnSimpleShareListenerImpl onShowUI");
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(true);
    }
  }
  
  public void d()
  {
    super.d();
    veg.b(this.jdField_a_of_type_Uhz.b, "OnSimpleShareListenerImpl onDismiss");
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null) && (!this.d)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uis
 * JD-Core Version:    0.7.0.1
 */