import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.utils.ApolloGameShare.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class abyb
  implements DialogInterface.OnDismissListener, Handler.Callback, AdapterView.OnItemClickListener, ausj.a
{
  private long BH;
  private ausj ac;
  private String bjV;
  private String bjX;
  private String bjY;
  Handler handler = new Handler(Looper.getMainLooper(), this);
  private WeakReference<Activity> mActivityRef;
  private WeakReference<AppInterface> mAppRef;
  private String mBrief;
  private int mGameId;
  private String mPicUrl;
  private long mRoomId;
  private String mSummary;
  private String mTitle;
  
  public abyb(Context paramContext, AppInterface paramAppInterface)
  {
    try
    {
      this.mActivityRef = new WeakReference((Activity)paramContext);
      this.mAppRef = new WeakReference(paramAppInterface);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.i("ApolloGameShare", 1, "[ApolloGameShare], errInfo->" + paramContext.getMessage());
    }
  }
  
  private void HC(int paramInt)
  {
    ThreadManager.post(new ApolloGameShare.2(this, paramInt), 5, null, true);
  }
  
  private AppInterface a()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (AppInterface)this.mAppRef.get();
  }
  
  private void cDw()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.mTitle);
    localBundle.putString("desc", this.mSummary);
    localBundle.putString("detail_url", this.bjX);
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(this.mPicUrl);
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    localBundle.putLong("req_share_id", 0L);
    if (this.mActivityRef != null) {}
    for (localObject = (Activity)this.mActivityRef.get();; localObject = null)
    {
      if (this.mAppRef != null) {}
      for (AppInterface localAppInterface = (AppInterface)this.mAppRef.get();; localAppInterface = null)
      {
        if ((localObject != null) && (localAppInterface != null) && (avqq.a(localAppInterface, (Context)localObject, localBundle, null)))
        {
          localObject = d();
          if (localObject != null) {
            break label172;
          }
        }
        label172:
        for (int i = -1;; i = ApolloUtil.gi(((BaseChatPie)localObject).sessionInfo.cZ))
        {
          VipUtils.a(a(), "cmshow", "Apollo", "share_url_succeed", i, 1, new String[] { Integer.toString(this.mGameId) });
          return;
        }
      }
    }
  }
  
  private void cGj()
  {
    Object localObject1 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(96).a(this.mBrief).e(this.bjX).a(acfp.m(2131702526), null).b("web", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326").a();
    Object localObject2 = anrd.a(2);
    ((anqv)localObject2).aU(this.mPicUrl, this.mTitle, this.mSummary);
    ((AbsShareMsg)localObject1).addItem((anqu)localObject2);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ((Intent)localObject2).putExtra("cmshow_game_id", this.mGameId);
    ((Intent)localObject2).putExtra("forwardDirect", true);
    if (this.mActivityRef != null)
    {
      localObject1 = (Activity)this.mActivityRef.get();
      if (localObject1 != null) {
        ahgq.f((Activity)localObject1, (Intent)localObject2, 14002);
      }
    }
  }
  
  private int ch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameShare", 2, "[parseShareParm],jsonStr:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("title")) {
          this.mTitle = paramString.getString("title");
        }
        this.mBrief = (acfp.m(2131702498) + this.mTitle);
        if (paramString.has("summary")) {
          this.mSummary = paramString.getString("summary");
        }
        if (paramString.has("detailUrl")) {
          this.bjX = paramString.getString("detailUrl");
        }
        if (paramString.has("picUrl")) {
          this.mPicUrl = paramString.getString("picUrl");
        }
        if (paramString.has("gameVersion")) {
          this.bjY = paramString.getString("gameVersion");
        }
        if (paramString.has("gameId")) {
          this.mGameId = paramString.getInt("gameId");
        }
        if (paramString.has("roomId")) {
          this.mRoomId = paramString.getLong("roomId");
        }
        if ((TextUtils.isEmpty(this.mTitle)) || (TextUtils.isEmpty(this.bjX)) || (TextUtils.isEmpty(this.mSummary)) || (TextUtils.isEmpty(this.bjX))) {
          break;
        }
        if (this.mAppRef != null)
        {
          paramString = (AppInterface)this.mAppRef.get();
          if (paramString != null)
          {
            paramString = paramString.getCurrentAccountUin();
            this.bjX = (this.bjX + "&gameId=" + this.mGameId + "&roomId=" + this.mRoomId + "&gameVersion=" + this.bjY + "&uin=" + paramString);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameShare", 2, "[mDetailUrl]:" + this.bjX);
            }
            return 0;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.i("ApolloGameShare", 1, "[showShareDialog], errInfo->" + paramString.getMessage());
        return -3;
      }
      paramString = "";
    }
    return -2;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    cDx();
  }
  
  public void bd(String paramString)
  {
    ausr localausr = null;
    int i = ch(paramString);
    if (i < 0)
    {
      QLog.i("ApolloGameShare", 1, "[showShareDialog], errInfo->parse err or param err, ret:" + i);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ausr.a(0));
    localArrayList.add(ausr.a(1));
    localArrayList.add(ausr.a(2));
    localArrayList.add(ausr.a(3));
    if (this.mActivityRef != null) {}
    for (paramString = (Activity)this.mActivityRef.get();; paramString = null)
    {
      if (paramString != null)
      {
        localausr = new ausr(paramString);
        localausr.setData(localArrayList);
      }
      if ((this.ac == null) && (paramString != null)) {
        this.ac = ausr.a(paramString, localausr, this, this, this, false);
      }
      if ((this.ac != null) && (!this.ac.isShowing()))
      {
        this.ac.setOnDismissListener(this);
        this.ac.show();
      }
      paramString = d();
      if (paramString == null) {}
      for (i = -1;; i = ApolloUtil.gi(paramString.sessionInfo.cZ))
      {
        VipUtils.a(a(), "cmshow", "Apollo", "share_panel_open", i, 0, new String[] { Integer.toString(this.mGameId) });
        return;
      }
    }
  }
  
  public void cDx()
  {
    if (this.ac != null) {
      this.ac.dismiss();
    }
  }
  
  public BaseChatPie d()
  {
    Object localObject;
    if (this.mActivityRef == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = (Activity)this.mActivityRef.get();
      if (localObject == null) {
        return null;
      }
      try
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if (localObject != null)
        {
          int i = ((BaseChatPie)localObject).vn();
          if (i < 7) {}
        }
        else
        {
          return null;
        }
      }
      catch (Throwable localThrowable) {}
    }
    return null;
  }
  
  public void dp(String paramString, int paramInt)
  {
    ausr localausr = null;
    ArrayList localArrayList;
    try
    {
      paramString = new JSONObject(paramString).optString("path");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ApolloGameShare", 2, "showSharePic parse err=" + paramString.toString());
        paramString = null;
      }
      localArrayList = new ArrayList();
      localArrayList.add(ausr.a(1));
      localArrayList.add(ausr.a(0));
      if (this.mActivityRef == null) {}
    }
    for (Activity localActivity = (Activity)this.mActivityRef.get();; localActivity = null)
    {
      if (localActivity != null)
      {
        localausr = new ausr(localActivity);
        localausr.setData(localArrayList);
      }
      if ((this.ac == null) && (localActivity != null))
      {
        paramString = ApolloRender.getSandBoxPathByRealGameId(paramInt, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameShare", 2, new Object[] { "share pic:", paramString });
        }
        this.ac = ausr.a(localActivity, localausr, new abyc(this, paramString), this, this, false);
      }
      if ((this.ac == null) || (this.ac.isShowing())) {
        break;
      }
      this.ac.setOnDismissListener(this);
      this.ac.show();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    Bundle localBundle;
    ArrayList localArrayList;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          do
          {
            return false;
            if (this.ac != null) {
              this.ac.dismiss();
            }
          } while (this.mAppRef == null);
          localObject = (AppInterface)this.mAppRef.get();
        } while (localObject == null);
        paramMessage = (String)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloGameShare", 1, "onItemClick share QZone apolloImage no file");
      return false;
      localBundle = new Bundle();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        localArrayList.add(URLDecoder.decode(paramMessage));
        localBundle.putStringArrayList("images", localArrayList);
        localBundle.putString("summary", acfp.m(2131702483));
        localBundle.putInt("req_type", 7);
        localBundle.putBoolean("key_need_save_draft", false);
        if (this.mActivityRef == null) {
          break label336;
        }
        paramMessage = (Activity)this.mActivityRef.get();
        if (paramMessage == null) {
          break;
        }
        avqq.a((AppInterface)localObject, paramMessage, localBundle, this, 15);
        return false;
      }
      catch (Exception paramMessage)
      {
        QLog.d("ApolloGameShare", 2, "publishToQzone:" + paramMessage.getMessage());
        return false;
      }
      if (this.ac != null) {
        this.ac.dismiss();
      }
      localObject = (String)paramMessage.obj;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("ApolloGameShare", 1, "onItemClick share QQ apolloImage no file");
        return false;
      }
      if (!new File((String)localObject).exists())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ApolloGameShare", 1, "onItemClick share QQ apolloImage no file");
        return false;
      }
      if (this.mActivityRef != null) {}
      for (paramMessage = (Activity)this.mActivityRef.get(); paramMessage != null; paramMessage = null)
      {
        ApolloUtil.d(paramMessage, (String)localObject, null, 1);
        return false;
      }
      break;
      label336:
      paramMessage = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.BH < 1000L)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.BH = l;
    cDx();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameShare", 2, new Object[] { "click type:", Long.valueOf(paramLong) });
    }
    int i;
    if (paramLong == 1L)
    {
      cDw();
      i = 1;
    }
    for (;;)
    {
      label85:
      BaseChatPie localBaseChatPie = d();
      if (localBaseChatPie == null) {}
      for (int j = -1;; j = ApolloUtil.gi(localBaseChatPie.sessionInfo.cZ))
      {
        VipUtils.a(a(), "cmshow", "Apollo", "send_game_share", j, i, new String[] { Integer.toString(this.mGameId) });
        break;
        if (paramLong == 0L)
        {
          cGj();
          i = 0;
          break label85;
        }
        if (paramLong == 2L)
        {
          i = 3;
          HC(1);
          break label85;
        }
        if (paramLong != 3L) {
          break label207;
        }
        i = 4;
        HC(2);
        break label85;
      }
      label207:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyb
 * JD-Core Version:    0.7.0.1
 */