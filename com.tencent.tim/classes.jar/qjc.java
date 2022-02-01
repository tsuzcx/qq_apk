import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController.3;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebToolFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class qjc
  extends qjh
{
  public long AL = -1L;
  public StoryPlayerGroupHolder a;
  public boolean aDD;
  public String axv;
  public String axw;
  public String axx;
  public qjk b;
  public int bmy;
  
  public boolean JF()
  {
    ram.d("PromoteWidgetController", "preloadWebProcessAndUrl()");
    Object localObject1 = ((psv)psx.a(29)).mUrl;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ram.b("PromoteWidgetController", "preloadWebProcessAndUrl() url is null! %s", localObject1);
      this.axx = "";
    }
    for (;;)
    {
      return false;
      Object localObject2 = aurr.getArgumentsFromURL((String)localObject1);
      if (!((Map)localObject2).containsKey("sonic")) {
        this.axx = aurr.addParameter((String)localObject1, "sonic", "1");
      }
      if (!((Map)localObject2).containsKey("vid")) {
        this.axx = aurr.addParameter((String)localObject1, "vid", this.axv);
      }
      localObject1 = (WebProcessManager)QQStoryContext.c().getManager(13);
      if (localObject1 != null)
      {
        if (((WebProcessManager)localObject1).aFT()) {
          ((WebProcessManager)localObject1).a(203, new qjd(this));
        }
        while (SonicPreloader.isWifiOrG3OrG4())
        {
          localObject2 = new SonicPreloadData(1003, this.axx, true, 0L, 0);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          boolean bool = ((WebProcessManager)localObject1).U(localArrayList);
          ram.b("PromoteWidgetController", "preloadSonicSession() load url %s: return %b.", this.axx, Boolean.valueOf(bool));
          return bool;
          this.aDD = true;
        }
      }
    }
  }
  
  public boolean JG()
  {
    ram.d("PromoteWidgetController", "closePromoteWidget()");
    if (!TextUtils.isEmpty(this.axv)) {
      rar.a("weishi_share", "video_cover_close", 0, 0, new String[] { "", this.axv });
    }
    this.axw = "";
    this.AL = -1L;
    this.axv = "";
    if (this.a != null)
    {
      XViewPager localXViewPager = this.a.a();
      if (localXViewPager.getCurrentItem() < localXViewPager.getAdapter().getCount() - 1)
      {
        localXViewPager.setCurrentItem(localXViewPager.getCurrentItem() + 1, true);
        return true;
      }
      this.b.n().finish();
      rar.a("play_video", "auto_quit", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  public boolean Js()
  {
    return false;
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void a(@NonNull qgy.a parama, String paramString)
  {
    int i = this.b.a().a().mReportData.from;
    ram.a("PromoteWidgetController", "onViewHolderBindData() from: %d, groupId: %s, isFinish: %b, isFastData: %b", Integer.valueOf(i), paramString, Boolean.valueOf(this.b.n().isFinishing()), Boolean.valueOf(parama.aDr));
    if (parama.aDr)
    {
      ram.d("PromoteWidgetController", "onViewHolderBindData() fastData will ignore");
      return;
    }
    this.bmy = 0;
    switch (i)
    {
    default: 
      ram.b("PromoteWidgetController", "onViewHolderBindData() from(%d) mismatch, will not promote!", Integer.valueOf(i));
      return;
    }
    for (this.bmy = 1; TextUtils.equals(this.axw, paramString); this.bmy = 2)
    {
      ram.d("PromoteWidgetController", "onViewHolderBindData() not first bind");
      return;
    }
    int j = parama.nP.size();
    i = 0;
    label154:
    qgy.d locald;
    String str;
    Object localObject;
    label240:
    ArrayList localArrayList;
    if (i < j)
    {
      locald = (qgy.d)parama.nP.get(i);
      ram.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: %s", Integer.valueOf(i), Integer.valueOf(j), locald);
      str = locald.d.groupId;
      if (!(locald.d instanceof qgr.a)) {
        break label389;
      }
      localObject = ((qgr.a)locald.d).a;
      if (localObject == null) {
        break label379;
      }
      localObject = ((qvd)localObject).mUnionId;
      localArrayList = new ArrayList(new HashSet(locald.fR.values()));
      ram.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: groupId: %s, feedId: %s", Integer.valueOf(i), Integer.valueOf(j), str, localArrayList);
      if (TextUtils.equals(str, paramString))
      {
        ram.w("PromoteWidgetController", "onViewHolderBindData() Find groupId: %s, feeds: %s, unionId: %s", new Object[] { str, localArrayList, localObject });
        if ((!localArrayList.isEmpty()) && (!TextUtils.equals(this.axw, paramString)))
        {
          if ((localArrayList.size() <= 1) || (this.bmy != 2)) {
            break label396;
          }
          ram.w("PromoteWidgetController", "onViewHolderBindData(), feedIds size > 1, unexpected!");
        }
      }
    }
    for (;;)
    {
      this.axw = paramString;
      i += 1;
      break label154;
      break;
      label379:
      rom.fail("groupInfo FeedIdListSeqInfo is null!", new Object[0]);
      label389:
      localObject = str;
      break label240;
      label396:
      b(localArrayList, (String)localObject, locald.nv.size());
    }
  }
  
  public void a(qjk paramqjk)
  {
    ram.b("PromoteWidgetController", "attachHolder(%s)", paramqjk);
    this.b = paramqjk;
    ((psv)psx.a(29)).sk(false);
    this.b.a(this);
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, boolean paramBoolean)
  {
    boolean bool = false;
    ram.a("PromoteWidgetController", "handleVideoCompletion(%s, %s, %b)", paramVideoViewVideoHolder, paramqlb, Boolean.valueOf(paramBoolean));
    paramVideoViewVideoHolder = this.b.be();
    int i = 0;
    int j = -1;
    while (i < paramVideoViewVideoHolder.size())
    {
      if (TextUtils.equals(((qgy.d)paramVideoViewVideoHolder.get(i)).d.groupId, this.axw)) {
        j = i;
      }
      i += 1;
    }
    paramBoolean = bool;
    if (j >= 0)
    {
      this.a = this.b.a(j);
      paramBoolean = bool;
      if (this.a != null)
      {
        paramBoolean = bool;
        if (this.a.a.getAdapter().getCount() - 1 == this.a.a.getCurrentItem())
        {
          ram.b("PromoteWidgetController", "handleVideoCompletion() match last video!! promoteTaskId: %d, fragmentLoaded: %b", Long.valueOf(this.AL), Boolean.valueOf(this.aDD));
          paramBoolean = bool;
          if (this.aDD)
          {
            paramBoolean = bool;
            if (this.AL != -1L)
            {
              paramBoolean = bool;
              if (!TextUtils.isEmpty(this.axx))
              {
                bool = aY(this.AL);
                paramBoolean = bool;
                if (!bool)
                {
                  this.AL = -1L;
                  paramBoolean = bool;
                }
              }
            }
          }
        }
      }
    }
    return paramBoolean;
  }
  
  protected boolean aY(long paramLong)
  {
    if (TextUtils.isEmpty(this.axx))
    {
      ram.d("PromoteWidgetController", "tryStartPromoteWebActivity() url is null, ignore!");
      return false;
    }
    if (!SonicPreloader.isWifiOrG3OrG4())
    {
      ram.d("PromoteWidgetController", "tryStartPromoteWebActivity() network not ready, ignore!");
      return false;
    }
    rar.a("weishi_share", "video_cover_exp", 0, 0, new String[] { "", this.axv });
    Intent localIntent = StoryPlayerWebFragment.c(this.b.n(), this.axx);
    PublicFragmentActivity.b.startForResult(this.b.n(), localIntent, PublicFragmentActivityForTool.class, StoryPlayerWebToolFragment.class, StoryPlayerActivity.blW);
    ThreadManager.executeOnSubThread(new PromoteWidgetController.3(this, paramLong));
    return true;
  }
  
  public void b(ArrayList<String> paramArrayList, String paramString, int paramInt)
  {
    ThreadManager.executeOnSubThread(new PromoteWidgetController.1(this, paramArrayList, paramString, paramInt));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == StoryPlayerActivity.blW) {
      JG();
    }
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjc
 * JD-Core Version:    0.7.0.1
 */