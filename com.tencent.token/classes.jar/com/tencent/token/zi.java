package com.tencent.token;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.AccountPageActivity;
import com.tencent.token.ui.GeneralVerifyMobileUpActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.NetActiveSetDirBySeqActivity;
import com.tencent.token.ui.NetActiveVryMobileNoSmsActivity;
import com.tencent.token.ui.NetActiveVryOtherListActivity;
import com.tencent.token.ui.NetActiveVryQQTokenActivity;
import com.tencent.token.ui.NetActiveVryQuesActivity;
import com.tencent.token.ui.UtilsActivity;
import com.tencent.token.ui.VerifyMobilePhoneActivity;
import com.tmsdk.TMSDKContext;
import java.util.List;

public final class zi
{
  private static zi c;
  public Activity a;
  public QQUser b = new QQUser();
  private Handler d = new Handler();
  
  public static zi a()
  {
    if (c == null) {
      c = new zi();
    }
    return c;
  }
  
  private void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, Handler paramHandler)
  {
    if (!paramActivity.isFinishing())
    {
      if (paramDeterminVerifyFactorsResult == null) {
        return;
      }
      QQUser localQQUser = tt.a().k.b();
      if (paramDeterminVerifyFactorsResult.mScene == 2) {
        localQQUser = this.b;
      }
      if (localQQUser == null) {
        return;
      }
      if (paramVerifyTypeItem != null)
      {
        List localList = paramVerifyTypeItem.mVerifyFactorList;
        if ((localList != null) && (localList.size() > 0))
        {
          i = ((Integer)localList.get(0)).intValue();
          break label90;
        }
      }
      int i = -1;
      label90:
      a(paramActivity, paramDeterminVerifyFactorsResult, paramVerifyTypeItem, i, true, paramHandler);
      paramActivity = new StringBuilder();
      paramActivity.append(localQQUser.mRealUin);
      TMSDKContext.SaveStringData(1150089, paramActivity.toString());
      return;
    }
  }
  
  private void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, QQUser paramQQUser, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, int paramInt, boolean paramBoolean, Handler paramHandler)
  {
    switch (paramInt)
    {
    default: 
      paramHandler = new Intent(paramActivity, NetActiveVryOtherListActivity.class);
      paramHandler.putExtra("intent.qquser", paramQQUser);
      paramHandler.putExtra("intent.determin_factors_result", paramDeterminVerifyFactorsResult);
      paramHandler.putExtra("intent.determin_verify_type", paramVerifyTypeItem);
      paramActivity.startActivity(paramHandler);
      return;
    case 7: 
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 7, paramBoolean, paramActivity, NetActiveVryQuesActivity.class);
      return;
    case 6: 
      Toast.makeText(paramActivity, "人脸身份验证已下线", 0).show();
      return;
    case 5: 
      Toast.makeText(paramActivity, "人脸验证已下线", 0).show();
      return;
    case 4: 
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 4, paramBoolean, paramActivity, NetActiveVryQQTokenActivity.class);
      return;
    case 3: 
      if (paramDeterminVerifyFactorsResult.c())
      {
        a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 3, paramBoolean, paramActivity, NetActiveVryMobileNoSmsActivity.class);
        return;
      }
      if (paramDeterminVerifyFactorsResult.d())
      {
        a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 3, paramBoolean, paramActivity, GeneralVerifyMobileUpActivity.class);
        return;
      }
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 3, paramBoolean, paramActivity, NetActiveVryMobileNoSmsActivity.class);
      return;
    case 2: 
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 2, paramBoolean, paramActivity, VerifyMobilePhoneActivity.class);
      return;
    }
    if (paramDeterminVerifyFactorsResult.b())
    {
      su.a().b(paramQQUser.mRealUin, paramVerifyTypeItem.verifyTypeId, "", "", paramHandler);
      this.a = null;
      return;
    }
    a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 1, paramBoolean, paramActivity, NetActiveSetDirBySeqActivity.class);
  }
  
  private void a(final DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, final QQUser paramQQUser, final DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, final int paramInt, final boolean paramBoolean, final Activity paramActivity, final Class paramClass)
  {
    if ((paramActivity instanceof NetActiveVryOtherListActivity))
    {
      paramActivity.setResult(112);
      paramActivity.finish();
    }
    this.d.postDelayed(new Runnable()
    {
      public final void run()
      {
        Intent localIntent = new Intent(paramActivity, paramClass);
        localIntent.putExtra("intent.qquser", paramQQUser);
        localIntent.putExtra("intent.determin_factors_result", paramDeterminVerifyFactorsResult);
        localIntent.putExtra("intent.determin_verify_type", paramVerifyTypeItem);
        localIntent.putExtra("intent.determin_verify_factor_id", paramInt);
        localIntent.putExtra("intent.determin_first_verify_factor", paramBoolean);
        boolean bool;
        if ((paramActivity instanceof NetActiveVryOtherListActivity)) {
          bool = true;
        } else {
          bool = false;
        }
        localIntent.putExtra("intent.determin_from_list", bool);
        paramActivity.startActivity(localIntent);
      }
    }, 10L);
  }
  
  public static void b() {}
  
  public final Intent a(Activity paramActivity)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = new Intent(paramActivity, localObject.getClass());
    } else {
      localObject = new Intent(paramActivity, IndexActivity.class);
    }
    Activity localActivity = this.a;
    if (((localActivity instanceof UtilsActivity)) || ((localActivity instanceof AccountPageActivity))) {
      localObject = new Intent(paramActivity, IndexActivity.class);
    }
    ((Intent)localObject).addFlags(67108864);
    return localObject;
  }
  
  public final void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, Handler paramHandler)
  {
    if (!paramActivity.isFinishing())
    {
      if (paramDeterminVerifyFactorsResult == null) {
        return;
      }
      this.a = paramActivity;
      Object localObject1 = tt.a().k.b();
      if (paramDeterminVerifyFactorsResult.mScene == 2) {
        localObject1 = this.b;
      }
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramDeterminVerifyFactorsResult.mVerifyTypeList != null)
      {
        localObject1 = localObject2;
        if (paramDeterminVerifyFactorsResult.mVerifyTypeList.size() > 0) {
          localObject1 = (DeterminVerifyFactorsResult.VerifyTypeItem)paramDeterminVerifyFactorsResult.mVerifyTypeList.get(0);
        }
      }
      a(paramActivity, paramDeterminVerifyFactorsResult, (DeterminVerifyFactorsResult.VerifyTypeItem)localObject1, paramHandler);
      return;
    }
  }
  
  public final void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, int paramInt, boolean paramBoolean, Handler paramHandler)
  {
    if (!paramActivity.isFinishing())
    {
      if (paramDeterminVerifyFactorsResult == null) {
        return;
      }
      QQUser localQQUser = tt.a().k.b();
      if (paramDeterminVerifyFactorsResult.mScene == 2) {
        localQQUser = this.b;
      }
      if (localQQUser == null) {
        return;
      }
      a(paramActivity, paramDeterminVerifyFactorsResult, localQQUser, paramVerifyTypeItem, paramInt, paramBoolean, paramHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zi
 * JD-Core Version:    0.7.0.1
 */