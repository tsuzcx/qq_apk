import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;

public class wvm
  extends wvi
{
  public wvm(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a(ShareGroupItem paramShareGroupItem)
  {
    String str;
    Object localObject;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramShareGroupItem == null) || (TextUtils.isEmpty(paramShareGroupItem.getName())))
    {
      str = anni.a(2131712695);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      localObject = (xxe)wpm.a(24);
      i = this.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDimensionPixelSize(2131298435);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null) {
        break label116;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      label91:
      if (paramShareGroupItem != null) {
        break label131;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((xxe)localObject).a());
    }
    label116:
    do
    {
      return;
      str = paramShareGroupItem.getName();
      break;
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      break label91;
      localObject = ((xxe)localObject).a(paramShareGroupItem.headerUnionIdList, str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while (!QLog.isColorLevel());
    label131:
    paramShareGroupItem = new StringBuilder("nickname = ").append(str).append(", headerUnionIdList = ").append(paramShareGroupItem.headerUnionIdList);
    QLog.e("zivonxxx", 2, "ShareGroupViewHolder: " + paramShareGroupItem.toString());
  }
  
  public void a(wrs paramwrs)
  {
    super.a(paramwrs);
    this.itemView.setTag(paramwrs.a);
    ShareGroupItem localShareGroupItem = ((xzh)wpm.a(7)).a(paramwrs.a);
    a(localShareGroupItem);
    if (localShareGroupItem == null) {
      new wwg(paramwrs.a, String.valueOf(System.currentTimeMillis())).a();
    }
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "ShareGroupViewHolder groupItem = " + localShareGroupItem + ", unionId = " + paramwrs.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvm
 * JD-Core Version:    0.7.0.1
 */