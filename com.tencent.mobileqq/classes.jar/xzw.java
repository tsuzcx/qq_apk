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

public class xzw
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  View.OnTouchListener a;
  protected QQStoryContext a;
  protected List<QQUserUIItem> a;
  protected yop a;
  
  public xzw(Context paramContext, View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = QQStoryContext.a();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void a(yop paramyop)
  {
    this.jdField_a_of_type_Yop = paramyop;
  }
  
  public void b(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Int == -1)
      {
        i = 2131561923;
        localObject1 = new yqw(((LayoutInflater)localObject1).inflate(i, null));
        localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject2 = (TextView)((yqw)localObject1).a(2131371827);
        String str = localQQUserUIItem.getUserIconUrl();
        if (TextUtils.isEmpty(str)) {
          break label286;
        }
        if (QLog.isColorLevel()) {
          QLog.w("zivonchen", 2, "fillFriendsData userIconUrl = " + str);
        }
        xiz.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (TextView)localObject2, str, 13.0F, 2.0F);
        label133:
        ((TextView)localObject2).setText(xiz.a(localQQUserUIItem));
        localObject2 = (ImageView)((yqw)localObject1).a(2131367946);
        if ((!localQQUserUIItem.isVip) || (!nnr.a(localQQUserUIItem.headUrl))) {
          break label304;
        }
        zps.a((ImageView)localObject2, localQQUserUIItem.headUrl, 38, 38, 1);
      }
    }
    for (;;)
    {
      ((yqw)localObject1).a = localQQUserUIItem;
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        ((yqw)localObject1).a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      ((yqw)localObject1).a().setOnClickListener((View.OnClickListener)localObject1);
      if (this.jdField_a_of_type_Yop != null) {
        ((yqw)localObject1).a(this.jdField_a_of_type_Yop);
      }
      localObject1 = ((yqw)localObject1).a();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      i = this.jdField_a_of_type_Int;
      break;
      localObject1 = (yqw)paramView.getTag();
      break label42;
      label286:
      ((TextView)localObject2).setCompoundDrawablePadding(0);
      ((TextView)localObject2).setCompoundDrawables(null, null, null, null);
      break label133;
      label304:
      if (!TextUtils.isEmpty(localQQUserUIItem.qq)) {
        xiz.a((ImageView)localObject2, localQQUserUIItem.qq);
      } else {
        ((ImageView)localObject2).setImageDrawable(bhmq.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzw
 * JD-Core Version:    0.7.0.1
 */