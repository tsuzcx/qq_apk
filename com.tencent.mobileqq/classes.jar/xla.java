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

public class xla
  implements xpd
{
  private static xts jdField_a_of_type_Xts;
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
  private xlg jdField_a_of_type_Xlg;
  private xli jdField_a_of_type_Xli;
  private xmp jdField_a_of_type_Xmp;
  private xms jdField_a_of_type_Xms;
  xmu jdField_a_of_type_Xmu = new xlb(this);
  private xmv jdField_a_of_type_Xmv;
  xpy jdField_a_of_type_Xpy = new xlc(this);
  private xqp jdField_a_of_type_Xqp;
  private xzt jdField_a_of_type_Xzt;
  private yme jdField_a_of_type_Yme = (yme)wth.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public xla()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new xld(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    yuk.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Xmp.a();
    this.jdField_a_of_type_Xmv = new xmv((xmv)localObject);
    this.jdField_a_of_type_Xqp = new xqp(paramRelativeLayout);
    xqp localxqp = this.jdField_a_of_type_Xqp;
    localObject = new xlg(this, this.jdField_a_of_type_Xli, this.jdField_a_of_type_Xqp.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (xmv)localObject, null);
    this.jdField_a_of_type_Xlg = ((xlg)localObject);
    localxqp.a((xqn)localObject);
    this.jdField_a_of_type_Xqp.c();
    this.jdField_a_of_type_Xqp.a(this.jdField_a_of_type_Xpy);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370299));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131380916));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xmv });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(xms paramxms, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      wjj.a().dispatch(new wxz(paramxms, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramxms, paramString, str);
      return;
    }
  }
  
  private void a(xrg paramxrg)
  {
    if (paramxrg == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramxrg.jdField_a_of_type_Int;
      int j = paramxrg.jdField_b_of_type_Int;
      yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramxrg.jdField_a_of_type_Xqz);
      Object localObject = this.jdField_a_of_type_Xqp.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (xmt)((List)localObject).get(i);
        if ((localObject instanceof xra)) {
          break label413;
        }
        localObject = ((xmt)localObject).jdField_a_of_type_Xms;
        if (localObject == null) {
          break label402;
        }
        if (!((xms)localObject).equals(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms))
        {
          a(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms = ((xms)localObject);
        }
        yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xmv });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramxrg.jdField_a_of_type_Xqz.c()) {
          break label431;
        }
        localObject = paramxrg.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Xms;
        String str = paramxrg.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Xmv.b = paramxrg.jdField_a_of_type_Xqz.b;
        this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString = paramxrg.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof xng))
        {
          ((xng)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt != null) {
            this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((xms)localObject).equals(this.jdField_a_of_type_Xms))) {
          break;
        }
        this.jdField_a_of_type_Xms = ((xms)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        yuk.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((xms)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Xmp.a((xms)localObject, str);
        this.jdField_a_of_type_Xzt.a((xms)localObject, str);
        paramxrg = (xrb)paramxrg.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(xrb.class);
        if (paramxrg != null) {
          paramxrg.a(str);
        }
        wjj.a().dispatch(new xqa(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (xms)localObject, str));
        return;
        yuk.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((xra)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xmv.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString)))
    {
      yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      xmq localxmq = new xmq();
      if ((this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt != null) && (TextUtils.equals(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xmt);
        localxmq.jdField_a_of_type_Boolean = false;
      }
      for (localxmq.jdField_b_of_type_Boolean = false;; localxmq.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localxmq.c = true;
        localxmq.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Xqp.a(localxmq, this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms);
        return true;
        yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
        xmt localxmt = new xmt(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms);
        localxmt.jdField_a_of_type_JavaUtilList = new ArrayList();
        localxmt.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
        localxmt.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.b);
        localxmt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString;
        localArrayList.add(localxmt);
        localxmq.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Xmp = xnz.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Xmp == null)
    {
      yuk.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Xli.finish();
      return;
    }
    this.jdField_a_of_type_Xmp.a();
    this.jdField_a_of_type_Xzt = new xzt(this.jdField_a_of_type_Xmp);
    this.jdField_a_of_type_Xzt.b();
  }
  
  private void j()
  {
    yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Xmv);
    xmq localxmq = this.jdField_a_of_type_Xmp.a(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms, 3);
    if (((localxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localxmq.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new xle(this));
        return;
        if (localxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localxmq.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localxmq.jdField_a_of_type_Boolean), Boolean.valueOf(localxmq.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localxmq.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        xmt localxmt = (xmt)localxmq.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, localxmt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localxmt.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString))) {
          localxmt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms = ((xmt)localxmq.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Xms;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localxmq.c = false;
        this.jdField_a_of_type_Xqp.a(localxmq, this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms = ((xmt)localxmq.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Xms;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xmv });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Xmp.a(this.jdField_a_of_type_Xmu);
    }
    this.jdField_a_of_type_Xmp.a(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms, 2, 5, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xmp.a(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms, 0, 5, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmv.b))
    {
      this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Xmv.b, true);
      this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Xmv.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString))
    {
      ((wte)wth.a(5)).a(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
      xmk.a(this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
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
        yup.b("play_video", "play_result", this.jdField_a_of_type_Xlg.a().mReportData.from, i, new String[] { str, "0", yup.a(this.jdField_a_of_type_Xlg.a()), "NO_VID" });
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
    yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      yuk.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Xli.finish();
      return;
    }
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Xts == null)
    {
      yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Xts = new xts(this.jdField_a_of_type_Xli.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Xli.a().findViewById(2131376925));
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (wlb)wth.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Xli.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new xlf(this));
  }
  
  public void a(xli paramxli)
  {
    if ((this.jdField_a_of_type_Xli != null) || (paramxli == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Xli = paramxli;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xqp.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Xmv != null)
    {
      a(this.jdField_a_of_type_Xmv.jdField_a_of_type_Xms, this.jdField_a_of_type_Xmv.jdField_a_of_type_JavaLangString);
      yuk.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Xqp != null) {
      this.jdField_a_of_type_Xqp.b();
    }
  }
  
  public void c()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.d();
    }
    a();
    xui.a(this.jdField_a_of_type_Xli.a()).a();
  }
  
  public void e()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Xlg != null)
    {
      this.jdField_a_of_type_Xlg.f();
      l();
    }
  }
  
  public void g()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Xqp != null) {
      this.jdField_a_of_type_Xqp.d();
    }
    if (this.jdField_a_of_type_Xmp != null) {
      this.jdField_a_of_type_Xmp.b();
    }
    if (this.jdField_a_of_type_Xzt != null) {
      this.jdField_a_of_type_Xzt.c();
    }
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((wlb)wth.a(6)).a(15000L);
    }
    wll.a().a();
  }
  
  public void h()
  {
    yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    xlo.b();
    if (jdField_a_of_type_Xts != null)
    {
      yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Xts.a();
      jdField_a_of_type_Xts = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xla
 * JD-Core Version:    0.7.0.1
 */