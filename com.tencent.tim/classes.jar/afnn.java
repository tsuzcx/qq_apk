import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController.a;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afnn
  extends aflk
  implements View.OnClickListener
{
  private boolean bZJ;
  private boolean bZK;
  private int cSz;
  private ImageView yS;
  
  public afnn(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private int a(afoo paramafoo)
  {
    int i = 1;
    if (paramafoo == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i = -1;
    }
    while ((paramafoo.type != 7) && (paramafoo.type != 10)) {
      return i;
    }
    return 2;
  }
  
  public int[] C()
  {
    return new int[] { 1 };
  }
  
  protected void MM(int paramInt) {}
  
  public void b(afoo paramafoo)
  {
    if (paramafoo == null) {}
    boolean bool;
    EmoticonPanelController.a locala;
    do
    {
      int i;
      do
      {
        return;
        bool = this.a.bYX;
        locala = this.a.b;
        i = a(paramafoo);
      } while (this.cSz == i);
      this.cSz = i;
    } while (((bool) && (!locala.bZc)) && (!this.a.bZp));
  }
  
  public void bT(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bZJ = paramBoolean1;
    this.bZK = paramBoolean2;
  }
  
  public void c(afoo paramafoo)
  {
    if (paramafoo == null) {}
    boolean bool;
    EmoticonPanelController.a locala;
    do
    {
      int i;
      do
      {
        return;
        bool = this.a.bYX;
        locala = this.a.b;
        i = a(paramafoo);
      } while (this.cSz == i);
      this.cSz = i;
    } while (((bool) && (!locala.bZc)) && (!this.a.bZp));
  }
  
  public void dae()
  {
    this.yS = ((ImageView)this.a.b().findViewById(2131363997));
    this.yS.setOnClickListener(this);
    if ((this.a.businessType == 3) || (this.bZK) || (this.a.bZp)) {
      this.yS.setVisibility(8);
    }
    this.yS.setVisibility(8);
  }
  
  public boolean jt(int paramInt)
  {
    if (paramInt == 13) {
      return true;
    }
    if ((paramInt == 14) && (this.yS != null))
    {
      this.yS.performClick();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.a.app;
    Object localObject = this.a.context;
    boolean bool = this.a.bYX;
    afmf localafmf = this.a.f;
    switch (paramView.getId())
    {
    }
    int i;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.getCurrentUin(), "ep_mall", "click_mine", "", 0, 0, 0, "", "", "");
      EmojiHomeUiPlugin.openEmosmActivity((BaseActivity)localObject, localQQAppInterface.getAccount(), 1, false, "");
      anot.a(localQQAppInterface, "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
      i = this.a.z(false);
      if (i != 0)
      {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800AE0F", "0X800AE0F", i, 0, "", "", "", "");
        continue;
        if ((this.cSz != 2) || (bool)) {
          break;
        }
        if (localafmf != null) {
          localafmf.delete();
        }
      }
    }
    anot.a(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    if (this.a.yP.getVisibility() == 0)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.a.yP.setVisibility(8);
      ((altq)localQQAppInterface.getManager(36)).OS(String.valueOf("100610.100611"));
      ((Context)localObject).getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
    }
    for (bool = true;; bool = false)
    {
      aqnl.eC(localQQAppInterface);
      this.a.e.dqV();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.a.context, localQQAppInterface.getAccount(), 1, bool, "");
      anot.a(localQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("emoticon_panel_" + localQQAppInterface.getCurrentAccountUin(), 0);
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).apply();
        }
      }
      if (WebProcessManager.aFS()) {}
      for (i = 1;; i = 0)
      {
        VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i, 0, "", "");
        anot.a(localQQAppInterface, "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
        i = this.a.z(false);
        if (i == 0) {
          break;
        }
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800AE0E", "0X800AE0E", i, 0, "", "", "", "");
        break;
      }
    }
  }
  
  public void setEmoSettingVisibility(int paramInt)
  {
    if (this.yS != null) {
      this.yS.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnn
 * JD-Core Version:    0.7.0.1
 */