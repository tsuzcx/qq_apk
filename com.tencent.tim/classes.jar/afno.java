import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.2;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class afno
  extends aflk
  implements View.OnClickListener
{
  private ImageView yT;
  
  public afno(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private afqq a()
  {
    Object localObject = this.a.zZ;
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.a.a;
    if ((localObject != null) && (((List)localObject).size() > 0) && (localEmotionPanelViewPagerAdapter != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        afll localafll = localEmotionPanelViewPagerAdapter.a((afoo)((Iterator)localObject).next());
        if ((localafll instanceof afqq)) {
          return (afqq)localafll;
        }
      }
    }
    return null;
  }
  
  public int[] C()
  {
    return new int[] { 4, 8, 3 };
  }
  
  void daP()
  {
    QQAppInterface localQQAppInterface = this.a.app;
    Context localContext = this.a.context;
    if (localQQAppInterface == null) {}
    while (!ApolloUtil.ZB()) {
      return;
    }
    if (this.yT == null)
    {
      this.yT = new ImageView(localContext);
      this.yT.setId(2131362395);
      this.yT.setImageResource(2130838094);
    }
    this.yT.setClickable(true);
    this.yT.setOnClickListener(this);
    if (this.yT.getParent() != null) {
      ((ViewGroup)this.yT.getParent()).removeView(this.yT);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = wja.dp2px(52.0F, localContext.getResources());
    localLayoutParams.rightMargin = wja.dp2px(15.0F, localContext.getResources());
    this.a.b().addView(this.yT, localLayoutParams);
    ApolloUtil.cGu();
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_view", 0, 0, new String[0]);
  }
  
  @TargetApi(11)
  public void daQ()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.a.app.getManager(36)).getAppInfoByPath(String.valueOf("100610.100611"));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "emoji mall has redpoint.");
      }
      anot.a(this.a.app, "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (this.a.context.getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
        this.a.yP.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.2(this), 200L);
  }
  
  public void dal()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "[removePopupGuide]");
    }
    if ((this.yT != null) && (this.yT.getParent() != null)) {
      ((ViewGroup)this.yT.getParent()).removeView(this.yT);
    }
  }
  
  public void dam()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.1(this), 200L);
  }
  
  public void hO(int paramInt1, int paramInt2)
  {
    if (EmoticonPanelController.cSe == this.a.hp(7))
    {
      afqq localafqq = a();
      if (localafqq != null) {
        localafqq.hQ(paramInt1, paramInt2);
      }
      return;
    }
    this.a.b().cRX = paramInt2;
    this.a.b().cdX = paramInt1;
    this.a.MD(7);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.a.app;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      afqq localafqq = a();
      if (localafqq != null) {
        localafqq.dbA();
      }
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_click", 0, 0, new String[0]);
    }
  }
  
  public void onDestory()
  {
    Object localObject = this.a.app;
    if (localObject != null)
    {
      localObject = (afmb)((QQAppInterface)localObject).getManager(172);
      if (localObject != null) {
        ((afmb)localObject).daj();
      }
    }
    dal();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt != 0) {
      dal();
    }
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (this.a.mBaseChatPie != null) {
      this.a.mBaseChatPie.bHd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afno
 * JD-Core Version:    0.7.0.1
 */