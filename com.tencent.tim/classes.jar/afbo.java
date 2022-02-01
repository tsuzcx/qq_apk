import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.DataReportViewer.b;
import com.tencent.mobileqq.datareportviewer.ReportData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class afbo
  implements AdapterView.OnItemClickListener
{
  public afbo(DataReportViewer paramDataReportViewer, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    WindowManager localWindowManager = (WindowManager)this.this$0.getContext().getSystemService("window");
    if (this.this$0.jP == null) {
      this.this$0.jP = ((RelativeLayout)LayoutInflater.from(this.val$context).inflate(2131559809, null));
    }
    Object localObject = new DataReportViewer.b(this.this$0, this.this$0.jP);
    ReportData localReportData = (ReportData)this.this$0.mList.get(paramInt);
    ((DataReportViewer.b)localObject).Ri.setText(localReportData.table);
    ((DataReportViewer.b)localObject).Rj.setText(localReportData.mainAction);
    ((DataReportViewer.b)localObject).Rk.setText(localReportData.subAction);
    ((DataReportViewer.b)localObject).Rl.setText(localReportData.actionName);
    ((DataReportViewer.b)localObject).Rm.setText(String.valueOf(localReportData.opType));
    ((DataReportViewer.b)localObject).nz.setText(String.valueOf(localReportData.result));
    ((DataReportViewer.b)localObject).Rn.setText(localReportData.r2);
    ((DataReportViewer.b)localObject).Ro.setText(localReportData.r3);
    ((DataReportViewer.b)localObject).Rp.setText(localReportData.r4);
    ((DataReportViewer.b)localObject).Rq.setText(localReportData.r5);
    ((TextView)this.this$0.jP.findViewById(2131365858)).setOnClickListener(new afbp(this, localWindowManager));
    ((TextView)this.this$0.jP.findViewById(2131365852)).setOnClickListener(new afbq(this, localReportData, localWindowManager));
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      localObject = new WindowManager.LayoutParams(-1, -1, i, 776, -2);
      ((WindowManager.LayoutParams)localObject).gravity = 49;
      localWindowManager.addView(this.this$0.jP, (ViewGroup.LayoutParams)localObject);
      this.this$0.jP.setOnClickListener(new afbr(this, localWindowManager));
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbo
 * JD-Core Version:    0.7.0.1
 */