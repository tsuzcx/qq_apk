import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity.22.1;
import com.tencent.mobileqq.activity.TroopInfoActivity.22.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class vzm
  extends acnd
{
  public vzm(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!aqft.equalsWithNullCheck(paramString, this.this$0.a.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.this$0.app.getManager(52)).b(paramString);
    } while (paramString == null);
    this.this$0.b = paramString;
    this.this$0.a.updateForTroopInfo(paramString, this.this$0.app.getCurrentAccountUin());
    this.this$0.handler.sendEmptyMessage(4);
  }
  
  protected void T(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.this$0.b != null) {
        this.this$0.b.mTags = paramString;
      }
      if (this.this$0.a != null) {
        this.this$0.a.troopTags = TroopInfo.getTags(paramString);
      }
      this.this$0.handler.sendEmptyMessage(6);
    }
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (paramTroopInfo == null) || (!aqft.equalsWithNullCheck(paramTroopInfo.troopuin, this.this$0.a.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onTroopSearch|result = " + paramByte + ", p = " + paramTroopInfo);
      }
    } while (paramByte != 0);
    this.this$0.b = paramTroopInfo;
    this.this$0.a.updateForTroopInfo(paramTroopInfo, this.this$0.app.getCurrentAccountUin());
    this.this$0.handler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (!aqft.equalsWithNullCheck(this.this$0.a.troopUin, String.valueOf(paramLong))) {}
    do
    {
      do
      {
        return;
        if ((this.this$0.qy != null) && (this.this$0.qy.contains(Integer.valueOf(paramInt))))
        {
          this.this$0.qy.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.this$0.b = paramTroopInfo;
          }
          if (paramBoolean)
          {
            this.this$0.cf(2131694967, 2);
            return;
          }
          this.this$0.cf(2131694966, 1);
          TroopInfoActivity.a(this.this$0, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.this$0.b = paramTroopInfo;
    } while ((this.this$0.qy != null) && (this.this$0.qy.size() != 0));
    this.this$0.a.updateForTroopInfo(paramTroopInfo, this.this$0.app.getCurrentAccountUin());
    this.this$0.handler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.this$0.ath();
    if (this.this$0.a.pa == 4) {}
    while (paramLong != Long.parseLong(this.this$0.a.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.this$0.a.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.this$0.a.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.this$0.a.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      TroopInfoActivity.f(this.this$0);
      return;
    }
    this.this$0.cf(2131719483, 1);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.this$0.b != null) && (this.this$0.b.troopuin != null) && (this.this$0.b.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.this$0.b.troopowneruin = paramTroopInfo.troopowneruin;
      this.this$0.b.troopname = paramTroopInfo.troopname;
      this.this$0.b.troopface = paramTroopInfo.troopface;
      this.this$0.b.troopmemo = paramTroopInfo.troopmemo;
      this.this$0.b.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.this$0.b.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.this$0.b.strLocation = paramTroopInfo.strLocation;
      this.this$0.b.troopLat = paramTroopInfo.troopLat;
      this.this$0.b.troopLon = paramTroopInfo.troopLon;
      this.this$0.b.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.this$0.b.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.this$0.b.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.this$0.b.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.this$0.b.isNewTroop = paramTroopInfo.isNewTroop;
      this.this$0.b.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.this$0.b.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.this$0.b.mTags = paramTroopInfo.mTags;
      if (!TextUtils.isEmpty(this.this$0.b.mRichFingerMemo)) {
        break label494;
      }
    }
    for (this.this$0.b.mRichFingerMemo = this.this$0.b.fingertroopmemo;; this.this$0.b.mRichFingerMemo = jqc.dR(this.this$0.b.mRichFingerMemo))
    {
      this.this$0.bLu = this.this$0.b.troopTypeExt;
      this.this$0.a.updateForTroopInfo(this.this$0.b, this.this$0.app.getCurrentAccountUin());
      if (this.this$0.bLu != this.this$0.a.troopTypeExt) {
        this.this$0.handler.sendEmptyMessage(8);
      }
      if ((this.this$0.b != null) && (this.this$0.a.isMember))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ThreadManager.post(new TroopInfoActivity.22.1(this, this.this$0.b), 8, null, true);
      }
      this.this$0.handler.post(new TroopInfoActivity.22.2(this));
      this.this$0.handler.sendEmptyMessage(4);
      return;
      label494:
      this.this$0.b.mRichFingerMemo = jqc.dS(this.this$0.b.mRichFingerMemo);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((!paramBoolean) || (!aqft.equalsWithNullCheck(paramString, this.this$0.a.troopUin))) {
      return;
    }
    this.this$0.bLv = paramInt1;
    this.this$0.bLw = paramInt2;
    this.this$0.bLx = paramInt3;
    if ((this.this$0.bLv == 1) || (this.this$0.bLv == 2)) {
      this.this$0.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4).edit().remove("has_shown_tips").commit();
    }
    if (this.this$0.bLv == 2)
    {
      paramString = paramGroupInfo.string_group_name.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString)) {
        this.this$0.a.troopName = paramString;
      }
      paramString = paramGroupInfo.group_geo_info.bytes_geocontent.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString)) {
        this.this$0.i(5, paramString, true);
      }
      paramString = apyh.a(BaseApplication.getContext()).a(this.this$0, Long.toString(paramGroupInfo.uint32_group_class_ext.get()));
      if (paramString != null)
      {
        this.this$0.a.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
        this.this$0.i(4, paramString.BD(), true);
      }
      paramString = TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get());
      if (!TextUtils.isEmpty(paramString))
      {
        this.this$0.a.troopTags = TroopInfo.getTags(paramString);
        paramString = TroopInfoActivity.a(this.this$0, this.this$0.a);
        this.this$0.a(8, paramString, true, 2, true);
      }
      paramString = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.this$0.a.mRichFingerMemo = paramString;
        this.this$0.i(6, paramString, true);
      }
    }
    TroopInfoActivity.e(this.this$0);
  }
  
  protected void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
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
          if (!aqft.equalsWithNullCheck(localTroopInfo.troopuin, this.this$0.a.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.this$0.b = localObject;
    this.this$0.a.updateForTroopInfo(localObject, this.this$0.app.getCurrentAccountUin());
    this.this$0.handler.sendEmptyMessage(4);
  }
  
  protected void h(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (this.this$0.d != null)
      {
        this.this$0.d.EX(this.this$0.a.troopUin);
        this.this$0.d.ES(this.this$0.a.troopUin);
      }
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.this$0.getString(2131694966);
    }
    QQToast.a(localBaseApplication, 1, str, 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void j(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(this.this$0.a.troopUin))) {
      this.this$0.bFL = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzm
 * JD-Core Version:    0.7.0.1
 */