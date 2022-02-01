import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class amrl
  extends amrm
{
  String cbq = null;
  
  ampw a(yow paramyow, List<ampx> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    amoy localamoy;
    if (paramList != null)
    {
      localamoy = (amoy)paramList.get(0);
      if ((localamoy != null) && (localamoy.a() != null))
      {
        String str = localamoy.a().hotword.get();
        kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localamoy.getKeyword(), str, String.valueOf(localamoy.a().hotword_type.get()), "");
      }
      if ((localamoy == null) || (localamoy.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localamoy != null) && (localamoy.a() != null)) {
        kbp.b(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localamoy.a().account_id.get()));
      }
      amxj.UD(110);
      this.cbq = paramString2;
      return new amox(paramyow, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localamoy = (amoy)paramList.get(1);
      } else {
        localamoy = null;
      }
    }
  }
  
  ampx a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new amoy(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  ampx a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new amoy(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrl
 * JD-Core Version:    0.7.0.1
 */