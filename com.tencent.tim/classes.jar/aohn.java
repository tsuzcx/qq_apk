import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public abstract class aohn
  implements aohl
{
  QQAppInterface app;
  
  public aohn(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public abstract int KG();
  
  public TofuItem a(@NotNull TofuItem paramTofuItem, long paramLong)
  {
    if (paramLong - paramTofuItem.lastPullTsLocal >= paramTofuItem.pullInterval) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_TofuDataBaseHandler", 2, String.format("makeReqItemIfPull [%s] tsCheck=%b ts=%d lastTs=%d interval=%d", new Object[] { aohm.fA(paramTofuItem.busId), Boolean.valueOf(bool), Long.valueOf(paramLong), Long.valueOf(paramTofuItem.lastPullTsLocal), Long.valueOf(paramTofuItem.pullInterval) }));
      }
      if (!bool) {
        break;
      }
      TofuItem localTofuItem = new TofuItem(Long.toString(paramTofuItem.frdUin), paramTofuItem.busId);
      localTofuItem.cloneFrom(paramTofuItem);
      return localTofuItem;
    }
    return null;
  }
  
  public abstract String a(TofuItem paramTofuItem);
  
  public final void a(@NotNull TofuItem paramTofuItem, oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult, long paramLong)
  {
    boolean bool;
    if ((paramBeancurdCubeInfoResult.uint32_result.has()) && (paramBeancurdCubeInfoResult.uint32_result.get() == 0)) {
      bool = true;
    }
    for (;;)
    {
      if (paramBeancurdCubeInfoResult.beancurdCubeInfo.has())
      {
        paramBeancurdCubeInfoResult = (oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get();
        bool = a(paramTofuItem, bool, paramLong, paramBeancurdCubeInfoResult);
        if (!bool) {}
      }
      try
      {
        paramBeancurdCubeInfoResult = a(paramTofuItem);
        if (!TextUtils.isEmpty(paramBeancurdCubeInfoResult))
        {
          wkh localwkh = (wkh)this.app.getManager(282);
          BeancurdMsg localBeancurdMsg = new BeancurdMsg();
          localBeancurdMsg.frienduin = Long.toString(paramTofuItem.frdUin);
          localBeancurdMsg.busiid = KG();
          localBeancurdMsg.isNeedDelHistory = paramTofuItem.bNeedDelHistory();
          localBeancurdMsg.ispush = paramTofuItem.bInsertImmediate();
          localBeancurdMsg.originTime = paramTofuItem.eventTs;
          localBeancurdMsg.startTime = anaz.gQ();
          localBeancurdMsg.validTime = paramTofuItem.validTime;
          localBeancurdMsg.buffer = paramBeancurdCubeInfoResult;
          localwkh.a(localBeancurdMsg);
        }
        QLog.d("Tofu_TofuDataBaseHandler", 1, String.format("onGetRsp [%s] bNew=%b ts=%d item=%s", new Object[] { aohm.fA(paramTofuItem.busId), Boolean.valueOf(bool), Long.valueOf(paramLong), paramTofuItem }));
        return;
        bool = false;
        continue;
        paramBeancurdCubeInfoResult = null;
      }
      catch (Exception paramBeancurdCubeInfoResult)
      {
        for (;;)
        {
          QLog.d("Tofu_TofuDataBaseHandler", 1, "onGetRsp exception=" + paramBeancurdCubeInfoResult.getMessage(), paramBeancurdCubeInfoResult);
        }
      }
    }
  }
  
  public boolean a(TofuItem paramTofuItem, boolean paramBoolean, long paramLong, oidb_0xe61.BeancurdCubeInfo paramBeancurdCubeInfo)
  {
    if ((paramBoolean) && (paramBeancurdCubeInfo != null))
    {
      long l1 = paramTofuItem.eventTs;
      long l2 = paramTofuItem.lastPullTsSvr;
      paramTofuItem.lastPullTsLocal = paramLong;
      label71:
      label112:
      byte[] arrayOfByte;
      if (paramBeancurdCubeInfo.uint64_event_time.has())
      {
        paramLong = paramBeancurdCubeInfo.uint64_event_time.get();
        paramTofuItem.eventTs = paramLong;
        if (!paramBeancurdCubeInfo.uint64_pull_interval_time.has()) {
          break label257;
        }
        paramLong = paramBeancurdCubeInfo.uint64_pull_interval_time.get();
        paramTofuItem.pullInterval = paramLong;
        if (paramTofuItem.pullInterval <= 0L) {
          paramTofuItem.pullInterval = 86400L;
        }
        if (!paramBeancurdCubeInfo.uint64_last_pull_time.has()) {
          break label264;
        }
        paramLong = paramBeancurdCubeInfo.uint64_last_pull_time.get();
        paramTofuItem.lastPullTsSvr = paramLong;
        if (!paramBeancurdCubeInfo.uint64_valid_time.has()) {
          break label272;
        }
        paramLong = paramBeancurdCubeInfo.uint64_valid_time.get();
        label137:
        paramTofuItem.validTime = paramLong;
        if (!paramBeancurdCubeInfo.uint64_flag.has()) {
          break label280;
        }
        paramLong = paramBeancurdCubeInfo.uint64_flag.get();
        label162:
        paramTofuItem.flags = paramLong;
        if (!paramBeancurdCubeInfo.bytes_busi_data_rsp.has()) {
          break label288;
        }
        arrayOfByte = paramBeancurdCubeInfo.bytes_busi_data_rsp.get().toByteArray();
        label191:
        paramTofuItem.bytesFromServer = arrayOfByte;
        if (!paramBeancurdCubeInfo.bytes_busi_data_req.has()) {
          break label294;
        }
      }
      label257:
      label264:
      label272:
      label280:
      label288:
      label294:
      for (paramBeancurdCubeInfo = paramBeancurdCubeInfo.bytes_busi_data_req.get().toByteArray();; paramBeancurdCubeInfo = null)
      {
        paramTofuItem.bytesFromClient = paramBeancurdCubeInfo;
        if ((paramTofuItem.eventTs <= l1) || (paramTofuItem.lastPullTsSvr <= l2)) {
          break label300;
        }
        return true;
        paramLong = paramTofuItem.eventTs;
        break;
        paramLong = 86400L;
        break label71;
        paramLong = paramTofuItem.lastPullTsSvr;
        break label112;
        paramLong = paramTofuItem.validTime;
        break label137;
        paramLong = paramTofuItem.flags;
        break label162;
        arrayOfByte = null;
        break label191;
      }
      label300:
      return false;
    }
    paramTofuItem.lastPullTsLocal = paramLong;
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohn
 * JD-Core Version:    0.7.0.1
 */