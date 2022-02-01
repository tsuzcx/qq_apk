import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class xru
  implements Handler.Callback, vpk, xqz, xrt, xua
{
  private int a;
  public Activity a;
  public Handler a;
  protected QQCustomDialog a;
  public vuq a;
  protected xrg a;
  protected xsi a;
  public xvb a;
  protected boolean a;
  
  public xru(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Vuq = ((vuq)vux.a(10));
  }
  
  public void a()
  {
    xvv.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Xrg = new xrg(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Vuq.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Vuq.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(xrb paramxrb)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      xvv.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Xvb != null) && (this.jdField_a_of_type_Xvb.isShowing()))
      {
        xvv.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramxrb == null)
      {
        xvv.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      xvv.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramxrb.b));
    } while (paramxrb.b <= i);
    this.jdField_a_of_type_Vuq.b("qqstory_guide_info_seqno", Integer.valueOf(paramxrb.b));
    xvb localxvb = new xvb(this.jdField_a_of_type_AndroidAppActivity, 2131755903);
    localxvb.b(paramxrb.a).c(paramxrb.c).d(paramxrb.e).b(new xsd(this, localxvb)).e(paramxrb.d).a(new xsc(this, localxvb)).setCancelable(true);
    localxvb.c(new xse(this, localxvb));
    localxvb.setCanceledOnTouchOutside(true);
    localxvb.show();
    xwa.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(xsi paramxsi)
  {
    this.jdField_a_of_type_Xsi = paramxsi;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    xvv.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Vuq.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(amtj.a(2131713507));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(amtj.a(2131713492), new xrw(this)).setPositiveButton("立即拍摄", new xrv(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166482));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new xrx(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      xwa.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    xtx localxtx = (xtx)this.jdField_a_of_type_Xsi.a("LocalVideoPushSegment");
    if (localxtx != null) {
      localxtx.a(this);
    }
  }
  
  public boolean b()
  {
    nmq localnmq = (nmq)QQStoryContext.a().getManager(70);
    if (localnmq == null)
    {
      xvv.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localnmq.a();
    if ((localRedDotInfo == null) && (((vxx)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      xvv.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localnmq.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localnmq.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        xvv.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      xvv.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((vuq)vux.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    xvv.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((vkz)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getBusinessHandler(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Vuq.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      xvv.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    xvv.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Vuq.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    xvv.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (ypp.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Xrg.c();
      this.jdField_a_of_type_Xrg.a(new xrc(null)).a(new xrh(this)).a(new xqu()).a(new xqx(this)).a(new xsg(this)).a(new xsf(this)).a();
      wcg.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131713482), 0).a();
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Xvb != null)
    {
      this.jdField_a_of_type_Xvb.dismiss();
      this.jdField_a_of_type_Xvb = null;
    }
  }
  
  public void g()
  {
    xvv.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Xvb != null)
    {
      this.jdField_a_of_type_Xvb.dismiss();
      this.jdField_a_of_type_Xvb = null;
    }
    if (this.jdField_a_of_type_Xrg != null) {
      this.jdField_a_of_type_Xrg.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    UIUtils.clearImageCache();
    UIUtils.pauseImageLoader(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    xvv.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((xtx)this.jdField_a_of_type_Xsi.a("LocalVideoPushSegment")).d_(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xru
 * JD-Core Version:    0.7.0.1
 */