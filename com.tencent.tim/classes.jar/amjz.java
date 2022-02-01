import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;

public abstract class amjz
  implements amka
{
  public static long aiN = SearchConfigManager.fieldPublicAccountName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiO = SearchConfigManager.fieldPublicAccountMark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiP = SearchConfigManager.fieldPublicAccountSummary << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiQ = SearchConfigManager.fieldPublicAccountDisplayName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiR = SearchConfigManager.filedDiscussionName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiS = SearchConfigManager.fieldTroopName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiT = SearchConfigManager.fieldRemark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiU = SearchConfigManager.fieldNewTroopNickName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiV = SearchConfigManager.fieldNewTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiW = SearchConfigManager.fieldDiscussionMemberRemark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiX = SearchConfigManager.fieldInteRemark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiY = SearchConfigManager.fieldNickName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aiZ = SearchConfigManager.fieldPhoneContactName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long ajA = SearchConfigManager.typeTool << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajB = SearchConfigManager.typePublicAccountConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajC = SearchConfigManager.typePublicAccount << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajD = SearchConfigManager.typeUnbindPhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajE = SearchConfigManager.typeCircleContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajF = SearchConfigManager.typeTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajG = SearchConfigManager.typeGlobalTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajH = SearchConfigManager.typeGlobalTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajI = SearchConfigManager.typeGlobalTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajJ = SearchConfigManager.typeQidianMaster << SearchConfigManager.contactSearchTypeBaseBit;
  public static long aja = SearchConfigManager.fieldAlias << SearchConfigManager.contactSearchFieldBaseBit;
  public static long ajb = SearchConfigManager.fieldUin << SearchConfigManager.contactSearchFieldBaseBit;
  public static long ajc = SearchConfigManager.fieldMobileNo << SearchConfigManager.contactSearchFieldBaseBit;
  public static long ajd = SearchConfigManager.fieldTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
  public static long aje = SearchConfigManager.stringOrigin << SearchConfigManager.contactSearchPinyinBaseBit;
  public static long ajf = SearchConfigManager.stringPinyin << SearchConfigManager.contactSearchPinyinBaseBit;
  public static long ajg = SearchConfigManager.recentTrue << SearchConfigManager.contactSearchRecentBaseBit;
  public static long ajh = SearchConfigManager.indexEqual << SearchConfigManager.contactSearchIndexBaseBit;
  public static long aji = SearchConfigManager.indexStart << SearchConfigManager.contactSearchIndexBaseBit;
  public static long ajj = SearchConfigManager.indexMiddle << SearchConfigManager.contactSearchIndexBaseBit;
  public static long ajk = 72057594037927936L;
  public static long ajl = SearchConfigManager.typeDiscussionMatchMemberFull << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajm = SearchConfigManager.typeFriendConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajn = SearchConfigManager.typeDiscussionConversationMatchTitle << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajo = SearchConfigManager.typeDiscussionConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajp = SearchConfigManager.typeTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajq = SearchConfigManager.typeFriendSpecialCare << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajr = SearchConfigManager.typeFriend << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajs = SearchConfigManager.typeFriendNotOftenContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajt = SearchConfigManager.typeNewTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long aju = SearchConfigManager.typeDiscussionMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajv = SearchConfigManager.typePhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajw = SearchConfigManager.typeDiscussionConversationMatchMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajx = SearchConfigManager.typeNewTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajy = SearchConfigManager.typeDiscussion << SearchConfigManager.contactSearchTypeBaseBit;
  public static long ajz = SearchConfigManager.typeTroop << SearchConfigManager.contactSearchTypeBaseBit;
  protected long ajK = -1L;
  protected long ajL;
  protected long ajM;
  protected long id;
  
  public static void dOb()
  {
    aiN = SearchConfigManager.fieldPublicAccountName << SearchConfigManager.contactSearchFieldBaseBit;
    aiO = SearchConfigManager.fieldPublicAccountMark << SearchConfigManager.contactSearchFieldBaseBit;
    aiP = SearchConfigManager.fieldPublicAccountSummary << SearchConfigManager.contactSearchFieldBaseBit;
    aiQ = SearchConfigManager.fieldPublicAccountDisplayName << SearchConfigManager.contactSearchFieldBaseBit;
    aiR = SearchConfigManager.filedDiscussionName << SearchConfigManager.contactSearchFieldBaseBit;
    aiS = SearchConfigManager.fieldTroopName << SearchConfigManager.contactSearchFieldBaseBit;
    aiT = SearchConfigManager.fieldRemark << SearchConfigManager.contactSearchFieldBaseBit;
    aiU = SearchConfigManager.fieldNewTroopNickName << SearchConfigManager.contactSearchFieldBaseBit;
    aiV = SearchConfigManager.fieldNewTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
    aiW = SearchConfigManager.fieldDiscussionMemberRemark << SearchConfigManager.contactSearchFieldBaseBit;
    aiX = SearchConfigManager.fieldInteRemark << SearchConfigManager.contactSearchFieldBaseBit;
    aiY = SearchConfigManager.fieldNickName << SearchConfigManager.contactSearchFieldBaseBit;
    aiZ = SearchConfigManager.fieldPhoneContactName << SearchConfigManager.contactSearchFieldBaseBit;
    aja = SearchConfigManager.fieldAlias << SearchConfigManager.contactSearchFieldBaseBit;
    ajb = SearchConfigManager.fieldUin << SearchConfigManager.contactSearchFieldBaseBit;
    ajc = SearchConfigManager.fieldMobileNo << SearchConfigManager.contactSearchFieldBaseBit;
    ajd = SearchConfigManager.fieldTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
    aje = SearchConfigManager.stringOrigin << SearchConfigManager.contactSearchPinyinBaseBit;
    ajf = SearchConfigManager.stringPinyin << SearchConfigManager.contactSearchPinyinBaseBit;
    ajg = SearchConfigManager.recentTrue << SearchConfigManager.contactSearchRecentBaseBit;
    ajh = SearchConfigManager.indexEqual << SearchConfigManager.contactSearchIndexBaseBit;
    aji = SearchConfigManager.indexStart << SearchConfigManager.contactSearchIndexBaseBit;
    ajj = SearchConfigManager.indexMiddle << SearchConfigManager.contactSearchIndexBaseBit;
    ajk = 72057594037927936L;
    ajl = SearchConfigManager.typeDiscussionMatchMemberFull << SearchConfigManager.contactSearchTypeBaseBit;
    ajm = SearchConfigManager.typeFriendConversation << SearchConfigManager.contactSearchTypeBaseBit;
    ajn = SearchConfigManager.typeDiscussionConversationMatchTitle << SearchConfigManager.contactSearchTypeBaseBit;
    ajo = SearchConfigManager.typeDiscussionConversation << SearchConfigManager.contactSearchTypeBaseBit;
    ajp = SearchConfigManager.typeTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
    ajq = SearchConfigManager.typeFriendSpecialCare << SearchConfigManager.contactSearchTypeBaseBit;
    ajr = SearchConfigManager.typeFriend << SearchConfigManager.contactSearchTypeBaseBit;
    ajs = SearchConfigManager.typeFriendNotOftenContact << SearchConfigManager.contactSearchTypeBaseBit;
    ajt = SearchConfigManager.typeNewTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    aju = SearchConfigManager.typeDiscussionMember << SearchConfigManager.contactSearchTypeBaseBit;
    ajv = SearchConfigManager.typePhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
    ajw = SearchConfigManager.typeDiscussionConversationMatchMember << SearchConfigManager.contactSearchTypeBaseBit;
    ajx = SearchConfigManager.typeNewTroop << SearchConfigManager.contactSearchTypeBaseBit;
    ajy = SearchConfigManager.typeDiscussion << SearchConfigManager.contactSearchTypeBaseBit;
    ajz = SearchConfigManager.typeTroop << SearchConfigManager.contactSearchTypeBaseBit;
    ajA = SearchConfigManager.typeTool << SearchConfigManager.contactSearchTypeBaseBit;
    ajB = SearchConfigManager.typePublicAccountConversation << SearchConfigManager.contactSearchTypeBaseBit;
    ajC = SearchConfigManager.typePublicAccount << SearchConfigManager.contactSearchTypeBaseBit;
    ajD = SearchConfigManager.typeUnbindPhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
    ajE = SearchConfigManager.typeCircleContact << SearchConfigManager.contactSearchTypeBaseBit;
    ajF = SearchConfigManager.typeTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    ajG = SearchConfigManager.typeGlobalTroop << SearchConfigManager.contactSearchTypeBaseBit;
    ajH = SearchConfigManager.typeGlobalTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
    ajI = SearchConfigManager.typeGlobalTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    ajJ = SearchConfigManager.typeQidianMaster << SearchConfigManager.contactSearchTypeBaseBit;
  }
  
  public abstract int IO();
  
  public abstract Object R();
  
  public abstract Drawable aP();
  
  protected void dOc()
  {
    for (;;)
    {
      int i;
      try
      {
        String str = getIdentifier();
        StringBuilder localStringBuilder = new StringBuilder();
        i = 0;
        if (i < str.length())
        {
          char c = str.charAt(i);
          if ((c >= '0') && (c <= '9')) {
            localStringBuilder.append(c);
          }
        }
        else
        {
          str = localStringBuilder.toString();
          if (!TextUtils.isEmpty(str))
          {
            this.id = Long.parseLong(str);
            return;
          }
          this.id = hashCode();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        this.id = hashCode();
        return;
      }
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return this.id == ((amjz)paramObject).id;
  }
  
  protected long gL()
  {
    return 0L;
  }
  
  public long gM()
  {
    return gO();
  }
  
  public long gN()
  {
    return this.ajL;
  }
  
  public long gO()
  {
    if (this.ajK == -1L) {
      this.ajK = gL();
    }
    return this.ajK;
  }
  
  public abstract String getExtraInfo();
  
  public abstract String getIdentifier();
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public void lg(long paramLong)
  {
    this.ajL = paramLong;
  }
  
  public abstract int pG();
  
  public abstract String yU();
  
  public abstract String yV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjz
 * JD-Core Version:    0.7.0.1
 */