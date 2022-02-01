import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class miu
{
  private miu.a a;
  private int aIP;
  public int aTq = 0;
  private String aiX;
  private String aiY;
  private String aiZ;
  private String aja = "";
  public String ajb;
  String ajc;
  String ajd;
  private String aje;
  private boolean amS;
  boolean amT;
  public boolean amU;
  public boolean amV;
  boolean amW;
  public QQAppInterface app;
  private TroopBarPOI b;
  private VisibleSetParam d;
  lce e = new miv(this);
  private List<ReadInJoyUgcVideoReportItem> ja;
  ArrayList<TagInfo> le;
  ArrayList<SocializeFeedsInfo.BiuCommentInfo> lf;
  private Bundle mBundle;
  private Context mContext;
  public float mProgress;
  private long mVideoDuration;
  private int mVideoHeight;
  private int mVideoWidth;
  private long vY;
  private long vZ;
  private long wa;
  private long wb;
  public long wc;
  
  private void a(Bundle paramBundle, mqt parammqt, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.ja != null)
    {
      localObject = this.ja.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((ReadInJoyUgcVideoReportItem)((Iterator)localObject).next()).toJson());
      }
    }
    Object localObject = new JSONObject();
    paramInt = paramBundle.getInt("arg_video_width", 0);
    int i = paramBundle.getInt("arg_video_height", 0);
    paramBundle = paramBundle.getString("captureMode");
    try
    {
      ((JSONObject)localObject).put("elements", localJSONArray);
      ((JSONObject)localObject).put("video_width_height", paramInt + "x" + i);
      ((JSONObject)localObject).put("video_bit_rate", Long.valueOf(parammqt.cR()).toString());
      ((JSONObject)localObject).put("video_capacity", Long.valueOf(parammqt.cQ()).toString());
      ((JSONObject)localObject).put("camera_mode", paramBundle);
      ((JSONObject)localObject).put("@_counts", "0");
      ((JSONObject)localObject).put("tags", TextUtils.join("&", this.le));
      kbp.a(null, "", "0X80093D4", "0X80093D4", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("ReadInJoyDeliverVideo", 2, "doStatisticsReportForBigT: ", paramBundle);
      }
    }
  }
  
  private void initData(Bundle paramBundle)
  {
    this.app = ((QQAppInterface)kxm.getAppRuntime());
    this.amS = paramBundle.getBoolean("arg_is_from_wang_zhe", false);
    this.aja = paramBundle.getString("requestUUID");
    this.amT = paramBundle.getBoolean("is_from_dian_dian", false);
    this.aiY = paramBundle.getString("commentString");
    this.aiZ = paramBundle.getString("arg_ugc_edit_cookie");
    this.le = paramBundle.getParcelableArrayList("mSelectedTagList");
    this.ja = paramBundle.getParcelableArrayList("key_read_in_joy_video_upload_report");
    this.lf = paramBundle.getParcelableArrayList("multiBiuStruct");
    this.ajc = paramBundle.getString("arg_video_path");
    this.aIP = paramBundle.getInt("arg_ad_tag", 0);
    this.amW = paramBundle.getBoolean("is_from_kan_dian", false);
    this.ajd = paramBundle.getString("arg_video_cover");
    this.aje = paramBundle.getString("compressPath");
    this.b = ((TroopBarPOI)paramBundle.getParcelable("location"));
    this.d = ((VisibleSetParam)paramBundle.getParcelable("arg_visible_set_params"));
  }
  
  private void rN(int paramInt)
  {
    this.wb = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc localanpc = anpc.a(this.mContext);
    String str = kxm.getAppRuntime().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyDeliverVideoSendRequest", bool, this.wb - this.vZ, 0L, localHashMap, "");
      return;
    }
  }
  
  private void rO(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.vY;
    anpc localanpc = anpc.a(this.mContext);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext, Bundle paramBundle, mqt parammqt, miu.a parama)
  {
    String str1 = parammqt.kk();
    String str2 = parammqt.km();
    String str3 = parammqt.kn();
    String str4 = parammqt.ko();
    String str5 = parammqt.kp();
    this.mContext = paramContext;
    this.a = parama;
    if (paramBundle == null) {}
    for (this.mBundle = new Bundle();; this.mBundle = paramBundle)
    {
      initData(this.mBundle);
      lcc.a().b(this.e);
      this.mBundle.putString("arg_video_cover_url", str1);
      if (!paramBoolean)
      {
        this.mBundle.putString("arg_video_cover_md5", str2);
        this.mBundle.putString("arg_video_url", str3);
        this.mBundle.putString("arg_video_md5", str4);
        this.mBundle.putString("arg_video_uuid", str5);
      }
      this.mBundle.putString("arg_video_title", this.aiY);
      this.mBundle.putParcelableArrayList("arg_ugc_tag_list", this.le);
      this.aja = (System.currentTimeMillis() + (Math.random() * 10000.0D) + "");
      paramContext = "coverURL:" + str1 + ",coverMd5:" + str2 + ", videoUrl:" + str3 + ",videoMd5:" + str4 + ", videoUUID:" + str5;
      QLog.d("ReadInJoyDeliverVideo", 1, this.ajb + "send0x83eRequest,mRequestUUID:" + this.aja + "detail info:" + paramContext);
      this.mBundle.putString("up_master_deliver_uuid", this.aja);
      this.mBundle.putString("arg_ugc_edit_cookie", this.aiZ);
      this.amV = true;
      lbz.a().a(this.app.getCurrentUin(), this.aiY, this.mBundle, this.lf, paramBoolean, this.amT, this.b, this.d);
      this.vY = NetConnInfoCenter.getServerTimeMillis();
      this.vZ = System.currentTimeMillis();
      a(this.mBundle, parammqt, this.lf.size());
      return;
    }
  }
  
  public abstract void aPf();
  
  public abstract void aPg();
  
  public void rM(int paramInt)
  {
    this.wa = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc localanpc = anpc.a(this.mContext);
    String str = kxm.getAppRuntime().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyDeliverUGCVideo", bool, this.wa - this.wc, 0L, localHashMap, "");
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, mqt parammqt);
    
    public abstract void b(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4);
    
    public abstract void e(String paramString, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     miu
 * JD-Core Version:    0.7.0.1
 */