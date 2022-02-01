import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class akbm
  extends akbp
  implements View.OnClickListener
{
  private TextView Vq;
  private TextView Vr;
  private int dmh;
  
  public akbm(PicBrowserActivity paramPicBrowserActivity, sxm paramsxm)
  {
    super(paramPicBrowserActivity, paramsxm);
  }
  
  protected void RJ(int paramInt)
  {
    if (paramInt == this.dmh) {
      this.Vq.setVisibility(8);
    }
    for (;;)
    {
      if (this.a.getCount() <= 1)
      {
        this.Vq.setVisibility(8);
        this.Vr.setVisibility(8);
      }
      return;
      this.Vq.setVisibility(0);
    }
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559698, null);
  }
  
  public void onBack()
  {
    ArrayList localArrayList = this.a.dl();
    if ((this.dmh != 0) && (this.dmh < localArrayList.size())) {
      localArrayList.add(0, (PicInfo)localArrayList.remove(this.dmh));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("intent_param_pic_infos", localArrayList);
    this.b.setResult(-1, localIntent);
    super.onBack();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131378095: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.dmh = this.a.getSelectedIndex();
        this.Vq.setVisibility(8);
        QQToast.a(this.mContext, this.mContext.getResources().getString(2131696236), 0).show();
      }
    }
    int i = this.a.getSelectedIndex();
    if (i < this.dmh) {
      this.dmh -= 1;
    }
    for (;;)
    {
      dAx();
      RJ(this.a.getSelectedIndex());
      break;
      if (i == this.dmh) {
        if (i == this.a.getCount() - 1) {
          this.dmh = (i - 1);
        } else {
          this.dmh = i;
        }
      }
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    RJ(paramInt);
  }
  
  public void setRootView(ViewGroup paramViewGroup)
  {
    super.setRootView(paramViewGroup);
    this.Vq = ((TextView)paramViewGroup.findViewById(2131378095));
    this.Vr = ((TextView)paramViewGroup.findViewById(2131365689));
    this.Vq.setOnClickListener(this);
    this.Vr.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbm
 * JD-Core Version:    0.7.0.1
 */