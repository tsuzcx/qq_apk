import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aodi
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int dNZ = 1;
  public static int dOa = 2;
  private Set<String> dc = new HashSet();
  private Set<String> dd = new HashSet();
  Context mContext;
  final List<GroupPadTemplateInfo> mData = new ArrayList();
  protected View.OnClickListener onClickListener;
  
  public aodi(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  private void a(AsyncImageView paramAsyncImageView, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if (paramGroupPadTemplateInfo != null)
    {
      Drawable localDrawable = this.mContext.getResources().getDrawable(2130840630);
      if (!aurr.isValidUrl(paramGroupPadTemplateInfo.mobThumbUrl)) {
        paramAsyncImageView.setImageDrawable(localDrawable);
      }
      for (;;)
      {
        return;
        String str = paramGroupPadTemplateInfo.mobThumbUrl;
        paramGroupPadTemplateInfo = URLDrawable.URLDrawableOptions.obtain();
        paramGroupPadTemplateInfo.mLoadingDrawable = localDrawable;
        paramGroupPadTemplateInfo.mFailedDrawable = localDrawable;
        Object localObject = null;
        try
        {
          paramGroupPadTemplateInfo = URLDrawable.getDrawable(str, paramGroupPadTemplateInfo);
          if (paramGroupPadTemplateInfo != null)
          {
            if ((paramGroupPadTemplateInfo.getStatus() == 2) && (this.dd.remove(str))) {
              paramGroupPadTemplateInfo.restartDownload();
            }
            paramGroupPadTemplateInfo.setDownloadListener(new aodj(this, str));
            paramAsyncImageView.setImageDrawable(paramGroupPadTemplateInfo);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("GroupPadTemplateAdapter", 2, "loadThumbImage is ok. url: " + str);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramGroupPadTemplateInfo = localObject;
            if (QLog.isColorLevel())
            {
              QLog.e("GroupPadTemplateAdapter", 2, localException, new Object[] { "loadThumbImage failed" });
              paramGroupPadTemplateInfo = localObject;
            }
          }
          paramAsyncImageView.setImageDrawable(localDrawable);
          return;
        }
      }
    }
    paramAsyncImageView.setImageResource(2130840630);
  }
  
  public GroupPadTemplateInfo a()
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = new GroupPadTemplateInfo();
    localGroupPadTemplateInfo.docOrSheetType = 1;
    localGroupPadTemplateInfo.templateName = this.mContext.getString(2131694526);
    return localGroupPadTemplateInfo;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return this.mData.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    if (localGroupPadTemplateInfo != null) {
      return localGroupPadTemplateInfo.templateID;
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    View localView;
    if (getCount() == paramInt + 1)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131559416, null);
      paramView = new aodi.a();
      paramView.dOb = dOa;
      paramView.e = ((AsyncImageView)localView.findViewById(2131368200));
      paramView.ZP = ((TextView)localView.findViewById(2131368196));
      paramView.DS = ((ImageView)localView.findViewById(2131368194));
      paramView.a = localGroupPadTemplateInfo;
      localView.setTag(paramView);
      localView.setOnClickListener(this.onClickListener);
      if (paramView.a == null) {
        break label316;
      }
      if (paramView.dOb != dNZ) {
        break label293;
      }
      a(paramView.e, localGroupPadTemplateInfo);
      label141:
      paramView.ZP.setText(localGroupPadTemplateInfo.templateName);
      label153:
      if (AppSetting.enableTalkBack)
      {
        if (localGroupPadTemplateInfo == null) {
          break label338;
        }
        localView.setContentDescription(localGroupPadTemplateInfo.templateName);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = LayoutInflater.from(this.mContext).inflate(2131559415, null);
      paramView = new aodi.a();
      paramView.dOb = dNZ;
      paramView.e = ((AsyncImageView)localView.findViewById(2131368199));
      paramView.ZP = ((TextView)localView.findViewById(2131368198));
      paramView.DS = ((ImageView)localView.findViewById(2131368193));
      paramView.a = localGroupPadTemplateInfo;
      localView.setTag(paramView);
      localView.setOnClickListener(this.onClickListener);
      break;
      label293:
      if (paramView.dOb != dOa) {
        break label141;
      }
      paramView.e.setImageResource(2130840632);
      break label141;
      label316:
      paramView.e.setImageResource(2130840630);
      paramView.ZP.setText("");
      break label153;
      label338:
      localView.setContentDescription("");
    }
  }
  
  public void onClick(View paramView) {}
  
  public void setData(List<GroupPadTemplateInfo> paramList)
  {
    this.mData.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)paramList.next();
        if ((localGroupPadTemplateInfo != null) && (localGroupPadTemplateInfo.templateID >= 0)) {
          this.mData.add(localGroupPadTemplateInfo);
        }
      }
      paramList = a();
      this.mData.add(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public class a
  {
    public ImageView DS;
    public TextView ZP;
    public GroupPadTemplateInfo a;
    public int dOb;
    public AsyncImageView e;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodi
 * JD-Core Version:    0.7.0.1
 */