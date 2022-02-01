import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tim.cloudfile.wps.WPSListActivity;
import com.tencent.util.BinderWarpper;
import java.lang.ref.WeakReference;

public class aunl
  extends ReportDialog
  implements View.OnClickListener
{
  private View KQ;
  private View KR;
  private View KS;
  private View KT;
  private View KU;
  private View KV;
  private View KW;
  private TextView afw;
  private atsn d;
  private WeakReference<Activity> mActivityRef;
  private WebViewPlugin.a mRuntime;
  private ProgressBar progressBar;
  private View rootView;
  
  public void cancel()
  {
    super.cancel();
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  protected void init()
  {
    this.rootView = View.inflate((Context)this.mActivityRef.get(), 2131559330, null);
    this.KQ = this.rootView.findViewById(2131367064);
    this.KR = this.rootView.findViewById(2131361799);
    this.KS = this.rootView.findViewById(2131382206);
    this.KT = this.rootView.findViewById(2131361822);
    this.KU = this.rootView.findViewById(2131361811);
    this.KV = this.rootView.findViewById(2131361794);
    this.KW = this.rootView.findViewById(2131361797);
    this.afw = ((TextView)this.rootView.findViewById(2131378596));
    this.progressBar = ((ProgressBar)this.rootView.findViewById(2131378594));
    this.rootView.findViewById(2131364677).setOnClickListener(this);
    this.KQ.setOnClickListener(this);
    this.KR.setOnClickListener(this);
    this.KS.setOnClickListener(this);
    this.KT.setOnClickListener(this);
    this.KU.setOnClickListener(this);
    this.KV.setOnClickListener(this);
    this.KW.setOnClickListener(this);
    this.afw.setOnClickListener(this);
    this.progressBar.setOnClickListener(this);
    setContentView(this.rootView);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    String str;
    switch (paramView.getId())
    {
    default: 
    case 2131367064: 
    case 2131361799: 
    case 2131382206: 
      do
      {
        for (;;)
        {
          super.dismiss();
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject = new Intent((Context)this.mActivityRef.get(), LiteActivity.class);
          ((Intent)localObject).putExtra("targetUin", acbn.bkw);
          ((Activity)this.mActivityRef.get()).startActivity((Intent)localObject);
          continue;
          avhc.c((Context)this.mActivityRef.get(), 2, null);
        }
      } while ((this.mRuntime.a() instanceof QQAppInterface));
    case 2131361822: 
      localObject = this.mRuntime.a();
      localIntent = new Intent((Context)this.mActivityRef.get(), WPSListActivity.class);
      long l = System.currentTimeMillis();
      localIntent.putExtra("url", "https://drive.wps.cn?from=tim&timestamp=" + l);
      str = ((AppInterface)localObject).getCurrentAccountUin();
      if (!(localObject instanceof QQAppInterface)) {
        break;
      }
    }
    for (Object localObject = aqgv.n((QQAppInterface)localObject, str);; localObject = str)
    {
      localIntent.putExtra("_nick_name_", (String)localObject);
      localIntent.putExtra("_uin_", str);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("file_manager_provider", new BinderWarpper(new atwj(str).asBinder()));
      localIntent.putExtras((Bundle)localObject);
      localIntent.addFlags(603979776);
      ((Activity)this.mActivityRef.get()).startActivity(localIntent);
      break;
      localObject = new Intent((Context)this.mActivityRef.get(), FMActivity.class);
      ((Intent)localObject).putExtra("tab_tab_type", 1);
      ((Intent)localObject).putExtra("bundle", new Bundle());
      ((Intent)localObject).putExtra("qfile_selecter_entrance_type", -1);
      ((Activity)this.mActivityRef.get()).startActivity((Intent)localObject);
      break;
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("string_from", false);
      ((Bundle)localObject).putBoolean("string_uin", false);
      ((Bundle)localObject).putLong("device_din", 0L);
      ((Bundle)localObject).putInt("sTitleID", 0);
      avio.b((Context)this.mActivityRef.get(), (Bundle)localObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
      break;
      localObject = (Activity)this.mActivityRef.get();
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    init();
  }
  
  public void onStart()
  {
    super.onStart();
    updateView();
    ((QQAppInterface)this.mRuntime.a()).a().addObserver(this.d);
  }
  
  public void onStop()
  {
    super.onStop();
    ((QQAppInterface)this.mRuntime.a()).a().deleteObserver(this.d);
  }
  
  protected void updateView()
  {
    aulh.a(BaseActivity.sTopActivity.app, "", new aunm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunl
 * JD-Core Version:    0.7.0.1
 */