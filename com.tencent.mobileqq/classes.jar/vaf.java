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

public class vaf
  implements Handler.Callback, sxo, uzk, vae, vcl
{
  private int a;
  public Activity a;
  public Handler a;
  protected bbgg a;
  public tcv a;
  protected uzr a;
  protected vat a;
  public vdm a;
  protected boolean a;
  
  public vaf(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Tcv = ((tcv)tdc.a(10));
  }
  
  public void a()
  {
    veg.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Uzr = new uzr(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Tcv.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Tcv.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(uzm paramuzm)
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      veg.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Vdm != null) && (this.jdField_a_of_type_Vdm.isShowing()))
      {
        veg.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramuzm == null)
      {
        veg.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      veg.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramuzm.b));
    } while (paramuzm.b <= i);
    this.jdField_a_of_type_Tcv.b("qqstory_guide_info_seqno", Integer.valueOf(paramuzm.b));
    vdm localvdm = new vdm(this.jdField_a_of_type_AndroidAppActivity, 2131755863);
    localvdm.b(paramuzm.a).c(paramuzm.c).d(paramuzm.e).b(new vao(this, localvdm)).e(paramuzm.d).a(new van(this, localvdm)).setCancelable(true);
    localvdm.c(new vap(this, localvdm));
    localvdm.setCanceledOnTouchOutside(true);
    localvdm.show();
    vel.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(vat paramvat)
  {
    this.jdField_a_of_type_Vat = paramvat;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    veg.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Tcv.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bbgg.setTitle(ajyc.a(2131714470));
      this.jdField_a_of_type_Bbgg.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bbgg.setNegativeButton(ajyc.a(2131714455), new vah(this)).setPositiveButton("立即拍摄", new vag(this));
      this.jdField_a_of_type_Bbgg.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166336));
      this.jdField_a_of_type_Bbgg.setOnDismissListener(new vai(this));
      this.jdField_a_of_type_Bbgg.show();
      vel.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    vci localvci = (vci)this.jdField_a_of_type_Vat.a("LocalVideoPushSegment");
    if (localvci != null) {
      localvci.a(this);
    }
  }
  
  public boolean b()
  {
    mxx localmxx = (mxx)QQStoryContext.a().getManager(70);
    if (localmxx == null)
    {
      veg.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localmxx.a();
    if ((localRedDotInfo == null) && (((tgc)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      veg.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localmxx.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localmxx.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        veg.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      veg.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((tcv)tdc.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    veg.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((ssv)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Tcv.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      veg.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    veg.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Tcv.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    veg.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (vyp.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Uzr.c();
      this.jdField_a_of_type_Uzr.a(new uzn(null)).a(new uzs(this)).a(new uzf()).a(new uzi(this)).a(new var(this)).a(new vaq(this)).a();
      tkl.d();
      return true;
    }
    bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131714445), 0).a();
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
    if (this.jdField_a_of_type_Bbgg != null)
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
    }
    if (this.jdField_a_of_type_Vdm != null)
    {
      this.jdField_a_of_type_Vdm.dismiss();
      this.jdField_a_of_type_Vdm = null;
    }
  }
  
  public void g()
  {
    veg.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bbgg != null)
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
    }
    if (this.jdField_a_of_type_Vdm != null)
    {
      this.jdField_a_of_type_Vdm.dismiss();
      this.jdField_a_of_type_Vdm = null;
    }
    if (this.jdField_a_of_type_Uzr != null) {
      this.jdField_a_of_type_Uzr.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    vzo.a();
    vzo.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    veg.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((vci)this.jdField_a_of_type_Vat.a("LocalVideoPushSegment")).e_(true);
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
      localObject = new uoi(QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, false, false);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 80001);
      return;
    }
    try
    {
      sxr.a(this.jdField_a_of_type_AndroidAppActivity);
      vel.a("video_shoot", "clk_local", 0, 0, new String[0]);
      localObject = vwm.a();
      if (((vwm)localObject).a())
      {
        ((vwm)localObject).b(this.jdField_a_of_type_AndroidAppActivity, null, 10006);
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
 * Qualified Name:     vaf
 * JD-Core Version:    0.7.0.1
 */