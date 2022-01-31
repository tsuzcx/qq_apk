import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class tyc
  extends TroopObserver
{
  public tyc(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(String paramString, boolean paramBoolean, List paramList)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.a.app.getManager(51)).a(paramString);
    paramString = new Message();
    paramString.what = 8;
    Bundle localBundle = paramString.getData();
    if (localTroopInfo != null)
    {
      localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)localTroopInfo.mTroopPicList);
      paramList = localTroopInfo.mTroopVerifyingPics;
      if (paramList != null) {
        localBundle.putStringArray("VERIFYING_PICTURE_LIST", (String[])paramList.toArray(new String[paramList.size()]));
      }
    }
    for (;;)
    {
      localBundle.putBoolean("IS_DEFAULT_AVATAR", paramBoolean);
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      return;
      localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)paramList);
    }
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (paramTroopInfo == null) || (!Utils.a(paramTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onTroopSearch|result = " + paramByte + ", p = " + paramTroopInfo);
      }
    } while (paramByte != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong))) {}
    do
    {
      do
      {
        return;
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
          }
          if (paramBoolean)
          {
            this.a.a(2131433503, 2);
            return;
          }
          this.a.a(2131433504, 1);
          TroopInfoActivity.a(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.o();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 4) {}
    while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      TroopInfoActivity.f(this.a);
      return;
    }
    this.a.a(2131434464, 1);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin = paramTroopInfo.troopowneruin;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname = paramTroopInfo.troopname;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopface = paramTroopInfo.troopface;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmemo = paramTroopInfo.troopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.strLocation = paramTroopInfo.strLocation;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopLat = paramTroopInfo.troopLat;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopLon = paramTroopInfo.troopLon;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = paramTroopInfo.isNewTroop;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTags = paramTroopInfo.mTags;
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo)) {
        break label494;
      }
    }
    for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = HttpUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo))
    {
      this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a.app.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_Int != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ThreadManager.post(new tyd(this, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo), 8, null, true);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.post(new tye(this));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
      label494:
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = HttpUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.a.app.getManager(51)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramString, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    this.a.jdField_c_of_type_Int = paramInt1;
    this.a.d = paramInt2;
    this.a.e = paramInt3;
    if ((this.a.jdField_c_of_type_Int == 1) || (this.a.jdField_c_of_type_Int == 2)) {
      this.a.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4).edit().remove("has_shown_tips").commit();
    }
    if (this.a.jdField_c_of_type_Int == 2)
    {
      paramString = paramGroupInfo.string_group_name.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
        this.a.a(3, paramString, true);
      }
      paramString = paramGroupInfo.group_geo_info.bytes_geocontent.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString)) {
        this.a.a(5, paramString, true);
      }
      paramString = GroupCatalogTool.a(BaseApplication.getContext()).a(this.a, Long.toString(paramGroupInfo.uint32_group_class_ext.get()));
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
        this.a.a(4, paramString.a(), true);
      }
      paramString = TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get());
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
        paramString = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.a.a(8, paramString, true, 2, true);
      }
      paramString = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = paramString;
        this.a.a(6, paramString, true);
      }
    }
    TroopInfoActivity.e(this.a);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    boolean bool = true;
    if (this.a.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
      if (paramInt1 == 0)
      {
        if (paramInt2 == 0) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          a(paramString1, paramBoolean, paramList);
          return;
        }
      }
      if (paramString2 != null)
      {
        QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
        return;
      }
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        QQToast.a(this.a, this.a.getString(2131430225), 1).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt1 == 19)
      {
        QQToast.a(this.a, this.a.getString(2131430226), 1).b(this.a.getTitleBarHeight());
        return;
      }
    } while (paramInt1 != 65);
    QQToast.a(this.a, this.a.getString(2131430227), 1).b(this.a.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTags = paramString;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt1 == 0)
    {
      a(paramString1, false, paramList);
      return;
    }
    if (paramString2 != null)
    {
      a(paramString1, false, paramList);
      QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 1)
    {
      QQToast.a(this.a, this.a.getString(2131430225), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 2)
    {
      QQToast.a(this.a, this.a.getString(2131430226), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 3)
    {
      QQToast.a(this.a, this.a.getString(2131430229), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 4)
    {
      QQToast.a(this.a, this.a.getString(2131430230), 1).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, this.a.getString(2131430231), 1).b(this.a.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    Object localObject;
    do
    {
      return;
      int i = 0;
      localObject = null;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(localObject, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tyc
 * JD-Core Version:    0.7.0.1
 */