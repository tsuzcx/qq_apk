import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import cooperation.qqreader.QRReaderPageProxyActivity;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.js.JsCallParams;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import cooperation.qqreader.ui.ReaderHomePageActivity;

public class avml
{
  private avml.a jdField_a_of_type_Avml$a;
  private JsCallParams jdField_a_of_type_CooperationQqreaderJsJsCallParams;
  private Intent av;
  private avmc.a b = new avmm(this);
  private final Activity mActivity;
  private Bundle mBundle;
  private ViewGroup mContentView;
  private TextView mTextView;
  
  public avml(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private Intent a(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = false;
    String str1 = paramBundle.getString("readtype");
    int i = -1;
    if (!TextUtils.isEmpty(str1)) {
      i = Integer.valueOf(str1).intValue();
    }
    switch (i)
    {
    case 17: 
    case 18: 
    case 19: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
    case 29: 
    case 30: 
    default: 
      paramActivity = null;
    }
    for (;;)
    {
      paramBundle = paramActivity;
      if (paramActivity == null)
      {
        paramBundle = new Intent();
        paramBundle.setClass(this.mActivity, ReaderHomePageActivity.class);
        paramBundle.putExtras(avlw.a(paramBundle, 1));
      }
      paramBundle.putExtra("params_remote_connect_at_launch", true);
      return paramBundle;
      paramActivity = c(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("nbid"));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", paramBundle.getString("id"));
      paramActivity.putExtra("ChannelSrc2", paramBundle.getString("group_code"));
      if (!TextUtils.equals(paramBundle.getString("stay"), "1")) {
        bool = true;
      }
      paramActivity.putExtra("is_return_to_home_page", bool);
      continue;
      paramActivity = c(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("book_new_id"));
      paramActivity.putExtra("is_from_conversation", paramBundle.getBoolean("is_from_conversation", false));
      continue;
      paramActivity = c(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("nbid"));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", paramBundle.getString("bid"));
      paramActivity.putExtra("com.qqreader.pureader.CHAPTER_ID", paramBundle.getString("cid"));
      if (!TextUtils.equals(paramBundle.getString("stay"), "1")) {}
      for (bool = true;; bool = false)
      {
        paramActivity.putExtra("is_return_to_home_page", bool);
        paramActivity.putExtra("is_from_conversation", paramBundle.getBoolean("is_from_conversation", false));
        if (paramBundle.getBoolean("recent_note", false)) {
          ChannelIdHelper.setChannelId("100336");
        }
        paramActivity.setFlags(67108864);
        break;
      }
      paramActivity = c(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", paramBundle.getString("nbid"));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", paramBundle.getString("bid"));
      paramActivity.putExtra("com.qqreader.pureader.CHAPTER_ID", paramBundle.getString("cid"));
      paramActivity.putExtra("com.qqreader.pureader.IN_BOOKSHELF", paramBundle.getString("inBookShelf"));
      ChannelIdHelper.setChannelId(paramBundle);
      paramActivity.setFlags(67108864);
      continue;
      paramActivity = c(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.FILE_PATH", paramBundle.getString("com.qqreader.pureader.FILE_PATH"));
      paramActivity.putExtra("com.qqreader.pureader.EXTRA_KEY_IS_LOCAL", true);
      ChannelIdHelper.setChannelId(paramBundle);
      continue;
      if (!paramBundle.getBoolean("is_from_qreader_shortcut", false))
      {
        paramActivity = null;
      }
      else
      {
        if (!paramBundle.getBoolean("cityshortcut")) {
          break;
        }
        paramBundle = new Intent();
        paramBundle.setClass(paramActivity, ReaderHomePageActivity.class);
        paramBundle.putExtras(avlw.a(paramBundle, 1));
        paramBundle.putExtra("is_from_qreader_shortcut", true);
        paramActivity = paramBundle;
      }
    }
    long l1 = paramBundle.getLong("book_id");
    long l2 = paramBundle.getLong("book_new_id");
    str1 = aqgz.a(paramActivity).networkType;
    String str2 = avoh.j(paramActivity);
    if (l2 != 0L) {}
    for (paramBundle = String.valueOf(l2);; paramBundle = "")
    {
      avof.a(str1, str2, "2198", paramBundle, "2", "");
      paramActivity = c(paramActivity);
      paramActivity.putExtra("com.qqreader.pureader.BOOK_ID", String.valueOf(l2));
      paramActivity.putExtra("com.qqreader.pureader.YW_BOOK_ID", String.valueOf(l1));
      paramActivity.putExtra("is_return_to_home_page", true);
      paramActivity.putExtra("is_from_qreader_shortcut", true);
      paramActivity.setFlags(67108864);
      break;
    }
  }
  
  private void a(JsCallParams paramJsCallParams)
  {
    if (avmc.a().aKJ())
    {
      ReaderJsPluginProxy localReaderJsPluginProxy = avmc.a().a(new avmn(this));
      if (localReaderJsPluginProxy != null) {
        localReaderJsPluginProxy.call(paramJsCallParams.getUrl(), paramJsCallParams.getPkgName(), paramJsCallParams.getMethod(), paramJsCallParams.getArgs());
      }
      for (;;)
      {
        onCompleted();
        return;
        avoc.e("ReaderSplashImpl", "checkPluginForHandleSpecialJsCall: plugin is ready but jsPluginProxy is null");
      }
    }
    this.jdField_a_of_type_CooperationQqreaderJsJsCallParams = paramJsCallParams;
    avmc.a().a(this.b);
    jg(cF());
  }
  
  private Intent c(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QRReaderPageProxyActivity.class);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("readerDpcConfig", DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0|0"));
    return localIntent;
  }
  
  private View cF()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mActivity);
    ImageView localImageView = new ImageView(this.mActivity);
    localImageView.setBackgroundColor(-1);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRelativeLayout.addView(localImageView);
    TextView localTextView = new TextView(this.mActivity);
    localTextView.setText(2131695459);
    localTextView.setTextColor(-16777216);
    localTextView.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    localTextView.setPadding(0, aqcx.dip2px(this.mActivity, 120.0F), 0, 0);
    localRelativeLayout.addView(localTextView, localLayoutParams);
    this.mTextView = localTextView;
    avms.a().a(this.mActivity, localImageView);
    return localRelativeLayout;
  }
  
  private void eAN()
  {
    if (this.av == null)
    {
      avoc.e("ReaderSplashImpl", "handlePendingJumpPluginIntent: mPendingJumpPluginIntent == null");
      return;
    }
    if ((this.mActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (this.mActivity.isDestroyed())))
    {
      avoc.w("ReaderSplashImpl", "handlePendingJumpPluginIntent: activity is destroyed");
      return;
    }
    avlw.a(this.mActivity, this.av, "com.qqreader.pureader.SSReaderActivity", new avmp(this));
    this.av = null;
  }
  
  private void ed(@NonNull Bundle paramBundle)
  {
    if (this.mActivity == null) {
      avoc.e("ReaderSplashImpl", "doJump: activity is null");
    }
    Intent localIntent;
    do
    {
      return;
      if (paramBundle.getBoolean("is_from_qreader_shortcut")) {
        paramBundle.putString("readtype", String.valueOf(26));
      }
      localIntent = a(this.mActivity, paramBundle);
    } while (localIntent == null);
    localIntent.putExtra("launch_by_splash", true);
    localIntent.putExtra("login_interval", avoh.y(BaseApplicationImpl.getApplication()));
    if (localIntent.getStringExtra("ChannelSrc2") == null) {
      localIntent.putExtra("ChannelSrc2", paramBundle.getString("ChannelSrc2"));
    }
    if ((localIntent.getComponent() != null) && ("cooperation.qqreader.ui.ReaderHomePageActivity".equals(localIntent.getComponent().getClassName())))
    {
      this.mActivity.startActivity(localIntent);
      onCompleted();
      return;
    }
    localIntent.putExtra("is_from_splash_activity", true);
    localIntent.putExtra("com.qqreader.pureader.START_TIME", System.currentTimeMillis());
    ej(localIntent);
  }
  
  private void ej(Intent paramIntent)
  {
    boolean bool = avno.aKN();
    avoc.d("ReaderSplashImpl", "jumpToPlugin: isUseShadow = " + bool);
    if (bool)
    {
      avno.a(this.mActivity, paramIntent, "com.qqreader.pureader.SSReaderActivity", new avmo(this));
      return;
    }
    this.av = paramIntent;
    avmc.a().a(this.b);
    jg(cF());
  }
  
  private void jg(View paramView)
  {
    if (this.mContentView == null)
    {
      avoc.e("ReaderSplashImpl", "showLoadingView: mContentView == null");
      return;
    }
    this.mContentView.setBackgroundColor(-1);
    this.mContentView.addView(paramView);
  }
  
  private void onCompleted()
  {
    this.mActivity.finish();
    this.mActivity.overridePendingTransition(0, 0);
  }
  
  public void ec(@NonNull Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public void i(@NonNull ViewGroup paramViewGroup)
  {
    this.mContentView = paramViewGroup;
  }
  
  public ViewGroup j()
  {
    return this.mContentView;
  }
  
  public void onCreate()
  {
    avoc.i("ReaderSplashImpl", "onCreate");
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("cooperation.qqreader.start_reader_act_completed");
    if (this.jdField_a_of_type_Avml$a == null)
    {
      this.jdField_a_of_type_Avml$a = new avml.a(null);
      this.mActivity.registerReceiver(this.jdField_a_of_type_Avml$a, (IntentFilter)localObject);
    }
    localObject = (JsCallParams)this.mBundle.getParcelable("splash_pending_js_param");
    if (localObject != null)
    {
      a((JsCallParams)localObject);
      return;
    }
    ed(this.mBundle);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Avml$a != null)
    {
      this.mActivity.unregisterReceiver(this.jdField_a_of_type_Avml$a);
      this.jdField_a_of_type_Avml$a = null;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("cooperation.qqreader.start_reader_act_completed".equals(paramIntent.getAction())) {
        avml.b(avml.this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avml
 * JD-Core Version:    0.7.0.1
 */