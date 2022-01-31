import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class zle
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  private final TroopUnreadMsgInfo jdField_a_of_type_ComTencentMobileqqTroopinfoTroopUnreadMsgInfo;
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  public zle(TroopHandler paramTroopHandler, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopUnreadMsgInfo = paramTroopUnreadMsgInfo;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    paramRecord = (TroopHandler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramRecord != null) && (paramRecord.b != null))
    {
      if (paramInt1 == 0) {
        paramRecord.b.a().a(1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopUnreadMsgInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopUnreadMsgInfo.b, this.jdField_a_of_type_ArrayOfLong, 2);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + paramRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zle
 * JD-Core Version:    0.7.0.1
 */