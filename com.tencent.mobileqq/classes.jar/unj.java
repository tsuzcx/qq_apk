import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class unj
  implements Handler.Callback, sks, umo, uni, upp
{
  private int a;
  public Activity a;
  public Handler a;
  protected bafb a;
  public spz a;
  protected umv a;
  protected unx a;
  public uqq a;
  protected boolean a;
  
  public unj(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Spz = ((spz)sqg.a(10));
  }
  
  public void a()
  {
    urk.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Umv = new umv(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Spz.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Spz.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(umq paramumq)
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      urk.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Uqq != null) && (this.jdField_a_of_type_Uqq.isShowing()))
      {
        urk.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramumq == null)
      {
        urk.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      urk.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramumq.b));
    } while (paramumq.b <= i);
    this.jdField_a_of_type_Spz.b("qqstory_guide_info_seqno", Integer.valueOf(paramumq.b));
    uqq localuqq = new uqq(this.jdField_a_of_type_AndroidAppActivity, 2131690253);
    localuqq.b(paramumq.a).c(paramumq.c).d(paramumq.e).b(new uns(this, localuqq)).e(paramumq.d).a(new unr(this, localuqq)).setCancelable(true);
    localuqq.c(new unt(this, localuqq));
    localuqq.setCanceledOnTouchOutside(true);
    localuqq.show();
    urp.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(unx paramunx)
  {
    this.jdField_a_of_type_Unx = paramunx;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    urk.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Spz.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bafb.setTitle(ajjy.a(2131648681));
      this.jdField_a_of_type_Bafb.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bafb.setNegativeButton(ajjy.a(2131648666), new unl(this)).setPositiveButton("立即拍摄", new unk(this));
      this.jdField_a_of_type_Bafb.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100743));
      this.jdField_a_of_type_Bafb.setOnDismissListener(new unm(this));
      this.jdField_a_of_type_Bafb.show();
      urp.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    upm localupm = (upm)this.jdField_a_of_type_Unx.a("LocalVideoPushSegment");
    if (localupm != null) {
      localupm.a(this);
    }
  }
  
  public boolean b()
  {
    mmy localmmy = (mmy)QQStoryContext.a().getManager(70);
    if (localmmy == null)
    {
      urk.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localmmy.a();
    if ((localRedDotInfo == null) && (((stg)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      urk.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localmmy.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localmmy.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        urk.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      urk.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((spz)sqg.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    urk.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((sfz)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Spz.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      urk.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    urk.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Spz.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    urk.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (vlt.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Umv.c();
      this.jdField_a_of_type_Umv.a(new umr(null)).a(new umw(this)).a(new umj()).a(new umm(this)).a(new unv(this)).a(new unu(this)).a();
      sxp.d();
      return true;
    }
    bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131648656), 0).a();
    return false;
  }
  
  public void e() {}
  
  public boolean e()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(QQStoryContext.a());
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    if (this.jdField_a_of_type_Uqq != null)
    {
      this.jdField_a_of_type_Uqq.dismiss();
      this.jdField_a_of_type_Uqq = null;
    }
  }
  
  public void g()
  {
    urk.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    if (this.jdField_a_of_type_Uqq != null)
    {
      this.jdField_a_of_type_Uqq.dismiss();
      this.jdField_a_of_type_Uqq = null;
    }
    if (this.jdField_a_of_type_Umv != null) {
      this.jdField_a_of_type_Umv.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    vms.a();
    vms.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    urk.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((upm)this.jdField_a_of_type_Unx.a("LocalVideoPushSegment")).f_(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.StoryListPresenter", 2, "localVideoClick");
    }
    if (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      QLog.e("Q.qqstory.home.StoryListPresenter", 2, "context == null");
      return;
    }
    Object localObject;
    if (!e())
    {
      localObject = new ubm(QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, false, false);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 80001);
      return;
    }
    try
    {
      skv.a(this.jdField_a_of_type_AndroidAppActivity);
      urp.a("video_shoot", "clk_local", 0, 0, new String[0]);
      localObject = vjq.a();
      if (((vjq)localObject).a())
      {
        ((vjq)localObject).b(this.jdField_a_of_type_AndroidAppActivity, null, 10006);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("Q.qqstory.home.StoryListPresenter", 4, "QQStoryFlowCallback ", localException);
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQStoryMainActivity)) {}
    for (String str = "from_home";; str = "from_now")
    {
      QQStoryFlowCallback.a(this.jdField_a_of_type_AndroidAppActivity, 0, "qqstory", null, LocalVideoSelectActivity.class.getName(), str, true, 99, 10006);
      return;
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unj
 * JD-Core Version:    0.7.0.1
 */