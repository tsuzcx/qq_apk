import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class apsr
  extends smq.h
{
  public apsr(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if ((paramBoolean) && (paramFileInfo != null))
    {
      String str = paramFileInfo.str_file_id.get();
      Object localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/" + str;
      }
      localObject = this.this$0.a().a((String)localObject);
      if (localObject != null)
      {
        ((apbr)localObject).dTg = paramFileInfo.uint32_bus_id.get();
        ((apbr)localObject).dTh = paramFileInfo.uint32_dead_time.get();
      }
      this.this$0.a().k((apbr)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsr
 * JD-Core Version:    0.7.0.1
 */