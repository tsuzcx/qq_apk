import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class wou
  implements Handler.Callback, umd, wnz, wot, wra
{
  private int a;
  public Activity a;
  public Handler a;
  protected bdfq a;
  public urk a;
  protected wog a;
  protected wpi a;
  public wsb a;
  protected boolean a;
  
  public wou(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Urk = ((urk)urr.a(10));
  }
  
  public void a()
  {
    wsv.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Wog = new wog(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Urk.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
    }
    for (;;)
    {
      h();
      d();
      return;
      d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    i();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Urk.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(wob paramwob)
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      wsv.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Wsb != null) && (this.jdField_a_of_type_Wsb.isShowing()))
      {
        wsv.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramwob == null)
      {
        wsv.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      wsv.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramwob.b));
    } while (paramwob.b <= i);
    this.jdField_a_of_type_Urk.b("qqstory_guide_info_seqno", Integer.valueOf(paramwob.b));
    wsb localwsb = new wsb(this.jdField_a_of_type_AndroidAppActivity, 2131755880);
    localwsb.b(paramwob.a).c(paramwob.c).d(paramwob.e).b(new wpd(this, localwsb)).e(paramwob.d).a(new wpc(this, localwsb)).setCancelable(true);
    localwsb.c(new wpe(this, localwsb));
    localwsb.setCanceledOnTouchOutside(true);
    localwsb.show();
    wta.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(wpi paramwpi)
  {
    this.jdField_a_of_type_Wpi = paramwpi;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    wsv.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Urk.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bdfq.setTitle(alpo.a(2131714853));
      this.jdField_a_of_type_Bdfq.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bdfq.setNegativeButton(alpo.a(2131714838), new wow(this)).setPositiveButton("立即拍摄", new wov(this));
      this.jdField_a_of_type_Bdfq.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166383));
      this.jdField_a_of_type_Bdfq.setOnDismissListener(new wox(this));
      this.jdField_a_of_type_Bdfq.show();
      wta.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    wqx localwqx = (wqx)this.jdField_a_of_type_Wpi.a("LocalVideoPushSegment");
    if (localwqx != null) {
      localwqx.a(this);
    }
  }
  
  public boolean b()
  {
    nan localnan = (nan)QQStoryContext.a().getManager(70);
    if (localnan == null)
    {
      wsv.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localnan.a();
    if ((localRedDotInfo == null) && (((uur)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      wsv.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localnan.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localnan.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        wsv.b("Q.qqstory.home.StoryListPresenter", "it have red point");
        int i = localRedDotInfo.uint32_last_time.get();
        if ((i > 0) && (i > this.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Int = i;
          return true;
        }
        return false;
      }
      return false;
    }
  }
  
  protected void c()
  {
    if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      wsv.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((urk)urr.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    wsv.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((uhk)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Urk.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      wsv.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    wsv.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Urk.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    wsv.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (xne.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Wog.c();
      this.jdField_a_of_type_Wog.a(new woc(null)).a(new woh(this)).a(new wnu()).a(new wnx(this)).a(new wpg(this)).a(new wpf(this)).a();
      uza.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131714828), 0).a();
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
    if (this.jdField_a_of_type_Wsb != null)
    {
      this.jdField_a_of_type_Wsb.dismiss();
      this.jdField_a_of_type_Wsb = null;
    }
  }
  
  public void g()
  {
    wsv.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
    if (this.jdField_a_of_type_Wsb != null)
    {
      this.jdField_a_of_type_Wsb.dismiss();
      this.jdField_a_of_type_Wsb = null;
    }
    if (this.jdField_a_of_type_Wog != null) {
      this.jdField_a_of_type_Wog.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    xod.a();
    xod.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    wsv.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((wqx)this.jdField_a_of_type_Wpi.a("LocalVideoPushSegment")).e_(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i() {}
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wou
 * JD-Core Version:    0.7.0.1
 */