import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class apdv
  implements ProxyListener
{
  apdv(apds paramapds, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.jdField_b_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.jdField_b_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    apef.b.d("TroopFileDataBaseProxy", apef.b.DEV, "[" + this.jdField_b_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdv
 * JD-Core Version:    0.7.0.1
 */