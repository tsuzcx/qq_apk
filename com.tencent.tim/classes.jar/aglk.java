import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.qphone.base.util.QLog;

class aglk
  extends aghq
{
  aglk(aglj paramaglj) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle)
  {
    label280:
    for (;;)
    {
      try
      {
        String str1;
        if (agmx.cen)
        {
          paramString6 = "183.61.37.13";
          str1 = "443";
          paramString5 = null;
          paramString4 = paramString5;
          if (agmx.aF(this.a.app))
          {
            paramString4 = paramString5;
            if (paramBundle != null)
            {
              String str2 = paramBundle.getString("strHttpsDomain");
              short s2 = paramBundle.getShort("httpsPort", (short)0);
              paramString4 = paramString5;
              if (!TextUtils.isEmpty(str2))
              {
                short s1 = s2;
                if (s2 == 0) {
                  s1 = 443;
                }
                paramString4 = new Bundle();
                paramString4.putBoolean("ishttps", true);
                paramString4.putString("httpsdomain", str2);
                paramString4.putShort("httpsport", s1);
              }
            }
          }
          paramString5 = paramString4;
          if (ahbr.amL())
          {
            paramString5 = paramString4;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getString("IPv6Dns");
              paramString5 = paramString4;
              if (paramString4 == null) {
                paramString5 = new Bundle();
              }
              paramString5.putString("ipv6domain", paramBundle);
            }
          }
          if (this.a.a != null) {
            this.a.a.a(paramBoolean, paramString6, str1, paramInt1, paramString1, paramString3, paramString2, this.a.bHG, paramString5);
          }
        }
        else
        {
          if ((paramString4 == null) || (paramString4.length() <= 0)) {
            break label280;
          }
          str1 = String.valueOf(paramInt2);
          paramString6 = paramString4;
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(this.a.TAG, 2, " callback is null");
          continue;
          paramString4 = paramString5;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aglk
 * JD-Core Version:    0.7.0.1
 */