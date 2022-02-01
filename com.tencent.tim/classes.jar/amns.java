import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.ArrayList;

public class amns
{
  public static amno a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new amnv(paramQQAppInterface);
  }
  
  public static amnq a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    return new amoa(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
  }
  
  public static amwt a(int paramInt, String paramString, FTSEntity paramFTSEntity)
  {
    paramString = new amwt(paramString);
    paramFTSEntity = (FTSMessage)paramFTSEntity;
    paramString.extra = new Bundle();
    paramString.extra.putLong("uin", paramFTSEntity.uin);
    paramString.extra.putInt("uinType", paramFTSEntity.istroop);
    return paramString;
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    String str = paramString;
    if (paramString.length() > 13) {
      str = paramString.substring(0, 10) + "…";
    }
    return paramContext.getString(2131719281, new Object[] { Integer.valueOf(paramInt1), str });
  }
  
  public static String g(Context paramContext, int paramInt)
  {
    return paramContext.getString(2131719282);
  }
  
  public static String h(Context paramContext, int paramInt)
  {
    return acfp.m(2131706653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amns
 * JD-Core Version:    0.7.0.1
 */