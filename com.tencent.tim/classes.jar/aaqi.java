import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class aaqi
{
  public static int ciB = 0;
  
  public static void B(String paramString1, String paramString2, String paramString3)
  {
    anot.a(null, "CliOper", paramString1, "", paramString2, paramString2, ciB, 0, paramString3, "", "", "");
  }
  
  public static void Gf(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      ciB = i;
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
    }
  }
  
  public static boolean WS()
  {
    return ilp.checkAVCameraUsed(BaseApplicationImpl.getContext());
  }
  
  public static String a(FlowActivity paramFlowActivity)
  {
    return paramFlowActivity.getAppRuntime().getAccount();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str1 = paramString2;
    String str2;
    String str3;
    if (paramHashMap != null)
    {
      str2 = (String)paramHashMap.get("cameraType");
      str3 = (String)paramHashMap.get("isTemplateMode");
      paramHashMap = (String)paramHashMap.get("templateId");
      if ((!String.valueOf(2).equals(str2)) || ((!String.valueOf(false).equals(str3)) && (paramHashMap != null))) {
        break label99;
      }
      str1 = "0X8007819";
    }
    for (;;)
    {
      ec(paramString1, str1);
      return;
      label99:
      if ((String.valueOf(2).equals(str2)) && (String.valueOf(true).equals(str3)) && (paramHashMap != null))
      {
        str1 = "0X800781A";
      }
      else if ((String.valueOf(1).equals(str2)) && ((String.valueOf(false).equals(str3)) || (paramHashMap == null)))
      {
        str1 = "0X800781B";
      }
      else
      {
        str1 = paramString2;
        if (String.valueOf(1).equals(str2))
        {
          str1 = paramString2;
          if (String.valueOf(true).equals(str3))
          {
            str1 = paramString2;
            if (paramHashMap != null) {
              str1 = "0X800781C";
            }
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt)
  {
    a(paramActivity, paramRMVideoStateMgr, paramFloat, paramBoolean, paramDouble1, paramDouble2, paramaaqj, false, paramInt, 0);
  }
  
  private static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    String str1 = "";
    int i = 0;
    String str2 = "";
    try
    {
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null)
      {
        str1 = localSessionInfo.aTl;
        i = localSessionInfo.cZ;
        str2 = localSessionInfo.troopUin;
      }
      paramActivity = new aaqn(paramActivity, paramRMVideoStateMgr, str1, i, str2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt1, paramInt2, false);
      paramActivity.CN(paramBoolean2);
      paramActivity.execute(new Void[0]);
      if (paramBoolean1) {
        reportClickEvent("", "0X8005E94");
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean3, String paramString2, boolean paramBoolean4, int paramInt4, int paramInt5, String paramString3)
  {
    String str1 = "";
    int i = 0;
    String str2 = "";
    try
    {
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null)
      {
        str1 = localSessionInfo.aTl;
        i = localSessionInfo.cZ;
        str2 = localSessionInfo.troopUin;
      }
      paramActivity = new aaqn(paramActivity, paramRMVideoStateMgr, str1, i, str2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt1, paramInt2, paramString1, paramInt3, paramArrayList, paramBoolean3, paramString2, paramBoolean4, paramInt4, paramInt5, paramString3);
      paramActivity.CN(paramBoolean2);
      paramActivity.execute(new Void[0]);
      if (paramBoolean1) {
        reportClickEvent("", "0X8005E94");
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean3, String paramString2, boolean paramBoolean4, String paramString3, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, long paramLong, int paramInt6, boolean paramBoolean5)
  {
    String str1 = "";
    int i = 0;
    String str2 = "";
    try
    {
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null)
      {
        str1 = localSessionInfo.aTl;
        i = localSessionInfo.cZ;
        str2 = localSessionInfo.troopUin;
      }
      paramActivity = new aaqn(paramActivity, paramRMVideoStateMgr, str1, i, str2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt1, paramInt2, paramString1, paramInt3, paramArrayList, paramBoolean3, paramString2, paramBoolean4, paramString3, paramString4, paramInt4, paramInt5, paramString5, paramString6, paramLong, paramInt6, paramBoolean5);
      paramActivity.CN(paramBoolean2);
      paramActivity.execute(new Void[0]);
      if (paramBoolean1) {
        reportClickEvent("", "0X8005E94");
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean3, String paramString2, boolean paramBoolean4, String paramString3, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, long paramLong, int paramInt6, boolean paramBoolean5, int paramInt7, boolean paramBoolean6, int paramInt8, String paramString7)
  {
    String str1 = "";
    int i = 0;
    String str2 = "";
    try
    {
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null)
      {
        str1 = localSessionInfo.aTl;
        i = localSessionInfo.cZ;
        str2 = localSessionInfo.troopUin;
      }
      paramActivity = new aaqn(paramActivity, paramRMVideoStateMgr, str1, i, str2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt1, paramInt2, paramString1, paramInt3, paramArrayList, paramBoolean3, paramString2, paramBoolean4, paramString3, paramString4, paramInt4, paramInt5, paramString5, paramString6, paramLong, paramInt6, paramBoolean5);
      paramActivity.superFontId = paramInt8;
      paramActivity.bdK = paramString7;
      paramActivity.bxo = paramBoolean6;
      paramActivity.CN(paramBoolean2);
      paramActivity.Gg(paramInt7);
      paramActivity.execute(new Void[0]);
      if (paramBoolean1) {
        reportClickEvent("", "0X8005E94");
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean3, String paramString2, boolean paramBoolean4, String paramString3, String paramString4, int paramInt4, boolean paramBoolean5, boolean paramBoolean6)
  {
    String str1 = "";
    int i = 0;
    String str2 = "";
    try
    {
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null)
      {
        str1 = localSessionInfo.aTl;
        i = localSessionInfo.cZ;
        str2 = localSessionInfo.troopUin;
      }
      paramActivity = new aaqn(paramActivity, paramRMVideoStateMgr, str1, i, str2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt1, paramInt2, paramString1, paramInt3, paramArrayList, paramBoolean3, paramString2, paramBoolean4, paramString3, paramString4, paramInt4, paramBoolean5, paramBoolean6);
      paramActivity.CN(paramBoolean2);
      paramActivity.execute(new Void[0]);
      if (paramBoolean1) {
        reportClickEvent("", "0X8005E94");
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void ao(String paramString1, String paramString2, String paramString3)
  {
    anot.a(null, "dc00898", paramString1, "", paramString2, paramString2, ciB, 0, paramString3, "", "", "");
  }
  
  public static void d(Activity paramActivity, ArrayList<String> paramArrayList)
  {
    SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Intent localIntent = new Intent(paramActivity, SendPhotoActivity.class);
    if (localSessionInfo != null)
    {
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent.putExtra("uin", localSessionInfo.aTl);
      localIntent.putExtra("uintype", localSessionInfo.cZ);
      localIntent.putExtra("troop_uin", localSessionInfo.troopUin);
      localIntent.putExtra("key_confess_topicid", localSessionInfo.topicId);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    anot.b(null, "CliOper", paramString1, "", paramString2, paramString2, ciB, paramInt, 0, paramString3, "", "", "");
  }
  
  public static void ec(String paramString1, String paramString2)
  {
    ao(paramString1, paramString2, "");
  }
  
  public static void h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(null, "dc00898", paramString1, "", paramString2, paramString2, ciB, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static void reportClickEvent(String paramString1, String paramString2)
  {
    B(paramString1, paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqi
 * JD-Core Version:    0.7.0.1
 */