import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class vnb
  extends BroadcastReceiver
{
  public vnb(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("light_reply_count_changed".equals(paramIntent.getAction()))
    {
      paramContext = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a;
      if ((paramContext instanceof AIOImageData))
      {
        paramContext = (AIOImageData)paramContext;
        QLog.d("AIOGalleryScene", 2, "replyPhotoBtn: isAIOImageData true, isPicFile: " + paramContext.jdField_g_of_type_Boolean + " isFromImageList: false");
        paramIntent = paramIntent.getExtras();
        this.a.a(paramIntent, paramContext.b, paramContext.jdField_g_of_type_JavaLangString, paramContext.f, paramContext.jdField_e_of_type_Long, paramContext.jdField_e_of_type_JavaLangString);
        if (1 == paramIntent.getInt("type"))
        {
          paramContext = (LightReplyEmojs)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramContext.b + paramContext.jdField_g_of_type_JavaLangString + paramContext.jdField_e_of_type_Long);
          if (paramContext != null) {
            this.a.a(this.a.b, paramContext);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnb
 * JD-Core Version:    0.7.0.1
 */