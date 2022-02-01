import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;

public class ajoq
{
  public static SpannableStringBuilder a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {}
    do
    {
      return paramSpannableStringBuilder;
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "updateReactiveIconResource start:" + paramSpannableStringBuilder);
      }
      localObject1 = paramSpannableStringBuilder.toString();
      try
      {
        k = aqnm.dpToPx(16.0F);
        localObject3 = ajnu.fI();
        localArrayList = new ArrayList();
        localObject2 = ajnu.Q((String)localObject1);
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          break label638;
        }
        i = 0;
        localObject4 = ((ArrayList)localObject2).iterator();
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          int k;
          Object localObject3;
          ArrayList localArrayList;
          int i;
          Object localObject4;
          Object localObject5;
          ajnw localajnw;
          Object localObject2 = localObject1;
          localObject1 = paramContext;
          paramContext = (Context)localObject2;
          localObject2 = paramContext;
          if (QLog.isColorLevel())
          {
            QLog.d("ReactivePushHelper", 2, "updateReactiveIconResource exception:" + localObject1);
            localObject2 = paramContext;
            continue;
            break label641;
          }
        }
      }
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ajnu.a)((Iterator)localObject4).next();
        if (TextUtils.isEmpty(((ajnu.a)localObject5).url)) {
          break label635;
        }
        localajnw = new ajnw(paramContext, 0, ((ajnu.a)localObject5).url, aqnm.dpToPx(16.0F), null);
        localObject2 = "[icon]";
        if (!TextUtils.isEmpty(((ajnu.a)localObject5).name)) {
          localObject2 = ((ajnu.a)localObject5).name;
        }
        ((ajnu.a)localObject5).start += i;
        ((ajnu.a)localObject5).end += i;
        paramSpannableStringBuilder.replace(((ajnu.a)localObject5).start, ((ajnu.a)localObject5).end, (CharSequence)localObject2);
        paramSpannableStringBuilder.setSpan(localajnw, ((ajnu.a)localObject5).start, ((ajnu.a)localObject5).start + ((String)localObject2).length(), 33);
        i = ((ajnu.a)localObject5).start + ((String)localObject2).length() - ((ajnu.a)localObject5).end + i;
        break label641;
      }
      localObject2 = paramSpannableStringBuilder.toString();
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          localObject2 = ((List)localObject3).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          i = ((String)localObject1).indexOf((String)localObject3);
          if ((i == -1) || (i < 0)) {
            continue;
          }
          localObject4 = localArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject5 = (Pair)((Iterator)localObject4).next();
          if ((i < ((Integer)((Pair)localObject5).first).intValue()) || (i >= ((Integer)((Pair)localObject5).second).intValue())) {
            continue;
          }
          j = 1;
        }
        catch (Throwable localThrowable)
        {
          paramContext = (Context)localObject1;
          localObject1 = localThrowable;
          continue;
          int j = 0;
          continue;
        }
        if ((j == 0) && (ajnu.lP.containsKey(localObject3)))
        {
          localObject4 = (Integer)ajnu.lP.get(localObject3);
          if ((localObject4 != null) && (((Integer)localObject4).intValue() != 0))
          {
            localObject4 = paramContext.getResources().getDrawable(((Integer)localObject4).intValue());
            if (localObject4 != null)
            {
              ((Drawable)localObject4).setBounds(0, 0, k, k);
              paramSpannableStringBuilder.setSpan(new ImageSpan((Drawable)localObject4, 0), i, ((String)localObject3).length() + i, 33);
              localArrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(((String)localObject3).length() + i)));
            }
          }
        }
        i = ((String)localObject1).indexOf((String)localObject3, ((String)localObject3).length() + i);
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ReactivePushHelper", 2, "removeReactiveIconResource end:" + (String)localObject2);
    return paramSpannableStringBuilder;
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      return null;
    }
    return a(paramContext, new SpannableStringBuilder(paramString));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramacrj);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramQQAppInterface == null)) {
      return false;
    }
    if (paramMessage.msgtype != -5040) {
      return false;
    }
    try
    {
      paramQQAppInterface = (MessageForUniteGrayTip)paramQQAppInterface.b().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReactivePushHelper", 2, "query msg, msg is null");
        }
        return false;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReactivePushHelper", 2, "query msg exception:" + paramQQAppInterface.toString());
        }
        paramQQAppInterface = null;
      }
      if ((paramQQAppInterface.tipParam != null) && (ajnu.ky(paramQQAppInterface.tipParam.dbK)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReactivePushHelper", 2, "isReactivePushTips : true");
        }
        return true;
      }
    }
    return false;
  }
  
  public static String mo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "removeReactiveIconResource start:" + paramString);
    }
    paramString = paramString.replaceAll("[icon]", "");
    Iterator localIterator = ajnu.Q(paramString).iterator();
    while (localIterator.hasNext()) {
      paramString = paramString.replaceAll(((ajnu.a)localIterator.next()).template, "");
    }
    localIterator = ajnu.fI().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.contains(str)) {
        paramString = paramString.replaceAll(str, "");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "removeReactiveIconResource end:" + paramString);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoq
 * JD-Core Version:    0.7.0.1
 */