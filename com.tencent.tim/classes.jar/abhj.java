import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class abhj
  implements abto.b
{
  abhj(abhh paramabhh) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {
      if ((paramInt1 > 0) && (!ApolloUtil.ih(paramInt1))) {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "role rsc NOT complete.");
        }
      }
    }
    label96:
    do
    {
      aqrb localaqrb;
      do
      {
        return;
        if (paramArrayOfInt != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramArrayOfInt.length) {
              break label96;
            }
            if (!ApolloUtil.ig(paramArrayOfInt[paramInt1]))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloManager", 2, "dress rsc NOT complete, id:" + paramArrayOfInt[paramInt1]);
              return;
            }
            paramInt1 += 1;
          }
        }
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        localaqrb = (aqrb)this.this$0.mApp.getBusinessHandler(71);
        localaqrb.notifyUI(2, true, paramArrayOfInt);
        abmm.a().dt(paramArrayOfInt);
        localaqrb.a(paramString, null);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloManager", 2, "apollo dress download ok notifyUI uin: " + ApolloUtil.iY(paramString));
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        localaqrb = (aqrb)this.this$0.mApp.getBusinessHandler(71);
        localaqrb.notifyUI(2, false, paramArrayOfInt);
        localaqrb.a(paramString, null);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "apollo dress download failed " + ApolloUtil.iY(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhj
 * JD-Core Version:    0.7.0.1
 */