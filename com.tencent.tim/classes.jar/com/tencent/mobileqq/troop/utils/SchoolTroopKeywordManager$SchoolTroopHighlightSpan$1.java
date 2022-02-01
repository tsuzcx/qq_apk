package com.tencent.mobileqq.troop.utils;

import anot;
import apri.a;
import apri.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1
  implements Runnable
{
  public SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1(apri.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject;
    if (!apri.b.a(this.this$0).cSe)
    {
      localObject = apri.b.a(this.this$0).getCurrentAccountUin();
      localObject = ((TroopManager)apri.b.a(this.this$0).getManager(52)).b(apri.b.a(this.this$0).troopUin, (String)localObject);
      if (localObject != null)
      {
        if (((TroopMemberInfo)localObject).level != 332) {
          break label186;
        }
        localObject = apri.b.a(this.this$0);
        ((apri.a)localObject).dVx |= 0x4;
      }
    }
    for (;;)
    {
      apri.b.a(this.this$0).cSe = true;
      anot.a(null, "dc00899", this.aoX, this.Lw, this.VN, this.val$actionName, this.lM, this.val$result, apri.b.a(this.this$0).troopUin, apri.b.a(this.this$0).Bz(), apri.b.a(this.this$0).action + "", apri.b.a(this.this$0).keyword);
      return;
      label186:
      if (((TroopMemberInfo)localObject).level == 333)
      {
        localObject = apri.b.a(this.this$0);
        ((apri.a)localObject).dVx |= 0x8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1
 * JD-Core Version:    0.7.0.1
 */