import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class dhe
  extends TroopObserver
{
  boolean jdField_a_of_type_Boolean = false;
  
  public dhe(FMActivity paramFMActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    label185:
    label243:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_Boolean = false;
            } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_d_of_type_JavaLangString == null);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder(150);
              ((StringBuilder)localObject1).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
              QLog.i("FMActivity<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
            }
          } while ((paramInt1 != 2) || (!paramBoolean));
          localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.app.getManager(44);
        } while (((TroopManager)localObject1).a(String.valueOf(paramLong1)));
        paramString = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_d_of_type_JavaLangString);
      } while ((paramString == null) || (StringUtil.b(paramString.troopowneruin)));
      paramString.Administrator = "";
      Object localObject2;
      if (paramList == null)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        if (paramInt2 >= paramInt1) {
          break label326;
        }
        localObject2 = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
          break label243;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label185;
        paramInt1 = paramList.size();
        break;
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!paramString.troopowneruin.equals(((String)localObject2).trim()))) {
          paramString.Administrator = (paramString.Administrator + (String)localObject2 + "|");
        }
      }
      ((TroopManager)localObject1).b(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FMActivity<FileAssistant>", 2, paramString.Administrator);
      }
      if ((paramString.troopPrivilegeFlag & 0x2) == 2L) {
        break;
      }
      paramInt1 = 1;
      paramList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.app.a();
    } while ((paramString.isTroopAdmin(paramList)) || (paramString.isTroopOwner(paramList)) || (paramInt1 != 0));
    label326:
    paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.app;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_d_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_d_of_type_Boolean) {}
    for (paramList = "0";; paramList = "1")
    {
      ReportController.b(paramString, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, (String)localObject1, paramList, "", "");
      FMActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    StringBuilder localStringBuilder = new StringBuilder(150);
    localStringBuilder.append("onTroopPrivilege").append("| isSuccess = ").append(paramBoolean1).append("| isAdmin = ").append(paramBoolean2).append("| isAllUser_Photo = ").append(paramBoolean3).append("| isAllUser_File = ").append(paramBoolean4);
    if (QLog.isColorLevel()) {
      QLog.i("FMActivity<FileAssistant>", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (!paramBoolean4))
    {
      this.jdField_a_of_type_Boolean = true;
      FMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhe
 * JD-Core Version:    0.7.0.1
 */