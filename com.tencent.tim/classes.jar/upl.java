import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class upl
  extends acnd
{
  public upl(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void S(boolean paramBoolean, String paramString)
  {
    super.S(paramBoolean, paramString);
    ChatSettingForTroop.a(this.this$0);
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    super.a(paramBoolean, paramInt, paramArrayList, paramString);
    if (!paramBoolean) {
      if (paramInt == 2) {
        QQToast.a(this.this$0, 1, acfp.m(2131703769), 0).show(this.this$0.getTitleBarHeight());
      }
    }
    Object localObject1;
    do
    {
      return;
      localObject2 = "";
      localObject1 = localObject2;
      if (this.this$0.b != null)
      {
        localObject1 = localObject2;
        if (this.this$0.b.troopuin != null) {
          localObject1 = this.this$0.b.troopuin;
        }
      }
    } while (this.this$0.qC == null);
    Object localObject2 = new HashSet();
    if ((paramString != null) && (paramString.equals(localObject1)))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (String)paramArrayList.next();
        localObject1 = this.this$0.qC.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)((Iterator)localObject1).next();
          if (paramString.equals(localmemberlist.uint64_member_uin.get() + "")) {
            ((Collection)localObject2).add(localmemberlist);
          }
        }
      }
      paramArrayList = ((Collection)localObject2).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (oidb_0x899.memberlist)paramArrayList.next();
        this.this$0.qC.remove(paramString);
      }
    }
    this.this$0.fH(this.this$0.qC);
  }
  
  protected void ac(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.this$0.a.troopUin == null) || (!paramString1.equals(this.this$0.a.troopUin))) {
      return;
    }
    ChatSettingForTroop.a(this.this$0, true);
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    String str;
    do
    {
      return;
      str = paramLong1 + "";
    } while ((this.this$0.a.troopUin == null) || (!str.equals(this.this$0.a.troopUin)));
    ChatSettingForTroop.a(this.this$0, true);
  }
  
  protected void c(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    String str;
    do
    {
      return;
      str = paramLong1 + "";
    } while ((this.this$0.a.troopUin == null) || (!str.equals(this.this$0.a.troopUin)));
    ChatSettingForTroop.a(this.this$0, true);
  }
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramString1 == null) || (this.this$0.a.troopUin == null) || (!paramString1.equals(this.this$0.a.troopUin))) {}
    while (paramInt2 != 512) {
      return;
    }
    if (paramBoolean)
    {
      acqi.a(this.this$0.app, this.this$0.b);
      return;
    }
    ChatSettingForTroop.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upl
 * JD-Core Version:    0.7.0.1
 */