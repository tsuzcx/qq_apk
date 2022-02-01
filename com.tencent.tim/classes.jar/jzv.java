import android.os.Bundle;
import java.util.ArrayList;

public class jzv
  implements acci
{
  public void L(boolean paramBoolean, int paramInt) {}
  
  public void M(boolean paramBoolean, int paramInt) {}
  
  public void N(boolean paramBoolean, int paramInt) {}
  
  public void a(oub.a parama) {}
  
  public void a(boolean paramBoolean, ArrayList<oub.d> paramArrayList) {}
  
  public void a(boolean paramBoolean, oub.a parama, byte[] paramArrayOfByte, String paramString) {}
  
  public void c(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void d(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void lI(boolean paramBoolean) {}
  
  public void n(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    default: 
      return;
    case 2: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        d(true, paramObject.getString("VALUE_ARTICLE_ID"), paramObject.getInt("VALUE_ARTICLE_LIKE_COUNT"));
        return;
      }
      d(false, null, 0);
      return;
    case 0: 
      if ((paramObject != null) && ((paramObject instanceof Bundle)))
      {
        n(paramBoolean, ((Bundle)paramObject).getString("VALUE_ARTICLE_ID"));
        return;
      }
      n(false, null);
      return;
    case 1: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        c(true, paramObject.getString("VALUE_ARTICLE_ID"), Boolean.valueOf(paramObject.getBoolean("VALUE_ARTICLE_IS_LIKED")).booleanValue());
        return;
      }
      c(false, null, false);
      return;
    case 4: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        if (paramObject.getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
        {
          M(true, paramObject.getInt("VALUE_ARTICLE_COMMENT_COUNT"));
          return;
        }
        M(false, 0);
        return;
      }
      M(false, 0);
      return;
    }
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      if (((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
      {
        lI(true);
        return;
      }
      lI(false);
      return;
    }
    lI(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzv
 * JD-Core Version:    0.7.0.1
 */