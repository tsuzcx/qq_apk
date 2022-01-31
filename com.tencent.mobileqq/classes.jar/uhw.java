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

public class uhw
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public bfpc a;
  private suy jdField_a_of_type_Suy = new suy();
  protected tpb a;
  private uio jdField_a_of_type_Uio;
  private uis jdField_a_of_type_Uis;
  private final uvx jdField_a_of_type_Uvx;
  private View b;
  
  public uhw(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((tdl)tcz.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
      ved.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      ved.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
    localObject = new uie(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = bbdj.a(b(), 230, 2131558906, ajya.a(2131706895), null, ajya.a(2131706893), ajya.a(2131706900), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bbgu)localObject).setCancelable(false);
    ((bbgu)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bbgu)localObject).show();
    vei.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    vei.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Uas == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    bfpc localbfpc;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Uas.a();
      localStoryVideoItem = this.jdField_a_of_type_Uas.a();
      localQQUserUIItem = ((tdl)tcz.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = tsr.a(localStoryVideoItem);
      localbfpc = (bfpc)bfpp.b(b(), null);
      localbfpc.a(ajya.a(2131706892), 5);
      localbfpc.c(2131690596);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localbfpc.a(new uhy(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localbfpc));
      localbfpc.a(new uia(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localbfpc.isShowing());
    localbfpc.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = vei.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      vei.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(vei.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Uas == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      bfpc localbfpc;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Uas.a();
        localbfpc = (bfpc)bfpp.b(b(), null);
        localbfpc.a(ajya.a(2131706889), 5);
        localbfpc.c(2131690596);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localbfpc.a(new uib(this, localStoryVideoItem, localAtomicBoolean, localbfpc));
        localbfpc.a(new uic(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localbfpc.isShowing());
      localbfpc.show();
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
  
  protected tpb a(trw paramtrw)
  {
    if (paramtrw == null) {}
    for (this.jdField_a_of_type_Tpb = tpb.a(b());; this.jdField_a_of_type_Tpb = tpb.a(b(), paramtrw)) {
      return this.jdField_a_of_type_Tpb;
    }
  }
  
  public void a(View paramView)
  {
    new uhx(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Uas == null) {
      return;
    }
    if (!vym.a(QQStoryContext.a().a()))
    {
      bcql.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, ajya.a(2131706899), 0).a();
      return;
    }
    bcql.a(b(), ajya.a(2131706896), 0).a();
    new tkx().a(paramStoryVideoItem.mVid);
    uwd localuwd = (uwd)tcz.a(12);
    localuwd.a(this.jdField_a_of_type_Uas.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localuwd.a(this.jdField_a_of_type_Uas.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new tla(new ErrorMessage(), paramStoryVideoItem.mVid);
    stb.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new uit(this), "");
    paramMap.put(new uil(this), "");
    paramMap.put(new uij(this), "");
    paramMap.put(new uik(this), "");
    paramMap.put(new uim(this), "");
    paramMap.put(new uii(this), "");
    paramMap.put(new uin(this), "");
    this.jdField_a_of_type_Uio = new uio(this);
    a(this.jdField_a_of_type_Uio);
  }
  
  public void a(trw paramtrw)
  {
    if (this.jdField_a_of_type_Uas == null) {
      return;
    }
    Object localObject1 = (tdl)tcz.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Uas.a();
    if (localStoryVideoItem == null)
    {
      ved.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Uas.a();
    QQUserUIItem localQQUserUIItem = ((tdl)localObject1).b(localStoryVideoItem.mOwnerUid);
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
      bool8 = tsr.a(localStoryVideoItem);
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
      if ((this.jdField_a_of_type_Twl instanceof twz))
      {
        localObject1 = ((twz)this.jdField_a_of_type_Twl).jdField_a_of_type_Tff;
        bool1 = tfy.a(QQStoryContext.a()).a(((twz)this.jdField_a_of_type_Twl).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((tff)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1377;
      }
      localObject1 = ((umv)tcz.a(7)).a(b());
      if (localObject1 == null) {
        break label1377;
      }
      localObject2 = ((TroopManager)tsr.a().getManager(52)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = tsr.a().getCurrentAccountUin();
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
          vei.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new uid(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
            this.jdField_a_of_type_Bfpc.dismiss();
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
          if ((this.jdField_a_of_type_Twl instanceof twz)) {
            ((twz)this.jdField_a_of_type_Twl).a();
          }
          if ((this.jdField_a_of_type_Twl instanceof twa))
          {
            localObject1 = (twa)this.jdField_a_of_type_Twl;
            if (((twa)localObject1).a != null)
            {
              localObject1 = ((twa)localObject1).a.jdField_a_of_type_JavaLangString;
              localObject1 = this.jdField_a_of_type_Uvx.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          ved.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Uas.a().isGameVideo()) {
            vei.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Uas.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
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
        a(paramtrw).a((List)localObject1).a().a(new tqd(localStoryVideoItem, bool7, (String)localObject2)).a(new uip(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
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
          k = vei.a(localVideoListFeedItem);
          if (!bool8) {
            break label933;
          }
        }
        label933:
        for (localObject1 = "2";; localObject1 = "1")
        {
          vei.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(vei.a(localQQUserUIItem)), localStoryVideoItem.mVid });
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
        a(paramtrw).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131719508).a(new tqd(localStoryVideoItem, bool7, (String)localObject2)).a(new uip(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramtrw).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new tqd(localStoryVideoItem, bool7, (String)localObject2)).a(new uip(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      a(paramtrw).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131719508).a(new tqd(localStoryVideoItem, bool7, (String)localObject2)).a(new uip(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1377:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ved.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramuas);
    j();
  }
  
  public boolean a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramuas.jdField_a_of_type_Tff == null) || (paramuas.jdField_a_of_type_Tff.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    uwd localuwd = (uwd)tcz.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new uif(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localuwd);
    localObject = bbdj.a(b(), 230, 2131558906, ajya.a(2131706886), null, ajya.a(2131706891), ajya.a(2131706898), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bbgu)localObject).setCancelable(false);
    ((bbgu)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bbgu)localObject).show();
    vei.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    vei.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Suy != null) {
      this.jdField_a_of_type_Suy.a();
    }
    if (this.jdField_a_of_type_Uio != null) {
      b(this.jdField_a_of_type_Uio);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Uas == null) {
      return;
    }
    paramView = this.jdField_a_of_type_Uas.a();
    if (paramView == null)
    {
      ved.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString });
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
    if (tsr.a(paramView))
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
 * Qualified Name:     uhw
 * JD-Core Version:    0.7.0.1
 */