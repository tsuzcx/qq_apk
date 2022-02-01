import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

class afqd
  implements ajdq<EmoticonPackage>
{
  afqd(afqc paramafqc, aqpi.b paramb, boolean paramBoolean, afke paramafke, ProgressButton paramProgressButton, int paramInt) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool = false;
    int i = ((acle)this.this$0.app.getBusinessHandler(13)).AX();
    Object localObject2 = "vip";
    Object localObject1 = "";
    Object localObject3;
    if (this.jdField_a_of_type_Aqpi$b.type == 4)
    {
      localObject1 = "mvip.g.a.bq_" + this.jdField_a_of_type_Aqpi$b.id;
      if (this.jdField_a_of_type_Aqpi$b.feeType != 4) {
        break label376;
      }
      localObject3 = "!vip";
      if (i != 1)
      {
        localObject2 = localObject3;
        if (i != 3) {}
      }
      else
      {
        bool = true;
        localObject2 = localObject3;
      }
      label104:
      localObject3 = new EmoticonPackage();
      ((EmoticonPackage)localObject3).jobType = this.jdField_a_of_type_Aqpi$b.type;
      ((EmoticonPackage)localObject3).epId = this.jdField_a_of_type_Aqpi$b.id;
      if (paramEmoticonPackage == null) {
        break label1004;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "canDownload:" + bool + ",vipType:" + i + ",isPayBack:" + this.cai);
      }
      if (afqc.a(this.this$0, this.jdField_a_of_type_Aqpi$b))
      {
        this.jdField_a_of_type_Afke.HX(paramEmoticonPackage.epId);
        this.c.setText(this.jdField_a_of_type_Aqpi$b.cuL);
        this.c.setProgress(0);
        if (this.cai) {
          anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, this.jdField_a_of_type_Aqpi$b.id, "", "", "");
        }
      }
      label376:
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Aqpi$b.type == 0)
          {
            localObject1 = "mvip.g.a.bq_" + this.jdField_a_of_type_Aqpi$b.id;
            break;
          }
          if ((this.jdField_a_of_type_Aqpi$b.type != 3) && (this.jdField_a_of_type_Aqpi$b.type != 5)) {
            break;
          }
          localObject1 = "mvip.g.a.bq_mg_" + this.jdField_a_of_type_Aqpi$b.id;
          break;
          if (this.jdField_a_of_type_Aqpi$b.feeType == 5)
          {
            localObject3 = "!svip";
            localObject2 = localObject3;
            if (i != 3) {
              break label104;
            }
            bool = true;
            localObject2 = localObject3;
            break label104;
          }
          bool = true;
          break label104;
          anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, this.jdField_a_of_type_Aqpi$b.id, "", "", "");
          return;
          if (bool)
          {
            localObject1 = (acdz)this.this$0.app.getBusinessHandler(12);
            if (this.val$businessType == 1)
            {
              ((acdz)localObject1).dt(paramEmoticonPackage.epId, this.val$businessType);
              this.jdField_a_of_type_Afke.a(paramEmoticonPackage, true, this.val$businessType);
              this.c.setText(acfp.m(2131713761));
              this.c.setProgressDrawable(this.c.a(-16745986));
              if (!this.cai) {
                anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, this.jdField_a_of_type_Aqpi$b.id, "", "", "");
              }
              localObject1 = this.this$0.app;
              localObject2 = this.jdField_a_of_type_Aqpi$b.id;
              if (!this.this$0.cag) {
                break label805;
              }
              paramEmoticonPackage = "1";
              anot.a((QQAppInterface)localObject1, "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, (String)localObject2, paramEmoticonPackage, "", "");
              i = this.this$0.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
              int j = this.this$0.data.indexOf(this.jdField_a_of_type_Aqpi$b);
              localObject1 = this.this$0.app.getCurrentUin();
              localObject2 = this.jdField_a_of_type_Aqpi$b.id;
              localObject3 = j + 1 + "";
              if (!this.this$0.cag) {
                break label811;
              }
            }
            for (paramEmoticonPackage = "1";; paramEmoticonPackage = "")
            {
              VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "0X8005814", "", 0, 0, 0, "", (String)localObject2, (String)localObject3, paramEmoticonPackage, "", i + "", "", 0, 0, 0, 0);
              return;
              if (paramEmoticonPackage.type == 4) {
                break;
              }
              ((acdz)localObject1).dt(paramEmoticonPackage.epId, this.val$businessType);
              break;
              paramEmoticonPackage = "";
              break label609;
            }
          }
        } while (this.cai);
        this.this$0.b = this.c;
        paramEmoticonPackage = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject1 + "&type=" + (String)localObject2 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1";
        localObject1 = new Intent(this.this$0.mContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramEmoticonPackage);
      } while (!(this.this$0.mContext instanceof Activity));
      label609:
      ((Activity)this.this$0.mContext).startActivityForResult((Intent)localObject1, 4779);
      label805:
      label811:
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "func downloadOrPay. mCurPageIndex: epid = " + this.jdField_a_of_type_Aqpi$b.id);
      }
      anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, this.jdField_a_of_type_Aqpi$b.id, "", "", "");
      return;
      label1004:
      paramEmoticonPackage = (EmoticonPackage)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqd
 * JD-Core Version:    0.7.0.1
 */