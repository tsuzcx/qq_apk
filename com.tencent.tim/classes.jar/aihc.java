import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class aihc
  implements aoil
{
  private QQAppInterface mApp;
  
  public aihc(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public int FB()
  {
    return 9;
  }
  
  public int a(int paramInt1, String paramString, Context paramContext, int paramInt2, Map<String, aoii> paramMap, Bundle paramBundle)
  {
    Object localObject = (aohy)this.mApp.getManager(339);
    int i;
    if (paramInt2 == 4)
    {
      anot.a(this.mApp, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join_suc", 0, 1, paramString, "", "", "");
      localObject = "4_" + paramInt1 + "_" + paramString;
      if (QLog.isColorLevel()) {
        QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA=" + (String)localObject + " from=" + paramInt2);
      }
      if (paramInt1 != 2) {
        break label289;
      }
      i = 2080;
    }
    for (;;)
    {
      if (((paramInt2 == 4) || (paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 8)) && (paramMap != null) && (paramMap.get(localObject) != null))
      {
        paramMap = (SingTogetherSession)paramMap.get(localObject);
        if (!TextUtils.isEmpty(paramMap.jumpUrl))
        {
          MiniAppLauncher.startMiniApp(paramContext, paramMap.jumpUrl, i, null);
          return 1;
          if (paramInt2 == 9)
          {
            anot.a(this.mApp, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark_suc", 0, 1, paramString, "", "", "");
            break;
          }
          if (paramInt2 == 1)
          {
            ((aohy)localObject).g("sing_tab", "clk_join_suc", 0, paramString);
            break;
          }
          if (paramInt2 != 8) {
            break;
          }
          ((aohy)localObject).g("sing_tab", "clk_setsing_suc", 0, paramString);
          break;
          label289:
          i = 2081;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA is empty");
        }
      }
    }
    if (TextUtils.isEmpty(""))
    {
      localObject = ((aenw)aeif.a().o(551)).a(4);
      if ((localObject != null) && (((aenw.a)localObject).version != 1))
      {
        boolean bool = TextUtils.isEmpty(((aenw.a)localObject).jumpUrl);
        if (bool)
        {
          paramMap = "mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc";
          if (!bool) {
            break label448;
          }
          paramInt2 = 2;
        }
        for (;;)
        {
          if ((paramInt1 == 2) && (((aenw.a)localObject).appId > 0))
          {
            paramString = ((aigv)this.mApp.getManager(348)).e(Long.parseLong(paramString), ((aenw.a)localObject).appId, true);
            if (TextUtils.isEmpty(paramString))
            {
              Toast.makeText(paramContext, "加载中，请稍后再试。", 1).show();
              return 0;
              paramMap = ((aenw.a)localObject).jumpUrl;
              break;
              label448:
              paramInt2 = ((aenw.a)localObject).jumpType;
              continue;
            }
            paramBundle.putString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID", paramString);
          }
        }
        aoij.a(this.mApp, paramInt2, paramMap, null, paramBundle, paramInt1);
        return 2;
      }
      if (paramInt1 == 2)
      {
        paramString = ((aigv)this.mApp.getManager(348)).e(Long.parseLong(paramString), 1109995692L, true);
        if (TextUtils.isEmpty(paramString))
        {
          Toast.makeText(paramContext, "加载中，请稍后再试。", 1).show();
          return 0;
        }
        paramBundle.putString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID", paramString);
      }
      if (paramInt1 == 1) {}
      for (paramString = aoij.a("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", paramBundle);; paramString = aoij.b("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", paramBundle))
      {
        MiniAppLauncher.startMiniApp(paramContext, paramString, i, null);
        if (QLog.isColorLevel()) {
          QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA=" + paramString);
        }
        return 3;
      }
    }
    return -1;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle) {}
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt) {}
  
  public void a(aoii paramaoii, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle)
  {
    a(paramInt1, paramString, paramContext, paramInt2, paramMap, paramBundle);
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, aoii> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle)
  {
    a(paramInt1, paramString, paramContext, paramInt2, paramMap, paramBundle);
    return false;
  }
  
  public aqju d()
  {
    return null;
  }
  
  public String getBusinessName()
  {
    return "一起K歌";
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihc
 * JD-Core Version:    0.7.0.1
 */