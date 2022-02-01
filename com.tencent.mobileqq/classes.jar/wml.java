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

public class wml
  implements wqo
{
  private static wvd jdField_a_of_type_Wvd;
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
  private wmr jdField_a_of_type_Wmr;
  private wmt jdField_a_of_type_Wmt;
  private woa jdField_a_of_type_Woa;
  private wod jdField_a_of_type_Wod;
  wof jdField_a_of_type_Wof = new wmm(this);
  private wog jdField_a_of_type_Wog;
  wrj jdField_a_of_type_Wrj = new wmn(this);
  private wsa jdField_a_of_type_Wsa;
  private xbe jdField_a_of_type_Xbe;
  private xnp jdField_a_of_type_Xnp = (xnp)vux.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public wml()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new wmo(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    xvv.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Woa.a();
    this.jdField_a_of_type_Wog = new wog((wog)localObject);
    this.jdField_a_of_type_Wsa = new wsa(paramRelativeLayout);
    wsa localwsa = this.jdField_a_of_type_Wsa;
    localObject = new wmr(this, this.jdField_a_of_type_Wmt, this.jdField_a_of_type_Wsa.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (wog)localObject, null);
    this.jdField_a_of_type_Wmr = ((wmr)localObject);
    localwsa.a((wry)localObject);
    this.jdField_a_of_type_Wsa.c();
    this.jdField_a_of_type_Wsa.a(this.jdField_a_of_type_Wrj);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370267));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131380642));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Wog });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(wod paramwod, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      vli.a().dispatch(new vzp(paramwod, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramwod, paramString, str);
      return;
    }
  }
  
  private void a(wsr paramwsr)
  {
    if (paramwsr == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramwsr.jdField_a_of_type_Int;
      int j = paramwsr.jdField_b_of_type_Int;
      xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramwsr.jdField_a_of_type_Wsk);
      Object localObject = this.jdField_a_of_type_Wsa.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (woe)((List)localObject).get(i);
        if ((localObject instanceof wsl)) {
          break label413;
        }
        localObject = ((woe)localObject).jdField_a_of_type_Wod;
        if (localObject == null) {
          break label402;
        }
        if (!((wod)localObject).equals(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod))
        {
          a(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Wog.jdField_a_of_type_Wod = ((wod)localObject);
        }
        xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Wog });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramwsr.jdField_a_of_type_Wsk.c()) {
          break label431;
        }
        localObject = paramwsr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Wod;
        String str = paramwsr.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Wog.b = paramwsr.jdField_a_of_type_Wsk.b;
        this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString = paramwsr.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof wor))
        {
          ((wor)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Wog.jdField_a_of_type_Woe != null) {
            this.jdField_a_of_type_Wog.jdField_a_of_type_Woe.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((wod)localObject).equals(this.jdField_a_of_type_Wod))) {
          break;
        }
        this.jdField_a_of_type_Wod = ((wod)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        xvv.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((wod)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Woa.a((wod)localObject, str);
        this.jdField_a_of_type_Xbe.a((wod)localObject, str);
        paramwsr = (wsm)paramwsr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(wsm.class);
        if (paramwsr != null) {
          paramwsr.a(str);
        }
        vli.a().dispatch(new wrl(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (wod)localObject, str));
        return;
        xvv.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((wsl)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Wog.jdField_a_of_type_Wod != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Wog.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString)))
    {
      xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Wog.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      wob localwob = new wob();
      if ((this.jdField_a_of_type_Wog.jdField_a_of_type_Woe != null) && (TextUtils.equals(this.jdField_a_of_type_Wog.jdField_a_of_type_Woe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Wog.jdField_a_of_type_Woe.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Wog.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Wog.jdField_a_of_type_Woe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Wog.jdField_a_of_type_Woe);
        localwob.jdField_a_of_type_Boolean = false;
      }
      for (localwob.jdField_b_of_type_Boolean = false;; localwob.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localwob.c = true;
        localwob.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Wsa.a(localwob, this.jdField_a_of_type_Wog.jdField_a_of_type_Wod);
        return true;
        xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Wog.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
        woe localwoe = new woe(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod);
        localwoe.jdField_a_of_type_JavaUtilList = new ArrayList();
        localwoe.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
        localwoe.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.b);
        localwoe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString;
        localArrayList.add(localwoe);
        localwob.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Woa = wpk.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Woa == null)
    {
      xvv.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Wmt.finish();
      return;
    }
    this.jdField_a_of_type_Woa.a();
    this.jdField_a_of_type_Xbe = new xbe(this.jdField_a_of_type_Woa);
    this.jdField_a_of_type_Xbe.b();
  }
  
  private void j()
  {
    xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Wog);
    wob localwob = this.jdField_a_of_type_Woa.a(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod, 3);
    if (((localwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localwob.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new wmp(this));
        return;
        if (localwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localwob.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localwob.jdField_a_of_type_Boolean), Boolean.valueOf(localwob.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localwob.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        woe localwoe = (woe)localwob.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, localwoe.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localwoe.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString))) {
          localwoe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Wog.jdField_a_of_type_Wod = ((woe)localwob.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Wod;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localwob.c = false;
        this.jdField_a_of_type_Wsa.a(localwob, this.jdField_a_of_type_Wog.jdField_a_of_type_Wod);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Wog.jdField_a_of_type_Wod = ((woe)localwob.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Wod;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Wog });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Woa.a(this.jdField_a_of_type_Wof);
    }
    this.jdField_a_of_type_Woa.a(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod, 2, 5, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Woa.a(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod, 0, 5, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wog.b))
    {
      this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Wog.b, true);
      this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Wog.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString))
    {
      ((vuu)vux.a(5)).a(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
      wnv.a(this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
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
        xwa.b("play_video", "play_result", this.jdField_a_of_type_Wmr.a().mReportData.from, i, new String[] { str, "0", xwa.a(this.jdField_a_of_type_Wmr.a()), "NO_VID" });
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
    xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Wmr != null) {
      this.jdField_a_of_type_Wmr.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      xvv.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Wmt.finish();
      return;
    }
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Wvd == null)
    {
      xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Wvd = new wvd(this.jdField_a_of_type_Wmt.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Wmt.a().findViewById(2131376679));
    if (this.jdField_a_of_type_Wmr != null) {
      this.jdField_a_of_type_Wmr.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (vna)vux.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Wmt.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new wmq(this));
  }
  
  public void a(wmt paramwmt)
  {
    if ((this.jdField_a_of_type_Wmt != null) || (paramwmt == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Wmt = paramwmt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Wsa.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wog != null)
    {
      a(this.jdField_a_of_type_Wog.jdField_a_of_type_Wod, this.jdField_a_of_type_Wog.jdField_a_of_type_JavaLangString);
      xvv.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Wsa != null) {
      this.jdField_a_of_type_Wsa.b();
    }
  }
  
  public void c()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Wmr != null) {
      this.jdField_a_of_type_Wmr.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Wmr != null) {
      this.jdField_a_of_type_Wmr.d();
    }
    a();
    wvt.a(this.jdField_a_of_type_Wmt.a()).a();
  }
  
  public void e()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Wmr != null) {
      this.jdField_a_of_type_Wmr.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Wmr != null)
    {
      this.jdField_a_of_type_Wmr.f();
      l();
    }
  }
  
  public void g()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Wsa != null) {
      this.jdField_a_of_type_Wsa.d();
    }
    if (this.jdField_a_of_type_Woa != null) {
      this.jdField_a_of_type_Woa.b();
    }
    if (this.jdField_a_of_type_Xbe != null) {
      this.jdField_a_of_type_Xbe.c();
    }
    if (this.jdField_a_of_type_Wmr != null) {
      this.jdField_a_of_type_Wmr.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((vna)vux.a(6)).a(15000L);
    }
    vnk.a().a();
  }
  
  public void h()
  {
    xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    wmz.b();
    if (jdField_a_of_type_Wvd != null)
    {
      xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Wvd.a();
      jdField_a_of_type_Wvd = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wml
 * JD-Core Version:    0.7.0.1
 */