import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class aiq
  implements Runnable
{
  public aiq(long paramLong, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, Activity paramActivity, int paramInt, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    Object localObject3 = null;
    int i = 1;
    int k = 0;
    int j = 0;
    Object localObject2;
    label80:
    FriendManager localFriendManager;
    if (1L == this.jdField_a_of_type_Long)
    {
      if (SystemUtil.a()) {}
      for (Object localObject1 = AppConstants.aF;; localObject1 = SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/")
      {
        localObject1 = (String)localObject1 + "default_discussion_icon.png";
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists()) {
          break;
        }
        i = 1;
        if (i != 0) {
          break label622;
        }
        localObject2 = "";
        AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a("推荐讨论组：" + this.jdField_a_of_type_JavaLangString).e(this.b).a("邀请加入讨论组", null).a();
        localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject1 = localObject3;
        if (localFriendManager != null)
        {
          localObject1 = localFriendManager.a(this.c);
          localObject3 = localFriendManager.a(this.c, ((DiscussionInfo)localObject1).ownerUin);
          if (localObject3 == null) {
            break label580;
          }
          localObject1 = ContactUtils.a((DiscussionMemberInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        label207:
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = "创建者信息获取失败";
        }
        localObject1 = StructMsgElementFactory.a(2);
        ((AbsStructMsgItem)localObject1).a((String)localObject2, this.jdField_a_of_type_JavaLangString, "创建人：" + (String)localObject3);
        localAbsShareMsg.addItem((AbsStructMsgElement)localObject1);
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        ((Intent)localObject1).putExtra("forward_type", -3);
        ((Intent)localObject1).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, this.jdField_a_of_type_Int);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        return;
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        ((File)localObject2).createNewFile();
        bool = ((BitmapDrawable)ImageUtil.d()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream((File)localObject2));
        if (!bool) {
          break label637;
        }
        i = 1;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel()) {
          localIOException1.printStackTrace();
        }
        str1 = null;
        i = j;
      }
      break;
      if (SystemUtil.a()) {}
      for (String str1 = AppConstants.aF;; str1 = SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/")
      {
        str1 = str1 + "default_discussion_icon.png";
        localObject2 = new File(str1);
        if (!((File)localObject2).exists()) {
          break label517;
        }
        i = 1;
        break;
      }
      for (;;)
      {
        try
        {
          label517:
          ((File)localObject2).createNewFile();
          bool = ((BitmapDrawable)ImageUtil.d()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream((File)localObject2));
          if (!bool) {
            break label629;
          }
        }
        catch (IOException localIOException2)
        {
          if (QLog.isColorLevel()) {
            localIOException2.printStackTrace();
          }
          str2 = null;
          i = k;
        }
        break;
        label580:
        if (localFriendManager.b(str2.ownerUin))
        {
          str2 = localFriendManager.c(str2.ownerUin);
          break label207;
        }
        str2 = str2.ownerUin;
        break label207;
        label622:
        localObject2 = str2;
        break label80;
        label629:
        str2 = null;
        i = 0;
      }
      label637:
      String str2 = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aiq
 * JD-Core Version:    0.7.0.1
 */