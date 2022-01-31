import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class tzw
  extends tzk
  implements View.OnClickListener
{
  final Button jdField_a_of_type_AndroidWidgetButton;
  final ImageView jdField_a_of_type_AndroidWidgetImageView;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  List<QQUserUIItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  final tzq jdField_a_of_type_Tzq;
  final ImageView jdField_b_of_type_AndroidWidgetImageView;
  final TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public tzw(View paramView, tzq paramtzq)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Tzq = paramtzq;
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311324));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311351));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306252));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131310852));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131304194));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302199));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (sqs)sqg.a(2);
    Object localObject2 = new ArrayList();
    int j = Math.min(paramList.size(), 6);
    int i = 0;
    if (i < j)
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = ((sqs)localObject1).b(str);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl))) {
        this.jdField_a_of_type_JavaUtilList.add(localQQUserUIItem);
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject2).add(new srn("", str));
      }
    }
    if (!((List)localObject2).isEmpty()) {
      new sxp(1, (List)localObject2).a();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    j = 0;
    label181:
    label193:
    int m;
    if (j < k)
    {
      if (j != 0) {
        break label274;
      }
      i = -1;
      paramList = this.jdField_a_of_type_Tzq.jdField_a_of_type_AndroidContentContext;
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      localObject2 = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(j);
      m = this.jdField_a_of_type_Tzq.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount;
      if (this.jdField_a_of_type_Tzq.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount <= 6) {
        break label292;
      }
    }
    label274:
    label292:
    for (boolean bool = true;; bool = false)
    {
      txl.a(paramList, (LinearLayout)localObject1, 34, (QQUserUIItem)localObject2, i, m, bool);
      j += 1;
      break label181;
      break;
      if (j == k - 1)
      {
        i = 1;
        break label193;
      }
      i = 0;
      break label193;
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Tzq.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
      return;
    }
    paramView = this.jdField_a_of_type_Tzq.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.name);
    if (paramView.type == 1)
    {
      paramVideoCollectionItem = ajjy.a(2131648135);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845720);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView.backgroundUrl)) {
        vms.a(this.jdField_b_of_type_AndroidWidgetImageView, paramView.backgroundUrl, 0, 0, null);
      }
      if (paramView.headerUnionIdList != null) {
        paramView.memberCount = Math.max(paramView.headerUnionIdList.size(), paramView.memberCount);
      }
      paramVideoCollectionItem = paramVideoCollectionItem + " · " + paramView.memberCount + ajjy.a(2131648137);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVideoCollectionItem);
      a(paramView.headerUnionIdList);
      return;
      paramVideoCollectionItem = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131310852: 
      this.jdField_a_of_type_Tzq.jdField_a_of_type_Uaa.a(this.jdField_a_of_type_AndroidWidgetButton);
      return;
    case 2131304194: 
      this.jdField_a_of_type_Tzq.jdField_a_of_type_Uaa.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    }
    this.jdField_a_of_type_Tzq.jdField_a_of_type_Uaa.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzw
 * JD-Core Version:    0.7.0.1
 */