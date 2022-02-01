import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class qoj
  extends BaseAdapter
{
  protected qwo a;
  protected QQStoryContext b;
  protected int bnn = -1;
  View.OnTouchListener f;
  protected Context mContext;
  protected List<QQUserUIItem> nW;
  
  public qoj(Context paramContext, View.OnTouchListener paramOnTouchListener)
  {
    this.mContext = paramContext;
    this.b = QQStoryContext.a();
    this.nW = new ArrayList();
    this.f = paramOnTouchListener;
  }
  
  public void a(qwo paramqwo)
  {
    this.a = paramqwo;
  }
  
  public void appendData(List<QQUserUIItem> paramList)
  {
    this.nW.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.nW.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.nW.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    int i;
    label42:
    QQUserUIItem localQQUserUIItem;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(this.mContext);
      if (this.bnn == -1)
      {
        i = 2131562041;
        localObject1 = new qyd(((LayoutInflater)localObject1).inflate(i, null));
        localQQUserUIItem = (QQUserUIItem)this.nW.get(paramInt);
        localObject2 = (TextView)((qyd)localObject1).get(2131372384);
        String str = localQQUserUIItem.getUserIconUrl();
        if (TextUtils.isEmpty(str)) {
          break label286;
        }
        if (QLog.isColorLevel()) {
          QLog.w("zivonchen", 2, "fillFriendsData userIconUrl = " + str);
        }
        qem.a(this.mContext.getResources(), (TextView)localObject2, str, 13.0F, 2.0F);
        label133:
        ((TextView)localObject2).setText(qem.d(localQQUserUIItem));
        localObject2 = (ImageView)((qyd)localObject1).get(2131368427);
        if ((!localQQUserUIItem.isVip) || (!jqc.isValidUrl(localQQUserUIItem.headUrl))) {
          break label304;
        }
        rpq.a((ImageView)localObject2, localQQUserUIItem.headUrl, 38, 38, 1);
      }
    }
    for (;;)
    {
      ((qyd)localObject1).param = localQQUserUIItem;
      if (this.f != null) {
        ((qyd)localObject1).getItemView().setOnTouchListener(this.f);
      }
      ((qyd)localObject1).getItemView().setOnClickListener((View.OnClickListener)localObject1);
      if (this.a != null) {
        ((qyd)localObject1).b(this.a);
      }
      localObject1 = ((qyd)localObject1).getItemView();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      i = this.bnn;
      break;
      localObject1 = (qyd)paramView.getTag();
      break label42;
      label286:
      ((TextView)localObject2).setCompoundDrawablePadding(0);
      ((TextView)localObject2).setCompoundDrawables(null, null, null, null);
      break label133;
      label304:
      if (!TextUtils.isEmpty(localQQUserUIItem.qq)) {
        qem.c((ImageView)localObject2, localQQUserUIItem.qq);
      } else {
        ((ImageView)localObject2).setImageDrawable(aqhu.aU());
      }
    }
  }
  
  public void setData(List<QQUserUIItem> paramList)
  {
    this.nW = paramList;
    super.notifyDataSetChanged();
  }
  
  public void wr(int paramInt)
  {
    this.bnn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoj
 * JD-Core Version:    0.7.0.1
 */