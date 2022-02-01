import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.2;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.3;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class aboo
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, ausj.a
{
  private long BH;
  private ausj ac;
  private boolean bEj;
  private boolean bEk;
  private String bhh;
  private int cqs;
  private String extendInfo;
  private WeakReference<Activity> mActivityRef;
  private WeakReference<AppInterface> mAppRef;
  private int mGameId;
  private String mPicUrl;
  private String mSummary;
  
  public aboo(Context paramContext, AppInterface paramAppInterface)
  {
    try
    {
      this.mActivityRef = new WeakReference((Activity)paramContext);
      this.mAppRef = new WeakReference(paramAppInterface);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[ApolloGameShare], errInfo->" + paramContext.getMessage());
    }
  }
  
  private void HC(int paramInt)
  {
    ThreadManager.post(new CmGameCommonShare.4(this, paramInt), 5, null, true);
  }
  
  private AppInterface a()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (AppInterface)this.mAppRef.get();
  }
  
  private boolean bC(long paramLong)
  {
    try
    {
      localabos = abmt.a(this.mGameId);
      if (localabos == null) {
        break label82;
      }
      CmGameStartChecker.StartCheckParam localStartCheckParam = localabos.a();
      if ((localStartCheckParam == null) || (localStartCheckParam.mGameType != 5)) {
        break label82;
      }
      if (paramLong == 0L) {
        break label76;
      }
      switch ((int)paramLong)
      {
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        abos localabos;
        label76:
        label82:
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, localThrowable, new Object[0]);
        continue;
        int i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
      }
    }
    localabos.HH(i);
    return true;
    localabos.HH(1);
    return false;
  }
  
  private void cDw()
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = this.mPicUrl;
      File localFile = new File(rg());
      if (localFile.isFile())
      {
        localObject = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        localFile = new File(dd(this.mGameId));
        localObject = localFile;
        if (!localFile.exists()) {
          localObject = new File(de(this.mGameId));
        }
      }
      localArrayList.add(((File)localObject).getAbsolutePath());
      localBundle.putStringArrayList("images", localArrayList);
      localBundle.putString("summary", this.mSummary);
      localBundle.putInt("req_type", 7);
      localBundle.putBoolean("key_need_save_draft", false);
      localObject = null;
      if (this.mActivityRef != null) {
        localObject = (Activity)this.mActivityRef.get();
      }
      if (localObject != null)
      {
        avqq.a(a(), (Context)localObject, localBundle, this, 255);
        return;
      }
      gG(1, 4);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("apollo_cmGame_CmGameCommonShare", 1, "publishToQzone:", localException);
      gG(1, 4);
    }
  }
  
  private int ch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, "[parseShareParm],jsonStr:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.extendInfo = paramString.optString("extendInfo");
      this.mSummary = paramString.optString("summary");
      this.mPicUrl = paramString.optString("localPicPath");
      this.cqs = paramString.optInt("activityId");
      int i = paramString.optInt("reqCode");
      paramString = abmt.a(this.mGameId);
      if (paramString != null)
      {
        paramString.cqs = this.cqs;
        paramString.cqu = i;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[showShareDialog], errInfo->" + paramString.getMessage());
    }
    return -3;
  }
  
  private String dd(int paramInt)
  {
    return abxi.biF + paramInt + "/" + "shareQRCode_default_v2.png";
  }
  
  private String de(int paramInt)
  {
    return abxi.biF + paramInt + "/" + "shareQRCode_no_icon_default_v2.png";
  }
  
  private void gG(int paramInt1, int paramInt2)
  {
    abos localabos = abmt.a(this.mGameId);
    if (localabos != null) {
      localabos.o(paramInt1, paramInt2, 0, "");
    }
  }
  
  private String rg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (!TextUtils.isEmpty(this.mPicUrl))
    {
      if (!this.mPicUrl.startsWith("GameSandBox:")) {
        break label88;
      }
      str = this.mPicUrl.substring("GameSandBox:".length() + "//".length());
      localStringBuilder.append(abxi.biF);
      localStringBuilder.append(this.mGameId);
      localStringBuilder.append("/sandbox/");
      localStringBuilder.append(str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label88:
      if (this.mPicUrl.startsWith("GameRes:"))
      {
        str = this.mPicUrl.substring("GameRes:".length() + "//".length());
        localStringBuilder.append(abxi.biF);
        localStringBuilder.append(this.mGameId);
        localStringBuilder.append("/");
        localStringBuilder.append(str);
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    cDx();
  }
  
  public boolean YL()
  {
    return this.bEj;
  }
  
  public void cDx()
  {
    if (this.ac != null) {
      this.ac.dismiss();
    }
  }
  
  public void g(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {}
    for (Object localObject = de(paramInt);; localObject = dd(paramInt))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "checkDefaultQRSharePic gameId:", paramInt + " bitmap:" + paramBitmap });
    }
    ThreadManager.post(new CmGameCommonShare.2(this, paramInt, paramBitmap, (File)localObject), 5, null, true);
  }
  
  public boolean hS(int paramInt)
  {
    if (new File(abxi.biF + paramInt + "/" + "shareQRCode_default_v2.png").exists()) {}
    while (new File(abxi.biF + paramInt + "/" + "shareQRCode_no_icon_default_v2.png").exists()) {
      return true;
    }
    return false;
  }
  
  public void i(String paramString, int paramInt, boolean paramBoolean)
  {
    ausr localausr = null;
    this.bhh = paramString;
    this.mGameId = paramInt;
    this.bEj = paramBoolean;
    paramInt = ch(paramString);
    if (paramInt < 0)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[showShareDialog], errInfo->parse err or param err, ret:" + paramInt);
      return;
    }
    if (this.mActivityRef != null) {}
    for (paramString = (Activity)this.mActivityRef.get();; paramString = null)
    {
      this.bEk = false;
      if ((this.ac == null) && (paramString != null))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(ausr.a(0));
        localArrayList.add(ausr.a(1));
        localArrayList.add(ausr.a(2));
        localArrayList.add(ausr.a(3));
        if (paramString != null)
        {
          localausr = new ausr(paramString);
          localausr.setData(localArrayList);
        }
        this.ac = ausr.a(paramString, localausr, this, this, this, false);
      }
      if ((this.ac == null) || (this.ac.isShowing())) {
        break;
      }
      this.ac.setOnDismissListener(this);
      this.ac.setOnBottomCancelListener(new abop(this));
      this.ac.show();
      return;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.bEk) {
      gG(-1, -1);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.BH < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.BH = l;
      cDx();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "click type:", Long.valueOf(paramLong) });
      }
      this.bEk = true;
      if (!bC(paramLong)) {
        if (paramLong == 1L) {
          cDw();
        } else if (paramLong == 0L) {
          ThreadManager.post(new CmGameCommonShare.3(this), 5, null, true);
        } else if (paramLong == 2L) {
          HC(0);
        } else if (paramLong == 3L) {
          HC(1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboo
 * JD-Core Version:    0.7.0.1
 */