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
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public final class cns
  implements Runnable
{
  public cns(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Activity paramActivity, String paramString3, String paramString4, int paramInt, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    Object localObject4 = null;
    Object localObject3;
    int i;
    label70:
    FriendManager localFriendManager;
    if (1L == this.jdField_a_of_type_Long)
    {
      if (SystemUtil.a()) {}
      for (Object localObject1 = AppConstants.ay;; localObject1 = SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/")
      {
        localObject1 = (String)localObject1 + "default_discussion_icon.png";
        localObject3 = new File((String)localObject1);
        if (!((File)localObject3).exists()) {
          break;
        }
        i = 1;
        if (i != 0) {
          break label548;
        }
        localObject3 = "";
        AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131559046, new Object[] { this.c })).c(this.d).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131559047), null).a();
        localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject1 = localObject4;
        if (localFriendManager != null)
        {
          localObject1 = localFriendManager.a(this.jdField_a_of_type_JavaLangString);
          localObject4 = localFriendManager.a(this.jdField_a_of_type_JavaLangString, ((DiscussionInfo)localObject1).ownerUin);
          if (localObject4 == null) {
            break label511;
          }
          localObject1 = ContactUtils.a((DiscussionMemberInfo)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        label198:
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject4 = this.jdField_a_of_type_AndroidAppActivity.getString(2131559048);
        }
        localObject1 = StructMsgElementFactory.a(2);
        ((AbsStructMsgItem)localObject1).a((String)localObject3, this.c, this.jdField_a_of_type_AndroidAppActivity.getString(2131559049, new Object[] { localObject4 }));
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
      try
      {
        ((File)localObject3).createNewFile();
        boolean bool = ((BitmapDrawable)ImageUtil.c()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream((File)localObject3));
        if (!bool) {
          break label566;
        }
        i = 1;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
        localObject2 = null;
        i = 0;
      }
      break;
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(101, this.jdField_a_of_type_JavaLangString));
      localObject2 = QZoneShareManager.a((ArrayList)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.b, "1");
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = (String)((ArrayList)localObject2).get(0);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://"))))
        {
          i = 1;
          break;
          label511:
          if (localFriendManager.b(((DiscussionInfo)localObject2).ownerUin))
          {
            localObject2 = localFriendManager.c(((DiscussionInfo)localObject2).ownerUin);
            break label198;
          }
          localObject2 = ((DiscussionInfo)localObject2).ownerUin;
          break label198;
          label548:
          localObject3 = localObject2;
          break label70;
        }
        i = 0;
        break;
      }
      localObject2 = null;
      i = 0;
      break;
      label566:
      localObject2 = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cns
 * JD-Core Version:    0.7.0.1
 */