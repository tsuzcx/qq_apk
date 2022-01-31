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

public class vyh
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  View.OnTouchListener a;
  protected QQStoryContext a;
  protected List<QQUserUIItem> a;
  protected wna a;
  
  public vyh(Context paramContext, View.OnTouchListener paramOnTouchListener)
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
  
  public void a(wna paramwna)
  {
    this.jdField_a_of_type_Wna = paramwna;
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
        i = 2131561630;
        paramView = new wph(paramView.inflate(i, null));
        paramViewGroup = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject = (TextView)paramView.a(2131371142);
        String str = paramViewGroup.getUserIconUrl();
        if (TextUtils.isEmpty(str)) {
          break label249;
        }
        if (QLog.isColorLevel()) {
          QLog.w("zivonchen", 2, "fillFriendsData userIconUrl = " + str);
        }
        vhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (TextView)localObject, str, 13.0F, 2.0F);
        label127:
        ((TextView)localObject).setText(vhj.a(paramViewGroup));
        localObject = (ImageView)paramView.a(2131367555);
        if ((!paramViewGroup.isVip) || (!ndd.a(paramViewGroup.headUrl))) {
          break label267;
        }
        xod.a((ImageView)localObject, paramViewGroup.headUrl, 38, 38, 1);
      }
    }
    for (;;)
    {
      paramView.a = paramViewGroup;
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        paramView.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      paramView.a().setOnClickListener(paramView);
      if (this.jdField_a_of_type_Wna != null) {
        paramView.a(this.jdField_a_of_type_Wna);
      }
      return paramView.a();
      i = this.jdField_a_of_type_Int;
      break;
      paramView = (wph)paramView.getTag();
      break label39;
      label249:
      ((TextView)localObject).setCompoundDrawablePadding(0);
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      break label127;
      label267:
      if (!TextUtils.isEmpty(paramViewGroup.qq)) {
        vhj.a((ImageView)localObject, paramViewGroup.qq);
      } else {
        ((ImageView)localObject).setImageDrawable(bdda.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vyh
 * JD-Core Version:    0.7.0.1
 */