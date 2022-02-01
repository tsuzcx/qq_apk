import android.app.Activity;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;

@Deprecated
public class ugv
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  public Activity a;
  private bjng jdField_a_of_type_Bjng;
  public ShareActionSheetBuilder a;
  private ugw jdField_a_of_type_Ugw;
  protected ugx a;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      yyi.a(1, 2131694801);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null) {
        a((String)paramMessage.obj);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (localObject != null)
      {
        bool = true;
        QLog.d("ReadInJoyShareHelper", 2, bool);
      }
    }
    else
    {
      if (localObject != null) {
        break label73;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      bool = false;
      break;
      label73:
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      localObject = (ugy)((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem;
      int i = ((ugy)localObject).action;
      if (this.jdField_a_of_type_Ugw != null) {
        if (((ugy)localObject).a)
        {
          this.jdField_a_of_type_Ugw.a(Integer.valueOf(i));
        }
        else
        {
          localObject = this.jdField_a_of_type_Ugx.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_Ugw.a((Integer)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugv
 * JD-Core Version:    0.7.0.1
 */