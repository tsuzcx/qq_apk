package com.tencent.token.utils.bugscanuitl;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.core.bean.ScanDataResult;
import com.tencent.token.ui.BaseActivity;
import java.util.List;

public class ResultListActivity
  extends BaseActivity
{
  f OnClickListener;
  private final String REMOVEACTION = "android.intent.action.PACKAGE_REMOVED";
  n adapter;
  ListView lv;
  Dialog mDialog;
  ScanDataResult result;
  TextView textsubv;
  TextView textv;
  String unilstallpackageName;
  
  private void initView()
  {
    Object localObject = (TitleBar)findViewById(2131296404);
    ((TitleBar)localObject).a(new l(this));
    ((TitleBar)localObject).a(String.format(getResources().getString(2131362723), new Object[] { this.result.b() }));
    ((TitleBar)localObject).a();
    this.textv = ((TextView)findViewById(2131297011));
    localObject = new SpannableStringBuilder(String.format(getResources().getString(2131362728), new Object[] { Integer.valueOf(b.c.size()) }));
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-65536), 4, String.valueOf(b.c.size()).length() + 4, 33);
    this.textv.setText((CharSequence)localObject);
    this.textsubv = ((TextView)findViewById(2131297012));
    this.textsubv.setText(this.result.d());
    this.OnClickListener = new m(this);
    this.adapter = new n(this, b.c, this.OnClickListener);
    this.lv = ((ListView)findViewById(2131297013));
    this.lv.setAdapter(this.adapter);
  }
  
  private void showBaseUserDialogBtn(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.mDialog = new Dialog(this, 2131427445);
    this.mDialog.setContentView(2130903074);
    TextView localTextView1 = (TextView)this.mDialog.findViewById(2131296516);
    TextView localTextView2 = (TextView)this.mDialog.findViewById(2131296514);
    TextView localTextView3 = (TextView)this.mDialog.findViewById(2131296404);
    TextView localTextView4 = (TextView)this.mDialog.findViewById(2131296512);
    if (paramInt == 0)
    {
      localTextView3.setVisibility(8);
      if (paramString1 == null) {
        break label168;
      }
      localTextView4.setText(paramString1);
    }
    for (;;)
    {
      if (paramString2 != null) {
        localTextView1.setText(paramString2);
      }
      if (paramOnClickListener1 != null) {
        localTextView1.setOnClickListener(paramOnClickListener1);
      }
      if ((localTextView2 != null) && (paramOnClickListener2 != null))
      {
        if (paramString3 != null) {
          localTextView2.setText(paramString3);
        }
        localTextView2.setOnClickListener(paramOnClickListener2);
      }
      this.mDialog.show();
      return;
      localTextView3.setText(paramInt);
      break;
      label168:
      localTextView4.setVisibility(8);
    }
  }
  
  public void dismissDialog()
  {
    if (isFinishing()) {}
    for (;;)
    {
      return;
      try
      {
        if (this.mDialog != null)
        {
          this.mDialog.cancel();
          this.mDialog = null;
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent(this, DetectActivity.class);
    localIntent.putExtra("result_flag", 1);
    localIntent.putExtra("result", this.result);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903181);
    this.result = ((ScanDataResult)getIntent().getSerializableExtra("result"));
    if (this.result == null)
    {
      finish();
      return;
    }
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.PACKAGE_REMOVED");
    paramBundle.addDataScheme("package");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void uninstall(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.DELETE");
    localIntent.setData(Uri.parse("package:" + paramString));
    startActivity(localIntent);
    this.unilstallpackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.ResultListActivity
 * JD-Core Version:    0.7.0.1
 */