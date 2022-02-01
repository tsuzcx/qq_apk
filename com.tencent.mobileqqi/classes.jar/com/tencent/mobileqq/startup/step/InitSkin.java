package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqqi.R.color;
import com.tencent.mobileqqi.R.drawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import gjz;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InitSkin
  extends Step
{
  public static boolean a;
  private static final int[] a;
  private static final int[] b = { 2130837605, 2130837606, 2130837608, 2130837609, 2130837611, 2130837612, 2130837613, 2130837614, 2130837627, 2130837652, 2130837669, 2130837716, 2130840539, 2130840536, 2130840537, 2130840534, 2130840535, 2130840540, 2130837724, 2130837725, 2130837726, 2130837744, 2130837764, 2130837766, 2130837790, 2130837791, 2130837793, 2130837794, 2130837800, 2130837801, 2130837802, 2130837803, 2130837839, 2130837840, 2130837845, 2130837855, 2130837859, 2130837863, 2130837884, 2130837887, 2130837892, 2130837922, 2130837936, 2130837946, 2130839941, 2130837979, 2130837998, 2130838784, 2130840538, 2130840529, 2130838010, 2130838020, 2130838021, 2130838022, 2130838033, 2130838034, 2130838121, 2130838137, 2130838159, 2130838340, 2130838341, 2130838342, 2130838343, 2130838507, 2130838508, 2130838509, 2130838620, 2130838621, 2130839020, 2130839021, 2130839025, 2130839026, 2130839028, 2130839029, 2130839030, 2130839031, 2130839041, 2130839222, 2130839223, 2130839224, 2130839225, 2130839226, 2130839227, 2130839228, 2130840542, 2130839229, 2130839230, 2130839232, 2130839233, 2130839234, 2130839236, 2130839240, 2130839241, 2130839242, 2130839243, 2130839244, 2130839247, 2130839249, 2130839250, 2130839251, 2130839252, 2130839253, 2130839254, 2130839255, 2130839256, 2130839257, 2130839259, 2130839260, 2130839261, 2130839262, 2130839263, 2130839264, 2130839265, 2130839266, 2130839267, 2130839268, 2130839269, 2130839270, 2130839273, 2130839276, 2130839280, 2130839281, 2130839282, 2130839283, 2130839284, 2130839285, 2130839286, 2130839287, 2130840548, 2130839288, 2130839289, 2130839290, 2130839291, 2130839293, 2130839295, 2130839296, 2130839297, 2130839298, 2130839299, 2130839300, 2130839302, 2130839303, 2130839305, 2130839306, 2130839308, 2130839309, 2130839310, 2130839311, 2130839312, 2130839313, 2130839314, 2130839315, 2130839316, 2130839317, 2130839318, 2130839319, 2130839320, 2130839321, 2130839322, 2130839323, 2130839324, 2130839325, 2130839326, 2130839327, 2130839328, 2130839329, 2130839330, 2130839331, 2130839332, 2130839333, 2130839334, 2130839336, 2130839345, 2130839347, 2130839348, 2130839349, 2130839350, 2130839351, 2130839352, 2130839361, 2130839362, 2130839364, 2130839365, 2130839366, 2130839367, 2130839372, 2130839373, 2130839374, 2130839375, 2130839376, 2130839377, 2130839378, 2130839379, 2130840531, 2130840532, 2130839381, 2130839382, 2130839383, 2130840541, 2130839387, 2130839388, 2130839389, 2130839390, 2130839391, 2130839392, 2130839393, 2130840546, 2130840547, 2130839394, 2130839395, 2130839396, 2130839397, 2130839398, 2130839400, 2130839401, 2130839402, 2130839403, 2130839404, 2130839405, 2130839407, 2130839409, 2130839410, 2130839411, 2130839412, 2130839413, 2130839415, 2130839416, 2130839417, 2130839425, 2130839426, 2130839427, 2130839428, 2130839429, 2130839430, 2130839431, 2130839432, 2130839433, 2130839434, 2130839435, 2130839436, 2130839437, 2130839438, 2130839439, 2130839440, 2130839441, 2130839442, 2130839443, 2130839444, 2130839445, 2130839446, 2130839447, 2130839448, 2130839449, 2130839451, 2130839452, 2130839453, 2130839454, 2130839455, 2130839456, 2130839457, 2130839458, 2130839459, 2130839460, 2130839461, 2130839462, 2130839463, 2130839465, 2130839466, 2130839467, 2130839468, 2130839469, 2130839470, 2130839471, 2130839472, 2130839473, 2130839474, 2130839475, 2130839476, 2130839477, 2130839478, 2130839479, 2130839484, 2130839486, 2130839487, 2130839488, 2130839489, 2130839490, 2130839491, 2130839492, 2130839493, 2130839494, 2130840544, 2130839496, 2130839499, 2130839500, 2130839502, 2130839503, 2130839504, 2130839505, 2130839506, 2130839507, 2130839510, 2130839511, 2130839512, 2130839513, 2130839514, 2130839517, 2130839518, 2130839519, 2130839520, 2130839523, 2130839524, 2130839525, 2130839526, 2130839527, 2130839528, 2130839532, 2130839533, 2130839534, 2130839535, 2130839536, 2130839537, 2130839538, 2130839539, 2130839541, 2130839542, 2130839543, 2130839544, 2130839545, 2130839546, 2130839550, 2130839574, 2130839575, 2130839576, 2130839577, 2130839578, 2130839579, 2130839580, 2130839581, 2130839582, 2130839583, 2130839584, 2130839587, 2130839590, 2130839596, 2130839597, 2130839599, 2130839600, 2130839601, 2130839602, 2130839605, 2130839606, 2130839607, 2130839608, 2130839609, 2130839612, 2130839613, 2130839614, 2130839615, 2130839616, 2130839617, 2130839618, 2130839619, 2130839620, 2130839621, 2130839622, 2130839623, 2130839624, 2130839641, 2130839642, 2130839643, 2130839644, 2130839645, 2130839647, 2130839693, 2130839703, 2130839704, 2130839705, 2130839716, 2130839714, 2130839715, 2130839717, 2130839719, 2130839721, 2130839767, 2130839770, 2130839787, 2130839788, 2130839789, 2130839790, 2130839791, 2130839804, 2130840063, 2130840064, 2130840065, 2130840066, 2130840067, 2130840071, 2130840072, 2130840073, 2130840082, 2130840083, 2130840084, 2130840085, 2130840086, 2130840087, 2130840088, 2130840100, 2130840102, 2130840105, 2130840106, 2130840107, 2130840108, 2130840109, 2130840110, 2130840111, 2130840112, 2130840118, 2130840119, 2130840120, 2130840121, 2130840122, 2130840123, 2130840124, 2130840126, 2130840127, 2130840129, 2130840130, 2130840134, 2130840137, 2130840149, 2130840150, 2130840151, 2130840152, 2130840154, 2130840155, 2130840156, 2130840157, 2130840158, 2130840159, 2130840160, 2130840161, 2130840162, 2130840163, 2130840164, 2130840165, 2130840166, 2130840167, 2130840168, 2130840169, 2130840171, 2130840172, 2130840173, 2130840174, 2130840175, 2130840177, 2130840178, 2130840179, 2130840180, 2130840185, 2130840186, 2130840187, 2130840188, 2130840212, 2130840213, 2130840241, 2130840319, 2130840321, 2130840325, 2130840327, 2130840328, 2130840329, 2130840511, 2130840346, 2130840348, 2130840506, 2130840507, 2130840508, 2130840509, 2130840510 };
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837605, 2130837606, 2130837608, 2130837609, 2130837611, 2130837612, 2130837613, 2130837614, 2130837840, 2130837839, 2130839767, 2130840224, 2130840223, 2130839529, 2130838013, 2130838012, 2130840330, 2130840100, 2130840102, 2130840105, 2130840106, 2130840107, 2130840108, 2130840109, 2130840110, 2130840111, 2130840334, 2130840490, 2130840489, 2130838040, 2130838038, 2130838039, 2130838037, 2130838035, 2130838036, 2130838583, 2130838581, 2130838582, 2130838043, 2130838041, 2130838042, 2130837724, 2130840511, 2130838187, 2130838188, 2130838189, 2130838190 };
  }
  
  public static final boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.DEBUG = false;
        if (!AppSetting.d) {
          continue;
        }
        localFile1 = new File(localFile2, "/skin/web_config");
        localFile2 = new File(localFile2, "/skin/web_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131361792, null);
        ThreadManager.b().postDelayed(new gjz("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131361792, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "web skin ignore skinEngine accered.");
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"603".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131361792, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131361792, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label524;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131361792, null);
      ThreadManager.b().postDelayed(new gjz("/skin/web_config", "/skin/web_skin_cache"), 10000L);
    }
  }
  
  public static final boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.DEBUG = false;
        if (!AppSetting.d) {
          continue;
        }
        localFile1 = new File(localFile2, "/skin/qzone_config");
        localFile2 = new File(localFile2, "/skin/qzone_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, b, R.color.class, 2131361792, null);
        ThreadManager.b().postDelayed(new gjz("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
        continue;
        SkinEngine.init(paramContext, b, R.color.class, 2131361792, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qzone skin ignore skinEngine accered.");
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"603".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, b, R.color.class, 2131361792, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, b, R.color.class, 2131361792, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837729);
      SkinEngine.getInstances().addDrawableResource(2130837757);
      SkinEngine.getInstances().addDrawableResource(2130837852);
      SkinEngine.getInstances().addDrawableResource(2130837765);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label560;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin cache time out");
      }
      SkinEngine.init(paramContext, b, R.color.class, 2131361792, null);
      ThreadManager.b().postDelayed(new gjz("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
    }
  }
  
  public static final boolean initSkin(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.DEBUG = false;
        if (!AppSetting.d) {
          continue;
        }
        localFile1 = new File(localFile2, "/skin/config");
        localFile2 = new File(localFile2, "/skin/skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131361792, null);
        ThreadManager.b().postDelayed(new gjz("/skin/config", "/skin/skin_cache"), 10000L);
        continue;
        SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131361792, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "ignore skinEngine accered.");
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"603".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131361792, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
        SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131361792, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837729);
      SkinEngine.getInstances().addDrawableResource(2130837757);
      SkinEngine.getInstances().addDrawableResource(2130837852);
      SkinEngine.getInstances().addDrawableResource(2130837765);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label575;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "cache time out");
      }
      SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131361792, null);
      ThreadManager.b().postDelayed(new gjz("/skin/config", "/skin/skin_cache"), 10000L);
    }
  }
  
  protected boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return true;
      jdField_a_of_type_Boolean = true;
      String[] arrayOfString = BaseApplicationImpl.processName.split(":");
      str = null;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
      if ((str == null) || (str.endsWith("map")) || (str.equals("pedit")) || (str.equals("openSdk")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")))
      {
        initSkin(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
      if (str.equals("qzone"))
      {
        b(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
    } while (!str.equals("web"));
    a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */