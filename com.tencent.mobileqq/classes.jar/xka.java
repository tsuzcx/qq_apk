import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class xka
  implements blrq
{
  xka(xjy paramxjy) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = xjy.a(this.a).getResources().getString(2131698630);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new xkl();
        ((xkl)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((xkl)localObject).d = paramObject.url;
        ((xkl)localObject).jdField_b_of_type_Int = 2;
        ((xkl)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = xjy.a(this.a).getResources().getString(2131698631);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xka
 * JD-Core Version:    0.7.0.1
 */