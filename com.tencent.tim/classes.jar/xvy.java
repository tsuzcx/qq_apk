import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class xvy
  extends xvb
{
  aadw a;
  int bXM = 0;
  int themeId = 0;
  
  public xvy(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    super(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    this.jdField_a_of_type_Aadw = null;
    this.skinId = 0;
    this.themeId = paramQQWalletTransferMsgElem.themeId;
  }
  
  public boolean ST()
  {
    this.jdField_a_of_type_Xvt.Kv.setVisibility(0);
    this.jdField_a_of_type_Xvt.Kv.setTextColor(-8947849);
    if ((this.jdField_a_of_type_Aadw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aadw.bcy)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aadw.bcx)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aadw.bcz))) {}
    try
    {
      int i = Color.parseColor(this.jdField_a_of_type_Aadw.bcy);
      this.jdField_a_of_type_Xvt.Kv.setTextColor(i);
      label91:
      this.jdField_a_of_type_Xvt.Kv.setText(this.jdField_a_of_type_Aadw.bcx);
      this.jdField_a_of_type_Xvt.Kv.setTag(this.jdField_a_of_type_Aadw.bcz);
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Xvt.Kv.setText("QQ主题红包");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label91;
    }
  }
  
  public void cfl()
  {
    if (this.bXM == 1)
    {
      cfk();
      return;
    }
    super.cfl();
  }
  
  public void cfm()
  {
    if (this.bXM > 0)
    {
      this.jdField_a_of_type_Xvt.title.setVisibility(8);
      return;
    }
    super.cfm();
  }
  
  public void onCreate()
  {
    super.onCreate();
    String str;
    int i;
    if ((this.themeId > 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo == null))
    {
      this.jdField_a_of_type_Aadw = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(this.themeId);
      if ((this.jdField_a_of_type_Aadw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aadw.bcw)))
      {
        str = this.jdField_a_of_type_Aadw.bcw;
        CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
        localRedPacketInfo.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
        if (this.elem.resourceType != 1) {
          break label171;
        }
        i = 4;
        label93:
        localRedPacketInfo.type = i;
        localRedPacketInfo.templateId = str;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo = CustomizeStrategyFactory.a().a(this.app, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$c);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo == null) {
        break label176;
      }
      this.bXM = 2;
    }
    label171:
    label176:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background == null)
    {
      return;
      str = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + this.themeId;
      break;
      i = 1;
      break label93;
    }
    this.bXM = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvy
 * JD-Core Version:    0.7.0.1
 */