import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Subscriber;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class tvd
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public begr a;
  private sif jdField_a_of_type_Sif = new sif();
  protected tci a;
  private tvv jdField_a_of_type_Tvv;
  private tvz jdField_a_of_type_Tvz;
  private final uje jdField_a_of_type_Uje;
  private View b;
  
  public tvd(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((sqs)sqg.a(2)).c(paramStoryVideoItem.mOwnerUid);
    int i;
    int j;
    label83:
    int k;
    label99:
    int m;
    label112:
    int n;
    label123:
    int i1;
    if (((paramStoryVideoItem.mStoryType != 1) || (localQQUserUIItem == null) || (localQQUserUIItem.isVip()) || (localQQUserUIItem.isFriend()) || (localQQUserUIItem.isMe())) || ((localQQUserUIItem != null) && (localQQUserUIItem.isFriend())))
    {
      i = 1;
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isMe())) {
        break label197;
      }
      j = 1;
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break label202;
      }
      k = 1;
      if (paramStoryVideoItem.mBanType != 1000) {
        break label208;
      }
      m = 1;
      if (paramStoryVideoItem.mStoryType != 2) {
        break label214;
      }
      n = 1;
      i1 = a().mUIStyle.bottomWidgetShowFlag;
      switch (i1)
      {
      default: 
        if ((m == 0) && ((i == 0) || (paramStoryVideoItem.mBanType != 0)) && (j == 0) && (k == 0) && (n == 0)) {
          break;
        }
      }
    }
    label197:
    label202:
    label208:
    label214:
    while ((i != 0) && (i1 == 3))
    {
      return true;
      i = 0;
      break;
      j = 0;
      break label83;
      k = 0;
      break label99;
      m = 0;
      break label112;
      n = 0;
      break label123;
      urk.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      urk.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
      return false;
    }
    return false;
  }
  
  private void c(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new tvl(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = babr.a(b(), 230, 2131493345, ajjy.a(2131641099), null, ajjy.a(2131641097), ajjy.a(2131641104), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bafb)localObject).setCancelable(false);
    ((bafb)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bafb)localObject).show();
    urp.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    urp.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Tnz == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    begr localbegr;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Tnz.a();
      localStoryVideoItem = this.jdField_a_of_type_Tnz.a();
      localQQUserUIItem = ((sqs)sqg.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = tfy.a(localStoryVideoItem);
      localbegr = (begr)behe.b(b(), null);
      localbegr.a(ajjy.a(2131641096), 5);
      localbegr.c(2131625035);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localbegr.a(new tvf(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localbegr));
      localbegr.a(new tvh(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localbegr.isShowing());
    localbegr.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = urp.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      urp.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(urp.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Tnz == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      begr localbegr;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Tnz.a();
        localbegr = (begr)behe.b(b(), null);
        localbegr.a(ajjy.a(2131641093), 5);
        localbegr.c(2131625035);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localbegr.a(new tvi(this, localStoryVideoItem, localAtomicBoolean, localbegr));
        localbegr.a(new tvj(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localbegr.isShowing());
      localbegr.show();
    } while (localVideoViewVideoHolder == null);
    localVideoViewVideoHolder.c(true);
  }
  
  public String a()
  {
    return "MoreVideoInfoWidget";
  }
  
  public String a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail()) {
      return "3";
    }
    if (paramStoryVideoItem.isUploading()) {
      return "1";
    }
    return "2";
  }
  
  protected tci a(tfd paramtfd)
  {
    if (paramtfd == null) {}
    for (this.jdField_a_of_type_Tci = tci.a(b());; this.jdField_a_of_type_Tci = tci.a(b(), paramtfd)) {
      return this.jdField_a_of_type_Tci;
    }
  }
  
  public void a(View paramView)
  {
    new tve(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Tnz == null) {
      return;
    }
    if (!vlt.a(QQStoryContext.a().a()))
    {
      bbmy.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, ajjy.a(2131641103), 0).a();
      return;
    }
    bbmy.a(b(), ajjy.a(2131641100), 0).a();
    new sye().a(paramStoryVideoItem.mVid);
    ujk localujk = (ujk)sqg.a(12);
    localujk.a(this.jdField_a_of_type_Tnz.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localujk.a(this.jdField_a_of_type_Tnz.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new syh(new ErrorMessage(), paramStoryVideoItem.mVid);
    sgi.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new twa(this), "");
    paramMap.put(new tvs(this), "");
    paramMap.put(new tvq(this), "");
    paramMap.put(new tvr(this), "");
    paramMap.put(new tvt(this), "");
    paramMap.put(new tvp(this), "");
    paramMap.put(new tvu(this), "");
    this.jdField_a_of_type_Tvv = new tvv(this);
    a(this.jdField_a_of_type_Tvv);
  }
  
  public void a(tfd paramtfd)
  {
    if (this.jdField_a_of_type_Tnz == null) {
      return;
    }
    Object localObject1 = (sqs)sqg.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Tnz.a();
    if (localStoryVideoItem == null)
    {
      urk.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Tnz.a();
    QQUserUIItem localQQUserUIItem = ((sqs)localObject1).b(localStoryVideoItem.mOwnerUid);
    boolean bool2;
    boolean bool3;
    label105:
    boolean bool8;
    boolean bool4;
    label128:
    int i;
    label141:
    boolean bool5;
    long l1;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    label324:
    boolean bool7;
    boolean bool6;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      bool2 = true;
      if (localStoryVideoItem.mStoryType != 2) {
        break label834;
      }
      bool3 = true;
      bool8 = tfy.a(localStoryVideoItem);
      if ((localQQUserUIItem == null) || (localQQUserUIItem.relationType != 0)) {
        break label840;
      }
      bool4 = true;
      if (localStoryVideoItem.mBanType != 1000) {
        break label846;
      }
      i = 1;
      long l2 = 0L;
      bool5 = false;
      l1 = l2;
      if ((this.jdField_a_of_type_Tjs instanceof tkg))
      {
        localObject1 = ((tkg)this.jdField_a_of_type_Tjs).jdField_a_of_type_Ssm;
        bool1 = stf.a(QQStoryContext.a()).a(((tkg)this.jdField_a_of_type_Tjs).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((ssm)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1383;
      }
      localObject1 = ((uac)sqg.a(7)).a(b());
      if (localObject1 == null) {
        break label1383;
      }
      localObject2 = ((TroopManager)tfy.a().getManager(52)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = tfy.a().getCurrentAccountUin();
      if ((localObject2 == null) || ((!((TroopInfo)localObject2).isTroopAdmin((String)localObject3)) && (!((TroopInfo)localObject2).isTroopOwner((String)localObject3)))) {
        break label851;
      }
      bool1 = true;
      bool7 = ((ShareGroupItem)localObject1).isOwner();
      bool6 = bool1;
      bool1 = bool7;
    }
    for (;;)
    {
      localObject3 = ((StoryPlayerGroupHolder)a()).a();
      int j;
      if (bool3)
      {
        j = c();
        if (localVideoListFeedItem != null)
        {
          localObject1 = localVideoListFeedItem.feedId;
          label373:
          urp.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new tvk(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
            this.jdField_a_of_type_Begr.dismiss();
          }
          if (localVideoListFeedItem != null) {
            break label940;
          }
          localObject2 = null;
          label473:
          if (c() != 12) {
            break label950;
          }
          bool7 = true;
          label485:
          boolean bool9 = a().mUIStyle.showVideoNoInteresting;
          if ((this.jdField_a_of_type_Tjs instanceof tkg)) {
            ((tkg)this.jdField_a_of_type_Tjs).a();
          }
          if ((this.jdField_a_of_type_Tjs instanceof tjh))
          {
            localObject1 = (tjh)this.jdField_a_of_type_Tjs;
            if (((tjh)localObject1).a != null)
            {
              localObject1 = ((tjh)localObject1).a.jdField_a_of_type_JavaLangString;
              localObject1 = this.jdField_a_of_type_Uje.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          urk.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Tnz.a().isGameVideo()) {
            urp.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Tnz.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
          }
          if (!bool3) {
            break label1032;
          }
          if ((!bool1) && (!bool8)) {
            break label956;
          }
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 8 } });
        }
      }
      for (;;)
      {
        a(paramtfd).a((List)localObject1).a().a(new tdk(localStoryVideoItem, bool7, (String)localObject2)).a(new tvw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
        bool2 = false;
        break;
        label834:
        bool3 = false;
        break label105;
        label840:
        bool4 = false;
        break label128;
        label846:
        i = 0;
        break label141;
        label851:
        bool1 = false;
        break label324;
        localObject1 = "";
        break label373;
        label871:
        int k;
        if (bool2)
        {
          j = 1;
          k = urp.a(localVideoListFeedItem);
          if (!bool8) {
            break label933;
          }
        }
        label933:
        for (localObject1 = "2";; localObject1 = "1")
        {
          urp.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(urp.a(localQQUserUIItem)), localStoryVideoItem.mVid });
          break;
          j = 2;
          break label871;
        }
        label940:
        localObject2 = localVideoListFeedItem.feedId;
        break label473;
        label950:
        bool7 = false;
        break label485;
        label956:
        if (bool6) {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9, 8 } });
        } else {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9 } });
        }
      }
      label1032:
      if (bool8)
      {
        paramtfd = a(paramtfd);
        localObject1 = new int[] { 6, 7, 8 };
        paramtfd.a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, localObject1 })).a(2131653614).a(new tdk(localStoryVideoItem, bool7, (String)localObject2)).a(new tvw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramtfd).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new tdk(localStoryVideoItem, bool7, (String)localObject2)).a(new tvw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      a(paramtfd).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131653614).a(new tdk(localStoryVideoItem, bool7, (String)localObject2)).a(new tvw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1383:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    urk.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramtnz);
    j();
  }
  
  public boolean a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramtnz.jdField_a_of_type_Ssm == null) || (paramtnz.jdField_a_of_type_Ssm.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    ujk localujk = (ujk)sqg.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new tvm(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localujk);
    localObject = babr.a(b(), 230, 2131493345, ajjy.a(2131641090), null, ajjy.a(2131641095), ajjy.a(2131641102), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bafb)localObject).setCancelable(false);
    ((bafb)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bafb)localObject).show();
    urp.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    urp.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Sif != null) {
      this.jdField_a_of_type_Sif.a();
    }
    if (this.jdField_a_of_type_Tvv != null) {
      b(this.jdField_a_of_type_Tvv);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Tnz == null) {
      return;
    }
    paramView = this.jdField_a_of_type_Tnz.a();
    if (paramView == null)
    {
      urk.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString });
      return;
    }
    if (paramView.mStoryType == 2) {}
    boolean bool;
    for (;;)
    {
      bool = a(paramView);
      if (i == 0) {
        break;
      }
      a(null);
      return;
      i = 0;
    }
    if (tfy.a(paramView))
    {
      if ((paramView.isUploadFail()) || (paramView.isUploading()))
      {
        e();
        return;
      }
      a(null);
      return;
    }
    if (bool)
    {
      a(null);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvd
 * JD-Core Version:    0.7.0.1
 */