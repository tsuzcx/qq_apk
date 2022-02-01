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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class ygp
  implements Handler.Callback, wef, yfu, ygo, yiv
{
  private int a;
  public Activity a;
  public Handler a;
  protected QQCustomDialog a;
  public wjl a;
  protected ygb a;
  protected yhd a;
  public yjw a;
  protected boolean a;
  
  public ygp(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wjl = ((wjl)wjs.a(10));
  }
  
  public void a()
  {
    ykq.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ygb = new ygb(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Wjl.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Wjl.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(yfw paramyfw)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      ykq.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Yjw != null) && (this.jdField_a_of_type_Yjw.isShowing()))
      {
        ykq.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramyfw == null)
      {
        ykq.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      ykq.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramyfw.b));
    } while (paramyfw.b <= i);
    this.jdField_a_of_type_Wjl.b("qqstory_guide_info_seqno", Integer.valueOf(paramyfw.b));
    yjw localyjw = new yjw(this.jdField_a_of_type_AndroidAppActivity, 2131755907);
    localyjw.b(paramyfw.a).c(paramyfw.c).d(paramyfw.e).b(new ygy(this, localyjw)).e(paramyfw.d).a(new ygx(this, localyjw)).setCancelable(true);
    localyjw.c(new ygz(this, localyjw));
    localyjw.setCanceledOnTouchOutside(true);
    localyjw.show();
    ykv.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(yhd paramyhd)
  {
    this.jdField_a_of_type_Yhd = paramyhd;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    ykq.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Wjl.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(anvx.a(2131713854));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(anvx.a(2131713839), new ygr(this)).setPositiveButton("立即拍摄", new ygq(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166496));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ygs(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      ykv.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    yis localyis = (yis)this.jdField_a_of_type_Yhd.a("LocalVideoPushSegment");
    if (localyis != null) {
      localyis.a(this);
    }
  }
  
  public boolean b()
  {
    ntq localntq = (ntq)QQStoryContext.a().getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (localntq == null)
    {
      ykq.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localntq.a();
    if ((localRedDotInfo == null) && (((wms)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean))
    {
      ykq.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localntq.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localntq.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        ykq.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      ykq.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((wjl)wjs.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    ykq.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((vzu)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Wjl.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      ykq.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    ykq.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Wjl.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    ykq.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (zei.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ygb.c();
      this.jdField_a_of_type_Ygb.a(new yfx(null)).a(new ygc(this)).a(new yfp()).a(new yfs(this)).a(new yhb(this)).a(new yha(this)).a();
      wrb.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131713829), 0).a();
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
    if (this.jdField_a_of_type_Yjw != null)
    {
      this.jdField_a_of_type_Yjw.dismiss();
      this.jdField_a_of_type_Yjw = null;
    }
  }
  
  public void g()
  {
    ykq.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Yjw != null)
    {
      this.jdField_a_of_type_Yjw.dismiss();
      this.jdField_a_of_type_Yjw = null;
    }
    if (this.jdField_a_of_type_Ygb != null) {
      this.jdField_a_of_type_Ygb.c();
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
    ykq.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((yis)this.jdField_a_of_type_Yhd.a("LocalVideoPushSegment")).d_(true);
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
 * Qualified Name:     ygp
 * JD-Core Version:    0.7.0.1
 */