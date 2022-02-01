import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.util.UUID;

class apdt
  implements ProxyListener
{
  apdt(apds paramapds, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.a.Id.toString() + "] addItem finish[del]. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.a.Id.toString() + "] addItem finish. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.a.Id.toString() + "] addItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdt
 * JD-Core Version:    0.7.0.1
 */