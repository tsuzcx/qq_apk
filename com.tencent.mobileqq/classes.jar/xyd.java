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

public class xyd
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public blir a;
  private wlg jdField_a_of_type_Wlg = new wlg();
  protected xfj a;
  private xyv jdField_a_of_type_Xyv;
  private xyz jdField_a_of_type_Xyz;
  private final yme jdField_a_of_type_Yme;
  private View b;
  
  public xyd(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((wtt)wth.a(2)).c(paramStoryVideoItem.mOwnerUid);
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
      yuk.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      yuk.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
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
    localObject = new xyl(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = bhlq.a(b(), 230, 2131559008, anzj.a(2131705777), null, anzj.a(2131705775), anzj.a(2131705782), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bhpc)localObject).setCancelable(false);
    ((bhpc)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bhpc)localObject).show();
    yup.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    yup.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Xqz == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    blir localblir;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_Xqz.a();
      localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
      localQQUserUIItem = ((wtt)wth.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = xiz.a(localStoryVideoItem);
      localblir = (blir)blji.b(b(), null);
      localblir.a(anzj.a(2131705774), 5);
      localblir.c(2131690580);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localblir.a(new xyf(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localblir));
      localblir.a(new xyh(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localblir.isShowing());
    localblir.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = yup.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      yup.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(yup.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xqz == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      blir localblir;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
        localblir = (blir)blji.b(b(), null);
        localblir.a(anzj.a(2131705771), 5);
        localblir.c(2131690580);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localblir.a(new xyi(this, localStoryVideoItem, localAtomicBoolean, localblir));
        localblir.a(new xyj(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localblir.isShowing());
      localblir.show();
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
  
  protected xfj a(xie paramxie)
  {
    if (paramxie == null) {}
    for (this.jdField_a_of_type_Xfj = xfj.a(b());; this.jdField_a_of_type_Xfj = xfj.a(b(), paramxie)) {
      return this.jdField_a_of_type_Xfj;
    }
  }
  
  public void a(View paramView)
  {
    new xye(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_Xqz == null) {
      return;
    }
    if (!zot.a(QQStoryContext.a().a()))
    {
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, anzj.a(2131705781), 0).a();
      return;
    }
    QQToast.a(b(), anzj.a(2131705778), 0).a();
    new xbf().a(paramStoryVideoItem.mVid);
    ymk localymk = (ymk)wth.a(12);
    localymk.a(this.jdField_a_of_type_Xqz.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localymk.a(this.jdField_a_of_type_Xqz.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new xbi(new ErrorMessage(), paramStoryVideoItem.mVid);
    wjj.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xza(this), "");
    paramMap.put(new xys(this), "");
    paramMap.put(new xyq(this), "");
    paramMap.put(new xyr(this), "");
    paramMap.put(new xyt(this), "");
    paramMap.put(new xyp(this), "");
    paramMap.put(new xyu(this), "");
    this.jdField_a_of_type_Xyv = new xyv(this);
    a(this.jdField_a_of_type_Xyv);
  }
  
  public void a(xie paramxie)
  {
    if (this.jdField_a_of_type_Xqz == null) {
      return;
    }
    Object localObject1 = (wtt)wth.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
    if (localStoryVideoItem == null)
    {
      yuk.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xqz.a();
    QQUserUIItem localQQUserUIItem = ((wtt)localObject1).b(localStoryVideoItem.mOwnerUid);
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
      bool8 = xiz.a(localStoryVideoItem);
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
      if ((this.jdField_a_of_type_Xms instanceof xng))
      {
        localObject1 = ((xng)this.jdField_a_of_type_Xms).jdField_a_of_type_Wvn;
        bool1 = wwg.a(QQStoryContext.a()).a(((xng)this.jdField_a_of_type_Xms).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((wvn)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1383;
      }
      localObject1 = ((ydc)wth.a(7)).a(b());
      if (localObject1 == null) {
        break label1383;
      }
      localObject2 = ((TroopManager)xiz.a().getManager(52)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = xiz.a().getCurrentAccountUin();
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
          yup.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new xyk(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
            this.jdField_a_of_type_Blir.dismiss();
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
          if ((this.jdField_a_of_type_Xms instanceof xng)) {
            ((xng)this.jdField_a_of_type_Xms).a();
          }
          if ((this.jdField_a_of_type_Xms instanceof xmh))
          {
            localObject1 = (xmh)this.jdField_a_of_type_Xms;
            if (((xmh)localObject1).a != null)
            {
              localObject1 = ((xmh)localObject1).a.jdField_a_of_type_JavaLangString;
              localObject1 = this.jdField_a_of_type_Yme.a((String)localObject1, true);
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          yuk.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_Xqz.a().isGameVideo()) {
            yup.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_Xqz.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
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
        a(paramxie).a((List)localObject1).a().a(new xgl(localStoryVideoItem, bool7, (String)localObject2)).a(new xyw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
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
          k = yup.a(localVideoListFeedItem);
          if (!bool8) {
            break label933;
          }
        }
        label933:
        for (localObject1 = "2";; localObject1 = "1")
        {
          yup.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(yup.a(localQQUserUIItem)), localStoryVideoItem.mVid });
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
        a(paramxie).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131718159).a(new xgl(localStoryVideoItem, bool7, (String)localObject2)).a(new xyw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramxie).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new xgl(localStoryVideoItem, bool7, (String)localObject2)).a(new xyw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      paramxie = a(paramxie);
      localObject1 = new int[] { 6, 9 };
      paramxie.a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, localObject1 })).a(2131718159).a(new xgl(localStoryVideoItem, bool7, (String)localObject2)).a(new xyw(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1383:
      bool1 = false;
      bool6 = false;
    }
  }
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    yuk.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramxqz);
    j();
  }
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramxqz.jdField_a_of_type_Wvn == null) || (paramxqz.jdField_a_of_type_Wvn.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    ymk localymk = (ymk)wth.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new xym(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localymk);
    localObject = bhlq.a(b(), 230, 2131559008, anzj.a(2131705768), null, anzj.a(2131705773), anzj.a(2131705780), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((bhpc)localObject).setCancelable(false);
    ((bhpc)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((bhpc)localObject).show();
    yup.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    yup.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Wlg != null) {
      this.jdField_a_of_type_Wlg.a();
    }
    if (this.jdField_a_of_type_Xyv != null) {
      b(this.jdField_a_of_type_Xyv);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Xqz == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
      if (localStoryVideoItem == null)
      {
        yuk.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString });
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
        if (xiz.a(localStoryVideoItem))
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
 * Qualified Name:     xyd
 * JD-Core Version:    0.7.0.1
 */