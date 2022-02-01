import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.util.UUID;

class apdu
  implements ProxyListener
{
  apdu(apds paramapds, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.a.Id.toString() + "] updateItem finish[del]. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.a.Id.toString() + "] updateItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.a.Id.toString() + "] updateItem finish. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdu
 * JD-Core Version:    0.7.0.1
 */