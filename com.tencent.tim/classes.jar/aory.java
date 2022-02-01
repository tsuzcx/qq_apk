import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity.8.2;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity.8.3;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aory
  extends Handler
{
  public aory(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.this$0.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    switch (paramMessage.what)
                    {
                    default: 
                      return;
                    }
                  } while (this.this$0.lS(1));
                  if (this.this$0.cu.size() != 9) {
                    break;
                  }
                  QQToast.a(this.this$0, "最多只能选择9张图片", 0).show(this.this$0.getTitleBarHeight());
                  return;
                  this.this$0.xa(false);
                  this.this$0.rightViewText.setEnabled(true);
                  this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
                  this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
                  QQToast.a(this.this$0, 2131698479, 1).show(this.this$0.getTitleBarHeight());
                } while (!(paramMessage.obj instanceof String));
                paramMessage = (String)paramMessage.obj;
                this.this$0.cu.remove(paramMessage);
                return;
                this.this$0.xa(false);
                this.this$0.bsq();
                return;
                if ((paramMessage.arg1 == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null)) {
                  this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.url = ((String)paramMessage.obj);
                }
              } while ((this.this$0.mProgress == null) || (!this.this$0.mProgress.isShowing()));
              this.this$0.bsq();
              return;
              this.this$0.xa(false);
              if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
                this.this$0.mProgress.dismiss();
              }
              this.this$0.rightViewText.setEnabled(true);
              this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
              this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
              QQToast.a(this.this$0, 2131698479, 1).show(this.this$0.getTitleBarHeight());
              return;
            } while (this.this$0.lS(2));
            if ((Build.VERSION.SDK_INT >= 23) && (this.this$0.checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
            {
              this.this$0.requestPermissions(new aorz(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
              return;
            }
            paramMessage = new Intent();
            paramMessage.putExtra("audio_max_length", this.this$0.dRz);
            if (this.this$0.mBid != null)
            {
              paramMessage.putExtra("from", "publish");
              paramMessage.putExtra("bid", this.this$0.mBid);
              paramMessage.putExtra("fromflag", this.this$0.cmL);
              aprv.d(this.this$0.cmV, this.this$0.mOpType, "Clk_record", this.this$0.mBid, this.this$0.cmL, "", "");
            }
            PublicFragmentActivity.b.startForResult(this.this$0.mActivity, paramMessage, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
            return;
          } while (!this.this$0.lS(4));
          return;
          this.this$0.i(this.this$0.mActivity, this.this$0.mActivity.getClass().getName());
          return;
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown()))
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.kd(5, 0);
            this.this$0.dWI();
            this.this$0.mHandler.postDelayed(new AbsPublishActivity.8.2(this), 200L);
            return;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.kd(5, 1);
          this.this$0.aG.setImageResource(2130844391);
          this.this$0.aG.setContentDescription(this.this$0.getString(2131698477));
          this.this$0.eA.setVisibility(8);
          aurd.hide(this.this$0.b);
          this.this$0.mHandler.postDelayed(new AbsPublishActivity.8.3(this), 200L);
        } while (!(this.this$0.getActivity() instanceof TroopBarPublishActivity));
        localObject = (TroopBarPublishActivity)this.this$0.getActivity();
        paramMessage = new StringBuilder();
      } while (((TroopBarPublishActivity)localObject).Hm == null);
      Object localObject = ((TroopBarPublishActivity)localObject).Hm.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramMessage.append(((TroopBarMyBar)((Iterator)localObject).next()).bid).append("|");
      }
    } while (!this.this$0.lS(8));
    return;
    if (this.this$0.cu.size() > 0)
    {
      this.this$0.jdField_a_of_type_Aour.bF(this.this$0.cu);
      paramMessage = this.this$0.jdField_a_of_type_Aour;
      if (this.this$0.cu.size() < 9) {
        bool = true;
      }
      paramMessage.C(bool, true);
      this.this$0.Wd(1);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(1);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      return;
    }
    this.this$0.cu.clear();
    this.this$0.jdField_a_of_type_Aour.C(false, true);
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.this$0.Wd(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aory
 * JD-Core Version:    0.7.0.1
 */