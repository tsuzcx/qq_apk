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

public class tut
  implements tyw
{
  private static udl jdField_a_of_type_Udl;
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
  private tuz jdField_a_of_type_Tuz;
  private tvb jdField_a_of_type_Tvb;
  private twi jdField_a_of_type_Twi;
  private twl jdField_a_of_type_Twl;
  twn jdField_a_of_type_Twn = new tuu(this);
  private two jdField_a_of_type_Two;
  tzr jdField_a_of_type_Tzr = new tuv(this);
  private uai jdField_a_of_type_Uai;
  private ujm jdField_a_of_type_Ujm;
  private uvx jdField_a_of_type_Uvx = (uvx)tcz.a(11);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public tut()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new tuw(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    ved.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_Twi.a();
    this.jdField_a_of_type_Two = new two((two)localObject);
    this.jdField_a_of_type_Uai = new uai(paramRelativeLayout);
    uai localuai = this.jdField_a_of_type_Uai;
    localObject = new tuz(this, this.jdField_a_of_type_Tvb, this.jdField_a_of_type_Uai.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (two)localObject, null);
    this.jdField_a_of_type_Tuz = ((tuz)localObject);
    localuai.a((uag)localObject);
    this.jdField_a_of_type_Uai.c();
    this.jdField_a_of_type_Uai.a(this.jdField_a_of_type_Tzr);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131369486));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131379048));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Two });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(twl paramtwl, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      stb.a().dispatch(new thr(paramtwl, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      ved.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramtwl, paramString, str);
      return;
    }
  }
  
  private void a(uaz paramuaz)
  {
    if (paramuaz == null) {}
    label402:
    label413:
    label431:
    for (;;)
    {
      return;
      int i = paramuaz.jdField_a_of_type_Int;
      int j = paramuaz.jdField_b_of_type_Int;
      ved.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramuaz.jdField_a_of_type_Uas);
      Object localObject = this.jdField_a_of_type_Uai.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (twm)((List)localObject).get(i);
        if ((localObject instanceof uat)) {
          break label413;
        }
        localObject = ((twm)localObject).jdField_a_of_type_Twl;
        if (localObject == null) {
          break label402;
        }
        if (!((twl)localObject).equals(this.jdField_a_of_type_Two.jdField_a_of_type_Twl))
        {
          a(this.jdField_a_of_type_Two.jdField_a_of_type_Twl, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Two.jdField_a_of_type_Twl = ((twl)localObject);
        }
        ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Two });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramuaz.jdField_a_of_type_Uas.c()) {
          break label431;
        }
        localObject = paramuaz.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Twl;
        String str = paramuaz.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Two.b = paramuaz.jdField_a_of_type_Uas.b;
        this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString = paramuaz.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof twz))
        {
          ((twz)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_Two.jdField_a_of_type_Twm != null) {
            this.jdField_a_of_type_Two.jdField_a_of_type_Twm.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((twl)localObject).equals(this.jdField_a_of_type_Twl))) {
          break;
        }
        this.jdField_a_of_type_Twl = ((twl)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        ved.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((twl)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_Twi.a((twl)localObject, str);
        this.jdField_a_of_type_Ujm.a((twl)localObject, str);
        paramuaz = (uau)paramuaz.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(uau.class);
        if (paramuaz != null) {
          paramuaz.a(str);
        }
        stb.a().dispatch(new tzt(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (twl)localObject, str));
        return;
        ved.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((uat)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Two.jdField_a_of_type_Twl != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Two.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString)))
    {
      ved.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_Two.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      twj localtwj = new twj();
      if ((this.jdField_a_of_type_Two.jdField_a_of_type_Twm != null) && (TextUtils.equals(this.jdField_a_of_type_Two.jdField_a_of_type_Twm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Two.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        ved.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_Two.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Two.jdField_a_of_type_Twm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_Two.jdField_a_of_type_Twm);
        localtwj.jdField_a_of_type_Boolean = false;
      }
      for (localtwj.jdField_b_of_type_Boolean = false;; localtwj.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localtwj.c = true;
        localtwj.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_Uai.a(localtwj, this.jdField_a_of_type_Two.jdField_a_of_type_Twl);
        return true;
        ved.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_Two.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
        twm localtwm = new twm(this.jdField_a_of_type_Two.jdField_a_of_type_Twl);
        localtwm.jdField_a_of_type_JavaUtilList = new ArrayList();
        localtwm.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
        localtwm.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.b);
        localtwm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString;
        localArrayList.add(localtwm);
        localtwj.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Twi = txs.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_Twi == null)
    {
      ved.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Tvb.finish();
      return;
    }
    this.jdField_a_of_type_Twi.a();
    this.jdField_a_of_type_Ujm = new ujm(this.jdField_a_of_type_Twi);
    this.jdField_a_of_type_Ujm.b();
  }
  
  private void j()
  {
    ved.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_Two);
    twj localtwj = this.jdField_a_of_type_Twi.a(this.jdField_a_of_type_Two.jdField_a_of_type_Twl, 3);
    if (((localtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localtwj.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      ved.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new tux(this));
        return;
        if (localtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localtwj.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      ved.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localtwj.jdField_a_of_type_Boolean), Boolean.valueOf(localtwj.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localtwj.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        twm localtwm = (twm)localtwj.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        ved.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, localtwm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localtwm.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString))) {
          localtwm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_Two.jdField_a_of_type_Twl = ((twm)localtwj.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_Twl;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localtwj.c = false;
        this.jdField_a_of_type_Uai.a(localtwj, this.jdField_a_of_type_Two.jdField_a_of_type_Twl);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_Two.jdField_a_of_type_Twl = ((twm)localtwj.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_Twl;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_Two });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_Twi.a(this.jdField_a_of_type_Twn);
    }
    this.jdField_a_of_type_Twi.a(this.jdField_a_of_type_Two.jdField_a_of_type_Twl, 2, 5, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Twi.a(this.jdField_a_of_type_Two.jdField_a_of_type_Twl, 0, 5, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Two.b))
    {
      this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Two.b, true);
      this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Two.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString))
    {
      ((tcw)tcz.a(5)).a(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
      twd.a(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
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
        vei.b("play_video", "play_result", this.jdField_a_of_type_Tuz.a().mReportData.from, i, new String[] { str, "0", vei.a(this.jdField_a_of_type_Tuz.a()), "NO_VID" });
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
    ved.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_Tuz != null) {
      this.jdField_a_of_type_Tuz.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      ved.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_Tvb.finish();
      return;
    }
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_Udl == null)
    {
      ved.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_Udl = new udl(this.jdField_a_of_type_Tvb.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_Tvb.a().findViewById(2131375493));
    if (this.jdField_a_of_type_Tuz != null) {
      this.jdField_a_of_type_Tuz.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (sut)tcz.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_Tvb.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new tuy(this));
  }
  
  public void a(tvb paramtvb)
  {
    if ((this.jdField_a_of_type_Tvb != null) || (paramtvb == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Tvb = paramtvb;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Uai.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Two != null)
    {
      a(this.jdField_a_of_type_Two.jdField_a_of_type_Twl, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
      ved.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_Uai != null) {
      this.jdField_a_of_type_Uai.b();
    }
  }
  
  public void c()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_Tuz != null) {
      this.jdField_a_of_type_Tuz.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Tuz != null) {
      this.jdField_a_of_type_Tuz.d();
    }
    a();
    ueb.a(this.jdField_a_of_type_Tvb.a()).a();
  }
  
  public void e()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Tuz != null) {
      this.jdField_a_of_type_Tuz.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_Tuz != null)
    {
      this.jdField_a_of_type_Tuz.f();
      l();
    }
  }
  
  public void g()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_Uai != null) {
      this.jdField_a_of_type_Uai.d();
    }
    if (this.jdField_a_of_type_Twi != null) {
      this.jdField_a_of_type_Twi.b();
    }
    if (this.jdField_a_of_type_Ujm != null) {
      this.jdField_a_of_type_Ujm.c();
    }
    if (this.jdField_a_of_type_Tuz != null) {
      this.jdField_a_of_type_Tuz.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((sut)tcz.a(6)).a(15000L);
    }
    svd.a().a();
  }
  
  public void h()
  {
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    tvh.b();
    if (jdField_a_of_type_Udl != null)
    {
      ved.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_Udl.a();
      jdField_a_of_type_Udl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tut
 * JD-Core Version:    0.7.0.1
 */