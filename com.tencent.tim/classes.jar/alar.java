import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class alar
{
  private static HashMap<Long, alar.a> mo = new HashMap();
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.getBitValue(1) == 1) {}
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPredictionEvaluator", 2, "msgViewedInAIO, size=" + mo.size());
      }
      l = System.currentTimeMillis();
    } while ((mo.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))) || (mo.size() >= 24));
    paramQQAppInterface = new alar.a(paramQQAppInterface, paramMessageForShortVideo, l, 0L);
    mo.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramQQAppInterface);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.getBitValue(1) == 1) {}
    long l;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPredictionEvaluator", 2, "msgClicked, size=" + mo.size());
        }
        l = System.currentTimeMillis();
      } while (!mo.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
      paramQQAppInterface = (alar.a)mo.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
    } while (paramQQAppInterface == null);
    paramQQAppInterface.kB(l);
    paramQQAppInterface.doReport();
  }
  
  public static void jf(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("business_type", String.valueOf(paramInt1));
    localHashMap.put("prediction_step", String.valueOf(paramInt2));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPredictionData", true, 0L, 0L, localHashMap, "");
  }
  
  public static class a
  {
    public boolean VN;
    public long afX;
    public long afY;
    public boolean bBz;
    public int drh = aqiw.getSystemNetwork(BaseApplication.getContext());
    public int dri;
    public boolean mAutoDownload;
    
    public a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, long paramLong1, long paramLong2)
    {
      this.mAutoDownload = angb.a(paramQQAppInterface, paramMessageForShortVideo);
      if (paramMessageForShortVideo.videoAttr == 1) {}
      for (;;)
      {
        this.bBz = bool;
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.e(String.valueOf(paramMessageForShortVideo.senderuin));
          if (paramQQAppInterface != null) {
            this.VN = paramQQAppInterface.isFriend();
          }
        }
        this.afX = paramLong1;
        this.afY = paramLong2;
        return;
        bool = false;
      }
    }
    
    public void doReport()
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("doReport:");
        ((StringBuilder)localObject).append("mMsgViewedInAIOTime=").append(this.afX).append("|");
        ((StringBuilder)localObject).append("mMsgClickedTime=").append(this.afY).append("|");
        ((StringBuilder)localObject).append("mViewNetType=").append(this.drh).append("|");
        ((StringBuilder)localObject).append("mClickNetType=").append(this.dri).append("|");
        ((StringBuilder)localObject).append("mAutoDownload=").append(this.mAutoDownload).append("|");
        ((StringBuilder)localObject).append("mIsFriend=").append(this.VN).append("|");
        ((StringBuilder)localObject).append("mIsHotVideo=").append(this.bBz).append("|");
        QLog.i("ShortVideoPredictionEvaluator", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("viewed_time", String.valueOf(this.afX));
      ((HashMap)localObject).put("click_time", String.valueOf(this.afY));
      ((HashMap)localObject).put("view_net", String.valueOf(this.drh));
      ((HashMap)localObject).put("click_net", String.valueOf(this.dri));
      ((HashMap)localObject).put("auto_download", String.valueOf(this.mAutoDownload));
      ((HashMap)localObject).put("is_friend", String.valueOf(this.VN));
      ((HashMap)localObject).put("is_hot", String.valueOf(this.bBz));
      if (this.afY > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actVideoMessageTime", bool, 0L, 0L, (HashMap)localObject, "");
        return;
      }
    }
    
    public void kB(long paramLong)
    {
      if (this.afY == 0L)
      {
        this.afY = paramLong;
        this.dri = aqiw.getSystemNetwork(BaseApplication.getContext());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alar
 * JD-Core Version:    0.7.0.1
 */