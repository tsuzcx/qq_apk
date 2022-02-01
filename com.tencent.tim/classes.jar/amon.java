import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.List;
import java.util.Set;

public class amon
  extends amol
{
  private CharSequence ai;
  
  public amon(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<amol.b> paramList)
  {
    super(paramQQAppInterface, paramInt, paramString, paramList);
  }
  
  public TroopInfo a()
  {
    return this.troopInfo;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (!amxk.lo(this.fromType)) {
      amxk.a(paramView, this);
    }
  }
  
  protected void dOp()
  {
    int j;
    int i;
    int k;
    label54:
    int m;
    if (amxk.lo(this.fromType))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.FW != null)
      {
        localSpannableStringBuilder.append("包含: ");
        j = this.FX.size() - 1;
        i = 0;
        if (j >= 0)
        {
          k = 1;
          if (i >= 10) {
            break label132;
          }
        }
        label132:
        for (m = 1;; m = 0)
        {
          if ((m & k) == 0) {
            break label138;
          }
          localSpannableStringBuilder.append(amxk.a((String)this.FX.get(j), (String)this.FY.get(j), 6, false));
          i += 1;
          localSpannableStringBuilder.append("、");
          j -= 1;
          break;
          k = 0;
          break label54;
        }
        label138:
        k = 0;
        j = i;
        i = k;
        if (i < this.FW.size())
        {
          k = 1;
          label159:
          if (j >= 10) {
            break label284;
          }
          m = 1;
          label168:
          if ((m & k) == 0) {
            break label336;
          }
          localObject = (amol.b)this.FW.get(i);
          k = j;
          if (!this.cT.contains(localObject))
          {
            if (this.FY.size() != 1) {
              break label290;
            }
            m = ((amol.b)localObject).dDf;
            label226:
            if (m != 66) {
              break label300;
            }
            localObject = ((amol.b)localObject).mMemberCard;
          }
        }
        for (;;)
        {
          label240:
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = j + 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.append("、");
          }
          label284:
          label290:
          label300:
          do
          {
            i += 1;
            j = k;
            break;
            k = 0;
            break label159;
            m = 0;
            break label168;
            m = ((amol.b)localObject).dDg;
            break label226;
            if (m == 88)
            {
              localObject = ((amol.b)localObject).mMemberName;
              break label240;
            }
            k = j;
          } while (m != 99);
          localObject = ((amol.b)localObject).mMemberNick;
        }
      }
      label336:
      if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、')) {}
      for (this.mDescription = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);; this.mDescription = localSpannableStringBuilder)
      {
        this.ai = (this.troopInfo.wMemberNum + acfp.m(2131704458));
        return;
      }
    }
    this.mDescription = acfp.m(2131704467);
    Object localObject = new SpannableStringBuilder();
    if (!this.troopInfo.hasSetTroopName()) {
      ((SpannableStringBuilder)localObject).append(String.valueOf(this.troopInfo.wMemberNum));
    }
    label593:
    label597:
    for (;;)
    {
      this.ai = ((CharSequence)localObject);
      return;
      if ((!this.cT.isEmpty()) && (this.FW != null))
      {
        j = this.FX.size() - 1;
        i = 0;
        if (j >= 0)
        {
          k = 1;
          label511:
          if (i >= 10) {
            break label593;
          }
        }
        for (m = 1;; m = 0)
        {
          if ((m & k) == 0) {
            break label597;
          }
          ((SpannableStringBuilder)localObject).append(amxk.a((String)this.FX.get(j), (String)this.FY.get(j), 6, false));
          if (j > 0) {
            ((SpannableStringBuilder)localObject).append("、");
          }
          j -= 1;
          i += 1;
          break;
          k = 0;
          break label511;
        }
      }
    }
  }
  
  public CharSequence getTitle()
  {
    if ((this.troopInfo.isNewTroop()) && (!this.troopInfo.hasSetTroopName())) {
      return za();
    }
    return super.getTitle();
  }
  
  public String zb()
  {
    return this.ai.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amon
 * JD-Core Version:    0.7.0.1
 */