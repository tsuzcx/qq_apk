import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopSearchLogicActivity;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class enj
  extends Handler
{
  public enj(TroopSearchLogicActivity paramTroopSearchLogicActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool;
    if (paramMessage.what == 1)
    {
      this.a.c();
      int i = paramMessage.arg1;
      if (paramMessage.arg2 != 1) {
        break label183;
      }
      bool = true;
      paramMessage = (List)paramMessage.obj;
      if ((paramMessage == null) || (paramMessage.size() != 1)) {
        break label188;
      }
      paramMessage = (SearchGroup.GroupInfo)paramMessage.get(0);
      paramMessage = TroopInfoActivity.a(6, String.valueOf(paramMessage.dwGroupCode.get()), "", paramMessage.sGroupName.get(), String.valueOf(paramMessage.dwGroupOwnerId.get()), "", (byte)SearchTroopListActivity.a(paramMessage), paramMessage.dwGroupFlagExt.get(), (short)paramMessage.dwGroupFaceId.get(), paramMessage.sGroupFingerMem.get(), paramMessage.sGroupLocation.get(), paramMessage.bGroupIn.get(), null, paramMessage.dwGroupFlagExt.get(), paramMessage.dwAuthGroupType.get(), this.a.jdField_d_of_type_Int);
      ChatSettingForTroop.a(this.a, paramMessage, 2);
    }
    for (;;)
    {
      this.a.finish();
      return;
      label183:
      bool = false;
      break;
      label188:
      if ((paramMessage != null) && (paramMessage.size() > 1)) {
        SearchTroopListActivity.a(this.a, this.a.jdField_d_of_type_JavaLangString, paramMessage, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     enj
 * JD-Core Version:    0.7.0.1
 */