import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class acqe
  implements Manager
{
  QQAppInterface app;
  AtomicBoolean cL = new AtomicBoolean(false);
  ConcurrentHashMap<String, acqj> ex;
  SharedPreferences pref;
  
  public acqe(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.pref = acqh.getSharedPreferences(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    this.ex = new ConcurrentHashMap();
  }
  
  public static acqe a(QQAppInterface paramQQAppInterface)
  {
    return (acqe)paramQQAppInterface.getManager(277);
  }
  
  void FX(String paramString)
  {
    synchronized (this.ex)
    {
      this.ex.remove(paramString);
      cNQ();
      return;
    }
  }
  
  acqj a(String paramString, int paramInt)
  {
    synchronized (this.ex)
    {
      acqj localacqj2 = (acqj)this.ex.get(paramString);
      acqj localacqj1 = localacqj2;
      if (localacqj2 == null)
      {
        localacqj1 = new acqj();
        localacqj1.uin = paramString;
        localacqj1.type = paramInt;
      }
      return localacqj1;
    }
  }
  
  void a(acqj paramacqj)
  {
    if ((paramacqj == null) || (TextUtils.isEmpty(paramacqj.uin))) {
      return;
    }
    synchronized (this.ex)
    {
      this.ex.put(paramacqj.uin, paramacqj);
      cNQ();
      return;
    }
  }
  
  boolean abY()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = cF();
        if (QLog.isColorLevel())
        {
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            QLog.d("tag_hidden_chat", 2, new Object[] { "doInitAllHidden(), dataList.size is ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (localObject1 == null) {
            break label156;
          }
          synchronized (this.ex)
          {
            this.ex.clear();
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            acqj localacqj = (acqj)((Iterator)localObject1).next();
            this.ex.put(localacqj.uin, localacqj);
          }
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("tag_hidden_chat", 2, "doInitAllHidden exception:" + localException.getMessage());
        }
        return false;
      }
    }
    label156:
    return true;
  }
  
  public void bO(Activity paramActivity)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("FirstSetHidden", false))
    {
      localSharedPreferences.edit().putBoolean("FirstSetHidden", true).commit();
      aqha.a(paramActivity, 230, paramActivity.getString(2131698581), paramActivity.getString(2131698579), paramActivity.getString(2131720227), paramActivity.getString(2131698580), new acqf(this, paramActivity), new aqha.a()).show();
      anot.a(this.app, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
    }
  }
  
  public ArrayList<acqj> cF()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.pref.getString("KeyHiddenChatList", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String[] arrayOfString = localObject[i].split("\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
            try
            {
              acqj localacqj = new acqj();
              localacqj.uin = arrayOfString[0];
              localacqj.type = Integer.parseInt(arrayOfString[1]);
              localArrayList.add(localacqj);
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("tag_hidden_chat", 2, localThrowable, new Object[0]);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void cNQ()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = this.ex.values().iterator();
    while (localIterator.hasNext())
    {
      acqj localacqj = (acqj)localIterator.next();
      localStringBuilder.append(localacqj.uin).append("|").append(localacqj.type).append(";");
    }
    this.pref.edit().putString("KeyHiddenChatList", localStringBuilder.toString()).commit();
  }
  
  public void cNR()
  {
    if (!this.cL.get())
    {
      abY();
      this.cL.set(true);
    }
  }
  
  public void n(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ex.contains(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      a(a(paramString, paramInt));
      return;
    }
    FX(paramString);
  }
  
  public void onDestroy()
  {
    this.ex.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqe
 * JD-Core Version:    0.7.0.1
 */