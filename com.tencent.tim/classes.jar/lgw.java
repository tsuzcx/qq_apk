import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspItem;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.RspBody;

class lgw
  extends jnm.a
{
  lgw(lgv paramlgv, lgv.a parama) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(lgv.TAG, 2, "getAtlasFavoriteStatus onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        paramBundle = new oidb_0xb40.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((oidb_0xb40.CheckFavoriteRspBody)paramBundle.msg_check_favorite_rsp.get()).rpt_msg_rsp_items.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          Object localObject = (oidb_0xb40.CheckFavoriteRspItem)paramArrayOfByte.next();
          paramBundle = ((oidb_0xb40.CheckFavoriteRspItem)localObject).bytes_rowkey.get().toStringUtf8();
          if (((oidb_0xb40.CheckFavoriteRspItem)localObject).uint32_result.get() == 1)
          {
            bool = true;
            localArrayList = new ArrayList();
            if (!bool) {
              break label242;
            }
            localObject = ((oidb_0xb40.CheckFavoriteRspItem)localObject).bytes_cid_list.get().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label242;
            }
            localArrayList.add(((ByteStringMicro)((Iterator)localObject).next()).toStringUtf8());
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.jdField_b_of_type_Lgv$a != null) {
          this.jdField_b_of_type_Lgv$a.a(false, null, false, null);
        }
        QLog.e(lgv.TAG, 1, "getAtlasFavoriteStatus onResult(), exception=" + paramArrayOfByte.toString());
      }
      boolean bool = false;
      continue;
      label242:
      if (this.jdField_b_of_type_Lgv$a != null) {
        this.jdField_b_of_type_Lgv$a.a(true, paramBundle, bool, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgw
 * JD-Core Version:    0.7.0.1
 */