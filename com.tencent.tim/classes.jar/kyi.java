import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.Aladdin.InitParams;
import com.tencent.aladdin.config.Aladdin.InitParams.Builder;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils.1;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.OccasionRule;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyRule;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.AwesomeCommentConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportDataConfigHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Arrays;

public class kyi
{
  public static final int[] df = { 1, 3, 40, 41, 111, 112, 116, 117, 119, 156, 121, 122, 123, 124, 127, 131, 133, 134, 132, 136, 139, 135, 138, 144, 140, 142, 145, 147, 148, 149, 151, 152, 153, 154, 155, 157, 159, 160, 161, 162, 164, 165, 167, 168, 169, 171, 170, 172, 173, 174, 176, 177, 178, 180, 179, 181, 182, 183, 185, 187, 186, 194, 190, 189, 188, 192, 193, 191, 196, 199, 200, 201, 204, 202, 205, 206, 207, 208, 209, 211, 212, 214, 215, 216, 218, 219, 217, 220, 221, 222, 197, 223, 225, 226, 246, 227, 226, 228, 227, 230, 232, 234, 243, 238, 239, 242, 244, 245, 247, 250, 252, 251, 254, 253, 255, 256, 259, 258, 260, 261, 263, 262, 264, 265, 269, 271, 272, 273, 274, 272, 267, 266, 276, 277, 278, 280, 282, 279, 275, 281, 283, 284, 285, 286, 287, 288, 290, 306, 289, 293, 298, 300, 304, 305, 293, 295, 301, 297, 302, 303, 307, 309, 312, 240, 314, 315 };
  
  static
  {
    Aladdin.registerConfigHandler(111, new kym());
    Aladdin.registerConfigHandler(112, new kzo());
    Aladdin.registerConfigHandler(116, new kzp());
    Aladdin.registerConfigHandler(117, new kyn());
    Aladdin.registerConfigHandler(119, new kzq());
    Aladdin.registerConfigHandler(156, new kzd());
    Aladdin.registerConfigHandler(121, new KandianReportDataConfigHandler());
    Aladdin.registerConfigHandler(122, new kyt());
    Aladdin.registerConfigHandler(123, new kza());
    Aladdin.registerConfigHandler(124, new kzn());
    Aladdin.registerConfigHandler(127, new kyy());
    Aladdin.registerConfigHandler(131, new kyx());
    Aladdin.registerConfigHandler(133, new kzk());
    Aladdin.registerConfigHandler(132, new kze());
    Aladdin.registerConfigHandler(134, new kyw());
    Aladdin.registerConfigHandler(135, new kys());
    Aladdin.registerConfigHandler(138, new AwesomeCommentConfigHandler());
    Aladdin.registerConfigHandler(142, new kzb());
    Aladdin.registerConfigHandler(147, new kyk());
    Aladdin.registerConfigHandler(148, new kyl());
    Aladdin.registerConfigHandler(149, new kyz());
    Aladdin.registerConfigHandler(155, new kyv());
    Aladdin.registerConfigHandler(162, new kyp());
    Aladdin.registerConfigHandler(170, new kyo());
    Aladdin.registerConfigHandler(181, new kyq());
    Aladdin.registerConfigHandler(182, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(185, new klb());
    Aladdin.registerConfigHandler(187, new kgh());
    Aladdin.registerConfigHandler(188, new klb());
    Aladdin.registerConfigHandler(157, new kyr());
    Aladdin.registerConfigHandler(191, new kzm());
    Aladdin.registerConfigHandler(200, new klf());
    Aladdin.registerConfigHandler(202, new kzj());
    Aladdin.registerConfigHandler(211, new kzr());
    Aladdin.registerConfigHandler(219, new kzc());
    Aladdin.registerConfigHandler(221, new kyu());
    Aladdin.registerConfigHandler(197, new kzs());
    Aladdin.registerConfigHandler(247, new kzu());
    Aladdin.registerConfigHandler(244, new kzf());
    Aladdin.registerConfigHandler(274, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(280, new kzi());
    Aladdin.registerConfigHandler(282, new kzt());
    Aladdin.registerConfigHandler(287, new kzv());
    Aladdin.registerConfigHandler(290, new kzl());
    Aladdin.registerConfigHandler(304, new kzh());
    Aladdin.registerConfigHandler(305, new kzg());
  }
  
  public static void aIg()
  {
    Aladdin.initialize(Aladdin.InitParams.newBuilder().withUserId(kxm.getAccount()).withAppVersion("3.4.4").withContext(BaseApplicationImpl.getContext()).withExecutor(kyj.a).withRequestHandler(new kyh()).withAppFlavorId(AppSetting.getAppId() + "").withLogger(new kyf()).build());
    Aladdin.registerBeanClass("SneakyParams", SneakyParams.class);
    Aladdin.registerBeanClass("AchillesParams", AchillesParams.class);
    Aladdin.registerBeanClass("SneakyRule", SneakyRule.class);
    Aladdin.registerBeanClass("OccasionRule", OccasionRule.class);
    Aladdin.registerConfigParser(136, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(139, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(140, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    aIh();
  }
  
  private static void aIh()
  {
    ThreadManagerV2.executeOnSubThread(new QQAladdinUtils.1());
  }
  
  public static void aIi()
  {
    Object localObject = kzl.u();
    if ((localObject == null) || (localObject.length == 0))
    {
      Aladdin.requestForUpdate(df);
      return;
    }
    int[] arrayOfInt = b((int[])localObject);
    if (arrayOfInt != null)
    {
      localObject = arrayOfInt;
      if (arrayOfInt.length > df.length) {}
    }
    else
    {
      localObject = df;
    }
    Aladdin.requestForUpdate((int[])localObject);
  }
  
  private static int[] b(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return df;
    }
    try
    {
      int[] arrayOfInt = new int[df.length + paramArrayOfInt.length];
      arrayOfInt = Arrays.copyOf(df, arrayOfInt.length);
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, df.length, paramArrayOfInt.length);
      return arrayOfInt;
    }
    catch (Throwable paramArrayOfInt)
    {
      QLog.d("mergeIds", 1, "mergeIds error: " + paramArrayOfInt.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyi
 * JD-Core Version:    0.7.0.1
 */