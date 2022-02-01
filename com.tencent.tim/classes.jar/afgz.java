import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afgz
{
  private static afgz a;
  private static int cQQ = -1;
  private static Object lock = new Object();
  public axpk a;
  
  public afgz()
  {
    this.jdField_a_of_type_Axpk = new axpk();
  }
  
  private int CU()
  {
    Object localObject = (afhc)getApp().getManager(333);
    if (cQQ == -1)
    {
      cQQ = 1;
      localObject = ((afhc)localObject).ez();
      if (localObject != null)
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          int j = ((CameraEmotionData)((List)localObject).get(i)).emoId;
          if (cQQ < j) {
            cQQ = j;
          }
          i += 1;
        }
      }
    }
    int i = cQQ + 1;
    cQQ = i;
    return i;
  }
  
  public static afgz a()
  {
    if (jdField_a_of_type_Afgz == null) {}
    synchronized (lock)
    {
      if (jdField_a_of_type_Afgz == null) {
        jdField_a_of_type_Afgz = new afgz();
      }
      return jdField_a_of_type_Afgz;
    }
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = getApp().getCurrentAccountUin();
    localCameraEmotionData.emoPath = paramString1;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString3;
    return localCameraEmotionData;
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = getApp().getCurrentAccountUin();
    localCameraEmotionData.emoOriginalPath = paramString1;
    localCameraEmotionData.thumbPath = paramString3;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString4;
    return localCameraEmotionData;
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Object localObject = getApp();
    afhc localafhc = (afhc)((QQAppInterface)localObject).getManager(333);
    localObject = (accj)((QQAppInterface)localObject).getBusinessHandler(160);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i), (String)paramArrayList4.get(i));
      localCameraEmotionData.emoId = CU();
      localafhc.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((accj)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.jdField_a_of_type_Axpk.y(String.valueOf(1011), new Object[] { localArrayList });
  }
  
  public void b(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Object localObject = getApp();
    if (localObject == null)
    {
      QLog.d("CameraEmoSendControl", 1, "app null");
      return;
    }
    afhc localafhc = (afhc)((QQAppInterface)localObject).getManager(333);
    localObject = (accj)((QQAppInterface)localObject).getBusinessHandler(160);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i));
      localCameraEmotionData.emoId = CU();
      localafhc.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((accj)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.jdField_a_of_type_Axpk.y(String.valueOf(1011), new Object[] { localArrayList });
  }
  
  public QQAppInterface getApp()
  {
    return (QQAppInterface)axol.getAppInterface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgz
 * JD-Core Version:    0.7.0.1
 */