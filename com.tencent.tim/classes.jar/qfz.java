import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.4;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class qfz
  implements qig
{
  private static qle jdField_a_of_type_Qle;
  private long AK;
  private QQStoryVideoPlayerErrorView jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
  private OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private QQStoryLoadingView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
  private qfz.a jdField_a_of_type_Qfz$a;
  private qfz.b jdField_a_of_type_Qfz$b;
  qgy.e jdField_a_of_type_Qgy$e = new qga(this);
  private qgy.f jdField_a_of_type_Qgy$f;
  private qgy jdField_a_of_type_Qgy;
  qiw jdField_a_of_type_Qiw = new qgb(this);
  private qjk jdField_a_of_type_Qjk;
  private qoh jdField_a_of_type_Qoh;
  private qvf jdField_a_of_type_Qvf = (qvf)psx.a(11);
  private boolean aDi;
  private boolean aDj;
  private boolean aDk;
  private boolean aDl = true;
  private String axo;
  private qgy.c b;
  private int blZ;
  private Runnable dr = new StoryPlayerImpl.4(this);
  protected AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new qgc(this);
  protected AudioManager mAudioManager;
  private int mErrorCode;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean uA;
  
  private boolean Jt()
  {
    if ((this.jdField_a_of_type_Qgy$f.d != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qgy$f.feedId)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qgy$f.vid)))
    {
      ram.b("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Qgy$f.d.groupId, this.jdField_a_of_type_Qgy$f.vid);
      ArrayList localArrayList = new ArrayList();
      qgy.a locala = new qgy.a();
      if ((this.jdField_a_of_type_Qgy$f.a != null) && (TextUtils.equals(this.jdField_a_of_type_Qgy$f.a.d.groupId, this.jdField_a_of_type_Qgy$f.d.groupId)) && (this.jdField_a_of_type_Qgy$f.a.nv.size() > 0))
      {
        ram.b("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Qgy$f.d.groupId, this.jdField_a_of_type_Qgy$f.vid);
        this.jdField_a_of_type_Qgy$f.a.axq = this.jdField_a_of_type_Qgy$f.vid;
        localArrayList.add(this.jdField_a_of_type_Qgy$f.a);
        locala.aDp = false;
      }
      for (locala.aDq = false;; locala.aDq = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        locala.aDr = true;
        locala.nP = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Qjk.a(locala, this.jdField_a_of_type_Qgy$f.d);
        return true;
        ram.b("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Qgy$f.d.groupId, this.jdField_a_of_type_Qgy$f.vid);
        qgy.d locald = new qgy.d(this.jdField_a_of_type_Qgy$f.d);
        locald.nv = new ArrayList();
        locald.nv.add(this.jdField_a_of_type_Qgy$f.vid);
        locald.fR.put(this.jdField_a_of_type_Qgy$f.vid, this.jdField_a_of_type_Qgy$f.feedId);
        locald.axq = this.jdField_a_of_type_Qgy$f.vid;
        localArrayList.add(locald);
        locala.aDp = false;
      }
    }
    return false;
  }
  
  private void a(qjw paramqjw)
  {
    if (paramqjw == null) {}
    label403:
    label414:
    label432:
    for (;;)
    {
      return;
      int i = paramqjw.bmn;
      int j = paramqjw.bmB;
      ram.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramqjw.a);
      Object localObject = this.jdField_a_of_type_Qjk.be();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (qgy.d)((List)localObject).get(i);
        if ((localObject instanceof qjr)) {
          break label414;
        }
        localObject = ((qgy.d)localObject).d;
        if (localObject == null) {
          break label403;
        }
        if (!((qgy.c)localObject).equals(this.jdField_a_of_type_Qgy$f.d))
        {
          b(this.jdField_a_of_type_Qgy$f.d, this.jdField_a_of_type_Qgy$f.vid);
          this.jdField_a_of_type_Qgy$f.d = ((qgy.c)localObject);
        }
        ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Qgy$f });
        this.mHandler.removeCallbacks(this.dr);
        this.mHandler.postDelayed(this.dr, 500L);
      }
      for (;;)
      {
        if (!paramqjw.a.JM()) {
          break label432;
        }
        localObject = paramqjw.c.d;
        String str = paramqjw.a.vid;
        this.jdField_a_of_type_Qgy$f.feedId = paramqjw.a.feedId;
        this.jdField_a_of_type_Qgy$f.vid = paramqjw.a.vid;
        if ((localObject instanceof qhc.a))
        {
          ((qhc.a)localObject).bmq = j;
          if (this.jdField_a_of_type_Qgy$f.a != null) {
            this.jdField_a_of_type_Qgy$f.a.bmp = j;
          }
        }
        if ((str.equals(this.axo)) && (((qgy.c)localObject).equals(this.b))) {
          break;
        }
        this.b = ((qgy.c)localObject);
        this.axo = str;
        ram.d("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((qgy.c)localObject).groupId, str);
        this.jdField_a_of_type_Qgy.c((qgy.c)localObject, str);
        this.jdField_a_of_type_Qoh.d((qgy.c)localObject, str);
        paramqjw = (qjs)paramqjw.c.b(qjs.class);
        if (paramqjw != null) {
          paramqjw.rF(str);
        }
        pmi.a().dispatch(new qiy(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (qgy.c)localObject, str));
        return;
        ram.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.aDk = true;
        this.aDl = ((qjr)localObject).aDI;
      }
    }
  }
  
  private void b(qgy.c paramc, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      pmi.a().dispatch(new pvv.g(paramc, paramString));
      if (paramString != null) {
        break label44;
      }
    }
    label44:
    for (String str = "";; str = paramString)
    {
      ram.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramc, paramString, str);
      return;
    }
  }
  
  private void boh()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Qgy$f });
    if (!this.aDj)
    {
      this.aDj = true;
      this.jdField_a_of_type_Qgy.a(this.jdField_a_of_type_Qgy$e);
    }
    this.jdField_a_of_type_Qgy.a(this.jdField_a_of_type_Qgy$f.d, 2, 5, this.jdField_a_of_type_Qgy$f.vid);
    this.jdField_a_of_type_Qgy.a(this.jdField_a_of_type_Qgy$f.d, 0, 5, this.jdField_a_of_type_Qgy$f.vid);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Qgy$f.feedId))
    {
      this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qgy$f.feedId, true);
      this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qgy$f.feedId);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Qgy$f.vid))
    {
      ((psu)psx.a(5)).a(this.jdField_a_of_type_Qgy$f.vid);
      qgt.rH(this.jdField_a_of_type_Qgy$f.vid);
    }
  }
  
  private void boi()
  {
    String str = "0";
    int i;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.tW() == 0)))
    {
      i = 200;
      str = "11" + "*";
      str = str + String.valueOf(SystemClock.uptimeMillis() - this.AK);
    }
    for (;;)
    {
      if (i != 0) {
        rar.b("play_video", "play_result", this.jdField_a_of_type_Qfz$a.a().mReportData.from, i, new String[] { str, "0", rar.getNetworkType(this.jdField_a_of_type_Qfz$a.n()), "NO_VID" });
      }
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0))
      {
        i = this.mErrorCode;
        str = String.valueOf(this.blZ);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void initData()
  {
    this.jdField_a_of_type_Qgy = qhq.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Qgy == null)
    {
      ram.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Qfz$b.finish();
      return;
    }
    this.jdField_a_of_type_Qgy.create();
    this.jdField_a_of_type_Qoh = new qoh(this.jdField_a_of_type_Qgy);
    this.jdField_a_of_type_Qoh.create();
  }
  
  private void p(RelativeLayout paramRelativeLayout)
  {
    ram.d("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Qgy.b();
    this.jdField_a_of_type_Qgy$f = new qgy.f((qgy.f)localObject);
    this.jdField_a_of_type_Qjk = new qjk(paramRelativeLayout);
    qjk localqjk = this.jdField_a_of_type_Qjk;
    localObject = new qfz.a(this.jdField_a_of_type_Qfz$b, this.jdField_a_of_type_Qjk.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (qgy.f)localObject, null);
    this.jdField_a_of_type_Qfz$a = ((qfz.a)localObject);
    localqjk.a((qji)localObject);
    this.jdField_a_of_type_Qjk.onCreate();
    this.jdField_a_of_type_Qjk.a(this.jdField_a_of_type_Qiw);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370787));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131381769));
    if (Jt())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.mHandler.postDelayed(this.dr, 1000L);
      return;
    }
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Qgy$f });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.dr.run();
  }
  
  private void updateData()
  {
    ram.b("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Qgy$f);
    qgy.a locala = this.jdField_a_of_type_Qgy.a(this.jdField_a_of_type_Qgy$f.d, 3);
    if (((locala.g != null) && (locala.g.isFail())) || ((locala.h != null) && (locala.h.isFail()) && (locala.nP.isEmpty())))
    {
      ram.w("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { locala.g, locala.h });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.mErrorCode = 9;
      if (locala.g != null) {
        i = locala.g.errorCode;
      }
      for (;;)
      {
        this.blZ = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.wh(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new qgd(this));
        return;
        if (locala.h != null) {
          i = locala.h.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (locala.nP.isEmpty())
    {
      ram.w("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(locala.aDp), Boolean.valueOf(locala.aDq) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = locala.nP.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        qgy.d locald = (qgy.d)locala.nP.get(i);
        if (!TextUtils.equals(locald.d.groupId, this.jdField_a_of_type_Qgy$f.d.groupId)) {
          break label521;
        }
        ram.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", locald.d.groupId, locald.axq, this.jdField_a_of_type_Qgy$f.vid);
        if ((TextUtils.isEmpty(locald.axq)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qgy$f.vid))) {
          locald.axq = this.jdField_a_of_type_Qgy$f.vid;
        }
        if (this.aDk)
        {
          if (!this.aDl) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Qgy$f.d = ((qgy.d)locala.nP.get(i - 1)).d;
            this.aDk = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        locala.aDr = false;
        this.jdField_a_of_type_Qjk.a(locala, this.jdField_a_of_type_Qgy$f.d);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Qgy$f.d = ((qgy.d)locala.nP.get(i + 1)).d;
          this.aDk = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  public boolean Js()
  {
    return this.jdField_a_of_type_Qjk.Js();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      ram.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Qfz$b.finish();
      return;
    }
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Qle == null)
    {
      ram.w("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Qle = new qle(this.jdField_a_of_type_Qfz$b.getContext());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    initData();
    p((RelativeLayout)this.jdField_a_of_type_Qfz$b.getRootView().findViewById(2131377546));
    if (this.jdField_a_of_type_Qfz$a != null) {
      this.jdField_a_of_type_Qfz$a.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (pnm)psx.a(6);
    if (!paramBundle1.Iy())
    {
      paramBundle1.blW();
      this.aDi = true;
    }
    this.mAudioManager = ((AudioManager)this.jdField_a_of_type_Qfz$b.getContext().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new qge(this));
  }
  
  public void a(qfz.b paramb)
  {
    if ((this.jdField_a_of_type_Qfz$b != null) || (paramb == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Qfz$b = paramb;
  }
  
  public void ahH()
  {
    if (this.mAudioManager == null) {}
    for (;;)
    {
      return;
      try
      {
        int j = this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 2);
        int i = j;
        if (j == 0) {
          i = this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
        if (i == 0)
        {
          this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 3);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void bog()
  {
    if (this.jdField_a_of_type_Qgy$f != null)
    {
      b(this.jdField_a_of_type_Qgy$f.d, this.jdField_a_of_type_Qgy$f.vid);
      ram.d("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Qjk != null) {
      this.jdField_a_of_type_Qjk.bog();
    }
  }
  
  public void boj()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    if (jdField_a_of_type_Qle != null)
    {
      ram.w("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Qle.destroy();
      jdField_a_of_type_Qle = null;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ram.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Qfz$a != null) {
      this.jdField_a_of_type_Qfz$a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Qjk != null) {
      this.jdField_a_of_type_Qjk.boy();
    }
    if (this.jdField_a_of_type_Qgy != null) {
      this.jdField_a_of_type_Qgy.destroy();
    }
    if (this.jdField_a_of_type_Qoh != null) {
      this.jdField_a_of_type_Qoh.destroy();
    }
    if (this.jdField_a_of_type_Qfz$a != null) {
      this.jdField_a_of_type_Qfz$a.onDestroy();
    }
    if (this.aDi) {
      ((pnm)psx.a(6)).ff(15000L);
    }
    pnr.a().blX();
  }
  
  public void onPause()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.uA = false;
    if (this.jdField_a_of_type_Qfz$a != null) {
      this.jdField_a_of_type_Qfz$a.onPause();
    }
    if (this.mAudioManager != null) {
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
    }
  }
  
  public void onResume()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.uA = true;
    if (this.jdField_a_of_type_Qfz$a != null) {
      this.jdField_a_of_type_Qfz$a.onResume();
    }
    ahH();
    qln.a(this.jdField_a_of_type_Qfz$b.getContext()).boT();
  }
  
  public void onStart()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Qfz$a != null) {
      this.jdField_a_of_type_Qfz$a.onStart();
    }
    this.AK = SystemClock.uptimeMillis();
  }
  
  public void onStop()
  {
    ram.w("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Qfz$a != null)
    {
      this.jdField_a_of_type_Qfz$a.onStop();
      boi();
    }
  }
  
  class a
    extends qji
    implements qig
  {
    private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    private final qjb jdField_a_of_type_Qjb;
    qjp jdField_a_of_type_Qjp = new qjp();
    private final boolean aDm = true;
    private boolean aDn;
    private final Set<pmd> aL = new HashSet();
    private final OpenPlayerBuilder.Data jdField_b_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
    private final CopyOnWriteArraySet<qig> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    private final qfz.b jdField_b_of_type_Qfz$b;
    private final qgy.f jdField_b_of_type_Qgy$f;
    pmd d = new qgf(this);
    
    private a(qfz.b paramb, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, qgy.f paramf)
    {
      this$1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((qfz.this instanceof QQAppInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)qfz.this);
        this.jdField_b_of_type_Qfz$b = paramb;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
        this.jdField_b_of_type_Qgy$f = new qgy.f(paramf);
        this.jdField_a_of_type_Qjb = qjb.a(this);
        ram.w("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(true) });
        return;
      }
      throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
    }
    
    public boolean Ju()
    {
      return this.aDn;
    }
    
    public boolean Jv()
    {
      return true;
    }
    
    public OpenPlayerBuilder.Data a()
    {
      return this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
    }
    
    public XViewPager a()
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    }
    
    public qgy.c a()
    {
      return qfz.a(qfz.this).a();
    }
    
    public qgy.f a()
    {
      return this.jdField_b_of_type_Qgy$f;
    }
    
    public qjb a()
    {
      return this.jdField_a_of_type_Qjb;
    }
    
    public qjp a()
    {
      return this.jdField_a_of_type_Qjp;
    }
    
    public void a(Bundle paramBundle1, Bundle paramBundle2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.d, false);
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).a(paramBundle1, paramBundle2);
      }
    }
    
    public void a(pmd parampmd)
    {
      this.aL.add(parampmd);
    }
    
    public void a(qig paramqig)
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramqig);
    }
    
    public void b(pmd parampmd)
    {
      this.aL.remove(parampmd);
    }
    
    public void b(qig paramqig)
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramqig);
    }
    
    public void b(qjw paramqjw)
    {
      if (qfz.a(qfz.this).a(paramqjw)) {
        qfz.a(qfz.this, paramqjw);
      }
    }
    
    public void bol()
    {
      qfz.a(qfz.this).removeCallbacks(qfz.a(qfz.this));
      qfz.a(qfz.this).postDelayed(qfz.a(qfz.this), 500L);
    }
    
    public String fX(String paramString)
    {
      return qfz.a(qfz.this).fX(paramString);
    }
    
    public Activity n()
    {
      return this.jdField_b_of_type_Qfz$b.getActivity();
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      Iterator localIterator = new HashSet(this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    
    public void onDestroy()
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.d);
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).onDestroy();
      }
    }
    
    public void onPause()
    {
      this.aDn = false;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).onPause();
      }
    }
    
    public void onResume()
    {
      this.aDn = true;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).onResume();
      }
    }
    
    public void onStart()
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).onStart();
      }
    }
    
    public void onStop()
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        ((qig)localIterator.next()).onStop();
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      this.jdField_b_of_type_Qfz$b.startActivity(paramIntent);
    }
  }
  
  public static abstract interface b
  {
    public abstract void finish();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract View getRootView();
    
    public abstract void startActivity(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfz
 * JD-Core Version:    0.7.0.1
 */