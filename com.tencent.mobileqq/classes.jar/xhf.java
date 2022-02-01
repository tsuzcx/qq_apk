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

public class xhf
  implements xli
{
  private static xpx jdField_a_of_type_Xpx;
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
  private xhl jdField_a_of_type_Xhl;
  private xhn jdField_a_of_type_Xhn;
  private xiu jdField_a_of_type_Xiu;
  private xix jdField_a_of_type_Xix;
  xiz jdField_a_of_type_Xiz = new xhg(this);
  private xja jdField_a_of_type_Xja;
  xmd jdField_a_of_type_Xmd = new xhh(this);
  private xmu jdField_a_of_type_Xmu;
  private xvy jdField_a_of_type_Xvy;
  private yij jdField_a_of_type_Yij = (yij)wpm.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public xhf()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new xhi(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    yqp.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Xiu.a();
    this.jdField_a_of_type_Xja = new xja((xja)localObject);
    this.jdField_a_of_type_Xmu = new xmu(paramRelativeLayout);
    xmu localxmu = this.jdField_a_of_type_Xmu;
    localObject = new xhl(this, this.jdField_a_of_type_Xhn, this.jdField_a_of_type_Xmu.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (xja)localObject, null);
    this.jdField_a_of_type_Xhl = ((xhl)localObject);
    localxmu.a((xms)localObject);
    this.jdField_a_of_type_Xmu.c();
    this.jdField_a_of_type_Xmu.a(this.jdField_a_of_type_Xmd);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370198));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131380739));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xja });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(xix paramxix, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      wfo.a().dispatch(new wue(paramxix, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramxix, paramString, str);
      return;
    }
  }
  
  private void a(xnl paramxnl)
  {
    if (paramxnl == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramxnl.jdField_a_of_type_Int;
      int j = paramxnl.jdField_b_of_type_Int;
      yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramxnl.jdField_a_of_type_Xne);
      Object localObject = this.jdField_a_of_type_Xmu.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (xiy)((List)localObject).get(i);
        if ((localObject instanceof xnf)) {
          break label413;
        }
        localObject = ((xiy)localObject).jdField_a_of_type_Xix;
        if (localObject == null) {
          break label402;
        }
        if (!((xix)localObject).equals(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix))
        {
          a(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Xja.jdField_a_of_type_Xix = ((xix)localObject);
        }
        yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xja });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramxnl.jdField_a_of_type_Xne.c()) {
          break label431;
        }
        localObject = paramxnl.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Xix;
        String str = paramxnl.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Xja.b = paramxnl.jdField_a_of_type_Xne.b;
        this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString = paramxnl.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof xjl))
        {
          ((xjl)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy != null) {
            this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((xix)localObject).equals(this.jdField_a_of_type_Xix))) {
          break;
        }
        this.jdField_a_of_type_Xix = ((xix)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        yqp.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((xix)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Xiu.a((xix)localObject, str);
        this.jdField_a_of_type_Xvy.a((xix)localObject, str);
        paramxnl = (xng)paramxnl.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(xng.class);
        if (paramxnl != null) {
          paramxnl.a(str);
        }
        wfo.a().dispatch(new xmf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (xix)localObject, str));
        return;
        yqp.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((xnf)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Xja.jdField_a_of_type_Xix != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xja.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString)))
    {
      yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Xja.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      xiv localxiv = new xiv();
      if ((this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy != null) && (TextUtils.equals(this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Xja.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Xja.jdField_a_of_type_Xiy);
        localxiv.jdField_a_of_type_Boolean = false;
      }
      for (localxiv.jdField_b_of_type_Boolean = false;; localxiv.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localxiv.c = true;
        localxiv.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Xmu.a(localxiv, this.jdField_a_of_type_Xja.jdField_a_of_type_Xix);
        return true;
        yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Xja.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
        xiy localxiy = new xiy(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix);
        localxiy.jdField_a_of_type_JavaUtilList = new ArrayList();
        localxiy.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
        localxiy.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.b);
        localxiy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString;
        localArrayList.add(localxiy);
        localxiv.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Xiu = xke.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Xiu == null)
    {
      yqp.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Xhn.finish();
      return;
    }
    this.jdField_a_of_type_Xiu.a();
    this.jdField_a_of_type_Xvy = new xvy(this.jdField_a_of_type_Xiu);
    this.jdField_a_of_type_Xvy.b();
  }
  
  private void j()
  {
    yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Xja);
    xiv localxiv = this.jdField_a_of_type_Xiu.a(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix, 3);
    if (((localxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localxiv.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new xhj(this));
        return;
        if (localxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localxiv.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localxiv.jdField_a_of_type_Boolean), Boolean.valueOf(localxiv.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localxiv.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        xiy localxiy = (xiy)localxiv.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, localxiy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localxiy.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString))) {
          localxiy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Xja.jdField_a_of_type_Xix = ((xiy)localxiv.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Xix;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localxiv.c = false;
        this.jdField_a_of_type_Xmu.a(localxiv, this.jdField_a_of_type_Xja.jdField_a_of_type_Xix);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Xja.jdField_a_of_type_Xix = ((xiy)localxiv.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Xix;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xja });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Xiu.a(this.jdField_a_of_type_Xiz);
    }
    this.jdField_a_of_type_Xiu.a(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix, 2, 5, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xiu.a(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix, 0, 5, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xja.b))
    {
      this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Xja.b, true);
      this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Xja.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString))
    {
      ((wpj)wpm.a(5)).a(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
      xip.a(this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
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
        yqu.b("play_video", "play_result", this.jdField_a_of_type_Xhl.a().mReportData.from, i, new String[] { str, "0", yqu.a(this.jdField_a_of_type_Xhl.a()), "NO_VID" });
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
    yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Xhl != null) {
      this.jdField_a_of_type_Xhl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      yqp.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Xhn.finish();
      return;
    }
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Xpx == null)
    {
      yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Xpx = new xpx(this.jdField_a_of_type_Xhn.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Xhn.a().findViewById(2131376788));
    if (this.jdField_a_of_type_Xhl != null) {
      this.jdField_a_of_type_Xhl.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (whg)wpm.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Xhn.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new xhk(this));
  }
  
  public void a(xhn paramxhn)
  {
    if ((this.jdField_a_of_type_Xhn != null) || (paramxhn == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Xhn = paramxhn;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xmu.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Xja != null)
    {
      a(this.jdField_a_of_type_Xja.jdField_a_of_type_Xix, this.jdField_a_of_type_Xja.jdField_a_of_type_JavaLangString);
      yqp.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Xmu != null) {
      this.jdField_a_of_type_Xmu.b();
    }
  }
  
  public void c()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Xhl != null) {
      this.jdField_a_of_type_Xhl.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Xhl != null) {
      this.jdField_a_of_type_Xhl.d();
    }
    a();
    xqn.a(this.jdField_a_of_type_Xhn.a()).a();
  }
  
  public void e()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Xhl != null) {
      this.jdField_a_of_type_Xhl.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Xhl != null)
    {
      this.jdField_a_of_type_Xhl.f();
      l();
    }
  }
  
  public void g()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Xmu != null) {
      this.jdField_a_of_type_Xmu.d();
    }
    if (this.jdField_a_of_type_Xiu != null) {
      this.jdField_a_of_type_Xiu.b();
    }
    if (this.jdField_a_of_type_Xvy != null) {
      this.jdField_a_of_type_Xvy.c();
    }
    if (this.jdField_a_of_type_Xhl != null) {
      this.jdField_a_of_type_Xhl.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((whg)wpm.a(6)).a(15000L);
    }
    whq.a().a();
  }
  
  public void h()
  {
    yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    xht.b();
    if (jdField_a_of_type_Xpx != null)
    {
      yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Xpx.a();
      jdField_a_of_type_Xpx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhf
 * JD-Core Version:    0.7.0.1
 */