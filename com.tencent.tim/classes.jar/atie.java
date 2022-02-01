import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileWithStatusBarAdapter.4;
import com.tencent.tim.cloudfile.CloudFileWithStatusBarAdapter.6;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class atie
  extends atdt
{
  private Boolean aU = Boolean.valueOf(false);
  private Boolean aV = Boolean.valueOf(false);
  private CloudFileCallbackCenter b = new atif(this);
  private String bN;
  private int boq;
  private atgg d;
  private boolean dhP;
  private byte[] hK;
  private Runnable iq;
  private int mFailCount;
  private int mFileType = -1;
  private int mProgress;
  private double mSpeed;
  private int mTotalCount;
  private HashMap<Long, CloudUploadFile> qe = new HashMap();
  
  public atie(QQAppInterface paramQQAppInterface, Context paramContext, byte[] paramArrayOfByte, augx paramaugx)
  {
    super(paramQQAppInterface, paramContext, paramaugx);
    this.hK = paramArrayOfByte;
  }
  
  private void dfh()
  {
    atgi.a().a(this.b);
  }
  
  private void elV()
  {
    atgi.c(this.b);
  }
  
  private void etI()
  {
    if (this.aU.booleanValue())
    {
      QLog.d("CloudFileAdapter", 1, "checkUploadList is Root directory, so fetch again");
      etJ();
      return;
    }
    atgi.a().a(this.hK, new atig(this));
  }
  
  private void etJ()
  {
    if (this.d != null)
    {
      QLog.d("CloudFileAdapter", 1, "fetchList mCloudFileSDKCallback exist, so need not to fetch again");
      return;
    }
    QLog.d("CloudFileAdapter", 1, "fetchList again");
    this.aV = Boolean.valueOf(true);
    this.d = new atih(this);
    atgi.a().e(this.d);
  }
  
  private void etK()
  {
    if ((this.mTotalCount != 0) && (this.boq == 0))
    {
      Object localObject1 = null;
      Iterator localIterator = this.qe.values().iterator();
      Object localObject2;
      CloudUploadFile localCloudUploadFile;
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localCloudUploadFile = (CloudUploadFile)localIterator.next();
        localObject2 = localObject1;
        if (localCloudUploadFile.uploadPath != null)
        {
          localObject2 = localObject1;
          if (localCloudUploadFile.uploadPath.length() > 0) {
            localObject2 = localCloudUploadFile.uploadPath;
          }
        }
        localObject1 = localObject2;
      } while (localCloudUploadFile.uploadStatus != 3);
      this.bN = ((String)localObject2);
    }
    this.app.runOnUiThread(new CloudFileWithStatusBarAdapter.4(this));
  }
  
  private void etL()
  {
    if (this.iq != null) {
      return;
    }
    this.iq = new CloudFileWithStatusBarAdapter.6(this);
    ThreadManager.getUIHandler().postDelayed(this.iq, 3000L);
  }
  
  private void etM()
  {
    if (this.iq != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.iq);
      this.iq = null;
    }
  }
  
  private void iO(View paramView)
  {
    Object localObject = (LinearLayout)paramView.findViewById(2131364783);
    if (!this.aV.booleanValue())
    {
      QLog.d("CloudFileAdapter", 1, "updateView bHasUploading is false, so hide");
      ((LinearLayout)localObject).setVisibility(8);
      etM();
      return;
    }
    ((LinearLayout)localObject).setOnTouchListener(new atii(this));
    localObject = (AsyncImageView)paramView.findViewById(2131364784);
    this.mFileType = ahav.getFileType(this.bN);
    ((AsyncImageView)localObject).setDefaultImage(athu.hL(this.mFileType));
    if (aueh.fileExistsAndNotEmpty(this.bN)) {
      switch (this.mFileType)
      {
      }
    }
    for (;;)
    {
      localObject = (ProgressBar)paramView.findViewById(2131364815);
      ((ProgressBar)localObject).setProgress(this.mProgress);
      ((ProgressBar)localObject).setMax(100);
      ((ProgressBar)localObject).setProgressDrawable(this.mContext.getResources().getDrawable(2130839431));
      if (this.mTotalCount != 0) {
        break;
      }
      this.mProgress = 0;
      iQ(paramView);
      return;
      ((AsyncImageView)localObject).setAsyncImage(this.bN);
      continue;
      ((AsyncImageView)localObject).setApkIconAsyncImage(this.bN);
      continue;
      ((AsyncImageView)localObject).setAsyncImage(this.bN);
    }
    if (this.boq != 0)
    {
      iP(paramView);
      return;
    }
    this.mProgress = 0;
    iR(paramView);
  }
  
  private void iP(View paramView)
  {
    QLog.d("CloudFileAdapter", 1, "showProcessState");
    long l = Math.round(this.mSpeed / 1024.0D);
    if (l < 1024L) {}
    for (String str = String.format("%d", new Object[] { Long.valueOf(l) }) + "KB";; str = String.format("%.01f", new Object[] { Float.valueOf((float)l / 1024.0F) }) + "MB")
    {
      ((TextView)paramView.findViewById(2131364787)).setVisibility(8);
      ((LinearLayout)paramView.findViewById(2131364782)).setVisibility(0);
      ((TextView)paramView.findViewById(2131364785)).setText(String.valueOf(this.mTotalCount - this.mFailCount));
      ((TextView)paramView.findViewById(2131364781)).setText(str);
      ((LinearLayout)paramView.findViewById(2131364783)).setVisibility(0);
      ((ProgressBar)paramView.findViewById(2131364815)).setVisibility(0);
      etM();
      return;
    }
  }
  
  private void iQ(View paramView)
  {
    QLog.d("CloudFileAdapter", 1, "showCompletedState bNeedShowComplete " + CloudFileUploadingStatusBar.die + " bForbidShowComplete " + CloudFileUploadingStatusBar.dif);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131364783);
    if ((!CloudFileUploadingStatusBar.dif) && (CloudFileUploadingStatusBar.die))
    {
      localLinearLayout.setVisibility(0);
      ((ProgressBar)paramView.findViewById(2131364815)).setVisibility(4);
      ((LinearLayout)paramView.findViewById(2131364782)).setVisibility(8);
      paramView = (TextView)paramView.findViewById(2131364787);
      paramView.setText(2131691709);
      paramView.setVisibility(0);
      etL();
      return;
    }
    CloudFileUploadingStatusBar.dif = false;
    CloudFileUploadingStatusBar.die = false;
    localLinearLayout.setVisibility(8);
    etM();
  }
  
  private void iR(View paramView)
  {
    QLog.d("CloudFileAdapter", 1, "showAbortedState mFailCount " + this.mFailCount + "mTotalCount " + this.mTotalCount);
    ((LinearLayout)paramView.findViewById(2131364783)).setVisibility(0);
    ((ProgressBar)paramView.findViewById(2131364815)).setVisibility(4);
    ((LinearLayout)paramView.findViewById(2131364782)).setVisibility(8);
    paramView = (TextView)paramView.findViewById(2131364787);
    if (this.mFailCount == this.mTotalCount) {
      paramView.setText(String.format(this.mContext.getResources().getString(2131691710), new Object[] { Integer.valueOf(this.mFailCount) }));
    }
    for (;;)
    {
      paramView.setVisibility(0);
      etM();
      return;
      if (ahav.amK()) {
        paramView.setText(2131691712);
      } else {
        paramView.setText(String.format(this.mContext.getResources().getString(2131691711), new Object[] { Integer.valueOf(this.mTotalCount - this.mFailCount) }));
      }
    }
  }
  
  public int ag()
  {
    return 2131558985;
  }
  
  public void b(View paramView, int paramInt)
  {
    QLog.d("CloudFileAdapter", 1, "configDividerView");
    iO(paramView);
  }
  
  public int getCount()
  {
    return this.GW.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return this.GW.get(paramInt - 1);
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 4;
    }
    atiu localatiu = (atiu)this.GW.get(paramInt - 1);
    return this.a.a(localatiu);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView1;
    if (paramInt == 0) {
      if (paramView == null)
      {
        QLog.d("CloudFileAdapter", 1, "getView convertView is null");
        paramView = View.inflate(this.mContext, ag(), null);
        iO(paramView);
        localView1 = paramView;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return paramView;
      QLog.d("CloudFileAdapter", 1, "getView convertView is not null");
      break;
      View localView2 = super.getView(paramInt - 1, paramView, paramViewGroup);
      localView1 = paramView;
      paramView = localView2;
    }
  }
  
  public void onPause()
  {
    QLog.d("CloudFileAdapter", 1, "onPause");
    elV();
    this.aV = Boolean.valueOf(false);
  }
  
  public void onResume()
  {
    QLog.d("CloudFileAdapter", 1, "onResume");
    this.boq = 0;
    this.mFailCount = 0;
    this.mTotalCount = 0;
    dfh();
    etI();
  }
  
  public boolean t(int paramInt)
  {
    return paramInt == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atie
 * JD-Core Version:    0.7.0.1
 */