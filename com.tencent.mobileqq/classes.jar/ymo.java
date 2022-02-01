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

public class ymo
  implements Handler.Callback, wjy, ylt, ymn, you
{
  private int a;
  public Activity a;
  public Handler a;
  protected bgpa a;
  public wpf a;
  protected yma a;
  protected ync a;
  public ypv a;
  protected boolean a;
  
  public ymo(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wpf = ((wpf)wpm.a(10));
  }
  
  public void a()
  {
    yqp.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Yma = new yma(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Wpf.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Wpf.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(ylv paramylv)
  {
    if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
      yqp.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Ypv != null) && (this.jdField_a_of_type_Ypv.isShowing()))
      {
        yqp.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramylv == null)
      {
        yqp.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      yqp.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramylv.b));
    } while (paramylv.b <= i);
    this.jdField_a_of_type_Wpf.b("qqstory_guide_info_seqno", Integer.valueOf(paramylv.b));
    ypv localypv = new ypv(this.jdField_a_of_type_AndroidAppActivity, 2131755901);
    localypv.b(paramylv.a).c(paramylv.c).d(paramylv.e).b(new ymx(this, localypv)).e(paramylv.d).a(new ymw(this, localypv)).setCancelable(true);
    localypv.c(new ymy(this, localypv));
    localypv.setCanceledOnTouchOutside(true);
    localypv.show();
    yqu.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(ync paramync)
  {
    this.jdField_a_of_type_Ync = paramync;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    yqp.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Wpf.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bgpa.setTitle(anni.a(2131713166));
      this.jdField_a_of_type_Bgpa.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bgpa.setNegativeButton(anni.a(2131713151), new ymq(this)).setPositiveButton("立即拍摄", new ymp(this));
      this.jdField_a_of_type_Bgpa.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166459));
      this.jdField_a_of_type_Bgpa.setOnDismissListener(new ymr(this));
      this.jdField_a_of_type_Bgpa.show();
      yqu.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    yor localyor = (yor)this.jdField_a_of_type_Ync.a("LocalVideoPushSegment");
    if (localyor != null) {
      localyor.a(this);
    }
  }
  
  public boolean b()
  {
    njg localnjg = (njg)QQStoryContext.a().getManager(70);
    if (localnjg == null)
    {
      yqp.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localnjg.a();
    if ((localRedDotInfo == null) && (((wsm)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      yqp.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localnjg.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localnjg.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        yqp.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      yqp.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((wpf)wpm.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    yqp.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((wff)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Wpf.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      yqp.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    yqp.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Wpf.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    yqp.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (zky.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Yma.c();
      this.jdField_a_of_type_Yma.a(new ylw(null)).a(new ymb(this)).a(new ylo()).a(new ylr(this)).a(new yna(this)).a(new ymz(this)).a();
      wwv.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, anni.a(2131713141), 0).a();
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_Bgpa != null)
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
    }
    if (this.jdField_a_of_type_Ypv != null)
    {
      this.jdField_a_of_type_Ypv.dismiss();
      this.jdField_a_of_type_Ypv = null;
    }
  }
  
  public void g()
  {
    yqp.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bgpa != null)
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
    }
    if (this.jdField_a_of_type_Ypv != null)
    {
      this.jdField_a_of_type_Ypv.dismiss();
      this.jdField_a_of_type_Ypv = null;
    }
    if (this.jdField_a_of_type_Yma != null) {
      this.jdField_a_of_type_Yma.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    zlx.a();
    zlx.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    yqp.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((yor)this.jdField_a_of_type_Ync.a("LocalVideoPushSegment")).e_(true);
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
 * Qualified Name:     ymo
 * JD-Core Version:    0.7.0.1
 */