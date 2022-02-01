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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Subscriber;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class xui
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public bkho a;
  private whl jdField_a_of_type_Whl = new whl();
  protected xbo a;
  private xva jdField_a_of_type_Xva;
  private xve jdField_a_of_type_Xve;
  private final yij jdField_a_of_type_Yij;
  private View b;
  
  public xui(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((wpy)wpm.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
      yqp.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      yqp.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
    localObject = new xuq(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = bglp.a(b(), 230, 2131559009, anni.a(2131705670), null, anni.a(2131705668), anni.a(2131705675), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bgpa)localObject).setCancelable(false);
    ((bgpa)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bgpa)localObject).show();
    yqu.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    yqu.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Xne == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    bkho localbkho;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Xne.a();
      localStoryVideoItem = this.jdField_a_of_type_Xne.a();
      localQQUserUIItem = ((wpy)wpm.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = xfe.a(localStoryVideoItem);
      localbkho = (bkho)bkif.b(b(), null);
      localbkho.a(anni.a(2131705667), 5);
      localbkho.c(2131690582);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localbkho.a(new xuk(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localbkho));
      localbkho.a(new xum(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localbkho.isShowing());
    localbkho.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = yqu.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      yqu.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(yqu.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xne == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      bkho localbkho;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xne.a();
        localbkho = (bkho)bkif.b(b(), null);
        localbkho.a(anni.a(2131705664), 5);
        localbkho.c(2131690582);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localbkho.a(new xun(this, localStoryVideoItem, localAtomicBoolean, localbkho));
        localbkho.a(new xuo(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localbkho.isShowing());
      localbkho.show();
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
  
  protected xbo a(xej paramxej)
  {
    if (paramxej == null) {}
    for (this.jdField_a_of_type_Xbo = xbo.a(b());; this.jdField_a_of_type_Xbo = xbo.a(b(), paramxej)) {
      return this.jdField_a_of_type_Xbo;
    }
  }
  
  public void a(View paramView)
  {
    new xuj(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Xne == null) {
      return;
    }
    if (!zky.a(QQStoryContext.a().a()))
    {
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, anni.a(2131705674), 0).a();
      return;
    }
    QQToast.a(b(), anni.a(2131705671), 0).a();
    new wxk().a(paramStoryVideoItem.mVid);
    yip localyip = (yip)wpm.a(12);
    localyip.a(this.jdField_a_of_type_Xne.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localyip.a(this.jdField_a_of_type_Xne.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new wxn(new ErrorMessage(), paramStoryVideoItem.mVid);
    wfo.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xvf(this), "");
    paramMap.put(new xux(this), "");
    paramMap.put(new xuv(this), "");
    paramMap.put(new xuw(this), "");
    paramMap.put(new xuy(this), "");
    paramMap.put(new xuu(this), "");
    paramMap.put(new xuz(this), "");
    this.jdField_a_of_type_Xva = new xva(this);
    a(this.jdField_a_of_type_Xva);
  }
  
  public void a(xej paramxej)
  {
    if (this.jdField_a_of_type_Xne == null) {
      return;
    }
    Object localObject1 = (wpy)wpm.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xne.a();
    if (localStoryVideoItem == null)
    {
      yqp.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xne.a();
    QQUserUIItem localQQUserUIItem = ((wpy)localObject1).b(localStoryVideoItem.mOwnerUid);
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
      bool8 = xfe.a(localStoryVideoItem);
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
      if ((this.jdField_a_of_type_Xix instanceof xjl))
      {
        localObject1 = ((xjl)this.jdField_a_of_type_Xix).jdField_a_of_type_Wrs;
        bool1 = wsl.a(QQStoryContext.a()).a(((xjl)this.jdField_a_of_type_Xix).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((wrs)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1377;
      }
      localObject1 = ((xzh)wpm.a(7)).a(b());
      if (localObject1 == null) {
        break label1377;
      }
      localObject2 = ((TroopManager)xfe.a().getManager(52)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = xfe.a().getCurrentAccountUin();
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
          yqu.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new xup(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing())) {
            this.jdField_a_of_type_Bkho.dismiss();
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
          if ((this.jdField_a_of_type_Xix instanceof xjl)) {
            ((xjl)this.jdField_a_of_type_Xix).a();
          }
          if ((this.jdField_a_of_type_Xix instanceof xim))
          {
            localObject1 = (xim)this.jdField_a_of_type_Xix;
            if (((xim)localObject1).a != null)
            {
              localObject1 = ((xim)localObject1).a.jdField_a_of_type_JavaLangString;
              localObject1 = this.jdField_a_of_type_Yij.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          yqp.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Xne.a().isGameVideo()) {
            yqu.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Xne.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
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
        a(paramxej).a((List)localObject1).a().a(new xcq(localStoryVideoItem, bool7, (String)localObject2)).a(new xvb(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
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
          k = yqu.a(localVideoListFeedItem);
          if (!bool8) {
            break label933;
          }
        }
        label933:
        for (localObject1 = "2";; localObject1 = "1")
        {
          yqu.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(yqu.a(localQQUserUIItem)), localStoryVideoItem.mVid });
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
        a(paramxej).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131718027).a(new xcq(localStoryVideoItem, bool7, (String)localObject2)).a(new xvb(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramxej).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new xcq(localStoryVideoItem, bool7, (String)localObject2)).a(new xvb(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      a(paramxej).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131718027).a(new xcq(localStoryVideoItem, bool7, (String)localObject2)).a(new xvb(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1377:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull xne paramxne, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    yqp.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramxne);
    j();
  }
  
  public boolean a(@NonNull xne paramxne, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramxne.jdField_a_of_type_Wrs == null) || (paramxne.jdField_a_of_type_Wrs.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    yip localyip = (yip)wpm.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new xur(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localyip);
    localObject = bglp.a(b(), 230, 2131559009, anni.a(2131705661), null, anni.a(2131705666), anni.a(2131705673), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bgpa)localObject).setCancelable(false);
    ((bgpa)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bgpa)localObject).show();
    yqu.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    yqu.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Whl != null) {
      this.jdField_a_of_type_Whl.a();
    }
    if (this.jdField_a_of_type_Xva != null) {
      b(this.jdField_a_of_type_Xva);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Xne == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xne.a();
      if (localStoryVideoItem == null)
      {
        yqp.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString });
      }
      else
      {
        if (localStoryVideoItem.mStoryType == 2) {}
        boolean bool;
        for (;;)
        {
          bool = a(localStoryVideoItem);
          if (i == 0) {
            break label91;
          }
          a(null);
          break;
          i = 0;
        }
        label91:
        if (xfe.a(localStoryVideoItem))
        {
          if ((localStoryVideoItem.isUploadFail()) || (localStoryVideoItem.isUploading())) {
            e();
          } else {
            a(null);
          }
        }
        else if (bool) {
          a(null);
        } else {
          d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xui
 * JD-Core Version:    0.7.0.1
 */