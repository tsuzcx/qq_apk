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

public class wzh
  extends wzd
{
  public wzh(ViewGroup paramViewGroup, int paramInt)
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
      str = anzj.a(2131712804);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      localObject = (yaz)wth.a(24);
      i = this.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDimensionPixelSize(2131298448);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((yaz)localObject).a());
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
      localObject = ((yaz)localObject).a(paramShareGroupItem.headerUnionIdList, str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while (!QLog.isColorLevel());
    label131:
    paramShareGroupItem = new StringBuilder("nickname = ").append(str).append(", headerUnionIdList = ").append(paramShareGroupItem.headerUnionIdList);
    QLog.e("zivonxxx", 2, "ShareGroupViewHolder: " + paramShareGroupItem.toString());
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    this.itemView.setTag(paramwvn.a);
    ShareGroupItem localShareGroupItem = ((ydc)wth.a(7)).a(paramwvn.a);
    a(localShareGroupItem);
    if (localShareGroupItem == null) {
      new xab(paramwvn.a, String.valueOf(System.currentTimeMillis())).a();
    }
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "ShareGroupViewHolder groupItem = " + localShareGroupItem + ", unionId = " + paramwvn.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzh
 * JD-Core Version:    0.7.0.1
 */