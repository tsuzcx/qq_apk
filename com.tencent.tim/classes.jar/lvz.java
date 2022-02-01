import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSImageView;
import com.tencent.qphone.base.util.QLog;

public class lvz
{
  public static void a(PTSImageView paramPTSImageView, String paramString)
  {
    if ((paramPTSImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("PTSLocalImageUtil", 2, "[setLocalImageDrawable], localPath = " + paramString);
    }
    int i;
    try
    {
      String str = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      str = "qb_public_account_readinjoy_" + str;
      i = q(paramPTSImageView.getContext(), str);
      if (i == -1)
      {
        QLog.e("PTSLocalImageUtil", 1, "[setLocalImageDrawable], cannot find the resource, localPath = " + paramString);
        paramPTSImageView.setImageDrawable(new ColorDrawable(0));
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("PTSLocalImageUtil", 1, "[setLocalImageDrawable] error, e = " + paramString);
      paramPTSImageView.setImageDrawable(new ColorDrawable(0));
      return;
    }
    paramPTSImageView.setImageResource(i);
  }
  
  private static int q(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvz
 * JD-Core Version:    0.7.0.1
 */