import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils.2;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class adzx
{
  public static void Hj(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 1000;
      localURLDrawableOptions.mRequestHeight = 600;
      ThreadManager.post(new BusinessCardUtils.2(URLDrawable.getDrawable(paramString, localURLDrawableOptions)), 8, null, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static BusinessCard a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (adyp)paramQQAppInterface.getManager(112);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a();; paramQQAppInterface = null)
    {
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = new BusinessCard();
      }
      return localObject;
    }
  }
  
  public static BusinessCard a(QQAppInterface paramQQAppInterface, alcn paramalcn)
  {
    adyp localadyp = (adyp)paramQQAppInterface.getManager(112);
    if (paramalcn.e.pa == 0) {
      paramQQAppInterface = localadyp.a();
    }
    for (;;)
    {
      paramalcn = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramalcn = new BusinessCard();
      }
      return paramalcn;
      if (paramalcn.d != null)
      {
        paramQQAppInterface = paramalcn.d.getCardInfo();
        if ((paramalcn.d.hasCardInfo()) && (!TextUtils.isEmpty(paramQQAppInterface.cardId))) {
          localadyp.a(paramalcn.e.uin, paramQQAppInterface);
        } else {
          paramQQAppInterface = localadyp.b(paramalcn.e.uin);
        }
      }
      else
      {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramURLImageView == null)) {}
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = paramURLImageView.getContext().getResources().getDrawable(2130845843);
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
        paramURLImageView.setURLDrawableDownListener(new adzy(paramURLImageView));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("BusinessCard", 2, "error " + paramString.toString());
  }
  
  public static void em(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ocr_user_edit_action_report", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzx
 * JD-Core Version:    0.7.0.1
 */