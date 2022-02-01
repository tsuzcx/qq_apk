import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aodk
  extends BaseAdapter
  implements aodc.a
{
  protected List<Object> GW = new ArrayList();
  private anzt jdField_a_of_type_Anzt;
  private aodh jdField_a_of_type_Aodh = new aodh();
  private aoel jdField_a_of_type_Aoel;
  private aoeo jdField_a_of_type_Aoeo;
  private QQAppInterface app;
  protected boolean cLe;
  protected boolean cLf;
  protected View.OnClickListener clickListener = new aodl(this);
  private Context context;
  protected int entrance;
  private Activity mActivity;
  private long mCreateTime;
  protected Handler mHandler;
  public int mSelectedPosition = -1;
  protected View.OnClickListener onClickListener;
  protected View.OnLongClickListener onLongClickListener;
  
  public aodk(QQAppInterface paramQQAppInterface, Activity paramActivity, anzt paramanzt, Handler paramHandler)
  {
    this.app = paramQQAppInterface;
    this.context = paramActivity;
    this.entrance = 1;
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Anzt = paramanzt;
    this.mHandler = paramHandler;
    this.mCreateTime = (anaz.gQ() * 1000L);
  }
  
  public void a(int paramInt, aoef paramaoef)
  {
    paramaoef = (PadInfo)paramaoef;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Anzt == null);
      this.jdField_a_of_type_Anzt.b(paramaoef);
      return;
    } while (this.jdField_a_of_type_Anzt == null);
    this.jdField_a_of_type_Anzt.a(paramaoef);
  }
  
  protected void a(aodg paramaodg)
  {
    if ((paramaodg instanceof aodc)) {
      ((aodc)paramaodg).a(this);
    }
  }
  
  public void dUi()
  {
    if (this.GW != null) {
      this.GW.clear();
    }
  }
  
  public int getCount()
  {
    return this.GW.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.GW.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((aoef)this.GW.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aoef localaoef = (aoef)this.GW.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localaoef.getCloudFileType() == 10)
    {
      localObject2 = this.jdField_a_of_type_Aoeo;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new aoeo(this.app, this.context, this, this.entrance);
        this.jdField_a_of_type_Aoeo = ((aoeo)localObject1);
      }
    }
    for (;;)
    {
      a((aodg)localObject1);
      paramView = ((aodg)localObject1).a(paramInt, localaoef, paramView, paramViewGroup, this.cLe, false, this.clickListener, this.onLongClickListener, this.cLf, this.mSelectedPosition);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = this.jdField_a_of_type_Aoel;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new aoel(this.app, this.context, this, this.entrance);
        this.jdField_a_of_type_Aoel = ((aoel)localObject1);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
  
  public void mw(List<? extends Object> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.GW.addAll(paramList);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(4);
      }
      notifyDataSetChanged();
    }
    do
    {
      return;
      dUi();
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessage(3);
  }
  
  public void mx(List<? extends Object> paramList)
  {
    this.GW.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.GW.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.GW.add(this.jdField_a_of_type_Aodh);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodk
 * JD-Core Version:    0.7.0.1
 */