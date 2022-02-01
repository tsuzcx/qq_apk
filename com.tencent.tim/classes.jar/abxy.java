import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class abxy
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, ausj.a
{
  private long BH;
  private ApolloPanel.b b;
  private String bjV;
  private WeakReference<ausj> fT;
  private WeakReference<Activity> mActivityRef;
  private WeakReference<AppInterface> mAppRef;
  private String mWording;
  
  public abxy(AppInterface paramAppInterface, Activity paramActivity)
  {
    try
    {
      this.mActivityRef = new WeakReference(paramActivity);
      this.mAppRef = new WeakReference(paramAppInterface);
      this.mWording = "";
      return;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.i("ApolloGameInvitation", 1, "[ApolloGameInvitation], errInfo->" + paramAppInterface.getMessage());
    }
  }
  
  private void gG(int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      abos localabos = abmt.a(this.b.gameId);
      if (localabos != null) {
        localabos.o(paramInt1, paramInt2, 0, "");
      }
    }
  }
  
  public void CZ(String paramString)
  {
    this.mWording = paramString;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    cDx();
  }
  
  public ApolloPanel.b a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[getGameMsgInfo], params:", paramString, ",app:", this.mAppRef });
    }
    if ((TextUtils.isEmpty(paramString)) || (this.mAppRef == null)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      if ((AppInterface)this.mAppRef.get() == null) {
        return null;
      }
      try
      {
        ApolloPanel.b localb = new ApolloPanel.b();
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("gameId");
        long l = paramString.optLong("roomId");
        int j = paramString.optInt("gameMode");
        int k = paramString.optInt("activityId");
        Object localObject = abmt.a(i);
        if (localObject != null)
        {
          ((abos)localObject).cqs = k;
          localObject = ((abos)localObject).c();
          if (localObject != null)
          {
            localb.gameName = ((CmGameInitParams)localObject).mChineseName;
            localb.actionId = ((CmGameInitParams)localObject).mActionId;
          }
        }
        if (0L == l) {
          QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo] roomId is invalid. gameId:" + i + ",gameMode:" + j);
        }
        localb.gameMode = j;
        localb.roomId = l;
        localb.gameId = i;
        localb.msgType = 3;
        localObject = aboy.c();
        if ((localObject != null) && (((aboy)localObject).f != null) && (0L != l)) {
          ((aboy)localObject).f.roomId = l;
        }
        localObject = paramString.optString("extendInfo");
        JSONObject localJSONObject = new JSONObject();
        paramString = localb;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localJSONObject.put("extendInfo", localObject);
          if (((String)localObject).length() >= 500)
          {
            QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo],extendInfo is too long, extendInfo:" + (String)localObject);
            return null;
          }
          localb.gameExtendJson = localJSONObject.toString();
          return localb;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInvitation", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void a(ApolloPanel.b paramb)
  {
    this.b = paramb;
  }
  
  public void bYd()
  {
    ausr localausr = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ausr.a(0));
    localArrayList.add(ausr.a(2));
    if (this.mActivityRef != null) {}
    for (Object localObject = (Activity)this.mActivityRef.get();; localObject = null)
    {
      if (localObject != null)
      {
        localausr = new ausr((Context)localObject);
        localausr.setData(localArrayList);
      }
      if (((this.fT == null) || (this.fT.get() == null)) && (localObject != null)) {
        this.fT = new WeakReference(ausr.a((Context)localObject, localausr, this, this, this, false));
      }
      if ((this.fT != null) && (this.fT.get() != null))
      {
        localObject = (ausj)this.fT.get();
        if ((localObject != null) && (!((ausj)localObject).isShowing()))
        {
          ((ausj)localObject).setOnDismissListener(this);
          ((ausj)localObject).show();
        }
      }
      return;
    }
  }
  
  public void cDx()
  {
    if ((this.fT != null) && (this.fT.get() != null))
    {
      ausj localausj = (ausj)this.fT.get();
      if (localausj != null) {
        localausj.dismiss();
      }
    }
  }
  
  public void cGf()
  {
    if (this.mActivityRef == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.mActivityRef.get();
    } while (localActivity == null);
    abxt.a(this.b, localActivity, 1);
  }
  
  public void cGg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameInvitation", 2, "[inviteWechatFriend]");
    }
    if (this.b == null)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, mGameMsg is null.");
      return;
    }
    ThreadManager.post(new ApolloGameInvitation.1(this), 5, null, true);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.BH < 1000L) {}
    label165:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.BH = l;
      cDx();
      if (paramLong == 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_WX_FRIEND is clicked.");
        }
        cGg();
      }
      for (int i = 1;; i = 0)
      {
        if ((this.mAppRef == null) || (this.b == null) || ((AppInterface)this.mAppRef.get() == null)) {
          break label165;
        }
        VipUtils.a(null, "cmshow", "Apollo", "invite_chose", i, 0, new String[] { Integer.toString(this.b.gameId) });
        break;
        if (paramLong == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_QQ is clicked.");
          }
          cGf();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxy
 * JD-Core Version:    0.7.0.1
 */