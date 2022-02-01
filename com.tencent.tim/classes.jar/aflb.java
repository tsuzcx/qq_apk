import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticon.SogouEmoji.3;
import com.tencent.mobileqq.emoticon.SogouEmoji.4;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class aflb
{
  public static String bDP = "taskId";
  public static String bDQ = "exprId";
  acdz jdField_a_of_type_Acdz;
  acea jdField_a_of_type_Acea = new aflb.a(this);
  public afko a;
  public aflf a;
  public afke c;
  int cRQ = 0;
  public int cRR;
  public ajdg e;
  private BaseChatPie f;
  
  public aflb(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Afko = new aflc(this);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor begins");
    }
    this.f = paramBaseChatPie;
    this.e = ((ajdg)this.f.a().app.getManager(14));
    this.c = ((afke)this.f.a().app.getManager(43));
    this.jdField_a_of_type_Acdz = ((acdz)this.f.a().app.getBusinessHandler(12));
    this.jdField_a_of_type_Aflf = new aflf(this.f.a());
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor ends");
    }
    this.f.a().app.addObserver(this.jdField_a_of_type_Acea);
  }
  
  private boolean mb(String paramString)
  {
    if ((this.f == null) || (this.f.a().app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func" + paramString + " ends, maybe chatActivity is finished.");
      }
      return false;
    }
    return true;
  }
  
  public void J(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new SogouEmoji.3(this, paramString1, paramString2, paramBoolean);
    ThreadManager.getFileThreadHandler().post(paramString1);
  }
  
  public ArrayList<Emoticon> af(ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getInvalidKeyEmoticon begins");
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.next();
      if (!localEmoticon.hasEncryptKey()) {
        localArrayList.add(localEmoticon);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getInvalidKeyEmoticon ends, size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  void c(Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func sendEmoji begins, mCurTaskId:" + this.cRR + ",emoticon:" + paramEmoticon);
    }
    this.jdField_a_of_type_Aflf.cancleProgressDailog();
    this.jdField_a_of_type_Aflf.removeTask(this.cRR);
    this.jdField_a_of_type_Aflf.uo();
    if (!mb("sendEmoji")) {
      return;
    }
    afpu localafpu = new afpu(this.f.a().app.getCurrentAccountUin());
    localafpu.type = 6;
    localafpu.e = paramEmoticon;
    this.e.a(paramEmoticon.epId, new afle(this, localafpu));
  }
  
  public void cl(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func trySend begins, packId:" + paramInt + ",exprId:" + paramString);
    }
    if ((this.f != null) && (this.f.a() != null) && (!aqiw.isNetSupport(this.f.a().getApplicationContext())))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show();
      return;
    }
    this.e.a(Integer.toString(paramInt), paramString, new afld(this, paramInt, paramString));
  }
  
  public void kq(List<String> paramList)
  {
    paramList = new SogouEmoji.4(this, paramList);
    ThreadManager.getFileThreadHandler().post(paramList);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor begins");
    }
    if ((this.f != null) && (this.f.a() != null))
    {
      QQAppInterface localQQAppInterface = this.f.a().app;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Acea);
      }
    }
    if (this.jdField_a_of_type_Aflf != null) {
      this.jdField_a_of_type_Aflf.onDestroy();
    }
    afkd.a().b(this.jdField_a_of_type_Afko);
    this.f = null;
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor ends");
    }
  }
  
  public void v(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getPackEmojiKey begins, packId:" + paramString);
    }
    if (!mb("getPackEmojiKey")) {}
    do
    {
      return;
      String str = Integer.toString(this.cRQ);
      this.cRQ += 1;
      if (afgc.lO(paramString)) {
        this.jdField_a_of_type_Acdz.a(Integer.parseInt(paramString), paramArrayList, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func getPackEmojiKey ends");
  }
  
  static class a
    extends acea
  {
    final WeakReference<aflb> ay;
    
    public a(aflb paramaflb)
    {
      this.ay = new WeakReference(paramaflb);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt);
      }
      if ((!paramBoolean) || (paramObject == null) || (paramInt != 3)) {}
      do
      {
        aflb localaflb;
        do
        {
          do
          {
            do
            {
              return;
              localaflb = (aflb)this.ay.get();
              if (localaflb == null)
              {
                QLog.d("SogouEmoji", 2, "WeakReference error");
                return;
              }
              paramObject = (EmoticonResp)paramObject;
            } while (paramObject.data == null);
            paramObject = (ArrayList)paramObject.data;
          } while (paramObject.size() == 0);
          paramBoolean = localaflb.a.js(localaflb.cRR);
          if (QLog.isColorLevel()) {
            QLog.d("SogouEmoji", 2, "func onEmojiKeyBack begins, isTaskExist:" + paramBoolean);
          }
          if (paramBoolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
        return;
        localaflb.c((Emoticon)paramObject.get(0));
      } while (!QLog.isColorLevel());
      QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, Ready to send.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflb
 * JD-Core Version:    0.7.0.1
 */