import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;

class amhf
  implements EIPCResultCallback
{
  amhf(amhd paramamhd) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = paramEIPCResult.data;
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (((Bundle)localObject).getInt("notify_type"))
            {
            case 6: 
            case 7: 
            default: 
              return;
            case 4: 
              paramEIPCResult = ((Bundle)localObject).getSerializable("my_signature");
            }
          } while (!(paramEIPCResult instanceof RichStatus));
          amhd.c(this.this$0);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(Integer.valueOf(5));
          ((ArrayList)localObject).add(paramEIPCResult);
          this.this$0.notifyObservers(localObject);
          return;
          localObject = new HashMap();
          ((HashMap)localObject).put("change_status_callback_data", paramEIPCResult.data);
          i = paramEIPCResult.data.getInt("result");
          int j = paramEIPCResult.data.getInt("type");
          amhd.d(this.this$0);
          paramEIPCResult = new ArrayList();
          paramEIPCResult.add(Integer.valueOf(6));
          paramEIPCResult.add(Integer.valueOf(i));
          paramEIPCResult.add(localObject);
          paramEIPCResult.add(Integer.valueOf(j));
          this.this$0.notifyObservers(paramEIPCResult);
          return;
          ((Bundle)localObject).getLong("bid");
          paramEIPCResult = ((Bundle)localObject).getString("scid");
        } while (TextUtils.isEmpty(paramEIPCResult));
        i = ((Bundle)localObject).getInt("download_result");
      } while ((!paramEIPCResult.startsWith("signature.sticker.")) || (i != 0));
      paramEIPCResult = paramEIPCResult.substring("signature.sticker.".length(), paramEIPCResult.length() - 4);
    } while (!TextUtils.isDigitsOnly(paramEIPCResult));
    int i = Integer.parseInt(paramEIPCResult);
    amhd.e(this.this$0);
    paramEIPCResult = new ArrayList();
    paramEIPCResult.add(Integer.valueOf(7));
    paramEIPCResult.add(Integer.valueOf(i));
    this.this$0.notifyObservers(paramEIPCResult);
    return;
    i = ((Bundle)localObject).getInt("key_history_signature_num");
    amhd.f(this.this$0);
    paramEIPCResult = new ArrayList();
    paramEIPCResult.add(Integer.valueOf(8));
    paramEIPCResult.add(Integer.valueOf(i));
    this.this$0.notifyObservers(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhf
 * JD-Core Version:    0.7.0.1
 */