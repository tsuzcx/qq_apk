import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper.1;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class wuk
  implements View.OnClickListener, wvs
{
  private achs jdField_a_of_type_Achs;
  private zli jdField_a_of_type_Zli;
  private zmw jdField_a_of_type_Zmw;
  private boolean bgb;
  private BaseChatPie f;
  
  wuk(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
    if (((this.f instanceof xys)) || ((this.f instanceof TroopChatPie))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bgb = bool;
      return;
    }
  }
  
  private void a(zmc paramzmc)
  {
    paramzmc = paramzmc.messageRecord;
    if ((paramzmc instanceof ChatMessage))
    {
      ajlc.a().b((ChatMessage)paramzmc, true);
      this.f.a.notifyDataSetChanged();
    }
    if (this.f.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramzmc.time;
    int i = paramzmc.istroop;
    long l2 = paramzmc.shmsgseq;
    if (i == 1) {
      l1 = l2;
    }
    for (;;)
    {
      this.f.fD(l1);
      return;
    }
  }
  
  private void gX()
  {
    Bundle localBundle = this.f.a().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = localBundle.getString("uin");
    localSessionInfo.cZ = localBundle.getInt("uintype");
    localSessionInfo.troopUin = localBundle.getString("troop_uin");
    localSessionInfo.a = new wkj();
    localSessionInfo.cN = ChatTextSizeSettingActivity.ag(this.f.a());
    if ((this.f instanceof xys))
    {
      this.jdField_a_of_type_Zli = new zli(this.f.a(), this.f.app, localSessionInfo, this.jdField_a_of_type_Achs.abb());
      this.jdField_a_of_type_Zli.show();
      this.jdField_a_of_type_Zli.F.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Zli.F.setOnItemClickListener(new wul(this));
      return;
    }
    this.jdField_a_of_type_Zmw = new zmw(this.f.a(), this.f.app, localSessionInfo, this.jdField_a_of_type_Achs.abb());
    this.jdField_a_of_type_Zmw.show();
    this.jdField_a_of_type_Zmw.F.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Zmw.F.setOnItemClickListener(new wum(this));
  }
  
  public int[] C()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void Ck(int paramInt)
  {
    if (this.bgb) {
      switch (paramInt)
      {
      }
    }
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = this.f.a().getIntent().getExtras();
      } while (localBundle == null);
      this.jdField_a_of_type_Achs = ((achs)this.f.app.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.f.aQ.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Achs != null) {
        this.jdField_a_of_type_Achs.iw(hashCode());
      }
      if ((this.jdField_a_of_type_Zmw != null) && (this.jdField_a_of_type_Zmw.isShowing()))
      {
        this.jdField_a_of_type_Zmw.dismiss();
        this.jdField_a_of_type_Zmw = null;
      }
    } while ((this.jdField_a_of_type_Zli == null) || (!this.jdField_a_of_type_Zli.isShowing()));
    this.jdField_a_of_type_Zli.dismiss();
    this.jdField_a_of_type_Zli = null;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369610) && (this.bgb))
    {
      anot.a(this.f.app, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      gX();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuk
 * JD-Core Version:    0.7.0.1
 */