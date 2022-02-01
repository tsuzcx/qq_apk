package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqdj;
import avpq;
import awkj;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import mqq.app.AppRuntime;

public class TimeHeaderLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static String cNI = "capsule_open";
  ImageView HE;
  View LL;
  a jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a;
  b jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$b;
  TextView agu;
  TextView agv;
  TextView agw;
  Handler handler;
  private Context mContext;
  private LinearLayout mn;
  SharedPreferences preferences;
  
  public TimeHeaderLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private String Gx()
  {
    String str2 = QzoneConfig.getInstance().getConfig("H5Url", "QzoneVisitor", "https://h5.qzone.qq.com/qzone/visitor/{hostUin}?uin={uin}&from={from}&qua={qua}&clicktime={clicktime}&hostuin={hostUin}&_wv=3&_proxy=1&trace_detail=%7B%22appid%22%3A%22{refer}%22%7D");
    if (TextUtils.isEmpty(str2)) {
      return str2;
    }
    String str3 = getCurrentUin();
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = str2.replace("{uin}", str3).replace("{hostUin}", str3);
    }
    return str1.replace("{clicktime}", System.currentTimeMillis() + "").replace("{from}", "androidQQ").replace("{qua}", avpq.getQUA3());
  }
  
  private void a(a parama)
  {
    LpReportInfo_dc02880 localLpReportInfo_dc02880 = new LpReportInfo_dc02880(7, 3);
    LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc02880, false, true);
    if ((this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$b != null) && (parama != null)) {
      this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$b.gU(parama.jumpUrl, 2131379677);
    }
  }
  
  private String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private void init()
  {
    this.handler = new Handler(Looper.getMainLooper());
    LayoutInflater.from(getContext()).inflate(2131562603, this, true);
    this.preferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_time_capsule", 0);
    this.LL = findViewById(2131379677);
    this.HE = ((ImageView)findViewById(2131363175));
    this.agu = ((TextView)findViewById(2131376434));
    this.agv = ((TextView)findViewById(2131375937));
    this.agw = ((TextView)findViewById(2131376504));
    this.mn = ((LinearLayout)findViewById(2131370308));
    this.mn.setOnClickListener(this);
    findViewById(2131379677).setOnClickListener(this);
    awkj.lm(9, 1);
  }
  
  private void update()
  {
    Object localObject = aqdj.g(1, 1);
    localObject = aqdj.a(((BaseActivity)this.mContext).app, 1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 1, (Drawable)localObject, (Drawable)localObject, null);
    this.HE.setImageDrawable((Drawable)localObject);
    if (this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a != null)
    {
      if (this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a.aAq <= 999L) {
        break label122;
      }
      this.agw.setText("999+");
      if (this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a.aAp <= 999L) {
        break label142;
      }
      this.agv.setText("999+");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a.aAo <= 9999L) {
        break label162;
      }
      this.agu.setText("9999+");
      return;
      label122:
      this.agw.setText(String.valueOf(this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a.aAq));
      break;
      label142:
      this.agv.setText(String.valueOf(this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a.aAp));
    }
    label162:
    this.agu.setText(String.valueOf(this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a.aAo));
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
      a(this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a);
      continue;
      if (this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$b != null)
      {
        String str = Gx();
        if (QLog.isColorLevel()) {
          QLog.i("QZoneMsg", 0, " jump url = " + str);
        }
        awkj.lm(9, 2);
        this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$b.gU(str, 2131370308);
      }
    }
  }
  
  public void setHeadInfo(a parama)
  {
    this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$a = parama;
    if (parama != null) {
      ThreadManagerV2.executeOnSubThread(new TimeHeaderLayout.1(this));
    }
  }
  
  public void setOnDetailClickListner(b paramb)
  {
    this.jdField_a_of_type_CooperationQzoneContentboxTimeHeaderLayout$b = paramb;
  }
  
  public static class a
  {
    public long aAo;
    public long aAp;
    public long aAq;
    public String jumpUrl;
  }
  
  public static abstract interface b
  {
    public abstract void gU(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout
 * JD-Core Version:    0.7.0.1
 */