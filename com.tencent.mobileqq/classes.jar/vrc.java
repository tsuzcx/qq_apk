import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class vrc
  implements bjbd
{
  vrc(vra paramvra) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = vra.a(this.a).getResources().getString(2131698318);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new vrn();
        ((vrn)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((vrn)localObject).d = paramObject.url;
        ((vrn)localObject).jdField_b_of_type_Int = 2;
        ((vrn)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = vra.a(this.a).getResources().getString(2131698319);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrc
 * JD-Core Version:    0.7.0.1
 */