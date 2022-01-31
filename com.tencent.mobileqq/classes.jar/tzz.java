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
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class tzz
  extends uaf
{
  public int a;
  public long a;
  public StoryPlayerGroupHolder a;
  public String a;
  public uai a;
  public boolean a;
  public String b;
  public String c;
  
  public tzz()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == StoryPlayerActivity.jdField_a_of_type_Int) {
      b();
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void a(ArrayList<String> paramArrayList, String paramString, int paramInt)
  {
    ThreadManager.executeOnSubThread(new PromoteWidgetController.1(this, paramArrayList, paramString, paramInt));
  }
  
  public void a(@NonNull twj paramtwj, String paramString)
  {
    int i = this.jdField_a_of_type_Uai.a().a().mReportData.from;
    ved.a("PromoteWidgetController", "onViewHolderBindData() from: %d, groupId: %s, isFinish: %b, isFastData: %b", Integer.valueOf(i), paramString, Boolean.valueOf(this.jdField_a_of_type_Uai.a().isFinishing()), Boolean.valueOf(paramtwj.c));
    if (paramtwj.c)
    {
      ved.b("PromoteWidgetController", "onViewHolderBindData() fastData will ignore");
      return;
    }
    this.jdField_a_of_type_Int = 0;
    switch (i)
    {
    default: 
      ved.a("PromoteWidgetController", "onViewHolderBindData() from(%d) mismatch, will not promote!", Integer.valueOf(i));
      return;
    }
    for (this.jdField_a_of_type_Int = 1; TextUtils.equals(this.b, paramString); this.jdField_a_of_type_Int = 2)
    {
      ved.b("PromoteWidgetController", "onViewHolderBindData() not first bind");
      return;
    }
    int j = paramtwj.jdField_a_of_type_JavaUtilList.size();
    i = 0;
    label153:
    twm localtwm;
    String str;
    Object localObject;
    label238:
    ArrayList localArrayList;
    if (i < j)
    {
      localtwm = (twm)paramtwj.jdField_a_of_type_JavaUtilList.get(i);
      ved.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: %s", Integer.valueOf(i), Integer.valueOf(j), localtwm);
      str = localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString;
      if (!(localtwm.jdField_a_of_type_Twl instanceof twa)) {
        break label383;
      }
      localObject = ((twa)localtwm.jdField_a_of_type_Twl).a;
      if (localObject == null) {
        break label374;
      }
      localObject = ((uvp)localObject).b;
      localArrayList = new ArrayList(new HashSet(localtwm.jdField_a_of_type_JavaUtilMap.values()));
      ved.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: groupId: %s, feedId: %s", Integer.valueOf(i), Integer.valueOf(j), str, localArrayList);
      if (TextUtils.equals(str, paramString))
      {
        ved.d("PromoteWidgetController", "onViewHolderBindData() Find groupId: %s, feeds: %s, unionId: %s", new Object[] { str, localArrayList, localObject });
        if ((!localArrayList.isEmpty()) && (!TextUtils.equals(this.b, paramString)))
        {
          if ((localArrayList.size() <= 1) || (this.jdField_a_of_type_Int != 2)) {
            break label390;
          }
          ved.d("PromoteWidgetController", "onViewHolderBindData(), feedIds size > 1, unexpected!");
        }
      }
    }
    for (;;)
    {
      this.b = paramString;
      i += 1;
      break label153;
      break;
      label374:
      vxp.a("groupInfo FeedIdListSeqInfo is null!", new Object[0]);
      label383:
      localObject = str;
      break label238;
      label390:
      a(localArrayList, (String)localObject, localtwm.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(uai paramuai)
  {
    ved.a("PromoteWidgetController", "attachHolder(%s)", paramuai);
    this.jdField_a_of_type_Uai = paramuai;
    ((tcx)tcz.a(29)).a(false);
    this.jdField_a_of_type_Uai.a(this);
  }
  
  public boolean a()
  {
    ved.b("PromoteWidgetController", "preloadWebProcessAndUrl()");
    Object localObject1 = ((tcx)tcz.a(29)).b;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ved.a("PromoteWidgetController", "preloadWebProcessAndUrl() url is null! %s", localObject1);
      this.c = "";
    }
    for (;;)
    {
      return false;
      Object localObject2 = bfnx.a((String)localObject1);
      if (!((Map)localObject2).containsKey("sonic")) {
        this.c = bfnx.a((String)localObject1, "sonic", "1");
      }
      if (!((Map)localObject2).containsKey("vid")) {
        this.c = bfnx.a((String)localObject1, "vid", this.jdField_a_of_type_JavaLangString);
      }
      localObject1 = (WebProcessManager)QQStoryContext.a().getManager(13);
      if (localObject1 != null)
      {
        if (((WebProcessManager)localObject1).d()) {
          ((WebProcessManager)localObject1).a(203, new uaa(this));
        }
        while (SonicPreloader.isWifiOrG3OrG4())
        {
          localObject2 = new SonicPreloadData(1003, this.c, true, 0L, 0);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          boolean bool = ((WebProcessManager)localObject1).a(localArrayList);
          ved.a("PromoteWidgetController", "preloadSonicSession() load url %s: return %b.", this.c, Boolean.valueOf(bool));
          return bool;
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected boolean a(long paramLong)
  {
    if (TextUtils.isEmpty(this.c))
    {
      ved.b("PromoteWidgetController", "tryStartPromoteWebActivity() url is null, ignore!");
      return false;
    }
    if (!SonicPreloader.isWifiOrG3OrG4())
    {
      ved.b("PromoteWidgetController", "tryStartPromoteWebActivity() network not ready, ignore!");
      return false;
    }
    vei.a("weishi_share", "video_cover_exp", 0, 0, new String[] { "", this.jdField_a_of_type_JavaLangString });
    Intent localIntent = StoryPlayerWebFragment.a(this.jdField_a_of_type_Uai.a(), this.c);
    abtq.a(this.jdField_a_of_type_Uai.a(), localIntent, PublicFragmentActivityForTool.class, StoryPlayerWebToolFragment.class, StoryPlayerActivity.jdField_a_of_type_Int);
    ThreadManager.executeOnSubThread(new PromoteWidgetController.3(this, paramLong));
    return true;
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, ucz paramucz, boolean paramBoolean)
  {
    boolean bool = false;
    ved.a("PromoteWidgetController", "handleVideoCompletion(%s, %s, %b)", paramVideoViewVideoHolder, paramucz, Boolean.valueOf(paramBoolean));
    paramVideoViewVideoHolder = this.jdField_a_of_type_Uai.a();
    int i = 0;
    int j = -1;
    while (i < paramVideoViewVideoHolder.size())
    {
      if (TextUtils.equals(((twm)paramVideoViewVideoHolder.get(i)).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, this.b)) {
        j = i;
      }
      i += 1;
    }
    paramBoolean = bool;
    if (j >= 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = this.jdField_a_of_type_Uai.a(j);
      paramBoolean = bool;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder != null)
      {
        paramBoolean = bool;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a.a().getCount() - 1 == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a.c())
        {
          ved.a("PromoteWidgetController", "handleVideoCompletion() match last video!! promoteTaskId: %d, fragmentLoaded: %b", Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean));
          paramBoolean = bool;
          if (this.jdField_a_of_type_Boolean)
          {
            paramBoolean = bool;
            if (this.jdField_a_of_type_Long != -1L)
            {
              paramBoolean = bool;
              if (!TextUtils.isEmpty(this.c))
              {
                bool = a(this.jdField_a_of_type_Long);
                paramBoolean = bool;
                if (!bool)
                {
                  this.jdField_a_of_type_Long = -1L;
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
  
  public boolean b()
  {
    ved.b("PromoteWidgetController", "closePromoteWidget()");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      vei.a("weishi_share", "video_cover_close", 0, 0, new String[] { "", this.jdField_a_of_type_JavaLangString });
    }
    this.b = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder != null)
    {
      XViewPager localXViewPager = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a();
      if (localXViewPager.c() < localXViewPager.a().getCount() - 1)
      {
        localXViewPager.setCurrentItem(localXViewPager.c() + 1, true);
        return true;
      }
      this.jdField_a_of_type_Uai.a().finish();
      vei.a("play_video", "auto_quit", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzz
 * JD-Core Version:    0.7.0.1
 */