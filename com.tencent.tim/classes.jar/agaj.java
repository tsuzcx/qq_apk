import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.a;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class agaj
  extends acfd
{
  DialogInterface.OnDismissListener a = new agam(this);
  private int bDz;
  DialogInterface.OnClickListener s = new agak(this);
  DialogInterface.OnClickListener t = new agal(this);
  private aqju w;
  
  public agaj(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  private void bFF()
  {
    if ((this.w != null) && (this.bDz != 0))
    {
      localObject1 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertTitle", 147, this.bDz);
      if (localObject1 == null) {
        break label483;
      }
    }
    label203:
    label223:
    label483:
    for (Object localObject1 = ((Bundle)localObject1).getString("AlertTitle");; localObject1 = null)
    {
      Object localObject2 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertText", 147, this.bDz);
      if (localObject2 != null) {}
      for (Object localObject3 = ((Bundle)localObject2).getString("AlertText");; localObject3 = null)
      {
        localObject2 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.bDz);
        if (localObject2 != null) {}
        for (localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");; localObject2 = null)
        {
          Object localObject4 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.bDz);
          if (localObject4 != null) {}
          for (localObject4 = ((Bundle)localObject4).getString("AlertRightBtnText");; localObject4 = null)
          {
            Object localObject5 = localObject1;
            int i;
            if (localObject1 == null)
            {
              localObject1 = this.this$0;
              if (this.bDz == 1)
              {
                i = 2131719340;
                localObject5 = ((Face2FaceAddFriendActivity)localObject1).getString(i);
              }
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                if (this.bDz != 1) {
                  break label327;
                }
                localObject1 = this.this$0.getString(2131719341);
              }
              if (localObject2 != null) {
                break label407;
              }
              if (this.bDz != 1) {
                break label393;
              }
              this.s = null;
              localObject3 = localObject2;
              if (localObject4 != null) {
                break label444;
              }
              if (this.bDz != 1) {
                break label431;
              }
              localObject2 = this.this$0.getString(2131719335);
            }
            for (;;)
            {
              this.w.setTitle((String)localObject5);
              this.w.setMessage((CharSequence)localObject1);
              this.w.setNegativeButton((String)localObject3, this.s);
              this.w.setPositiveButton((String)localObject2, this.t);
              if ((this.s == null) || (this.t == null)) {
                this.w.findViewById(2131363753).setVisibility(8);
              }
              return;
              i = 2131719344;
              break;
              if (this.bDz == 2)
              {
                localObject1 = this.this$0.getString(2131719339);
                break label203;
              }
              if (this.bDz == 3)
              {
                localObject1 = this.this$0.getString(2131719343);
                break label203;
              }
              localObject1 = localObject3;
              if (this.bDz != 4) {
                break label203;
              }
              localObject1 = this.this$0.getString(2131719342);
              break label203;
              localObject3 = this.this$0.getString(2131719336);
              break label223;
              localObject3 = localObject2;
              if (!TextUtils.isEmpty(((String)localObject2).trim())) {
                break label223;
              }
              this.s = null;
              localObject3 = localObject2;
              break label223;
              localObject2 = this.this$0.getString(2131719334);
              continue;
              if (TextUtils.isEmpty(((String)localObject4).trim())) {
                this.t = null;
              }
              localObject2 = localObject4;
            }
          }
        }
      }
    }
  }
  
  protected void onAddFriend(String paramString)
  {
    super.onAddFriend(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onAddFriend 进入好友列表" + paramString);
    }
    Object localObject = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
    ((Message)localObject).what = 2;
    ((Message)localObject).arg1 = 2;
    ((Message)localObject).obj = paramString;
    Face2FaceAddFriendActivity.a(this.this$0).sendMessage((Message)localObject);
    Face2FaceAddFriendActivity.a(this.this$0, 2, paramString);
    localObject = Face2FaceAddFriendActivity.a(this.this$0, paramString, 1);
    if (localObject == null) {}
    agba localagba;
    do
    {
      return;
      localagba = ((Face2FaceFriendBubbleView)localObject).g();
      if ((localagba != null) && (this.this$0.ky.containsKey(paramString)))
      {
        String str = (String)this.this$0.ky.get(paramString);
        if ((!TextUtils.isEmpty(str)) && (localagba != null) && (localagba.type == 1))
        {
          ((agbc)localagba).remark = str;
          ((Face2FaceFriendBubbleView)localObject).vD(str);
        }
      }
    } while (!this.this$0.ae.contains(localagba));
    this.this$0.a.Iy(paramString);
    paramString = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
    paramString.what = 11;
    paramString.arg1 = 1;
    Face2FaceAddFriendActivity.a(this.this$0).sendMessageDelayed(paramString, this.this$0.DV());
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.this$0.bGc, paramString1)) {}
    do
    {
      for (;;)
      {
        return;
        if (paramBoolean)
        {
          if (!this.this$0.ky.containsKey(paramString1)) {
            this.this$0.bf.setText(paramString2);
          }
          try
          {
            this.this$0.bf.setSelection(this.this$0.bf.getText().length());
            if (!this.this$0.kz.containsKey(paramString1))
            {
              this.this$0.bDA = paramInt;
              this.this$0.RV.setText(this.this$0.ee(this.this$0.bDA));
              this.this$0.kz.put(paramString1, Integer.valueOf(this.this$0.bDA));
              return;
            }
          }
          catch (IndexOutOfBoundsException paramString2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetAutoInfo | IndexOutOfBoundsException");
              }
            }
          }
        }
      }
    } while (this.this$0.kz.containsKey(paramString1));
    this.this$0.bDA = 0;
    this.this$0.RV.setText(this.this$0.ee(this.this$0.bDA));
    this.this$0.kz.put(paramString1, Integer.valueOf(this.this$0.bDA));
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 147)
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onQueryUinSafetyFlag isSuccess=" + paramBoolean + "status=" + paramInt2);
      }
      if ((!paramBoolean) || (paramInt2 == 0)) {
        Face2FaceAddFriendActivity.e(this.this$0);
      }
    }
    else
    {
      return;
    }
    this.bDz = paramInt2;
    aqfz.a().bf(this.this$0.app, "SecWarningCfg");
    try
    {
      this.w = aqha.a(this.this$0, 230, "", "", this.s, this.t);
      bFF();
      this.w.setOnDismissListener(this.a);
      this.w.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    super.onUpdateAddFriend(paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramBundle);
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onUpdateAddFriend请求加好友回调 isSuccess= " + paramBoolean1 + "addSuccess=" + paramBoolean2 + "reqestUin=" + paramString + "friendSetting" + i);
    }
    if (paramBoolean2)
    {
      paramString = paramBundle.getString("remark");
      paramBundle = paramBundle.getString("uin");
      this.this$0.ky.put(paramBundle, paramString);
      if (i == 0)
      {
        paramString = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
        paramString.what = 2;
        paramString.arg1 = 2;
        paramString.obj = this.this$0.bGc;
        Face2FaceAddFriendActivity.a(this.this$0).sendMessage(paramString);
        Face2FaceAddFriendActivity.a(this.this$0, 2, this.this$0.bGc);
        return;
      }
      paramString = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
      paramString.what = 2;
      paramString.arg1 = 4;
      paramString.obj = this.this$0.bGc;
      Face2FaceAddFriendActivity.a(this.this$0).sendMessage(paramString);
      Face2FaceAddFriendActivity.a(this.this$0, 4, this.this$0.bGc);
      return;
    }
    paramBundle = paramBundle.getString("ErrorString");
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "add friend response error and ErroString = " + paramBundle);
    }
    paramString = paramBundle;
    if (TextUtils.isEmpty(paramBundle)) {
      paramString = this.this$0.getString(2131693352);
    }
    QQToast.a(this.this$0, 0, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uin");
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onUpdateAddFriendSetting请求加好友设置 isSuccess= " + paramBoolean + "friendSetting=" + i);
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.this$0.app.getBusinessHandler(1);
    String str2 = this.this$0.bf.getText().toString();
    byte b = (byte)this.this$0.bDA;
    if (TextUtils.isEmpty(this.this$0.bGc)) {}
    do
    {
      return;
      localFriendListHandler.a(this.this$0.bGc, null, i, b, "", 3021, 0, true, null, true, str2, "");
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "请求加好友" + this.this$0.bGc);
      }
    } while ((!this.this$0.bGc.equals(str1)) || (!paramBoolean));
    paramBundle.getStringArrayList("user_question");
    paramBundle.getBoolean("contact_bothway");
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "好友onUpdateCustomHead success = " + paramBoolean);
    }
    if (this.this$0.ccj) {
      return;
    }
    if (this.this$0.cVN == 1) {}
    for (;;)
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = Face2FaceAddFriendActivity.a(this.this$0, paramString, i);
      if (localFace2FaceFriendBubbleView == null) {
        break;
      }
      localFace2FaceFriendBubbleView.x(this.this$0.app, paramString, 1);
      return;
      i = 1;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onUpdateDelFriend 删除好友");
    }
    if (this.this$0.AH.contains(String.valueOf(paramObject))) {
      this.this$0.AH.remove(String.valueOf(paramObject));
    }
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "群onUpdateTroopHead success = " + paramBoolean);
    }
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = Face2FaceAddFriendActivity.a(this.this$0, paramString, 2);
    if (localFace2FaceFriendBubbleView != null) {
      localFace2FaceFriendBubbleView.x(this.this$0.app, paramString, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agaj
 * JD-Core Version:    0.7.0.1
 */