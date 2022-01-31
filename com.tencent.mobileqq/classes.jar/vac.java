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

public class vac
  implements Handler.Callback, sxl, uzh, vab, vci
{
  private int a;
  public Activity a;
  public Handler a;
  protected bbgu a;
  public tcs a;
  protected uzo a;
  protected vaq a;
  public vdj a;
  protected boolean a;
  
  public vac(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Tcs = ((tcs)tcz.a(10));
  }
  
  public void a()
  {
    ved.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Uzo = new uzo(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Tcs.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Tcs.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(uzj paramuzj)
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      ved.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Vdj != null) && (this.jdField_a_of_type_Vdj.isShowing()))
      {
        ved.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramuzj == null)
      {
        ved.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      ved.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramuzj.b));
    } while (paramuzj.b <= i);
    this.jdField_a_of_type_Tcs.b("qqstory_guide_info_seqno", Integer.valueOf(paramuzj.b));
    vdj localvdj = new vdj(this.jdField_a_of_type_AndroidAppActivity, 2131755863);
    localvdj.b(paramuzj.a).c(paramuzj.c).d(paramuzj.e).b(new val(this, localvdj)).e(paramuzj.d).a(new vak(this, localvdj)).setCancelable(true);
    localvdj.c(new vam(this, localvdj));
    localvdj.setCanceledOnTouchOutside(true);
    localvdj.show();
    vei.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(vaq paramvaq)
  {
    this.jdField_a_of_type_Vaq = paramvaq;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    ved.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Tcs.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bbgu.setTitle(ajya.a(2131714481));
      this.jdField_a_of_type_Bbgu.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bbgu.setNegativeButton(ajya.a(2131714466), new vae(this)).setPositiveButton("立即拍摄", new vad(this));
      this.jdField_a_of_type_Bbgu.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166336));
      this.jdField_a_of_type_Bbgu.setOnDismissListener(new vaf(this));
      this.jdField_a_of_type_Bbgu.show();
      vei.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    vcf localvcf = (vcf)this.jdField_a_of_type_Vaq.a("LocalVideoPushSegment");
    if (localvcf != null) {
      localvcf.a(this);
    }
  }
  
  public boolean b()
  {
    mxu localmxu = (mxu)QQStoryContext.a().getManager(70);
    if (localmxu == null)
    {
      ved.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localmxu.a();
    if ((localRedDotInfo == null) && (((tfz)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      ved.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localmxu.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localmxu.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        ved.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      ved.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((tcs)tcz.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    ved.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((sss)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Tcs.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      ved.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    ved.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Tcs.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    ved.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (vym.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Uzo.c();
      this.jdField_a_of_type_Uzo.a(new uzk(null)).a(new uzp(this)).a(new uzc()).a(new uzf(this)).a(new vao(this)).a(new van(this)).a();
      tki.d();
      return true;
    }
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131714456), 0).a();
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
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    if (this.jdField_a_of_type_Vdj != null)
    {
      this.jdField_a_of_type_Vdj.dismiss();
      this.jdField_a_of_type_Vdj = null;
    }
  }
  
  public void g()
  {
    ved.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    if (this.jdField_a_of_type_Vdj != null)
    {
      this.jdField_a_of_type_Vdj.dismiss();
      this.jdField_a_of_type_Vdj = null;
    }
    if (this.jdField_a_of_type_Uzo != null) {
      this.jdField_a_of_type_Uzo.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    vzl.a();
    vzl.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    ved.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((vcf)this.jdField_a_of_type_Vaq.a("LocalVideoPushSegment")).e_(true);
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
      localObject = new uof(QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, false, false);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 80001);
      return;
    }
    try
    {
      sxo.a(this.jdField_a_of_type_AndroidAppActivity);
      vei.a("video_shoot", "clk_local", 0, 0, new String[0]);
      localObject = vwj.a();
      if (((vwj)localObject).a())
      {
        ((vwj)localObject).b(this.jdField_a_of_type_AndroidAppActivity, null, 10006);
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
 * Qualified Name:     vac
 * JD-Core Version:    0.7.0.1
 */