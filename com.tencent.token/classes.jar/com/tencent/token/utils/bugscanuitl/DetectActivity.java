package com.tencent.token.utils.bugscanuitl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.av;
import com.tencent.token.ax;
import com.tencent.token.core.bean.ScanDataResult;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;
import java.util.List;

public class DetectActivity
  extends FragmentActivity
  implements LoaderManager.LoaderCallbacks
{
  public static final int HAVE_APP_AFFECT = 1;
  public static final int NO_APP_AFFECT = 0;
  public static String RESULT_FLAG = "result_flag";
  private final Handler fHandler = new g(this);
  private boolean isDoingScan = false;
  private TextView isScaning;
  Loader loader;
  ScanDataResult result;
  private int resultFlag;
  private View.OnClickListener retryClickListener;
  private ImageView scanBottom;
  private ImageView scanMiddleArc;
  private ImageView scanUpperBug;
  private TextView startScan;
  private TextView textExplain;
  private TitleBar title;
  private RelativeLayout upperLayout;
  private String urlString = "http://www.qq.com/";
  
  private void doDetect()
  {
    this.startScan.setVisibility(4);
    this.isDoingScan = true;
    this.scanMiddleArc.setVisibility(0);
    this.upperLayout.setBackgroundColor(getResources().getColor(2131165331));
    this.upperLayout.postInvalidate();
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968580);
    localAnimation.setInterpolator(new LinearInterpolator());
    this.scanMiddleArc.startAnimation(localAnimation);
    this.isScaning.setVisibility(0);
    this.isScaning.setText(2131362727);
    if (this.loader == null)
    {
      this.loader = getSupportLoaderManager().initLoader(0, null, this);
      return;
    }
    this.loader.forceLoad();
  }
  
  private void showHaveAffectedResult()
  {
    this.upperLayout.setBackgroundColor(getResources().getColor(2131165333));
    this.scanMiddleArc.setVisibility(4);
    this.scanUpperBug.setVisibility(4);
    this.scanBottom.setImageResource(2130837531);
    this.isScaning.setVisibility(0);
    String str = String.format(getResources().getString(2131362737), new Object[] { Integer.valueOf(b.c.size()) });
    this.isScaning.setText(str);
    this.isScaning.setOnClickListener(new k(this));
    this.startScan.setVisibility(0);
    this.startScan.setText(2131362730);
    this.startScan.setOnClickListener(this.retryClickListener);
  }
  
  private void showHealResult()
  {
    this.upperLayout.setBackgroundColor(getResources().getColor(2131165332));
    this.scanMiddleArc.setVisibility(4);
    this.scanUpperBug.setVisibility(4);
    this.scanBottom.setImageResource(2130837766);
    this.isScaning.setVisibility(0);
    this.isScaning.setText(2131362731);
    this.isScaning.setOnClickListener(null);
    this.startScan.setVisibility(0);
    this.startScan.setText(2131362730);
    this.startScan.setOnClickListener(this.retryClickListener);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903053);
    BaseActivity.addActivitToList(this);
    this.result = ((ScanDataResult)getIntent().getSerializableExtra("result"));
    if (this.result == null) {
      finish();
    }
    paramBundle = (TitleBar)findViewById(2131296404);
    paramBundle.a(new h(this));
    paramBundle.a();
    this.startScan = ((TextView)findViewById(2131296412));
    this.isScaning = ((TextView)findViewById(2131296411));
    this.textExplain = ((TextView)findViewById(2131296414));
    this.scanBottom = ((ImageView)findViewById(2131296408));
    this.scanMiddleArc = ((ImageView)findViewById(2131296409));
    this.scanUpperBug = ((ImageView)findViewById(2131296410));
    this.title = ((TitleBar)findViewById(2131296404));
    this.title.a(String.format(getResources().getString(2131362723), new Object[] { this.result.b() }));
    this.title.a();
    this.upperLayout = ((RelativeLayout)findViewById(2131296405));
    this.startScan.setOnClickListener(new i(this));
    this.retryClickListener = new j(this);
    if (getIntent() != null)
    {
      this.resultFlag = getIntent().getIntExtra(RESULT_FLAG, -1);
      if (this.resultFlag != 0) {
        break label311;
      }
      showHealResult();
    }
    for (;;)
    {
      if (this.result.c() != null) {
        this.textExplain.setText(this.result.c());
      }
      return;
      label311:
      if (this.resultFlag == 1) {
        if ((b.c == null) || (b.c.size() == 0)) {
          showHealResult();
        } else {
          showHaveAffectedResult();
        }
      }
    }
  }
  
  public Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new b(this, this.result.e());
  }
  
  protected void onDestroy()
  {
    try
    {
      BaseActivity.removeActivityFromList(this);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.c("remove activity list err=" + localException.getMessage());
      }
    }
  }
  
  public void onLoadFinished(Loader paramLoader, List paramList)
  {
    int i = 0;
    this.scanMiddleArc.clearAnimation();
    this.scanMiddleArc.setVisibility(4);
    this.isDoingScan = false;
    this.textExplain.setText(this.result.c());
    if (b.c == null)
    {
      if ((b.c != null) && (b.c.size() != 0)) {
        break label95;
      }
      showHealResult();
    }
    for (;;)
    {
      af.a().a(this.fHandler, this.result.a(), i);
      return;
      i = b.c.size();
      break;
      label95:
      paramLoader = new Intent(this, ResultListActivity.class);
      paramLoader.putExtra("result", this.result);
      startActivity(paramLoader);
    }
  }
  
  public void onLoaderReset(Loader paramLoader) {}
  
  protected void onResume()
  {
    BaseActivity.sTopActivity = this;
    if (ax.a().e() != null) {
      af.a().a(av.a, this.fHandler);
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.DetectActivity
 * JD-Core Version:    0.7.0.1
 */