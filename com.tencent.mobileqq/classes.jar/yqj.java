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

public class yqj
  implements Handler.Callback, wnt, ypo, yqi, ysp
{
  private int a;
  public Activity a;
  public Handler a;
  protected bhpc a;
  public wta a;
  protected ypv a;
  protected yqx a;
  public ytq a;
  protected boolean a;
  
  public yqj(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wta = ((wta)wth.a(10));
  }
  
  public void a()
  {
    yuk.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ypv = new ypv(ThreadManager.getSubThreadLooper());
    b();
    if (a()) {
      this.jdField_a_of_type_Wta.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
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
    this.jdField_a_of_type_Wta.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(ypq paramypq)
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      yuk.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Ytq != null) && (this.jdField_a_of_type_Ytq.isShowing()))
      {
        yuk.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramypq == null)
      {
        yuk.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      yuk.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramypq.b));
    } while (paramypq.b <= i);
    this.jdField_a_of_type_Wta.b("qqstory_guide_info_seqno", Integer.valueOf(paramypq.b));
    ytq localytq = new ytq(this.jdField_a_of_type_AndroidAppActivity, 2131755902);
    localytq.b(paramypq.a).c(paramypq.c).d(paramypq.e).b(new yqs(this, localytq)).e(paramypq.d).a(new yqr(this, localytq)).setCancelable(true);
    localytq.c(new yqt(this, localytq));
    localytq.setCanceledOnTouchOutside(true);
    localytq.show();
    yup.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(yqx paramyqx)
  {
    this.jdField_a_of_type_Yqx = paramyqx;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    yuk.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Wta.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bhpc.setTitle(anzj.a(2131713275));
      this.jdField_a_of_type_Bhpc.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_Bhpc.setNegativeButton(anzj.a(2131713260), new yql(this)).setPositiveButton("立即拍摄", new yqk(this));
      this.jdField_a_of_type_Bhpc.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166463));
      this.jdField_a_of_type_Bhpc.setOnDismissListener(new yqm(this));
      this.jdField_a_of_type_Bhpc.show();
      yup.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    ysm localysm = (ysm)this.jdField_a_of_type_Yqx.a("LocalVideoPushSegment");
    if (localysm != null) {
      localysm.a(this);
    }
  }
  
  public boolean b()
  {
    nlb localnlb = (nlb)QQStoryContext.a().getManager(70);
    if (localnlb == null)
    {
      yuk.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localnlb.a();
    if ((localRedDotInfo == null) && (((wwh)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(252)).jdField_a_of_type_Boolean))
    {
      yuk.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localnlb.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localnlb.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        yuk.b("Q.qqstory.home.StoryListPresenter", "it have red point");
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
      yuk.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((wta)wth.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    yuk.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((wja)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_Wta.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      yuk.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    yuk.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Wta.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    yuk.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (zot.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ypv.c();
      this.jdField_a_of_type_Ypv.a(new ypr(null)).a(new ypw(this)).a(new ypj()).a(new ypm(this)).a(new yqv(this)).a(new yqu(this)).a();
      xaq.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131713250), 0).a();
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
    if (this.jdField_a_of_type_Ytq != null)
    {
      this.jdField_a_of_type_Ytq.dismiss();
      this.jdField_a_of_type_Ytq = null;
    }
  }
  
  public void g()
  {
    yuk.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
    if (this.jdField_a_of_type_Ytq != null)
    {
      this.jdField_a_of_type_Ytq.dismiss();
      this.jdField_a_of_type_Ytq = null;
    }
    if (this.jdField_a_of_type_Ypv != null) {
      this.jdField_a_of_type_Ypv.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    zps.a();
    zps.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    yuk.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((ysm)this.jdField_a_of_type_Yqx.a("LocalVideoPushSegment")).e_(true);
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
 * Qualified Name:     yqj
 * JD-Core Version:    0.7.0.1
 */