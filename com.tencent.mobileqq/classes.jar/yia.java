import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class yia
  implements Runnable
{
  public yia(long paramLong, int paramInt, View paramView, ApolloRender paramApolloRender) {}
  
  public void run()
  {
    try
    {
      ApolloRender.access$002(this.jdField_a_of_type_Long);
      Intent localIntent;
      if (this.jdField_a_of_type_Int == 0)
      {
        localIntent = new Intent("android.intent.action.PICK");
        localIntent.setType("image/*");
        ((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).startActivityForResult(localIntent, 14006);
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        localIntent = new Intent();
        localIntent.setAction("android.media.action.IMAGE_CAPTURE");
        localIntent.addCategory("android.intent.category.DEFAULT");
        ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
        ApolloRender.access$102(new File(ApolloRender.CMSHOW_FILE_PATH));
        localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
        ApolloRender.access$100().createNewFile();
        localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
        localIntent.putExtra("output", Uri.fromFile(ApolloRender.access$100()));
        ((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).startActivityForResult(localIntent, 14005);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloRender", 2, "imageselector  fail e=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yia
 * JD-Core Version:    0.7.0.1
 */