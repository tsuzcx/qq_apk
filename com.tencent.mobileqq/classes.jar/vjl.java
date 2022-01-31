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

public class vjl
  implements vno
{
  private static vsd jdField_a_of_type_Vsd;
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
  private vjr jdField_a_of_type_Vjr;
  private vjt jdField_a_of_type_Vjt;
  private vla jdField_a_of_type_Vla;
  private vld jdField_a_of_type_Vld;
  vlf jdField_a_of_type_Vlf = new vjm(this);
  private vlg jdField_a_of_type_Vlg;
  voj jdField_a_of_type_Voj = new vjn(this);
  private vpa jdField_a_of_type_Vpa;
  private vye jdField_a_of_type_Vye;
  private wkp jdField_a_of_type_Wkp = (wkp)urr.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public vjl()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new vjo(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    wsv.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Vla.a();
    this.jdField_a_of_type_Vlg = new vlg((vlg)localObject);
    this.jdField_a_of_type_Vpa = new vpa(paramRelativeLayout);
    vpa localvpa = this.jdField_a_of_type_Vpa;
    localObject = new vjr(this, this.jdField_a_of_type_Vjt, this.jdField_a_of_type_Vpa.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (vlg)localObject, null);
    this.jdField_a_of_type_Vjr = ((vjr)localObject);
    localvpa.a((voy)localObject);
    this.jdField_a_of_type_Vpa.c();
    this.jdField_a_of_type_Vpa.a(this.jdField_a_of_type_Voj);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131369748));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131379723));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Vlg });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(vld paramvld, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      uht.a().dispatch(new uwj(paramvld, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramvld, paramString, str);
      return;
    }
  }
  
  private void a(vpr paramvpr)
  {
    if (paramvpr == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramvpr.jdField_a_of_type_Int;
      int j = paramvpr.jdField_b_of_type_Int;
      wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramvpr.jdField_a_of_type_Vpk);
      Object localObject = this.jdField_a_of_type_Vpa.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (vle)((List)localObject).get(i);
        if ((localObject instanceof vpl)) {
          break label413;
        }
        localObject = ((vle)localObject).jdField_a_of_type_Vld;
        if (localObject == null) {
          break label402;
        }
        if (!((vld)localObject).equals(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld))
        {
          a(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld = ((vld)localObject);
        }
        wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Vlg });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramvpr.jdField_a_of_type_Vpk.c()) {
          break label431;
        }
        localObject = paramvpr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Vld;
        String str = paramvpr.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Vlg.b = paramvpr.jdField_a_of_type_Vpk.b;
        this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString = paramvpr.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof vlr))
        {
          ((vlr)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle != null) {
            this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((vld)localObject).equals(this.jdField_a_of_type_Vld))) {
          break;
        }
        this.jdField_a_of_type_Vld = ((vld)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        wsv.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((vld)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Vla.a((vld)localObject, str);
        this.jdField_a_of_type_Vye.a((vld)localObject, str);
        paramvpr = (vpm)paramvpr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(vpm.class);
        if (paramvpr != null) {
          paramvpr.a(str);
        }
        uht.a().dispatch(new vol(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (vld)localObject, str));
        return;
        wsv.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((vpl)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vlg.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString)))
    {
      wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      vlb localvlb = new vlb();
      if ((this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle != null) && (TextUtils.equals(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vle);
        localvlb.jdField_a_of_type_Boolean = false;
      }
      for (localvlb.jdField_b_of_type_Boolean = false;; localvlb.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localvlb.c = true;
        localvlb.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Vpa.a(localvlb, this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld);
        return true;
        wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
        vle localvle = new vle(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld);
        localvle.jdField_a_of_type_JavaUtilList = new ArrayList();
        localvle.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
        localvle.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.b);
        localvle.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString;
        localArrayList.add(localvle);
        localvlb.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Vla = vmk.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Vla == null)
    {
      wsv.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Vjt.finish();
      return;
    }
    this.jdField_a_of_type_Vla.a();
    this.jdField_a_of_type_Vye = new vye(this.jdField_a_of_type_Vla);
    this.jdField_a_of_type_Vye.b();
  }
  
  private void j()
  {
    wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Vlg);
    vlb localvlb = this.jdField_a_of_type_Vla.a(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld, 3);
    if (((localvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localvlb.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new vjp(this));
        return;
        if (localvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localvlb.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localvlb.jdField_a_of_type_Boolean), Boolean.valueOf(localvlb.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localvlb.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        vle localvle = (vle)localvlb.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, localvle.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localvle.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString))) {
          localvle.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld = ((vle)localvlb.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Vld;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localvlb.c = false;
        this.jdField_a_of_type_Vpa.a(localvlb, this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld = ((vle)localvlb.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Vld;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Vlg });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Vla.a(this.jdField_a_of_type_Vlf);
    }
    this.jdField_a_of_type_Vla.a(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld, 2, 5, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Vla.a(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld, 0, 5, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Vlg.b))
    {
      this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Vlg.b, true);
      this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Vlg.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString))
    {
      ((uro)urr.a(5)).a(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
      vkv.a(this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
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
        wta.b("play_video", "play_result", this.jdField_a_of_type_Vjr.a().mReportData.from, i, new String[] { str, "0", wta.a(this.jdField_a_of_type_Vjr.a()), "NO_VID" });
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
    wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Vjr != null) {
      this.jdField_a_of_type_Vjr.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      wsv.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Vjt.finish();
      return;
    }
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Vsd == null)
    {
      wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Vsd = new vsd(this.jdField_a_of_type_Vjt.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Vjt.a().findViewById(2131375981));
    if (this.jdField_a_of_type_Vjr != null) {
      this.jdField_a_of_type_Vjr.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (ujl)urr.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Vjt.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new vjq(this));
  }
  
  public void a(vjt paramvjt)
  {
    if ((this.jdField_a_of_type_Vjt != null) || (paramvjt == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Vjt = paramvjt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Vpa.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vlg != null)
    {
      a(this.jdField_a_of_type_Vlg.jdField_a_of_type_Vld, this.jdField_a_of_type_Vlg.jdField_a_of_type_JavaLangString);
      wsv.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Vpa != null) {
      this.jdField_a_of_type_Vpa.b();
    }
  }
  
  public void c()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Vjr != null) {
      this.jdField_a_of_type_Vjr.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Vjr != null) {
      this.jdField_a_of_type_Vjr.d();
    }
    a();
    vst.a(this.jdField_a_of_type_Vjt.a()).a();
  }
  
  public void e()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Vjr != null) {
      this.jdField_a_of_type_Vjr.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Vjr != null)
    {
      this.jdField_a_of_type_Vjr.f();
      l();
    }
  }
  
  public void g()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Vpa != null) {
      this.jdField_a_of_type_Vpa.d();
    }
    if (this.jdField_a_of_type_Vla != null) {
      this.jdField_a_of_type_Vla.b();
    }
    if (this.jdField_a_of_type_Vye != null) {
      this.jdField_a_of_type_Vye.c();
    }
    if (this.jdField_a_of_type_Vjr != null) {
      this.jdField_a_of_type_Vjr.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((ujl)urr.a(6)).a(15000L);
    }
    ujv.a().a();
  }
  
  public void h()
  {
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    vjz.b();
    if (jdField_a_of_type_Vsd != null)
    {
      wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Vsd.a();
      jdField_a_of_type_Vsd = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjl
 * JD-Core Version:    0.7.0.1
 */