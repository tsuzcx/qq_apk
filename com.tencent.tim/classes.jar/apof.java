import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class apof
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (appb[])localEditable.getSpans(0, paramEditText.getSelectionStart(), appb.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new apoh(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static appb a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (appb[])localEditable.getSpans(0, paramEditText.getSelectionStart(), appb.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new apog(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static ChatHistoryTroopMemberFragment.a a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (acff)paramQQAppInterface.getManager(51);
    ChatHistoryTroopMemberFragment.a locala = new ChatHistoryTroopMemberFragment.a();
    locala.uin = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((acff)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      locala.displayName = aqgv.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, locala.uin, true);
      locala.faceid = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        locala.wQ(paramTroopMemberInfo.friendnick);
        locala.wS(paramTroopMemberInfo.pyAll_friendnick);
        locala.wR(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        locala.wT(((Friends)localObject).remark);
        locala.wW(ChnToSpell.aJ(locala.remark, 1));
        locala.wU(ChnToSpell.aJ(locala.remark, 2));
        locala.wV(((Friends)localObject).remark);
        locala.wX(paramTroopMemberInfo.troopnick);
        locala.wZ(paramTroopMemberInfo.pyAll_troopnick);
        locala.wY(paramTroopMemberInfo.pyFirst_troopnick);
        locala.Hr = paramTroopMemberInfo.last_active_time;
        locala.Hq = paramTroopMemberInfo.join_time;
        locala.level = paramTroopMemberInfo.level;
        locala.realLevel = paramTroopMemberInfo.realLevel;
        locala.Ht = paramTroopMemberInfo.credit_level;
        locala.isTroopFollowed = paramTroopMemberInfo.isTroopFollowed;
        locala.Hs = paramTroopMemberInfo.active_point;
        locala.mIsShielded = paramTroopMemberInfo.mIsShielded;
        locala.bLX = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, locala.uin);
        if ((d1 == -1000.0D) || (d1 == -100.0D)) {
          break label671;
        }
        double d2 = d1 / 1000.0D;
        d1 = d2;
        if (d2 < 0.01D) {
          d1 = 0.01D;
        }
        if (d1 <= 10.0D) {
          break label629;
        }
        locala.aRr = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          locala.mUniqueTitle = paramTroopMemberInfo.mUniqueTitle;
          locala.mUniqueTitleExpire = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        locala.mVipType = paramTroopMemberInfo.mVipType;
        locala.mVipLevel = paramTroopMemberInfo.mVipLevel;
        locala.mVipTemplateId = paramTroopMemberInfo.mBigClubTemplateId;
        locala.bLY = paramTroopMemberInfo.mBigClubVipType;
        locala.bLZ = paramTroopMemberInfo.mBigClubVipLevel;
        locala.mBigClubTemplateId = paramTroopMemberInfo.mBigClubTemplateId;
        locala.pinyinFirst = ChnToSpell.aJ(c(locala), 2);
        locala.vW(ChnToSpell.aJ(c(locala), 1));
        locala.bah = c(locala);
        locala.baj = locala.pinyinFirst;
        locala.bai = locala.pinyinAll;
        return locala;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label629:
        paramQQAppInterface = new DecimalFormat("#.##");
        locala.aRr = (paramQQAppInterface.format(d1) + "km");
        continue;
        label671:
        locala.aRr = "";
      }
    }
  }
  
  public static String a(ChatHistoryTroopMemberFragment.a parama)
  {
    if (!TextUtils.isEmpty(parama.aRl)) {
      return parama.aRl;
    }
    if (!TextUtils.isEmpty(parama.nickname)) {
      return parama.nickname;
    }
    return parama.uin;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (appb[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), appb.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (aptw)paramQQAppInterface.getManager(203);
      int i = 0;
      while (i < paramEditText.length)
      {
        if (paramQQAppInterface.gM(paramEditText[i].Bw())) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    String str = paramTroopInfo.Administrator;
    return (paramQQAppInterface.getCurrentAccountUin().equals(paramTroopInfo.troopowneruin)) || ((str != null) && (str.contains(paramQQAppInterface.getCurrentAccountUin())));
  }
  
  public static boolean a(String paramString, TroopInfo paramTroopInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTroopInfo == null)) {}
    do
    {
      return false;
      paramTroopInfo = paramTroopInfo.Administrator;
    } while ((paramTroopInfo == null) || (!paramTroopInfo.contains(paramString)));
    return true;
  }
  
  public static int b(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (appb[])localEditable.getSpans(0, paramEditText.getSelectionStart(), appb.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new apoi(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(ChatHistoryTroopMemberFragment.a parama)
  {
    if (!TextUtils.isEmpty(parama.remark)) {
      return parama.remark;
    }
    if (!TextUtils.isEmpty(parama.displayName)) {
      return parama.displayName;
    }
    if (!TextUtils.isEmpty(parama.aRl)) {
      return parama.aRl;
    }
    if (!TextUtils.isEmpty(parama.nickname)) {
      return parama.nickname;
    }
    return parama.uin;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    return (paramTroopInfo.isNewTroop) && (paramTroopInfo.wMemberNum <= 20);
  }
  
  public static boolean b(String paramString, TroopInfo paramTroopInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTroopInfo == null)) {
      return false;
    }
    return paramString.equals(paramTroopInfo.troopowneruin);
  }
  
  public static boolean bP(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.toLowerCase().contains(paramString2.toLowerCase());
  }
  
  public static String c(ChatHistoryTroopMemberFragment.a parama)
  {
    if (!TextUtils.isEmpty(parama.remark)) {
      return parama.remark;
    }
    if (!TextUtils.isEmpty(parama.aRl)) {
      return parama.aRl;
    }
    if (!TextUtils.isEmpty(parama.nickname)) {
      return parama.nickname;
    }
    return parama.uin;
  }
  
  public static String d(ChatHistoryTroopMemberFragment.a parama)
  {
    if (!TextUtils.isEmpty(parama.aRj)) {
      return parama.aRj;
    }
    if (!TextUtils.isEmpty(parama.aRm)) {
      return parama.aRm;
    }
    if (!TextUtils.isEmpty(parama.aRh)) {
      return parama.aRh;
    }
    return null;
  }
  
  public static String e(ChatHistoryTroopMemberFragment.a parama)
  {
    if (!TextUtils.isEmpty(parama.aRk)) {
      return parama.aRk;
    }
    if (!TextUtils.isEmpty(parama.aRn)) {
      return parama.aRn;
    }
    if (!TextUtils.isEmpty(parama.aRi)) {
      return parama.aRi;
    }
    return null;
  }
  
  static class a
    implements Comparator<ChatHistoryTroopMemberFragment.a>
  {
    private final TroopInfo b;
    
    a(TroopInfo paramTroopInfo)
    {
      this.b = paramTroopInfo;
    }
    
    public int a(ChatHistoryTroopMemberFragment.a parama1, ChatHistoryTroopMemberFragment.a parama2)
    {
      int j = 5;
      int i;
      if (apof.b(parama1.uin, this.b)) {
        i = 5;
      }
      for (;;)
      {
        if (apof.b(parama2.uin, this.b)) {}
        for (;;)
        {
          if (i != j)
          {
            return j - i;
            if (apof.a(parama1.uin, this.b))
            {
              i = 3;
              break;
            }
            if (!parama1.isTroopFollowed) {
              break label134;
            }
            i = 1;
            break;
            if (apof.a(parama2.uin, this.b))
            {
              j = 3;
              continue;
            }
            if (!parama2.isTroopFollowed) {
              break label128;
            }
            j = 1;
            continue;
          }
          return ChnToSpell.aJ(apof.c(parama1), 1).compareToIgnoreCase(ChnToSpell.aJ(apof.c(parama2), 1));
          label128:
          j = 0;
        }
        label134:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apof
 * JD-Core Version:    0.7.0.1
 */