import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aqhw
  extends ashx
{
  aqhw(aqhv paramaqhv) {}
  
  protected void k(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {}
    Object localObject;
    String str1;
    Intent localIntent;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramHashMap.get("ranKey");
        } while ((localObject != null) && (this.eme != ((Integer)localObject).intValue()));
        this.this$0.app.removeObserver(this.this$0.b);
      } while (!paramBoolean);
      localObject = (String)paramHashMap.get("key_ext_uin");
      str1 = (String)paramHashMap.get("key_sigt");
      String str2 = (String)paramHashMap.get("key_return_root");
      localIntent = new Intent();
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals("NO"))) {
        break;
      }
      localIntent.setComponent(new ComponentName(this.this$0.context, ChatActivity.class));
      localIntent.addFlags(67108864);
      i = ((Integer)paramHashMap.get("key_aio_type")).intValue();
    } while (localObject == null);
    if (str1 != null) {
      localIntent.putExtra("sigt", aqhs.hexStr2Bytes(str1));
    }
    if (i == 1) {
      if (((acff)this.this$0.app.getManager(51)).isFriend((String)localObject))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", aqgv.o(this.this$0.app, (String)localObject));
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_FRIEND");
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("uin", (String)localObject);
      this.this$0.context.startActivity(localIntent);
      return;
      localIntent.setComponent(new ComponentName(this.this$0.context, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      localIntent.putExtra("uintype", 1025);
      localIntent.putExtra("from_wpa_for_crm", true);
      if (QLog.isColorLevel())
      {
        QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
        continue;
        localIntent.putExtra("uintype", 1024);
        localIntent.putExtra("chat_subType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_MASTER");
        }
      }
    }
  }
  
  protected void l(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.this$0.app.removeObserver(this.this$0.b);
    if (paramHashMap != null) {
      if (!paramBoolean) {
        break label350;
      }
    }
    label276:
    label313:
    label350:
    for (int i = ((Integer)paramHashMap.get("key_aio_type")).intValue();; i = 2)
    {
      String str1 = (String)paramHashMap.get("key_sigt");
      String str2 = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("key_return_root");
      Intent localIntent = new Intent();
      if ((TextUtils.isEmpty(paramHashMap)) || (paramHashMap.equals("NO")))
      {
        localIntent.setComponent(new ComponentName(this.this$0.context, ChatActivity.class));
        localIntent.addFlags(67108864);
        if ((str1 != null) && (str2 != null)) {
          localIntent.putExtra("sigt", aqhs.hexStr2Bytes(str1));
        }
        if (i != 1) {
          break label313;
        }
        if (!((acff)this.this$0.app.getManager(51)).isFriend(str2)) {
          break label276;
        }
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", aqgv.o(this.this$0.app, str2));
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_FRIEND");
        }
      }
      for (;;)
      {
        localIntent.putExtra("uin", str2);
        this.this$0.context.startActivity(localIntent);
        return;
        localIntent.setComponent(new ComponentName(this.this$0.context, SplashActivity.class));
        localIntent.putExtra("open_chatfragment", true);
        break;
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        if (QLog.isColorLevel())
        {
          QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
          continue;
          localIntent.putExtra("uintype", 1024);
          localIntent.putExtra("chat_subType", 1);
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_MASTER");
          }
        }
      }
    }
  }
  
  protected void m(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.this$0.app.removeObserver(this.this$0.b);
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (String)paramHashMap.get("cipher_text");
      this.this$0.attrs.put("uin", paramHashMap);
      if (this.this$0.attrs.containsKey("isPrivate")) {
        this.this$0.attrs.remove("isPrivate");
      }
      aqhv.j(this.this$0);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getString(2131718828), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhw
 * JD-Core Version:    0.7.0.1
 */