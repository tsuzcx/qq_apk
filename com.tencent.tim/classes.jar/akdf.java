import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class akdf
  implements ajww.a
{
  akdf(akcx paramakcx) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      localObject = new oidb_0xada.RspBody();
      try
      {
        ((oidb_0xada.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (((oidb_0xada.RspBody)localObject).busi_buf.has())
        {
          paramBundle = new ilive_new_anchor_follow_interface.FollowActionRsp();
          paramBundle.mergeFrom(((oidb_0xada.RspBody)localObject).busi_buf.get().toByteArray());
          if (paramBundle.ret.has())
          {
            paramInt = paramBundle.ret.get();
            if (paramInt != 0) {}
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        boolean bool;
        label159:
        label465:
        paramArrayOfByte = "";
        paramInt = 0;
      }
    }
    try
    {
      ((ajpj)this.this$0.a.app.getManager(106)).go.put(this.this$0.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramArrayOfByte = this.this$0;
      if (akcx.a(this.this$0)) {
        break label465;
      }
      bool = true;
      akcx.a(paramArrayOfByte, bool);
      akcx.a(this.this$0, 1, 60);
      paramArrayOfByte = "";
      paramInt = 1;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        paramArrayOfByte = "";
        paramInt = 1;
      }
      break label159;
    }
    if (paramInt != 0)
    {
      ((ajpj)this.this$0.a.app.getManager(106)).go.put(this.this$0.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramBundle = this.this$0.a;
      if (akcx.a(this.this$0)) {}
      for (paramArrayOfByte = acfp.m(2131708925);; paramArrayOfByte = acfp.m(2131708862))
      {
        for (;;)
        {
          QQToast.a(paramBundle, 2, paramArrayOfByte, 1).show();
          if (!TextUtils.isEmpty(akcx.a(this.this$0).uin)) {
            ((ajvl)this.this$0.a.app.getBusinessHandler(119)).notifyUI(1000, true, new Object[] { Boolean.valueOf(akcx.a(this.this$0)), akcx.a(this.this$0).uin });
          }
          if ((!akcx.a(this.this$0)) && (akcx.a(this.this$0).getChildAt(2).getVisibility() != 0))
          {
            paramArrayOfByte = (Button)akcx.a(this.this$0).getChildAt(1).findViewById(2131381048);
            paramArrayOfByte.setTextColor(this.this$0.a.getResources().getColor(2131167335));
            paramArrayOfByte.setBackgroundDrawable(this.this$0.a.getResources().getDrawable(2130846434));
          }
          if (akcx.a(this.this$0))
          {
            paramArrayOfByte = (Button)akcx.a(this.this$0).getChildAt(1).findViewById(2131381048);
            paramArrayOfByte.setTextColor(this.this$0.a.getResources().getColor(2131167337));
            paramArrayOfByte.setBackgroundDrawable(this.this$0.a.getResources().getDrawable(2130846435));
          }
          return;
          bool = false;
          break;
          paramArrayOfByte = paramBundle.msg.get();
          try
          {
            QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret=" + paramBundle.ret.get() + ",errMsg=" + paramArrayOfByte);
            paramInt = 0;
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            for (;;)
            {
              paramInt = 0;
            }
            paramArrayOfByte = "";
            paramInt = 0;
          }
        }
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret not has ");
        break label648;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, rspBody.busi_buf not has ");
        break label648;
        paramBundle.printStackTrace();
        break label159;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, errorCode=" + paramInt);
        break label648;
      }
    }
    Object localObject = this.this$0.a;
    paramBundle = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramBundle = acfp.m(2131708910);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdf
 * JD-Core Version:    0.7.0.1
 */