import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.QLog;

public class zpa
  extends aqrd
{
  public zpa(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void handlePendantAuth(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    paramObject.getInt("seriesId");
    Object localObject = paramObject.getString("uin");
    int i = paramObject.getInt("result");
    if ((l == -1L) || (localObject == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label472;
      }
      if (l != 0L) {
        break;
      }
      this.this$0.vt.setVisibility(4);
      this.this$0.hQ.setVisibility(8);
      if (this.this$0.jdField_a_of_type_Aqph != null) {
        this.this$0.jdField_a_of_type_Aqph.pS = -1;
      }
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005FD4", "0X8005FD4", 0, 0, "", "", "", "");
      if ((this.this$0.jdField_a_of_type_Abdq != null) && (this.this$0.uC != null))
      {
        paramObject = ((AvatarPendantManager)this.this$0.app.getManager(46)).gI();
        this.this$0.jdField_a_of_type_Abdq.C(paramObject, this.this$0.uC);
      }
    } while ((this.this$0.jdField_a_of_type_Aqpg == null) || (!this.this$0.jdField_a_of_type_Aqpg.isLink));
    localObject = aqqj.getUrl("linkPendantSet");
    paramObject = localObject;
    if (localObject != null) {
      paramObject = ((String)localObject).replace("[id]", String.valueOf(this.this$0.jdField_a_of_type_Aqpg.ebe));
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "handlePendantAuth, mPendantInfo.isLink == true, jump to url =" + paramObject);
    }
    localObject = new Intent(this.this$0, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramObject);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("webStyle", "noBottomBar");
    this.this$0.startActivity((Intent)localObject);
    anot.a(this.this$0.app, "CliOper", "", "", "0X8006517", "0X8006517", 0, 0, "", "", "", "");
    return;
    this.this$0.eF.setText(2131719633);
    this.this$0.vt.setVisibility(0);
    this.this$0.hQ.setVisibility(0);
    localObject = this.this$0.app;
    if (this.this$0.bse) {}
    for (paramObject = "1";; paramObject = "0")
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8005FD6", "0X8005FD6", 0, 0, paramObject, "", "", "");
      if (!this.this$0.bse) {
        break;
      }
      this.this$0.bse = false;
      break;
    }
    label472:
    paramObject = (PendantTipsInfo)paramObject.getSerializable("tipsInfo");
    if (paramObject != null)
    {
      this.this$0.a(paramObject, l, i);
      return;
    }
    QLog.e("AvatarPendantActivity", 1, "handlePendantAuth, tipsInfo == null, pendantId = " + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpa
 * JD-Core Version:    0.7.0.1
 */