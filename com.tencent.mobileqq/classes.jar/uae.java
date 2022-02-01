import android.app.Activity;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;

@Deprecated
public class uae
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  public Activity a;
  private bkgm jdField_a_of_type_Bkgm;
  public ShareActionSheetBuilder a;
  private uaf jdField_a_of_type_Uaf;
  protected uag a;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zvc.a(1, 2131694643);
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
      localObject = (uah)((bgsa)localObject).a;
      int i = ((uah)localObject).action;
      if (this.jdField_a_of_type_Uaf != null) {
        if (((uah)localObject).a)
        {
          this.jdField_a_of_type_Uaf.a(Integer.valueOf(i));
        }
        else
        {
          localObject = this.jdField_a_of_type_Uag.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_Uaf.a((Integer)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uae
 * JD-Core Version:    0.7.0.1
 */