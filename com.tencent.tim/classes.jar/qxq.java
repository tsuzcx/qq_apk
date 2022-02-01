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

public class qxq
  implements Handler.Callback, ppe, qxg.b, qxp, qzc.a
{
  public psr a;
  protected qxj a;
  protected qye a;
  public qzy a;
  protected boolean aDA;
  private int bou = -1;
  public Activity context;
  public Handler mainHandler;
  protected aqju s;
  
  public qxq(Activity paramActivity)
  {
    this.context = paramActivity;
    this.jdField_a_of_type_Psr = ((psr)psx.a(10));
  }
  
  protected boolean KJ()
  {
    int i = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    ram.w("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Psr.n("qqstory_is_story_new_user", Integer.valueOf(1));
      this.s = aqha.a(this.context, 230);
      this.s.setTitle(acfp.m(2131714891));
      this.s.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.s.setNegativeButton(acfp.m(2131714876), new qxs(this)).setPositiveButton("立即拍摄", new qxr(this));
      this.s.getBtnight().setTextColor(this.context.getResources().getColor(2131166746));
      this.s.setOnDismissListener(new qxt(this));
      this.s.show();
      rar.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  public boolean KK()
  {
    jnv localjnv = (jnv)QQStoryContext.a().getManager(70);
    if (localjnv == null)
    {
      ram.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localjnv.a();
    if ((localRedDotInfo == null) && (((puz)((QQAppInterface)((BaseActivity)this.context).getAppInterface()).getManager(252)).aBT))
    {
      ram.d("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localjnv.a(52);
      if (localRedDotInfo == null) {
        localRedDotInfo = localjnv.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        ram.d("Q.qqstory.home.StoryListPresenter", "it have red point");
        int i = localRedDotInfo.uint32_last_time.get();
        if ((i > 0) && (i > this.bou))
        {
          this.bou = i;
          return true;
        }
        return false;
      }
      return false;
    }
  }
  
  public boolean KL()
  {
    long l = ((Long)this.jdField_a_of_type_Psr.c("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      ram.w("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    ram.b("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public boolean KM()
  {
    if (rpc.hasInternet(this.context))
    {
      this.jdField_a_of_type_Qxj.reset();
      this.jdField_a_of_type_Qxj.a(new qxh(null)).a(new qxk(this)).a(new qxf()).a(new qxg(this)).a(new qyc(this)).a(new qyb(this)).run();
      pxs.bnA();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131714866), 0).show();
    return false;
  }
  
  public void a(qxg.d paramd)
  {
    if ((this.s != null) && (this.s.isShowing())) {
      ram.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Qzy != null) && (this.jdField_a_of_type_Qzy.isShowing()))
      {
        ram.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramd == null)
      {
        ram.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      ram.b("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramd.seqno));
    } while (paramd.seqno <= i);
    this.jdField_a_of_type_Psr.n("qqstory_guide_info_seqno", Integer.valueOf(paramd.seqno));
    qzy localqzy = new qzy(this.context, 2131756561);
    localqzy.b(paramd.imageUrl).c(paramd.word).d(paramd.azc).b(new qxz(this, localqzy)).e(paramd.azb).a(new qxy(this, localqzy)).setCancelable(true);
    localqzy.c(new qya(this, localqzy));
    localqzy.setCanceledOnTouchOutside(true);
    localqzy.show();
    rar.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(qye paramqye)
  {
    this.jdField_a_of_type_Qye = paramqye;
  }
  
  protected void bru()
  {
    qzc localqzc = (qzc)this.jdField_a_of_type_Qye.a("LocalVideoPushSegment");
    if (localqzc != null) {
      localqzc.a(this);
    }
  }
  
  protected void brv()
  {
    if (!(this.context instanceof BaseActivity)) {
      ram.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((psr)psx.a(10)).dJ();
    } while (System.currentTimeMillis() - l <= 7200000L);
    ram.d("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((pma)((QQAppInterface)((BaseActivity)this.context).getAppInterface()).getBusinessHandler(98)).blO();
  }
  
  public void brw()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_Psr.c("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    ram.b("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  protected void brx()
  {
    ram.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((qzc)this.jdField_a_of_type_Qye.a("LocalVideoPushSegment")).setDisplay(true);
  }
  
  public void bry() {}
  
  public void fo(long paramLong)
  {
    this.jdField_a_of_type_Psr.n("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    bry();
  }
  
  public void onCreate()
  {
    ram.d("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    brv();
    this.aDA = true;
    this.mainHandler = new Handler(this);
    this.bou = -1;
    this.jdField_a_of_type_Qxj = new qxj(ThreadManager.getSubThreadLooper());
    bru();
    if (KJ()) {
      this.jdField_a_of_type_Psr.n("key_story_has_show_rename_guide", Boolean.valueOf(true));
    }
    for (;;)
    {
      brx();
      KM();
      return;
      brw();
    }
  }
  
  public void onDestory()
  {
    ram.d("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.aDA = false;
    if (this.s != null)
    {
      this.s.dismiss();
      this.s = null;
    }
    if (this.jdField_a_of_type_Qzy != null)
    {
      this.jdField_a_of_type_Qzy.dismiss();
      this.jdField_a_of_type_Qzy = null;
    }
    if (this.jdField_a_of_type_Qxj != null) {
      this.jdField_a_of_type_Qxj.reset();
    }
    this.mainHandler.removeMessages(2);
    this.mainHandler.removeMessages(3);
    this.mainHandler.removeMessages(4);
    this.mainHandler.removeMessages(5);
    rpq.bvP();
    rpq.ud(false);
    StoryQIMBadgeView.clearCache();
  }
  
  public void onPause()
  {
    if (this.s != null)
    {
      this.s.dismiss();
      this.s = null;
    }
    if (this.jdField_a_of_type_Qzy != null)
    {
      this.jdField_a_of_type_Qzy.dismiss();
      this.jdField_a_of_type_Qzy = null;
    }
  }
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxq
 * JD-Core Version:    0.7.0.1
 */