import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class yhh
  implements aolm.b
{
  yhh(yhf paramyhf, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + paramaomh.dPy + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((paramaomh.dPy == 200) && (yhf.a(this.this$0, yhf.a(this.this$0), yhf.b(this.this$0), this.val$md5, this.bmH)))
    {
      if (!yhf.b(this.this$0).exists()) {
        break label423;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "pull words success");
      }
      l1 = 0L;
    }
    for (;;)
    {
      int i;
      try
      {
        long l2 = SystemClock.elapsedRealtime();
        l1 = l2;
        Object localObject = new JSONObject(aqhq.readFileToString(yhf.b(this.this$0)));
        l1 = l2;
        paramaomh = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = paramaomh;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          paramaomh = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(paramaomh)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(paramaomh);
          break label438;
        }
        l1 = l2;
        aqhq.deleteFile(yhf.c(this.this$0).getAbsolutePath());
        l1 = l2;
        yhf.a(this.this$0, yhf.c(this.this$0).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        aqhq.deleteFile(yhf.b(this.this$0).getAbsolutePath());
        l1 = l2;
        aqmj.t(yhf.a(this.this$0).getApp(), "words_version_key805_gray_one", yhf.a(this.this$0).getCurrentUin(), this.val$version);
        l1 = l2;
        this.this$0.unInit();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception paramaomh)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StickerRecManager", 2, "generate encode table time error cost : " + (SystemClock.elapsedRealtime() - l1));
        QLog.d("StickerRecManager", 2, "build EncodeTable error !");
        return;
      }
      label423:
      if (QLog.isColorLevel())
      {
        QLog.d("StickerRecManager", 2, "updateWords fail: words file is not exist.");
        return;
        label438:
        i += 1;
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhh
 * JD-Core Version:    0.7.0.1
 */