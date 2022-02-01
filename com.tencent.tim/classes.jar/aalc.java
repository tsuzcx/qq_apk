import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class aalc
  extends aakb
{
  protected aajx mFaceDecoder;
  private List<String> vo;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    this.mFaceDecoder = paramaajx;
    paramViewGroup = null;
    paramaajx = paramViewGroup;
    if (paramView != null)
    {
      paramaajx = paramViewGroup;
      if (paramView.getTag() != null)
      {
        paramaajx = paramViewGroup;
        if ((paramView.getTag() instanceof aalc.b)) {
          paramaajx = (aalc.b)paramView.getTag();
        }
      }
    }
    if (paramaajx == null)
    {
      paramViewGroup = new aalc.b();
      paramc = super.a(paramContext, 2131561452, paramViewGroup);
      paramViewGroup.wl = ((ImageView)paramc.findViewById(2131368723));
      paramViewGroup.titleTV = ((TextView)paramc.findViewById(2131379870));
      paramViewGroup.i = ((DragTextView)paramc.findViewById(2131381286));
      paramViewGroup.A = ((SingleLineTextView)paramc.findViewById(2131372039));
      paramViewGroup.c = ((MyGridView)paramc.findViewById(2131372010));
      paramaajx = paramContext.getResources();
      paramView = paramaajx.getDisplayMetrics();
      int m = (int)(Math.min(paramView.widthPixels, paramView.heightPixels) - paramView.density * 119.0F);
      int i = paramaajx.getDimensionPixelSize(2131299335);
      int k = paramaajx.getDimensionPixelSize(2131299334);
      if (i <= 0)
      {
        i = 45;
        int j = k;
        if (k <= 0) {
          j = 10;
        }
        m /= (i + j);
        k = m;
        if (m > 6) {
          k = 6;
        }
        paramaajx = new aalc.a(paramContext, k, i);
        paramViewGroup.c.setColumnWidth(i);
        paramViewGroup.c.setNumColumns(k);
        paramViewGroup.c.setHorizontalSpacing(j);
        paramViewGroup.c.setStretchMode(0);
        paramViewGroup.c.eid();
        paramViewGroup.c.setAdapter(paramaajx);
        paramViewGroup.A.setExtendTextSize(14.0F, 1);
        paramc.setTag(paramViewGroup);
        paramView = paramc;
        paramaajx = paramViewGroup;
        if (this.c != null)
        {
          paramViewGroup.i.setOnModeChangeListener(this.c.a());
          paramaajx = paramViewGroup;
          paramView = paramc;
        }
      }
    }
    for (;;)
    {
      paramaajx.i.setTag(Integer.valueOf(paramInt));
      paramViewGroup = paramContext.getResources().getDrawable(2130846463);
      if ((paramaajx != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramaajx, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(null);
        }
        return paramView;
        if (paramaajx != null)
        {
          paramaajx.wl.setImageDrawable(paramViewGroup);
          paramaajx.titleTV.setText("");
          paramaajx.A.setText("");
        }
      }
      break;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    for (;;)
    {
      this.vo.add(paramRecentBaseData.getString(fy[0]));
      return this.vo;
      this.vo.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable arg4)
  {
    int i = 0;
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof aalc.b));
    Object localObject = (aalc.b)localObject;
    RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
    ((aalc.b)localObject).wl.setImageDrawable(???);
    ((aalc.b)localObject).titleTV.setText(2131701344);
    int k = paramRecentBaseData.mUnreadNum;
    int j = paramRecentBaseData.mUnreadFlag;
    if (k > 0) {
      if (j == 3)
      {
        j = 2130851408;
        ((aalc.b)localObject).i.setDragViewType(1);
        i = 3;
      }
    }
    for (;;)
    {
      label105:
      aute.updateCustomNoteTxt(((aalc.b)localObject).i, i, k, j, 99, null);
      i = paramRecentBaseData.mExtraInfoColor;
      ??? = paramRecentBaseData.mMsgExtroInfo;
      if (??? != null)
      {
        ??? = ???.toString();
        label148:
        if (!TextUtils.isEmpty(???)) {
          ((aalc.b)localObject).A.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        ((aalc.b)localObject).A.setExtendText(???, 1);
      }
      for (;;)
      {
        synchronized (localRecentSayHelloBoxItem.lock)
        {
          if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.mMsgExtroInfo))
          {
            ((aalc.b)localObject).c.setVisibility(8);
            ((aalc.b)localObject).A.setVisibility(0);
            ((aalc.b)localObject).A.setText(localRecentSayHelloBoxItem.mLastMsg);
            ((aalc.b)localObject).A.setTextColor(paramContext.getResources().getColor(2131167379));
            if (!AppSetting.enableTalkBack) {
              break;
            }
            paramView.setContentDescription(paramRecentBaseData.mContentDesc);
            return;
            j = 2130851404;
            ((aalc.b)localObject).i.setDragViewType(0);
            i = 3;
            break label105;
            ??? = "";
            break label148;
          }
          if ((localRecentSayHelloBoxItem.mUnreadMRList != null) && (localRecentSayHelloBoxItem.mUnreadMRList.size() > 0))
          {
            ((aalc.b)localObject).A.setVisibility(8);
            ((aalc.b)localObject).c.setVisibility(0);
            ((aalc.b)localObject).A.setTextColor(paramContext.getResources().getColor(2131167379));
            if (((aalc.b)localObject).c.getAdapter() == null) {
              continue;
            }
            aalc.a.a((aalc.a)((aalc.b)localObject).c.getAdapter(), localRecentSayHelloBoxItem.mUnreadMRList);
          }
        }
        ((aalc.b)localObject).c.setVisibility(8);
        ((aalc.b)localObject).A.setVisibility(0);
        ((aalc.b)localObject).A.setText(localRecentSayHelloBoxItem.mLastMsg);
        ((aalc.b)localObject).A.setTextColor(paramContext.getResources().getColor(2131167379));
      }
      j = 0;
    }
  }
  
  public void b(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null) || (paramDrawable == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag();
      if ((paramView instanceof aalc.b))
      {
        paramView = (aalc.b)paramView;
        int j = paramView.c.getCount();
        int i = 0;
        while (i < j)
        {
          paramRecentBaseData = paramView.c.getChildAt(i);
          if ((paramRecentBaseData != null) && ((paramRecentBaseData.getTag(-1) instanceof String)))
          {
            String str = (String)paramRecentBaseData.getTag(-1);
            if (str.equals(paramMessageRecord.senderuin))
            {
              ((CustomImgView)paramRecentBaseData).setImageDrawable(paramDrawable);
              return;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SAYHELL_BOX", 4, "updateMsgHeader,childView uin:" + str);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private int TL;
    private int columnWidth;
    private Context context;
    private List<MessageRecord> vr;
    
    public a(Context paramContext, int paramInt1, int paramInt2)
    {
      this.context = paramContext;
      this.TL = paramInt1;
      this.columnWidth = paramInt2;
      this.vr = new ArrayList();
    }
    
    private void hI(List<MessageRecord> paramList)
    {
      if (paramList != null)
      {
        this.vr.clear();
        this.vr.addAll(paramList);
      }
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.vr == null) {}
      for (int i = 0;; i = this.vr.size())
      {
        int j = i;
        if (i > this.TL) {
          j = this.TL;
        }
        return j;
      }
    }
    
    public Object getItem(int paramInt)
    {
      if (this.vr == null) {}
      for (int i = 0; (paramInt > 0) && (paramInt < i); i = this.vr.size()) {
        return this.vr.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(2131561296, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.columnWidth, this.columnWidth));
      }
      for (;;)
      {
        CustomImgView localCustomImgView = (CustomImgView)paramView;
        MessageRecord localMessageRecord = (MessageRecord)this.vr.get(paramInt);
        if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.senderuin)))
        {
          localCustomImgView.setImageDrawable(aalc.this.mFaceDecoder.a(localMessageRecord.istroop, localMessageRecord.senderuin));
          paramView.setTag(-1, localMessageRecord.senderuin);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  public static class b
    extends aakb.a
  {
    public SingleLineTextView A;
    public MyGridView c;
    public DragTextView i;
    public TextView titleTV;
    public ImageView wl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalc
 * JD-Core Version:    0.7.0.1
 */