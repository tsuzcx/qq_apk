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

public class wzo
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public bjnw a;
  private vnf jdField_a_of_type_Vnf = new vnf();
  protected wgz a;
  private xag jdField_a_of_type_Xag;
  private xak jdField_a_of_type_Xak;
  private final xnp jdField_a_of_type_Xnp;
  private View b;
  
  public wzo(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((vvj)vux.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
      xvv.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      xvv.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
    localObject = new wzw(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = bfur.a(b(), 230, 2131559016, amtj.a(2131706007), null, amtj.a(2131706005), amtj.a(2131706012), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    xwa.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    xwa.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Wsk == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    bjnw localbjnw;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Wsk.a();
      localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
      localQQUserUIItem = ((vvj)vux.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = wkp.a(localStoryVideoItem);
      localbjnw = (bjnw)bjon.b(b(), null);
      localbjnw.a(amtj.a(2131706004), 5);
      localbjnw.c(2131690620);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localbjnw.a(new wzq(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localbjnw));
      localbjnw.a(new wzs(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localbjnw.isShowing());
    localbjnw.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = xwa.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      xwa.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(xwa.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Wsk == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      bjnw localbjnw;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
        localbjnw = (bjnw)bjon.b(b(), null);
        localbjnw.a(amtj.a(2131706001), 5);
        localbjnw.c(2131690620);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localbjnw.a(new wzt(this, localStoryVideoItem, localAtomicBoolean, localbjnw));
        localbjnw.a(new wzu(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localbjnw.isShowing());
      localbjnw.show();
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
  
  protected wgz a(wju paramwju)
  {
    if (paramwju == null) {}
    for (this.jdField_a_of_type_Wgz = wgz.a(b());; this.jdField_a_of_type_Wgz = wgz.a(b(), paramwju)) {
      return this.jdField_a_of_type_Wgz;
    }
  }
  
  public void a(View paramView)
  {
    new wzp(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Wsk == null) {
      return;
    }
    if (!ypp.a(QQStoryContext.a().a()))
    {
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, amtj.a(2131706011), 0).a();
      return;
    }
    QQToast.a(b(), amtj.a(2131706008), 0).a();
    new wcv().a(paramStoryVideoItem.mVid);
    xnv localxnv = (xnv)vux.a(12);
    localxnv.a(this.jdField_a_of_type_Wsk.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localxnv.a(this.jdField_a_of_type_Wsk.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new wcy(new ErrorMessage(), paramStoryVideoItem.mVid);
    vli.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xal(this), "");
    paramMap.put(new xad(this), "");
    paramMap.put(new xab(this), "");
    paramMap.put(new xac(this), "");
    paramMap.put(new xae(this), "");
    paramMap.put(new xaa(this), "");
    paramMap.put(new xaf(this), "");
    this.jdField_a_of_type_Xag = new xag(this);
    a(this.jdField_a_of_type_Xag);
  }
  
  public void a(wju paramwju)
  {
    if (this.jdField_a_of_type_Wsk == null) {
      return;
    }
    Object localObject1 = (vvj)vux.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
    if (localStoryVideoItem == null)
    {
      xvv.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Wsk.a();
    QQUserUIItem localQQUserUIItem = ((vvj)localObject1).b(localStoryVideoItem.mOwnerUid);
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
      bool8 = wkp.a(localStoryVideoItem);
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
      if ((this.jdField_a_of_type_Wod instanceof wor))
      {
        localObject1 = ((wor)this.jdField_a_of_type_Wod).jdField_a_of_type_Vxd;
        bool1 = vxw.a(QQStoryContext.a()).a(((wor)this.jdField_a_of_type_Wod).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((vxd)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1389;
      }
      localObject1 = ((xen)vux.a(7)).a(b());
      if (localObject1 == null) {
        break label1389;
      }
      localObject2 = ((TroopManager)wkp.a().getManager(52)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = wkp.a().getCurrentAccountUin();
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
          xwa.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new wzv(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing())) {
            this.jdField_a_of_type_Bjnw.dismiss();
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
          if ((this.jdField_a_of_type_Wod instanceof wor)) {
            ((wor)this.jdField_a_of_type_Wod).a();
          }
          if ((this.jdField_a_of_type_Wod instanceof wns))
          {
            localObject1 = (wns)this.jdField_a_of_type_Wod;
            if (((wns)localObject1).a != null)
            {
              localObject1 = ((wns)localObject1).a.jdField_a_of_type_JavaLangString;
              localObject1 = this.jdField_a_of_type_Xnp.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          xvv.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Wsk.a().isGameVideo()) {
            xwa.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Wsk.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
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
        a(paramwju).a((List)localObject1).a().a(new wib(localStoryVideoItem, bool7, (String)localObject2)).a(new xah(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
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
          k = xwa.a(localVideoListFeedItem);
          if (!bool8) {
            break label933;
          }
        }
        label933:
        for (localObject1 = "2";; localObject1 = "1")
        {
          xwa.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(xwa.a(localQQUserUIItem)), localStoryVideoItem.mVid });
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
        paramwju = a(paramwju);
        localObject1 = new int[] { 6, 7, 8 };
        paramwju.a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, localObject1 })).a(2131718400).a(new wib(localStoryVideoItem, bool7, (String)localObject2)).a(new xah(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramwju).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new wib(localStoryVideoItem, bool7, (String)localObject2)).a(new xah(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      paramwju = a(paramwju);
      localObject1 = new int[] { 6, 9 };
      paramwju.a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, localObject1 })).a(2131718400).a(new wib(localStoryVideoItem, bool7, (String)localObject2)).a(new xah(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1389:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    xvv.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramwsk);
    j();
  }
  
  public boolean a(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramwsk.jdField_a_of_type_Vxd == null) || (paramwsk.jdField_a_of_type_Vxd.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    xnv localxnv = (xnv)vux.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new wzx(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localxnv);
    localObject = bfur.a(b(), 230, 2131559016, amtj.a(2131705998), null, amtj.a(2131706003), amtj.a(2131706010), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    xwa.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    xwa.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Vnf != null) {
      this.jdField_a_of_type_Vnf.a();
    }
    if (this.jdField_a_of_type_Xag != null) {
      b(this.jdField_a_of_type_Xag);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Wsk == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
      if (localStoryVideoItem == null)
      {
        xvv.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString });
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
        if (wkp.a(localStoryVideoItem))
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
 * Qualified Name:     wzo
 * JD-Core Version:    0.7.0.1
 */