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
import goj;
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
  private static final int[] b = { 2130837605, 2130837606, 2130837608, 2130837609, 2130837611, 2130837612, 2130837613, 2130837614, 2130837627, 2130837652, 2130837669, 2130837716, 2130840537, 2130840534, 2130840535, 2130840532, 2130840533, 2130840538, 2130837724, 2130837725, 2130837726, 2130837744, 2130837763, 2130837765, 2130837789, 2130837790, 2130837792, 2130837793, 2130837799, 2130837800, 2130837801, 2130837802, 2130837837, 2130837838, 2130837843, 2130837853, 2130837857, 2130837861, 2130837882, 2130837885, 2130837890, 2130837920, 2130837934, 2130837944, 2130839941, 2130837977, 2130837996, 2130838784, 2130840536, 2130840527, 2130838008, 2130838018, 2130838019, 2130838020, 2130838031, 2130838032, 2130838119, 2130838135, 2130838157, 2130838338, 2130838339, 2130838340, 2130838341, 2130838505, 2130838506, 2130838507, 2130838618, 2130838619, 2130839018, 2130839019, 2130839023, 2130839024, 2130839026, 2130839027, 2130839028, 2130839029, 2130839039, 2130839220, 2130839221, 2130839222, 2130839223, 2130839224, 2130839225, 2130839226, 2130840540, 2130839227, 2130839228, 2130839230, 2130839231, 2130839232, 2130839234, 2130839238, 2130839239, 2130839240, 2130839241, 2130839242, 2130839245, 2130839247, 2130839248, 2130839249, 2130839250, 2130839251, 2130839252, 2130839253, 2130839254, 2130839255, 2130839257, 2130839258, 2130839259, 2130839260, 2130839261, 2130839262, 2130839263, 2130839264, 2130839265, 2130839266, 2130839267, 2130839268, 2130839271, 2130839274, 2130839278, 2130839279, 2130839280, 2130839281, 2130839282, 2130839283, 2130839284, 2130839285, 2130840546, 2130839286, 2130839287, 2130839288, 2130839289, 2130839291, 2130839293, 2130839294, 2130839295, 2130839296, 2130839297, 2130839298, 2130839300, 2130839301, 2130839303, 2130839304, 2130839306, 2130839307, 2130839308, 2130839309, 2130839310, 2130839311, 2130839312, 2130839313, 2130839314, 2130839315, 2130839316, 2130839317, 2130839318, 2130839319, 2130839320, 2130839321, 2130839322, 2130839323, 2130839324, 2130839325, 2130839326, 2130839327, 2130839328, 2130839329, 2130839330, 2130839331, 2130839332, 2130839334, 2130839343, 2130839345, 2130839346, 2130839347, 2130839348, 2130839349, 2130839350, 2130839359, 2130839360, 2130839362, 2130839363, 2130839364, 2130839365, 2130839370, 2130839371, 2130839372, 2130839373, 2130839374, 2130839375, 2130839376, 2130839377, 2130840529, 2130840530, 2130839379, 2130839380, 2130839381, 2130840539, 2130839385, 2130839386, 2130839387, 2130839388, 2130839389, 2130839390, 2130839391, 2130840544, 2130840545, 2130839392, 2130839393, 2130839394, 2130839395, 2130839396, 2130839398, 2130839399, 2130839400, 2130839401, 2130839402, 2130839403, 2130839405, 2130839407, 2130839408, 2130839409, 2130839410, 2130839411, 2130839413, 2130839414, 2130839415, 2130839423, 2130839424, 2130839425, 2130839426, 2130839427, 2130839428, 2130839429, 2130839430, 2130839431, 2130839432, 2130839433, 2130839434, 2130839435, 2130839436, 2130839437, 2130839438, 2130839439, 2130839440, 2130839441, 2130839442, 2130839443, 2130839444, 2130839445, 2130839446, 2130839447, 2130839449, 2130839450, 2130839451, 2130839452, 2130839453, 2130839454, 2130839455, 2130839456, 2130839457, 2130839458, 2130839459, 2130839460, 2130839461, 2130839463, 2130839464, 2130839465, 2130839466, 2130839467, 2130839468, 2130839469, 2130839470, 2130839471, 2130839472, 2130839473, 2130839474, 2130839475, 2130839476, 2130839477, 2130839482, 2130839484, 2130839485, 2130839486, 2130839487, 2130839488, 2130839489, 2130839490, 2130839491, 2130839492, 2130840542, 2130839494, 2130839497, 2130839498, 2130839500, 2130839501, 2130839502, 2130839503, 2130839504, 2130839505, 2130839508, 2130839509, 2130839510, 2130839511, 2130839512, 2130839515, 2130839516, 2130839517, 2130839518, 2130839521, 2130839522, 2130839523, 2130839524, 2130839525, 2130839526, 2130839530, 2130839531, 2130839532, 2130839533, 2130839534, 2130839535, 2130839536, 2130839537, 2130839539, 2130839540, 2130839541, 2130839542, 2130839543, 2130839544, 2130839548, 2130839572, 2130839573, 2130839574, 2130839575, 2130839576, 2130839577, 2130839578, 2130839579, 2130839580, 2130839581, 2130839582, 2130839585, 2130839588, 2130839594, 2130839595, 2130839597, 2130839598, 2130839599, 2130839600, 2130839603, 2130839604, 2130839605, 2130839606, 2130839607, 2130839610, 2130839611, 2130839612, 2130839613, 2130839614, 2130839615, 2130839616, 2130839617, 2130839618, 2130839619, 2130839620, 2130839621, 2130839622, 2130839639, 2130839640, 2130839641, 2130839642, 2130839643, 2130839645, 2130839691, 2130839701, 2130839702, 2130839703, 2130839714, 2130839712, 2130839713, 2130839715, 2130839717, 2130839719, 2130839765, 2130839768, 2130839785, 2130839786, 2130839787, 2130839788, 2130839789, 2130839802, 2130840061, 2130840062, 2130840063, 2130840064, 2130840065, 2130840069, 2130840070, 2130840071, 2130840080, 2130840081, 2130840082, 2130840083, 2130840084, 2130840085, 2130840086, 2130840098, 2130840100, 2130840103, 2130840104, 2130840105, 2130840106, 2130840107, 2130840108, 2130840109, 2130840110, 2130840116, 2130840117, 2130840118, 2130840119, 2130840120, 2130840121, 2130840122, 2130840124, 2130840125, 2130840127, 2130840128, 2130840132, 2130840135, 2130840147, 2130840148, 2130840149, 2130840150, 2130840152, 2130840153, 2130840154, 2130840155, 2130840156, 2130840157, 2130840158, 2130840159, 2130840160, 2130840161, 2130840162, 2130840163, 2130840164, 2130840165, 2130840166, 2130840167, 2130840169, 2130840170, 2130840171, 2130840172, 2130840173, 2130840175, 2130840176, 2130840177, 2130840178, 2130840183, 2130840184, 2130840185, 2130840186, 2130840210, 2130840211, 2130840239, 2130840317, 2130840319, 2130840323, 2130840325, 2130840326, 2130840327, 2130840509, 2130840344, 2130840346, 2130840504, 2130840505, 2130840506, 2130840507, 2130840508 };
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837605, 2130837606, 2130837608, 2130837609, 2130837611, 2130837612, 2130837613, 2130837614, 2130837838, 2130837837, 2130839765, 2130840222, 2130840221, 2130839527, 2130838011, 2130838010, 2130840328, 2130840098, 2130840100, 2130840103, 2130840104, 2130840105, 2130840106, 2130840107, 2130840108, 2130840109, 2130840332, 2130840488, 2130840487, 2130838038, 2130838036, 2130838037, 2130838035, 2130838033, 2130838034, 2130838581, 2130838579, 2130838580, 2130838041, 2130838039, 2130838040, 2130837724, 2130840509, 2130838185, 2130838186, 2130838187, 2130838188 };
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
        ThreadManager.b().postDelayed(new goj("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
        if ((i != AppSetting.a) || (!"25030".equals(str))) {
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
      ThreadManager.b().postDelayed(new goj("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
        ThreadManager.b().postDelayed(new goj("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        if ((i != AppSetting.a) || (!"25030".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130837756);
      SkinEngine.getInstances().addDrawableResource(2130837850);
      SkinEngine.getInstances().addDrawableResource(2130837764);
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
      ThreadManager.b().postDelayed(new goj("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        ThreadManager.b().postDelayed(new goj("/skin/config", "/skin/skin_cache"), 10000L);
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
        if ((i != AppSetting.a) || (!"25030".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130837756);
      SkinEngine.getInstances().addDrawableResource(2130837850);
      SkinEngine.getInstances().addDrawableResource(2130837764);
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
      ThreadManager.b().postDelayed(new goj("/skin/config", "/skin/skin_cache"), 10000L);
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