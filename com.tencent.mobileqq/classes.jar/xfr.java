import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class xfr
  implements blne
{
  xfr(xfp paramxfp) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = xfp.a(this.a).getResources().getString(2131698618);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new xgc();
        ((xgc)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((xgc)localObject).d = paramObject.url;
        ((xgc)localObject).jdField_b_of_type_Int = 2;
        ((xgc)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = xfp.a(this.a).getResources().getString(2131698619);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfr
 * JD-Core Version:    0.7.0.1
 */