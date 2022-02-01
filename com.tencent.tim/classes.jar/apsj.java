import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileRspBody;

class apsj
  extends smq.p
{
  apsj(apsf paramapsf) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.TransFileRspBody paramTransFileRspBody, Bundle paramBundle)
  {
    Object localObject = this.c;
    ((apsf)localObject).mRunningCount -= 1;
    if ((!paramBoolean) || (paramTransFileRspBody == null)) {
      apef.b.e("TroopFileManager", apef.b.USR, "onTransFileResult:  isSuccess:false");
    }
    do
    {
      return;
      localObject = paramBundle.getString("fileId");
      paramBundle = (apbr)this.c.nO.get(localObject);
    } while (paramBundle == null);
    int i = paramTransFileRspBody.int32_ret_code.get();
    apef.b.i("TroopFileManager", apef.b.USR, "onTransFileResult: fileId:" + (String)localObject + " isSuccess:" + paramBoolean + " errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      paramInt = 501;
      switch (i)
      {
      }
      for (;;)
      {
        this.c.a(paramBundle, paramInt);
        return;
        paramInt = 504;
        continue;
        paramInt = 103;
        continue;
        paramInt = 101;
        continue;
        paramInt = 503;
        continue;
        paramInt = 502;
      }
    }
    paramTransFileRspBody = paramTransFileRspBody.str_save_file_path.get();
    this.c.d.a(paramBundle.Id, paramTransFileRspBody);
    paramBundle.mFileId = paramTransFileRspBody;
    paramBundle.dTg = 102;
    paramBundle.dTh = 0;
    this.c.nO.remove(localObject);
    this.c.nO.put(paramTransFileRspBody, paramBundle);
    this.c.k(paramBundle);
    paramTransFileRspBody = (apsf.a)this.c.nQ.get(paramBundle.mParentId);
    if (paramTransFileRspBody != null) {
      paramTransFileRspBody.a = null;
    }
    this.c.a(paramBundle, 505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsj
 * JD-Core Version:    0.7.0.1
 */