import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;

public class afjg
  implements abto.b
{
  public afjg(MessengerService.a parama, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    int i;
    if (paramBoolean) {
      if ((this.cRf == 1) && (this.val$qqApp != null))
      {
        paramArrayOfInt = ((abhh)this.val$qqApp.getManager(153)).b(this.val$qqApp.getCurrentAccountUin());
        if (paramArrayOfInt == null) {
          break label231;
        }
        i = paramArrayOfInt.apolloVipFlag;
        paramInt2 = paramArrayOfInt.apolloVipLevel;
      }
    }
    for (;;)
    {
      paramString.putInt("apollo_apolloVipFlag", i);
      paramString.putInt("apollo_apolloVipLevel", paramInt2);
      paramString.putBoolean("apollo_is_super_yellow", abhh.Yc());
      paramString.putInt("apollo_result", 0);
      paramString.putInt("apollo_partnerRoleId", paramInt1);
      paramString.putString("apollo_json", this.val$json);
      paramString.putInt("apollo_previewAction", this.cRg);
      paramString.putBoolean("apollo_previewOnFrame", this.bYq);
      paramString.putString("apollo_id", this.bgz);
      paramString.putString("title", this.val$title);
      paramString.putString("subTitle", this.bDt);
      this.val$reqbundle.putBundle("response", paramString);
      this.val$service.cp(this.val$reqbundle);
      return;
      paramString.putInt("apollo_result", 1);
      paramString.putString("apollo_json", this.val$json);
      this.val$reqbundle.putBundle("response", paramString);
      this.val$service.cp(this.val$reqbundle);
      return;
      label231:
      paramInt2 = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjg
 * JD-Core Version:    0.7.0.1
 */