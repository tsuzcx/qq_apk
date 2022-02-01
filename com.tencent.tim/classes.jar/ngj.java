import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ngj
  extends BaseAdapter
  implements View.OnClickListener
{
  private final String TAG = "ReadInJoyNavigationAdapter";
  private ngj.a a;
  private Context context;
  public int fontColor = -13879999;
  public int frameColor = -723466;
  private List<ChannelCoverInfo> jX;
  public final int selectedColor = -9387998;
  
  public ngj(Context paramContext)
  {
    this.context = paramContext;
    this.jX = new ArrayList();
  }
  
  private void L(View paramView, int paramInt)
  {
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(aqnm.dip2px(17.0F));
    localGradientDrawable1.setColor(-723466);
    localGradientDrawable1.setStroke(1, paramInt);
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(aqnm.dip2px(17.0F));
    localGradientDrawable2.setColor(-2697514);
    localGradientDrawable2.setStroke(1, paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, localGradientDrawable1);
    paramView.setBackgroundDrawable(localStateListDrawable);
  }
  
  private List<ChannelCoverInfo> aa(List<ChannelCoverInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 28) {
        localObject = paramList.subList(0, 28);
      }
    }
    return localObject;
  }
  
  public void cX(List<ChannelCoverInfo> paramList)
  {
    this.jX.clear();
    this.jX.addAll(aa(paramList));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, new Object[] { "mChannels size: ", Integer.valueOf(this.jX.size()) });
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jX != null) {
      return this.jX.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jX.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = new ngj.b(null);
      localView = LayoutInflater.from(this.context).inflate(2131560429, paramViewGroup, false);
      paramView.container = localView.findViewById(2131365322);
      paramView.sZ = ((TextView)localView.findViewById(2131379178));
      localView.setTag(paramView);
      localObject = (ChannelCoverInfo)this.jX.get(paramInt);
      if (localObject != null)
      {
        paramView.sZ.setText(((ChannelCoverInfo)localObject).mChannelCoverName);
        int j = 5;
        i = 12;
        if (aqgz.hM() < 1080L)
        {
          j = 4;
          i = 11;
        }
        if (paramView.sZ.length() < j) {
          break label306;
        }
      }
    }
    for (;;)
    {
      float f = acej.aV() / 16.0F;
      paramView.sZ.setTextSize(i / f);
      paramView.sZ.setTextColor(((ChannelCoverInfo)localObject).mFontColor);
      L(paramView.container, this.frameColor);
      if (!TextUtils.isEmpty(((ChannelCoverInfo)localObject).mIconUrl)) {}
      for (;;)
      {
        if (!((ChannelCoverInfo)localObject).isReport)
        {
          ((ChannelCoverInfo)localObject).isReport = true;
          kqo.a("0X8007F01", (ChannelCoverInfo)localObject, kqo.aLl);
        }
        paramView.container.setTag(localObject);
        paramView.container.setOnClickListener(this);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (ngj.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        paramView.container.setPadding(aqnm.dip2px(8.0F), 0, aqnm.dip2px(8.0F), 0);
        paramView.sZ.setCompoundDrawables(null, null, null, null);
        paramView.sZ.setGravity(17);
      }
      label306:
      i = 14;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, "click container");
    }
    ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramView.getTag();
    Object localObject;
    if (localChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(localChannelCoverInfo.mChannelJumpUrl)) {
        break label261;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(localChannelCoverInfo.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(localChannelCoverInfo.mChannelCoverStyle));
      kgw.a(this.context, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNavigationAdapter", 2, "launchChannelActivity info.mArticleId:" + localChannelCoverInfo.mArticleId + " info.mChannelCoverStyle: " + localChannelCoverInfo.mChannelCoverStyle + " info.mChannelCoverId:" + localChannelCoverInfo.mChannelCoverId + " info.mChannelCoverName:" + localChannelCoverInfo.mChannelCoverName + " info.mChannelType: " + localChannelCoverInfo.mChannelType);
      }
    }
    label261:
    label360:
    for (;;)
    {
      kqo.a("0X8007F02", localChannelCoverInfo, kqo.aLl);
      if ((this.a == null) || (!(paramView.getTag() instanceof ChannelCoverInfo))) {
        break;
      }
      this.a.b((ChannelCoverInfo)paramView.getTag());
      break;
      if (ntp.ek(localChannelCoverInfo.mChannelJumpUrl)) {
        ntp.b(this.context, "", localChannelCoverInfo.mChannelJumpUrl, null);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label360;
        }
        QLog.d("ReadInJoyNavigationAdapter", 2, "info.mChannelJumpUrl:" + localChannelCoverInfo.mChannelJumpUrl);
        break;
        localObject = new Intent(this.context, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", localChannelCoverInfo.mChannelJumpUrl);
        this.context.startActivity((Intent)localObject);
      }
    }
  }
  
  public void setChannelButtonListener(ngj.a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(ChannelCoverInfo paramChannelCoverInfo);
  }
  
  class b
  {
    View container;
    TextView sZ;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngj
 * JD-Core Version:    0.7.0.1
 */