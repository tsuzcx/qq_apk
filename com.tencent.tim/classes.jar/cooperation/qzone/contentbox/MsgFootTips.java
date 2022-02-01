package cooperation.qzone.contentbox;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import avte;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

public class MsgFootTips
  extends FrameLayout
{
  private MsgFootTips a = this;
  private LinearLayout cc;
  private int currentState;
  private View eg;
  private TextView id;
  private Context mContext;
  private Handler mHandler;
  private ProgressBar s;
  private String yE = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLoadingComment", "正在加载评论...");
  private String yF = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLoadingMoreComment", "加载更多评论...");
  private String yG = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewAddFirstComment", "快来添加第一条评论吧!");
  private String yH = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewShowAll", "已显示全部");
  private String yI = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLookUp", "查看更多");
  private boolean yJ;
  public boolean yK;
  
  public MsgFootTips(Context paramContext, Handler paramHandler)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    initView();
    bindEvents();
  }
  
  private void bindEvents()
  {
    this.cc.setOnClickListener(new avte(this));
  }
  
  private void initView()
  {
    this.cc = ((LinearLayout)LayoutInflater.from(this.mContext).inflate(2131562489, null));
    try
    {
      this.cc.setBackgroundResource(2130838900);
      addView(this.cc);
      this.s = ((ProgressBar)this.cc.findViewById(2131364989));
      this.id = ((TextView)this.cc.findViewById(2131364990));
      this.eg = this.cc.findViewById(2131364987);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QZoneMsgManager.MsgFootTips", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (this.cc != null) {
      this.cc.setBackgroundColor(paramInt);
    }
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    View localView = this.eg;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setLoadingDataText(String paramString)
  {
    this.yE = paramString;
  }
  
  public void setLoadingMoreDataText(String paramString)
  {
    this.yF = paramString;
  }
  
  public void setNoDataText(String paramString)
  {
    this.yG = paramString;
  }
  
  public void setNoMoreDataText(String paramString)
  {
    this.yH = paramString;
  }
  
  public void setNoMoreDataVisibility(boolean paramBoolean)
  {
    this.yJ = paramBoolean;
  }
  
  public void setState(int paramInt)
  {
    if ((this.id == null) || (this.s == null)) {
      return;
    }
    setVisibility(0);
    this.currentState = paramInt;
    if (this.id.getVisibility() == 8) {
      this.id.setVisibility(0);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yE);
      this.s.setVisibility(0);
      this.id.setText(this.yE);
      this.id.setVisibility(0);
      return;
    case 1: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yF);
      this.s.setVisibility(0);
      this.id.setText(this.yF);
      this.id.setVisibility(0);
      return;
    case 2: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yG);
      this.s.setVisibility(8);
      this.id.setText(this.yG);
      this.id.setVisibility(0);
      return;
    case 3: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，隐藏");
      setVisibility(8);
      this.id.setVisibility(8);
      this.s.setVisibility(8);
      return;
    case 4: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yH);
      this.s.setVisibility(8);
      this.id.setText(this.yH);
      if (this.yJ)
      {
        this.id.setVisibility(0);
        return;
      }
      this.id.setVisibility(8);
      setVisibility(8);
      return;
    case 6: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yH);
      this.s.setVisibility(8);
      this.id.setText(this.yH);
      this.id.setVisibility(0);
      setVisibility(4);
      return;
    case 7: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yH);
      this.s.setVisibility(8);
      this.id.setText(this.yH);
      this.id.setVisibility(0);
      setVisibility(0);
      return;
    }
    QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.yI);
    this.s.setVisibility(8);
    this.id.setText(this.yI);
    this.id.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgFootTips
 * JD-Core Version:    0.7.0.1
 */