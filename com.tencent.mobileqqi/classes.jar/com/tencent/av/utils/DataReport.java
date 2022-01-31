package com.tencent.av.utils;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class DataReport
{
  static boolean a;
  static boolean b = false;
  static boolean c = false;
  static boolean d = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().e())
        {
          ReportController.b(null, "CliOper", "", "", "0X800436B", "0X800436B", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800434C", "0X800434C", 0, 0, String.valueOf(PhoneStatusTools.a(paramVideoController.a())), "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().e())
    {
      ReportController.b(null, "CliOper", "", "", "0X80043CB", "0X80043CB", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043B7", "0X80043B7", 0, 0, String.valueOf(PhoneStatusTools.a(paramVideoController.a())), "", "", "");
  }
  
  public static void a(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().e())
        {
          if (paramBoolean)
          {
            ReportController.b(null, "CliOper", "", "", "0X8004373", "0X8004373", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004378", "0X8004378", 0, 0, "", "", "", "");
          return;
        }
        if (paramBoolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X800434F", "0X800434F", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004350", "0X8004350", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().e())
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X80043D3", "0X80043D3", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043D4", "0X80043D4", 0, 0, "", "", "", "");
      return;
    }
    if (paramBoolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X80043BA", "0X80043BA", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043BB", "0X80043BB", 0, 0, "", "", "", "");
  }
  
  public static void b(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().e())
        {
          ReportController.b(null, "CliOper", "", "", "0X800436C", "0X800436C", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800434D", "0X800434D", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().e())
    {
      ReportController.b(null, "CliOper", "", "", "0X80043CC", "0X80043CC", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043B8", "0X80043B8", 0, 0, "", "", "", "");
  }
  
  public static void b(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramBoolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X800436D", "0X800436D", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800436F", "0X800436F", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramBoolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X80043CD", "0X80043CD", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043CF", "0X80043CF", 0, 0, "", "", "", "");
  }
  
  public static void c(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().e())
        {
          if (paramVideoController.a().b)
          {
            ReportController.b(null, "CliOper", "", "", "0X8004381", "0X8004381", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004382", "0X8004382", 0, 0, "", "", "", "");
          return;
        }
        if (paramVideoController.a().b)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004353", "0X8004353", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004354", "0X8004354", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().e())
    {
      if (paramVideoController.a().b)
      {
        ReportController.b(null, "CliOper", "", "", "0X80043DC", "0X80043DC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043DD", "0X80043DD", 0, 0, "", "", "", "");
      return;
    }
    if (paramVideoController.a().b)
    {
      ReportController.b(null, "CliOper", "", "", "0X80043BE", "0X80043BE", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043BF", "0X80043BF", 0, 0, "", "", "", "");
  }
  
  public static void c(VideoController paramVideoController, boolean paramBoolean)
  {
    if ((paramVideoController == null) || (paramVideoController.a().jdField_a_of_type_Long == 0L)) {
      return;
    }
    Object localObject1 = paramVideoController.a();
    int j = paramVideoController.a().m;
    AudioManager localAudioManager = (AudioManager)((Context)localObject1).getSystemService("audio");
    int i = localAudioManager.getStreamVolume(j);
    j = localAudioManager.getStreamMaxVolume(j);
    i = (int)(i / j * 100.0F);
    if (i < 30) {
      i = 1;
    }
    for (;;)
    {
      label75:
      localObject1 = paramVideoController.a().i;
      String str;
      label98:
      Object localObject2;
      if ("DEVICE_EARPHONE".equals(localObject1))
      {
        str = "0";
        j = paramVideoController.a().jdField_a_of_type_Int;
        if (j != 1) {
          break label392;
        }
        switch (i)
        {
        default: 
          localObject1 = null;
          label143:
          localObject2 = localObject1;
          if (paramBoolean)
          {
            localObject2 = localObject1;
            if (paramVideoController.a().jdField_a_of_type_Boolean) {
              if (localAudioManager.isBluetoothA2dpOn())
              {
                str = "3";
                paramVideoController = (VideoController)localObject1;
                localObject1 = str;
              }
            }
          }
          break;
        }
      }
      while ((paramVideoController != null) && (localObject1 != null))
      {
        ReportController.b(null, "CliOper", "", "", paramVideoController, paramVideoController, 0, 0, (String)localObject1, "", "", "");
        return;
        if ((i >= 30) && (i <= 70))
        {
          i = 2;
          break label75;
        }
        if (i <= 70) {
          break label580;
        }
        i = 3;
        break label75;
        if ("DEVICE_SPEAKERPHONE".equals(localObject1))
        {
          str = "1";
          break label98;
        }
        if ("DEVICE_WIREDHEADSET".equals(localObject1))
        {
          str = "2";
          break label98;
        }
        if ("DEVICE_BLUETOOTHHEADSET".equals(localObject1))
        {
          str = "3";
          break label98;
        }
        str = "4";
        break label98;
        if (paramBoolean)
        {
          localObject1 = "0X800437B";
          break label143;
        }
        localObject1 = "0X800437E";
        break label143;
        if (paramBoolean)
        {
          localObject1 = "0X800437C";
          break label143;
        }
        localObject1 = "0X800437F";
        break label143;
        if (paramBoolean)
        {
          localObject1 = "0X800437D";
          break label143;
        }
        localObject1 = "0X8004380";
        break label143;
        if (localAudioManager.isWiredHeadsetOn())
        {
          str = "2";
          paramVideoController = (VideoController)localObject1;
          localObject1 = str;
        }
        else
        {
          str = "0";
          paramVideoController = (VideoController)localObject1;
          localObject1 = str;
          continue;
          label392:
          if (j == 2)
          {
            switch (i)
            {
            default: 
              localObject1 = null;
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (!paramBoolean) {
                break label561;
              }
              localObject2 = localObject1;
              if (!paramVideoController.a().jdField_a_of_type_Boolean) {
                break label561;
              }
              if (!localAudioManager.isBluetoothA2dpOn()) {
                break label525;
              }
              str = "3";
              paramVideoController = (VideoController)localObject1;
              localObject1 = str;
              break;
              if (paramBoolean)
              {
                localObject1 = "0X80043D6";
              }
              else
              {
                localObject1 = "0X80043D9";
                continue;
                if (paramBoolean)
                {
                  localObject1 = "0X80043D7";
                }
                else
                {
                  localObject1 = "0X80043DA";
                  continue;
                  if (paramBoolean) {
                    localObject1 = "0X80043D8";
                  } else {
                    localObject1 = "0X80043DB";
                  }
                }
              }
            }
            label525:
            if (localAudioManager.isWiredHeadsetOn())
            {
              str = "2";
              paramVideoController = (VideoController)localObject1;
              localObject1 = str;
            }
            else
            {
              str = "1";
              paramVideoController = (VideoController)localObject1;
              localObject1 = str;
              continue;
              label561:
              localObject1 = str;
              paramVideoController = localObject2;
            }
          }
          else
          {
            localObject1 = str;
            paramVideoController = null;
          }
        }
      }
      label580:
      i = 0;
    }
  }
  
  public static void d(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    String str;
    int i;
    label229:
    do
    {
      return;
      switch (paramVideoController.a().jdField_l_of_type_Int)
      {
      default: 
        str = "8";
      }
      for (;;)
      {
        i = paramVideoController.a().jdField_a_of_type_Int;
        if (i != 1) {
          break label229;
        }
        if (!paramVideoController.a().e()) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004389", "0X8004389", 0, 0, "", "", "", "");
        return;
        if (paramVideoController.a().h >= 0)
        {
          str = "1";
        }
        else
        {
          str = "0";
          continue;
          if (!paramVideoController.a().k)
          {
            str = "2";
          }
          else
          {
            str = "4";
            continue;
            str = "3";
            continue;
            str = "5";
            continue;
            str = "6";
            continue;
            str = "7";
            continue;
            str = "9";
          }
        }
      }
      ReportController.b(null, "CliOper", "", "", "0X8004358", "0X8004358", 0, 0, str, "", "", "");
      return;
    } while (i != 2);
    if (paramVideoController.a().e())
    {
      ReportController.b(null, "CliOper", "", "", "0X80043E4", "0X80043E4", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043C3", "0X80043C3", 0, 0, str, "", "", "");
  }
  
  public static void d(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramBoolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004385", "0X8004385", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004387", "0X8004387", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramBoolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X80043E0", "0X80043E0", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043E2", "0X80043E2", 0, 0, "", "", "", "");
  }
  
  public static void e(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004359", "0X8004359", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043C4", "0X80043C4", 0, 0, "", "", "", "");
  }
  
  public static void e(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {}
    label164:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              i = paramVideoController.a().jdField_a_of_type_Int;
              if (i != 1) {
                break label164;
              }
              if (!paramBoolean) {
                break;
              }
            } while (paramVideoController.a().jdField_a_of_type_Boolean);
            if (paramVideoController.a().b)
            {
              ReportController.b(null, "CliOper", "", "", "0X8004356", "0X8004356", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(null, "CliOper", "", "", "0X8004355", "0X8004355", 0, 0, "", "", "", "");
            return;
          } while (paramVideoController.a().jdField_a_of_type_Long <= 0L);
          if (paramVideoController.a().b)
          {
            ReportController.b(null, "CliOper", "", "", "0X8004384", "0X8004384", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004383", "0X8004383", 0, 0, "", "", "", "");
          return;
        } while (i != 2);
        if (!paramBoolean) {
          break;
        }
      } while (paramVideoController.a().jdField_a_of_type_Boolean);
      if (paramVideoController.a().b)
      {
        ReportController.b(null, "CliOper", "", "", "0X80043C1", "0X80043C1", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80043C0", "0X80043C0", 0, 0, "", "", "", "");
      return;
    } while (paramVideoController.a().jdField_a_of_type_Long <= 0L);
    if (paramVideoController.a().b)
    {
      ReportController.b(null, "CliOper", "", "", "0X80043DF", "0X80043DF", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043DE", "0X80043DE", 0, 0, "", "", "", "");
  }
  
  public static void f(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X800435A", "0X800435A", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043C5", "0X80043C5", 0, 0, "", "", "", "");
  }
  
  public static void g(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X800435C", "0X800435C", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043C7", "0X80043C7", 0, 0, "", "", "", "");
  }
  
  public static void h(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X800435E", "0X800435E", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043C9", "0X80043C9", 0, 0, "", "", "", "");
  }
  
  public static void i(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004394", "0X8004394", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043F2", "0X80043F2", 0, 0, "", "", "", "");
  }
  
  public static void j(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    while (paramVideoController.a().jdField_a_of_type_Int != 2) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043E6", "0X80043E6", 0, 0, "", "", "", "");
  }
  
  public static void k(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004370", "0X8004370", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043D0", "0X80043D0", 0, 0, "", "", "", "");
  }
  
  public static void l(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004371", "0X8004371", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043D1", "0X80043D1", 0, 0, "", "", "", "");
  }
  
  public static void m(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004372", "0X8004372", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043D2", "0X80043D2", 0, 0, "", "", "", "");
  }
  
  public static void n(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004388", "0X8004388", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043E3", "0X80043E3", 0, 0, "", "", "", "");
  }
  
  public static void o(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().n)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004351", "0X8004351", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004352", "0X8004352", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().n)
    {
      ReportController.b(null, "CliOper", "", "", "0X80043BC", "0X80043BC", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043BD", "0X80043BD", 0, 0, "", "", "", "");
  }
  
  public static void p(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    while ((!paramVideoController.a().e()) || (paramVideoController.a().jdField_a_of_type_Int != 1) || (paramVideoController.a().n)) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8004379", "0X8004379", 0, 0, "", "", "", "");
  }
  
  public static void q(VideoController paramVideoController)
  {
    if (jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
        jdField_a_of_type_Boolean = true;
      } while ((paramVideoController == null) || (!paramVideoController.a().e()));
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X800437A", "0X800437A", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043D5", "0X80043D5", 0, 0, "", "", "", "");
  }
  
  public static void r(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    String str;
    int i;
    label245:
    do
    {
      return;
      str = "";
      if (!paramVideoController.a().jdField_l_of_type_Boolean) {
        switch (paramVideoController.a().jdField_l_of_type_Int)
        {
        default: 
          str = "8";
        }
      }
      for (;;)
      {
        i = paramVideoController.a().jdField_a_of_type_Int;
        if (i != 1) {
          break label245;
        }
        if (!paramVideoController.a().e()) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X800438A", "0X800438A", 0, 0, "", "", "", "");
        return;
        if (paramVideoController.a().h >= 0)
        {
          str = "1";
        }
        else
        {
          str = "0";
          continue;
          if (!paramVideoController.a().k)
          {
            str = "2";
          }
          else
          {
            str = "4";
            continue;
            str = "3";
            continue;
            str = "5";
            continue;
            str = "6";
            continue;
            str = "7";
            continue;
            str = "9";
          }
        }
      }
      ReportController.b(null, "CliOper", "", "", "0X800435B", "0X800435B", 0, 0, str, "", "", "");
      return;
    } while (i != 2);
    if (paramVideoController.a().e())
    {
      ReportController.b(null, "CliOper", "", "", "0X80043E5", "0X80043E5", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043C6", "0X80043C6", 0, 0, str, "", "", "");
  }
  
  public static void s(VideoController paramVideoController)
  {
    if (b) {}
    do
    {
      return;
      b = true;
    } while ((paramVideoController == null) || ((!paramVideoController.a().e) && (!paramVideoController.a().f)));
    ReportController.b(null, "CliOper", "", "", "0X800438F", "0X800438F", 0, 0, "", "", "", "");
  }
  
  public static void t(VideoController paramVideoController)
  {
    if (c) {}
    do
    {
      return;
      c = true;
    } while ((paramVideoController == null) || (paramVideoController.a().e) || (paramVideoController.a().f));
    ReportController.b(null, "CliOper", "", "", "0X80043EB", "0X80043EB", 0, 0, "", "", "", "");
  }
  
  public static void u(VideoController paramVideoController)
  {
    if (d) {}
    int i;
    do
    {
      do
      {
        return;
        d = true;
      } while (paramVideoController == null);
      i = paramVideoController.a().jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004395", "0X8004395", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    ReportController.b(null, "CliOper", "", "", "0X80043F3", "0X80043F3", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.DataReport
 * JD-Core Version:    0.7.0.1
 */