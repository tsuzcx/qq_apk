import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vsk
  extends aqrd
{
  public vsk(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void handlePendantAuth(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    String str = paramObject.getString("uin");
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "handlePendantAuth isSuccess:" + paramBoolean + " pendantId:" + l + " uin:" + str);
    }
    if ((l == -1L) || (str == null)) {
      return;
    }
    if (paramBoolean)
    {
      acff localacff = (acff)this.a.app.getManager(51);
      ExtensionInfo localExtensionInfo = localacff.a(str);
      paramObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramObject = new ExtensionInfo();
        paramObject.uin = str;
      }
      paramObject.pendantId = l;
      paramObject.timestamp = System.currentTimeMillis();
      localacff.a(paramObject);
      if (!TextUtils.isEmpty(this.a.aPF)) {
        QQToast.a(this.a.app.getApp(), 2, this.a.aPF, 0).show();
      }
      this.a.finish();
      return;
    }
    int i = paramObject.getInt("result");
    if (aqiw.isNetSupport(this.a))
    {
      paramObject = "4";
      switch (i)
      {
      default: 
        label225:
        i = -1;
      }
    }
    for (;;)
    {
      if ((i != -1) && (QLog.isColorLevel())) {
        QLog.e("Q.BabyQ", 2, "handlePendantAuth error:" + i + paramObject);
      }
      QQToast.a(this.a.app.getApp(), 1, acfp.m(2131713934), 0).show();
      break;
      paramObject = "3";
      break label225;
      i = 2131717400;
      continue;
      paramObject = "0";
      i = 2131717401;
      continue;
      paramObject = "1";
      i = 2131717402;
      continue;
      paramObject = "2";
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsk
 * JD-Core Version:    0.7.0.1
 */