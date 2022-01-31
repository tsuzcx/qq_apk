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

public class tuw
  implements tyz
{
  private static udo jdField_a_of_type_Udo;
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
  private tvc jdField_a_of_type_Tvc;
  private tve jdField_a_of_type_Tve;
  private twl jdField_a_of_type_Twl;
  private two jdField_a_of_type_Two;
  twq jdField_a_of_type_Twq = new tux(this);
  private twr jdField_a_of_type_Twr;
  tzu jdField_a_of_type_Tzu = new tuy(this);
  private ual jdField_a_of_type_Ual;
  private ujp jdField_a_of_type_Ujp;
  private uwa jdField_a_of_type_Uwa = (uwa)tdc.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public tuw()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new tuz(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    veg.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Twl.a();
    this.jdField_a_of_type_Twr = new twr((twr)localObject);
    this.jdField_a_of_type_Ual = new ual(paramRelativeLayout);
    ual localual = this.jdField_a_of_type_Ual;
    localObject = new tvc(this, this.jdField_a_of_type_Tve, this.jdField_a_of_type_Ual.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (twr)localObject, null);
    this.jdField_a_of_type_Tvc = ((tvc)localObject);
    localual.a((uaj)localObject);
    this.jdField_a_of_type_Ual.c();
    this.jdField_a_of_type_Ual.a(this.jdField_a_of_type_Tzu);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131369487));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131379043));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Twr });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(two paramtwo, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ste.a().dispatch(new thu(paramtwo, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      veg.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramtwo, paramString, str);
      return;
    }
  }
  
  private void a(ubc paramubc)
  {
    if (paramubc == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramubc.jdField_a_of_type_Int;
      int j = paramubc.jdField_b_of_type_Int;
      veg.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramubc.jdField_a_of_type_Uav);
      Object localObject = this.jdField_a_of_type_Ual.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (twp)((List)localObject).get(i);
        if ((localObject instanceof uaw)) {
          break label413;
        }
        localObject = ((twp)localObject).jdField_a_of_type_Two;
        if (localObject == null) {
          break label402;
        }
        if (!((two)localObject).equals(this.jdField_a_of_type_Twr.jdField_a_of_type_Two))
        {
          a(this.jdField_a_of_type_Twr.jdField_a_of_type_Two, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Twr.jdField_a_of_type_Two = ((two)localObject);
        }
        veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Twr });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramubc.jdField_a_of_type_Uav.c()) {
          break label431;
        }
        localObject = paramubc.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Two;
        String str = paramubc.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Twr.b = paramubc.jdField_a_of_type_Uav.b;
        this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString = paramubc.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof txc))
        {
          ((txc)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Twr.jdField_a_of_type_Twp != null) {
            this.jdField_a_of_type_Twr.jdField_a_of_type_Twp.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((two)localObject).equals(this.jdField_a_of_type_Two))) {
          break;
        }
        this.jdField_a_of_type_Two = ((two)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        veg.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((two)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Twl.a((two)localObject, str);
        this.jdField_a_of_type_Ujp.a((two)localObject, str);
        paramubc = (uax)paramubc.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(uax.class);
        if (paramubc != null) {
          paramubc.a(str);
        }
        ste.a().dispatch(new tzw(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (two)localObject, str));
        return;
        veg.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((uaw)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Twr.jdField_a_of_type_Two != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Twr.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString)))
    {
      veg.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Twr.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      twm localtwm = new twm();
      if ((this.jdField_a_of_type_Twr.jdField_a_of_type_Twp != null) && (TextUtils.equals(this.jdField_a_of_type_Twr.jdField_a_of_type_Twp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Twr.jdField_a_of_type_Twp.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        veg.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Twr.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Twr.jdField_a_of_type_Twp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Twr.jdField_a_of_type_Twp);
        localtwm.jdField_a_of_type_Boolean = false;
      }
      for (localtwm.jdField_b_of_type_Boolean = false;; localtwm.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localtwm.c = true;
        localtwm.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Ual.a(localtwm, this.jdField_a_of_type_Twr.jdField_a_of_type_Two);
        return true;
        veg.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Twr.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
        twp localtwp = new twp(this.jdField_a_of_type_Twr.jdField_a_of_type_Two);
        localtwp.jdField_a_of_type_JavaUtilList = new ArrayList();
        localtwp.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
        localtwp.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.b);
        localtwp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString;
        localArrayList.add(localtwp);
        localtwm.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Twl = txv.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Twl == null)
    {
      veg.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Tve.finish();
      return;
    }
    this.jdField_a_of_type_Twl.a();
    this.jdField_a_of_type_Ujp = new ujp(this.jdField_a_of_type_Twl);
    this.jdField_a_of_type_Ujp.b();
  }
  
  private void j()
  {
    veg.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Twr);
    twm localtwm = this.jdField_a_of_type_Twl.a(this.jdField_a_of_type_Twr.jdField_a_of_type_Two, 3);
    if (((localtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localtwm.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      veg.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new tva(this));
        return;
        if (localtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localtwm.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      veg.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localtwm.jdField_a_of_type_Boolean), Boolean.valueOf(localtwm.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localtwm.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        twp localtwp = (twp)localtwm.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        veg.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, localtwp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localtwp.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString))) {
          localtwp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Twr.jdField_a_of_type_Two = ((twp)localtwm.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Two;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localtwm.c = false;
        this.jdField_a_of_type_Ual.a(localtwm, this.jdField_a_of_type_Twr.jdField_a_of_type_Two);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Twr.jdField_a_of_type_Two = ((twp)localtwm.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Two;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Twr });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Twl.a(this.jdField_a_of_type_Twq);
    }
    this.jdField_a_of_type_Twl.a(this.jdField_a_of_type_Twr.jdField_a_of_type_Two, 2, 5, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Twl.a(this.jdField_a_of_type_Twr.jdField_a_of_type_Two, 0, 5, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Twr.b))
    {
      this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Twr.b, true);
      this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Twr.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString))
    {
      ((tcz)tdc.a(5)).a(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
      twg.a(this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
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
        vel.b("play_video", "play_result", this.jdField_a_of_type_Tvc.a().mReportData.from, i, new String[] { str, "0", vel.a(this.jdField_a_of_type_Tvc.a()), "NO_VID" });
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
    veg.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Tvc != null) {
      this.jdField_a_of_type_Tvc.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      veg.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Tve.finish();
      return;
    }
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Udo == null)
    {
      veg.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Udo = new udo(this.jdField_a_of_type_Tve.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Tve.a().findViewById(2131375491));
    if (this.jdField_a_of_type_Tvc != null) {
      this.jdField_a_of_type_Tvc.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (suw)tdc.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Tve.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new tvb(this));
  }
  
  public void a(tve paramtve)
  {
    if ((this.jdField_a_of_type_Tve != null) || (paramtve == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Tve = paramtve;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ual.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Twr != null)
    {
      a(this.jdField_a_of_type_Twr.jdField_a_of_type_Two, this.jdField_a_of_type_Twr.jdField_a_of_type_JavaLangString);
      veg.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Ual != null) {
      this.jdField_a_of_type_Ual.b();
    }
  }
  
  public void c()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Tvc != null) {
      this.jdField_a_of_type_Tvc.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Tvc != null) {
      this.jdField_a_of_type_Tvc.d();
    }
    a();
    uee.a(this.jdField_a_of_type_Tve.a()).a();
  }
  
  public void e()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Tvc != null) {
      this.jdField_a_of_type_Tvc.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Tvc != null)
    {
      this.jdField_a_of_type_Tvc.f();
      l();
    }
  }
  
  public void g()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Ual != null) {
      this.jdField_a_of_type_Ual.d();
    }
    if (this.jdField_a_of_type_Twl != null) {
      this.jdField_a_of_type_Twl.b();
    }
    if (this.jdField_a_of_type_Ujp != null) {
      this.jdField_a_of_type_Ujp.c();
    }
    if (this.jdField_a_of_type_Tvc != null) {
      this.jdField_a_of_type_Tvc.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((suw)tdc.a(6)).a(15000L);
    }
    svg.a().a();
  }
  
  public void h()
  {
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    tvk.b();
    if (jdField_a_of_type_Udo != null)
    {
      veg.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Udo.a();
      jdField_a_of_type_Udo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */