import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class alj
  implements DragSortListView.RemoveListener
{
  public alj(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!NetworkUtil.e(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).a(2130837962);
      ((QQToast)localObject).c(1500);
      ((QQToast)localObject).a("无网络连接，删除失败");
      ((QQToast)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_Int = 0;
    this.a.b = 1;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131364040));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ((EmosmHandler)this.a.app.a(11)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alj
 * JD-Core Version:    0.7.0.1
 */