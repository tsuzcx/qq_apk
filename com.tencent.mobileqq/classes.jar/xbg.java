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

public class xbg
  implements xfj
{
  private static xjy jdField_a_of_type_Xjy;
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
  private xbm jdField_a_of_type_Xbm;
  private xbo jdField_a_of_type_Xbo;
  private xcv jdField_a_of_type_Xcv;
  private xcy jdField_a_of_type_Xcy;
  xda jdField_a_of_type_Xda = new xbh(this);
  private xdb jdField_a_of_type_Xdb;
  xge jdField_a_of_type_Xge = new xbi(this);
  private xgv jdField_a_of_type_Xgv;
  private xpz jdField_a_of_type_Xpz;
  private yck jdField_a_of_type_Yck = (yck)wjs.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public xbg()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new xbj(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    ykq.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Xcv.a();
    this.jdField_a_of_type_Xdb = new xdb((xdb)localObject);
    this.jdField_a_of_type_Xgv = new xgv(paramRelativeLayout);
    xgv localxgv = this.jdField_a_of_type_Xgv;
    localObject = new xbm(this, this.jdField_a_of_type_Xbo, this.jdField_a_of_type_Xgv.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (xdb)localObject, null);
    this.jdField_a_of_type_Xbm = ((xbm)localObject);
    localxgv.a((xgt)localObject);
    this.jdField_a_of_type_Xgv.c();
    this.jdField_a_of_type_Xgv.a(this.jdField_a_of_type_Xge);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370446));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131380990));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xdb });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(xcy paramxcy, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      wad.a().dispatch(new wok(paramxcy, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramxcy, paramString, str);
      return;
    }
  }
  
  private void a(xhm paramxhm)
  {
    if (paramxhm == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramxhm.jdField_a_of_type_Int;
      int j = paramxhm.jdField_b_of_type_Int;
      ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramxhm.jdField_a_of_type_Xhf);
      Object localObject = this.jdField_a_of_type_Xgv.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (xcz)((List)localObject).get(i);
        if ((localObject instanceof xhg)) {
          break label413;
        }
        localObject = ((xcz)localObject).jdField_a_of_type_Xcy;
        if (localObject == null) {
          break label402;
        }
        if (!((xcy)localObject).equals(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy))
        {
          a(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy = ((xcy)localObject);
        }
        ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xdb });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramxhm.jdField_a_of_type_Xhf.c()) {
          break label431;
        }
        localObject = paramxhm.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Xcy;
        String str = paramxhm.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Xdb.b = paramxhm.jdField_a_of_type_Xhf.b;
        this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString = paramxhm.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof xdm))
        {
          ((xdm)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz != null) {
            this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((xcy)localObject).equals(this.jdField_a_of_type_Xcy))) {
          break;
        }
        this.jdField_a_of_type_Xcy = ((xcy)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        ykq.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((xcy)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Xcv.a((xcy)localObject, str);
        this.jdField_a_of_type_Xpz.a((xcy)localObject, str);
        paramxhm = (xhh)paramxhm.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(xhh.class);
        if (paramxhm != null) {
          paramxhm.a(str);
        }
        wad.a().dispatch(new xgg(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (xcy)localObject, str));
        return;
        ykq.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((xhg)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xdb.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString)))
    {
      ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      xcw localxcw = new xcw();
      if ((this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz != null) && (TextUtils.equals(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcz);
        localxcw.jdField_a_of_type_Boolean = false;
      }
      for (localxcw.jdField_b_of_type_Boolean = false;; localxcw.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localxcw.c = true;
        localxcw.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Xgv.a(localxcw, this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy);
        return true;
        ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
        xcz localxcz = new xcz(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy);
        localxcz.jdField_a_of_type_JavaUtilList = new ArrayList();
        localxcz.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
        localxcz.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.b);
        localxcz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString;
        localArrayList.add(localxcz);
        localxcw.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Xcv = xef.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Xcv == null)
    {
      ykq.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Xbo.finish();
      return;
    }
    this.jdField_a_of_type_Xcv.a();
    this.jdField_a_of_type_Xpz = new xpz(this.jdField_a_of_type_Xcv);
    this.jdField_a_of_type_Xpz.b();
  }
  
  private void j()
  {
    ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Xdb);
    xcw localxcw = this.jdField_a_of_type_Xcv.a(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy, 3);
    if (((localxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localxcw.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new xbk(this));
        return;
        if (localxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localxcw.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localxcw.jdField_a_of_type_Boolean), Boolean.valueOf(localxcw.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localxcw.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        xcz localxcz = (xcz)localxcw.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, localxcz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localxcz.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString))) {
          localxcz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy = ((xcz)localxcw.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Xcy;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localxcw.c = false;
        this.jdField_a_of_type_Xgv.a(localxcw, this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy = ((xcz)localxcw.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Xcy;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Xdb });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Xcv.a(this.jdField_a_of_type_Xda);
    }
    this.jdField_a_of_type_Xcv.a(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy, 2, 5, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xcv.a(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy, 0, 5, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdb.b))
    {
      this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xdb.b, true);
      this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xdb.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString))
    {
      ((wjp)wjs.a(5)).a(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
      xcq.a(this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
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
        ykv.b("play_video", "play_result", this.jdField_a_of_type_Xbm.a().mReportData.from, i, new String[] { str, "0", ykv.a(this.jdField_a_of_type_Xbm.a()), "NO_VID" });
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
    ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Xbm != null) {
      this.jdField_a_of_type_Xbm.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      ykq.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Xbo.finish();
      return;
    }
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Xjy == null)
    {
      ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Xjy = new xjy(this.jdField_a_of_type_Xbo.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Xbo.a().findViewById(2131376947));
    if (this.jdField_a_of_type_Xbm != null) {
      this.jdField_a_of_type_Xbm.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (wbv)wjs.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Xbo.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new xbl(this));
  }
  
  public void a(xbo paramxbo)
  {
    if ((this.jdField_a_of_type_Xbo != null) || (paramxbo == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Xbo = paramxbo;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xgv.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Xdb != null)
    {
      a(this.jdField_a_of_type_Xdb.jdField_a_of_type_Xcy, this.jdField_a_of_type_Xdb.jdField_a_of_type_JavaLangString);
      ykq.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Xgv != null) {
      this.jdField_a_of_type_Xgv.b();
    }
  }
  
  public void c()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Xbm != null) {
      this.jdField_a_of_type_Xbm.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Xbm != null) {
      this.jdField_a_of_type_Xbm.d();
    }
    a();
    xko.a(this.jdField_a_of_type_Xbo.a()).a();
  }
  
  public void e()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Xbm != null) {
      this.jdField_a_of_type_Xbm.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Xbm != null)
    {
      this.jdField_a_of_type_Xbm.f();
      l();
    }
  }
  
  public void g()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Xgv != null) {
      this.jdField_a_of_type_Xgv.d();
    }
    if (this.jdField_a_of_type_Xcv != null) {
      this.jdField_a_of_type_Xcv.b();
    }
    if (this.jdField_a_of_type_Xpz != null) {
      this.jdField_a_of_type_Xpz.c();
    }
    if (this.jdField_a_of_type_Xbm != null) {
      this.jdField_a_of_type_Xbm.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((wbv)wjs.a(6)).a(15000L);
    }
    wcf.a().a();
  }
  
  public void h()
  {
    ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    xbu.b();
    if (jdField_a_of_type_Xjy != null)
    {
      ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Xjy.a();
      jdField_a_of_type_Xjy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbg
 * JD-Core Version:    0.7.0.1
 */