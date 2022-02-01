import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class ajoe
{
  private static ajoe a;
  
  public static ajoe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ajoe();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = aqqx.a(paramString, aqqx.pe, paramDrawable, null, new ajof(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = wja.dp2px(21.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public static String mm(String paramString)
  {
    aenq localaenq = (aenq)aeif.a().o(490);
    if ((localaenq != null) && (localaenq.jX != null)) {
      return (String)localaenq.jX.get(paramString);
    }
    return "";
  }
  
  public boolean arg()
  {
    aenq localaenq = (aenq)aeif.a().o(490);
    return (localaenq != null) && (localaenq.cOe != 0);
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString, ajoh paramajoh)
  {
    if ((paramQQAppInterface == null) || (paramajoh == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    paramQQAppInterface = (aenq)aeif.a().o(490);
                                    switch ((int)paramajoh.type)
                                    {
                                    default: 
                                      return;
                                    }
                                  } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mIconUrl)));
                                  i = VipUtils.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
                                  if ((paramajoh.ada != 0L) || (i <= 0)) {
                                    break;
                                  }
                                  paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "lover1");
                                  paramajoh.bRP = paramajoh.bRP.replace("{vip}", "vip");
                                  return;
                                } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mIconUrl)));
                                i = VipUtils.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
                                if (paramajoh.ada != 1L) {
                                  break;
                                }
                                if (i == 2)
                                {
                                  paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "smallfire");
                                  paramajoh.bRP = paramajoh.bRP.replace("{vip}", "union_vip");
                                  return;
                                }
                              } while (i != 1);
                              paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "smallfire");
                              paramajoh.bRP = paramajoh.bRP.replace("{vip}", "svip");
                              return;
                            } while (paramajoh.ada != 2L);
                            if (i == 2)
                            {
                              paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "bigfire");
                              paramajoh.bRP = paramajoh.bRP.replace("{vip}", "union_vip");
                              return;
                            }
                          } while (i != 1);
                          paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "bigfire");
                          paramajoh.bRP = paramajoh.bRP.replace("{vip}", "svip");
                          return;
                        } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mIconUrl)));
                        i = VipUtils.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                        if (paramajoh.ada != 1L) {
                          break;
                        }
                        if (i == 2)
                        {
                          paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "smallship");
                          paramajoh.bRP = paramajoh.bRP.replace("{vip}", "union_vip");
                          return;
                        }
                      } while (i != 1);
                      paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "smallship");
                      paramajoh.bRP = paramajoh.bRP.replace("{vip}", "svip");
                      return;
                    } while (paramajoh.ada != 2L);
                    if (i == 2)
                    {
                      paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "bigship");
                      paramajoh.bRP = paramajoh.bRP.replace("{vip}", "union_vip");
                      return;
                    }
                  } while (i != 1);
                  paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "bigship");
                  paramajoh.bRP = paramajoh.bRP.replace("{vip}", "svip");
                  return;
                  if ((paramajoh.ada == 1L) && (i > 0))
                  {
                    paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "lover2");
                    paramajoh.bRP = paramajoh.bRP.replace("{vip}", "vip");
                    return;
                  }
                } while ((paramajoh.ada != 2L) || (i <= 0));
                paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "lover3");
                paramajoh.bRP = paramajoh.bRP.replace("{vip}", "vip");
                return;
              } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mIconUrl)));
              i = VipUtils.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
              if ((paramajoh.ada == 0L) && (i > 0))
              {
                paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "sister1");
                paramString = paramajoh.bRP;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramajoh.bRP = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
              if ((paramajoh.ada == 1L) && (i > 0))
              {
                paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "sister2");
                paramString = paramajoh.bRP;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramajoh.bRP = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
            } while ((paramajoh.ada != 2L) || (i <= 0));
            paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "sister3");
            paramString = paramajoh.bRP;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramajoh.bRP = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mIconUrl)));
          i = VipUtils.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
          if ((paramajoh.ada == 0L) && (i > 0))
          {
            paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "brother1");
            paramString = paramajoh.bRP;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramajoh.bRP = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
          if ((paramajoh.ada == 1L) && (i > 0))
          {
            paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "brother2");
            paramString = paramajoh.bRP;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramajoh.bRP = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
        } while ((paramajoh.ada != 2L) || (i <= 0));
        paramajoh.bRP = paramQQAppInterface.mIconUrl.replace("{type}", "brother3");
        paramString = paramajoh.bRP;
        if (i == 1) {}
        for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
        {
          paramajoh.bRP = paramString.replace("{vip}", paramQQAppInterface);
          return;
        }
        i = VipUtils.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
        if ((i == 1) && (paramajoh.ada == 1L))
        {
          paramajoh.bRP = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
          return;
        }
        if ((i == 2) && (paramajoh.ada == 1L))
        {
          paramajoh.bRP = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
          return;
        }
        if ((i == 3) && (paramajoh.ada == 1L))
        {
          paramajoh.bRP = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
          return;
        }
      } while ((i != 4) || (paramajoh.ada != 1L));
      paramajoh.bRP = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
      return;
      if (paramajoh.ada == 1L)
      {
        paramajoh.bRP = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
        return;
      }
      if (paramajoh.ada == 2L)
      {
        paramajoh.bRP = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
        return;
      }
    } while (paramajoh.ada != 3L);
    paramajoh.bRP = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoe
 * JD-Core Version:    0.7.0.1
 */