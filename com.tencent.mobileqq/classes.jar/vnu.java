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

public class vnu
  implements vrx
{
  private static vwm jdField_a_of_type_Vwm;
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
  private voa jdField_a_of_type_Voa;
  private voc jdField_a_of_type_Voc;
  private vpj jdField_a_of_type_Vpj;
  private vpm jdField_a_of_type_Vpm;
  vpo jdField_a_of_type_Vpo = new vnv(this);
  private vpp jdField_a_of_type_Vpp;
  vss jdField_a_of_type_Vss = new vnw(this);
  private vtj jdField_a_of_type_Vtj;
  private wcn jdField_a_of_type_Wcn;
  private woy jdField_a_of_type_Woy = (woy)uwa.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public vnu()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new vnx(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    wxe.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Vpj.a();
    this.jdField_a_of_type_Vpp = new vpp((vpp)localObject);
    this.jdField_a_of_type_Vtj = new vtj(paramRelativeLayout);
    vtj localvtj = this.jdField_a_of_type_Vtj;
    localObject = new voa(this, this.jdField_a_of_type_Voc, this.jdField_a_of_type_Vtj.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (vpp)localObject, null);
    this.jdField_a_of_type_Voa = ((voa)localObject);
    localvtj.a((vth)localObject);
    this.jdField_a_of_type_Vtj.c();
    this.jdField_a_of_type_Vtj.a(this.jdField_a_of_type_Vss);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131369767));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131379781));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Vpp });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(vpm paramvpm, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      umc.a().dispatch(new vas(paramvpm, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramvpm, paramString, str);
      return;
    }
  }
  
  private void a(vua paramvua)
  {
    if (paramvua == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramvua.jdField_a_of_type_Int;
      int j = paramvua.jdField_b_of_type_Int;
      wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramvua.jdField_a_of_type_Vtt);
      Object localObject = this.jdField_a_of_type_Vtj.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (vpn)((List)localObject).get(i);
        if ((localObject instanceof vtu)) {
          break label413;
        }
        localObject = ((vpn)localObject).jdField_a_of_type_Vpm;
        if (localObject == null) {
          break label402;
        }
        if (!((vpm)localObject).equals(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm))
        {
          a(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm = ((vpm)localObject);
        }
        wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Vpp });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramvua.jdField_a_of_type_Vtt.c()) {
          break label431;
        }
        localObject = paramvua.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Vpm;
        String str = paramvua.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Vpp.b = paramvua.jdField_a_of_type_Vtt.b;
        this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString = paramvua.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof vqa))
        {
          ((vqa)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn != null) {
            this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((vpm)localObject).equals(this.jdField_a_of_type_Vpm))) {
          break;
        }
        this.jdField_a_of_type_Vpm = ((vpm)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        wxe.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((vpm)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Vpj.a((vpm)localObject, str);
        this.jdField_a_of_type_Wcn.a((vpm)localObject, str);
        paramvua = (vtv)paramvua.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(vtv.class);
        if (paramvua != null) {
          paramvua.a(str);
        }
        umc.a().dispatch(new vsu(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (vpm)localObject, str));
        return;
        wxe.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((vtu)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vpp.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString)))
    {
      wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      vpk localvpk = new vpk();
      if ((this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn != null) && (TextUtils.equals(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpn);
        localvpk.jdField_a_of_type_Boolean = false;
      }
      for (localvpk.jdField_b_of_type_Boolean = false;; localvpk.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localvpk.c = true;
        localvpk.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Vtj.a(localvpk, this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm);
        return true;
        wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
        vpn localvpn = new vpn(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm);
        localvpn.jdField_a_of_type_JavaUtilList = new ArrayList();
        localvpn.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
        localvpn.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.b);
        localvpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString;
        localArrayList.add(localvpn);
        localvpk.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Vpj = vqt.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Vpj == null)
    {
      wxe.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Voc.finish();
      return;
    }
    this.jdField_a_of_type_Vpj.a();
    this.jdField_a_of_type_Wcn = new wcn(this.jdField_a_of_type_Vpj);
    this.jdField_a_of_type_Wcn.b();
  }
  
  private void j()
  {
    wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Vpp);
    vpk localvpk = this.jdField_a_of_type_Vpj.a(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm, 3);
    if (((localvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localvpk.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new vny(this));
        return;
        if (localvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localvpk.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localvpk.jdField_a_of_type_Boolean), Boolean.valueOf(localvpk.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localvpk.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        vpn localvpn = (vpn)localvpk.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, localvpn.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localvpn.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString))) {
          localvpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm = ((vpn)localvpk.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Vpm;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localvpk.c = false;
        this.jdField_a_of_type_Vtj.a(localvpk, this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm = ((vpn)localvpk.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Vpm;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Vpp });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Vpj.a(this.jdField_a_of_type_Vpo);
    }
    this.jdField_a_of_type_Vpj.a(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm, 2, 5, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Vpj.a(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm, 0, 5, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Vpp.b))
    {
      this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Vpp.b, true);
      this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Vpp.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString))
    {
      ((uvx)uwa.a(5)).a(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
      vpe.a(this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
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
        wxj.b("play_video", "play_result", this.jdField_a_of_type_Voa.a().mReportData.from, i, new String[] { str, "0", wxj.a(this.jdField_a_of_type_Voa.a()), "NO_VID" });
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
    wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Voa != null) {
      this.jdField_a_of_type_Voa.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      wxe.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Voc.finish();
      return;
    }
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Vwm == null)
    {
      wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Vwm = new vwm(this.jdField_a_of_type_Voc.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Voc.a().findViewById(2131376034));
    if (this.jdField_a_of_type_Voa != null) {
      this.jdField_a_of_type_Voa.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (unu)uwa.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Voc.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new vnz(this));
  }
  
  public void a(voc paramvoc)
  {
    if ((this.jdField_a_of_type_Voc != null) || (paramvoc == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Voc = paramvoc;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Vtj.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vpp != null)
    {
      a(this.jdField_a_of_type_Vpp.jdField_a_of_type_Vpm, this.jdField_a_of_type_Vpp.jdField_a_of_type_JavaLangString);
      wxe.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Vtj != null) {
      this.jdField_a_of_type_Vtj.b();
    }
  }
  
  public void c()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Voa != null) {
      this.jdField_a_of_type_Voa.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Voa != null) {
      this.jdField_a_of_type_Voa.d();
    }
    a();
    vxc.a(this.jdField_a_of_type_Voc.a()).a();
  }
  
  public void e()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Voa != null) {
      this.jdField_a_of_type_Voa.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Voa != null)
    {
      this.jdField_a_of_type_Voa.f();
      l();
    }
  }
  
  public void g()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Vtj != null) {
      this.jdField_a_of_type_Vtj.d();
    }
    if (this.jdField_a_of_type_Vpj != null) {
      this.jdField_a_of_type_Vpj.b();
    }
    if (this.jdField_a_of_type_Wcn != null) {
      this.jdField_a_of_type_Wcn.c();
    }
    if (this.jdField_a_of_type_Voa != null) {
      this.jdField_a_of_type_Voa.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((unu)uwa.a(6)).a(15000L);
    }
    uoe.a().a();
  }
  
  public void h()
  {
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    voi.b();
    if (jdField_a_of_type_Vwm != null)
    {
      wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Vwm.a();
      jdField_a_of_type_Vwm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnu
 * JD-Core Version:    0.7.0.1
 */