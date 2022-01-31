import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.activity.FriendProfileImagePortraits;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class apt
  extends TransProcessorHandler
{
  public apt(FriendProfileImagePortraits paramFriendProfileImagePortraits) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    Object localObject = localFileMsg.c;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (FriendProfileImagePortraits.a(this.a) != null)) {}
    for (localObject = (FriendProfileImageModel.ProfileImageInfo)FriendProfileImagePortraits.a(this.a).get(HexUtil.b((String)localObject));; localObject = null)
    {
      if (localObject == null) {
        label56:
        return;
      }
      if (Utils.a(localFileMsg.jdField_e_of_type_JavaLangString, ((FriendProfileImageModel.ProfileImageInfo)localObject).d)) {
        switch (localFileMsg.B)
        {
        case 0: 
        default: 
        case 2001: 
        case 2002: 
          label128:
          while (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.PhotoWall", 2, "transfer:" + ((FriendProfileImageModel.ProfileImageInfo)localObject).b + ", status:" + paramMessage.what + ", picScale = " + localFileMsg.ab);
            return;
            ((FriendProfileImageModel.ProfileImageInfo)localObject).i = 0;
            ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 4;
            this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
            continue;
            if (localFileMsg.a <= 0L) {
              break label476;
            }
          }
        }
      }
      label476:
      for (i = (int)(localFileMsg.jdField_e_of_type_Long * 100L / localFileMsg.a);; i = 0)
      {
        ((FriendProfileImageModel.ProfileImageInfo)localObject).i = i;
        ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 4;
        this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
        break label128;
        ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 6;
        ((FriendProfileImageModel.ProfileImageInfo)localObject).a = false;
        this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
        break label128;
        ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 5;
        this.a.d((FriendProfileImageModel.ProfileImageInfo)localObject);
        break label128;
        if (!Utils.a(localFileMsg.jdField_e_of_type_JavaLangString, ((FriendProfileImageModel.ProfileImageInfo)localObject).c)) {
          break label128;
        }
        switch (localFileMsg.B)
        {
        case 0: 
        default: 
          break;
        case 2001: 
          ((FriendProfileImageModel.ProfileImageInfo)localObject).i = 0;
          ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 1;
          this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
          break;
        case 2002: 
          if (localFileMsg.a > 0L) {
            i = (int)(localFileMsg.jdField_e_of_type_Long * 100L / localFileMsg.a);
          }
          ((FriendProfileImageModel.ProfileImageInfo)localObject).i = i;
          ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 1;
          this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
          break;
        case 2003: 
          ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 3;
          this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
          this.a.e((FriendProfileImageModel.ProfileImageInfo)localObject);
          break;
        case 2005: 
          ((FriendProfileImageModel.ProfileImageInfo)localObject).h = 2;
          this.a.c((FriendProfileImageModel.ProfileImageInfo)localObject);
          break;
          break label56;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     apt
 * JD-Core Version:    0.7.0.1
 */