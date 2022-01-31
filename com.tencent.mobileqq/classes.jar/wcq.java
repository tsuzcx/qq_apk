import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class wcq
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  View.OnTouchListener a;
  protected QQStoryContext a;
  protected List<QQUserUIItem> a;
  protected wrj a;
  
  public wcq(Context paramContext, View.OnTouchListener paramOnTouchListener)
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
  
  public void a(wrj paramwrj)
  {
    this.jdField_a_of_type_Wrj = paramwrj;
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
    int i;
    label39:
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Int == -1)
      {
        i = 2131561648;
        paramView = new wtq(paramView.inflate(i, null));
        paramViewGroup = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject = (TextView)paramView.a(2131371161);
        String str = paramViewGroup.getUserIconUrl();
        if (TextUtils.isEmpty(str)) {
          break label249;
        }
        if (QLog.isColorLevel()) {
          QLog.w("zivonchen", 2, "fillFriendsData userIconUrl = " + str);
        }
        vls.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (TextView)localObject, str, 13.0F, 2.0F);
        label127:
        ((TextView)localObject).setText(vls.a(paramViewGroup));
        localObject = (ImageView)paramView.a(2131367565);
        if ((!paramViewGroup.isVip) || (!ndd.a(paramViewGroup.headUrl))) {
          break label267;
        }
        xsm.a((ImageView)localObject, paramViewGroup.headUrl, 38, 38, 1);
      }
    }
    for (;;)
    {
      paramView.a = paramViewGroup;
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        paramView.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      paramView.a().setOnClickListener(paramView);
      if (this.jdField_a_of_type_Wrj != null) {
        paramView.a(this.jdField_a_of_type_Wrj);
      }
      return paramView.a();
      i = this.jdField_a_of_type_Int;
      break;
      paramView = (wtq)paramView.getTag();
      break label39;
      label249:
      ((TextView)localObject).setCompoundDrawablePadding(0);
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      break label127;
      label267:
      if (!TextUtils.isEmpty(paramViewGroup.qq)) {
        vls.a((ImageView)localObject, paramViewGroup.qq);
      } else {
        ((ImageView)localObject).setImageDrawable(bdhj.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcq
 * JD-Core Version:    0.7.0.1
 */