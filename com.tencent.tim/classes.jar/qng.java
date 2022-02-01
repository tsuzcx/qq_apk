import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class qng
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  protected qbc a;
  private qng.g jdField_a_of_type_Qng$g;
  private qng.i jdField_a_of_type_Qng$i;
  private final qvf jdField_a_of_type_Qvf;
  private pno b = new pno();
  private View jj;
  public ausj mActionSheet;
  
  public qng(View paramView)
  {
    super(paramView);
    this.jj = paramView;
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
  }
  
  private void bps()
  {
    if (this.jdField_a_of_type_Qjq == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    ausj localausj;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Qjq.a();
      localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
      localQQUserUIItem = ((ptf)psx.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = qem.c(localStoryVideoItem);
      localausj = (ausj)auss.b(getActivity(), null);
      localausj.addButton(acfp.m(2131708458), 5);
      localausj.addCancelButton(2131721058);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localausj.a(new qni(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localausj));
      localausj.a(new qnk(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localausj.isShowing());
    localausj.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).sH(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = rar.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      rar.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(rar.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void bpt()
  {
    if (this.jdField_a_of_type_Qjq == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      ausj localausj;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
        localausj = (ausj)auss.b(getActivity(), null);
        localausj.addButton(acfp.m(2131708455), 5);
        localausj.addCancelButton(2131721058);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localausj.a(new qnl(this, localStoryVideoItem, localAtomicBoolean, localausj));
        localausj.a(new qnm(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localausj.isShowing());
      localausj.show();
    } while (localVideoViewVideoHolder == null);
    localVideoViewVideoHolder.sH(true);
  }
  
  private boolean e(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
      ram.w(this.TAG, "show BottomWidget because flag 1");
      return true;
      ram.w(this.TAG, "hide BottomWidget because flag 2");
      return false;
    }
    return false;
  }
  
  private void k(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).sH(true);
    }
    localObject = new qno(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = aqha.b(getActivity(), 230, 2131559151, acfp.m(2131708461), null, acfp.m(2131708459), acfp.m(2131708466), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((aqju)localObject).setCancelable(false);
    ((aqju)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((aqju)localObject).show();
    rar.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    rar.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new qng.j(this), "");
    paramMap.put(new qng.d(this), "");
    paramMap.put(new qng.b(this), "");
    paramMap.put(new qng.c(this), "");
    paramMap.put(new qng.e(this), "");
    paramMap.put(new qng.a(this), "");
    paramMap.put(new qng.f(this), "");
    this.jdField_a_of_type_Qng$g = new qng.g();
    a(this.jdField_a_of_type_Qng$g);
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
  
  public void a(qdu paramqdu)
  {
    if (this.jdField_a_of_type_Qjq == null) {
      return;
    }
    Object localObject1 = (ptf)psx.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
    if (localStoryVideoItem == null)
    {
      ram.e(this.TAG, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Qjq.vid });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Qjq.a();
    QQUserUIItem localQQUserUIItem = ((ptf)localObject1).b(localStoryVideoItem.mOwnerUid);
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
        break label839;
      }
      bool3 = true;
      bool8 = qem.c(localStoryVideoItem);
      if ((localQQUserUIItem == null) || (localQQUserUIItem.relationType != 0)) {
        break label845;
      }
      bool4 = true;
      if (localStoryVideoItem.mBanType != 1000) {
        break label851;
      }
      i = 1;
      long l2 = 0L;
      bool5 = false;
      l1 = l2;
      if ((this.d instanceof qhc.a))
      {
        localObject1 = ((qhc.a)this.d).g;
        bool1 = puy.a(QQStoryContext.a()).fh(((qhc.a)this.d).getUnionId());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((puh)localObject1).N(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(mL()))) {
        break label1383;
      }
      localObject1 = ((qqe)psx.a(7)).a(mL());
      if (localObject1 == null) {
        break label1383;
      }
      localObject2 = ((TroopManager)qem.getQQAppInterface().getManager(52)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = qem.getQQAppInterface().getCurrentAccountUin();
      if ((localObject2 == null) || ((!((TroopInfo)localObject2).isTroopAdmin((String)localObject3)) && (!((TroopInfo)localObject2).isTroopOwner((String)localObject3)))) {
        break label856;
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
        j = getVideoSource();
        if (localVideoListFeedItem != null)
        {
          localObject1 = localVideoListFeedItem.feedId;
          label373:
          rar.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).sH(true);
          }
          new qnn(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
            this.mActionSheet.dismiss();
          }
          if (localVideoListFeedItem != null) {
            break label946;
          }
          localObject2 = null;
          label476:
          if (getVideoSource() != 12) {
            break label956;
          }
          bool7 = true;
          label488:
          boolean bool9 = a().mUIStyle.showVideoNoInteresting;
          if ((this.d instanceof qhc.a)) {
            ((qhc.a)this.d).JC();
          }
          if ((this.d instanceof qgr.a))
          {
            localObject1 = (qgr.a)this.d;
            if (((qgr.a)localObject1).a != null)
            {
              localObject1 = ((qgr.a)localObject1).a.mFeedId;
              localObject1 = this.jdField_a_of_type_Qvf.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          ram.w(this.TAG, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Qjq.b().isGameVideo()) {
            rar.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Qjq.b().getVideoGameInfo().id });
          }
          if (!bool3) {
            break label1038;
          }
          if ((!bool1) && (!bool8)) {
            break label962;
          }
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 8 } });
        }
      }
      for (;;)
      {
        b(paramqdu).a((List)localObject1).a().a(new qce(localStoryVideoItem, bool7, (String)localObject2)).a(new qng.h(bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
        bool2 = false;
        break;
        label839:
        bool3 = false;
        break label105;
        label845:
        bool4 = false;
        break label128;
        label851:
        i = 0;
        break label141;
        label856:
        bool1 = false;
        break label324;
        localObject1 = "";
        break label373;
        label877:
        int k;
        if (bool2)
        {
          j = 1;
          k = rar.a(localVideoListFeedItem);
          if (!bool8) {
            break label939;
          }
        }
        label939:
        for (localObject1 = "2";; localObject1 = "1")
        {
          rar.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(rar.a(localQQUserUIItem)), localStoryVideoItem.mVid });
          break;
          j = 2;
          break label877;
        }
        label946:
        localObject2 = localVideoListFeedItem.feedId;
        break label476;
        label956:
        bool7 = false;
        break label488;
        label962:
        if (bool6) {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9, 8 } });
        } else {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9 } });
        }
      }
      label1038:
      if (bool8)
      {
        b(paramqdu).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131720177).a(new qce(localStoryVideoItem, bool7, (String)localObject2)).a(new qng.h(bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        b(paramqdu).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new qce(localStoryVideoItem, bool7, (String)localObject2)).a(new qng.h(bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      b(paramqdu).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131720177).a(new qce(localStoryVideoItem, bool7, (String)localObject2)).a(new qng.h(bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1383:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ram.b(this.TAG, "bindData=%s", paramqjq);
    show();
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramqjq.h == null) || (paramqjq.h.nodeType != 13));
  }
  
  protected qbc b(qdu paramqdu)
  {
    if (paramqdu == null) {}
    for (this.jdField_a_of_type_Qbc = qbc.a(getActivity());; this.jdField_a_of_type_Qbc = qbc.a(getActivity(), paramqdu)) {
      return this.jdField_a_of_type_Qbc;
    }
  }
  
  public void dJ(View paramView)
  {
    new qnh(this);
    this.jj.setOnClickListener(this);
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy()
  {
    if (this.b != null) {
      this.b.stop();
    }
    if (this.jdField_a_of_type_Qng$g != null) {
      b(this.jdField_a_of_type_Qng$g);
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public String getTag()
  {
    return "MoreVideoInfoWidget";
  }
  
  public void l(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Qjq == null) {
      return;
    }
    if (!rpc.hasInternet(QQStoryContext.a().getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, acfp.m(2131708465), 0).show();
      return;
    }
    QQToast.a(getActivity(), acfp.m(2131708462), 0).show();
    new pxy().rz(paramStoryVideoItem.mVid);
    qvi localqvi = (qvi)psx.a(12);
    localqvi.a(this.jdField_a_of_type_Qjq.feedId, 0, paramStoryVideoItem);
    localqvi.a(this.jdField_a_of_type_Qjq.feedId, 1, paramStoryVideoItem);
    paramStoryVideoItem = new pxy.c(new ErrorMessage(), paramStoryVideoItem.mVid);
    pmi.a().dispatch(paramStoryVideoItem);
  }
  
  public void m(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    qvi localqvi = (qvi)psx.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).sH(true);
    }
    localObject = new qnp(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localqvi);
    localObject = aqha.b(getActivity(), 230, 2131559151, acfp.m(2131708452), null, acfp.m(2131708457), acfp.m(2131708464), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((aqju)localObject).setCancelable(false);
    ((aqju)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((aqju)localObject).show();
    rar.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    rar.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Qjq == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Qjq.b();
      if (localStoryVideoItem == null)
      {
        ram.e(this.TAG, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Qjq.vid });
      }
      else
      {
        if (localStoryVideoItem.mStoryType == 2) {}
        boolean bool;
        for (;;)
        {
          bool = e(localStoryVideoItem);
          if (i == 0) {
            break label91;
          }
          a(null);
          break;
          i = 0;
        }
        label91:
        if (qem.c(localStoryVideoItem))
        {
          if ((localStoryVideoItem.isUploadFail()) || (localStoryVideoItem.isUploading())) {
            bpt();
          } else {
            a(null);
          }
        }
        else if (bool) {
          a(null);
        } else {
          bps();
        }
      }
    }
  }
  
  public static class a
    extends QQUIEventReceiver<qng, qem.a>
  {
    public a(@NonNull qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull qem.a parama)
    {
      if (TextUtils.equals(String.valueOf(paramqng.hashCode()), parama.key)) {
        b(paramqng, parama);
      }
    }
    
    public Class acceptEventClass()
    {
      return qem.a.class;
    }
    
    public void b(qng paramqng, qem.a parama)
    {
      paramqng = ((StoryPlayerGroupHolder)paramqng.a()).a();
      if (paramqng != null) {
        paramqng.sH(false);
      }
      if (parama.g == null) {
        return;
      }
      boolean bool = qem.c(parama.g);
      switch (parama.status)
      {
      case 0: 
      default: 
        return;
      case 1: 
        QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131708456), 0).show();
        return;
      case 2: 
        if (bool) {}
        for (paramqng = "2";; paramqng = "1")
        {
          rar.a("play_video", "down_suc", 0, 0, new String[] { paramqng, "", "", parama.g.mVid });
          QQToast.a(BaseApplicationImpl.getContext(), 2, ppf.getString(2131701960), 0).show();
          return;
        }
      }
      if (bool) {}
      for (paramqng = "2";; paramqng = "1")
      {
        rar.a("play_video", "down_fail", 0, 0, new String[] { paramqng, "", "", parama.g.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131708460), 0).show();
        return;
      }
    }
  }
  
  public static class b
    extends pml<qng, pqs>
  {
    public b(qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull pqs parampqs)
    {
      if ((paramqng.a != null) && (TextUtils.equals(paramqng.a.feedId, parampqs.feedId)))
      {
        ram.b(this.TAG, "receive feed info change event. %s.", parampqs.toString());
        paramqng.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull qng paramqng, @NonNull pqs parampqs) {}
  }
  
  public static class c
    extends QQUIEventReceiver<qng, qeu.b>
  {
    public c(@NonNull qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull qeu.b paramb)
    {
      if (!TextUtils.equals(paramb.axg, String.valueOf(paramqng.hashCode()))) {
        return;
      }
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramqng.a()).a();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(false);
      }
      paramqng.bpm();
      if (paramb.b.isSuccess())
      {
        ram.b(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramb.axf);
        if (paramb.f.mIsPicture == 1)
        {
          qeu.a().v(paramqng.getActivity(), paramb.axf);
          return;
        }
        qeu.a().a(paramqng.getActivity(), paramb.axf, paramb.f, paramqng.hashCode());
        return;
      }
      ram.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
      QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131708454), 0).show();
    }
    
    public Class acceptEventClass()
    {
      return qeu.b.class;
    }
  }
  
  public static final class d
    extends QQUIEventReceiver<qng, pxk.a>
  {
    public d(@NonNull qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull pxk.a parama)
    {
      if ((parama.b.isSuccess()) && (parama.mO != null) && (paramqng.a != null))
      {
        parama = parama.mO.iterator();
        while (parama.hasNext())
        {
          ptp localptp = (ptp)parama.next();
          if (TextUtils.equals(paramqng.a.feedId, localptp.feedId)) {
            paramqng.updateUI();
          }
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pxk.a.class;
    }
  }
  
  public static final class e
    extends QQUIEventReceiver<qng, qvf.c>
  {
    public e(@NonNull qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull qvf.c paramc)
    {
      if ((paramc.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramc.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramqng.a != null) && (TextUtils.equals(paramc.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramqng.a.feedId)))
      {
        ram.b(paramqng.TAG, "refresh feed item , feed id :%s", paramqng.a.feedId);
        paramqng.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return qvf.c.class;
    }
  }
  
  public static class f
    extends QQUIEventReceiver<qng, pxs.b>
  {
    public f(@NonNull qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull pxs.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.b(paramqng.TAG, "receive user info event. %s.", paramb.toString());
        paramqng.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  public class g
    extends qjh
  {
    public g() {}
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      Object localObject = qng.this.a();
      if ((localObject == null) || (!qng.this.d.equals(localObject))) {}
      do
      {
        return;
        if (paramInt1 == qng.this.hashCode())
        {
          ram.d(qng.this.TAG, "onActivityResult, onChooseFriendResult");
          localObject = ((StoryPlayerGroupHolder)qng.this.a()).a();
          if (localObject != null) {
            ((VideoViewVideoHolder)localObject).sH(false);
          }
          if (paramInt2 == -1) {
            qeu.a().aU(paramIntent.getExtras());
          }
        }
        if ((paramInt1 == 10002) && (paramInt2 == -1))
        {
          pnx.qU(qng.this.TAG + " onActivityResult");
          QQToast.a(qng.this.getActivity(), qng.this.getActivity().getString(2131720184), 1).show();
        }
        if ((paramInt1 == 467) && (paramInt2 == -1) && (qng.a(qng.this) != null)) {
          qng.a(qng.this).onSuccess();
        }
        if (QLog.isColorLevel()) {
          QLog.d(qng.this.TAG, 2, new Object[] { "MoreVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
        }
      } while (qng.this.a == null);
      qng.this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      if (qng.a(qng.this) != null) {
        qng.a(qng.this).stop();
      }
    }
  }
  
  public class h
    extends qbi
  {
    private long Av;
    private final boolean aEv;
    private final boolean aEw;
    private boolean aEx;
    private boolean aEy;
    private final VideoViewVideoHolder c;
    private final QQUserUIItem jdField_e_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    private final VideoListFeedItem jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
    private final String feedId;
    private final boolean isMine;
    private final StoryVideoItem k;
    
    public h(boolean paramBoolean1, VideoListFeedItem paramVideoListFeedItem, String paramString, StoryVideoItem paramStoryVideoItem, boolean paramBoolean2, VideoViewVideoHolder paramVideoViewVideoHolder, boolean paramBoolean3, QQUserUIItem paramQQUserUIItem, boolean paramBoolean4, long paramLong)
    {
      this.aEv = paramBoolean1;
      this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = paramVideoListFeedItem;
      this.feedId = paramString;
      this.k = paramStoryVideoItem;
      this.isMine = paramBoolean2;
      this.c = paramVideoViewVideoHolder;
      this.aEw = paramBoolean3;
      this.jdField_e_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramQQUserUIItem;
      this.aEy = paramBoolean4;
      this.Av = paramLong;
    }
    
    public void bnD()
    {
      super.bnD();
      ram.d(qng.this.TAG, "OnSimpleShareListenerImpl onShowUI");
      if (this.c != null) {
        this.c.sH(true);
      }
    }
    
    public void onDismiss()
    {
      super.onDismiss();
      ram.d(qng.this.TAG, "OnSimpleShareListenerImpl onDismiss");
      if ((this.c != null) && (!this.aEx)) {
        this.c.sH(false);
      }
      this.aEx = false;
    }
    
    public void onFinish()
    {
      super.onFinish();
      ram.d(qng.this.TAG, "OnSimpleShareListenerImpl onFinish");
      if (this.c != null) {
        this.c.sH(false);
      }
    }
    
    public void onSuccess(int paramInt)
    {
      super.onSuccess(paramInt);
      ram.d(qng.this.TAG, "OnSimpleShareListenerImpl onSuccess");
      if (this.aEv)
      {
        rar.a("host_share", "suc_share", 3, paramInt, new String[] { String.valueOf(rar.b(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.feedId, this.k.mVid });
        switch (paramInt)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          label128:
          if (this.k.getVideoGameInfo() != null)
          {
            if (!this.isMine) {
              break label812;
            }
            if (this.k.getVideoGameInfo().type != 1) {
              break label807;
            }
            paramInt = 1;
          }
          break;
        }
      }
      for (;;)
      {
        rar.a("video_game", "share_game", 0, 0, new String[] { String.valueOf(paramInt), "", "", this.k.getVideoGameInfo().id, this.k.mVid });
        return;
        rar.a("host_share", "suc_share", 1, paramInt, new String[] { String.valueOf(rar.b(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.feedId, this.k.mVid });
        break;
        label275:
        String str1;
        if (this.aEw)
        {
          paramInt = 1;
          if (!this.isMine) {
            break label346;
          }
          str1 = "2";
          label285:
          if (!this.aEy) {
            break label352;
          }
        }
        label346:
        label352:
        for (String str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
        {
          rar.a("play_video", "guest_share_suc", paramInt, 1, new String[] { str1, str2, this.feedId, this.k.mVid });
          break;
          paramInt = 2;
          break label275;
          str1 = "1";
          break label285;
        }
        if (this.aEw)
        {
          paramInt = 1;
          label375:
          if (!this.isMine) {
            break label446;
          }
          str1 = "2";
          label385:
          if (!this.aEy) {
            break label452;
          }
        }
        label446:
        label452:
        for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
        {
          rar.a("play_video", "guest_share_suc", paramInt, 2, new String[] { str1, str2, this.feedId, this.k.mVid });
          break;
          paramInt = 2;
          break label375;
          str1 = "1";
          break label385;
        }
        if (this.aEw)
        {
          paramInt = 1;
          label475:
          if (!this.isMine) {
            break label546;
          }
          str1 = "2";
          label485:
          if (!this.aEy) {
            break label552;
          }
        }
        label546:
        label552:
        for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
        {
          rar.a("play_video", "guest_share_suc", paramInt, 3, new String[] { str1, str2, this.feedId, this.k.mVid });
          break;
          paramInt = 2;
          break label475;
          str1 = "1";
          break label485;
        }
        if (this.aEw)
        {
          paramInt = 1;
          label575:
          if (!this.isMine) {
            break label646;
          }
          str1 = "2";
          label585:
          if (!this.aEy) {
            break label652;
          }
        }
        label646:
        label652:
        for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
        {
          rar.a("play_video", "guest_share_suc", paramInt, 4, new String[] { str1, str2, this.feedId, this.k.mVid });
          break;
          paramInt = 2;
          break label575;
          str1 = "1";
          break label585;
        }
        if (this.aEw)
        {
          paramInt = 1;
          label675:
          if (!this.isMine) {
            break label746;
          }
          str1 = "2";
          label685:
          if (!this.aEy) {
            break label752;
          }
        }
        label746:
        label752:
        for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
        {
          rar.a("play_video", "guest_share_suc", paramInt, 5, new String[] { str1, str2, this.feedId, this.k.mVid });
          break;
          paramInt = 2;
          break label675;
          str1 = "1";
          break label685;
        }
        rar.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", this.k.mVid });
        break label128;
        label807:
        paramInt = 3;
        continue;
        label812:
        if (this.k.getVideoGameInfo().type == 1) {
          paramInt = 2;
        } else {
          paramInt = 4;
        }
      }
    }
    
    public void vU(int paramInt)
    {
      super.vU(paramInt);
      this.aEx = true;
      ram.d(qng.this.TAG, "OnSimpleShareListenerImpl onChooseShareChannel");
      if (this.aEv) {
        rar.a("host_share", "share_chanel", 3, paramInt, new String[] { String.valueOf(rar.b(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.feedId, this.k.mVid });
      }
      for (;;)
      {
        switch (paramInt)
        {
        case 6: 
        default: 
          return;
          rar.a("host_share", "share_chanel", 1, paramInt, new String[] { String.valueOf(rar.b(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.feedId, this.k.mVid });
        }
      }
      if (this.aEw)
      {
        paramInt = 1;
        if (!this.isMine) {
          break label268;
        }
        str1 = "2";
        label207:
        if (!this.aEy) {
          break label274;
        }
      }
      label268:
      label274:
      for (String str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        rar.a("play_video", "guest_share", paramInt, 1, new String[] { str1, str2, this.feedId, this.k.mVid });
        return;
        paramInt = 2;
        break;
        str1 = "1";
        break label207;
      }
      if (this.aEw)
      {
        paramInt = 1;
        if (!this.isMine) {
          break label369;
        }
        str1 = "2";
        label308:
        if (!this.aEy) {
          break label375;
        }
      }
      label369:
      label375:
      for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        rar.a("play_video", "guest_share", paramInt, 2, new String[] { str1, str2, this.feedId, this.k.mVid });
        return;
        paramInt = 2;
        break;
        str1 = "1";
        break label308;
      }
      if (this.aEw)
      {
        paramInt = 1;
        if (!this.isMine) {
          break label470;
        }
        str1 = "2";
        label409:
        if (!this.aEy) {
          break label476;
        }
      }
      label470:
      label476:
      for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        rar.a("play_video", "guest_share", paramInt, 3, new String[] { str1, str2, this.feedId, this.k.mVid });
        return;
        paramInt = 2;
        break;
        str1 = "1";
        break label409;
      }
      if (this.aEw)
      {
        paramInt = 1;
        if (!this.isMine) {
          break label571;
        }
        str1 = "2";
        label510:
        if (!this.aEy) {
          break label577;
        }
      }
      label571:
      label577:
      for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        rar.a("play_video", "guest_share", paramInt, 4, new String[] { str1, str2, this.feedId, this.k.mVid });
        return;
        paramInt = 2;
        break;
        str1 = "1";
        break label510;
      }
      if (this.aEw)
      {
        paramInt = 1;
        if (!this.isMine) {
          break label672;
        }
        str1 = "2";
        label611:
        if (!this.aEy) {
          break label678;
        }
      }
      label672:
      label678:
      for (str2 = String.valueOf(this.Av);; str2 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)))
      {
        rar.a("play_video", "guest_share", paramInt, 5, new String[] { str1, str2, this.feedId, this.k.mVid });
        return;
        paramInt = 2;
        break;
        str1 = "1";
        break label611;
      }
      if (qeu.a().Jr()) {
        QQToast.a(qng.this.getActivity(), 0, acfp.m(2131708468), 0).show();
      }
      for (;;)
      {
        rar.a("play_video", "share_friend", 0, 0, new String[] { "", "", "", this.k.mVid });
        return;
        if (TextUtils.isEmpty(this.k.mLocalVideoPath))
        {
          QQToast.a(qng.this.getActivity(), 1, acfp.m(2131708463), 0).show();
          ram.e(qng.this.TAG, "send video to friend failed because videoLocalPath is empty.");
        }
        else
        {
          qng.this.a("", true, 300L);
          qeu.a().a(this.k, String.valueOf(qng.this.hashCode()));
        }
      }
      if (qeu.a().Jr())
      {
        QQToast.a(qng.this.getActivity(), 0, acfp.m(2131708467), 0).show();
        return;
      }
      if (TextUtils.isEmpty(this.k.mLocalVideoPath))
      {
        ram.w(qng.this.TAG, "save video -info local file not exist , start download , vid:%s", new Object[] { this.k.mVid });
        qng.a(qng.this).a(this.k.mVid, 0, false, new qns(this));
        paramInt = qng.this.getVideoSource();
        str2 = qng.this.a(this.k);
        if (this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) {
          break label1088;
        }
        str1 = "";
        label975:
        rar.a("story_grp", "clk_one", paramInt, 0, new String[] { "3", str2, "", str1 });
        if (!this.isMine) {
          break label1099;
        }
      }
      label1088:
      label1099:
      for (String str1 = "2";; str1 = "1")
      {
        rar.a("play_video", "clk_download", 0, 0, new String[] { str1 });
        return;
        ram.w(qng.this.TAG, "save video -info local file exist , start watermark , vid:%s", new Object[] { this.k.mVid });
        qem.a(this.k, this.k.mStoryType, String.valueOf(qng.this.hashCode()));
        break;
        str1 = this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId;
        break label975;
      }
      qem.a(qng.this.getActivity(), this.k, new qnt(this));
      int i;
      if (this.aEw)
      {
        paramInt = 1;
        if (!this.aEy) {
          break label1253;
        }
        i = (int)this.Av;
        label1149:
        if (this.jdField_e_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {
          break label1258;
        }
        str1 = "4";
        label1160:
        rar.a("play_video", "more_report", paramInt, i, new String[] { "", str1 });
        paramInt = qng.this.getVideoSource();
        str2 = qng.this.a(this.k);
        if (this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) {
          break label1272;
        }
      }
      label1253:
      label1258:
      label1272:
      for (str1 = "";; str1 = this.jdField_e_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId)
      {
        rar.a("story_grp", "clk_one", paramInt, 0, new String[] { "7", str2, "", str1 });
        return;
        paramInt = 2;
        break;
        i = 0;
        break label1149;
        str1 = String.valueOf(rar.a(this.jdField_e_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
        break label1160;
      }
      qng.this.m(this.k);
      return;
      qng.this.l(this.k);
      rar.a("play_video", "not_like", qng.this.getVideoSource(), 0, new String[] { "", "", "", this.k.mVid });
    }
  }
  
  public static abstract interface i
  {
    public abstract void onSuccess();
  }
  
  public static class j
    extends QQUIEventReceiver<qng, psg>
  {
    public j(@NonNull qng paramqng)
    {
      super();
    }
    
    public void a(@NonNull qng paramqng, @NonNull psg parampsg)
    {
      paramqng.bpm();
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramqng.a()).a();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(false);
      }
      ram.d(this.TAG, "delete onEvent");
      if ((!parampsg.aBu) && (parampsg.b.isFail()))
      {
        if (QLog.isColorLevel()) {
          ram.w(this.TAG, "删除失败：%s", new Object[] { parampsg.getErrorMessage() });
        }
        QQToast.a(paramqng.getActivity(), 1, acfp.m(2131708453), 0).show();
      }
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qng
 * JD-Core Version:    0.7.0.1
 */