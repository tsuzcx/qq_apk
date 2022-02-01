import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class zdl
  implements boku
{
  zdl(zdj paramzdj) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = zdj.a(this.a).getResources().getString(2131697517);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new zdw();
        ((zdw)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((zdw)localObject).d = paramObject.url;
        ((zdw)localObject).jdField_b_of_type_Int = 2;
        ((zdw)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = zdj.a(this.a).getResources().getString(2131697518);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdl
 * JD-Core Version:    0.7.0.1
 */