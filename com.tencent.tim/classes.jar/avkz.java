import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReqInfo;

public class avkz
  implements avky.a
{
  public boolean f(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          return true;
          accr.cm((QQAppInterface)localObject);
          return true;
          paramBundle = (acnj)((QQAppInterface)localObject).getBusinessHandler(44);
          paramBundle.a(new avla(this));
          paramBundle.FH("");
          return true;
          paramBundle = (accy)((QQAppInterface)localObject).getBusinessHandler(4);
          paramBundle.a(null, new GetResourceReqInfo[] { paramBundle.d() });
          return true;
          ((QQAppInterface)localObject).addObserver(new avlb(this));
          return true;
          boolean bool = paramBundle.getBoolean("visible");
          ((acgr)((QQAppInterface)localObject).getBusinessHandler(3)).EZ(bool);
          return true;
          paramInt = paramBundle.getInt("iFaceType");
          str1 = paramBundle.getString("uinOrMobileNum");
          byte b = paramBundle.getByte("faceFileType");
          int i = paramBundle.getInt("idType");
          paramBundle = (FriendListHandler)((QQAppInterface)localObject).getBusinessHandler(1);
          switch (paramInt)
          {
          default: 
            return true;
          case 1: 
            paramBundle.a(str1, (byte)0, b);
            return true;
          case 11: 
            paramBundle.c(str1, b);
            return true;
          case 4: 
            paramBundle.b(str1, b);
            return true;
          case 32: 
            paramBundle.a(str1, i, (byte)1, b);
            return true;
          }
          paramBundle.b(str1, i, (byte)1, b);
          return true;
          str1 = paramBundle.getString("mUin");
          str2 = paramBundle.getString("feedsId");
          paramInt = paramBundle.getInt("action");
          paramBundle = (SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(41);
        } while (paramBundle == null);
        paramBundle.l(str1, str2, 255, paramInt);
        return true;
        ((QQAppInterface)localObject).addObserver(new avlc(this));
        return true;
        ((QQAppInterface)localObject).registObserver(new avkz.a(null));
        return true;
        paramBundle = (SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(41);
      } while (paramBundle == null);
      paramBundle.cMw();
      return true;
      ((SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(41)).c(paramBundle.getString("uin"), paramBundle.getString("feedsId"), 255, true);
      return true;
      paramBundle = aqgv.A((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = new Bundle();
      ((Bundle)localObject).putString("name", paramBundle);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 6, (Bundle)localObject);
      return true;
    } while (paramBundle == null);
    ((QQAppInterface)localObject).sendToService((ToServiceMsg)paramBundle.getParcelable("msg"));
    return true;
  }
  
  class a
    extends amho
  {
    private a() {}
    
    protected void c(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RichStatus> paramArrayList, boolean paramBoolean3)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isSuccess", paramBoolean1);
      localBundle.putInt("start", paramInt1);
      localBundle.putInt("end", paramInt2);
      localBundle.putBoolean("over", paramBoolean2);
      localBundle.putSerializable("data", paramArrayList);
      localBundle.putBoolean("isAddFromCard", paramBoolean3);
      localBundle.putInt("which_method", 0);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 5, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avkz
 * JD-Core Version:    0.7.0.1
 */