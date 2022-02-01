import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import org.json.JSONException;
import org.json.JSONObject;

public class aidx
{
  private aidc a = new aiec(this);
  private long abq;
  private long abr;
  String appType;
  private IVPluginDataReporter b;
  String bNb;
  String bNn = null;
  String bNo = null;
  private BroadcastReceiver bn = new aieh(this);
  private boolean cjQ;
  private boolean cke;
  boolean ckf = false;
  private ViewGroup dS;
  private Button gq;
  arhz m;
  String mAction;
  private Activity mActivity;
  private int mCurrentProgress;
  private int mCurrentState;
  String mExtra = null;
  private ProgressBar mProgressBar;
  private TextView mTipsTextView;
  private long mTotalSize;
  private Handler mUIHandler = new aieg(this, Looper.getMainLooper());
  private TextView nM;
  String pluginPackageName;
  String uin = null;
  String uri = null;
  
  public aidx(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private void KV(boolean paramBoolean)
  {
    this.cjQ = paramBoolean;
    if (paramBoolean) {
      this.mAction = "checkVersion";
    }
    for (;;)
    {
      this.mCurrentProgress = 0;
      Object localObject2 = aida.a(this.mActivity.getApplicationContext(), this.pluginPackageName);
      String str1 = this.appType;
      String str2 = this.bNn;
      String str3 = this.uin;
      String str4 = this.mAction;
      String str5 = this.bNn;
      Object localObject1;
      if (this.mExtra == null)
      {
        localObject1 = "";
        ((aida)localObject2).a(str1, str2, "", str3, 0, str4, "", "", str5, (String)localObject1, this.a);
        return;
        this.abq = System.currentTimeMillis();
        this.abr = System.currentTimeMillis();
        aiem.a.cG(40, String.valueOf(this.ckf));
        this.b.opType("huiyin").opName("download").d1(String.valueOf(aqiw.isWifiEnabled(this.mActivity.getApplicationContext()))).d2(String.valueOf(this.ckf)).report();
        if (this.mExtra == null) {}
      }
      try
      {
        localObject1 = new JSONObject(this.mExtra);
        ((JSONObject)localObject1).put("startTS", System.currentTimeMillis());
        this.mExtra = ((JSONObject)localObject1).toString();
        label211:
        localObject2 = this.b.opType("huiyin").opName("launch");
        if (aqiw.isWifiEnabled(this.mActivity.getApplicationContext()))
        {
          localObject1 = "1";
          label242:
          localObject2 = ((IVPluginDataReporter)localObject2).d1((String)localObject1);
          if (!this.cke) {
            break label291;
          }
          localObject1 = "1";
          label258:
          localObject2 = ((IVPluginDataReporter)localObject2).d2((String)localObject1);
          if (!this.ckf) {
            break label297;
          }
        }
        label291:
        label297:
        for (localObject1 = "1";; localObject1 = "2")
        {
          ((IVPluginDataReporter)localObject2).d3((String)localObject1).report();
          break;
          localObject1 = "2";
          break label242;
          localObject1 = "2";
          break label258;
        }
        localObject1 = this.mExtra;
      }
      catch (Exception localException)
      {
        break label211;
      }
    }
  }
  
  private void checkNetwork()
  {
    if (!aqiw.isNetworkAvailable(this.mActivity.getApplicationContext()))
    {
      aiem.a.cG(32, null);
      this.gq.setVisibility(0);
      this.mTipsTextView.setVisibility(0);
      this.gq.setText(acfp.m(2131707311));
      this.mTipsTextView.setText(acfp.m(2131707315));
      this.dS.setVisibility(8);
      this.mActivity.findViewById(16908290).setVisibility(0);
      this.gq.setOnClickListener(new aidz(this));
      return;
    }
    aicu.a(this.appType, new aiea(this));
  }
  
  void initUI()
  {
    this.mActivity.setContentView(2131561445);
    this.mProgressBar = ((ProgressBar)this.mActivity.findViewById(2131373700));
    this.mTipsTextView = ((TextView)this.mActivity.findViewById(2131368291));
    this.gq = ((Button)this.mActivity.findViewById(2131366061));
    this.dS = ((ViewGroup)this.mActivity.findViewById(2131373659));
    this.nM = ((TextView)this.mActivity.findViewById(2131373689));
    this.mActivity.findViewById(16908290).setVisibility(8);
    this.mActivity.findViewById(2131368727).setOnClickListener(new aidy(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    initUI();
    this.b = new IVPluginDataReporter();
    this.b.opDepartment("huiyin");
    this.uin = this.mActivity.getIntent().getStringExtra("uin");
    this.mExtra = this.mActivity.getIntent().getStringExtra("extra");
    this.ckf = this.mActivity.getIntent().getBooleanExtra("preloadOnly", false);
    this.abr = System.currentTimeMillis();
    paramBundle = this.mActivity.getIntent().getStringExtra("param_general");
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.bNn = paramBundle.optString("opentype");
      this.uri = paramBundle.optString("uri");
      this.bNb = paramBundle.optString("notifyJsCallback");
      this.mAction = paramBundle.optString("action");
      this.pluginPackageName = paramBundle.optString("pluginPackageName");
      this.bNo = paramBundle.optString("pluginData");
      this.appType = paramBundle.optString("appType");
      checkNetwork();
      if (this.ckf) {
        this.mActivity.finish();
      }
      this.abq = 0L;
      if (this.ckf)
      {
        aiem.a.cG(20, null);
        paramBundle = new IntentFilter();
        paramBundle.addAction("close.activity");
        paramBundle.addAction("close.loading");
        this.mActivity.registerReceiver(this.bn, paramBundle);
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        aiem.a.cG(30, null);
      }
    }
  }
  
  public void onDestroy()
  {
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mActivity.unregisterReceiver(this.bn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidx
 * JD-Core Version:    0.7.0.1
 */