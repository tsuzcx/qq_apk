package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.token.cc;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tmsdk.TMSDKContext;
import java.util.List;

public class u
{
  private static u a;
  private Activity b;
  private Handler c = new Handler();
  private QQUser d = new QQUser();
  
  public static u a()
  {
    if (a == null) {
      a = new u();
    }
    return a;
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
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 6, paramBoolean, paramActivity, RealNameFindActivity.class);
      return;
    case 5: 
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 5, paramBoolean, paramActivity, FaceRecognitionCameraActivity.class);
      return;
    case 4: 
      a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 4, paramBoolean, paramActivity, NetActiveVryQQTokenActivity.class);
      return;
    case 3: 
      if (paramDeterminVerifyFactorsResult.i())
      {
        a(paramDeterminVerifyFactorsResult, paramQQUser, paramVerifyTypeItem, 3, paramBoolean, paramActivity, NetActiveVryMobileNoSmsActivity.class);
        return;
      }
      if (paramDeterminVerifyFactorsResult.j())
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
      cc.a().b(paramQQUser.mRealUin, paramVerifyTypeItem.a(), "", "", paramHandler);
      this.b = null;
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
    this.c.postDelayed(new Runnable()
    {
      public void run()
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
  
  public static void c() {}
  
  public Intent a(Activity paramActivity)
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = new Intent(paramActivity, localObject.getClass());
    } else {
      localObject = new Intent(paramActivity, IndexActivity.class);
    }
    Activity localActivity = this.b;
    if (((localActivity instanceof UtilsActivity)) || ((localActivity instanceof AccountPageActivity))) {
      localObject = new Intent(paramActivity, IndexActivity.class);
    }
    ((Intent)localObject).addFlags(67108864);
    return localObject;
  }
  
  public void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, Handler paramHandler)
  {
    if (!paramActivity.isFinishing())
    {
      if (paramDeterminVerifyFactorsResult == null) {
        return;
      }
      this.b = paramActivity;
      Object localObject1 = cs.a().e();
      if (paramDeterminVerifyFactorsResult.c() == 2) {
        localObject1 = this.d;
      }
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramDeterminVerifyFactorsResult.l() != null)
      {
        localObject1 = localObject2;
        if (paramDeterminVerifyFactorsResult.l().size() > 0) {
          localObject1 = (DeterminVerifyFactorsResult.VerifyTypeItem)paramDeterminVerifyFactorsResult.l().get(0);
        }
      }
      a(paramActivity, paramDeterminVerifyFactorsResult, (DeterminVerifyFactorsResult.VerifyTypeItem)localObject1, paramHandler);
      return;
    }
  }
  
  public void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, int paramInt, boolean paramBoolean, Handler paramHandler)
  {
    if (!paramActivity.isFinishing())
    {
      if (paramDeterminVerifyFactorsResult == null) {
        return;
      }
      QQUser localQQUser = cs.a().e();
      if (paramDeterminVerifyFactorsResult.c() == 2) {
        localQQUser = this.d;
      }
      if (localQQUser == null) {
        return;
      }
      a(paramActivity, paramDeterminVerifyFactorsResult, localQQUser, paramVerifyTypeItem, paramInt, paramBoolean, paramHandler);
      return;
    }
  }
  
  public void a(Activity paramActivity, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, Handler paramHandler)
  {
    if (!paramActivity.isFinishing())
    {
      if (paramDeterminVerifyFactorsResult == null) {
        return;
      }
      QQUser localQQUser = cs.a().e();
      if (paramDeterminVerifyFactorsResult.c() == 2) {
        localQQUser = this.d;
      }
      if (localQQUser == null) {
        return;
      }
      if (paramVerifyTypeItem != null)
      {
        List localList = paramVerifyTypeItem.c();
        if ((localList != null) && (localList.size() > 0))
        {
          i = ((Integer)localList.get(0)).intValue();
          break label87;
        }
      }
      int i = -1;
      label87:
      a(paramActivity, paramDeterminVerifyFactorsResult, paramVerifyTypeItem, i, true, paramHandler);
      paramActivity = new StringBuilder();
      paramActivity.append(localQQUser.mRealUin);
      paramActivity.append("");
      TMSDKContext.SaveStringData(1150089, paramActivity.toString());
      return;
    }
  }
  
  public void a(QQUser paramQQUser)
  {
    this.d = paramQQUser;
  }
  
  public Activity b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.u
 * JD-Core Version:    0.7.0.1
 */