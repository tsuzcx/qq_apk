import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import java.io.File;

class ahtw
  implements PreloadManager.d
{
  ahtw(ahtv paramahtv, FullPopData paramFullPopData) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      paramPathResult = new File(paramPathResult.folderPath);
      if (paramPathResult.exists())
      {
        ahtv.a(this.jdField_b_of_type_Ahtv, this.jdField_b_of_type_ComTencentMobileqqGamecenterDataFullPopData);
        ahtv.a(this.jdField_b_of_type_Ahtv).resPath = paramPathResult.getPath();
        this.jdField_b_of_type_Ahtv.cih = true;
        if (QLog.isColorLevel()) {
          QLog.d("FullPopBussiness", 1, "full pop res is ready");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtw
 * JD-Core Version:    0.7.0.1
 */