import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class abdn
  extends BaseAdapter
{
  private AppletsSettingFragment.a a;
  private Drawable dm;
  protected QQAppInterface mApp;
  private Activity mContext;
  protected List<Object> mDataList;
  private LayoutInflater mInflater;
  private CompoundButton.OnCheckedChangeListener x = new abdo(this);
  
  public abdn(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, AppletsSettingFragment.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.mInflater = ((LayoutInflater)paramFragmentActivity.getSystemService("layout_inflater"));
    this.mDataList = new ArrayList();
    this.mContext = paramFragmentActivity;
    this.dm = paramFragmentActivity.getResources().getDrawable(2130846238);
    this.a = parama;
  }
  
  public void cS(List<AppletItem> paramList)
  {
    this.mDataList.clear();
    if (paramList != null) {
      this.mDataList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mDataList.size())) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (AppletItem)getItem(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    label122:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new abdn.a();
      paramView = this.mInflater.inflate(2131561662, paramViewGroup, false);
      ((abdn.a)localObject1).mItemLayout = ((RelativeLayout)paramView.findViewById(2131362875));
      ((abdn.a)localObject1).aF = ((URLImageView)paramView.findViewById(2131362874));
      ((abdn.a)localObject1).Pd = ((TextView)paramView.findViewById(2131362876));
      ((abdn.a)localObject1).C = ((Switch)paramView.findViewById(2131362877));
      paramView.setTag(localObject1);
      ((abdn.a)localObject1).mItemLayout.setBackgroundResource(2130839682);
      Object localObject3 = ((abdn.a)localObject1).C;
      if (((AppletItem)localObject2).getValue() != 1) {
        break label327;
      }
      bool = true;
      label151:
      ((Switch)localObject3).setChecked(bool);
      ((abdn.a)localObject1).C.setOnCheckedChangeListener(this.x);
      ((abdn.a)localObject1).C.setTag(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("AppletsListAdapter", 2, ((AppletItem)localObject2).toString());
      }
      ((abdn.a)localObject1).Pd.setText(((AppletItem)localObject2).getName());
      ((abdn.a)localObject1).a = ((AppletItem)localObject2);
      if (TextUtils.isEmpty(((AppletItem)localObject2).getIcon())) {
        break label333;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = wja.dp2px(((abdn.a)localObject1).aF.getMeasuredWidth(), this.mContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.dm;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.dm;
      localObject2 = URLDrawable.getDrawable(((AppletItem)localObject2).getIcon(), (URLDrawable.URLDrawableOptions)localObject3);
      ((abdn.a)localObject1).aF.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      localObject1 = (abdn.a)paramView.getTag();
      break label122;
      label327:
      bool = false;
      break label151;
      label333:
      ((abdn.a)localObject1).aF.setImageDrawable(this.dm);
    }
  }
  
  public static class a
  {
    Switch C;
    TextView Pd;
    AppletItem a;
    URLImageView aF;
    RelativeLayout mItemLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdn
 * JD-Core Version:    0.7.0.1
 */