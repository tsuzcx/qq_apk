import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class apfw
  extends smq.h
{
  apfw(apfu paramapfu) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if ((!paramBoolean) || (paramFileInfo == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = paramFileInfo.str_file_id.get();
          } while (TextUtils.isEmpty((CharSequence)localObject2));
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("/")) {
            localObject1 = "/" + (String)localObject2;
          }
        } while (!((String)localObject1).equalsIgnoreCase(this.a.c.FilePath));
        apef.b.i("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.coy + "] onGetOneFileResult. bus_id:" + paramFileInfo.uint32_bus_id.get() + " dead_time:" + paramFileInfo.uint32_dead_time.get());
        localObject2 = apef.a(this.a.mTroopUin);
      } while (localObject2 == null);
      localObject1 = ((apsf)localObject2).a((String)localObject1);
    } while (localObject1 == null);
    ((apbr)localObject1).dTg = paramFileInfo.uint32_bus_id.get();
    ((apbr)localObject1).dTh = paramFileInfo.uint32_dead_time.get();
    ((apsf)localObject2).k((apbr)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfw
 * JD-Core Version:    0.7.0.1
 */