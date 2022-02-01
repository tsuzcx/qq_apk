import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class zem
  extends BaseAdapter
{
  private zem.b a;
  private boolean aTT;
  private View.OnClickListener eA;
  private Context mContext;
  private List<Object> mData = new ArrayList();
  private LayoutInflater mInflater;
  
  public zem(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(zem.b paramb)
  {
    this.a = paramb;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    Object localObject2 = getItem(paramInt);
    if ((localObject2 instanceof String)) {
      if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
      {
        localObject1 = (TextView)paramView.getTag();
        ((TextView)localObject1).setText((String)localObject2);
      }
    }
    for (localObject1 = paramView;; localObject1 = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = this.mInflater.inflate(2131561031, paramViewGroup, false);
      localObject1 = (TextView)paramView.findViewById(2131379419);
      paramView.setTag(localObject1);
      break;
      if ((localObject2 instanceof TencentDocItem))
      {
        localObject1 = paramView;
        for (;;)
        {
          try
          {
            for (;;)
            {
              TencentDocItem localTencentDocItem = (TencentDocItem)localObject2;
              if (paramView != null)
              {
                localObject1 = paramView;
                if ((paramView.getTag() instanceof zem.a))
                {
                  localObject1 = paramView;
                  localObject2 = (zem.a)paramView.getTag();
                  localObject1 = localObject2;
                }
              }
              try
              {
                label154:
                paramView.setVisibility(0);
                ((zem.a)localObject1).jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTencentDocItem = localTencentDocItem;
                ((zem.a)localObject1).fileName.setText(localTencentDocItem.mTitle);
                zje.j(((zem.a)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTencentDocItem.mIcon);
                if (this.aTT)
                {
                  ((zem.a)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
                  boolean bool1 = bool2;
                  if (this.a != null)
                  {
                    bool1 = bool2;
                    if (this.a.a(localTencentDocItem)) {
                      bool1 = true;
                    }
                  }
                  ((zem.a)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool1);
                }
                for (;;)
                {
                  ((zem.a)localObject1).aY.setText(localTencentDocItem.mDescription);
                  localObject2 = paramView;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break;
                  localObject1 = paramView;
                  localObject2 = new zem.a();
                  localObject1 = paramView;
                  paramView = this.mInflater.inflate(2131561003, paramViewGroup, false);
                  localObject1 = paramView;
                  ((zem.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131367036));
                  localObject1 = paramView;
                  ((zem.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367020));
                  localObject1 = paramView;
                  ((zem.a)localObject2).fileName = ((TextView)paramView.findViewById(2131367034));
                  localObject1 = paramView;
                  ((zem.a)localObject2).aY = ((TextView)paramView.findViewById(2131367018));
                  localObject1 = paramView;
                  ((zem.a)localObject2).fileName.setMaxLines(2);
                  localObject1 = paramView;
                  ((zem.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
                  localObject1 = paramView;
                  paramView.setOnClickListener(this.eA);
                  localObject1 = paramView;
                  paramView.setTag(localObject2);
                  localObject1 = localObject2;
                  break label154;
                  ((zem.a)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
                }
                QLog.e("ChatHistoryBaseTenDocAdapter", 4, "getView failed", localException1);
              }
              catch (Exception localException1) {}
            }
          }
          catch (Exception localException2)
          {
            paramView = (View)localObject1;
          }
        }
      }
    }
  }
  
  public void setData(List<Object> paramList)
  {
    if (paramList != null) {
      this.mData = paramList;
    }
  }
  
  public void setSelectMode(boolean paramBoolean)
  {
    this.aTT = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void y(View.OnClickListener paramOnClickListener)
  {
    this.eA = paramOnClickListener;
  }
  
  public static class a
    implements Cloneable
  {
    public CheckBox a;
    public TencentDocItem a;
    public AsyncImageView a;
    public TextView aY;
    public TextView fileName;
  }
  
  public static abstract interface b
  {
    public abstract boolean a(TencentDocItem paramTencentDocItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zem
 * JD-Core Version:    0.7.0.1
 */