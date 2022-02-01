import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ixy
  implements View.OnClickListener
{
  private boolean VX;
  private boolean VY;
  private BroadcastReceiver mBroadcastReceiver = new ixz(this);
  private Context mContext;
  private long[] p;
  
  public ixy(Context paramContext)
  {
    this.mContext = paramContext;
    this.p = new long[6];
  }
  
  private void asf() {}
  
  private void bL(View paramView)
  {
    Object localObject = (Activity)this.mContext;
    ((Activity)localObject).findViewById(2131373965).setVisibility(0);
    paramView = (TextView)((Activity)localObject).findViewById(2131373967);
    localObject = (TextView)((Activity)localObject).findViewById(2131373966);
    int i = ConfigInfo.getSharpConfigVersionFromFile(this.mContext);
    String str2 = format(ConfigInfo.getSharpConfigPayloadFromFile(this.mContext));
    String str1 = imh.R(this.mContext);
    str2 = str2 + "\n----------\n";
    str1 = str2 + format(str1);
    paramView.setText(i + "|" + itl.a().get("load"));
    ((TextView)localObject).setText(str1);
  }
  
  String format(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    paramString = new String();
    int n = arrayOfString.length;
    int k = 0;
    int i = 0;
    String str;
    int j;
    if (k < n)
    {
      str = arrayOfString[k];
      j = str.length();
      if (j < 2) {
        break label172;
      }
    }
    label172:
    for (int m = str.charAt(j - 2);; m = 0)
    {
      j = i;
      if (m == 125) {
        j = i - 1;
      }
      i = 0;
      while (i < j)
      {
        paramString = paramString + "\t";
        i += 1;
      }
      paramString = paramString + str;
      paramString = paramString + "\n";
      i = j;
      if (m == 123) {
        i = j + 1;
      }
      k += 1;
      break;
      return paramString;
    }
  }
  
  public void init()
  {
    Object localObject = (Activity)this.mContext;
    View localView = ((Activity)localObject).findViewById(2131373964);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      localView.setVisibility(0);
    }
    localView = ((Activity)localObject).findViewById(2131373966);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localObject = ((Activity)localObject).findViewById(2131373965);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    this.mContext.registerReceiver(this.mBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      System.arraycopy(this.p, 1, this.p, 0, this.p.length - 1);
      this.p[(this.p.length - 1)] = SystemClock.uptimeMillis();
      if (this.p[0] >= SystemClock.uptimeMillis() - 2000L)
      {
        bL(paramView);
        continue;
        ((Activity)this.mContext).findViewById(2131373965).setVisibility(8);
      }
    }
  }
  
  public void unInit()
  {
    this.mContext.unregisterReceiver(this.mBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixy
 * JD-Core Version:    0.7.0.1
 */