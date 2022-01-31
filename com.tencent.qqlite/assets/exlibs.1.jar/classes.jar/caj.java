import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.lbs.member_lbs.NeighbourNumber;
import tencent.im.lbs.member_lbs.RspBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.AppBrief;

public class caj
  extends BizTroopObserver
{
  public caj(TroopChatPie paramTroopChatPie) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo != null) && (TroopChatPie.y(this.a).jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString))) {
      TroopChatPie.a(this.a, paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo, true);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (TroopChatPie.a(this.a) != null) {
      TroopChatPie.b(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, List paramList)
  {
    if (ChatActivityUtils.a(TroopChatPie.C(this.a).jdField_a_of_type_JavaLangString, TroopChatPie.h(this.a).a()) != null) {}
    do
    {
      return;
      paramString = new ArrayList();
      paramString.add(Long.valueOf(1L));
      paramString.add(Long.valueOf(2L));
      paramString.add(Long.valueOf(1101236949L));
      paramString.add(Long.valueOf(1101484419L));
      paramString.add(Long.valueOf(1102858908L));
      if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          paramString.add(Long.valueOf(((oidb_0x8cf.AppBrief)paramList.next()).opt_uint64_appid.get()));
        }
      }
      paramList = (TroopHandler)TroopChatPie.i(this.a).a(17);
    } while (paramList == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "send_oidb_0x8c9_2, appIds : " + paramString);
    }
    paramList.a(TroopChatPie.D(this.a).jdField_a_of_type_JavaLangString, paramString);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!TroopChatPie.g(this.a).isResume()) {}
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    long l = ((Long)paramObject).longValue();
    if ((TroopChatPie.w(this.a).jdField_a_of_type_Int == 1) && (TroopChatPie.x(this.a).jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
      TroopChatPie.a(this.a);
    }
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      paramObject = (member_lbs.RspBody)paramObject;
      Object localObject = (member_lbs.NeighbourNumber)paramObject.msg_neighbour_number.get();
      long l2 = ((member_lbs.NeighbourNumber)localObject).uint64_group_code.get();
      try
      {
        long l1 = Long.parseLong(TroopChatPie.z(this.a).jdField_a_of_type_JavaLangString);
        l2 = Long.valueOf(l2).longValue();
        if (l1 == l2)
        {
          if (((member_lbs.NeighbourNumber)localObject).uint64_neighbour_number.get() > 0L) {
            this.a.a(TroopChatPie.A(this.a).jdField_a_of_type_JavaLangString, ((member_lbs.NeighbourNumber)localObject).uint64_neighbour_number.get());
          }
          if (paramObject.bool_show_tips.get())
          {
            try
            {
              localObject = new String(paramObject.str_tips_wording.get().toByteArray(), "UTF-8");
              paramObject = new String(paramObject.str_tips_web_url.get().toByteArray(), "UTF-8");
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
                continue;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(TroopChatPie.g(this.a), TroopChatPie.f(this.a), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, TroopChatPie.B(this.a).jdField_a_of_type_JavaLangString, (String)localObject, paramObject);
              return;
            }
            catch (UnsupportedEncodingException paramObject)
            {
              return;
            }
            if (!QLog.isColorLevel()) {}
          }
        }
      }
      catch (NumberFormatException paramObject) {}
    }
    QLog.d("TroopChatPie", 2, "onGetNearbyTroopMemberCount NumberFormatException", paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     caj
 * JD-Core Version:    0.7.0.1
 */