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

public class wtd
  implements Handler.Callback, uqm, wsi, wtc, wvj
{
  private int a;
  public Activity a;
  public Handler a;
  protected bdjz a;
  public uvt a;
  protected wsp a;
  protected wtr a;
  public wwk a;
  protected boolean a;
  
  public wtd(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Uvt = ((uvt)uwa.a(10));
  }
  
  public void a()
  {
    wxe.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Wsp = new wsp(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Uvt.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Uvt.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(wsk paramwsk)
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      wxe.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Wwk != null) && (this.jdField_a_of_type_Wwk.isShowing()))
      {
        wxe.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramwsk == null)
      {
        wxe.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      wxe.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramwsk.b));
    } while (paramwsk.b <= i);
    this.jdField_a_of_type_Uvt.b("qqstory_guide_info_seqno", Integer.valueOf(paramwsk.b));
    wwk localwwk = new wwk(this.jdField_a_of_type_AndroidAppActivity, 2131755880);
    localwwk.b(paramwsk.a).c(paramwsk.c).d(paramwsk.e).b(new wtm(this, localwwk)).e(paramwsk.d).a(new wtl(this, localwwk)).setCancelable(true);
    localwwk.c(new wtn(this, localwwk));
    localwwk.setCanceledOnTouchOutside(true);
    localwwk.show();
    wxj.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(wtr paramwtr)
  {
    this.jdField_a_of_type_Wtr = paramwtr;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    wxe.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Uvt.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bdjz.setTitle(alud.a(2131714865));
      this.jdField_a_of_type_Bdjz.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bdjz.setNegativeButton(alud.a(2131714850), new wtf(this)).setPositiveButton("立即拍摄", new wte(this));
      this.jdField_a_of_type_Bdjz.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166385));
      this.jdField_a_of_type_Bdjz.setOnDismissListener(new wtg(this));
      this.jdField_a_of_type_Bdjz.show();
      wxj.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    wvg localwvg = (wvg)this.jdField_a_of_type_Wtr.a("LocalVideoPushSegment");
    if (localwvg != null) {
      localwvg.a(this);
    }
  }
  
  public boolean b()
  {
    nan localnan = (nan)QQStoryContext.a().getManager(70);
    if (localnan == null)
    {
      wxe.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localnan.a();
    if ((localRedDotInfo == null) && (((uza)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      wxe.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localnan.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localnan.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        wxe.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      wxe.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((uvt)uwa.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    wxe.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((ult)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Uvt.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      wxe.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    wxe.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Uvt.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    wxe.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (xrn.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Wsp.c();
      this.jdField_a_of_type_Wsp.a(new wsl(null)).a(new wsq(this)).a(new wsd()).a(new wsg(this)).a(new wtp(this)).a(new wto(this)).a();
      vdj.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, alud.a(2131714840), 0).a();
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (this.jdField_a_of_type_Wwk != null)
    {
      this.jdField_a_of_type_Wwk.dismiss();
      this.jdField_a_of_type_Wwk = null;
    }
  }
  
  public void g()
  {
    wxe.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (this.jdField_a_of_type_Wwk != null)
    {
      this.jdField_a_of_type_Wwk.dismiss();
      this.jdField_a_of_type_Wwk = null;
    }
    if (this.jdField_a_of_type_Wsp != null) {
      this.jdField_a_of_type_Wsp.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    xsm.a();
    xsm.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    wxe.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((wvg)this.jdField_a_of_type_Wtr.a("LocalVideoPushSegment")).e_(true);
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
 * Qualified Name:     wtd
 * JD-Core Version:    0.7.0.1
 */