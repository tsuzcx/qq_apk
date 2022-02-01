import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.BidDownloader.1.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class joz
  implements jox
{
  public joz(BidDownloader paramBidDownloader, long paramLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    boolean bool = true;
    int i = 0;
    int j = (int)(System.currentTimeMillis() - this.val$start);
    if ((jpa.aR != null) && (jpa.aR.containsKey(this.this$0.mBusinessId))) {
      jpa.aR.remove(this.this$0.mBusinessId);
    }
    this.this$0.mUiHandler.sendEmptyMessage(0);
    if (paramInt == 0)
    {
      stw.oy(this.this$0.mBusinessId);
      if (this.this$0.aaU)
      {
        if (!jpa.dg(this.this$0.mBusinessId))
        {
          jqo.deleteFile(this.this$0.TM);
          jqo.dn(jpe.dO(this.this$0.mBusinessId) + this.this$0.mBusinessId);
          paramString = this.this$0.mUiHandler.obtainMessage(2, 10, j);
          this.this$0.mUiHandler.sendMessage(paramString);
          jpa.a(this.this$0.mBusinessId, 14, 0L, jqi.getNetworkType(BidDownloader.mContext), "lixian_update", "0");
          stw.a(this.this$0.mBusinessId, "Offline_Update_BSDiff", j, 14, "", "", "");
        }
      }
      else if (((this.this$0.aaW) || (this.this$0.aaX)) && (!this.this$0.yi()))
      {
        QLog.e(BidDownloader.TAG, 1, "businessId " + this.this$0.mBusinessId + " now un compress file error! " + this.this$0.TM);
        return;
      }
      if (2 == this.this$0.mType)
      {
        bool = jpa.dh(this.this$0.mBusinessId);
        paramString = this.this$0.mUiHandler.obtainMessage(2, -1, j);
        this.this$0.mUiHandler.sendMessage(paramString);
      }
      while (this.this$0.aaU)
      {
        stw.a(this.this$0.mBusinessId, "Offline_Update_BSDiff", j, 0, "", "", "");
        BaseApplicationImpl.getApplication().getSharedPreferences("bid_update_success_time", 4).edit().putLong(this.this$0.mBusinessId, System.currentTimeMillis()).commit();
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "success update bid: " + this.this$0.mBusinessId);
        }
        jpa.a(this.this$0.mBusinessId, paramInt, j, jqi.getNetworkType(BidDownloader.mContext), "lixian_update", this.this$0.ver + "");
        return;
        if (this.this$0.aaT) {
          bool = jpa.dh(this.this$0.mBusinessId);
        }
        paramString = this.this$0.mUiHandler.obtainMessage(2, 0, j);
        this.this$0.mUiHandler.sendMessage(paramString);
      }
      paramString = this.this$0.mBusinessId;
      if (bool) {}
      for (;;)
      {
        stw.a(paramString, "Offline_Update", j, i, "", "", "");
        break;
        i = 13;
      }
    }
    paramString = this.this$0;
    paramString.failCount += 1;
    if (this.this$0.failCount < 3)
    {
      BidDownloader.jdField_a_of_type_Jpl.runOnSubThread(new BidDownloader.1.1(this));
      return;
    }
    paramString = this.this$0.mUiHandler.obtainMessage(2, 2, j);
    this.this$0.mUiHandler.sendMessage(paramString);
    jpa.a(this.this$0.mBusinessId, paramInt, j, jqi.getNetworkType(BidDownloader.mContext), "lixian_update", this.this$0.ver + "");
    stw.a(this.this$0.mBusinessId, "Offline_Update", j, paramInt, "", "", "");
  }
  
  public void progress(int paramInt)
  {
    if (this.this$0.jdField_a_of_type_Jox != null) {
      this.this$0.jdField_a_of_type_Jox.progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     joz
 * JD-Core Version:    0.7.0.1
 */