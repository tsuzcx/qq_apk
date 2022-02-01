import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;
import mqq.app.MobileQQ;

public class amjk
  extends amjz
{
  private String caA;
  public String caw;
  public String cax;
  public String cay;
  public String caz;
  private int dCv;
  private QQAppInterface e;
  private Friends h;
  private String mGroupName;
  
  @SuppressLint({"DefaultLocale"})
  public amjk(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.h = paramFriends;
    this.ajM = paramLong2;
    this.mGroupName = paramString;
    this.e = paramQQAppInterface;
    if ((this.h.remark != null) && (this.h.remark.length() != 0))
    {
      this.caw = ChnToSpell.aJ(this.h.remark, 1).toLowerCase();
      this.cax = ChnToSpell.aJ(this.h.remark, 2).toLowerCase();
    }
    if ((this.h.name != null) && (this.h.name.length() != 0))
    {
      this.cay = ChnToSpell.aJ(this.h.name, 1).toLowerCase();
      this.caz = ChnToSpell.aJ(this.h.name, 2).toLowerCase();
    }
    dOc();
  }
  
  private String yW()
  {
    if (!TextUtils.isEmpty(this.h.alias)) {
      return this.h.alias;
    }
    return this.h.uin;
  }
  
  public int IN()
  {
    return this.dCv;
  }
  
  public int IO()
  {
    return 0;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void PG(String paramString)
  {
    String str1;
    String str2;
    label44:
    String str3;
    label63:
    String str4;
    label82:
    String str5;
    String str6;
    String str7;
    String str8;
    long l1;
    if (this.h.remark != null)
    {
      str1 = this.h.remark.toLowerCase();
      if (this.h.name == null) {
        break label600;
      }
      str2 = this.h.name.toLowerCase();
      if (this.h.uin == null) {
        break label606;
      }
      str3 = this.h.uin;
      if (this.h.alias == null) {
        break label612;
      }
      str4 = this.h.alias;
      str5 = this.caw;
      str6 = this.cax;
      str7 = this.cay;
      str8 = this.caz;
      paramString = paramString.toLowerCase();
      l2 = -9223372036854775808L;
      this.ajL = -9223372036854775808L;
      l1 = l2;
      if (str1 != null)
      {
        l1 = l2;
        if (str1.length() != 0)
        {
          if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString)))) {
            break label629;
          }
          l1 = amjz.ajh;
          if ((str1.equals(paramString)) || (str1.equals(str5))) {
            break label618;
          }
          l1 += amjz.ajf;
          label213:
          l2 = l1 + 0L;
          l1 = l2;
          if (this.ajL < l2)
          {
            this.ajL = l2;
            this.dCv = 2;
            l1 = l2;
          }
        }
      }
      if ((str2 == null) || (str2.length() == 0)) {
        break label1090;
      }
      if ((!str2.equals(paramString)) && ((str7 == null) || (!str7.equals(paramString))) && ((str8 == null) || (!str8.equals(paramString)))) {
        break label773;
      }
      l1 = amjz.ajh;
      if ((str2.equals(paramString)) || (str2.equals(str7))) {
        break label753;
      }
      l1 = amjz.ajf + l1;
      label330:
      if (!TextUtils.isEmpty(this.h.remark)) {
        break label764;
      }
      l1 += 0L;
      label349:
      l2 = l1;
      if (this.ajL < l1)
      {
        this.ajL = l1;
        this.dCv = 1;
      }
    }
    label449:
    label1090:
    for (long l2 = l1;; l2 = l1)
    {
      long l3 = l2;
      if (str4 != null)
      {
        l3 = l2;
        if (str4.length() != 0)
        {
          if (!str4.equals(paramString)) {
            break label928;
          }
          l1 = amjz.ajh + amjz.aje;
          if ((!TextUtils.isEmpty(this.h.remark)) || (!TextUtils.isEmpty(this.h.name))) {
            break label919;
          }
          l1 += 0L;
          l3 = l1;
          if (this.ajL < l1)
          {
            this.ajL = l1;
            this.dCv = 3;
            l3 = l1;
          }
        }
      }
      if (1 != this.h.cSpecialFlag)
      {
        l1 = l3;
        if (str3 != null)
        {
          if (!str3.equals(paramString)) {
            break label1003;
          }
          l1 = amjz.ajh + amjz.aje;
          if ((!TextUtils.isEmpty(this.h.remark)) || (!TextUtils.isEmpty(this.h.name))) {
            break label994;
          }
          l1 += 0L;
        }
      }
      for (;;)
      {
        if (this.ajL < l1)
        {
          this.ajL = l1;
          this.dCv = 0;
        }
        if (this.ajL != -9223372036854775808L) {
          this.ajL += this.ajM;
        }
        return;
        str1 = null;
        break;
        label600:
        str2 = null;
        break label44;
        label606:
        str3 = null;
        break label63;
        label612:
        str4 = null;
        break label82;
        label618:
        l1 += amjz.aje;
        break label213;
        label629:
        int k = str1.indexOf(paramString);
        int j;
        if (str5 != null)
        {
          i = str5.indexOf(paramString);
          if (str6 == null) {
            break label729;
          }
          j = str6.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label732;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label734;
          }
          l1 = amjz.aji;
          if ((k >= 0) || (str1.equals(str5))) {
            break label742;
          }
        }
        label729:
        label732:
        label734:
        label742:
        for (l1 += amjz.ajf;; l1 += amjz.aje)
        {
          l2 = l1 + 0L;
          break;
          i = -1;
          break label649;
          j = -1;
          break label661;
          break;
          l1 = amjz.ajj;
          break label692;
        }
        label753:
        l1 = amjz.aje + l1;
        break label330;
        label764:
        l1 += 0L;
        break label349;
        k = str2.indexOf(paramString);
        if (str7 != null)
        {
          i = str7.indexOf(paramString);
          if (str8 == null) {
            break label886;
          }
          j = str8.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label1087;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label891;
          }
          l1 = amjz.aji;
          label836:
          if ((k >= 0) || (str2.equals(str7))) {
            break label899;
          }
        }
        for (l1 = amjz.ajf + l1;; l1 = amjz.aje + l1)
        {
          if (!TextUtils.isEmpty(this.h.remark)) {
            break label910;
          }
          l1 += 0L;
          break;
          i = -1;
          break label793;
          label886:
          j = -1;
          break label805;
          label891:
          l1 = amjz.ajj;
          break label836;
        }
        l1 += 0L;
        break label349;
        l1 += 0L;
        break label449;
        l1 = l2;
        if (str4.indexOf(paramString) < 0) {
          break label449;
        }
        l1 = amjz.ajj + amjz.aje;
        if ((TextUtils.isEmpty(this.h.remark)) && (TextUtils.isEmpty(this.h.name)))
        {
          l1 += 0L;
          break label449;
        }
        l1 += 0L;
        break label449;
        label994:
        l1 += 0L;
        continue;
        label1003:
        int i = str3.indexOf(paramString);
        l1 = l3;
        if (i >= 0)
        {
          if (i == 0) {}
          for (l1 = amjz.aji;; l1 = amjz.ajj)
          {
            l1 += amjz.aje;
            if ((!TextUtils.isEmpty(this.h.remark)) || (!TextUtils.isEmpty(this.h.name))) {
              break label1078;
            }
            l1 += 0L;
            break;
          }
          l1 += 0L;
        }
      }
      break label349;
    }
  }
  
  public Friends a()
  {
    return this.h;
  }
  
  public Drawable aP()
  {
    return null;
  }
  
  protected long gL()
  {
    QQMessageFacade.Message localMessage = this.e.b().a(this.h.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public String getExtraInfo()
  {
    if (this.caA != null) {
      return String.format("(%s)", new Object[] { this.caA });
    }
    return null;
  }
  
  public String getIdentifier()
  {
    return this.h.uin;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public String yU()
  {
    if (jqs.d(this.e, this.h.uin, 0)) {
      return this.e.getApplication().getString(2131689918);
    }
    return this.mGroupName;
  }
  
  public String yV()
  {
    Object localObject1 = this.h.remark;
    String str1 = this.h.name;
    Object localObject2 = this.h.alias;
    String str2 = this.h.uin;
    switch (this.dCv)
    {
    default: 
      localObject2 = null;
    case 0: 
    case 2: 
      do
      {
        do
        {
          return localObject2;
          if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = str1;
            }
            for (;;)
            {
              localObject1 = String.format("%s", new Object[] { localObject1 });
              this.caA = yW();
              return localObject1;
            }
          }
          return str2;
          localObject2 = localObject1;
        } while (str1 == null);
        localObject2 = localObject1;
      } while (str1.length() == 0);
      localObject1 = String.format("%s", new Object[] { localObject1 });
      this.caA = str1;
      return localObject1;
    case 1: 
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject1 = String.format("%s", new Object[] { localObject1 });
        this.caA = str1;
        return localObject1;
      }
      localObject1 = String.format("%s", new Object[] { str1 });
      this.caA = yW();
      return localObject1;
    }
    if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
    {
      localObject1 = String.format("%s", new Object[] { aqgv.c(this.h) });
      this.caA = ((String)localObject2);
      return localObject1;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjk
 * JD-Core Version:    0.7.0.1
 */