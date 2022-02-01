import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.widget.ListView;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class aupe
{
  public static String cIK = "new_share_todo_id";
  
  public static int J(long paramLong)
  {
    int i = -1;
    int k = Calendar.getInstance().getTimeZone().getRawOffset();
    int j = (int)((System.currentTimeMillis() + k) / 86400000L);
    k = (int)((k + paramLong) / 86400000L);
    if (k == j) {
      i = 2131721204;
    }
    do
    {
      return i;
      if (k == j - 1) {
        return 2131721953;
      }
      if (k == j - 2) {
        return 2131690832;
      }
    } while (k != j + 1);
    return 2131721218;
  }
  
  public static void L(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public static int a(TodoInfo paramTodoInfo, aunv paramaunv)
  {
    int j;
    if (paramaunv == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramaunv.getCount()) {
        break label60;
      }
      aupm localaupm = paramaunv.a(i);
      if ((localaupm instanceof TodoInfo))
      {
        j = i;
        if (((TodoInfo)localaupm).todoId.equals(paramTodoInfo.todoId)) {
          break;
        }
      }
      i += 1;
    }
    label60:
    return -1;
  }
  
  public static final View a(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.getFirstVisiblePosition()) && (paramInt <= paramListView.getLastVisiblePosition())) {
      return paramListView.getChildAt(paramInt - paramListView.getFirstVisiblePosition());
    }
    return null;
  }
  
  public static String a(TodoInfo paramTodoInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramTodoInfo == null) || (paramQQAppInterface == null)) {
      paramContext = "";
    }
    do
    {
      do
      {
        return paramContext;
        String str = "";
        if (paramTodoInfo.fromUinType == 1) {
          return aqgv.z(paramQQAppInterface, String.valueOf(paramTodoInfo.fromUin));
        }
        if (paramTodoInfo.fromUinType == 2) {
          return aqgv.b(paramQQAppInterface, paramContext, String.valueOf(paramTodoInfo.fromUin));
        }
        if (paramTodoInfo.fromUinType == 3) {
          break;
        }
        paramContext = str;
      } while (paramTodoInfo.fromUinType != 4);
      paramContext = aqgv.b(paramQQAppInterface, String.valueOf(paramTodoInfo.fromUin), true);
    } while (paramTodoInfo.c2cTempUinType != 3);
    return paramTodoInfo.numStr;
  }
  
  public static void a(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    long l2 = 0L;
    if ((paramBundle != null) && (paramQQAppInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TodoUtils", 2, "Todo from forward");
      }
      for (;;)
      {
        try
        {
          String str3 = paramBundle.getString(cIK);
          int i = paramBundle.getInt("uintype", -1);
          String str2 = paramBundle.getString("uin");
          if (TextUtils.isEmpty(str2)) {
            break label232;
          }
          l1 = Long.valueOf(str2).longValue();
          paramBundle = paramBundle.getString("troop_uin");
          if (!TextUtils.isEmpty(paramBundle)) {
            l2 = Long.valueOf(paramBundle).longValue();
          }
          paramBundle = "";
          if (i == 1006)
          {
            ajdo localajdo = (ajdo)paramQQAppInterface.getManager(11);
            str1 = str2;
            if (localajdo.a() != null)
            {
              paramBundle = localajdo.a().nationCode + localajdo.a().mobileNo;
              str1 = str2;
            }
            if (!aqiw.isNetSupport(BaseApplication.getContext()))
            {
              QQToast.a(paramContext, "当前网络不可用，请检查你的网络设置。", 0).show();
              return;
            }
            ((aunu)paramQQAppInterface.getBusinessHandler(181)).a(str3, l1, i, l2, paramBundle, str1);
            L(paramQQAppInterface, "0X80091CF", 1);
            return;
          }
        }
        catch (NumberFormatException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        String str1 = "";
        continue;
        label232:
        long l1 = 0L;
      }
    }
  }
  
  public static void a(ChatMessage paramChatMessage, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      TodoInfo localTodoInfo;
      int i;
      try
      {
        localTodoInfo = new TodoInfo();
        try
        {
          str = new aofk(paramChatMessage.msg, 2).AE();
          if (str != null)
          {
            if (str.getBytes("UTF-8").length <= TodoNewActivity.erP) {
              continue;
            }
            localTodoInfo.content = aqmr.aL(str, TodoNewActivity.erP);
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          String str;
          localUnsupportedEncodingException.printStackTrace();
          continue;
        }
        localTodoInfo.fromUinType = paramChatMessage.msgtype;
        localTodoInfo.fromUin = Long.parseLong(paramChatMessage.frienduin);
        localTodoInfo.msgTime = ((int)paramChatMessage.time);
        localTodoInfo.msgRandom = anbk.ab(paramChatMessage.msgUid);
        localTodoInfo.msgSeq = ((int)paramChatMessage.shmsgseq);
        i = paramChatMessage.istroop;
        if (i != 3000) {
          break label199;
        }
        localTodoInfo.fromUinType = 2;
        paramChatMessage = new Intent(paramContext, TodoNewActivity.class);
        paramChatMessage.putExtra("todoinfo", localTodoInfo);
        paramChatMessage.putExtra("param_mode", 4);
        paramContext.startActivity(paramChatMessage);
        L(paramQQAppInterface, "0X80091B4", 1);
        return;
      }
      catch (NumberFormatException paramChatMessage)
      {
        paramChatMessage.printStackTrace();
        return;
      }
      localTodoInfo.content = str;
      continue;
      label199:
      if (i == 1)
      {
        localTodoInfo.fromUinType = 1;
      }
      else if (i == 0)
      {
        localTodoInfo.fromUinType = 3;
      }
      else
      {
        localTodoInfo.fromUinType = 4;
        localTodoInfo.c2cTempUin = Long.parseLong(paramChatMessage.frienduin);
        if (i == 1000)
        {
          localTodoInfo.c2cTempUinType = 1;
        }
        else if (i == 1004)
        {
          localTodoInfo.c2cTempUinType = 2;
        }
        else if (i == 1006)
        {
          localTodoInfo.c2cTempUinType = 3;
          localTodoInfo.numStr = paramChatMessage.frienduin;
        }
      }
    }
  }
  
  public static String cm(long paramLong)
  {
    if ((!TextUtils.isEmpty(auqb.y(paramLong))) && (paramLong > 0L))
    {
      if (J(paramLong) == 2131721204) {
        return "今天 " + auqb.cn(paramLong);
      }
      if (J(paramLong) == 2131721218) {
        return "明天 " + auqb.cn(paramLong);
      }
      if (auqb.co(paramLong).equals(auqb.Fh())) {
        return new SimpleDateFormat("MM月dd日 HH:mm").format(Long.valueOf(paramLong));
      }
      return new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(Long.valueOf(paramLong));
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupe
 * JD-Core Version:    0.7.0.1
 */