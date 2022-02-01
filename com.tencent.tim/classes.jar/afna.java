import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class afna
  extends aflk
{
  aceg jdField_a_of_type_Aceg = new afnc(this);
  afic<CustomEmotionData> jdField_a_of_type_Afic = new afnb(this);
  protected QQAppInterface app;
  Runnable gs = new EmoticonPanelFavHelper.3(this);
  
  public afna(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public int[] C()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  void daB()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.zZ;
    int j = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.businessType;
    if (localQQAppInterface != null)
    {
      afke localafke = (afke)localQQAppInterface.getManager(43);
      if (!localafke.bYw)
      {
        localafke.bYw = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "doSyncFavEmotion");
        }
        daC();
      }
      if (!localafke.bYv)
      {
        localObject = new ArrayList((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "newPanelDataList.size() = " + ((ArrayList)localObject).size());
        }
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackage localEmoticonPackage = ((afoo)((Iterator)localObject).next()).d;
          i += 1;
          if ((localEmoticonPackage != null) && ((localEmoticonPackage.jobType == 0) || (localEmoticonPackage.jobType == 4)) && (localEmoticonPackage.status != 2))
          {
            localafke.bYv = true;
            if (i <= 10) {
              afnu.a(localQQAppInterface, localEmoticonPackage, j);
            }
          }
        }
      }
    }
  }
  
  void daC()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.context;
    if (localQQAppInterface == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("mobileQQ", 0);
    String str = localQQAppInterface.getCurrentUin();
    boolean bool = ((SharedPreferences)localObject).getBoolean("local_overflow" + str, false);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "isDelOverflow=" + bool);
    }
    ThreadManager.post(new EmoticonPanelFavHelper.2(this, localQQAppInterface, bool, (SharedPreferences)localObject, str), 5, null, false);
  }
  
  public void daD()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.context;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app;
    if ((!aqiw.isNetSupport((Context)localObject)) || (localQQAppInterface == null)) {}
    afil localafil;
    do
    {
      return;
      localObject = (afhv)localQQAppInterface.getManager(103);
      localafil = (afil)localQQAppInterface.getBusinessHandler(80);
    } while (!((afhv)localObject).ajh());
    localafil.cZN();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    ((afhv)localObject).a(this.jdField_a_of_type_Afic);
    ((afhv)localObject).cZq();
    this.gs.run();
    anot.a(localQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
  
  public void dae()
  {
    this.app = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app;
  }
  
  public void dak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelFavHelper.1(this), 200L);
  }
  
  public void onAttachedToWindow()
  {
    if (this.app != null) {
      this.app.addObserver(this.jdField_a_of_type_Aceg);
    }
  }
  
  public void onDestory()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Aceg);
    }
    this.jdField_a_of_type_Afic = null;
  }
  
  public void onDetachedFromWindow()
  {
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Aceg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afna
 * JD-Core Version:    0.7.0.1
 */