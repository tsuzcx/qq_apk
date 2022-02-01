package com.tencent.qqmail.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import moai.oss.KvHelper;

public class SyncErrorBar
  extends LinearLayout
{
  public static final int PAGE_ACCOUNT_LIST = 3;
  public static final int PAGE_ACCOUNT_LIST_MAIL_LIST = 4;
  public static final int PAGE_FOLDER_LIST_MAIL_LIST = 5;
  public static final int PAGE_INNER_FOLDER_LIST = 2;
  public static final int PAGE_OUT_FOLDER_LIST = 1;
  public static final String TAG = "SyncErrorBar";
  private int code = -1;
  private Context context;
  private onBarItemClickListener onBarItemClickListener;
  private TextView textView;
  
  public SyncErrorBar(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  private boolean renderView(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != this.code)
    {
      QMLog.log(6, "SyncErrorBar", "renderView errorCode:" + paramInt1 + ", accountId:" + paramInt2 + ", page:" + paramInt3);
      this.code = paramInt1;
      removeAllViews();
      String str;
      View localView;
      ImageView localImageView1;
      ImageView localImageView2;
      if (paramInt1 != 0) {
        switch (paramInt1)
        {
        default: 
          str = this.context.getString(2131695956);
          paramInt1 = 1;
          localView = LayoutInflater.from(this.context).inflate(2131563150, this, false);
          localImageView1 = (ImageView)localView.findViewById(2131379079);
          this.textView = ((TextView)localView.findViewById(2131379078));
          localImageView2 = (ImageView)localView.findViewById(2131379077);
          if (paramInt1 != 0)
          {
            QMUIKit.setBackgroundKeepingPadding(localView, 2130850569);
            localImageView1.setImageResource(2130840938);
            localImageView2.setImageResource(2130841076);
            this.textView.setTextColor(ContextCompat.getColor(this.context, 2131167499));
          }
          break;
        }
      }
      for (;;)
      {
        this.textView.setText(str);
        localView.setOnClickListener(new SyncErrorBar.1(this));
        addView(localView);
        return true;
        str = this.context.getString(2131695957);
        paramInt1 = 1;
        break;
        str = this.context.getString(2131695956);
        paramInt1 = 1;
        break;
        str = this.context.getString(2131695955);
        paramInt1 = 1;
        break;
        str = this.context.getString(2131695954);
        paramInt1 = 0;
        break;
        QMUIKit.setBackgroundKeepingPadding(localView, 2130850570);
        localImageView1.setImageResource(2130840939);
        localImageView2.setImageResource(2130841077);
        this.textView.setTextColor(ContextCompat.getColor(this.context, 2131167504));
      }
    }
    return false;
  }
  
  private void reportSyncError(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      KvHelper.syncWithoutNetworkShow(new double[0]);
      return;
    case 2: 
      KvHelper.syncWithUnavailableNetworkShow(new double[0]);
      return;
    case 4: 
      KvHelper.syncServerErrorShow(new double[0]);
      return;
    }
    KvHelper.syncUnauthShow(new double[0]);
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public onBarItemClickListener getOnBarItemClickListener()
  {
    return this.onBarItemClickListener;
  }
  
  public boolean render(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt2 == 5) {
      return false;
    }
    QMNetworkUtils.clearNetworkType();
    if (!QMNetworkUtils.isNetworkConnected()) {
      if ((paramInt2 == 1) || (paramInt2 == 3)) {
        i = 1;
      }
    }
    for (;;)
    {
      reportSyncError(i);
      return renderView(i, paramInt1, paramInt2);
      if (QMSyncErrorManager.sharedInstance().isNetworkUnavailable())
      {
        if ((paramInt2 == 1) || (paramInt2 == 3)) {
          i = 2;
        }
      }
      else if (paramInt2 != 3) {
        i = QMSyncErrorManager.sharedInstance().getSyncErrorCode(paramInt1);
      }
    }
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setOnBarItemClickListener(onBarItemClickListener paramonBarItemClickListener)
  {
    this.onBarItemClickListener = paramonBarItemClickListener;
  }
  
  public static abstract interface onBarItemClickListener
  {
    public abstract void onItemClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.SyncErrorBar
 * JD-Core Version:    0.7.0.1
 */