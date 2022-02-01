import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class acuv
  extends acuk
{
  public acuv(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acp();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("OnlineDatingAction", 1, "doAction error: " + localException.getMessage());
      Ge("OnlineDatingAction");
    }
    return false;
  }
  
  public boolean acp()
  {
    String str = (String)this.attrs.get("roomid");
    Object localObject6 = (String)this.attrs.get("fromid");
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("vasname"))) {}
    try
    {
      localObject1 = URLDecoder.decode((String)this.attrs.get("vasname"), "utf-8");
      localObject5 = "";
      localObject3 = localObject5;
      if (TextUtils.isEmpty((CharSequence)this.attrs.get("userdata"))) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        localObject3 = URLDecoder.decode((String)this.attrs.get("vasname"), "utf-8");
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(str);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          for (;;)
          {
            int i;
            localNumberFormatException1.printStackTrace();
          }
        }
        i = 0;
        try
        {
          int j = Integer.parseInt((String)localObject6);
          i = j;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject4;
            localNumberFormatException2.printStackTrace();
          }
        }
        localObject5 = this.app;
        localObject6 = this.app;
        ((aigu)((QQAppInterface)localObject5).getManager(108)).a(this.context, l1, "launcher", (String)localObject1, (String)localObject3, i);
        return true;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        localUnsupportedEncodingException1.printStackTrace();
        localObject2 = localObject3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          Object localObject5;
          localUnsupportedEncodingException2.printStackTrace();
          localObject4 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acuv
 * JD-Core Version:    0.7.0.1
 */