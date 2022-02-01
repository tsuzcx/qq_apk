import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.download.ArkDownloadController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adso
{
  private static adso a;
  private boolean bQE;
  private int cJN;
  private aqju mDialog;
  private Object mLock = new Object();
  private Runnable mRunnable;
  private long mStartTime;
  private ArrayList<adsr> ms = new ArrayList(4);
  private ArrayList<adsr> uJ = new ArrayList(4);
  
  private void GT(String paramString)
  {
    synchronized (this.mLock)
    {
      QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [checkWaitQueueToShowDialog] waite size:", Integer.valueOf(this.uJ.size()) });
      if (this.uJ.size() > 0)
      {
        this.ms.clear();
        this.ms.addAll((ArrayList)this.uJ.clone());
        this.uJ.clear();
        GU(paramString);
      }
      return;
    }
  }
  
  private void GU(String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (this.ms == null) || (this.ms.size() <= 0))
    {
      if (this.ms != null) {}
      for (int i = this.ms.size();; i = 0)
      {
        QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] error,showlist size:", Integer.valueOf(i) });
        return;
      }
    }
    Object localObject = new adsp(this, paramString);
    try
    {
      this.mStartTime = System.currentTimeMillis();
      this.cJN = this.ms.size();
      QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] arkappname:", paramString, ",showlist size:", Integer.valueOf(this.cJN) });
      this.mDialog = aqha.b(localBaseActivity, 230, 2131558746, null, String.format(localBaseActivity.getString(2131690501), new Object[] { Integer.valueOf(this.cJN) }), localBaseActivity.getString(2131721058), localBaseActivity.getString(2131690498), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      localObject = (LinearLayout)this.mDialog.findViewById(2131370501);
      LinearLayout localLinearLayout = (LinearLayout)this.mDialog.findViewById(2131370500);
      a(localBaseActivity, this.ms, (LinearLayout)localObject, localLinearLayout);
      this.mDialog.setOnDismissListener(new adsq(this));
      this.mDialog.show();
      anot.c(null, "dc00898", "", "", "0X800AD1C", "0X800AD1C", 3, 0, String.valueOf(this.cJN), "", paramString, "");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] exception:", paramString);
    }
  }
  
  public static adso a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new adso();
      }
      return a;
    }
    finally {}
  }
  
  private void a(Context paramContext, ArrayList<adsr> paramArrayList, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    if (paramArrayList.size() <= 4) {
      paramLinearLayout2.setVisibility(8);
    }
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838741);
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (adsr)paramArrayList.get(i);
      View localView = LayoutInflater.from(paramContext).inflate(2131558747, null, false);
      URLImageView localURLImageView = (URLImageView)localView.findViewById(2131368700);
      TextView localTextView = (TextView)localView.findViewById(2131372573);
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [initAppView] item[", Integer.valueOf(i), "],app name:", ((adsr)localObject).name, ",appid:", ((adsr)localObject).appId, ",icon:", ((adsr)localObject).iconUrl });
      if (i < 7)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = wja.dp2px(47.0F, paramContext.getResources());
        localURLDrawableOptions.mRequestHeight = localURLDrawableOptions.mRequestWidth;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localObject = URLDrawable.getDrawable(((adsr)localObject).iconUrl, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        localURLImageView.setImageDrawable((Drawable)localObject);
        localTextView.setVisibility(8);
        label256:
        if (i >= 4) {
          break label338;
        }
        paramLinearLayout1.addView(localView, i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i != 7) {
          return;
        }
        localURLImageView.setImageDrawable(paramContext.getResources().getDrawable(2130838743));
        localTextView.setText(String.format("+%d", new Object[] { Integer.valueOf(paramArrayList.size() - 7) }));
        localTextView.setVisibility(0);
        break label256;
        label338:
        paramLinearLayout2.addView(localView, i - 4);
      }
    }
  }
  
  public void a(String paramString1, String arg2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener)
  {
    QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadPermissionDialog] arkAppName:", paramString1, ", queue size[", Integer.valueOf(this.uJ.size()), "], app:" + paramString3 + ",iconUrl:" + paramString4 });
    adsr localadsr = new adsr();
    localadsr.appId = ???;
    localadsr.iconUrl = paramString4;
    localadsr.name = paramString3;
    localadsr.I = paramOnClickListener;
    synchronized (this.mLock)
    {
      this.uJ.add(localadsr);
      if (!this.bQE)
      {
        this.bQE = true;
        this.mRunnable = new ArkDownloadController.1(this, paramString1);
        ArkDispatchTask.getInstance().postToMainThreadDelayed(this.mRunnable, 150L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adso
 * JD-Core Version:    0.7.0.1
 */