import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.maproam.RoamMapController;
import com.tencent.mobileqq.maproam.data.PersonalInfo;
import java.util.ArrayList;
import java.util.Arrays;

public class gft
  extends LBSObserver
{
  public gft(RoamMapController paramRoamMapController, int paramInt, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean1, String arg2, int paramInt1, RespGetEncounterV2 paramRespGetEncounterV2, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramBoolean1) {
      if (paramRespGetEncounterV2 == null) {
        break label198;
      }
    }
    label198:
    for (paramRespGetEncounterV2 = paramRespGetEncounterV2.vEncounterInfos;; paramRespGetEncounterV2 = null)
    {
      if ((paramRespGetEncounterV2 != null) && (!paramRespGetEncounterV2.isEmpty()))
      {
        paramInt3 = paramRespGetEncounterV2.size();
        paramInt1 = Math.min(this.jdField_a_of_type_Int, paramInt3);
        paramInt2 = 0;
        if ((paramInt2 < paramInt1) && (paramInt2 < paramInt3))
        {
          RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramRespGetEncounterV2.get(paramInt2);
          String str = String.valueOf(localRespEncounterInfo.lEctID);
          if (???.equals(str)) {
            paramInt1 += 1;
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            PersonalInfo localPersonalInfo = new PersonalInfo();
            localPersonalInfo.lEctID = str;
            localPersonalInfo.uid = localRespEncounterInfo.uid;
            localPersonalInfo.enc_id = localRespEncounterInfo.enc_id;
            localPersonalInfo.seg = Arrays.toString(localRespEncounterInfo.sig);
            this.jdField_a_of_type_JavaUtilArrayList.add(localPersonalInfo);
          }
        }
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqMaproamRoamMapController.a)
      {
        this.jdField_a_of_type_ComTencentMobileqqMaproamRoamMapController.a.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gft
 * JD-Core Version:    0.7.0.1
 */