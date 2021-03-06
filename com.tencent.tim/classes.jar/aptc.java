import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ImgShowConfig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ImgShowItem;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.RspBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.StockInfo;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.StockItem;

class aptc
  extends jnm.c
{
  aptc(apsz paramapsz, apsy paramapsy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 0;
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.a);
      }
      if (this.a != null) {
        this.a.onError(paramInt, "sso request error or callback is null.");
      }
      return;
    }
    Object localObject1;
    try
    {
      localObject1 = new oidb_0x6c3.RspBody();
      ((oidb_0x6c3.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      paramInt = ((oidb_0x6c3.RspBody)localObject1).int32_ret.get();
      if ((paramInt != 0) || (paramBundle == null)) {
        break label681;
      }
      paramInt = paramBundle.getInt("subCmd");
      if (((paramInt == 0) || (paramInt == 2) || (paramInt == 7)) && (((oidb_0x6c3.RspBody)localObject1).msg_get_stock.has()))
      {
        paramArrayOfByte = (oidb_0x6c3.GetStockRsp)((oidb_0x6c3.RspBody)localObject1).msg_get_stock.get();
        paramBundle = new ArrayList(10);
        Object localObject2;
        if (paramArrayOfByte.msg_stock.has())
        {
          localObject1 = (oidb_0x6c3.StockInfo)paramArrayOfByte.msg_stock.get();
          if (((oidb_0x6c3.StockInfo)localObject1).msg_stock.has())
          {
            localObject1 = ((oidb_0x6c3.StockInfo)localObject1).msg_stock.get();
            paramInt = 0;
            while (paramInt < ((List)localObject1).size())
            {
              localObject2 = (oidb_0x6c3.StockItem)((List)localObject1).get(paramInt);
              apsz.a locala = new apsz.a();
              locala.giftId = ((oidb_0x6c3.StockItem)localObject2).int32_productid.get();
              locala.count = ((oidb_0x6c3.StockItem)localObject2).int32_amount.get();
              locala.dVN = ((oidb_0x6c3.StockItem)localObject2).int32_free_limit_chance.get();
              paramBundle.add(locala);
              paramInt += 1;
            }
          }
        }
        this.a.a(paramArrayOfByte.int32_count.get(), paramArrayOfByte.int32_give_count.get(), paramArrayOfByte.bytes_give_info.get().toStringUtf8(), paramBundle);
        paramBundle = new SparseArray();
        if (paramArrayOfByte.msg_imgshow_config.has())
        {
          int j = paramArrayOfByte.msg_imgshow_config.msg_imgshow_item.size();
          paramInt = i;
          while (paramInt < j)
          {
            localObject1 = (oidb_0x6c3.ImgShowItem)paramArrayOfByte.msg_imgshow_config.msg_imgshow_item.get(paramInt);
            localObject2 = new apsz.c();
            ((apsz.c)localObject2).price = ((oidb_0x6c3.ImgShowItem)localObject1).uint32_price.get();
            ((apsz.c)localObject2).wording = ((oidb_0x6c3.ImgShowItem)localObject1).bytes_wording.get().toStringUtf8();
            ((apsz.c)localObject2).cre = ((oidb_0x6c3.ImgShowItem)localObject1).bytes_cut_wording.get().toStringUtf8();
            paramBundle.put(((oidb_0x6c3.ImgShowItem)localObject1).uint32_productid.get(), localObject2);
            paramInt += 1;
          }
        }
        this.a.d(paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.a.onError(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    if (((paramInt == 1) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10)) && (((oidb_0x6c3.RspBody)localObject1).msg_extra_data.has()))
    {
      paramArrayOfByte = (oidb_0x6c3.GetExtraDataRsp)((oidb_0x6c3.RspBody)localObject1).msg_extra_data.get();
      paramBundle = snf.v(((oidb_0x6c3.RspBody)localObject1).exclusive_gift_list.get());
      paramInt = ((oidb_0x6c3.RspBody)localObject1).msg_extra_data.int32_version_seq.get();
      this.a.fp(paramArrayOfByte.bytes_shop_config.get().toStringUtf8(), paramInt);
      this.a.z(paramArrayOfByte.bytes_shop_config.get().toStringUtf8(), paramInt, paramBundle);
      return;
    }
    this.a.onError(-1, "Invalid RspData. subCmd:" + paramInt);
    return;
    label681:
    paramArrayOfByte = ((oidb_0x6c3.RspBody)localObject1).bytes_msg.get().toStringUtf8();
    this.a.onError(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptc
 * JD-Core Version:    0.7.0.1
 */