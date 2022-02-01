import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameIPCModule.1;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class ahvf
  extends QIPCModule
{
  private static volatile ahvf a;
  
  public ahvf(String paramString)
  {
    super(paramString);
  }
  
  public static ahvf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahvf("QQGameIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {}
    do
    {
      int i;
      Object localObject1;
      do
      {
        return null;
        if ("findMessage".equals(paramString)) {
          for (;;)
          {
            try
            {
              paramBundle = ((QQAppInterface)localObject2).b().i("2747277822", 1008, 10);
              if ((paramBundle == null) || (paramBundle.size() <= 0)) {
                break;
              }
              paramString = new ArrayList();
              i = paramBundle.size() - 1;
              if (i >= 0)
              {
                localObject1 = (MessageRecord)paramBundle.get(i);
                if (("2747277822".equals(((MessageRecord)localObject1).frienduin)) && (((localObject1 instanceof MessageForArkApp)) || ((localObject1 instanceof MessageForPubAccount)) || ((localObject1 instanceof MessageForStructing))))
                {
                  localObject1 = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject1);
                  if (localObject1 != null) {
                    paramString.add(localObject1);
                  }
                }
                if (paramString.size() != 3) {}
              }
              else
              {
                paramBundle = new Bundle();
                paramBundle.putSerializable("key_get_msg", paramString);
                callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
                return null;
              }
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              return null;
            }
            i -= 1;
          }
        }
        if ("getGameMsg".equals(paramString))
        {
          paramString = (ahta)((AppRuntime)localObject2).getManager(358);
          localObject1 = paramString.fi();
          paramBundle = new ArrayList();
          if (localObject1 != null) {
            paramBundle.addAll(paramString.fi());
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putSerializable("key_get_game_msg", paramBundle);
          ((Bundle)localObject1).putInt("key_get_game_view_type", paramString.getViewType());
          ((Bundle)localObject1).putBoolean("key_get_game_show_on_list", paramString.cif);
          ((Bundle)localObject1).putBoolean("key_get_game_gray_user", paramString.anX());
          callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject1));
          return null;
        }
        if ("doOnResume".equals(paramString))
        {
          ((ahta)((AppRuntime)localObject2).getManager(358)).Pr(0);
          ((QQAppInterface)localObject2).b().a("2747277822", 1008, true, true);
          return null;
        }
        if ("doOnDestory".equals(paramString))
        {
          ((ahta)((AppRuntime)localObject2).getManager(358)).Pr(0);
          return null;
        }
        if ("getGameMsgUrl".equals(paramString))
        {
          paramString = (ahta)((AppRuntime)localObject2).getManager(358);
          paramBundle = new Bundle();
          paramBundle.putString("key_get_msg_list_url", paramString.wD());
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
          return null;
        }
        if (!"saveGalleryDataToMsg".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getString("game_source_pic_txt");
        localObject1 = paramBundle.getString("game_source_pic_url");
        paramInt = paramBundle.getInt("game_source_type_pic", 0);
        i = paramBundle.getInt("game_source_subtype_pic", 0);
        long l = paramBundle.getLong("uniseq");
        int j = paramBundle.getInt("is_troop");
        paramBundle = paramBundle.getString("friend_uin");
        localObject2 = (QQAppInterface)localObject2;
        paramBundle = ((QQAppInterface)localObject2).b().b(paramBundle, j, l);
      } while (paramBundle == null);
      ahtr.b("game_source_pic_txt", paramString, paramBundle);
      ahtr.b("game_source_pic_url", (String)localObject1, paramBundle);
      ahtr.b("game_source_type_pic", paramInt + "", paramBundle);
      ahtr.b("game_source_subtype_pic", i + "", paramBundle);
      ThreadManager.excute(new QQGameIPCModule.1(this, (QQAppInterface)localObject2, paramBundle), 32, null, false);
      return null;
      if ("clearUnreadMsg".equals(paramString))
      {
        ((QQAppInterface)localObject2).a().h("2747277822", 1008, false);
        return null;
      }
    } while (!"openSessionPage".equals(paramString));
    ahtc.a(((ahta)((AppRuntime)localObject2).getManager(358)).wD(), ((AppRuntime)localObject2).getApplication(), null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvf
 * JD-Core Version:    0.7.0.1
 */