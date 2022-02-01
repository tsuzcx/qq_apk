import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class dm
  extends du
{
  public static String TAG = "dataline.PrinterSessionAdapter";
  public View.OnLongClickListener a;
  BubblePopupWindow a;
  acde b;
  public PrinterActivity b;
  LayoutInflater mInflater = null;
  private View.OnClickListener mOnClickListener = new dn(this);
  
  public dm(PrinterActivity paramPrinterActivity, acde paramacde)
  {
    this.jdField_b_of_type_Acde = null;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new dp(this);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_b_of_type_Acde = paramacde;
    this.jdField_b_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.mInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_b_of_type_Acde.a.AE();
    cj();
  }
  
  public int af()
  {
    return this.jdField_b_of_type_Acde.a.ts.size();
  }
  
  public long c(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_b_of_type_Acde.a.ts.get(paramInt)).time;
  }
  
  public long d(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_b_of_type_Acde.a.ts.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_Acde.a.ts.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_b_of_type_Acde.a.ts.size() > paramInt) {
      this.jdField_b_of_type_Acde.a.ts.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_b_of_type_Acde.a.ts.size() > paramInt) {}
    for (Object localObject1 = (PrinterItemMsgRecord)this.jdField_b_of_type_Acde.a.ts.get(paramInt);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
      }
      Object localObject3;
      label295:
      int i;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2131559191, null);
        localObject2 = new dl();
        ((dl)localObject2).o = ((RelativeLayout)paramView.findViewById(2131372014));
        ((dl)localObject2).o.setTag(localObject2);
        ((dl)localObject2).o.setClickable(true);
        ((dl)localObject2).o.setLongClickable(true);
        ((dl)localObject2).o.setOnClickListener(this.mOnClickListener);
        ((dl)localObject2).o.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((dl)localObject2).o.setAddStatesFromChildren(true);
        ((dl)localObject2).b((TextView)paramView.findViewById(2131378717));
        localObject3 = (RelativeLayout)paramView.findViewById(2131367050);
        ((dl)localObject2).a().n = ((RelativeLayout)localObject3);
        ((dl)localObject2).a().d = ((AsyncImageView)paramView.findViewById(2131367022));
        ((dl)localObject2).a().mFileName = ((TextView)paramView.findViewById(2131367070));
        ((dl)localObject2).a().f = ((ProgressBar)paramView.findViewById(2131367035));
        ((dl)localObject2).a().d.setDefaultImage(2130851854);
        ((dl)localObject2).a().d.setIsDrawRound(false);
        ((dl)localObject2).a((TextView)paramView.findViewById(2131365616));
        paramView.setTag(localObject2);
        ((dl)localObject2).setTag(localObject1);
        ((dl)localObject2).a().d.setIsDrawRound(false);
        localObject3 = ahbj.getExtension(((PrinterItemMsgRecord)localObject1).filename);
        if (localObject3 != null) {
          break label687;
        }
        ((dl)localObject2).a().d.setImageResource(2130845244);
        localObject3 = ((PrinterItemMsgRecord)localObject1).filename;
        i = ((PrinterItemMsgRecord)localObject1).filename.lastIndexOf("/");
        if (i >= 0) {
          localObject3 = ahav.kY(((PrinterItemMsgRecord)localObject1).filename.substring(i + 1));
        }
        ((dl)localObject2).a().mFileName.setText((CharSequence)localObject3);
        switch (((PrinterItemMsgRecord)localObject1).status)
        {
        default: 
          label452:
          if (ThemeUtil.isInNightMode(this.jdField_b_of_type_ComDatalineActivitiesPrinterActivity.app))
          {
            localObject3 = (afeh)this.jdField_b_of_type_ComDatalineActivitiesPrinterActivity.e.getTag(2131361820);
            if (localObject3 != null)
            {
              i = wkj.c(((afeh)localObject3).getBitmap());
              ((dl)localObject2).a().setTextColor(ColorStateList.valueOf(i));
            }
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("dataline.time", 4, "time[" + ((PrinterItemMsgRecord)localObject1).time + "], uniseq[" + ((PrinterItemMsgRecord)localObject1).uniseq + "], lastShowTime[" + this.lastShowTime + "], filename[" + ((PrinterItemMsgRecord)localObject1).filename + "], position[" + paramInt + "], mapShowTime[" + e(((PrinterItemMsgRecord)localObject1).uniseq));
          }
          if (e(((PrinterItemMsgRecord)localObject1).uniseq))
          {
            localObject1 = aqmu.a(this.jdField_b_of_type_ComDatalineActivitiesPrinterActivity, 3, ((PrinterItemMsgRecord)localObject1).time * 1000L);
            ((dl)localObject2).a().setVisibility(0);
            ((dl)localObject2).a().setText((CharSequence)localObject1);
          }
          break;
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        localObject2 = paramView;
        break;
        localObject2 = (dl)paramView.getTag();
        break label295;
        label687:
        ((dl)localObject2).a().d.setDefaultImage(ahav.r((String)localObject3));
        switch (ahav.getFileType((String)localObject3))
        {
        default: 
          i = ahav.r((String)localObject3);
          if (i == 0) {
            break;
          }
          ((dl)localObject2).a().d.setImageResource(i);
          break;
        case 0: 
          ((dl)localObject2).a().d.setAsyncClipSize(128, 128);
          ((dl)localObject2).a().d.setAsyncImage(((PrinterItemMsgRecord)localObject1).filename);
          break;
          ((dl)localObject2).a().f.setVisibility(0);
          ((dl)localObject2).b().setText(2131692396);
          break label452;
          ((dl)localObject2).a().f.setVisibility(0);
          ((dl)localObject2).a().f.setProgress((int)(((PrinterItemMsgRecord)localObject1).progress * 100.0D));
          ((dl)localObject2).b().setText(2131692397);
          break label452;
          ((dl)localObject2).a().f.setVisibility(4);
          ((dl)localObject2).b().setText(2131692399);
          break label452;
          ((dl)localObject2).a().f.setVisibility(4);
          ((dl)localObject2).b().setText(2131692398);
          break label452;
          ((dl)localObject2).a().f.setVisibility(4);
          ((dl)localObject2).b().setText(2131692400);
          break label452;
          ((dl)localObject2).a().setVisibility(8);
        }
      }
    }
  }
  
  protected boolean i(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.isShowing())) {
      return true;
    }
    aqoa localaqoa = new aqoa();
    paramView = (dl)paramView.getTag();
    Object localObject1 = (PrinterItemMsgRecord)paramView.getTag();
    if (localObject1 != null)
    {
      localObject2 = paramView.a().n;
      if (localObject2 == null) {
        return false;
      }
    }
    else
    {
      return false;
    }
    Object localObject2 = ((RelativeLayout)localObject2).getContext();
    localaqoa.dV(2131365692, ((Context)localObject2).getString(2131695393));
    localObject1 = new dq(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = aqgq.a(paramView.o, localaqoa, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new do(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */