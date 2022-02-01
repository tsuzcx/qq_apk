import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class apqc
  extends acnd
{
  apqc(appx paramappx) {}
  
  protected void T(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (appx.a(this.this$0) != null)) {
      appx.a(this.this$0).Tv(paramString);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if ((appx.a(this.this$0) == null) || (appx.a(this.this$0) == null)) {
      return;
    }
    appx.a(this.this$0).b(paramBoolean, paramLong, paramTroopInfo);
  }
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    if ((paramRespBatchProcess == null) || (paramRespBatchProcess.batch_response_list == null) || (paramRespBatchProcess.batch_response_list.size() == 0) || (appx.a(this.this$0) == null)) {}
    int j;
    do
    {
      do
      {
        do
        {
          return;
        } while ((!String.valueOf(paramLong).equals(appx.a(this.this$0).troopUin)) || (appx.a(this.this$0) == null) || (appx.a(this.this$0) == null));
        if (appx.a(this.this$0).mTitleTv != null) {
          appx.a(this.this$0).mTitleTv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      } while (!String.valueOf(paramLong).equals(appx.a(this.this$0).troopUin));
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((paramBundle == null) || (paramBundle.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (paramBundle.type == 1) {
            appx.a(this.this$0, paramBundle);
          }
        }
      }
    } while (j <= 0);
    this.this$0.bWy();
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((appx.a(this.this$0) == null) || (appx.a(this.this$0) == null)) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!aqft.equalsWithNullCheck(paramString1, appx.a(this.this$0).troopUin)));
      if (paramInt1 == 0)
      {
        this.this$0.aC(paramList, true);
        return;
      }
    } while (paramString2 != null);
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      paramString2 = appx.a(this.this$0).getString(2131698299);
    }
    for (;;)
    {
      appx.a(this.this$0).showToast(paramString2);
      return;
      if (paramInt1 == 19) {
        paramString2 = appx.a(this.this$0).getString(2131698297);
      } else if (paramInt1 == 65) {
        paramString2 = appx.a(this.this$0).getString(2131698298);
      }
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.b(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (paramInt1 != 2) {}
    while ((!paramBoolean) || (appx.a(this.this$0) == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    appx.a(this.this$0).i(paramLong1, paramList);
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((appx.a(this.this$0) == null) || (appx.a(this.this$0) == null)) {}
    while (!aqft.equalsWithNullCheck(paramString1, appx.a(this.this$0).troopUin)) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.this$0.aC(paramList, true);
      return;
    }
    this.this$0.aC(paramList, true);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramInt1 != 1) {
        break label106;
      }
      paramString1 = appx.a(this.this$0).getString(2131698299);
    }
    for (;;)
    {
      appx.a(this.this$0).showToast(paramString1);
      return;
      label106:
      if (paramInt1 == 2) {
        paramString1 = appx.a(this.this$0).getString(2131698297);
      } else if (paramInt1 == 3) {
        paramString1 = appx.a(this.this$0).getString(2131698310);
      } else if (paramInt1 == 4) {
        paramString1 = appx.a(this.this$0).getString(2131698311);
      } else {
        paramString1 = appx.a(this.this$0).getString(2131698308);
      }
    }
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      if (appx.a(this.this$0) == null) {
        break label86;
      }
    }
    for (;;)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((appx.a(this.this$0) != null) && (appx.a(this.this$0) != null)) {
        break;
      }
      return;
      label86:
      bool = false;
    }
    appx.a(this.this$0).eE(paramInt1, paramInt2);
  }
  
  protected void j(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (appx.a(this.this$0) != null) && (paramString.equals(appx.a(this.this$0).troopUin))) {
      this.this$0.bFL = paramInt;
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label111;
      }
      str = "";
      if (appx.a(this.this$0) == null) {
        break label117;
      }
    }
    label111:
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((appx.a(this.this$0) != null) && (appx.a(this.this$0) != null)) {
        break label123;
      }
      return;
      str = paramString;
      break;
    }
    label123:
    appx.a(this.this$0).q(paramInt1, paramInt2, paramString);
  }
  
  protected void uX(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (appx.a(this.this$0) == null) {
      return;
    }
    appx.a(this.this$0).uX(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqc
 * JD-Core Version:    0.7.0.1
 */