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
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class tia
  implements tmd
{
  private static tqs jdField_a_of_type_Tqs;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected AudioManager.OnAudioFocusChangeListener a;
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private QQStoryVideoPlayerErrorView jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
  private OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private QQStoryLoadingView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryPlayerImpl.4(this);
  private String jdField_a_of_type_JavaLangString;
  private tig jdField_a_of_type_Tig;
  private tii jdField_a_of_type_Tii;
  private tjp jdField_a_of_type_Tjp;
  private tjs jdField_a_of_type_Tjs;
  tju jdField_a_of_type_Tju = new tib(this);
  private tjv jdField_a_of_type_Tjv;
  tmy jdField_a_of_type_Tmy = new tic(this);
  private tnp jdField_a_of_type_Tnp;
  private twt jdField_a_of_type_Twt;
  private uje jdField_a_of_type_Uje = (uje)sqg.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public tia()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new tid(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    urk.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Tjp.a();
    this.jdField_a_of_type_Tjv = new tjv((tjv)localObject);
    this.jdField_a_of_type_Tnp = new tnp(paramRelativeLayout);
    tnp localtnp = this.jdField_a_of_type_Tnp;
    localObject = new tig(this, this.jdField_a_of_type_Tii, this.jdField_a_of_type_Tnp.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (tjv)localObject, null);
    this.jdField_a_of_type_Tig = ((tig)localObject);
    localtnp.a((tnn)localObject);
    this.jdField_a_of_type_Tnp.c();
    this.jdField_a_of_type_Tnp.a(this.jdField_a_of_type_Tmy);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131303812));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131313207));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Tjv });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(tjs paramtjs, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      sgi.a().dispatch(new suy(paramtjs, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      urk.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramtjs, paramString, str);
      return;
    }
  }
  
  private void a(tog paramtog)
  {
    if (paramtog == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramtog.jdField_a_of_type_Int;
      int j = paramtog.jdField_b_of_type_Int;
      urk.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramtog.jdField_a_of_type_Tnz);
      Object localObject = this.jdField_a_of_type_Tnp.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (tjt)((List)localObject).get(i);
        if ((localObject instanceof toa)) {
          break label413;
        }
        localObject = ((tjt)localObject).jdField_a_of_type_Tjs;
        if (localObject == null) {
          break label402;
        }
        if (!((tjs)localObject).equals(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs))
        {
          a(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs = ((tjs)localObject);
        }
        urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Tjv });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramtog.jdField_a_of_type_Tnz.c()) {
          break label431;
        }
        localObject = paramtog.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Tjs;
        String str = paramtog.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Tjv.b = paramtog.jdField_a_of_type_Tnz.b;
        this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString = paramtog.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof tkg))
        {
          ((tkg)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt != null) {
            this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((tjs)localObject).equals(this.jdField_a_of_type_Tjs))) {
          break;
        }
        this.jdField_a_of_type_Tjs = ((tjs)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        urk.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((tjs)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Tjp.a((tjs)localObject, str);
        this.jdField_a_of_type_Twt.a((tjs)localObject, str);
        paramtog = (tob)paramtog.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(tob.class);
        if (paramtog != null) {
          paramtog.a(str);
        }
        sgi.a().dispatch(new tna(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (tjs)localObject, str));
        return;
        urk.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((toa)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tjv.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString)))
    {
      urk.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      tjq localtjq = new tjq();
      if ((this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt != null) && (TextUtils.equals(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        urk.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjt);
        localtjq.jdField_a_of_type_Boolean = false;
      }
      for (localtjq.jdField_b_of_type_Boolean = false;; localtjq.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localtjq.c = true;
        localtjq.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Tnp.a(localtjq, this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs);
        return true;
        urk.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
        tjt localtjt = new tjt(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs);
        localtjt.jdField_a_of_type_JavaUtilList = new ArrayList();
        localtjt.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
        localtjt.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.b);
        localtjt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString;
        localArrayList.add(localtjt);
        localtjq.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Tjp = tkz.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Tjp == null)
    {
      urk.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Tii.finish();
      return;
    }
    this.jdField_a_of_type_Tjp.a();
    this.jdField_a_of_type_Twt = new twt(this.jdField_a_of_type_Tjp);
    this.jdField_a_of_type_Twt.b();
  }
  
  private void j()
  {
    urk.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Tjv);
    tjq localtjq = this.jdField_a_of_type_Tjp.a(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs, 3);
    if (((localtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localtjq.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      urk.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new tie(this));
        return;
        if (localtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localtjq.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      urk.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localtjq.jdField_a_of_type_Boolean), Boolean.valueOf(localtjq.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localtjq.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        tjt localtjt = (tjt)localtjq.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        urk.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, localtjt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localtjt.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString))) {
          localtjt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs = ((tjt)localtjq.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Tjs;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localtjq.c = false;
        this.jdField_a_of_type_Tnp.a(localtjq, this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs = ((tjt)localtjq.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Tjs;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Tjv });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Tjp.a(this.jdField_a_of_type_Tju);
    }
    this.jdField_a_of_type_Tjp.a(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs, 2, 5, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Tjp.a(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs, 0, 5, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Tjv.b))
    {
      this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Tjv.b, true);
      this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Tjv.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString))
    {
      ((sqd)sqg.a(5)).a(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
      tjk.a(this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void l()
  {
    String str = "0";
    int i;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a() == 0)))
    {
      i = 200;
      str = "11" + "*";
      str = str + String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (i != 0) {
        urp.b("play_video", "play_result", this.jdField_a_of_type_Tig.a().mReportData.from, i, new String[] { str, "0", urp.a(this.jdField_a_of_type_Tig.a()), "NO_VID" });
      }
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0))
      {
        i = this.jdField_a_of_type_Int;
        str = String.valueOf(this.jdField_b_of_type_Int);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      try
      {
        int j = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
        int i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 3);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    urk.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Tig != null) {
      this.jdField_a_of_type_Tig.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      urk.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Tii.finish();
      return;
    }
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Tqs == null)
    {
      urk.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Tqs = new tqs(this.jdField_a_of_type_Tii.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Tii.a().findViewById(2131309736));
    if (this.jdField_a_of_type_Tig != null) {
      this.jdField_a_of_type_Tig.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (sia)sqg.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Tii.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new tif(this));
  }
  
  public void a(tii paramtii)
  {
    if ((this.jdField_a_of_type_Tii != null) || (paramtii == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Tii = paramtii;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Tnp.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Tjv != null)
    {
      a(this.jdField_a_of_type_Tjv.jdField_a_of_type_Tjs, this.jdField_a_of_type_Tjv.jdField_a_of_type_JavaLangString);
      urk.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Tnp != null) {
      this.jdField_a_of_type_Tnp.b();
    }
  }
  
  public void c()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Tig != null) {
      this.jdField_a_of_type_Tig.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Tig != null) {
      this.jdField_a_of_type_Tig.d();
    }
    a();
    tri.a(this.jdField_a_of_type_Tii.a()).a();
  }
  
  public void e()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Tig != null) {
      this.jdField_a_of_type_Tig.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Tig != null)
    {
      this.jdField_a_of_type_Tig.f();
      l();
    }
  }
  
  public void g()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Tnp != null) {
      this.jdField_a_of_type_Tnp.d();
    }
    if (this.jdField_a_of_type_Tjp != null) {
      this.jdField_a_of_type_Tjp.b();
    }
    if (this.jdField_a_of_type_Twt != null) {
      this.jdField_a_of_type_Twt.c();
    }
    if (this.jdField_a_of_type_Tig != null) {
      this.jdField_a_of_type_Tig.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((sia)sqg.a(6)).a(15000L);
    }
    sik.a().a();
  }
  
  public void h()
  {
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    tio.b();
    if (jdField_a_of_type_Tqs != null)
    {
      urk.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Tqs.a();
      jdField_a_of_type_Tqs = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tia
 * JD-Core Version:    0.7.0.1
 */