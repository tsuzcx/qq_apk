import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import java.util.Iterator;
import java.util.List;

public class xvw
  extends xwa
{
  private aqdf c;
  private View.OnClickListener ee = new xvx(this);
  BaseChatPie mBaseChatPie;
  
  public xvw(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    super(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
  }
  
  public boolean ST()
  {
    boolean bool = super.ST();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Xvt.Kv.setVisibility(0);
    this.jdField_a_of_type_Xvt.Kv.setTextColor(-8947849);
    this.jdField_a_of_type_Xvt.Kv.setText("QQ专属红包");
    return false;
  }
  
  public void a(aqdf paramaqdf)
  {
    this.c = paramaqdf;
  }
  
  public void cfj()
  {
    int j = 0;
    super.cfj();
    if ((this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hX == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Xvt.hX.getVisibility() != 0) {
        this.jdField_a_of_type_Xvt.hX.setVisibility(0);
      }
      LinearLayout localLinearLayout = new LinearLayout(this.context);
      localLinearLayout.setOrientation(0);
      this.jdField_a_of_type_Xvt.hX.addView(localLinearLayout);
      Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = aqcx.dip2px(this.context, 25.0F);
      int k = aqcx.dip2px(this.context, 1.0F);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() <= 1) {
        i = 0;
      }
      while ((j < 5) && (j < this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size()))
      {
        long l = ((Long)this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.get(j)).longValue();
        localObject = new ImageView(this.context);
        localLinearLayout.addView((View)localObject);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        localLayoutParams.width = aqcx.dip2px(this.context, 33.0F);
        localLayoutParams.height = aqcx.dip2px(this.context, 33.0F);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        if (j > 0) {
          localLayoutParams.leftMargin = i;
        }
        ((ImageView)localObject).setImageDrawable(aqdj.a(this.app, String.valueOf(l), (byte)4));
        ((ImageView)localObject).setBackgroundResource(2130848229);
        ((ImageView)localObject).setPadding(k, k, k, k);
        j += 1;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 3)) {
          i = aqcx.dip2px(this.context, 10.0F);
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 4) {
          i = 0;
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() >= 5) {
          i = -aqcx.dip2px(this.context, 8.0F);
        } else {
          i = 0;
        }
      }
    }
  }
  
  public void cfo()
  {
    super.cfo();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null) || (this.jdField_a_of_type_Xvt == null) || (this.jdField_a_of_type_Xvt.hW == null)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSender()) || (aafi.R(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg))) {
      return;
    }
    View localView = new View(this.context);
    this.jdField_a_of_type_Xvt.hW.setVisibility(0);
    this.jdField_a_of_type_Xvt.hW.addView(localView);
    Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = aqcx.dip2px(this.context, 33.5F);
    ((RelativeLayout.LayoutParams)localObject).height = aqcx.dip2px(this.context, 33.5F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(this.context, 10.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.specifyUinList != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.specifyUinList.iterator();
      Long localLong;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLong = (Long)((Iterator)localObject).next();
      } while (!this.app.getCurrentUin().equals(localLong + ""));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localView.setBackgroundResource(2130848232);
        localView.setTag(Integer.valueOf(1));
      }
      for (;;)
      {
        if (((this.context instanceof FragmentActivity)) && (((FragmentActivity)this.context).getChatFragment() != null)) {
          this.mBaseChatPie = ((FragmentActivity)this.context).getChatFragment().a();
        }
        localView.setOnClickListener(this.ee);
        aagd.k(localView, 0.6F);
        return;
        localView.setBackgroundResource(2130848231);
        localView.setTag(Integer.valueOf(0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvw
 * JD-Core Version:    0.7.0.1
 */