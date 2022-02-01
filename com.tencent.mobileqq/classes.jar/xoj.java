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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Subscriber;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class xoj
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public bkzi a;
  private wca jdField_a_of_type_Wca = new wca();
  protected wvu a;
  private xpb jdField_a_of_type_Xpb;
  private xpf jdField_a_of_type_Xpf;
  private final yck jdField_a_of_type_Yck;
  private View b;
  
  public xoj(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((wke)wjs.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
      ykq.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      ykq.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
    localObject = new xor(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = bhdj.a(b(), 230, 2131559043, anvx.a(2131706358), null, anvx.a(2131706356), anvx.a(2131706363), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    ykv.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    ykv.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Xhf == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    bkzi localbkzi;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Xhf.a();
      localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
      localQQUserUIItem = ((wke)wjs.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = wzk.a(localStoryVideoItem);
      localbkzi = (bkzi)bkzz.b(b(), null);
      localbkzi.a(anvx.a(2131706355), 5);
      localbkzi.c(2131690697);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localbkzi.a(new xol(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localbkzi));
      localbkzi.a(new xon(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localbkzi.isShowing());
    localbkzi.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = ykv.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      ykv.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(ykv.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xhf == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      bkzi localbkzi;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
        localbkzi = (bkzi)bkzz.b(b(), null);
        localbkzi.a(anvx.a(2131706352), 5);
        localbkzi.c(2131690697);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localbkzi.a(new xoo(this, localStoryVideoItem, localAtomicBoolean, localbkzi));
        localbkzi.a(new xop(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localbkzi.isShowing());
      localbkzi.show();
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
  
  protected wvu a(wyp paramwyp)
  {
    if (paramwyp == null) {}
    for (this.jdField_a_of_type_Wvu = wvu.a(b());; this.jdField_a_of_type_Wvu = wvu.a(b(), paramwyp)) {
      return this.jdField_a_of_type_Wvu;
    }
  }
  
  public void a(View paramView)
  {
    new xok(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Xhf == null) {
      return;
    }
    if (!zei.a(QQStoryContext.a().a()))
    {
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, anvx.a(2131706362), 0).a();
      return;
    }
    QQToast.a(b(), anvx.a(2131706359), 0).a();
    new wrq().a(paramStoryVideoItem.mVid);
    ycq localycq = (ycq)wjs.a(12);
    localycq.a(this.jdField_a_of_type_Xhf.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localycq.a(this.jdField_a_of_type_Xhf.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new wrt(new ErrorMessage(), paramStoryVideoItem.mVid);
    wad.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xpg(this), "");
    paramMap.put(new xoy(this), "");
    paramMap.put(new xow(this), "");
    paramMap.put(new xox(this), "");
    paramMap.put(new xoz(this), "");
    paramMap.put(new xov(this), "");
    paramMap.put(new xpa(this), "");
    this.jdField_a_of_type_Xpb = new xpb(this);
    a(this.jdField_a_of_type_Xpb);
  }
  
  public void a(wyp paramwyp)
  {
    if (this.jdField_a_of_type_Xhf == null) {
      return;
    }
    Object localObject1 = (wke)wjs.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
    if (localStoryVideoItem == null)
    {
      ykq.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xhf.a();
    QQUserUIItem localQQUserUIItem = ((wke)localObject1).b(localStoryVideoItem.mOwnerUid);
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
    label325:
    boolean bool7;
    boolean bool6;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      bool2 = true;
      if (localStoryVideoItem.mStoryType != 2) {
        break label835;
      }
      bool3 = true;
      bool8 = wzk.a(localStoryVideoItem);
      if ((localQQUserUIItem == null) || (localQQUserUIItem.relationType != 0)) {
        break label841;
      }
      bool4 = true;
      if (localStoryVideoItem.mBanType != 1000) {
        break label847;
      }
      i = 1;
      long l2 = 0L;
      bool5 = false;
      l1 = l2;
      if ((this.jdField_a_of_type_Xcy instanceof xdm))
      {
        localObject1 = ((xdm)this.jdField_a_of_type_Xcy).jdField_a_of_type_Wly;
        bool1 = wmr.a(QQStoryContext.a()).a(((xdm)this.jdField_a_of_type_Xcy).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((wly)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1384;
      }
      localObject1 = ((xti)wjs.a(7)).a(b());
      if (localObject1 == null) {
        break label1384;
      }
      localObject2 = ((TroopManager)wzk.a().getManager(QQManagerFactory.TROOP_MANAGER)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = wzk.a().getCurrentAccountUin();
      if ((localObject2 == null) || ((!((TroopInfo)localObject2).isTroopAdmin((String)localObject3)) && (!((TroopInfo)localObject2).isTroopOwner((String)localObject3)))) {
        break label852;
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
          label374:
          ykv.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new xoq(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
            this.jdField_a_of_type_Bkzi.dismiss();
          }
          if (localVideoListFeedItem != null) {
            break label941;
          }
          localObject2 = null;
          label474:
          if (c() != 12) {
            break label951;
          }
          bool7 = true;
          label486:
          boolean bool9 = a().mUIStyle.showVideoNoInteresting;
          if ((this.jdField_a_of_type_Xcy instanceof xdm)) {
            ((xdm)this.jdField_a_of_type_Xcy).a();
          }
          if ((this.jdField_a_of_type_Xcy instanceof xcn))
          {
            localObject1 = (xcn)this.jdField_a_of_type_Xcy;
            if (((xcn)localObject1).a != null)
            {
              localObject1 = ((xcn)localObject1).a.jdField_a_of_type_JavaLangString;
              localObject1 = this.jdField_a_of_type_Yck.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          ykq.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Xhf.a().isGameVideo()) {
            ykv.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Xhf.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
          }
          if (!bool3) {
            break label1033;
          }
          if ((!bool1) && (!bool8)) {
            break label957;
          }
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 8 } });
        }
      }
      for (;;)
      {
        a(paramwyp).a((List)localObject1).a().a(new www(localStoryVideoItem, bool7, (String)localObject2)).a(new xpc(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
        bool2 = false;
        break;
        label835:
        bool3 = false;
        break label105;
        label841:
        bool4 = false;
        break label128;
        label847:
        i = 0;
        break label141;
        label852:
        bool1 = false;
        break label325;
        localObject1 = "";
        break label374;
        label872:
        int k;
        if (bool2)
        {
          j = 1;
          k = ykv.a(localVideoListFeedItem);
          if (!bool8) {
            break label934;
          }
        }
        label934:
        for (localObject1 = "2";; localObject1 = "1")
        {
          ykv.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(ykv.a(localQQUserUIItem)), localStoryVideoItem.mVid });
          break;
          j = 2;
          break label872;
        }
        label941:
        localObject2 = localVideoListFeedItem.feedId;
        break label474;
        label951:
        bool7 = false;
        break label486;
        label957:
        if (bool6) {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9, 8 } });
        } else {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9 } });
        }
      }
      label1033:
      if (bool8)
      {
        a(paramwyp).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131718786).a(new www(localStoryVideoItem, bool7, (String)localObject2)).a(new xpc(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramwyp).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new www(localStoryVideoItem, bool7, (String)localObject2)).a(new xpc(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      paramwyp = a(paramwyp);
      localObject1 = new int[] { 6, 9 };
      paramwyp.a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, localObject1 })).a(2131718786).a(new www(localStoryVideoItem, bool7, (String)localObject2)).a(new xpc(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1384:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ykq.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramxhf);
    j();
  }
  
  public boolean a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramxhf.jdField_a_of_type_Wly == null) || (paramxhf.jdField_a_of_type_Wly.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    ycq localycq = (ycq)wjs.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new xos(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localycq);
    localObject = bhdj.a(b(), 230, 2131559043, anvx.a(2131706349), null, anvx.a(2131706354), anvx.a(2131706361), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    ykv.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    ykv.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Wca != null) {
      this.jdField_a_of_type_Wca.a();
    }
    if (this.jdField_a_of_type_Xpb != null) {
      b(this.jdField_a_of_type_Xpb);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Xhf == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
      if (localStoryVideoItem == null)
      {
        ykq.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString });
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
        if (wzk.a(localStoryVideoItem))
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
 * Qualified Name:     xoj
 * JD-Core Version:    0.7.0.1
 */