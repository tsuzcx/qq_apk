import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afon
{
  private static afon a;
  
  public static afon a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afon();
      }
      return a;
    }
    finally {}
  }
  
  public List<afom> a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (ajdg)paramQQAppInterface.getManager(14);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label603:
    for (;;)
    {
      return localArrayList;
      return afqr.b(paramQQAppInterface, paramInt3);
      localArrayList.add(new afom());
      return localArrayList;
      paramQQAppInterface = ((afhu)paramQQAppInterface.getManager(149)).eA();
      paramEmoticonPackage = new afmi();
      paramEmoticonPackage.action = "favEdit";
      localArrayList.add(paramEmoticonPackage);
      if (paramInt2 != 1024)
      {
        paramEmoticonPackage = new afmi();
        paramEmoticonPackage.action = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
      }
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.size() > afhs.cQV)
        {
          localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, afhs.cQV)));
          return localArrayList;
        }
        localArrayList.addAll(paramQQAppInterface);
        return localArrayList;
        paramQQAppInterface = ((afhc)paramQQAppInterface.getManager(333)).eA();
        paramEmoticonPackage = new aflv();
        paramEmoticonPackage.action = "cameraEdit";
        localArrayList.add(paramEmoticonPackage);
        paramEmoticonPackage = new aflv();
        paramEmoticonPackage.action = "cameraJump";
        localArrayList.add(paramEmoticonPackage);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.size() > afgu.cQP)
          {
            localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, afgu.cQP)));
            return localArrayList;
          }
          localArrayList.addAll(paramQQAppInterface);
          return localArrayList;
          paramQQAppInterface = new afpu(paramQQAppInterface.getCurrentAccountUin());
          paramQQAppInterface.action = "push";
          paramEmoticonPackage = ((ajdg)localObject1).ag(0);
          localArrayList.add(paramQQAppInterface);
          localArrayList.addAll(paramEmoticonPackage);
          return localArrayList;
          paramQQAppInterface = ((ajdg)localObject1).a(true, paramInt3, paramBoolean);
          if (paramQQAppInterface != null)
          {
            localArrayList.addAll(paramQQAppInterface);
            return localArrayList;
            if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
              return null;
            }
            localObject1 = ((ajdg)localObject1).e(paramEmoticonPackage.epId, true);
            if (paramEmoticonPackage.jobType == 4) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (localObject1 == null) {
                break label603;
              }
              paramInt3 = ((List)localObject1).size();
              paramInt2 = 0;
              while (paramInt2 < paramInt3)
              {
                localEmoticon = (Emoticon)((List)localObject1).get(paramInt2);
                if (paramInt1 == 0) {
                  break label605;
                }
                localObject2 = new afqh(paramQQAppInterface.getCurrentAccountUin());
                ((afqh)localObject2).type = 10;
                ((afqh)localObject2).imageType = paramEmoticonPackage.type;
                ((afqh)localObject2).e = localEmoticon;
                localArrayList.add(localObject2);
                paramInt2 += 1;
              }
              break;
            }
          }
        }
      }
    }
    label605:
    Object localObject2 = new afpu(paramQQAppInterface.getCurrentAccountUin());
    ((afpu)localObject2).type = 6;
    ((afpu)localObject2).imageType = paramEmoticonPackage.type;
    ((afpu)localObject2).e = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((afpu)localObject2).isAPNG = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, afon.a parama)
  {
    if (parama == null) {
      return;
    }
    ThreadManager.post(new EmotionPanelDataBuilder.1(this, paramQQAppInterface, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, parama), 5, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void jS(List<afom> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afon
 * JD-Core Version:    0.7.0.1
 */