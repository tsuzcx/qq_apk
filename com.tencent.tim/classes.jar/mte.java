import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class mte
  implements mtf.a
{
  mte(mtc.a parama) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, mtf.b> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = mtc.J().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      mtc.J().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      awit.H("kandian_video_extract_frame_local_result", mtc.J().toString());
      label66:
      mtc.access$302(System.currentTimeMillis() - mtc.access$400());
      mtc.E(paramLong);
      mtc.b(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!mtc.access$000().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (mtc.a() == null) {
        return;
      }
      mtc.a().destory();
      mtc.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mte
 * JD-Core Version:    0.7.0.1
 */